package com.tencent.mm.plugin.appbrand.widget.input;

import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.EditText;
import com.tencent.mm.plugin.appbrand.jsapi.m.c.f;
import com.tencent.mm.plugin.appbrand.widget.b.b;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Locale;

final class ac<Input extends EditText & z> {
    final String TAG;
    final Input jZo;
    final float jZp;
    f jZq;
    MotionEvent jZr;
    boolean jZs = false;
    final Runnable jZt = new 1(this);
    final Runnable jZu = new 2(this);

    ac(Input input) {
        this.jZo = input;
        this.TAG = "MicroMsg.AppBrand.InputFakeTapEventEmitter" + String.format(Locale.US, "[%s]", new Object[]{input.toString()});
        this.jZp = (float) ViewConfiguration.get(input.getContext()).getScaledTouchSlop();
    }

    final void ani() {
        this.jZs = false;
        this.jZo.removeCallbacks(this.jZt);
        this.jZo.removeCallbacks(this.jZu);
        this.jZq = null;
        if (this.jZr != null) {
            this.jZr.recycle();
            this.jZr = null;
        }
    }

    final boolean a(MotionEvent motionEvent, MotionEvent motionEvent2) {
        float x = motionEvent.getX(motionEvent.getActionIndex());
        float y = motionEvent.getY(motionEvent.getActionIndex());
        x.v(this.TAG, "[apptouch] checkTapArea touchSlop %f, X[%f:%f], Y[%f:%f], [%s : %s]", new Object[]{Float.valueOf(this.jZp), Float.valueOf(x), Float.valueOf(motionEvent2.getX(motionEvent2.getActionIndex())), Float.valueOf(y), Float.valueOf(motionEvent2.getY(motionEvent2.getActionIndex())), b.C(motionEvent), b.C(motionEvent2)});
        if (Math.abs(motionEvent2.getY(motionEvent2.getActionIndex()) - y) > this.jZp || Math.abs(r4 - x) > this.jZp) {
            return false;
        }
        return true;
    }
}
