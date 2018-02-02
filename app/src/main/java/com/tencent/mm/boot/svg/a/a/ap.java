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

public final class ap extends c {
    private final int height = 45;
    private final int width = 45;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 45;
            case 1:
                return 45;
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
                i2.setColor(-2631721);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(37.639984f, 18.956465f);
                j.cubicTo(40.8106f, 15.785851f, 40.782635f, 10.622878f, 37.579388f, 7.4196324f);
                j.cubicTo(34.376846f, 4.2170906f, 29.211271f, 4.1903195f, 26.042555f, 7.3590355f);
                j.lineTo(18.664976f, 14.736615f);
                j.cubicTo(15.494361f, 17.90723f, 15.522326f, 23.070202f, 18.725573f, 26.273449f);
                j.lineTo(20.365034f, 24.633986f);
                j.cubicTo(18.076956f, 22.345907f, 18.038301f, 18.67684f, 20.32175f, 16.39339f);
                j.lineTo(27.699331f, 9.015811f);
                j.cubicTo(29.981482f, 6.7336607f, 33.652905f, 6.7720737f, 35.939926f, 9.059094f);
                j.cubicTo(38.228004f, 11.347174f, 38.26666f, 15.01624f, 35.98321f, 17.29969f);
                j.lineTo(31.21839f, 22.06451f);
                j.lineTo(32.875164f, 23.721285f);
                j.lineTo(37.639984f, 18.956465f);
                j.close();
                j.moveTo(7.3600707f, 26.041521f);
                j.cubicTo(4.189456f, 29.212135f, 4.2174215f, 34.375107f, 7.4206676f, 37.578354f);
                j.cubicTo(10.62321f, 40.780895f, 15.788785f, 40.807667f, 18.9575f, 37.63895f);
                j.lineTo(26.335081f, 30.26137f);
                j.cubicTo(29.505695f, 27.090755f, 29.47773f, 21.927784f, 26.274483f, 18.724537f);
                j.lineTo(24.635021f, 20.364f);
                j.cubicTo(26.9231f, 22.652079f, 26.961754f, 26.321144f, 24.678305f, 28.604595f);
                j.lineTo(17.300724f, 35.982174f);
                j.cubicTo(15.018575f, 38.264324f, 11.347151f, 38.22591f, 9.06013f, 35.938892f);
                j.cubicTo(6.7720504f, 33.65081f, 6.7333965f, 29.981745f, 9.016847f, 27.698296f);
                j.lineTo(13.781667f, 22.933475f);
                j.lineTo(12.12489f, 21.2767f);
                j.lineTo(7.3600707f, 26.041521f);
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
