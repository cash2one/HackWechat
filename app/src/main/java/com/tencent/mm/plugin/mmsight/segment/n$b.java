package com.tencent.mm.plugin.mmsight.segment;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

class n$b extends Drawable {
    boolean ozA = false;
    private Drawable ozB;
    private Drawable ozC;
    final /* synthetic */ n ozv;

    public n$b(n nVar, Drawable drawable, Drawable drawable2) {
        this.ozv = nVar;
        this.ozB = drawable;
        this.ozC = drawable2;
        this.ozA = false;
    }

    public final void draw(Canvas canvas) {
        Drawable drawable;
        if (this.ozA) {
            drawable = this.ozB;
        } else {
            drawable = this.ozC;
        }
        if (!getBounds().equals(drawable.getBounds())) {
            drawable.setBounds(getBounds());
        }
        drawable.draw(canvas);
    }

    public final void setAlpha(int i) {
        this.ozB.setAlpha(i);
        this.ozC.setAlpha(i);
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.ozB.setColorFilter(colorFilter);
        this.ozC.setColorFilter(colorFilter);
    }

    public final int getOpacity() {
        return -3;
    }
}
