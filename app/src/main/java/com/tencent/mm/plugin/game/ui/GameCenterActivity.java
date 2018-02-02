package com.tencent.mm.plugin.game.ui;

import android.annotation.TargetApi;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.WindowInsets;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.plugin.game.c.dw;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.i;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.p;
import com.tencent.mm.ui.p.5;
import com.tencent.mm.ui.p.a;
import com.tencent.mm.ui.p.b;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.w.a.k;
import com.tencent.smtt.sdk.WebView;

public abstract class GameCenterActivity extends GameBaseActivity {
    protected int jNd;
    protected ActionBar mActionBar;
    protected View nmo;
    protected View nmp;
    protected int nmq = 0;
    protected String nmr = null;
    private dw nms;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mActionBar = getSupportActionBar();
        this.nms = i.aQb().aQd();
        if (this.nms != null) {
            this.nmq = c.parseColor(this.nms.hbM);
            this.nmr = this.nms.neh;
        }
        try {
            this.nmo = this.mController.contentView;
            if (this.nmo != null) {
                aRv();
                ((ViewGroup) ((ViewGroup) getWindow().getDecorView()).getChildAt(0)).addOnLayoutChangeListener(new 1(this));
            }
        } catch (Exception e) {
            x.e("MicroMsg.GameCenterActivity", "fixContentMargin error : %s", new Object[]{e.getMessage()});
        }
        try {
            if (d.fM(21)) {
                ViewGroup viewGroup = (ViewGroup) ((ViewGroup) getWindow().getDecorView()).getChildAt(0);
                viewGroup.setOnApplyWindowInsetsListener(new 2(this, viewGroup));
                return;
            }
            ((ViewGroup) getWindow().getDecorView()).setFitsSystemWindows(true);
        } catch (Exception e2) {
            x.e("MicroMsg.GameCenterActivity", "tryToExpandToStatusBar error : %s", new Object[]{e2.getMessage()});
        }
    }

    protected final void onCreateBeforeSetContentView() {
        supportRequestWindowFeature(5);
        supportRequestWindowFeature(9);
        setProgressBarIndeterminateVisibility(false);
    }

    protected final void aRv() {
        if (this.nmo != null) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.nmo.getLayoutParams();
            int height = (this.mActionBar != null ? this.mActionBar.getHeight() : 0) + this.jNd;
            if (height != marginLayoutParams.topMargin) {
                marginLayoutParams.topMargin = height;
                this.nmo.setLayoutParams(marginLayoutParams);
            }
        }
    }

    @TargetApi(21)
    protected final void a(ViewGroup viewGroup, WindowInsets windowInsets) {
        if (this.jNd != windowInsets.getSystemWindowInsetTop()) {
            this.jNd = windowInsets.getSystemWindowInsetTop();
            aRv();
            if (viewGroup instanceof SwipeBackLayout) {
                viewGroup = viewGroup.getChildAt(0);
            }
            int i = R.h.action_bar_container;
            if (i > 0) {
                View findViewById = viewGroup.findViewById(i);
                if (findViewById != null) {
                    MarginLayoutParams marginLayoutParams = (MarginLayoutParams) findViewById.getLayoutParams();
                    marginLayoutParams.topMargin = windowInsets.getSystemWindowInsetTop();
                    findViewById.setLayoutParams(marginLayoutParams);
                    findViewById.requestLayout();
                }
            }
            x.i("MicroMsg.GameCenterActivity", "setInitialStatusBarStyle");
            if (!d.fM(21)) {
                return;
            }
            if (this.nmq != 0) {
                if (this.mActionBar != null) {
                    this.mActionBar.setBackgroundDrawable(new ColorDrawable(this.nmq));
                }
                if (aRw()) {
                    x.i("MicroMsg.GameCenterActivity", "setBackBtnColorFilter");
                    cmV();
                }
                i = this.nmq;
                boolean aRw = aRw();
                if (VERSION.SDK_INT >= 23 && !h.zj()) {
                    setStatusBarColor(i);
                    Window window = getWindow();
                    i = window.getDecorView().getSystemUiVisibility();
                    window.getDecorView().setSystemUiVisibility(aRw ? i | 8192 : i & -8193);
                    return;
                } else if (VERSION.SDK_INT >= 21) {
                    if (aRw) {
                        i = com.tencent.mm.plugin.webview.ui.tools.d.j(i, 0.78f);
                    }
                    setStatusBarColor(i);
                    return;
                } else {
                    return;
                }
            }
            setStatusBarColor(getResources().getColor(R.e.btS));
        }
    }

    public final void setBackBtn(OnMenuItemClickListener onMenuItemClickListener, int i) {
        x.i("MicroMsg.GameCenterActivity", "setBackBtn");
        super.setBackBtn(onMenuItemClickListener, i);
        if (d.fM(21) && aRw()) {
            x.i("MicroMsg.GameCenterActivity", "setBackBtn, setBackBtnColorFilter");
            cmV();
        }
    }

    public final void setBackBtn(OnMenuItemClickListener onMenuItemClickListener) {
        x.i("MicroMsg.GameCenterActivity", "setBackBtn");
        super.setBackBtn(onMenuItemClickListener, 0);
        if (d.fM(21) && aRw()) {
            x.i("MicroMsg.GameCenterActivity", "setBackBtn, setBackBtnColorFilter");
            cmV();
        }
    }

    @TargetApi(21)
    private void setStatusBarColor(int i) {
        if (this.jNd > 0 && !d.fN(21)) {
            getWindow().setStatusBarColor(0);
            if (this.nmp == null) {
                this.nmp = new View(this);
                this.nmp.setId(R.h.ckA);
                ((ViewGroup) findViewById(16908290)).addView(this.nmp, new LayoutParams(-1, this.jNd));
            } else {
                LayoutParams layoutParams = this.nmp.getLayoutParams();
                if (layoutParams.height != this.jNd) {
                    layoutParams.height = this.jNd;
                    this.nmp.setLayoutParams(layoutParams);
                }
            }
            this.nmp.setBackgroundColor(i);
        }
    }

    private boolean aRw() {
        if (bh.ov(this.nmr) || !this.nmr.equals("black")) {
            return false;
        }
        return true;
    }

    public final void setMMTitle(int i) {
        super.setMMTitle(i);
        if (d.fM(21) && aRw()) {
            nR(WebView.NIGHT_MODE_COLOR);
        }
    }

    public final void addTextOptionMenu(int i, String str, OnMenuItemClickListener onMenuItemClickListener) {
        if (d.fM(21) && aRw()) {
            p pVar = this.mController;
            int i2 = b.xJy;
            a aVar = new a();
            aVar.xJr = i;
            aVar.text = str;
            aVar.textColor = WebView.NIGHT_MODE_COLOR;
            aVar.pRz = onMenuItemClickListener;
            aVar.mwJ = null;
            aVar.xJw = i2;
            pVar.DS(aVar.xJr);
            pVar.xIP.add(aVar);
            new af().postDelayed(new 5(pVar), 200);
            return;
        }
        super.addTextOptionMenu(i, str, onMenuItemClickListener);
    }

    public final void addIconOptionMenu(int i, int i2, OnMenuItemClickListener onMenuItemClickListener) {
        if (d.fM(21)) {
            Drawable b = android.support.v4.content.a.b(this, i2);
            if (b != null) {
                if (aRw()) {
                    b.setColorFilter(WebView.NIGHT_MODE_COLOR, Mode.SRC_ATOP);
                } else {
                    b.clearColorFilter();
                }
                a(i, getString(k.gYx), b, onMenuItemClickListener);
                return;
            }
            return;
        }
        super.addIconOptionMenu(i, i2, onMenuItemClickListener);
    }
}
