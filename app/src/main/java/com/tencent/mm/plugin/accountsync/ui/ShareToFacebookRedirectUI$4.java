package com.tencent.mm.plugin.accountsync.ui;

import com.tencent.mm.plugin.accountsync.model.c;
import com.tencent.mm.pluginsdk.ui.applet.e$a;
import com.tencent.mm.pluginsdk.ui.applet.o.a;
import com.tencent.mm.protocal.c.bfz;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;

class ShareToFacebookRedirectUI$4 implements a {
    final /* synthetic */ ShareToFacebookRedirectUI ilI;
    final /* synthetic */ e$a ilJ;

    ShareToFacebookRedirectUI$4(ShareToFacebookRedirectUI shareToFacebookRedirectUI, e$a com_tencent_mm_pluginsdk_ui_applet_e_a) {
        this.ilI = shareToFacebookRedirectUI;
        this.ilJ = com_tencent_mm_pluginsdk_ui_applet_e_a;
    }

    public final void a(boolean z, String str, int i) {
        this.ilI.aWs();
        this.ilJ.pyk.dismiss();
        if (z) {
            bfz com_tencent_mm_protocal_c_bfz = new bfz();
            if (bh.ov(str)) {
                str = " ";
            }
            com_tencent_mm_protocal_c_bfz.nfU = str;
            com_tencent_mm_protocal_c_bfz.nfp = ShareToFacebookRedirectUI.b(this.ilI);
            com_tencent_mm_protocal_c_bfz.vIO = ShareToFacebookRedirectUI.c(this.ilI);
            com_tencent_mm_protocal_c_bfz.oPA = ShareToFacebookRedirectUI.d(this.ilI);
            com_tencent_mm_protocal_c_bfz.wKG = ShareToFacebookRedirectUI.e(this.ilI);
            ar.CG().a(new c(com_tencent_mm_protocal_c_bfz), 0);
            ShareToFacebookRedirectUI.a(this.ilI, h.a(this.ilI, "", false, new 1(this)));
            return;
        }
        this.ilI.finish();
    }
}
