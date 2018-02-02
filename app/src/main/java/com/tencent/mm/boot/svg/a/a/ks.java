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

public final class ks extends c {
    private final int height = 117;
    private final int width = 117;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 117;
            case 1:
                return 117;
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
                e = c.a(e, 1.0f, 0.0f, -1265.0f, 0.0f, 1.0f, -201.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                a2.setColor(-16139513);
                a2.setStrokeWidth(6.0f);
                Path j = c.j(looper);
                j.moveTo(1268.0f, 259.5f);
                j.cubicTo(1268.0f, 228.84819f, 1292.8481f, 204.0f, 1323.5f, 204.0f);
                j.lineTo(1323.5f, 204.0f);
                j.cubicTo(1354.1519f, 204.0f, 1379.0f, 228.84819f, 1379.0f, 259.5f);
                j.lineTo(1379.0f, 259.5f);
                j.cubicTo(1379.0f, 290.1518f, 1354.1519f, 315.0f, 1323.5f, 315.0f);
                j.lineTo(1323.5f, 315.0f);
                j.cubicTo(1292.8481f, 315.0f, 1268.0f, 290.1518f, 1268.0f, 259.5f);
                j.lineTo(1268.0f, 259.5f);
                j.close();
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(i2, looper);
                a2.setColor(-16139513);
                j = c.j(looper);
                j.moveTo(1309.1147f, 266.15973f);
                j.cubicTo(1310.8816f, 264.54208f, 1312.0f, 262.14874f, 1312.0f, 259.4782f);
                j.cubicTo(1312.0f, 257.09238f, 1311.1073f, 254.92775f, 1309.6571f, 253.33984f);
                j.lineTo(1302.976f, 260.02097f);
                j.lineTo(1309.1147f, 266.15973f);
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
