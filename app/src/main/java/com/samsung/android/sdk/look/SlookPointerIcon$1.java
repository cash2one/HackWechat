package com.samsung.android.sdk.look;

import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.View.OnHoverListener;

class SlookPointerIcon$1 implements OnHoverListener {
    final /* synthetic */ SlookPointerIcon this$0;

    SlookPointerIcon$1(SlookPointerIcon slookPointerIcon) {
        this.this$0 = slookPointerIcon;
    }

    public boolean onHover(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 9:
                try {
                    PointerIcon.setHoveringSpenIcon(0, SlookPointerIcon.access$000(this.this$0));
                    break;
                } catch (RemoteException e) {
                    break;
                }
            case 10:
                try {
                    PointerIcon.setHoveringSpenIcon(1, -1);
                    break;
                } catch (RemoteException e2) {
                    break;
                }
        }
        return false;
    }
}
