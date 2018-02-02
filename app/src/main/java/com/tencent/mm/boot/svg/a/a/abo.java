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

public final class abo extends c {
    private final int height = 60;
    private final int width = 69;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 69;
            case 1:
                return 60;
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
                a.setColor(WebView.NIGHT_MODE_COLOR);
                e = c.a(e, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.saveLayerAlpha(null, 25, 4);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(7.0f, 12.0f);
                j.cubicTo(20.493433f, -2.788531f, 47.23359f, -2.778528f, 61.0f, 12.0f);
                j.cubicTo(52.72773f, 16.237268f, 44.191296f, 19.518269f, 36.0f, 23.0f);
                j.cubicTo(32.692627f, 24.629827f, 29.620312f, 26.500397f, 26.0f, 27.0f);
                j.cubicTo(22.454912f, 25.550108f, 19.53271f, 22.599209f, 16.0f, 21.0f);
                j.cubicTo(16.880709f, 25.780178f, 19.072361f, 30.011467f, 21.0f, 34.0f);
                j.cubicTo(21.914503f, 35.3631f, 22.444904f, 36.96359f, 24.0f, 37.0f);
                j.cubicTo(26.958305f, 36.253372f, 29.59029f, 34.442818f, 32.0f, 33.0f);
                j.cubicTo(40.868793f, 28.060873f, 49.445255f, 23.299421f, 58.0f, 18.0f);
                j.cubicTo(59.733013f, 17.267584f, 61.69449f, 16.477343f, 64.0f, 16.0f);
                j.cubicTo(67.03852f, 21.758953f, 68.209404f, 29.341263f, 66.0f, 36.0f);
                j.cubicTo(61.50435f, 46.006344f, 51.30666f, 52.538334f, 41.0f, 54.0f);
                j.cubicTo(35.554787f, 55.26917f, 30.130697f, 54.698994f, 25.0f, 54.0f);
                j.cubicTo(19.993055f, 52.598354f, 16.260242f, 56.709606f, 12.0f, 58.0f);
                j.cubicTo(12.337285f, 55.159134f, 12.547443f, 52.298264f, 13.0f, 49.0f);
                j.cubicTo(9.835399f, 45.706253f, 5.582193f, 42.685333f, 3.0f, 38.0f);
                j.cubicTo(-0.9327183f, 29.841415f, 0.7785717f, 19.25819f, 7.0f, 12.0f);
                j.lineTo(7.0f, 12.0f);
                j.lineTo(7.0f, 12.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
