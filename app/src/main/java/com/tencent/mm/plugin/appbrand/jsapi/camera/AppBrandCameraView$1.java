package com.tencent.mm.plugin.appbrand.jsapi.camera;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e;

class AppBrandCameraView$1 implements e {
    final /* synthetic */ AppBrandCameraView jiw;

    AppBrandCameraView$1(AppBrandCameraView appBrandCameraView) {
        this.jiw = appBrandCameraView;
    }

    public final void r(Bitmap bitmap) {
        if (bitmap == null) {
            AppBrandCameraView.a(this.jiw, -1, null, "bitmap is null");
        } else if (AppBrandCameraView.a(this.jiw, bitmap, AppBrandCameraView.a(this.jiw))) {
            AppBrandCameraView.a(this.jiw, 0, AppBrandCameraView.a(this.jiw, AppBrandCameraView.a(this.jiw)), "");
        } else {
            AppBrandCameraView.a(this.jiw, -1, null, "save fail");
        }
    }

    public final void agg() {
        AppBrandCameraView.a(this.jiw, -1, null, "take picture error");
    }
}
