package com.tencent.mm.plugin.appbrand.game;

import com.tencent.magicbrush.a.c$f;
import com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView.f;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;

class GameGLSurfaceView$g extends Thread {
    public boolean iWA;
    public boolean iWB;
    public boolean iWC;
    public boolean iWD;
    public boolean iWE;
    public boolean iWF;
    boolean iWG;
    private boolean iWH;
    boolean iWI;
    boolean iWJ;
    boolean iWK;
    boolean iWL;
    private boolean iWM;
    public boolean iWN = true;
    private boolean iWO = false;
    public boolean iWP;
    LinkedList<Runnable> iWQ = new LinkedList();
    boolean iWR = true;
    private f iWS;
    private WeakReference<GameGLSurfaceView> iWy;
    public boolean iqR;
    int mHeight = 0;
    int mRenderMode = 1;
    int mWidth = 0;

    GameGLSurfaceView$g(WeakReference<GameGLSurfaceView> weakReference) {
        this.iWy = weakReference;
    }

    public final void run() {
        setName("GLThread " + getId());
        c$f.i("GLThread", "starting tid=" + getId(), new Object[0]);
        h.iXm.adJ();
        try {
            adz();
        } catch (InterruptedException e) {
        } finally {
            GameGLSurfaceView.adv().g(this);
        }
        h.iXm.adK();
        h hVar = h.iXm;
        hVar.iXn.clear();
        hVar.iXo = null;
    }

    private void adx() {
        if (this.iWK) {
            this.iWK = false;
            this.iWL = false;
        }
    }

    private void ady() {
        if (this.iWJ) {
            this.iWJ = false;
            GameGLSurfaceView.adv().notifyAll();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void adz() {
        this.iWS = new f(this.iWy);
        this.iWJ = false;
        this.iWK = false;
        synchronized (GameGLSurfaceView.adv()) {
            this.iWO = false;
        }
        Object obj = null;
        Object obj2 = null;
        Object obj3 = null;
        Object obj4 = null;
        Object obj5 = null;
        Object obj6 = null;
        Object obj7 = null;
        Object obj8 = null;
        int i = 0;
        int i2 = 0;
        Runnable runnable = null;
        while (true) {
            synchronized (GameGLSurfaceView.adv()) {
                Object obj9 = obj4;
                obj4 = obj3;
                obj3 = obj;
                obj = obj2;
                obj2 = obj7;
                obj7 = obj8;
                while (!this.iWA) {
                    Object obj10;
                    if (this.iqR || !this.iWL || this.iWQ.isEmpty()) {
                        boolean z;
                        GameGLSurfaceView gameGLSurfaceView;
                        Object[] objArr;
                        Object[] objArr2;
                        if (this.iqR != this.iWD) {
                            z = this.iWD;
                            this.iqR = this.iWD;
                            if (z) {
                                gameGLSurfaceView = (GameGLSurfaceView) this.iWy.get();
                                if (gameGLSurfaceView != null) {
                                    GameGLSurfaceView.g(gameGLSurfaceView).onPause();
                                }
                            } else {
                                gameGLSurfaceView = (GameGLSurfaceView) this.iWy.get();
                                if (gameGLSurfaceView != null) {
                                    GameGLSurfaceView.g(gameGLSurfaceView).onResume();
                                }
                            }
                            GameGLSurfaceView.adv().notifyAll();
                            objArr = new Object[0];
                            c$f.i("GLThread", "mPaused is now " + this.iqR + " tid=" + getId(), objArr);
                        } else {
                            z = false;
                        }
                        if (this.iWM) {
                            c$f.i("GLThread", "releasing EGL context because asked to tid=" + getId(), new Object[0]);
                            adx();
                            ady();
                            this.iWM = false;
                            obj7 = 1;
                        }
                        if (obj9 != null) {
                            adx();
                            ady();
                            obj9 = null;
                        }
                        if (z && this.iWK) {
                            objArr = new Object[0];
                            c$f.i("GLThread", "releasing EGL surface because paused tid=" + getId(), objArr);
                            adx();
                        }
                        if (z && this.iWJ) {
                            boolean z2;
                            gameGLSurfaceView = (GameGLSurfaceView) this.iWy.get();
                            if (gameGLSurfaceView == null) {
                                z2 = false;
                            } else {
                                z2 = GameGLSurfaceView.h(gameGLSurfaceView);
                            }
                            if (!z2) {
                                ady();
                                objArr2 = new Object[0];
                                c$f.i("GLThread", "releasing EGL context because paused tid=" + getId(), objArr2);
                            }
                        }
                        if (!(this.iWG || this.iWI)) {
                            objArr2 = new Object[0];
                            c$f.i("GLThread", "noticed surfaceView surface lost tid=" + getId(), objArr2);
                            if (this.iWK) {
                                adx();
                            }
                            this.iWI = true;
                            this.iWH = false;
                            GameGLSurfaceView.adv().notifyAll();
                        }
                        if (this.iWG && this.iWI) {
                            objArr2 = new Object[0];
                            c$f.i("GLThread", "noticed surfaceView surface acquired tid=" + getId(), objArr2);
                            this.iWI = false;
                            GameGLSurfaceView.adv().notifyAll();
                        }
                        if (obj2 != null) {
                            c$f.i("GLThread", "sending render notification tid=" + getId(), new Object[0]);
                            this.iWO = false;
                            this.iWP = true;
                            GameGLSurfaceView.adv().notifyAll();
                            obj2 = null;
                        }
                        if (adB()) {
                            int i3;
                            if (!this.iWJ) {
                                if (obj7 != null) {
                                    obj8 = null;
                                    if (this.iWJ || this.iWK) {
                                        obj7 = obj5;
                                        obj5 = obj4;
                                        obj4 = obj;
                                    } else {
                                        this.iWK = true;
                                        obj7 = 1;
                                        obj5 = 1;
                                        obj4 = 1;
                                    }
                                    if (this.iWK) {
                                        obj10 = obj3;
                                        obj3 = obj4;
                                        obj4 = obj10;
                                    } else {
                                        if (this.iWR) {
                                            obj7 = 1;
                                            i = this.mWidth;
                                            i2 = this.mHeight;
                                            this.iWO = true;
                                            c$f.i("GLThread", "noticing that we want render notification tid=" + getId(), new Object[0]);
                                            obj4 = 1;
                                            this.iWR = false;
                                        }
                                        this.iWN = false;
                                        GameGLSurfaceView.adv().notifyAll();
                                        if (this.iWO) {
                                            obj = obj5;
                                            obj5 = obj6;
                                            obj6 = obj2;
                                            obj2 = obj3;
                                            obj3 = obj9;
                                            obj9 = obj4;
                                            obj4 = obj7;
                                            obj7 = obj8;
                                        } else {
                                            obj = obj5;
                                            i3 = 1;
                                            obj6 = obj2;
                                            obj2 = obj3;
                                            obj3 = obj9;
                                            obj9 = obj4;
                                            obj4 = obj7;
                                            obj7 = obj8;
                                        }
                                    }
                                } else {
                                    try {
                                        f fVar = this.iWS;
                                        fVar.ipk = (EGL10) EGLContext.getEGL();
                                        fVar.ipl = fVar.ipk.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
                                        if (fVar.ipl == EGL10.EGL_NO_DISPLAY) {
                                            throw new RuntimeException("eglGetDisplay failed");
                                        }
                                        int[] iArr = new int[2];
                                        if (fVar.ipk.eglInitialize(fVar.ipl, iArr)) {
                                            gameGLSurfaceView = (GameGLSurfaceView) fVar.iWy.get();
                                            if (gameGLSurfaceView == null) {
                                                fVar.iWz = null;
                                                fVar.ipm = null;
                                            } else {
                                                fVar.iWz = GameGLSurfaceView.b(gameGLSurfaceView).chooseConfig(fVar.ipk, fVar.ipl);
                                                fVar.ipm = GameGLSurfaceView.c(gameGLSurfaceView).createContext(fVar.ipk, fVar.ipl, fVar.iWz);
                                            }
                                            if (fVar.ipm == null || fVar.ipm == EGL10.EGL_NO_CONTEXT) {
                                                fVar.ipm = null;
                                                f.aw("createContext", fVar.ipk.eglGetError());
                                            }
                                            fVar.ipn = null;
                                            this.iWJ = true;
                                            obj3 = 1;
                                            GameGLSurfaceView.adv().notifyAll();
                                        } else {
                                            throw new RuntimeException("eglInitialize failed");
                                        }
                                    } catch (RuntimeException e) {
                                        GameGLSurfaceView.adv().notifyAll();
                                        throw e;
                                    }
                                }
                            }
                            obj8 = obj7;
                            if (this.iWJ) {
                            }
                            obj7 = obj5;
                            obj5 = obj4;
                            obj4 = obj;
                            if (this.iWK) {
                                obj10 = obj3;
                                obj3 = obj4;
                                obj4 = obj10;
                            } else {
                                if (this.iWR) {
                                    obj7 = 1;
                                    i = this.mWidth;
                                    i2 = this.mHeight;
                                    this.iWO = true;
                                    c$f.i("GLThread", "noticing that we want render notification tid=" + getId(), new Object[0]);
                                    obj4 = 1;
                                    this.iWR = false;
                                }
                                this.iWN = false;
                                GameGLSurfaceView.adv().notifyAll();
                                if (this.iWO) {
                                    obj = obj5;
                                    obj5 = obj6;
                                    obj6 = obj2;
                                    obj2 = obj3;
                                    obj3 = obj9;
                                    obj9 = obj4;
                                    obj4 = obj7;
                                    obj7 = obj8;
                                } else {
                                    obj = obj5;
                                    i3 = 1;
                                    obj6 = obj2;
                                    obj2 = obj3;
                                    obj3 = obj9;
                                    obj9 = obj4;
                                    obj4 = obj7;
                                    obj7 = obj8;
                                }
                            }
                        } else {
                            obj8 = obj7;
                            obj7 = obj5;
                            obj5 = obj4;
                            obj4 = obj3;
                            obj3 = obj;
                        }
                        if (adC()) {
                            obj = obj5;
                            obj5 = obj6;
                            obj6 = obj2;
                            obj2 = obj4;
                            obj4 = obj7;
                            obj7 = obj8;
                            obj10 = obj9;
                            obj9 = obj3;
                            obj3 = obj10;
                        } else {
                            GameGLSurfaceView.adv().wait();
                            obj = obj3;
                            obj3 = obj4;
                            obj4 = obj5;
                            obj5 = obj7;
                            obj7 = obj8;
                        }
                    } else {
                        runnable = (Runnable) this.iWQ.remove(0);
                        obj10 = obj2;
                        obj2 = obj3;
                        obj3 = obj9;
                        obj9 = obj;
                        obj = obj4;
                        obj4 = obj5;
                        obj5 = obj6;
                        obj6 = obj10;
                    }
                }
                return;
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void adA() {
        Runnable runnable;
        Runnable runnable2 = null;
        while (true) {
            synchronized (GameGLSurfaceView.adv()) {
                if (!adC()) {
                    return;
                } else if (this.iWE) {
                    this.iWE = false;
                    return;
                } else if (this.iWQ.isEmpty()) {
                    runnable = runnable2;
                } else {
                    runnable = (Runnable) this.iWQ.remove(0);
                }
            }
        }
        GameGLSurfaceView.i(r0).cE(false);
        GameGLSurfaceView.i(r0).aeT();
        runnable2 = runnable;
    }

    final boolean adB() {
        return !this.iqR && this.iWG && !this.iWH && this.mWidth > 0 && this.mHeight > 0 && (this.iWN || this.mRenderMode == 1);
    }

    private boolean adC() {
        return this.iqR && this.iWF && this.mWidth > 0 && this.mHeight > 0 && (!this.iWN || this.mRenderMode == 1);
    }

    public final int getRenderMode() {
        int i;
        synchronized (GameGLSurfaceView.adv()) {
            i = this.mRenderMode;
        }
        return i;
    }

    public final void adD() {
        synchronized (GameGLSurfaceView.adv()) {
            c$f.i("GLThread", "requestExitAndWait tid=" + getId(), new Object[0]);
            this.iWA = true;
            this.iWE = true;
            GameGLSurfaceView.adv().notifyAll();
            while (!this.iWB) {
                try {
                    GameGLSurfaceView.adv().wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
