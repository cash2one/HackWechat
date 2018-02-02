package com.tencent.mm.app.plugin;

import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.app.plugin.URISpanHandlerSet.a;
import com.tencent.mm.g.a.sp;
import com.tencent.mm.pluginsdk.t;
import com.tencent.mm.pluginsdk.ui.applet.k;
import com.tencent.mm.pluginsdk.ui.d.f;
import com.tencent.mm.sdk.b.b;

@a
class URISpanHandlerSet$VoipCallAgainUrilSpanHandler extends URISpanHandlerSet$BaseUriSpanHandler {
    final /* synthetic */ URISpanHandlerSet fhe;

    URISpanHandlerSet$VoipCallAgainUrilSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
        this.fhe = uRISpanHandlerSet;
        super(uRISpanHandlerSet);
    }

    final k cH(String str) {
        if (str.trim().startsWith("weixin://voip/callagain/")) {
            return new k(str, 38, null);
        }
        return null;
    }

    final int[] uC() {
        return new int[]{38};
    }

    final boolean a(k kVar, f fVar) {
        if (kVar.type == 38) {
            Uri parse = Uri.parse(kVar.url);
            String queryParameter = parse.getQueryParameter("username");
            String queryParameter2 = parse.getQueryParameter("isvideocall");
            b spVar = new sp();
            spVar.fKq.fuL = 5;
            spVar.fKq.talker = queryParameter;
            spVar.fKq.context = URISpanHandlerSet.a(this.fhe);
            if (!(queryParameter == null || queryParameter.equals(""))) {
                if (queryParameter2 == null || !queryParameter2.equals("true")) {
                    spVar.fKq.fKl = 4;
                } else {
                    spVar.fKq.fKl = 2;
                }
                com.tencent.mm.sdk.b.a.xef.m(spVar);
                return true;
            }
        }
        return false;
    }

    final boolean a(String str, boolean z, t tVar, Bundle bundle) {
        return false;
    }
}
