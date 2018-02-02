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

public final class vr extends c {
    private final int height = 92;
    private final int width = 92;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 92;
            case 1:
                return 92;
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
                a.setColor(-3355444);
                e = c.a(e, 1.0f, 0.0f, 22.0f, 0.0f, 1.0f, 12.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(17.932604f, 2.0969148f);
                j.cubicTo(25.994081f, -0.5536036f, 35.3458f, 1.7168405f, 41.396908f, 7.6379986f);
                j.cubicTo(47.988117f, 13.789202f, 50.418564f, 23.60112f, 48.198154f, 32.24281f);
                j.cubicTo(44.57749f, 46.585617f, 34.955727f, 58.447937f, 24.993898f, 69.0f);
                j.cubicTo(17.072445f, 60.688374f, 9.661086f, 51.646606f, 4.860205f, 41.13455f);
                j.cubicTo(2.0196838f, 34.84332f, 0.079327956f, 27.781939f, 1.4495794f, 20.860584f);
                j.cubicTo(2.989862f, 12.228896f, 9.511058f, 4.6574154f, 17.932604f, 2.0969148f);
                j.lineTo(17.932604f, 2.0969148f);
                j.lineTo(17.932604f, 2.0969148f);
                j.close();
                j.moveTo(22.660744f, 14.37389f);
                j.cubicTo(16.35458f, 15.838051f, 12.456952f, 23.040936f, 14.585656f, 29.035152f);
                j.cubicTo(16.224659f, 34.636303f, 22.740694f, 38.291794f, 28.477203f, 36.57214f);
                j.cubicTo(34.683426f, 35.098152f, 38.49111f, 27.983707f, 36.442356f, 22.068104f);
                j.cubicTo(34.853325f, 16.447298f, 28.407246f, 12.781983f, 22.660744f, 14.37389f);
                j.lineTo(22.660744f, 14.37389f);
                j.lineTo(22.660744f, 14.37389f);
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
