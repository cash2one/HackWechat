package com.tencent.mm.wallet_core.c;

import org.json.JSONObject;

public final class q {
    public String wQi = "";
    public String wWP = "";
    public String zHG = "";
    public String zHH = "";
    public int zHI = 0;

    public q(JSONObject jSONObject) {
        this.zHG = jSONObject.optString("device_id");
        this.wWP = jSONObject.optString("device_name");
        this.zHH = jSONObject.optString("device_os");
        this.zHI = jSONObject.optInt("Is_cur_device");
        this.wQi = jSONObject.optString("crt_no");
    }
}
