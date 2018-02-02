package com.tencent.mm.app.plugin;

import android.os.Bundle;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.app.plugin.URISpanHandlerSet.a;
import com.tencent.mm.pluginsdk.t;
import com.tencent.mm.pluginsdk.ui.applet.k;
import com.tencent.mm.pluginsdk.ui.d.f;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.q;

@a
class URISpanHandlerSet$PayTransferUriSpanHandler extends URISpanHandlerSet$BaseUriSpanHandler {
    final /* synthetic */ URISpanHandlerSet fhe;

    URISpanHandlerSet$PayTransferUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
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
        String str2 = null;
        if (!str.startsWith("wxpay://")) {
            return false;
        }
        String obj;
        com.tencent.mm.plugin.wallet.a aVar;
        if (tVar != null) {
            obj = tVar.bYg().toString();
            Object bYh = tVar.bYh();
            if (bYh instanceof com.tencent.mm.plugin.wallet.a) {
                aVar = (com.tencent.mm.plugin.wallet.a) bYh;
                str2 = obj;
            } else {
                aVar = null;
                str2 = obj;
            }
        } else {
            aVar = null;
        }
        if (bh.ov(str2)) {
            x.e("MicroMsg.URISpanHandlerSet", "SERVICE_JUMP_TO_PAY fail, null username");
            return false;
        }
        obj = str.substring(8);
        String str3 = "";
        if (obj.indexOf("&") > 0) {
            obj = obj.split("&")[0];
        }
        int indexOf = obj.indexOf("=");
        if (indexOf >= 0) {
            obj = obj.substring(indexOf + 1);
        } else {
            obj = str3;
        }
        if (bh.getInt(obj, 0) == 1) {
            if (q.Gg() || q.Gh()) {
                h.a(URISpanHandlerSet.a(this.fhe), 5, str2, 11, aVar);
            } else {
                h.a(URISpanHandlerSet.a(this.fhe), 2, str2, 11, aVar);
            }
            return true;
        }
        Toast.makeText(URISpanHandlerSet.a(this.fhe), URISpanHandlerSet.a(this.fhe).getString(R.l.eKh), 0).show();
        return false;
    }
}
