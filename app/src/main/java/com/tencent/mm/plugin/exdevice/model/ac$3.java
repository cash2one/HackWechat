package com.tencent.mm.plugin.exdevice.model;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.ShapeDrawable.ShaderFactory;

class ac$3 extends ShaderFactory {
    final /* synthetic */ ac lNC;
    final /* synthetic */ int[] lNF;

    ac$3(ac acVar, int[] iArr) {
        this.lNC = acVar;
        this.lNF = iArr;
    }

    public final Shader resize(int i, int i2) {
        return new LinearGradient(0.0f, 0.0f, 0.0f, (float) i2, new int[]{0, this.lNF[0]}, new float[]{0.0f, 1.0f}, TileMode.REPEAT);
    }
}
