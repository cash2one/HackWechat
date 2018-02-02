package com.tencent.mm.plugin.auth;

import com.tencent.mm.protocal.i.f;
import com.tencent.mm.protocal.i.g;
import com.tencent.mm.z.as.a;
import com.tencent.mm.z.y;

class PluginAuth$1 implements a {
    final /* synthetic */ PluginAuth kid;

    PluginAuth$1(PluginAuth pluginAuth) {
        this.kid = pluginAuth;
    }

    public final void a(f fVar, g gVar) {
        y.a(gVar.vAZ, true);
        this.kid.getHandleAuthResponseCallbacks().a(fVar, gVar, true);
    }
}
