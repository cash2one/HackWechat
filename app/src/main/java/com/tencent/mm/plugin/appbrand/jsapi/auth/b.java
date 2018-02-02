package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.q.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import org.json.JSONObject;

abstract class b extends a {
    protected abstract void a(j jVar, JSONObject jSONObject, int i, a aVar);

    b() {
    }

    public void a(j jVar, JSONObject jSONObject, int i) {
        final e o = a.o(jVar.irP);
        final j jVar2 = jVar;
        final JSONObject jSONObject2 = jSONObject;
        final int i2 = i;
        AnonymousClass1 anonymousClass1 = new a.a(this) {
            final /* synthetic */ b jfS;

            public final void afF() {
                x.i("MicroMsg.AppBrand.BaseAuthJsApi", "about to call AuthInvoke, api[%s]", this.jfS.getName());
                this.jfS.a(jVar2, jSONObject2, i2, o);
            }

            public final String toString() {
                return hashCode() + "|" + this.jfS.getName();
            }
        };
        if (!o.afE()) {
            synchronized (o.jRU) {
                o.jRU.offer(anonymousClass1);
            }
            o.Dh(1);
        }
    }

    final void a(j jVar, int i, String str) {
        jVar.E(i, e(str, null));
    }

    protected final MMActivity a(j jVar) {
        return super.a(jVar);
    }
}
