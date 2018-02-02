package com.tencent.mm.plugin.appbrand.widget.input.panel;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import com.tencent.mm.ui.base.CustomViewPager;

public class AppBrandSmileyViewPager extends CustomViewPager {
    c kaL;
    private int kbi = 0;
    private int kbj = 0;
    b kbk;

    public AppBrandSmileyViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (VERSION.SDK_INT >= 9) {
            setOverScrollMode(2);
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.kaL != null && (((i > 0 && i3 != i) || (i2 > 0 && i4 != i2)) && ((i2 > 0 && i2 != this.kbi) || (i > 0 && i != this.kbj)))) {
            this.kaL.kbf = i2;
            this.kaL.kbg = i;
            if (this.kbk != null) {
                this.kbk.anw();
            }
        }
        if (i2 > 0) {
            this.kbi = i2;
        }
        if (i > 0) {
            this.kbj = i;
        }
    }
}
