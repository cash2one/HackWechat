package com.tencent.mm.app.plugin;

import android.os.Bundle;
import com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler;
import com.tencent.mm.pluginsdk.t;
import com.tencent.mm.pluginsdk.ui.applet.k;
import com.tencent.mm.pluginsdk.ui.d.f;
import com.tencent.mm.sdk.platformtools.x;

@URISpanHandlerSet$a
class URISpanHandlerSet$AppBrandLinkSpanHandler extends BaseUriSpanHandler {
    final /* synthetic */ URISpanHandlerSet fhe;

    URISpanHandlerSet$AppBrandLinkSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
        this.fhe = uRISpanHandlerSet;
        super(uRISpanHandlerSet);
    }

    final k cH(String str) {
        return null;
    }

    final int[] uC() {
        return new int[]{45};
    }

    final boolean a(k kVar, f fVar) {
        if (kVar.type == 45) {
            if (fVar != null) {
                x.i("MicroMsg.URISpanHandlerSet", "AppBrandLinkSpanHandler click appbrandlink");
                fVar.b(kVar);
                return true;
            }
            x.e("MicroMsg.URISpanHandlerSet", "clickCallback is null, return");
        }
        return false;
    }

    final boolean a(String str, boolean z, t tVar, Bundle bundle) {
        return false;
    }
}
