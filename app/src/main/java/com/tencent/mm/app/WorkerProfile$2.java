package com.tencent.mm.app;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.ag.a.e;
import com.tencent.mm.ag.f;
import com.tencent.mm.aq.o;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.g.a.op;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.model.app.am.a;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.g$a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;

class WorkerProfile$2 extends c<op> {
    final /* synthetic */ WorkerProfile fgz;

    WorkerProfile$2(WorkerProfile workerProfile) {
        this.fgz = workerProfile;
        this.xen = op.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        op opVar = (op) bVar;
        for (String str : bh.F(opVar.fGx.toUser.split(","))) {
            if (bh.ov(opVar.fGx.fGB)) {
                WXMediaMessage wXMediaMessage = opVar.fGx.fzc;
                String str2 = opVar.fGx.appId;
                String str3 = opVar.fGx.appName;
                int i = opVar.fGx.fGy;
                String str4 = opVar.fGx.fGz;
                String str5 = opVar.fGx.fGA;
                String str6 = opVar.fGx.fGC;
                String str7 = opVar.fGx.fGD;
                String str8 = opVar.fGx.fGE;
                String str9 = opVar.fGx.fGF;
                String str10 = opVar.fGx.fqu;
                String str11 = opVar.fGx.fGG;
                com.tencent.mm.sdk.e.c cVar = null;
                g$a com_tencent_mm_y_g_a = new g$a();
                com_tencent_mm_y_g_a.appId = str2;
                com_tencent_mm_y_g_a.appName = str3;
                com_tencent_mm_y_g_a.hbe = i;
                com_tencent_mm_y_g_a.fGz = str4;
                com_tencent_mm_y_g_a.fGA = str5;
                com_tencent_mm_y_g_a.fGC = str6;
                com_tencent_mm_y_g_a.fGD = str7;
                com_tencent_mm_y_g_a.fGE = str8;
                com_tencent_mm_y_g_a.fGF = str9;
                com_tencent_mm_y_g_a.fGG = str11;
                str2 = l.b(com_tencent_mm_y_g_a, wXMediaMessage, null);
                x.d("MicroMsg.AppMsgLogic", g.zh() + " content url:" + com_tencent_mm_y_g_a.url + " lowUrl:" + com_tencent_mm_y_g_a.hba + " attachlen:" + com_tencent_mm_y_g_a.hbb + " attachid:" + com_tencent_mm_y_g_a.fny + " attach file:" + str2);
                String str12 = System.currentTimeMillis();
                if (!bh.ov(str2)) {
                    cVar = l.a(str12, com_tencent_mm_y_g_a, str2);
                    if (cVar == null) {
                        g.getLine();
                    }
                }
                cf auVar = new au();
                if (wXMediaMessage.thumbData != null && wXMediaMessage.thumbData.length > 0) {
                    str2 = o.Pw().a(6, wXMediaMessage.thumbData, com_tencent_mm_y_g_a.type == 2, CompressFormat.PNG);
                    x.d("MicroMsg.AppMsgLogic", g.zh() + " thumbData MsgInfo path:" + str2);
                    if (!bh.ov(str2)) {
                        auVar.dT(str2);
                        x.d("MicroMsg.AppMsgLogic", "new thumbnail saved, path" + str2);
                    }
                }
                if (cVar != null) {
                    com_tencent_mm_y_g_a.fny = cVar.xjy;
                }
                auVar.setContent(g$a.a(com_tencent_mm_y_g_a, null, null));
                auVar.eQ(1);
                auVar.dS(str);
                auVar.aq(ba.hR(str));
                auVar.eR(1);
                auVar.setType(l.d(com_tencent_mm_y_g_a));
                if (f.eE(auVar.field_talker)) {
                    auVar.dY(e.HD());
                    x.d("MicroMsg.AppMsgLogic", "NetSceneSendMsg:MsgSource:%s", new Object[]{auVar.gjF});
                }
                ar.Hg();
                long Q = com.tencent.mm.z.c.Fa().Q(auVar);
                x.d("MicroMsg.AppMsgLogic", g.zh() + " msginfo insert id: " + Q);
                if (Q < 0) {
                    x.e("MicroMsg.AppMsgLogic", g.zh() + "insert msg failed :" + Q);
                    g.getLine();
                } else {
                    x.i("MicroMsg.AppMsgLogic", g.getLine() + " new msg inserted to db , local id = " + Q);
                    auVar.ao(Q);
                    com.tencent.mm.sdk.e.c gVar = new com.tencent.mm.y.g();
                    gVar.field_xml = auVar.field_content;
                    gVar.field_title = wXMediaMessage.title;
                    gVar.field_type = wXMediaMessage.mediaObject.type();
                    gVar.field_description = wXMediaMessage.description;
                    gVar.field_msgId = Q;
                    gVar.field_source = str3;
                    an.bYS().b(gVar);
                    if (cVar != null) {
                        cVar.field_msgInfoId = Q;
                        cVar.field_status = 101;
                        an.aqd().c(cVar, new String[0]);
                        an.bYU().run();
                    } else {
                        an.bYU();
                        a.u(Q, str10);
                    }
                }
            } else {
                l.a(opVar.fGx.fzc, opVar.fGx.appId, opVar.fGx.appName, str, opVar.fGx.fGy, opVar.fGx.fGB);
            }
        }
        return false;
    }
}
