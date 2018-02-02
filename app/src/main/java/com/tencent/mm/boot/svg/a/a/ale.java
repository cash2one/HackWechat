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

public final class ale extends c {
    private final int height = 46;
    private final int width = 46;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 46;
            case 1:
                return 46;
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
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-6710887);
                Path j = c.j(looper);
                j.moveTo(23.0f, 0.0f);
                j.cubicTo(35.70255f, 0.0f, 46.0f, 10.29745f, 46.0f, 23.0f);
                j.cubicTo(46.0f, 35.70255f, 35.70255f, 46.0f, 23.0f, 46.0f);
                j.cubicTo(10.29745f, 46.0f, 0.0f, 35.70255f, 0.0f, 23.0f);
                j.cubicTo(0.0f, 10.29745f, 10.29745f, 0.0f, 23.0f, 0.0f);
                j.close();
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                i2 = c.a(i2, looper);
                i2.setColor(-1);
                j = c.j(looper);
                j.moveTo(29.837742f, 16.978155f);
                j.cubicTo(29.663364f, 15.734242f, 29.332104f, 14.538659f, 28.424576f, 13.573514f);
                j.cubicTo(25.837162f, 10.148845f, 20.172827f, 10.138831f, 17.585415f, 13.5635f);
                j.cubicTo(15.967033f, 15.315889f, 16.176823f, 17.799276f, 15.827173f, 19.982252f);
                j.lineTo(13.0f, 19.982252f);
                j.cubicTo(13.00999f, 24.328176f, 13.00999f, 28.66409f, 13.00999f, 33.0f);
                j.lineTo(32.99001f, 33.0f);
                j.cubicTo(32.99001f, 28.66409f, 32.99001f, 24.328176f, 33.0f, 19.982252f);
                j.lineTo(31.586414f, 19.982252f);
                j.lineTo(26.086912f, 19.982252f);
                j.lineTo(18.824175f, 19.982252f);
                j.cubicTo(18.804195f, 17.358675f, 19.713287f, 13.873924f, 22.99001f, 13.97406f);
                j.cubicTo(25.067957f, 13.891255f, 26.212177f, 15.279206f, 26.759495f, 16.978155f);
                j.lineTo(29.837742f, 16.978155f);
                j.lineTo(29.837742f, 16.978155f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, i2);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
