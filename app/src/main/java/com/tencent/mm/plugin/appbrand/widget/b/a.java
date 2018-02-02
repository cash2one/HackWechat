package com.tencent.mm.plugin.appbrand.widget.b;

import android.graphics.Matrix;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.appbrand.p.j;

public final class a {
    public static boolean bP(View view) {
        return view != null && (view instanceof d) && ((d) view).ams();
    }

    public static boolean a(ViewGroup viewGroup, MotionEvent motionEvent, View view, int i) {
        if (viewGroup == null || motionEvent == null) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 3) {
            motionEvent.setAction(3);
            if (view == null) {
                return false;
            }
            boolean dispatchTouchEvent = view.dispatchTouchEvent(motionEvent);
            motionEvent.setAction(action);
            return dispatchTouchEvent;
        }
        int intValue = ((Integer) j.e("getPointerIdBits", motionEvent, Integer.valueOf(0))).intValue();
        action = intValue & i;
        if (action == 0) {
            return false;
        }
        MotionEvent motionEvent2;
        if (action != intValue) {
            motionEvent2 = (MotionEvent) j.a("split", motionEvent, new Class[]{Integer.class}, new Object[]{Integer.valueOf(action)}, MotionEvent.obtain(motionEvent));
        } else if (view != null && !((Boolean) j.e("hasIdentityMatrix", view, Boolean.valueOf(false))).booleanValue()) {
            motionEvent2 = MotionEvent.obtain(motionEvent);
        } else if (view == null) {
            return false;
        } else {
            float scrollX = (float) (viewGroup.getScrollX() - view.getLeft());
            float scrollY = (float) (viewGroup.getScrollY() - view.getTop());
            motionEvent.offsetLocation(scrollX, scrollY);
            dispatchTouchEvent = view.dispatchTouchEvent(motionEvent);
            motionEvent.offsetLocation(-scrollX, -scrollY);
            return dispatchTouchEvent;
        }
        if (view == null) {
            return false;
        }
        motionEvent2.offsetLocation((float) (viewGroup.getScrollX() - view.getLeft()), (float) (viewGroup.getScrollY() - view.getTop()));
        if (!((Boolean) j.e("hasIdentityMatrix", view, Boolean.valueOf(false))).booleanValue()) {
            motionEvent2.transform((Matrix) j.e("getInverseMatrix", view, new Matrix()));
        }
        dispatchTouchEvent = view.dispatchTouchEvent(motionEvent2);
        motionEvent2.recycle();
        return dispatchTouchEvent;
    }
}
