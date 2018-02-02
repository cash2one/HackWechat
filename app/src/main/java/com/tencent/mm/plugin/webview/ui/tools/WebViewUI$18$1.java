package com.tencent.mm.plugin.webview.ui.tools;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.18;

class WebViewUI$18$1 implements AnimationListener {
    final /* synthetic */ 18 tBj;

    WebViewUI$18$1(18 18) {
        this.tBj = 18;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        WebViewUI.Q(this.tBj.tAv).setVisibility(8);
    }
}
