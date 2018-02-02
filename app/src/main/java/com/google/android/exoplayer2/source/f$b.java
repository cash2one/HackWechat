package com.google.android.exoplayer2.source;

public final class f$b {
    public static final f$b arR = new f$b(-1, -1, -1);
    public final int arS;
    public final int arT;
    public final int arU;

    public f$b(int i) {
        this(i, -1, -1);
    }

    public f$b(int i, int i2, int i3) {
        this.arS = i;
        this.arT = i2;
        this.arU = i3;
    }

    public final f$b cA(int i) {
        return this.arS == i ? this : new f$b(i, this.arT, this.arU);
    }

    public final boolean kf() {
        return this.arT != -1;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        f$b com_google_android_exoplayer2_source_f_b = (f$b) obj;
        if (this.arS == com_google_android_exoplayer2_source_f_b.arS && this.arT == com_google_android_exoplayer2_source_f_b.arT && this.arU == com_google_android_exoplayer2_source_f_b.arU) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.arS + 527) * 31) + this.arT) * 31) + this.arU;
    }
}
