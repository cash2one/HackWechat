package com.tencent.mm.ui.statusbar;

import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.w.a.d;

public abstract class DrawStatusBarActivity extends MMActivity {
    private b jKr = null;

    protected void initSwipeBack() {
        super.initSwipeBack();
        if (getSwipeBackLayout() != null && getSwipeBackLayout().getChildCount() > 0) {
            View childAt = getSwipeBackLayout().getChildAt(0);
            getSwipeBackLayout().removeView(childAt);
            this.jKr = new b(this);
            this.jKr.addView(childAt, new LayoutParams(-1, -1));
            getSwipeBackLayout().addView(this.jKr);
            getSwipeBackLayout().Iv = this.jKr;
        }
    }

    public int getStatusBarColor() {
        return getResources().getColor(d.btS);
    }
}
