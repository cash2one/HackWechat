package com.tencent.mm.plugin.appbrand.widget.recyclerview;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.c;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView.a;

class LoadMoreRecyclerView$2 extends c {
    final /* synthetic */ LinearLayoutManager kgh;
    final /* synthetic */ LoadMoreRecyclerView kgi;

    LoadMoreRecyclerView$2(LoadMoreRecyclerView loadMoreRecyclerView, LinearLayoutManager linearLayoutManager) {
        this.kgi = loadMoreRecyclerView;
        this.kgh = linearLayoutManager;
    }

    public final void aa(int i, int i2) {
        super.aa(i, i2);
        if (this.kgi.kgf && this.kgh.fa() == this.kgi.kgj.getItemCount() - 1 && LoadMoreRecyclerView.a(this.kgi) != null) {
            a a = LoadMoreRecyclerView.a(this.kgi);
            RecyclerView.a aVar = this.kgi.kgj.TU;
            a.akW();
        }
    }
}
