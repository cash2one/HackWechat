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

public final class apu extends c {
    private final int height = 35;
    private final int width = 38;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 38;
            case 1:
                return 35;
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
                i2.setColor(-9074725);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(25.499968f, 4.0f);
                j.cubicTo(23.846365f, 4.0f, 22.306759f, 4.4393754f, 21.000032f, 5.1871934f);
                j.cubicTo(18.602196f, 6.559061f, 17.000055f, 8.984258f, 17.000055f, 11.750141f);
                j.lineTo(17.000055f, 23.25012f);
                j.cubicTo(17.000055f, 25.32095f, 14.985246f, 26.999956f, 12.500119f, 26.999956f);
                j.cubicTo(10.0146675f, 26.999956f, 7.999859f, 25.32095f, 7.999859f, 23.25012f);
                j.cubicTo(7.999859f, 21.77598f, 9.022897f, 20.504429f, 10.507459f, 19.891453f);
                j.cubicTo(10.61429f, 19.847158f, 10.723075f, 19.805468f, 10.834792f, 19.768337f);
                j.cubicTo(11.768912f, 19.393778f, 12.570472f, 18.689604f, 12.868166f, 17.87176f);
                j.cubicTo(13.307216f, 16.665024f, 12.489371f, 15.686933f, 11.041288f, 15.686933f);
                j.cubicTo(10.680408f, 15.686933f, 10.314642f, 15.74784f, 9.961577f, 15.857927f);
                j.cubicTo(9.9599495f, 15.8582535f, 9.958321f, 15.858905f, 9.956367f, 15.85923f);
                j.cubicTo(7.863063f, 16.460482f, 6.115658f, 17.778608f, 5.066563f, 19.499956f);
                j.cubicTo(4.388772f, 20.612238f, 3.9998806f, 21.889977f, 3.9998806f, 23.25012f);
                j.cubicTo(3.9998806f, 27.523363f, 7.8129044f, 30.999935f, 12.500119f, 30.999935f);
                j.cubicTo(14.153396f, 30.999935f, 15.693002f, 30.56056f, 17.000055f, 29.812742f);
                j.cubicTo(19.397566f, 28.440874f, 21.000032f, 26.015676f, 21.000032f, 23.25012f);
                j.lineTo(21.000032f, 11.750141f);
                j.cubicTo(21.000032f, 9.678986f, 23.014515f, 7.999978f, 25.499968f, 7.999978f);
                j.cubicTo(27.985094f, 7.999978f, 29.999903f, 9.678986f, 29.999903f, 11.750141f);
                j.cubicTo(29.999903f, 13.287141f, 28.890226f, 14.607873f, 27.302092f, 15.186976f);
                j.cubicTo(26.277424f, 15.530269f, 25.437757f, 16.271898f, 25.118242f, 17.150324f);
                j.cubicTo(24.68082f, 18.351849f, 25.49508f, 19.325378f, 26.936651f, 19.325378f);
                j.cubicTo(27.263006f, 19.325378f, 27.592945f, 19.269684f, 27.914415f, 19.17816f);
                j.cubicTo(27.96718f, 19.16383f, 28.018967f, 19.14787f, 28.07108f, 19.132563f);
                j.cubicTo(30.152006f, 18.527729f, 31.888988f, 17.213837f, 32.933197f, 15.499978f);
                j.cubicTo(33.61099f, 14.387697f, 33.99988f, 13.109958f, 33.99988f, 11.750141f);
                j.cubicTo(33.99988f, 7.476571f, 30.186857f, 4.0f, 25.499968f, 4.0f);
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
