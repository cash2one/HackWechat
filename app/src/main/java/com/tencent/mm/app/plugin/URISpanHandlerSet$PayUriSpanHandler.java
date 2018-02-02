package com.tencent.mm.app.plugin;

import android.os.Bundle;
import android.os.Looper;
import com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler;
import com.tencent.mm.g.a.gw;
import com.tencent.mm.pluginsdk.t;
import com.tencent.mm.pluginsdk.ui.applet.k;
import com.tencent.mm.pluginsdk.ui.d.f;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;

@URISpanHandlerSet$a
class URISpanHandlerSet$PayUriSpanHandler extends BaseUriSpanHandler {
    final /* synthetic */ URISpanHandlerSet fhe;

    URISpanHandlerSet$PayUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
        this.fhe = uRISpanHandlerSet;
        super(uRISpanHandlerSet);
    }

    final k cH(String str) {
        return null;
    }

    final int[] uC() {
        return new int[]{28};
    }

    final boolean a(k kVar, f fVar) {
        if (kVar.type != 28) {
            return false;
        }
        if (fVar != null) {
            fVar.a(kVar);
        }
        b gwVar = new gw();
        gwVar.fxb.actionCode = 11;
        gwVar.fxb.result = kVar.url;
        gwVar.fxb.context = URISpanHandlerSet.a(this.fhe);
        gwVar.fxb.fxd = new Bundle();
        gwVar.fxb.fxd.putInt("pay_channel", 6);
        a.xef.a(gwVar, Looper.myLooper());
        if (fVar != null) {
            fVar.b(kVar);
        }
        return true;
    }

    final boolean a(String str, boolean z, t tVar, Bundle bundle) {
        return false;
    }
}
