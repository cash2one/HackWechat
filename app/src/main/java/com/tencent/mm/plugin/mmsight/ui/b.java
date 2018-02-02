package com.tencent.mm.plugin.mmsight.ui;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class b {
    private int duration;
    boolean fAs;
    ak hHu = null;
    private float oBZ = 0.0f;
    private float oCa;
    float oCb;
    long oCc;
    float oCd;
    a oCe;
    private Runnable oCf = new Runnable(this) {
        final /* synthetic */ b oCg;

        {
            this.oCg = r1;
        }

        public final void run() {
            b.a(this.oCg);
            if (!this.oCg.fAs) {
                x.i("MicroMsg.ProgressHandlerAnimator", "isStart is false now");
            } else if (this.oCg.oCd < this.oCg.oCb) {
                this.oCg.hHu.post(this);
            } else {
                this.oCg.fAs = false;
                x.i("MicroMsg.ProgressHandlerAnimator", "reach end, currentValue: %s, end: %s", new Object[]{Float.valueOf(this.oCg.oCd), Float.valueOf(this.oCg.oCb)});
                if (this.oCg.oCe != null) {
                    this.oCg.oCe.onAnimationEnd();
                }
            }
        }
    };

    static /* synthetic */ void a(b bVar) {
        x.d("MicroMsg.ProgressHandlerAnimator", "updateImpl, currentValue: %s", new Object[]{Float.valueOf(bVar.oCd)});
        bVar.oCd = (((float) bh.bA(bVar.oCc)) / ((float) bVar.duration)) * (bVar.oCb - bVar.oCa);
        if (bVar.oCe != null) {
            bVar.oCe.an(bVar.oCd);
        }
    }

    public b(float f, float f2, int i) {
        this.oCa = f;
        this.oCb = f2;
        this.duration = i;
        if (f2 > f) {
            this.oBZ = ((f2 - f) / ((float) this.duration)) * 20.0f;
        }
        x.i("MicroMsg.ProgressHandlerAnimator", "create ProgressHandlerAnimator, start: %s, end: %s, duration: %s, updateStep: %s", new Object[]{Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i), Float.valueOf(this.oBZ)});
        this.fAs = false;
        this.oCc = 0;
        this.hHu = new ak(Looper.getMainLooper(), new 1(this), true);
    }
}
