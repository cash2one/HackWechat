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

public final class ho extends c {
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
                j.moveTo(65.0f, 53.0f);
                j.cubicTo(65.0f, 55.20933f, 62.761665f, 57.0f, 60.0f, 57.0f);
                j.lineTo(55.0f, 57.0f);
                j.lineTo(55.0f, 41.0f);
                j.lineTo(60.0f, 41.0f);
                j.cubicTo(62.761665f, 41.0f, 65.0f, 42.79111f, 65.0f, 45.0f);
                j.lineTo(65.0f, 53.0f);
                j.close();
                j.moveTo(60.0f, 33.0f);
                j.lineTo(48.0f, 33.0f);
                j.lineTo(48.0f, 65.0f);
                j.lineTo(60.0f, 65.0f);
                j.cubicTo(66.627556f, 65.0f, 72.0f, 59.627556f, 72.0f, 53.0f);
                j.lineTo(72.0f, 45.0f);
                j.cubicTo(72.0f, 38.37289f, 66.627556f, 33.0f, 60.0f, 33.0f);
                j.lineTo(60.0f, 33.0f);
                j.close();
                j.moveTo(48.5f, 78.0f);
                j.cubicTo(32.759857f, 78.0f, 20.0f, 65.24014f, 20.0f, 49.5f);
                j.cubicTo(20.0f, 42.182285f, 22.76043f, 35.511475f, 27.293285f, 30.464714f);
                j.lineTo(29.464714f, 28.293737f);
                j.cubicTo(34.511475f, 23.76043f, 41.182285f, 21.0f, 48.5f, 21.0f);
                j.cubicTo(55.817715f, 21.0f, 62.488525f, 23.76043f, 67.535286f, 28.293737f);
                j.lineTo(69.70671f, 30.464714f);
                j.cubicTo(74.23957f, 35.511475f, 77.0f, 42.182285f, 77.0f, 49.5f);
                j.cubicTo(77.0f, 65.24014f, 64.24014f, 78.0f, 48.5f, 78.0f);
                j.lineTo(48.5f, 78.0f);
                j.close();
                j.moveTo(89.0f, 28.320707f);
                j.lineTo(84.54362f, 23.862083f);
                j.lineTo(78.94612f, 29.462835f);
                j.cubicTo(78.10526f, 28.189201f, 77.189674f, 26.969608f, 76.20072f, 25.813969f);
                j.lineTo(81.34762f, 20.664484f);
                j.lineTo(76.891235f, 16.205858f);
                j.lineTo(71.71237f, 21.387772f);
                j.cubicTo(70.703606f, 20.554144f, 69.645325f, 19.779964f, 68.54969f, 19.056675f);
                j.lineTo(74.14538f, 13.458625f);
                j.lineTo(69.688995f, 9.0f);
                j.lineTo(62.753685f, 15.939241f);
                j.cubicTo(58.37472f, 14.0760765f, 53.558674f, 13.040685f, 48.5f, 13.040685f);
                j.cubicTo(43.441326f, 13.040685f, 38.62528f, 14.0760765f, 34.246315f, 15.939241f);
                j.lineTo(27.311008f, 9.0f);
                j.lineTo(22.854622f, 13.458625f);
                j.lineTo(28.450312f, 19.056675f);
                j.cubicTo(27.354671f, 19.779964f, 26.296392f, 20.554144f, 25.287628f, 21.387772f);
                j.lineTo(20.108767f, 16.205858f);
                j.lineTo(15.652381f, 20.664484f);
                j.lineTo(20.799282f, 25.813969f);
                j.cubicTo(19.810324f, 26.969608f, 18.89474f, 28.189201f, 18.053879f, 29.462835f);
                j.lineTo(12.456387f, 23.862083f);
                j.lineTo(8.0f, 28.320707f);
                j.lineTo(14.937108f, 35.2613f);
                j.cubicTo(13.073078f, 39.64066f, 12.038656f, 44.45868f, 12.038656f, 49.520344f);
                j.cubicTo(12.038656f, 69.66747f, 28.362986f, 86.0f, 48.5f, 86.0f);
                j.cubicTo(68.63702f, 86.0f, 84.96134f, 69.66747f, 84.96134f, 49.520344f);
                j.cubicTo(84.96134f, 44.45868f, 83.92692f, 39.64066f, 82.06289f, 35.2613f);
                j.lineTo(89.0f, 28.320707f);
                j.close();
                j.moveTo(36.0f, 53.0f);
                j.cubicTo(36.0f, 55.20933f, 34.20933f, 57.0f, 32.0f, 57.0f);
                j.lineTo(28.0f, 57.0f);
                j.lineTo(28.0f, 65.0f);
                j.lineTo(32.0f, 65.0f);
                j.cubicTo(38.627556f, 65.0f, 44.0f, 59.627556f, 44.0f, 53.0f);
                j.lineTo(44.0f, 33.0f);
                j.lineTo(36.0f, 33.0f);
                j.lineTo(36.0f, 53.0f);
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
