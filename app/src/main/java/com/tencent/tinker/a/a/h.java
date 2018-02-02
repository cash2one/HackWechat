package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.t.a.a;

public final class h extends a<h> {
    public int AeP;
    public int[] AeQ;
    public byte[] AeR;

    public final /* synthetic */ int compareTo(Object obj) {
        h hVar = (h) obj;
        int i = this.AeP;
        int i2 = hVar.AeP;
        if (i != i2) {
            return i - i2;
        }
        int[] iArr = this.AeQ;
        int[] iArr2 = hVar.AeQ;
        int length = iArr.length;
        i = iArr2.length;
        if (length < i) {
            i = -1;
        } else if (length > i) {
            i = 1;
        } else {
            for (i2 = 0; i2 < length; i2++) {
                i = c.fI(iArr[i2], iArr2[i2]);
                if (i != 0) {
                    break;
                }
            }
            i = 0;
        }
        return i == 0 ? c.m(this.AeR, hVar.AeR) : i;
    }

    public h(int i, int i2, int[] iArr, byte[] bArr) {
        super(i);
        this.AeP = i2;
        this.AeQ = iArr;
        this.AeR = bArr;
    }
}
