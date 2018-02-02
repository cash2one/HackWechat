package com.google.android.exoplayer2.source;

import java.util.Arrays;

public final class m {
    public static final m asF = new m(new l[0]);
    private int aen;
    public final l[] asG;
    public final int length;

    public m(l... lVarArr) {
        this.asG = lVarArr;
        this.length = lVarArr.length;
    }

    public final int a(l lVar) {
        for (int i = 0; i < this.length; i++) {
            if (this.asG[i] == lVar) {
                return i;
            }
        }
        return -1;
    }

    public final int hashCode() {
        if (this.aen == 0) {
            this.aen = Arrays.hashCode(this.asG);
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
        m mVar = (m) obj;
        if (this.length == mVar.length && Arrays.equals(this.asG, mVar.asG)) {
            return true;
        }
        return false;
    }
}
