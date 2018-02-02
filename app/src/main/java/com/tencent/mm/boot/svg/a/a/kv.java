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

public final class kv extends c {
    private final int height = 56;
    private final int width = 10;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 10;
            case 1:
                return 56;
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
                Paint a = c.a(i2, looper);
                a.setColor(-3684404);
                e = c.a(e, 1.0f, 0.0f, -273.0f, 0.0f, 1.0f, -165.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(278.0f, 175.0f);
                j.cubicTo(280.7614f, 175.0f, 283.0f, 172.76143f, 283.0f, 170.0f);
                j.cubicTo(283.0f, 167.23857f, 280.7614f, 165.0f, 278.0f, 165.0f);
                j.cubicTo(275.2386f, 165.0f, 273.0f, 167.23857f, 273.0f, 170.0f);
                j.cubicTo(273.0f, 172.76143f, 275.2386f, 175.0f, 278.0f, 175.0f);
                j.close();
                j.moveTo(278.0f, 198.0f);
                j.cubicTo(280.7614f, 198.0f, 283.0f, 195.76143f, 283.0f, 193.0f);
                j.cubicTo(283.0f, 190.23857f, 280.7614f, 188.0f, 278.0f, 188.0f);
                j.cubicTo(275.2386f, 188.0f, 273.0f, 190.23857f, 273.0f, 193.0f);
                j.cubicTo(273.0f, 195.76143f, 275.2386f, 198.0f, 278.0f, 198.0f);
                j.close();
                j.moveTo(278.0f, 221.0f);
                j.cubicTo(280.7614f, 221.0f, 283.0f, 218.76143f, 283.0f, 216.0f);
                j.cubicTo(283.0f, 213.23857f, 280.7614f, 211.0f, 278.0f, 211.0f);
                j.cubicTo(275.2386f, 211.0f, 273.0f, 213.23857f, 273.0f, 216.0f);
                j.cubicTo(273.0f, 218.76143f, 275.2386f, 221.0f, 278.0f, 221.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
