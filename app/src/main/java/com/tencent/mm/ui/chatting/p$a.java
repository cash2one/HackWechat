package com.tencent.mm.ui.chatting;

import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.mm.plugin.appbrand.jsapi.map.h;

public class p$a implements OnTouchListener {
    private int su;

    public p$a() {
        this(Color.argb(255, h.CTRL_INDEX, h.CTRL_INDEX, h.CTRL_INDEX));
    }

    private p$a(int i) {
        this.su = i;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        Drawable drawable;
        int action = motionEvent.getAction();
        if (view instanceof ImageView) {
            drawable = ((ImageView) view).getDrawable();
        } else {
            drawable = view.getBackground();
        }
        if (drawable != null) {
            if (action == 0) {
                drawable.setColorFilter(this.su, Mode.MULTIPLY);
            } else if (action == 3 || action == 1) {
                drawable.clearColorFilter();
            }
        }
        return false;
    }
}
