package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Bundle;
import android.view.View;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.plugin.appbrand.dynamic.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.u$b;
import org.json.JSONObject;

public final class h extends com.tencent.mm.plugin.appbrand.dynamic.d.a.a {

    private static class a implements com.tencent.mm.ipcinvoker.h<b, Bundle> {
        private a() {
        }

        public final /* synthetic */ void a(Object obj, i iVar) {
            b bVar = (b) obj;
            Bundle bundle = new Bundle();
            View rn = e.acF().rn(bVar.id);
            if (rn instanceof com.tencent.mm.plugin.appbrand.dynamic.h) {
                ((com.tencent.mm.plugin.appbrand.dynamic.h) rn).a(bVar.iTt, bVar.fIR, bVar.iTu, new 1(this, bundle, iVar));
                return;
            }
            x.i("MicroMsg.IPCInvoke_RequestSetWidgetSize", "onTapCallback failed, view is not a instance of DynamicPageAccessible.(%s)", new Object[]{bVar.id});
            bundle.putBoolean("ret", false);
            bundle.putString("reason", "view is not a instance of DynamicPageAccessible");
            iVar.as(bundle);
        }
    }

    public h() {
        super("onTapCallback", 327);
    }

    protected final void a(com.tencent.mm.u.c.a aVar, JSONObject jSONObject, com.tencent.mm.u.b.b.a<JSONObject> aVar2) {
        u$b Cb = aVar.Cb();
        b bVar = new b();
        bVar.id = Cb.getString("__page_view_id", "");
        bVar.fIR = jSONObject.optString("eventId", "");
        bVar.iTt = jSONObject.optBoolean("hasHandler");
        bVar.iTu = jSONObject.optBoolean("res");
        XIPCInvoker.a(Cb.getString("__process_name", ac.Br()), bVar, a.class, new 1(this, aVar2));
    }
}
