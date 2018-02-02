package com.tencent.mm.plugin.game.gamewebview.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameMMToClientEvent;
import com.tencent.mm.plugin.game.gamewebview.ui.d.30;
import com.tencent.mm.plugin.webview.ui.tools.game.c;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.GameMenuImageButton;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.j;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.SwipeBackLayout.a;
import com.tencent.mm.ui.widget.l;

public final class b extends SwipeBackLayout implements a, l.a {
    private boolean jDf;
    public Context mContext;
    boolean mSwiping = false;
    d mWG;
    c mYs;
    boolean mYt;
    public Bundle vf = new Bundle();

    public b(Context context, c cVar) {
        super(context);
        this.mContext = context;
        this.mYs = cVar;
        setLayoutParams(new LayoutParams(-1, -1));
        init();
        nE(false);
        nD(true);
        addView(aOV());
        this.Iv = aOV();
        this.zwz = this;
    }

    public final d aOV() {
        if (this.mWG == null) {
            this.mWG = new d(this);
        }
        return this.mWG;
    }

    public final void aes() {
        d dVar;
        x.d("MicroMsg.GameWebPage", "onPageForeground: %s", new Object[]{bh.ou(this.mWG.mXZ)});
        l.b(this);
        this.zsB = false;
        this.mEnable = aOW();
        this.jDf = false;
        setVisibility(0);
        if (this.vf.getBoolean("transparent_page", false)) {
            dVar = this.mWG;
            dVar.mYN.setBackgroundColor(0);
            dVar.mYL.tyg = true;
            dVar.mYL.iMZ = false;
            dVar.mYL.kr(true);
            dVar.mYL.AF(0);
        }
        if (this.mContext instanceof GameWebViewUI) {
            GameWebViewUI gameWebViewUI = (GameWebViewUI) this.mContext;
            gameWebViewUI.qK(this.vf.getInt("screen_orientation", -1));
            if (isFullScreen()) {
                gameWebViewUI.getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                gameWebViewUI.getWindow().getDecorView().setSystemUiVisibility(5894);
            } else {
                gameWebViewUI.getWindow().clearFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                gameWebViewUI.getWindow().getDecorView().setSystemUiVisibility(0);
            }
        }
        FrameLayout frameLayout = this.mWG;
        boolean isFullScreen = isFullScreen();
        x.d("MicroMsg.GameWebPageView", "setFullScreen, rawUrl = %s, fullscreen = %b, mHVGameAppId = %s", new Object[]{frameLayout.mXZ, Boolean.valueOf(isFullScreen), frameLayout.mZv});
        frameLayout.jDU = isFullScreen;
        if (isFullScreen) {
            frameLayout.qG(8);
            if (bh.ov(frameLayout.mZv)) {
                frameLayout.mYR.setVisibility(0);
            } else {
                if (frameLayout.mYT == null) {
                    frameLayout.mYT = new GameMenuImageButton(frameLayout.mYx);
                    frameLayout.mYT.a(frameLayout, new 30(frameLayout));
                }
                frameLayout.mYR.setVisibility(8);
            }
        } else {
            frameLayout.qG(0);
            frameLayout.mYR.setVisibility(8);
        }
        dVar = this.mWG;
        dVar.aPm();
        dVar.BL("onResume");
        dVar.BM("onResume");
        dVar.mYG.mYf = System.currentTimeMillis();
        dVar.mZw.tFt.onResume();
    }

    public final void fv(boolean z) {
        x.d("MicroMsg.GameWebPage", "onPageBackground: %s", new Object[]{bh.ou(this.mWG.mXZ)});
        if (z) {
            l.a(this);
        }
        this.jDf = true;
        d dVar = this.mWG;
        com.tencent.mm.plugin.game.gamewebview.d.a aVar = dVar.mYG;
        aVar.mYg += System.currentTimeMillis() - aVar.mYf;
        dVar.mZw.tFt.onPause();
        dVar.BL("onPause");
        dVar.BM("onPause");
        dVar.jFi.onHideCustomView();
    }

    protected final void aer() {
        x.d("MicroMsg.GameWebPage", "onPageDestroy: %s", new Object[]{this.mWG.aPk()});
        d dVar = this.mWG;
        x.d("MicroMsg.GameWebPageView", "onPageDestroy");
        dVar.lut = true;
        if (dVar.mZt != null) {
            dVar.mZt.cancel();
        }
        if (dVar.mYZ != null) {
            dVar.mYZ.onDestroy();
        }
        com.tencent.mm.plugin.game.gamewebview.d.a aVar = dVar.mYG;
        x.d("MicroMsg.GameWebViewReportManager", "totalTime = %d, visitTime = %d, loadSuccess = %d", new Object[]{Long.valueOf(System.currentTimeMillis() - aVar.mYe), Long.valueOf(aVar.mYg), Integer.valueOf(aVar.mYc)});
        aVar.a(aVar.mWG.aPk(), 4, r4, aVar.mYc, 0);
        aVar.a(aVar.mWG.aPk(), 1, aVar.mYg, aVar.mYc, 0);
        dVar.BL("onDestroy");
        c.a(dVar.mZw.tFt.tFu);
        x.d("MicroMsg.GameWebPageView", "destroy");
        GameMMToClientEvent.qD(dVar.hashCode());
        com.tencent.mm.plugin.game.gamewebview.model.a.b(dVar);
        dVar.mYL.release();
        if (dVar.mYW != null) {
            dVar.mYW.detach();
            dVar.mYW = null;
        }
        dVar.mYM.iTB.getLooper().quit();
        dVar.mYN.setWebChromeClient(null);
        dVar.mYN.setWebChromeClient(null);
        dVar.mYN.setOnTouchListener(null);
        dVar.mYN.setOnLongClickListener(null);
        try {
            dVar.mYN.destroy();
        } catch (Exception e) {
            x.e("MicroMsg.GameWebPageView", "destroy, webview destroy, excepiton: " + e.getMessage());
        }
        dVar.mYN = null;
        System.gc();
    }

    public final boolean aOW() {
        if (!(this.vf.getBoolean("disable_swipe_back", false) || this.vf.getBoolean("transparent_page", false) || this.mYt)) {
            if (this.mYs.mYw.size() > 1) {
                return true;
            }
        }
        return false;
    }

    public final void hide() {
        if (this.jDf) {
            x.d("MicroMsg.GameWebPage", "hide, %d", new Object[]{Integer.valueOf(hashCode())});
            setVisibility(4);
        }
    }

    public final void onSwipe(float f) {
        x.d("MicroMsg.GameWebPage", "onSwipe， " + hashCode());
        if (this.jDf) {
            if (f != 1.0f) {
                setVisibility(0);
            } else {
                hide();
            }
        }
        if (Float.compare(1.0f, f) <= 0) {
            j.n(aOV(), 0.0f);
            return;
        }
        j.n(aOV(), (((float) (aOV().getWidth() / 4)) * (1.0f - f)) * -1.0f);
    }

    public final void onSettle(boolean z, int i) {
        long j = 120;
        x.d("MicroMsg.GameWebPage", "onSettle(%d), %b, %d ", new Object[]{Integer.valueOf(hashCode()), Boolean.valueOf(z), Integer.valueOf(i)});
        if (z) {
            View aOV = aOV();
            if (i <= 0) {
                j = 240;
            }
            j.a(aOV, j, 0.0f, null);
            return;
        }
        aOV = aOV();
        if (i <= 0) {
            j = 240;
        }
        j.a(aOV, j, (float) ((aOV().getWidth() * -1) / 4), null);
    }

    public final boolean forceRemoveNoMatchOnPath() {
        return false;
    }

    public final void onSwipeBack() {
        this.mYs.fw(true);
    }

    public final void onDrag() {
        this.mSwiping = true;
    }

    public final void onCancel() {
        this.mSwiping = false;
    }

    public final void aOX() {
        this.mYt = false;
        this.mEnable = aOW();
    }

    public final boolean aOY() {
        return this.vf.getBoolean("is_from_keep_top", false);
    }

    public final void aOZ() {
        this.mYs.fw(true);
    }

    public final boolean isFullScreen() {
        return this.vf.getBoolean("show_full_screen", false);
    }
}
