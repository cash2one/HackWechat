package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.o;
import com.tencent.tinker.a.a.t$a;
import com.tencent.tinker.c.a.b.a;
import com.tencent.tinker.c.a.c.c;
import java.util.Arrays;

public abstract class i<T extends Comparable<T>> {
    protected final com.tencent.tinker.a.a.i Agj;
    protected final a Agl;
    private final c Agm;

    protected abstract T a(com.tencent.tinker.a.a.a.a aVar);

    protected abstract t$a c(com.tencent.tinker.a.a.i iVar);

    protected abstract int e(T t);

    public i(a aVar, com.tencent.tinker.a.a.i iVar, c cVar) {
        this.Agl = aVar;
        this.Agj = iVar;
        this.Agm = cVar;
    }

    protected T a(com.tencent.tinker.c.a.c.a aVar, T t) {
        return t;
    }

    protected void a(c cVar, int i, int i2, int i3, int i4) {
    }

    protected void a(c cVar, int i, int i2) {
    }

    private int[] IC(int i) {
        int i2 = 0;
        int[] iArr = new int[i];
        int i3 = 0;
        while (i2 < i) {
            i3 += o.a(this.Agl.Ahi);
            iArr[i2] = i3;
            i2++;
        }
        return iArr;
    }

    private static int a(int i, T t) {
        if (t instanceof t$a.a) {
            return ((t$a.a) t).dzw;
        }
        return i;
    }

    public final void execute() {
        int i;
        com.tencent.tinker.a.a.a.a aVar;
        int[] IC = IC(o.b(this.Agl.Ahi));
        int[] IC2 = IC(o.b(this.Agl.Ahi));
        int[] IC3 = IC(o.b(this.Agl.Ahi));
        t$a c = c(this.Agj);
        if (c.exists()) {
            com.tencent.tinker.a.a.a.a a = this.Agj.a(c);
            i = c.size;
            aVar = a;
        } else {
            i = 0;
            aVar = null;
        }
        int length = IC.length;
        int length2 = IC2.length;
        int length3 = IC3.length;
        int i2 = (i + length2) - length;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (true) {
            if (i3 >= i && i4 >= i2) {
                break;
            } else if (i6 < length2 && IC2[i6] == i4) {
                e(a(this.Agl.Ahi));
                i4++;
                i6++;
            } else if (i5 < length3 && IC3[i5] == i4) {
                e(a(this.Agl.Ahi));
                i4++;
                i5++;
            } else if (Arrays.binarySearch(IC, i3) >= 0) {
                a(this.Agm, i3, a(i3, a(aVar)));
                i3++;
                i7++;
            } else if (Arrays.binarySearch(IC3, i3) >= 0) {
                a(this.Agm, i3, a(i3, a(aVar)));
                i3++;
            } else if (i3 < i) {
                Comparable a2 = a(this.Agm, a(aVar));
                int e = e(a2);
                a(this.Agm, i3, a(i3, a2), i4, e);
                i3++;
                i4++;
            }
        }
        if (i6 != length2 || i7 != length || i5 != length3) {
            throw new IllegalStateException(String.format("bad patch operation sequence. addCounter: %d, addCount: %d, delCounter: %d, delCount: %d, replaceCounter: %d, replaceCount:%d", new Object[]{Integer.valueOf(i6), Integer.valueOf(length2), Integer.valueOf(i7), Integer.valueOf(length), Integer.valueOf(i5), Integer.valueOf(length3)}));
        }
    }
}
