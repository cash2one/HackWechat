package com.tencent.mm.plugin.appbrand.jsapi.h;

import com.tencent.mm.a.e;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.kernel.g;

final class b$a implements j<IPCVoid, IPCString> {
    private b$a() {
    }

    public final /* synthetic */ Object at(Object obj) {
        String str = g.Dj().gQi + "address";
        return e.bO(str) ? new IPCString(str) : new IPCString("");
    }
}
