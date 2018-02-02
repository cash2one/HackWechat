package com.tencent.mm.ui.conversation;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.conversation.BizConversationUI.a;

class BizConversationUI$a$2 implements OnItemLongClickListener {
    final /* synthetic */ a yWk;

    BizConversationUI$a$2(a aVar) {
        this.yWk = aVar;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        a.a(this.yWk, (ae) a.e(this.yWk).getItem(i));
        a.a(this.yWk, a.f(this.yWk).field_username);
        a.j(this.yWk).a(view, i, j, this.yWk, a.g(this.yWk), a.h(this.yWk), a.i(this.yWk));
        return true;
    }
}
