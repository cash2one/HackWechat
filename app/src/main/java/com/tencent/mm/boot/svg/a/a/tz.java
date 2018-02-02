package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class tz extends c {
    private final int height = 61;
    private final int width = 61;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 61;
            case 1:
                return 61;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                c.f(looper);
                c.e(looper);
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
                a.setColor(-10970130);
                Path j = c.j(looper);
                j.moveTo(24.357143f, 31.267857f);
                j.cubicTo(26.82522f, 35.67271f, 22.368435f, 37.603485f, 20.517857f, 38.94643f);
                j.cubicTo(12.49915f, 43.23181f, 9.0f, 44.938072f, 9.0f, 46.625f);
                j.lineTo(9.0f, 50.464287f);
                j.cubicTo(9.0f, 51.156628f, 9.728162f, 52.0f, 10.535714f, 52.0f);
                j.lineTo(50.464287f, 52.0f);
                j.cubicTo(51.27184f, 52.0f, 52.0f, 51.156628f, 52.0f, 50.464287f);
                j.lineTo(52.0f, 46.625f);
                j.cubicTo(52.0f, 44.938072f, 48.50085f, 43.23181f, 40.482143f, 38.94643f);
                j.cubicTo(38.631565f, 37.603485f, 34.17478f, 35.67271f, 36.642857f, 31.267857f);
                j.cubicTo(39.24307f, 27.868282f, 41.103214f, 26.426222f, 41.25f, 20.517857f);
                j.cubicTo(41.103214f, 14.887795f, 36.947693f, 9.0f, 30.5f, 9.0f);
                j.cubicTo(24.052307f, 9.0f, 19.896786f, 14.887795f, 19.75f, 20.517857f);
                j.cubicTo(19.896786f, 26.426222f, 21.756931f, 27.868282f, 24.357143f, 31.267857f);
                j.close();
                j.moveTo(30.714453f, 42.92168f);
                j.cubicTo(26.309618f, 42.92168f, 23.007446f, 38.011597f, 23.007446f, 38.011597f);
                j.cubicTo(23.007446f, 38.011597f, 24.622948f, 50.719337f, 30.714453f, 50.719337f);
                j.cubicTo(36.805958f, 50.719337f, 38.079346f, 38.011597f, 38.079346f, 38.011597f);
                j.cubicTo(38.079346f, 38.011597f, 35.11929f, 42.92168f, 30.714453f, 42.92168f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
