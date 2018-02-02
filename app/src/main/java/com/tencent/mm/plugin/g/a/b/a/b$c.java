package com.tencent.mm.plugin.g.a.b.a;

import com.tencent.mm.sdk.platformtools.x;

public class b$c {
    public int kyN = 0;
    public int kyO = 0;
    public int kyP = 0;
    public int kyQ = 0;
    public int kyR = 0;
    public int kyS = 0;

    public final boolean H(byte[] bArr, int i) {
        String by = b.by();
        String str = "data size = %d, offset = %d, lenght = %d";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(7);
        x.d(by, str, objArr);
        if (bArr == null || i < 0 || bArr.length < i + 7) {
            x.e(b.by(), "data input error");
            return false;
        }
        this.kyN = (bArr[i] & 255) + ((bArr[i + 1] & 255) << 8);
        this.kyO = bArr[i + 2] & 255;
        this.kyP = bArr[i + 3] & 255;
        this.kyQ = bArr[i + 4] & 255;
        this.kyR = bArr[i + 5] & 255;
        this.kyS = bArr[i + 6] & 255;
        x.d(b.by(), "year = %d, month = %d, day = %d, hours = %d, minutes = %d, seconds = %d", new Object[]{Integer.valueOf(this.kyN), Integer.valueOf(this.kyO), Integer.valueOf(this.kyP), Integer.valueOf(this.kyQ), Integer.valueOf(this.kyR), Integer.valueOf(this.kyS)});
        return true;
    }
}
