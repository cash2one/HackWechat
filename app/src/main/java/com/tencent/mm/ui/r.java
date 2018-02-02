package com.tencent.mm.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

public abstract class r implements OnClickListener {
    private long qxA = -1;

    public abstract void ayX();

    public void onClick(View view) {
        x.i("MicroMsg.MMCustomClickListener", "button onclick");
        if (this.qxA != -1) {
            if ((System.nanoTime() - this.qxA) / 1000000 < 3000) {
                x.i("MicroMsg.MMCustomClickListener", "click time limited limitetime:%d, delaytime:%d", new Object[]{Long.valueOf((System.nanoTime() - this.qxA) / 1000000), Long.valueOf(3000)});
                return;
            }
        }
        this.qxA = System.nanoTime();
        ayX();
    }
}
