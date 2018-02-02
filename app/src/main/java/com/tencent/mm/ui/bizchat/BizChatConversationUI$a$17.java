package com.tencent.mm.ui.bizchat;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.ui.bizchat.BizChatConversationUI.a;
import com.tencent.mm.ui.widget.i;

class BizChatConversationUI$a$17 implements OnItemLongClickListener {
    final /* synthetic */ i pnU;
    final /* synthetic */ a ynJ;

    BizChatConversationUI$a$17(a aVar, i iVar) {
        this.ynJ = aVar;
        this.pnU = iVar;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.pnU.a(view, i, j, this.ynJ, a.e(this.ynJ), a.f(this.ynJ), a.g(this.ynJ));
        return true;
    }
}
