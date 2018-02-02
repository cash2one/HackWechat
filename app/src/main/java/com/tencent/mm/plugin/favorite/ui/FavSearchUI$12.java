package com.tencent.mm.plugin.favorite.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class FavSearchUI$12 implements OnTouchListener {
    final /* synthetic */ FavSearchUI mth;

    FavSearchUI$12(FavSearchUI favSearchUI) {
        this.mth = favSearchUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.mth.aWs();
                break;
        }
        return false;
    }
}
