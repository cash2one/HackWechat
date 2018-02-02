package com.tencent.mm.ui;

import com.tencent.mm.network.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bd.a;

class JSAPIUploadLogHelperUI$1 implements a {
    final /* synthetic */ int hZY;
    final /* synthetic */ String hpU;
    final /* synthetic */ JSAPIUploadLogHelperUI xGL;

    JSAPIUploadLogHelperUI$1(JSAPIUploadLogHelperUI jSAPIUploadLogHelperUI, String str, int i) {
        this.xGL = jSAPIUploadLogHelperUI;
        this.hpU = str;
        this.hZY = i;
    }

    public final void a(e eVar) {
        synchronized (JSAPIUploadLogHelperUI.BP()) {
            JSAPIUploadLogHelperUI.bd(true);
        }
        ar.CG().a(1, "", 0, false);
        x.cfk();
        ar.CG().a(2, this.hpU, this.hZY, ar.Hj());
    }
}
