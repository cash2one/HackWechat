package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.bv.a;
import com.tencent.mm.w.a.d;

public class MMImageButton extends FrameLayout {
    private ImageView fyg;
    private TextView pfA;

    public MMImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MMImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.fyg = new ImageView(context);
        this.fyg.setLayoutParams(layoutParams);
        addView(this.fyg);
        layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.pfA = new TextView(context);
        this.pfA.setLayoutParams(layoutParams);
        this.pfA.setClickable(false);
        this.pfA.setFocusable(false);
        this.pfA.setFocusableInTouchMode(false);
        this.pfA.setTextColor(a.Z(context, d.gUB));
        addView(this.pfA);
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.pfA.setEnabled(z);
        this.fyg.setEnabled(z);
    }
}
