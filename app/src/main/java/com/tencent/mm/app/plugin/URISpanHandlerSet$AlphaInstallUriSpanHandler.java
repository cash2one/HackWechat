package com.tencent.mm.app.plugin;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler;
import com.tencent.mm.app.plugin.URISpanHandlerSet.a;
import com.tencent.mm.bm.d;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.pluginsdk.t;
import com.tencent.mm.pluginsdk.ui.applet.k;
import com.tencent.mm.pluginsdk.ui.d.f;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;

@a
class URISpanHandlerSet$AlphaInstallUriSpanHandler extends BaseUriSpanHandler {
    final /* synthetic */ URISpanHandlerSet fhe;

    URISpanHandlerSet$AlphaInstallUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
        this.fhe = uRISpanHandlerSet;
        super(uRISpanHandlerSet);
    }

    final k cH(String str) {
        if (str.trim().toLowerCase().startsWith("weixin://alphainstall?")) {
            return new k(str, 32, null);
        }
        return null;
    }

    final int[] uC() {
        return new int[]{32};
    }

    final boolean a(k kVar, f fVar) {
        if (kVar.type != 32) {
            return false;
        }
        String replace = kVar.url.replace("weixin://alphainstall?", "");
        String str = e.bnF + Uri.parse(replace).getQueryParameter("md5") + ".apk";
        if (com.tencent.mm.a.e.bO(str)) {
            bh.i(str, ac.getContext());
        } else {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", replace.toString());
            d.b(URISpanHandlerSet.a(this.fhe), "webview", ".ui.tools.WebViewUI", intent);
        }
        return true;
    }

    final boolean a(String str, boolean z, t tVar, Bundle bundle) {
        return false;
    }
}
