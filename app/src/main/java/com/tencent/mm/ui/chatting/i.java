package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.database.Cursor;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.ad.h;
import com.tencent.mm.ad.n;
import com.tencent.mm.ag.y;
import com.tencent.mm.aq.e;
import com.tencent.mm.aq.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.k;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.y.g.a;
import com.tencent.mm.y.l;
import com.tencent.mm.y.m;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;
import com.tencent.mm.z.u;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class i {
    public static boolean ai(au auVar) {
        if (auVar == null) {
            x.w("MicroMsg.ChattingEditModeLogic", "check is store emoji error, msg is null");
            return true;
        }
        EmojiInfo yc;
        if (auVar.cjk()) {
            a aVar;
            aj ajVar = new aj(auVar.field_content);
            a I = a.I(auVar.field_content, auVar.field_reserved);
            if (I == null) {
                I = new a();
                I.hbd = ajVar.fqR;
                aVar = I;
            } else {
                aVar = I;
            }
            yc = ((c) g.k(c.class)).getEmojiMgr().yc(aVar.hbd);
        } else {
            yc = ((c) g.k(c.class)).getEmojiMgr().yc(auVar.field_imgPath);
        }
        if (yc != null && (yc.field_catalog == EmojiInfo.xAk || (!bh.ov(yc.field_groupId) && ((c) g.k(c.class)).getEmojiMgr().yf(yc.field_groupId)))) {
            return false;
        }
        if (yc == null || !yc.ckx()) {
            return false;
        }
        return true;
    }

    public static boolean aj(au auVar) {
        if (auVar.cjk()) {
            a aVar;
            aj ajVar = new aj(auVar.field_content);
            a I = a.I(auVar.field_content, auVar.field_reserved);
            if (I == null) {
                I = new a();
                I.hbd = ajVar.fqR;
                aVar = I;
            } else {
                aVar = I;
            }
            if (((c) g.k(c.class)).getEmojiMgr().yc(aVar.hbd) == null) {
                return false;
            }
        }
        return true;
    }

    public static boolean ak(au auVar) {
        if (auVar == null) {
            x.w("MicroMsg.ChattingEditModeLogic", "check is game msg error, msg is null");
            return true;
        }
        String hQ;
        if (auVar.field_isSend == 0) {
            hQ = ba.hQ(auVar.field_content);
        } else {
            hQ = auVar.field_content;
        }
        a fT = a.fT(hQ);
        if (fT == null) {
            x.w("MicroMsg.ChattingEditModeLogic", "parse app message content fail");
            return false;
        }
        f aZ = com.tencent.mm.pluginsdk.model.app.g.aZ(fT.appId, false);
        return aZ != null && aZ.Yz();
    }

    public static boolean al(au auVar) {
        return auVar.getType() == 419430449;
    }

    public static boolean am(au auVar) {
        return auVar.getType() == 436207665 || auVar.getType() == 469762097;
    }

    public static boolean an(au auVar) {
        if (auVar == null) {
            x.w("MicroMsg.ChattingEditModeLogic", "isAppbrandForbidForwardMsg, check msg error, msg is null");
            return true;
        }
        String hQ;
        if (auVar.field_isSend == 0) {
            hQ = ba.hQ(auVar.field_content);
        } else {
            hQ = auVar.field_content;
        }
        a fT = a.fT(hQ);
        if (fT != null) {
            return fT.type == 33 && fT.hdz == 3;
        } else {
            x.w("MicroMsg.ChattingEditModeLogic", "isAppbrandForbidForwardMsg, parse app message content fail");
            return false;
        }
    }

    public static boolean db(List<au> list) {
        if (list == null || list.isEmpty()) {
            x.w("MicroMsg.ChattingEditModeLogic", "check contain invalid send to brand msg error, selected item empty");
            return true;
        }
        for (au auVar : list) {
            if (auVar.ciW() || ai(auVar) || auVar.cjf() || ak(auVar) || al(auVar) || auVar.getType() == -1879048186 || as(auVar) || am(auVar) || ar(auVar) || an(auVar)) {
                return true;
            }
            if (av(auVar)) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(List<au> list, ac acVar) {
        boolean z = true;
        if (list == null || list.isEmpty()) {
            x.w("MicroMsg.ChattingEditModeLogic", "check contain invalid send to friend msg error, select item empty");
            return false;
        } else if (list.size() == 1 && acVar != null && acVar.crU()) {
            r0 = (au) list.get(0);
            if (at(r0) || r0.ciW() || ai(r0) || ak(r0) || al(r0) || r0.getType() == -1879048186 || r0.getType() == 318767153 || as(r0) || am(r0) || au(r0) || ar(r0) || an(r0)) {
                return false;
            }
            return true;
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                boolean z2;
                r0 = (au) it.next();
                if (acVar == null || !acVar.crU()) {
                    if (ao(r0) || ap(r0)) {
                        it.remove();
                        z2 = false;
                    }
                    z2 = z;
                } else {
                    if (r0.ciW() || ai(r0) || ak(r0) || al(r0) || r0.getType() == -1879048186 || as(r0) || am(r0) || ((ao(r0) && (acVar == null || !acVar.crU())) || ((ap(r0) && (acVar == null || !acVar.crU())) || r0.getType() == 318767153 || at(r0) || au(r0) || ar(r0) || an(r0)))) {
                        it.remove();
                        z = false;
                    }
                    z2 = z;
                }
                z = z2;
            }
            return z;
        }
    }

    private static boolean ao(au auVar) {
        if (auVar == null) {
            return false;
        }
        a fT = a.fT(auVar.field_content);
        if (fT == null || fT.type != 19 || fT.hbB == null || !fT.hbB.contains("<recordxml>")) {
            return false;
        }
        return true;
    }

    private static boolean ap(au auVar) {
        if (auVar != null) {
            a fT = a.fT(auVar.field_content);
            if (fT != null && fT.type == 24) {
                return true;
            }
        }
        return false;
    }

    public static boolean aq(au auVar) {
        if (auVar == null) {
            return false;
        }
        a fT = a.fT(auVar.field_content);
        if (fT == null) {
            return false;
        }
        if (fT.type == 6 || fT.type == 5 || fT.type == 19) {
            return true;
        }
        return false;
    }

    public static boolean ar(au auVar) {
        if (auVar == null || !auVar.ciV()) {
            return false;
        }
        l vL = ((com.tencent.mm.plugin.biz.a.a) g.h(com.tencent.mm.plugin.biz.a.a.class)).vL(auVar.field_content);
        if (vL == null) {
            x.w("MicroMsg.ChattingEditModeLogic", "isBizMsgForbidForward reader is null");
            return false;
        } else if (vL.hdY == 1) {
            return true;
        } else {
            return false;
        }
    }

    static boolean as(au auVar) {
        if (auVar != null) {
            a fT = a.fT(auVar.field_content);
            if (fT != null && fT.type == 16) {
                return true;
            }
            if (fT != null && fT.type == 34) {
                return true;
            }
        }
        return false;
    }

    static boolean at(au auVar) {
        if (!auVar.cjf()) {
            return false;
        }
        ar.Hg();
        au.a EK = com.tencent.mm.z.c.Fa().EK(auVar.field_content);
        if (EK == null || bh.ov(EK.rYX)) {
            return true;
        }
        if (s.gF(EK.rYX)) {
            return false;
        }
        return true;
    }

    private static boolean au(au auVar) {
        if (auVar != null && auVar.aNc()) {
            a fT = a.fT(auVar.field_content);
            if (fT != null && fT.type == 6 && (fT.hbf != 0 || fT.hbb > 26214400)) {
                return true;
            }
        }
        return false;
    }

    public static boolean av(au auVar) {
        if (auVar != null && auVar.aNc()) {
            a fT = a.fT(auVar.field_content);
            if (fT != null && fT.type == 6) {
                return true;
            }
        }
        return false;
    }

    public static int dc(List<au> list) {
        if (list == null) {
            x.w("MicroMsg.ChattingEditModeLogic", "get invalid send to friend msg num error, select item empty");
            return 0;
        }
        int i = 0;
        for (au auVar : list) {
            int i2;
            if (auVar.ciW() || ai(auVar) || auVar.aNe() || ak(auVar) || al(auVar) || am(auVar)) {
                i2 = i + 1;
            } else {
                i2 = i;
            }
            i = i2;
        }
        return i;
    }

    public static boolean dd(List<au> list) {
        if (list == null) {
            x.w("MicroMsg.ChattingEditModeLogic", "check contain undownload file, select item empty");
            return false;
        }
        for (au auVar : list) {
            if (auVar.cje() || auVar.cjm()) {
                e bh;
                e eVar = null;
                if (auVar.field_msgId > 0) {
                    eVar = o.Pw().bi(auVar.field_msgId);
                }
                if ((eVar == null || eVar.hzP <= 0) && auVar.field_msgSvrId > 0) {
                    bh = o.Pw().bh(auVar.field_msgSvrId);
                } else {
                    bh = eVar;
                }
                if (bh != null && (bh.offset < bh.hlp || bh.hlp == 0)) {
                    return true;
                }
            } else if (auVar.cjh()) {
                r0 = com.tencent.mm.modelvideo.o.TU().nr(auVar.field_imgPath);
                if (!(r0 == null || r0.status == 199 || r0.status == 199)) {
                    return true;
                }
            } else if (auVar.cjk()) {
                if (!aj(auVar)) {
                    return true;
                }
            } else if (auVar.aNc()) {
                a I = a.I(auVar.field_content, auVar.field_content);
                if (I != null) {
                    switch (I.type) {
                        case 6:
                            b Rz = an.aqd().Rz(I.fny);
                            if (Rz != null) {
                                if (new File(Rz.field_fileFullPath).exists()) {
                                    break;
                                }
                                return true;
                            }
                            return true;
                        default:
                            break;
                    }
                }
                return true;
            } else if (auVar.cji()) {
                r0 = t.nF(auVar.field_imgPath);
                if (!(r0 == null || r0.status == 199 || r0.status == 199)) {
                    return true;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    public static boolean de(List<au> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        for (au auVar : list) {
            if (auVar.cjh() && k.Rv(auVar.field_imgPath)) {
                return true;
            }
        }
        return false;
    }

    public static boolean df(List<au> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        for (au cji : list) {
            if (cji.cji()) {
                return true;
            }
        }
        return false;
    }

    public static String q(String str, int i, boolean z) {
        if (z && str != null && i == 0) {
            return ba.hQ(str);
        }
        return str;
    }

    public static List<String> crp() {
        String str;
        List<String> hq = y.Mf().hq(25);
        com.tencent.mm.ag.e Mf = y.Mf();
        List<String> arrayList = new ArrayList();
        StringBuilder stringBuilder = new StringBuilder();
        com.tencent.mm.ag.e.a(stringBuilder);
        com.tencent.mm.ag.e.c(stringBuilder);
        com.tencent.mm.ag.e.d(stringBuilder);
        com.tencent.mm.ag.e.a(stringBuilder, true);
        stringBuilder.append(" order by ");
        stringBuilder.append(com.tencent.mm.ag.e.LI());
        x.i("MicroMsg.BizInfoStorage", "getEnterpriseBizChatLst sql %s", new Object[]{stringBuilder.toString()});
        Cursor rawQuery = Mf.rawQuery(r3, new String[0]);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                do {
                    arrayList.add(rawQuery.getString(0));
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
        }
        HashMap hashMap = new HashMap();
        for (String str2 : arrayList) {
            String Lm = com.tencent.mm.ag.f.jS(str2).Lm();
            if (!bh.ov(Lm)) {
                hashMap.put(Lm, str2);
            }
        }
        List<String> linkedList = new LinkedList();
        Collection linkedList2 = new LinkedList();
        for (String str22 : hq) {
            if (!com.tencent.mm.ag.f.jV(str22)) {
                linkedList.add(str22);
            } else if (com.tencent.mm.ag.f.jZ(str22)) {
                str22 = com.tencent.mm.ag.f.jS(str22).field_enterpriseFather;
                if (!linkedList2.contains(str22) && com.tencent.mm.ag.f.jX(str22)) {
                    linkedList2.add(str22);
                    str22 = (String) hashMap.get(str22);
                    if (!bh.ov(str22)) {
                        linkedList2.add(str22);
                    }
                }
            }
        }
        for (String str222 : hashMap.values()) {
            if (!(bh.ov(str222) || linkedList2.contains(str222))) {
                linkedList2.add(str222);
            }
        }
        linkedList.addAll(linkedList2);
        x.d("MicroMsg.ChattingEditModeLogic", "get selected accept list, size %d", new Object[]{Integer.valueOf(linkedList.size())});
        return linkedList;
    }

    public static List<String> crq() {
        List<String> hq = y.Mf().hq(25);
        List<String> linkedList = new LinkedList();
        for (String str : hq) {
            if (!com.tencent.mm.ag.f.jV(str)) {
                linkedList.add(str);
            }
        }
        x.d("MicroMsg.ChattingEditModeLogic", "get selected accept list without enterprise, size %d", new Object[]{Integer.valueOf(linkedList.size())});
        return linkedList;
    }

    static boolean a(Context context, String str, au auVar, String str2) {
        if (context == null) {
            x.w("MicroMsg.ChattingEditModeLogic", "send %s fail, context is null", new Object[]{str2});
            return false;
        } else if (bh.ov(str)) {
            x.w("MicroMsg.ChattingEditModeLogic", "send %s fail, username is null", new Object[]{str2});
            return false;
        } else if (auVar != null) {
            return true;
        } else {
            x.w("MicroMsg.ChattingEditModeLogic", "send %s fail, msg is null", new Object[]{str2});
            return false;
        }
    }

    public static void a(Context context, String str, au auVar) {
        if (a(context, str, auVar, "emoji")) {
            String str2;
            String str3 = aj.Xp(auVar.field_content).fqR;
            if (str3 == null || str3.endsWith("-1")) {
                str2 = auVar.field_imgPath;
            } else {
                str2 = str3;
            }
            if (str2 == null) {
                x.w("MicroMsg.ChattingEditModeLogic", "showAcceptEmojiConnector: filePath is null");
            } else {
                ((c) g.k(c.class)).getEmojiMgr().m(context, str, str2);
            }
        }
    }

    public static void b(Context context, String str, au auVar) {
        if (a(context, str, auVar, SlookAirButtonRecentMediaAdapter.IMAGE_TYPE)) {
            e bh;
            e eVar = null;
            if (auVar.field_msgId > 0) {
                eVar = o.Pw().bi(auVar.field_msgId);
            }
            if ((eVar == null || eVar.hzP <= 0) && auVar.field_msgSvrId > 0) {
                bh = o.Pw().bh(auVar.field_msgSvrId);
            } else {
                bh = eVar;
            }
            if (bh != null) {
                int i = 0;
                if (bh.Pe() && !com.tencent.mm.aq.f.a(bh).hzQ.startsWith("SERVERID://")) {
                    i = 1;
                }
                String m = o.Pw().m(com.tencent.mm.aq.f.c(bh), "", "");
                String m2 = o.Pw().m(bh.hzS, "th_", "");
                if (!bh.ov(m)) {
                    com.tencent.mm.plugin.messenger.a.f.aZh().a(context, str, m, i, bh.hAa, m2);
                }
            }
        }
    }

    public static void c(Context context, String str, au auVar) {
        if (a(context, str, auVar, SlookAirButtonRecentMediaAdapter.VIDEO_TYPE) && auVar != null) {
            if (auVar == null || !auVar.cji() || !t.nH(auVar.field_imgPath)) {
                r nF = t.nF(auVar.field_imgPath);
                String str2 = auVar.field_imgPath;
                int i = nF.hVL;
                int i2 = nF.hVH;
                String Ug = nF.Ug();
                int type = auVar.getType();
                x.d("MicroMsg.ChattingEditModeLogic", "copy video fileName %s userName %s export %d videoLength %d", new Object[]{str2, str, Integer.valueOf(i), Integer.valueOf(i2)});
                String ns = com.tencent.mm.modelvideo.s.ns(q.FS());
                com.tencent.mm.modelvideo.o.TU();
                x.d("MicroMsg.ChattingEditModeLogic", "copy video: srcFullPath[%s] destFullPath[%s] srcThumbPath[%s] destThumbPath[%s]", new Object[]{com.tencent.mm.modelvideo.s.nt(str2), com.tencent.mm.modelvideo.s.nt(ns), com.tencent.mm.modelvideo.s.nu(str2), com.tencent.mm.modelvideo.s.nu(ns)});
                com.tencent.mm.sdk.platformtools.k.q(r3, r7, false);
                com.tencent.mm.sdk.platformtools.k.q(str2, r8, false);
                t.a(ns, i2, str, null, i, Ug, type);
                t.nA(ns);
            }
        }
    }

    public static void a(Context context, String str, au auVar, boolean z) {
        if (a(context, str, auVar, "text")) {
            String q = q(auVar.field_content, auVar.field_isSend, z);
            if (auVar.cjw()) {
                q = q + "\n\n" + q(auVar.field_transContent, auVar.field_isSend, z);
            }
            if (q == null || q.equals("")) {
                x.e("MicroMsg.ChattingEditModeLogic", "Transfer text erro: content null");
            } else {
                com.tencent.mm.plugin.messenger.a.f.aZh().A(str, q, s.hp(str));
            }
        }
    }

    public static void b(Context context, String str, au auVar, boolean z) {
        if (!a(context, str, auVar, "appmsg")) {
            return;
        }
        if (context == null) {
            x.w("MicroMsg.ChattingEditModeLogic", "getReaderAppMsgContent: context is null");
        } else if (auVar == null) {
            x.w("MicroMsg.ChattingEditModeLogic", "getReaderAppMsgContent: msg is null");
        } else {
            ar.Hg();
            if (com.tencent.mm.z.c.isSDCardAvailable()) {
                String str2;
                String b = o.Pw().b(auVar.field_imgPath, false, false);
                if (com.tencent.mm.platformtools.t.ov(b) || b.endsWith("hd") || !FileOp.bO(b + "hd")) {
                    str2 = b;
                } else {
                    str2 = b + "hd";
                }
                try {
                    l vL = ((com.tencent.mm.plugin.biz.a.a) g.h(com.tencent.mm.plugin.biz.a.a.class)).vL(auVar.field_content);
                    List<m> list = vL.hdX;
                    if (list == null || list.size() <= 0) {
                        if (auVar == null || !(auVar.aNc() || auVar.ciV())) {
                            b = null;
                        } else {
                            String hz = u.hz(auVar.field_msgSvrId);
                            u.b t = u.GK().t(hz, true);
                            t.o("prePublishId", "msg_" + auVar.field_msgSvrId);
                            t.o("preUsername", com.tencent.mm.ui.chatting.viewitems.b.a(auVar, z, false));
                            t.o("preChatName", auVar.field_talker);
                            t.o("preMsgIndex", Integer.valueOf(0));
                            t.o("sendAppMsgScene", Integer.valueOf(1));
                            ((com.tencent.mm.plugin.sns.b.i) g.h(com.tencent.mm.plugin.sns.b.i.class)).a("adExtStr", t, auVar);
                            b = hz;
                        }
                        com.tencent.mm.plugin.messenger.a.f.aZh().a(str, bh.readFromFile(str2), bh.VH(auVar.field_content), b);
                        return;
                    }
                    for (m mVar : list) {
                        a aVar = new a();
                        if (com.tencent.mm.y.i.fV(mVar.hei)) {
                            k.b(str, k.a(str, mVar), mVar.hen);
                        } else {
                            aVar.title = mVar.title;
                            aVar.description = mVar.hef;
                            aVar.action = "view";
                            aVar.type = 5;
                            aVar.url = mVar.url;
                            aVar.fGz = vL.fGz;
                            aVar.fGA = vL.fGA;
                            aVar.gjD = vL.gjD;
                            aVar.thumburl = mVar.hed;
                            if (bh.ov(aVar.thumburl) && !bh.ov(aVar.fGz)) {
                                h jm = n.JQ().jm(aVar.fGz);
                                if (jm != null) {
                                    aVar.thumburl = jm.JG();
                                }
                            }
                            com.tencent.mm.plugin.messenger.a.f.aZh().a(str, bh.readFromFile(str2), bh.VH(a.a(aVar, null, null)), null);
                        }
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.ChattingEditModeLogic", e, "", new Object[0]);
                    x.e("MicroMsg.ChattingEditModeLogic", "send app msg error : %s", new Object[]{e.getLocalizedMessage()});
                }
            }
        }
    }

    public static void c(Context context, String str, au auVar, boolean z) {
        if (a(context, str, auVar, "location")) {
            com.tencent.mm.plugin.messenger.a.f.aZh().A(str, q(auVar.field_content, auVar.field_isSend, z), 48);
        }
    }

    public static void a(Context context, String str, String str2, int i, boolean z) {
        try {
            au auVar = new au();
            auVar.setContent(str2);
            auVar.eR(i);
            int indexOf = str2.indexOf("<msg>");
            if (indexOf > 0 && indexOf < str2.length()) {
                str2 = str2.substring(indexOf).trim();
            }
            Map y = bi.y(str2, "msg");
            if (y != null && y.size() > 0) {
                auVar.dU(ax.at(y));
            }
            b(context, str, auVar, z);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ChattingEditModeLogic", e, "", new Object[0]);
            x.e("MicroMsg.ChattingEditModeLogic", "retransmit sigle app msg error : %s", new Object[]{e.getLocalizedMessage()});
        }
    }

    public static void b(EmojiInfo emojiInfo, String str) {
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        StringBuilder stringBuilder = new StringBuilder();
        ar.Hg();
        String stringBuilder2 = stringBuilder.append(com.tencent.mm.z.c.Fp()).append(emojiInfo.Nr()).toString();
        if (com.tencent.mm.a.e.bN(stringBuilder2 + "_thumb") > 0) {
            wXMediaMessage.thumbData = com.tencent.mm.a.e.d(stringBuilder2 + "_thumb", 0, com.tencent.mm.a.e.bN(stringBuilder2 + "_thumb"));
        } else {
            try {
                InputStream fileInputStream = new FileInputStream(stringBuilder2);
                wXMediaMessage.setThumbImage(BackwardSupportUtil.b.a(fileInputStream, 1.0f));
                fileInputStream.close();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.ChattingEditModeLogic", e, "", new Object[0]);
                x.e("MicroMsg.ChattingEditModeLogic", "sendAppMsgEmoji Fail cause there is no thumb");
            }
        }
        wXMediaMessage.mediaObject = new WXEmojiObject(stringBuilder2);
        com.tencent.mm.pluginsdk.model.app.l.a(wXMediaMessage, emojiInfo.field_app_id, null, str, 1, emojiInfo.Nr());
    }
}
