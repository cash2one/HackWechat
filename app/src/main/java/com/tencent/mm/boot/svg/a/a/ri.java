package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class ri extends c {
    private final int height = 108;
    private final int width = 108;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 108;
            case 1:
                return 108;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                c.f(looper);
                c.e(looper);
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
                Path j = c.j(looper);
                j.moveTo(0.0f, 0.0f);
                j.lineTo(96.0f, 0.0f);
                j.lineTo(96.0f, 96.0f);
                j.lineTo(0.0f, 96.0f);
                j.lineTo(0.0f, 0.0f);
                j.close();
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-15683841);
                Path j2 = c.j(looper);
                j2.moveTo(63.79504f, 76.03136f);
                j2.cubicTo(66.12399f, 72.529205f, 68.7792f, 68.3831f, 71.20018f, 64.23644f);
                j2.cubicTo(75.00407f, 57.72113f, 67.96337f, 50.764866f, 69.06122f, 48.884483f);
                j2.lineTo(75.6094f, 37.66875f);
                j2.lineTo(77.45893f, 38.724712f);
                j2.lineTo(79.198235f, 35.74563f);
                j2.lineTo(65.82298f, 28.109241f);
                j2.lineTo(64.08367f, 31.088326f);
                j2.lineTo(65.30881f, 31.787794f);
                j2.lineTo(65.30881f, 31.787794f);
                j2.cubicTo(63.367702f, 35.112526f, 59.602104f, 41.562244f, 58.760628f, 43.00353f);
                j2.cubicTo(57.614784f, 44.966133f, 48.31452f, 42.2731f, 44.418648f, 48.945957f);
                j2.cubicTo(41.398506f, 54.118862f, 34.140175f, 64.83309f, 31.555475f, 68.623924f);
                j2.cubicTo(36.904846f, 68.18801f, 44.777954f, 68.44738f, 52.00923f, 72.13616f);
                j2.cubicTo(56.16449f, 74.25582f, 60.120087f, 75.47306f, 63.79504f, 76.03136f);
                j2.lineTo(63.79504f, 76.03136f);
                j2.close();
                j2.moveTo(74.7789f, 22.0f);
                j2.lineTo(71.04058f, 28.949007f);
                j2.lineTo(76.47996f, 32.174023f);
                j2.lineTo(84.06177f, 26.508453f);
                j2.lineTo(74.7789f, 22.0f);
                j2.close();
                j2.moveTo(87.90909f, 75.08898f);
                j2.cubicTo(87.90909f, 75.08898f, 77.715836f, 85.38182f, 65.84715f, 85.38182f);
                j2.cubicTo(40.000687f, 85.38182f, 50.014915f, 73.98892f, 20.0f, 72.81588f);
                j2.cubicTo(19.998188f, 72.81866f, 36.395184f, 68.36936f, 50.49552f, 75.08898f);
                j2.cubicTo(71.97876f, 85.326965f, 87.90909f, 75.08898f, 87.90909f, 75.08898f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, a);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
