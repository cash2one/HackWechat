package com.tencent.mm.ui;

import com.tencent.mm.sdk.platformtools.x;

class o$1 implements Runnable {
    final /* synthetic */ o xIn;

    o$1(o oVar) {
        this.xIn = oVar;
    }

    public final void run() {
        if (o.a(this.xIn) != 0) {
            x.v("MicroMsg.MListAdapter", "ashutest:: onResetCursorJobRun, current AbsListViewScrollType %d, post resetCursorJob, retryTimes %d", new Object[]{Integer.valueOf(o.a(this.xIn)), Integer.valueOf(o.b(this.xIn))});
            o.d(this.xIn).removeCallbacks(o.c(this.xIn));
            if (20 > o.e(this.xIn)) {
                o.d(this.xIn).postDelayed(o.c(this.xIn), 100);
                return;
            } else {
                x.w("MicroMsg.MListAdapter", "ashutest:: onResetCursorJobRun, current AbsListViewScrollType %d, do resetCursorJob, retryTimes %d", new Object[]{Integer.valueOf(o.a(this.xIn)), Integer.valueOf(o.e(this.xIn))});
            }
        }
        x.d("MicroMsg.MListAdapter", "ashutest:: do resetCursorJob");
        o.f(this.xIn);
        o.g(this.xIn);
    }
}
