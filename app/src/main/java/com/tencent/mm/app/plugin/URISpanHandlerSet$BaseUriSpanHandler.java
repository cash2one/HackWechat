package com.tencent.mm.app.plugin;

import android.os.Bundle;
import com.tencent.mm.pluginsdk.t;
import com.tencent.mm.pluginsdk.ui.applet.k;
import com.tencent.mm.pluginsdk.ui.d.f;

abstract class URISpanHandlerSet$BaseUriSpanHandler {
    final /* synthetic */ URISpanHandlerSet fhe;

    abstract boolean a(k kVar, f fVar);

    abstract boolean a(String str, boolean z, t tVar, Bundle bundle);

    abstract k cH(String str);

    abstract int[] uC();

    public URISpanHandlerSet$BaseUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
        this.fhe = uRISpanHandlerSet;
    }
}
