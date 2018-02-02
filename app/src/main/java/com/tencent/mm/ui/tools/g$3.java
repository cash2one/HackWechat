package com.tencent.mm.ui.tools;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import com.tencent.mm.ui.tools.g.a;

class g$3 extends ScaleAnimation {
    final /* synthetic */ View rpV;
    final /* synthetic */ g zkR;
    final /* synthetic */ a zkS;

    g$3(g gVar, float f, float f2, View view, a aVar) {
        this.zkR = gVar;
        this.rpV = view;
        this.zkS = aVar;
        super(1.0f, f, 1.0f, f2);
    }

    protected final void applyTransformation(float f, Transformation transformation) {
        if (!(this.zkR.rpz == 0 || this.zkR.rpA == 0 || this.zkR.zkM != 1.0f)) {
            Rect rect = new Rect();
            this.rpV.getGlobalVisibleRect(rect);
            int i = (rect.right - rect.left) / 2;
            int i2 = ((rect.bottom - rect.top) + this.zkR.rpH) / 2;
            int i3 = (int) (((((float) (this.zkR.rpz - this.zkR.mWidth)) * (1.0f - f)) + ((float) this.zkR.mWidth)) / (1.0f - ((1.0f - this.zkR.rpF) * f)));
            int i4 = (int) (((((float) (this.zkR.rpA - this.zkR.mHeight)) * (1.0f - f)) + ((float) this.zkR.mHeight)) / (1.0f - ((1.0f - this.zkR.rpF) * f)));
            if (this.zkR.zkM != 1.0f) {
                this.zkR.rpF = this.zkR.zkK / this.zkR.zkM;
                i4 = rect.right;
                i4 = rect.left;
                i = (rect.right + rect.left) / 2;
                i2 = (this.zkR.zkO - rect.top) + ((int) (((float) this.zkR.rpA) / 2.0f));
                i3 = (int) (((((float) (this.zkR.rpz - this.zkR.mWidth)) * (1.0f - f)) + ((float) this.zkR.mWidth)) / (1.0f - ((1.0f - this.zkR.rpF) * f)));
                i4 = (int) (((((float) (this.zkR.rpA - this.zkR.mHeight)) * (1.0f - f)) + ((float) this.zkR.mHeight)) / (1.0f - ((1.0f - this.zkR.rpF) * f)));
            }
            int i5 = (int) (((float) (i - (i3 / 2))) + ((((float) this.zkR.rpI) * f) / (1.0f - ((1.0f - this.zkR.rpF) * f))));
            int i6 = (int) ((((float) (i2 - (i4 / 2))) - ((((float) this.zkR.rpH) * (1.0f - f)) / 2.0f)) + ((((float) this.zkR.rpK) * f) / (1.0f - ((1.0f - this.zkR.rpF) * f))));
            i3 = (int) (((float) ((i3 / 2) + i)) - ((((float) this.zkR.rpJ) * f) / (1.0f - ((1.0f - this.zkR.rpF) * f))));
            i4 = (int) (((float) ((i4 / 2) + i2)) - ((((float) this.zkR.rpL) * f) / (1.0f - ((1.0f - this.zkR.rpF) * f))));
            if (VERSION.SDK_INT >= 21) {
                this.rpV.setClipBounds(new Rect(i5, i6, i3, i4));
            } else if (VERSION.SDK_INT >= 18) {
                if (this.zkS != null) {
                    this.zkS.s(i5, i6, i3, i4);
                } else {
                    this.rpV.setClipBounds(new Rect(i5 + this.rpV.getScrollX(), i6, i3 + this.rpV.getScrollX(), i4));
                }
            }
        }
        super.applyTransformation(f, transformation);
    }
}
