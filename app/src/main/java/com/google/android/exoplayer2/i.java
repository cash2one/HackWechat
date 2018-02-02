package com.google.android.exoplayer2;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import com.google.android.exoplayer2.f.c;
import com.google.android.exoplayer2.g.g;
import com.google.android.exoplayer2.g.g.a;
import com.google.android.exoplayer2.g.h;
import com.google.android.exoplayer2.i.o;
import com.google.android.exoplayer2.i.r;
import com.google.android.exoplayer2.source.e;
import com.google.android.exoplayer2.source.f;
import com.google.android.exoplayer2.source.j;
import java.io.IOException;

final class i implements Callback, a, e.a, f.a {
    private final r[] acF;
    private final g acG;
    private final Handler acI;
    private final com.google.android.exoplayer2.w.b acL;
    private final w.a acM;
    private boolean acO;
    private boolean acS;
    private w acT;
    private p acX;
    private b acY;
    private final s[] add;
    private final m ade;
    private final o adf;
    private final HandlerThread adg;
    private final f adh;
    private final n adi;
    private r adj;
    private com.google.android.exoplayer2.i.f adk;
    private f adl;
    private r[] adm;
    private boolean adn;
    int ado;
    private int adp;
    private long adq;
    private int adr;
    private c ads;
    private long adt;
    private a adu;
    private a adv;
    private a adw;
    final Handler handler;
    boolean released;
    private int repeatMode;
    private int state = 1;

    public static final class b {
        public final com.google.android.exoplayer2.source.f.b adI;
        public final long adJ;
        public final long adK;
        public volatile long adL;
        public volatile long adM;

        public b(long j) {
            this(new com.google.android.exoplayer2.source.f.b(0), j);
        }

        public b(com.google.android.exoplayer2.source.f.b bVar, long j) {
            this(bVar, j, -9223372036854775807L);
        }

        public b(com.google.android.exoplayer2.source.f.b bVar, long j, long j2) {
            this.adI = bVar;
            this.adJ = j;
            this.adK = j2;
            this.adL = j;
            this.adM = j;
        }
    }

    public final /* synthetic */ void a(j jVar) {
        this.handler.obtainMessage(9, (e) jVar).sendToTarget();
    }

    public i(r[] rVarArr, g gVar, m mVar, boolean z, int i, Handler handler, b bVar, f fVar) {
        this.acF = rVarArr;
        this.acG = gVar;
        this.ade = mVar;
        this.acO = z;
        this.repeatMode = i;
        this.acI = handler;
        this.acY = bVar;
        this.adh = fVar;
        this.add = new s[rVarArr.length];
        for (int i2 = 0; i2 < rVarArr.length; i2++) {
            rVarArr[i2].setIndex(i2);
            this.add[i2] = rVarArr[i2].hN();
        }
        this.adf = new o();
        this.adm = new r[0];
        this.acL = new com.google.android.exoplayer2.w.b();
        this.acM = new w.a();
        this.adi = new n();
        gVar.aAv = this;
        this.acX = p.aev;
        this.adg = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
        this.adg.start();
        this.handler = new Handler(this.adg.getLooper(), this);
    }

    public final void a(w wVar, int i, long j) {
        this.handler.obtainMessage(3, new c(wVar, i, j)).sendToTarget();
    }

    public final synchronized void b(c... cVarArr) {
        if (!this.released) {
            int i = this.ado;
            this.ado = i + 1;
            this.handler.obtainMessage(11, cVarArr).sendToTarget();
            Object obj = null;
            while (this.adp <= i) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    obj = 1;
                }
            }
            if (obj != null) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public final synchronized void release() {
        if (!this.released) {
            this.handler.sendEmptyMessage(6);
            Object obj = null;
            while (!this.released) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    obj = 1;
                }
            }
            if (obj != null) {
                Thread.currentThread().interrupt();
            }
            this.adg.quit();
        }
    }

    public final void a(w wVar, Object obj) {
        this.handler.obtainMessage(7, Pair.create(wVar, obj)).sendToTarget();
    }

    public final void a(e eVar) {
        this.handler.obtainMessage(8, eVar).sendToTarget();
    }

    public final boolean handleMessage(Message message) {
        long longValue;
        com.google.android.exoplayer2.source.f.b d;
        int i;
        long ik;
        try {
            Object obj;
            boolean z;
            n nVar;
            n.a a;
            int a2;
            int i2;
            int intValue;
            com.google.android.exoplayer2.source.f.b bVar;
            int i3;
            a aVar;
            r rVar;
            Object obj2;
            a aVar2;
            long ka;
            Pair a3;
            int i4;
            a aVar3;
            e eVar;
            switch (message.what) {
                case 0:
                    f fVar = (f) message.obj;
                    obj = message.arg1 != 0 ? 1 : null;
                    this.acI.sendEmptyMessage(0);
                    af(true);
                    this.ade.hX();
                    if (obj != null) {
                        this.acY = new b(-9223372036854775807L);
                    } else {
                        this.acY = new b(this.acY.adI, this.acY.adL, this.acY.adK);
                    }
                    this.adl = fVar;
                    if (fVar != null) {
                        fVar.a(this);
                    }
                    setState(2);
                    this.handler.sendEmptyMessage(2);
                    return true;
                case 1:
                    z = message.arg1 != 0;
                    this.adn = false;
                    this.acO = z;
                    if (!z) {
                        if();
                        ig();
                    } else if (this.state == 3) {
                        ie();
                        this.handler.sendEmptyMessage(2);
                    } else if (this.state == 2) {
                        this.handler.sendEmptyMessage(2);
                    }
                    return true;
                case 2:
                    Object obj3;
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    if (this.acT != null || this.adl == null) {
                        r rVar2;
                        com.google.android.exoplayer2.source.i iVar;
                        h hVar;
                        h hVar2;
                        r rVar3;
                        com.google.android.exoplayer2.g.e eVar2;
                        t tVar;
                        Format[] formatArr;
                        if (this.adu == null) {
                            nVar = this.adi;
                            b bVar2 = this.acY;
                            a = nVar.a(bVar2.adI, bVar2.adK, bVar2.adJ);
                        } else {
                            if (!this.adu.adC.aeu && this.adu.il() && this.adu.adC.aes != -9223372036854775807L && (this.adw == null || this.adu.index - this.adw.index != 100)) {
                                n nVar2 = this.adi;
                                n.a aVar4 = this.adu.adC;
                                ik = this.adu.ik();
                                long j = this.adt;
                                if (aVar4.aet) {
                                    a2 = nVar2.acT.a(aVar4.aeq.arS, nVar2.acM, nVar2.acL, nVar2.repeatMode);
                                    if (a2 == -1) {
                                        a = null;
                                    } else {
                                        i2 = nVar2.acT.a(a2, nVar2.acM, false).adN;
                                        if (nVar2.acT.a(i2, nVar2.acL).afi == a2) {
                                            Pair a4 = nVar2.acT.a(nVar2.acL, nVar2.acM, i2, -9223372036854775807L, Math.max(0, (aVar4.aes + ik) - j));
                                            if (a4 == null) {
                                                a = null;
                                            } else {
                                                intValue = ((Integer) a4.first).intValue();
                                                longValue = ((Long) a4.second).longValue();
                                                a2 = intValue;
                                            }
                                        } else {
                                            longValue = 0;
                                        }
                                        a = nVar2.a(nVar2.d(a2, longValue), longValue, longValue);
                                    }
                                } else {
                                    bVar = aVar4.aeq;
                                    if (bVar.kf()) {
                                        i3 = bVar.arT;
                                        nVar2.acT.a(bVar.arS, nVar2.acM, false);
                                        intValue = nVar2.acM.aeZ[i3];
                                        if (intValue == -1) {
                                            a = null;
                                        } else {
                                            i2 = bVar.arU + 1;
                                            if (i2 < intValue) {
                                                a = !nVar2.acM.an(i3, i2) ? null : nVar2.b(bVar.arS, i3, i2, aVar4.adK);
                                            } else {
                                                intValue = nVar2.acM.s(aVar4.adK);
                                                a = nVar2.b(bVar.arS, aVar4.adK, intValue == -1 ? Long.MIN_VALUE : nVar2.acM.aeY[intValue]);
                                            }
                                        }
                                    } else if (aVar4.aer != Long.MIN_VALUE) {
                                        i3 = nVar2.acM.r(aVar4.aer);
                                        a = !nVar2.acM.an(i3, 0) ? null : nVar2.b(bVar.arS, i3, 0, aVar4.aer);
                                    } else {
                                        i3 = nVar2.acM.iw();
                                        if (i3 != 0) {
                                            if (nVar2.acM.aeY[i3 - 1] == Long.MIN_VALUE && !nVar2.acM.bX(i3 - 1) && nVar2.acM.an(i3 - 1, 0)) {
                                                a = nVar2.b(bVar.arS, i3 - 1, 0, nVar2.acM.aes);
                                            }
                                        }
                                        a = null;
                                    }
                                }
                            }
                            if (this.adu != null || this.adu.il()) {
                                ae(false);
                            } else if (!(this.adu == null || this.acS)) {
                                ij();
                            }
                            if (this.adw != null) {
                                while (this.adw != this.adv && this.adt >= this.adw.adF.adB) {
                                    this.adw.release();
                                    b(this.adw.adF);
                                    this.acY = new b(this.adw.adC.aeq, this.adw.adC.adJ, this.adw.adC.adK);
                                    ig();
                                    this.acI.obtainMessage(5, this.acY).sendToTarget();
                                }
                                if (!this.adv.adC.aeu) {
                                    while (a2 < this.acF.length) {
                                        rVar2 = this.acF[a2];
                                        iVar = this.adv.adz[a2];
                                        if (rVar2.hP() == iVar && (iVar == null || rVar2.hQ())) {
                                        }
                                    }
                                    if (this.adv.adF != null && this.adv.adF.adD) {
                                        hVar = this.adv.adG;
                                        this.adv = this.adv.adF;
                                        hVar2 = this.adv.adG;
                                        obj = this.adv.adx.jZ() == -9223372036854775807L ? 1 : null;
                                        for (intValue = 0; intValue < this.acF.length; intValue++) {
                                            rVar3 = this.acF[intValue];
                                            if (hVar.aAx.aAu[intValue] == null) {
                                                if (obj == null) {
                                                    if (!rVar3.hS()) {
                                                        eVar2 = hVar2.aAx.aAu[intValue];
                                                        obj3 = hVar.aAz[intValue];
                                                        tVar = hVar2.aAz[intValue];
                                                        if (eVar2 != null && tVar.equals(obj3)) {
                                                            formatArr = new Format[eVar2.length()];
                                                            for (i3 = 0; i3 < formatArr.length; i3++) {
                                                                formatArr[i3] = eVar2.cN(i3);
                                                            }
                                                            rVar3.a(formatArr, this.adv.adz[intValue], this.adv.ik());
                                                        }
                                                    }
                                                }
                                                rVar3.hR();
                                            }
                                        }
                                    }
                                } else {
                                    for (a2 = 0; a2 < this.acF.length; a2++) {
                                        rVar2 = this.acF[a2];
                                        iVar = this.adv.adz[a2];
                                        if (iVar != null && rVar2.hP() == iVar && rVar2.hQ()) {
                                            rVar2.hR();
                                        }
                                    }
                                }
                            }
                        }
                        if (a == null) {
                            this.adl.kd();
                        } else {
                            aVar = new a(this.acF, this.add, this.adu == null ? 60000000 : this.adu.ik() + this.adu.adC.aes, this.acG, this.ade, this.adl, this.acT.a(a.aeq.arS, this.acM, true).ady, this.adu == null ? 0 : this.adu.index + 1, a);
                            if (this.adu != null) {
                                this.adu.adF = aVar;
                            }
                            this.adu = aVar;
                            this.adu.adx.a(this, a.adJ);
                            ae(true);
                        }
                        if (this.adu != null) {
                            break;
                        }
                        ae(false);
                        if (this.adw != null) {
                            while (this.adw != this.adv) {
                                this.adw.release();
                                b(this.adw.adF);
                                this.acY = new b(this.adw.adC.aeq, this.adw.adC.adJ, this.adw.adC.adK);
                                ig();
                                this.acI.obtainMessage(5, this.acY).sendToTarget();
                                break;
                            }
                            if (!this.adv.adC.aeu) {
                                while (a2 < this.acF.length) {
                                    rVar2 = this.acF[a2];
                                    iVar = this.adv.adz[a2];
                                    rVar2.hR();
                                    break;
                                }
                            }
                            for (a2 = 0; a2 < this.acF.length; a2++) {
                                rVar2 = this.acF[a2];
                                iVar = this.adv.adz[a2];
                            }
                            hVar = this.adv.adG;
                            this.adv = this.adv.adF;
                            hVar2 = this.adv.adG;
                            if (this.adv.adx.jZ() == -9223372036854775807L) {
                            }
                            for (intValue = 0; intValue < this.acF.length; intValue++) {
                                rVar3 = this.acF[intValue];
                                if (hVar.aAx.aAu[intValue] == null) {
                                    if (obj == null) {
                                        if (!rVar3.hS()) {
                                            eVar2 = hVar2.aAx.aAu[intValue];
                                            obj3 = hVar.aAz[intValue];
                                            tVar = hVar2.aAz[intValue];
                                            formatArr = new Format[eVar2.length()];
                                            for (i3 = 0; i3 < formatArr.length; i3++) {
                                                formatArr[i3] = eVar2.cN(i3);
                                            }
                                            rVar3.a(formatArr, this.adv.adz[intValue], this.adv.ik());
                                            break;
                                        }
                                    }
                                    rVar3.hR();
                                }
                            }
                            break;
                        }
                    }
                    this.adl.kd();
                    if (this.adw == null) {
                        ii();
                        b(elapsedRealtime, 10);
                    } else {
                        r.beginSection("doSomeWork");
                        ig();
                        this.adw.adx.A(this.acY.adL);
                        obj3 = 1;
                        z = true;
                        for (r rVar4 : this.adm) {
                            rVar4.c(this.adt, this.adq);
                            obj3 = (obj3 == null || !rVar4.it()) ? null : 1;
                            obj2 = (rVar4.is() || rVar4.it()) ? 1 : null;
                            if (obj2 == null) {
                                rVar4.hT();
                            }
                            z = z && obj2 != null;
                        }
                        if (!z) {
                            ii();
                        }
                        if (this.adk != null) {
                            p iU = this.adk.iU();
                            if (!iU.equals(this.acX)) {
                                this.acX = iU;
                                this.adf.a(this.adk);
                                this.acI.obtainMessage(7, iU).sendToTarget();
                            }
                        }
                        ik = this.adw.adC.aes;
                        if (obj3 != null && ((ik == -9223372036854775807L || ik <= this.acY.adL) && this.adw.adC.aeu)) {
                            setState(4);
                            if();
                        } else if (this.state == 2) {
                            if (this.adm.length > 0) {
                                if (z) {
                                    aVar2 = this.adu;
                                    boolean z2 = this.adn;
                                    ik = this.adt;
                                    ka = !aVar2.adD ? aVar2.adC.adJ : aVar2.adx.ka();
                                    if (ka == Long.MIN_VALUE) {
                                        if (aVar2.adC.aeu) {
                                            z = true;
                                            if (z) {
                                                z = true;
                                            }
                                        } else {
                                            ka = aVar2.adC.aes;
                                        }
                                    }
                                    z = aVar2.ade.b(ka - (ik - aVar2.ik()), z2);
                                    if (z) {
                                        z = true;
                                    }
                                }
                                z = false;
                            } else {
                                z = o(ik);
                            }
                            if (z) {
                                setState(3);
                                if (this.acO) {
                                    ie();
                                }
                            }
                        } else if (this.state == 3) {
                            if (this.adm.length <= 0) {
                                z = o(ik);
                            }
                            if (!z) {
                                this.adn = this.acO;
                                setState(2);
                                if();
                            }
                        }
                        if (this.state == 2) {
                            for (r hT : this.adm) {
                                hT.hT();
                            }
                        }
                        if ((this.acO && this.state == 3) || this.state == 2) {
                            b(elapsedRealtime, 10);
                        } else if (this.adm.length == 0 || this.state == 4) {
                            this.handler.removeMessages(2);
                        } else {
                            b(elapsedRealtime, 1000);
                        }
                        r.endSection();
                    }
                    return true;
                case 3:
                    c cVar = (c) message.obj;
                    if (this.acT == null) {
                        this.adr++;
                        this.ads = cVar;
                    } else {
                        a3 = a(cVar);
                        if (a3 == null) {
                            this.acY = new b(0);
                            this.acI.obtainMessage(4, 1, 0, this.acY).sendToTarget();
                            this.acY = new b(-9223372036854775807L);
                            setState(4);
                            af(false);
                        } else {
                            i3 = cVar.adO == -9223372036854775807L ? 1 : 0;
                            i2 = ((Integer) a3.first).intValue();
                            ik = ((Long) a3.second).longValue();
                            d = this.adi.d(i2, ik);
                            if (d.kf()) {
                                longValue = 0;
                                i = 1;
                            } else {
                                i = i3;
                                longValue = ik;
                            }
                            if (d.equals(this.acY.adI) && longValue / 1000 == this.acY.adL / 1000) {
                                this.acY = new b(d, longValue, ik);
                                this.acI.obtainMessage(4, i != 0 ? 1 : 0, 0, this.acY).sendToTarget();
                            } else {
                                long a5 = a(d, longValue);
                                i4 = i | (longValue != a5 ? 1 : 0);
                                this.acY = new b(d, a5, ik);
                                this.acI.obtainMessage(4, i4 != 0 ? 1 : 0, 0, this.acY).sendToTarget();
                            }
                        }
                    }
                    return true;
                case 4:
                    p pVar = (p) message.obj;
                    pVar = this.adk != null ? this.adk.b(pVar) : this.adf.b(pVar);
                    this.acX = pVar;
                    this.acI.obtainMessage(7, pVar).sendToTarget();
                    return true;
                case 5:
                    ih();
                    return true;
                case 6:
                    af(true);
                    this.ade.hY();
                    setState(1);
                    synchronized (this) {
                        this.released = true;
                        notifyAll();
                    }
                    return true;
                case 7:
                    Pair pair = (Pair) message.obj;
                    w wVar = this.acT;
                    this.acT = (w) pair.first;
                    this.adi.acT = this.acT;
                    Object obj4 = pair.second;
                    if (wVar != null) {
                        intValue = this.acY.adI.arS;
                        a aVar5 = this.adw != null ? this.adw : this.adu;
                        if (aVar5 != null || intValue < wVar.iv()) {
                            i4 = this.acT.U(aVar5 == null ? wVar.a(intValue, this.acM, true).ady : aVar5.ady);
                            if (i4 == -1) {
                                a2 = a(intValue, wVar, this.acT);
                                if (a2 == -1) {
                                    l(obj4, 0);
                                } else {
                                    a3 = bV(this.acT.a(a2, this.acM, false).adN);
                                    i3 = ((Integer) a3.first).intValue();
                                    ik = ((Long) a3.second).longValue();
                                    this.acT.a(i3, this.acM, true);
                                    if (aVar5 != null) {
                                        obj2 = this.acM.ady;
                                        aVar5.adC = aVar5.adC.iq();
                                        aVar3 = aVar5;
                                        while (aVar3.adF != null) {
                                            aVar3 = aVar3.adF;
                                            if (aVar3.ady.equals(obj2)) {
                                                aVar3.adC = this.adi.a(aVar3.adC, i3);
                                            } else {
                                                aVar3.adC = aVar3.adC.iq();
                                            }
                                        }
                                    }
                                    bVar = new com.google.android.exoplayer2.source.f.b(i3);
                                    this.acY = new b(bVar, a(bVar, ik));
                                }
                            } else {
                                if (i4 != intValue) {
                                    b bVar3 = this.acY;
                                    b bVar4 = new b(bVar3.adI.cA(i4), bVar3.adJ, bVar3.adK);
                                    bVar4.adL = bVar3.adL;
                                    bVar4.adM = bVar3.adM;
                                    this.acY = bVar4;
                                }
                                if (this.acY.adI.kf()) {
                                    d = this.adi.d(i4, this.acY.adK);
                                    if (!(d.kf() && d.arU == this.acY.adI.arU)) {
                                        this.acY = new b(d, a(d, this.acY.adK), d.kf() ? this.acY.adK : -9223372036854775807L);
                                    }
                                }
                                if (aVar5 != null) {
                                    aVar = a(aVar5, i4);
                                    a2 = i4;
                                    while (aVar.adF != null) {
                                        aVar2 = aVar.adF;
                                        a2 = this.acT.a(a2, this.acM, this.acL, this.repeatMode);
                                        if (a2 == -1 || !aVar2.ady.equals(this.acT.a(a2, this.acM, true).ady)) {
                                            obj = (this.adv == null || this.adv.index >= aVar2.index) ? null : 1;
                                            if (obj == null) {
                                                this.acY = new b(this.adw.adC.aeq, a(this.adw.adC.aeq, this.acY.adL), this.acY.adK);
                                            } else {
                                                this.adu = aVar;
                                                this.adu.adF = null;
                                                a(aVar2);
                                            }
                                        } else {
                                            aVar = a(aVar2, a2);
                                        }
                                    }
                                }
                            }
                        }
                        m(obj4, 0);
                    } else if (this.adr > 0) {
                        a3 = a(this.ads);
                        i4 = this.adr;
                        this.adr = 0;
                        this.ads = null;
                        if (a3 == null) {
                            l(obj4, i4);
                        } else {
                            i3 = ((Integer) a3.first).intValue();
                            ik = ((Long) a3.second).longValue();
                            d = this.adi.d(i3, ik);
                            this.acY = new b(d, d.kf() ? 0 : ik, ik);
                            m(obj4, i4);
                        }
                    } else {
                        if (this.acY.adJ == -9223372036854775807L) {
                            if (this.acT.isEmpty()) {
                                l(obj4, 0);
                            } else {
                                a3 = bV(0);
                                i3 = ((Integer) a3.first).intValue();
                                ik = ((Long) a3.second).longValue();
                                d = this.adi.d(i3, ik);
                                this.acY = new b(d, d.kf() ? 0 : ik, ik);
                            }
                        }
                        m(obj4, 0);
                    }
                    return true;
                case 8:
                    eVar = (e) message.obj;
                    if (this.adu != null && this.adu.adx == eVar) {
                        a aVar6 = this.adu;
                        aVar6.adD = true;
                        aVar6.im();
                        longValue = aVar6.p(aVar6.adC.adJ);
                        a = aVar6.adC;
                        aVar6.adC = new n.a(a.aeq, longValue, a.aer, a.adK, a.aes, a.aet, a.aeu);
                        if (this.adw == null) {
                            this.adv = this.adu;
                            n(this.adv.adC.adJ);
                            b(this.adv);
                        }
                        ij();
                    }
                    return true;
                case 9:
                    eVar = (e) message.obj;
                    if (this.adu != null && this.adu.adx == eVar) {
                        ij();
                    }
                    return true;
                case 10:
                    if (this.adw != null) {
                        obj = 1;
                        a aVar7 = this.adw;
                        while (aVar7 != null && aVar7.adD) {
                            if (aVar7.im()) {
                                if (obj != null) {
                                    z = this.adv != this.adw;
                                    a(this.adw.adF);
                                    this.adw.adF = null;
                                    this.adu = this.adw;
                                    this.adv = this.adw;
                                    boolean[] zArr = new boolean[this.acF.length];
                                    ka = this.adw.a(this.acY.adL, z, zArr);
                                    if (ka != this.acY.adL) {
                                        this.acY.adL = ka;
                                        n(ka);
                                    }
                                    boolean[] zArr2 = new boolean[this.acF.length];
                                    a2 = 0;
                                    for (i3 = 0; i3 < this.acF.length; i3++) {
                                        rVar4 = this.acF[i3];
                                        zArr2[i3] = rVar4.getState() != 0;
                                        com.google.android.exoplayer2.source.i iVar2 = this.adw.adz[i3];
                                        if (iVar2 != null) {
                                            a2++;
                                        }
                                        if (zArr2[i3]) {
                                            if (iVar2 != rVar4.hP()) {
                                                if (rVar4 == this.adj) {
                                                    if (iVar2 == null) {
                                                        this.adf.a(this.adk);
                                                    }
                                                    this.adk = null;
                                                    this.adj = null;
                                                }
                                                a(rVar4);
                                                rVar4.disable();
                                            } else if (zArr[i3]) {
                                                rVar4.i(this.adt);
                                            }
                                        }
                                    }
                                    this.acI.obtainMessage(3, aVar7.adG).sendToTarget();
                                    a(zArr2, a2);
                                } else {
                                    this.adu = aVar7;
                                    for (aVar3 = this.adu.adF; aVar3 != null; aVar3 = aVar3.adF) {
                                        aVar3.release();
                                    }
                                    this.adu.adF = null;
                                    if (this.adu.adD) {
                                        this.adu.p(Math.max(this.adu.adC.adJ, this.adt - this.adu.ik()));
                                    }
                                }
                                ij();
                                ig();
                                this.handler.sendEmptyMessage(2);
                            } else {
                                if (aVar7 == this.adv) {
                                    obj = null;
                                }
                                aVar7 = aVar7.adF;
                            }
                        }
                    }
                    return true;
                case 11:
                    for (c cVar2 : (c[]) message.obj) {
                        cVar2.acC.c(cVar2.acD, cVar2.acE);
                    }
                    if (this.state == 3 || this.state == 2) {
                        this.handler.sendEmptyMessage(2);
                    }
                    synchronized (this) {
                        this.adp++;
                        notifyAll();
                    }
                    return true;
                case 12:
                    intValue = message.arg1;
                    this.repeatMode = intValue;
                    this.adi.repeatMode = intValue;
                    aVar3 = this.adw != null ? this.adw : this.adu;
                    if (aVar3 != null) {
                        while (true) {
                            i2 = this.acT.a(aVar3.adC.aeq.arS, this.acM, this.acL, intValue);
                            aVar2 = aVar3;
                            while (aVar2.adF != null && !aVar2.adC.aet) {
                                aVar2 = aVar2.adF;
                            }
                            if (i2 == -1 || aVar2.adF == null || aVar2.adF.adC.aeq.arS != i2) {
                                i2 = this.adu.index;
                                intValue = this.adv != null ? this.adv.index : -1;
                                if (aVar2.adF != null) {
                                    a(aVar2.adF);
                                    aVar2.adF = null;
                                }
                                nVar = this.adi;
                                n.a aVar8 = aVar2.adC;
                                aVar2.adC = nVar.a(aVar8, aVar8.aeq);
                                if ((i2 <= aVar2.index ? 1 : null) == null) {
                                    this.adu = aVar2;
                                }
                                obj = (intValue == -1 || intValue > aVar2.index) ? null : 1;
                                if (obj == null && this.adw != null) {
                                    d = this.adw.adC.aeq;
                                    this.acY = new b(d, a(d, this.acY.adL), this.acY.adK);
                                }
                            } else {
                                aVar3 = aVar2.adF;
                            }
                        }
                    }
                    return true;
                default:
                    return false;
            }
        } catch (e e) {
            this.acI.obtainMessage(8, e).sendToTarget();
            ih();
            return true;
        } catch (IOException e2) {
            this.acI.obtainMessage(8, e.a(e2)).sendToTarget();
            ih();
            return true;
        } catch (RuntimeException e3) {
            this.acI.obtainMessage(8, e.b(e3)).sendToTarget();
            ih();
            return true;
        } catch (Throwable th) {
            Throwable th2 = th;
            this.acY = new b(d, longValue, ik);
            this.acI.obtainMessage(4, i != 0 ? 1 : 0, 0, this.acY).sendToTarget();
        }
    }

    private void setState(int i) {
        if (this.state != i) {
            this.state = i;
            this.acI.obtainMessage(1, i, 0).sendToTarget();
        }
    }

    private void ae(boolean z) {
        if (this.acS != z) {
            int i;
            this.acS = z;
            Handler handler = this.acI;
            if (z) {
                i = 1;
            } else {
                i = 0;
            }
            handler.obtainMessage(2, i, 0).sendToTarget();
        }
    }

    private void ie() {
        int i = 0;
        this.adn = false;
        o oVar = this.adf;
        if (!oVar.started) {
            oVar.aCF = SystemClock.elapsedRealtime();
            oVar.started = true;
        }
        r[] rVarArr = this.adm;
        int length = rVarArr.length;
        while (i < length) {
            rVarArr[i].start();
            i++;
        }
    }

    private void if() {
        this.adf.stop();
        for (r a : this.adm) {
            a(a);
        }
    }

    private void ig() {
        if (this.adw != null) {
            long jZ = this.adw.adx.jZ();
            if (jZ != -9223372036854775807L) {
                n(jZ);
            } else {
                if (this.adj == null || this.adj.it()) {
                    this.adt = this.adf.iN();
                } else {
                    this.adt = this.adk.iN();
                    this.adf.K(this.adt);
                }
                jZ = this.adt - this.adw.ik();
            }
            this.acY.adL = jZ;
            this.adq = SystemClock.elapsedRealtime() * 1000;
            if (this.adm.length == 0) {
                jZ = Long.MIN_VALUE;
            } else {
                jZ = this.adw.adx.ka();
            }
            b bVar = this.acY;
            if (jZ == Long.MIN_VALUE) {
                jZ = this.adw.adC.aes;
            }
            bVar.adM = jZ;
        }
    }

    private void b(long j, long j2) {
        this.handler.removeMessages(2);
        long elapsedRealtime = (j + j2) - SystemClock.elapsedRealtime();
        if (elapsedRealtime <= 0) {
            this.handler.sendEmptyMessage(2);
        } else {
            this.handler.sendEmptyMessageDelayed(2, elapsedRealtime);
        }
    }

    private long a(com.google.android.exoplayer2.source.f.b bVar, long j) {
        a aVar;
        if();
        this.adn = false;
        setState(2);
        if (this.adw != null) {
            a aVar2 = this.adw;
            aVar = null;
            while (aVar2 != null) {
                if (aVar == null) {
                    boolean z;
                    if (bVar.equals(aVar2.adC.aeq) && aVar2.adD) {
                        this.acT.a(aVar2.adC.aeq.arS, this.acM, false);
                        int s = this.acM.s(j);
                        if (s == -1 || this.acM.aeY[s] == aVar2.adC.aer) {
                            z = true;
                            if (z) {
                                aVar = aVar2;
                                aVar2 = aVar2.adF;
                            }
                        }
                    }
                    z = false;
                    if (z) {
                        aVar = aVar2;
                        aVar2 = aVar2.adF;
                    }
                }
                aVar2.release();
                aVar2 = aVar2.adF;
            }
        } else if (this.adu != null) {
            this.adu.release();
            aVar = null;
        } else {
            aVar = null;
        }
        if (!(this.adw == aVar && this.adw == this.adv)) {
            for (r disable : this.adm) {
                disable.disable();
            }
            this.adm = new r[0];
            this.adk = null;
            this.adj = null;
            this.adw = null;
        }
        if (aVar != null) {
            aVar.adF = null;
            this.adu = aVar;
            this.adv = aVar;
            b(aVar);
            if (this.adw.adE) {
                j = this.adw.adx.B(j);
            }
            n(j);
            ij();
        } else {
            this.adu = null;
            this.adv = null;
            this.adw = null;
            n(j);
        }
        this.handler.sendEmptyMessage(2);
        return j;
    }

    private void n(long j) {
        long j2;
        if (this.adw == null) {
            j2 = 60000000 + j;
        } else {
            j2 = this.adw.ik() + j;
        }
        this.adt = j2;
        this.adf.K(this.adt);
        for (r i : this.adm) {
            i.i(this.adt);
        }
    }

    private void ih() {
        af(true);
        this.ade.onStopped();
        setState(1);
    }

    private void af(boolean z) {
        this.handler.removeMessages(2);
        this.adn = false;
        this.adf.stop();
        this.adk = null;
        this.adj = null;
        this.adt = 60000000;
        for (r rVar : this.adm) {
            try {
                a(rVar);
                rVar.disable();
            } catch (e e) {
            } catch (RuntimeException e2) {
            }
        }
        this.adm = new r[0];
        a(this.adw != null ? this.adw : this.adu);
        this.adu = null;
        this.adv = null;
        this.adw = null;
        ae(false);
        if (z) {
            if (this.adl != null) {
                this.adl.ke();
                this.adl = null;
            }
            this.adi.acT = null;
            this.acT = null;
        }
    }

    private static void a(r rVar) {
        if (rVar.getState() == 2) {
            rVar.stop();
        }
    }

    private boolean o(long j) {
        return j == -9223372036854775807L || this.acY.adL < j || (this.adw.adF != null && (this.adw.adF.adD || this.adw.adF.adC.aeq.kf()));
    }

    private void ii() {
        if (this.adu != null && !this.adu.adD) {
            if (this.adv == null || this.adv.adF == this.adu) {
                r[] rVarArr = this.adm;
                int length = rVarArr.length;
                int i = 0;
                while (i < length) {
                    if (rVarArr[i].hQ()) {
                        i++;
                    } else {
                        return;
                    }
                }
                this.adu.adx.jX();
            }
        }
    }

    private a a(a aVar, int i) {
        while (true) {
            aVar.adC = this.adi.a(aVar.adC, i);
            if (aVar.adC.aet || aVar.adF == null) {
                return aVar;
            }
            aVar = aVar.adF;
        }
        return aVar;
    }

    private void l(Object obj, int i) {
        this.acY = new b(0);
        m(obj, i);
        this.acY = new b(-9223372036854775807L);
        setState(4);
        af(false);
    }

    private void m(Object obj, int i) {
        this.acI.obtainMessage(6, new d(this.acT, obj, this.acY, i)).sendToTarget();
    }

    private int a(int i, w wVar, w wVar2) {
        int iv = wVar.iv();
        int i2 = -1;
        for (int i3 = 0; i3 < iv && i2 == -1; i3++) {
            i = wVar.a(i, this.acM, this.acL, this.repeatMode);
            if (i == -1) {
                break;
            }
            i2 = wVar2.U(wVar.a(i, this.acM, true).ady);
        }
        return i2;
    }

    private Pair<Integer, Long> a(c cVar) {
        w wVar = cVar.acT;
        if (wVar.isEmpty()) {
            wVar = this.acT;
        }
        try {
            Pair<Integer, Long> a = wVar.a(this.acL, this.acM, cVar.adN, cVar.adO);
            if (this.acT == wVar) {
                return a;
            }
            int U = this.acT.U(wVar.a(((Integer) a.first).intValue(), this.acM, true).ady);
            if (U != -1) {
                return Pair.create(Integer.valueOf(U), a.second);
            }
            int a2 = a(((Integer) a.first).intValue(), wVar, this.acT);
            if (a2 != -1) {
                return bV(this.acT.a(a2, this.acM, false).adN);
            }
            return null;
        } catch (IndexOutOfBoundsException e) {
            throw new l(this.acT, cVar.adN, cVar.adO);
        }
    }

    private Pair<Integer, Long> bV(int i) {
        return this.acT.a(this.acL, this.acM, i, -9223372036854775807L);
    }

    private void ij() {
        a aVar = this.adu;
        long j = this.adt;
        long kb = !aVar.adD ? 0 : aVar.adx.kb();
        boolean l = kb == Long.MIN_VALUE ? false : aVar.ade.l(kb - (j - aVar.ik()));
        ae(l);
        if (l) {
            a aVar2 = this.adu;
            aVar2.adx.C(this.adt - aVar2.ik());
        }
    }

    private static void a(a aVar) {
        while (aVar != null) {
            aVar.release();
            aVar = aVar.adF;
        }
    }

    private void b(a aVar) {
        if (this.adw != aVar) {
            boolean[] zArr = new boolean[this.acF.length];
            int i = 0;
            int i2 = 0;
            while (i < this.acF.length) {
                boolean z;
                r rVar = this.acF[i];
                if (rVar.getState() != 0) {
                    z = true;
                } else {
                    z = false;
                }
                zArr[i] = z;
                com.google.android.exoplayer2.g.e eVar = aVar.adG.aAx.aAu[i];
                if (eVar != null) {
                    i2++;
                }
                if (zArr[i] && (eVar == null || (rVar.hS() && rVar.hP() == this.adw.adz[i]))) {
                    if (rVar == this.adj) {
                        this.adf.a(this.adk);
                        this.adk = null;
                        this.adj = null;
                    }
                    a(rVar);
                    rVar.disable();
                }
                i++;
            }
            this.adw = aVar;
            this.acI.obtainMessage(3, aVar.adG).sendToTarget();
            a(zArr, i2);
        }
    }

    private void a(boolean[] zArr, int i) {
        this.adm = new r[i];
        int i2 = 0;
        for (int i3 = 0; i3 < this.acF.length; i3++) {
            r rVar = this.acF[i3];
            com.google.android.exoplayer2.g.e eVar = this.adw.adG.aAx.aAu[i3];
            if (eVar != null) {
                int i4 = i2 + 1;
                this.adm[i2] = rVar;
                if (rVar.getState() == 0) {
                    t tVar = this.adw.adG.aAz[i3];
                    Object obj = (this.acO && this.state == 3) ? 1 : null;
                    boolean z = (zArr[i3] || obj == null) ? false : true;
                    Format[] formatArr = new Format[eVar.length()];
                    for (int i5 = 0; i5 < formatArr.length; i5++) {
                        formatArr[i5] = eVar.cN(i5);
                    }
                    rVar.a(tVar, formatArr, this.adw.adz[i3], this.adt, z, this.adw.ik());
                    com.google.android.exoplayer2.i.f hO = rVar.hO();
                    if (hO != null) {
                        if (this.adk != null) {
                            throw e.b(new IllegalStateException("Multiple renderer media clocks enabled."));
                        }
                        this.adk = hO;
                        this.adj = rVar;
                        this.adk.b(this.acX);
                    }
                    if (obj != null) {
                        rVar.start();
                    }
                }
                i2 = i4;
            }
        }
    }
}
