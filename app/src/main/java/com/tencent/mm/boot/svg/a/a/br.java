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

public final class br extends c {
    private final int height = 90;
    private final int width = 90;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 90;
            case 1:
                return 90;
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
                i3 = c.a(i2, looper);
                i3.setColor(-855310);
                Path j = c.j(looper);
                j.moveTo(0.0f, 0.0f);
                j.lineTo(90.0f, 0.0f);
                j.lineTo(90.0f, 90.0f);
                j.lineTo(0.0f, 90.0f);
                j.lineTo(0.0f, 0.0f);
                j.close();
                canvas.drawPath(j, i3);
                canvas.restore();
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(WebView.NIGHT_MODE_COLOR);
                e = c.a(e, 0.70710677f, -0.70710677f, 55.691124f, 0.70710677f, 0.70710677f, 21.750002f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.saveLayerAlpha(null, 153, 4);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j2 = c.j(looper);
                j2.moveTo(0.0f, 33.0f);
                j2.lineTo(3.75f, 33.0f);
                j2.lineTo(3.75f, 39.0f);
                j2.cubicTo(3.75f, 41.899494f, 6.100505f, 44.25f, 9.0f, 44.25f);
                j2.cubicTo(11.899495f, 44.25f, 14.25f, 41.899494f, 14.25f, 39.0f);
                j2.lineTo(14.25f, 27.0f);
                j2.cubicTo(14.25f, 24.100506f, 11.899495f, 21.75f, 9.0f, 21.75f);
                j2.lineTo(9.0f, 18.0f);
                j2.cubicTo(13.970563f, 18.0f, 18.0f, 22.029438f, 18.0f, 27.0f);
                j2.lineTo(18.0f, 39.0f);
                j2.cubicTo(18.0f, 43.970562f, 13.970563f, 48.0f, 9.0f, 48.0f);
                j2.cubicTo(4.029437f, 48.0f, 0.0f, 43.970562f, 0.0f, 39.0f);
                j2.lineTo(0.0f, 33.0f);
                j2.close();
                j2.moveTo(0.0f, 33.0f);
                j2.lineTo(3.75f, 33.0f);
                j2.lineTo(3.75f, 39.0f);
                j2.cubicTo(3.75f, 41.899494f, 6.100505f, 44.25f, 9.0f, 44.25f);
                j2.cubicTo(11.899495f, 44.25f, 14.25f, 41.899494f, 14.25f, 39.0f);
                j2.lineTo(14.25f, 27.0f);
                j2.cubicTo(14.25f, 24.100506f, 11.899495f, 21.75f, 9.0f, 21.75f);
                j2.lineTo(9.0f, 18.0f);
                j2.cubicTo(13.970563f, 18.0f, 18.0f, 22.029438f, 18.0f, 27.0f);
                j2.lineTo(18.0f, 39.0f);
                j2.cubicTo(18.0f, 43.970562f, 13.970563f, 48.0f, 9.0f, 48.0f);
                j2.cubicTo(4.029437f, 48.0f, 0.0f, 43.970562f, 0.0f, 39.0f);
                j2.lineTo(0.0f, 33.0f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 1);
                canvas.drawPath(j2, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j2 = c.j(looper);
                j2.moveTo(18.0f, 15.0f);
                j2.lineTo(14.25f, 15.0f);
                j2.lineTo(14.25f, 9.0f);
                j2.cubicTo(14.25f, 6.100505f, 11.899495f, 3.75f, 9.0f, 3.75f);
                j2.cubicTo(6.100505f, 3.75f, 3.75f, 6.100505f, 3.75f, 9.0f);
                j2.lineTo(3.75f, 21.0f);
                j2.cubicTo(3.75f, 23.899494f, 6.100505f, 26.25f, 9.0f, 26.25f);
                j2.lineTo(9.0f, 30.0f);
                j2.cubicTo(4.029437f, 30.0f, 0.0f, 25.970562f, 0.0f, 21.0f);
                j2.lineTo(0.0f, 9.0f);
                j2.cubicTo(0.0f, 4.029437f, 4.029437f, 9.130776E-16f, 9.0f, 0.0f);
                j2.cubicTo(13.970563f, -9.130776E-16f, 18.0f, 4.029437f, 18.0f, 9.0f);
                j2.lineTo(18.0f, 15.0f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 1);
                canvas.drawPath(j2, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
