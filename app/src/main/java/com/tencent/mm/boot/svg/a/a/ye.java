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

public final class ye extends c {
    private final int height = 46;
    private final int width = 46;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 46;
            case 1:
                return 46;
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
                e = c.a(e, 1.0f, 0.0f, -996.0f, 0.0f, 1.0f, -265.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, -1.0f, 0.0f, 1.0f, 216.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                a = c.a(a, looper);
                e = c.a(e, 0.70710677f, -0.70710677f, 350.08917f, 0.70710677f, 0.70710677f, -700.3372f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                Path j = c.j(looper);
                j.moveTo(1018.4283f, 70.42826f);
                j.lineTo(990.4264f, 70.42826f);
                j.lineTo(990.4264f, 74.42455f);
                j.lineTo(1018.4283f, 74.42455f);
                j.lineTo(1018.4283f, 102.42641f);
                j.lineTo(1022.42456f, 102.42641f);
                j.lineTo(1022.42456f, 74.42455f);
                j.lineTo(1050.4264f, 74.42455f);
                j.lineTo(1050.4264f, 70.42826f);
                j.lineTo(1022.42456f, 70.42826f);
                j.lineTo(1022.42456f, 42.426407f);
                j.lineTo(1018.4283f, 42.426407f);
                j.lineTo(1018.4283f, 70.42826f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
