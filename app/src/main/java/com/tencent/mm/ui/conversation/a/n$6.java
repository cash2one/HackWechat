package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bm.d;

class n$6 implements OnClickListener {
    final /* synthetic */ Intent val$intent;
    final /* synthetic */ n zby;

    n$6(n nVar, Intent intent) {
        this.zby = nVar;
        this.val$intent = intent;
    }

    public final void onClick(View view) {
        d.b((Context) this.zby.voC.get(), "webwx", ".ui.WebWXLogoutUI", this.val$intent);
    }
}
