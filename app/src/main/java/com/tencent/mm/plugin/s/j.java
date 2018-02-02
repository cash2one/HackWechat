package com.tencent.mm.plugin.s;

import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.af.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class j {
    long aep;
    public long aqA;
    boolean kTc;
    public g opD;
    af opE;
    af opZ;
    af oqa;
    af oqb;
    long oqc;
    boolean oqd = false;
    public k oqe;
    boolean oqf = false;
    a oqg;
    private a oqh = new a(this) {
        final /* synthetic */ j oqk;

        {
            this.oqk = r1;
        }

        public final boolean handleMessage(Message message) {
            x.i("MicroMsg.VideoPlayerImpl", "%s inner callback %d %d [%d]", new Object[]{this.oqk.opD.asP(), Integer.valueOf(message.what), Integer.valueOf(this.oqk.state), Integer.valueOf(this.oqk.oqe.state)});
            boolean z;
            switch (message.what) {
                case 0:
                    if (this.oqk.oqd && (this.oqk.kTc || this.oqk.oqf)) {
                        this.oqk.opE.obtainMessage(6).sendToTarget();
                        break;
                    }
                case 2:
                    int i;
                    if (this.oqk.state < 2) {
                        i = 1;
                    } else {
                        z = false;
                    }
                    if (i != 0) {
                        z = d.sv(this.oqk.oqe.state);
                        if (this.oqk.oqg != null) {
                            z &= d.sv(this.oqk.oqg.state);
                        }
                        if (z) {
                            this.oqk.setState(2);
                            this.oqk.opE.obtainMessage(1).sendToTarget();
                            break;
                        }
                    }
                    break;
                case 7:
                    j.a(this.oqk);
                    break;
                case 9:
                    if (!d.sy(this.oqk.state)) {
                        if (!d.sz(this.oqk.state) && !d.sx(this.oqk.state)) {
                            z = d.sy(this.oqk.oqe.state);
                            if (this.oqk.oqg != null) {
                                z &= d.sy(this.oqk.oqg.state);
                            }
                            if (z) {
                                this.oqk.setState(9);
                                this.oqk.opE.obtainMessage(2).sendToTarget();
                                break;
                            }
                        }
                        this.oqk.setState(9);
                        this.oqk.opE.obtainMessage(2).sendToTarget();
                        break;
                    }
                    break;
            }
            return false;
        }
    };
    private a oqi = new 2(this);
    private a oqj = new a(this) {
        final /* synthetic */ j oqk;

        {
            this.oqk = r1;
        }

        public final boolean handleMessage(Message message) {
            if (this.oqk.oqg != null) {
                switch (message.what) {
                    case 1:
                        if (!this.oqk.oqg.aZJ()) {
                            this.oqk.oqg = null;
                        }
                        this.oqk.a(this.oqk.oqa, SystemClock.elapsedRealtime(), 0);
                        break;
                    case 2:
                        if (!d.sy(this.oqk.oqg.state)) {
                            if (d.sv(this.oqk.oqg.v(this.oqk.aep, this.oqk.oqc))) {
                                this.oqk.oqb.sendMessageDelayed(this.oqk.oqb.obtainMessage(2), 10);
                            }
                            if (this.oqk.state != 3) {
                                if (this.oqk.state != 5) {
                                    if (this.oqk.state != 1) {
                                        if (this.oqk.state != 0) {
                                            this.oqk.oqa.removeMessages(2);
                                            break;
                                        }
                                        this.oqk.a(this.oqk.oqa, SystemClock.elapsedRealtime(), 0);
                                        break;
                                    }
                                    this.oqk.a(this.oqk.oqa, SystemClock.elapsedRealtime(), 0);
                                    break;
                                }
                                this.oqk.a(this.oqk.oqa, SystemClock.elapsedRealtime(), 0);
                                break;
                            }
                            this.oqk.a(this.oqk.oqa, SystemClock.elapsedRealtime(), this.oqk.opD.opw);
                            break;
                        }
                        this.oqk.oqb.obtainMessage(9).sendToTarget();
                        this.oqk.oqa.removeMessages(2);
                        break;
                    case 3:
                        this.oqk.oqg.start();
                        this.oqk.a(this.oqk.oqa, SystemClock.elapsedRealtime(), 0);
                        break;
                    case 4:
                        this.oqk.a(this.oqk.oqa, SystemClock.elapsedRealtime(), 0);
                        this.oqk.oqg.pause();
                        break;
                    case 7:
                        this.oqk.oqg.release();
                        this.oqk.oqf = true;
                        this.oqk.oqb.obtainMessage(0).sendToTarget();
                        break;
                    default:
                        break;
                }
            }
            return false;
        }
    };
    int state;

    static /* synthetic */ void a(j jVar) {
        x.i("MicroMsg.VideoPlayerImpl", "%s seek done", new Object[]{jVar.opD.asP()});
        jVar.oqe.setState(5);
        if (jVar.oqg != null) {
            jVar.opD.opu = jVar.oqg.sC((int) jVar.opD.ops);
            jVar.oqg.setState(5);
        }
        jVar.sE(7);
        jVar.setState(4);
        jVar.opE.obtainMessage(3, 0, 0).sendToTarget();
        jVar.opD.opt = jVar.opD.ops * 1000;
        jVar.opD.ops = -1;
    }

    public j(af afVar, Looper looper, Looper looper2, Looper looper3, boolean z) {
        this.opE = afVar;
        this.kTc = false;
        this.opD = new g(this.kTc);
        this.oqb = new af(looper, this.oqh);
        this.oqe = new k(this.opD, this.opE);
        this.opZ = new af(looper2, this.oqi);
        if (looper3 != null) {
            this.oqg = new a(this.opD, this.opE);
            this.oqa = new af(looper3, this.oqj);
        }
    }

    public final void aZL() {
        x.i("MicroMsg.VideoPlayerImpl", "%s reset extractor time[%d]", new Object[]{this.opD.asP(), Long.valueOf(this.opD.opt)});
        if (this.oqe != null) {
            this.oqe.w(this.opD.opt, -1);
            this.oqe.aZH();
            this.oqe.opH = 0;
        }
    }

    public final void aZM() {
        if (this.oqe != null) {
            x.i("MicroMsg.VideoPlayerImpl", "%s player flush surface", new Object[]{this.opD.asP()});
            this.oqe.setState(10);
            a(this.opZ, SystemClock.elapsedRealtime(), 0);
        }
    }

    public final void start() {
        setState(3);
        this.opZ.obtainMessage(3).sendToTarget();
        if (this.oqg != null) {
            this.oqa.obtainMessage(3).sendToTarget();
        }
    }

    public final void pause() {
        setState(4);
        this.opZ.obtainMessage(4).sendToTarget();
        if (this.oqg != null) {
            this.oqa.obtainMessage(4).sendToTarget();
        }
    }

    public final void F(int i, boolean z) {
        x.i("MicroMsg.VideoPlayerImpl", "%s seek to [%d] is precision[%b]", new Object[]{this.opD.asP(), Integer.valueOf(i), Boolean.valueOf(true)});
        this.oqe.pause();
        if (this.oqg != null) {
            this.oqg.pause();
        }
        if (((long) i) >= this.aqA) {
            x.i("MicroMsg.VideoPlayerImpl", "seekTo %d, duration %d ", new Object[]{Integer.valueOf(i), Long.valueOf(this.aqA)});
            setState(6);
            this.oqb.obtainMessage(9).sendToTarget();
            return;
        }
        long sC = this.oqe.sC(i);
        boolean z2 = sC >= 0 && sC < ((long) i);
        x.i("MicroMsg.VideoPlayerImpl", "%s can seek precision[%b] after seek [%d, %d]", new Object[]{this.opD.asP(), Boolean.valueOf(z2), Long.valueOf(sC), Integer.valueOf(i)});
        this.oqe.setState(6);
        setState(6);
        if (z2) {
            this.opD.ops = (long) i;
        } else {
            this.opD.ops = sC;
        }
        sE(6);
        a(this.opZ, SystemClock.elapsedRealtime(), 0);
    }

    public final void stop() {
        setState(8);
    }

    public final void release() {
        setState(9);
        this.oqb.removeMessages(2);
        this.oqb.removeMessages(9);
        this.opZ.removeMessages(1);
        this.opZ.removeMessages(2);
        this.opZ.removeMessages(3);
        this.opZ.removeMessages(4);
        this.opZ.removeMessages(6);
        this.opZ.removeCallbacksAndMessages(null);
        try {
            this.oqe.setState(9);
            x.i("MicroMsg.VideoTrackDataSource", "%s isConfigureSurface [%b]", new Object[]{r0.asP(), Boolean.valueOf(this.oqe.oql)});
            if (this.oqe.oql && d.fO(19)) {
                this.oqe.kL();
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.VideoPlayerImpl", e, "release error %s", new Object[]{e.toString()});
        }
        this.opZ.obtainMessage(7).sendToTarget();
        if (this.oqa != null) {
            this.oqa.removeMessages(1);
            this.oqa.removeMessages(2);
            this.oqa.removeMessages(3);
            this.oqa.removeMessages(4);
            this.oqa.removeMessages(6);
            this.oqa.obtainMessage(7).sendToTarget();
        }
        g gVar = this.opD;
        gVar.opq = 0;
        gVar.opr = 0;
        gVar.ops = -1;
        gVar.aep = 0;
        gVar.opt = 0;
        gVar.opu = 0;
    }

    protected final void setState(int i) {
        x.i("MicroMsg.VideoPlayerImpl", "%s set state old %d new %d stack %s", new Object[]{this.opD.asP(), Integer.valueOf(this.state), Integer.valueOf(i), bh.cgy()});
        this.state = i;
        this.opD.opv = 0;
    }

    final void sE(int i) {
        x.i("MicroMsg.VideoPlayerImpl", "%s update positions state %d timeline[%d %d %d]", new Object[]{this.opD.asP(), Integer.valueOf(i), Long.valueOf(this.opD.opq), Long.valueOf(this.opD.opr), Long.valueOf(this.opD.aep)});
        g gVar;
        switch (i) {
            case 3:
                if (this.opD.opr > 0) {
                    gVar = this.opD;
                    gVar.aep += this.opD.opr - this.opD.opq;
                    this.opD.opr = 0;
                }
                this.opD.opq = SystemClock.elapsedRealtime();
                break;
            case 4:
                if (this.opD.opq > 0) {
                    this.opD.opr = SystemClock.elapsedRealtime();
                    break;
                }
                this.opD.opr = 0;
                break;
            case 5:
                this.opD.aep = this.opD.ops;
                this.opD.opq = SystemClock.elapsedRealtime();
                this.opD.opr = 0;
                gVar = this.opD;
                this.opD.opu = 0;
                gVar.opt = 0;
                break;
            case 6:
                this.opD.aep = this.opD.ops;
                gVar = this.opD;
                this.opD.opr = 0;
                gVar.opq = 0;
                gVar = this.opD;
                this.opD.opu = 0;
                gVar.opt = 0;
                break;
            case 7:
                this.opD.aep = this.opD.ops;
                gVar = this.opD;
                this.opD.opr = 0;
                gVar.opq = 0;
                break;
        }
        this.oqc = this.opD.opq;
        this.aep = this.opD.aep;
        x.i("MicroMsg.VideoPlayerImpl", "%s update positions end state[%d] ms[%d, %d]", new Object[]{this.opD.asP(), Integer.valueOf(i), Long.valueOf(this.oqc), Long.valueOf(this.aep)});
    }

    private void a(af afVar, long j, long j2) {
        if (!d.sy(this.state)) {
            try {
                Thread thread = afVar.getLooper().getThread();
                if (!(thread == null || thread.isAlive())) {
                    return;
                }
            } catch (Exception e) {
            }
            afVar.removeMessages(2);
            long elapsedRealtime = (j + j2) - SystemClock.elapsedRealtime();
            if (elapsedRealtime <= 0) {
                afVar.sendEmptyMessage(2);
            } else {
                afVar.sendEmptyMessageDelayed(2, elapsedRealtime);
            }
        }
    }
}
