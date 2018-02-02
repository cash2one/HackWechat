package com.tencent.mm.ui.conversation;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class ConversationWithAppBrandListView$14 implements OnItemClickListener {
    final /* synthetic */ ConversationWithAppBrandListView yYl;
    final /* synthetic */ OnItemClickListener yYq;

    ConversationWithAppBrandListView$14(ConversationWithAppBrandListView conversationWithAppBrandListView, OnItemClickListener onItemClickListener) {
        this.yYl = conversationWithAppBrandListView;
        this.yYq = onItemClickListener;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.yYq != null) {
            this.yYq.onItemClick(adapterView, view, i, j);
        }
        if (ConversationWithAppBrandListView.b(this.yYl) && this.yYl.getFirstVisiblePosition() == 0) {
            this.yYl.z(500, 8);
        }
    }
}
