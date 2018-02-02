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

public final class wh extends c {
    private final int height = 93;
    private final int width = 93;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 93;
            case 1:
                return 93;
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
                e = c.a(e, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 11.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(5.2173915f, 0.0f);
                j.cubicTo(2.2700827f, 0.0f, -7.1054274E-15f, 2.4263568f, -7.1054274E-15f, 5.2173915f);
                j.lineTo(-7.1054274E-15f, 65.21739f);
                j.cubicTo(-7.1054274E-15f, 68.00842f, 2.2700827f, 70.434784f, 5.2173915f, 70.434784f);
                j.lineTo(86.08696f, 70.434784f);
                j.cubicTo(89.03313f, 70.434784f, 91.304344f, 68.00842f, 91.304344f, 65.21739f);
                j.lineTo(91.304344f, 5.2173915f);
                j.cubicTo(91.304344f, 2.4263568f, 89.03313f, 0.0f, 86.08696f, 0.0f);
                j.lineTo(5.2173915f, 0.0f);
                j.close();
                j.moveTo(67.82609f, 6.521739f);
                j.lineTo(80.933716f, 6.521739f);
                j.cubicTo(82.835846f, 6.521739f, 84.78261f, 8.498771f, 84.78261f, 11.73913f);
                j.lineTo(84.78261f, 24.782608f);
                j.lineTo(91.304344f, 24.782608f);
                j.lineTo(91.304344f, 44.347828f);
                j.lineTo(84.78261f, 44.347828f);
                j.lineTo(84.78261f, 58.695652f);
                j.cubicTo(84.78261f, 61.936012f, 82.835846f, 63.913044f, 80.933716f, 63.913044f);
                j.lineTo(67.82609f, 63.913044f);
                j.lineTo(67.82609f, 70.434784f);
                j.lineTo(24.782608f, 70.434784f);
                j.lineTo(24.782608f, 63.913044f);
                j.lineTo(10.370634f, 63.913044f);
                j.cubicTo(8.467525f, 63.913044f, 6.521739f, 61.936012f, 6.521739f, 58.695652f);
                j.lineTo(6.521739f, 44.347828f);
                j.lineTo(7.1054274E-15f, 44.347828f);
                j.lineTo(8.303451E-15f, 24.782608f);
                j.lineTo(6.521739f, 24.782608f);
                j.lineTo(6.521739f, 11.73913f);
                j.cubicTo(6.521739f, 8.498771f, 8.467525f, 6.521739f, 10.370634f, 6.521739f);
                j.lineTo(24.782608f, 6.521739f);
                j.lineTo(24.782608f, 0.0f);
                j.lineTo(67.82609f, 0.0f);
                j.lineTo(67.82609f, 6.521739f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                Paint a3 = c.a(a, looper);
                Path j2 = c.j(looper);
                j2.moveTo(29.608696f, 34.347828f);
                j2.lineTo(27.0f, 39.565216f);
                j2.lineTo(38.739132f, 53.913044f);
                j2.lineTo(64.82609f, 22.608696f);
                j2.lineTo(62.217392f, 20.0f);
                j2.lineTo(38.739132f, 42.173912f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 1);
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, a3);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
