package com.tencent.mm.plugin.auth;

import com.tencent.mm.kernel.b.f;
import com.tencent.mm.plugin.auth.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.i;
import com.tencent.mm.protocal.i.g;
import com.tencent.mm.protocal.y;
import com.tencent.mm.z.as;

public class PluginAuth extends f implements b {
    private final a kic = new a();

    private static final class a extends com.tencent.mm.cd.a<com.tencent.mm.plugin.auth.a.a> implements com.tencent.mm.plugin.auth.a.a {
        private a() {
        }

        public final void a(i.f fVar, g gVar, boolean z) {
            a(new 1(this, fVar, gVar, z));
        }

        public final void a(y.b bVar, String str, int i, String str2, String str3, int i2) {
            a(new 2(this, bVar, str, i, str2, str3, i2));
        }
    }

    public void installed() {
        alias(b.class);
    }

    public void dependency() {
        dependsOn(n.class);
    }

    public void configure(com.tencent.mm.kernel.b.g gVar) {
        as.a(new 1(this));
    }

    public void execute(com.tencent.mm.kernel.b.g gVar) {
    }

    public String toString() {
        return "plugin-auth";
    }

    public com.tencent.mm.vending.b.b addHandleAuthResponse(com.tencent.mm.plugin.auth.a.a aVar) {
        return this.kic.aE(aVar);
    }

    public com.tencent.mm.plugin.auth.a.a getHandleAuthResponseCallbacks() {
        return this.kic;
    }
}
