package com.tencent.mm.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.sdk.platformtools.x;

public abstract class s implements OnMenuItemClickListener {
    private long qxA = -1;

    public abstract void bKg();

    public boolean onMenuItemClick(MenuItem menuItem) {
        x.i("MicroMsg.MMCustomMenuItemClickListener", "button onclick");
        if (this.qxA != -1) {
            if ((System.nanoTime() - this.qxA) / 1000000 < 500) {
                x.i("MicroMsg.MMCustomMenuItemClickListener", "click time limited limitetime:%d, delaytime:%d", new Object[]{Long.valueOf((System.nanoTime() - this.qxA) / 1000000), Long.valueOf(500)});
                return false;
            }
        }
        this.qxA = System.nanoTime();
        bKg();
        return false;
    }
}
