package com.tencent.mm.app.plugin;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler;
import com.tencent.mm.app.plugin.URISpanHandlerSet.a;
import com.tencent.mm.bm.d;
import com.tencent.mm.pluginsdk.t;
import com.tencent.mm.pluginsdk.ui.applet.k;
import com.tencent.mm.pluginsdk.ui.d.f;

@a
class URISpanHandlerSet$CardUriSpanHandler extends BaseUriSpanHandler {
    final /* synthetic */ URISpanHandlerSet fhe;

    URISpanHandlerSet$CardUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
        this.fhe = uRISpanHandlerSet;
        super(uRISpanHandlerSet);
    }

    final k cH(String str) {
        return null;
    }

    final int[] uC() {
        return new int[0];
    }

    final boolean a(k kVar, f fVar) {
        return false;
    }

    final boolean a(String str, boolean z, t tVar, Bundle bundle) {
        if (!str.startsWith("wxcard://cardjumptype=1")) {
            return false;
        }
        String str2 = null;
        if (tVar != null) {
            str2 = tVar.bYg().toString();
        }
        Intent intent = new Intent();
        intent.putExtra("user_name", str2);
        intent.putExtra("view_type", 1);
        d.b(URISpanHandlerSet.a(this.fhe), "card", ".ui.CardViewUI", intent);
        return true;
    }
}
