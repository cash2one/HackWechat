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

public final class vf extends c {
    private final int height = 45;
    private final int width = 45;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 45;
            case 1:
                return 45;
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
                i3 = c.a(i3, looper);
                i3.setStrokeWidth(1.0f);
                Paint a = c.a(i2, looper);
                Paint a2 = c.a(i3, looper);
                a.setColor(-16139513);
                a2.setColor(-16139513);
                a2.setStrokeWidth(0.5f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 7.0f, 0.0f, 1.0f, 13.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a3 = c.a(a, looper);
                Paint a4 = c.a(a2, looper);
                e = c.a(e, 0.70710677f, -0.70710677f, 10.0f, 0.70710677f, 0.70710677f, -4.1421356f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                Path j = c.j(looper);
                j.moveTo(-1.3137084f, 7.1715727f);
                j.lineTo(21.313707f, 7.1715727f);
                j.lineTo(21.313707f, 12.828427f);
                j.lineTo(-1.3137084f, 12.828427f);
                j.lineTo(-1.3137084f, 7.1715727f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a3);
                canvas.drawPath(j, a4);
                canvas.restore();
                canvas.save();
                a = c.a(a, looper);
                a2 = c.a(a2, looper);
                e = c.a(e, -0.70710677f, -0.70710677f, 44.62742f, 0.70710677f, -0.70710677f, 1.514719f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                Path j2 = c.j(looper);
                j2.moveTo(10.686292f, 7.1715727f);
                j2.lineTo(33.31371f, 7.1715727f);
                j2.lineTo(33.31371f, 12.828427f);
                j2.lineTo(10.686292f, 12.828427f);
                j2.lineTo(10.686292f, 7.1715727f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, a);
                canvas.drawPath(j2, a2);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
