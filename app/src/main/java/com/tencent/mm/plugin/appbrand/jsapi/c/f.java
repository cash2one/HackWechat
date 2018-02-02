package com.tencent.mm.plugin.appbrand.jsapi.c;

import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import org.json.JSONObject;

public final class f extends c {
    public static final int CTRL_INDEX = 83;
    public static final String NAME = "updateCanvas";

    protected final int i(JSONObject jSONObject) {
        return jSONObject.optInt("canvasId");
    }

    protected final boolean afL() {
        return true;
    }
}
