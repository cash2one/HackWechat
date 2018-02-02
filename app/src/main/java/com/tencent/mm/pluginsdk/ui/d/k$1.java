package com.tencent.mm.pluginsdk.ui.d;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import com.tencent.mm.bm.d;
import com.tencent.mm.ui.base.h.c;

class k$1 implements c {
    final /* synthetic */ Context val$context;
    final /* synthetic */ OnDismissListener vuJ;
    final /* synthetic */ String vuK;

    k$1(OnDismissListener onDismissListener, String str, Context context) {
        this.vuJ = onDismissListener;
        this.vuK = str;
        this.val$context = context;
    }

    public final void jl(int i) {
        if (this.vuJ != null) {
            this.vuJ.onDismiss(null);
        }
        String replace = this.vuK.replace(" ", "").replace("#", "@");
        switch (i) {
            case 0:
                Context context = this.val$context;
                Intent intent = new Intent();
                intent.putExtra("composeType", 4);
                String substring = replace.substring(0, replace.indexOf(64));
                intent.putExtra("toList", new String[]{substring + " " + replace});
                d.b(context, "qqmail", ".ui.ComposeUI", intent);
                return;
            case 1:
                k.bd(this.val$context, replace);
                return;
            default:
                return;
        }
    }
}
