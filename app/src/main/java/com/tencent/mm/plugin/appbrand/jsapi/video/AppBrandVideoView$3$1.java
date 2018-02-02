package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView.3;

class AppBrandVideoView$3$1 implements Runnable {
    final /* synthetic */ Bitmap jsN;
    final /* synthetic */ 3 jsO;

    AppBrandVideoView$3$1(3 3, Bitmap bitmap) {
        this.jsO = 3;
        this.jsN = bitmap;
    }

    public final void run() {
        if (this.jsN != null && !this.jsN.isRecycled()) {
            AppBrandVideoView.a(this.jsO.jsL).setImageBitmap(this.jsN);
        }
    }
}
