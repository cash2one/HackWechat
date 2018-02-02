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

public final class abl extends c {
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
                i3 = c.a(i2, looper);
                i3.setColor(-1);
                canvas.save();
                Paint a = c.a(i3, looper);
                Path j = c.j(looper);
                j.moveTo(0.0f, 4.0f);
                j.cubicTo(0.0f, 1.7908609f, 1.7908609f, 0.0f, 4.0f, 0.0f);
                j.lineTo(86.0f, 0.0f);
                j.cubicTo(88.20914f, 0.0f, 90.0f, 1.7908609f, 90.0f, 4.0f);
                j.lineTo(90.0f, 86.0f);
                j.cubicTo(90.0f, 88.20914f, 88.20914f, 90.0f, 86.0f, 90.0f);
                j.lineTo(4.0f, 90.0f);
                j.cubicTo(1.7908609f, 90.0f, 0.0f, 88.20914f, 0.0f, 86.0f);
                j.lineTo(0.0f, 4.0f);
                j.close();
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                float[] a2 = c.a(e, 1.0f, 0.0f, 25.0f, 0.0f, 1.0f, 23.0f);
                f.reset();
                f.setValues(a2);
                canvas.concat(f);
                canvas.save();
                Paint a3 = c.a(i2, looper);
                a3.setColor(-16731650);
                j = c.j(looper);
                j.moveTo(1.330489f, 10.218908f);
                j.lineTo(18.69964f, 20.085167f);
                j.cubicTo(19.419216f, 20.49391f, 20.589544f, 20.491829f, 21.305456f, 20.085167f);
                j.lineTo(38.674606f, 10.218908f);
                j.cubicTo(39.394184f, 9.810165f, 39.379704f, 9.183529f, 38.635887f, 8.816125f);
                j.lineTo(21.34418f, 0.27502382f);
                j.cubicTo(20.603216f, -0.09096857f, 19.404737f, -0.09237996f, 18.660917f, 0.27502382f);
                j.lineTo(1.3692116f, 8.816125f);
                j.cubicTo(0.6282494f, 9.182117f, 0.6145759f, 9.812246f, 1.330489f, 10.218908f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a3);
                canvas.restore();
                canvas.save();
                a3 = c.a(i2, looper);
                a3.setColor(-371630);
                j = c.j(looper);
                j.moveTo(22.305946f, 22.062408f);
                j.cubicTo(21.584692f, 22.468164f, 21.0f, 23.469671f, 21.0f, 24.294716f);
                j.lineTo(21.0f, 42.597317f);
                j.cubicTo(21.0f, 43.42443f, 21.579006f, 43.74706f, 22.28357f, 43.32374f);
                j.lineTo(38.71643f, 33.450405f);
                j.cubicTo(39.425327f, 33.024483f, 40.0f, 32.006466f, 40.0f, 31.183224f);
                j.lineTo(40.0f, 13.604286f);
                j.cubicTo(40.0f, 12.77808f, 39.410534f, 12.439923f, 38.694054f, 12.842992f);
                j.lineTo(22.305946f, 22.062408f);
                j.lineTo(22.305946f, 22.062408f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a3);
                canvas.restore();
                canvas.save();
                a3 = c.a(i2, looper);
                a3.setColor(-14313);
                j = c.j(looper);
                j.moveTo(17.694054f, 22.062408f);
                j.cubicTo(18.415308f, 22.468164f, 19.0f, 23.469671f, 19.0f, 24.294716f);
                j.lineTo(19.0f, 42.597317f);
                j.cubicTo(19.0f, 43.42443f, 18.420994f, 43.74706f, 17.71643f, 43.32374f);
                j.lineTo(1.2835687f, 33.450405f);
                j.cubicTo(0.5746733f, 33.024483f, 0.0f, 32.006466f, 0.0f, 31.183224f);
                j.lineTo(0.0f, 13.604286f);
                j.cubicTo(0.0f, 12.77808f, 0.5894669f, 12.439923f, 1.305947f, 12.842992f);
                j.lineTo(17.694054f, 22.062408f);
                j.lineTo(17.694054f, 22.062408f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a3);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
