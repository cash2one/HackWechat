package android.support.design.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.design.a.h;
import android.support.design.a.i;
import android.support.v4.view.z;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class ScrimInsetsFrameLayout extends FrameLayout {
    private Drawable ew;
    private Rect ex;
    private Rect ey;

    public ScrimInsetsFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScrimInsetsFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ey = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.db, i, h.bL);
        this.ew = obtainStyledAttributes.getDrawable(i.dc);
        obtainStyledAttributes.recycle();
        setWillNotDraw(true);
        z.b(this, new 1(this));
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.ex != null && this.ew != null) {
            int save = canvas.save();
            canvas.translate((float) getScrollX(), (float) getScrollY());
            this.ey.set(0, 0, width, this.ex.top);
            this.ew.setBounds(this.ey);
            this.ew.draw(canvas);
            this.ey.set(0, height - this.ex.bottom, width, height);
            this.ew.setBounds(this.ey);
            this.ew.draw(canvas);
            this.ey.set(0, this.ex.top, this.ex.left, height - this.ex.bottom);
            this.ew.setBounds(this.ey);
            this.ew.draw(canvas);
            this.ey.set(width - this.ex.right, this.ex.top, width, height - this.ex.bottom);
            this.ew.setBounds(this.ey);
            this.ew.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.ew != null) {
            this.ew.setCallback(this);
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.ew != null) {
            this.ew.setCallback(null);
        }
    }

    public void a(Rect rect) {
    }
}
