package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.mogic.WxViewPager;

public class CustomViewPager extends WxViewPager {
    public boolean DN = true;
    public boolean xXJ = true;

    public CustomViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected final boolean H(float f, float f2) {
        if (this.xXJ) {
            return super.H(f, f2);
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.DN) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.DN) {
            try {
                z = super.onTouchEvent(motionEvent);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.CustomViewPager", e, "get a Exception", new Object[z]);
            }
        }
        return z;
    }
}
