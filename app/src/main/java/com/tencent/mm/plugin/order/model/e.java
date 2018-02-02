package com.tencent.mm.plugin.order.model;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.tenpay.model.i;
import com.tenpay.android.wechat.PayuSecureEncrypt;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class e extends i {
    public int liB;
    private int ocK;
    public List<i> pbd = null;
    public List<d> pbe = null;
    public String pbf;

    public e(int i, String str) {
        Map hashMap = new HashMap();
        hashMap.put("Limit", PayuSecureEncrypt.ENCRYPT_VERSION_DEFAULT);
        hashMap.put("Offset", String.valueOf(i));
        hashMap.put("Extbuf", str);
        D(hashMap);
    }

    public final int ayQ() {
        return 105;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        int i2 = 0;
        x.d("MicroMsg.NetScenePatchQueryUserRoll", "errCode " + i + " errMsg: " + str);
        this.pbd = new LinkedList();
        try {
            this.liB = jSONObject.getInt("TotalNum");
            this.ocK = jSONObject.getInt("RecNum");
            this.pbf = jSONObject.optString("Extbuf");
            JSONArray jSONArray = jSONObject.getJSONArray("UserRollList");
            if (jSONArray != null) {
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    i iVar = new i();
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                    iVar.pbq = jSONObject2.optInt("PayType");
                    iVar.pbi = jSONObject2.optString("Transid");
                    iVar.pbj = jSONObject2.optDouble("TotalFee");
                    iVar.pbk = jSONObject2.optString("GoodsName");
                    iVar.pbl = jSONObject2.optInt("CreateTime");
                    iVar.pbn = jSONObject2.optInt("ModifyTime");
                    iVar.pbo = jSONObject2.optString("FeeType");
                    iVar.pbt = jSONObject2.optString("AppThumbUrl");
                    iVar.pbm = jSONObject2.optString("TradeStateName");
                    iVar.pby = jSONObject2.optString("StatusColor");
                    iVar.pbz = jSONObject2.optString("FeeColor");
                    iVar.pbA = jSONObject2.optDouble("ActualPayFee");
                    iVar.pbB = jSONObject2.optString("BillId");
                    this.pbd.add(iVar);
                }
            }
            this.pbe = new LinkedList();
            JSONArray optJSONArray = jSONObject.optJSONArray("month_info");
            if (optJSONArray != null) {
                while (i2 < optJSONArray.length()) {
                    JSONObject jSONObject3 = optJSONArray.getJSONObject(i2);
                    d dVar = new d();
                    dVar.year = jSONObject3.optInt("year");
                    dVar.month = jSONObject3.optInt("month");
                    dVar.pbc = jSONObject3.optString("feetext");
                    this.pbe.add(dVar);
                    i2++;
                }
            }
        } catch (JSONException e) {
            x.e("MicroMsg.NetScenePatchQueryUserRoll", "Parse Json exp:" + e.getLocalizedMessage());
        }
    }
}
