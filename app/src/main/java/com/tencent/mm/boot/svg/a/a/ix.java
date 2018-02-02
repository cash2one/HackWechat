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

public final class ix extends c {
    private final int height = 102;
    private final int width = 102;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 102;
            case 1:
                return 102;
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
                Paint a = c.a(i2, looper);
                a.setColor(-1);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(51.0f, 102.0f);
                j.cubicTo(79.16652f, 102.0f, 102.0f, 79.16652f, 102.0f, 51.0f);
                j.cubicTo(102.0f, 22.833477f, 79.16652f, 0.0f, 51.0f, 0.0f);
                j.cubicTo(22.833477f, 0.0f, 0.0f, 22.833477f, 0.0f, 51.0f);
                j.cubicTo(0.0f, 79.16652f, 22.833477f, 102.0f, 51.0f, 102.0f);
                j.close();
                j.moveTo(51.0f, 98.0f);
                j.cubicTo(76.95738f, 98.0f, 98.0f, 76.95738f, 98.0f, 51.0f);
                j.cubicTo(98.0f, 25.042616f, 76.95738f, 4.0f, 51.0f, 4.0f);
                j.cubicTo(25.042616f, 4.0f, 4.0f, 25.042616f, 4.0f, 51.0f);
                j.cubicTo(4.0f, 76.95738f, 25.042616f, 98.0f, 51.0f, 98.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                float[] a3 = c.a(e, 1.0f, 0.0f, 15.0f, 0.0f, 1.0f, 14.0f);
                f.reset();
                f.setValues(a3);
                canvas.concat(f);
                canvas.save();
                a3 = c.a(a3, 1.0f, 0.0f, 9.0f, 0.0f, 1.0f, 24.0f);
                f.reset();
                f.setValues(a3);
                canvas.concat(f);
                canvas.save();
                Paint a4 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(15.415947f, 1.2113346f);
                j.cubicTo(16.290796f, 0.54233295f, 17.0f, 0.8949788f, 17.0f, 1.9970046f);
                j.lineTo(17.0f, 24.002995f);
                j.cubicTo(17.0f, 25.105911f, 16.291174f, 25.457956f, 15.415947f, 24.788666f);
                j.lineTo(1.5840529f, 14.211334f);
                j.cubicTo(0.7092046f, 13.542333f, 0.70882535f, 12.457957f, 1.5840529f, 11.788666f);
                j.lineTo(15.415947f, 1.2113346f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a4);
                canvas.restore();
                canvas.save();
                i2 = c.a(a, looper);
                Path j2 = c.j(looper);
                j2.moveTo(14.0f, 9.0f);
                j2.lineTo(55.0f, 9.0f);
                j2.lineTo(55.0f, 17.0f);
                j2.lineTo(14.0f, 17.0f);
                j2.lineTo(14.0f, 9.0f);
                j2.close();
                canvas.drawPath(j2, i2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
