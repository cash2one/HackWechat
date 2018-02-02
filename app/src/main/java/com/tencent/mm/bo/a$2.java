package com.tencent.mm.bo;

import com.tencent.mm.d.b;
import java.util.Comparator;

class a$2 implements Comparator<b> {
    final /* synthetic */ a vAf;

    a$2(a aVar) {
        this.vAf = aVar;
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return ((b) obj).uG().value - ((b) obj2).uG().value;
    }
}
