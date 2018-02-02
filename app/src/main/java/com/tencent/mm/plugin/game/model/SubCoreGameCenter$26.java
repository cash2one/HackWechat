package com.tencent.mm.plugin.game.model;

import com.tencent.mm.g.a.gq;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.z.ar;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class SubCoreGameCenter$26 extends c<gq> {
    final /* synthetic */ SubCoreGameCenter nfd;

    SubCoreGameCenter$26(SubCoreGameCenter subCoreGameCenter) {
        this.nfd = subCoreGameCenter;
        this.xen = gq.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        return b((gq) bVar);
    }

    private static boolean b(gq gqVar) {
        t tVar;
        switch (gqVar.fwK.pK) {
            case 1:
                String str = gqVar.fwK.fwF;
                LinkedList linkedList = new LinkedList();
                if (str != null) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        int i = bh.getInt(jSONObject.optString(DownloadSettingTable$Columns.TYPE), 0);
                        int i2 = bh.getInt(jSONObject.optString("limit"), 0);
                        long j = bh.getLong(jSONObject.optString("lastLocalId"), -1);
                        int i3 = bh.getInt(jSONObject.optString("isUnread"), -1);
                        if (i2 > 0 && i2 <= 10000 && j >= 0 && i3 >= 0) {
                            Object b = SubCoreGameCenter.aRd().b(i, j, i3, i2);
                            if (!bh.cA(b)) {
                                JSONArray jSONArray = new JSONArray();
                                Iterator it = b.iterator();
                                while (it.hasNext()) {
                                    tVar = (t) it.next();
                                    JSONObject jSONObject2 = new JSONObject();
                                    jSONObject2.put("localId", tVar.field_msgId);
                                    jSONObject2.put("content", tVar.field_rawXML);
                                    jSONArray.put(jSONObject2);
                                }
                                gqVar.fwL.fwM = jSONArray.toString();
                                break;
                            }
                        }
                    } catch (JSONException e) {
                        x.w("MicroMsg.GameJsapiProcessor", "JSONException : %s", new Object[]{e.getMessage()});
                        break;
                    }
                }
                break;
            case 2:
                y.a(gqVar);
                break;
            case 3:
                SubCoreGameCenter.aRe();
                tVar = w.aQr();
                if (tVar != null) {
                    gqVar.fwL.fwM = tVar.field_rawXML;
                    break;
                }
                break;
            case 4:
                SubCoreGameCenter.aRe();
                w.aQs();
                break;
            case 5:
                SubCoreGameCenter.aRe();
                ar.Hg();
                tVar = SubCoreGameCenter.aRd().dv(((Long) com.tencent.mm.z.c.CU().get(a.xpN, Long.valueOf(0))).longValue());
                if (tVar == null || tVar.field_isHidden) {
                    tVar = null;
                }
                if (tVar != null) {
                    gqVar.fwL.fwM = tVar.field_rawXML;
                    break;
                }
                break;
            case 6:
                SubCoreGameCenter.aRe();
                ar.Hg();
                tVar = SubCoreGameCenter.aRd().dv(((Long) com.tencent.mm.z.c.CU().get(a.xpN, Long.valueOf(0))).longValue());
                if (!(tVar == null || tVar.field_isHidden)) {
                    ar.Hg();
                    com.tencent.mm.z.c.CU().a(a.xpN, Long.valueOf(0));
                    break;
                }
            case 9:
                SubCoreGameCenter.aRe();
                tVar = w.aQt();
                if (tVar != null) {
                    gqVar.fwL.fwM = tVar.field_rawXML;
                    break;
                }
                break;
            case 10:
                SubCoreGameCenter.aRe();
                ar.Hg();
                if (SubCoreGameCenter.aRd().dv(((Long) com.tencent.mm.z.c.CU().get(a.xpO, Long.valueOf(0))).longValue()) != null) {
                    ar.Hg();
                    com.tencent.mm.z.c.CU().a(a.xpO, Long.valueOf(0));
                    break;
                }
                break;
        }
        return false;
    }
}
