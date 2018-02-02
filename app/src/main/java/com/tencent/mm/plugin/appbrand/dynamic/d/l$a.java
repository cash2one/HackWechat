package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Bundle;
import android.view.View;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.plugin.appbrand.dynamic.e;
import com.tencent.mm.plugin.appbrand.dynamic.widget.a.a;
import com.tencent.mm.sdk.platformtools.x;

class l$a implements h<a, Bundle> {
    private l$a() {
    }

    public final /* synthetic */ void a(Object obj, i iVar) {
        a aVar = (a) obj;
        Bundle bundle = new Bundle();
        View rn = e.acF().rn(aVar.id);
        if (rn instanceof com.tencent.mm.plugin.appbrand.dynamic.h) {
            ((com.tencent.mm.plugin.appbrand.dynamic.h) rn).b(aVar.height, new 1(this, bundle, iVar));
            return;
        }
        x.i("MicroMsg.IPCInvoke_RequestSetWidgetSize", "drawCanvas failed, view is not a instance of DynamicPageAccessible.(%s)", new Object[]{aVar.id});
        bundle.putBoolean("ret", false);
        bundle.putString("reason", "view is not a instance of DynamicPageAccessible");
        iVar.as(bundle);
    }
}
