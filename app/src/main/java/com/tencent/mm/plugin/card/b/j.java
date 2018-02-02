package com.tencent.mm.plugin.card.b;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.c;
import com.tencent.mm.protocal.c.aap;
import com.tencent.mm.protocal.c.lf;
import com.tencent.mm.protocal.c.lg;
import com.tencent.mm.protocal.c.lh;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class j {
    public static void a(LinkedList<lf> linkedList, int i) {
        if (linkedList != null) {
            int size = linkedList.size();
            for (int i2 = 0; i2 < linkedList.size(); i2++) {
                lf lfVar = (lf) linkedList.get(i2);
                c auA = am.auA();
                String str = lfVar.fGU;
                int i3 = ((size - i2) * 10) + i;
                String str2 = lfVar.kNu;
                int i4 = lfVar.cey;
                if (bh.ov(str)) {
                    x.w("MicroMsg.CardInfoStorage", "cardId null");
                } else {
                    auA.gJP.fx("UserCardInfo", "update UserCardInfo set stickyIndex=" + i3 + ", stickyAnnouncement='" + str2 + "', stickyEndTime=" + i4 + " where card_id='" + str + "'");
                }
            }
        }
    }

    public static void b(LinkedList<lf> linkedList, int i) {
        if (linkedList != null) {
            for (int i2 = 0; i2 < linkedList.size(); i2++) {
                lf lfVar = (lf) linkedList.get(i2);
                am.auA().gJP.fx("UserCardInfo", "update UserCardInfo set stickyIndex=" + i + ", label_wording='" + (lfVar.vUd != null ? lfVar.vUd : "") + "' where card_id='" + lfVar.fGU + "'");
            }
        }
    }

    public static aap wN(String str) {
        if (bh.ov(str)) {
            x.w("MicroMsg.CardStickyHelper", "jsonRet null");
            return null;
        }
        aap com_tencent_mm_protocal_c_aap = new aap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            com_tencent_mm_protocal_c_aap.wjx = jSONObject.optString("layout_buff");
            JSONObject jSONObject2 = jSONObject.getJSONObject("list");
            if (jSONObject2 != null) {
                com_tencent_mm_protocal_c_aap.wjA = new lh();
                com_tencent_mm_protocal_c_aap.wjA.vUf = E(jSONObject2.optJSONObject("expiring_list"));
                com_tencent_mm_protocal_c_aap.wjA.vUg = E(jSONObject2.optJSONObject("member_card_list"));
                com_tencent_mm_protocal_c_aap.wjA.vUh = E(jSONObject2.optJSONObject("nearby_list"));
                com_tencent_mm_protocal_c_aap.wjA.vUi = E(jSONObject2.optJSONObject("label_list"));
                com_tencent_mm_protocal_c_aap.wjA.vUj = E(jSONObject2.optJSONObject("first_list"));
                if (!(com_tencent_mm_protocal_c_aap.wjA.vUj == null || com_tencent_mm_protocal_c_aap.wjA.vUj.vUe == null)) {
                    for (int size = com_tencent_mm_protocal_c_aap.wjA.vUj.vUe.size() - 1; size >= 0; size--) {
                        lf lfVar = (lf) com_tencent_mm_protocal_c_aap.wjA.vUj.vUe.get(size);
                        if (!bh.ov(lfVar.fGU)) {
                            CardInfo wf = am.auA().wf(lfVar.fGU);
                            if (!(wf == null || wf.ati())) {
                                com_tencent_mm_protocal_c_aap.wjA.vUj.vUe.remove(size);
                            }
                        }
                    }
                }
                com_tencent_mm_protocal_c_aap.wjB = jSONObject2.optString("red_dot_wording");
                com_tencent_mm_protocal_c_aap.wjC = jSONObject2.optInt("show_red_dot", 0) == 1;
                Object optString = jSONObject2.optString("title");
                if (optString == null) {
                    optString = "";
                }
                am.auF().putValue("key_card_entrance_tips", optString);
                com_tencent_mm_protocal_c_aap.wjD = jSONObject2.optInt("top_scene", 100);
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CardStickyHelper", e, "", new Object[0]);
        }
        return com_tencent_mm_protocal_c_aap;
    }

    private static lg E(JSONObject jSONObject) {
        if (jSONObject == null) {
            x.w("MicroMsg.CardStickyHelper", "parseLayoutItemList param obj null");
            return null;
        }
        lg lgVar = new lg();
        lgVar.vUe = new LinkedList();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("item_list");
            for (int i = 0; i < jSONArray.length(); i++) {
                lf lfVar;
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                if (jSONObject2 == null) {
                    lfVar = null;
                } else {
                    lfVar = new lf();
                    lfVar.kNu = jSONObject2.optString("announcement");
                    lfVar.fGU = jSONObject2.optString("card_id");
                    lfVar.cey = jSONObject2.optInt("end_time", 0);
                    lfVar.vUc = jSONObject2.optInt("update_time", 0);
                    lfVar.vUd = jSONObject2.optString("label_wording");
                }
                if (lfVar == null || (((long) lfVar.cey) <= bh.Wo() && lfVar.cey != 0)) {
                    x.i("MicroMsg.CardStickyHelper", "item.end_time > Util.nowSecond()");
                } else {
                    lgVar.vUe.add(lfVar);
                }
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CardStickyHelper", e, "", new Object[0]);
        }
        return lgVar;
    }

    public static String a(Context context, int i, CardInfo cardInfo) {
        switch (i % 10) {
            case 0:
                return context.getString(R.l.dPI);
            case 1:
                return context.getString(R.l.dPH);
            case 2:
                return context.getString(R.l.dPG);
            case 3:
                return context.getString(R.l.dPF);
            case 4:
                return cardInfo.field_label_wording;
            default:
                return null;
        }
    }
}
