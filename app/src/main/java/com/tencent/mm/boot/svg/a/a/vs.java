package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class vs extends c {
    private final int height = 120;
    private final int width = 120;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 120;
            case 1:
                return 120;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                Matrix f = c.f(looper);
                float[] e = c.e(looper);
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
                e = c.a(e, 1.0f, 0.0f, -180.0f, 0.0f, 1.0f, -98.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 180.0f, 0.0f, 1.0f, 98.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                Paint a = c.a(i2, looper);
                a.setColor(-3552823);
                canvas.save();
                a = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(0.0f, 0.0f);
                j.lineTo(120.0f, 0.0f);
                j.lineTo(120.0f, 120.0f);
                j.lineTo(0.0f, 120.0f);
                j.lineTo(0.0f, 0.0f);
                j.close();
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                Paint a2 = c.a(i2, looper);
                a2.setColor(-1);
                Path j2 = c.j(looper);
                j2.moveTo(84.01563f, 54.268833f);
                j2.cubicTo(89.06397f, 49.220486f, 89.01945f, 40.99985f, 83.91914f, 35.89955f);
                j2.cubicTo(78.81996f, 30.80037f, 70.595184f, 30.757744f, 65.549866f, 35.803066f);
                j2.lineTo(53.803066f, 47.549866f);
                j2.cubicTo(48.75472f, 52.59821f, 48.799248f, 60.818844f, 53.89955f, 65.91914f);
                j2.lineTo(56.50995f, 63.308746f);
                j2.cubicTo(52.866802f, 59.6656f, 52.805256f, 53.823605f, 56.441032f, 50.18783f);
                j2.lineTo(68.18783f, 38.441032f);
                j2.cubicTo(71.82153f, 34.807327f, 77.66728f, 34.86849f, 81.30875f, 38.50995f);
                j2.cubicTo(84.9519f, 42.153095f, 85.01344f, 47.99509f, 81.37766f, 51.630867f);
                j2.lineTo(75.504265f, 57.504265f);
                j2.lineTo(78.142235f, 60.14223f);
                j2.lineTo(84.01563f, 54.268833f);
                j2.close();
                j2.moveTo(35.803066f, 65.549866f);
                j2.cubicTo(30.75472f, 70.598206f, 30.799248f, 78.81885f, 35.89955f, 83.91914f);
                j2.cubicTo(40.99873f, 89.018326f, 49.22351f, 89.06095f, 54.268833f, 84.01563f);
                j2.lineTo(66.01563f, 72.26883f);
                j2.cubicTo(71.06397f, 67.22049f, 71.01945f, 58.99985f, 65.91914f, 53.89955f);
                j2.lineTo(63.308746f, 56.50995f);
                j2.cubicTo(66.9519f, 60.153095f, 67.01344f, 65.99509f, 63.377663f, 69.63087f);
                j2.lineTo(51.630867f, 81.37766f);
                j2.cubicTo(47.997158f, 85.01137f, 42.151413f, 84.95021f, 38.50995f, 81.30875f);
                j2.cubicTo(34.866802f, 77.665596f, 34.805256f, 71.82361f, 38.441032f, 68.18783f);
                j2.lineTo(44.31443f, 62.31443f);
                j2.lineTo(41.676464f, 59.676464f);
                j2.lineTo(35.803066f, 65.549866f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
