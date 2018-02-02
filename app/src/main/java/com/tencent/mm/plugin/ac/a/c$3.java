package com.tencent.mm.plugin.ac.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.ac.a.c.a;

class c$3 implements OnClickListener {
    final /* synthetic */ Intent gHX;
    final /* synthetic */ a pvg;

    c$3(a aVar, Intent intent) {
        this.pvg = aVar;
        this.gHX = intent;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        d.b(this.pvg.getContext(), "freewifi", ".ui.FreeWifiEntryUI", this.gHX);
        this.pvg.hs(false);
    }
}
