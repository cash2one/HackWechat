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

public final class hq extends c {
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
                i2.setColor(-8617594);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(39.0f, 87.17454f);
                j.cubicTo(41.636593f, 87.715576f, 44.36543f, 88.0f, 47.160282f, 88.0f);
                j.cubicTo(52.397297f, 88.0f, 57.40235f, 87.001335f, 62.0f, 85.18495f);
                j.lineTo(39.0f, 62.0f);
                j.lineTo(39.0f, 87.17454f);
                j.close();
                j.moveTo(84.18153f, 34.0f);
                j.lineTo(61.0f, 57.0f);
                j.lineTo(86.17404f, 57.0f);
                j.cubicTo(86.71542f, 54.364433f, 87.0f, 51.636253f, 87.0f, 48.841667f);
                j.cubicTo(87.0f, 43.60351f, 86.00011f, 38.59756f, 84.18153f, 34.0f);
                j.lineTo(84.18153f, 34.0f);
                j.close();
                j.moveTo(68.36796f, 82.0f);
                j.cubicTo(74.77223f, 77.61014f, 79.888794f, 71.36405f, 83.0f, 64.0f);
                j.lineTo(51.0f, 64.0f);
                j.lineTo(68.36796f, 82.0f);
                j.close();
                j.moveTo(7.0f, 48.134434f);
                j.cubicTo(7.0f, 53.381317f, 8.00163f, 58.394844f, 9.8239765f, 63.0f);
                j.lineTo(33.0f, 40.0f);
                j.lineTo(7.8198056f, 40.0f);
                j.cubicTo(7.2825346f, 42.628418f, 7.0f, 45.348637f, 7.0f, 48.134434f);
                j.lineTo(7.0f, 48.134434f);
                j.close();
                j.moveTo(24.616856f, 15.0f);
                j.cubicTo(18.216589f, 19.392467f, 13.105181f, 25.63808f, 10.0f, 33.0f);
                j.lineTo(42.0f, 33.0f);
                j.lineTo(24.616856f, 15.0f);
                j.close();
                j.moveTo(63.0f, 11.0f);
                j.lineTo(63.0f, 43.0f);
                j.lineTo(81.0f, 25.622782f);
                j.cubicTo(76.60968f, 19.219759f, 70.3637f, 14.106408f, 63.0f, 11.0f);
                j.lineTo(63.0f, 11.0f);
                j.close();
                j.moveTo(32.0f, 84.0f);
                j.lineTo(32.0f, 52.0f);
                j.lineTo(14.0f, 69.37412f);
                j.cubicTo(18.39201f, 75.77617f, 24.637726f, 80.88998f, 32.0f, 84.0f);
                j.lineTo(32.0f, 84.0f);
                j.close();
                j.moveTo(56.0f, 8.82031f);
                j.cubicTo(53.37215f, 8.282693f, 50.65258f, 8.0f, 47.867496f, 8.0f);
                j.cubicTo(42.61948f, 8.0f, 37.60506f, 9.003309f, 33.0f, 10.826928f);
                j.lineTo(56.0f, 34.0f);
                j.lineTo(56.0f, 8.82031f);
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
