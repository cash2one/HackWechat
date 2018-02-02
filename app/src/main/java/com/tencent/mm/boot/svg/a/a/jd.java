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

public final class jd extends c {
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
                e = c.a(e, 1.0f, 0.0f, 16.0f, 0.0f, 1.0f, 15.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.saveLayerAlpha(null, FileUtils.S_IWUSR, 4);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(0.98f, 33.0f);
                j.cubicTo(11.64f, 22.32f, 22.32f, 11.64f, 33.0f, 0.98f);
                j.cubicTo(34.9f, 2.86f, 36.8f, 4.76f, 38.68f, 6.66f);
                j.cubicTo(31.25f, 14.11f, 23.8f, 21.54f, 16.37f, 28.99f);
                j.cubicTo(32.58f, 29.01f, 48.79f, 28.99f, 65.0f, 29.0f);
                j.cubicTo(65.0f, 31.69f, 65.0f, 34.37f, 64.99f, 37.06f);
                j.cubicTo(48.81f, 37.08f, 32.62f, 37.05f, 16.43f, 37.07f);
                j.cubicTo(23.84f, 44.5f, 31.27f, 51.91f, 38.68f, 59.34f);
                j.cubicTo(36.8f, 61.24f, 34.9f, 63.14f, 33.0f, 65.02f);
                j.cubicTo(22.32f, 54.36f, 11.64f, 43.68f, 0.98f, 33.0f);
                j.lineTo(0.98f, 33.0f);
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
