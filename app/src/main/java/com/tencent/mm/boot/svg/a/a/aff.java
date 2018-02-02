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

public final class aff extends c {
    private final int height = 96;
    private final int width = 96;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                a.setColor(-6250336);
                e = c.a(e, 0.70710677f, -0.70710677f, 48.0f, 0.70710677f, 0.70710677f, -19.882248f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                Path j = c.j(looper);
                j.moveTo(62.0f, 28.517904f);
                j.lineTo(62.0f, 66.0f);
                j.lineTo(67.0f, 66.0f);
                j.lineTo(67.0f, 28.517904f);
                j.cubicTo(66.99998f, 28.51194f, 67.0f, 28.505972f, 67.0f, 28.5f);
                j.cubicTo(67.0f, 27.119287f, 65.880714f, 26.0f, 64.5f, 26.0f);
                j.cubicTo(63.11929f, 26.0f, 62.0f, 27.119287f, 62.0f, 28.5f);
                j.cubicTo(62.0f, 28.505972f, 62.00002f, 28.51194f, 62.00006f, 28.517904f);
                j.close();
                j.moveTo(40.0f, 39.482143f);
                j.lineTo(40.0f, 66.0f);
                j.lineTo(45.0f, 66.0f);
                j.lineTo(45.0f, 39.482143f);
                j.cubicTo(44.990337f, 38.10965f, 43.874756f, 37.0f, 42.5f, 37.0f);
                j.cubicTo(41.125244f, 37.0f, 40.009663f, 38.10965f, 40.00006f, 39.482143f);
                j.lineTo(40.0f, 39.482143f);
                j.close();
                j.moveTo(55.99748f, 24.0f);
                j.cubicTo(55.857f, 16.7968f, 49.867767f, 11.0f, 42.5f, 11.0f);
                j.cubicTo(35.132233f, 11.0f, 29.143f, 16.7968f, 29.002523f, 24.0f);
                j.lineTo(34.01446f, 24.0f);
                j.cubicTo(34.27327f, 19.538311f, 37.973427f, 16.0f, 42.5f, 16.0f);
                j.cubicTo(47.026573f, 16.0f, 50.72673f, 19.538311f, 50.98554f, 24.0f);
                j.lineTo(55.99748f, 24.0f);
                j.close();
                j.moveTo(67.0f, 66.0f);
                j.cubicTo(67.0f, 76.49341f, 58.493412f, 85.0f, 48.0f, 85.0f);
                j.cubicTo(37.506588f, 85.0f, 29.0f, 76.49341f, 29.0f, 66.0f);
                j.lineTo(34.0f, 66.0f);
                j.cubicTo(34.0f, 73.73199f, 40.268013f, 80.0f, 48.0f, 80.0f);
                j.cubicTo(55.731987f, 80.0f, 62.0f, 73.73199f, 62.0f, 66.0f);
                j.lineTo(67.0f, 66.0f);
                j.lineTo(67.0f, 66.0f);
                j.close();
                j.moveTo(56.0f, 66.0f);
                j.cubicTo(56.0f, 70.41828f, 52.418278f, 74.0f, 48.0f, 74.0f);
                j.cubicTo(43.581722f, 74.0f, 40.0f, 70.41828f, 40.0f, 66.0f);
                j.lineTo(45.0f, 66.0f);
                j.cubicTo(45.0f, 67.65685f, 46.343147f, 69.0f, 48.0f, 69.0f);
                j.cubicTo(49.656853f, 69.0f, 51.0f, 67.65685f, 51.0f, 66.0f);
                j.lineTo(56.0f, 66.0f);
                j.lineTo(56.0f, 66.0f);
                j.close();
                j.moveTo(29.0f, 24.0f);
                j.lineTo(34.0f, 24.0f);
                j.lineTo(34.0f, 66.0f);
                j.lineTo(29.0f, 66.0f);
                j.lineTo(29.0f, 24.0f);
                j.close();
                j.moveTo(51.0f, 24.0f);
                j.lineTo(56.0f, 24.0f);
                j.lineTo(56.0f, 66.0f);
                j.lineTo(51.0f, 66.0f);
                j.lineTo(51.0f, 24.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
