package com.tencent.mm.wallet_core.tenpay.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.wallet.d;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.bnl;
import com.tencent.mm.protocal.c.bnm;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.h;
import com.tencent.mm.wallet_core.c.m;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.c.s;
import com.tencent.mm.z.q;
import com.tenpay.android.wechat.TenpayUtil;
import java.util.Vector;
import org.json.JSONObject;

public abstract class i extends h {
    public static Vector<String> zIk = new Vector();
    protected boolean zIj = false;

    public abstract int ayQ();

    public int bKu() {
        return ayQ();
    }

    public void F(boolean z, boolean z2) {
        b JZ;
        b bVar = this.gJQ;
        if (bVar == null) {
            a aVar = new a();
            aVar.hmj = new bnl();
            aVar.hmk = new bnm();
            String uri = getUri();
            int Hr = Hr();
            aVar.uri = uri;
            aVar.hmi = Hr;
            aVar.hml = 185;
            aVar.hmm = 1000000185;
            JZ = aVar.JZ();
            JZ.hmx = !cBH();
        } else {
            JZ = bVar;
        }
        bnl com_tencent_mm_protocal_c_bnl = (bnl) JZ.hmg.hmo;
        if (z) {
            com_tencent_mm_protocal_c_bnl.wru = ayQ();
        }
        if (z2) {
            com_tencent_mm_protocal_c_bnl.wrv = 1;
        }
        this.gJQ = JZ;
    }

    public boolean cBH() {
        return true;
    }

    public int getType() {
        return 385;
    }

    public final String MP(String str) {
        return TenpayUtil.signWith3Des(str);
    }

    public final void a(b bVar, bdn com_tencent_mm_protocal_c_bdn) {
        ((bnl) bVar.hmg.hmo).wrw = com_tencent_mm_protocal_c_bdn;
    }

    public final void b(b bVar, bdn com_tencent_mm_protocal_c_bdn) {
        ((bnl) bVar.hmg.hmo).wEj = com_tencent_mm_protocal_c_bdn;
    }

    static {
        for (Object add : d.vzH) {
            zIk.add(add);
        }
    }

    public final m d(b bVar) {
        bnm com_tencent_mm_protocal_c_bnm = (bnm) bVar.hmh.hmo;
        m mVar = new m();
        mVar.wrA = com_tencent_mm_protocal_c_bnm.wrA;
        mVar.wrz = com_tencent_mm_protocal_c_bnm.wrz;
        mVar.wry = com_tencent_mm_protocal_c_bnm.wry;
        mVar.wrx = com_tencent_mm_protocal_c_bnm.wrx;
        mVar.lOs = com_tencent_mm_protocal_c_bnm.wEl;
        mVar.zHA = com_tencent_mm_protocal_c_bnm.wEk;
        return mVar;
    }

    private int e(b bVar) {
        bnl com_tencent_mm_protocal_c_bnl = (bnl) bVar.hmg.hmo;
        if (com_tencent_mm_protocal_c_bnl.wrw != null) {
            String str = new String(com_tencent_mm_protocal_c_bnl.wrw.wJD.oz);
        }
        if (com_tencent_mm_protocal_c_bnl.wEj != null) {
            str = new String(com_tencent_mm_protocal_c_bnl.wEj.wJD.oz);
        }
        s.cBB();
        if (!this.zIj) {
            return -1;
        }
        bnm com_tencent_mm_protocal_c_bnm = (bnm) bVar.hmh.hmo;
        if (com_tencent_mm_protocal_c_bnm == null) {
            com_tencent_mm_protocal_c_bnm = new bnm();
        }
        com_tencent_mm_protocal_c_bnm.wrx = new bdn().bj("".getBytes());
        com_tencent_mm_protocal_c_bnm.wrA = bKu();
        com_tencent_mm_protocal_c_bnm.wry = 0;
        try {
            JSONObject jSONObject = new JSONObject(null);
            com_tencent_mm_protocal_c_bnm.wEk = jSONObject.optInt("TenpayErrType");
            com_tencent_mm_protocal_c_bnm.wEl = jSONObject.optString("TenpayErrMsg");
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NetSenceTenPayBase", e, "", new Object[0]);
        }
        a(1, 0, 0, "", bVar, null);
        return 1;
    }

    public final void cBQ() {
        this.zIj = true;
    }

    public int a(e eVar, com.tencent.mm.ae.e eVar2) {
        this.gJT = eVar2;
        if (zIk.contains(this.gJQ.uri)) {
            x.d("MicroMsg.NetSenceTenPayBase", "black cgi bye bye %s", this.gJQ.uri);
        } else {
            Object[] objArr = new Object[1];
            com.tencent.mm.wallet_core.c.a.cBn();
            objArr[0] = Integer.valueOf(com.tencent.mm.wallet_core.c.a.getLastError());
            x.i("MicroMsg.NetSenceTenPayBase", "cert try get errormsg %s", objArr);
            long currentTimeMillis = System.currentTimeMillis();
            com.tencent.mm.wallet_core.c.a.cBn();
            com.tencent.mm.wallet_core.c.a.init(ac.getContext());
            bnl com_tencent_mm_protocal_c_bnl = (bnl) this.gJQ.hmg.hmo;
            String str = "";
            String str2 = "";
            if (com_tencent_mm_protocal_c_bnl.wrw != null) {
                str = new String(com_tencent_mm_protocal_c_bnl.wrw.wJD.oz);
            }
            if (com_tencent_mm_protocal_c_bnl.wEj != null) {
                str2 = new String(com_tencent_mm_protocal_c_bnl.wEj.wJD.oz);
            }
            String str3 = new String((str + "&&" + str2).getBytes());
            r.cBz();
            String cBy = r.cBy();
            com.tencent.mm.wallet_core.c.a.cBn();
            if (com.tencent.mm.wallet_core.c.a.isCertExist(cBy)) {
                g.pQN.a(414, 20, 1, true);
                com.tencent.mm.wallet_core.c.a.cBn();
                String genUserSig = com.tencent.mm.wallet_core.c.a.genUserSig(cBy, str3);
                g.pQN.a(414, 21, System.currentTimeMillis() - currentTimeMillis, true);
                x.v("MicroMsg.NetSenceTenPayBase", "sign ret src:%s sign:%s", str3, genUserSig);
                com_tencent_mm_protocal_c_bnl.sign = genUserSig;
                com_tencent_mm_protocal_c_bnl.wQi = cBy;
            } else {
                objArr = new Object[2];
                objArr[0] = cBy;
                com.tencent.mm.wallet_core.c.a.cBn();
                objArr[1] = Integer.valueOf(com.tencent.mm.wallet_core.c.a.getLastError());
                x.i("MicroMsg.NetSenceTenPayBase", "cert not exist cn %s %s", objArr);
            }
            x.i("MicroMsg.NetSenceTenPayBase", "sign cost time %s cn %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), cBy);
        }
        if (this.zIj) {
            int e = e(this.gJQ);
            if (e != -1) {
                return e;
            }
        }
        if (q.Gf()) {
            x.e("MicroMsg.NetSenceTenPayBase", "hy: serious error: is payupay");
            eVar2.a(1000, -100868, "Pay Method Err", this);
            return 1;
        }
        return a(eVar, this.gJQ, this);
    }

    public String getUri() {
        return "/cgi-bin/micromsg-bin/tenpay";
    }

    public int Hr() {
        return 385;
    }
}
