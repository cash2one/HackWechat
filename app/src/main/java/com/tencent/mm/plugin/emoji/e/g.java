package com.tencent.mm.plugin.emoji.e;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.ae.d.a;
import com.tencent.mm.az.f;
import com.tencent.mm.g.a.bc;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.emoji.f.n;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI;
import com.tencent.mm.plugin.emoji.ui.EmojiAddCustomDialogUI;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.i.a.b.b;
import com.tencent.mm.pluginsdk.i.a.b.m;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.protocal.c.bis;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.al;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.q;
import com.tencent.mm.storage.emotion.r;
import com.tencent.mm.storage.emotion.t;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.tools.h;
import com.tencent.mm.y.g$a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.c;
import com.tencent.mm.z.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class g implements d {
    public final EmojiInfo yc(String str) {
        return i.aBE().lwL.XU(str);
    }

    public final EmojiInfo c(EmojiInfo emojiInfo) {
        if (emojiInfo.field_catalog == EmojiGroupInfo.xAc && emojiInfo.field_type == EmojiInfo.xAl && emojiInfo.we().length() > 0 && EmojiInfo.Du(bh.getInt(emojiInfo.we(), 0))) {
            Cursor Dy = i.aBE().lwL.Dy(bh.getInt(emojiInfo.we(), 0));
            if (Dy != null && Dy.getCount() > 1) {
                int eF = bh.eF(Dy.getCount() - 1, 0);
                emojiInfo = new EmojiInfo();
                Dy.moveToPosition(eF);
                emojiInfo.b(Dy);
            }
            if (Dy != null) {
                Dy.close();
            }
        }
        return emojiInfo;
    }

    public final boolean a(Context context, EmojiInfo emojiInfo, int i, String str) {
        if (context == null) {
            x.e("MicroMsg.emoji.EmojiMgrImpl", "[cpan] save emoji failed. context is null");
            return false;
        } else if (emojiInfo == null) {
            x.e("MicroMsg.emoji.EmojiMgrImpl", "[cpan] save emoji failed. emoji is null");
            return false;
        } else {
            Intent intent = new Intent();
            intent.setClass(context, EmojiAddCustomDialogUI.class);
            intent.putExtra("extra_id", emojiInfo.Nr());
            intent.putExtra("extra_scence", i);
            intent.addFlags(65536);
            intent.putExtra("extra_username", str);
            context.startActivity(intent);
            return true;
        }
    }

    public final void a(Context context, au auVar) {
        if (context == null || auVar == null) {
            x.w("MicroMsg.emoji.EmojiMgrImpl", "context or msg is null");
            return;
        }
        aj Xp = aj.Xp(auVar.field_content);
        g$a fT = g$a.fT(auVar.field_content);
        if (fT == null) {
            fT = new g$a();
            fT.hbd = Xp.fqR;
        }
        EmojiInfo XU = i.aBE().lwL.XU(fT.hbd);
        long j;
        if (auVar.field_isSend == 1) {
            if (XU == null || !XU.cks()) {
                j = auVar.field_msgId;
                c(fT);
                return;
            }
            a(context, fT.hbd, fT.appId, fT.appName, auVar.field_msgSvrId, auVar.field_talker, auVar.field_content);
        } else if (XU == null || !XU.cks()) {
            j = auVar.field_msgId;
            c(fT);
        } else {
            a(context, XU.Nr(), fT.appId, fT.appName, auVar.field_msgSvrId, auVar.field_talker, auVar.field_content);
        }
    }

    public final boolean m(Context context, String str, String str2) {
        if (context == null) {
            x.w("MicroMsg.emoji.EmojiMgrImpl", "sendEmoji: context is null");
            return false;
        } else if (bh.ov(str) || bh.ov(str2)) {
            x.w("MicroMsg.emoji.EmojiMgrImpl", "sendEmoji: userName or imgPath is null");
            return false;
        } else {
            EmojiInfo XU = i.aBE().lwL.XU(str2);
            if (XU == null) {
                x.w("MicroMsg.emoji.EmojiMgrImpl", "sendEmoji: emoji not found, imgPath %s", new Object[]{str2});
                return false;
            }
            if (XU.field_type == EmojiInfo.xAo || XU.field_type == EmojiInfo.xAp) {
                WXMediaMessage wXMediaMessage = new WXMediaMessage();
                StringBuilder stringBuilder = new StringBuilder();
                ar.Hg();
                String stringBuilder2 = stringBuilder.append(c.Fp()).append(XU.Nr()).toString();
                if (e.bO(stringBuilder2 + "_thumb")) {
                    wXMediaMessage.thumbData = e.d(stringBuilder2 + "_thumb", 0, e.bN(stringBuilder2 + "_thumb"));
                } else {
                    wXMediaMessage.setThumbImage(XU.fn(context));
                }
                wXMediaMessage.mediaObject = new WXEmojiObject(stringBuilder2);
                l.a(wXMediaMessage, XU.field_app_id, null, str, 0, XU.Nr());
            } else {
                EmojiInfo emojiInfo;
                if (XU.field_type == EmojiInfo.xAl) {
                    Cursor Dy = EmojiInfo.Du(XU.field_catalog) ? i.aBE().lwL.Dy(XU.field_catalog) : (XU.field_catalog == EmojiInfo.xAg && XU.we().length() > 0 && EmojiInfo.Du(bh.getInt(XU.we(), 0))) ? i.aBE().lwL.Dy(bh.getInt(XU.we(), 0)) : null;
                    if (Dy != null) {
                        int eF = bh.eF(Dy.getCount() - 1, 0);
                        emojiInfo = new EmojiInfo();
                        Dy.moveToPosition(eF);
                        emojiInfo.b(Dy);
                        Dy.close();
                        i.aBy().a(str, emojiInfo, null);
                    }
                }
                emojiInfo = XU;
                i.aBy().a(str, emojiInfo, null);
            }
            return true;
        }
    }

    public final void a(String str, EmojiInfo emojiInfo, au auVar) {
        if (emojiInfo != null || auVar != null) {
            if (emojiInfo == null) {
                emojiInfo = i.aBE().lwL.XU(auVar.field_imgPath);
            }
            i.aBy().a(str, emojiInfo, auVar);
        }
    }

    private static void a(Context context, String str, String str2, String str3, long j, String str4, String str5) {
        if (str.equals("-1")) {
            x.e("MicroMsg.emoji.EmojiMgrImpl", "showEmoji fail cause md5 is no valid");
            return;
        }
        EmojiInfo XU = i.aBE().lwL.XU(str);
        if (XU == null) {
            x.e("MicroMsg.emoji.EmojiMgrImpl", "showEmoji fail cause md5 is no valid");
            return;
        }
        Intent intent = new Intent(context, CustomSmileyPreviewUI.class);
        intent.putExtra("custom_smiley_preview_md5", str);
        if (str2 != null) {
            intent.putExtra("custom_smiley_preview_appid", str2);
        } else {
            intent.putExtra("custom_smiley_preview_appid", XU.field_app_id);
        }
        intent.putExtra("custom_smiley_preview_appname", str3);
        intent.putExtra("msg_id", j);
        intent.putExtra("msg_content", str5);
        if (s.eV(str4)) {
            str4 = ba.hP(str5);
        }
        intent.putExtra("msg_sender", str4);
        context.startActivity(intent);
    }

    private static void c(g$a com_tencent_mm_y_g_a) {
        i.aBH();
        if (com_tencent_mm_y_g_a == null) {
            x.e("MicroMsg.emoji.EmojiAppMsgDownloadService", "msg content is null");
            return;
        }
        String str = com_tencent_mm_y_g_a.hbd;
        if (bh.ov(str)) {
            x.e("MicroMsg.emoji.EmojiAppMsgDownloadService", "md5 is null.");
            return;
        }
        EmojiInfo emojiInfo = new EmojiInfo();
        emojiInfo.field_md5 = str;
        emojiInfo.field_app_id = com_tencent_mm_y_g_a.appId;
        emojiInfo.field_catalog = EmojiInfo.xAe;
        emojiInfo.field_size = com_tencent_mm_y_g_a.hbb;
        emojiInfo.field_temp = 1;
        emojiInfo.field_state = EmojiInfo.xAu;
        i.aBE().lwL.o(emojiInfo);
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        ar.CG().a(new com.tencent.mm.plugin.emoji.f.e(linkedList), 0);
        com.tencent.mm.plugin.emoji.model.c.bf(str, 0);
        x.d("MicroMsg.emoji.EmojiAppMsgDownloadService", "start change cdn url. md5:%s", new Object[]{str});
    }

    public final al cj(String str, String str2) {
        Map y = bi.y(str, "msg");
        if (y == null) {
            x.w("MicroMsg.emoji.EmojiMgrImpl", "get from xml, but attrs is null");
            return null;
        }
        al a = al.a(y, str2, str, "");
        if (a != null) {
            return a;
        }
        x.w("MicroMsg.emoji.EmojiMgrImpl", "parserEmojiXml error " + str);
        return null;
    }

    public final void d(EmojiInfo emojiInfo) {
        i.aBE().lwL.p(emojiInfo);
    }

    public final String yd(String str) {
        return EmojiLogic.yd(str);
    }

    public final String a(Context context, WXMediaMessage wXMediaMessage, String str) {
        return EmojiLogic.b(context, wXMediaMessage, str);
    }

    public final boolean a(String str, String str2, long j, String str3, a aVar) {
        boolean z = false;
        com.tencent.mm.plugin.emoji.model.d aBy = i.aBy();
        x.d("MicroMsg.emoji.EmojiMsgInfo", "parserEmojiXml " + str2);
        al a = al.a(bi.y(str2, "msg"), str, str2, str3);
        if (a == null) {
            x.i("MicroMsg.emoji.EmojiService", "prepareEmoji failed. emoji msg info is null.");
        } else {
            a.fFo = j;
            x.i("MicroMsg.emoji.EmojiService", "summerbadcr prepareEmoji msgSvrId[%d], stack[%s]", new Object[]{Long.valueOf(j), bh.cgy()});
            aBy.yx(a.fqV);
            if (!EmojiLogic.yw(n.aBo())) {
                z = true;
            }
            aBy.a(a, aVar, z);
        }
        return true;
    }

    public final List<EmojiInfo> ye(String str) {
        ar.Hg();
        if (c.isSDCardAvailable()) {
            return (ArrayList) i.aBE().lwL.ye(str);
        }
        return new ArrayList();
    }

    public final String FC() {
        return com.tencent.mm.kernel.g.Dj().gQi;
    }

    public final String xZ(String str) {
        return i.aBz().xZ(str);
    }

    public final boolean yf(String str) {
        return i.aBE().lwM.XP(str);
    }

    public final ArrayList<String> yg(String str) {
        a aBz = i.aBz();
        if (!aBz.mInit) {
            aBz.aAN();
        }
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        ArrayList<String> arrayList2 = new ArrayList();
        int ZY = h.ZY(str);
        if (ZY < aBz.luZ || ZY > aBz.lva) {
            x.d("MicroMsg.emoji.EmojiDescNewMgr", "input text over checkout limit.");
            return null;
        }
        if (!(bh.ov(str) || aBz.lve == null)) {
            String toLowerCase = str.toLowerCase();
            ArrayList arrayList3 = new ArrayList();
            if (aBz.lvd.containsKey(toLowerCase)) {
                arrayList3.addAll((Collection) aBz.lvc.get(aBz.lvd.get(toLowerCase)));
            } else {
                arrayList3.add(toLowerCase);
            }
            Iterator it = arrayList3.iterator();
            while (it.hasNext()) {
                ArrayList arrayList4 = (ArrayList) aBz.lve.get((String) it.next());
                if (!(arrayList4 == null || arrayList4.isEmpty())) {
                    arrayList.addAll(arrayList4);
                }
            }
        }
        if (!arrayList.isEmpty()) {
            Collections.sort(arrayList, aBz.lvf);
            for (int i = 0; i < arrayList.size(); i++) {
                arrayList2.add(((a.a) arrayList.get(i)).fqR);
            }
        }
        x.d("MicroMsg.emoji.EmojiDescNewMgr", "cpan[check desc]User time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        return arrayList2;
    }

    public final String yh(String str) {
        return EmojiLogic.yh(str);
    }

    public final String yi(String str) {
        return EmojiLogic.yi(str);
    }

    public final int yj(String str) {
        return EmojiLogic.yj(str);
    }

    public final String yk(String str) {
        return EmojiLogic.yk(str);
    }

    public final int e(EmojiInfo emojiInfo) {
        if (emojiInfo != null) {
            if (emojiInfo.field_catalog == EmojiInfo.xAi || String.valueOf(EmojiInfo.xAi).equals(emojiInfo.field_groupId)) {
                return R.g.bDi;
            }
            if (emojiInfo.field_catalog == EmojiInfo.xAj || String.valueOf(EmojiInfo.xAj).equals(emojiInfo.field_groupId)) {
                return R.g.bBH;
            }
        }
        return 0;
    }

    public final int[] f(EmojiInfo emojiInfo) {
        if (emojiInfo != null) {
            if (emojiInfo.field_catalog == EmojiInfo.xAi) {
                return new int[]{R.g.bDk, R.g.bDl, R.g.bDj};
            } else if (emojiInfo.field_catalog == EmojiInfo.xAj) {
                return new int[]{R.g.bBI, R.g.bBJ, R.g.bBK, R.g.bBL};
            }
        }
        return null;
    }

    public final byte[] a(EmojiInfo emojiInfo) {
        return e.aAR().a(emojiInfo);
    }

    public final void onDestroy() {
    }

    public final boolean aAU() {
        return n.aBm();
    }

    public final ArrayList<q> aAV() {
        return i.aBE().lwT.aAV();
    }

    public final ArrayList<String> aAW() {
        return i.aBE().lwT.aAW();
    }

    public final ArrayList<com.tencent.mm.storage.emotion.s> aAX() {
        return i.aBE().lwU.aAX();
    }

    public final boolean p(ArrayList<q> arrayList) {
        r rVar = i.aBE().lwT;
        if (arrayList.size() <= 0) {
            x.i("MicroMsg.emoji.NewSmileyInfoStorage", "insertSmileyInfoList failed. list is null.");
        } else {
            long dz;
            com.tencent.mm.by.h hVar;
            if (rVar.gJP instanceof com.tencent.mm.by.h) {
                com.tencent.mm.by.h hVar2 = (com.tencent.mm.by.h) rVar.gJP;
                dz = hVar2.dz(Thread.currentThread().getId());
                hVar = hVar2;
            } else {
                dz = -1;
                hVar = null;
            }
            rVar.gJP.delete("SmileyInfo", null, null);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                rVar.b((q) it.next());
            }
            int i = -1;
            if (hVar != null) {
                i = hVar.fS(dz);
            }
            if (i >= 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean q(ArrayList<com.tencent.mm.storage.emotion.s> arrayList) {
        t tVar = i.aBE().lwU;
        if (arrayList.size() <= 0) {
            x.i("MicroMsg.emoji.SmileyPanelConfigInfoStorage", "insertSmileyConfigInfoList failed. list is null.");
        } else {
            long dz;
            com.tencent.mm.by.h hVar;
            if (tVar.gJP instanceof com.tencent.mm.by.h) {
                com.tencent.mm.by.h hVar2 = (com.tencent.mm.by.h) tVar.gJP;
                dz = hVar2.dz(Thread.currentThread().getId());
                hVar = hVar2;
            } else {
                dz = -1;
                hVar = null;
            }
            tVar.gJP.delete("SmileyPanelConfigInfo", null, null);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                tVar.b((com.tencent.mm.storage.emotion.s) it.next());
            }
            int i = -1;
            if (hVar != null) {
                i = hVar.fS(dz);
            }
            if (i >= 0) {
                return true;
            }
        }
        return false;
    }

    public final String ck(String str, String str2) {
        ar.Hg();
        return EmojiLogic.H(c.Fp(), str, str2);
    }

    public final f aAY() {
        return i.aBg().aAY();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void yl(String str) {
        if (bh.ov(str)) {
            x.i("MicroMsg.emoji.EmojiCommandMgr", "emoji command is null.");
        }
        if ("sync".equalsIgnoreCase(str)) {
            ar.Hg();
            c.CU().a(w.a.xnj, Boolean.valueOf(true));
            ar.Hg();
            c.CU().a(w.a.xno, Boolean.valueOf(true));
            ar.Hg();
            c.CU().a(w.a.xnr, Long.valueOf(0));
            ar.Hg();
            c.CU().a(w.a.xni, Long.valueOf(0));
            ar.CG().a(new com.tencent.mm.plugin.emoji.f.e(), 0);
            ar.CG().a(new n(8, null, 15, true), 0);
        } else if ("rcheart".equalsIgnoreCase(str)) {
            i.aBE().lwM.ckr();
        } else if ("recover".equalsIgnoreCase(str)) {
            x.i("MicroMsg.emoji.EmojiCommandMgr", "recover   begin");
            i.aBE().lwL.fl(ac.getContext());
            i.aBE().lwM.fl(ac.getContext());
            x.i("MicroMsg.emoji.EmojiCommandMgr", "recover   end");
        } else if ("clean".equalsIgnoreCase(str)) {
            x.i("MicroMsg.emoji.EmojiCommandMgr", "begin clean");
            d aAQ = d.aAQ();
            ar.Hg();
            aAQ.yb(c.Fp());
            ar.Hg();
            c.CU().a(w.a.xno, Boolean.valueOf(true));
            x.i("MicroMsg.emoji.EmojiCommandMgr", "end clean");
        } else if ("dump".equalsIgnoreCase(str)) {
            x.i("MicroMsg.emoji.EmojiCommandMgr", "begin dump emoji db info:");
            ArrayList arrayList = (ArrayList) i.aBE().lwM.ckc();
            if (arrayList.size() > 0) {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    EmojiGroupInfo emojiGroupInfo = (EmojiGroupInfo) arrayList.get(i);
                    x.i("MicroMsg.emoji.EmojiCommandMgr", "i:%d group info:%s", new Object[]{Integer.valueOf(i), emojiGroupInfo.toString()});
                }
            }
            Cursor cursor = null;
            try {
                cursor = i.aBE().lwL.Tj();
                if (cursor != null) {
                    if (cursor.moveToFirst()) {
                        do {
                            new EmojiInfo().b(cursor);
                            x.i("MicroMsg.emoji.EmojiCommandMgr", "emoji info:%s", new Object[]{r1.toString()});
                        } while (cursor.moveToNext());
                    }
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Exception e) {
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Cursor cursor2 = cursor;
                Throwable th3 = th2;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th3;
            }
            x.i("MicroMsg.emoji.EmojiCommandMgr", "end dump emoji db info:");
        } else if ("config".equalsIgnoreCase(str)) {
            b.c.bZm().e(37, 1, -1, false);
            b.c.bZm().e(37, 2, -1, false);
            ar.Hg();
            c.CU().a(w.a.xny, Integer.valueOf(0));
            ar.Hg();
            c.CU().a(w.a.xnz, Integer.valueOf(0));
            ar.Hg();
            c.CU().a(w.a.xnB, Integer.valueOf(0));
            ar.CG().a(new m(37), 0);
            bc bcVar = new bc();
            bcVar.fpl.filePath = com.tencent.mm.compatible.util.e.bnF + "CheckResUpdate/37.1.data.decompressed";
            bcVar.fpl.fpm = 37;
            bcVar.fpl.fpn = 1;
            bc bcVar2 = new bc();
            bcVar2.fpl.filePath = com.tencent.mm.compatible.util.e.bnF + "CheckResUpdate/37.2.data.decompressed";
            bcVar2.fpl.fpm = 37;
            bcVar2.fpl.fpn = 2;
            i.aBg().a(bcVar, true);
            i.aBg().b(bcVar2, true);
        } else if ("tuzki".equalsIgnoreCase(str)) {
            com.tencent.mm.plugin.emoji.f.a.aBJ();
            com.tencent.mm.plugin.emoji.f.a.aBK();
        }
    }

    public final bis aAZ() {
        return i.aBE().lwO.aAZ();
    }

    public final void a(bis com_tencent_mm_protocal_c_bis) {
        i.aBE().lwO.b(com_tencent_mm_protocal_c_bis);
    }

    public final int aBa() {
        return i.aBE().lwL.lI(true);
    }

    public final int ym(String str) {
        return i.aBE().lwL.ym(str);
    }

    public final boolean a(EmojiGroupInfo emojiGroupInfo) {
        return i.aBE().lwM.c(emojiGroupInfo, new String[]{"productID"});
    }

    public final ArrayList<EmojiGroupInfo> aBb() {
        return i.aBE().aBb();
    }

    public final int aBc() {
        return i.aBE().aBc();
    }

    public final ArrayList<EmojiInfo> aBd() {
        return i.aBE().aBd();
    }

    public final ArrayList<EmojiInfo> yn(String str) {
        l aBE = i.aBE();
        if (l.lxb == null) {
            l.lxb = new HashMap();
        }
        if (l.lwY) {
            l.lxb.clear();
            l.lwY = false;
        }
        if (!l.lxb.containsKey(str)) {
            ar.Hg();
            if (c.isSDCardAvailable()) {
                l.lxb.put(str, (ArrayList) aBE.lwL.ye(str));
            }
        }
        return (ArrayList) l.lxb.get(str);
    }

    public final com.tencent.mm.aq.a.a aBe() {
        return i.aBe();
    }

    public final void f(j.a aVar) {
        i.aBE().lwL.j(aVar);
    }

    public final void g(j.a aVar) {
        i.aBE().lwL.c(aVar);
    }

    public final void h(j.a aVar) {
        i.aBE().lwM.j(aVar);
    }

    public final void i(j.a aVar) {
        if (((com.tencent.mm.kernel.b.h) com.tencent.mm.kernel.g.Dg().CN()).DS()) {
            i.aBE().lwM.c(aVar);
        }
    }

    public final boolean aBf() {
        return n.aBr();
    }
}
