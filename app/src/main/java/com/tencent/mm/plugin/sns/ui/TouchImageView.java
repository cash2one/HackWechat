package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import junit.framework.Assert;

public class TouchImageView extends ImageView {
    private int a = 90;
    private int b = 0;
    private boolean fqP = true;
    private int g = 0;
    private int r = 0;
    private Rect rMX = new Rect();
    private Paint rMY = new Paint();
    af rqY;
    Runnable rqZ;

    public TouchImageView(Context context) {
        super(context);
        init();
    }

    public TouchImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        this.rqY = new af();
        this.rqZ = new 1(this);
        super.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ TouchImageView rMZ;

            {
                this.rMZ = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (!this.rMZ.fqP) {
                    return false;
                }
                TouchImageView touchImageView = this.rMZ;
                switch (motionEvent.getAction()) {
                    case 0:
                        view.setPressed(true);
                        view.invalidate();
                        touchImageView.rqY.removeCallbacks(touchImageView.rqZ);
                        break;
                    case 1:
                    case 3:
                        touchImageView.rqY.post(touchImageView.rqZ);
                        break;
                }
                if (touchImageView.isClickable() || touchImageView.isLongClickable()) {
                    return false;
                }
                return true;
            }
        });
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isPressed()) {
            this.rMX.left = getPaddingLeft();
            this.rMX.top = getPaddingTop();
            this.rMX.right = getWidth() - getPaddingRight();
            this.rMX.bottom = getHeight() - getPaddingBottom();
            this.rMY.setARGB(this.a, this.r, this.g, this.b);
            canvas.drawRect(this.rMX, this.rMY);
        }
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        Assert.assertTrue(false);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        x.d("MicroMsg.MaskImageView", "onAttachedToWindow");
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        x.d("MicroMsg.MaskImageView", "onDetachedFromWindow");
    }
}
