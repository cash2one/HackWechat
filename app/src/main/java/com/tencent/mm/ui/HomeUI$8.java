package com.tencent.mm.ui;

import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import java.util.Iterator;

class HomeUI$8 implements OnClickListener {
    final /* synthetic */ HomeUI xGv;

    HomeUI$8(HomeUI homeUI) {
        this.xGv = homeUI;
    }

    public final void onClick(View view) {
        if (SystemClock.elapsedRealtime() - HomeUI.o(this.xGv) < 300) {
            Iterator it = HomeUI.p(this.xGv).iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
        }
        HomeUI.b(this.xGv, SystemClock.elapsedRealtime());
    }
}
