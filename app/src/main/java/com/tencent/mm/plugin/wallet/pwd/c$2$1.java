package com.tencent.mm.plugin.wallet.pwd;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.wallet.pwd.c.2;

class c$2$1 implements OnClickListener {
    final /* synthetic */ 2 sGt;

    c$2$1(2 2) {
        this.sGt = 2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        c.c(this.sGt.sGs).putInt("RESET_PWD_USER_ACTION", 2);
        this.sGt.sGs.a(this.sGt.zHU, 0, c.d(this.sGt.sGs));
    }
}
