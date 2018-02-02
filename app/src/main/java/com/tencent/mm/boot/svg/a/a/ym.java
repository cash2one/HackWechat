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
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;

public final class ym extends c {
    private final int height = 108;
    private final int width = 108;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 108;
            case 1:
                return 108;
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
                a.setColor(-10526881);
                e = c.a(e, 1.0f, 0.0f, 21.0f, 0.0f, 1.0f, 30.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(2.35f, DownloadHelper.SAVE_FATOR);
                j.cubicTo(3.74f, 0.7f, 5.46f, 1.12f, 6.99f, 0.97f);
                j.cubicTo(25.38f, 1.08f, 43.78f, 0.89f, 62.17f, 1.07f);
                j.cubicTo(64.14f, 0.97f, 65.25f, 3.16f, 64.99f, 4.89f);
                j.cubicTo(65.01f, 17.64f, 65.01f, 30.4f, 64.99f, 43.16f);
                j.cubicTo(65.41f, 45.4f, 63.42f, 47.45f, 61.15f, 46.99f);
                j.cubicTo(42.39f, 47.01f, 23.62f, 47.01f, 4.85f, 46.99f);
                j.cubicTo(3.08f, 47.28f, 0.96f, 46.11f, 1.07f, 44.13f);
                j.cubicTo(0.89f, 31.42f, 1.07f, 18.7f, 0.98f, 5.99f);
                j.cubicTo(1.05f, 4.43f, 0.78f, 2.44f, 2.35f, DownloadHelper.SAVE_FATOR);
                j.lineTo(2.35f, DownloadHelper.SAVE_FATOR);
                j.close();
                j.moveTo(7.98f, 14.89f);
                j.cubicTo(15.34f, 19.29f, 22.84f, 23.48f, 30.24f, 27.82f);
                j.cubicTo(31.9f, 28.96f, 34.09f, 28.95f, 35.76f, 27.82f);
                j.cubicTo(43.14f, 23.48f, 50.64f, 19.31f, 57.99f, 14.91f);
                j.cubicTo(61.35f, 13.52f, 58.13f, 7.66f, 55.13f, 9.74f);
                j.cubicTo(47.7f, 13.88f, 40.39f, 18.25f, 33.0f, 22.46f);
                j.cubicTo(25.61f, 18.25f, 18.31f, 13.88f, 10.88f, 9.75f);
                j.cubicTo(7.92f, 7.68f, 4.67f, 13.4f, 7.98f, 14.89f);
                j.lineTo(7.98f, 14.89f);
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
