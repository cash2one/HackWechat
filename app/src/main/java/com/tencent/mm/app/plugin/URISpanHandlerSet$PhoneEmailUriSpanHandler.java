package com.tencent.mm.app.plugin;

import android.os.Bundle;
import com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler;
import com.tencent.mm.app.plugin.URISpanHandlerSet.a;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.b;
import com.tencent.mm.pluginsdk.t;
import com.tencent.mm.pluginsdk.ui.applet.k;
import com.tencent.mm.pluginsdk.ui.d.f;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.z.q;

@a
class URISpanHandlerSet$PhoneEmailUriSpanHandler extends BaseUriSpanHandler {
    final /* synthetic */ URISpanHandlerSet fhe;

    URISpanHandlerSet$PhoneEmailUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
        this.fhe = uRISpanHandlerSet;
        super(uRISpanHandlerSet);
    }

    final k cH(String str) {
        return null;
    }

    final int[] uC() {
        return new int[]{25, 24};
    }

    final boolean a(k kVar, f fVar) {
        if (kVar.type == 25) {
            String str = kVar.username;
            Bundle bundle = new Bundle();
            if (!(str == null || str.equals(q.FS()))) {
                bundle.putString("Contact_User", str);
                b kR = af.OD().kR(str);
                if (kR == null || bh.ov(kR.Nr())) {
                    str = null;
                } else {
                    str = bh.ou(kR.Nz()).replace(" ", "");
                }
                bundle.putString("Contact_Mobile_MD5", str);
            }
            bundle.putInt("fromScene", 1);
            com.tencent.mm.pluginsdk.ui.d.k.a(URISpanHandlerSet.a(this.fhe), kVar.url, null, bundle);
            return true;
        }
        if (kVar.type == 24) {
            com.tencent.mm.pluginsdk.ui.d.k.b(URISpanHandlerSet.a(this.fhe), kVar.url, null);
        }
        return false;
    }

    final boolean a(String str, boolean z, t tVar, Bundle bundle) {
        return false;
    }
}
