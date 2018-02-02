package com.tencent.mm.plugin.mmsight.segment;

import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.x;

class RecyclerThumbSeekBar$2 implements Runnable {
    final /* synthetic */ RecyclerThumbSeekBar oyG;

    RecyclerThumbSeekBar$2(RecyclerThumbSeekBar recyclerThumbSeekBar) {
        this.oyG = recyclerThumbSeekBar;
    }

    public final void run() {
        if (this.oyG.getHeight() == 0 || this.oyG.getWidth() == 0) {
            this.oyG.post(RecyclerThumbSeekBar.e(this.oyG));
            return;
        }
        RecyclerThumbSeekBar.a(this.oyG, 1000);
        RecyclerThumbSeekBar.b(this.oyG, this.oyG.getHeight());
        RecyclerThumbSeekBar.c(this.oyG, (this.oyG.getWidth() - (RecyclerThumbSeekBar.f(this.oyG) * 2)) / 10);
        e.post(new Runnable(this) {
            final /* synthetic */ RecyclerThumbSeekBar$2 oyH;

            {
                this.oyH = r1;
            }

            public final void run() {
                int i;
                try {
                    d bbc = RecyclerThumbSeekBar.g(this.oyH.oyG).bbc();
                    RecyclerThumbSeekBar.d(this.oyH.oyG, bbc.getDurationMs());
                    RecyclerThumbSeekBar.g(this.oyH.oyG).a(bbc);
                    i = 1;
                } catch (Throwable e) {
                    x.printErrStackTrace("RecyclerThumbSeekBar", e, "Try to init fetcher error : %s", e.getMessage());
                    i = 0;
                }
                if (i == 0) {
                    RecyclerThumbSeekBar.h(this.oyH.oyG);
                    return;
                }
                if (RecyclerThumbSeekBar.i(this.oyH.oyG) >= 10000) {
                    RecyclerThumbSeekBar.a(this.oyH.oyG, 1000);
                } else if (RecyclerThumbSeekBar.i(this.oyH.oyG) > 0) {
                    RecyclerThumbSeekBar.a(this.oyH.oyG, RecyclerThumbSeekBar.i(this.oyH.oyG) / 10);
                } else {
                    x.e("RecyclerThumbSeekBar", "RecyclerThumbSeekBar duration invalid %d", Integer.valueOf(RecyclerThumbSeekBar.i(this.oyH.oyG)));
                    RecyclerThumbSeekBar.h(this.oyH.oyG);
                    return;
                }
                x.d("RecyclerThumbSeekBar", "duration %d interval %d", Integer.valueOf(RecyclerThumbSeekBar.i(this.oyH.oyG)), Integer.valueOf(RecyclerThumbSeekBar.b(this.oyH.oyG)));
                RecyclerThumbSeekBar.j(this.oyH.oyG);
            }
        }, "check duration of ");
    }
}
