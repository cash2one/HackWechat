package com.tencent.mm.ui.chatting.gallery;

import android.util.Base64;
import android.view.View;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.pluginsdk.ui.tools.f.a;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;

class j$1 implements a {
    final /* synthetic */ j yGA;

    j$1(j jVar) {
        this.yGA = jVar;
    }

    public final void hX() {
    }

    public final void onError(int i, int i2) {
        this.yGA.yGd.stop();
        String str = (String) ((View) this.yGA.yGd).getTag();
        b.z(Base64.encodeToString((d.bsC() + "[ImageGallery] on play sight error, what=" + i + ", extra=" + i2 + ", path=" + bh.az(str, "")).getBytes(), 2), "FullScreenPlaySight");
        ag.y(new 1(this, str));
        this.yGA.yGb.put(str, Boolean.valueOf(true));
    }

    public final void vh() {
        this.yGA.yGd.start();
        this.yGA.yGh.post(new 2(this));
    }

    public final int cf(int i, int i2) {
        return 0;
    }

    public final void cg(int i, int i2) {
    }
}
