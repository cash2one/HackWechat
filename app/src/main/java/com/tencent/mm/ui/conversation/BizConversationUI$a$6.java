package com.tencent.mm.ui.conversation;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ui.conversation.BizConversationUI.a;

class BizConversationUI$a$6 implements OnCancelListener {
    final /* synthetic */ a yWk;

    BizConversationUI$a$6(a aVar) {
        this.yWk = aVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        a.k(this.yWk);
    }
}
