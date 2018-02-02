package com.tencent.mm.plugin.appbrand.jsapi.video;

import com.tencent.mm.plugin.appbrand.jsapi.video.f.b;
import com.tencent.mm.plugin.appbrand.q.i;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.sdk.platformtools.x;

class AppBrandVideoView$5 implements b {
    final /* synthetic */ AppBrandVideoView jsL;

    AppBrandVideoView$5(AppBrandVideoView appBrandVideoView) {
        this.jsL = appBrandVideoView;
    }

    public final void agS() {
        x.d("MicroMsg.AppBrandVideoView", "onSingleTap");
        if (AppBrandVideoView.f(this.jsL)) {
            AppBrandVideoView.g(this.jsL).ahb();
        }
    }

    public final void agT() {
        x.d("MicroMsg.AppBrandVideoView", "onDoubleTap");
    }

    public final void agU() {
        if (AppBrandVideoView.h(this.jsL)) {
            AppBrandVideoView.i(this.jsL).setVisibility(0);
        }
    }

    public final int e(int i, float f) {
        int i2 = 0;
        if (AppBrandVideoView.h(this.jsL)) {
            x.i("MicroMsg.AppBrandVideoView", "onDragProgress:" + i + "/" + f);
            float measuredWidth = f / ((float) this.jsL.getMeasuredWidth());
            int ahi = AppBrandVideoView.b(this.jsL).ahi();
            int currentPosition = ((int) (measuredWidth * ((float) ahi))) + getCurrentPosition();
            if (currentPosition >= 0) {
                if (currentPosition > ahi) {
                    i2 = ahi;
                } else {
                    i2 = currentPosition;
                }
            }
            AppBrandVideoView.i(this.jsL).setText(g.bp(((long) i2) * 1000) + "/" + g.bp(((long) ahi) * 1000));
        }
        return i2;
    }

    public final void f(int i, float f) {
        AppBrandVideoView.i(this.jsL).setVisibility(8);
        int ahk = AppBrandVideoView.b(this.jsL).ahk();
        x.i("MicroMsg.AppBrandVideoView", "onEndDragProgress: dragPosition=%d currentPositon=%d totalDistanceX=%s", new Object[]{Integer.valueOf(i), Integer.valueOf(ahk), Float.valueOf(f)});
        if (AppBrandVideoView.h(this.jsL)) {
            this.jsL.w(i, false);
        }
    }

    public final int getCurrentPosition() {
        return AppBrandVideoView.b(this.jsL).ahk();
    }

    public final void Y(float f) {
        x.d("MicroMsg.AppBrandVideoView", "onAdjustVolume:" + f);
        AppBrandVideoView.j(this.jsL).X(f);
        AppBrandVideoView.k(this.jsL).setText(j.iBv);
        AppBrandVideoView.l(this.jsL).setImageResource(i.iyk);
        AppBrandVideoView.m(this.jsL).setVisibility(0);
    }

    public final void Z(float f) {
        x.d("MicroMsg.AppBrandVideoView", "onAdjustBrightness:" + f);
        AppBrandVideoView.j(this.jsL).X(f);
        AppBrandVideoView.k(this.jsL).setText(j.iBu);
        AppBrandVideoView.l(this.jsL).setImageResource(i.ixZ);
        AppBrandVideoView.m(this.jsL).setVisibility(0);
    }

    public final void agV() {
        AppBrandVideoView.m(this.jsL).setVisibility(8);
    }

    public final void agW() {
        AppBrandVideoView.m(this.jsL).setVisibility(8);
    }
}
