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

public final class apt extends c {
    private final int height = 242;
    private final int width = 245;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 245;
            case 1:
                return 242;
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
                Paint a2 = c.a(i2, looper);
                a2.setColor(-3552823);
                e = c.a(e, 1.0f, 0.0f, 55.0f, 0.0f, 1.0f, 75.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a3 = c.a(a2, looper);
                Path j = c.j(looper);
                j.moveTo(134.481f, 27.64f);
                j.lineTo(125.895f, 36.226f);
                j.cubicTo(110.961f, 21.261f, 90.312f, 12.0f, 67.499f, 12.0f);
                j.cubicTo(44.686f, 12.0f, 24.037f, 21.261f, 9.103f, 36.226f);
                j.lineTo(0.517f, 27.64f);
                j.cubicTo(17.694f, 10.56f, 41.362f, 0.0f, 67.499f, 0.0f);
                j.cubicTo(93.636f, 0.0f, 117.304f, 10.56f, 134.481f, 27.64f);
                j.lineTo(134.481f, 27.64f);
                j.close();
                j.moveTo(115.389f, 46.732f);
                j.lineTo(106.807f, 55.314f);
                j.cubicTo(96.758f, 45.234f, 82.859f, 38.996f, 67.501f, 38.996f);
                j.cubicTo(52.142f, 38.996f, 38.242f, 45.235f, 28.192f, 55.316f);
                j.lineTo(19.608f, 46.732f);
                j.cubicTo(31.899f, 34.537f, 48.817f, 27.0f, 67.499f, 27.0f);
                j.cubicTo(86.181f, 27.0f, 103.098f, 34.537f, 115.389f, 46.732f);
                j.lineTo(115.389f, 46.732f);
                j.close();
                j.moveTo(96.196f, 65.925f);
                j.lineTo(87.607f, 74.514f);
                j.cubicTo(82.517f, 69.262f, 75.393f, 65.993f, 67.502f, 65.993f);
                j.cubicTo(59.609f, 65.993f, 52.484f, 69.263f, 47.394f, 74.517f);
                j.lineTo(38.802f, 65.925f);
                j.cubicTo(46.135f, 58.56f, 56.284f, 54.0f, 67.499f, 54.0f);
                j.cubicTo(78.714f, 54.0f, 88.862f, 58.56f, 96.196f, 65.925f);
                j.lineTo(96.196f, 65.925f);
                j.close();
                j.moveTo(77.2f, 84.921f);
                j.lineTo(67.498f, 94.623f);
                j.lineTo(57.796f, 84.922f);
                j.cubicTo(60.314f, 82.497f, 63.729f, 81.0f, 67.499f, 81.0f);
                j.cubicTo(71.269f, 81.0f, 74.683f, 82.497f, 77.2f, 84.921f);
                j.lineTo(77.2f, 84.921f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a3);
                canvas.restore();
                canvas.restore();
                canvas.save();
                a3 = c.a(a, looper);
                a3.setColor(-3552823);
                a3.setStrokeWidth(4.0f);
                j = c.j(looper);
                j.moveTo(123.0f, 7.0f);
                j.cubicTo(185.96046f, 7.0f, 237.0f, 58.039536f, 237.0f, 121.0f);
                j.cubicTo(237.0f, 183.96046f, 185.96046f, 235.0f, 123.0f, 235.0f);
                j.cubicTo(60.039536f, 235.0f, 9.0f, 183.96046f, 9.0f, 121.0f);
                j.cubicTo(9.0f, 58.039536f, 60.039536f, 7.0f, 123.0f, 7.0f);
                j.close();
                canvas.drawPath(j, a3);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
