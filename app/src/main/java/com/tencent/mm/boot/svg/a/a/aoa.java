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

public final class aoa extends c {
    private final int height = 60;
    private final int width = 108;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 108;
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
                a.setColor(-3355444);
                e = c.a(e, 1.0f, 0.0f, 19.0f, 0.0f, 1.0f, 9.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(2.358476f, 1.539103f);
                j.cubicTo(3.7269406f, 0.68053156f, 5.494957f, 1.1697177f, 7.0332313f, 1.0f);
                j.cubicTo(20.038641f, 1.0898505f, 33.044052f, 0.9201329f, 46.04946f, 1.0798671f);
                j.cubicTo(48.05721f, 0.9301163f, 49.225895f, 3.126462f, 48.9562f, 4.9035053f);
                j.cubicTo(48.976177f, 15.615682f, 48.976177f, 26.327858f, 48.9562f, 37.040035f);
                j.cubicTo(49.245872f, 38.79711f, 48.077187f, 41.00344f, 46.089417f, 40.903606f);
                j.cubicTo(32.38479f, 41.023407f, 18.670176f, 40.923573f, 4.965551f, 40.95352f);
                j.cubicTo(3.1475906f, 41.253025f, 0.94006723f, 40.08497f, 1.0799104f, 38.02839f);
                j.cubicTo(0.92008966f, 27.33618f, 1.0898992f, 16.633987f, 1.0f, 5.9417777f);
                j.cubicTo(1.0499439f, 4.4043355f, 0.8002241f, 2.4675581f, 2.358476f, 1.539103f);
                j.lineTo(2.358476f, 1.539103f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(52.013893f, 14.44758f);
                j.cubicTo(57.040844f, 10.022178f, 61.738647f, 5.21371f, 66.9551f, 1.0f);
                j.cubicTo(68.35148f, 3.0866935f, 67.92259f, 5.647177f, 67.98244f, 8.006048f);
                j.cubicTo(67.94254f, 17.774193f, 67.96249f, 27.532259f, 67.972466f, 37.29032f);
                j.cubicTo(68.00239f, 38.63105f, 67.65329f, 39.860886f, 66.93516f, 41.0f);
                j.cubicTo(61.728672f, 36.80645f, 57.06079f, 31.997984f, 52.02387f, 27.602823f);
                j.cubicTo(51.98397f, 23.217741f, 52.003918f, 18.83266f, 52.013893f, 14.44758f);
                j.lineTo(52.013893f, 14.44758f);
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
