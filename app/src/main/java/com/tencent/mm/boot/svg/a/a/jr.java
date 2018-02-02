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

public final class jr extends c {
    private final int height = 42;
    private final int width = 42;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 42;
            case 1:
                return 42;
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
                canvas.saveLayerAlpha(null, 102, 4);
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-1);
                e = c.a(e, 1.0f, 0.0f, -1491.0f, 0.0f, 1.0f, -387.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(1492.763f, 389.7632f);
                j.cubicTo(1492.5024f, 389.2075f, 1492.6007f, 388.5263f, 1493.0635f, 388.06348f);
                j.cubicTo(1493.6508f, 387.47614f, 1494.6017f, 387.4747f, 1495.1901f, 388.0631f);
                j.lineTo(1501.127f, 394.0f);
                j.lineTo(1523.9926f, 394.0f);
                j.cubicTo(1525.6536f, 394.0f, 1527.0f, 395.3431f, 1527.0f, 397.00793f);
                j.lineTo(1527.0f, 416.99207f);
                j.cubicTo(1527.0f, 417.79025f, 1526.6876f, 418.51584f, 1526.1813f, 419.05432f);
                j.lineTo(1530.607f, 423.48016f);
                j.cubicTo(1531.1942f, 424.0673f, 1531.1981f, 425.01532f, 1530.6067f, 425.60675f);
                j.cubicTo(1530.147f, 426.06656f, 1529.4644f, 426.16727f, 1528.9072f, 425.907f);
                j.cubicTo(1528.8348f, 425.75256f, 1528.7347f, 425.60782f, 1528.607f, 425.48016f);
                j.lineTo(1493.1901f, 390.0631f);
                j.cubicTo(1493.0623f, 389.93536f, 1492.9175f, 389.8354f, 1492.763f, 389.7632f);
                j.close();
                j.moveTo(1493.0339f, 394.16092f);
                j.cubicTo(1491.8503f, 394.56543f, 1491.0f, 395.6873f, 1491.0f, 397.00793f);
                j.lineTo(1491.0f, 416.99207f);
                j.cubicTo(1491.0f, 418.6569f, 1492.3418f, 420.0f, 1493.9968f, 420.0f);
                j.lineTo(1500.0f, 420.0f);
                j.lineTo(1500.0f, 426.8875f);
                j.cubicTo(1500.0f, 428.08762f, 1500.6836f, 428.36902f, 1501.5267f, 427.5205f);
                j.lineTo(1509.0f, 420.0f);
                j.lineTo(1518.873f, 420.0f);
                j.lineTo(1493.0339f, 394.16092f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
