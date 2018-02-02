package com.tencent.mm.plugin.appbrand.jsapi.video;

import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.c.d.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandOnlineVideoProxy.OnlineVideoProxy;
import com.tencent.mm.sdk.platformtools.x;

class AppBrandOnlineVideoProxy$OnlineVideoProxy$1 implements c {
    final /* synthetic */ OnlineVideoProxy jsh;

    AppBrandOnlineVideoProxy$OnlineVideoProxy$1(OnlineVideoProxy onlineVideoProxy) {
        this.jsh = onlineVideoProxy;
    }

    public final void bx(int i, int i2) {
        this.jsh.jsd = i;
        this.jsh.jse = i2;
        this.jsh.jsb = 10;
        OnlineVideoProxy.a(this.jsh);
    }

    public final void by(int i, int i2) {
        this.jsh.jsd = i;
        this.jsh.jse = i2;
        this.jsh.jsb = 11;
        OnlineVideoProxy.b(this.jsh);
    }

    public final void bz(int i, int i2) {
        this.jsh.jsd = i;
        this.jsh.jse = i2;
        this.jsh.jsb = 12;
        OnlineVideoProxy.c(this.jsh);
    }

    public final void K(String str, int i) {
        x.i("MicroMsg.AppBrandOnlineVideoProxy", "on finish [%s %d]", new Object[]{str, Integer.valueOf(i)});
        this.jsh.jsd = i;
        this.jsh.jsb = 13;
        f.Zr().qi(this.jsh.hTu);
        OnlineVideoProxy.d(this.jsh);
    }
}
