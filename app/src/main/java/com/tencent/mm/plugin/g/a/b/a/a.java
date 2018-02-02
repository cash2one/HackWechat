package com.tencent.mm.plugin.g.a.b.a;

import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.sdk.platformtools.x;
import java.io.Serializable;

public abstract class a implements Serializable {
    private static final String TAG = a.class.getName();
    public long kxJ;
    public String kyq;
    public int kyr;

    public abstract byte[] ars();

    public static a ad(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            x.e(TAG, "data input error");
            return null;
        }
        Object as = b.as(bArr);
        if (as != null && (as instanceof a)) {
            return (a) as;
        }
        x.e(TAG, "bytes2object is not instanceof BaseProfileParser");
        return null;
    }
}
