package com.tencent.mm.plugin.appbrand.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.FrameLayout;

public final class e extends FrameLayout {
    public e(Context context) {
        super(context);
        setWillNotDraw(false);
    }

    protected final void dispatchDraw(Canvas canvas) {
        if (!willNotDraw()) {
            super.dispatchDraw(canvas);
        }
    }
}
