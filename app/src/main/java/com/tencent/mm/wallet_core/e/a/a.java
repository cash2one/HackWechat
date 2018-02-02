package com.tencent.mm.wallet_core.e.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.network.e;
import com.tencent.mm.protocal.c.awv;
import com.tencent.mm.protocal.c.aww;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.h;
import com.tencent.mm.wallet_core.c.m;
import com.tencent.mm.z.q;
import com.tenpay.android.wechat.TenpayUtil;
import java.net.URLEncoder;

public abstract class a extends h {
    public abstract int bKL();

    public final int bKu() {
        return bKL();
    }

    public final void F(boolean z, boolean z2) {
        b bVar = this.gJQ;
        if (bVar == null) {
            com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
            aVar.hmj = new awv();
            aVar.hmk = new aww();
            aVar.uri = "/cgi-bin/mmpay-bin/payu";
            aVar.hmi = 1518;
            aVar.hml = 0;
            aVar.hmm = 0;
            bVar = aVar.JZ();
            bVar.hmx = true;
        }
        b bVar2 = bVar;
        awv com_tencent_mm_protocal_c_awv = (awv) bVar2.hmg.hmo;
        if (z) {
            com_tencent_mm_protocal_c_awv.wru = bKL();
        }
        if (z2) {
            com_tencent_mm_protocal_c_awv.wrv = 1;
        }
        this.gJQ = bVar2;
    }

    public final int getType() {
        return 1518;
    }

    public final String MP(String str) {
        return TenpayUtil.signWith3Des(str);
    }

    public final void a(b bVar, bdn com_tencent_mm_protocal_c_bdn) {
        ((awv) bVar.hmg.hmo).wrw = com_tencent_mm_protocal_c_bdn;
    }

    public final void b(b bVar, bdn com_tencent_mm_protocal_c_bdn) {
        ((awv) bVar.hmg.hmo).wEj = com_tencent_mm_protocal_c_bdn;
    }

    public final m d(b bVar) {
        aww com_tencent_mm_protocal_c_aww = (aww) bVar.hmh.hmo;
        m mVar = new m();
        mVar.wrA = com_tencent_mm_protocal_c_aww.wrA;
        mVar.wrz = com_tencent_mm_protocal_c_aww.wrz;
        mVar.wry = com_tencent_mm_protocal_c_aww.wry;
        mVar.wrx = com_tencent_mm_protocal_c_aww.wrx;
        mVar.lOs = com_tencent_mm_protocal_c_aww.wEl;
        mVar.zHA = com_tencent_mm_protocal_c_aww.wEk;
        return mVar;
    }

    public int a(e eVar, com.tencent.mm.ae.e eVar2) {
        this.gJT = eVar2;
        if (q.Gf()) {
            return a(eVar, this.gJQ, this);
        }
        x.e("MicroMsg.NetScenePayUBase", "hy: serious error: not payupay");
        eVar2.a(1000, -100868, "Pay Method Err", this);
        return 1;
    }

    public final void b(StringBuilder stringBuilder, String str) {
        stringBuilder.append(URLEncoder.encode(str));
    }
}
