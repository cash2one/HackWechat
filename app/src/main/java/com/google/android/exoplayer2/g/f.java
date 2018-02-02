package com.google.android.exoplayer2.g;

import java.util.Arrays;

public final class f {
    public final e[] aAu;
    private int aen;
    public final int length;

    public f(e... eVarArr) {
        this.aAu = eVarArr;
        this.length = eVarArr.length;
    }

    public final e[] lk() {
        return (e[]) this.aAu.clone();
    }

    public final int hashCode() {
        if (this.aen == 0) {
            this.aen = Arrays.hashCode(this.aAu) + 527;
        }
        return this.aen;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.aAu, ((f) obj).aAu);
    }
}
