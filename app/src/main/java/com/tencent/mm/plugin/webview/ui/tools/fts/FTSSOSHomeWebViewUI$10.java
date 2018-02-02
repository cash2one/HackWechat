package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AbsoluteLayout;
import android.widget.RelativeLayout.LayoutParams;

class FTSSOSHomeWebViewUI$10 implements OnGlobalLayoutListener {
    final /* synthetic */ FTSSOSHomeWebViewUI tDo;

    FTSSOSHomeWebViewUI$10(FTSSOSHomeWebViewUI fTSSOSHomeWebViewUI) {
        this.tDo = fTSSOSHomeWebViewUI;
    }

    public final void onGlobalLayout() {
        if (FTSSOSHomeWebViewUI.b(this.tDo).getHeight() > 0) {
            FTSSOSHomeWebViewUI.c(this.tDo).getViewTreeObserver().removeOnGlobalLayoutListener(this);
            this.tDo.tEe.countDown();
            if (this.tDo.tCf.getLayoutParams() instanceof LayoutParams) {
                FTSSOSHomeWebViewUI.b(this.tDo, ((LayoutParams) this.tDo.tCf.getLayoutParams()).topMargin);
            }
            if (FTSSOSHomeWebViewUI.c(this.tDo).getLayoutParams() instanceof LayoutParams) {
                FTSSOSHomeWebViewUI.c(this.tDo, ((LayoutParams) FTSSOSHomeWebViewUI.c(this.tDo).getLayoutParams()).topMargin);
                if (this.tDo.tEd && FTSSOSHomeWebViewUI.d(this.tDo).getTopView() != null && (FTSSOSHomeWebViewUI.e(this.tDo).getTopView() instanceof AbsoluteLayout)) {
                    ((ViewGroup) FTSSOSHomeWebViewUI.c(this.tDo).getParent()).removeView(FTSSOSHomeWebViewUI.c(this.tDo));
                    ((AbsoluteLayout) FTSSOSHomeWebViewUI.g(this.tDo).getTopView()).addView(FTSSOSHomeWebViewUI.c(this.tDo), new AbsoluteLayout.LayoutParams(-1, -2, 0, FTSSOSHomeWebViewUI.f(this.tDo) - FTSSOSHomeWebViewUI.b(this.tDo).getHeight()));
                }
            }
            FTSSOSHomeWebViewUI.h(this.tDo);
        }
    }
}
