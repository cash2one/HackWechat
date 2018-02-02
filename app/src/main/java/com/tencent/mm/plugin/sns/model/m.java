package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.protocal.c.bji;
import com.tencent.mm.protocal.c.bjj;
import com.tencent.mm.protocal.c.bjv;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

public final class m extends k implements com.tencent.mm.network.k {
    private static Vector<String> qTN = new Vector();
    private String desc = "";
    final int fqd;
    private b gJQ;
    public e gJT;
    private boolean kMn = false;
    private ArrayList<com.tencent.mm.plugin.sns.storage.m> kNi = new ArrayList();
    private boolean qTK;
    private long qTL = 0;
    private long qTM = 0;
    public int qTO = 0;
    public int qTP = 0;

    public static synchronized boolean Kc(String str) {
        boolean z;
        synchronized (m.class) {
            if (qTN.contains(str)) {
                z = false;
            } else {
                qTN.add(str);
                z = true;
            }
        }
        return z;
    }

    public static synchronized boolean Kd(String str) {
        synchronized (m.class) {
            qTN.remove(str);
        }
        return true;
    }

    public m(String str) {
        a aVar = new a();
        aVar.hmj = new bji();
        aVar.hmk = new bjj();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnsclassifytimeline";
        aVar.hmi = 601;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        this.qTL = 0;
        this.qTK = 0 == 0;
        this.fqd = 2;
        bji com_tencent_mm_protocal_c_bji = (bji) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bji.wMJ = "";
        com_tencent_mm_protocal_c_bji.wMK = 0;
        com_tencent_mm_protocal_c_bji.wML = str;
        com_tencent_mm_protocal_c_bji.wMM = 1;
        x.d("MicroMsg.NetSceneSnsClassifyTimeLine", "maxid %s classifyid %s classifyType %d", new Object[]{i.eq(0), str, Integer.valueOf(0)});
    }

    private com.tencent.mm.plugin.sns.storage.m b(bjv com_tencent_mm_protocal_c_bjv) {
        com.tencent.mm.plugin.sns.storage.m mVar = new com.tencent.mm.plugin.sns.storage.m();
        String str = new String(com_tencent_mm_protocal_c_bjv.wMW.wJD.toByteArray());
        x.d("MicroMsg.NetSceneSnsClassifyTimeLine", "from server %d ", new Object[]{Long.valueOf(com_tencent_mm_protocal_c_bjv.vPO)});
        if (!mVar.Lk(str)) {
            return null;
        }
        com_tencent_mm_protocal_c_bjv.wMW.bj(new byte[0]);
        mVar.field_userName = com_tencent_mm_protocal_c_bjv.vIy;
        mVar.hK(com_tencent_mm_protocal_c_bjv.pbl);
        mVar.field_likeFlag = com_tencent_mm_protocal_c_bjv.wMX;
        mVar.eN(com_tencent_mm_protocal_c_bjv.vPO);
        mVar.eP(com_tencent_mm_protocal_c_bjv.vPO);
        mVar.xj(this.fqd);
        try {
            mVar.aJ(com_tencent_mm_protocal_c_bjv.toByteArray());
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NetSceneSnsClassifyTimeLine", e, "", new Object[0]);
        }
        bnp bxV = mVar.bxV();
        bxV.ksU = com_tencent_mm_protocal_c_bjv.vIy;
        mVar.field_pravited = bxV.wxG;
        x.d("MicroMsg.NetSceneSnsClassifyTimeLine", "ext flag " + com_tencent_mm_protocal_c_bjv.wzw);
        mVar.byn();
        mVar.c(bxV);
        mVar.field_type = bxV.wQo.vYc;
        mVar.field_subType = bxV.wQo.vYe;
        return mVar;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneSnsClassifyTimeLine", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        bjj com_tencent_mm_protocal_c_bjj = (bjj) ((b) qVar).hmh.hmo;
        if (qVar.Hp().vBp == 207 || qVar.Hp().vBp == 0 || qVar.Hp().vBp == com.tencent.mm.plugin.appbrand.jsapi.bio.face.b.CTRL_INDEX) {
            this.kMn = qVar.Hp().vBp == com.tencent.mm.plugin.appbrand.jsapi.bio.face.b.CTRL_INDEX;
            this.qTO = com_tencent_mm_protocal_c_bjj.wMN;
            this.desc = com_tencent_mm_protocal_c_bjj.vIO;
            i.er(this.qTL);
            x.d("MicroMsg.NetSceneSnsClassifyTimeLine", "resp objCount %d desc %s", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bjj.wzD), this.desc});
            Iterator it = com_tencent_mm_protocal_c_bjj.vLo.iterator();
            while (it.hasNext()) {
                com.tencent.mm.plugin.sns.storage.m b = b((bjv) it.next());
                if (b != null) {
                    this.kNi.add(b);
                }
            }
            Kd("@__classify_timeline");
            this.gJT.a(i2, i3, str, this);
            return;
        }
        Kd("@__classify_timeline");
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 601;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
