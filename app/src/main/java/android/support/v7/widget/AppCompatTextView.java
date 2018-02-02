package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.view.x;
import android.util.AttributeSet;
import android.widget.TextView;

public class AppCompatTextView extends TextView implements x {
    private h Pc;
    private f Pd;
    private l Pe;

    public AppCompatTextView(Context context) {
        this(context, null);
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet, int i) {
        super(am.r(context), attributeSet, i);
        this.Pc = h.ey();
        this.Pd = new f(this, this.Pc);
        this.Pd.b(attributeSet, i);
        this.Pe = l.d(this);
        this.Pe.b(attributeSet, i);
        this.Pe.eA();
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.Pd != null) {
            this.Pd.aR(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.Pd != null) {
            this.Pd.f(null);
        }
    }

    public final void d(ColorStateList colorStateList) {
        if (this.Pd != null) {
            this.Pd.d(colorStateList);
        }
    }

    public final ColorStateList bM() {
        return this.Pd != null ? this.Pd.bM() : null;
    }

    public final void a(Mode mode) {
        if (this.Pd != null) {
            this.Pd.a(mode);
        }
    }

    public final Mode bN() {
        return this.Pd != null ? this.Pd.bN() : null;
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.Pe != null) {
            this.Pe.h(context, i);
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.Pd != null) {
            this.Pd.ev();
        }
        if (this.Pe != null) {
            this.Pe.eA();
        }
    }
}
