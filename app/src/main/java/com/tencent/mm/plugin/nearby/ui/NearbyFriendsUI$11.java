package com.tencent.mm.plugin.nearby.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI.b;

class NearbyFriendsUI$11 implements OnTouchListener {
    final /* synthetic */ NearbyFriendsUI oOS;

    NearbyFriendsUI$11(NearbyFriendsUI nearbyFriendsUI) {
        this.oOS = nearbyFriendsUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (NearbyFriendsUI.s(this.oOS) != null) {
            b s = NearbyFriendsUI.s(this.oOS);
            if (s.hvU != null) {
                s.hvU.onTouchEvent(motionEvent);
            }
        }
        return false;
    }
}
