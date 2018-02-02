package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.x;

class a$1 implements Runnable {
    final /* synthetic */ a rmk;
    final /* synthetic */ int val$id;

    a$1(a aVar, int i) {
        this.rmk = aVar;
        this.val$id = i;
    }

    public final void run() {
        long currentTimeMillis = System.currentTimeMillis();
        SightVideoJNI.freeObj(this.val$id);
        x.d("MicroMsg.SightPlayController", "#0x%x tick: do clear video %d, use %d ms", new Object[]{Integer.valueOf(this.rmk.hashCode()), Integer.valueOf(this.val$id), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }
}
