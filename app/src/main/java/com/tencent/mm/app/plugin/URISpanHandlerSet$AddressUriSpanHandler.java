package com.tencent.mm.app.plugin;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.t;
import com.tencent.mm.pluginsdk.ui.applet.k;
import com.tencent.mm.pluginsdk.ui.d.f;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.WebView;
import com.tencent.wcdb.database.SQLiteDatabase;

@URISpanHandlerSet$a
class URISpanHandlerSet$AddressUriSpanHandler extends BaseUriSpanHandler {
    final /* synthetic */ URISpanHandlerSet fhe;

    URISpanHandlerSet$AddressUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
        this.fhe = uRISpanHandlerSet;
        super(uRISpanHandlerSet);
    }

    final k cH(String str) {
        return null;
    }

    final int[] uC() {
        return new int[]{44};
    }

    final boolean a(k kVar, f fVar) {
        if (kVar.type != 44) {
            return false;
        }
        Uri parse = Uri.parse(new StringBuilder(WebView.SCHEME_GEO).append(Uri.encode(kVar.url)).toString());
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(parse);
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        if (intent.resolveActivity(ac.getContext().getPackageManager()) != null) {
            ac.getContext().startActivity(intent);
            g.pQN.h(12809, Integer.valueOf(9), "");
        } else {
            x.w("MicroMsg.URISpanHandlerSet", "Cannot find map app");
        }
        g.pQN.h(12809, Integer.valueOf(8), "");
        return true;
    }

    final boolean a(String str, boolean z, t tVar, Bundle bundle) {
        return false;
    }
}
