package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a;
import com.tencent.mm.sdk.platformtools.x;

class AdLandingPagesProxy$b implements a {
    public long id;
    final /* synthetic */ AdLandingPagesProxy qSq;

    private AdLandingPagesProxy$b(AdLandingPagesProxy adLandingPagesProxy) {
        this.qSq = adLandingPagesProxy;
    }

    public final void start() {
        this.qSq.CLIENT_CALL("start", new Object[]{Long.valueOf(this.id)});
    }

    public final void wy(int i) {
        x.v("AdLandingPagesProxy", "progress %d", Integer.valueOf(i));
        this.qSq.CLIENT_CALL("progress", new Object[]{Long.valueOf(this.id), Integer.valueOf(i)});
    }

    public final void bus() {
        this.qSq.CLIENT_CALL("paused", new Object[]{Long.valueOf(this.id)});
    }

    public final void but() {
        this.qSq.CLIENT_CALL("stopped", new Object[]{Long.valueOf(this.id)});
    }

    public final void buu() {
        this.qSq.CLIENT_CALL("succeed", new Object[]{Long.valueOf(this.id)});
    }

    public final void buv() {
        this.qSq.CLIENT_CALL("failed", new Object[]{Long.valueOf(this.id)});
    }

    public final void buw() {
        this.qSq.CLIENT_CALL("resumed", new Object[]{Long.valueOf(this.id)});
    }
}
