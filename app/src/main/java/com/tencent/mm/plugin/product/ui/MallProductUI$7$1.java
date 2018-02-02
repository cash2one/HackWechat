package com.tencent.mm.plugin.product.ui;

import android.content.Intent;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.product.b.m;
import com.tencent.mm.plugin.product.ui.MallProductUI.7;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.z.u;

class MallProductUI$7$1 implements c {
    final /* synthetic */ 7 phd;

    MallProductUI$7$1(7 7) {
        this.phd = 7;
    }

    public final void jl(int i) {
        f e;
        String bjf;
        Intent intent;
        switch (i) {
            case 0:
                e = MallProductUI.e(this.phd.phb);
                bjf = e.pfH.bjf();
                intent = new Intent();
                intent.putExtra("Retr_Msg_content", bjf);
                intent.putExtra("Retr_Msg_Type", 2);
                if (!bh.ov(e.pfH.pdK.bji())) {
                    intent.putExtra("Retr_Msg_thumb_path", e.pfH.biW());
                }
                intent.putExtra("Retr_go_to_chattingUI", false);
                intent.putExtra("Retr_show_success_tips", true);
                intent.putExtra("Retr_Msg_Type", 2);
                d.a(e.iQz, ".ui.transmit.MsgRetransmitUI", intent);
                if (f.irz == 4) {
                    g.pQN.h(10651, Integer.valueOf(11), Integer.valueOf(1), Integer.valueOf(0));
                    return;
                }
                return;
            case 1:
                e = MallProductUI.e(this.phd.phb);
                m mVar = e.pfH.pdK;
                intent = new Intent();
                intent.putExtra("KContentObjDesc", e.pfH.bjg());
                intent.putExtra("Ksnsupload_title", mVar.peo.name);
                intent.putExtra("Ksnsupload_link", e.pfH.biX());
                intent.putExtra("Ksnsupload_imgurl", e.pfH.pdK.bji());
                if (!bh.ov(e.pfH.pdK.bji())) {
                    intent.putExtra("KsnsUpload_imgPath", e.pfH.biW());
                }
                intent.putExtra("Ksnsupload_type", 6);
                intent.putExtra("KUploadProduct_UserData", e.pfH.a(mVar));
                intent.putExtra("KUploadProduct_subType", mVar.pel);
                bjf = u.hz("scan_product");
                u.GK().t(bjf, true).o("prePublishId", "scan_product");
                intent.putExtra("reportSessionId", bjf);
                d.b(e.iQz, "sns", ".ui.SnsUploadUI", intent);
                if (f.irz == 4) {
                    g.pQN.h(10651, Integer.valueOf(11), Integer.valueOf(0), Integer.valueOf(0));
                    return;
                }
                return;
            case 2:
                MallProductUI.e(this.phd.phb).bjm();
                return;
            case 3:
                e = MallProductUI.e(this.phd.phb);
                e.S(e.iQz, e.pfH.biV());
                return;
            default:
                return;
        }
    }
}
