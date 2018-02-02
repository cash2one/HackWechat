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

public final class l extends c {
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
                a.setColor(-1);
                e = c.a(e, 1.0f, 0.0f, 8.0f, 0.0f, 1.0f, 19.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(42.313f, 39.809f);
                j.cubicTo(39.234f, 38.115f, 32.741f, 35.447f, 37.025f, 29.307f);
                j.cubicTo(37.36f, 28.827f, 37.571f, 28.341f, 37.692f, 27.858f);
                j.cubicTo(40.269f, 24.814f, 42.161f, 20.834f, 42.29f, 17.135f);
                j.lineTo(42.314f, 17.135f);
                j.lineTo(42.314f, 11.863f);
                j.lineTo(42.252f, 11.863f);
                j.cubicTo(41.627f, 3.408f, 34.667f, 0.0f, 29.092f, 0.0f);
                j.cubicTo(23.51f, 0.0f, 16.542f, 3.216f, 15.929f, 11.863f);
                j.lineTo(15.868f, 11.863f);
                j.lineTo(15.868f, 17.135f);
                j.lineTo(15.893f, 17.135f);
                j.cubicTo(16.022f, 20.837f, 17.908f, 24.816f, 20.495f, 27.863f);
                j.cubicTo(20.615f, 28.344f, 20.822f, 28.828f, 21.156f, 29.307f);
                j.cubicTo(25.441f, 35.447f, 18.947f, 38.115f, 15.868f, 39.809f);
                j.cubicTo(4.042f, 46.316f, 1.028f, 48.37f, 0.262f, 51.119f);
                j.cubicTo(0.1f, 51.408f, 0.0f, 51.735f, 0.0f, 52.089f);
                j.lineTo(0.0f, 55.999f);
                j.cubicTo(0.0f, 57.103f, 0.896f, 57.999f, 2.0f, 57.999f);
                j.lineTo(56.182f, 57.999f);
                j.cubicTo(57.286f, 57.999f, 58.182f, 57.103f, 58.182f, 55.999f);
                j.lineTo(58.182f, 52.089f);
                j.cubicTo(58.182f, 51.735f, 58.082f, 51.407f, 57.92f, 51.119f);
                j.cubicTo(57.153f, 48.37f, 54.138f, 46.315f, 42.313f, 39.809f);
                j.lineTo(42.313f, 39.809f);
                j.lineTo(42.313f, 39.809f);
                j.close();
                j.moveTo(79.943f, 47.53f);
                j.cubicTo(79.661f, 45.044f, 77.982f, 43.752f, 68.098f, 38.315f);
                j.cubicTo(65.788f, 37.044f, 60.918f, 35.042f, 64.132f, 30.437f);
                j.cubicTo(64.382f, 30.078f, 64.538f, 29.715f, 64.628f, 29.354f);
                j.cubicTo(66.567f, 27.069f, 67.982f, 24.085f, 68.079f, 21.309f);
                j.lineTo(68.098f, 21.309f);
                j.lineTo(68.098f, 17.354f);
                j.lineTo(68.052f, 17.354f);
                j.cubicTo(67.583f, 11.013f, 62.364f, 8.457f, 58.181f, 8.457f);
                j.cubicTo(53.995f, 8.457f, 48.769f, 10.87f, 48.309f, 17.354f);
                j.lineTo(48.264f, 17.354f);
                j.lineTo(48.264f, 21.309f);
                j.lineTo(48.283f, 21.309f);
                j.cubicTo(48.38f, 24.085f, 49.795f, 27.07f, 51.735f, 29.354f);
                j.cubicTo(51.825f, 29.715f, 51.98f, 30.078f, 52.231f, 30.437f);
                j.cubicTo(55.12f, 34.577f, 51.48f, 36.61f, 49.036f, 37.903f);
                j.cubicTo(64.284f, 46.296f, 65.378f, 47.545f, 65.449f, 51.956f);
                j.lineTo(78.045f, 51.956f);
                j.cubicTo(79.125f, 51.956f, 80.0f, 51.082f, 80.0f, 50.003f);
                j.lineTo(80.0f, 47.98f);
                j.cubicTo(79.999f, 47.824f, 79.977f, 47.675f, 79.943f, 47.53f);
                j.lineTo(79.943f, 47.53f);
                j.lineTo(79.943f, 47.53f);
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
