package com.tencent.mm.plugin.g.a.b.a;

import android.annotation.TargetApi;
import com.tencent.mm.plugin.g.a.b.h;
import com.tencent.mm.sdk.platformtools.x;

@TargetApi(18)
public class f extends a {
    static final String TAG = f.class.getName();
    public static String kzv = h.kxY;
    public static String kzw = h.kxZ;
    public long kzA;
    public long kzB;
    public int kzx;
    public int kzy;
    public int kzz;

    public f() {
        this.kyq = null;
        this.kyr = 8;
        this.kxJ = 1;
        this.kzx = -1;
        this.kzy = -1;
        this.kzz = -1;
        this.kzA = 0;
        this.kzB = 0;
    }

    public final byte[] ars() {
        if (this.kzx < 0) {
            x.e(TAG, "stepCount is invalid");
            return null;
        }
        int i;
        if (this.kzy >= 0) {
            i = 7;
        } else {
            i = 4;
        }
        if (this.kzz >= 0) {
            i += 3;
        }
        byte[] bArr = new byte[i];
        bArr[0] = (byte) 1;
        i = 1;
        int i2 = 0;
        while (i2 < 3) {
            bArr[i] = (byte) ((this.kzx >> (i2 * 8)) & 255);
            i2++;
            i++;
        }
        if (this.kzy >= 0) {
            bArr[0] = (byte) (bArr[0] | 2);
            i2 = 0;
            while (i2 < 3) {
                bArr[i] = (byte) ((this.kzy >> (i2 * 8)) & 255);
                i2++;
                i++;
            }
        }
        if (this.kzz >= 0) {
            bArr[0] = (byte) 4;
            int i3 = i;
            for (i = 0; i < 3; i++) {
                bArr[i3] = (byte) ((this.kzz >> (i * 8)) & 255);
                i3++;
            }
        }
        return bArr;
    }
}
