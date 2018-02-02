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

public final class mz extends c {
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
                Paint a = c.a(i2, looper);
                a.setColor(-9538696);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 8.0f, 0.0f, 1.0f, 17.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(77.0f, 50.5601f);
                j.cubicTo(77.0f, 51.3551f, 76.36f, 52.0001f, 75.555f, 52.0001f);
                j.lineTo(49.0f, 52.0001f);
                j.lineTo(32.0f, 52.0001f);
                j.lineTo(4.445f, 52.0001f);
                j.cubicTo(3.647f, 52.0001f, 3.0f, 51.3621f, 3.0f, 50.5601f);
                j.lineTo(3.0f, 43.0001f);
                j.lineTo(77.0f, 43.0001f);
                j.lineTo(77.0f, 50.5601f);
                j.close();
                j.moveTo(33.232f, 60.0001f);
                j.lineTo(35.0f, 55.5781f);
                j.lineTo(35.0f, 55.0001f);
                j.lineTo(46.0f, 55.0001f);
                j.lineTo(46.0f, 55.5781f);
                j.lineTo(47.769f, 60.0001f);
                j.lineTo(33.232f, 60.0001f);
                j.close();
                j.moveTo(3.0f, 4.4401f);
                j.cubicTo(3.0f, 3.6451f, 3.64f, 3.0001f, 4.445f, 3.0001f);
                j.lineTo(75.555f, 3.0001f);
                j.cubicTo(76.353f, 3.0001f, 77.0f, 3.6371f, 77.0f, 4.4401f);
                j.lineTo(77.0f, 40.0001f);
                j.lineTo(3.0f, 40.0001f);
                j.lineTo(3.0f, 4.4401f);
                j.close();
                j.moveTo(75.685f, 1.0E-4f);
                j.lineTo(4.315f, 1.0E-4f);
                j.cubicTo(1.938f, 1.0E-4f, 0.0f, 1.9321f, 0.0f, 4.3161f);
                j.lineTo(0.0f, 50.6841f);
                j.cubicTo(0.0f, 53.0751f, 1.932f, 55.0001f, 4.315f, 55.0001f);
                j.lineTo(32.0f, 55.0001f);
                j.lineTo(30.0f, 60.0001f);
                j.lineTo(26.0f, 62.0001f);
                j.lineTo(26.0f, 63.0001f);
                j.lineTo(55.0f, 63.0001f);
                j.lineTo(55.0f, 62.0001f);
                j.lineTo(51.0f, 60.0001f);
                j.lineTo(49.0f, 55.0001f);
                j.lineTo(75.685f, 55.0001f);
                j.cubicTo(78.062f, 55.0001f, 80.0f, 53.0681f, 80.0f, 50.6841f);
                j.lineTo(80.0f, 4.3161f);
                j.cubicTo(80.0f, 1.9251f, 78.068f, 1.0E-4f, 75.685f, 1.0E-4f);
                j.lineTo(75.685f, 1.0E-4f);
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
