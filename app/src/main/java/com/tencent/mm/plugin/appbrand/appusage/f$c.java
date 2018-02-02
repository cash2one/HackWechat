package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.sdk.platformtools.x;

final class f$c implements j<AppIdentity, IPCBoolean> {
    private f$c() {
    }

    public final /* synthetic */ Object at(Object obj) {
        return a((AppIdentity) obj);
    }

    private static IPCBoolean a(AppIdentity appIdentity) {
        try {
            return new IPCBoolean(((e) f.u(e.class)).am(appIdentity.username, appIdentity.iKd));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AppBrandLocalUsageStorageIPCImpl", e, "ipc removeUsage", new Object[0]);
            return new IPCBoolean(false);
        }
    }
}
