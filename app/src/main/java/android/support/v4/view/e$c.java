package android.support.v4.view;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;

class e$c implements e$a {
    private final GestureDetector xj;

    public e$c(Context context, OnGestureListener onGestureListener, Handler handler) {
        this.xj = new GestureDetector(context, onGestureListener, null);
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return this.xj.onTouchEvent(motionEvent);
    }
}
