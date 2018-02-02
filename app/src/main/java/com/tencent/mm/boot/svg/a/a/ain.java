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

public final class ain extends c {
    private final int height = 60;
    private final int width = 60;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 60;
            case 1:
                return 60;
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
                e = c.a(e, 1.0f, 0.0f, 13.0f, 0.0f, 1.0f, 7.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(1.0f, 22.0f);
                j.cubicTo(-2.8734941f, 12.371129f, 4.898239f, 1.1049721f, 15.0f, 0.0f);
                j.cubicTo(23.440092f, -1.1542573f, 32.25474f, 5.2435603f, 34.0f, 14.0f);
                j.cubicTo(34.841976f, 18.579012f, 32.585667f, 23.21743f, 30.0f, 27.0f);
                j.cubicTo(26.478588f, 33.613884f, 21.885744f, 39.461887f, 17.0f, 45.0f);
                j.cubicTo(10.874953f, 37.892426f, 4.7478185f, 30.494947f, 1.0f, 22.0f);
                j.lineTo(1.0f, 22.0f);
                j.close();
                j.moveTo(13.0f, 7.0f);
                j.cubicTo(6.5172105f, 9.0244465f, 4.703988f, 19.022913f, 10.0f, 24.0f);
                j.cubicTo(15.73359f, 28.731422f, 25.8115f, 25.191965f, 27.0f, 18.0f);
                j.cubicTo(28.446182f, 10.514218f, 20.211548f, 3.7152615f, 13.0f, 7.0f);
                j.lineTo(13.0f, 7.0f);
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
