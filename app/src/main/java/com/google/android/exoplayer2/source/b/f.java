package com.google.android.exoplayer2.source.b;

import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.b;
import com.google.android.exoplayer2.c.c.c;
import com.google.android.exoplayer2.c.c.t;
import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.h.i;
import com.google.android.exoplayer2.i.g;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.i.q;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.metadata.id3.a;
import com.google.android.exoplayer2.source.a.d;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

final class f extends d {
    private static final AtomicInteger att = new AtomicInteger();
    private final q alA;
    private final boolean ami;
    private volatile boolean asO;
    private final com.google.android.exoplayer2.c.d atA;
    final boolean atB;
    private final boolean atC;
    private final boolean atD;
    private final a atE;
    private final j atF;
    private com.google.android.exoplayer2.c.d atG;
    private int atH;
    private int atI;
    private boolean atJ;
    j atK;
    volatile boolean atL;
    private final List<Format> atc;
    public final int atu;
    public final com.google.android.exoplayer2.source.b.a.a.a atv;
    private final com.google.android.exoplayer2.h.f atw;
    private final i atx;
    private final boolean aty;
    private final String atz;
    public final int uid;

    public f(com.google.android.exoplayer2.h.f fVar, i iVar, i iVar2, com.google.android.exoplayer2.source.b.a.a.a aVar, List<Format> list, int i, Object obj, long j, long j2, int i2, int i3, boolean z, q qVar, f fVar2, byte[] bArr, byte[] bArr2) {
        com.google.android.exoplayer2.h.f fVar3;
        if (bArr == null || bArr2 == null) {
            fVar3 = fVar;
        } else {
            fVar3 = new a(fVar, bArr, bArr2);
        }
        super(fVar3, iVar, aVar.aeo, i, obj, j, j2, i2);
        this.atu = i3;
        this.atx = iVar2;
        this.atv = aVar;
        this.atc = list;
        this.aty = z;
        this.alA = qVar;
        this.ami = this.aiB instanceof a;
        this.atz = iVar.uri.getLastPathSegment();
        boolean z2 = this.atz.endsWith(".aac") || this.atz.endsWith(".ac3") || this.atz.endsWith(".ec3") || this.atz.endsWith(".mp3");
        this.atD = z2;
        if (fVar2 != null) {
            this.atE = fVar2.atE;
            this.atF = fVar2.atF;
            this.atA = fVar2.atG;
            this.atB = fVar2.atv != aVar;
            z2 = fVar2.atu != i3 || this.atB;
            this.atC = z2;
        } else {
            this.atE = this.atD ? new a() : null;
            this.atF = this.atD ? new j(10) : null;
            this.atA = null;
            this.atB = false;
            this.atC = true;
        }
        this.atw = fVar;
        this.uid = att.getAndIncrement();
    }

    public final long kp() {
        return (long) this.atI;
    }

    public final void kq() {
        this.asO = true;
    }

    public final boolean kr() {
        return this.asO;
    }

    public final void ks() {
        com.google.android.exoplayer2.c.d lVar;
        boolean z;
        int i;
        i N;
        e bVar;
        Object obj = null;
        int i2 = 0;
        if (this.atG == null && !this.atD) {
            int i3;
            if ("text/vtt".equals(this.atv.aeo.adV) || this.atz.endsWith(".webvtt") || this.atz.endsWith(".vtt")) {
                lVar = new l(this.asI.ael, this.alA);
                i3 = true;
            } else if (!this.atC) {
                lVar = this.atA;
                i3 = 0;
            } else if (this.atz.endsWith(".mp4") || this.atz.startsWith(".m4", this.atz.length() - 4)) {
                r1 = new com.google.android.exoplayer2.c.b.d(0, this.alA);
                z = true;
            } else {
                i = 16;
                List list = this.atc;
                if (list != null) {
                    i = 48;
                } else {
                    list = Collections.emptyList();
                }
                String str = this.asI.adS;
                if (!TextUtils.isEmpty(str)) {
                    Object ac;
                    String ac2;
                    String str2 = "audio/mp4a-latm";
                    if (str != null) {
                        for (String ac22 : str.split(",")) {
                            ac = g.ac(ac22);
                            if (ac != null && g.Z(ac)) {
                                break;
                            }
                        }
                    }
                    ac = null;
                    if (!str2.equals(ac)) {
                        i |= 2;
                    }
                    str2 = "video/avc";
                    if (str != null) {
                        for (String ac222 : str.split(",")) {
                            ac222 = g.ac(ac222);
                            if (ac222 != null && g.aa(ac222)) {
                                obj = ac222;
                                break;
                            }
                        }
                    }
                    if (!str2.equals(obj)) {
                        i |= 4;
                    }
                }
                z = true;
                r1 = new t(2, this.alA, new com.google.android.exoplayer2.c.c.e(i, list));
            }
            if (i3 != 0) {
                lVar.a(this.atK);
            }
            this.atG = lVar;
        }
        if (!(this.atA == this.atG || this.atJ || this.atx == null)) {
            N = this.atx.N((long) this.atH);
            try {
                bVar = new b(this.atw, N.aAK, this.atw.a(N));
                i = 0;
                while (i == 0) {
                    if (!this.asO) {
                        i = this.atG.a(bVar);
                    }
                }
                this.atH = (int) (bVar.getPosition() - this.atx.aAK);
                com.google.android.exoplayer2.i.t.a(this.aiB);
                this.atJ = true;
            } catch (Throwable th) {
                com.google.android.exoplayer2.i.t.a(this.aiB);
            }
        }
        if (!this.asO) {
            boolean z2;
            if (this.ami) {
                i iVar = this.asH;
                if (this.atI != 0) {
                    z = true;
                } else {
                    z = false;
                }
                z2 = z;
                N = iVar;
            } else {
                z2 = false;
                N = this.asH.N((long) this.atI);
            }
            if (!this.aty) {
                this.alA.lR();
            } else if (this.alA.amG == Long.MAX_VALUE) {
                this.alA.P(this.asL);
            }
            try {
                bVar = new b(this.aiB, N.aAK, this.aiB.a(N));
                if (this.atG == null) {
                    long readLong;
                    bVar.js();
                    if (bVar.b(this.atF.data, 0, 10, true)) {
                        this.atF.reset(10);
                        if (this.atF.lG() == a.amF) {
                            this.atF.cV(3);
                            i = this.atF.lH();
                            int i4 = i + 10;
                            if (i4 > this.atF.capacity()) {
                                obj = this.atF.data;
                                this.atF.reset(i4);
                                System.arraycopy(obj, 0, this.atF.data, 0, 10);
                            }
                            if (bVar.b(this.atF.data, 10, i, true)) {
                                Metadata b = this.atE.b(this.atF.data, i);
                                if (b != null) {
                                    for (Entry entry : b.aqo) {
                                        if (entry instanceof PrivFrame) {
                                            PrivFrame privFrame = (PrivFrame) entry;
                                            if ("com.apple.streaming.transportStreamTimestamp".equals(privFrame.aqS)) {
                                                System.arraycopy(privFrame.aqT, 0, this.atF.data, 0, 8);
                                                this.atF.reset(8);
                                                readLong = this.atF.readLong();
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    readLong = -9223372036854775807L;
                    readLong = readLong != -9223372036854775807L ? this.alA.Q(readLong) : this.asL;
                    if (this.atz.endsWith(".aac")) {
                        lVar = new c(readLong);
                    } else if (this.atz.endsWith(".ac3") || this.atz.endsWith(".ec3")) {
                        lVar = new com.google.android.exoplayer2.c.c.a(readLong);
                    } else if (this.atz.endsWith(".mp3")) {
                        lVar = new com.google.android.exoplayer2.c.a.b(0, readLong);
                    } else {
                        throw new IllegalArgumentException("Unknown extension for audio file: " + this.atz);
                    }
                    lVar.a(this.atK);
                    this.atG = lVar;
                }
                if (z2) {
                    bVar.cf(this.atI);
                }
                while (i2 == 0) {
                    if (this.asO) {
                        break;
                    }
                    i2 = this.atG.a(bVar);
                }
                this.atI = (int) (bVar.getPosition() - this.asH.aAK);
                com.google.android.exoplayer2.i.t.a(this.aiB);
                this.atL = true;
            } catch (Throwable th2) {
                com.google.android.exoplayer2.i.t.a(this.aiB);
            }
        }
    }
}
