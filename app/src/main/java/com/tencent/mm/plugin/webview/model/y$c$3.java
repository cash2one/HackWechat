package com.tencent.mm.plugin.webview.model;

import android.os.Bundle;
import com.tencent.mm.plugin.webview.model.y.b;
import com.tencent.mm.plugin.webview.model.y.c;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.plugin.webview.ui.tools.widget.h.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

class y$c$3 implements a {
    final /* synthetic */ d trP;
    final /* synthetic */ b tsm;
    final /* synthetic */ y.d tsn;
    final /* synthetic */ Bundle tso;
    final /* synthetic */ int tsp;

    public y$c$3(Bundle bundle, y.d dVar, d dVar2, b bVar, int i) {
        this.tso = bundle;
        this.tsn = dVar;
        this.trP = dVar2;
        this.tsm = bVar;
        this.tsp = i;
    }

    public final void d(int i, Bundle bundle) {
        x.i("MicroMsg.OauthAuthorizeLogic", "WebAuthorizeDialog#onRevMsg resultCode %d", new Object[]{Integer.valueOf(i)});
        Bundle bundle2;
        d dVar;
        b bVar;
        int i2;
        switch (i) {
            case 1:
                bundle2 = this.tso;
                y.d dVar2 = this.tsn;
                dVar = this.trP;
                bVar = this.tsm;
                i2 = this.tsp;
                x.i("MicroMsg.OauthAuthorizeLogic", "doAcceptLogic");
                if (bundle2.getBoolean("is_call_server_when_confirm")) {
                    c.a(dVar, bundle2.getString("oauth_url"), 1, (ArrayList) bundle.getSerializable("key_scope"), bVar, true, i2);
                    return;
                }
                dVar2.Oi(bundle2.getString("redirect_url"));
                x.i("MicroMsg.OauthAuthorizeLogic", "doAcceptLogic redirectUrl: %s", new Object[]{r0});
                return;
            case 2:
            case 3:
                bundle2 = this.tso;
                y.d dVar3 = this.tsn;
                dVar = this.trP;
                bVar = this.tsm;
                i2 = this.tsp;
                x.i("MicroMsg.OauthAuthorizeLogic", "doRejectLogic");
                c.a(dVar, bundle2.getString("oauth_url"), 2, bundle == null ? new ArrayList() : (ArrayList) bundle.getSerializable("key_scope"), bVar, false, i2);
                dVar3.goBack();
                return;
            default:
                this.tsn.goBack();
                return;
        }
    }
}
