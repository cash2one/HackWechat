package com.tencent.mm.pluginsdk.model.app;

import android.database.Cursor;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aj;
import com.tencent.mm.y.g;
import com.tencent.mm.z.ar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class am$a implements e {
    private static int flV = 0;
    Queue<Long> flN = new LinkedList();
    Queue<Long> flO = new LinkedList();
    Map<Long, a> flP = new HashMap();
    private boolean flQ = false;
    private boolean flR = false;
    private boolean flS = false;
    int flT = 0;
    private long flU = 0;
    a flX = new a();
    private ak flY = new ak(ar.Dm().oAt.getLooper(), new 4(this), false);
    private HashMap<Long, String> vfi = new HashMap();

    static /* synthetic */ void i(am$a com_tencent_mm_pluginsdk_model_app_am_a) {
        x.d("MicroMsg.SceneAppMsg", "summerbig tryStartNetscene recving[%b][%d], sending[%b][%d]", new Object[]{Boolean.valueOf(com_tencent_mm_pluginsdk_model_app_am_a.flQ), Integer.valueOf(com_tencent_mm_pluginsdk_model_app_am_a.flO.size()), Boolean.valueOf(com_tencent_mm_pluginsdk_model_app_am_a.flR), Integer.valueOf(com_tencent_mm_pluginsdk_model_app_am_a.flN.size())});
        com_tencent_mm_pluginsdk_model_app_am_a.flU = System.currentTimeMillis();
        if ((!com_tencent_mm_pluginsdk_model_app_am_a.flQ && com_tencent_mm_pluginsdk_model_app_am_a.flO.size() == 0) || (!com_tencent_mm_pluginsdk_model_app_am_a.flR && com_tencent_mm_pluginsdk_model_app_am_a.flN.size() == 0)) {
            com_tencent_mm_pluginsdk_model_app_am_a.bYP();
        }
        if (!com_tencent_mm_pluginsdk_model_app_am_a.flQ && com_tencent_mm_pluginsdk_model_app_am_a.flO.size() == 0 && !com_tencent_mm_pluginsdk_model_app_am_a.flR && com_tencent_mm_pluginsdk_model_app_am_a.flN.size() == 0) {
            com_tencent_mm_pluginsdk_model_app_am_a.vB();
            x.d("MicroMsg.SceneAppMsg", "summerbig No Data Any More , Stop Service");
        } else if (!com_tencent_mm_pluginsdk_model_app_am_a.flR && com_tencent_mm_pluginsdk_model_app_am_a.flN.size() > 0) {
            long a = bh.a((Long) com_tencent_mm_pluginsdk_model_app_am_a.flN.poll(), -1);
            x.i("MicroMsg.SceneAppMsg", "summerbig Start Send :" + a);
            if (a != -1) {
                com_tencent_mm_pluginsdk_model_app_am_a.flP.put(Long.valueOf(a), new a());
                com_tencent_mm_pluginsdk_model_app_am_a.flR = true;
                c bVar = new b();
                cf dH;
                if (an.aqd().b(a, bVar)) {
                    String str;
                    if (bVar.field_type == 8) {
                        ar.Hg();
                        dH = com.tencent.mm.z.c.Fa().dH(bVar.field_msgInfoId);
                        if (dH.field_msgId == 0) {
                            x.e("MicroMsg.SceneAppMsg", "getEmoticonMd5 fail, msg is null :" + bVar.field_msgInfoId);
                            str = null;
                        } else {
                            g.a fT = g.a.fT(dH.field_content);
                            str = fT != null ? fT.hbd : aj.Xp(dH.field_content).fqR;
                        }
                        if (str == null) {
                            x.e("MicroMsg.SceneAppMsg", "summerbig tryStartNetscene fail, send emoji, emoticonMd5 can not be null");
                            ar.Hg();
                            dH = com.tencent.mm.z.c.Fa().dH(bVar.field_msgInfoId);
                            dH.eQ(5);
                            ar.Hg();
                            com.tencent.mm.z.c.Fa().a(dH.field_msgId, dH);
                            com_tencent_mm_pluginsdk_model_app_am_a.flR = false;
                            return;
                        }
                    }
                    str = null;
                    String str2 = (String) com_tencent_mm_pluginsdk_model_app_am_a.vfi.get(Long.valueOf(bVar.field_msgInfoId));
                    if (bVar.field_totalLen > 26214400) {
                        ar.Hg();
                        cf dH2 = com.tencent.mm.z.c.Fa().dH(bVar.field_msgInfoId);
                        ar.CG().a(new z(null, bVar.field_fileFullPath, dH2.field_talker, new 1(com_tencent_mm_pluginsdk_model_app_am_a, bVar, dH2, a, str2)), 0);
                        return;
                    }
                    ar.CG().a(new ak(a, str, str2), 0);
                    return;
                }
                x.e("MicroMsg.SceneAppMsg", "summerbig tryStartNetscene fail, getAttachInfo fail, infoId = " + a);
                ar.Hg();
                dH = com.tencent.mm.z.c.Fa().dH(bVar.field_msgInfoId);
                dH.eQ(5);
                ar.Hg();
                com.tencent.mm.z.c.Fa().a(dH.field_msgId, dH);
                com_tencent_mm_pluginsdk_model_app_am_a.flR = false;
            }
        }
    }

    static /* synthetic */ int vC() {
        int i = flV;
        flV = i + 1;
        return i;
    }

    static /* synthetic */ int vD() {
        int i = flV;
        flV = i - 1;
        return i;
    }

    public am$a() {
        ar.CG().a(220, this);
        ar.CG().a(221, this);
        ar.CG().a(222, this);
    }

    protected final void finalize() {
        ar.CG().b(220, this);
        ar.CG().b(221, this);
        ar.CG().b(222, this);
        this.vfi.clear();
        super.finalize();
    }

    public final void t(long j, String str) {
        this.vfi.put(Long.valueOf(j), str);
    }

    public static void ft(long j) {
        ar.CG().a(new ah(j, null, null), 0);
    }

    public static void u(long j, String str) {
        ar.CG().a(new ah(j, str, null), 0);
    }

    public static void d(long j, String str, String str2) {
        ar.CG().a(new ah(j, str, str2), 0);
    }

    private boolean bYP() {
        List list;
        try {
            Cursor rawQuery = an.aqd().rawQuery("select *  , rowid  from appattach where status = 101", new String[0]);
            if (rawQuery == null) {
                list = null;
            } else {
                int count = rawQuery.getCount();
                x.d("MicroMsg.AppAttachInfoStorage", "getUnfinishInfo resCount:" + count);
                if (count == 0) {
                    rawQuery.close();
                    list = null;
                } else {
                    list = new ArrayList();
                    for (int i = 0; i < count; i++) {
                        rawQuery.moveToPosition(i);
                        b bVar = new b();
                        bVar.b(rawQuery);
                        list.add(bVar);
                    }
                    rawQuery.close();
                }
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SceneAppMsg", e, "", new Object[0]);
            c aqd = an.aqd();
            aqd.gJP.fx("appattach", " update appattach set status = 198 , lastModifyTime = " + bh.Wo() + " where status = 101");
            aqd.doNotify();
            list = null;
        }
        if (r0 == null || r0.size() == 0) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        String fJ = bh.fJ(currentTimeMillis);
        for (b bVar2 : r0) {
            if (this.flP.containsKey(Long.valueOf(bVar2.xjy))) {
                x.d("MicroMsg.SceneAppMsg", "summerbig File is Already running:" + bVar2.xjy);
            } else {
                x.d("MicroMsg.SceneAppMsg", "summerbig Get file:" + bVar2.field_fileFullPath + " status:" + bVar2.field_status + " create:(" + bh.fJ(bVar2.field_createTime) + "," + bh.fJ(bVar2.field_createTime / 1000) + ", last:" + bh.fJ(bVar2.field_lastModifyTime) + " now:" + bh.fJ(currentTimeMillis) + " " + (currentTimeMillis - bVar2.field_lastModifyTime));
                if (bVar2.field_isUpload) {
                    if (currentTimeMillis - bVar2.field_lastModifyTime <= 600 || bVar2.field_status != 101) {
                        this.flN.offer(Long.valueOf(bVar2.xjy));
                        this.flP.put(Long.valueOf(bVar2.xjy), null);
                    } else {
                        x.e("MicroMsg.SceneAppMsg", "summerbig time out file: " + bVar2.field_fileFullPath + " last:" + bh.fJ(bVar2.field_lastModifyTime) + " now:" + fJ);
                        l.fr(bVar2.xjy);
                    }
                }
            }
        }
        x.d("MicroMsg.SceneAppMsg", "summerbig GetNeedRun procing:" + this.flP.size() + " [recv:" + this.flO.size() + ",send:" + this.flN.size() + "]");
        if (this.flO.size() + this.flN.size() == 0) {
            return false;
        }
        return true;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.d("MicroMsg.SceneAppMsg", "summersafecdn onSceneEnd type:%d errType:%d errCode:%d", new Object[]{Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2)});
        ar.Dm().F(new 2(this, kVar, i, i2));
    }

    private void vB() {
        this.flP.clear();
        this.flN.clear();
        this.flO.clear();
        this.flR = false;
        this.flQ = false;
        this.flS = false;
        x.d("MicroMsg.SceneAppMsg", "Finish service use time(ms):" + this.flX.zi());
    }

    public final void run() {
        ar.Dm().F(new 3(this));
    }
}
