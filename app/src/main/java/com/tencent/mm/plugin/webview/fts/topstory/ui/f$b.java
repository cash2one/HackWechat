package com.tencent.mm.plugin.webview.fts.topstory.ui;

import android.annotation.SuppressLint;
import com.tencent.mm.R;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.webview.fts.c.c;
import com.tencent.mm.plugin.webview.fts.topstory.ui.widget.b;
import com.tencent.mm.sdk.platformtools.x;

class f$b implements b {
    final /* synthetic */ f tpL;
    private float tpQ;

    f$b(f fVar) {
        this.tpL = fVar;
        this.tpQ = (float) a.eB(fVar.getContext());
    }

    public final void agS() {
        x.d("MicroMsg.WebSearch.TopStoryVideoViewContainer", "onSingleTap");
        if (f.r(this.tpL)) {
            f.f(this.tpL).kn(f.i(this.tpL));
        }
        if (f.b(this.tpL) != null) {
            f.b(this.tpL).bPz();
            f.b(this.tpL).bPy();
        }
    }

    public final void agT() {
        x.d("MicroMsg.WebSearch.TopStoryVideoViewContainer", "onDoubleTap");
    }

    public final void agU() {
        f.s(this.tpL).setVisibility(0);
        f.f(this.tpL).bQu();
    }

    public final int e(int i, float f) {
        x.d("MicroMsg.WebSearch.TopStoryVideoViewContainer", "onDragProgress:" + i + "/" + f);
        float f2 = f / this.tpQ;
        int ahi = g.bQd().ahi();
        int ahk = ((int) (f2 * ((float) ahi))) + g.bQd().ahk();
        if (ahk < 0) {
            ahk = 0;
        } else if (ahk > ahi) {
            ahk = ahi;
        }
        f.s(this.tpL).setText(c.bp(((long) ahk) * 1000) + "/" + c.bp(((long) ahi) * 1000));
        return ahk;
    }

    public final void f(int i, float f) {
        f.f(this.tpL).bQv();
        f.s(this.tpL).setVisibility(8);
        int ahk = g.bQd().ahk();
        f.seekTo(i);
        f.f(this.tpL).bQv();
        x.d("MicroMsg.WebSearch.TopStoryVideoViewContainer", "onEndDragProgress: dragPosition=%d currentPositon=%d totalDistanceX=%s", new Object[]{Integer.valueOf(i), Integer.valueOf(ahk), Float.valueOf(f)});
    }

    public final boolean bQc() {
        if (f.t(this.tpL)) {
            return false;
        }
        return true;
    }

    public final int getCurrentPosition() {
        return g.bQd().ahk();
    }

    @SuppressLint({"ResourceType"})
    public final void Y(float f) {
        f.u(this.tpL).X(f);
        f.v(this.tpL).setText(R.l.ekU);
        f.w(this.tpL).setImageResource(R.k.dyJ);
        f.x(this.tpL).setVisibility(0);
        x.d("MicroMsg.WebSearch.TopStoryVideoViewContainer", "onAdjustVolume:" + f);
    }

    @SuppressLint({"ResourceType"})
    public final void Z(float f) {
        f.u(this.tpL).X(f);
        f.v(this.tpL).setText(R.l.ekT);
        f.w(this.tpL).setImageResource(R.k.dyH);
        f.x(this.tpL).setVisibility(0);
        x.d("MicroMsg.WebSearch.TopStoryVideoViewContainer", "onAdjustBrightness:" + f);
    }

    public final void agV() {
        f.x(this.tpL).setVisibility(8);
        g.pQN.h(791, 23);
    }

    public final void agW() {
        f.x(this.tpL).setVisibility(8);
        g.pQN.h(791, 24);
    }
}
