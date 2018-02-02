package com.tencent.mm.plugin.appbrand.jsapi.map;

import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

class b$1 implements OnTouchListener {
    final /* synthetic */ ImageView jlT;
    final /* synthetic */ b jlU;

    b$1(b bVar, ImageView imageView) {
        this.jlU = bVar;
        this.jlT = imageView;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.jlT.setColorFilter(Color.parseColor("#88888888"));
        } else if (action == 3 || action == 1) {
            this.jlT.clearColorFilter();
        }
        return false;
    }
}
