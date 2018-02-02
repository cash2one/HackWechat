package com.tencent.mm.app.plugin;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.app.plugin.URISpanHandlerSet.a;
import com.tencent.mm.bm.d;
import com.tencent.mm.pluginsdk.t;
import com.tencent.mm.pluginsdk.ui.applet.k;
import com.tencent.mm.pluginsdk.ui.d.f;
import com.tencent.mm.sdk.platformtools.bh;

@a
class URISpanHandlerSet$ExposeUriSpanHandler extends URISpanHandlerSet$BaseUriSpanHandler {
    final /* synthetic */ URISpanHandlerSet fhe;

    URISpanHandlerSet$ExposeUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
        this.fhe = uRISpanHandlerSet;
        super(uRISpanHandlerSet);
    }

    final k cH(String str) {
        if (str.trim().toLowerCase().equals("weixin://expose/")) {
            return new k(str, 31, null);
        }
        return null;
    }

    final int[] uC() {
        return new int[]{31};
    }

    final boolean a(k kVar, f fVar) {
        if (kVar.type != 31) {
            return false;
        }
        int i;
        Intent intent = new Intent();
        String str = (String) fVar.a(kVar);
        intent.putExtra("k_username", str);
        if (bh.ov(str) || !str.endsWith("@chatroom")) {
            i = 39;
        } else {
            i = 36;
        }
        intent.putExtra("showShare", false);
        intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(i)}));
        d.b(URISpanHandlerSet.a(this.fhe), "webview", ".ui.tools.WebViewUI", intent);
        return true;
    }

    final boolean a(String str, boolean z, t tVar, Bundle bundle) {
        return false;
    }
}
