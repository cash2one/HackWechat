package com.tencent.mm.ui.applet;

import android.widget.Toast;
import com.tencent.mm.ca.d.b;
import com.tencent.mm.ui.applet.d.a;

class d$a$1 implements b {
    final /* synthetic */ a xWC;

    d$a$1(a aVar) {
        this.xWC = aVar;
    }

    public final void cls() {
        this.xWC.fD(this.xWC.context);
        Toast.makeText(this.xWC.context, "trace file has saved ", 0).show();
    }
}
