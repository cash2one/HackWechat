package com.tencent.mm.plugin.profile.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ag.d;

class c$1 implements OnClickListener {
    final /* synthetic */ d fhj;
    final /* synthetic */ c piX;

    c$1(c cVar, d dVar) {
        this.piX = cVar;
        this.fhj = dVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.fhj.field_hadAlert = 1;
        this.fhj.field_brandFlag |= 4;
        this.piX.a(this.fhj, true);
    }
}
