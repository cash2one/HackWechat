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

public final class lm extends c {
    private final int height = 60;
    private final int width = 60;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 60;
            case 1:
                return 60;
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
                Path j = c.j(looper);
                j.moveTo(0.0f, 0.0f);
                j.lineTo(60.0f, 0.0f);
                j.lineTo(60.0f, 60.0f);
                j.lineTo(0.0f, 60.0f);
                j.lineTo(0.0f, 0.0f);
                j.close();
                Paint a = c.a(i2, looper);
                a.setColor(-5592406);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 6.0f, 0.0f, 1.0f, 6.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j2 = c.j(looper);
                j2.moveTo(0.0f, 6.0f);
                j2.cubicTo(0.0f, 2.6891508f, 2.6835413f, 0.0f, 6.0f, 0.0f);
                j2.lineTo(42.0f, 0.0f);
                j2.cubicTo(45.31085f, 0.0f, 48.0f, 2.6835413f, 48.0f, 6.0f);
                j2.lineTo(48.0f, 42.0f);
                j2.cubicTo(48.0f, 45.31085f, 45.31646f, 48.0f, 42.0f, 48.0f);
                j2.lineTo(6.0f, 48.0f);
                j2.cubicTo(2.6891508f, 48.0f, 0.0f, 45.31646f, 0.0f, 42.0f);
                j2.lineTo(0.0f, 6.0f);
                j2.lineTo(0.0f, 6.0f);
                j2.close();
                j2.moveTo(3.0f, 5.0f);
                j2.cubicTo(3.0f, 3.9389288f, 3.936117f, 3.0f, 5.0f, 3.0f);
                j2.lineTo(43.0f, 3.0f);
                j2.cubicTo(44.06107f, 3.0f, 45.0f, 3.936117f, 45.0f, 5.0f);
                j2.lineTo(45.0f, 43.0f);
                j2.cubicTo(45.0f, 44.06107f, 44.063885f, 45.0f, 43.0f, 45.0f);
                j2.lineTo(5.0f, 45.0f);
                j2.cubicTo(3.9389288f, 45.0f, 3.0f, 44.063885f, 3.0f, 43.0f);
                j2.lineTo(3.0f, 5.0f);
                j2.lineTo(3.0f, 5.0f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, a2);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
