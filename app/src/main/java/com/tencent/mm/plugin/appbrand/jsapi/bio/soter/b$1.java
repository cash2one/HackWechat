package com.tencent.mm.plugin.appbrand.jsapi.bio.soter;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity.a;

class b$1 implements a {
    final /* synthetic */ int gOK;
    final /* synthetic */ j iZy;
    final /* synthetic */ b jhA;

    b$1(b bVar, j jVar, int i) {
        this.jhA = bVar;
        this.iZy = jVar;
        this.gOK = i;
    }

    public final void b(int i, int i2, Intent intent) {
        Bundle bundle = null;
        if (i != 1000) {
            return;
        }
        b bVar;
        j jVar;
        int i3;
        if (i2 == -1) {
            x.i("MicroMsg.JsApiStartSoterAuthentication", "hy: soter auth ok");
            bVar = this.jhA;
            jVar = this.iZy;
            i3 = this.gOK;
            if (intent != null) {
                bundle = intent.getExtras();
            }
            b.a(bVar, jVar, i3, bundle, "ok");
        } else if (i2 == 1) {
            x.w("MicroMsg.JsApiStartSoterAuthentication", "hy: soter auth failed");
            bVar = this.jhA;
            jVar = this.iZy;
            i3 = this.gOK;
            if (intent != null) {
                bundle = intent.getExtras();
            }
            b.a(bVar, jVar, i3, bundle, "fail");
        } else {
            x.e("MicroMsg.JsApiStartSoterAuthentication", "hy: soter user cancelled");
            bVar = this.jhA;
            jVar = this.iZy;
            i3 = this.gOK;
            if (intent != null) {
                bundle = intent.getExtras();
            }
            b.a(bVar, jVar, i3, bundle, "cancel");
        }
    }
}
