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

public final class gj extends c {
    private final int height = 51;
    private final int width = 46;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 46;
            case 1:
                return 51;
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
                i2 = c.a(i2, looper);
                i2.setColor(-3881788);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(24.0f, 3.0f);
                j.cubicTo(24.89f, 0.3245459f, 29.14f, 0.33455303f, 30.0f, 3.0f);
                j.cubicTo(30.22f, 5.9885883f, 29.98f, 8.990731f, 30.0f, 12.0f);
                j.cubicTo(30.48f, 11.972859f, 31.48f, 11.972859f, 32.0f, 12.0f);
                j.cubicTo(31.99f, 9.981439f, 31.82f, 7.9700027f, 32.0f, 6.0f);
                j.cubicTo(32.82f, 3.63691f, 36.41f, 3.2466314f, 38.0f, 5.0f);
                j.cubicTo(38.37f, 7.48966f, 37.93f, 9.80131f, 38.0f, 12.0f);
                j.cubicTo(40.68f, 11.972859f, 43.34f, 11.972859f, 46.0f, 12.0f);
                j.lineTo(46.0f, 39.0f);
                j.cubicTo(43.6f, 38.982136f, 41.2f, 38.99214f, 39.0f, 39.0f);
                j.cubicTo(37.14f, 44.706223f, 32.34f, 49.389565f, 26.0f, 50.0f);
                j.lineTo(21.0f, 50.0f);
                j.cubicTo(14.81f, 49.539673f, 9.88f, 44.786278f, 8.0f, 39.0f);
                j.cubicTo(5.46f, 38.99214f, 2.73f, 38.99214f, 0.0f, 39.0f);
                j.lineTo(0.0f, 12.0f);
                j.cubicTo(2.63f, 11.972859f, 5.25f, 11.972859f, 8.0f, 12.0f);
                j.cubicTo(7.87f, 9.691231f, 7.81f, 5.8584957f, 11.0f, 6.0f);
                j.cubicTo(14.22f, 5.968574f, 14.09f, 9.731259f, 14.0f, 12.0f);
                j.cubicTo(14.6f, 11.972859f, 15.54f, 11.972859f, 16.0f, 12.0f);
                j.cubicTo(16.0f, 9.320967f, 15.79f, 6.639053f, 16.0f, 4.0f);
                j.cubicTo(16.88f, 1.3352673f, 21.13f, 1.3352673f, 22.0f, 4.0f);
                j.cubicTo(22.21f, 6.64906f, 22.0f, 9.320967f, 22.0f, 12.0f);
                j.cubicTo(22.5f, 11.972859f, 23.51f, 11.972859f, 24.0f, 12.0f);
                j.cubicTo(24.02f, 8.980724f, 23.77f, 5.968574f, 24.0f, 3.0f);
                j.lineTo(24.0f, 3.0f);
                j.close();
                j.moveTo(5.0f, 34.0f);
                j.cubicTo(12.38f, 33.93302f, 19.77f, 34.072884f, 27.0f, 34.0f);
                j.cubicTo(33.0f, 34.0f, 32.56548f, 25.699202f, 32.99548f, 22.046875f);
                j.cubicTo(33.340767f, 19.0f, 36.95f, 18.938057f, 39.0f, 19.0f);
                j.cubicTo(39.01f, 23.75323f, 39.0f, 28.868101f, 39.0f, 34.0f);
                j.cubicTo(39.75f, 33.98297f, 41.25f, 33.98297f, 42.0f, 34.0f);
                j.lineTo(42.0f, 17.0f);
                j.lineTo(5.0f, 17.0f);
                j.lineTo(5.0f, 34.0f);
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
