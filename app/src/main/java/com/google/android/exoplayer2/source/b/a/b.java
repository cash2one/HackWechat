package com.google.android.exoplayer2.source.b.a;

import java.util.Collections;
import java.util.List;

public final class b extends c {
    public final long aes;
    public final long asL;
    public final int auF;
    public final long auG;
    public final boolean auH;
    public final int auI;
    public final int auJ;
    public final long auK;
    public final boolean auL;
    public final boolean auM;
    public final boolean auN;
    public final a auO;
    public final List<a> auP;
    public final int version;

    public b(int i, String str, List<String> list, long j, long j2, boolean z, int i2, int i3, int i4, long j3, boolean z2, boolean z3, boolean z4, a aVar, List<a> list2) {
        super(str, list);
        this.auF = i;
        this.asL = j2;
        this.auH = z;
        this.auI = i2;
        this.auJ = i3;
        this.version = i4;
        this.auK = j3;
        this.auL = z2;
        this.auM = z3;
        this.auN = z4;
        this.auO = aVar;
        this.auP = Collections.unmodifiableList(list2);
        if (list2.isEmpty()) {
            this.aes = 0;
        } else {
            a aVar2 = (a) list2.get(list2.size() - 1);
            this.aes = aVar2.aes + aVar2.auR;
        }
        if (j == -9223372036854775807L) {
            j = -9223372036854775807L;
        } else if (j < 0) {
            j += this.aes;
        }
        this.auG = j;
    }

    public final long kF() {
        return this.asL + this.aes;
    }
}
