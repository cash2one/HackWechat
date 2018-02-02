package com.tencent.mm.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.g.a.jg;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.x;

class LauncherUIBottomTabView$1 implements OnClickListener {
    private final long rHI = 300;
    final /* synthetic */ LauncherUIBottomTabView xHG;

    LauncherUIBottomTabView$1(LauncherUIBottomTabView launcherUIBottomTabView) {
        this.xHG = launcherUIBottomTabView;
    }

    public final void onClick(View view) {
        int intValue = ((Integer) view.getTag()).intValue();
        if (LauncherUIBottomTabView.a(this.xHG) == intValue && intValue == 0 && System.currentTimeMillis() - LauncherUIBottomTabView.b(this.xHG) <= 300) {
            x.v("MicroMsg.LauncherUITabView", "onMainTabDoubleClick");
            LauncherUIBottomTabView.c(this.xHG).removeMessages(0);
            a.xef.m(new jg());
            LauncherUIBottomTabView.a(this.xHG, System.currentTimeMillis());
            LauncherUIBottomTabView.a(this.xHG, intValue);
            return;
        }
        if (LauncherUIBottomTabView.d(this.xHG) != null) {
            if (intValue == 0 && LauncherUIBottomTabView.a(this.xHG) == 0) {
                x.v("MicroMsg.LauncherUITabView", "do double click check");
                LauncherUIBottomTabView.c(this.xHG).sendEmptyMessageDelayed(0, 300);
            } else {
                x.v("MicroMsg.LauncherUITabView", "directly dispatch tab click event");
                LauncherUIBottomTabView.a(this.xHG, System.currentTimeMillis());
                LauncherUIBottomTabView.a(this.xHG, intValue);
                LauncherUIBottomTabView.d(this.xHG).oW(intValue);
                return;
            }
        }
        LauncherUIBottomTabView.a(this.xHG, System.currentTimeMillis());
        LauncherUIBottomTabView.a(this.xHG, intValue);
        x.w("MicroMsg.LauncherUITabView", "on tab click, index %d, but listener is null", new Object[]{(Integer) view.getTag()});
    }
}
