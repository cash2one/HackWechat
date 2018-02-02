package com.tencent.mm.ui.conversation;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.conversation.AppBrandServiceConversationUI.AppBrandServiceConversationFmUI;

class AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$10 implements OnItemLongClickListener {
    final /* synthetic */ AppBrandServiceConversationFmUI yVG;

    AppBrandServiceConversationUI$AppBrandServiceConversationFmUI$10(AppBrandServiceConversationFmUI appBrandServiceConversationFmUI) {
        this.yVG = appBrandServiceConversationFmUI;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        AppBrandServiceConversationFmUI.access$402(this.yVG, (ae) AppBrandServiceConversationFmUI.access$100(this.yVG).getItem(i));
        AppBrandServiceConversationFmUI.access$502(this.yVG, AppBrandServiceConversationFmUI.access$400(this.yVG).field_username);
        AppBrandServiceConversationFmUI.access$700(this.yVG).a(view, i, j, this.yVG, this.yVG);
        return true;
    }
}
