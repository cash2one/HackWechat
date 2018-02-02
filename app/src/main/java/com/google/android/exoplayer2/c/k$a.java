package com.google.android.exoplayer2.c;

import java.util.Arrays;

public final class k$a {
    public final int ahS;
    public final int ahT;
    public final int aiQ;
    public final byte[] aiR;

    public k$a(int i, byte[] bArr, int i2, int i3) {
        this.aiQ = i;
        this.aiR = bArr;
        this.ahS = i2;
        this.ahT = i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        k$a com_google_android_exoplayer2_c_k_a = (k$a) obj;
        if (this.aiQ == com_google_android_exoplayer2_c_k_a.aiQ && this.ahS == com_google_android_exoplayer2_c_k_a.ahS && this.ahT == com_google_android_exoplayer2_c_k_a.ahT && Arrays.equals(this.aiR, com_google_android_exoplayer2_c_k_a.aiR)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (((((this.aiQ * 31) + Arrays.hashCode(this.aiR)) * 31) + this.ahS) * 31) + this.ahT;
    }
}
