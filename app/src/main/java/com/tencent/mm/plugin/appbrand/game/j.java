package com.tencent.mm.plugin.appbrand.game;

import android.content.Context;
import android.opengl.GLSurfaceView.EGLConfigChooser;
import android.view.MotionEvent;
import com.tencent.mm.plugin.appbrand.config.h;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView.b;
import com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView.d;
import com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView.g;
import com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView.k;
import com.tencent.mm.plugin.appbrand.jsapi.n;
import com.tencent.mm.sdk.platformtools.x;

public final class j extends GameGLSurfaceView {
    public b iXv;
    private a iXw;
    private n iXx;
    private d iXy = new d((byte) 0);
    e irP;

    public j(Context context, e eVar, b bVar, a aVar) {
        super(context);
        x.i("MicroMsg.WAGameView", "new GameView");
        this.irP = eVar;
        super.adu();
        this.iWo = 2;
        EGLConfigChooser bVar2 = new b(this, 8, 8, 8, 8, 16, 8);
        super.adu();
        this.iWi = bVar2;
        this.iWp = true;
        this.iXv = new b(this);
        this.iXv.iWX = bVar;
        this.iXw = aVar;
        com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView.j jVar = this.iXv;
        super.adu();
        if (this.iWi == null) {
            this.iWi = new k(this);
        }
        if (this.iWj == null) {
            this.iWj = new GameGLSurfaceView$c(this);
        }
        if (this.iWk == null) {
            this.iWk = new d((byte) 0);
        }
        this.iWh = jVar;
        this.iWg = new g(this.iWf);
        this.iWg.start();
        setOnTouchListener(new 1(this));
        if (h.qH(this.irP.mAppId)) {
            postDelayed(new 2(this), 30000);
        }
        this.iXx = new 3(this, context.getResources().getDisplayMetrics().density);
    }

    final void adV() {
        x.i("MicroMsg.WAGameView", "hy: first rendered: %s ", new Object[]{this.irP.mAppId});
        if (this.iXw != null) {
            this.iXw.adV();
            this.iXw = null;
        }
    }

    private boolean x(MotionEvent motionEvent) {
        StringBuilder stringBuilder = null;
        if (this.iXx == null || motionEvent == null || !this.iXv.gSX) {
            return false;
        }
        n nVar = this.iXx;
        if (motionEvent != null) {
            int i;
            switch (motionEvent.getActionMasked()) {
                case 0:
                case 5:
                    i = 0;
                    break;
                case 1:
                case 6:
                    i = 2;
                    break;
                case 2:
                    i = 1;
                    break;
                case 3:
                    i = 3;
                    break;
                default:
                    i = -1;
                    break;
            }
            if (i != -1) {
                int i2;
                nVar.jcp.setLength(0);
                nVar.jcp = nVar.e(nVar.jcp);
                nVar.jcp.append("[[");
                int pointerCount = motionEvent.getPointerCount();
                for (i2 = 0; i2 < pointerCount; i2++) {
                    nVar.jcp.append(motionEvent.getPointerId(i2)).append(",").append(motionEvent.getX(i2) / nVar.jco).append(",").append(motionEvent.getY(i2) / nVar.jco).append(",").append(motionEvent.getPressure(i2));
                    if (i2 != pointerCount - 1) {
                        nVar.jcp.append(",");
                    }
                }
                nVar.jcp.append("],[");
                if (i == 1) {
                    for (i2 = 0; i2 < pointerCount; i2++) {
                        nVar.jcp.append(i2);
                        if (i2 != pointerCount - 1) {
                            nVar.jcp.append(",");
                        }
                    }
                } else {
                    nVar.jcp.append(motionEvent.getActionIndex());
                }
                nVar.jcp.append("],");
                nVar.jcp.append(motionEvent.getEventTime()).append(",");
                nVar.jcp.append(i).append("]");
                nVar.jcp = nVar.f(nVar.jcp);
                stringBuilder = nVar.jcp;
            }
        }
        if (stringBuilder == null || stringBuilder.length() == 0) {
            return false;
        }
        c cVar = (c) this.iXy.aeU();
        cVar.iXA = stringBuilder.toString();
        cVar.iXB = this.irP.iqB.irR;
        queueEvent(cVar);
        return true;
    }
}
