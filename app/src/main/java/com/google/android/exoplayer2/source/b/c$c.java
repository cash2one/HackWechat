package com.google.android.exoplayer2.source.b;

import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.g.a;
import com.google.android.exoplayer2.source.l;

final class c$c extends a {
    private int atq;

    public c$c(l lVar, int[] iArr) {
        int i = 0;
        super(lVar, iArr);
        Format format = lVar.arZ[0];
        while (i < this.length) {
            if (this.arZ[i] == format) {
                break;
            }
            i++;
        }
        i = -1;
        this.atq = i;
    }

    public final void ku() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (g(this.atq, elapsedRealtime)) {
            int i = this.length - 1;
            while (i >= 0) {
                if (g(i, elapsedRealtime)) {
                    i--;
                } else {
                    this.atq = i;
                    return;
                }
            }
            throw new IllegalStateException();
        }
    }

    public final int kv() {
        return this.atq;
    }

    public final int kw() {
        return 0;
    }

    public final Object kx() {
        return null;
    }
}
