package com.tencent.mm.plugin.nearlife.b;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.adj;
import com.tencent.mm.protocal.c.adk;
import com.tencent.mm.protocal.c.aof;
import com.tencent.mm.protocal.c.aog;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public final class c extends k implements com.tencent.mm.network.k {
    public static Vector<String> oPF = new Vector();
    public int fut = 0;
    private final b gJQ;
    private e gJT;
    public String iRN = "";
    public int nQP;
    public String oPG = "";
    public String oPH = "";
    public List<a> oPI;
    public boolean oPJ;

    public static boolean tQ(int i) {
        String valueOf = String.valueOf(i);
        if (oPF.contains(valueOf)) {
            return false;
        }
        oPF.add(valueOf);
        return true;
    }

    public static boolean tR(int i) {
        oPF.remove(String.valueOf(i));
        return true;
    }

    public static void clear() {
        oPF.clear();
    }

    public c(int i, int i2, float f, float f2, int i3, int i4, String str, String str2, bdn com_tencent_mm_protocal_c_bdn, String str3, int i5, boolean z) {
        this.oPG = str3;
        if (!(i == 0 || i == 1)) {
            x.e("MicroMsg.NetSceneGetLbsLifeList", "OpCode Error :" + i);
        }
        this.fut = i;
        a aVar = new a();
        aVar.hmj = new adj();
        aVar.hmk = new adk();
        aVar.uri = "/cgi-bin/micromsg-bin/getlbslifelist";
        aVar.hmi = 603;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        adj com_tencent_mm_protocal_c_adj = (adj) this.gJQ.hmg.hmo;
        aog com_tencent_mm_protocal_c_aog = new aog();
        com_tencent_mm_protocal_c_aog.wct = str2;
        com_tencent_mm_protocal_c_aog.wcu = i4;
        com_tencent_mm_protocal_c_aog.vQu = f2;
        com_tencent_mm_protocal_c_aog.vQt = f;
        com_tencent_mm_protocal_c_aog.wcs = str;
        com_tencent_mm_protocal_c_aog.wcr = i3;
        com_tencent_mm_protocal_c_adj.vYA = com_tencent_mm_protocal_c_aog;
        com_tencent_mm_protocal_c_adj.wgS = str3;
        com_tencent_mm_protocal_c_adj.rYW = i2;
        com_tencent_mm_protocal_c_adj.wlP = i5;
        if (com_tencent_mm_protocal_c_bdn == null) {
            com_tencent_mm_protocal_c_adj.wlO = new bdn().bj(new byte[0]);
        } else {
            com_tencent_mm_protocal_c_adj.wlO = com_tencent_mm_protocal_c_bdn;
        }
        com_tencent_mm_protocal_c_adj.vJL = i;
        com_tencent_mm_protocal_c_adj.wlQ = 1;
        this.oPJ = z;
        x.d("MicroMsg.NetSceneGetLbsLifeList", "Req: opcode:" + i + " lon:" + f + " lat:" + f2 + " pre:" + i3 + " gpsSource:" + i4 + " mac" + str + " cell:" + str2 + " scene: " + i2 + " entryTime: " + i5);
        x.d("MicroMsg.NetSceneGetLbsLifeList", "isLoadMore: %s, buf: %s", new Object[]{Boolean.valueOf(z), Integer.valueOf(com_tencent_mm_protocal_c_adj.wlO.wJB)});
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final int getType() {
        return 603;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetLbsLifeList", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        adk com_tencent_mm_protocal_c_adk = (adk) ((b) qVar).hmh.hmo;
        this.iRN = com_tencent_mm_protocal_c_adk.vPs;
        this.nQP = com_tencent_mm_protocal_c_adk.wlY;
        x.d("MicroMsg.NetSceneGetLbsLifeList", "resp " + com_tencent_mm_protocal_c_adk.wlV + "searchId " + this.iRN);
        int i4 = (i3 == 0 || i3 == 101) ? 1 : 0;
        if (i2 == 0 || i4 != 0) {
            x.d("MicroMsg.NetSceneGetLbsLifeList", "continueFlag %d lifeCount %d linkCount %d %s", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_adk.vPq), Integer.valueOf(com_tencent_mm_protocal_c_adk.wlV), Integer.valueOf(com_tencent_mm_protocal_c_adk.wlT), com_tencent_mm_protocal_c_adk.wlX});
            this.oPH = bh.az(com_tencent_mm_protocal_c_adk.wlX, "");
            this.oPI = new ArrayList();
            Iterator it = com_tencent_mm_protocal_c_adk.wlW.iterator();
            while (it.hasNext()) {
                this.oPI.add(new a(com_tencent_mm_protocal_c_adk.vPs, (aof) it.next()));
            }
            if (com_tencent_mm_protocal_c_adk.wlV > 0) {
                aof com_tencent_mm_protocal_c_aof = (aof) com_tencent_mm_protocal_c_adk.wlW.get(0);
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(" Bid " + com_tencent_mm_protocal_c_aof.oPt);
                stringBuffer.append(" title " + com_tencent_mm_protocal_c_aof.fon);
                stringBuffer.append(" link " + com_tencent_mm_protocal_c_aof.oPA);
                stringBuffer.append(" price " + com_tencent_mm_protocal_c_aof.oPu);
                stringBuffer.append(" rate " + com_tencent_mm_protocal_c_aof.oPz);
                stringBuffer.append(" type " + com_tencent_mm_protocal_c_aof.ktN);
                stringBuffer.append(" desc : ");
                it = com_tencent_mm_protocal_c_aof.oPy.iterator();
                while (it.hasNext()) {
                    stringBuffer.append(((bdo) it.next()).wJF + "-");
                }
                x.d("MicroMsg.NetSceneGetLbsLifeList", "resp one %s ", new Object[]{stringBuffer.toString()});
            }
            this.gJT.a(i2, i3, str, this);
            return;
        }
        this.gJT.a(i2, i3, str, this);
    }

    public final bdn bfa() {
        bdn com_tencent_mm_protocal_c_bdn = ((adk) this.gJQ.hmh.hmo).wlO;
        return com_tencent_mm_protocal_c_bdn == null ? new bdn().bj(new byte[0]) : com_tencent_mm_protocal_c_bdn;
    }

    public final int bfb() {
        return ((adk) this.gJQ.hmh.hmo).vPq;
    }
}
