package com.tencent.mm.plugin.mmsight.segment;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.k;

class RecyclerThumbSeekBar$5 extends k {
    final /* synthetic */ RecyclerThumbSeekBar oyG;

    RecyclerThumbSeekBar$5(RecyclerThumbSeekBar recyclerThumbSeekBar) {
        this.oyG = recyclerThumbSeekBar;
    }

    public final void e(RecyclerView recyclerView, int i) {
        if (i == 0 && RecyclerThumbSeekBar.o(this.oyG) != null) {
            RecyclerThumbSeekBar.o(this.oyG).A(this.oyG.baZ(), this.oyG.bba());
        }
    }
}
