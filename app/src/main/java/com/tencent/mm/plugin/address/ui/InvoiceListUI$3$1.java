package com.tencent.mm.plugin.address.ui;

import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.address.model.a;
import com.tencent.mm.plugin.address.ui.InvoiceListUI.3;
import com.tencent.mm.plugin.o.a.b;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.z.ar;

class InvoiceListUI$3$1 implements c {
    final /* synthetic */ 3 int;
    final /* synthetic */ int kI;

    InvoiceListUI$3$1(3 3, int i) {
        this.int = 3;
        this.kI = i;
    }

    public final void jl(int i) {
        b bVar;
        synchronized (this.int.ins.lockObj) {
            if (this.kI < this.int.ins.inp.size()) {
                bVar = (b) this.int.ins.inp.get(this.kI);
            } else {
                bVar = null;
            }
        }
        if (bVar != null) {
            switch (i) {
                case 0:
                    this.int.ins.jk(bVar.nBI);
                    return;
                case 1:
                    k aVar = new a(bVar.nBI);
                    this.int.ins.ink = null;
                    ar.CG().a(aVar, 0);
                    return;
                case 2:
                    InvoiceListUI.b(this.int.ins, bVar);
                    return;
                default:
                    return;
            }
        }
    }
}
