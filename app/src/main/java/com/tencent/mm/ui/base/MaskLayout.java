package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.m;

public class MaskLayout extends RelativeLayout {
    private ImageView myd;
    public View view;
    private Drawable yeW;

    public MaskLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaskLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.faI, i, 0);
        this.yeW = obtainStyledAttributes.getDrawable(m.gZl);
        obtainStyledAttributes.recycle();
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.view = findViewById(g.content);
        if (this.view == null) {
            x.d("MicroMsg.MaskLayout", "%s", new Object[]{"not found view by id, new one"});
            this.view = new View(getContext());
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.view.setLayoutParams(layoutParams);
            addView(this.view);
        }
        this.myd = new ImageView(getContext());
        this.myd.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.myd.setImageDrawable(this.yeW);
        addView(this.myd);
    }

    public final void cpP() {
        ER(a.yfc);
        this.myd.setImageBitmap(null);
    }

    public final void cpQ() {
        ER(a.yfc);
        this.myd.setImageDrawable(null);
    }

    public final void d(Bitmap bitmap, int i) {
        ER(i);
        this.myd.setImageBitmap(bitmap);
    }

    private void ER(int i) {
        removeView(this.myd);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        switch (1.yeX[i - 1]) {
            case 1:
                layoutParams.addRule(12);
                layoutParams.addRule(11);
                break;
            case 2:
                layoutParams.addRule(12);
                layoutParams.addRule(9);
                break;
            case 3:
                break;
            case 4:
                layoutParams.addRule(11);
                break;
            default:
                layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                break;
        }
        addView(this.myd, layoutParams);
    }
}
