package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

public final class i extends LinearLayout {
    private Context context;
    private int kAD = 0;
    public int rrq = 6;
    private LinearLayout rrr;

    public i(Context context) {
        super(context);
        this.context = context;
        setOrientation(1);
    }

    public final void addView(View view) {
        if (this.kAD % this.rrq == 0) {
            this.rrr = new LinearLayout(this.context);
            this.rrr.setOrientation(0);
            this.rrr.addView(view);
            super.addView(this.rrr);
        } else {
            this.rrr.addView(view);
        }
        this.kAD++;
    }
}
