package com.tencent.mm.plugin.appbrand;

import android.graphics.Bitmap;
import android.os.Looper;
import com.tencent.magicbrush.handler.image.MBCanvasContentHolder;
import com.tencent.mm.plugin.appbrand.game.e.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

public final class s {
    public static void g(e eVar) {
        if (eVar == null) {
            x.e("MicroMsg.AppBrand.RuntimeRestartHelper", "restart skip with Null runtime");
        } else if (eVar.gSX) {
            h(eVar);
        } else {
            x.e("MicroMsg.AppBrand.RuntimeRestartHelper", "restart %s, not initialized", new Object[]{eVar.mAppId});
        }
    }

    static void h(final e eVar) {
        if (ag.isMainThread()) {
            e.post(new Runnable() {
                public final void run() {
                    s.h(eVar);
                }
            }, String.format("performRestart$%s", new Object[]{eVar.mAppId}));
            return;
        }
        Bitmap bitmap;
        if (eVar.Yz()) {
            MBCanvasContentHolder aeQ = a.jah.aeQ();
            bitmap = aeQ == null ? null : aeQ.content;
        } else {
            bitmap = (Bitmap) new 3(eVar).b(new af(Looper.getMainLooper()));
        }
        ag.y(new 2(eVar, bitmap));
    }
}
