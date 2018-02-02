package com.tencent.mm.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;

public class d implements OnClickListener {
    private long jIo = 0;
    private OnClickListener pGO;

    public void onClick(View view) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.jIo >= 500) {
            this.pGO.onClick(view);
            this.jIo = currentTimeMillis;
        }
    }
}
