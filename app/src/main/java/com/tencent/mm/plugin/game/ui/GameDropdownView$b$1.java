package com.tencent.mm.plugin.game.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.plugin.game.ui.GameDropdownView.b;

class GameDropdownView$b$1 implements OnTouchListener {
    final /* synthetic */ b nqa;

    GameDropdownView$b$1(b bVar) {
        this.nqa = bVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 4) {
            return false;
        }
        this.nqa.dismiss();
        return true;
    }
}
