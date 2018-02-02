package com.tencent.mm.ui.account;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.tencent.mm.R;

class a$1 implements OnTouchListener {
    final /* synthetic */ a xNo;

    a$1(a aVar) {
        this.xNo = aVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            ((TextView) view.findViewById(R.h.bJZ)).setTextColor(-10395295);
        } else if (motionEvent.getAction() == 1) {
            ((TextView) view.findViewById(R.h.bJZ)).setTextColor(-1);
        }
        return false;
    }
}
