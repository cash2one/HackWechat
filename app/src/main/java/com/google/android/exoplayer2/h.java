package com.google.android.exoplayer2;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.f.c;
import com.google.android.exoplayer2.g.e;
import com.google.android.exoplayer2.g.f;
import com.google.android.exoplayer2.g.g;
import com.google.android.exoplayer2.i.t;
import com.google.android.exoplayer2.source.m;
import com.google.android.exoplayer2.w.a;
import com.google.android.exoplayer2.w.b;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

final class h implements f {
    private final r[] acF;
    final g acG;
    private final f acH;
    private final Handler acI;
    private final i acJ;
    final CopyOnWriteArraySet<q$a> acK;
    private final b acL;
    private final a acM;
    boolean acN;
    boolean acO;
    int acP;
    int acQ;
    int acR;
    boolean acS;
    w acT;
    Object acU;
    m acV;
    f acW;
    p acX;
    i.b acY;
    int acZ;
    int ada;
    long adb;
    private int repeatMode;

    @SuppressLint({"HandlerLeak"})
    public h(r[] rVarArr, g gVar, m mVar) {
        new StringBuilder("Init ").append(Integer.toHexString(System.identityHashCode(this))).append(" [ExoPlayerLib/2.5.4] [").append(t.aCI).append("]");
        com.google.android.exoplayer2.i.a.an(rVarArr.length > 0);
        this.acF = (r[]) com.google.android.exoplayer2.i.a.Y(rVarArr);
        this.acG = (g) com.google.android.exoplayer2.i.a.Y(gVar);
        this.acO = false;
        this.repeatMode = 0;
        this.acP = 1;
        this.acK = new CopyOnWriteArraySet();
        this.acH = new f(new e[rVarArr.length]);
        this.acT = w.aeV;
        this.acL = new b();
        this.acM = new a();
        this.acV = m.asF;
        this.acW = this.acH;
        this.acX = p.aev;
        this.acI = new 1(this, Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper());
        this.acY = new i.b(0);
        this.acJ = new i(rVarArr, gVar, mVar, this.acO, this.repeatMode, this.acI, this.acY, this);
    }

    public final void a(q$a com_google_android_exoplayer2_q_a) {
        this.acK.add(com_google_android_exoplayer2_q_a);
    }

    public final void b(q$a com_google_android_exoplayer2_q_a) {
        this.acK.remove(com_google_android_exoplayer2_q_a);
    }

    public final int ia() {
        return this.acP;
    }

    public final void a(com.google.android.exoplayer2.source.f fVar) {
        Iterator it;
        if (!(this.acT.isEmpty() && this.acU == null)) {
            this.acT = w.aeV;
            this.acU = null;
            it = this.acK.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
        if (this.acN) {
            this.acN = false;
            this.acV = m.asF;
            this.acW = this.acH;
            this.acG.W(null);
            it = this.acK.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
        this.acR++;
        this.acJ.handler.obtainMessage(0, 1, 0, fVar).sendToTarget();
    }

    public final void ad(boolean z) {
        if (this.acO != z) {
            int i;
            this.acO = z;
            Handler handler = this.acJ.handler;
            if (z) {
                i = 1;
            } else {
                i = 0;
            }
            handler.obtainMessage(1, i, 0).sendToTarget();
            Iterator it = this.acK.iterator();
            while (it.hasNext()) {
                ((q$a) it.next()).a(z, this.acP);
            }
        }
    }

    public final boolean ib() {
        return this.acO;
    }

    public final boolean ic() {
        return this.acS;
    }

    public final void seekTo(long j) {
        int id = id();
        if (id < 0 || (!this.acT.isEmpty() && id >= this.acT.iu())) {
            throw new l(this.acT, id, j);
        }
        this.acQ++;
        this.acZ = id;
        if (this.acT.isEmpty()) {
            this.ada = 0;
        } else {
            this.acT.a(id, this.acL);
            long k = j == -9223372036854775807L ? this.acL.afk : b.k(j);
            int i = this.acL.afi;
            long j2 = this.acL.afl + k;
            k = this.acT.a(i, this.acM, false).aes;
            while (k != -9223372036854775807L && j2 >= k && i < this.acL.afj) {
                j2 -= k;
                i++;
                k = this.acT.a(i, this.acM, false).aes;
            }
            this.ada = i;
        }
        if (j == -9223372036854775807L) {
            this.adb = 0;
            this.acJ.a(this.acT, id, -9223372036854775807L);
            return;
        }
        this.adb = j;
        this.acJ.a(this.acT, id, b.k(j));
        Iterator it = this.acK.iterator();
        while (it.hasNext()) {
            ((q$a) it.next()).ir();
        }
    }

    public final void stop() {
        this.acJ.handler.sendEmptyMessage(5);
    }

    public final void release() {
        new StringBuilder("Release ").append(Integer.toHexString(System.identityHashCode(this))).append(" [ExoPlayerLib/2.5.4] [").append(t.aCI).append("] [").append(j.in()).append("]");
        this.acJ.release();
        this.acI.removeCallbacksAndMessages(null);
    }

    public final void a(c... cVarArr) {
        i iVar = this.acJ;
        if (!iVar.released) {
            iVar.ado++;
            iVar.handler.obtainMessage(11, cVarArr).sendToTarget();
        }
    }

    public final void b(c... cVarArr) {
        this.acJ.b(cVarArr);
    }

    private int id() {
        if (this.acT.isEmpty() || this.acQ > 0) {
            return this.acZ;
        }
        return this.acT.a(this.acY.adI.arS, this.acM, false).adN;
    }

    public final long getDuration() {
        if (this.acT.isEmpty()) {
            return -9223372036854775807L;
        }
        boolean z;
        if (!this.acT.isEmpty() && this.acQ == 0 && this.acY.adI.kf()) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return b.j(this.acT.a(id(), this.acL).aes);
        }
        com.google.android.exoplayer2.source.f.b bVar = this.acY.adI;
        this.acT.a(bVar.arS, this.acM, false);
        return b.j(this.acM.ao(bVar.arT, bVar.arU));
    }

    public final long getCurrentPosition() {
        if (this.acT.isEmpty() || this.acQ > 0) {
            return this.adb;
        }
        return m(this.acY.adL);
    }

    public final long getBufferedPosition() {
        if (this.acT.isEmpty() || this.acQ > 0) {
            return this.adb;
        }
        return m(this.acY.adM);
    }

    public final int getBufferedPercentage() {
        if (this.acT.isEmpty()) {
            return 0;
        }
        long bufferedPosition = getBufferedPosition();
        long duration = getDuration();
        if (bufferedPosition == -9223372036854775807L || duration == -9223372036854775807L) {
            return 0;
        }
        if (duration == 0) {
            return 100;
        }
        return t.u((int) ((bufferedPosition * 100) / duration), 0, 100);
    }

    private long m(long j) {
        long j2 = b.j(j);
        if (this.acY.adI.kf()) {
            return j2;
        }
        this.acT.a(this.acY.adI.arS, this.acM, false);
        return j2 + b.j(this.acM.aeX);
    }
}
