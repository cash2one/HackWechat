package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.k;
import com.tencent.mm.ae.u.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.plugin.appbrand.ui.WxaBindBizInfoUI.3;
import com.tencent.mm.protocal.c.air;
import com.tencent.mm.protocal.c.gm;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class WxaBindBizInfoUI$3$1 implements a {
    final /* synthetic */ 3 jNp;

    WxaBindBizInfoUI$3$1(3 3) {
        this.jNp = 3;
    }

    public final int a(int i, int i2, String str, b bVar, k kVar) {
        if (i == 0 && i2 == 0) {
            air com_tencent_mm_protocal_c_air = (air) bVar.hmh.hmo;
            LinkedList linkedList = com_tencent_mm_protocal_c_air.wqf;
            boolean z = com_tencent_mm_protocal_c_air.wqg;
            this.jNp.jNo.jNk = com_tencent_mm_protocal_c_air.wqe;
            if (z) {
                this.jNp.jNo.jNm.dB(false);
                this.jNp.jNo.jJq.ajm();
                this.jNp.jNo.jNl.jNr = true;
                this.jNp.jNo.jNn.setVisibility(0);
            }
            if (!(linkedList == null || linkedList.isEmpty())) {
                List linkedList2 = new LinkedList();
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    gm gmVar = (gm) it.next();
                    if (gmVar != null) {
                        WxaEntryInfo wxaEntryInfo = new WxaEntryInfo();
                        wxaEntryInfo.title = gmVar.fpL;
                        wxaEntryInfo.iconUrl = gmVar.oZC;
                        wxaEntryInfo.username = gmVar.username;
                        linkedList2.add(wxaEntryInfo);
                    }
                }
                this.jNp.jNo.jNl.ac(linkedList2);
            }
        } else {
            x.e("MicroMsg.WxaBindBizInfoUI", "onResp, errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        }
        return 0;
    }
}
