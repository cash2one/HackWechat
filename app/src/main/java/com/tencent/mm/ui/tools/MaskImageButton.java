package com.tencent.mm.ui.tools;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.ImageButton;
import com.tencent.mm.sdk.platformtools.af;

public class MaskImageButton extends ImageButton {
    private int a = 90;
    private int b = 0;
    private int g = 0;
    private int r = 0;
    private af rqY = new af(Looper.getMainLooper());
    private Runnable rqZ = new 1(this);
    public Object zlH;

    public MaskImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setOnTouchListener(new 2(this));
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isPressed()) {
            canvas.drawARGB(this.a, this.r, this.g, this.b);
        }
    }
}
