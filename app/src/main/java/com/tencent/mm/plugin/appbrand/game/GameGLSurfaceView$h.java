package com.tencent.mm.plugin.appbrand.game;

import com.tencent.magicbrush.a.c$f;
import com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView.f;

class GameGLSurfaceView$h {
    private static String TAG = "GLThreadManager";

    private GameGLSurfaceView$h() {
    }

    public final synchronized void g(GameGLSurfaceView$g gameGLSurfaceView$g) {
        GameGLSurfaceView gameGLSurfaceView;
        c$f.i("GLThread", "exiting tid=" + gameGLSurfaceView$g.getId(), new Object[0]);
        if (gameGLSurfaceView$g.iWC) {
            gameGLSurfaceView = (GameGLSurfaceView) gameGLSurfaceView$g.iWy.get();
            if (gameGLSurfaceView != null) {
                GameGLSurfaceView.g(gameGLSurfaceView).adF();
            } else {
                c$f.i("GLThread", "onFinalize:view = null", new Object[0]);
            }
        }
        gameGLSurfaceView$g.iWS.adw();
        gameGLSurfaceView$g.adx();
        gameGLSurfaceView$g.ady();
        f c = gameGLSurfaceView$g.iWS;
        if (c.ipm != null) {
            gameGLSurfaceView = (GameGLSurfaceView) c.iWy.get();
            if (gameGLSurfaceView != null) {
                GameGLSurfaceView.c(gameGLSurfaceView).destroyContext(c.ipk, c.ipl, c.ipm);
            }
            c.ipm = null;
        }
        if (c.ipl != null) {
            c.ipk.eglTerminate(c.ipl);
            c.ipl = null;
        }
        gameGLSurfaceView$g.iWB = true;
        notifyAll();
    }
}
