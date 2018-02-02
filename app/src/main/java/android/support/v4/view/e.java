package android.support.v4.view;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;

public final class e {
    private final a wL;

    public e(Context context, OnGestureListener onGestureListener) {
        this(context, onGestureListener, (byte) 0);
    }

    private e(Context context, OnGestureListener onGestureListener, byte b) {
        if (VERSION.SDK_INT > 17) {
            this.wL = new c(context, onGestureListener, null);
        } else {
            this.wL = new b(context, onGestureListener, null);
        }
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return this.wL.onTouchEvent(motionEvent);
    }
}
