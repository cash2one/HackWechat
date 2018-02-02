package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class dq extends c {
    private final int height = 200;
    private final int width = 200;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 200;
            case 1:
                return 200;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                Matrix f = c.f(looper);
                float[] e = c.e(looper);
                Paint i2 = c.i(looper);
                i2.setFlags(385);
                i2.setStyle(Style.FILL);
                Paint i3 = c.i(looper);
                i3.setFlags(385);
                i3.setStyle(Style.STROKE);
                i2.setColor(WebView.NIGHT_MODE_COLOR);
                i3.setStrokeWidth(1.0f);
                i3.setStrokeCap(Cap.BUTT);
                i3.setStrokeJoin(Join.MITER);
                i3.setStrokeMiter(4.0f);
                i3.setPathEffect(null);
                c.a(i3, looper).setStrokeWidth(1.0f);
                Paint a = c.a(i2, looper);
                a.setColor(-1);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 29.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(0.31970137f, 77.93319f);
                j.cubicTo(-0.063724294f, 77.53636f, -0.108552635f, 76.85273f, 0.2193248f, 76.40659f);
                j.lineTo(9.792403f, 63.380688f);
                j.cubicTo(10.120393f, 62.934402f, 10.738718f, 62.842735f, 11.176576f, 63.17833f);
                j.lineTo(61.002815f, 101.36729f);
                j.cubicTo(62.317314f, 102.37477f, 64.42048f, 102.32714f, 65.687584f, 101.27154f);
                j.lineTo(186.95796f, 0.24350294f);
                j.cubicTo(187.37868f, -0.10698287f, 188.04178f, -0.07305191f, 188.42578f, 0.3061832f);
                j.lineTo(197.7745f, 9.538964f);
                j.cubicTo(198.16446f, 9.9240675f, 198.16162f, 10.550133f, 197.76987f, 10.935685f);
                j.lineTo(64.80481f, 141.79317f);
                j.cubicTo(64.01734f, 142.56815f, 62.75824f, 142.55399f, 61.988094f, 141.75691f);
                j.lineTo(0.31970137f, 77.93319f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
