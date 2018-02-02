package com.tencent.mm.ui.conversation;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.k;
import android.view.View;
import com.tencent.mm.plugin.appbrand.widget.recentview.b;

class ConversationWithAppBrandListView$3 extends k {
    LinearLayoutManager riL = ((LinearLayoutManager) ConversationWithAppBrandListView.c(this.yYl).TV);
    int toQ = 0;
    final /* synthetic */ ConversationWithAppBrandListView yYl;

    ConversationWithAppBrandListView$3(ConversationWithAppBrandListView conversationWithAppBrandListView) {
        this.yYl = conversationWithAppBrandListView;
    }

    public final void c(RecyclerView recyclerView, int i, int i2) {
        super.c(recyclerView, i, i2);
        LinearLayoutManager linearLayoutManager = this.riL;
        View a = linearLayoutManager.a(0, linearLayoutManager.getChildCount(), true, false);
        int bd = a == null ? -1 : LinearLayoutManager.bd(a);
        if (!(ConversationWithAppBrandListView.e(this.yYl) == null || bd / 4 == this.toQ || recyclerView.getChildCount() <= 4)) {
            b e = ConversationWithAppBrandListView.e(this.yYl);
            e.kfi++;
        }
        this.toQ = bd / 4;
    }
}
