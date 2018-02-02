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

public final class m extends c {
    private final int height = 30;
    private final int width = 30;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 30;
            case 1:
                return 30;
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
                e = c.a(e, 1.0f, 0.0f, -30.0f, 0.0f, 1.0f, 0.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(48.870228f, 11.038835f);
                j.lineTo(46.0f, 13.9090605f);
                j.lineTo(47.16861f, 15.077669f);
                j.lineTo(50.038834f, 12.207443f);
                j.lineTo(52.90906f, 15.077669f);
                j.lineTo(54.07767f, 13.9090605f);
                j.lineTo(51.207443f, 11.038835f);
                j.lineTo(54.07767f, 8.168609f);
                j.lineTo(52.90906f, 7.0f);
                j.lineTo(50.038834f, 9.870226f);
                j.lineTo(47.16861f, 7.0f);
                j.lineTo(46.0f, 8.168609f);
                j.lineTo(48.870228f, 11.038835f);
                j.close();
                j.moveTo(37.99703f, 7.0f);
                j.cubicTo(37.446384f, 7.0f, 37.0f, 7.4530363f, 37.0f, 7.9970303f);
                j.lineTo(37.0f, 14.00297f);
                j.cubicTo(37.0f, 14.553615f, 37.453037f, 15.0f, 37.99703f, 15.0f);
                j.lineTo(44.00297f, 15.0f);
                j.cubicTo(44.553616f, 15.0f, 45.0f, 14.546964f, 45.0f, 14.00297f);
                j.lineTo(45.0f, 7.9970303f);
                j.cubicTo(45.0f, 7.4463854f, 44.546963f, 7.0f, 44.00297f, 7.0f);
                j.lineTo(37.99703f, 7.0f);
                j.close();
                j.moveTo(37.99703f, 16.0f);
                j.cubicTo(37.446384f, 16.0f, 37.0f, 16.453035f, 37.0f, 16.99703f);
                j.lineTo(37.0f, 23.00297f);
                j.cubicTo(37.0f, 23.553614f, 37.453037f, 24.0f, 37.99703f, 24.0f);
                j.lineTo(44.00297f, 24.0f);
                j.cubicTo(44.553616f, 24.0f, 45.0f, 23.546965f, 45.0f, 23.00297f);
                j.lineTo(45.0f, 16.99703f);
                j.cubicTo(45.0f, 16.446386f, 44.546963f, 16.0f, 44.00297f, 16.0f);
                j.lineTo(37.99703f, 16.0f);
                j.close();
                j.moveTo(46.99703f, 16.0f);
                j.cubicTo(46.446384f, 16.0f, 46.0f, 16.453035f, 46.0f, 16.99703f);
                j.lineTo(46.0f, 23.00297f);
                j.cubicTo(46.0f, 23.553614f, 46.453037f, 24.0f, 46.99703f, 24.0f);
                j.lineTo(53.00297f, 24.0f);
                j.cubicTo(53.553616f, 24.0f, 54.0f, 23.546965f, 54.0f, 23.00297f);
                j.lineTo(54.0f, 16.99703f);
                j.cubicTo(54.0f, 16.446386f, 53.546963f, 16.0f, 53.00297f, 16.0f);
                j.lineTo(46.99703f, 16.0f);
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
