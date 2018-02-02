package com.tencent.mm.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.test.suitebuilder.annotation.Suppress;
import android.text.Spannable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.sdk.platformtools.x;

public class MMTextView extends TextView {
    private long gAc = -1;
    public b yxa = null;
    private GestureDetector yxb = null;
    private a zvA = null;
    private boolean zvw = false;
    private boolean zvx = false;
    private boolean zvy = false;
    private boolean zvz = false;

    public MMTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public MMTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.yxb = new GestureDetector(getContext(), new 1(this));
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        boolean z = action == 1 && this.zvw;
        if (z) {
            x.d("MicroMsg.MMTextView", "ignore Action Up Event this time");
            return true;
        }
        boolean z2;
        if (action == 0) {
            this.zvw = false;
        }
        if (this.yxa == null || this.yxb == null) {
            z2 = false;
        } else {
            z2 = this.yxb.onTouchEvent(motionEvent);
        }
        if (z2) {
            return z2;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Suppress
    public void setText(CharSequence charSequence, BufferType bufferType) {
        super.setText(charSequence, bufferType);
        if (this.zvA != null && this.zvx && (charSequence instanceof Spannable) && ((Spannable) charSequence).getSpans(0, charSequence.length(), Object.class) != null) {
            this.zvA.a(charSequence, this.gAc);
        }
        this.zvy = false;
    }

    public void cancelLongPress() {
        x.d("MicroMsg.MMTextView", "cancelLongPress , should ignore Action Up Event next time");
        this.zvw = true;
        super.cancelLongPress();
    }

    public boolean performLongClick() {
        x.d("MicroMsg.MMTextView", "performLongClick , should ignore Action Up Event next time");
        this.zvw = true;
        return super.performLongClick();
    }

    protected void onMeasure(int i, int i2) {
        try {
            super.onMeasure(i, i2);
        } catch (Throwable th) {
            x.printErrStackTrace("MicroMsg.MMTextView", th, "", new Object[0]);
        }
    }

    protected void onDraw(Canvas canvas) {
        try {
            super.onDraw(canvas);
        } catch (Throwable th) {
            x.printErrStackTrace("MicroMsg.MMTextView", th, "", new Object[0]);
        }
    }

    public boolean onPreDraw() {
        try {
            return super.onPreDraw();
        } catch (Throwable th) {
            return true;
        }
    }

    public int getBaseline() {
        try {
            return super.getBaseline();
        } catch (Throwable th) {
            x.printErrStackTrace("MicroMsg.MMTextView", th, "", new Object[0]);
            return -1;
        }
    }
}
