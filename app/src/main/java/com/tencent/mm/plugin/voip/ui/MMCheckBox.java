package com.tencent.mm.plugin.voip.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.CheckBox;
import com.tencent.mm.plugin.gif.MMGIFException;

public class MMCheckBox extends CheckBox {
    private Drawable spK;
    private int spL;

    public MMCheckBox(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public MMCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setButtonDrawable(int i) {
        if (i == 0 || i != this.spL) {
            this.spL = i;
            Drawable drawable = null;
            if (this.spL != 0) {
                drawable = getResources().getDrawable(this.spL);
            }
            setButtonDrawable(drawable);
        }
    }

    public void setButtonDrawable(Drawable drawable) {
        this.spK = drawable;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.spK != null) {
            this.spK.setState(getDrawableState());
            invalidate();
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.spK;
    }

    @TargetApi(11)
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (VERSION.SDK_INT >= 11 && this.spK != null) {
            this.spK.jumpToCurrentState();
        }
    }

    protected void onDraw(Canvas canvas) {
        int i = 0;
        super.onDraw(canvas);
        Drawable drawable = this.spK;
        if (drawable != null) {
            int gravity = getGravity() & MMGIFException.D_GIF_ERR_IMAGE_DEFECT;
            int gravity2 = getGravity() & 7;
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            switch (gravity) {
                case 16:
                    gravity = (getHeight() - intrinsicHeight) / 2;
                    break;
                case 80:
                    gravity = getHeight() - intrinsicHeight;
                    break;
                default:
                    gravity = 0;
                    break;
            }
            switch (gravity2) {
                case 1:
                    i = (getWidth() - intrinsicWidth) / 2;
                    break;
                case 5:
                    i = getWidth() - intrinsicWidth;
                    break;
            }
            drawable.setBounds(i, gravity, i + intrinsicWidth, intrinsicHeight + gravity);
            drawable.draw(canvas);
        }
    }
}
