package com.tencent.mm.plugin.appbrand.media;

import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.plugin.appbrand.media.d.a;

final class AppBrandMusicClientService$a implements j<IPCString, IPCBoolean> {
    private AppBrandMusicClientService$a() {
    }

    public final /* synthetic */ Object at(Object obj) {
        return new IPCBoolean(a.aio().tj(((IPCString) obj).value));
    }
}
