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

public final class ic extends c {
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
                e = c.a(e, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 12.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-8683387);
                Path j = c.j(looper);
                j.moveTo(53.089928f, 45.616577f);
                j.lineTo(53.623455f, 47.1627f);
                j.cubicTo(53.623455f, 47.1627f, 53.01152f, 44.28202f, 54.975307f, 42.67076f);
                j.cubicTo(54.863106f, 42.752514f, 54.75811f, 42.829773f, 54.656723f, 42.90524f);
                j.lineTo(73.0f, 26.94896f);
                j.lineTo(48.666668f, 26.94896f);
                j.cubicTo(48.666668f, 26.94896f, 45.512344f, 26.898201f, 45.06173f, 24.253796f);
                j.cubicTo(45.0784f, 24.353516f, 45.093723f, 24.444702f, 45.109043f, 24.537237f);
                j.lineTo(36.420692f, 0.0f);
                j.lineTo(27.904024f, 24.459076f);
                j.cubicTo(27.915741f, 24.39035f, 27.926556f, 24.326115f, 27.938272f, 24.253796f);
                j.cubicTo(27.916191f, 24.383163f, 27.882845f, 24.5013f, 27.848598f, 24.61854f);
                j.lineTo(27.758926f, 24.875479f);
                j.cubicTo(26.960882f, 26.899998f, 24.333334f, 26.94896f, 24.333334f, 26.94896f);
                j.lineTo(0.0f, 26.94896f);
                j.lineTo(18.472155f, 43.11681f);
                j.cubicTo(19.523445f, 44.34356f, 19.512178f, 45.986263f, 19.435574f, 46.74495f);
                j.lineTo(11.566444f, 71.87288f);
                j.lineTo(34.679054f, 56.182972f);
                j.lineTo(34.246914f, 56.59578f);
                j.cubicTo(34.246914f, 56.59578f, 36.448177f, 54.918938f, 38.753086f, 56.59578f);
                j.cubicTo(38.745876f, 56.588593f, 38.740017f, 56.583202f, 38.732807f, 56.57557f);
                j.lineTo(61.149216f, 72.0f);
                j.lineTo(53.089928f, 45.616577f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
