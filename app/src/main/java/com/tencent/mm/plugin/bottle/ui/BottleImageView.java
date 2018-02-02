package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.widget.ImageView;

public class BottleImageView extends ImageView {
    int Rn;
    int Ro;
    int Rp;
    int Rq;
    Context context;
    private int kBX;
    private int kBY;
    Animation kBZ = new 1(this);

    public BottleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
        arL();
    }

    public BottleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        arL();
    }

    private void arL() {
        Drawable background = getBackground();
        if (background != null) {
            this.kBX = background.getIntrinsicWidth();
            this.kBY = background.getIntrinsicHeight();
        }
    }
}
