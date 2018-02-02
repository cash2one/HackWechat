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

public final class akj extends c {
    private final int height = 42;
    private final int width = 42;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 42;
            case 1:
                return 42;
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
                Paint a = c.a(i3, looper);
                a.setStrokeWidth(1.0f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(i2, looper);
                Paint a3 = c.a(a, looper);
                a2.setColor(-4737097);
                a3.setColor(-4737097);
                a3.setStrokeWidth(0.5f);
                Path j = c.j(looper);
                j.moveTo(19.597933f, 30.307812f);
                j.cubicTo(16.679598f, 30.307812f, 13.962932f, 28.918991f, 12.334599f, 26.680159f);
                j.lineTo(26.861265f, 26.680159f);
                j.cubicTo(25.232931f, 28.918991f, 22.5171f, 30.307812f, 19.597933f, 30.307812f);
                j.moveTo(28.349598f, 25.0f);
                j.lineTo(10.845432f, 25.0f);
                j.cubicTo(10.553765f, 25.0f, 10.282932f, 25.149807f, 10.128765f, 25.393969f);
                j.cubicTo(9.973765f, 25.640612f, 9.9579315f, 25.948503f, 10.085432f, 26.20839f);
                j.cubicTo(11.809599f, 29.719343f, 15.543765f, 31.98797f, 19.597933f, 31.98797f);
                j.cubicTo(23.652931f, 31.98797f, 27.386265f, 29.719343f, 29.109598f, 26.20839f);
                j.cubicTo(29.237932f, 25.947676f, 29.221266f, 25.640612f, 29.066265f, 25.393969f);
                j.cubicTo(28.912098f, 25.149807f, 28.641266f, 25.0f, 28.349598f, 25.0f);
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.drawPath(j, a3);
                canvas.restore();
                Paint a4 = c.a(i2, looper);
                i3 = c.a(a, looper);
                a4.setColor(-4210753);
                i3.setColor(-4210753);
                canvas.save();
                a2 = c.a(a4, looper);
                a = c.a(i3, looper);
                j = c.j(looper);
                j.moveTo(19.975f, 38.047897f);
                j.cubicTo(9.894167f, 38.047897f, 1.6916667f, 29.901197f, 1.6916667f, 19.887285f);
                j.cubicTo(1.6916667f, 9.87503f, 9.894167f, 1.7291565f, 19.975f, 1.7291565f);
                j.cubicTo(30.056667f, 1.7291565f, 38.258335f, 9.87503f, 38.258335f, 19.887285f);
                j.cubicTo(38.258335f, 29.901197f, 30.056667f, 38.047897f, 19.975f, 38.047897f);
                j.moveTo(19.975f, 0.048997734f);
                j.cubicTo(8.96f, 0.048997734f, 0.0f, 8.948046f, 0.0f, 19.887285f);
                j.cubicTo(0.0f, 30.827354f, 8.96f, 39.728058f, 19.975f, 39.728058f);
                j.cubicTo(30.99f, 39.728058f, 39.95f, 30.827354f, 39.95f, 19.887285f);
                j.cubicTo(39.95f, 8.948046f, 30.99f, 0.048997734f, 19.975f, 0.048997734f);
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                a2 = c.a(i2, looper);
                a2.setColor(-4737097);
                j = c.j(looper);
                j.moveTo(12.383333f, 14.045125f);
                j.cubicTo(12.845833f, 13.585771f, 13.46f, 13.333333f, 14.113334f, 13.333333f);
                j.cubicTo(14.766666f, 13.333333f, 15.381667f, 13.585771f, 15.843333f, 14.045125f);
                j.cubicTo(16.7975f, 14.992801f, 16.7975f, 16.534739f, 15.843333f, 17.482414f);
                j.cubicTo(14.92f, 18.399467f, 13.308333f, 18.399467f, 12.383333f, 17.482414f);
                j.cubicTo(11.920834f, 17.022234f, 11.666667f, 16.412245f, 11.666667f, 15.763356f);
                j.cubicTo(11.666667f, 15.114467f, 11.920834f, 14.504478f, 12.383333f, 14.045125f);
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(i2, looper);
                a2.setColor(-4737097);
                j = c.j(looper);
                j.moveTo(27.565332f, 17.653965f);
                j.cubicTo(26.642f, 18.571016f, 25.030333f, 18.571016f, 24.105333f, 17.653965f);
                j.cubicTo(23.642834f, 17.193783f, 23.388666f, 16.584623f, 23.388666f, 15.934906f);
                j.cubicTo(23.388666f, 15.286017f, 23.642834f, 14.676028f, 24.105333f, 14.216675f);
                j.cubicTo(24.568666f, 13.757321f, 25.182833f, 13.504884f, 25.836166f, 13.504884f);
                j.cubicTo(26.488667f, 13.504884f, 27.103666f, 13.757321f, 27.565332f, 14.216675f);
                j.cubicTo(28.5195f, 15.1643505f, 28.5195f, 16.70629f, 27.565332f, 17.653965f);
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
