package com.tencent.mm.ui.conversation;

import android.annotation.TargetApi;
import android.graphics.Rect;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewGroup;
import android.view.WindowInsets;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.HomeUI.FitSystemWindowLayoutView;

class BaseConversationUI$9 implements Runnable {
    final /* synthetic */ int[] xLN;
    final /* synthetic */ FitSystemWindowLayoutView xLO;
    final /* synthetic */ ViewGroup xLP;
    final /* synthetic */ BaseConversationUI yVX;

    BaseConversationUI$9(BaseConversationUI baseConversationUI, int[] iArr, FitSystemWindowLayoutView fitSystemWindowLayoutView, ViewGroup viewGroup) {
        this.yVX = baseConversationUI;
        this.xLN = iArr;
        this.xLO = fitSystemWindowLayoutView;
        this.xLP = viewGroup;
    }

    public final void run() {
        this.yVX.getSupportActionBar().getCustomView().getLocationInWindow(this.xLN);
        int i = this.xLN[1];
        if (i > 0) {
            BaseConversationUI.access$1300(this.yVX, this.xLO, i, new Rect(0, i, 0, 0), this.xLP);
        } else if (d.fM(20)) {
            this.xLO.setOnApplyWindowInsetsListener(new OnApplyWindowInsetsListener(this) {
                final /* synthetic */ BaseConversationUI$9 yVZ;

                {
                    this.yVZ = r1;
                }

                @TargetApi(20)
                public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    if (windowInsets != null) {
                        x.i("MicroMsg.BaseConversationUI", "OnApplyWindowInsetsListener %s", new Object[]{windowInsets});
                        windowInsets.consumeSystemWindowInsets();
                        BaseConversationUI.access$1300(this.yVZ.yVX, this.yVZ.xLO, windowInsets.getSystemWindowInsetTop(), new Rect(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom()), this.yVZ.xLP);
                    }
                    return windowInsets;
                }
            });
        }
    }
}
