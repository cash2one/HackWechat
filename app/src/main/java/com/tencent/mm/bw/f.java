package com.tencent.mm.bw;

import android.util.SparseIntArray;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.InputStream;

public final class f {
    SparseIntArray xbN;
    byte[] xbO;

    private f(SparseIntArray sparseIntArray, byte[] bArr) {
        this.xbN = sparseIntArray;
        this.xbO = bArr;
    }

    public static f a(SparseIntArray sparseIntArray, InputStream inputStream, int i) {
        byte[] bArr = new byte[i];
        try {
            if (inputStream.read(bArr, 0, bArr.length) != bArr.length) {
                x.e("MicroMsg.language.StringsCollection", "[cpan] newStringsCollection failed. data length no equal.");
            }
            return new f(sparseIntArray, bArr);
        } catch (Throwable e) {
            x.e("MicroMsg.language.StringsCollection", "[cpan] newStringsCollection failed. %s", bh.i(e));
            return null;
        }
    }

    public final String getString(int i) {
        String str;
        try {
            int indexOfKey = this.xbN.indexOfKey(i);
            if (indexOfKey < 0) {
                return null;
            }
            int valueAt;
            int valueAt2 = this.xbN.valueAt(indexOfKey);
            if (indexOfKey < this.xbN.size() - 1) {
                valueAt = this.xbN.valueAt(indexOfKey + 1) - valueAt2;
            } else {
                valueAt = this.xbO.length - valueAt2;
            }
            str = new String(this.xbO, valueAt2, valueAt, "UTF-8");
            return str;
        } catch (Throwable e) {
            x.e("MicroMsg.language.StringsCollection", "[cpan] getString failed. %s", bh.i(e));
            str = null;
        } catch (Throwable e2) {
            x.e("MicroMsg.language.StringsCollection", "[cpan] getString failed. %s", bh.i(e2));
            str = null;
        }
    }
}
