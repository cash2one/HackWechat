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

public final class aos extends c {
    private final int height = 162;
    private final int width = 162;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 162;
            case 1:
                return 162;
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
                Path j = c.j(looper);
                j.moveTo(13.0f, 37.996094f);
                j.cubicTo(13.0f, 35.789112f, 14.782292f, 34.0f, 17.007507f, 34.0f);
                j.lineTo(145.9925f, 34.0f);
                j.cubicTo(148.20578f, 34.0f, 150.0f, 35.795326f, 150.0f, 37.996094f);
                j.lineTo(150.0f, 123.00391f);
                j.cubicTo(150.0f, 125.21089f, 148.21771f, 127.0f, 145.9925f, 127.0f);
                j.lineTo(17.007507f, 127.0f);
                j.cubicTo(14.794222f, 127.0f, 13.0f, 125.20467f, 13.0f, 123.00391f);
                j.lineTo(13.0f, 37.996094f);
                j.close();
                j.moveTo(23.0f, 52.0f);
                j.lineTo(140.0f, 52.0f);
                j.lineTo(140.0f, 69.0f);
                j.lineTo(23.0f, 69.0f);
                j.lineTo(23.0f, 52.0f);
                j.close();
                i3 = c.i(looper);
                i3.setFlags(385);
                i3.setStyle(Style.FILL);
                Paint i4 = c.i(looper);
                i4.setFlags(385);
                i4.setStyle(Style.STROKE);
                i3.setColor(WebView.NIGHT_MODE_COLOR);
                i4.setStrokeWidth(1.0f);
                i4.setStrokeCap(Cap.BUTT);
                i4.setStrokeJoin(Join.MITER);
                i4.setStrokeMiter(4.0f);
                i4.setPathEffect(null);
                float[] a2 = c.a(e, 150.0f, 0.0f, 13.0f, 0.0f, 127.0f, 34.0f);
                f.reset();
                f.setValues(a2);
                WeChatSVGRenderC2Java.setLinearGradient(a, 0.5f, 0.0f, 0.5f, 1.0f, new int[]{-9919532, -10117428}, new float[]{0.0f, 1.0f}, f, 0);
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
