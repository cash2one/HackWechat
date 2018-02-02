package com.tencent.mm.plugin.appbrand.widget.recyclerview;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.k;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView.a;

class LoadMoreRecyclerView$1 extends k {
    int kgg = 0;
    final /* synthetic */ LinearLayoutManager kgh;
    final /* synthetic */ LoadMoreRecyclerView kgi;

    LoadMoreRecyclerView$1(LoadMoreRecyclerView loadMoreRecyclerView, LinearLayoutManager linearLayoutManager) {
        this.kgi = loadMoreRecyclerView;
        this.kgh = linearLayoutManager;
    }

    public final void e(RecyclerView recyclerView, int i) {
        super.e(recyclerView, i);
        if (i == 0 && this.kgi.kgf && this.kgg == this.kgi.kgj.getItemCount() - 1 && LoadMoreRecyclerView.a(this.kgi) != null) {
            a a = LoadMoreRecyclerView.a(this.kgi);
            RecyclerView.a aVar = this.kgi.kgj.TU;
            a.akW();
        }
    }

    public final void c(RecyclerView recyclerView, int i, int i2) {
        super.c(recyclerView, i, i2);
        this.kgg = this.kgh.fa();
    }
}
