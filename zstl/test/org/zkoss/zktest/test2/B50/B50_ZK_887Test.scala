package org.zkoss.zktest.test2.B50

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.ZK

@Tags(tags = "B50-ZK-887.zul")
class B50_ZK_887Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """<zk>
                    You should see the width of the cell is as well as its label.
                    <hbox style="border:1px solid #336" width="100px" widths="30px, 50px">
                      30px
                      <splitter/>
                      50px
                    </hbox>
                  </zk>"""

    runZTL(zscript,
      () => {
        val label0 = jq(".z-label:contains(30px)")
        val td0 = label0.parent()
        val width0 = td0.width()

        verifyEquals(td0.text().trim().replace("\n", "").substring(0, 2).toInt, width0)

        val label1 = jq(".z-label:contains(50px)")
        val td1 = label1.parent()

        // opera bug: will be more 2px than others browser
        val diff = if (ZK.is("opera")) {
          2
        } else {
          0
        }
        val width1 = td1.width() - diff

        verifyEquals(td1.text().trim().replace("\n", "").substring(0, 2).toInt, width1)
      })

  }
}
