package com.tencent.mm.plugin.appbrand.jsapi.version;

import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import org.json.JSONObject;

public final class JsApiUpdateApp extends a {
    private static final int CTRL_INDEX = 359;
    private static final String NAME = "updateApp";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        XIPCInvoker.a("com.tencent.mm", new IPCString(jVar.irP.iqx.fnl), a.class, new 1(this, jVar, i));
    }
}
