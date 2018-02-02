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

public final class acu extends c {
    private final int height = 96;
    private final int width = 96;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                a.setColor(-1);
                e = c.a(e, 1.0f, 0.0f, 19.0f, 0.0f, 1.0f, 19.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(1.0f, 5.0f);
                j.cubicTo(1.0122918f, 2.442013f, 3.5599186f, 0.722164f, 6.0f, 1.0f);
                j.cubicTo(21.28341f, 1.0402863f, 36.67907f, 1.0402863f, 52.0f, 1.0f);
                j.cubicTo(54.412548f, 0.71222264f, 57.000137f, 2.4221303f, 57.0f, 5.0f);
                j.cubicTo(57.0401f, 17.572708f, 56.960175f, 30.247896f, 57.0f, 43.0f);
                j.cubicTo(57.219933f, 44.970997f, 55.88118f, 47.197853f, 54.0f, 47.0f);
                j.cubicTo(49.0975f, 47.893745f, 44.451828f, 47.416565f, 40.0f, 48.0f);
                j.cubicTo(34.511086f, 48.032925f, 32.652817f, 53.99772f, 29.0f, 57.0f);
                j.cubicTo(25.999016f, 54.36555f, 24.18071f, 50.53814f, 21.0f, 48.0f);
                j.cubicTo(15.458835f, 46.830025f, 9.77413f, 48.15222f, 4.0f, 47.0f);
                j.cubicTo(2.1012774f, 47.17797f, 0.7725152f, 44.92129f, 1.0f, 43.0f);
                j.cubicTo(1.0522546f, 30.19819f, 0.972329f, 17.552826f, 1.0f, 5.0f);
                j.lineTo(1.0f, 5.0f);
                j.close();
                j.moveTo(26.0f, 12.0f);
                j.cubicTo(22.03111f, 13.35653f, 21.961203f, 19.373447f, 24.0f, 23.0f);
                j.cubicTo(24.73757f, 24.342642f, 26.495272f, 25.859344f, 25.0f, 28.0f);
                j.cubicTo(22.580393f, 30.150015f, 18.60559f, 31.097954f, 16.0f, 34.0f);
                j.cubicTo(14.550895f, 34.730057f, 15.170085f, 36.446323f, 15.0f, 38.0f);
                j.cubicTo(23.029804f, 38.202507f, 30.99938f, 37.843285f, 39.0f, 38.0f);
                j.cubicTo(40.466995f, 37.92311f, 43.403156f, 38.47192f, 43.0f, 36.0f);
                j.cubicTo(42.21471f, 30.419428f, 33.44618f, 31.197737f, 32.0f, 26.0f);
                j.cubicTo(33.426205f, 23.18516f, 35.69324f, 20.381256f, 35.0f, 17.0f);
                j.cubicTo(35.223854f, 12.548287f, 30.070595f, 9.734406f, 26.0f, 12.0f);
                j.lineTo(26.0f, 12.0f);
                j.close();
                j.moveTo(11.0f, 17.0f);
                j.cubicTo(10.0190115f, 19.932035f, 12.682579f, 22.227203f, 13.0f, 25.0f);
                j.cubicTo(10.49501f, 27.839842f, 4.4791965f, 28.160564f, 5.0f, 33.0f);
                j.cubicTo(7.902336f, 33.001465f, 10.768456f, 33.041553f, 14.0f, 33.0f);
                j.cubicTo(16.217123f, 30.966883f, 19.113625f, 29.463497f, 22.0f, 28.0f);
                j.cubicTo(20.389706f, 27.038036f, 18.799667f, 26.045801f, 17.0f, 25.0f);
                j.cubicTo(18.627499f, 21.956594f, 20.754301f, 18.58901f, 19.0f, 15.0f);
                j.cubicTo(17.402056f, 11.543145f, 10.83935f, 12.665673f, 11.0f, 17.0f);
                j.lineTo(11.0f, 17.0f);
                j.close();
                j.moveTo(39.0f, 15.0f);
                j.cubicTo(37.25394f, 18.590094f, 39.36744f, 21.956934f, 41.0f, 25.0f);
                j.cubicTo(39.19553f, 26.045242f, 37.61799f, 27.027239f, 36.0f, 28.0f);
                j.cubicTo(38.892155f, 29.462187f, 41.784313f, 30.96524f, 44.0f, 33.0f);
                j.cubicTo(47.234913f, 33.039455f, 50.106846f, 33.009396f, 53.0f, 33.0f);
                j.cubicTo(53.484398f, 28.159538f, 47.497837f, 27.838886f, 45.0f, 25.0f);
                j.cubicTo(45.32366f, 22.227484f, 47.97312f, 19.922802f, 47.0f, 17.0f);
                j.cubicTo(47.113564f, 12.69812f, 40.580933f, 11.525738f, 39.0f, 15.0f);
                j.lineTo(39.0f, 15.0f);
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
