package com.tencent.mm.ui.conversation;

import android.database.DataSetObserver;
import android.widget.ListAdapter;
import com.tencent.mm.sdk.platformtools.x;

class ConversationWithAppBrandListView$1 extends DataSetObserver {
    int yYj = -1;
    final /* synthetic */ ListAdapter yYk;
    final /* synthetic */ ConversationWithAppBrandListView yYl;

    ConversationWithAppBrandListView$1(ConversationWithAppBrandListView conversationWithAppBrandListView, ListAdapter listAdapter) {
        this.yYl = conversationWithAppBrandListView;
        this.yYk = listAdapter;
    }

    public final void onChanged() {
        if (this.yYj != this.yYk.getCount()) {
            String str = "MicroMsg.ConversationWithAppBrandListView";
            String str2 = "[onChanged] isDelete:%s";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(this.yYj > this.yYk.getCount());
            x.i(str, str2, objArr);
            if (this.yYj > this.yYk.getCount()) {
                ConversationWithAppBrandListView.a(this.yYl, false);
                ConversationWithAppBrandListView.a(this.yYl, true);
            } else {
                ConversationWithAppBrandListView.a(this.yYl);
            }
        }
        this.yYj = this.yYk.getCount();
    }
}
