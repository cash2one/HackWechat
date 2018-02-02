package com.tencent.mm.ui.chatting.b;

import android.view.View;
import android.view.View.OnClickListener;

class z$1 implements OnClickListener {
    final /* synthetic */ Boolean yCf;
    final /* synthetic */ z yCg;

    z$1(z zVar, Boolean bool) {
        this.yCg = zVar;
        this.yCf = bool;
    }

    public final void onClick(View view) {
        if (this.yCf.booleanValue()) {
            this.yCg.c(Boolean.valueOf(true), Boolean.valueOf(true));
            this.yCg.fhr.csB().cbn();
            return;
        }
        this.yCg.c(Boolean.valueOf(true), Boolean.valueOf(false));
        this.yCg.fhr.csB().aa(2, true);
    }
}
