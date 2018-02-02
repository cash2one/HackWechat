package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.i.a;
import java.util.Arrays;

public final class l {
    private int aen;
    public final Format[] arZ;
    public final int length;

    public l(Format... formatArr) {
        a.an(formatArr.length > 0);
        this.arZ = formatArr;
        this.length = formatArr.length;
    }

    public final int j(Format format) {
        for (int i = 0; i < this.arZ.length; i++) {
            if (format == this.arZ[i]) {
                return i;
            }
        }
        return -1;
    }

    public final int hashCode() {
        if (this.aen == 0) {
            this.aen = Arrays.hashCode(this.arZ) + 527;
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
        l lVar = (l) obj;
        if (this.length == lVar.length && Arrays.equals(this.arZ, lVar.arZ)) {
            return true;
        }
        return false;
    }
}
