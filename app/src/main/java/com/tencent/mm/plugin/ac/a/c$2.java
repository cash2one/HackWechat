package com.tencent.mm.plugin.ac.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.plugin.ac.a.c.a;

class c$2 implements OnClickListener {
    final /* synthetic */ a pvg;
    final /* synthetic */ Intent pvh;

    c$2(a aVar, Intent intent) {
        this.pvg = aVar;
        this.pvh = intent;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.pvg.getContext().startActivity(this.pvh);
    }
}
