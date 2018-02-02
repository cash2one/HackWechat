package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class nu extends c {
    private final int height = ar.CTRL_INDEX;
    private final int width = ar.CTRL_INDEX;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return ar.CTRL_INDEX;
            case 1:
                return ar.CTRL_INDEX;
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
                canvas.save();
                i3 = c.a(i2, looper);
                i3.setColor(-16745032);
                Path j = c.j(looper);
                j.moveTo(0.0f, 0.0f);
                j.lineTo(192.0f, 0.0f);
                j.lineTo(192.0f, 192.0f);
                j.lineTo(0.0f, 192.0f);
                j.lineTo(0.0f, 0.0f);
                j.close();
                canvas.drawPath(j, i3);
                canvas.restore();
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-1);
                Path j2 = c.j(looper);
                j2.moveTo(100.36363f, 132.43181f);
                j2.lineTo(100.36363f, 148.36363f);
                j2.lineTo(78.545456f, 148.36363f);
                j2.lineTo(78.545456f, 74.181816f);
                j2.lineTo(100.36363f, 74.181816f);
                j2.lineTo(100.36363f, 81.31886f);
                j2.cubicTo(106.0796f, 75.988815f, 113.749794f, 72.72727f, 122.181816f, 72.72727f);
                j2.cubicTo(139.85522f, 72.72727f, 154.18182f, 87.05574f, 154.18182f, 104.72727f);
                j2.cubicTo(154.18182f, 105.21475f, 154.17091f, 105.69968f, 154.14935f, 106.18183f);
                j2.lineTo(154.18182f, 106.181816f);
                j2.lineTo(154.18182f, 149.81818f);
                j2.lineTo(132.36363f, 149.81818f);
                j2.lineTo(132.36363f, 135.90036f);
                j2.lineTo(132.36363f, 112.0f);
                j2.lineTo(132.29858f, 112.0f);
                j2.cubicTo(132.34158f, 111.520935f, 132.36363f, 111.035774f, 132.36363f, 110.545456f);
                j2.cubicTo(132.36363f, 101.70946f, 125.19964f, 94.545456f, 117.30481f, 94.545456f);
                j2.cubicTo(107.52763f, 94.545456f, 100.36363f, 101.70946f, 100.36363f, 110.545456f);
                j2.cubicTo(100.36363f, 111.035774f, 100.38569f, 111.520935f, 100.42901f, 112.0f);
                j2.lineTo(100.36363f, 112.0f);
                j2.lineTo(100.36363f, 132.43181f);
                j2.lineTo(100.36363f, 132.43181f);
                j2.close();
                j2.moveTo(42.18182f, 74.181816f);
                j2.lineTo(64.0f, 74.181816f);
                j2.lineTo(64.0f, 148.36363f);
                j2.lineTo(42.18182f, 148.36363f);
                j2.lineTo(42.18182f, 74.181816f);
                j2.close();
                j2.moveTo(66.90909f, 50.909092f);
                j2.cubicTo(66.90909f, 58.942547f, 60.39709f, 65.454544f, 52.363636f, 65.454544f);
                j2.cubicTo(44.33018f, 65.454544f, 37.81818f, 58.942547f, 37.81818f, 50.909092f);
                j2.cubicTo(37.81818f, 42.875637f, 44.33018f, 36.363636f, 52.363636f, 36.363636f);
                j2.cubicTo(60.39709f, 36.363636f, 66.90909f, 42.875637f, 66.90909f, 50.909092f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, a);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
