package com.tencent.mm.plugin.webview.ui.tools;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.mm.R;

class WebViewUI$63 implements OnClickListener {
    final /* synthetic */ WebViewUI tAv;

    WebViewUI$63(WebViewUI webViewUI) {
        this.tAv = webViewUI;
    }

    public final void onClick(View view) {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.tAv, R.a.bqc);
        loadAnimation.setAnimationListener(new 1(this));
        WebViewUI.Q(this.tAv).startAnimation(loadAnimation);
        WebViewUI.Q(this.tAv).setVisibility(8);
    }
}
