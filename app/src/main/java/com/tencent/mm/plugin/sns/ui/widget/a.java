package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public final class a extends Animation {
    private Context context;
    private final float fdk;
    private final float fdl;
    private float gOa = 1.0f;
    private final boolean rRA;
    private Camera rRB;
    private final float rRx;
    private final float rRy;
    private final float rRz;

    public a(Context context, float f, float f2, float f3, float f4, boolean z) {
        this.context = context;
        this.rRx = f;
        this.rRy = f2;
        this.fdk = f3;
        this.fdl = f4;
        this.rRz = 150.0f;
        this.rRA = z;
        this.gOa = context.getResources().getDisplayMetrics().density;
    }

    public final void initialize(int i, int i2, int i3, int i4) {
        super.initialize(i, i2, i3, i4);
        this.rRB = new Camera();
    }

    protected final void applyTransformation(float f, Transformation transformation) {
        float f2 = this.rRx + ((this.rRy - this.rRx) * f);
        float f3 = this.fdk;
        float f4 = this.fdl;
        Camera camera = this.rRB;
        Matrix matrix = transformation.getMatrix();
        camera.save();
        if (this.rRA) {
            camera.translate(0.0f, 0.0f, this.rRz * f);
        } else {
            camera.translate(0.0f, 0.0f, this.rRz * (1.0f - f));
        }
        camera.rotateY(f2);
        camera.getMatrix(matrix);
        camera.restore();
        float[] fArr = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        matrix.getValues(fArr);
        fArr[6] = fArr[6] / this.gOa;
        matrix.setValues(fArr);
        matrix.preTranslate(-f3, -f4);
        matrix.postTranslate(f3, f4);
    }
}
