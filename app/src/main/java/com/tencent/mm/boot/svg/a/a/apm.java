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

public final class apm extends c {
    private final int height = 98;
    private final int width = 123;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 123;
            case 1:
                return 98;
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
                canvas.saveLayerAlpha(null, 64, 4);
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-5592406);
                e = c.a(e, 1.0f, 0.0f, -479.0f, 0.0f, 1.0f, -378.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 479.0f, 0.0f, 1.0f, 378.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(97.83983f, 58.755054f);
                j.cubicTo(95.062546f, 58.755054f, 92.84071f, 56.56591f, 92.84071f, 53.82948f);
                j.cubicTo(92.84071f, 51.09305f, 95.062546f, 48.903908f, 97.83983f, 48.903908f);
                j.cubicTo(100.61712f, 48.903908f, 102.83894f, 51.09305f, 102.83894f, 53.82948f);
                j.cubicTo(102.83894f, 56.42909f, 100.61712f, 58.755054f, 97.83983f, 58.755054f);
                j.moveTo(73.20133f, 58.755054f);
                j.cubicTo(70.42405f, 58.755054f, 68.20222f, 56.56591f, 68.20222f, 53.82948f);
                j.cubicTo(68.20222f, 51.09305f, 70.42405f, 48.903908f, 73.20133f, 48.903908f);
                j.cubicTo(75.97862f, 48.903908f, 78.20045f, 51.09305f, 78.20045f, 53.82948f);
                j.cubicTo(78.20045f, 56.42909f, 75.97862f, 58.755054f, 73.20133f, 58.755054f);
                j.moveTo(109.76284f, 86.40196f);
                j.cubicTo(117.556206f, 80.87495f, 122.478325f, 72.65183f, 122.478325f, 63.61989f);
                j.cubicTo(122.478325f, 46.90405f, 106.07124f, 33.423534f, 85.69912f, 33.423534f);
                j.cubicTo(65.326996f, 33.423534f, 48.919914f, 46.90405f, 48.919914f, 63.61989f);
                j.cubicTo(48.919914f, 80.33573f, 65.326996f, 93.816246f, 85.69912f, 93.816246f);
                j.cubicTo(89.937614f, 93.816246f, 93.902664f, 93.27702f, 97.73098f, 92.198586f);
                j.cubicTo(98.00443f, 92.06378f, 98.41461f, 92.06378f, 98.82478f, 92.06378f);
                j.cubicTo(99.508415f, 92.06378f, 100.19204f, 92.33339f, 100.738945f, 92.603f);
                j.lineTo(108.80576f, 97.18638f);
                j.cubicTo(109.07921f, 97.32118f, 109.215935f, 97.455986f, 109.48939f, 97.455986f);
                j.cubicTo(110.17302f, 97.455986f, 110.71992f, 96.91676f, 110.71992f, 96.24274f);
                j.cubicTo(110.71992f, 95.97313f, 110.58319f, 95.70352f, 110.58319f, 95.2991f);
                j.cubicTo(110.58319f, 95.1643f, 109.48939f, 91.52456f, 108.94249f, 89.23287f);
                j.cubicTo(108.80576f, 88.96326f, 108.80576f, 88.69365f, 108.80576f, 88.42404f);
                j.cubicTo(108.66904f, 87.4804f, 109.07921f, 86.80638f, 109.76284f, 86.40196f);
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(58.561066f, 30.257093f);
                j.cubicTo(55.37226f, 30.257093f, 52.847794f, 27.76976f, 52.847794f, 24.627867f);
                j.cubicTo(52.847794f, 21.485971f, 55.37226f, 18.99864f, 58.561066f, 18.99864f);
                j.cubicTo(61.74987f, 18.99864f, 64.27434f, 21.485971f, 64.27434f, 24.627867f);
                j.cubicTo(64.27434f, 27.638847f, 61.74987f, 30.257093f, 58.561066f, 30.257093f);
                j.moveTo(29.280533f, 30.257093f);
                j.cubicTo(26.091728f, 30.257093f, 23.567259f, 27.76976f, 23.567259f, 24.627867f);
                j.cubicTo(23.567259f, 21.485971f, 26.091728f, 18.99864f, 29.280533f, 18.99864f);
                j.cubicTo(32.469337f, 18.99864f, 34.99381f, 21.485971f, 34.99381f, 24.627867f);
                j.cubicTo(34.99381f, 27.638847f, 32.469337f, 30.257093f, 29.280533f, 30.257093f);
                j.moveTo(44.263397f, 0.0f);
                j.cubicTo(19.870565f, 0.0f, 0.0f, 16.146992f, 0.0f, 36.196175f);
                j.cubicTo(0.0f, 47.095394f, 5.89265f, 56.918148f, 15.348298f, 63.5115f);
                j.cubicTo(16.03349f, 64.049736f, 16.581644f, 64.857086f, 16.581644f, 65.93355f);
                j.cubicTo(16.581644f, 66.20267f, 16.444605f, 66.60634f, 16.444605f, 66.87546f);
                j.cubicTo(15.759414f, 69.56663f, 14.526068f, 74.00705f, 14.3890295f, 74.1416f);
                j.cubicTo(14.251991f, 74.54528f, 14.114953f, 74.8144f, 14.114953f, 75.21807f);
                j.cubicTo(14.114953f, 76.02542f, 14.800145f, 76.69821f, 15.622375f, 76.69821f);
                j.cubicTo(15.896452f, 76.69821f, 16.170528f, 76.56365f, 16.444605f, 76.42909f);
                j.lineTo(26.17433f, 70.91221f);
                j.cubicTo(26.859522f, 70.50853f, 27.681751f, 70.23942f, 28.503983f, 70.23942f);
                j.cubicTo(28.915098f, 70.23942f, 29.326212f, 70.23942f, 29.737328f, 70.37397f);
                j.cubicTo(34.259594f, 71.585f, 39.192974f, 72.39235f, 44.126358f, 72.39235f);
                j.lineTo(46.59305f, 72.39235f);
                j.cubicTo(45.633778f, 69.56663f, 45.085625f, 66.60634f, 45.085625f, 63.5115f);
                j.cubicTo(45.085625f, 45.346138f, 63.17469f, 30.544727f, 85.37491f, 30.544727f);
                j.lineTo(87.8416f, 30.544727f);
                j.cubicTo(84.68972f, 13.18671f, 66.32658f, 0.0f, 44.263397f, 0.0f);
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
