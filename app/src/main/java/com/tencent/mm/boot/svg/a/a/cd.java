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

public final class cd extends c {
    private final int height = 96;
    private final int width = 132;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 132;
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
                e = c.a(e, 1.0f, 0.0f, -368.0f, 0.0f, 1.0f, -950.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 239.0f, 0.0f, 1.0f, 950.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 170.0f, 0.0f, 1.0f, 22.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(26.0f, 52.0f);
                j.cubicTo(11.640596f, 52.0f, 0.0f, 40.3594f, 0.0f, 26.0f);
                j.cubicTo(0.0f, 11.640596f, 11.640596f, 0.0f, 26.0f, 0.0f);
                j.cubicTo(40.3594f, 0.0f, 52.0f, 11.640596f, 52.0f, 26.0f);
                j.cubicTo(52.0f, 40.3594f, 40.3594f, 52.0f, 26.0f, 52.0f);
                j.close();
                j.moveTo(26.0f, 45.882355f);
                j.cubicTo(36.98072f, 45.882355f, 45.882355f, 36.98072f, 45.882355f, 26.0f);
                j.cubicTo(45.882355f, 15.0192795f, 36.98072f, 6.117647f, 26.0f, 6.117647f);
                j.cubicTo(15.0192795f, 6.117647f, 6.117647f, 15.0192795f, 6.117647f, 26.0f);
                j.cubicTo(6.117647f, 36.98072f, 15.0192795f, 45.882355f, 26.0f, 45.882355f);
                j.close();
                j.moveTo(35.0f, 26.0f);
                j.cubicTo(35.0f, 30.9698f, 30.9698f, 35.0f, 26.0f, 35.0f);
                j.cubicTo(21.0302f, 35.0f, 17.0f, 30.9698f, 17.0f, 26.0f);
                j.cubicTo(17.0f, 21.0284f, 21.0302f, 17.0f, 26.0f, 17.0f);
                j.cubicTo(30.9698f, 17.0f, 35.0f, 21.0284f, 35.0f, 26.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
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
