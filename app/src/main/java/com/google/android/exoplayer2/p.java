package com.google.android.exoplayer2;

public final class p {
    public static final p aev = new p(1.0f, 1.0f);
    public final float aew;
    public final int aex;
    public final float pitch;

    public p(float f, float f2) {
        this.aew = f;
        this.pitch = f2;
        this.aex = Math.round(1000.0f * f);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        p pVar = (p) obj;
        if (this.aew == pVar.aew && this.pitch == pVar.pitch) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return ((Float.floatToRawIntBits(this.aew) + 527) * 31) + Float.floatToRawIntBits(this.pitch);
    }
}
