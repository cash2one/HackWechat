package com.google.android.exoplayer2.a;

import android.media.AudioAttributes;

public final class b {
    public static final b aft;
    public final int afu;
    public final int afv;
    AudioAttributes afw;
    public final int flags;

    static {
        a aVar = new a();
        aft = new b(aVar.afu, aVar.flags, aVar.afv);
    }

    private b(int i, int i2, int i3) {
        this.afu = i;
        this.flags = i2;
        this.afv = i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (this.afu == bVar.afu && this.flags == bVar.flags && this.afv == bVar.afv) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.afu + 527) * 31) + this.flags) * 31) + this.afv;
    }
}
