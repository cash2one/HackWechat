package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.map.e;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class abg extends c {
    private final int height = e.CTRL_INDEX;
    private final int width = e.CTRL_INDEX;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return e.CTRL_INDEX;
            case 1:
                return e.CTRL_INDEX;
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
                a.setColor(-11286451);
                e = c.a(e, 1.0f, 0.0f, 44.0f, 0.0f, 1.0f, 22.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(11.594659f, 0.83899826f);
                j.cubicTo(22.046501f, -0.22110067f, 32.598267f, -0.24110253f, 43.07009f, 0.578974f);
                j.cubicTo(46.867126f, 0.95900947f, 50.724117f, 1.3390449f, 54.311317f, 2.6891708f);
                j.cubicTo(56.08993f, 3.2692251f, 55.980015f, 5.4394274f, 56.0f, 6.9395676f);
                j.cubicTo(55.94005f, 36.00228f, 56.019985f, 65.05499f, 55.96003f, 94.107704f);
                j.cubicTo(56.23981f, 97.137985f, 52.752533f, 97.84805f, 50.504288f, 98.3581f);
                j.cubicTo(39.79265f, 100.29828f, 28.821213f, 100.17827f, 17.979675f, 99.70822f);
                j.cubicTo(12.933614f, 99.27818f, 7.6977005f, 99.14817f, 2.9414127f, 97.24799f);
                j.cubicTo(1.1827854f, 96.67794f, 0.9329804f, 94.67776f, 1.012918f, 93.09761f);
                j.cubicTo(1.0229102f, 64.40493f, 1.0428946f, 35.70225f, 1.0029258f, 7.009574f);
                j.cubicTo(1.1028478f, 5.649447f, 0.813074f, 3.9392877f, 2.0720913f, 2.9991999f);
                j.cubicTo(5.049767f, 1.5990692f, 8.377171f, 1.2690384f, 11.594659f, 0.83899826f);
                j.lineTo(11.594659f, 0.83899826f);
                j.close();
                j.moveTo(4.0f, 10.0f);
                j.lineTo(4.0f, 87.0f);
                j.lineTo(53.0f, 87.0f);
                j.lineTo(53.0f, 10.0f);
                j.lineTo(4.0f, 10.0f);
                j.lineTo(4.0f, 10.0f);
                j.close();
                j.moveTo(27.34189f, 91.35242f);
                j.cubicTo(24.280243f, 92.668205f, 27.048307f, 97.45562f, 29.763947f, 95.56292f);
                j.cubicTo(32.605408f, 94.19653f, 30.015589f, 89.72288f, 27.34189f, 91.35242f);
                j.lineTo(27.34189f, 91.35242f);
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
