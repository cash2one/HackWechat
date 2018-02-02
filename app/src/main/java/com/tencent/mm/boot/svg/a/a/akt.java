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

public final class akt extends c {
    private final int height = 40;
    private final int width = 40;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 40;
            case 1:
                return 40;
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
                e = c.a(e, 1.0f, 0.0f, 3.0f, 0.0f, 1.0f, 2.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                a = c.a(a, looper);
                a.setColor(-4210753);
                a.setStrokeWidth(2.375f);
                a.setStrokeCap(Cap.ROUND);
                a.setStrokeJoin(Join.MITER);
                e = c.a(e, -1.0f, 0.0f, 32.0f, 0.0f, 1.0f, 0.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(26.966852f, 0.0f);
                j.lineTo(4.337496f, 0.0f);
                j.cubicTo(2.0019212f, 0.0f, 0.0f, 2.0290322f, 0.0f, 4.6548386f);
                j.lineTo(0.0f, 24.467741f);
                j.cubicTo(0.0f, 26.974194f, 1.8907033f, 29.122581f, 4.337496f, 29.122581f);
                j.lineTo(8.230121f, 29.122581f);
                j.lineTo(8.230121f, 36.403225f);
                j.lineTo(16.793894f, 29.122581f);
                j.lineTo(26.966852f, 29.122581f);
                j.cubicTo(29.302427f, 29.122581f, 31.304348f, 27.093548f, 31.304348f, 24.467741f);
                j.lineTo(31.304348f, 4.6548386f);
                j.cubicTo(31.19313f, 2.1483872f, 29.302427f, 0.0f, 26.966852f, 0.0f);
                j.close();
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.restore();
                canvas.save();
                a2 = c.a(i2, looper);
                a2.setColor(-4210753);
                j = c.j(looper);
                j.moveTo(14.599606f, 19.08865f);
                j.lineTo(17.538462f, 19.08865f);
                j.lineTo(17.538462f, 22.0f);
                j.lineTo(14.599606f, 22.0f);
                j.lineTo(14.599606f, 19.08865f);
                j.close();
                j.moveTo(12.962524f, 7.7656145f);
                j.cubicTo(13.738334f, 7.2552023f, 14.691645f, 7.0f, 15.822485f, 7.0f);
                j.cubicTo(17.308357f, 7.0f, 18.54273f, 7.362656f, 19.52564f, 8.087978f);
                j.cubicTo(20.508553f, 8.813301f, 21.0f, 9.887837f, 21.0f, 11.311619f);
                j.cubicTo(21.0f, 12.184692f, 20.786327f, 12.920077f, 20.358974f, 13.517797f);
                j.cubicTo(20.109137f, 13.880459f, 19.629194f, 14.343852f, 18.919132f, 14.907992f);
                j.lineTo(18.218935f, 15.462055f);
                j.cubicTo(17.837605f, 15.764273f, 17.584484f, 16.116856f, 17.459566f, 16.519812f);
                j.cubicTo(17.38067f, 16.775019f, 17.337936f, 17.171253f, 17.331362f, 17.708529f);
                j.lineTo(14.668639f, 17.708529f);
                j.cubicTo(14.708087f, 16.573534f, 14.81328f, 15.789458f, 14.9842205f, 15.356279f);
                j.cubicTo(15.155162f, 14.9231f, 15.595657f, 14.424449f, 16.30572f, 13.860309f);
                j.lineTo(17.02564f, 13.2860985f);
                j.cubicTo(17.26233f, 13.104768f, 17.452991f, 12.90665f, 17.597633f, 12.691739f);
                j.cubicTo(17.860619f, 12.322362f, 17.992111f, 11.916054f, 17.992111f, 11.4728f);
                j.cubicTo(17.992111f, 10.962388f, 17.845827f, 10.497315f, 17.553255f, 10.077569f);
                j.cubicTo(17.260683f, 9.657822f, 16.7265f, 9.447951f, 15.95069f, 9.447951f);
                j.cubicTo(15.18803f, 9.447951f, 14.647273f, 9.7065115f, 14.3284025f, 10.22364f);
                j.cubicTo(14.009532f, 10.740768f, 13.850099f, 11.278036f, 13.850099f, 11.83546f);
                j.lineTo(11.0f, 11.83546f);
                j.cubicTo(11.078896f, 9.921414f, 11.733065f, 8.564813f, 12.962524f, 7.7656145f);
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
