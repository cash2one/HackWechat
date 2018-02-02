package com.tencent.mm.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.g.a.jg;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.x;

class LauncherUITabView$1 implements OnClickListener {
    private final long rHI = 300;
    final /* synthetic */ LauncherUITabView xHV;

    LauncherUITabView$1(LauncherUITabView launcherUITabView) {
        this.xHV = launcherUITabView;
    }

    public final void onClick(View view) {
        int intValue = ((Integer) view.getTag()).intValue();
        if (LauncherUITabView.a(this.xHV) == intValue && intValue == 0 && System.currentTimeMillis() - LauncherUITabView.b(this.xHV) <= 300) {
            x.v("MicroMsg.LauncherUITabView", "onMainTabDoubleClick");
            LauncherUITabView.c(this.xHV).removeMessages(0);
            a.xef.m(new jg());
            LauncherUITabView.a(this.xHV, System.currentTimeMillis());
            LauncherUITabView.a(this.xHV, intValue);
            return;
        }
        if (LauncherUITabView.d(this.xHV) != null) {
            if (intValue == 0 && LauncherUITabView.a(this.xHV) == 0) {
                LauncherUITabView.c(this.xHV).sendEmptyMessageDelayed(0, 300);
            } else {
                LauncherUITabView.a(this.xHV, System.currentTimeMillis());
                LauncherUITabView.a(this.xHV, intValue);
                LauncherUITabView.d(this.xHV).oW(intValue);
                return;
            }
        }
        LauncherUITabView.a(this.xHV, System.currentTimeMillis());
        LauncherUITabView.a(this.xHV, intValue);
        x.w("MicroMsg.LauncherUITabView", "on tab click, index %d, but listener is null", new Object[]{(Integer) view.getTag()});
    }
}
