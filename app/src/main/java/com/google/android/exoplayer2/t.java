package com.google.android.exoplayer2;

public final class t {
    public static final t aey = new t(0);
    public final int aez;

    public t(int i) {
        this.aez = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (this.aez != ((t) obj).aez) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.aez;
    }
}
