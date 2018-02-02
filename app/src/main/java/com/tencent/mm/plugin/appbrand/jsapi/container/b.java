package com.tencent.mm.plugin.appbrand.jsapi.container;

import org.json.JSONObject;

public final class b extends com.tencent.mm.plugin.appbrand.jsapi.base.b {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "removeContainer";

    protected final int i(JSONObject jSONObject) {
        return jSONObject.getInt("containerId");
    }
}
