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

public final class ln extends c {
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
                Path j = c.j(looper);
                j.moveTo(0.0f, 0.0f);
                j.lineTo(60.0f, 0.0f);
                j.lineTo(60.0f, 60.0f);
                j.lineTo(0.0f, 60.0f);
                j.lineTo(0.0f, 0.0f);
                j.close();
                i2 = c.a(i2, looper);
                i2.setColor(-1);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j2 = c.j(looper);
                j2.moveTo(6.0f, 12.0f);
                j2.cubicTo(6.0f, 8.689151f, 8.683541f, 6.0f, 12.0f, 6.0f);
                j2.lineTo(48.0f, 6.0f);
                j2.cubicTo(51.31085f, 6.0f, 54.0f, 8.683541f, 54.0f, 12.0f);
                j2.lineTo(54.0f, 48.0f);
                j2.cubicTo(54.0f, 51.31085f, 51.31646f, 54.0f, 48.0f, 54.0f);
                j2.lineTo(12.0f, 54.0f);
                j2.cubicTo(8.689151f, 54.0f, 6.0f, 51.31646f, 6.0f, 48.0f);
                j2.lineTo(6.0f, 12.0f);
                j2.lineTo(6.0f, 12.0f);
                j2.close();
                j2.moveTo(9.0f, 11.0f);
                j2.cubicTo(9.0f, 9.938929f, 9.936117f, 9.0f, 11.0f, 9.0f);
                j2.lineTo(49.0f, 9.0f);
                j2.cubicTo(50.06107f, 9.0f, 51.0f, 9.936117f, 51.0f, 11.0f);
                j2.lineTo(51.0f, 49.0f);
                j2.cubicTo(51.0f, 50.06107f, 50.063885f, 51.0f, 49.0f, 51.0f);
                j2.lineTo(11.0f, 51.0f);
                j2.cubicTo(9.938929f, 51.0f, 9.0f, 50.063885f, 9.0f, 49.0f);
                j2.lineTo(9.0f, 11.0f);
                j2.lineTo(9.0f, 11.0f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, a);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
