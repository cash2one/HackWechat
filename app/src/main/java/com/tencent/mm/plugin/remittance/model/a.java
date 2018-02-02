package com.tencent.mm.plugin.remittance.model;

import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.protocal.c.io;
import com.tencent.mm.protocal.c.vu;
import com.tencent.mm.protocal.c.vv;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a {
    public static JSONObject a(io ioVar) {
        if (ioVar == null) {
            return new JSONObject();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            List list = ioVar.vON;
            vv vvVar = new vv();
            jSONObject.put("favor_info_list", by(list));
            list = ioVar.vOO;
            vu vuVar = new vu();
            jSONObject.put("favor_compose_result_list", bz(list));
            jSONObject.put("default_fav_compose_id", ioVar.vOP);
            jSONObject.put("favor_resp_sign", ioVar.vOQ);
            jSONObject.put("no_compose_wording", ioVar.vOR);
            return jSONObject;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", e, "", new Object[0]);
            return jSONObject;
        }
    }

    private static JSONArray by(List<vv> list) {
        if (list == null) {
            return new JSONArray();
        }
        JSONArray jSONArray = new JSONArray();
        try {
            int i = 0;
            for (vv a : list) {
                jSONArray.put(i, a(a));
                i++;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", e, "", new Object[0]);
        }
        return jSONArray;
    }

    private static JSONObject a(vv vvVar) {
        if (vvVar == null) {
            return new JSONObject();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("fav_type", vvVar.wfJ);
            jSONObject.put("fav_sub_type", vvVar.wfK);
            jSONObject.put("fav_property", vvVar.wfL);
            jSONObject.put("favor_type_desc", vvVar.wfM);
            jSONObject.put("fav_id", vvVar.wfN);
            jSONObject.put("fav_name", vvVar.wfO);
            jSONObject.put("fav_desc", vvVar.wfP);
            jSONObject.put("favor_use_manual", vvVar.wfQ);
            jSONObject.put("favor_remarks", vvVar.wfR);
            jSONObject.put("fav_price", vvVar.wfS);
            jSONObject.put("real_fav_fee", vvVar.wfT);
            jSONObject.put("fav_scope_type", vvVar.wfU);
            jSONObject.put("business_receipt_no", vvVar.wfV);
            jSONObject.put("unavailable", vvVar.wfW);
            return jSONObject;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", e, "", new Object[0]);
            return jSONObject;
        }
    }

    private static JSONArray bz(List<vu> list) {
        if (list == null) {
            return new JSONArray();
        }
        JSONArray jSONArray = new JSONArray();
        try {
            int i = 0;
            for (vu a : list) {
                jSONArray.put(i, a(a));
                i++;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", e, "", new Object[0]);
        }
        return jSONArray;
    }

    public static JSONObject a(vu vuVar) {
        if (vuVar == null) {
            return new JSONObject();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("favor_compose_id", vuVar.wfE);
            List list = vuVar.vON;
            vv vvVar = new vv();
            jSONObject.put("favor_info_list,", by(list));
            jSONObject.put("show_favor_amount,", vuVar.wfF);
            jSONObject.put("show_pay_amount,", vuVar.wfG);
            jSONObject.put("total_favor_amount,", vuVar.wfH);
            jSONObject.put("favor_desc", vuVar.pKc);
            jSONObject.put("compose_sort_flag", vuVar.wfI);
            jSONObject.put("extend_str", vuVar.vUk);
            return jSONObject;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", e, "", new Object[0]);
            return jSONObject;
        }
    }

    public static JSONObject a(cd cdVar) {
        if (cdVar == null) {
            return new JSONObject();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("channel", cdVar.fCR);
            jSONObject.put("favor_compose_info", a(cdVar.vHt));
            jSONObject.put("f2f_id", cdVar.vHq);
            jSONObject.put("payok_checksign", cdVar.vHs);
            jSONObject.put("receiver_openid", cdVar.pLn);
            jSONObject.put("receiver_username", cdVar.vHu);
            jSONObject.put("scan_scene", cdVar.pKd);
            jSONObject.put("scene", cdVar.scene);
            jSONObject.put("total_amount", cdVar.vHv);
            jSONObject.put("trans_id", cdVar.vHr);
            return jSONObject;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BusiF2FFavorHelper", e, "", new Object[0]);
            return jSONObject;
        }
    }
}
