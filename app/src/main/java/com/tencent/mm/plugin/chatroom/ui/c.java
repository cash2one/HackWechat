package com.tencent.mm.plugin.chatroom.ui;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;

public final class c extends TouchDelegate {
    private static final Rect leR = new Rect();
    ArrayList<TouchDelegate> leS;
    TouchDelegate leT;

    public c(View view) {
        super(leR, view);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        TouchDelegate touchDelegate;
        switch (motionEvent.getAction()) {
            case 0:
                if (this.leS != null) {
                    Iterator it = this.leS.iterator();
                    while (it.hasNext()) {
                        touchDelegate = (TouchDelegate) it.next();
                        if (touchDelegate != null && touchDelegate.onTouchEvent(motionEvent)) {
                            this.leT = touchDelegate;
                            return true;
                        }
                    }
                    touchDelegate = null;
                    break;
                }
                break;
            case 1:
            case 3:
                touchDelegate = this.leT;
                this.leT = null;
                break;
            case 2:
                touchDelegate = this.leT;
                break;
            default:
                touchDelegate = null;
                break;
        }
        if (touchDelegate == null) {
            return false;
        }
        return touchDelegate.onTouchEvent(motionEvent);
    }
}
