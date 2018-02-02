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

public final class ac extends c {
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
                i2 = c.a(i2, looper);
                i2.setColor(-2130706433);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(46.0f, 73.0f);
                j.lineTo(46.0f, 69.99739f);
                j.cubicTo(46.0f, 69.96348f, 46.00085f, 69.929756f, 46.002525f, 69.896255f);
                j.cubicTo(36.447983f, 68.898026f, 29.0f, 60.818798f, 29.0f, 51.0f);
                j.cubicTo(29.0f, 49.89543f, 29.89543f, 49.0f, 31.0f, 49.0f);
                j.cubicTo(32.10457f, 49.0f, 33.0f, 49.89543f, 33.0f, 51.0f);
                j.cubicTo(33.0f, 59.28427f, 39.71573f, 66.0f, 48.0f, 66.0f);
                j.cubicTo(56.28427f, 66.0f, 63.0f, 59.28427f, 63.0f, 51.0f);
                j.cubicTo(63.0f, 49.89543f, 63.89543f, 49.0f, 65.0f, 49.0f);
                j.cubicTo(66.10457f, 49.0f, 67.0f, 49.89543f, 67.0f, 51.0f);
                j.cubicTo(67.0f, 60.818787f, 59.552032f, 68.89801f, 49.9975f, 69.896255f);
                j.lineTo(49.9975f, 69.896255f);
                j.cubicTo(49.99916f, 69.929756f, 50.0f, 69.96348f, 50.0f, 69.99739f);
                j.lineTo(50.0f, 73.0f);
                j.lineTo(57.008846f, 73.0f);
                j.cubicTo(58.110325f, 73.0f, 59.0f, 73.89543f, 59.0f, 75.0f);
                j.cubicTo(59.0f, 76.112274f, 58.10853f, 77.0f, 57.008846f, 77.0f);
                j.lineTo(38.991154f, 77.0f);
                j.cubicTo(37.889675f, 77.0f, 37.0f, 76.10457f, 37.0f, 75.0f);
                j.cubicTo(37.0f, 73.887726f, 37.89147f, 73.0f, 38.991154f, 73.0f);
                j.lineTo(46.0f, 73.0f);
                j.close();
                j.moveTo(48.0f, 20.0f);
                j.cubicTo(41.92487f, 20.0f, 37.0f, 24.920769f, 37.0f, 31.007566f);
                j.lineTo(37.0f, 50.992435f);
                j.cubicTo(37.0f, 57.071747f, 41.92353f, 62.0f, 48.0f, 62.0f);
                j.cubicTo(54.07513f, 62.0f, 59.0f, 57.07923f, 59.0f, 50.992435f);
                j.lineTo(59.0f, 31.007566f);
                j.cubicTo(59.0f, 24.928255f, 54.07647f, 20.0f, 48.0f, 20.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
