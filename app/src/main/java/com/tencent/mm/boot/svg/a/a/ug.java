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

public final class ug extends c {
    private final int height = 48;
    private final int width = 48;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 48;
            case 1:
                return 48;
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
                Paint a = c.a(i2, looper);
                a.setColor(-65794);
                e = c.a(e, 1.0f, 0.0f, 3.0f, 0.0f, 1.0f, 9.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(38.485332f, 0.0f);
                j.cubicTo(39.240726f, 0.101668164f, 39.99612f, 0.20333633f, 40.751514f, 0.30500448f);
                j.cubicTo(40.83103f, 1.0878494f, 40.920486f, 1.8706942f, 41.0f, 2.653539f);
                j.cubicTo(39.270546f, 3.4770513f, 38.048f, 4.98174f, 36.736f, 6.3339267f);
                j.cubicTo(29.221819f, 14.182709f, 21.498909f, 21.817987f, 14.094061f, 29.768438f);
                j.cubicTo(11.698667f, 30.886787f, 10.595394f, 27.65374f, 9.02497f, 26.47439f);
                j.cubicTo(5.953697f, 23.678514f, 3.4986668f, 20.130297f, 0.0f, 17.88343f);
                j.cubicTo(0.09939394f, 17.141253f, 0.20872727f, 16.40924f, 0.3180606f, 15.677231f);
                j.cubicTo(1.0635152f, 15.58573f, 1.7990303f, 15.494228f, 2.5345454f, 15.402727f);
                j.cubicTo(4.6317577f, 18.666275f, 8.011151f, 20.76064f, 10.158061f, 23.973352f);
                j.cubicTo(11.002909f, 26.037216f, 14.004606f, 26.545557f, 15.266909f, 24.634195f);
                j.cubicTo(20.554667f, 18.564606f, 26.438787f, 13.074526f, 31.965092f, 7.2387733f);
                j.cubicTo(34.131878f, 4.819071f, 36.875153f, 2.8873758f, 38.485332f, 0.0f);
                j.lineTo(38.485332f, 0.0f);
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
