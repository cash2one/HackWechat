package com.tencent.neattextview.textview.layout;

import android.text.Spanned;
import java.lang.reflect.Array;

public final class d<E> {
    private final Class<? extends E> zLh;
    public int zLi = 0;
    public E[] zLj;
    public int[] zLk;
    public int[] zLl;
    public int[] zLm;

    d(Class<? extends E> cls) {
        this.zLh = cls;
    }

    public final void a(Spanned spanned, int i) {
        if (r3 > 0 && (this.zLj == null || this.zLj.length < r3)) {
            this.zLj = (Object[]) Array.newInstance(this.zLh, r3);
            this.zLk = new int[r3];
            this.zLl = new int[r3];
            this.zLm = new int[r3];
        }
        this.zLi = 0;
        for (Object obj : spanned.getSpans(0, i, this.zLh)) {
            int spanStart = spanned.getSpanStart(obj);
            int spanEnd = spanned.getSpanEnd(obj);
            if (spanStart != spanEnd) {
                int spanFlags = spanned.getSpanFlags(obj);
                this.zLj[this.zLi] = obj;
                this.zLk[this.zLi] = spanStart;
                this.zLl[this.zLi] = spanEnd;
                this.zLm[this.zLi] = spanFlags;
                this.zLi++;
            }
        }
    }

    public final E fz(int i, int i2) {
        int i3 = 0;
        while (i3 < this.zLi) {
            if (this.zLk[i3] < i2 && this.zLl[i3] > i) {
                return this.zLj[i3];
            }
            i3++;
        }
        return null;
    }

    public final boolean[] fA(int i, int i2) {
        boolean[] zArr = new boolean[this.zLi];
        int i3 = 0;
        while (i3 < this.zLi) {
            if (this.zLk[i3] < i2 && this.zLl[i3] > i) {
                zArr[i3] = true;
            }
            i3++;
        }
        return zArr;
    }

    public final E fB(int i, int i2) {
        int i3 = 0;
        while (i3 < this.zLi) {
            if (this.zLk[i3] == i && this.zLl[i3] == i2) {
                return this.zLj[i3];
            }
            i3++;
        }
        return null;
    }
}
