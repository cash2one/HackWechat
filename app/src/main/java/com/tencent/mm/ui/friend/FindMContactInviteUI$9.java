package com.tencent.mm.ui.friend;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.modelfriend.j;

class FindMContactInviteUI$9 implements OnTouchListener {
    final /* synthetic */ FindMContactInviteUI zcx;

    FindMContactInviteUI$9(FindMContactInviteUI findMContactInviteUI) {
        this.zcx = findMContactInviteUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (FindMContactInviteUI.b(this.zcx) != null) {
            j b = FindMContactInviteUI.b(this.zcx);
            if (b.hvU != null) {
                b.hvU.onTouchEvent(motionEvent);
            }
        }
        return false;
    }
}
