package com.google.android.exoplayer2.c.b;

import com.google.android.exoplayer2.c.k$a;
import com.google.android.exoplayer2.i.a;

public final class f {
    public final boolean ami;
    public final String amj;
    public final k$a amk;
    public final int aml;
    public final byte[] amm;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public f(boolean z, String str, int i, byte[] bArr, int i2, int i3, byte[] bArr2) {
        int i4 = 0;
        int i5 = 1;
        a.am((bArr2 == null ? 1 : 0) ^ (i == 0 ? 1 : 0));
        this.ami = z;
        this.amj = str;
        this.aml = i;
        this.amm = bArr2;
        if (str != null) {
            switch (str.hashCode()) {
                case 3046605:
                    if (str.equals("cbc1")) {
                        i4 = 2;
                        break;
                    }
                case 3046671:
                    if (str.equals("cbcs")) {
                        i4 = 3;
                        break;
                    }
                case 3049879:
                    if (str.equals("cenc")) {
                        break;
                    }
                case 3049895:
                    if (str.equals("cens")) {
                        i4 = 1;
                        break;
                    }
                default:
                    i4 = -1;
                    break;
            }
            switch (i4) {
                case 0:
                case 1:
                    break;
                case 2:
                case 3:
                    i5 = 2;
                    break;
                default:
                    new StringBuilder("Unsupported protection scheme type '").append(str).append("'. Assuming AES-CTR crypto mode.");
                    break;
            }
        }
        this.amk = new k$a(i5, bArr, i2, i3);
    }
}
