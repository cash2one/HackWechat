package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public final class a {
    View rnu;
    int rnv;
    LayoutParams rnw = ((LayoutParams) this.rnu.getLayoutParams());

    public a(Activity activity) {
        this.rnu = ((FrameLayout) activity.findViewById(16908290)).getChildAt(0);
        this.rnu.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener(this) {
            final /* synthetic */ a rnx;

            {
                this.rnx = r1;
            }

            public final void onGlobalLayout() {
                a aVar = this.rnx;
                Rect rect = new Rect();
                aVar.rnu.getWindowVisibleDisplayFrame(rect);
                int i = rect.bottom - rect.top;
                if (i != aVar.rnv) {
                    int height = aVar.rnu.getRootView().getHeight();
                    int i2 = height - i;
                    if (i2 > height / 4) {
                        aVar.rnw.height = height - i2;
                    } else {
                        aVar.rnw.height = height;
                    }
                    aVar.rnu.requestLayout();
                    aVar.rnv = i;
                }
            }
        });
    }
}
