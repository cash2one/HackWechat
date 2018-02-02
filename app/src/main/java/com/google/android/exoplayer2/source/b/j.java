package com.google.android.exoplayer2.source.b;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.g.e;
import com.google.android.exoplayer2.h.i;
import com.google.android.exoplayer2.h.q;
import com.google.android.exoplayer2.h.r;
import com.google.android.exoplayer2.h.r.a;
import com.google.android.exoplayer2.h.r.c;
import com.google.android.exoplayer2.h.r.d;
import com.google.android.exoplayer2.i.s;
import com.google.android.exoplayer2.i.t;
import com.google.android.exoplayer2.source.g;
import com.google.android.exoplayer2.source.h;
import com.google.android.exoplayer2.source.h.b;
import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.source.m;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

final class j implements f, a<com.google.android.exoplayer2.source.a.a>, d, b, com.google.android.exoplayer2.source.j {
    m acV;
    final int ach;
    boolean adD;
    private final com.google.android.exoplayer2.h.b asj;
    private final int atN;
    final com.google.android.exoplayer2.source.a.a atO;
    private final a aua;
    final c aub;
    private final Format auc;
    final r aud = new r("Loader:HlsSampleStreamWrapper");
    private final c.b aue = new c.b();
    final LinkedList<f> auf = new LinkedList();
    private final Runnable aug = new Runnable(this) {
        final /* synthetic */ j auw;

        {
            this.auw = r1;
        }

        public final void run() {
            this.auw.kD();
        }
    };
    h[] auh = new h[0];
    private int[] aui = new int[0];
    boolean auj;
    int auk;
    Format aul;
    int aum;
    int aun;
    private boolean auo;
    boolean[] aup;
    private boolean[] auq;
    long aur;
    private long aus;
    boolean aut;
    boolean auu;
    boolean auv;
    final Handler handler = new Handler();
    boolean released;

    public final /* synthetic */ int a(c cVar, long j, long j2, IOException iOException) {
        com.google.android.exoplayer2.source.a.a aVar = (com.google.android.exoplayer2.source.a.a) cVar;
        boolean z = aVar instanceof f;
        Object obj = (!z || aVar.kp() == 0) ? 1 : null;
        boolean z2 = false;
        c cVar2 = this.aub;
        if (obj != null) {
            boolean z3;
            e eVar = cVar2.atk;
            int indexOf = cVar2.atk.indexOf(cVar2.atb.j(aVar.asI));
            if (com.google.android.exoplayer2.source.a.b.a(iOException)) {
                boolean f = eVar.f(indexOf, 60000);
                int i = ((q.e) iOException).responseCode;
                if (f) {
                    new StringBuilder("Blacklisted: duration=60000").append(", responseCode=").append(i).append(", format=").append(eVar.cN(indexOf));
                } else {
                    new StringBuilder("Blacklisting failed (cannot blacklist last enabled track): responseCode=").append(i).append(", format=").append(eVar.cN(indexOf));
                }
                z3 = f;
            } else {
                z3 = false;
            }
            if (z3) {
                obj = 1;
                if (obj != null) {
                    if (z) {
                        com.google.android.exoplayer2.i.a.an(((f) this.auf.removeLast()) != aVar);
                        if (this.auf.isEmpty()) {
                            this.aus = this.aur;
                        }
                    }
                    z2 = true;
                }
                this.atO.a(aVar.asH, aVar.type, this.ach, aVar.asI, aVar.asJ, aVar.asK, aVar.asL, aVar.asM, j, j2, aVar.kp(), iOException, z2);
                if (z2) {
                    return 0;
                }
                if (this.adD) {
                    C(this.aur);
                } else {
                    this.aua.a(this);
                }
                return 2;
            }
        }
        obj = null;
        if (obj != null) {
            if (z) {
                if (((f) this.auf.removeLast()) != aVar) {
                }
                com.google.android.exoplayer2.i.a.an(((f) this.auf.removeLast()) != aVar);
                if (this.auf.isEmpty()) {
                    this.aus = this.aur;
                }
            }
            z2 = true;
        }
        this.atO.a(aVar.asH, aVar.type, this.ach, aVar.asI, aVar.asJ, aVar.asK, aVar.asL, aVar.asM, j, j2, aVar.kp(), iOException, z2);
        if (z2) {
            return 0;
        }
        if (this.adD) {
            this.aua.a(this);
        } else {
            C(this.aur);
        }
        return 2;
    }

    public final /* synthetic */ void a(c cVar, long j, long j2) {
        com.google.android.exoplayer2.source.a.a aVar = (com.google.android.exoplayer2.source.a.a) cVar;
        c cVar2 = this.aub;
        if (aVar instanceof c.a) {
            c.a aVar2 = (c.a) aVar;
            cVar2.ate = aVar2.data;
            cVar2.a(aVar2.asH.uri, aVar2.atl, aVar2.atm);
        }
        this.atO.a(aVar.asH, aVar.type, this.ach, aVar.asI, aVar.asJ, aVar.asK, aVar.asL, aVar.asM, j, j2, aVar.kp());
        if (this.adD) {
            this.aua.a(this);
            return;
        }
        C(this.aur);
    }

    public final /* synthetic */ void a(c cVar, long j, long j2, boolean z) {
        com.google.android.exoplayer2.source.a.a aVar = (com.google.android.exoplayer2.source.a.a) cVar;
        this.atO.b(aVar.asH, aVar.type, this.ach, aVar.asI, aVar.asJ, aVar.asK, aVar.asL, aVar.asM, j, j2, aVar.kp());
        if (!z) {
            kC();
            if (this.auk > 0) {
                this.aua.a(this);
            }
        }
    }

    public final /* synthetic */ k ck(int i) {
        return cG(i);
    }

    public j(int i, a aVar, c cVar, com.google.android.exoplayer2.h.b bVar, long j, Format format, int i2, com.google.android.exoplayer2.source.a.a aVar2) {
        this.ach = i;
        this.aua = aVar;
        this.aub = cVar;
        this.asj = bVar;
        this.auc = format;
        this.atN = i2;
        this.atO = aVar2;
        this.aur = j;
        this.aus = j;
    }

    public final void kA() {
        if (!this.adD) {
            C(this.aur);
        }
    }

    public final boolean e(long j, boolean z) {
        this.aur = j;
        if (!(z || kE())) {
            boolean z2;
            int length = this.auh.length;
            int i = 0;
            while (i < length) {
                h hVar = this.auh[i];
                hVar.rewind();
                if (!hVar.d(j, false) && (this.auq[i] || !this.auo)) {
                    z2 = false;
                    break;
                }
                hVar.H(hVar.asl.kk());
                i++;
            }
            z2 = true;
            if (z2) {
                return false;
            }
        }
        this.aus = j;
        this.auv = false;
        this.auf.clear();
        if (this.aud.ic()) {
            this.aud.ly();
        } else {
            kC();
        }
        return true;
    }

    public final long ka() {
        if (this.auv) {
            return Long.MIN_VALUE;
        }
        if (kE()) {
            return this.aus;
        }
        long max;
        long j = this.aur;
        f fVar = (f) this.auf.getLast();
        if (!fVar.atL) {
            fVar = this.auf.size() > 1 ? (f) this.auf.get(this.auf.size() - 2) : null;
        }
        if (fVar != null) {
            max = Math.max(j, fVar.asM);
        } else {
            max = j;
        }
        h[] hVarArr = this.auh;
        int length = hVarArr.length;
        int i = 0;
        while (i < length) {
            long max2 = Math.max(max, hVarArr[i].asl.ki());
            i++;
            max = max2;
        }
        return max;
    }

    public final void kB() {
        kC();
    }

    public final void ai(boolean z) {
        this.aub.atd = z;
    }

    final void kc() {
        this.aud.kc();
        c cVar = this.aub;
        if (cVar.atf != null) {
            throw cVar.atf;
        } else if (cVar.atg != null) {
            cVar.ata.c(cVar.atg);
        }
    }

    final void kC() {
        for (h hVar : this.auh) {
            boolean z = this.aut;
            g gVar = hVar.asl;
            gVar.length = 0;
            gVar.asa = 0;
            gVar.asb = 0;
            gVar.asc = 0;
            gVar.asf = true;
            gVar.asd = Long.MIN_VALUE;
            gVar.ase = Long.MIN_VALUE;
            if (z) {
                gVar.ash = null;
                gVar.asg = true;
            }
            h.a aVar = hVar.asn;
            if (aVar.asx) {
                com.google.android.exoplayer2.h.a[] aVarArr = new com.google.android.exoplayer2.h.a[((hVar.asp.asx ? 1 : 0) + (((int) (hVar.asp.asw - aVar.asw)) / hVar.ask))];
                for (int i = 0; i < aVarArr.length; i++) {
                    aVarArr[i] = aVar.asy;
                    aVar = aVar.kn();
                }
                hVar.asj.a(aVarArr);
            }
            hVar.asn = new h.a(0, hVar.ask);
            hVar.aso = hVar.asn;
            hVar.asp = hVar.asn;
            hVar.ano = 0;
            hVar.asj.lm();
        }
        this.aut = false;
    }

    public final boolean C(long j) {
        if (this.auv || this.aud.ic()) {
            return false;
        }
        com.google.android.exoplayer2.source.a.d dVar;
        int i;
        long max;
        Object obj;
        com.google.android.exoplayer2.source.b.a.b b;
        int i2;
        com.google.android.exoplayer2.source.b.a.b bVar;
        com.google.android.exoplayer2.source.b.a.a.a aVar;
        int i3;
        boolean z;
        int a;
        com.google.android.exoplayer2.source.b.a.b bVar2;
        com.google.android.exoplayer2.source.b.a.a.a aVar2;
        com.google.android.exoplayer2.source.b.a.b.a aVar3;
        Uri j2;
        com.google.android.exoplayer2.source.b.a.b.a aVar4;
        i iVar;
        long j3;
        int i4;
        k kVar;
        com.google.android.exoplayer2.i.q qVar;
        com.google.android.exoplayer2.i.q qVar2;
        com.google.android.exoplayer2.source.a.a aVar5;
        com.google.android.exoplayer2.source.b.a.a.a aVar6;
        int i5;
        boolean z2;
        long a2;
        com.google.android.exoplayer2.source.a.a aVar7;
        i iVar2;
        int i6;
        Format format;
        int i7;
        Object obj2;
        c cVar = this.aub;
        if (this.auf.isEmpty()) {
            dVar = null;
        } else {
            dVar = (f) this.auf.getLast();
        }
        if (this.aus != -9223372036854775807L) {
            j = this.aus;
        }
        c.b bVar3 = this.aue;
        if (dVar == null) {
            i = -1;
        } else {
            i = cVar.atb.j(dVar.asI);
        }
        cVar.atg = null;
        if (dVar != null) {
            long j4;
            if (cVar.ath) {
                j4 = dVar.asM;
            } else {
                j4 = dVar.asL;
            }
            Math.max(0, j4 - j);
        }
        cVar.atk.ku();
        int li = cVar.atk.li();
        Object obj3;
        if (i != li) {
            obj3 = 1;
        } else {
            obj3 = null;
        }
        com.google.android.exoplayer2.source.b.a.a.a aVar8 = cVar.asZ[li];
        com.google.android.exoplayer2.source.b.a.e.a aVar9 = (com.google.android.exoplayer2.source.b.a.e.a) cVar.ata.avA.get(aVar8);
        if (aVar9.avL != null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            max = Math.max(30000, com.google.android.exoplayer2.b.j(aVar9.avL.aes));
            if (aVar9.avL.auM || aVar9.avL.auF == 2 || aVar9.avL.auF == 1 || max + aVar9.avM > elapsedRealtime) {
                obj = 1;
                if (obj != null) {
                    bVar3.atp = aVar8;
                    cVar.atg = aVar8;
                } else {
                    b = cVar.ata.b(aVar8);
                    cVar.ath = b.auL;
                    if (dVar == null && r4 == null) {
                        i2 = dVar.asP + 1;
                        bVar = b;
                        aVar = aVar8;
                        i3 = li;
                    } else {
                        if (dVar != null) {
                            j = cVar.ath ? dVar.asM : dVar.asL;
                        }
                        if (!b.auM || j < b.kF()) {
                            List list = b.auP;
                            Object valueOf = Long.valueOf(j - b.asL);
                            z = cVar.ata.avH || dVar == null;
                            a = t.a(list, valueOf, z) + b.auJ;
                            if (a < b.auJ || dVar == null) {
                                bVar2 = b;
                                aVar2 = aVar8;
                                i3 = li;
                            } else {
                                com.google.android.exoplayer2.source.b.a.a.a aVar10 = cVar.asZ[i];
                                a = dVar.asP + 1;
                                com.google.android.exoplayer2.source.b.a.b b2 = cVar.ata.b(aVar10);
                                aVar2 = aVar10;
                                i3 = i;
                                bVar2 = b2;
                            }
                            i2 = a;
                            bVar = bVar2;
                            aVar = aVar2;
                        } else {
                            i2 = b.auJ + b.auP.size();
                            bVar = b;
                            aVar = aVar8;
                            i3 = li;
                        }
                    }
                    if (i2 >= bVar.auJ) {
                        cVar.atf = new com.google.android.exoplayer2.source.b();
                    } else {
                        a = i2 - bVar.auJ;
                        if (a >= bVar.auP.size()) {
                            aVar3 = (com.google.android.exoplayer2.source.b.a.b.a) bVar.auP.get(a);
                            if (aVar3.ami) {
                                cVar.ati = null;
                                cVar.aiR = null;
                                cVar.atj = null;
                                cVar.asT = null;
                            } else {
                                j2 = s.j(bVar.auW, aVar3.auS);
                                if (!j2.equals(cVar.ati)) {
                                    bVar3.atn = new c.a(cVar.asX, new i(j2, 1), cVar.asZ[i3].aeo, cVar.atk.kw(), cVar.atk.kx(), cVar.ate, aVar3.auT);
                                } else if (!t.h(aVar3.auT, cVar.atj)) {
                                    cVar.a(j2, aVar3.auT, cVar.aiR);
                                }
                            }
                            aVar4 = bVar.auO;
                            if (aVar4 == null) {
                                iVar = new i(s.j(bVar.auW, aVar4.url), aVar4.auU, aVar4.auV);
                            } else {
                                iVar = null;
                            }
                            j3 = bVar.asL + aVar3.auR;
                            i4 = bVar.auI + aVar3.auQ;
                            kVar = cVar.asY;
                            qVar = (com.google.android.exoplayer2.i.q) kVar.aux.get(i4);
                            if (qVar != null) {
                                com.google.android.exoplayer2.i.q qVar3 = new com.google.android.exoplayer2.i.q(Long.MAX_VALUE);
                                kVar.aux.put(i4, qVar3);
                            } else {
                                qVar2 = qVar;
                            }
                            bVar3.atn = new f(cVar.asW, new i(s.j(bVar.auW, aVar3.url), aVar3.auU, aVar3.auV), iVar, aVar, cVar.atc, cVar.atk.kw(), cVar.atk.kx(), j3, j3 + aVar3.aes, i2, i4, cVar.atd, qVar2, dVar, cVar.aiR, cVar.asT);
                        } else if (bVar.auM) {
                            bVar3.atp = aVar;
                            cVar.atg = aVar;
                        } else {
                            bVar3.ato = true;
                        }
                    }
                }
                z = this.aue.ato;
                aVar5 = this.aue.atn;
                aVar6 = this.aue.atp;
                this.aue.clear();
                if (z) {
                    this.aus = -9223372036854775807L;
                    this.auv = true;
                    return true;
                } else if (aVar5 != null) {
                    if (aVar6 != null) {
                        this.aua.a(aVar6);
                    }
                    return false;
                } else {
                    if (aVar5 instanceof f) {
                        this.aus = -9223372036854775807L;
                        f fVar = (f) aVar5;
                        fVar.atK = this;
                        i5 = fVar.uid;
                        z2 = fVar.atB;
                        this.aum = i5;
                        for (h hVar : this.auh) {
                            hVar.asl.asi = i5;
                        }
                        if (z2) {
                            for (h hVar2 : this.auh) {
                                hVar2.asu = true;
                            }
                        }
                        this.auf.add(fVar);
                    }
                    a2 = this.aud.a(aVar5, this, this.atN);
                    aVar7 = this.atO;
                    iVar2 = aVar5.asH;
                    i3 = aVar5.type;
                    i6 = this.ach;
                    format = aVar5.asI;
                    i7 = aVar5.asJ;
                    obj2 = aVar5.asK;
                    max = aVar5.asL;
                    j3 = aVar5.asM;
                    if (aVar7.ars != null) {
                        aVar7.handler.post(new a$a$1(aVar7, iVar2, i3, i6, format, i7, obj2, max, j3, a2));
                    }
                    return true;
                }
            }
        }
        obj = null;
        if (obj != null) {
            b = cVar.ata.b(aVar8);
            cVar.ath = b.auL;
            if (dVar == null) {
            }
            if (dVar != null) {
                if (cVar.ath) {
                }
            }
            if (b.auM) {
            }
            List list2 = b.auP;
            Object valueOf2 = Long.valueOf(j - b.asL);
            if (cVar.ata.avH) {
            }
            a = t.a(list2, valueOf2, z) + b.auJ;
            if (a < b.auJ) {
            }
            bVar2 = b;
            aVar2 = aVar8;
            i3 = li;
            i2 = a;
            bVar = bVar2;
            aVar = aVar2;
            if (i2 >= bVar.auJ) {
                a = i2 - bVar.auJ;
                if (a >= bVar.auP.size()) {
                    aVar3 = (com.google.android.exoplayer2.source.b.a.b.a) bVar.auP.get(a);
                    if (aVar3.ami) {
                        cVar.ati = null;
                        cVar.aiR = null;
                        cVar.atj = null;
                        cVar.asT = null;
                    } else {
                        j2 = s.j(bVar.auW, aVar3.auS);
                        if (!j2.equals(cVar.ati)) {
                            bVar3.atn = new c.a(cVar.asX, new i(j2, 1), cVar.asZ[i3].aeo, cVar.atk.kw(), cVar.atk.kx(), cVar.ate, aVar3.auT);
                        } else if (t.h(aVar3.auT, cVar.atj)) {
                            cVar.a(j2, aVar3.auT, cVar.aiR);
                        }
                    }
                    aVar4 = bVar.auO;
                    if (aVar4 == null) {
                        iVar = null;
                    } else {
                        iVar = new i(s.j(bVar.auW, aVar4.url), aVar4.auU, aVar4.auV);
                    }
                    j3 = bVar.asL + aVar3.auR;
                    i4 = bVar.auI + aVar3.auQ;
                    kVar = cVar.asY;
                    qVar = (com.google.android.exoplayer2.i.q) kVar.aux.get(i4);
                    if (qVar != null) {
                        qVar2 = qVar;
                    } else {
                        com.google.android.exoplayer2.i.q qVar32 = new com.google.android.exoplayer2.i.q(Long.MAX_VALUE);
                        kVar.aux.put(i4, qVar32);
                    }
                    bVar3.atn = new f(cVar.asW, new i(s.j(bVar.auW, aVar3.url), aVar3.auU, aVar3.auV), iVar, aVar, cVar.atc, cVar.atk.kw(), cVar.atk.kx(), j3, j3 + aVar3.aes, i2, i4, cVar.atd, qVar2, dVar, cVar.aiR, cVar.asT);
                } else if (bVar.auM) {
                    bVar3.atp = aVar;
                    cVar.atg = aVar;
                } else {
                    bVar3.ato = true;
                }
            } else {
                cVar.atf = new com.google.android.exoplayer2.source.b();
            }
        } else {
            bVar3.atp = aVar8;
            cVar.atg = aVar8;
        }
        z = this.aue.ato;
        aVar5 = this.aue.atn;
        aVar6 = this.aue.atp;
        this.aue.clear();
        if (z) {
            this.aus = -9223372036854775807L;
            this.auv = true;
            return true;
        } else if (aVar5 != null) {
            if (aVar5 instanceof f) {
                this.aus = -9223372036854775807L;
                f fVar2 = (f) aVar5;
                fVar2.atK = this;
                i5 = fVar2.uid;
                z2 = fVar2.atB;
                this.aum = i5;
                while (i < li) {
                    hVar.asl.asi = i5;
                }
                if (z2) {
                    while (i < i3) {
                        hVar2.asu = true;
                    }
                }
                this.auf.add(fVar2);
            }
            a2 = this.aud.a(aVar5, this, this.atN);
            aVar7 = this.atO;
            iVar2 = aVar5.asH;
            i3 = aVar5.type;
            i6 = this.ach;
            format = aVar5.asI;
            i7 = aVar5.asJ;
            obj2 = aVar5.asK;
            max = aVar5.asL;
            j3 = aVar5.asM;
            if (aVar7.ars != null) {
                aVar7.handler.post(new a$a$1(aVar7, iVar2, i3, i6, format, i7, obj2, max, j3, a2));
            }
            return true;
        } else {
            if (aVar6 != null) {
                this.aua.a(aVar6);
            }
            return false;
        }
    }

    public final long kb() {
        if (kE()) {
            return this.aus;
        }
        return this.auv ? Long.MIN_VALUE : ((f) this.auf.getLast()).asM;
    }

    public final h cG(int i) {
        int length = this.auh.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.aui[i2] == i) {
                return this.auh[i2];
            }
        }
        h hVar = new h(this.asj);
        hVar.asv = this;
        this.aui = Arrays.copyOf(this.aui, length + 1);
        this.aui[length] = i;
        this.auh = (h[]) Arrays.copyOf(this.auh, length + 1);
        this.auh[length] = hVar;
        return hVar;
    }

    public final void ju() {
        this.auj = true;
        this.handler.post(this.aug);
    }

    public final void ko() {
        this.handler.post(this.aug);
    }

    final void kD() {
        if (!this.released && !this.adD && this.auj) {
            h[] hVarArr = this.auh;
            int length = hVarArr.length;
            int i = 0;
            while (i < length) {
                if (hVarArr[i].asl.kh() != null) {
                    i++;
                } else {
                    return;
                }
            }
            int length2 = this.auh.length;
            int i2 = 0;
            i = -1;
            boolean z = false;
            while (i2 < length2) {
                String str = this.auh[i2].asl.kh().adV;
                boolean z2 = com.google.android.exoplayer2.i.g.aa(str) ? true : com.google.android.exoplayer2.i.g.Z(str) ? true : com.google.android.exoplayer2.i.g.ab(str);
                if (z2 > z) {
                    i = i2;
                } else if (z2 != z || i == -1) {
                    z2 = z;
                } else {
                    i = -1;
                    z2 = z;
                }
                i2++;
                z = z2;
            }
            l lVar = this.aub.atb;
            int i3 = lVar.length;
            this.aun = -1;
            this.aup = new boolean[length2];
            this.auq = new boolean[length2];
            l[] lVarArr = new l[length2];
            for (int i4 = 0; i4 < length2; i4++) {
                Format kh = this.auh[i4].asl.kh();
                String str2 = kh.adV;
                boolean z3 = com.google.android.exoplayer2.i.g.aa(str2) || com.google.android.exoplayer2.i.g.Z(str2);
                this.auq[i4] = z3;
                this.auo = z3 | this.auo;
                if (i4 == i) {
                    Format[] formatArr = new Format[i3];
                    for (i2 = 0; i2 < i3; i2++) {
                        formatArr[i2] = a(lVar.arZ[i2], kh);
                    }
                    lVarArr[i4] = new l(formatArr);
                    this.aun = i4;
                } else {
                    Format format = (z && com.google.android.exoplayer2.i.g.Z(kh.adV)) ? this.auc : null;
                    lVarArr[i4] = new l(a(format, kh));
                }
            }
            this.acV = new m(lVarArr);
            this.adD = true;
            this.aua.hX();
        }
    }

    final void k(int i, boolean z) {
        int i2 = 1;
        com.google.android.exoplayer2.i.a.an(this.aup[i] != z);
        this.aup[i] = z;
        int i3 = this.auk;
        if (!z) {
            i2 = -1;
        }
        this.auk = i3 + i2;
    }

    private static Format a(Format format, Format format2) {
        if (format == null) {
            return format2;
        }
        String str = null;
        int ad = com.google.android.exoplayer2.i.g.ad(format2.adV);
        if (ad == 1) {
            str = i(format.adS, 1);
        } else if (ad == 2) {
            str = i(format.adS, 2);
        }
        return new Format(format.id, format2.adU, format2.adV, str, format.bitrate, format2.adW, format.width, format.height, format2.adZ, format2.aea, format2.aeb, format2.aed, format2.aec, format2.aee, format2.aef, format2.sampleRate, format2.aeg, format2.aeh, format2.aei, format.aek, format.ael, format2.aem, format2.aej, format2.adX, format2.adY, format2.adT);
    }

    final boolean kE() {
        return this.aus != -9223372036854775807L;
    }

    private static String i(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split("(\\s*,\\s*)|(\\s*$)");
        StringBuilder stringBuilder = new StringBuilder();
        for (String str2 : split) {
            if (i == com.google.android.exoplayer2.i.g.ad(com.google.android.exoplayer2.i.g.ac(str2))) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append(",");
                }
                stringBuilder.append(str2);
            }
        }
        if (stringBuilder.length() > 0) {
            return stringBuilder.toString();
        }
        return null;
    }
}
