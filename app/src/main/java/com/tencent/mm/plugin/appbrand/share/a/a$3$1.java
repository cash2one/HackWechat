package com.tencent.mm.plugin.appbrand.share.a;

import android.os.Bundle;
import com.tencent.mm.plugin.appbrand.share.a.a.3;
import com.tencent.mm.sdk.platformtools.x;

class a$3$1 implements Runnable {
    final /* synthetic */ Bundle fhp;
    final /* synthetic */ 3 jJm;

    a$3$1(3 3, Bundle bundle) {
        this.jJm = 3;
        this.fhp = bundle;
    }

    public final void run() {
        this.jJm.jJl.ue(this.fhp.getString("delay_load_img_path"));
        x.i("MicroMsg.WxaShareMessageService", "onLoadImageFinishedAction(%s)", new Object[]{r0});
    }
}
