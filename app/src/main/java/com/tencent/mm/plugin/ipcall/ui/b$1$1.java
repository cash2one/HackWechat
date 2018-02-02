package com.tencent.mm.plugin.ipcall.ui;

import com.tencent.mm.plugin.ipcall.a.g.c;
import com.tencent.mm.plugin.ipcall.ui.b.1;

class b$1$1 implements Runnable {
    final /* synthetic */ 1 nHA;
    final /* synthetic */ c nHz;

    b$1$1(1 1, c cVar) {
        this.nHA = 1;
        this.nHz = cVar;
    }

    public final void run() {
        if (this.nHz == null || this.nHz.xjy == -1) {
            this.nHA.nHy.iiQ.setText("");
        } else {
            this.nHA.nHy.iiQ.setText(this.nHz.field_systemAddressBookUsername);
        }
    }
}
