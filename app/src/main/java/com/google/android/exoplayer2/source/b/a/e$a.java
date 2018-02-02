package com.google.android.exoplayer2.source.b.a;

import android.os.SystemClock;
import com.google.android.exoplayer2.h.r;
import com.google.android.exoplayer2.h.r.a;
import com.google.android.exoplayer2.h.r.c;
import com.google.android.exoplayer2.h.s;
import com.google.android.exoplayer2.o;
import com.google.android.exoplayer2.source.a.b;
import java.io.IOException;
import java.util.List;

final class e$a implements a<s<c>>, Runnable {
    private final a.a avI;
    public final r avJ = new r("HlsPlaylistTracker:MediaPlaylist");
    private final s<c> avK;
    public b avL;
    public long avM;
    private long avN;
    private long avO;
    private long avP;
    private boolean avQ;
    IOException avR;
    final /* synthetic */ e avS;

    public final /* synthetic */ int a(c cVar, long j, long j2, IOException iOException) {
        s sVar = (s) cVar;
        boolean z = iOException instanceof o;
        this.avS.atO.a(sVar.asH, j, j2, sVar.aBU, iOException, z);
        if (z) {
            return 3;
        }
        boolean z2 = true;
        if (b.a(iOException)) {
            z2 = kI();
        }
        return z2 ? 0 : 2;
    }

    public final /* synthetic */ void a(c cVar, long j, long j2) {
        s sVar = (s) cVar;
        c cVar2 = (c) sVar.result;
        if (cVar2 instanceof b) {
            b((b) cVar2);
            if (((b) cVar2).auM) {
                this.avS.atO.jW();
            }
            this.avS.atO.a(sVar.asH, j, j2, sVar.aBU);
            return;
        }
        this.avR = new o("Loaded playlist has unexpected type.");
    }

    public final /* synthetic */ void a(c cVar, long j, long j2, boolean z) {
        s sVar = (s) cVar;
        this.avS.atO.b(sVar.asH, j, j2, sVar.aBU);
    }

    public e$a(e eVar, a.a aVar) {
        this.avS = eVar;
        this.avI = aVar;
        this.avK = new s(eVar.atM.kt(), com.google.android.exoplayer2.i.s.j(eVar.atr.auW, aVar.url), eVar.atW);
    }

    public final void kG() {
        this.avP = 0;
        if (!this.avQ && !this.avJ.ic()) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (elapsedRealtime < this.avO) {
                this.avQ = true;
                this.avS.avB.postDelayed(this, this.avO - elapsedRealtime);
                return;
            }
            kH();
        }
    }

    public final void run() {
        this.avQ = false;
        kH();
    }

    private void kH() {
        this.avJ.a(this.avK, this, this.avS.avz);
    }

    private void b(b bVar) {
        Object obj;
        int size;
        b bVar2;
        b bVar3 = this.avL;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.avM = elapsedRealtime;
        e eVar = this.avS;
        if (bVar3 == null || bVar.auJ > bVar3.auJ) {
            obj = 1;
        } else {
            if (bVar.auJ >= bVar3.auJ) {
                size = bVar.auP.size();
                int size2 = bVar3.auP.size();
                if (size > size2 || (size == size2 && bVar.auM && !bVar3.auM)) {
                    obj = 1;
                }
            }
            obj = null;
        }
        if (obj == null) {
            bVar2 = bVar.auM ? bVar3.auM ? bVar3 : new b(bVar3.auF, bVar3.auW, bVar3.auX, bVar3.auG, bVar3.asL, bVar3.auH, bVar3.auI, bVar3.auJ, bVar3.version, bVar3.auK, bVar3.auL, true, bVar3.auN, bVar3.auO, bVar3.auP) : bVar3;
        } else {
            long j;
            int i;
            if (bVar.auN) {
                j = bVar.asL;
            } else {
                j = eVar.avG != null ? eVar.avG.asL : 0;
                if (bVar3 != null) {
                    size = bVar3.auP.size();
                    b.a a = e.a(bVar3, bVar);
                    if (a != null) {
                        j = bVar3.asL + a.auR;
                    } else if (size == bVar.auJ - bVar3.auJ) {
                        j = bVar3.kF();
                    }
                }
            }
            if (bVar.auH) {
                i = bVar.auI;
            } else {
                i = eVar.avG != null ? eVar.avG.auI : 0;
                if (bVar3 != null) {
                    b.a a2 = e.a(bVar3, bVar);
                    if (a2 != null) {
                        i = (bVar3.auI + a2.auQ) - ((b.a) bVar.auP.get(0)).auQ;
                    }
                }
            }
            bVar2 = new b(bVar.auF, bVar.auW, bVar.auX, bVar.auG, j, true, i, bVar.auJ, bVar.version, bVar.auK, bVar.auL, bVar.auM, bVar.auN, bVar.auO, bVar.auP);
        }
        this.avL = bVar2;
        if (this.avL != bVar3) {
            this.avR = null;
            this.avN = elapsedRealtime;
            e eVar2 = this.avS;
            a.a aVar = this.avI;
            b bVar4 = this.avL;
            if (aVar == eVar2.avF) {
                if (eVar2.avG == null) {
                    eVar2.avH = !bVar4.auM;
                }
                eVar2.avG = bVar4;
                eVar2.avC.a(bVar4);
            }
            int size3 = eVar2.avD.size();
            for (int i2 = 0; i2 < size3; i2++) {
                ((e$b) eVar2.avD.get(i2)).ky();
            }
        } else if (!this.avL.auM) {
            if (bVar.auJ + bVar.auP.size() < this.avL.auJ) {
                this.avR = new e.c(this.avI.url, (byte) 0);
            } else if (((double) (elapsedRealtime - this.avN)) > ((double) com.google.android.exoplayer2.b.j(this.avL.auK)) * 3.5d) {
                this.avR = new e$d(this.avI.url, (byte) 0);
                kI();
            }
        }
        this.avO = com.google.android.exoplayer2.b.j(this.avL != bVar3 ? this.avL.auK : this.avL.auK / 2) + elapsedRealtime;
        if (this.avI == this.avS.avF && !this.avL.auM) {
            kG();
        }
    }

    private boolean kI() {
        int i;
        this.avP = SystemClock.elapsedRealtime() + 60000;
        e eVar = this.avS;
        a.a aVar = this.avI;
        int size = eVar.avD.size();
        for (i = 0; i < size; i++) {
            ((e$b) eVar.avD.get(i)).a(aVar, 60000);
        }
        if (this.avS.avF == this.avI) {
            Object obj;
            eVar = this.avS;
            List list = eVar.atr.auC;
            size = list.size();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            for (i = 0; i < size; i++) {
                e$a com_google_android_exoplayer2_source_b_a_e_a = (e$a) eVar.avA.get(list.get(i));
                if (elapsedRealtime > com_google_android_exoplayer2_source_b_a_e_a.avP) {
                    eVar.avF = com_google_android_exoplayer2_source_b_a_e_a.avI;
                    com_google_android_exoplayer2_source_b_a_e_a.kG();
                    obj = 1;
                    break;
                }
            }
            obj = null;
            if (obj == null) {
                return true;
            }
        }
        return false;
    }
}
