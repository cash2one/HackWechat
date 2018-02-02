package com.tencent.mm.plugin.translate;

import android.util.SparseArray;
import com.tencent.mm.plugin.translate.a.c.a;
import com.tencent.mm.plugin.translate.a.c.c;

class a$1 implements a {
    final /* synthetic */ a sfW;

    a$1(a aVar) {
        this.sfW = aVar;
    }

    public final void a(int i, SparseArray<c> sparseArray) {
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            c cVar = (c) sparseArray.valueAt(i2);
            if (cVar != null) {
                this.sfW.sfS.c(new 1(this, i, cVar));
            }
        }
    }
}
