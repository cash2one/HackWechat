package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.ui.base.CustomViewPager;

public class WebViewSmileyViewPager extends CustomViewPager {
    private int kbi = 0;
    private int kbj = 0;
    c tLf;
    a tLo;

    public WebViewSmileyViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (d.fM(9)) {
            setOverScrollMode(2);
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.tLf != null && (((i > 0 && i3 != i) || (i2 > 0 && i4 != i2)) && ((i2 > 0 && i2 != this.kbi) || (i > 0 && i != this.kbj)))) {
            this.tLf.kbf = i2;
            this.tLf.kbg = i;
            if (this.tLo != null) {
                this.tLo.anw();
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
