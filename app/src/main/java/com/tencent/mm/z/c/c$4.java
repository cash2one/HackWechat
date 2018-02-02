package com.tencent.mm.z.c;

import com.tencent.mm.plugin.auth.a.a;
import com.tencent.mm.protocal.i;
import com.tencent.mm.protocal.i.f;
import com.tencent.mm.protocal.i.g;
import com.tencent.mm.protocal.y.b;

class c$4 implements a {
    final /* synthetic */ c hiE;

    c$4(c cVar) {
        this.hiE = cVar;
    }

    public final void a(f fVar, g gVar, boolean z) {
        if (z) {
            if (fVar != null && (fVar instanceof i.a) && fVar.vBj == 12) {
                b.IA();
            }
        } else if (fVar != null && fVar.vBj == 16) {
            b.IA();
        }
    }

    public final void a(b bVar, String str, int i, String str2, String str3, int i2) {
    }
}
