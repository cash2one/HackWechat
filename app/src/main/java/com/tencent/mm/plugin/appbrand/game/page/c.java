package com.tencent.mm.plugin.appbrand.game.page;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.magicbrush.handler.image.MBCanvasContentHolder;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.appbrand.config.d$b;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView;
import com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView.g;
import com.tencent.mm.plugin.appbrand.game.c.d;
import com.tencent.mm.plugin.appbrand.game.j;
import com.tencent.mm.plugin.appbrand.menu.m;
import com.tencent.mm.plugin.appbrand.p.l;
import com.tencent.mm.plugin.appbrand.page.AppBrandActionHeaderLayout;
import com.tencent.mm.plugin.appbrand.page.AppBrandActionSingleHeaderView;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.q$e;
import com.tencent.mm.plugin.appbrand.q.f;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

@SuppressLint({"ViewConstructor"})
public final class c extends p implements com.tencent.mm.plugin.appbrand.game.c {
    private boolean Vx = true;
    private b iZO;
    WAGamePageViewContainerLayout iZP;
    public j iZQ;
    ImageView iZR;
    private u iZS;
    private final ConcurrentLinkedQueue<Runnable> iZT = new ConcurrentLinkedQueue();
    private Bitmap iZU = null;
    private final Object iZV = new Object();
    private String iZW;
    private String mUrl;

    static /* synthetic */ boolean a(WAGamePageViewContainerLayout.b bVar) {
        return bVar == WAGamePageViewContainerLayout.b.jac || bVar == WAGamePageViewContainerLayout.b.jae;
    }

    static /* synthetic */ boolean b(WAGamePageViewContainerLayout.b bVar) {
        return bVar == WAGamePageViewContainerLayout.b.jad || bVar == WAGamePageViewContainerLayout.b.jaf;
    }

    c(Context context, e eVar) {
        a(context, eVar);
        this.jEc.f(eVar);
        this.iZO = eVar.iqB.irR;
        com.tencent.magicbrush.engine.c.az(ac.cfu().getBoolean("appbrandgame_open_v8debug", false));
    }

    protected final void initView() {
        x.i("AppBrandGame.WAGamePageView", "new Rendder GameView");
        initActionBar();
        this.iZP = new WAGamePageViewContainerLayout(this.mContext);
        aey();
        View frameLayout = new FrameLayout(this.mContext);
        this.iZP.addView(frameLayout, new LayoutParams(-1, -1));
        this.iZS = new a(frameLayout);
        this.iZS.a(aiX());
        float f = this.mContext.getResources().getDisplayMetrics().density;
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.gravity = 8388661;
        layoutParams.rightMargin = a.ab(this.mContext, q$e.isJ);
        layoutParams.topMargin = a.ab(this.mContext, q$e.isK);
        this.iZP.addView(this.jDN.getActionView(), layoutParams);
        x(m.jAM, false);
        if (this.irP.iqx.iOi) {
            d aee = d.aee();
            FrameLayout frameLayout2 = this.iZP;
            if (Looper.myLooper() != Looper.getMainLooper()) {
                throw new IllegalStateException("You can only init GameInspector in main thread.");
            } else if (aee.mState == 0) {
                aee.mContext = frameLayout2.getContext();
                aee.iYA = new com.tencent.mm.plugin.appbrand.game.c.c(aee.mContext);
                aee.iYA.setBackground(aee.mContext.getResources().getDrawable(f.isZ));
                aee.iYB = new com.tencent.mm.plugin.appbrand.game.c.b(aee.mContext);
                frameLayout2.setClipChildren(false);
                float f2 = aee.mContext.getResources().getDisplayMetrics().density;
                if (aee.iYB != null) {
                    frameLayout2.addView(aee.iYB, new LayoutParams(-1, -1));
                    ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-2, -2);
                    layoutParams2.gravity = 8388693;
                    layoutParams2.bottomMargin = (int) (25.0f * f2);
                    int i = (int) (f2 * 15.0f);
                    layoutParams2.rightMargin = i;
                    layoutParams2.leftMargin = i;
                    frameLayout2.addView(aee.iYB.iYq, layoutParams2);
                }
                if (aee.iYA != null) {
                    frameLayout2.addView(aee.iYA, new LayoutParams(-2, -2));
                }
                aee.mState = 1;
            }
        }
        this.iZR = new ImageView(this.mContext);
        this.iZP.addView(this.iZR, new LayoutParams(-1, -1));
    }

    final void aey() {
        if (ag.isMainThread()) {
            this.iZQ = new j(this.mContext, this.irP, new 2(this), new 3(this));
            this.iZP.addView(this.iZQ, 0, new LayoutParams(-1, -1));
            return;
        }
        ag.y(new 1(this));
    }

    public final void h(String str, String str2, int i) {
        x.d("AppBrandGame.WAGamePageView", "dispatch event %s, data %s, src %d", new Object[]{str, str2, Integer.valueOf(i)});
    }

    public final b YR() {
        return this.iZO;
    }

    public final View getContentView() {
        return this.iZP;
    }

    public final void rQ(String str) {
        this.jEc.ua(str);
        this.mUrl = str;
        this.iZW = l.uB(str);
        x.i("AppBrandGame.WAGamePageView", "loadURL url : " + str);
    }

    public final void e(Runnable runnable) {
        o(runnable);
    }

    final void o(Runnable runnable) {
        if (this.iZQ != null) {
            if (this.iZT.size() > 0) {
                synchronized (this.iZT) {
                    if (this.iZT.size() > 0) {
                        x.v("AppBrandGame.WAGamePageView", "hy: try to render %d", new Object[]{Integer.valueOf(this.iZT.size())});
                        Iterator it = this.iZT.iterator();
                        while (it.hasNext()) {
                            Runnable runnable2 = (Runnable) it.next();
                            if (runnable2 != null) {
                                this.iZQ.queueEvent(runnable2);
                            }
                        }
                        this.iZT.clear();
                    }
                }
            }
            if (runnable != null) {
                this.iZQ.queueEvent(runnable);
                return;
            }
            return;
        }
        synchronized (this.iZT) {
            x.v("AppBrandGame.WAGamePageView", "hy: add to task first");
            if (runnable != null) {
                this.iZT.add(runnable);
            }
        }
    }

    public final void a(String str, String str2, int[] iArr) {
        this.irP.iqB.h(str, str2, hashCode());
    }

    public final boolean isRunning() {
        return this.Vx;
    }

    public final void show() {
        this.iZP.setVisibility(0);
    }

    public final void hide() {
        this.iZP.setVisibility(4);
    }

    protected final void aez() {
        this.jEc.ajQ();
    }

    protected final void aeA() {
        x.i("AppBrandGame.WAGamePageView", "hy: on perform foreground");
        this.jEc.aga();
        aeD();
        g gVar = this.iZQ.iWg;
        synchronized (GameGLSurfaceView.iWe) {
            com.tencent.magicbrush.a.c.f.i("GLThread", "onResume tid=" + gVar.getId(), new Object[0]);
            gVar.iWD = false;
            gVar.iWF = false;
            gVar.iWN = true;
            gVar.iWP = false;
            GameGLSurfaceView.iWe.notifyAll();
            while (!gVar.iWB && gVar.iqR && !gVar.iWP) {
                com.tencent.magicbrush.a.c.f.i("Main thread", "onResume waiting for !mPaused.", new Object[0]);
                try {
                    GameGLSurfaceView.iWe.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        super.cB(this.jDU);
    }

    protected final void aeB() {
        x.i("AppBrandGame.WAGamePageView", "hy: on perform background");
        this.jEc.afA();
        g gVar = this.iZQ.iWg;
        synchronized (GameGLSurfaceView.iWe) {
            com.tencent.magicbrush.a.c.f.i("GLThread", "onPauseAlsoDoDraw tid=" + gVar.getId(), new Object[0]);
            gVar.iWF = true;
            gVar.iWD = true;
            GameGLSurfaceView.iWe.notifyAll();
            while (!gVar.iWB && !gVar.iqR) {
                com.tencent.magicbrush.a.c.f.i("Main thread", "onPause waiting for mPaused.", new Object[0]);
                try {
                    GameGLSurfaceView.iWe.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        if (this.jDP != null) {
            this.jDP.dismiss();
        }
    }

    protected final void aeC() {
        this.Vx = false;
        this.jEc.onDestroy();
        aeD();
        g gVar = this.iZQ.iWg;
        synchronized (GameGLSurfaceView.iWe) {
            com.tencent.magicbrush.a.c.f.i("GLThread", "requestExitAndWaitForDestory tid=" + gVar.getId(), new Object[0]);
            gVar.iWA = true;
            gVar.iWC = true;
            gVar.iWE = true;
            GameGLSurfaceView.iWe.notifyAll();
            while (!gVar.iWB) {
                try {
                    GameGLSurfaceView.iWe.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        d.release();
    }

    private void aeD() {
        synchronized (this.iZV) {
            if (!(this.iZU == null || this.iZU.isRecycled())) {
                x.i("AppBrandGame.WAGamePageView", "hy: recycling captured screen");
                this.iZU.recycle();
                this.iZU = null;
            }
        }
    }

    protected final void aeE() {
        aeC();
    }

    public final u aeF() {
        return this.iZS;
    }

    public final boolean aeG() {
        return false;
    }

    public final void rR(String str) {
    }

    public final void kg(int i) {
    }

    public final void rS(String str) {
    }

    public final String aeH() {
        return null;
    }

    public final void rT(String str) {
    }

    public final void kh(int i) {
    }

    public final void cA(boolean z) {
    }

    protected final void cB(boolean z) {
        super.cB(z);
    }

    protected final void aeI() {
    }

    public final void aeJ() {
    }

    public final void aeK() {
    }

    public final void cC(boolean z) {
    }

    public final void be(String str, String str2) {
    }

    public final boolean aeL() {
        return false;
    }

    public final void cD(boolean z) {
    }

    public final void rU(String str) {
        if (this.mContext instanceof Activity) {
            Window window = ((Activity) this.mContext).getWindow();
            if (window != null) {
                com.tencent.mm.plugin.appbrand.ui.j.a(window, "black".equals(str));
            }
        }
    }

    public final void ki(int i) {
    }

    public final FrameLayout aeM() {
        return this.iZP;
    }

    public final View aeN() {
        View appBrandActionHeaderLayout = new AppBrandActionHeaderLayout(this.mContext);
        appBrandActionHeaderLayout.mAppId = this.mAppId;
        if (this.jDZ) {
            appBrandActionHeaderLayout.jCw.lc(appBrandActionHeaderLayout.mContext.getResources().getColor(com.tencent.mm.cb.a.b.buj));
            appBrandActionHeaderLayout.jCx.lc(appBrandActionHeaderLayout.mContext.getResources().getColor(com.tencent.mm.cb.a.b.buj));
            appBrandActionHeaderLayout.jCy.lc(appBrandActionHeaderLayout.mContext.getResources().getColor(com.tencent.mm.cb.a.b.buj));
            appBrandActionHeaderLayout.jCz.lc(appBrandActionHeaderLayout.mContext.getResources().getColor(com.tencent.mm.cb.a.b.buj));
            appBrandActionHeaderLayout.jCA.lc(appBrandActionHeaderLayout.mContext.getResources().getColor(com.tencent.mm.cb.a.b.buj));
            appBrandActionHeaderLayout.jCB.setTextColor(appBrandActionHeaderLayout.mContext.getResources().getColor(com.tencent.mm.cb.a.b.buj));
        } else {
            appBrandActionHeaderLayout.jCw.lc(appBrandActionHeaderLayout.mContext.getResources().getColor(com.tencent.mm.cb.a.b.isB));
            appBrandActionHeaderLayout.jCx.lc(appBrandActionHeaderLayout.mContext.getResources().getColor(com.tencent.mm.cb.a.b.isB));
            appBrandActionHeaderLayout.jCy.lc(appBrandActionHeaderLayout.mContext.getResources().getColor(com.tencent.mm.cb.a.b.isB));
            appBrandActionHeaderLayout.jCz.lc(appBrandActionHeaderLayout.mContext.getResources().getColor(com.tencent.mm.cb.a.b.isB));
            appBrandActionHeaderLayout.jCA.lc(appBrandActionHeaderLayout.mContext.getResources().getColor(com.tencent.mm.cb.a.b.isB));
            appBrandActionHeaderLayout.jCB.setTextColor(appBrandActionHeaderLayout.mContext.getResources().getColor(com.tencent.mm.cb.a.b.isB));
        }
        x.w("AppBrandGame.WAGamePageView", "getActionSheetHeader orientation:%d,mActionSheetTitleStrId:%d", new Object[]{Integer.valueOf(((MMActivity) this.mContext).getRequestedOrientation()), Integer.valueOf(this.jEa)});
        if (((MMActivity) this.mContext).getRequestedOrientation() == 6) {
            if (this.jEa > 0) {
                appBrandActionHeaderLayout.lb(this.jEa);
            }
            String str = this.irP.iqw.iconUrl;
            CharSequence charSequence = this.irP.iqw.frn;
            appBrandActionHeaderLayout.jCu.setVisibility(0);
            appBrandActionHeaderLayout.jCv.setVisibility(8);
            AppBrandActionSingleHeaderView appBrandActionSingleHeaderView = appBrandActionHeaderLayout.jCw;
            appBrandActionSingleHeaderView.fvf.setImageDrawable(com.tencent.mm.modelappbrand.a.a.Ji());
            com.tencent.mm.modelappbrand.a.b.Jj().a(appBrandActionHeaderLayout.jCw.fvf, str, null, com.tencent.mm.modelappbrand.a.f.hkr);
            appBrandActionHeaderLayout.jCw.imw.setText(charSequence);
            return appBrandActionHeaderLayout;
        } else if (this.jEa <= 0) {
            return null;
        } else {
            appBrandActionHeaderLayout.lb(this.jEa);
            return appBrandActionHeaderLayout;
        }
    }

    public final void kj(int i) {
        this.jEa = i;
    }

    public final String getURL() {
        return this.iZW;
    }

    public final String aeO() {
        return this.mUrl;
    }

    public final <T> T a(int i, Bundle bundle, Object... objArr) {
        MBCanvasContentHolder kk;
        switch (i) {
            case 1:
                x.i("AppBrandGame.WAGamePageView", "hy: got message beforeShare");
                if (bundle != null) {
                    kk = com.tencent.mm.plugin.appbrand.game.e.a.jah.kk(bundle.getInt("canvasId", -1));
                    x.i("AppBrandGame.WAGamePageView", "hy: got message beforeShare end");
                    if (!(kk == null || kk.content == null)) {
                        synchronized (this.iZV) {
                            this.iZU = kk.content;
                        }
                        break;
                    }
                }
                x.e("AppBrandGame.WAGamePageView", "hy: got message beforeShare data is null");
                break;
            case 2:
                d$b com_tencent_mm_plugin_appbrand_config_d_b = d$b.LANDSCAPE;
                com.tencent.mm.plugin.appbrand.config.d.e.abO();
                if (com_tencent_mm_plugin_appbrand_config_d_b != com.tencent.mm.plugin.appbrand.config.d.bQ(this.mContext)) {
                    x.i("AppBrandGame.WAGamePageView", "hy: vertical game. not need screenshot");
                    break;
                }
                kk = com.tencent.mm.plugin.appbrand.game.e.a.jah.aeQ();
                if (this.iZR == null) {
                    this.iZR = new ImageView(this.mContext);
                }
                this.iZP.jaa = new 4(this, kk);
                break;
            case 3:
                x.i("AppBrandGame.WAGamePageView", "got message doGetCanvasBitmap");
                if (bundle == null) {
                    x.e("AppBrandGame.WAGamePageView", "got message doGetCanvasBitmap data is null");
                    return null;
                }
                int i2 = bundle.getInt("canvasId", -1);
                boolean z = bundle.getBoolean("sync", true);
                if (i2 == -1) {
                    x.e("AppBrandGame.WAGamePageView", "got message doGetCanvasBitmap canvasId is illegal");
                    return null;
                }
                T kl;
                x.i("AppBrandGame.WAGamePageView", "got message doGetCanvasBitmap canvasId:%d,sync:%b", new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)});
                if (z) {
                    com.tencent.mm.plugin.appbrand.game.e.a aVar = com.tencent.mm.plugin.appbrand.game.e.a.jah;
                    kl = com.tencent.mm.plugin.appbrand.game.e.a.kl(i2);
                } else {
                    kl = com.tencent.mm.plugin.appbrand.game.e.a.jah.kk(i2);
                }
                x.i("AppBrandGame.WAGamePageView", "got message doGetCanvasBitmap end");
                return kl;
            default:
                x.w("AppBrandGame.WAGamePageView", "hy: not support this command!! %d", new Object[]{Integer.valueOf(i)});
                break;
        }
        return super.a(i, bundle, objArr);
    }

    public final Bitmap aeP() {
        x.i("AppBrandGame.WAGamePageView", "hy: jsapi enter wait");
        return null;
    }
}
