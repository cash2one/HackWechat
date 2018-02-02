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

public final class x extends c {
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
                a.setColor(-1);
                e = c.a(e, 1.0f, 0.0f, 24.0f, 0.0f, 1.0f, 24.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(1.0f, 5.270896f);
                j.cubicTo(2.4202743f, 3.8405488f, 3.8405488f, 2.4202743f, 5.270896f, 1.0f);
                j.cubicTo(11.687312f, 7.3962708f, 18.083584f, 13.812688f, 24.5f, 20.21903f);
                j.cubicTo(30.916416f, 13.822761f, 37.312687f, 7.3962708f, 43.729103f, 1.0f);
                j.cubicTo(45.15945f, 2.4202743f, 46.579727f, 3.8405488f, 48.0f, 5.270896f);
                j.cubicTo(41.60373f, 11.687312f, 35.17724f, 18.083584f, 28.78097f, 24.5f);
                j.cubicTo(35.17724f, 30.916416f, 41.60373f, 37.312687f, 48.0f, 43.739178f);
                j.cubicTo(46.579727f, 45.15945f, 45.15945f, 46.579727f, 43.739178f, 48.0f);
                j.cubicTo(37.312687f, 41.60373f, 30.916416f, 35.17724f, 24.5f, 28.78097f);
                j.cubicTo(18.083584f, 35.17724f, 11.687312f, 41.60373f, 5.270896f, 48.0f);
                j.cubicTo(3.8405488f, 46.579727f, 2.4202743f, 45.15945f, 1.0f, 43.739178f);
                j.cubicTo(7.3962708f, 37.312687f, 13.822761f, 30.916416f, 20.21903f, 24.5f);
                j.cubicTo(13.822761f, 18.083584f, 7.3962708f, 11.687312f, 1.0f, 5.270896f);
                j.lineTo(1.0f, 5.270896f);
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
