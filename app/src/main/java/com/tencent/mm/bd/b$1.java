package com.tencent.mm.bd;

import android.os.Handler;
import android.text.TextUtils;
import com.d.a.a.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;

class b$1 implements Runnable {
    final /* synthetic */ int hLF;
    final /* synthetic */ float hLG;
    final /* synthetic */ float hLH;
    final /* synthetic */ int hLI;
    final /* synthetic */ int hLJ;
    final /* synthetic */ int hLK = 0;
    final /* synthetic */ String hLL;
    final /* synthetic */ String hLM;
    final /* synthetic */ b hLN;

    public b$1(b bVar, int i, float f, float f2, int i2, int i3, int i4, String str, String str2) {
        this.hLN = bVar;
        this.hLF = i;
        this.hLG = f;
        this.hLH = f2;
        this.hLI = i2;
        this.hLJ = i3;
        this.hLL = str;
        this.hLM = str2;
    }

    public final void run() {
        if (b.a(this.hLN)) {
            x.d("MicroMsg.SenseWhereHelper", "it is collection now, do not start sense where sdk.");
        } else if (b.b(this.hLN)) {
            b.Ro();
            if (b.c(this.hLN).size() == 0 && b.d(this.hLN).size() == 0) {
                b.e(this.hLN);
            }
            if (b.a(this.hLN, this.hLF, this.hLG, this.hLH)) {
                x.i("MicroMsg.SenseWhereHelper", "it begin to start sense where sdk to upload location info.[%d, %f, %f, %d]", new Object[]{Integer.valueOf(this.hLF), Float.valueOf(this.hLG), Float.valueOf(this.hLH), Integer.valueOf(this.hLI)});
                b.a(this.hLN, true);
                g.Dj().CU().a(a.xsj, Long.valueOf(bh.Wo()));
                com.tencent.mm.sdk.b.a.xef.b(b.f(this.hLN));
                if (b.g(this.hLN) != null) {
                    b.g(this.hLN).finish();
                }
                b.h(this.hLN);
                b.a(this.hLN, bh.Wq());
                b.a(this.hLN, new c(this.hLG, this.hLH, this.hLJ, this.hLK, this.hLL, this.hLM, this.hLF, this.hLI));
                Object Rp = b.Rp();
                if (TextUtils.isEmpty(Rp)) {
                    throw new NullPointerException("SenseWhereEngine:invalid imei!");
                }
                t.setImei(Rp);
                t.a(ac.getContext(), b.g(this.hLN));
                Handler i = b.i(this.hLN);
                int i2 = this.hLN.hLt;
                t.a(i, (long) this.hLN.hLu, b.j(this.hLN), b.k(this.hLN));
                b.Rq();
                b.a(this.hLN, this.hLN.hLv);
            }
        } else {
            x.d("MicroMsg.SenseWhereHelper", "it do not start sense where sdk by config.");
        }
    }
}
