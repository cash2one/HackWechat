package com.tencent.mm.plugin.music.ui;

import android.content.Context;
import android.widget.Scroller;

public class MusicViewPager$a extends Scroller {
    private int duration = 1000;
    final /* synthetic */ MusicViewPager oNT;

    public MusicViewPager$a(MusicViewPager musicViewPager, Context context) {
        this.oNT = musicViewPager;
        super(context);
    }

    public final void startScroll(int i, int i2, int i3, int i4, int i5) {
        super.startScroll(i, i2, i3, i4, this.duration);
    }

    public final void startScroll(int i, int i2, int i3, int i4) {
        super.startScroll(i, i2, i3, i4, this.duration);
    }
}
