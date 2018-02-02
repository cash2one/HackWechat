package com.tencent.mm.ui;

import com.tencent.mm.ui.h.15;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class h$15$1 implements Runnable {
    final /* synthetic */ 15 xFD;

    h$15$1(15 15) {
        this.xFD = 15;
    }

    public final void run() {
        ar.Hg();
        c.CU().set(68377, "");
        if (h.a(this.xFD.xFs) != null) {
            h.a(this.xFD.xFs).notifyDataSetChanged();
        }
    }
}
