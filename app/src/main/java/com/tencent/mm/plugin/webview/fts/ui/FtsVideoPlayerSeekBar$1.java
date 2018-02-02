package com.tencent.mm.plugin.webview.fts.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.sdk.platformtools.x;

class FtsVideoPlayerSeekBar$1 implements OnTouchListener {
    final /* synthetic */ FtsVideoPlayerSeekBar tqH;

    FtsVideoPlayerSeekBar$1(FtsVideoPlayerSeekBar ftsVideoPlayerSeekBar) {
        this.tqH = ftsVideoPlayerSeekBar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            x.i("MicroMsg.FtsVideoPlayerSeekBar", "ontouch down");
            FtsVideoPlayerSeekBar.a(this.tqH);
            FtsVideoPlayerSeekBar.a(this.tqH, motionEvent.getX());
            FtsVideoPlayerSeekBar.b(this.tqH, (float) ((LayoutParams) FtsVideoPlayerSeekBar.b(this.tqH).getLayoutParams()).leftMargin);
            if (FtsVideoPlayerSeekBar.c(this.tqH) != null) {
                FtsVideoPlayerSeekBar.d(this.tqH).agX();
            }
        } else if (motionEvent.getAction() == 2) {
            x.i("MicroMsg.FtsVideoPlayerSeekBar", "move dis %f ", new Object[]{Float.valueOf(motionEvent.getX() - FtsVideoPlayerSeekBar.e(this.tqH))});
            this.tqH.Af((int) ((r0 - FtsVideoPlayerSeekBar.e(this.tqH)) + ((float) FtsVideoPlayerSeekBar.f(this.tqH))));
            r0 = FtsVideoPlayerSeekBar.g(this.tqH);
            FtsVideoPlayerSeekBar.h(this.tqH).setText(FtsVideoPlayerSeekBar.kG(r0 / 60) + ":" + FtsVideoPlayerSeekBar.kG(r0 % 60));
            FtsVideoPlayerSeekBar.i(this.tqH);
        } else {
            x.i("MicroMsg.FtsVideoPlayerSeekBar", "ontouch up");
            r0 = FtsVideoPlayerSeekBar.j(this.tqH);
            if (FtsVideoPlayerSeekBar.k(this.tqH)) {
                r0 = FtsVideoPlayerSeekBar.a(this.tqH, FtsVideoPlayerSeekBar.g(this.tqH));
            }
            if (FtsVideoPlayerSeekBar.l(this.tqH) != null) {
                x.i("MicroMsg.FtsVideoPlayerSeekBar", "current time : " + r0);
                FtsVideoPlayerSeekBar.m(this.tqH).kH(r0);
            }
            FtsVideoPlayerSeekBar.n(this.tqH);
        }
        return true;
    }
}
