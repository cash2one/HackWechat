package com.tencent.mm.ui.chatting;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.R;

class r$f implements OnTouchListener {
    private int[] ytL = new int[2];

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.ytL[0] = (int) motionEvent.getRawX();
                this.ytL[1] = (int) motionEvent.getRawY();
                view.setTag(R.h.cSF, this.ytL);
                break;
        }
        return false;
    }
}
