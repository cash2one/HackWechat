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

public final class wt extends c {
    private final int height = 36;
    private final int width = 46;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 46;
            case 1:
                return 36;
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
                a.setColor(-16036);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(25.915672f, 0.0f);
                j.cubicTo(25.97802f, 12.003458f, 26.092323f, 24.006916f, 25.863716f, 36.0f);
                j.cubicTo(19.75988f, 32.49351f, 13.654047f, 28.48876f, 7.201107f, 25.397118f);
                j.cubicTo(4.8215203f, 25.034006f, 2.4003692f, 25.241499f, 0.0f, 25.241499f);
                j.lineTo(0.0f, 10.696254f);
                j.cubicTo(2.4003692f, 10.696254f, 4.8215203f, 10.903747f, 7.2114983f, 10.540634f);
                j.cubicTo(13.685221f, 7.5008645f, 19.217047f, 3.8922536f, 25.915672f, 0.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(34.0f, 8.687097f);
                j.cubicTo(37.385418f, 6.432258f, 40.822918f, 4.225806f, 44.239582f, 2.0f);
                j.cubicTo(44.822918f, 2.7935483f, 45.40625f, 3.5774193f, 46.0f, 4.370968f);
                j.cubicTo(42.5625f, 6.548387f, 39.177082f, 8.793549f, 35.760418f, 11.0f);
                j.cubicTo(35.1875f, 10.225806f, 34.59375f, 9.451612f, 34.0f, 8.687097f);
                j.lineTo(34.0f, 8.687097f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                i2 = c.a(a, looper);
                Path j2 = c.j(looper);
                j2.moveTo(46.0f, 16.0f);
                j2.lineTo(46.0f, 19.0f);
                j2.lineTo(34.0f, 19.0f);
                j2.lineTo(34.0f, 16.0f);
                j2.lineTo(46.0f, 16.0f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, i2);
                canvas.restore();
                canvas.save();
                a = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(34.0f, 26.688448f);
                j.cubicTo(34.535355f, 25.806301f, 35.050507f, 24.913652f, 35.535355f, 24.0f);
                j.cubicTo(39.0101f, 26.121353f, 42.50505f, 28.211203f, 46.0f, 30.290548f);
                j.cubicTo(45.626263f, 30.973162f, 44.878788f, 32.317387f, 44.515152f, 33.0f);
                j.cubicTo(41.0f, 30.89965f, 37.50505f, 28.788797f, 34.0f, 26.688448f);
                j.lineTo(34.0f, 26.688448f);
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
