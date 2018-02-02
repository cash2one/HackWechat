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

public final class ano extends c {
    private final int height = 180;
    private final int width = 120;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 120;
            case 1:
                return 180;
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
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-1);
                Path j = c.j(looper);
                j.moveTo(24.0f, 76.0f);
                j.lineTo(24.0f, 98.23779f);
                j.cubicTo(24.0f, 121.084274f, 40.67616f, 139.71544f, 62.0f, 141.80502f);
                j.lineTo(62.0f, 152.0f);
                j.lineTo(70.0f, 152.0f);
                j.lineTo(70.0f, 141.80527f);
                j.lineTo(70.0f, 141.80527f);
                j.cubicTo(91.31973f, 139.7189f, 108.0f, 121.12331f, 108.0f, 98.434006f);
                j.lineTo(108.0f, 76.0f);
                j.lineTo(100.0f, 76.0f);
                j.lineTo(100.0f, 98.63076f);
                j.cubicTo(100.0f, 118.188705f, 84.77768f, 134.0f, 66.0f, 134.0f);
                j.cubicTo(47.21819f, 134.0f, 32.0f, 118.16465f, 32.0f, 98.63076f);
                j.lineTo(32.0f, 76.0f);
                j.lineTo(24.0f, 76.0f);
                j.lineTo(24.0f, 76.0f);
                j.close();
                j.moveTo(38.0f, 152.0f);
                j.cubicTo(35.79086f, 152.0f, 34.0f, 153.79086f, 34.0f, 156.0f);
                j.cubicTo(34.0f, 158.20914f, 35.79086f, 160.0f, 38.0f, 160.0f);
                j.lineTo(94.0f, 160.0f);
                j.cubicTo(96.20914f, 160.0f, 98.0f, 158.20914f, 98.0f, 156.0f);
                j.cubicTo(98.0f, 153.79086f, 96.20914f, 152.0f, 94.0f, 152.0f);
                j.lineTo(38.0f, 152.0f);
                j.close();
                j.moveTo(40.0f, 98.66034f);
                j.cubicTo(40.0f, 113.75961f, 51.63744f, 126.0f, 66.0f, 126.0f);
                j.cubicTo(80.359406f, 126.0f, 92.0f, 113.77821f, 92.0f, 98.66034f);
                j.lineTo(92.0f, 45.339664f);
                j.cubicTo(92.0f, 30.240385f, 80.362564f, 18.0f, 66.0f, 18.0f);
                j.cubicTo(51.6406f, 18.0f, 40.0f, 30.22179f, 40.0f, 45.339664f);
                j.lineTo(40.0f, 98.66034f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                a = c.a(i2, looper);
                a.setColor(-1);
                j = c.j(looper);
                j.moveTo(104.0f, 80.0f);
                j.cubicTo(106.20914f, 80.0f, 108.0f, 78.20914f, 108.0f, 76.0f);
                j.cubicTo(108.0f, 73.79086f, 106.20914f, 72.0f, 104.0f, 72.0f);
                j.cubicTo(101.79086f, 72.0f, 100.0f, 73.79086f, 100.0f, 76.0f);
                j.cubicTo(100.0f, 78.20914f, 101.79086f, 80.0f, 104.0f, 80.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                i2 = c.a(i2, looper);
                i2.setColor(-1);
                j = c.j(looper);
                j.moveTo(28.0f, 80.0f);
                j.cubicTo(30.209139f, 80.0f, 32.0f, 78.20914f, 32.0f, 76.0f);
                j.cubicTo(32.0f, 73.79086f, 30.209139f, 72.0f, 28.0f, 72.0f);
                j.cubicTo(25.790861f, 72.0f, 24.0f, 73.79086f, 24.0f, 76.0f);
                j.cubicTo(24.0f, 78.20914f, 25.790861f, 80.0f, 28.0f, 80.0f);
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
