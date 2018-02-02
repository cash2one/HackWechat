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

public final class cf extends c {
    private final int height = 96;
    private final int width = 130;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 130;
            case 1:
                return 96;
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
                a.setColor(WebView.NIGHT_MODE_COLOR);
                e = c.a(e, 1.0f, 0.0f, -238.0f, 0.0f, 1.0f, -166.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 238.0f, 0.0f, 1.0f, 166.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                a = c.a(a, looper);
                e = c.a(e, 0.70710677f, -0.70710677f, 50.78103f, 0.70710677f, 0.70710677f, -41.066437f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                Path j = c.j(looper);
                j.moveTo(75.89903f, 17.651163f);
                j.lineTo(92.860985f, 63.1806f);
                j.lineTo(92.860985f, 63.1806f);
                j.cubicTo(93.05379f, 63.698135f, 92.79054f, 64.27399f, 92.27301f, 64.46679f);
                j.cubicTo(91.96835f, 64.58029f, 91.62753f, 64.538605f, 91.359215f, 64.35502f);
                j.lineTo(74.96195f, 53.135838f);
                j.lineTo(58.56469f, 64.35502f);
                j.lineTo(58.56469f, 64.35502f);
                j.cubicTo(58.108883f, 64.666885f, 57.486565f, 64.5502f, 57.174698f, 64.09439f);
                j.cubicTo(56.99111f, 63.826077f, 56.949425f, 63.48526f, 57.062923f, 63.1806f);
                j.lineTo(74.02487f, 17.651163f);
                j.lineTo(74.02487f, 17.651163f);
                j.cubicTo(74.21768f, 17.133627f, 74.793526f, 16.870382f, 75.311066f, 17.063189f);
                j.cubicTo(75.58311f, 17.164541f, 75.79768f, 17.379114f, 75.89903f, 17.651163f);
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
