package com.tencent.mm.compatible.loader;

public final class b<E> {
    static final Object wg = new Object();
    int hX;
    boolean wh;
    long[] wi;
    Object[] wj;

    public final void put(long j, E e) {
        int b = b(this.wi, this.hX, j);
        if (b >= 0) {
            this.wj[b] = e;
            return;
        }
        b ^= -1;
        if (b >= this.hX || this.wj[b] != wg) {
            int i;
            if (this.wh && this.hX >= this.wi.length) {
                int i2 = this.hX;
                long[] jArr = this.wi;
                Object[] objArr = this.wj;
                b = 0;
                for (i = 0; i < i2; i++) {
                    Object obj = objArr[i];
                    if (obj != wg) {
                        if (i != b) {
                            jArr[b] = jArr[i];
                            objArr[b] = obj;
                        }
                        b++;
                    }
                }
                this.wh = false;
                this.hX = b;
                b = b(this.wi, this.hX, j) ^ -1;
            }
            if (this.hX >= this.wi.length) {
                i = a.Y(this.hX + 1);
                Object obj2 = new long[i];
                Object obj3 = new Object[i];
                System.arraycopy(this.wi, 0, obj2, 0, this.wi.length);
                System.arraycopy(this.wj, 0, obj3, 0, this.wj.length);
                this.wi = obj2;
                this.wj = obj3;
            }
            if (this.hX - b != 0) {
                System.arraycopy(this.wi, b, this.wi, b + 1, this.hX - b);
                System.arraycopy(this.wj, b, this.wj, b + 1, this.hX - b);
            }
            this.wi[b] = j;
            this.wj[b] = e;
            this.hX++;
            return;
        }
        this.wi[b] = j;
        this.wj[b] = e;
    }

    static int b(long[] jArr, int i, long j) {
        int i2 = -1;
        int i3 = i + 0;
        while (i3 - i2 > 1) {
            int i4 = (i3 + i2) / 2;
            if (jArr[i4] < j) {
                i2 = i4;
            } else {
                i3 = i4;
            }
        }
        if (i3 == i + 0) {
            return (i + 0) ^ -1;
        }
        return jArr[i3] != j ? i3 ^ -1 : i3;
    }
}
