package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class a extends c {
    private final int height = 100;
    private final int width = 100;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 100;
            case 1:
                return 100;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                c.f(looper);
                c.e(looper);
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
                i3 = c.a(i2, looper);
                i3.setColor(-2236702);
                canvas.save();
                Paint a = c.a(i3, looper);
                Path j = c.j(looper);
                j.moveTo(0.0f, 10.0f);
                j.cubicTo(0.0f, 4.4771523f, 4.4771523f, 0.0f, 10.0f, 0.0f);
                j.lineTo(90.0f, 0.0f);
                j.cubicTo(95.52285f, 0.0f, 100.0f, 4.4771523f, 100.0f, 10.0f);
                j.lineTo(100.0f, 90.0f);
                j.cubicTo(100.0f, 95.52285f, 95.52285f, 100.0f, 90.0f, 100.0f);
                j.lineTo(10.0f, 100.0f);
                j.cubicTo(4.4771523f, 100.0f, 0.0f, 95.52285f, 0.0f, 90.0f);
                j.lineTo(0.0f, 10.0f);
                j.close();
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                i2 = c.a(i2, looper);
                i2.setColor(-1);
                j = c.j(looper);
                j.moveTo(74.0f, 52.03699f);
                j.lineTo(74.0f, 22.99649f);
                j.cubicTo(74.0f, 21.887833f, 73.10395f, 21.0f, 71.99861f, 21.0f);
                j.lineTo(28.001389f, 21.0f);
                j.cubicTo(26.894938f, 21.0f, 26.0f, 21.89386f, 26.0f, 22.99649f);
                j.lineTo(26.0f, 77.00351f);
                j.cubicTo(26.0f, 78.11217f, 26.896053f, 79.0f, 28.001389f, 79.0f);
                j.lineTo(71.99861f, 79.0f);
                j.cubicTo(73.105064f, 79.0f, 74.0f, 78.10614f, 74.0f, 77.00351f);
                j.lineTo(74.0f, 55.48232f);
                j.lineTo(50.747208f, 68.733765f);
                j.lineTo(50.57445f, 68.832016f);
                j.cubicTo(50.36059f, 68.938515f, 50.119755f, 69.0f, 49.86415f, 69.0f);
                j.cubicTo(49.272663f, 69.0f, 48.75824f, 68.677986f, 48.487865f, 68.2032f);
                j.lineTo(48.384464f, 67.97943f);
                j.lineTo(44.075783f, 58.647274f);
                j.cubicTo(44.0289f, 58.54522f, 44.0f, 58.430485f, 44.0f, 58.318916f);
                j.cubicTo(44.0f, 57.88914f, 44.35322f, 57.539864f, 44.789295f, 57.539864f);
                j.cubicTo(44.96655f, 57.539864f, 45.129673f, 57.59755f, 45.26133f, 57.694534f);
                j.lineTo(50.345818f, 61.267784f);
                j.cubicTo(50.717667f, 61.50803f, 51.161446f, 61.648754f, 51.63862f, 61.648754f);
                j.cubicTo(51.923122f, 61.648754f, 52.194782f, 61.59614f, 52.44782f, 61.505493f);
                j.lineTo(74.0f, 52.03699f);
                j.close();
                j.moveTo(34.0f, 38.0f);
                j.lineTo(52.0f, 38.0f);
                j.lineTo(52.0f, 41.0f);
                j.lineTo(34.0f, 41.0f);
                j.lineTo(34.0f, 38.0f);
                j.close();
                j.moveTo(34.0f, 29.0f);
                j.lineTo(52.0f, 29.0f);
                j.lineTo(52.0f, 32.0f);
                j.lineTo(34.0f, 32.0f);
                j.lineTo(34.0f, 29.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, i2);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
