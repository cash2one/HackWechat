package com.tencent.mm.plugin.appbrand.game.c;

import android.content.Context;
import android.graphics.RectF;
import android.support.v7.widget.AppCompatButton;
import android.view.MotionEvent;

final class a extends AppCompatButton {
    private RectF iYi;
    private boolean iYj;
    private float iYk;
    private float iYl;

    public a(Context context) {
        super(context);
        setGravity(17);
        setText("vConsole");
        setTextColor(-1);
        float f = getContext().getResources().getDisplayMetrics().density;
        setPadding((int) (13.0f * f), (int) (4.0f * f), (int) (13.0f * f), (int) (f * 6.0f));
        setBackgroundDrawable(new a(this, (byte) 0));
    }

    private boolean q(float f, float f2) {
        if (this.iYi == null) {
            return false;
        }
        return this.iYi.contains(f, f2);
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.iYi = new RectF(getX(), getY(), getX() + ((float) getWidth()), getY() + ((float) getHeight()));
                this.iYj = false;
                break;
            case 1:
                if (!this.iYj && q(motionEvent.getRawX(), motionEvent.getRawY())) {
                    performClick();
                    break;
                }
            case 2:
                if (this.iYj || !q(motionEvent.getRawX(), motionEvent.getRawY())) {
                    setX(getX() + (motionEvent.getRawX() - this.iYk));
                    setY(getY() + (motionEvent.getRawY() - this.iYl));
                    requestLayout();
                    this.iYj = true;
                    break;
                }
        }
        this.iYk = motionEvent.getRawX();
        this.iYl = motionEvent.getRawY();
        return true;
    }
}
