package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.appbrand.jsapi.share.i;
import com.tencent.mm.protocal.c.bjv;
import com.tencent.mm.protocal.c.bjw;
import com.tencent.mm.protocal.c.bjx;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;
import java.util.Vector;

public final class p extends k implements com.tencent.mm.network.k {
    public static List<Long> qTJ = new Vector();
    public b gJQ;
    public e gJT;
    private long qQJ;

    public static boolean ev(long j) {
        if (qTJ.contains(Long.valueOf(j))) {
            return false;
        }
        qTJ.add(Long.valueOf(j));
        return true;
    }

    private static boolean ew(long j) {
        qTJ.remove(Long.valueOf(j));
        return true;
    }

    public p(long j) {
        this.qQJ = j;
        a aVar = new a();
        aVar.hmj = new bjw();
        aVar.hmk = new bjx();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnsobjectdetail";
        aVar.hmi = i.CTRL_INDEX;
        aVar.hml = 101;
        aVar.hmm = 1000000101;
        this.gJQ = aVar.JZ();
        ((bjw) this.gJQ.hmg.hmo).vPO = j;
        x.d("MicroMsg.NetSceneSnsObjectDetial", "req snsId " + j);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final int getType() {
        return i.CTRL_INDEX;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (i2 == 0 && i3 == 0) {
            bjv com_tencent_mm_protocal_c_bjv = ((bjx) this.gJQ.hmh.hmo).wNs;
            if (com_tencent_mm_protocal_c_bjv != null) {
                x.i("MicroMsg.NetSceneSnsObjectDetial", "snsdetail xml " + n.b(com_tencent_mm_protocal_c_bjv.wMW));
            }
            ai.d(com_tencent_mm_protocal_c_bjv);
            this.gJT.a(i2, i3, str, this);
            ew(this.qQJ);
            return;
        }
        this.gJT.a(i2, i3, str, this);
        ew(this.qQJ);
    }
}
