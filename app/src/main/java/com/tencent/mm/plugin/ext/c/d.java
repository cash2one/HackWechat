package com.tencent.mm.plugin.ext.c;

import android.graphics.Rect;
import android.util.SparseArray;
import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.x;

public final class d {
    private static SparseArray<byte[]> mbj = new SparseArray(1);

    interface c {
        b ak(String str, boolean z);
    }

    static /* synthetic */ b c(byte[] bArr, boolean z) {
        String str = null;
        if (bArr == null || bArr.length <= 14) {
            x.w("MicroMsg.ExtQbarYuvRetrieverFactory", "hy: invalid yuv handle file!!");
            return null;
        }
        Object obj;
        if (z) {
            str = g.s(bArr);
        }
        Object obj2 = new byte[4];
        System.arraycopy(bArr, 0, obj2, 0, 4);
        Object obj3 = new byte[4];
        System.arraycopy(bArr, 4, obj3, 0, 4);
        Object obj4 = new byte[4];
        System.arraycopy(bArr, 8, obj4, 0, 4);
        Object obj5 = new byte[4];
        System.arraycopy(bArr, 12, obj5, 0, 4);
        Object obj6 = new byte[4];
        System.arraycopy(bArr, 16, obj6, 0, 4);
        Object obj7 = new byte[4];
        System.arraycopy(bArr, 20, obj7, 0, 4);
        Object obj8 = new byte[4];
        System.arraycopy(bArr, 24, obj8, 0, 4);
        int length = bArr.length - 28;
        Object obj9 = (byte[]) mbj.get(length);
        if (obj9 == null) {
            obj = new byte[length];
            mbj.put(length, obj);
        } else {
            obj = obj9;
        }
        System.arraycopy(bArr, 28, obj, 0, length);
        int at = at(obj2);
        int at2 = at(obj3);
        length = at(obj4);
        int at3 = at(obj5);
        x.i("MicroMsg.ExtQbarYuvRetrieverFactory", "hy: retrieved result: %s", new Object[]{new b(obj, at, at2, at(obj8), new Rect(length, at3, at(obj6) + length, at(obj7) + at3), str)});
        return new b(obj, at, at2, at(obj8), new Rect(length, at3, at(obj6) + length, at(obj7) + at3), str);
    }

    static c aFW() {
        return new a();
    }

    private static int at(byte[] bArr) {
        return (((bArr[3] & 255) | ((bArr[2] & 255) << 8)) | ((bArr[1] & 255) << 16)) | ((bArr[0] & 255) << 24);
    }
}
