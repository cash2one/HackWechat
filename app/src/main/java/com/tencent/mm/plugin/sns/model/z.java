package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.c.bjv;
import com.tencent.mm.protocal.c.bla;
import com.tencent.mm.protocal.c.blb;
import com.tencent.mm.protocal.c.blc;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.TXLiveConstants;
import java.util.Vector;

public final class z extends k implements com.tencent.mm.network.k, d {
    private static Vector<String> qUP = new Vector();
    private final int fqd;
    private boolean fuf;
    private b gJQ;
    public e gJT;
    private boolean qTK;
    private long qTL = 0;
    long qTM = 0;
    public int qTO = 0;
    private long qUD = 0;
    private boolean qUE = false;
    private boolean qUF = false;
    private int qUQ = 0;
    private boolean qUR = false;
    private boolean qUS = false;
    public long qUT;
    private String qUm = "";
    String userName;

    public static synchronized boolean Kf(String str) {
        boolean z;
        synchronized (z.class) {
            if (qUP.contains(str)) {
                z = false;
            } else {
                qUP.add(str);
                z = true;
            }
        }
        return z;
    }

    public static synchronized boolean Kg(String str) {
        synchronized (z.class) {
            qUP.remove(str);
        }
        return true;
    }

    public z(String str, long j, boolean z, int i) {
        long j2 = 0;
        boolean z2 = false;
        this.userName = str;
        this.qTL = j;
        this.fuf = z;
        if (j == 0) {
            x.i("MicroMsg.NetSceneSnsUserPage", "fp userName " + str);
        } else {
            x.i("MicroMsg.NetSceneSnsUserPage", "np userName " + str);
        }
        this.fqd = z ? 4 : 8;
        a aVar = new a();
        aVar.hmj = new blb();
        aVar.hmk = new blc();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnsuserpage";
        aVar.hmi = com.tencent.mm.plugin.appbrand.jsapi.bio.face.b.CTRL_INDEX;
        aVar.hml = 99;
        aVar.hmm = 1000000099;
        this.gJQ = aVar.JZ();
        blb com_tencent_mm_protocal_c_blb = (blb) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_blb.vIy = str;
        com_tencent_mm_protocal_c_blb.wMK = j;
        if (j == 0) {
            z2 = true;
        }
        this.qTK = z2;
        int Kp = ae.bvl().Kp(str);
        n bvv = ae.bvv();
        if (!this.qTK) {
            j2 = j;
        }
        this.qTM = bvv.a(j2, Kp, str, z);
        com_tencent_mm_protocal_c_blb.wOg = this.qTM;
        int a = c.a(this.qTM, j, str);
        com_tencent_mm_protocal_c_blb.wOh = a;
        com_tencent_mm_protocal_c_blb.vHW = i;
        if (this.qTK) {
            this.qUm = ae.bvz().Lq(str).field_md5;
            if (this.qUm == null) {
                this.qUm = "";
            }
            com_tencent_mm_protocal_c_blb.wMJ = this.qUm;
        }
        this.qUD = j;
        x.i("MicroMsg.NetSceneSnsUserPage", "nextCount: " + Kp + " maxId:" + i.eq(j) + " minId:" + i.eq(this.qTM) + " lastReqTime:" + a + " snsSource " + i);
    }

    private void buS() {
        n bvv = ae.bvv();
        String str = this.userName;
        boolean z = this.fuf;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select snsId from SnsInfo ").append(n.aG(str, z)).append(" AND type in ( 1,2 , 3 , 4 , 18 , 5 , 12 , 9 , 14 , 15 , 13 , 21 , 25 , 26) and  (snsId != 0  )  limit ").append(4);
        Cursor rawQuery = bvv.gJP.rawQuery(stringBuilder.toString(), null);
        int count = rawQuery.getCount();
        rawQuery.close();
        if (count <= 3 && count > 0) {
            this.qUF = true;
        } else if (count == 0) {
            this.qUE = true;
        }
    }

    private void a(blc com_tencent_mm_protocal_c_blc, String str) {
        ai.a(this.userName, this.fqd, com_tencent_mm_protocal_c_blc.vLo, str);
        if (this.qTL == 0) {
            this.qTL = ((bjv) com_tencent_mm_protocal_c_blc.vLo.getFirst()).vPO;
        } else {
            this.qTL = c.eu(this.qTL);
        }
        this.qTM = ((bjv) com_tencent_mm_protocal_c_blc.vLo.getLast()).vPO;
        x.i("MicroMsg.NetSceneSnsUserPage", "insertListAndUpdateFaultInfo userName %s maxId %s minId %s NewRequestTime %s", new Object[]{this.userName, Long.valueOf(this.qTL), Long.valueOf(this.qTM), Integer.valueOf(com_tencent_mm_protocal_c_blc.wOk)});
        c.d(this.userName, this.qTL, this.qTM, com_tencent_mm_protocal_c_blc.wOk);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneSnsUserPage", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        blc com_tencent_mm_protocal_c_blc = (blc) ((b) qVar).hmh.hmo;
        if (qVar.Hp().vBp == 207 || qVar.Hp().vBp == 203 || qVar.Hp().vBp == 0 || qVar.Hp().vBp == 2001 || qVar.Hp().vBp == TXLiveConstants.PLAY_EVT_PLAY_BEGIN || qVar.Hp().vBp == 2003) {
            String str2;
            if (qVar.Hp().vBp == 2003) {
                n bvv = ae.bvv();
                str2 = this.userName;
                boolean fx = bvv.gJP.fx("SnsInfo", "DELETE FROM SnsInfo" + " where SnsInfo.userName=\"" + bh.ot(str2) + "\"");
                x.d("MicroMsg.SnsInfoStorage", "del snsinfo " + str2 + " res " + fx);
                Boolean.valueOf(fx);
            }
            this.qTO = com_tencent_mm_protocal_c_blc.wMN;
            x.i("MicroMsg.NetSceneSnsUserPage", "for same md5 count: " + com_tencent_mm_protocal_c_blc.wMN + " , objCount:  " + com_tencent_mm_protocal_c_blc.wzD);
            this.qUT = com_tencent_mm_protocal_c_blc.wOu;
            str2 = i.er(this.qTL);
            if (!this.qTK) {
                x.d("MicroMsg.NetSceneSnsUserPage", "np  " + com_tencent_mm_protocal_c_blc.vLo.size());
                if (com_tencent_mm_protocal_c_blc.vLo.isEmpty()) {
                    this.qUS = qVar.Hp().vBp == 203;
                    ae.bvv().a(this.userName, this.fuf, str2);
                    this.qUE = true;
                    this.qTM = this.qTL;
                } else {
                    a(com_tencent_mm_protocal_c_blc, str2);
                }
                Kg(this.userName);
                this.gJT.a(i2, i3, str, this);
                return;
            } else if (this.qUm.equals(com_tencent_mm_protocal_c_blc.wMJ)) {
                this.qTM = ae.bvv().a(this.qTK ? 0 : this.qUD, this.qTO, this.userName, this.fuf);
                x.i("MicroMsg.NetSceneSnsUserPage", "md5 is nochange the new minid %s", new Object[]{Long.valueOf(this.qTM)});
                buS();
                Kg(this.userName);
                com.tencent.mm.plugin.sns.storage.k Lq = ae.bvz().Lq(this.userName);
                this.gJT.a(Lq.field_lastFirstPageRequestErrType, Lq.field_lastFirstPageRequestErrCode, str, this);
                return;
            } else {
                String eq;
                String str3;
                x.i("MicroMsg.NetSceneSnsUserPage", "fp  " + com_tencent_mm_protocal_c_blc.vLo.size());
                if (this.qTK && !this.qUm.equals(com_tencent_mm_protocal_c_blc.wMJ)) {
                    this.qUQ = com_tencent_mm_protocal_c_blc.wOt;
                    com.tencent.mm.plugin.sns.storage.k Lq2 = ae.bvz().Lq(this.userName);
                    Lq2.field_icount = this.qUQ;
                    bla com_tencent_mm_protocal_c_bla = com_tencent_mm_protocal_c_blc.wvl;
                    if (com_tencent_mm_protocal_c_bla != null) {
                        eq = i.eq(com_tencent_mm_protocal_c_bla.hvG);
                        String accSnsPath = ae.getAccSnsPath();
                        str3 = this.userName + "bg_";
                        String str4 = this.userName + "tbg_";
                        if (Lq2.field_bgUrl == null || !Lq2.field_bgId.equals(eq)) {
                            Lq2.field_older_bgId = Lq2.field_bgId;
                            if (FileOp.bO(am.r(accSnsPath, this.userName) + str3)) {
                                FileOp.deleteFile(am.r(accSnsPath, this.userName) + str4);
                                FileOp.g(am.r(accSnsPath, this.userName), str3, str4);
                            }
                            this.qUR = true;
                            Lq2.bye();
                            x.d("MicroMsg.NetSceneSnsUserPage", "get new  bgid " + com_tencent_mm_protocal_c_bla.hvF);
                        }
                        Lq2.field_bgId = eq;
                        Lq2.field_bgUrl = com_tencent_mm_protocal_c_bla.hvF;
                        Lq2.field_snsBgId = com_tencent_mm_protocal_c_bla.hvG;
                    }
                    ae.bvz().a(Lq2);
                }
                ae.bvz().m(this.userName, com_tencent_mm_protocal_c_blc.wMJ, i2, i3);
                if (qVar.Hp().vBp == 207 || qVar.Hp().vBp == 2001 || qVar.Hp().vBp == TXLiveConstants.PLAY_EVT_PLAY_BEGIN) {
                    ae.bvz().em(this.userName, "");
                    String str5;
                    if (com_tencent_mm_protocal_c_blc.vLo.isEmpty()) {
                        n bvv2 = ae.bvv();
                        str5 = this.userName;
                        boolean z = this.fuf;
                        bvv2.i(z, n.aG(str5, z) + " AND  (snsId != 0  ) ");
                        this.qTM = this.qTL;
                    } else {
                        n bvv3 = ae.bvv();
                        eq = this.userName;
                        boolean z2 = this.fuf;
                        str3 = i.er(((bjv) com_tencent_mm_protocal_c_blc.vLo.getFirst()).vPO);
                        str5 = n.aG(eq, z2) + " AND  (snsId != 0  ) ";
                        if (n.Lu(str3)) {
                            str5 = str5 + " AND " + bvv3.Lx(str3);
                        }
                        bvv3.i(z2, str5);
                        ae.bvv().a(this.userName, this.fuf, i.er(((bjv) com_tencent_mm_protocal_c_blc.vLo.getLast()).vPO));
                        a(com_tencent_mm_protocal_c_blc, str2);
                    }
                    buS();
                    Kg(this.userName);
                    this.gJT.a(i2, i3, str, this);
                    return;
                } else if (com_tencent_mm_protocal_c_blc.vLo.size() == 0) {
                    x.d("MicroMsg.NetSceneSnsUserPage", "error: server give size zero");
                    this.gJT.a(i2, i3, str, this);
                    return;
                } else {
                    a(com_tencent_mm_protocal_c_blc, str2);
                    Kg(this.userName);
                    this.gJT.a(i2, i3, str, this);
                    return;
                }
            }
        }
        Kg(this.userName);
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return com.tencent.mm.plugin.appbrand.jsapi.bio.face.b.CTRL_INDEX;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final long buF() {
        return this.qTM;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final boolean buB() {
        return this.qTK;
    }

    public final boolean buC() {
        return this.qUE;
    }

    public final boolean buG() {
        return this.qUR;
    }

    public final boolean buE() {
        return this.qUS;
    }

    public final boolean buD() {
        return this.qUF;
    }

    public final long buH() {
        return this.qUT;
    }
}
