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

public final class aog extends c {
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
                a.setColor(-12863723);
                e = c.a(e, 1.0f, 0.0f, 22.0f, 0.0f, 1.0f, 16.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(12.334797f, 4.3112025f);
                j.cubicTo(21.186792f, -1.572559f, 33.55958f, -1.422463f, 42.261543f, 4.6914454f);
                j.cubicTo(48.87303f, 9.174312f, 53.184006f, 17.00932f, 52.99396f, 25.054462f);
                j.cubicTo(52.903942f, 31.708717f, 50.01329f, 37.97272f, 46.38247f, 43.416203f);
                j.cubicTo(40.95125f, 51.47135f, 33.95967f, 58.28571f, 27.008104f, 65.0f);
                j.cubicTo(20.046535f, 58.315727f, 13.094969f, 51.481358f, 7.6637444f, 43.456226f);
                j.cubicTo(3.8228788f, 37.70255f, 0.7821936f, 31.028282f, 1.0122454f, 23.973772f);
                j.cubicTo(1.2122905f, 16.068718f, 5.713305f, 8.543908f, 12.334797f, 4.3112025f);
                j.lineTo(12.334797f, 4.3112025f);
                j.close();
                j.moveTo(23.398994f, 14.60051f);
                j.cubicTo(19.540892f, 15.836599f, 16.380636f, 19.116222f, 15.413617f, 23.063734f);
                j.cubicTo(13.429734f, 29.89213f, 18.853012f, 37.448223f, 25.90128f, 37.91674f);
                j.cubicTo(33.079147f, 38.83384f, 39.858246f, 32.02538f, 38.911163f, 24.848087f);
                j.cubicTo(38.442608f, 17.531237f, 30.3376f, 12.148268f, 23.398994f, 14.60051f);
                j.lineTo(23.398994f, 14.60051f);
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
