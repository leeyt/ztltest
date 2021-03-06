/* 

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.bind.basic
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.ZKSeleneseTestCase
import org.openqa.selenium.Keys
import org.zkoss.ztl.Tags

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_ValidationMessagesTest extends ZTL4ScalaTestCase {
  def testArg() = {
    val zul = {
      <include src="bind/basic/validationmessages.zul"/>
    }

    runZTL(zul, () => {
      var l11 = jq("$l11")
      var l12 = jq("$l12")
      var t21 = jq("$t21")
      var t22 = jq("$t22")
      var t31 = jq("$t31")
      var t32 = jq("$t32")
      var m31 = jq("$m31")
      var m32 = jq("$m32")
      var btn1 = jq("$btn1")
      var t41 = jq("$t41")
      var t42 = jq("$t42")
      var m41 = jq("$m41")
      var m42 = jq("$m42")
      var m43 = jq("$m43")
      var m44 = jq("$m44")
      var m45 = jq("$m45")
      var m46 = jq("$m46")
      var btn2 = jq("$btn2")
      var btn3 = jq("$btn3")
      verifyEquals("ABC", l11.toWidget().get("value"))
      verifyEquals("10", l12.toWidget().get("value"))
      verifyEquals("ABC", t21.toWidget().get("value"))
      verifyEquals("10", t22.toWidget().get("value"))
      verifyEquals("ABC", t31.toWidget().get("value"))
      verifyEquals("10", t32.toWidget().get("value"))
      verifyEquals("", m31.toWidget().get("value"))
      verifyEquals("", m32.toWidget().get("value"))
      verifyEquals("ABC", t41.toWidget().get("value"))
      verifyEquals("10", t42.toWidget().get("value"))
      verifyEquals("", m41.toWidget().get("value"))
      verifyEquals("", m42.toWidget().get("value"))
      verifyEquals("", m43.toWidget().get("value"))
      verifyEquals("", m44.toWidget().get("value"))
      `type`(t21.toWidget(), "ABCD")
      waitResponse(true)
      `type`(t22.toWidget(), "6")
      waitResponse(true)
      verifyEquals("ABC", l11.toWidget().get("value"))
      verifyEquals("10", l12.toWidget().get("value"))
      verifyEquals("ABCD", t21.toWidget().get("value"))
      verifyEquals("6", t22.toWidget().get("value"))
      verifyEquals("ABC", t31.toWidget().get("value"))
      verifyEquals("10", t32.toWidget().get("value"))
      verifyEquals("", m31.toWidget().get("value"))
      verifyEquals("", m32.toWidget().get("value"))
      verifyEquals("ABC", t41.toWidget().get("value"))
      verifyEquals("10", t42.toWidget().get("value"))
      verifyEquals("", m41.toWidget().get("value"))
      verifyEquals("", m42.toWidget().get("value"))
      verifyEquals("", m43.toWidget().get("value"))
      verifyEquals("", m44.toWidget().get("value"))
      `type`(t21.toWidget(), "Abc")
      waitResponse(true)
      `type`(t22.toWidget(), "33")
      waitResponse(true)
      verifyEquals("Abc", l11.toWidget().get("value"))
      verifyEquals("33", l12.toWidget().get("value"))
      verifyEquals("Abc", t21.toWidget().get("value"))
      verifyEquals("33", t22.toWidget().get("value"))
      verifyEquals("Abc", t31.toWidget().get("value"))
      verifyEquals("33", t32.toWidget().get("value"))
      verifyEquals("", m31.toWidget().get("value"))
      verifyEquals("", m32.toWidget().get("value"))
      verifyEquals("ABC", t41.toWidget().get("value"))
      verifyEquals("10", t42.toWidget().get("value"))
      verifyEquals("", m41.toWidget().get("value"))
      verifyEquals("", m42.toWidget().get("value"))
      verifyEquals("", m43.toWidget().get("value"))
      verifyEquals("", m44.toWidget().get("value"))
      `type`(t31.toWidget(), "XXX")
      waitResponse(true)
      `type`(t32.toWidget(), "1") // intbox has reset issue...too bad
      waitResponse(true)
      verifyEquals("Abc", l11.toWidget().get("value"))
      verifyEquals("33", l12.toWidget().get("value"))
      verifyEquals("Abc", t21.toWidget().get("value"))
      verifyEquals("33", t22.toWidget().get("value"))
      verifyEquals("XXX", t31.toWidget().get("value"))
      verifyEquals("1", t32.toWidget().get("value"))
      verifyEquals("", m31.toWidget().get("value"))
      verifyEquals("", m32.toWidget().get("value"))
      verifyEquals("ABC", t41.toWidget().get("value"))
      verifyEquals("10", t42.toWidget().get("value"))
      verifyEquals("", m41.toWidget().get("value"))
      verifyEquals("", m42.toWidget().get("value"))
      verifyEquals("", m43.toWidget().get("value"))
      verifyEquals("", m44.toWidget().get("value"))
      click(btn1.toWidget())
      waitResponse(true)
      verifyEquals("Abc", l11.toWidget().get("value"))
      verifyEquals("33", l12.toWidget().get("value"))
      verifyEquals("Abc", t21.toWidget().get("value"))
      verifyEquals("33", t22.toWidget().get("value"))
      verifyEquals("XXX", t31.toWidget().get("value"))
      verifyEquals("1", t32.toWidget().get("value"))
      verifyEquals("value must equals ignore case 'abc', but is XXX", m31.toWidget().get("value"))
      verifyEquals("value must not < 10 or > 100, but is 1", m32.toWidget().get("value"))
      verifyEquals("ABC", t41.toWidget().get("value"))
      verifyEquals("10", t42.toWidget().get("value"))
      verifyEquals("", m41.toWidget().get("value"))
      verifyEquals("", m42.toWidget().get("value"))
      verifyEquals("", m43.toWidget().get("value"))
      verifyEquals("", m44.toWidget().get("value"))
      `type`(t32.toWidget(), "55") // intbox has reset issue...too bad
      waitResponse(true)
      verifyEquals("Abc", l11.toWidget().get("value"))
      verifyEquals("33", l12.toWidget().get("value"))
      verifyEquals("Abc", t21.toWidget().get("value"))
      verifyEquals("33", t22.toWidget().get("value"))
      verifyEquals("XXX", t31.toWidget().get("value"))
      verifyEquals("55", t32.toWidget().get("value"))
      verifyEquals("value must equals ignore case 'abc', but is XXX", m31.toWidget().get("value"))
      verifyEquals("value must not < 10 or > 100, but is 1", m32.toWidget().get("value"))
      verifyEquals("ABC", t41.toWidget().get("value"))
      verifyEquals("10", t42.toWidget().get("value"))
      verifyEquals("", m41.toWidget().get("value"))
      verifyEquals("", m42.toWidget().get("value"))
      verifyEquals("", m43.toWidget().get("value"))
      verifyEquals("", m44.toWidget().get("value"))
      click(btn1.toWidget())
      waitResponse(true)
      verifyEquals("Abc", l11.toWidget().get("value"))
      verifyEquals("33", l12.toWidget().get("value"))
      verifyEquals("Abc", t21.toWidget().get("value"))
      verifyEquals("33", t22.toWidget().get("value"))
      verifyEquals("XXX", t31.toWidget().get("value"))
      verifyEquals("55", t32.toWidget().get("value"))
      verifyEquals("value must equals ignore case 'abc', but is XXX", m31.toWidget().get("value"))
      verifyEquals("", m32.toWidget().get("value"))
      verifyEquals("ABC", t41.toWidget().get("value"))
      verifyEquals("10", t42.toWidget().get("value"))
      verifyEquals("", m41.toWidget().get("value"))
      verifyEquals("", m42.toWidget().get("value"))
      verifyEquals("", m43.toWidget().get("value"))
      verifyEquals("", m44.toWidget().get("value"))
      `type`(t31.toWidget(), "aBC") // intbox has reset issue...too bad
      waitResponse(true)
      verifyEquals("Abc", l11.toWidget().get("value"))
      verifyEquals("33", l12.toWidget().get("value"))
      verifyEquals("Abc", t21.toWidget().get("value"))
      verifyEquals("33", t22.toWidget().get("value"))
      verifyEquals("aBC", t31.toWidget().get("value"))
      verifyEquals("55", t32.toWidget().get("value"))
      verifyEquals("value must equals ignore case 'abc', but is XXX", m31.toWidget().get("value"))
      verifyEquals("", m32.toWidget().get("value"))
      verifyEquals("ABC", t41.toWidget().get("value"))
      verifyEquals("10", t42.toWidget().get("value"))
      verifyEquals("", m41.toWidget().get("value"))
      verifyEquals("", m42.toWidget().get("value"))
      verifyEquals("", m43.toWidget().get("value"))
      verifyEquals("", m44.toWidget().get("value"))
      click(btn1.toWidget())
      waitResponse(true)
      verifyEquals("aBC", l11.toWidget().get("value"))
      verifyEquals("55", l12.toWidget().get("value"))
      verifyEquals("aBC", t21.toWidget().get("value"))
      verifyEquals("55", t22.toWidget().get("value"))
      verifyEquals("aBC", t31.toWidget().get("value"))
      verifyEquals("55", t32.toWidget().get("value"))
      verifyEquals("", m31.toWidget().get("value"))
      verifyEquals("", m32.toWidget().get("value"))
      verifyEquals("ABC", t41.toWidget().get("value"))
      verifyEquals("10", t42.toWidget().get("value"))
      verifyEquals("", m41.toWidget().get("value"))
      verifyEquals("", m42.toWidget().get("value"))
      verifyEquals("", m43.toWidget().get("value"))
      verifyEquals("", m44.toWidget().get("value"))
      // ///////
      `type`(t41.toWidget(), "YYY")
      waitResponse(true)
      `type`(t42.toWidget(), "1999") // intbox has reset issue...too bad
      waitResponse(true)
      verifyEquals("aBC", l11.toWidget().get("value"))
      verifyEquals("55", l12.toWidget().get("value"))
      verifyEquals("aBC", t21.toWidget().get("value"))
      verifyEquals("55", t22.toWidget().get("value"))
      verifyEquals("aBC", t31.toWidget().get("value"))
      verifyEquals("55", t32.toWidget().get("value"))
      verifyEquals("", m31.toWidget().get("value"))
      verifyEquals("", m32.toWidget().get("value"))
      verifyEquals("YYY", t41.toWidget().get("value"))
      verifyEquals("1999", t42.toWidget().get("value"))
      verifyEquals("value must equals ignore case 'abc', but is YYY", m41.toWidget().get("value"))
      verifyEquals("value must not < 10 or > 100, but is 1999", m42.toWidget().get("value"))
      verifyEquals("", m43.toWidget().get("value"))
      verifyEquals("", m44.toWidget().get("value"))
      click(btn2.toWidget())
      waitResponse(true)
      verifyEquals("aBC", l11.toWidget().get("value"))
      verifyEquals("55", l12.toWidget().get("value"))
      verifyEquals("aBC", t21.toWidget().get("value"))
      verifyEquals("55", t22.toWidget().get("value"))
      verifyEquals("aBC", t31.toWidget().get("value"))
      verifyEquals("55", t32.toWidget().get("value"))
      verifyEquals("", m31.toWidget().get("value"))
      verifyEquals("", m32.toWidget().get("value"))
      verifyEquals("YYY", t41.toWidget().get("value"))
      verifyEquals("1999", t42.toWidget().get("value"))
      verifyEquals("value must equals ignore case 'abc', but is YYY", m41.toWidget().get("value"))
      verifyEquals("value must not < 10 or > 100, but is 1999", m42.toWidget().get("value"))
      verifyEquals("value must equals 'AbC', but is ABC", m43.toWidget().get("value"))
      verifyEquals("value must equals 'AbC', but is ABC", m44.toWidget().get("value"))
      verifyEquals("value must equals 'AbC', but is ABC", m45.toWidget().get("value"))
      verifyEquals("extra validation info ABC", m46.toWidget().get("value"))
      `type`(t41.toWidget(), "abc")
      waitResponse(true)
      `type`(t42.toWidget(), "77") // intbox has reset issue...too bad
      waitResponse(true)
      verifyEquals("aBC", l11.toWidget().get("value"))
      verifyEquals("55", l12.toWidget().get("value"))
      verifyEquals("aBC", t21.toWidget().get("value"))
      verifyEquals("55", t22.toWidget().get("value"))
      verifyEquals("aBC", t31.toWidget().get("value"))
      verifyEquals("55", t32.toWidget().get("value"))
      verifyEquals("", m31.toWidget().get("value"))
      verifyEquals("", m32.toWidget().get("value"))
      verifyEquals("abc", t41.toWidget().get("value"))
      verifyEquals("77", t42.toWidget().get("value"))
      verifyEquals("", m41.toWidget().get("value"))
      verifyEquals("", m42.toWidget().get("value"))
      verifyEquals("value must equals 'AbC', but is ABC", m43.toWidget().get("value"))
      verifyEquals("value must equals 'AbC', but is ABC", m44.toWidget().get("value"))
      verifyEquals("value must equals 'AbC', but is ABC", m45.toWidget().get("value"))
      verifyEquals("extra validation info ABC", m46.toWidget().get("value"))
      click(btn2.toWidget())
      waitResponse(true)
      verifyEquals("aBC", l11.toWidget().get("value"))
      verifyEquals("55", l12.toWidget().get("value"))
      verifyEquals("aBC", t21.toWidget().get("value"))
      verifyEquals("55", t22.toWidget().get("value"))
      verifyEquals("aBC", t31.toWidget().get("value"))
      verifyEquals("55", t32.toWidget().get("value"))
      verifyEquals("", m31.toWidget().get("value"))
      verifyEquals("", m32.toWidget().get("value"))
      verifyEquals("abc", t41.toWidget().get("value"))
      verifyEquals("77", t42.toWidget().get("value"))
      verifyEquals("", m41.toWidget().get("value"))
      verifyEquals("", m42.toWidget().get("value"))
      verifyEquals("value must equals 'AbC', but is abc", m43.toWidget().get("value"))
      verifyEquals("value must equals 'AbC', but is abc", m44.toWidget().get("value"))
      verifyEquals("value must equals 'AbC', but is abc", m45.toWidget().get("value"))
      verifyEquals("extra validation info abc", m46.toWidget().get("value"))
      `type`(t41.toWidget(), "AbC")
      waitResponse(true)
      click(btn2.toWidget())
      waitResponse(true)
      verifyEquals("AbC", l11.toWidget().get("value"))
      verifyEquals("77", l12.toWidget().get("value"))
      verifyEquals("AbC", t21.toWidget().get("value"))
      verifyEquals("77", t22.toWidget().get("value"))
      verifyEquals("AbC", t31.toWidget().get("value"))
      verifyEquals("77", t32.toWidget().get("value"))
      verifyEquals("", m31.toWidget().get("value"))
      verifyEquals("", m32.toWidget().get("value"))
      verifyEquals("AbC", t41.toWidget().get("value"))
      verifyEquals("77", t42.toWidget().get("value"))
      verifyEquals("", m41.toWidget().get("value"))
      verifyEquals("", m42.toWidget().get("value"))
      verifyEquals("", m43.toWidget().get("value"))
      verifyEquals("", m44.toWidget().get("value"))
      `type`(t31.toWidget(), "YYY")
      waitResponse(true)
      `type`(t32.toWidget(), "2") // intbox has reset issue...too bad
      waitResponse(true)
      click(btn1.toWidget())
      waitResponse(true)
      verifyEquals("YYY", t31.toWidget().get("value"))
      verifyEquals("2", t32.toWidget().get("value"))
      verifyEquals("value must equals ignore case 'abc', but is YYY", m31.toWidget().get("value"))
      verifyEquals("value must not < 10 or > 100, but is 2", m32.toWidget().get("value"))
      click(btn3.toWidget())
      waitResponse(true)
      verifyEquals("AbC", t31.toWidget().get("value"))
      verifyEquals("2", t32.toWidget().get("value"))
      verifyEquals("", m31.toWidget().get("value"))
      verifyEquals("value must not < 10 or > 100, but is 2", m32.toWidget().get("value"))
    })
  }
}