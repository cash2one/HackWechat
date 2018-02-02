package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;

final class m extends l {
    private static final int[] Qm = new int[]{16843666, 16843667};
    private an Qn;
    private an Qo;

    m(TextView textView) {
        super(textView);
    }

    final void b(AttributeSet attributeSet, int i) {
        super.b(attributeSet, i);
        Context context = this.Qh.getContext();
        h ey = h.ey();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Qm, i, 0);
        if (obtainStyledAttributes.hasValue(0)) {
            this.Qn = l.a(context, ey, obtainStyledAttributes.getResourceId(0, 0));
        }
        if (obtainStyledAttributes.hasValue(1)) {
            this.Qo = l.a(context, ey, obtainStyledAttributes.getResourceId(1, 0));
        }
        obtainStyledAttributes.recycle();
    }

    final void eA() {
        super.eA();
        if (this.Qn != null || this.Qo != null) {
            Drawable[] compoundDrawablesRelative = this.Qh.getCompoundDrawablesRelative();
            a(compoundDrawablesRelative[0], this.Qn);
            a(compoundDrawablesRelative[2], this.Qo);
        }
    }
}
