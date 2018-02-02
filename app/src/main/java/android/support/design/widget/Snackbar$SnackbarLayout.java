package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.a.d;
import android.support.design.a.e;
import android.support.design.a.f;
import android.support.design.a.i;
import android.support.v4.view.z;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Snackbar$SnackbarLayout extends LinearLayout {
    private int iX;
    private int jA;
    b jB;
    a jC;
    TextView jy;
    Button jz;

    interface b {
        void ao();
    }

    public Snackbar$SnackbarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.dg);
        this.iX = obtainStyledAttributes.getDimensionPixelSize(i.dh, -1);
        this.jA = obtainStyledAttributes.getDimensionPixelSize(i.dj, -1);
        if (obtainStyledAttributes.hasValue(i.di)) {
            z.g(this, (float) obtainStyledAttributes.getDimensionPixelSize(i.di, 0));
        }
        obtainStyledAttributes.recycle();
        setClickable(true);
        LayoutInflater.from(context).inflate(f.bt, this);
        z.N(this);
        z.i(this, 1);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.jy = (TextView) findViewById(e.bo);
        this.jz = (Button) findViewById(e.bn);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.iX > 0 && getMeasuredWidth() > this.iX) {
            i = MeasureSpec.makeMeasureSpec(this.iX, 1073741824);
            super.onMeasure(i, i2);
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.bh);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(d.bg);
        int i3 = this.jy.getLayout().getLineCount() > 1 ? 1 : 0;
        if (i3 == 0 || this.jA <= 0 || this.jz.getMeasuredWidth() <= this.jA) {
            if (i3 == 0) {
                dimensionPixelSize = dimensionPixelSize2;
            }
            if (f(0, dimensionPixelSize, dimensionPixelSize)) {
                dimensionPixelSize = 1;
            }
            dimensionPixelSize = 0;
        } else {
            if (f(1, dimensionPixelSize, dimensionPixelSize - dimensionPixelSize2)) {
                dimensionPixelSize = 1;
            }
            dimensionPixelSize = 0;
        }
        if (dimensionPixelSize != 0) {
            super.onMeasure(i, i2);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.jB != null) {
            this.jB.ao();
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.jC != null) {
            this.jC.an();
        }
    }

    private boolean f(int i, int i2, int i3) {
        boolean z = false;
        if (i != getOrientation()) {
            setOrientation(i);
            z = true;
        }
        if (this.jy.getPaddingTop() == i2 && this.jy.getPaddingBottom() == i3) {
            return z;
        }
        View view = this.jy;
        if (z.ad(view)) {
            z.c(view, z.O(view), i2, z.P(view), i3);
        } else {
            view.setPadding(view.getPaddingLeft(), i2, view.getPaddingRight(), i3);
        }
        return true;
    }
}
