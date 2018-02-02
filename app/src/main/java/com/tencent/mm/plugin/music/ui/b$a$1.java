package com.tencent.mm.plugin.music.ui;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.ShapeDrawable.ShaderFactory;
import com.tencent.mm.plugin.music.ui.b.a;

class b$a$1 extends ShaderFactory {
    final /* synthetic */ int oNB;
    final /* synthetic */ a oNC;

    b$a$1(a aVar, int i) {
        this.oNC = aVar;
        this.oNB = i;
    }

    public final Shader resize(int i, int i2) {
        return new LinearGradient(0.0f, 0.0f, 0.0f, (float) i2, new int[]{0, this.oNB}, new float[]{0.0f, 1.0f}, TileMode.REPEAT);
    }
}
