package com.tencent.mm.plugin.appbrand.canvas.c;

import android.graphics.Path;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class e {
    private Map<String, a> iLk = new HashMap();

    public e() {
        a(new h());
        a(new f());
        a(new g());
        a(new i());
        a(new d());
        a(new b());
        a(new c());
        a(new j());
    }

    public final Path d(JSONArray jSONArray) {
        Path path = new Path();
        if (jSONArray == null || jSONArray.length() == 0) {
            return path;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("method");
                JSONArray optJSONArray = optJSONObject.optJSONArray(SlookAirButtonFrequentContactAdapter.DATA);
                a aVar = (a) this.iLk.get(optString);
                if (aVar != null) {
                    aVar.a(path, optJSONArray);
                }
            }
        }
        return path;
    }

    private void a(a aVar) {
        this.iLk.put(aVar.getMethod(), aVar);
    }
}
