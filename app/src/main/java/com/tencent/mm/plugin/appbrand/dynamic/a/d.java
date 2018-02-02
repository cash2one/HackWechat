package com.tencent.mm.plugin.appbrand.dynamic.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.modelappbrand.h;
import com.tencent.mm.modelappbrand.h.a;
import com.tencent.mm.plugin.appbrand.appcache.d$a;
import com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetInitializer;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.b;
import com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetDebugUI;
import com.tencent.mm.plugin.appbrand.wxawidget.console.e;

public final class d implements h {
    boolean iSG;

    public final void b(Context context, Bundle bundle) {
        Intent intent = new Intent(context, WxaWidgetDebugUI.class);
        String aZ = WxaWidgetInitializer.aZ(bundle.getString("app_id"), bundle.getString("msg_id"));
        intent.putExtras(bundle);
        intent.putExtra(SlookAirButtonFrequentContactAdapter.ID, aZ);
        context.startActivity(intent);
    }

    public final void bf(Context context) {
        e.ck(context);
    }

    public final boolean hf(int i) {
        return d$a.hf(i);
    }

    public final boolean a(String str, a aVar) {
        return b.c(str, aVar);
    }

    public final boolean b(String str, a aVar) {
        return b.d(str, aVar);
    }

    public final void bz(boolean z) {
        this.iSG = z;
    }

    public final boolean IZ() {
        return this.iSG;
    }

    public final boolean Ja() {
        return com.tencent.mm.sdk.a.b.ceK();
    }
}
