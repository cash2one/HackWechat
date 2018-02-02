package com.tencent.d.b.f;

import com.tencent.d.a.c.c;
import com.tencent.d.a.c.d;
import com.tencent.d.b.b.a;
import com.tencent.d.b.d.b;
import com.tencent.d.b.e.e;

public final class j extends c {
    e AdN = null;
    private boolean AdO = false;

    public j(e eVar, boolean z) {
        this.AdN = eVar;
        this.AdO = z;
    }

    final boolean cGg() {
        if (!a.cFX().isInit()) {
            c.w("Soter.TaskPrepareAppSecureKey", "soter: not initialized yet", new Object[0]);
            b(new com.tencent.d.b.a.c(14));
            return true;
        } else if (!a.cFX().cFW()) {
            c.w("Soter.TaskPrepareAppSecureKey", "soter: not support soter", new Object[0]);
            b(new com.tencent.d.b.a.c(2));
            return true;
        } else if (!com.tencent.d.a.a.cFM() || this.AdO) {
            if (this.AdN == null) {
                c.w("Soter.TaskPrepareAppSecureKey", "soter: it is strongly recommended that you provide a net wrapper to check and upload ASK validation from server! Please make sure you upload it later", new Object[0]);
            }
            return false;
        } else {
            c.i("Soter.TaskPrepareAppSecureKey", "soter: already has ask. do not need generate again", new Object[0]);
            b(new com.tencent.d.b.a.c(com.tencent.d.a.a.cFN()));
            return true;
        }
    }

    final void cGh() {
        c.w("Soter.TaskPrepareAppSecureKey", "soter: cancelled prepare ask", new Object[0]);
        com.tencent.d.a.a.cFK();
    }

    final void execute() {
        dI(d.cFS().Acm, 1);
        b.a aVar = new b.a();
        boolean z = this.AdO;
        aVar.AcI |= 1;
        aVar.AcK = z;
        aVar.AcM = new 1(this);
        aVar.cGe().cGd();
    }
}
