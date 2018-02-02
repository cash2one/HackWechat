package com.tencent.mm.app.plugin;

import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.ag.d;
import com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler;
import com.tencent.mm.app.plugin.URISpanHandlerSet.PRIORITY;
import com.tencent.mm.app.plugin.URISpanHandlerSet.a;
import com.tencent.mm.pluginsdk.t;
import com.tencent.mm.pluginsdk.ui.applet.k;
import com.tencent.mm.pluginsdk.ui.d.f;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

@a(uD = PRIORITY.LOW)
class URISpanHandlerSet$DeeplinkUriSpanHandler extends BaseUriSpanHandler {
    final /* synthetic */ URISpanHandlerSet fhe;

    URISpanHandlerSet$DeeplinkUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
        this.fhe = uRISpanHandlerSet;
        super(uRISpanHandlerSet);
    }

    final k cH(String str) {
        x.i("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler getHrefFromUrl %s", new Object[]{str});
        if (str.trim().toLowerCase().startsWith("weixin://")) {
            return new k(str, 30, null);
        }
        return null;
    }

    final int[] uC() {
        return new int[]{30};
    }

    final boolean a(k kVar, f fVar) {
        String str;
        x.i("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler handleSpanClick %d, %s", new Object[]{Integer.valueOf(kVar.type), kVar.url});
        if (fVar != null) {
            str = (String) fVar.a(kVar);
        } else {
            str = null;
        }
        if (kVar.type != 30) {
            return false;
        }
        String ou = bh.ou(kVar.url);
        if (ou.startsWith("weixin://shieldBrandMsg/") || ou.startsWith("weixin://receiveBrandMsg/")) {
            if (bh.ov(str)) {
                x.e("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler username is null");
                return true;
            }
            d jS = com.tencent.mm.ag.f.jS(str);
            if (jS == null) {
                x.e("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler BizInfo is null");
                return true;
            } else if (ou.startsWith("weixin://shieldBrandMsg/")) {
                h.a(URISpanHandlerSet.a(this.fhe), R.l.eQZ, R.l.dGO, R.l.eQY, R.l.cancel, new 1(this, jS, ou, str), null);
            } else if (ou.startsWith("weixin://receiveBrandMsg/")) {
                h.a(URISpanHandlerSet.a(this.fhe), R.l.eQX, R.l.dGO, R.l.eQW, R.l.cancel, new 2(this, jS, ou, str), null);
            }
        } else if (com.tencent.mm.pluginsdk.d.j(Uri.parse(ou))) {
            com.tencent.mm.pluginsdk.d.v(URISpanHandlerSet.a(this.fhe), str, ou);
        } else if (!ou.startsWith("weixin://receiveWeAppKFMsg")) {
            com.tencent.mm.pluginsdk.d.a(URISpanHandlerSet.a(this.fhe), ou, str, 1, ou, null);
        } else if (bh.ov(str)) {
            x.e("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler username is null, handle the BUILTIN_RECEIVE_WEAPP_KFMSG ,  the herfUrl is %s", new Object[]{ou});
            return true;
        } else {
            h.a(URISpanHandlerSet.a(this.fhe), R.l.dEc, R.l.dGO, R.l.dEb, R.l.cancel, new 3(this, str), null);
        }
        return true;
    }

    final boolean a(String str, boolean z, t tVar, Bundle bundle) {
        if (bh.ov(str) || bundle == null) {
            boolean z2;
            String str2 = "MicroMsg.URISpanHandlerSet";
            String str3 = "url is null ? %b, paramsBundle is null ? %b";
            Object[] objArr = new Object[2];
            if (str == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            objArr[0] = Boolean.valueOf(z2);
            if (bundle == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            objArr[1] = Boolean.valueOf(z2);
            x.e(str2, str3, objArr);
            return false;
        } else if (!com.tencent.mm.pluginsdk.d.j(Uri.parse(str))) {
            return false;
        } else {
            int i = bundle.getInt("key_scene", -1);
            x.d("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler jump, %d, %s", new Object[]{Integer.valueOf(i), str});
            if (i == -1) {
                i = 5;
            }
            com.tencent.mm.pluginsdk.d.a(URISpanHandlerSet.a(this.fhe), str, i, new 4(this, h.a(URISpanHandlerSet.a(this.fhe), "", true, null)));
            return true;
        }
    }
}
