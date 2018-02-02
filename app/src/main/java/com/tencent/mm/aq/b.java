package com.tencent.mm.aq;

import android.net.TrafficStats;
import android.os.Looper;
import android.os.Process;
import android.text.format.DateFormat;
import com.tencent.mm.ae.k;
import com.tencent.mm.aq.d.a;
import com.tencent.mm.g.a.ll;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import java.util.Stack;

public final class b implements a {
    private a hzk;
    public Stack<Long> hzl;
    long hzm = 0;
    public int hzn = 0;
    boolean hzo = false;
    public long hzp = 0;
    int hzq = 0;
    boolean hzr = false;
    long hzs = 0;
    long hzt = 0;
    int hzu;
    int hzv;
    ak hzw = new ak(new 1(this), false);
    c hzx = new c<ll>(this) {
        final /* synthetic */ b hzz;

        {
            this.hzz = r2;
            this.xen = ll.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            ll llVar = (ll) bVar;
            this.hzz.hzq = (llVar.fCN.fCO ? 1 : -1) + this.hzz.hzq;
            if (this.hzz.hzq < 0) {
                this.hzz.hzq = 0;
                x.e("MicroMsg.AutoGetBigImgLogic", "mPauseCnt < 0");
            }
            x.i("MicroMsg.AutoGetBigImgLogic", "req pause: " + llVar.fCN.fCO + " count:" + this.hzz.hzq);
            this.hzz.start();
            return false;
        }
    };
    c hzy = new 3(this);

    public b(Looper looper) {
        this.hzk = new a(this, looper);
        this.hzl = new Stack();
        this.hzu = Process.myUid();
        Integer num = (Integer) g.Dj().CU().get(327681, null);
        int intValue = (num == null || 3 == num.intValue()) ? 1 : num.intValue();
        this.hzv = intValue;
        com.tencent.mm.sdk.b.a.xef.b(this.hzx);
        com.tencent.mm.sdk.b.a.xef.b(this.hzy);
    }

    public final void start() {
        this.hzk.sendEmptyMessage(1);
    }

    public final void bD(boolean z) {
        x.d("MicroMsg.AutoGetBigImgLogic", "is foreground: " + z);
        this.hzo = z;
        this.hzp = System.currentTimeMillis();
    }

    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, k kVar) {
    }

    public static void a(long j, long j2, boolean z) {
        if (!z) {
            x.i("MicroMsg.AutoGetBigImgLogic", "imglocalId " + j + " msglocalid " + j2 + " false");
        } else if (an.isWifi(ac.getContext())) {
            x.v("MicroMsg.AutoGetBigImgLogic", "is wifi pass count");
        } else {
            long a = bh.a((Long) g.Dj().CU().get(w.a.USERINFO_AUTOGETBIG_IMG_CURRENT_LONG, null), 0);
            long VJ = bh.VJ((String) DateFormat.format("M", System.currentTimeMillis()));
            x.d("MicroMsg.AutoGetBigImgLogic", "img " + j + " msgLocalId: " + j2 + " has been downloaded current %d month %d", Long.valueOf(1 + a), Long.valueOf(VJ));
            g.Dj().CU().a(w.a.USERINFO_AUTOGETBIG_IMG_CURRENT_LONG, Long.valueOf(a + 1));
            g.Dj().CU().a(w.a.USERINFO_AUTOGETBIG_IMG_CURRENT_DATE_LONG, Long.valueOf(VJ));
        }
    }

    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, String str, k kVar) {
        if (i3 == 0 && i4 == 0) {
            a(j, j2, true);
        } else {
            x.e("MicroMsg.AutoGetBigImgLogic", "img " + j + "msgLocalId " + j2 + " download failed");
        }
        this.hzm = 0;
        com.tencent.mm.modelcontrol.c.MR();
        if (com.tencent.mm.modelcontrol.c.MS()) {
            this.hzs = TrafficStats.getUidRxBytes(this.hzu);
            this.hzt = TrafficStats.getUidTxBytes(this.hzu);
            this.hzw.J(1000, 1000);
            return;
        }
        x.d("MicroMsg.AutoGetBigImgLogic", "don't allow auto download, clear task list");
        synchronized (this.hzl) {
            this.hzl.clear();
        }
    }

    public final void a(long j, long j2, int i, int i2, Object obj) {
        x.i("MicroMsg.AutoGetBigImgLogic", "img " + j + " has been canceled");
    }
}
