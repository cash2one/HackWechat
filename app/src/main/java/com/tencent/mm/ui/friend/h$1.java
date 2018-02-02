package com.tencent.mm.ui.friend;

import com.tencent.mm.modelfriend.o;
import com.tencent.mm.ui.base.h$d;
import java.util.ArrayList;

class h$1 implements h$d {
    final /* synthetic */ ArrayList ykW;
    final /* synthetic */ h zdz;

    h$1(h hVar, ArrayList arrayList) {
        this.zdz = hVar;
        this.ykW = arrayList;
    }

    public final void cn(int i, int i2) {
        if (i2 != -1) {
            this.zdz.ZP(((o) this.ykW.get(i2)).field_googlegmail);
        }
    }
}
