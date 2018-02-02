package com.tencent.mm.plugin.favorite.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.g.a.cf;

class a$1 implements OnClickListener {
    final /* synthetic */ cf mqX;

    public a$1(cf cfVar) {
        this.mqX = cfVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (i == -2) {
            a.a(this.mqX);
        }
    }
}
