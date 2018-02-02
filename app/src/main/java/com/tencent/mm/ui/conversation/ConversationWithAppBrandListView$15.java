package com.tencent.mm.ui.conversation;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;

class ConversationWithAppBrandListView$15 implements OnItemLongClickListener {
    final /* synthetic */ ConversationWithAppBrandListView yYl;
    final /* synthetic */ OnItemLongClickListener yYr;

    ConversationWithAppBrandListView$15(ConversationWithAppBrandListView conversationWithAppBrandListView, OnItemLongClickListener onItemLongClickListener) {
        this.yYl = conversationWithAppBrandListView;
        this.yYr = onItemLongClickListener;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if ((i == 0 && ConversationWithAppBrandListView.b(this.yYl)) || this.yYr == null) {
            return false;
        }
        return this.yYr.onItemLongClick(adapterView, view, i, j);
    }
}
