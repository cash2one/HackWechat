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

public final class cs extends c {
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
                e = c.a(e, 1.0f, 0.0f, -921.0f, 0.0f, 1.0f, -39.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 921.0f, 0.0f, 1.0f, 39.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(855638016);
                Path j = c.j(looper);
                j.moveTo(0.0f, 60.0f);
                j.cubicTo(0.0f, 26.862915f, 26.862915f, 0.0f, 60.0f, 0.0f);
                j.lineTo(60.0f, 0.0f);
                j.cubicTo(93.137085f, 0.0f, 120.0f, 26.862915f, 120.0f, 60.0f);
                j.lineTo(120.0f, 60.0f);
                j.cubicTo(120.0f, 93.137085f, 93.137085f, 120.0f, 60.0f, 120.0f);
                j.lineTo(60.0f, 120.0f);
                j.cubicTo(26.862915f, 120.0f, 0.0f, 93.137085f, 0.0f, 60.0f);
                j.lineTo(0.0f, 60.0f);
                j.close();
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                a = c.a(i2, looper);
                a.setColor(-1);
                j = c.j(looper);
                j.moveTo(40.5f, 60.75f);
                j.cubicTo(40.5f, 64.47735f, 37.47735f, 67.5f, 33.75f, 67.5f);
                j.cubicTo(30.02265f, 67.5f, 27.0f, 64.47735f, 27.0f, 60.75f);
                j.cubicTo(27.0f, 57.0213f, 30.02265f, 54.0f, 33.75f, 54.0f);
                j.cubicTo(37.47735f, 54.0f, 40.5f, 57.0213f, 40.5f, 60.75f);
                j.close();
                j.moveTo(59.25f, 49.5f);
                j.cubicTo(65.46225f, 49.5f, 70.5f, 54.5355f, 70.5f, 60.75f);
                j.cubicTo(70.5f, 66.96225f, 65.46225f, 72.0f, 59.25f, 72.0f);
                j.cubicTo(53.03775f, 72.0f, 48.0f, 66.96225f, 48.0f, 60.75f);
                j.cubicTo(48.0f, 54.5355f, 53.03775f, 49.5f, 59.25f, 49.5f);
                j.close();
                j.moveTo(93.0f, 60.75f);
                j.cubicTo(93.0f, 64.47735f, 89.97735f, 67.5f, 86.25f, 67.5f);
                j.cubicTo(82.52265f, 67.5f, 79.5f, 64.47735f, 79.5f, 60.75f);
                j.cubicTo(79.5f, 57.0213f, 82.52265f, 54.0f, 86.25f, 54.0f);
                j.cubicTo(89.97735f, 54.0f, 93.0f, 57.0213f, 93.0f, 60.75f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
