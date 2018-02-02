package com.tencent.mm.plugin.appbrand.dynamic.f;

import com.tencent.mm.plugin.appbrand.p.f;
import com.tencent.mm.u.b.c;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class b extends c {
    public Map<String, String> iUb;
    public String iUc;
    public int iUd;
    public int iUe;
    public String path;
    public String title;

    public b() {
        super("onCanvasInsert");
    }

    b(int i) {
        super("onCanvasInsert", i);
    }

    public final JSONObject sN() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("title", this.title);
            jSONObject.put("path", this.path);
            jSONObject.put("query", new JSONObject(this.iUb == null ? new HashMap() : this.iUb));
            jSONObject.put("cacheKey", this.iUc);
            jSONObject.put("width", f.lH(this.iUd));
            jSONObject.put("height", f.lH(this.iUe));
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
