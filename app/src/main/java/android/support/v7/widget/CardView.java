package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v7.b.a.a;
import android.support.v7.b.a.c;
import android.support.v7.b.a.d;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;

public class CardView extends FrameLayout implements o {
    private static final int[] Qr = new int[]{16842801};
    private static final q Qs;
    private boolean Qt;
    private int Qu;
    private int Qv;
    private final Rect Qw = new Rect();
    private final Rect Qx = new Rect();
    private boolean hZ;

    static {
        if (VERSION.SDK_INT >= 21) {
            Qs = new n();
        } else if (VERSION.SDK_INT >= 17) {
            Qs = new r();
        } else {
            Qs = new p();
        }
        Qs.eE();
    }

    public CardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet, 0);
    }

    public CardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet, i);
    }

    public void setPadding(int i, int i2, int i3, int i4) {
    }

    public void setPaddingRelative(int i, int i2, int i3, int i4) {
    }

    public final boolean eC() {
        return this.hZ;
    }

    protected void onMeasure(int i, int i2) {
        if (Qs instanceof n) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = MeasureSpec.getMode(i);
        switch (mode) {
            case Integer.MIN_VALUE:
            case 1073741824:
                i = MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) Qs.a(this)), MeasureSpec.getSize(i)), mode);
                break;
        }
        mode = MeasureSpec.getMode(i2);
        switch (mode) {
            case Integer.MIN_VALUE:
            case 1073741824:
                i2 = MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) Qs.b(this)), MeasureSpec.getSize(i2)), mode);
                break;
        }
        super.onMeasure(i, i2);
    }

    private void a(Context context, AttributeSet attributeSet, int i) {
        int color;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.Ja, i, c.IZ);
        if (obtainStyledAttributes.hasValue(d.Jd)) {
            color = obtainStyledAttributes.getColor(d.Jd, 0);
        } else {
            TypedArray obtainStyledAttributes2 = getContext().obtainStyledAttributes(Qr);
            int color2 = obtainStyledAttributes2.getColor(0, 0);
            obtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color2, fArr);
            color = fArr[2] > 0.5f ? getResources().getColor(a.IV) : getResources().getColor(a.IU);
        }
        float dimension = obtainStyledAttributes.getDimension(d.Je, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(d.Jf, 0.0f);
        float dimension3 = obtainStyledAttributes.getDimension(d.Jg, 0.0f);
        this.hZ = obtainStyledAttributes.getBoolean(d.Jh, false);
        this.Qt = obtainStyledAttributes.getBoolean(d.Ji, true);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(d.Jj, 0);
        this.Qw.left = obtainStyledAttributes.getDimensionPixelSize(d.Jk, dimensionPixelSize);
        this.Qw.top = obtainStyledAttributes.getDimensionPixelSize(d.Jm, dimensionPixelSize);
        this.Qw.right = obtainStyledAttributes.getDimensionPixelSize(d.Jl, dimensionPixelSize);
        this.Qw.bottom = obtainStyledAttributes.getDimensionPixelSize(d.Jn, dimensionPixelSize);
        if (dimension2 > dimension3) {
            dimension3 = dimension2;
        }
        this.Qu = obtainStyledAttributes.getDimensionPixelSize(d.Jb, 0);
        this.Qv = obtainStyledAttributes.getDimensionPixelSize(d.Jc, 0);
        obtainStyledAttributes.recycle();
        Qs.a(this, context, color, dimension, dimension2, dimension3);
    }

    public void setMinimumWidth(int i) {
        this.Qu = i;
        super.setMinimumWidth(i);
    }

    public void setMinimumHeight(int i) {
        this.Qv = i;
        super.setMinimumHeight(i);
    }

    public final void B(int i, int i2) {
        if (i > this.Qu) {
            super.setMinimumWidth(i);
        }
        if (i2 > this.Qv) {
            super.setMinimumHeight(i2);
        }
    }

    public final void d(int i, int i2, int i3, int i4) {
        this.Qx.set(i, i2, i3, i4);
        super.setPadding(this.Qw.left + i, this.Qw.top + i2, this.Qw.right + i3, this.Qw.bottom + i4);
    }

    public final boolean eD() {
        return this.Qt;
    }
}
