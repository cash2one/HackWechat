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

public final class cv extends c {
    private final int height = 58;
    private final int width = 58;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 58;
            case 1:
                return 58;
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
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-1);
                e = c.a(e, 1.0f, 0.0f, -249.0f, 0.0f, 1.0f, -79.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                a = c.a(a, looper);
                e = c.a(e, 0.70710677f, 0.70710677f, 4.6425705f, -0.70710677f, 0.70710677f, 229.20816f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                Path j = c.j(looper);
                j.moveTo(277.0f, 118.906f);
                j.lineTo(277.0f, 141.0f);
                j.lineTo(283.0f, 141.0f);
                j.lineTo(283.0f, 118.61951f);
                j.cubicTo(292.68488f, 116.751785f, 300.0f, 108.23016f, 300.0f, 98.0f);
                j.cubicTo(300.0f, 86.40202f, 290.598f, 77.0f, 279.0f, 77.0f);
                j.cubicTo(267.402f, 77.0f, 258.0f, 86.40202f, 258.0f, 98.0f);
                j.cubicTo(258.0f, 108.92341f, 266.34015f, 117.89888f, 277.0f, 118.906f);
                j.close();
                j.moveTo(279.0f, 113.0f);
                j.cubicTo(287.28427f, 113.0f, 294.0f, 106.28427f, 294.0f, 98.0f);
                j.cubicTo(294.0f, 89.71573f, 287.28427f, 83.0f, 279.0f, 83.0f);
                j.cubicTo(270.71573f, 83.0f, 264.0f, 89.71573f, 264.0f, 98.0f);
                j.cubicTo(264.0f, 106.28427f, 270.71573f, 113.0f, 279.0f, 113.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
