package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.t$a.a;

public final class c extends a<c> {
    public int[] Aei;

    public final /* synthetic */ int compareTo(Object obj) {
        c cVar = (c) obj;
        int length = this.Aei.length;
        int length2 = cVar.Aei.length;
        if (length != length2) {
            return com.tencent.tinker.a.a.b.c.fI(length, length2);
        }
        for (length2 = 0; length2 < length; length2++) {
            if (this.Aei[length2] != cVar.Aei[length2]) {
                return com.tencent.tinker.a.a.b.c.fI(this.Aei[length2], cVar.Aei[length2]);
            }
        }
        return 0;
    }

    public c(int i, int[] iArr) {
        super(i);
        this.Aei = iArr;
    }
}
