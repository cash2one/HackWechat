package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.t;
import android.support.v7.a.a.a;
import android.util.AttributeSet;
import android.widget.RadioButton;

public class AppCompatRadioButton extends RadioButton implements t {
    private h Pc;
    private g Pi;

    public AppCompatRadioButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.radioButtonStyle);
    }

    public AppCompatRadioButton(Context context, AttributeSet attributeSet, int i) {
        super(am.r(context), attributeSet, i);
        this.Pc = h.ey();
        this.Pi = new g(this, this.Pc);
        this.Pi.b(attributeSet, i);
    }

    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        if (this.Pi != null) {
            this.Pi.ew();
        }
    }

    public void setButtonDrawable(int i) {
        setButtonDrawable(this.Pc != null ? this.Pc.a(getContext(), i, false) : android.support.v4.content.a.b(getContext(), i));
    }

    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        return this.Pi != null ? this.Pi.aS(compoundPaddingLeft) : compoundPaddingLeft;
    }

    public final void e(ColorStateList colorStateList) {
        if (this.Pi != null) {
            this.Pi.e(colorStateList);
        }
    }

    public final void b(Mode mode) {
        if (this.Pi != null) {
            this.Pi.b(mode);
        }
    }
}
