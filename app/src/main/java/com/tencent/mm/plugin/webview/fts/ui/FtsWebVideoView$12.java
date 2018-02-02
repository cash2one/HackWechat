package com.tencent.mm.plugin.webview.fts.ui;

import com.tencent.mm.R;
import com.tencent.mm.plugin.webview.fts.c.c;
import com.tencent.mm.plugin.webview.fts.ui.a.b;
import com.tencent.mm.sdk.platformtools.x;

class FtsWebVideoView$12 implements b {
    final /* synthetic */ FtsWebVideoView trm;

    FtsWebVideoView$12(FtsWebVideoView ftsWebVideoView) {
        this.trm = ftsWebVideoView;
    }

    public final void agS() {
        x.d("MicroMsg.FtsWebVideoView", "onSingleTap");
        if (FtsWebVideoView.e(this.trm)) {
            FtsWebVideoView.c(this.trm).kn(FtsWebVideoView.f(this.trm));
        }
    }

    public final void agT() {
        x.d("MicroMsg.FtsWebVideoView", "onDoubleTap");
    }

    public final void agU() {
        if (FtsWebVideoView.d(this.trm).agP()) {
            x.i("MicroMsg.FtsWebVideoView", "onStartDragProgress isLive: no seek");
            return;
        }
        FtsWebVideoView.g(this.trm).setVisibility(0);
        FtsWebVideoView.c(this.trm).bQu();
    }

    public final int e(int i, float f) {
        int i2 = 0;
        if (FtsWebVideoView.d(this.trm).agP()) {
            x.i("MicroMsg.FtsWebVideoView", "onDragProgress isLive: no seek");
        } else {
            x.i("MicroMsg.FtsWebVideoView", "onDragProgress:" + i + "/" + f);
            float measuredWidth = f / ((float) this.trm.getMeasuredWidth());
            int ahi = FtsWebVideoView.d(this.trm).ahi();
            int currentPosition = ((int) (measuredWidth * ((float) ahi))) + getCurrentPosition();
            if (currentPosition >= 0) {
                if (currentPosition > ahi) {
                    i2 = ahi;
                } else {
                    i2 = currentPosition;
                }
            }
            FtsWebVideoView.g(this.trm).setText(c.bp(((long) i2) * 1000) + "/" + c.bp(((long) ahi) * 1000));
        }
        return i2;
    }

    public final void f(int i, float f) {
        FtsWebVideoView.c(this.trm).bQv();
        FtsWebVideoView.g(this.trm).setVisibility(8);
        int ahk = FtsWebVideoView.d(this.trm).ahk();
        x.i("MicroMsg.FtsWebVideoView", "onEndDragProgress: dragPosition=%d currentPositon=%d totalDistanceX=%s", new Object[]{Integer.valueOf(i), Integer.valueOf(ahk), Float.valueOf(f)});
        if (FtsWebVideoView.d(this.trm).agP()) {
            x.i("MicroMsg.FtsWebVideoView", "onEndDragProgress isLive: no seek");
            return;
        }
        this.trm.w(i, false);
        FtsWebVideoView.c(this.trm).bQv();
        if (FtsWebVideoView.h(this.trm) != null) {
            FtsWebVideoView.h(this.trm).bQy();
        }
    }

    public final boolean bQc() {
        if (FtsWebVideoView.i(this.trm)) {
            return false;
        }
        return true;
    }

    public final int getCurrentPosition() {
        return FtsWebVideoView.d(this.trm).ahk();
    }

    public final void Y(float f) {
        x.d("MicroMsg.FtsWebVideoView", "onAdjustVolume:" + f);
        FtsWebVideoView.j(this.trm).X(f);
        FtsWebVideoView.k(this.trm).setText(R.l.ekU);
        FtsWebVideoView.l(this.trm).setImageResource(R.k.dyJ);
        FtsWebVideoView.m(this.trm).setVisibility(0);
    }

    public final void Z(float f) {
        x.d("MicroMsg.FtsWebVideoView", "onAdjustBrightness:" + f);
        FtsWebVideoView.j(this.trm).X(f);
        FtsWebVideoView.k(this.trm).setText(R.l.ekT);
        FtsWebVideoView.l(this.trm).setImageResource(R.k.dyH);
        FtsWebVideoView.m(this.trm).setVisibility(0);
    }

    public final void agV() {
        FtsWebVideoView.m(this.trm).setVisibility(8);
    }

    public final void agW() {
        FtsWebVideoView.m(this.trm).setVisibility(8);
    }
}
