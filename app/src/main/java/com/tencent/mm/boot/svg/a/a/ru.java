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

public final class ru extends c {
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
                e = c.a(e, 1.0f, 0.0f, -3787.0f, 0.0f, 1.0f, -1426.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 3716.0f, 0.0f, 1.0f, 1222.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 71.0f, 0.0f, 1.0f, 204.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-564640);
                Path j = c.j(looper);
                j.moveTo(120.0f, 60.69974f);
                j.cubicTo(120.0f, 26.989773f, 93.13778f, 0.26119402f, 59.25926f, 0.26119402f);
                j.cubicTo(26.862223f, 0.26119402f, 0.0f, 26.989773f, 0.0f, 60.69974f);
                j.cubicTo(0.0f, 92.9356f, 26.862223f, 119.66418f, 59.25926f, 119.66418f);
                j.cubicTo(93.13778f, 119.66418f, 120.0f, 92.9356f, 120.0f, 60.69974f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                a = c.a(i2, looper);
                a.setColor(-1);
                j = c.j(looper);
                j.moveTo(60.0f, 30.697248f);
                j.cubicTo(56.751266f, 30.697248f, 54.240303f, 33.333435f, 54.391315f, 36.579117f);
                j.lineTo(55.892197f, 68.836845f);
                j.cubicTo(55.995052f, 71.04744f, 57.877804f, 72.83948f, 60.06893f, 72.83948f);
                j.lineTo(59.93107f, 72.83948f);
                j.cubicTo(62.13496f, 72.83948f, 64.00457f, 71.055595f, 64.1078f, 68.836845f);
                j.lineTo(65.60868f, 36.579117f);
                j.cubicTo(65.75983f, 33.33065f, 63.242123f, 30.697248f, 60.0f, 30.697248f);
                j.close();
                j.moveTo(60.0f, 91.56936f);
                j.cubicTo(63.248734f, 91.56936f, 65.882355f, 88.948845f, 65.882355f, 85.71627f);
                j.cubicTo(65.882355f, 82.4837f, 63.248734f, 79.86318f, 60.0f, 79.86318f);
                j.cubicTo(56.751266f, 79.86318f, 54.117645f, 82.4837f, 54.117645f, 85.71627f);
                j.cubicTo(54.117645f, 88.948845f, 56.751266f, 91.56936f, 60.0f, 91.56936f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
