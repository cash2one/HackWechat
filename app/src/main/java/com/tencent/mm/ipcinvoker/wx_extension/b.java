package com.tencent.mm.ipcinvoker.wx_extension;

import com.tencent.mm.ae.u;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.sdk.platformtools.ac;

public final class b {
    public static void a(com.tencent.mm.ae.b bVar, a aVar) {
        if (ac.cfw()) {
            u.a(bVar, new 1(aVar), true);
        } else {
            XIPCInvoker.a("com.tencent.mm", bVar, b.class, new 2(aVar));
        }
    }
}
