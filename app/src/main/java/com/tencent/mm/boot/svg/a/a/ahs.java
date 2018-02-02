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
import com.tencent.wcdb.FileUtils;

public final class ahs extends c {
    private final int height = FileUtils.S_IWUSR;
    private final int width = FileUtils.S_IWUSR;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return FileUtils.S_IWUSR;
            case 1:
                return FileUtils.S_IWUSR;
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
                Paint a = c.a(i2, looper);
                a.setColor(-5658199);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 17.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(8.006973f, 18.0f);
                j.cubicTo(3.584844f, 18.0f, 0.0f, 21.589066f, 0.0f, 26.007586f);
                j.lineTo(0.0f, 85.99242f);
                j.cubicTo(0.0f, 90.41488f, 3.5907528f, 94.0f, 8.006973f, 94.0f);
                j.lineTo(119.99303f, 94.0f);
                j.cubicTo(124.41515f, 94.0f, 128.0f, 90.410934f, 128.0f, 85.99242f);
                j.lineTo(128.0f, 26.007586f);
                j.cubicTo(128.0f, 21.58512f, 124.40925f, 18.0f, 119.99303f, 18.0f);
                j.lineTo(8.006973f, 18.0f);
                j.close();
                j.moveTo(51.428135f, 0.0f);
                j.lineTo(64.0f, 0.0f);
                j.lineTo(64.0f, 18.0f);
                j.lineTo(26.375288f, 18.0f);
                j.cubicTo(36.35272f, 18.0f, 41.71253f, 0.0f, 51.428135f, 0.0f);
                j.close();
                j.moveTo(76.5697f, 0.0f);
                j.lineTo(64.0f, 0.0f);
                j.lineTo(64.0f, 18.0f);
                j.lineTo(101.62471f, 18.0f);
                j.cubicTo(91.647285f, 18.0f, 86.28747f, 0.0f, 76.5697f, 0.0f);
                j.close();
                j.moveTo(93.0f, 53.0f);
                j.cubicTo(93.0f, 69.01692f, 80.01692f, 82.0f, 64.0f, 82.0f);
                j.cubicTo(47.983078f, 82.0f, 35.0f, 69.01692f, 35.0f, 53.0f);
                j.cubicTo(35.0f, 36.983078f, 47.983078f, 24.0f, 64.0f, 24.0f);
                j.cubicTo(80.01692f, 24.0f, 93.0f, 36.983078f, 93.0f, 53.0f);
                j.close();
                j.moveTo(84.0f, 53.0f);
                j.cubicTo(84.0f, 64.046f, 75.046f, 73.0f, 64.0f, 73.0f);
                j.cubicTo(52.954f, 73.0f, 44.0f, 64.046f, 44.0f, 53.0f);
                j.cubicTo(44.0f, 41.954f, 52.954f, 33.0f, 64.0f, 33.0f);
                j.cubicTo(75.046f, 33.0f, 84.0f, 41.954f, 84.0f, 53.0f);
                j.close();
                j.moveTo(6.4545455f, 6.4315085f);
                j.lineTo(24.454546f, 6.4315085f);
                j.lineTo(24.454546f, 12.431508f);
                j.lineTo(6.4545455f, 12.431508f);
                j.lineTo(6.4545455f, 6.4315085f);
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
