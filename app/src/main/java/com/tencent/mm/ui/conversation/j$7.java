package com.tencent.mm.ui.conversation;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class j$7 implements OnTouchListener {
    final /* synthetic */ j yZL;

    j$7(j jVar) {
        this.yZL = jVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.yZL.hideVKB();
                j.f(this.yZL)[0] = (int) motionEvent.getRawX();
                j.f(this.yZL)[1] = (int) motionEvent.getRawY();
                break;
        }
        return false;
    }
}
