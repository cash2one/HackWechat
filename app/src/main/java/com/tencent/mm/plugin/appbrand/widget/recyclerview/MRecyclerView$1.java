package com.tencent.mm.plugin.appbrand.widget.recyclerview;

import android.support.v7.widget.RecyclerView.c;

class MRecyclerView$1 extends c {
    final /* synthetic */ MRecyclerView kgm;

    MRecyclerView$1(MRecyclerView mRecyclerView) {
        this.kgm = mRecyclerView;
    }

    public final void onChanged() {
        if (MRecyclerView.a(this.kgm) != null) {
            MRecyclerView.a(this.kgm).setVisibility(this.kgm.aoa() ? 0 : 8);
        }
    }
}
