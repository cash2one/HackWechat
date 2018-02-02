package com.tencent.mm.vending.base;

import com.tencent.mm.vending.base.Vending.i;
import com.tencent.mm.vending.f.a;

class Vending$7 implements a<_Index> {
    final /* synthetic */ Vending zBp;

    Vending$7(Vending vending) {
        this.zBp = vending;
    }

    public final void ck(_Index _Index) {
        i lock = this.zBp.getLock(_Index);
        boolean access$1100 = Vending.access$1100(this.zBp, lock, _Index);
        if (lock.zBb) {
            a.d("Vending", "This lock is defer to return %s %s", new Object[]{lock, _Index});
        } else if (!access$1100) {
            Vending.access$1300(this.zBp, lock);
        }
    }

    public final void cancel() {
        this.zBp.loaderClear();
        Vending.access$200(this.zBp);
    }
}
