package com.tencent.mm.plugin.mmsight.segment;

import com.tencent.mm.plugin.mmsight.segment.c.b;
import com.tencent.mm.plugin.mmsight.segment.n.a;

class RecyclerThumbSeekBar$6 implements a {
    final /* synthetic */ RecyclerThumbSeekBar oyG;

    RecyclerThumbSeekBar$6(RecyclerThumbSeekBar recyclerThumbSeekBar) {
        this.oyG = recyclerThumbSeekBar;
    }

    public final void bbm() {
        if (RecyclerThumbSeekBar.o(this.oyG) != null && RecyclerThumbSeekBar.l(this.oyG) != null) {
            b o = RecyclerThumbSeekBar.o(this.oyG);
            this.oyG.baZ();
            this.oyG.bba();
            o.bbb();
        }
    }

    public final void bbn() {
        if (RecyclerThumbSeekBar.o(this.oyG) != null && RecyclerThumbSeekBar.l(this.oyG) != null) {
            RecyclerThumbSeekBar.o(this.oyG).B(this.oyG.baZ(), this.oyG.bba());
        }
    }

    public final void gG(boolean z) {
        if (!(RecyclerThumbSeekBar.o(this.oyG) == null || RecyclerThumbSeekBar.l(this.oyG) == null)) {
            RecyclerThumbSeekBar.o(this.oyG).C(this.oyG.baZ(), this.oyG.bba());
        }
        if (z) {
            RecyclerThumbSeekBar.l(this.oyG).o(true, RecyclerThumbSeekBar.k(this.oyG).bbo());
        } else {
            RecyclerThumbSeekBar.l(this.oyG).o(false, RecyclerThumbSeekBar.k(this.oyG).getWidth() - RecyclerThumbSeekBar.k(this.oyG).bbp());
        }
    }
}
