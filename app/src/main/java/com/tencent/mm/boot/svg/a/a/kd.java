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

public final class kd extends c {
    private final int height = 39;
    private final int width = 39;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 39;
            case 1:
                return 39;
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
                a.setColor(-1710619);
                e = c.a(e, 1.0f, 0.0f, -322.0f, 0.0f, 1.0f, -941.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 323.0f, 0.0f, 1.0f, 942.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(18.5f, 0.0f);
                j.cubicTo(8.282732f, -6.256272E-16f, 1.2512544E-15f, 8.282732f, 0.0f, 18.5f);
                j.cubicTo(-1.2512544E-15f, 28.717268f, 8.282732f, 37.0f, 18.5f, 37.0f);
                j.cubicTo(28.717268f, 37.0f, 37.0f, 28.717268f, 37.0f, 18.5f);
                j.cubicTo(37.0f, 13.593495f, 35.0509f, 8.887947f, 31.581476f, 5.4185247f);
                j.cubicTo(28.112053f, 1.9491016f, 23.406506f, 3.004368E-16f, 18.5f, 0.0f);
                j.close();
                j.moveTo(18.470951f, 34.999973f);
                j.cubicTo(9.3658285f, 34.983944f, 1.9946595f, 27.595451f, 2.0000029f, 18.490316f);
                j.cubicTo(2.0053463f, 9.385182f, 9.385182f, 2.0053463f, 18.490316f, 2.0000029f);
                j.cubicTo(27.595451f, 1.9946595f, 34.983944f, 9.3658285f, 34.999973f, 18.470951f);
                j.cubicTo(35.007698f, 22.857082f, 33.26873f, 27.065794f, 30.167261f, 30.167261f);
                j.cubicTo(27.065794f, 33.26873f, 22.857082f, 35.007698f, 18.470951f, 34.999973f);
                j.lineTo(18.470951f, 34.999973f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 1);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                Paint a3 = c.a(a, looper);
                Path j2 = c.j(looper);
                j2.moveTo(14.230769f, 27.508078f);
                j2.lineTo(9.961538f, 27.508078f);
                j2.lineTo(11.66923f, 9.961538f);
                j2.lineTo(16.066538f, 9.961538f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 1);
                WeChatSVGRenderC2Java.setFillType(j2, 1);
                canvas.drawPath(j2, a3);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(21.150963f, 16.820768f);
                j.cubicTo(20.627676f, 17.163134f, 20.287874f, 17.724329f, 20.22702f, 18.346695f);
                j.cubicTo(20.166168f, 18.969063f, 20.390827f, 19.58545f, 20.837887f, 20.022692f);
                j.cubicTo(22.147118f, 21.801538f, 26.530195f, 27.508078f, 26.530195f, 27.508078f);
                j.lineTo(20.980194f, 27.508078f);
                j.cubicTo(19.115963f, 24.861155f, 18.247887f, 23.452307f, 16.525963f, 21.033077f);
                j.cubicTo(15.165143f, 19.326057f, 15.424838f, 16.843111f, 17.109425f, 15.454616f);
                j.cubicTo(17.820963f, 14.743077f, 20.254425f, 12.409231f, 22.801733f, 9.961538f);
                j.lineTo(28.10981f, 9.961538f);
                j.lineTo(21.150963f, 16.820768f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 1);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
