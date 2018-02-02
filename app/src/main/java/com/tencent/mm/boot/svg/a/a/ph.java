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

public final class ph extends c {
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
                Paint a = c.a(i2, looper);
                a.setColor(-16139513);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(27.52f, 0.0f);
                j.lineTo(32.07f, 0.0f);
                j.cubicTo(46.45f, 0.9f, 58.83f, 13.19f, 60.0f, 27.52f);
                j.lineTo(60.0f, 32.08f);
                j.cubicTo(59.09f, 46.46f, 46.8f, 58.83f, 32.48f, 60.0f);
                j.lineTo(27.93f, 60.0f);
                j.cubicTo(13.55f, 59.1f, 1.17f, 46.81f, 0.0f, 32.48f);
                j.lineTo(0.0f, 27.93f);
                j.cubicTo(0.9f, 13.55f, 13.2f, 1.17f, 27.52f, 0.0f);
                j.lineTo(27.52f, 0.0f);
                j.close();
                j.moveTo(24.383501f, 3.6703784f);
                j.cubicTo(11.597891f, 6.255954f, 1.8089068f, 19.054052f, 3.117434f, 32.111706f);
                j.cubicTo(3.9265237f, 46.387276f, 17.730988f, 58.336826f, 32.024902f, 56.879322f);
                j.cubicTo(46.738342f, 56.09067f, 58.884674f, 41.515614f, 56.75707f, 26.890642f);
                j.cubicTo(55.318687f, 11.726592f, 39.286728f, 0.026614152f, 24.383501f, 3.6703784f);
                j.lineTo(24.383501f, 3.6703784f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                i3 = c.a(a, looper);
                Path j2 = c.j(looper);
                j2.moveTo(25.0f, 15.0f);
                j2.lineTo(36.0f, 15.0f);
                j2.lineTo(36.0f, 31.0f);
                j2.lineTo(25.0f, 31.0f);
                j2.lineTo(25.0f, 15.0f);
                j2.close();
                canvas.drawPath(j2, i3);
                canvas.restore();
                canvas.save();
                i3 = c.a(i2, looper);
                i3.setColor(-16139513);
                j2 = c.j(looper);
                j2.moveTo(14.176433f, 30.047743f);
                j2.lineTo(30.5319f, 46.112846f);
                j2.lineTo(46.914062f, 30.035374f);
                j2.lineTo(14.176433f, 30.047743f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, i3);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
