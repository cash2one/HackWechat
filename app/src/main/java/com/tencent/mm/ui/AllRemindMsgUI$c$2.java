package com.tencent.mm.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.AllRemindMsgUI.c;

class AllRemindMsgUI$c$2 implements OnTouchListener {
    final /* synthetic */ AllRemindMsgUI xDJ;
    final /* synthetic */ c xDK;

    AllRemindMsgUI$c$2(c cVar, AllRemindMsgUI allRemindMsgUI) {
        this.xDK = cVar;
        this.xDJ = allRemindMsgUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        view.setTag(R.h.cSF, new int[]{(int) motionEvent.getRawX(), (int) motionEvent.getRawY()});
        return false;
    }
}
