package com.tencent.mm.ui.contact;

import android.os.Process;
import com.tencent.mm.ui.contact.AddressUI.a;

class AddressUI$a$10 implements Runnable {
    final /* synthetic */ a yQF;

    AddressUI$a$10(a aVar) {
        this.yQF = aVar;
    }

    public final void run() {
        Process.setThreadPriority(10);
        a.n(this.yQF);
    }
}
