package com.tencent.mm.plugin.s;

import android.os.Message;
import android.os.SystemClock;
import com.tencent.mm.sdk.platformtools.af.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class j$2 implements a {
    final /* synthetic */ j oqk;

    j$2(j jVar) {
        this.oqk = jVar;
    }

    public final boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
                if (!this.oqk.oqe.aZJ()) {
                    this.oqk.opE.obtainMessage(5, -1, -1).sendToTarget();
                    break;
                }
                this.oqk.aqA = this.oqk.oqe.aqA;
                j.a(this.oqk, this.oqk.opZ, SystemClock.elapsedRealtime(), 0);
                break;
            case 2:
                g gVar = this.oqk.opD;
                long bA = bh.bA(gVar.opv);
                if (gVar.opv > 0 && bA >= 30) {
                    x.w("MicroMsg.PlayTimeLine", "%s do some work delay 30ms!!![%d, %d]", new Object[]{gVar.asP(), Long.valueOf(gVar.opv), Long.valueOf(bA)});
                    gVar.opw = 0;
                }
                if (!d.sy(this.oqk.oqe.state)) {
                    boolean z;
                    int v = this.oqk.oqe.v(this.oqk.aep, this.oqk.oqc);
                    if (d.sv(v)) {
                        this.oqk.oqb.obtainMessage(2).sendToTarget();
                    }
                    if (v == 7) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        if (!d.sA(v)) {
                            if (this.oqk.state == 3) {
                                j.a(this.oqk, this.oqk.opZ, SystemClock.elapsedRealtime(), this.oqk.opD.opw);
                            } else if (this.oqk.state == 5) {
                                j.a(this.oqk, this.oqk.opZ, SystemClock.elapsedRealtime(), 0);
                            } else if (this.oqk.state == 1) {
                                j.a(this.oqk, this.oqk.opZ, SystemClock.elapsedRealtime(), 0);
                            } else if (this.oqk.state == 0) {
                                j.a(this.oqk, this.oqk.opZ, SystemClock.elapsedRealtime(), 0);
                            } else if (this.oqk.state == 6) {
                                j.a(this.oqk, this.oqk.opZ, SystemClock.elapsedRealtime(), 0);
                            } else {
                                this.oqk.opZ.removeMessages(2);
                            }
                            this.oqk.opD.opv = bh.Wq();
                            break;
                        }
                        j.a(this.oqk, this.oqk.opZ, SystemClock.elapsedRealtime(), 0);
                        this.oqk.opD.opv = bh.Wq();
                        break;
                    }
                    this.oqk.oqb.obtainMessage(7).sendToTarget();
                    this.oqk.opZ.removeMessages(2);
                    break;
                }
                this.oqk.oqb.obtainMessage(9).sendToTarget();
                this.oqk.opZ.removeMessages(2);
                break;
            case 3:
                this.oqk.sE(3);
                this.oqk.oqe.start();
                j.a(this.oqk, this.oqk.opZ, SystemClock.elapsedRealtime(), 0);
                break;
            case 4:
                this.oqk.sE(4);
                j.a(this.oqk, this.oqk.opZ, SystemClock.elapsedRealtime(), 0);
                this.oqk.oqe.pause();
                break;
            case 7:
                this.oqk.oqe.release();
                this.oqk.oqd = true;
                this.oqk.oqb.obtainMessage(0).sendToTarget();
                break;
        }
        return false;
    }
}
