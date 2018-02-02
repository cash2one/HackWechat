package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.graphics.Rect;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.WindowInsets;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.HomeUI.FitSystemWindowLayoutView;
import com.tencent.mm.ui.z.4;

class z$4$1 implements OnApplyWindowInsetsListener {
    final /* synthetic */ 4 xLQ;

    z$4$1(4 4) {
        this.xLQ = 4;
    }

    @TargetApi(20)
    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        if (windowInsets != null) {
            x.i("MicroMsg.LauncherUI.NewChattingTabUI", "OnApplyWindowInsetsListener %s", new Object[]{windowInsets});
            windowInsets.consumeSystemWindowInsets();
            LauncherUI$b launcherUI$b = this.xLQ.xLL.xLy;
            FitSystemWindowLayoutView fitSystemWindowLayoutView = this.xLQ.xLO;
            windowInsets.getSystemWindowInsetTop();
            launcherUI$b.a(fitSystemWindowLayoutView, new Rect(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom()), this.xLQ.xLP);
        }
        return windowInsets;
    }
}
