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

public final class aor extends c {
    private final int height = 102;
    private final int width = 102;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 102;
            case 1:
                return 102;
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
                i3 = c.a(i3, looper);
                i3.setStrokeWidth(1.0f);
                Paint a = c.a(i2, looper);
                a.setColor(-986896);
                Path j = c.j(looper);
                j.moveTo(0.0f, 0.0f);
                j.lineTo(102.0f, 0.0f);
                j.lineTo(102.0f, 102.0f);
                j.lineTo(0.0f, 102.0f);
                j.lineTo(0.0f, 0.0f);
                j.close();
                canvas.saveLayerAlpha(null, 0, 4);
                canvas.drawPath(j, c.a(a, looper));
                canvas.restore();
                canvas.save();
                Paint a2 = c.a(i3, looper);
                a2.setColor(-11048043);
                a2.setStrokeWidth(6.0f);
                Path j2 = c.j(looper);
                j2.moveTo(24.0f, 50.0f);
                j2.cubicTo(24.0f, 48.89543f, 24.89543f, 48.0f, 26.0f, 48.0f);
                j2.lineTo(76.0f, 48.0f);
                j2.cubicTo(77.10457f, 48.0f, 78.0f, 48.89543f, 78.0f, 50.0f);
                j2.lineTo(78.0f, 79.0f);
                j2.cubicTo(78.0f, 80.10457f, 77.10457f, 81.0f, 76.0f, 81.0f);
                j2.lineTo(26.0f, 81.0f);
                j2.cubicTo(24.89543f, 81.0f, 24.0f, 80.10457f, 24.0f, 79.0f);
                j2.lineTo(24.0f, 50.0f);
                j2.close();
                canvas.drawPath(j2, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(i2, looper);
                a2.setColor(-11048043);
                j2 = c.j(looper);
                j2.moveTo(28.5f, 35.0f);
                j2.cubicTo(28.5f, 22.573593f, 38.573593f, 12.5f, 51.0f, 12.5f);
                j2.cubicTo(63.426407f, 12.5f, 73.5f, 22.573593f, 73.5f, 35.0f);
                j2.lineTo(67.5f, 35.0f);
                j2.cubicTo(67.5f, 25.887302f, 60.112698f, 18.5f, 51.0f, 18.5f);
                j2.cubicTo(41.887302f, 18.5f, 34.5f, 25.887302f, 34.5f, 35.0f);
                j2.lineTo(28.5f, 35.0f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, a2);
                canvas.restore();
                canvas.save();
                i3 = c.a(i2, looper);
                i3.setColor(-11048043);
                Path j3 = c.j(looper);
                j3.moveTo(28.5f, 35.0f);
                j3.lineTo(34.5f, 35.0f);
                j3.lineTo(34.5f, 47.0f);
                j3.lineTo(28.5f, 47.0f);
                j3.lineTo(28.5f, 35.0f);
                j3.close();
                canvas.drawPath(j3, i3);
                canvas.restore();
                canvas.save();
                i2 = c.a(i2, looper);
                i2.setColor(-11048043);
                j2 = c.j(looper);
                j2.moveTo(67.5f, 35.0f);
                j2.lineTo(73.5f, 35.0f);
                j2.lineTo(73.5f, 35.0f);
                j2.lineTo(73.5f, 35.0f);
                j2.cubicTo(73.5f, 36.656853f, 72.15685f, 38.0f, 70.5f, 38.0f);
                j2.lineTo(70.5f, 38.0f);
                j2.lineTo(70.5f, 38.0f);
                j2.cubicTo(68.84315f, 38.0f, 67.5f, 36.656853f, 67.5f, 35.0f);
                j2.lineTo(67.5f, 35.0f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, i2);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
