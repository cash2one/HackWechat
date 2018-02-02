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

public final class abr extends c {
    private final int height = 73;
    private final int width = 73;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 73;
            case 1:
                return 73;
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
                i2.setColor(-1);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(54.0f, 36.33741f);
                j.lineTo(54.0f, 15.0f);
                j.lineTo(20.0f, 15.0f);
                j.lineTo(20.0f, 57.0f);
                j.lineTo(54.0f, 57.0f);
                j.lineTo(54.0f, 40.860947f);
                j.cubicTo(46.617874f, 45.131622f, 36.955612f, 50.721386f, 36.955612f, 50.721386f);
                j.lineTo(36.77752f, 50.824207f);
                j.cubicTo(36.557053f, 50.935654f, 36.30878f, 51.0f, 36.04528f, 51.0f);
                j.cubicTo(35.43552f, 51.0f, 34.90521f, 50.66301f, 34.626484f, 50.16615f);
                j.lineTo(34.51989f, 49.93198f);
                j.lineTo(30.078123f, 40.165905f);
                j.cubicTo(30.029793f, 40.059105f, 30.0f, 39.939034f, 30.0f, 39.82228f);
                j.cubicTo(30.0f, 39.37252f, 30.364134f, 39.007004f, 30.813673f, 39.007004f);
                j.cubicTo(30.996403f, 39.007004f, 31.164566f, 39.06737f, 31.300287f, 39.168865f);
                j.lineTo(36.541824f, 42.90826f);
                j.cubicTo(36.92516f, 43.159676f, 37.38264f, 43.306942f, 37.874554f, 43.306942f);
                j.cubicTo(38.167847f, 43.306942f, 38.4479f, 43.251884f, 38.70875f, 43.157024f);
                j.cubicTo(38.70875f, 43.157024f, 46.71709f, 39.585453f, 53.33591f, 36.633583f);
                j.close();
                j.moveTo(16.0f, 13.996532f);
                j.cubicTo(16.0f, 12.341594f, 17.349846f, 11.0f, 19.003681f, 11.0f);
                j.lineTo(54.99632f, 11.0f);
                j.cubicTo(56.655205f, 11.0f, 58.0f, 12.337379f, 58.0f, 13.996532f);
                j.lineTo(58.0f, 58.003468f);
                j.cubicTo(58.0f, 59.658405f, 56.650154f, 61.0f, 54.99632f, 61.0f);
                j.lineTo(19.003681f, 61.0f);
                j.cubicTo(17.344793f, 61.0f, 16.0f, 59.66262f, 16.0f, 58.003468f);
                j.lineTo(16.0f, 13.996532f);
                j.close();
                j.moveTo(24.0f, 21.0f);
                j.lineTo(39.0f, 21.0f);
                j.lineTo(39.0f, 24.0f);
                j.lineTo(24.0f, 24.0f);
                j.lineTo(24.0f, 21.0f);
                j.close();
                j.moveTo(24.0f, 28.0f);
                j.lineTo(39.0f, 28.0f);
                j.lineTo(39.0f, 31.0f);
                j.lineTo(24.0f, 31.0f);
                j.lineTo(24.0f, 28.0f);
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
