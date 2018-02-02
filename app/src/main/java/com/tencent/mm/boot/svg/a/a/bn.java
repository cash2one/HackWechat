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

public final class bn extends c {
    private final int height = 90;
    private final int width = 90;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 90;
            case 1:
                return 90;
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
                i3 = c.a(i2, looper);
                i3.setColor(-855310);
                Path j = c.j(looper);
                j.moveTo(0.0f, 0.0f);
                j.lineTo(90.0f, 0.0f);
                j.lineTo(90.0f, 90.0f);
                j.lineTo(0.0f, 90.0f);
                j.lineTo(0.0f, 0.0f);
                j.close();
                canvas.drawPath(j, i3);
                canvas.restore();
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(WebView.NIGHT_MODE_COLOR);
                e = c.a(e, 1.0f, 0.0f, 30.0f, 0.0f, 1.0f, 24.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.saveLayerAlpha(null, 153, 4);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j2 = c.j(looper);
                j2.moveTo(13.125807f, 35.88405f);
                j2.cubicTo(5.7260823f, 34.961723f, 9.368011E-16f, 28.64956f, 0.0f, 21.0f);
                j2.lineTo(0.0f, 17.25f);
                j2.lineTo(3.75f, 17.25f);
                j2.lineTo(3.75f, 21.0f);
                j2.cubicTo(3.75f, 27.213203f, 8.786797f, 32.25f, 15.0f, 32.25f);
                j2.cubicTo(21.213203f, 32.25f, 26.25f, 27.213203f, 26.25f, 21.0f);
                j2.lineTo(26.25f, 17.25f);
                j2.lineTo(30.0f, 17.25f);
                j2.lineTo(30.0f, 21.0f);
                j2.cubicTo(30.0f, 28.649282f, 24.274334f, 34.961266f, 16.875f, 35.88395f);
                j2.lineTo(16.875f, 42.0f);
                j2.lineTo(13.12812f, 42.0f);
                j2.lineTo(13.125807f, 35.88405f);
                j2.close();
                j2.moveTo(15.0f, 0.0f);
                j2.cubicTo(19.142136f, -7.6089796E-16f, 22.5f, 3.3578644f, 22.5f, 7.5f);
                j2.lineTo(22.5f, 21.0f);
                j2.cubicTo(22.5f, 25.142136f, 19.142136f, 28.5f, 15.0f, 28.5f);
                j2.cubicTo(10.857864f, 28.5f, 7.5f, 25.142136f, 7.5f, 21.0f);
                j2.lineTo(7.5f, 7.5f);
                j2.cubicTo(7.5f, 3.3578644f, 10.857864f, 7.6089796E-16f, 15.0f, 0.0f);
                j2.close();
                j2.moveTo(15.0f, 3.75f);
                j2.cubicTo(12.928932f, 3.75f, 11.25f, 5.428932f, 11.25f, 7.5f);
                j2.lineTo(11.25f, 21.0f);
                j2.cubicTo(11.25f, 23.071068f, 12.928932f, 24.75f, 15.0f, 24.75f);
                j2.cubicTo(17.071068f, 24.75f, 18.75f, 23.071068f, 18.75f, 21.0f);
                j2.lineTo(18.75f, 7.5f);
                j2.cubicTo(18.75f, 5.428932f, 17.071068f, 3.75f, 15.0f, 3.75f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 1);
                canvas.drawPath(j2, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
