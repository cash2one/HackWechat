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

public final class ve extends c {
    private final int height = 75;
    private final int width = 75;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 75;
            case 1:
                return 75;
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
                i2.setColor(-15028967);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(4.0f, 60.0f);
                j.lineTo(4.0f, 71.990364f);
                j.cubicTo(4.0f, 73.65254f, 5.348283f, 75.0f, 7.0073853f, 75.0f);
                j.lineTo(66.992615f, 75.0f);
                j.cubicTo(68.65355f, 75.0f, 70.0f, 73.666405f, 70.0f, 71.990364f);
                j.lineTo(70.0f, 3.0096345f);
                j.cubicTo(70.0f, 1.3474593f, 68.65172f, 0.0f, 66.992615f, 0.0f);
                j.lineTo(7.0073853f, 0.0f);
                j.cubicTo(5.346452f, 0.0f, 4.0f, 1.3335965f, 4.0f, 3.0096345f);
                j.lineTo(4.0f, 15.0f);
                j.cubicTo(6.4852815f, 15.0f, 8.5f, 17.014719f, 8.5f, 19.5f);
                j.cubicTo(8.5f, 21.985281f, 6.4852815f, 24.0f, 4.0f, 24.0f);
                j.lineTo(4.0f, 51.0f);
                j.cubicTo(6.4852815f, 51.0f, 8.5f, 53.014717f, 8.5f, 55.5f);
                j.cubicTo(8.5f, 57.985283f, 6.4852815f, 60.0f, 4.0f, 60.0f);
                j.close();
                j.moveTo(35.16073f, 42.33927f);
                j.cubicTo(31.262531f, 38.441074f, 29.43414f, 34.747486f, 29.54121f, 33.381584f);
                j.cubicTo(29.648281f, 32.01568f, 31.987486f, 28.614197f, 31.95635f, 27.008419f);
                j.cubicTo(31.941387f, 26.23667f, 28.530704f, 21.19352f, 28.136374f, 20.583046f);
                j.cubicTo(27.742043f, 19.972572f, 27.281416f, 19.406528f, 26.698536f, 19.512964f);
                j.cubicTo(26.115658f, 19.6194f, 19.69526f, 21.835806f, 20.584337f, 27.494286f);
                j.cubicTo(21.473415f, 33.152767f, 27.573353f, 41.04148f, 31.963337f, 45.536663f);
                j.lineTo(35.16073f, 42.33927f);
                j.close();
                j.moveTo(35.16073f, 42.33927f);
                j.cubicTo(39.058926f, 46.23747f, 42.752514f, 48.06586f, 44.118416f, 47.95879f);
                j.cubicTo(45.48432f, 47.85172f, 48.885803f, 45.512516f, 50.49158f, 45.54365f);
                j.cubicTo(51.263332f, 45.558613f, 56.30648f, 48.969296f, 56.916954f, 49.363625f);
                j.cubicTo(57.527428f, 49.757957f, 58.09347f, 50.218586f, 57.987034f, 50.801464f);
                j.cubicTo(57.8806f, 51.384342f, 55.664196f, 57.80474f, 50.005714f, 56.915665f);
                j.cubicTo(44.347233f, 56.026585f, 36.45852f, 49.926647f, 31.963337f, 45.536663f);
                j.lineTo(35.16073f, 42.33927f);
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
