package com.tencent.mm.plugin.wallet_core.c;

import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders$DiscountInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.Promotions;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.tenpay.model.i;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class y extends i {
    public Orders sIO;

    public y(String str) {
        Map hashMap = new HashMap();
        hashMap.put("trans_id", str);
        D(hashMap);
    }

    public y(String str, int i) {
        Map hashMap = new HashMap();
        hashMap.put("trans_id", str);
        hashMap.put("pay_type", String.valueOf(i));
        D(hashMap);
    }

    public final int ayQ() {
        return 3;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                JSONObject jSONObject2;
                this.sIO = new Orders();
                Commodity commodity = new Commodity();
                commodity.pal = jSONObject.getString("buy_uin");
                commodity.pam = jSONObject.getString("buy_name");
                commodity.pan = jSONObject.optString("sale_uin");
                commodity.pao = jSONObject.optString("sale_name");
                commodity.fuI = jSONObject.getString("trans_id");
                commodity.desc = jSONObject.optString("goods_name");
                commodity.ljg = jSONObject.optDouble("pay_num") / 100.0d;
                commodity.pas = jSONObject.getString("trade_state");
                commodity.pat = jSONObject.getString("trade_state_name");
                commodity.pax = jSONObject.getString("buy_bank_name");
                commodity.paE = jSONObject.optString("discount", "");
                commodity.pav = jSONObject.optInt("modify_timestamp");
                commodity.paz = jSONObject.optString("fee_type");
                commodity.paA = jSONObject.optString("appusername");
                commodity.pac = jSONObject.optString("app_telephone");
                commodity.sOk = jSONObject.optDouble("original_total_fee", -1.0d) / 100.0d;
                commodity.paz = jSONObject.optString("fee_type", "");
                int i2 = 1;
                JSONObject optJSONObject = jSONObject.optJSONObject("subscribe_biz_info");
                if (optJSONObject != null) {
                    Promotions promotions = new Promotions();
                    promotions.type = Orders.sOi;
                    promotions.name = optJSONObject.optString("nickname");
                    promotions.paA = optJSONObject.optString("username");
                    commodity.sOl = promotions.paA;
                    promotions.peY = optJSONObject.optString("logo_round_url");
                    promotions.url = optJSONObject.optString("subscribe_biz_url");
                    i2 = optJSONObject.optInt("recommend_level");
                    commodity.sNN = i2;
                    if (!bh.ov(promotions.name)) {
                        commodity.sOs.add(promotions);
                    }
                }
                int i3 = i2;
                JSONArray jSONArray = jSONObject.getJSONArray("activity_info");
                int length = jSONArray.length();
                for (i2 = 0; i2 < length; i2++) {
                    jSONObject2 = jSONArray.getJSONObject(i2);
                    Promotions promotions2 = new Promotions();
                    promotions2.type = Orders.sOj;
                    promotions2.peY = jSONObject2.optString("icon");
                    promotions2.name = jSONObject2.optString("wording");
                    promotions2.url = jSONObject2.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                    promotions2.sNx = jSONObject2.optString("btn_text");
                    promotions2.sOA = jSONObject2.optInt(DownloadSettingTable$Columns.TYPE);
                    promotions2.title = jSONObject2.optString("title");
                    promotions2.sIr = jSONObject2.optLong("activity_id");
                    promotions2.sOB = jSONObject2.optInt("activity_type", 0);
                    promotions2.sOC = jSONObject2.optInt("award_id");
                    promotions2.sNu = jSONObject2.optInt("send_record_id");
                    promotions2.sNv = jSONObject2.optInt("user_record_id");
                    promotions2.sOE = jSONObject2.optString("activity_tinyapp_username");
                    promotions2.sOF = jSONObject2.optString("activity_tinyapp_path");
                    promotions2.sNw = jSONObject2.optLong("activity_mch_id");
                    promotions2.sOG = jSONObject2.optInt("activity_tinyapp_version");
                    promotions2.sOH = jSONObject2.optString("get_award_params");
                    promotions2.sOI = jSONObject2.optString("query_award_status_params");
                    Orders.a(promotions2, jSONObject2.optJSONObject("exposure_info"));
                    commodity.sOs.add(promotions2);
                }
                jSONArray = jSONObject.optJSONArray("discount_array");
                if (jSONArray != null && jSONArray.length() > 0) {
                    length = jSONArray.length();
                    commodity.sOn = new ArrayList();
                    for (i2 = 0; i2 < length; i2++) {
                        jSONObject2 = jSONArray.optJSONObject(i2);
                        Orders$DiscountInfo orders$DiscountInfo = new Orders$DiscountInfo();
                        orders$DiscountInfo.sOz = jSONObject2.optDouble("payment_amount");
                        orders$DiscountInfo.pKc = jSONObject2.optString("favor_desc");
                        commodity.sOn.add(orders$DiscountInfo);
                    }
                }
                commodity.sOo = jSONObject.optString("rateinfo");
                commodity.sOp = jSONObject.optString("discount_rateinfo");
                commodity.sOq = jSONObject.optString("original_feeinfo");
                this.sIO.sNW = new ArrayList();
                this.sIO.sNW.add(commodity);
                this.sIO.sNP = jSONObject.optString("trade_state_name");
                this.sIO.sNN = i3;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.NetSceneTenpayQueryOrderInfo", e, "", new Object[0]);
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.NetSceneTenpayQueryOrderInfo", e2, "", new Object[0]);
            }
        }
    }
}
