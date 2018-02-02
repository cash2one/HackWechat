package com.tencent.mm.plugin.mmsight.segment;

import android.support.v7.widget.RecyclerView.t;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

class RecyclerThumbSeekBar$e extends t {
    ImageView fvf;
    final /* synthetic */ RecyclerThumbSeekBar oyG;

    RecyclerThumbSeekBar$e(RecyclerThumbSeekBar recyclerThumbSeekBar, View view, int i) {
        this.oyG = recyclerThumbSeekBar;
        super(view);
        if (i == 0) {
            this.fvf = (ImageView) ((LinearLayout) view).getChildAt(0);
        }
    }
}
