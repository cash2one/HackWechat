package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.appcache.v.b;
import com.tencent.mm.plugin.appbrand.appcache.v.c;
import com.tencent.mm.plugin.appbrand.appcache.v.d;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.Callable;

class v$1 implements Callable<c> {
    v$1() {
    }

    public final /* synthetic */ Object call() {
        return ZQ();
    }

    private static c ZQ() {
        WxaPkgWrappingInfo wxaPkgWrappingInfo;
        try {
            wxaPkgWrappingInfo = (WxaPkgWrappingInfo) XIPCInvoker.a("com.tencent.mm", IPCVoid.gNf, b.class);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WxaCommLibRuntimeReader", e, "load() ipc read lib", new Object[0]);
            wxaPkgWrappingInfo = null;
        }
        x.i("MicroMsg.WxaCommLibRuntimeReader", "load(), ipc query pkgInfo %s", new Object[]{wxaPkgWrappingInfo});
        return (wxaPkgWrappingInfo == null || wxaPkgWrappingInfo.iGN) ? v$a.iEQ : new d(wxaPkgWrappingInfo, (byte) 0);
    }
}
