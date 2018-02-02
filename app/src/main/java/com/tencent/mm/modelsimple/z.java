package com.tencent.mm.modelsimple;

import com.tencent.mm.R;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.oa;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.protocal.c.bdk;
import com.tencent.mm.protocal.c.bdl;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.h;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.o;
import com.tencent.mm.z.q;
import org.xwalk.core.R$styleable;

public final class z extends k implements com.tencent.mm.network.k {
    private static final ag hOa = new ag("deleteRevokeMessageThread");
    private final long fqm;
    private e gJT;
    private final b hFi;
    private final String hOb;

    public z(au auVar, String str) {
        int i;
        ar.Hg();
        Object obj = c.CU().get(290818, Integer.valueOf(0));
        if (obj != null) {
            i = bh.getInt(obj.toString(), 0);
        } else {
            i = 0;
        }
        this.fqm = auVar.field_msgId;
        this.hOb = str;
        String str2 = null;
        int i2 = 0;
        int i3 = (int) (auVar.field_createTime / 1000);
        long j = auVar.field_msgSvrId;
        String FS = q.FS();
        String str3 = auVar.field_talker;
        if (auVar.gjJ != 1) {
            String str4;
            switch (auVar.getType()) {
                case 1:
                case R$styleable.AppCompatTheme_dialogTheme /*42*/:
                case R$styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                    x.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:text,newClientMsgId:%d", new Object[]{Integer.valueOf(o.k(q.FS(), auVar.field_createTime).hashCode())});
                    i2 = r2;
                    break;
                case 3:
                    com.tencent.mm.aq.e bi = com.tencent.mm.aq.o.Pw().bi(auVar.field_msgId);
                    x.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:img,talker:%s,hdId:%s,localId:%s,clientMsgId:%s", new Object[]{auVar.field_talker, Integer.valueOf(bi.hzZ), Long.valueOf(bi.hzP), auVar.gjM});
                    str2 = str4;
                    break;
                case 34:
                    p of = m.UD().of(auVar.field_imgPath);
                    if (of != null) {
                        x.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:voice,clientMsgId:%s", new Object[]{of.clientId});
                        str2 = str4;
                        break;
                    }
                    break;
                case R$styleable.AppCompatTheme_dialogPreferredPadding /*43*/:
                case 62:
                    x.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:video,clientMsgId:%s", new Object[]{auVar.field_imgPath});
                    str2 = str4;
                    break;
                case 47:
                    x.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:emoji,clientMsgId:%s", new Object[]{String.valueOf(aj.Xp(auVar.field_content).time)});
                    str2 = str4;
                    break;
                case R$styleable.AppCompatTheme_actionButtonStyle /*49*/:
                case 1048625:
                case 268435505:
                case 553648177:
                    com.tencent.mm.pluginsdk.model.app.b fo = an.aqd().fo(auVar.field_msgId);
                    if (fo != null) {
                        str4 = fo.field_clientAppDataId;
                    } else {
                        str4 = auVar.field_talker + auVar.field_msgId + "T" + auVar.field_createTime;
                    }
                    x.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSendRevokeMsg] type:app msg/emoji/img,clientMsgId:%s", new Object[]{str4});
                    str2 = str4;
                    break;
            }
        }
        a aVar = new a();
        aVar.hmj = new bdk();
        aVar.hmk = new bdl();
        aVar.uri = "/cgi-bin/micromsg-bin/revokemsg";
        aVar.hmi = 594;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.hFi = aVar.JZ();
        bdk com_tencent_mm_protocal_c_bdk = (bdk) this.hFi.hmg.hmo;
        com_tencent_mm_protocal_c_bdk.vHU = str2;
        com_tencent_mm_protocal_c_bdk.wJv = i2;
        com_tencent_mm_protocal_c_bdk.wJw = 0;
        com_tencent_mm_protocal_c_bdk.wJy = j;
        com_tencent_mm_protocal_c_bdk.pbl = i3;
        com_tencent_mm_protocal_c_bdk.nkp = FS;
        com_tencent_mm_protocal_c_bdk.nko = str3;
        com_tencent_mm_protocal_c_bdk.wJx = i;
        x.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][NetSceneRevokeMsg]:clientMsgId:%s,newClientMsgId:%d,svrMsgId:%d,createTime:%d,fromUserName:%s,toUserName:%s,indexOfRequest:%d", new Object[]{com_tencent_mm_protocal_c_bdk.vHU, Integer.valueOf(com_tencent_mm_protocal_c_bdk.wJv), Integer.valueOf(com_tencent_mm_protocal_c_bdk.wJw), Integer.valueOf(com_tencent_mm_protocal_c_bdk.pbl), com_tencent_mm_protocal_c_bdk.nkp, com_tencent_mm_protocal_c_bdk.nko, Integer.valueOf(com_tencent_mm_protocal_c_bdk.wJx)});
    }

    public final int getType() {
        return 594;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.hFi, this);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        if (i2 == 0 && i3 == 0) {
            ar.Hg();
            au dH = c.Fa().dH(this.fqm);
            if (dH.field_msgId == this.fqm) {
                bdl Sl = Sl();
                x.i("MicroMsg.NetSceneRevokeMsg", "[oneliang][doSceneEnd.revokeMsg] msgId:%s,msgSvrId:%s,responseSysWording:%s", new Object[]{Long.valueOf(dH.field_msgId), Long.valueOf(dH.field_msgSvrId), Sl.wJA});
                int type = dH.getType();
                a(this.hOb, "  " + ac.getContext().getString(R.l.eqs), dH, dH.field_content);
                dH.eR(0);
                dH.fb(dH.gjE | 4);
                com.tencent.mm.sdk.b.b oaVar = new oa();
                oaVar.fFW.fqm = this.fqm;
                com.tencent.mm.sdk.b.a.xef.m(oaVar);
                ar.Hg();
                c.Fa().a(dH.field_msgId, dH);
                int i4 = 0;
                ar.Hg();
                Object obj = c.CU().get(290818, Integer.valueOf(0));
                if (obj != null) {
                    i4 = bh.getInt(obj.toString(), 0);
                }
                i4++;
                ar.Hg();
                c.CU().set(290818, Integer.valueOf(i4));
                dH.setType(type);
                com.tencent.mm.modelstat.b bVar;
                if (dH.aNc()) {
                    bVar = com.tencent.mm.modelstat.b.hPA;
                    type = h.g(dH);
                    if (bVar.SN()) {
                        bVar.a(dH, com.tencent.mm.modelstat.b.b.hPN, type);
                    }
                } else {
                    bVar = com.tencent.mm.modelstat.b.hPA;
                    if (bVar.SN()) {
                        bVar.a(dH, com.tencent.mm.modelstat.b.b.hPN, 0);
                    }
                }
                hOa.g(new 1(this, dH), 300000);
            } else {
                x.e("MicroMsg.NetSceneRevokeMsg", "cannot find the msg:%d after revoke.", new Object[]{Long.valueOf(this.fqm)});
            }
        }
        this.gJT.a(i2, i3, str, this);
    }

    public static void a(String str, String str2, au auVar, String str3) {
        if (auVar.getType() == 1 || auVar.getType() == 16777265) {
            auVar.setType(10002);
            auVar.setContent(String.format("<sysmsg type=\"invokeMessage\"><invokeMessage><text><![CDATA[%s]]></text><timestamp><![CDATA[%s]]></timestamp><link><text><![CDATA[%s]]></text></link><preContent><![CDATA[%s]]></preContent></invokeMessage></sysmsg>", new Object[]{str, Long.valueOf(System.currentTimeMillis()), str2, str3}));
            return;
        }
        auVar.setType(10000);
        auVar.setContent(str);
    }

    public final bdl Sl() {
        return (bdl) this.hFi.hmh.hmo;
    }
}
