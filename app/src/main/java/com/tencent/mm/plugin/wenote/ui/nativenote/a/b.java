package com.tencent.mm.plugin.wenote.ui.nativenote.a;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.k;

public abstract class b extends k {
    private int tXQ;

    public abstract void bXL();

    public abstract void bXM();

    public abstract void bXN();

    public final void c(RecyclerView recyclerView, int i, int i2) {
        if ((Math.abs(i2) > this.tXQ ? 1 : 0) != 0 && recyclerView.canScrollVertically(-1)) {
            if (!recyclerView.canScrollVertically(1)) {
                bXN();
            } else if (i2 < 0) {
                bXL();
            } else if (i2 > 0) {
                bXM();
            }
        }
    }
}
