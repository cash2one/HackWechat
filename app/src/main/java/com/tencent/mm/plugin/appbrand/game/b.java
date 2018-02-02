package com.tencent.mm.plugin.appbrand.game;

import android.content.Context;
import com.tencent.magicbrush.a.c$f;
import com.tencent.magicbrush.engine.d;
import com.tencent.magicbrush.handler.MBFontManagerJNI;
import com.tencent.magicbrush.handler.MBImageHandlerJNI;
import com.tencent.magicbrush.handler.MBJavaHandler;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView.j;
import com.tencent.mm.plugin.appbrand.game.b.a.1;
import com.tencent.mm.plugin.appbrand.game.b.a.2;
import com.tencent.mm.plugin.appbrand.game.b.b.3;
import com.tencent.mm.plugin.appbrand.game.b.b.a;
import com.tencent.mm.plugin.appbrand.game.b.b.c;
import com.tencent.mm.plugin.appbrand.game.c.f;
import com.tencent.mm.plugin.appbrand.game.c.g;
import com.tencent.mm.plugin.appbrand.game.c.h;
import com.tencent.mm.plugin.appbrand.game.c.i;
import com.tencent.mm.plugin.appbrand.page.k;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map.Entry;

public final class b implements j {
    volatile boolean gSX = false;
    j iWT;
    boolean iWU = false;
    private boolean iWV = false;
    private d iWW;
    j$b iWX;
    private long iWY = -1;
    private long iWZ = System.currentTimeMillis();
    e irP;
    private Context mContext;

    public b(j jVar) {
        this.iWT = jVar;
        this.mContext = this.iWT.getContext();
        this.irP = this.iWT.irP;
        this.iWW = new d();
        MBJavaHandler.setCallbackProxy(new 1(this));
        MBFontManagerJNI.registerFontManager(new 1(this.irP), new 2());
        e eVar = this.irP;
        com.tencent.magicbrush.handler.image.b 3 = new 3(new b$1(eVar), new com.tencent.mm.plugin.appbrand.game.b.b.2());
        3.a(new c((byte) 0), false);
        3.a(new com.tencent.mm.plugin.appbrand.game.b.b.b((byte) 0), false);
        3.a(new com.tencent.mm.plugin.appbrand.game.b.b.d(eVar, (byte) 0), true);
        3.boK = new a();
        com.tencent.magicbrush.a.a.a(new com.tencent.mm.plugin.appbrand.game.b.b.e((byte) 0));
        MBImageHandlerJNI.register(3);
        c$f.a(new d$1());
        com.tencent.magicbrush.a.c.a.a(new d$2());
        if (this.iWT.irP != null && this.iWT.irP.iqx != null) {
            AppBrandSysConfig appBrandSysConfig = this.iWT.irP.iqx;
            i iVar = i.iZn;
            x.i("MicroMsg.WAGamePerfManager", "init() called with: appId = [%s]", new Object[]{appBrandSysConfig.appId});
            iVar.mAppId = r2;
            if (iVar.iZo != null) {
                iVar.iZo.oAt.quit();
                iVar.iZo = null;
            }
            if (i.a(appBrandSysConfig.uin, appBrandSysConfig.iOJ.iNG)) {
                i.iZn.iZu = true;
                iVar = i.iZn;
                x.i("MicroMsg.WAGamePerfManager", "WAGamePerfManager.enableReport interval = [%d]", new Object[]{Integer.valueOf(appBrandSysConfig.iOJ.iNH)});
                iVar.iZs = new com.tencent.mm.plugin.appbrand.game.c.e(iVar.mAppId, r0);
            }
        }
    }

    public final void adE() {
        x.i("MicroMsg.GameRenderer", "onSurfaceCreated mInitialized:%s", new Object[]{Boolean.valueOf(this.gSX)});
        if (!this.gSX) {
            e eVar = i.iXq.iXr;
            if (eVar == null) {
                throw new IllegalStateException("There is no mainJsContext here.");
            }
            this.iWW.a(eVar.iXj, this.mContext, this.irP.mAppId);
            x.i("MicroMsg.GameRenderer", "hy: created.");
            this.iWY = bh.Wq();
            this.gSX = true;
        }
        if (this.iWX != null) {
            this.iWX.adL();
        }
        i iVar = i.iZn;
        x.i("MicroMsg.WAGamePerfManager", "WAGamePerfManager.gameStart");
        synchronized (i.iZn) {
            iVar.iZv = true;
            if (iVar.iZu) {
                f fVar = iVar.iZp;
                fVar.iZb = new ak(iVar.aek().oAt.getLooper(), new f.a(fVar, (byte) 0), true);
                long j = (long) fVar.iZe;
                fVar.iZb.J(j, j);
            }
            iVar.iZr.iZm = h.b(h.aeg());
            if (iVar.iZs != null) {
                com.tencent.mm.plugin.appbrand.game.c.e eVar2 = iVar.iZs;
                eVar2.ikI = new ak(iVar.aek().oAt.getLooper(), new com.tencent.mm.plugin.appbrand.game.c.e.1(eVar2), true);
                j = (long) (eVar2.iYL * 1000);
                eVar2.ikI.J(j, j);
            }
            iVar.iZw = System.currentTimeMillis();
        }
    }

    public final void bE(int i, int i2) {
        x.i("MicroMsg.GameRenderer", "[alex] WindowSize onSurfaceChanged width = [%d], height = [%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (this.iWW != null) {
            this.iWW.bnG.Changed(i, i2);
        }
        l.iXJ.bF(i, i2);
        if (this.irP != null) {
            e eVar = this.irP;
            k kVar = eVar.iqN;
            x.i("MicroMsg.AppBrandOnWindowSizeChangedEvent", "hy: on resizeWindow");
            kVar.a(eVar.iqB).afs();
        }
    }

    public final void cy(boolean z) {
        if (this.iWW != null) {
            boolean Render = this.iWW.bnG.Render();
            if (!z) {
                if (Render) {
                    if (!this.iWU) {
                        x.w("MicroMsg.GameRenderer", "hy: onDrawFrame mFirstFrameRendered. using %d ms", new Object[]{Long.valueOf(bh.bA(this.iWY))});
                        this.iWU = true;
                        this.iWT.adV();
                    }
                } else if (!this.iWV) {
                    this.iWV = true;
                    if (this.irP != null) {
                        this.irP.iqM.o(9, System.currentTimeMillis() - this.iWZ);
                    }
                }
                this.iWT.iWm = Render;
            }
            g gVar = i.iZn.iZq;
            if (!gVar.iZl) {
                long currentTimeMillis;
                if (gVar.iZi <= 0) {
                    currentTimeMillis = System.currentTimeMillis();
                    gVar.iZi = currentTimeMillis;
                    gVar.iZg = currentTimeMillis;
                    return;
                }
                gVar.iZh++;
                if (gVar.iZh % 20 <= 0) {
                    currentTimeMillis = System.currentTimeMillis();
                    gVar.iZj = 20000.0d / ((double) (currentTimeMillis - gVar.iZg));
                    if (gVar.iZk <= 0.0d) {
                        gVar.iZk = gVar.iZj;
                    } else if (gVar.iZj < gVar.iZk) {
                        gVar.iZk = gVar.iZj;
                    }
                    gVar.iZg = currentTimeMillis;
                }
            }
        }
    }

    public final void onCreateEglSurface() {
        x.i("MicroMsg.GameRenderer", "onCreateEglSurface ");
        if (this.iWW != null) {
            this.iWW.bnG.onCreateEglSurface();
        }
    }

    public final void onResume() {
        x.i("MicroMsg.GameRenderer", "onResume ");
        if (this.iWW != null) {
            this.iWW.bnG.Resume();
        }
    }

    public final void onPause() {
        x.i("MicroMsg.GameRenderer", "onPause ");
        if (this.iWW != null) {
            this.iWW.bnG.Pause();
        }
    }

    public final void adF() {
        x.i("MicroMsg.GameRenderer", "onFinalize ");
        if (this.iWW != null) {
            this.iWW.bnG.Finalize();
        }
        i iVar = i.iZn;
        x.i("MicroMsg.WAGamePerfManager", "WAGamePerfManager.gameDestroy");
        synchronized (i.iZn) {
            iVar.iZv = false;
        }
        x.i("MicroMsg.WAGamePerfManager", "release() called");
        if (iVar.iZo != null) {
            iVar.iZo.oAt.quit();
            iVar.iZo = null;
        }
        if (iVar.iZs != null) {
            com.tencent.mm.plugin.appbrand.game.c.e eVar = iVar.iZs;
            if (eVar.ikI != null) {
                eVar.ikI.TG();
            }
            iVar.iZs = null;
        }
        iVar.iZq.iZl = true;
        if (iVar.iZu) {
            f fVar = iVar.iZp;
            synchronized (fVar) {
                if (fVar.iZb != null) {
                    fVar.iZb.TG();
                }
            }
            iVar.iZu = false;
        }
        iVar.iZr.iZm = Integer.MAX_VALUE;
        i iVar2 = i.iXq;
        x.i("MicroMsg.V8JsVmManager", "GameRenderer.disposeJsVm start");
        for (Entry entry : iVar2.iXt.entrySet()) {
            if (iVar2.iXr != entry.getValue()) {
                com.tencent.mm.plugin.appbrand.g.a aVar = (com.tencent.mm.plugin.appbrand.g.a) entry.getValue();
                if (aVar != null) {
                    aVar.destroy();
                }
            }
        }
        iVar2.iXt.clear();
        if (iVar2.iXr != null) {
            iVar2.iXr.destroy();
            iVar2.iXr = null;
        }
        x.i("MicroMsg.V8JsVmManager", "GameRenderer.disposeJsVm finished");
    }
}
