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

public final class ew extends c {
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
                canvas.save();
                i3 = c.a(i2, looper);
                i3.setColor(-1);
                Path j = c.j(looper);
                j.moveTo(11.0f, 15.0f);
                j.lineTo(44.0f, 15.0f);
                j.lineTo(44.0f, 48.0f);
                j.lineTo(11.0f, 48.0f);
                j.lineTo(11.0f, 15.0f);
                j.close();
                canvas.drawPath(j, i3);
                canvas.restore();
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-2012855);
                Path j2 = c.j(looper);
                j2.moveTo(30.0f, 28.37868f);
                j2.lineTo(20.454058f, 18.832739f);
                j2.lineTo(18.332739f, 20.954058f);
                j2.lineTo(27.87868f, 30.5f);
                j2.lineTo(18.332739f, 40.04594f);
                j2.lineTo(20.454058f, 42.167263f);
                j2.lineTo(30.0f, 32.62132f);
                j2.lineTo(39.54594f, 42.167263f);
                j2.lineTo(41.667263f, 40.04594f);
                j2.lineTo(32.12132f, 30.5f);
                j2.lineTo(41.667263f, 20.954058f);
                j2.lineTo(39.54594f, 18.832739f);
                j2.lineTo(30.0f, 28.37868f);
                j2.close();
                j2.moveTo(30.0f, 60.0f);
                j2.cubicTo(13.4314575f, 60.0f, 0.0f, 46.568542f, 0.0f, 30.0f);
                j2.cubicTo(0.0f, 13.4314575f, 13.4314575f, 0.0f, 30.0f, 0.0f);
                j2.cubicTo(46.568542f, 0.0f, 60.0f, 13.4314575f, 60.0f, 30.0f);
                j2.cubicTo(60.0f, 46.568542f, 46.568542f, 60.0f, 30.0f, 60.0f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 1);
                canvas.drawPath(j2, a);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
