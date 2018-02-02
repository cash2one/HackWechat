package com.google.android.gms.c;

import java.util.Arrays;

final class bg {
    final byte[] bal;
    final int tag;

    bg(int i, byte[] bArr) {
        this.tag = i;
        this.bal = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof bg)) {
            return false;
        }
        bg bgVar = (bg) obj;
        return this.tag == bgVar.tag && Arrays.equals(this.bal, bgVar.bal);
    }

    public final int hashCode() {
        return ((this.tag + 527) * 31) + Arrays.hashCode(this.bal);
    }
}
