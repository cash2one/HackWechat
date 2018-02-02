package com.tencent.mm.plugin.game.ui;

import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.mm.plugin.appbrand.jsapi.map.h;

public final class y implements OnTouchListener {
    private int su;

    public y() {
        this(Color.argb(221, h.CTRL_INDEX, h.CTRL_INDEX, h.CTRL_INDEX));
    }

    private y(int i) {
        this.su = i;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        Drawable drawable;
        if (action == 0) {
            if (view instanceof ImageView) {
                ImageView imageView = (ImageView) view;
                drawable = imageView.getDrawable();
                if (drawable != null) {
                    drawable.setColorFilter(this.su, Mode.MULTIPLY);
                    imageView.setImageDrawable(drawable);
                }
            } else if (view.getBackground() != null) {
                view.getBackground().setColorFilter(this.su, Mode.MULTIPLY);
            }
        } else if (action == 1 || action == 3) {
            if (view instanceof ImageView) {
                drawable = ((ImageView) view).getDrawable();
                if (drawable != null) {
                    drawable.clearColorFilter();
                }
            } else {
                drawable = view.getBackground();
                if (drawable != null) {
                    drawable.clearColorFilter();
                }
            }
        }
        return false;
    }
}
