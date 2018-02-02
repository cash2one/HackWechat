package com.tencent.mm.vending.app;

import com.tencent.mm.vending.base.a;

class a$1 extends a<Object> {
    final /* synthetic */ a zBa;

    a$1(a aVar) {
        this.zBa = aVar;
    }

    protected final /* synthetic */ Object resolveAsynchronous(Object obj) {
        return L((Class) obj);
    }

    protected final Object L(Class<?> cls) {
        a$a com_tencent_mm_vending_app_a_a = (a$a) this.zBa.zAT.get(cls);
        if (com_tencent_mm_vending_app_a_a != null) {
            com_tencent_mm_vending_app_a_a.zBc = true;
            Object WN = com_tencent_mm_vending_app_a_a.WN();
            com_tencent_mm_vending_app_a_a.zBc = false;
            if (!com_tencent_mm_vending_app_a_a.zBb) {
                return WN;
            }
            com_tencent_mm_vending_app_a_a.zBd = defer(cls);
        }
        return null;
    }
}
