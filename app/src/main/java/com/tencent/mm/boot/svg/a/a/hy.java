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

public final class hy extends c {
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
                i2.setColor(-8617851);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(47.0f, 87.98775f);
                j.cubicTo(25.370693f, 87.45702f, 8.0f, 69.75708f, 8.0f, 48.0f);
                j.cubicTo(8.0f, 34.31184f, 14.875527f, 22.229542f, 25.36142f, 15.018275f);
                j.lineTo(31.139889f, 20.796743f);
                j.cubicTo(22.05139f, 26.441599f, 16.0f, 36.51411f, 16.0f, 48.0f);
                j.cubicTo(16.0f, 65.338554f, 29.789598f, 79.456375f, 47.0f, 79.98467f);
                j.lineTo(47.0f, 70.0f);
                j.lineTo(65.0f, 88.0f);
                j.lineTo(47.0f, 88.0f);
                j.lineTo(47.0f, 87.98775f);
                j.close();
                j.moveTo(47.0f, 8.012256f);
                j.cubicTo(47.332344f, 8.004101f, 47.66569f, 8.0f, 48.0f, 8.0f);
                j.cubicTo(70.09139f, 8.0f, 88.0f, 25.90861f, 88.0f, 48.0f);
                j.cubicTo(88.0f, 62.075714f, 80.72963f, 74.45335f, 69.73931f, 81.58246f);
                j.lineTo(63.921238f, 75.76438f);
                j.cubicTo(73.52948f, 70.24273f, 80.0f, 59.877f, 80.0f, 48.0f);
                j.cubicTo(80.0f, 30.326887f, 65.67311f, 16.0f, 48.0f, 16.0f);
                j.cubicTo(47.665443f, 16.0f, 47.332085f, 16.005135f, 47.0f, 16.015327f);
                j.lineTo(47.0f, 26.0f);
                j.lineTo(29.0f, 8.0f);
                j.lineTo(47.0f, 8.0f);
                j.lineTo(47.0f, 8.012256f);
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
