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

public final class uo extends c {
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
                a2.setColor(-8420471);
                Path j = c.j(looper);
                j.moveTo(96.0f, 47.448277f);
                j.cubicTo(96.0f, 74.50933f, 74.50971f, 96.0f, 48.551723f, 96.0f);
                j.cubicTo(21.490286f, 96.0f, 0.0f, 74.50933f, 0.0f, 47.448277f);
                j.cubicTo(0.0f, 21.488955f, 21.490286f, 5.9487298E-15f, 48.551723f, 5.9487298E-15f);
                j.cubicTo(74.50971f, 5.9487298E-15f, 96.0f, 21.488955f, 96.0f, 47.448277f);
                j.close();
                canvas.saveLayerAlpha(null, 51, 4);
                Paint a3 = c.a(a2, looper);
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a3);
                canvas.restore();
                canvas.save();
                a2 = c.a(i2, looper);
                a2.setColor(-8617594);
                j = c.j(looper);
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
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                i2 = c.a(i2, looper);
                a = c.a(a, looper);
                i2.setColor(-8617594);
                a.setColor(-8617594);
                a.setStrokeWidth(2.0f);
                j = c.j(looper);
                j.moveTo(60.0f, 50.0f);
                j.cubicTo(58.552845f, 50.154545f, 57.8374f, 49.327274f, 59.0f, 48.0f);
                j.cubicTo(58.672085f, 47.436363f, 59.506775f, 46.727272f, 61.0f, 47.0f);
                j.cubicTo(64.03794f, 45.663635f, 66.54201f, 42.945454f, 67.0f, 40.0f);
                j.cubicTo(66.54201f, 35.736362f, 62.845528f, 32.545456f, 59.0f, 32.0f);
                j.cubicTo(53.544716f, 32.545456f, 49.84824f, 35.736362f, 50.0f, 40.0f);
                j.lineTo(50.0f, 57.0f);
                j.cubicTo(49.84824f, 63.272728f, 44.482384f, 68.0f, 38.0f, 68.0f);
                j.cubicTo(31.365854f, 68.0f, 26.0f, 63.272728f, 26.0f, 57.0f);
                j.cubicTo(26.0f, 52.163635f, 30.17344f, 47.79091f, 36.0f, 47.0f);
                j.cubicTo(37.20867f, 46.96364f, 37.80488f, 48.618183f, 37.0f, 49.0f);
                j.cubicTo(36.759224f, 49.496105f, 36.373985f, 50.390907f, 35.0f, 50.0f);
                j.cubicTo(31.962059f, 51.454544f, 29.457994f, 54.172726f, 29.0f, 57.0f);
                j.cubicTo(29.457994f, 61.263638f, 33.154472f, 64.454544f, 37.0f, 65.0f);
                j.cubicTo(42.455284f, 64.454544f, 46.15176f, 61.263638f, 46.0f, 57.0f);
                j.lineTo(46.0f, 40.0f);
                j.cubicTo(46.15176f, 33.727272f, 51.517616f, 29.0f, 58.0f, 29.0f);
                j.cubicTo(64.63415f, 29.0f, 70.0f, 33.727272f, 70.0f, 40.0f);
                j.cubicTo(70.0f, 44.954544f, 65.82656f, 49.20909f, 60.0f, 50.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, i2);
                canvas.drawPath(j, a);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
