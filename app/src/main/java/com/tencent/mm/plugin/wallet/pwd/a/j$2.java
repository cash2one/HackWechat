package com.tencent.mm.plugin.wallet.pwd.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class j$2 implements OnClickListener {
    final /* synthetic */ boolean sGA = true;
    final /* synthetic */ Context val$context;

    public j$2(boolean z, Context context) {
        this.val$context = context;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.sGA && (this.val$context instanceof Activity)) {
            ((Activity) this.val$context).finish();
        }
    }
}
