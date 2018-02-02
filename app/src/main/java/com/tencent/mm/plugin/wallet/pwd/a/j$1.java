package com.tencent.mm.plugin.wallet.pwd.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.wallet_core.ui.e;

class j$1 implements OnClickListener {
    final /* synthetic */ Context val$context;

    public j$1(Context context) {
        this.val$context = context;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        e.l(this.val$context, o.bLm().bMn().field_find_passwd_url, false);
        if (this.val$context instanceof Activity) {
            ((Activity) this.val$context).finish();
        }
    }
}
