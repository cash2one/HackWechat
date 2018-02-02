package com.tencent.mm.plugin.appbrand.jsapi.version;

import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.plugin.appbrand.config.r;
import com.tencent.mm.plugin.appbrand.jsapi.version.JsApiUpdateApp.SyncResult;

final class JsApiUpdateApp$a implements h<IPCString, SyncResult> {
    private JsApiUpdateApp$a() {
    }

    public final /* synthetic */ void a(Object obj, i iVar) {
        r.a(((IPCString) obj).value, new 1(this, iVar));
    }
}
