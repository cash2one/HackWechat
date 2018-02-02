package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.media.ThumbnailUtils;
import com.tencent.mm.sdk.platformtools.ag;

class AppBrandVideoView$3 implements Runnable {
    final /* synthetic */ AppBrandVideoView jsL;
    final /* synthetic */ String jsM;

    AppBrandVideoView$3(AppBrandVideoView appBrandVideoView, String str) {
        this.jsL = appBrandVideoView;
        this.jsM = str;
    }

    public final void run() {
        ag.y(new 1(this, ThumbnailUtils.createVideoThumbnail(this.jsM, 1)));
    }
}
