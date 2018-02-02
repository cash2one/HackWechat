package com.tencent.mm.plugin.appbrand.game;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.magicbrush.handler.c;
import com.tencent.mm.plugin.appbrand.appcache.ah;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.game.c.i;
import com.tencent.mm.plugin.appbrand.game.e.g;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements c {
    final /* synthetic */ b iXa;

    b$1(b bVar) {
        this.iXa = bVar;
    }

    public final byte[] bz(String str) {
        return this.iXa.irP == null ? null : ah.e(this.iXa.irP, str);
    }

    public final String r(String str, String str2) {
        return AppBrandLocalMediaObjectManager.genMediaFilePath(str, str2);
    }

    public final void s(String str, String str2) {
        if (this.iXa.irP != null) {
            if (!(this.iXa.iWU || this.iXa.irP.iqx.iOI.iGK == 0)) {
                x.w("MicroMsg.GameRenderer", "v8_exception mFirstFrameRendered");
                this.iXa.iWU = true;
                this.iXa.iWT.adV();
            }
            x.e("MicroMsg.GameRenderer", "v8_exception message = [%s], stackTrace = [%s]", new Object[]{str, str2});
            this.iXa.irP.iqB.h("onError", "{'message':'" + g.rV(str) + "', 'stack': '" + g.rV(str2) + "'}", 0);
        }
    }

    public final void onScreenCanvasContextTypeSet(boolean z) {
        i iVar = i.iZn;
        x.i("MicroMsg.WAGamePerfManager", "setGameMainCanvasType() called with: is2D = [" + z + "]");
        iVar.iZt = Boolean.valueOf(z);
    }

    public final void onShaderCompileError(String str) {
        x.e("MicroMsg.GameRenderer", "hy: onShaderCompileError: %s", new Object[]{str});
        com.tencent.mm.plugin.report.service.g.pQN.h(808, 0);
        com.tencent.mm.plugin.report.service.g.pQN.h(15134, new Object[]{Build.MANUFACTURER, Build.MODEL, VERSION.INCREMENTAL, str});
    }
}
