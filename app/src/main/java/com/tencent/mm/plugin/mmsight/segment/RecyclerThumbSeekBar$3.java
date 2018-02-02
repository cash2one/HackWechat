package com.tencent.mm.plugin.mmsight.segment;

import com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar.c;
import com.tencent.mm.plugin.mmsight.segment.n.1;
import com.tencent.mm.sdk.platformtools.x;

class RecyclerThumbSeekBar$3 implements Runnable {
    final /* synthetic */ RecyclerThumbSeekBar oyG;

    RecyclerThumbSeekBar$3(RecyclerThumbSeekBar recyclerThumbSeekBar) {
        this.oyG = recyclerThumbSeekBar;
    }

    public final void run() {
        try {
            RecyclerThumbSeekBar.k(this.oyG).am(-1.0f);
            RecyclerThumbSeekBar.a(this.oyG, new c(this.oyG, (byte) 0));
            int e = RecyclerThumbSeekBar.e(this.oyG, 10000);
            int e2 = RecyclerThumbSeekBar.e(this.oyG, 1000);
            RecyclerThumbSeekBar.f(this.oyG, (this.oyG.getWidth() - e) / 2);
            n k = RecyclerThumbSeekBar.k(this.oyG);
            k.post(new 1(k, e, RecyclerThumbSeekBar.f(this.oyG), e2));
            x.i("RecyclerThumbSeekBar", "RecyclerThumbSeekBar.run(212) width %d", Integer.valueOf(this.oyG.getWidth()));
            RecyclerThumbSeekBar.l(this.oyG).oyM = (this.oyG.getWidth() - RecyclerThumbSeekBar.f(this.oyG)) - e;
            RecyclerThumbSeekBar.l(this.oyG).oyL = RecyclerThumbSeekBar.f(this.oyG);
            RecyclerThumbSeekBar.m(this.oyG).a(RecyclerThumbSeekBar.l(this.oyG));
            x.d("RecyclerThumbSeekBar", "init segment thumb fetcher end, adapter.getItemCount() %d", Integer.valueOf(RecyclerThumbSeekBar.l(this.oyG).getItemCount()));
            if (RecyclerThumbSeekBar.n(this.oyG) != null) {
                RecyclerThumbSeekBar.n(this.oyG).gF(false);
            }
        } catch (Throwable e3) {
            x.printErrStackTrace("RecyclerThumbSeekBar", e3, "RecyclerThumbSeekBar notifySuccess error : %s", e3.getMessage());
            if (RecyclerThumbSeekBar.n(this.oyG) != null) {
                RecyclerThumbSeekBar.n(this.oyG).gF(true);
            }
        }
    }
}
