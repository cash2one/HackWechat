package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Bundle;
import android.view.View;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.plugin.appbrand.dynamic.d.i.b;
import com.tencent.mm.plugin.appbrand.dynamic.e;
import com.tencent.mm.sdk.platformtools.x;

class i$a implements h<b, Bundle> {
    private i$a() {
    }

    public final /* synthetic */ void a(Object obj, i iVar) {
        b bVar = (b) obj;
        Bundle bundle = new Bundle();
        View rn = e.acF().rn(bVar.id);
        if (rn instanceof com.tencent.mm.plugin.appbrand.dynamic.h) {
            ((com.tencent.mm.plugin.appbrand.dynamic.h) rn).a(bVar.url, new 1(this, bundle, iVar));
            return;
        }
        x.i("MicroMsg.IPCInvoke_RequestSetWidgetSize", "openApp failed, view is not a instance of DynamicPageAccessible.(%s)", new Object[]{bVar.id});
        bundle.putBoolean("ret", false);
        bundle.putString("reason", "view is not a instance of DynamicPageAccessible");
        iVar.as(bundle);
    }
}
