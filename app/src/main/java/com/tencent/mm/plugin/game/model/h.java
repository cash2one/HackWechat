package com.tencent.mm.plugin.game.model;

import android.content.Context;
import com.tencent.mm.a.g;
import com.tencent.mm.aq.a.a.c$a;
import com.tencent.mm.aq.o;
import com.tencent.mm.g.a.gn;
import com.tencent.mm.loader.stub.a;
import com.tencent.mm.plugin.game.ui.GameRegionPreference;
import com.tencent.mm.protocal.c.ajq;
import com.tencent.mm.protocal.c.aqy;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class h {
    private static final String nby = (a.bnF + "Game/HvMenu/");

    static /* synthetic */ void a(ajq com_tencent_mm_protocal_c_ajq, String str) {
        if (com_tencent_mm_protocal_c_ajq == null) {
            return;
        }
        if (bh.cA(com_tencent_mm_protocal_c_ajq.wqI)) {
            x.i("MicroMsg.GameCommOpertionProcessor", "menu list is null. appid:%s", new Object[]{str});
            return;
        }
        List arrayList = new ArrayList();
        arrayList.addAll(com_tencent_mm_protocal_c_ajq.wqI);
        a(arrayList, new 2(str, com_tencent_mm_protocal_c_ajq));
    }

    public static void a(gn gnVar) {
        x.i("MicroMsg.GameCommOpertionProcessor", "cmd:%d", new Object[]{Integer.valueOf(gnVar.fwD.pK)});
        Context context;
        JSONObject jSONObject;
        String str;
        switch (gnVar.fwD.pK) {
            case 1:
                context = gnVar.fwD.context;
                if (context != null) {
                    jSONObject = new JSONObject();
                    GameRegionPreference.a cK = g.cK(context);
                    if (cK != null) {
                        try {
                            jSONObject.put("gameRegionName", g.a(cK));
                        } catch (JSONException e) {
                        }
                    }
                    gnVar.fwE.result = jSONObject.toString();
                    return;
                }
                return;
            case 2:
                str = gnVar.fwD.fwF;
                x.i("MicroMsg.GameCommOpertionProcessor", "update hv menu! appid:%s", new Object[]{str});
                if (!bh.ov(str)) {
                    ar.CG().a(1369, new 1(str));
                    ar.CG().a(new bf(str), 0);
                    return;
                }
                return;
            case 3:
                str = gnVar.fwD.fwF;
                x.i("MicroMsg.GameCommOpertionProcessor", "get hv menu! appid:%s", new Object[]{str});
                if (!bh.ov(str)) {
                    byte[] BX = SubCoreGameCenter.aRh().BX("pb_game_hv_menu_" + str);
                    if (!bh.bw(BX)) {
                        try {
                            gnVar.fwE.result = new String(BX, "ISO-8859-1");
                            x.i("MicroMsg.GameCommOpertionProcessor", "get hv menu success! appid:%s", new Object[]{str});
                            return;
                        } catch (UnsupportedEncodingException e2) {
                            return;
                        }
                    }
                    return;
                }
                return;
            case 4:
                b(gnVar);
                return;
            case 10001:
                context = gnVar.fwD.context;
                if (context != null) {
                    jSONObject = new JSONObject();
                    Object cO = g.cO(context);
                    if (bh.ov(cO)) {
                        cO = g.aPY();
                    }
                    try {
                        jSONObject.put("regionCode", cO);
                    } catch (JSONException e3) {
                    }
                    gnVar.fwE.result = jSONObject.toString();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private static void a(List<aqy> list, a aVar) {
        if (!bh.cA(list)) {
            aqy com_tencent_mm_protocal_c_aqy = (aqy) list.remove(0);
            if (com_tencent_mm_protocal_c_aqy == null || bh.ov(com_tencent_mm_protocal_c_aqy.pbP)) {
                x.e("MicroMsg.GameCommOpertionProcessor", "menu is null or thumburl is null");
                return;
            }
            String str = nby + g.s(com_tencent_mm_protocal_c_aqy.pbP.getBytes());
            c$a com_tencent_mm_aq_a_a_c_a = new c$a();
            com_tencent_mm_aq_a_a_c_a.hDA = true;
            com_tencent_mm_aq_a_a_c_a.hDC = str;
            o.PA().a(com_tencent_mm_protocal_c_aqy.pbP, com_tencent_mm_aq_a_a_c_a.PK(), new 3(com_tencent_mm_protocal_c_aqy, list, aVar));
        } else if (aVar != null) {
            aVar.onComplete();
        }
    }

    private static void b(gn gnVar) {
        String str = gnVar.fwD.fwF;
        if (!bh.ov(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int parseInt = Integer.parseInt(jSONObject.getString("game_page_report_id"));
                boolean z = jSONObject.getBoolean("game_page_report_instantly");
                str = jSONObject.optString("game_page_report_format_data");
                String optString = jSONObject.optString("game_page_report_tabs_format_data");
                x.i("MicroMsg.GameCommOpertionProcessor", "reportGamePageTime, reportId:%d, reportInstantly:%b, reportFormatData:(%s), reportTabsFormatData(%s)", new Object[]{Integer.valueOf(parseInt), Boolean.valueOf(z), str, optString});
                if (bh.ov(str)) {
                    if (!bh.ov(optString)) {
                        try {
                            JSONArray jSONArray = new JSONArray(optString);
                            for (int i = 0; i < jSONArray.length(); i++) {
                                optString = jSONArray.getString(i);
                                if (!bh.ov(optString)) {
                                    if (z) {
                                        ap.am(parseInt, optString);
                                    } else {
                                        com.tencent.mm.plugin.report.service.g.pQN.k(parseInt, optString);
                                    }
                                }
                            }
                        } catch (JSONException e) {
                            x.i("MicroMsg.GameCommOpertionProcessor", "reportGamePageTime, err2:%s", new Object[]{e.getMessage()});
                        }
                    }
                } else if (z) {
                    ap.am(parseInt, str);
                } else {
                    com.tencent.mm.plugin.report.service.g.pQN.k(parseInt, str);
                }
            } catch (JSONException e2) {
                x.i("MicroMsg.GameCommOpertionProcessor", "reportGamePageTime, err1:%s", new Object[]{e2.getMessage()});
            }
        }
    }
}
