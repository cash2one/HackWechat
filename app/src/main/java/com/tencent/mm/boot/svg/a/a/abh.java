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

public final class abh extends c {
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
                i3 = c.a(i3, looper);
                i3.setStrokeWidth(1.0f);
                canvas.save();
                Paint a = c.a(i2, looper);
                i3 = c.a(i3, looper);
                a.setColor(-1);
                i3.setColor(-789517);
                i3.setStrokeWidth(3.0f);
                Path j = c.j(looper);
                j.moveTo(0.0f, 0.0f);
                j.lineTo(96.0f, 0.0f);
                j.lineTo(96.0f, 96.0f);
                j.lineTo(0.0f, 96.0f);
                j.lineTo(0.0f, 0.0f);
                j.close();
                canvas.drawPath(j, a);
                canvas.drawPath(j, i3);
                canvas.restore();
                canvas.save();
                Paint a2 = c.a(i2, looper);
                a2.setColor(-2274503);
                Path j2 = c.j(looper);
                j2.moveTo(70.0f, 43.5f);
                j2.lineTo(61.0f, 43.5f);
                j2.lineTo(61.0f, 47.5f);
                j2.lineTo(70.0f, 47.5f);
                j2.lineTo(70.0f, 56.5f);
                j2.lineTo(74.0f, 56.5f);
                j2.lineTo(74.0f, 47.5f);
                j2.lineTo(83.0f, 47.5f);
                j2.lineTo(83.0f, 43.5f);
                j2.lineTo(74.0f, 43.5f);
                j2.lineTo(74.0f, 34.5f);
                j2.lineTo(70.0f, 34.5f);
                j2.lineTo(70.0f, 43.5f);
                j2.close();
                j2.moveTo(48.15627f, 20.104698f);
                j2.cubicTo(50.54511f, 21.845333f, 52.34338f, 24.262693f, 53.18048f, 27.182009f);
                j2.cubicTo(53.94655f, 29.85361f, 53.807194f, 32.595276f, 52.93231f, 35.14289f);
                j2.lineTo(52.93231f, 35.14289f);
                j2.cubicTo(52.242462f, 37.515053f, 50.741844f, 40.506275f, 47.5f, 43.0f);
                j2.cubicTo(41.0f, 48.0f, 49.5f, 53.0f, 49.5f, 53.0f);
                j2.cubicTo(59.0f, 62.0f, 56.0f, 67.5f, 56.0f, 67.5f);
                j2.cubicTo(56.0f, 75.0f, 45.0f, 81.5f, 36.25f, 81.0f);
                j2.cubicTo(24.0f, 81.0f, 17.0f, 78.263535f, 17.0f, 68.263535f);
                j2.cubicTo(17.0f, 61.359974f, 25.618519f, 55.5f, 36.25f, 55.5f);
                j2.cubicTo(37.272186f, 55.5f, 38.280388f, 55.5416f, 39.267845f, 55.623466f);
                j2.cubicTo(38.37787f, 54.83482f, 37.28443f, 53.491013f, 37.0f, 51.5f);
                j2.cubicTo(36.626415f, 48.884895f, 37.36936f, 47.107193f, 37.768917f, 46.37545f);
                j2.cubicTo(30.210897f, 47.066048f, 23.23882f, 43.011383f, 21.31952f, 36.317993f);
                j2.cubicTo(19.107191f, 28.60268f, 24.446062f, 20.303026f, 33.244225f, 17.780195f);
                j2.cubicTo(35.439465f, 17.150719f, 37.64265f, 16.940361f, 39.747517f, 17.099007f);
                j2.lineTo(39.5f, 17.0f);
                j2.lineTo(58.0f, 17.0f);
                j2.cubicTo(58.0f, 17.0f, 55.5f, 19.5f, 53.5f, 20.0f);
                j2.cubicTo(52.141f, 20.33975f, 49.6277f, 20.21778f, 48.15627f, 20.104698f);
                j2.lineTo(48.15627f, 20.104698f);
                j2.close();
                j2.moveTo(50.24038f, 65.369125f);
                j2.cubicTo(50.412556f, 66.126335f, 50.5f, 66.922386f, 50.5f, 67.75f);
                j2.cubicTo(50.5f, 73.68706f, 46.0f, 78.5f, 37.5f, 77.5f);
                j2.cubicTo(29.0f, 76.5f, 24.5f, 73.43706f, 24.5f, 67.5f);
                j2.cubicTo(24.5f, 61.56294f, 30.0f, 57.5f, 38.0f, 57.5f);
                j2.cubicTo(39.67587f, 57.5f, 41.198147f, 57.689266f, 42.55764f, 58.043083f);
                j2.cubicTo(44.646748f, 59.511887f, 48.315704f, 62.34963f, 50.24038f, 65.369125f);
                j2.lineTo(50.24038f, 65.369125f);
                j2.close();
                j2.moveTo(41.083046f, 43.708344f);
                j2.cubicTo(45.661427f, 42.30859f, 47.770977f, 35.934086f, 45.794857f, 29.470486f);
                j2.cubicTo(43.818737f, 23.006886f, 38.50526f, 18.901825f, 33.926876f, 20.301579f);
                j2.cubicTo(29.348494f, 21.70133f, 27.238943f, 28.075836f, 29.215065f, 34.539436f);
                j2.cubicTo(31.191185f, 41.003036f, 36.50466f, 45.108097f, 41.083046f, 43.708344f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, a2);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
