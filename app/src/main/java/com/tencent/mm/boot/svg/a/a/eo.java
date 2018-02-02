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

public final class eo extends c {
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
                a.setColor(WebView.NIGHT_MODE_COLOR);
                e = c.a(e, 1.0f, 0.0f, 8.0f, 0.0f, 1.0f, 8.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                a = c.a(a, looper);
                e = c.a(e, 0.70710677f, 0.70710677f, -16.568542f, -0.70710677f, 0.70710677f, 40.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                Path j = c.j(looper);
                j.moveTo(37.0f, 37.0f);
                j.lineTo(37.0f, 12.995752f);
                j.cubicTo(37.0f, 12.450768f, 37.44359f, 12.0f, 37.99078f, 12.0f);
                j.lineTo(42.00922f, 12.0f);
                j.cubicTo(42.549026f, 12.0f, 43.0f, 12.445813f, 43.0f, 12.995752f);
                j.lineTo(43.0f, 37.0f);
                j.lineTo(67.00425f, 37.0f);
                j.cubicTo(67.54923f, 37.0f, 68.0f, 37.44359f, 68.0f, 37.99078f);
                j.lineTo(68.0f, 42.00922f);
                j.cubicTo(68.0f, 42.549026f, 67.554184f, 43.0f, 67.00425f, 43.0f);
                j.lineTo(43.0f, 43.0f);
                j.lineTo(43.0f, 67.00425f);
                j.cubicTo(43.0f, 67.54923f, 42.55641f, 68.0f, 42.00922f, 68.0f);
                j.lineTo(37.99078f, 68.0f);
                j.cubicTo(37.450974f, 68.0f, 37.0f, 67.554184f, 37.0f, 67.00425f);
                j.lineTo(37.0f, 43.0f);
                j.lineTo(12.995752f, 43.0f);
                j.cubicTo(12.450768f, 43.0f, 12.0f, 42.55641f, 12.0f, 42.00922f);
                j.lineTo(12.0f, 37.99078f);
                j.cubicTo(12.0f, 37.450974f, 12.445813f, 37.0f, 12.995752f, 37.0f);
                j.lineTo(37.0f, 37.0f);
                j.lineTo(37.0f, 37.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
