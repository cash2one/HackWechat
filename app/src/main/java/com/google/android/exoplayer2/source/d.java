package com.google.android.exoplayer2.source;

public final class d implements j {
    private final j[] arQ;

    public d(j[] jVarArr) {
        this.arQ = jVarArr;
    }

    public final long ka() {
        long j = Long.MAX_VALUE;
        for (j ka : this.arQ) {
            long ka2 = ka.ka();
            if (ka2 != Long.MIN_VALUE) {
                j = Math.min(j, ka2);
            }
        }
        return j == Long.MAX_VALUE ? Long.MIN_VALUE : j;
    }

    public final long kb() {
        long j = Long.MAX_VALUE;
        for (j kb : this.arQ) {
            long kb2 = kb.kb();
            if (kb2 != Long.MIN_VALUE) {
                j = Math.min(j, kb2);
            }
        }
        return j == Long.MAX_VALUE ? Long.MIN_VALUE : j;
    }

    public final boolean C(long j) {
        boolean z = false;
        int i;
        do {
            long kb = kb();
            if (kb == Long.MIN_VALUE) {
                break;
            }
            i = 0;
            for (j jVar : this.arQ) {
                if (jVar.kb() == kb) {
                    i |= jVar.C(j);
                }
            }
            z |= i;
        } while (i != 0);
        return z;
    }
}
