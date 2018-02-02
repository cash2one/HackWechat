package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.view.View;
import android.view.View.OnClickListener;

class AppBrandVideoView$10 implements OnClickListener {
    final /* synthetic */ AppBrandVideoView jsL;

    AppBrandVideoView$10(AppBrandVideoView appBrandVideoView) {
        this.jsL = appBrandVideoView;
    }

    public final void onClick(View view) {
        if (AppBrandVideoView.b(this.jsL).isPlaying()) {
            this.jsL.pause();
        } else {
            this.jsL.start();
        }
    }
}
