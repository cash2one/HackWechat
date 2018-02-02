package com.tencent.mm.plugin.sns.ui;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import com.tencent.mm.plugin.sns.ui.b.a;

class b$2 extends ScaleAnimation {
    final /* synthetic */ b rpU;
    final /* synthetic */ View rpV;
    final /* synthetic */ a rpW = null;

    b$2(b bVar, float f, float f2, View view, a aVar) {
        this.rpU = bVar;
        this.rpV = view;
        super(1.0f, f, 1.0f, f2);
    }

    protected final void applyTransformation(float f, Transformation transformation) {
        if (!(this.rpU.rpz == 0 || this.rpU.rpA == 0)) {
            Rect rect = new Rect();
            this.rpV.getGlobalVisibleRect(rect);
            int i = (rect.right - rect.left) / 2;
            int i2 = ((rect.bottom - rect.top) + this.rpU.rpH) / 2;
            int i3 = (int) (((((float) (this.rpU.rpz - this.rpU.mWidth)) * (1.0f - f)) + ((float) this.rpU.mWidth)) / (1.0f - ((1.0f - this.rpU.rpF) * f)));
            int i4 = (int) (((((float) (this.rpU.rpA - this.rpU.mHeight)) * (1.0f - f)) + ((float) this.rpU.mHeight)) / (1.0f - ((1.0f - this.rpU.rpF) * f)));
            int i5 = (int) (((float) (i - (i3 / 2))) + ((((float) this.rpU.rpI) * f) / (1.0f - ((1.0f - this.rpU.rpF) * f))));
            int i6 = (int) ((((float) (i2 - (i4 / 2))) - ((((float) this.rpU.rpH) * (1.0f - f)) / 2.0f)) + ((((float) this.rpU.rpK) * f) / (1.0f - ((1.0f - this.rpU.rpF) * f))));
            i = (int) (((float) (i + (i3 / 2))) - ((((float) this.rpU.rpJ) * f) / (1.0f - ((1.0f - this.rpU.rpF) * f))));
            i2 = (int) (((float) (i2 + (i4 / 2))) - ((((float) this.rpU.rpL) * f) / (1.0f - ((1.0f - this.rpU.rpF) * f))));
            if (VERSION.SDK_INT >= 21) {
                this.rpV.setClipBounds(new Rect(i5, i6, i, i2));
            } else if (VERSION.SDK_INT >= 18 && this.rpW == null) {
                this.rpV.setClipBounds(new Rect(i5 + this.rpV.getScrollX(), i6, i + this.rpV.getScrollX(), i2));
            }
        }
        super.applyTransformation(f, transformation);
    }
}
