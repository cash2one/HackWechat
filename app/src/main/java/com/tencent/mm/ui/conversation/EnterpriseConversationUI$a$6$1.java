package com.tencent.mm.ui.conversation;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.profile.a.c;
import com.tencent.mm.ui.conversation.EnterpriseConversationUI.a.6;
import com.tencent.mm.z.ar;

class EnterpriseConversationUI$a$6$1 implements OnCancelListener {
    final /* synthetic */ c kGw;
    final /* synthetic */ 6 yZi;

    EnterpriseConversationUI$a$6$1(6 6, c cVar) {
        this.yZi = 6;
        this.kGw = cVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.kGw);
        ar.CG().b(1394, this.yZi.yZh);
    }
}
