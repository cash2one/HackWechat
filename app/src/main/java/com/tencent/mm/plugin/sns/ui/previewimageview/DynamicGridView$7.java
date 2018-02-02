package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

class DynamicGridView$7 implements TypeEvaluator<Rect> {
    final /* synthetic */ DynamicGridView rRm;

    DynamicGridView$7(DynamicGridView dynamicGridView) {
        this.rRm = dynamicGridView;
    }

    public final /* synthetic */ Object evaluate(float f, Object obj, Object obj2) {
        Rect rect = (Rect) obj;
        Rect rect2 = (Rect) obj2;
        return new Rect(c(rect.left, rect2.left, f), c(rect.top, rect2.top, f), c(rect.right, rect2.right, f), c(rect.bottom, rect2.bottom, f));
    }

    private static int c(int i, int i2, float f) {
        return (int) (((float) i) + (((float) (i2 - i)) * f));
    }
}
