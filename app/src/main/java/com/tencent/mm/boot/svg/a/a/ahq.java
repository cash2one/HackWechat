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

public final class ahq extends c {
    private final int height = 48;
    private final int width = 48;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 48;
            case 1:
                return 48;
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
                i3 = c.a(i2, looper);
                i3.setColor(-16896);
                canvas.save();
                Paint a = c.a(i3, looper);
                Path j = c.j(looper);
                j.moveTo(22.7f, 0.0f);
                j.lineTo(25.07f, 0.0f);
                j.cubicTo(36.94f, 0.34f, 47.3f, 10.5f, 48.0f, 22.33f);
                j.lineTo(48.0f, 25.39f);
                j.cubicTo(47.47f, 37.15f, 37.36f, 47.34f, 25.6f, 48.0f);
                j.lineTo(22.61f, 48.0f);
                j.cubicTo(10.79f, 47.47f, 0.57f, 37.25f, 0.0f, 25.44f);
                j.lineTo(0.0f, 22.47f);
                j.cubicTo(0.61f, 10.66f, 10.88f, 0.5f, 22.7f, 0.0f);
                j.lineTo(22.7f, 0.0f);
                j.close();
                j.moveTo(23.290903f, 13.335449f);
                j.cubicTo(20.390598f, 14.737528f, 22.898153f, 19.267319f, 25.697754f, 17.65934f);
                j.cubicTo(28.628271f, 16.237654f, 26.080433f, 11.747081f, 23.290903f, 13.335449f);
                j.lineTo(23.290903f, 13.335449f);
                j.close();
                j.moveTo(20.0f, 20.0f);
                j.lineTo(20.00998f, 20.98f);
                j.cubicTo(20.758484f, 20.99f, 22.25549f, 21.01f, 23.003992f, 21.02f);
                j.lineTo(23.003992f, 34.98f);
                j.cubicTo(22.25549f, 34.99f, 20.758484f, 35.01f, 20.00998f, 35.02f);
                j.lineTo(20.00998f, 36.0f);
                j.lineTo(30.0f, 36.0f);
                j.lineTo(29.99002f, 35.02f);
                j.cubicTo(29.241516f, 35.01f, 27.74451f, 34.99f, 26.996008f, 34.98f);
                j.cubicTo(26.996008f, 29.99f, 27.005987f, 24.99f, 26.996008f, 20.0f);
                j.lineTo(20.0f, 20.0f);
                j.lineTo(20.0f, 20.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                i2 = c.a(i2, looper);
                i2.setColor(-1);
                float[] a2 = c.a(e, 1.0f, 0.0f, 20.0f, 0.0f, 1.0f, 13.0f);
                f.reset();
                f.setValues(a2);
                canvas.concat(f);
                canvas.save();
                Paint a3 = c.a(i2, looper);
                j = c.j(looper);
                j.moveTo(3.290903f, 0.33544943f);
                j.cubicTo(6.080433f, -1.2529188f, 8.628271f, 3.2376533f, 5.697754f, 4.659341f);
                j.cubicTo(2.8981533f, 6.2673187f, 0.39059758f, 1.7375276f, 3.290903f, 0.33544943f);
                j.lineTo(3.290903f, 0.33544943f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a3);
                canvas.restore();
                canvas.save();
                a3 = c.a(i2, looper);
                j = c.j(looper);
                j.moveTo(0.0f, 7.0f);
                j.lineTo(6.996008f, 7.0f);
                j.cubicTo(7.005988f, 11.99f, 6.996008f, 16.99f, 6.996008f, 21.98f);
                j.cubicTo(7.744511f, 21.99f, 9.241517f, 22.01f, 9.99002f, 22.02f);
                j.lineTo(10.0f, 23.0f);
                j.lineTo(0.00998004f, 23.0f);
                j.lineTo(0.00998004f, 22.02f);
                j.cubicTo(0.75848305f, 22.01f, 2.255489f, 21.99f, 3.003992f, 21.98f);
                j.lineTo(3.003992f, 8.02f);
                j.cubicTo(2.255489f, 8.01f, 0.75848305f, 7.99f, 0.00998004f, 7.98f);
                j.lineTo(0.0f, 7.0f);
                j.lineTo(0.0f, 7.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a3);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
