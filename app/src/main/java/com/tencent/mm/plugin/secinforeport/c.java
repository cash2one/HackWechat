package com.tencent.mm.plugin.secinforeport;

import android.content.Context;
import com.tencent.c.a.d.1;
import com.tencent.c.e.a.e;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.u;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.protocal.c.bcg;
import com.tencent.mm.protocal.c.bch;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Random;

enum c implements com.tencent.mm.plugin.secinforeport.a.c {
    ;

    private c(String str) {
    }

    public final boolean G(int i, long j) {
        return a.G(i, j);
    }

    public final void IX(String str) {
        int nextInt = new Random().nextInt();
        int length = str.length();
        int i = (length / 1000) + (length % 1000 > 0 ? 1 : 0);
        int i2 = 0;
        int i3 = 0;
        while (i2 < str.length()) {
            int min = Math.min(1000, length - i2);
            d.pPH.a(13690, nextInt + "," + i + "," + i3 + ",0,0" + ",," + str.substring(i2, i2 + min), false, true);
            i2 += min;
            i3++;
        }
        x.d("MicroMsg.SecInfoReporterImpl", "kvreport: ctxId: %d, dataLen: %d, pkgCount: %d", Integer.valueOf(nextInt), Integer.valueOf(length), Integer.valueOf(i));
    }

    public final void bX(String str, int i) {
        aB(i, str);
    }

    public final void IY(String str) {
        aB(Integer.MIN_VALUE, str);
    }

    public final void bqp() {
        e.cDy().vo();
        Context context = ac.getContext();
        e.cDy().a(context, q.yE(), new 1(new 1(this), new com.tencent.c.b.c(context)));
    }

    private void aB(int i, String str) {
        a aVar = new a();
        aVar.uri = com.tencent.mm.plugin.normsg.a.d.oSu.GG("Q\u001e\u001b\u0012W\u001b\u0011\u0019Y\u0018\u001d\u0010\u0000\u001e\u001d\u001c\t@\u000e\u0002\u0004F\u001a\u0002\u0016\n\u0016\u0017\u0001\r\t:0)?3?:3");
        aVar.hmi = 771;
        aVar.hmj = new bcg();
        aVar.hmk = new bch();
        b JZ = aVar.JZ();
        bcg com_tencent_mm_protocal_c_bcg = (bcg) JZ.hmg.hmo;
        com_tencent_mm_protocal_c_bcg.wIx = i;
        com_tencent_mm_protocal_c_bcg.wIw = str;
        d.pPH.a(416, 0, 1, false);
        u.a(JZ, new 2(this, i), false);
    }
}
