package com.tencent.mm.plugin.appbrand.dynamic.f;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.sdk.platformtools.bh;
import org.json.JSONException;
import org.json.JSONObject;

public final class c extends com.tencent.mm.u.b.c {
    public String data;

    public c() {
        super("onDataPush");
    }

    c(int i) {
        super("onDataPush", i);
    }

    public final JSONObject sN() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SlookAirButtonFrequentContactAdapter.DATA, bh.ou(this.data));
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
