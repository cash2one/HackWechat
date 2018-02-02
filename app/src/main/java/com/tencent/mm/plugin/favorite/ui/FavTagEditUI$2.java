package com.tencent.mm.plugin.favorite.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class FavTagEditUI$2 implements OnTouchListener {
    final /* synthetic */ FavTagEditUI mtH;

    FavTagEditUI$2(FavTagEditUI favTagEditUI) {
        this.mtH = favTagEditUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        FavTagEditUI.d(this.mtH).cpG();
        return false;
    }
}
