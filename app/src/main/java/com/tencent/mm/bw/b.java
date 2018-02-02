package com.tencent.mm.bw;

import android.util.SparseArray;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.InputStream;

public final class b {
    public byte[] kwG;
    public SparseArray<a> xbx;

    static class a {
        public final int[] xbA;
        public final int xby;
        public final int[] xbz;

        public a(int i, int[] iArr, int[] iArr2) {
            this.xby = i;
            this.xbz = iArr;
            this.xbA = iArr2;
        }
    }

    private b(SparseArray<a> sparseArray, byte[] bArr) {
        this.xbx = sparseArray;
        this.kwG = bArr;
    }

    public static b a(SparseArray<a> sparseArray, InputStream inputStream, int i) {
        try {
            byte[] bArr = new byte[i];
            if (inputStream.read(bArr, 0, bArr.length) != bArr.length) {
                x.e("MicroMsg.language.PluralsCollection", "[cpan] newPluralsConllection failed. data length no equal.");
            }
            return new b(sparseArray, bArr);
        } catch (Throwable e) {
            x.e("MicroMsg.language.PluralsCollection", "[cpan] newPluralsConllection failed:%s", bh.i(e));
            return null;
        }
    }

    public final String getQuantityString(int i, int i2, Object... objArr) {
        Throwable e;
        String str;
        try {
            int indexOfKey = this.xbx.indexOfKey(i);
            if (indexOfKey < 0) {
                return null;
            }
            a aVar = (a) this.xbx.valueAt(indexOfKey);
            int length = aVar.xbz.length;
            int i3 = 0;
            int i4 = 0;
            while (i3 < length) {
                int i5;
                if (aVar.xbz[i3] == i2) {
                    i5 = i3;
                } else {
                    i5 = i4;
                }
                i3++;
                i4 = i5;
            }
            if (indexOfKey <= this.xbx.size() - 1) {
                if (i4 >= length - 1) {
                    str = new String(this.kwG, aVar.xbA[i4], ((a) this.xbx.valueAt(indexOfKey + 1)).xbA[0] - aVar.xbA[i4]);
                } else {
                    str = new String(this.kwG, aVar.xbA[i4], aVar.xbA[i4 + 1] - aVar.xbA[i4]);
                }
            } else if (i4 >= length - 1) {
                str = new String(this.kwG, aVar.xbA[i4], this.kwG.length - aVar.xbA[i4]);
            } else {
                str = new String(this.kwG, aVar.xbA[i4], aVar.xbA[i4 + 1] - aVar.xbA[i4]);
            }
            try {
                if (bh.ov(str) || objArr != null) {
                    return String.format(str, objArr);
                }
                return str;
            } catch (Exception e2) {
                e = e2;
                x.e("MicroMsg.language.PluralsCollection", "[cpan] getString failed. %s", bh.i(e));
                return str;
            }
        } catch (Throwable e3) {
            e = e3;
            str = null;
            x.e("MicroMsg.language.PluralsCollection", "[cpan] getString failed. %s", bh.i(e));
            return str;
        }
    }
}
