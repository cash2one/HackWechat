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

public final class yg extends c {
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
                i2.setColor(-16896);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(21.44831f, 69.12264f);
                j.lineTo(46.491844f, 26.187445f);
                j.cubicTo(47.320778f, 24.766298f, 48.675976f, 24.758957f, 49.509193f, 26.187445f);
                j.lineTo(74.55273f, 69.12264f);
                j.cubicTo(75.38166f, 70.54379f, 74.719376f, 71.70915f, 73.063896f, 71.70915f);
                j.lineTo(22.937145f, 71.70915f);
                j.cubicTo(21.285309f, 71.70915f, 20.615093f, 70.55113f, 21.44831f, 69.12264f);
                j.close();
                j.moveTo(46.700405f, 41.400345f);
                j.cubicTo(46.15008f, 41.400345f, 45.72443f, 41.842537f, 45.75011f, 42.39727f);
                j.lineTo(46.46933f, 57.932423f);
                j.lineTo(49.530827f, 57.932423f);
                j.lineTo(50.250046f, 42.39727f);
                j.cubicTo(50.275536f, 41.846684f, 49.83909f, 41.400345f, 49.29975f, 41.400345f);
                j.lineTo(46.700405f, 41.400345f);
                j.close();
                j.moveTo(48.000076f, 65.280014f);
                j.cubicTo(49.268192f, 65.280014f, 50.2962f, 64.252f, 50.2962f, 62.98389f);
                j.cubicTo(50.2962f, 61.715775f, 49.268192f, 60.687767f, 48.000076f, 60.687767f);
                j.cubicTo(46.731964f, 60.687767f, 45.703957f, 61.715775f, 45.703957f, 62.98389f);
                j.cubicTo(45.703957f, 64.252f, 46.731964f, 65.280014f, 48.000076f, 65.280014f);
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
