package com.tencent.mm.ui.transmit;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.k;
import com.tencent.mm.ae.u.a;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.protocal.c.cat;
import com.tencent.mm.protocal.c.cbb;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.g;
import java.util.Iterator;
import java.util.LinkedList;

class SendAppMessageWrapperUI$6 implements a {
    final /* synthetic */ WXMediaMessage fgT;
    final /* synthetic */ LinkedList jrg;
    final /* synthetic */ SendAppMessageWrapperUI zpD;
    final /* synthetic */ WxaAttributes zpE;
    final /* synthetic */ WXMiniProgramObject zpF;
    final /* synthetic */ String zpG;

    SendAppMessageWrapperUI$6(SendAppMessageWrapperUI sendAppMessageWrapperUI, LinkedList linkedList, WxaAttributes wxaAttributes, WXMiniProgramObject wXMiniProgramObject, String str, WXMediaMessage wXMediaMessage) {
        this.zpD = sendAppMessageWrapperUI;
        this.jrg = linkedList;
        this.zpE = wxaAttributes;
        this.zpF = wXMiniProgramObject;
        this.zpG = str;
        this.fgT = wXMediaMessage;
    }

    public final int a(int i, int i2, String str, b bVar, k kVar) {
        x.i("MicroMsg.SendAppMessageWrapperUI", "callback, errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        cat com_tencent_mm_protocal_c_cat = (cat) bVar.hmh.hmo;
        if (i != 0 || i2 != 0 || com_tencent_mm_protocal_c_cat == null || com_tencent_mm_protocal_c_cat.xab == null) {
            Iterator it = this.jrg.iterator();
            while (it.hasNext()) {
                l.a(this.fgT, SendAppMessageWrapperUI.e(this.zpD).field_appId, SendAppMessageWrapperUI.e(this.zpD).field_appName, (String) it.next(), 2, null, null);
            }
        } else {
            LinkedList linkedList = com_tencent_mm_protocal_c_cat.xab == null ? new LinkedList() : com_tencent_mm_protocal_c_cat.xab;
            x.i("MicroMsg.SendAppMessageWrapperUI", "get wxaAppShareInfoList size = %d, toUserList size = %d", new Object[]{Integer.valueOf(linkedList.size()), Integer.valueOf(this.jrg.size())});
            for (int i3 = 0; i3 < this.jrg.size(); i3++) {
                cbb com_tencent_mm_protocal_c_cbb;
                if (i3 < linkedList.size()) {
                    com_tencent_mm_protocal_c_cbb = (cbb) linkedList.get(i3);
                } else {
                    com_tencent_mm_protocal_c_cbb = new cbb();
                }
                g.a aVar = new g.a();
                aVar.appId = SendAppMessageWrapperUI.e(this.zpD).field_appId;
                aVar.hdy = this.zpE.field_appId;
                aVar.hdE = this.zpF.miniprogramType;
                aVar.appName = SendAppMessageWrapperUI.e(this.zpD).field_appName;
                aVar.hbe = 2;
                aVar.hdD = com_tencent_mm_protocal_c_cbb.xaq;
                aVar.hdC = this.zpG;
                l.a(aVar, this.fgT, (String) this.jrg.get(i3));
            }
        }
        return 0;
    }
}
