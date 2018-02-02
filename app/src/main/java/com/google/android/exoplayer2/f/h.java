package com.google.android.exoplayer2.f;

import com.google.android.exoplayer2.b.e;

public final class h extends e implements Comparable<h> {
    public long aej;

    public final /* synthetic */ int compareTo(Object obj) {
        h hVar = (h) obj;
        if (iY() != hVar.iY()) {
            return iY() ? 1 : -1;
        } else {
            long j = this.aig - hVar.aig;
            if (j == 0) {
                return 0;
            }
            return j <= 0 ? -1 : 1;
        }
    }

    public h() {
        super(1);
    }
}
