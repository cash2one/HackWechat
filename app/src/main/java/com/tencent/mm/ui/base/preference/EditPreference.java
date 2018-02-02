package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.EditText;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.base.preference.Preference.a;
import com.tencent.mm.w.a.e;
import com.tencent.mm.w.a.k;

public class EditPreference extends Preference {
    private i pyk;
    String value;
    private a yia;
    a yif;
    private EditText yig;

    public EditPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EditPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void a(a aVar) {
        this.yia = aVar;
    }

    public final void showDialog() {
        View view;
        if (this.yig != null) {
            view = this.yig;
        } else {
            view = new EditText(this.mContext);
            view.setLayoutParams(new LayoutParams(-1, -2));
            view.setSingleLine(true);
            view.setText(this.value);
        }
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof MarginLayoutParams) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) layoutParams;
            int dimensionPixelSize = view.getResources().getDimensionPixelSize(e.bvv);
            marginLayoutParams.leftMargin = dimensionPixelSize;
            marginLayoutParams.rightMargin = dimensionPixelSize;
            marginLayoutParams.topMargin = dimensionPixelSize;
            marginLayoutParams.bottomMargin = dimensionPixelSize;
        }
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        this.pyk = h.a(this.mContext, getTitle().toString(), view, com.tencent.mm.bv.a.ac(this.mContext, k.dFU), com.tencent.mm.bv.a.ac(this.mContext, k.dEn), new 1(this, view), new 2(this));
    }
}
