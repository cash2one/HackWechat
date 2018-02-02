package com.tencent.mm.plugin.remittance.model;

import com.tencent.mm.protocal.c.vu;
import com.tencent.mm.protocal.c.vv;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b {
    public static LinkedList<vu> q(JSONArray jSONArray) {
        LinkedList<vu> linkedList = new LinkedList();
        if (jSONArray != null) {
            int i = 0;
            while (i < jSONArray.length()) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    vu vuVar = new vu();
                    vuVar.wfE = jSONObject.optString("favor_compose_id");
                    vuVar.wfF = jSONObject.optLong("show_favor_amount");
                    vuVar.wfG = jSONObject.optLong("show_pay_amount");
                    vuVar.wfH = jSONObject.optString("total_favor_amount");
                    vuVar.pKc = jSONObject.optString("favor_desc");
                    vuVar.wfI = jSONObject.optLong("compose_sort_flag");
                    vuVar.vUk = jSONObject.optString("extend_str");
                    vuVar.vON = r(jSONObject.optJSONArray("favor_info_list"));
                    linkedList.add(vuVar);
                    i++;
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.BusiFavorInfoParser", e, "", new Object[0]);
                }
            }
        }
        return linkedList;
    }

    public static LinkedList<vv> r(JSONArray jSONArray) {
        LinkedList<vv> linkedList = new LinkedList();
        if (jSONArray != null) {
            int i = 0;
            while (i < jSONArray.length()) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    vv vvVar = new vv();
                    vvVar.wfV = jSONObject.optString("business_receipt_no");
                    vvVar.vUk = jSONObject.optString("extend_str");
                    vvVar.wfP = jSONObject.optString("fav_desc");
                    vvVar.wfN = jSONObject.optLong("fav_id", 0);
                    vvVar.wfO = jSONObject.optString("fav_name");
                    vvVar.wfS = jSONObject.optString("fav_price");
                    vvVar.wfL = jSONObject.optLong("fav_property", 0);
                    vvVar.wfU = jSONObject.optInt("fav_scope_type", 0);
                    vvVar.wfK = jSONObject.optLong("fav_sub_type", 0);
                    vvVar.wfJ = jSONObject.optLong("fav_type", 0);
                    vvVar.wfR = jSONObject.optString("favor_remarks");
                    vvVar.wfM = jSONObject.optString("favor_type_desc");
                    vvVar.wfQ = jSONObject.optString("favor_use_manual");
                    vvVar.wfT = jSONObject.optString("real_fav_fee");
                    vvVar.wfW = jSONObject.optInt("unavailable");
                    linkedList.add(vvVar);
                    i++;
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.BusiFavorInfoParser", e, "", new Object[0]);
                }
            }
        }
        return linkedList;
    }
}
