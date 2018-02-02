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

public final class un extends c {
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
                Paint a = c.a(i3, looper);
                a.setStrokeWidth(1.0f);
                Paint a2 = c.a(i2, looper);
                a2.setColor(-8617594);
                canvas.save();
                Paint a3 = c.a(a2, looper);
                Path j = c.j(looper);
                j.moveTo(96.0f, 48.0f);
                j.cubicTo(96.0f, 74.50967f, 74.50967f, 96.0f, 48.0f, 96.0f);
                j.cubicTo(21.490332f, 96.0f, 0.0f, 74.50967f, 0.0f, 48.0f);
                j.cubicTo(0.0f, 21.490332f, 21.490332f, 0.0f, 48.0f, 0.0f);
                j.cubicTo(74.50967f, 0.0f, 96.0f, 21.490332f, 96.0f, 48.0f);
                j.close();
                j.moveTo(2.2325583f, 48.0f);
                j.cubicTo(2.2325583f, 73.27666f, 22.72334f, 93.76744f, 48.0f, 93.76744f);
                j.cubicTo(73.27666f, 93.76744f, 93.76744f, 73.27666f, 93.76744f, 48.0f);
                j.cubicTo(93.76744f, 22.72334f, 73.27666f, 2.2325583f, 48.0f, 2.2325583f);
                j.cubicTo(22.72334f, 2.2325583f, 2.2325583f, 22.72334f, 2.2325583f, 48.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 1);
                canvas.drawPath(j, a3);
                canvas.restore();
                canvas.save();
                a2 = c.a(a2, looper);
                a = c.a(a, looper);
                a.setColor(-8617594);
                a.setStrokeWidth(2.0f);
                j = c.j(looper);
                j.moveTo(61.0f, 51.0f);
                j.cubicTo(59.552845f, 51.154545f, 58.8374f, 50.327274f, 60.0f, 49.0f);
                j.cubicTo(59.672085f, 48.436363f, 60.506775f, 47.727272f, 62.0f, 48.0f);
                j.cubicTo(65.03794f, 46.663635f, 67.54201f, 43.945454f, 68.0f, 41.0f);
                j.cubicTo(67.54201f, 36.736362f, 63.845528f, 33.545456f, 60.0f, 33.0f);
                j.cubicTo(54.544716f, 33.545456f, 50.84824f, 36.736362f, 51.0f, 41.0f);
                j.lineTo(51.0f, 58.0f);
                j.cubicTo(50.84824f, 64.27273f, 45.482384f, 69.0f, 39.0f, 69.0f);
                j.cubicTo(32.365852f, 69.0f, 27.0f, 64.27273f, 27.0f, 58.0f);
                j.cubicTo(27.0f, 53.163635f, 31.17344f, 48.79091f, 37.0f, 48.0f);
                j.cubicTo(38.20867f, 47.96364f, 38.80488f, 49.618183f, 38.0f, 50.0f);
                j.cubicTo(37.759224f, 50.496105f, 37.373985f, 51.390907f, 36.0f, 51.0f);
                j.cubicTo(32.96206f, 52.454544f, 30.457994f, 55.172726f, 30.0f, 58.0f);
                j.cubicTo(30.457994f, 62.263638f, 34.154472f, 65.454544f, 38.0f, 66.0f);
                j.cubicTo(43.455284f, 65.454544f, 47.15176f, 62.263638f, 47.0f, 58.0f);
                j.lineTo(47.0f, 41.0f);
                j.cubicTo(47.15176f, 34.727272f, 52.517616f, 30.0f, 59.0f, 30.0f);
                j.cubicTo(65.63415f, 30.0f, 71.0f, 34.727272f, 71.0f, 41.0f);
                j.cubicTo(71.0f, 45.954544f, 66.82656f, 50.20909f, 61.0f, 51.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.drawPath(j, a);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
