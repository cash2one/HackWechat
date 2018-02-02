package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a {
    public int cey;
    public String hbM;
    public String kFg;
    public String kJN;
    public int kJO;
    public String kJP;
    public String kJQ;
    public String kJR;
    public String kJS;
    public String kJT;
    public String kJU;
    public int kJV;
    public String kJW;
    public String kJX;
    public String kJY;
    public boolean kJZ;
    public String title;
    public String userName;

    public static LinkedList<a> wd(String str) {
        LinkedList<a> linkedList = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                linkedList = a(new JSONObject(str).optJSONArray("available_cards"), false);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.AvailableCardItem", e, "", new Object[0]);
            }
        }
        return linkedList;
    }

    public static LinkedList<a> we(String str) {
        LinkedList<a> linkedList = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                linkedList = a(new JSONObject(str).optJSONArray("available_share_cards"), true);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.AvailableCardItem", e, "", new Object[0]);
            }
        }
        return linkedList;
    }

    private static LinkedList<a> a(JSONArray jSONArray, boolean z) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        LinkedList<a> linkedList = new LinkedList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            a aVar = new a();
            aVar.kJN = jSONObject.optString("card_tp_id");
            aVar.kJO = jSONObject.optInt("card_type");
            aVar.hbM = jSONObject.optString("color");
            aVar.kJP = jSONObject.optString("logo_url");
            aVar.title = jSONObject.optString("title");
            aVar.kJQ = jSONObject.optString("sub_title");
            aVar.kJR = jSONObject.optString("aux_title");
            aVar.kJS = jSONObject.optString("encrypt_code");
            aVar.userName = jSONObject.optString("from_user_name");
            aVar.kJT = jSONObject.optString("app_id");
            aVar.cey = jSONObject.optInt("end_time");
            aVar.kJU = jSONObject.optString("card_user_id");
            aVar.kJV = jSONObject.optInt("choose_optional");
            aVar.kJX = jSONObject.optString("invoice_item");
            aVar.kJY = jSONObject.optString("invoice_status");
            aVar.kJW = jSONObject.optString("invoice_title");
            aVar.kJZ = z;
            linkedList.add(aVar);
        }
        return linkedList;
    }
}
