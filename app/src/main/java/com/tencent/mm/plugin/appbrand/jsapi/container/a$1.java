package com.tencent.mm.plugin.appbrand.jsapi.container;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.tencent.mm.plugin.appbrand.jsapi.m.c;

class a$1 implements OnTouchListener {
    final /* synthetic */ a jjc;

    a$1(a aVar) {
        this.jjc = aVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            c.a((ViewGroup) view, motionEvent);
        }
        return false;
    }
}
