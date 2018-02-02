package com.tencent.mm.ui.conversation;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.conversation.EnterpriseConversationUI.a;

class EnterpriseConversationUI$a$5 implements OnItemLongClickListener {
    final /* synthetic */ a yZh;

    EnterpriseConversationUI$a$5(a aVar) {
        this.yZh = aVar;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        a.c(this.yZh, ((ae) a.f(this.yZh).getItem(i)).field_username);
        a.i(this.yZh).a(view, i, j, this.yZh, a.h(this.yZh));
        return true;
    }
}
