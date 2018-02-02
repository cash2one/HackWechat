package com.tencent.mm.bw;

import android.util.SparseArray;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.InputStream;

public final class d {
    public byte[] kwG;
    public SparseArray<a> xbC;

    static class a {
        public final int mPo;
        public final int[] xbD;

        public a(int i, int[] iArr) {
            this.mPo = i;
            this.xbD = iArr;
        }
    }

    private d(SparseArray<a> sparseArray, byte[] bArr) {
        this.xbC = sparseArray;
        this.kwG = bArr;
    }

    public static d b(SparseArray<a> sparseArray, InputStream inputStream, int i) {
        try {
            byte[] bArr = new byte[i];
            if (inputStream.read(bArr, 0, bArr.length) != bArr.length) {
                x.e("MicroMsg.language.StringArraysCollection", "[cpan] newPluralsConllection failed. data length no equal.");
            }
            return new d(sparseArray, bArr);
        } catch (Throwable e) {
            x.e("MicroMsg.language.StringArraysCollection", "[cpan] newPluralsConllection failed:%s", bh.i(e));
            return null;
        }
    }
}
