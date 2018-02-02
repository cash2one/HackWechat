package com.d.a.a;

import android.content.Context;
import android.os.Handler;
import com.d.a.a.x.a;

final class w extends n {
    private static w bmq;
    private boolean bmr;
    private int bms;
    private long bmt;
    private long bmu;

    static w sy() {
        if (bmq == null) {
            bmq = new w();
        }
        return bmq;
    }

    w() {
    }

    final void a(Context context, Handler handler, d$a com_d_a_a_d_a) {
        if (this.bmr) {
            if (k.rY().isReady) {
                k.rY().rU();
            }
        } else if (!k.rY().isReady) {
            try {
                k.rY().a(context, new m[]{this});
            } catch (Exception e) {
            }
        }
        super.a(context, handler, com_d_a_a_d_a);
    }

    final synchronized void a(Handler handler, d$a com_d_a_a_d_a) {
        this.bmr = false;
        super.a(handler, com_d_a_a_d_a);
    }

    public final void a(p pVar) {
        Object obj;
        long j = pVar.bjy;
        if (!this.bmr || j - this.bmu <= this.bmt) {
            obj = null;
        } else {
            stop();
            obj = 1;
        }
        if (obj == null) {
            super.a(pVar);
        }
    }

    final void a(x xVar, long j, long j2) {
        Object obj;
        if (xVar.bmz == null) {
            xVar.bmz = new a();
        }
        float f = xVar.bmz.bmC;
        if (!this.bmr || f < ((float) this.bms)) {
            obj = null;
        } else {
            stop();
            obj = 1;
        }
        if (obj == null) {
            super.a(xVar, j, j2);
        }
    }

    final void a(int i, String str, long j, long j2) {
        if (this.bmr) {
            stop();
        }
        super.a(i, str, j, j2);
    }
}
