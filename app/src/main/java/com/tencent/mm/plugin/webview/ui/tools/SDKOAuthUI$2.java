package com.tencent.mm.plugin.webview.ui.tools;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.protocal.c.beh;

class SDKOAuthUI$2 implements OnClickListener {
    final /* synthetic */ SDKOAuthUI txf;
    final /* synthetic */ beh txg;

    SDKOAuthUI$2(SDKOAuthUI sDKOAuthUI, beh com_tencent_mm_protocal_c_beh) {
        this.txf = sDKOAuthUI;
        this.txg = com_tencent_mm_protocal_c_beh;
    }

    public final void onClick(View view) {
        if (this.txg.wBN) {
            SDKOAuthUI.a(this.txf, SDKOAuthUI.b(this.txf), SDKOAuthUI.c(this.txf).state, SDKOAuthUI.Pi(SDKOAuthUI.b(this.txf)), SDKOAuthUI.d(this.txf).bSq());
        } else {
            SDKOAuthUI.a(this.txf, this.txg.vUP);
        }
    }
}
