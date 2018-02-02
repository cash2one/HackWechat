package com.tencent.mm.plugin.record.b;

import android.content.Context;
import android.graphics.Bitmap.CompressFormat;
import android.util.SparseIntArray;
import com.tencent.mm.R;
import com.tencent.mm.a.f;
import com.tencent.mm.ad.b;
import com.tencent.mm.ag.a.e;
import com.tencent.mm.aq.o;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.g.a.cf;
import com.tencent.mm.g.a.rw;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.model.app.am.a;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.protocal.b.a.c;
import com.tencent.mm.protocal.b.a.d;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.protocal.c.ur;
import com.tencent.mm.protocal.c.us;
import com.tencent.mm.protocal.c.ux;
import com.tencent.mm.protocal.c.uy;
import com.tencent.mm.protocal.c.vd;
import com.tencent.mm.protocal.c.ve;
import com.tencent.mm.protocal.c.vn;
import com.tencent.mm.protocal.c.vt;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.g$a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.m;
import com.tencent.mm.z.q;
import com.tencent.mm.z.r;
import com.tencent.mm.z.s;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public final class h {
    private static final f<Integer, c> hdO = new f(32);

    public static String a(String str, String str2, ve veVar, String str3) {
        if (veVar == null || veVar.weU == null) {
            x.e("MicroMsg.RecordMsgLogic", "buildRecordAppMsgXML error: protoItem or datalist is null");
            return "";
        }
        List list = veVar.weU;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<recordinfo>");
        stringBuilder.append("<title>").append(bh.VG(str)).append("</title>");
        stringBuilder.append("<desc>").append(bh.VG(str2)).append("</desc>");
        a(stringBuilder, veVar);
        stringBuilder.append(i.aG(list));
        stringBuilder.append("<favusername>").append(bh.VG(str3)).append("</favusername>");
        stringBuilder.append("</recordinfo>");
        g$a com_tencent_mm_y_g_a = new g$a();
        com_tencent_mm_y_g_a.title = str;
        com_tencent_mm_y_g_a.description = str2;
        if (bh.ov(((uq) list.get(0)).wcY) || !((uq) list.get(0)).wcY.equals(".htm")) {
            com_tencent_mm_y_g_a.type = 19;
            com_tencent_mm_y_g_a.url = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/favorite_record__w_unsupport&from=singlemessage&isappinstalled=0";
        } else {
            com_tencent_mm_y_g_a.type = 24;
            com_tencent_mm_y_g_a.url = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/common_page__upgrade&btn_text=btn_text_0&text=text008";
        }
        com_tencent_mm_y_g_a.action = "view";
        com_tencent_mm_y_g_a.hbB = stringBuilder.toString();
        return g$a.a(com_tencent_mm_y_g_a, null, null);
    }

    public static g$a a(String str, String str2, ve veVar) {
        List list = veVar.weU;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<recordinfo>");
        stringBuilder.append("<title>").append(bh.VG(str)).append("</title>");
        stringBuilder.append("<desc>").append(bh.VG(str2)).append("</desc>");
        a(stringBuilder, veVar);
        stringBuilder.append(i.aG(list));
        stringBuilder.append("<favusername>").append(bh.VG(q.FS())).append("</favusername>");
        stringBuilder.append("</recordinfo>");
        g$a com_tencent_mm_y_g_a = new g$a();
        com_tencent_mm_y_g_a.title = str;
        if (str2 != null && str2.length() > 200) {
            str2 = str2.substring(0, 200);
        }
        com_tencent_mm_y_g_a.description = str2;
        if (bh.cA(list) || bh.ov(((uq) list.get(0)).wcY) || !((uq) list.get(0)).wcY.equals(".htm")) {
            com_tencent_mm_y_g_a.type = 19;
            com_tencent_mm_y_g_a.url = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/favorite_record__w_unsupport&from=singlemessage&isappinstalled=0";
        } else {
            com_tencent_mm_y_g_a.type = 24;
            com_tencent_mm_y_g_a.url = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/common_page__upgrade&btn_text=btn_text_0&text=text008";
        }
        com_tencent_mm_y_g_a.action = "view";
        com_tencent_mm_y_g_a.hbB = stringBuilder.toString();
        return com_tencent_mm_y_g_a;
    }

    private static void a(StringBuilder stringBuilder, ve veVar) {
        if (veVar.vCU != null) {
            stringBuilder.append("<noteinfo>");
            stringBuilder.append("<noteauthor>").append(bh.VG(veVar.vCU.weL)).append("</noteauthor>");
            stringBuilder.append("<noteeditor>").append(bh.VG(veVar.vCU.weM)).append("</noteeditor>");
            stringBuilder.append("</noteinfo>");
            stringBuilder.append("<edittime>").append(veVar.vCV).append("</edittime>");
        }
    }

    public static int a(Context context, String str, String str2, List<au> list, cf cfVar, d dVar) {
        if (bh.ov(str)) {
            x.w("MicroMsg.RecordMsgLogic", "send record msg error, touser is null");
            return -1;
        } else if (list == null || list.isEmpty()) {
            x.w("MicroMsg.RecordMsgLogic", "send record msg error, msginfo error");
            return -1;
        } else {
            if (cfVar == null || dVar == null) {
                cf cfVar2 = new cf();
                if (!com.tencent.mm.pluginsdk.model.h.a(context, cfVar2, str2, list, true, true)) {
                    return -1;
                }
                dVar = a(context, cfVar2, str2);
                cfVar = cfVar2;
            }
            g$a a = a(dVar.title, dVar.desc, cfVar.fqp.fqr);
            com.tencent.mm.g.b.cf auVar = new au();
            byte[] bArr = null;
            if (!bh.ov(dVar.fvC)) {
                bArr = bh.readFromFile(dVar.fvC);
            } else if (dVar.fEI == 0 && !bh.ov(dVar.mpH)) {
                bArr = com.tencent.mm.sdk.platformtools.d.Q(b.a(dVar.mpH, false, -1));
            }
            if (bArr != null) {
                String a2;
                if (bArr.length > WXMediaMessage.THUMB_LENGTH_LIMIT) {
                    a2 = o.Pw().a(bArr, false, CompressFormat.JPEG);
                } else {
                    a2 = o.Pw().f(8, bArr);
                }
                x.d("MicroMsg.RecordMsgLogic", g.zh() + " thumbData MsgInfo path:" + a2);
                if (!bh.ov(a2)) {
                    auVar.dT(a2);
                }
            }
            auVar.setContent(g$a.a(a, null, null));
            auVar.eQ(1);
            auVar.dS(str);
            auVar.aq(ba.hR(str));
            auVar.eR(1);
            auVar.setType(49);
            if (com.tencent.mm.ag.f.eE(str)) {
                auVar.dY(e.HD());
            }
            ar.Hg();
            long Q = com.tencent.mm.z.c.Fa().Q(auVar);
            x.d("MicroMsg.RecordMsgLogic", g.zh() + " msginfo insert id: " + Q);
            if (Q < 0) {
                x.e("MicroMsg.RecordMsgLogic", g.zh() + "insert msg failed :" + Q);
                return 0 - g.getLine();
            }
            x.i("MicroMsg.RecordMsgLogic", g.getLine() + " new msg inserted to db , local id = " + Q);
            auVar.ao(Q);
            com.tencent.mm.sdk.e.c gVar = new com.tencent.mm.y.g();
            gVar.field_xml = auVar.field_content;
            gVar.field_title = a.title;
            gVar.field_type = a.type;
            gVar.field_description = a.description;
            gVar.field_msgId = Q;
            an.bYS().b(gVar);
            Iterator it = cfVar.fqp.fqr.weU.iterator();
            boolean z = false;
            while (it.hasNext()) {
                uq uqVar = (uq) it.next();
                String obj = uqVar.toString();
                uqVar.TD(com.tencent.mm.a.g.s((obj + uqVar.bjS + System.currentTimeMillis()).getBytes()));
                if (z || com.tencent.mm.a.e.bO(uqVar.wdh) || com.tencent.mm.a.e.bO(uqVar.wdj) || !bh.ov(uqVar.wcJ) || !bh.ov(uqVar.hbj)) {
                    z = true;
                }
            }
            x.d("MicroMsg.RecordMsgLogic", "summerrecord needNetScene:%b", new Object[]{Boolean.valueOf(z)});
            if (z) {
                gVar = new com.tencent.mm.plugin.record.a.g();
                gVar.field_msgId = Q;
                gVar.field_title = a.title;
                gVar.field_desc = a.description;
                gVar.field_toUser = str;
                gVar.field_dataProto = cfVar.fqp.fqr;
                gVar.field_type = 3;
                gVar.field_localId = new Random().nextInt(2147483645) + 1;
                x.i("MicroMsg.RecordMsgLogic", "summerrecord needNetScene insert ret:%b, id:%d, localid:%d", new Object[]{Boolean.valueOf(n.bmS().b(gVar)), Long.valueOf(Q), Integer.valueOf(gVar.field_localId)});
                n.bmT().a(gVar);
            } else {
                x.d("MicroMsg.RecordMsgLogic", "summerrecord do not trans cdn, directly send msg id:%d", new Object[]{Long.valueOf(Q)});
                an.bYU();
                a.ft(Q);
            }
            return 0;
        }
    }

    public static d a(Context context, cf cfVar, String str) {
        String str2;
        int i = 0;
        d dVar = new d();
        SparseIntArray sparseIntArray = new SparseIntArray();
        if (com.tencent.mm.ag.f.eE(str)) {
            dVar.title = cfVar.fqp.fqr.title;
        } else if (s.eV(str)) {
            dVar.title = context.getString(R.l.eCA);
        } else {
            if (q.FU().equals(r.gt(str))) {
                dVar.title = context.getString(R.l.egj, new Object[]{q.FU()});
            } else {
                dVar.title = context.getString(R.l.egi, new Object[]{q.FU(), r.gt(str)});
            }
        }
        x.d("MicroMsg.RecordMsgLogic", "msgInfo title %s", new Object[]{dVar.title});
        List<String> linkedList = new LinkedList();
        List list;
        if (cfVar.fqp.fqr != null) {
            list = cfVar.fqp.fqr.weU;
        } else {
            list = new LinkedList();
        }
        for (uq uqVar : r0) {
            sparseIntArray.put(uqVar.bjS, sparseIntArray.get(uqVar.bjS) + 1);
            switch (uqVar.bjS) {
                case 1:
                    if (linkedList.size() >= 5) {
                        break;
                    }
                    linkedList.add(uqVar.wdF + ":" + uqVar.desc + "\n");
                    break;
                case 2:
                    if (linkedList.size() < 5) {
                        linkedList.add(uqVar.wdF + ":" + context.getString(R.l.dGj) + "\n");
                    }
                    if (i != 0) {
                        break;
                    }
                    a(dVar, uqVar, R.g.byV);
                    i = 1;
                    break;
                case 3:
                    if (linkedList.size() >= 5) {
                        break;
                    }
                    linkedList.add(uqVar.wdF + ":" + context.getString(R.l.dGY) + "\n");
                    break;
                case 4:
                    if (linkedList.size() < 5) {
                        linkedList.add(uqVar.wdF + ":" + context.getString(R.l.dGX) + "\n");
                    }
                    if (i != 0) {
                        break;
                    }
                    a(dVar, uqVar, R.k.dvA);
                    i = 1;
                    break;
                case 5:
                    if (linkedList.size() < 5) {
                        linkedList.add(uqVar.wdF + ":" + context.getString(R.l.dGU) + uqVar.title + "\n");
                    }
                    if (i != 0) {
                        break;
                    }
                    a(dVar, uqVar, R.k.dvD);
                    i = 1;
                    break;
                case 6:
                    if (linkedList.size() < 5) {
                        ux uxVar = uqVar.wdD.wdZ;
                        StringBuilder append = new StringBuilder().append(uqVar.wdF).append(":").append(context.getString(R.l.dFz));
                        str2 = (bh.ov(uxVar.fDu) || uxVar.fDu.equals(context.getString(R.l.eth))) ? uxVar.label : uxVar.fDu;
                        linkedList.add(append.append(str2).append("\n").toString());
                    }
                    if (i != 0) {
                        break;
                    }
                    dVar.fEI = R.k.dvm;
                    i = 1;
                    break;
                    break;
                case 7:
                    if (linkedList.size() < 5) {
                        linkedList.add(uqVar.wdF + ":" + context.getString(R.l.dFJ) + uqVar.title + "\n");
                    }
                    if (i != 0) {
                        break;
                    }
                    a(dVar, uqVar, R.k.dvn);
                    i = 1;
                    break;
                case 8:
                    if (linkedList.size() < 5) {
                        linkedList.add(uqVar.wdF + ":" + context.getString(R.l.dFj) + uqVar.title + "\n");
                    }
                    if (i != 0) {
                        break;
                    }
                    a(dVar, uqVar, R.k.dvx);
                    i = 1;
                    break;
                case 10:
                case 11:
                    if (linkedList.size() < 5) {
                        linkedList.add(uqVar.wdF + ":" + context.getString(R.l.dGl) + uqVar.wdD.wed.title + "\n");
                    }
                    if (i != 0) {
                        break;
                    }
                    a(dVar, uqVar, R.k.dvx);
                    i = 1;
                    break;
                case 14:
                    if (linkedList.size() < 5) {
                        linkedList.add(uqVar.wdF + ":" + context.getString(R.l.dDN) + "\n");
                    }
                    if (i != 0) {
                        break;
                    }
                    a(dVar, uqVar, R.k.dvx);
                    i = 1;
                    break;
                case 15:
                    if (linkedList.size() < 5) {
                        linkedList.add(uqVar.wdF + ":" + context.getString(R.l.dGX) + "\n");
                    }
                    if (i != 0) {
                        break;
                    }
                    a(dVar, uqVar, R.k.dvA);
                    i = 1;
                    break;
                case 16:
                    if (linkedList.size() < 5) {
                        linkedList.add(uqVar.wdF + ":" + context.getString(R.l.dFn) + "\n");
                    }
                    if (i != 0) {
                        break;
                    }
                    ar.Hg();
                    dVar.mpH = com.tencent.mm.z.c.Fa().EK(uqVar.desc).rYX;
                    i = 1;
                    break;
                case 17:
                    if (linkedList.size() >= 5) {
                        break;
                    }
                    linkedList.add(uqVar.wdF + ":" + context.getString(R.l.dGs) + "\n");
                    break;
                default:
                    break;
            }
        }
        dVar.desc = "";
        String str3 = "";
        for (String str22 : linkedList) {
            str3 = str3 + str22;
        }
        str22 = str3.trim();
        if (linkedList.size() >= 5) {
            str22 = str22 + "...";
        }
        dVar.desc = str22;
        return dVar;
    }

    private static void a(d dVar, uq uqVar, int i) {
        String str = uqVar.wdj;
        if (com.tencent.mm.a.e.bO(str)) {
            dVar.fvC = str;
        } else {
            dVar.fEI = i;
        }
    }

    public static int a(String str, String str2, au auVar) {
        if (bh.ov(str)) {
            x.w("MicroMsg.RecordMsgLogic", "send record msg error, touser is null");
            return -1;
        } else if (auVar == null || bh.ov(auVar.field_content)) {
            x.w("MicroMsg.RecordMsgLogic", "send record msg error, msginfo error");
            return -1;
        } else if (1 == auVar.field_status) {
            x.w("MicroMsg.RecordMsgLogic", "send record msg error, msginfo is sending");
            return -1;
        } else {
            for (String str3 : bh.F(str.split(","))) {
                x.i("MicroMsg.RecordMsgLogic", "send recordMsg, toUser[%s] msgId[%d], msgType[%d]", new Object[]{str3, Long.valueOf(auVar.field_msgId), Integer.valueOf(auVar.field_status)});
                String hQ = ba.hQ(auVar.field_content);
                g$a fT = g$a.fT(hQ);
                if (fT == null) {
                    x.w("MicroMsg.RecordMsgLogic", "send record msg error, parse appmsg error");
                    return -1;
                }
                c Ik = Ik(fT.hbB);
                if (Ik == null) {
                    x.w("MicroMsg.RecordMsgLogic", "send record msg error, parse record data error");
                    return -1;
                }
                com.tencent.mm.g.b.cf auVar2 = new au();
                if (!bh.ov(auVar.field_imgPath)) {
                    String f = o.Pw().f(8, bh.readFromFile(o.Pw().B(auVar.field_imgPath, true)));
                    x.d("MicroMsg.RecordMsgLogic", g.zh() + " thumbData from msg MsgInfo path:" + f);
                    if (!bh.ov(f)) {
                        auVar2.dT(f);
                    }
                }
                auVar2.setContent(hQ);
                auVar2.eQ(1);
                auVar2.dS(str3);
                auVar2.aq(ba.hR(str3));
                auVar2.eR(1);
                auVar2.setType(49);
                ar.Hg();
                long Q = com.tencent.mm.z.c.Fa().Q(auVar2);
                x.d("MicroMsg.RecordMsgLogic", g.zh() + " msginfo insert id: " + Q);
                if (Q < 0) {
                    x.e("MicroMsg.RecordMsgLogic", g.zh() + "insert msg failed :" + Q);
                    return 0 - g.getLine();
                }
                Object obj;
                x.i("MicroMsg.RecordMsgLogic", g.getLine() + " new msg inserted to db , local id = " + Q);
                auVar2.ao(Q);
                com.tencent.mm.sdk.b.b rwVar = new rw();
                rwVar.fJD.fJE = auVar.field_msgId;
                rwVar.fJD.fJF = Q;
                com.tencent.mm.sdk.b.a.xef.m(rwVar);
                com.tencent.mm.sdk.e.c gVar = new com.tencent.mm.y.g();
                gVar.field_xml = auVar2.field_content;
                gVar.field_title = fT.title;
                gVar.field_type = fT.type;
                gVar.field_description = fT.description;
                gVar.field_msgId = Q;
                an.bYS().b(gVar);
                Iterator it = Ik.hdX.iterator();
                while (it.hasNext()) {
                    uq uqVar = (uq) it.next();
                    if (bh.ov(uqVar.wcJ)) {
                        if (!bh.ov(uqVar.hbj)) {
                        }
                    }
                    obj = 1;
                }
                obj = null;
                if (obj != null) {
                    gVar = new com.tencent.mm.plugin.record.a.g();
                    ve veVar = new ve();
                    veVar.weU.addAll(Ik.hdX);
                    gVar.field_msgId = Q;
                    gVar.field_oriMsgId = auVar.field_msgId;
                    gVar.field_toUser = str3;
                    gVar.field_title = fT.title;
                    gVar.field_desc = bh.az(Ik.desc, fT.description);
                    gVar.field_dataProto = veVar;
                    gVar.field_type = 0;
                    gVar.field_favFrom = Ik.vCT;
                    gVar.field_localId = new Random().nextInt(2147483645) + 1;
                    n.bmS().b(gVar);
                    n.bmT().a(gVar);
                } else {
                    x.d("MicroMsg.RecordMsgLogic", "do not check upload, directly send msg");
                    an.bYU();
                    a.ft(Q);
                }
                if (!bh.ov(str2)) {
                    com.tencent.mm.plugin.messenger.a.f.aZh().A(str3, str2, s.hp(str3));
                }
            }
            return 0;
        }
    }

    public static int a(String str, ve veVar, String str2, String str3, String str4, int i, String str5) {
        if (bh.ov(str)) {
            x.w("MicroMsg.RecordMsgLogic", "send record msg error, touser is null");
            return -1;
        } else if (veVar == null || veVar.weU.isEmpty()) {
            x.w("MicroMsg.RecordMsgLogic", "send record msg error, favprotoitem error");
            return -1;
        } else {
            g$a a = a(str2, str3, veVar);
            com.tencent.mm.g.b.cf auVar = new au();
            byte[] bArr = null;
            if (!bh.ov(str4)) {
                bArr = bh.readFromFile(str4);
            } else if (i != 0) {
                bArr = com.tencent.mm.sdk.platformtools.d.Q(com.tencent.mm.sdk.platformtools.d.CZ(i));
            } else if (!bh.ov(str5)) {
                bArr = com.tencent.mm.sdk.platformtools.d.Q(b.a(str5, false, -1));
            }
            if (bArr != null) {
                String a2;
                if (bArr.length > WXMediaMessage.THUMB_LENGTH_LIMIT) {
                    a2 = o.Pw().a(bArr, false, CompressFormat.JPEG);
                } else {
                    a2 = o.Pw().f(8, bArr);
                }
                x.d("MicroMsg.RecordMsgLogic", g.zh() + " thumbData MsgInfo path:" + a2);
                if (!bh.ov(a2)) {
                    auVar.dT(a2);
                }
            }
            auVar.setContent(g$a.a(a, null, null));
            auVar.eQ(1);
            auVar.dS(str);
            auVar.aq(ba.hR(str));
            auVar.eR(1);
            auVar.setType(49);
            if (com.tencent.mm.ag.f.eE(str)) {
                auVar.dY(e.HD());
            }
            ar.Hg();
            long Q = com.tencent.mm.z.c.Fa().Q(auVar);
            x.d("MicroMsg.RecordMsgLogic", g.zh() + " msginfo insert id: " + Q);
            if (Q < 0) {
                x.e("MicroMsg.RecordMsgLogic", g.zh() + "insert msg failed :" + Q);
                return 0 - g.getLine();
            }
            Object obj;
            x.i("MicroMsg.RecordMsgLogic", g.getLine() + " new msg inserted to db , local id = " + Q);
            auVar.ao(Q);
            com.tencent.mm.sdk.e.c gVar = new com.tencent.mm.y.g();
            gVar.field_xml = auVar.field_content;
            gVar.field_title = a.title;
            gVar.field_type = a.type;
            gVar.field_description = a.description;
            gVar.field_msgId = Q;
            an.bYS().b(gVar);
            Iterator it = veVar.weU.iterator();
            while (it.hasNext()) {
                uq uqVar = (uq) it.next();
                if (bh.ov(uqVar.wcJ)) {
                    if (!bh.ov(uqVar.hbj)) {
                    }
                }
                obj = 1;
            }
            obj = null;
            if (obj != null || com.tencent.mm.pluginsdk.model.c.vdg) {
                gVar = new com.tencent.mm.plugin.record.a.g();
                gVar.field_msgId = Q;
                gVar.field_title = a.title;
                gVar.field_desc = a.description;
                gVar.field_toUser = str;
                gVar.field_dataProto = veVar;
                gVar.field_type = 1;
                gVar.field_localId = new Random().nextInt(2147483645) + 1;
                n.bmS().b(gVar);
                n.bmT().a(gVar);
            } else {
                x.d("MicroMsg.RecordMsgLogic", "do not trans cdn, directly send msg");
                an.bYU();
                a.ft(Q);
            }
            return 0;
        }
    }

    private static File eb(long j) {
        r2 = new Object[2];
        ar.Hg();
        r2[0] = com.tencent.mm.z.c.Fw();
        r2[1] = Long.valueOf(j);
        File file = new File(String.format("%s/%d/", r2));
        if (!(file.exists() && file.isDirectory())) {
            file.mkdirs();
        }
        return file;
    }

    public static void ec(long j) {
        boolean g = com.tencent.mm.a.e.g(eb(j));
        x.i("MicroMsg.RecordMsgLogic", "do clear resource, path %s, result %B", new Object[]{r0.getAbsolutePath(), Boolean.valueOf(g)});
    }

    public static String c(uq uqVar, long j) {
        int i = 1;
        if (uqVar == null) {
            return "";
        }
        String str = uqVar.mvG;
        if (bh.ov(str) || !ar.Hj()) {
            return "";
        }
        File file;
        String str2;
        File eb = eb(j);
        if (uqVar.bjS != 8 || bh.ov(uqVar.title)) {
            i = 0;
            file = eb;
            str2 = str;
        } else {
            str = uqVar.title;
            int hashCode = uqVar.mvG.hashCode() & 255;
            r6 = new Object[3];
            ar.Hg();
            r6[0] = com.tencent.mm.z.c.Fw();
            r6[1] = Long.valueOf(j);
            r6[2] = Integer.valueOf(hashCode);
            eb = new File(String.format("%s/%d/%d/", r6));
            if (!(eb.exists() && eb.isDirectory())) {
                eb.mkdirs();
            }
            file = eb;
            str2 = str;
        }
        if (uqVar.wcY != null && uqVar.wcY.trim().length() > 0 && r0 == 0) {
            str2 = str2 + "." + uqVar.wcY;
        }
        return new File(file, str2).getAbsolutePath();
    }

    public static boolean d(uq uqVar, long j) {
        return new File(c(uqVar, j)).exists();
    }

    public static boolean e(uq uqVar, long j) {
        return new File(f(uqVar, j)).exists();
    }

    public static String f(uq uqVar, long j) {
        if (uqVar == null || bh.ov(uqVar.mvG)) {
            return "";
        }
        return new File(eb(j), Ac(uqVar.mvG)).getAbsolutePath();
    }

    public static String Ac(String str) {
        return str + "_t";
    }

    public static String d(String str, long j, boolean z) {
        if (z) {
            return str + "@record_download@" + j;
        }
        return str + "@record_upload@" + j;
    }

    public static c Ik(String str) {
        if (bh.ov(str)) {
            x.e("MicroMsg.RecordMsgLogic", "xml is null");
            return null;
        }
        int hashCode = str.hashCode();
        c cVar = (c) hdO.get(Integer.valueOf(hashCode));
        if (cVar != null) {
            x.d("MicroMsg.RecordMsgLogic", "get record msg data from cache");
            return cVar;
        }
        Map y;
        if (str.trim().startsWith("<recordinfo>")) {
            y = bi.y(str, "recordinfo");
        } else {
            y = bi.y("<recordinfo>" + str + "</recordinfo>", "recordinfo");
        }
        if (y == null) {
            x.e("MicroMsg.RecordMsgLogic", "values is null: %s", new Object[]{str});
            return null;
        }
        c cVar2 = new c();
        cVar2.title = (String) y.get(".recordinfo.title");
        cVar2.desc = (String) y.get(".recordinfo.desc");
        cVar2.vCT = (String) y.get(".recordinfo.favusername");
        if (y.get(".recordinfo.noteinfo") != null) {
            uy uyVar = new uy();
            uyVar.weM = (String) y.get(".recordinfo.noteinfo.noteeditor");
            uyVar.weL = (String) y.get(".recordinfo.noteinfo.noteauthor");
            cVar2.vCU = uyVar;
            cVar2.vCV = bh.getLong((String) y.get(".recordinfo.edittime"), 0);
        }
        a(str, cVar2);
        hdO.put(Integer.valueOf(hashCode), cVar2);
        return cVar2;
    }

    private static void a(String str, c cVar) {
        cVar.hdX.clear();
        try {
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new ByteArrayInputStream(str.getBytes())));
            parse.normalize();
            NodeList elementsByTagName = parse.getDocumentElement().getElementsByTagName("datalist");
            if (elementsByTagName != null) {
                NodeList childNodes = elementsByTagName.item(0).getChildNodes();
                if (childNodes != null && childNodes.getLength() > 0) {
                    int length = childNodes.getLength();
                    for (int i = 0; i < length; i++) {
                        String str2;
                        Map y;
                        Object obj;
                        Node item = childNodes.item(i);
                        String b = bi.b(item);
                        NodeList elementsByTagName2 = ((Element) item).getElementsByTagName("recordxml");
                        if (elementsByTagName2 == null || elementsByTagName2.getLength() <= 0) {
                            str2 = null;
                        } else {
                            str2 = bi.b(elementsByTagName2.item(0).getFirstChild());
                        }
                        if (b.trim().startsWith("<dataitem")) {
                            y = bi.y(b, "dataitem");
                        } else {
                            y = null;
                        }
                        if (y == null) {
                            obj = null;
                        } else {
                            uq uqVar = new uq();
                            String str3 = ".dataitem";
                            uqVar.CJ(bh.getInt((String) y.get(str3 + ".$datatype"), 0));
                            uqVar.TI((String) y.get(str3 + ".$datasourceid"));
                            uqVar.CK(bh.getInt((String) y.get(str3 + ".$datastatus"), 0));
                            uqVar.TA((String) y.get(str3 + ".datafmt"));
                            uqVar.Tq((String) y.get(str3 + ".datatitle"));
                            uqVar.Tr((String) y.get(str3 + ".datadesc"));
                            uqVar.Ts((String) y.get(str3 + ".cdnthumburl"));
                            uqVar.Tt((String) y.get(str3 + ".cdnthumbkey"));
                            uqVar.CG(bh.getInt((String) y.get(str3 + ".thumbwidth"), 0));
                            uqVar.CH(bh.getInt((String) y.get(str3 + ".thumbheight"), 0));
                            uqVar.Tu((String) y.get(str3 + ".cdndataurl"));
                            uqVar.Tv((String) y.get(str3 + ".cdndatakey"));
                            String str4 = (String) y.get(str3 + ".duration");
                            if (str4 != null && str4.length() > 0) {
                                uqVar.CI(bh.getInt(str4, 0));
                            }
                            uqVar.Tx((String) y.get(str3 + ".streamdataurl"));
                            uqVar.Ty((String) y.get(str3 + ".streamlowbandurl"));
                            uqVar.Tw((String) y.get(str3 + ".streamweburl"));
                            uqVar.TB((String) y.get(str3 + ".fullmd5"));
                            uqVar.TC((String) y.get(str3 + ".head256md5"));
                            str4 = (String) y.get(str3 + ".datasize");
                            if (!bh.ov(str4)) {
                                uqVar.fw((long) bh.getInt(str4, 0));
                            }
                            uqVar.Tz((String) y.get(str3 + ".dataext"));
                            uqVar.TG((String) y.get(str3 + ".thumbfullmd5"));
                            uqVar.TH((String) y.get(str3 + ".thumbhead256md5"));
                            str4 = (String) y.get(str3 + ".thumbsize");
                            if (!bh.ov(str4)) {
                                uqVar.fx((long) bh.getInt(str4, 0));
                            }
                            uqVar.TJ((String) y.get(str3 + ".streamvideoid"));
                            str4 = (String) y.get(str3 + ".$dataid");
                            if (bh.ov(str4)) {
                                str4 = String.valueOf(i);
                            }
                            uqVar.TD(str4);
                            str4 = (String) y.get(str3 + ".$htmlid");
                            if (!bh.ov(str4)) {
                                uqVar.TN(str4);
                            }
                            uqVar.CL(bh.getInt((String) y.get(str3 + ".$dataillegaltype"), 0));
                            uqVar.TK((String) y.get(str3 + ".sourcetitle"));
                            uqVar.TL((String) y.get(str3 + ".sourcename"));
                            uqVar.TM((String) y.get(str3 + ".sourcetime"));
                            uqVar.TO((String) y.get(str3 + ".statextstr"));
                            if (str2 != null) {
                                uqVar.TQ(str2);
                            }
                            ur urVar = new ur();
                            us usVar = new us();
                            usVar.CN(bh.getInt((String) y.get(str3 + ".$sourcetype"), 0));
                            str4 = (String) y.get(str3 + ".dataitemsource.fromusr");
                            if (!bh.ov(str4)) {
                                usVar.TR(str4);
                                x.d("MicroMsg.RecordMsgParser", "fromusr %s", new Object[]{usVar.fzO});
                            }
                            str4 = (String) y.get(str3 + ".dataitemsource.realchatname");
                            if (!bh.ov(str4)) {
                                usVar.TU(str4);
                                x.d("MicroMsg.RecordMsgParser", "realChatname %s", new Object[]{usVar.wet});
                            }
                            usVar.TW((String) y.get(str3 + ".appid"));
                            usVar.TX((String) y.get(str3 + ".link"));
                            usVar.TY((String) y.get(str3 + ".brandid"));
                            urVar.c(usVar);
                            String str5 = str3 + ".locitem";
                            if (y.containsKey(str5)) {
                                ux uxVar = new ux();
                                if (!bh.ov((String) y.get(str5 + ".label"))) {
                                    uxVar.TZ((String) y.get(str5 + ".label"));
                                }
                                if (!bh.ov((String) y.get(str5 + ".poiname"))) {
                                    uxVar.Ua((String) y.get(str5 + ".poiname"));
                                }
                                str4 = (String) y.get(str5 + ".lng");
                                if (!bh.ov(str4)) {
                                    uxVar.r(bh.getDouble(str4, 0.0d));
                                }
                                str4 = (String) y.get(str5 + ".lat");
                                if (!bh.ov(str4)) {
                                    uxVar.s(bh.getDouble(str4, 0.0d));
                                }
                                str4 = (String) y.get(str5 + ".scale");
                                if (!bh.ov(str4)) {
                                    if (str4.indexOf(46) != -1) {
                                        uxVar.CO(bh.getInt(str4.substring(0, str4.indexOf(46)), -1));
                                    } else {
                                        uxVar.CO(bh.getInt(str4, -1));
                                    }
                                }
                                urVar.a(uxVar);
                            } else {
                                x.w("MicroMsg.RecordMsgParser", "cur fav not contains %s", new Object[]{str5});
                            }
                            str5 = str3 + ".weburlitem";
                            if (y.containsKey(str5)) {
                                vt vtVar = new vt();
                                vtVar.Uv((String) y.get(str5 + ".title"));
                                vtVar.Uw((String) y.get(str5 + ".desc"));
                                vtVar.Uy((String) y.get(str5 + ".thumburl"));
                                vtVar.Ux((String) y.get(str5 + ".link"));
                                vtVar.CT(bh.getInt((String) y.get(str5 + ".opencache"), 0));
                                urVar.a(vtVar);
                            } else {
                                x.w("MicroMsg.RecordMsgParser", "cur fav not contains %s", new Object[]{str5});
                            }
                            str5 = str3 + ".productitem";
                            if (y.containsKey(str5)) {
                                vd vdVar = new vd();
                                vdVar.Ub((String) y.get(str5 + ".title"));
                                vdVar.Uc((String) y.get(str5 + ".desc"));
                                vdVar.Ud((String) y.get(str5 + ".thumburl"));
                                vdVar.Ue((String) y.get(str5 + ".productinfo"));
                                vdVar.CP(bh.getInt((String) y.get(str5 + ".$type"), 0));
                                urVar.a(vdVar);
                            } else {
                                x.w("MicroMsg.RecordMsgParser", "cur fav not contains %s", new Object[]{str5});
                            }
                            str3 = str3 + ".tvitem";
                            if (y.containsKey(str3)) {
                                vn vnVar = new vn();
                                vnVar.Ur((String) y.get(str3 + ".title"));
                                vnVar.Us((String) y.get(str3 + ".desc"));
                                vnVar.Ut((String) y.get(str3 + ".thumburl"));
                                vnVar.Uu((String) y.get(str3 + ".tvinfo"));
                                urVar.a(vnVar);
                            } else {
                                x.w("MicroMsg.RecordMsgParser", "cur fav not contains %s", new Object[]{str3});
                            }
                            uqVar.a(urVar);
                            uq uqVar2 = uqVar;
                        }
                        try {
                            cVar.hdX.add(obj);
                        } catch (Throwable e) {
                            x.e("MicroMsg.RecordMsgLogic", "get record msg data from xml error: %s", new Object[]{e.getMessage()});
                            x.printErrStackTrace("MicroMsg.RecordMsgLogic", e, "", new Object[0]);
                            cVar.hdX.clear();
                        }
                    }
                }
            }
        } catch (Exception e2) {
            x.e("MicroMsg.RecordMsgLogic", "[parser] parseXML exception:%s", new Object[]{e2.toString()});
        }
    }

    public static int vs(int i) {
        if (2 == i) {
            return com.tencent.mm.modelcdntran.b.MediaType_FULLSIZEIMAGE;
        }
        if (4 == i) {
            return com.tencent.mm.modelcdntran.b.MediaType_VIDEO;
        }
        return com.tencent.mm.modelcdntran.b.MediaType_FILE;
    }

    public static boolean a(uq uqVar, long j, boolean z) {
        if (uqVar == null) {
            x.w("MicroMsg.RecordMsgLogic", "try download data fail, dataitem is null");
            return false;
        }
        String d = d(uqVar.mvG, j, true);
        com.tencent.mm.plugin.record.a.f Ij = n.getRecordMsgCDNStorage().Ij(d);
        if (Ij == null) {
            Ij = new com.tencent.mm.plugin.record.a.f();
            Ij.field_cdnKey = uqVar.wcL;
            Ij.field_cdnUrl = uqVar.wcJ;
            Ij.field_dataId = uqVar.mvG;
            Ij.field_mediaId = d;
            Ij.field_totalLen = (int) uqVar.wde;
            Ij.field_localId = new Random().nextInt(2147483645) + 1;
            Ij.field_path = c(uqVar, j);
            Ij.field_type = 1;
            Ij.field_fileType = vs(uqVar.bjS);
            Ij.field_isThumb = false;
            boolean a = n.getRecordMsgCDNStorage().a(Ij);
            x.d("MicroMsg.RecordMsgLogic", "insert localId[%d] result[%B]", new Object[]{Integer.valueOf(Ij.field_localId), Boolean.valueOf(a)});
            if (!bh.ov(uqVar.wdL) && uqVar.wdL.equals("WeNoteHtmlFile")) {
                n.bmU().a(Ij, true);
            }
        }
        x.d("MicroMsg.RecordMsgLogic", "try download data, dump record cdninfo: %s", new Object[]{Ij});
        if (4 == Ij.field_status) {
            x.w("MicroMsg.RecordMsgLogic", "try download, but cdn info out of date, code[%d]", new Object[]{Integer.valueOf(Ij.field_errCode)});
            return false;
        }
        if (3 == Ij.field_status) {
            x.i("MicroMsg.RecordMsgLogic", "try download, but cdn info error, code[%d], can retry[%B]", new Object[]{Integer.valueOf(Ij.field_errCode), Boolean.valueOf(z)});
            if (!z) {
                return false;
            }
            Ij.field_status = 1;
            n.getRecordMsgCDNStorage().b(Ij, new String[]{"localId"});
        }
        n.bmU().run();
        return true;
    }

    public static boolean g(uq uqVar, long j) {
        if (uqVar == null) {
            x.w("MicroMsg.RecordMsgLogic", "checkDataOutOfDate fail, dataitem is null");
            return true;
        }
        com.tencent.mm.plugin.record.a.f Ij = n.getRecordMsgCDNStorage().Ij(d(uqVar.mvG, j, true));
        if (Ij == null) {
            x.d("MicroMsg.RecordMsgLogic", "checkDataOutOfDate ok, not find cdn info");
            return false;
        } else if (4 == Ij.field_status) {
            x.w("MicroMsg.RecordMsgLogic", "checkDataOutOfDate ok, status err, code %d", new Object[]{Integer.valueOf(Ij.field_errCode)});
            return true;
        } else {
            x.d("MicroMsg.RecordMsgLogic", "checkDataOutOfDate ok, find cdn info, status %d", new Object[]{Integer.valueOf(Ij.field_status)});
            return false;
        }
    }

    public static boolean b(uq uqVar, long j, boolean z) {
        if (uqVar == null) {
            x.w("MicroMsg.RecordMsgLogic", "try download thumb error, dataitem is null");
            return false;
        }
        String Ac = Ac(uqVar.mvG);
        String d = d(Ac, j, true);
        com.tencent.mm.plugin.record.a.f Ij = n.getRecordMsgCDNStorage().Ij(d);
        if (Ij == null) {
            Ij = new com.tencent.mm.plugin.record.a.f();
            Ij.field_cdnKey = uqVar.wcF;
            Ij.field_cdnUrl = uqVar.hbj;
            Ij.field_dataId = Ac;
            Ij.field_mediaId = d;
            Ij.field_totalLen = (int) uqVar.wdp;
            Ij.field_localId = new Random().nextInt(2147483645) + 1;
            Ij.field_path = f(uqVar, j);
            Ij.field_type = 1;
            Ij.field_fileType = com.tencent.mm.modelcdntran.b.MediaType_FULLSIZEIMAGE;
            Ij.field_isThumb = true;
            boolean a = n.getRecordMsgCDNStorage().a(Ij);
            x.d("MicroMsg.RecordMsgLogic", "insert localId[%d] result[%B]", new Object[]{Integer.valueOf(Ij.field_localId), Boolean.valueOf(a)});
        }
        x.v("MicroMsg.RecordMsgLogic", "try download thumb, dump record cdninfo: %s", new Object[]{Ij});
        if (4 == Ij.field_status) {
            x.w("MicroMsg.RecordMsgLogic", "try download thumb, but cdn info out of date, code[%d]", new Object[]{Integer.valueOf(Ij.field_errCode)});
            return false;
        }
        if (3 == Ij.field_status) {
            x.i("MicroMsg.RecordMsgLogic", "try download thumb, but cdn info error, code[%d], can retry[%B]", new Object[]{Integer.valueOf(Ij.field_errCode), Boolean.valueOf(z)});
            if (!z) {
                return false;
            }
            Ij.field_status = 1;
            n.getRecordMsgCDNStorage().b(Ij, new String[]{"localId"});
        }
        n.bmU().run();
        return true;
    }

    public static String gv(String str) {
        ar.Hg();
        com.tencent.mm.storage.x WO = com.tencent.mm.z.c.EY().WO(str);
        if (WO == null) {
            x.w("MicroMsg.RecordMsgLogic", "wtf get contact null, username %s", new Object[]{str});
            return "";
        }
        String AQ = WO.AQ();
        if (!s.eV(AQ)) {
            return AQ;
        }
        List gj = m.gj(str);
        String FS = q.FS();
        if (gj == null || gj.isEmpty()) {
            x.w("MicroMsg.RecordMsgLogic", "get members from username error, content empty");
            return AQ;
        }
        gj.remove(FS);
        gj.add(0, FS);
        return m.b(gj, 3);
    }

    public static boolean h(uq uqVar, long j) {
        return p.UR(c(uqVar, j));
    }
}
