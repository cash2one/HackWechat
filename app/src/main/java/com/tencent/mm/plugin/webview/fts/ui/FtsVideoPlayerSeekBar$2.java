package com.tencent.mm.plugin.webview.fts.ui;

import android.view.View;
import android.view.View.OnLayoutChangeListener;

class FtsVideoPlayerSeekBar$2 implements OnLayoutChangeListener {
    final /* synthetic */ FtsVideoPlayerSeekBar tqH;

    FtsVideoPlayerSeekBar$2(FtsVideoPlayerSeekBar ftsVideoPlayerSeekBar) {
        this.tqH = ftsVideoPlayerSeekBar;
    }

    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (i3 - i != i7 - i5) {
            this.tqH.ahe();
        }
    }
}
