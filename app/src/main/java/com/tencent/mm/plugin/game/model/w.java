package com.tencent.mm.plugin.game.model;

import android.database.Cursor;
import com.tencent.mm.g.a.mb;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONObject;

public final class w {
    static void a(t tVar, t tVar2) {
        tVar2.aQm();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("oldNoticeId", tVar2.ncT);
            jSONObject.put("oldMsgId", tVar2.field_gameMsgId);
            if (tVar.field_weight.compareTo(tVar2.field_weight) >= 0) {
                jSONObject.put("coverType", 1);
            } else {
                jSONObject.put("coverType", 2);
            }
        } catch (Exception e) {
            x.e("MicroMsg.GameMessageService", "reportMsgCover: " + e.getMessage());
        }
        int i = tVar.field_msgType;
        if (tVar.field_msgType == 100) {
            i = tVar.ncS;
        }
        ap.a(ac.getContext(), 0, 0, 0, 31, 0, tVar.field_appId, 0, i, tVar.field_gameMsgId, tVar.ncT, ap.BY(jSONObject.toString()));
    }

    public final void a(mb mbVar) {
        t aQn = aQn();
        if (aQn != null) {
            aQn.aQm();
            ap.BZ(aQn.ncT);
            mbVar.fDH.showType = aQn.ncl.nda;
            mbVar.fDH.appId = aQn.field_appId;
            mbVar.fDH.appName = aQn.ncl.jUJ;
            mbVar.fDH.fDI = aQn.ncl.ncY;
            mbVar.fDH.msgType = aQn.field_msgType;
            if (aQn.field_msgType == 100) {
                mbVar.fDH.msgType = aQn.ncS;
            }
            mbVar.fDH.fDJ = aQn.field_gameMsgId;
            mbVar.fDH.fop = aQn.ncT;
        }
    }

    public static t aQn() {
        t dv;
        ar.Hg();
        long longValue = ((Long) c.CU().get(a.xpL, Long.valueOf(0))).longValue();
        if (longValue != 0) {
            dv = SubCoreGameCenter.aRd().dv(longValue);
        } else {
            dv = null;
        }
        if (dv != null && !dv.field_isHidden && !f(dv)) {
            return dv;
        }
        ap.BZ("");
        return null;
    }

    public static void aQo() {
        ar.Hg();
        long longValue = ((Long) c.CU().get(a.xpL, Long.valueOf(0))).longValue();
        t tVar = null;
        if (longValue != 0) {
            tVar = SubCoreGameCenter.aRd().dv(longValue);
        }
        if (tVar != null && !tVar.field_isHidden) {
            ar.Hg();
            c.CU().a(a.xpL, Long.valueOf(0));
        }
    }

    public static t aQp() {
        ar.Hg();
        long longValue = ((Long) c.CU().get(a.xpP, Long.valueOf(0))).longValue();
        if (longValue == 0) {
            return null;
        }
        t dv = SubCoreGameCenter.aRd().dv(longValue);
        if (dv == null || dv.field_isHidden || f(dv)) {
            return null;
        }
        return dv;
    }

    public static void aQq() {
        ar.Hg();
        long longValue = ((Long) c.CU().get(a.xpP, Long.valueOf(0))).longValue();
        t tVar = null;
        if (longValue != 0) {
            tVar = SubCoreGameCenter.aRd().dv(longValue);
        }
        if (tVar != null && !tVar.field_isHidden) {
            ar.Hg();
            c.CU().a(a.xpP, Long.valueOf(0));
        }
    }

    public static t aQr() {
        ar.Hg();
        long longValue = ((Long) c.CU().get(a.xpM, Long.valueOf(0))).longValue();
        if (longValue == 0) {
            return null;
        }
        t dv = SubCoreGameCenter.aRd().dv(longValue);
        if (dv == null || dv.field_isHidden || f(dv)) {
            return null;
        }
        return dv;
    }

    public static void aQs() {
        ar.Hg();
        long longValue = ((Long) c.CU().get(a.xpM, Long.valueOf(0))).longValue();
        t tVar = null;
        if (longValue != 0) {
            tVar = SubCoreGameCenter.aRd().dv(longValue);
        }
        if (tVar != null && !tVar.field_isHidden) {
            ar.Hg();
            c.CU().a(a.xpM, Long.valueOf(0));
        }
    }

    public static t aQt() {
        ar.Hg();
        return SubCoreGameCenter.aRd().dv(((Long) c.CU().get(a.xpO, Long.valueOf(0))).longValue());
    }

    private static boolean f(t tVar) {
        return tVar.field_expireTime < System.currentTimeMillis() / 1000;
    }

    static void g(t tVar) {
        if (!bh.ov(tVar.field_mergerId)) {
            com.tencent.mm.sdk.e.c cVar;
            x aRd = SubCoreGameCenter.aRd();
            String str = "select * from GameRawMessage where msgType=" + tVar.field_msgType + " and mergerId= \"" + tVar.field_mergerId + "\" order by createTime desc limit 1";
            com.tencent.mm.sdk.e.c tVar2 = new t();
            Cursor rawQuery = aRd.rawQuery(str, new String[0]);
            if (rawQuery == null) {
                cVar = null;
            } else {
                if (rawQuery.moveToFirst()) {
                    tVar2.b(rawQuery);
                }
                rawQuery.close();
                cVar = tVar2;
            }
            if (cVar != null) {
                cVar.aQm();
                if (!bh.cA(cVar.ncj)) {
                    tVar.aQm();
                    Object linkedList = new LinkedList(cVar.ncj);
                    if (!bh.cA(tVar.ncj)) {
                        String str2 = ((t$h) tVar.ncj.get(0)).userName;
                        if (!bh.ov(str2)) {
                            Iterator it = cVar.ncj.iterator();
                            while (it.hasNext()) {
                                t$h com_tencent_mm_plugin_game_model_t_h = (t$h) it.next();
                                if (com_tencent_mm_plugin_game_model_t_h.userName.equals(str2)) {
                                    linkedList.remove(com_tencent_mm_plugin_game_model_t_h);
                                    break;
                                }
                            }
                        }
                    }
                    if (!bh.cA(linkedList)) {
                        tVar.field_rawXML = aq.a(tVar.field_rawXML, linkedList, cVar.nco);
                    }
                    SubCoreGameCenter.aRd().a(cVar, new String[0]);
                }
            }
        }
    }
}
