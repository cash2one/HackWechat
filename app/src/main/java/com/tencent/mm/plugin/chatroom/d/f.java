package com.tencent.mm.plugin.chatroom.d;

import com.tencent.mm.ad.h;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.b.af;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.aqv;
import com.tencent.mm.protocal.c.aqw;
import com.tencent.mm.protocal.c.pm;
import com.tencent.mm.protocal.c.pn;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.m;
import com.tencent.mm.z.q;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class f extends k implements com.tencent.mm.network.k {
    public int fAO = 0;
    public String fAP;
    public final List<String> fAQ;
    public final List<String> fAS;
    public List<String> fAT;
    public List<String> fAU;
    private final b gJQ;
    private e gJT;
    public final List<String> kZm;

    public f(String str, List<String> list) {
        x.d("MicroMsg.NetSceneCreateChatRoom", "topic : " + str + " size : " + list.size() + " username : " + ((String) list.get(0)));
        a aVar = new a();
        aVar.hmj = new pm();
        aVar.hmk = new pn();
        aVar.uri = "/cgi-bin/micromsg-bin/createchatroom";
        aVar.hmi = 119;
        aVar.hml = 37;
        aVar.hmm = 1000000037;
        this.gJQ = aVar.JZ();
        pm pmVar = (pm) this.gJQ.hmg.hmo;
        pmVar.vYu = n.os(str);
        LinkedList linkedList = new LinkedList();
        for (String str2 : list) {
            aqv com_tencent_mm_protocal_c_aqv = new aqv();
            com_tencent_mm_protocal_c_aqv.vYO = n.os(str2);
            linkedList.add(com_tencent_mm_protocal_c_aqv);
        }
        pmVar.vGF = linkedList;
        pmVar.kZx = linkedList.size();
        this.fAQ = new LinkedList();
        this.kZm = new LinkedList();
        this.fAS = new LinkedList();
        this.fAT = new LinkedList();
        this.fAU = new LinkedList();
        this.fAP = "";
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final int getType() {
        return 119;
    }

    private static boolean a(pn pnVar) {
        if (!n.a(pnVar.vGG).toLowerCase().endsWith("@chatroom") || pnVar.kZx == 0) {
            x.e("MicroMsg.NetSceneCreateChatRoom", "CreateChatroom: room:[" + pnVar.vGG + "] listCnt:" + pnVar.kZx);
            return false;
        }
        af xVar = new com.tencent.mm.storage.x();
        xVar.dc(n.a(pnVar.vYu));
        xVar.dd(n.a(pnVar.vYw));
        xVar.de(n.a(pnVar.vYx));
        xVar.setUsername(n.a(pnVar.vGG));
        ar.Hg();
        com.tencent.mm.storage.ar EY = c.EY();
        if (!EY.WQ(xVar.field_username)) {
            EY.R(xVar);
        }
        h hVar = new h();
        hVar.username = xVar.field_username;
        hVar.hly = pnVar.vUU;
        hVar.hlx = pnVar.vUV;
        hVar.fWe = 3;
        hVar.bA(false);
        hVar.fDt = -1;
        com.tencent.mm.ad.n.JQ().a(hVar);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < pnVar.vGF.size(); i++) {
            if (((aqw) pnVar.vGF.get(i)).wyG == 0) {
                af afVar;
                af WO = EY.WO(n.a(((aqw) pnVar.vGF.get(i)).vYO));
                if (((int) WO.gJd) != 0) {
                    WO.Af();
                    EY.a(WO.field_username, WO);
                    afVar = WO;
                } else {
                    afVar = m.a(WO, (aqw) pnVar.vGF.get(i));
                    EY.R(afVar);
                }
                arrayList.add(afVar.field_username);
            }
        }
        if (!arrayList.contains(q.FS())) {
            arrayList.add(q.FS());
            x.d("MicroMsg.NetSceneCreateChatRoom", "respon has not self add one " + arrayList.contains(q.FS()));
        }
        return m.a(xVar.field_username, arrayList, q.FS());
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneCreateChatRoom", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        pn pnVar = (pn) this.gJQ.hmh.hmo;
        this.fAP = n.a(pnVar.vGG);
        int i4 = this.gJQ.hmh.vBp;
        this.fAO = pnVar.kZx;
        ap(pnVar.vGF);
        if (!bh.ov(this.fAP) && i4 == 0) {
            a(pnVar);
        }
        this.gJT.a(i2, i3, str, this);
    }

    private void ap(List<aqw> list) {
        for (int i = 0; i < list.size(); i++) {
            int i2 = ((aqw) list.get(i)).wyG;
            if (i2 == 0) {
                this.fAU.add(n.a(((aqw) list.get(i)).vYO));
            } else if (i2 == 3) {
                x.d("MicroMsg.NetSceneCreateChatRoom", " blacklist : " + ((aqw) list.get(i)).vYO);
                this.kZm.add(n.a(((aqw) list.get(i)).vYO));
            } else if (i2 == 1) {
                x.d("MicroMsg.NetSceneCreateChatRoom", " not user : " + ((aqw) list.get(i)).vYO);
                this.fAS.add(n.a(((aqw) list.get(i)).vYO));
            } else if (i2 == 2) {
                x.d("MicroMsg.NetSceneCreateChatRoom", " invalid username : " + ((aqw) list.get(i)).vYO);
                this.fAQ.add(n.a(((aqw) list.get(i)).vYO));
            } else if (i2 == 4) {
                x.d("MicroMsg.NetSceneCreateChatRoom", " verify user : " + ((aqw) list.get(i)).vYO);
                this.fAT.add(n.a(((aqw) list.get(i)).vYO));
            } else if (!(i2 == 5 || i2 == 6)) {
                x.w("MicroMsg.NetSceneCreateChatRoom", "unknown member status : status = " + i2);
            }
        }
    }
}
