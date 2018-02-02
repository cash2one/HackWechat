package com.tencent.mm.plugin.appbrand.game.d;

import com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView;
import com.tencent.mm.plugin.appbrand.game.page.c;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.l;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class b extends l {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "setPreferredFramesPerSecond";

    public final String a(j jVar, JSONObject jSONObject) {
        if (jSONObject != null) {
            GameGLSurfaceView gameGLSurfaceView;
            if (jVar == null) {
                gameGLSurfaceView = null;
            } else if (jVar.irP == null || jVar.irP.iqC == null || jVar.irP.iqC.aiT() == null || jVar.irP.iqC.aiT().aex() == null) {
                gameGLSurfaceView = null;
            } else {
                p aex = jVar.irP.iqC.aiT().aex();
                gameGLSurfaceView = (aex == null || !(aex instanceof c)) ? null : ((c) aex).iZQ;
            }
            if (gameGLSurfaceView != null) {
                x.i("MicroMsg.JsApiSetPreferredFramesPerSecond", "GameRenderer.setFPS %d", new Object[]{Integer.valueOf(jSONObject.optInt("fps", 60))});
                int max = Math.max(10, Math.min(60, max));
                com.tencent.mm.plugin.appbrand.game.e.b bVar = gameGLSurfaceView.iWq;
                if (max >= 10 && max <= 60) {
                    bVar.jao = com.tencent.mm.plugin.appbrand.game.e.b.km(max);
                }
            }
        }
        return null;
    }
}
