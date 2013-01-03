package org.zkoss.zktest.test2.B50

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.util.Scripts

@Tags(tags = "B50-ZK-908.zul")
class B50_ZK_908Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """<zk>
	<div>Test Window One</div>
	<div>1. Click 'save' button, you should see two error box.</div>
	<div>2. Close the first error box then close the second error box.</div>
	<div>3. Input some value into First textbox then click 'save' button again.</div>
	<div>4. The value of First textbox should not be cleared.</div>
	<div height="10px"></div>
	<div>Test Window Two</div>
	<div>1. Input -1 in Intbox One then click outside, you should see an error box.</div>
	<div>2. Input -1 in Intbox Two then click outside, you should see an error box.</div>
	<div>3. Click 'set -1' button, the error box of Intbox Two should not disappeared.</div>
	<div>4. Click 'set 1' button, the error box of Intbox Two should disappeared.</div>
	<div>5. Input -1 in Intbox Three then click outside, you should see message 'Only positive number or zero is allowed'.</div>
	<div>6. Click 'set 1 two' button, the message above should disappeared.</div>
	<div>7. Input -1 in Intbox Four then click outside, you should see an error box.</div>
	<window title="Window One" border="normal">
		<grid>
			<columns>
				<column width="150px" />
			</columns>
			<rows>
				<row>
					<label value="First textbox"></label>
					<textbox id="periodValue"></textbox>
				</row>
				<row>
					<label value="Second textbox"></label>
					<textbox id="periodValue1"></textbox>
				</row>
				<row>
					<button id="b" label="save">
						<attribute name="onClick"><![CDATA[
							if ("".equals(periodValue.getValue())) {
								periodValue.setErrorMessage("Empty not allowed in 1");
							}
							if ("".equals(periodValue1.getValue())) {
								periodValue1.setErrorMessage("Empty not allowed in 2");
							}
						]]></attribute>
					</button>
				</row>
			</rows>
		</grid>
	</window>
	<window title="Window Two" border="normal">
		<script>
		zk.load('zul.inp', function () {
			ClientServerConstraint = zk.$extends(zul.inp.SimpleConstraint, {
				serverValidate: true
			});
		});
		</script>
		<zscript><![CDATA[
		public class MyConstraint extends SimpleConstraint implements CustomConstraint {
			public MyConstraint(int flags) {
				super(flags);
			}
			public void showCustomError(Component comp, WrongValueException ex) {
				comp.getFellow("errlb").setValue(ex != null ? ex.getMessage(): "");
			}
		}
		MyConstraint nes = new MyConstraint(MyConstraint.NO_NEGATIVE);
		
		public class ClientServerConstraint extends SimpleConstraint {
			public ClientServerConstraint() {
				super(NO_NEGATIVE);
			}
			public void validate(Component comp, Object value)
			throws WrongValueException {
				super.validate(comp, value);
				if (value != null && (value.intValue() & 1) != 0)
					throw new WrongValueException(comp, "Only even numbers are allowed, not "+value);
			}
			public String getClientConstraint() {
				return "new ClientServerConstraint('no negative');";
			}
		};
		ClientServerConstraint csc = new ClientServerConstraint();
		]]></zscript>
		
		<grid>
		<rows>
			<row>Intbox One: No negative: <intbox constraint="no negative"/></row>
			<row>Intbox Two: No negative (custom message): <intbox id="i2" constraint="no negative:Negative? Not possible"/>
			<button label="set -1" onClick="i2.setValue(-1)"/>
			<button label="set 1" onClick="i2.setValue(1)"/>
			</row>
			<row>
			Intbox Three: Custom error display (no negative):
			<intbox id="i3" constraint="${nes}"/>
			<label id="errlb"/>
			<button label="set 1 two" onClick="i3.setValue(1)"/>
			</row>
			<row>
			Intbox Four: Client+Server (no negative, no odd number):
			<intbox constraint="${csc}"/>
			</row>
		</rows>
		</grid>
	</window>
</zk>"""

    runZTL(zscript,
      () => {
        val savebtn = jq(".z-button:contains(save)")
        click(savebtn)
        waitResponse()
        verifyTrue("should see errorbox message", jq(".z-errbox").exists())

        // close errbox marco
        var errbox0 = jq(".z-errbox-close:eq(0)")
        var close_x0 = errbox0.positionLeft() + errbox0.width() - 5
        var close_y0 = errbox0.positionTop() + 5

        Scripts.triggerMouseEventAt(getWebDriver(), errbox0, "click", close_x0 + "," + close_y0)
        waitResponse()

        Scripts.triggerMouseEventAt(getWebDriver(), errbox0, "click", close_x0 + "," + close_y0)
        waitResponse()
        verifyTrue("should not see errorbox message", !jq(".z-errbox").exists())

        val textbox = jq(".z-textbox:eq(0)")
        sendKeys(textbox, "1111")
        waitResponse()
        blur(textbox)
        waitResponse()

        click(savebtn)
        waitResponse()
        verifyTrue("the value of first textbox should not be cleared.", textbox.`val`().length() != 0)
      })

  }
}
