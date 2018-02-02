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

public final class adj extends c {
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
                Paint a = c.a(i2, looper);
                a.setColor(-1);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(16.0f, 29.0f);
                j.cubicTo(17.726973f, 27.70042f, 19.455055f, 28.159777f, 21.0f, 28.0f);
                j.cubicTo(34.0089f, 28.089874f, 47.05442f, 27.920113f, 60.0f, 28.0f);
                j.cubicTo(62.067753f, 27.960056f, 63.226467f, 30.137007f, 63.0f, 32.0f);
                j.cubicTo(62.976746f, 42.61952f, 62.966755f, 53.34449f, 63.0f, 64.0f);
                j.cubicTo(63.246445f, 65.83699f, 62.057766f, 68.023926f, 60.0f, 68.0f);
                j.cubicTo(46.335217f, 68.023926f, 32.600464f, 67.94404f, 19.0f, 68.0f);
                j.cubicTo(17.10766f, 68.2536f, 14.970034f, 67.06527f, 15.0f, 65.0f);
                j.cubicTo(14.920089f, 54.383034f, 15.0899f, 43.678036f, 15.0f, 33.0f);
                j.cubicTo(15.059934f, 31.435186f, 14.790233f, 29.447971f, 16.0f, 29.0f);
                j.lineTo(16.0f, 29.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(66.0f, 41.0f);
                j.cubicTo(71.03873f, 37.01664f, 75.738205f, 32.185577f, 81.0f, 28.0f);
                j.cubicTo(82.33345f, 30.067574f, 81.93434f, 32.58901f, 82.0f, 35.0f);
                j.cubicTo(81.94432f, 44.71205f, 81.97425f, 54.505295f, 82.0f, 64.0f);
                j.cubicTo(82.00419f, 65.62985f, 81.66495f, 66.86031f, 81.0f, 68.0f);
                j.cubicTo(75.718254f, 63.82451f, 71.01877f, 58.993443f, 66.0f, 55.0f);
                j.lineTo(66.0f, 41.0f);
                j.lineTo(66.0f, 41.0f);
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
