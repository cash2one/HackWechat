package com.tencent.mm.modelmulti;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.os;
import com.tencent.mm.g.a.ou;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiCreateAudioInstance;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.bd;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.protocal.c.ara;
import com.tencent.mm.protocal.c.arb;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.protocal.c.bfx;
import com.tencent.mm.protocal.c.bfy;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.z.ba;
import com.tencent.wcdb.database.SQLiteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import junit.framework.Assert;

public final class j extends k implements com.tencent.mm.network.k {
    private static final List<Object> hFz = new ArrayList();
    public long fqm;
    private b gJQ;
    private e gJT;
    private final List<au> hFA = new LinkedList();
    private int hFB = 3;
    private boolean hFC = false;
    private final List<au> hFD = new ArrayList();
    private au hFE = null;
    public com.tencent.mm.plugin.messenger.foundation.a.k hFF = null;

    static /* synthetic */ void a(j jVar, List list) {
        for (int i = 0; i < list.size(); i++) {
            r((au) list.get(i));
        }
    }

    static /* synthetic */ void b(j jVar, List list) {
        for (int i = 0; i < list.size(); i++) {
            q((au) list.get(i));
        }
    }

    public j(String str, String str2, int i, int i2, Object obj) {
        x.d("MicroMsg.NetSceneSendMsg", "dktext :%s", new Object[]{bh.cgy()});
        if (!bh.ov(str)) {
            cf auVar = new au();
            auVar.eQ(1);
            auVar.dS(str);
            auVar.aq(ba.hR(str));
            auVar.eR(1);
            auVar.setContent(str2);
            auVar.setType(i);
            String a = a(((o) g.h(o.class)).s(auVar), obj, i2);
            if (!bh.ov(a)) {
                auVar.dY(a);
                x.d("MicroMsg.NetSceneSendMsg", "NetSceneSendMsg:MsgSource:%s", new Object[]{auVar.gjF});
            }
            try {
                this.fqm = ((h) g.h(h.class)).aZi().b(auVar, true);
                if (this.fqm == -1) {
                    d.pPH.a(111, 255, 1, false);
                }
                Assert.assertTrue(this.fqm != -1);
                x.i("MicroMsg.NetSceneSendMsg", "new msg inserted to db , local id = " + this.fqm);
            } catch (SQLiteException e) {
                d.pPH.a(111, 255, 1, false);
                throw e;
            }
        }
    }

    public j(String str, String str2, int i) {
        boolean z = false;
        x.d("MicroMsg.NetSceneSendMsg", "dktext :%s", new Object[]{bh.cgy()});
        if (!bh.ov(str)) {
            cf auVar = new au();
            auVar.eQ(1);
            auVar.dS(str);
            auVar.aq(ba.hR(str));
            auVar.eR(1);
            auVar.setContent(str2);
            auVar.setType(i);
            String s = ((o) g.h(o.class)).s(auVar);
            if (!bh.ov(s)) {
                auVar.dY(s);
                x.d("MicroMsg.NetSceneSendMsg", "NetSceneSendMsg:MsgSource:%s", new Object[]{auVar.gjF});
            }
            try {
                this.fqm = ((h) g.h(h.class)).aZi().b(auVar, true);
                if (this.fqm == -1) {
                    d.pPH.a(111, 255, 1, false);
                }
                if (this.fqm != -1) {
                    z = true;
                }
                Assert.assertTrue(z);
                x.i("MicroMsg.NetSceneSendMsg", "new msg inserted to db , local id = " + this.fqm);
            } catch (SQLiteException e) {
                d.pPH.a(111, 255, 1, false);
                throw e;
            }
        }
    }

    public j(long j) {
        x.i("MicroMsg.NetSceneSendMsg", "resend msg , local id = " + j);
        this.fqm = j;
        this.hFE = ((h) g.h(h.class)).aZi().dH(j);
        if (this.hFE == null) {
            x.e("MicroMsg.NetSceneSendMsg", "resend msg , msg is null localid:%d", new Object[]{Long.valueOf(j)});
        }
    }

    public j() {
        x.d("MicroMsg.NetSceneSendMsg", "dktext :%s", new Object[]{bh.cgy()});
        x.i("MicroMsg.NetSceneSendMsg", "empty msg sender created");
    }

    public final boolean Kd() {
        return true;
    }

    protected final int Bh() {
        return 10;
    }

    public final boolean Ke() {
        boolean Ke = super.Ke();
        if (Ke) {
            d.pPH.a(111, 254, 1, false);
        }
        return Ke;
    }

    protected final int a(q qVar) {
        return this.hFA.size() > 0 ? k.b.hmP : k.b.hmQ;
    }

    private static String a(String str, Object obj, int i) {
        String str2 = "MicroMsg.NetSceneSendMsg";
        String str3 = "[mergeMsgSource] rawSource:%s args is null:%s flag:%s";
        Object[] objArr = new Object[3];
        objArr[0] = str;
        objArr[1] = Boolean.valueOf(obj == null);
        objArr[2] = Integer.valueOf(i);
        x.i(str2, str3, objArr);
        if (!bh.ov(str) && !str.startsWith("<msgsource>")) {
            x.w("MicroMsg.NetSceneSendMsg", "[mergeMsgSource] WTF the msgsource is right? %s", new Object[]{str});
            return str;
        } else if (i != JsApiCreateAudioInstance.CTRL_INDEX || !(obj instanceof HashMap)) {
            return str;
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            if (bh.ov(str)) {
                stringBuffer.append("<msgsource>");
            }
            for (Entry entry : ((HashMap) obj).entrySet()) {
                str2 = (String) entry.getValue();
                String str4 = (String) entry.getKey();
                if (bh.ov(str2) || bh.ov(str4)) {
                    x.w("MicroMsg.NetSceneSendMsg", "%s %s", new Object[]{str4, str2});
                } else {
                    stringBuffer.append("<").append(str4).append(">");
                    stringBuffer.append(str2);
                    stringBuffer.append("</").append(str4).append(">");
                }
            }
            if (!bh.ov(str)) {
                return str.replace("<msgsource>", "<msgsource>" + stringBuffer.toString());
            }
            stringBuffer.append("</msgsource>");
            return stringBuffer.toString();
        }
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        List aZq;
        this.gJT = eVar2;
        a aVar = new a();
        aVar.hmj = new bfx();
        aVar.hmk = new bfy();
        aVar.uri = "/cgi-bin/micromsg-bin/newsendmsg";
        aVar.hmi = 522;
        aVar.hml = bd.CTRL_BYTE;
        aVar.hmm = 1000000237;
        this.gJQ = aVar.JZ();
        bfx com_tencent_mm_protocal_c_bfx = (bfx) this.gJQ.hmg.hmo;
        if (this.hFE == null) {
            aZq = ((h) g.h(h.class)).aZi().aZq();
        } else {
            if (this.hFE.field_status != 5) {
                x.w("MicroMsg.NetSceneSendMsg", "msg:%d status:%d should not be resend !", new Object[]{Long.valueOf(this.hFE.field_msgId), Integer.valueOf(this.hFE.field_status)});
            }
            this.hFE.eQ(1);
            ((h) g.h(h.class)).aZi().a(this.fqm, this.hFE);
            List arrayList = new ArrayList();
            arrayList.add(this.hFE);
            this.hFE = null;
            aZq = arrayList;
        }
        if (aZq.size() == 0) {
            x.w("MicroMsg.NetSceneSendMsg", "no sending message");
            return -2;
        }
        this.hFA.clear();
        for (int i = 0; i < aZq.size(); i++) {
            au auVar = (au) aZq.get(i);
            if (auVar.field_isSend == 1) {
                ara com_tencent_mm_protocal_c_ara = new ara();
                com_tencent_mm_protocal_c_ara.vGY = new bdo().UA(auVar.field_talker);
                com_tencent_mm_protocal_c_ara.pbl = (int) (auVar.field_createTime / 1000);
                com_tencent_mm_protocal_c_ara.ktN = auVar.getType();
                com_tencent_mm_protocal_c_ara.nje = auVar.field_content;
                com_tencent_mm_protocal_c_ara.wyU = com.tencent.mm.z.o.k(com.tencent.mm.z.q.FS(), auVar.field_createTime).hashCode();
                if (this.hFF == null) {
                    this.hFF = ((o) g.h(o.class)).Qa();
                }
                x.i("MicroMsg.NetSceneSendMsg", "using message source assembler %s", new Object[]{this.hFF});
                this.hFF.a(com_tencent_mm_protocal_c_ara, auVar);
                x.i("MicroMsg.NetSceneSendMsg", "reqCmd.MsgSource:%s", new Object[]{com_tencent_mm_protocal_c_ara.vHc});
                com_tencent_mm_protocal_c_bfx.ksP.add(com_tencent_mm_protocal_c_ara);
                com_tencent_mm_protocal_c_bfx.ksO = com_tencent_mm_protocal_c_bfx.ksP.size();
                this.hFA.add(auVar);
            }
        }
        int a = a(eVar, this.gJQ, this);
        if (a >= 0) {
            return a;
        }
        x.i("MicroMsg.NetSceneSendMsg", "mark all failed. do scene %d", new Object[]{Integer.valueOf(a)});
        PW();
        return a;
    }

    public final int getType() {
        return 522;
    }

    private void ib(int i) {
        if (this.hFA == null) {
            x.e("MicroMsg.NetSceneSendMsg", "publishMsgSendFailEvent, sendingList is null");
        } else if (i >= this.hFA.size() || i < 0) {
            x.e("MicroMsg.NetSceneSendMsg", "publishMsgSendFailEvent, index:%d, sendingList.size:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(this.hFA.size())});
        } else {
            q((au) this.hFA.get(i));
        }
    }

    private static void q(au auVar) {
        com.tencent.mm.sdk.b.b osVar = new os();
        osVar.fGK.fnB = auVar;
        com.tencent.mm.sdk.b.a.xef.m(osVar);
        x.d("MicroMsg.NetSceneSendMsg", "publishMsgSendFailEvent for msgId:%d", new Object[]{Long.valueOf(auVar.field_msgId)});
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (i2 == 0 && i3 == 0) {
            List list = ((bfy) this.gJQ.hmh.hmo).ksP;
            ArrayList arrayList = new ArrayList();
            if (this.hFA.size() == list.size()) {
                int i4 = 0;
                while (i4 < list.size()) {
                    arb com_tencent_mm_protocal_c_arb = (arb) list.get(i4);
                    if (com_tencent_mm_protocal_c_arb.vJU != 0 || r.iea) {
                        d.pPH.a(111, 252, 1, false);
                        if (com_tencent_mm_protocal_c_arb.vJU == -49 || r.iea) {
                            x.i("MicroMsg.NetSceneSendMsg", "summerdktext send msg failed: item ret code[%d], index[%d], testVerifyPsw[%b], retryVerifyCount[%d]", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_arb.vJU), Integer.valueOf(i4), Boolean.valueOf(r.iea), Integer.valueOf(this.hFB)});
                            if (this.hFC) {
                                this.hFD.add((au) this.hFA.get(i4));
                            } else if (this.hFB < 0) {
                                ic(i4);
                                this.gJT.a(4, com_tencent_mm_protocal_c_arb.vJU, str, this);
                                ib(i4);
                                return;
                            } else {
                                this.hFC = true;
                                this.hFB--;
                                this.hFD.add((au) this.hFA.get(i4));
                                g.Dm().F(new 1(this, str));
                            }
                        } else {
                            ic(i4);
                            this.gJT.a(4, com_tencent_mm_protocal_c_arb.vJU, str, this);
                            ib(i4);
                            return;
                        }
                    }
                    long j = ((au) this.hFA.get(i4)).field_msgId;
                    x.i("MicroMsg.NetSceneSendMsg", "msg local id = " + j + ", SvrId = " + com_tencent_mm_protocal_c_arb.vHe + " sent successfully!");
                    au dH = ((h) g.h(h.class)).aZi().dH(j);
                    dH.ap(com_tencent_mm_protocal_c_arb.vHe);
                    x.d("MicroMsg.NetSceneSendMsg", "dkmsgid  set svrmsgid %d -> %d", new Object[]{Long.valueOf(com_tencent_mm_protocal_c_arb.vHe), Integer.valueOf(r.idu)});
                    if (CdnLogic.kMediaTypeFavoriteBigFile == r.idt && r.idu != 0) {
                        dH.ap((long) r.idu);
                        r.idu = 0;
                    }
                    dH.eQ(2);
                    ((h) g.h(h.class)).aZi().a(j, dH);
                    if (this.hFA == null) {
                        x.e("MicroMsg.NetSceneSendMsg", "publishMsgSendSuccessEvent, sendingList is null");
                    } else if (i4 >= this.hFA.size() || i4 < 0) {
                        x.e("MicroMsg.NetSceneSendMsg", "publishMsgSendSuccessEvent, index:%d, sendingList.size:%d", new Object[]{Integer.valueOf(i4), Integer.valueOf(this.hFA.size())});
                    } else {
                        x.d("MicroMsg.NetSceneSendMsg", "publishMsgSendSuccessEvent for msgId:%d", new Object[]{Long.valueOf(((au) this.hFA.get(i4)).field_msgId)});
                        au dH2 = ((h) g.h(h.class)).aZi().dH(j);
                        com.tencent.mm.sdk.b.b ouVar = new ou();
                        ouVar.fGM.fnB = dH2;
                        com.tencent.mm.sdk.b.a.xef.m(ouVar);
                    }
                    arrayList.add(Integer.valueOf(i4));
                    if (1 == com_tencent_mm_protocal_c_arb.ktN) {
                        d.pPH.a(11942, true, false, new Object[]{Long.valueOf(com_tencent_mm_protocal_c_arb.vHe)});
                        d.pPH.a(11945, false, true, new Object[]{Long.valueOf(com_tencent_mm_protocal_c_arb.vHe)});
                        d.pPH.a(11946, false, false, new Object[]{Long.valueOf(com_tencent_mm_protocal_c_arb.vHe)});
                        d.pPH.a(90, 0, 1, false);
                        d.pPH.a(90, 1, 1, true);
                    }
                    i4++;
                }
                x.i("MicroMsg.NetSceneSendMsg", "summerdktext total  [%d]msgs sent successfully, [%d]msgs need verifypsw", new Object[]{Integer.valueOf(i4 - this.hFD.size()), Integer.valueOf(this.hFD.size())});
            }
            x.d("MicroMsg.NetSceneSendMsg", "summerdktext send finish, continue send SENDING msg verifyingPsw[%b]", new Object[]{Boolean.valueOf(this.hFC)});
            if (this.hFC) {
                this.gJT.a(i2, i3, str, this);
                return;
            } else {
                lI(str);
                return;
            }
        }
        d.pPH.a(111, (long) (i2 + 40), 1, true);
        d.pPH.a(111, 253, 1, false);
        x.i("MicroMsg.NetSceneSendMsg", "mark all failed. onGYNetEnd. errType:%d errCode:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        PW();
        this.gJT.a(i2, i3, str, this);
        for (int i5 = 0; i5 < this.hFA.size(); i5++) {
            ib(i5);
        }
        x.d("MicroMsg.NetSceneSendMsg", "send fail, continue send SENDING msg");
        lI(str);
    }

    private void lI(String str) {
        x.d("MicroMsg.NetSceneSendMsg", "continue send msg in list");
        int a = a(this.hmA, this.gJT);
        if (a == -2) {
            this.gJT.a(0, 0, str, this);
        } else if (a < 0) {
            this.gJT.a(3, -1, str, this);
        }
    }

    private void PW() {
        for (int i = 0; i < this.hFA.size(); i++) {
            ic(i);
        }
    }

    private void ic(int i) {
        x.d("MicroMsg.NetSceneSendMsg", "markMsgFailed for id:%d", new Object[]{Long.valueOf(((au) this.hFA.get(i)).field_msgId)});
        r(r0);
    }

    private static void r(au auVar) {
        auVar.eQ(5);
        d.pPH.a(111, 30, 1, true);
        ((h) g.h(h.class)).aZi().a(auVar.field_msgId, auVar);
        Iterator it = hFz.iterator();
        while (it.hasNext()) {
            it.next();
            String str = auVar.field_talker;
            str = auVar.field_content;
        }
    }
}
