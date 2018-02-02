package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.profile.a.c;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.conversation.EnterpriseConversationUI.a;
import com.tencent.mm.z.ar;

class EnterpriseConversationUI$a$6 implements OnClickListener {
    final /* synthetic */ String gIx;
    final /* synthetic */ Context val$context;
    final /* synthetic */ a yZh;

    EnterpriseConversationUI$a$6(a aVar, String str, Context context) {
        this.yZh = aVar;
        this.gIx = str;
        this.val$context = context;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        k cVar = new c(this.gIx, true);
        ar.CG().a(1394, this.yZh);
        ar.CG().a(cVar, 0);
        a aVar = this.yZh;
        Context context = this.val$context;
        this.val$context.getString(R.l.dGO);
        a.a(aVar, h.a(context, this.val$context.getString(R.l.dHc), true, new 1(this, cVar)));
    }
}
