package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;

public final class p extends i {
    MMWebView juE;
    FrameLayout rks;

    public p(Context context, v vVar, ViewGroup viewGroup) {
        super(context, vVar, viewGroup);
    }

    protected final void bxa() {
        WindowManager windowManager = (WindowManager) this.context.getSystemService("window");
        int width = windowManager.getDefaultDisplay().getWidth();
        int height = windowManager.getDefaultDisplay().getHeight();
        this.juE.setVerticalScrollBarEnabled(false);
        this.juE.setHorizontalScrollBarEnabled(false);
        this.juE.getSettings().setJavaScriptEnabled(true);
        this.juE.loadUrl(((v) this.rji).nvp);
        this.juE.setLayoutParams(new LayoutParams(-1, -1));
        this.juE.setVisibility(0);
        this.rks.setPadding(this.rks.getPaddingLeft(), (int) ((v) this.rji).rgM, this.rks.getPaddingRight(), (int) ((v) this.rji).rgN);
        this.rks.setLayoutParams(new LinearLayout.LayoutParams(width, height));
    }

    public final View bwW() {
        this.rks = (FrameLayout) this.contentView;
        this.juE = a.cn(this.context);
        this.rks.addView(this.juE);
        return this.rks;
    }

    protected final int bjK() {
        return Integer.MAX_VALUE;
    }

    protected final View bxb() {
        return new FrameLayout(this.context);
    }
}
