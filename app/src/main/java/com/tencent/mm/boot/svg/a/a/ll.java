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

public final class ll extends c {
    private final int height = 60;
    private final int width = 60;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 60;
            case 1:
                return 60;
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
                Path j = c.j(looper);
                j.moveTo(0.0f, 0.0f);
                j.lineTo(60.0f, 0.0f);
                j.lineTo(60.0f, 60.0f);
                j.lineTo(0.0f, 60.0f);
                j.lineTo(0.0f, 0.0f);
                j.close();
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-1);
                j = c.j(looper);
                j.moveTo(9.0f, 14.380721f);
                j.cubicTo(9.0f, 11.409031f, 11.404006f, 9.0f, 14.380721f, 9.0f);
                j.lineTo(46.619278f, 9.0f);
                j.cubicTo(49.59097f, 9.0f, 52.0f, 11.404006f, 52.0f, 14.380721f);
                j.lineTo(52.0f, 46.619278f);
                j.cubicTo(52.0f, 49.59097f, 49.595993f, 52.0f, 46.619278f, 52.0f);
                j.lineTo(14.380721f, 52.0f);
                j.cubicTo(11.409031f, 52.0f, 9.0f, 49.595993f, 9.0f, 46.619278f);
                j.lineTo(9.0f, 14.380721f);
                j.lineTo(9.0f, 14.380721f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                i2 = c.a(i2, looper);
                i2.setColor(-964550);
                j = c.j(looper);
                j.moveTo(6.0f, 12.006387f);
                j.cubicTo(6.0f, 8.689151f, 8.683541f, 6.0f, 12.006387f, 6.0f);
                j.lineTo(47.993614f, 6.0f);
                j.cubicTo(51.31085f, 6.0f, 54.0f, 8.683541f, 54.0f, 12.006387f);
                j.lineTo(54.0f, 47.993614f);
                j.cubicTo(54.0f, 51.31085f, 51.31646f, 54.0f, 47.993614f, 54.0f);
                j.lineTo(12.006387f, 54.0f);
                j.cubicTo(8.689151f, 54.0f, 6.0f, 51.31646f, 6.0f, 47.993614f);
                j.lineTo(6.0f, 12.006387f);
                j.lineTo(6.0f, 12.006387f);
                j.close();
                j.moveTo(12.0f, 32.576923f);
                j.lineTo(16.2f, 28.538462f);
                j.lineTo(25.0f, 36.923077f);
                j.lineTo(43.8f, 19.0f);
                j.lineTo(48.0f, 23.038462f);
                j.lineTo(25.0f, 45.0f);
                j.lineTo(12.0f, 32.576923f);
                j.lineTo(12.0f, 32.576923f);
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
