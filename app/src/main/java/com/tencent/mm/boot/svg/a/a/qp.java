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

public final class qp extends c {
    private final int height = 75;
    private final int width = 75;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 75;
            case 1:
                return 75;
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
                e = c.a(e, 1.0f, 0.0f, 15.0f, 0.0f, 1.0f, 6.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(i2, looper);
                a2.setColor(-9473160);
                Path j = c.j(looper);
                j.moveTo(23.94f, 60.0f);
                j.lineTo(23.94f, 54.18f);
                j.lineTo(21.42f, 54.18f);
                j.lineTo(21.42f, 60.0f);
                j.lineTo(9.5f, 60.0f);
                j.lineTo(9.5f, 60.0f);
                j.cubicTo(8.671573f, 60.0f, 8.0f, 60.671574f, 8.0f, 61.5f);
                j.cubicTo(8.0f, 62.328426f, 8.671573f, 63.0f, 9.5f, 63.0f);
                j.lineTo(36.5f, 63.0f);
                j.cubicTo(37.328426f, 63.0f, 38.0f, 62.328426f, 38.0f, 61.5f);
                j.cubicTo(38.0f, 60.671574f, 37.328426f, 60.0f, 36.5f, 60.0f);
                j.lineTo(23.94f, 60.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(i2, looper);
                a2.setColor(-9473160);
                j = c.j(looper);
                j.moveTo(45.36f, 23.94f);
                j.lineTo(45.36f, 31.74326f);
                j.cubicTo(45.36f, 44.134727f, 35.20582f, 54.18f, 22.68f, 54.18f);
                j.cubicTo(10.1541815f, 54.18f, 0.0f, 44.134727f, 0.0f, 31.74326f);
                j.lineTo(0.0f, 23.94f);
                j.lineTo(3.0f, 23.94f);
                j.lineTo(3.0f, 31.74326f);
                j.cubicTo(3.0f, 42.47059f, 11.803838f, 51.18f, 22.68f, 51.18f);
                j.cubicTo(33.556164f, 51.18f, 42.36f, 42.47059f, 42.36f, 31.74326f);
                j.lineTo(42.36f, 23.94f);
                j.lineTo(45.36f, 23.94f);
                j.close();
                j.moveTo(45.36f, 23.94f);
                j.lineTo(45.36f, 31.74326f);
                j.cubicTo(45.36f, 44.134727f, 35.20582f, 54.18f, 22.68f, 54.18f);
                j.cubicTo(10.1541815f, 54.18f, 0.0f, 44.134727f, 0.0f, 31.74326f);
                j.lineTo(0.0f, 23.94f);
                j.lineTo(3.0f, 23.94f);
                j.lineTo(3.0f, 31.74326f);
                j.cubicTo(3.0f, 42.47059f, 11.803838f, 51.18f, 22.68f, 51.18f);
                j.cubicTo(33.556164f, 51.18f, 42.36f, 42.47059f, 42.36f, 31.74326f);
                j.lineTo(42.36f, 23.94f);
                j.lineTo(45.36f, 23.94f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 1);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                a2.setColor(-9473160);
                a2.setStrokeWidth(3.0f);
                j = c.j(looper);
                j.moveTo(11.58f, 12.6f);
                j.cubicTo(11.58f, 6.4696393f, 16.549639f, DownloadHelper.SAVE_FATOR, 22.68f, DownloadHelper.SAVE_FATOR);
                j.lineTo(22.679998f, DownloadHelper.SAVE_FATOR);
                j.cubicTo(28.81036f, DownloadHelper.SAVE_FATOR, 33.78f, 6.4696393f, 33.78f, 12.6f);
                j.lineTo(33.78f, 31.499998f);
                j.cubicTo(33.78f, 37.63036f, 28.81036f, 42.6f, 22.679998f, 42.6f);
                j.lineTo(22.68f, 42.6f);
                j.cubicTo(16.549639f, 42.6f, 11.58f, 37.63036f, 11.58f, 31.499998f);
                j.lineTo(11.58f, 12.6f);
                j.close();
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
