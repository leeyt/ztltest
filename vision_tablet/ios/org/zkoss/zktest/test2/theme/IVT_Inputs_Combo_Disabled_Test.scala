package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Inputs_Combo_Disabled_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<vbox>
	Combobox:
	<combobox disabled="true">
		<comboitem label="Comboitem 1" />
		<comboitem label="Comboitem 2" />
		<comboitem label="Comboitem 3" />
	</combobox>
	<combobox buttonVisible="false" disabled="true">
		<comboitem label="Comboitem 1" />
		<comboitem label="Comboitem 2" />
		<comboitem label="Comboitem 3" />
	</combobox>
	<separator />
	Datebox:
	<datebox format="yyyy/MM/dd hh:mm:ss a" disabled="true"/>
	<datebox buttonVisible="false" disabled="true"/>
	<separator />
	Bandbox:
	<bandbox disabled="true">
		<bandpopup>Bandpopup Content</bandpopup>
	</bandbox>
	<bandbox buttonVisible="false" disabled="true">
		<bandpopup>Bandpopup Content</bandpopup>
	</bandbox>
	<separator />
	Timebox:
	<timebox disabled="true"/>
	<timebox buttonVisible="false" disabled="true"/>
	<separator />
	Spinner:
	<spinner disabled="true"/>
	<spinner buttonVisible="false" disabled="true"/>
	<separator />
	Doublespinner:
	<doublespinner disabled="true"/>
	<doublespinner buttonVisible="false" disabled="true"/>
</vbox>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
