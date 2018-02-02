package com.tencent.mm.plugin.webview.ui.tools;

import android.view.View;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

class OAuthUI$8 implements a {
    final /* synthetic */ String mZE;
    final /* synthetic */ OAuthUI twM;
    final /* synthetic */ View twN;
    final /* synthetic */ ThreeDotsLoadingView twO;

    OAuthUI$8(OAuthUI oAuthUI, String str, View view, ThreeDotsLoadingView threeDotsLoadingView) {
        this.twM = oAuthUI;
        this.mZE = str;
        this.twN = view;
        this.twO = threeDotsLoadingView;
    }

    public final boolean uF() {
        OAuthUI.a(this.twM, this.mZE);
        this.twN.setVisibility(8);
        this.twO.ajm();
        return false;
    }
}
