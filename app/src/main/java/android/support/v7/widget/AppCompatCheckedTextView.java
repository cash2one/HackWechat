package android.support.v7.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckedTextView;

public class AppCompatCheckedTextView extends CheckedTextView {
    private static final int[] KP = new int[]{16843016};
    private h Pc;
    private l Pe;

    public AppCompatCheckedTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16843720);
    }

    public AppCompatCheckedTextView(Context context, AttributeSet attributeSet, int i) {
        super(am.r(context), attributeSet, i);
        this.Pe = l.d(this);
        this.Pe.b(attributeSet, i);
        this.Pe.eA();
        this.Pc = h.ey();
        ap a = ap.a(getContext(), attributeSet, KP, i);
        setCheckMarkDrawable(a.getDrawable(0));
        a.Zu.recycle();
    }

    public void setCheckMarkDrawable(int i) {
        if (this.Pc != null) {
            setCheckMarkDrawable(this.Pc.a(getContext(), i, false));
        } else {
            super.setCheckMarkDrawable(i);
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.Pe != null) {
            this.Pe.h(context, i);
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.Pe != null) {
            this.Pe.eA();
        }
    }
}
