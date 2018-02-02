package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.launching.i;
import com.tencent.mm.plugin.appbrand.task.d;
import com.tencent.mm.sdk.platformtools.bh;

final class JsApiNavigateToDevMiniProgram$a implements j<JsApiNavigateToDevMiniProgram$DevPkgInfo, IPCVoid> {
    private JsApiNavigateToDevMiniProgram$a() {
    }

    public final /* synthetic */ Object at(Object obj) {
        JsApiNavigateToDevMiniProgram$DevPkgInfo jsApiNavigateToDevMiniProgram$DevPkgInfo = (JsApiNavigateToDevMiniProgram$DevPkgInfo) obj;
        ((i) f.u(i.class)).m(jsApiNavigateToDevMiniProgram$DevPkgInfo.appId, 1, jsApiNavigateToDevMiniProgram$DevPkgInfo.jom);
        if (f.Zo().a(jsApiNavigateToDevMiniProgram$DevPkgInfo.appId, 1, jsApiNavigateToDevMiniProgram$DevPkgInfo.fvR, jsApiNavigateToDevMiniProgram$DevPkgInfo.fIn, 0, bh.Wo() + 7200)) {
            d.aJ(jsApiNavigateToDevMiniProgram$DevPkgInfo.appId, 1);
        }
        return IPCVoid.gNf;
    }
}
