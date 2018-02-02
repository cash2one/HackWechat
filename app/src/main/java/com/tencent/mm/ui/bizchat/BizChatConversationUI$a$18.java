package com.tencent.mm.ui.bizchat;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.ui.bizchat.BizChatConversationUI.a;

class BizChatConversationUI$a$18 implements OnItemClickListener {
    final /* synthetic */ a ynJ;

    BizChatConversationUI$a$18(a aVar) {
        this.ynJ = aVar;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        a.b(this.ynJ, ((com.tencent.mm.ag.a.a) a.b(this.ynJ).getItem(i)).field_bizChatId);
    }
}
