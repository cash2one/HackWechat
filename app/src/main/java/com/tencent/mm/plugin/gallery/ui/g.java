package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.p;

public final class g extends LinearLayoutManager {
    public g(Context context) {
    }

    public final void a(RecyclerView recyclerView, int i) {
        p 1 = new 1(this, recyclerView.getContext());
        1.Vv = i;
        a(1);
    }
}
