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

public final class jq extends c {
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
                canvas.saveLayerAlpha(null, 38, 4);
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(WebView.NIGHT_MODE_COLOR);
                e = c.a(e, 1.0f, 0.0f, -1538.0f, 0.0f, 1.0f, -387.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(1539.7643f, 389.7639f);
                j.cubicTo(1539.5017f, 389.20786f, 1539.599f, 388.5254f, 1540.0621f, 388.06216f);
                j.cubicTo(1540.6488f, 387.47556f, 1541.5945f, 387.47012f, 1542.1871f, 388.06277f);
                j.lineTo(1548.1244f, 394.0f);
                j.lineTo(1570.9926f, 394.0f);
                j.cubicTo(1572.6536f, 394.0f, 1574.0f, 395.3431f, 1574.0f, 397.00793f);
                j.lineTo(1574.0f, 416.99207f);
                j.cubicTo(1574.0f, 417.79092f, 1573.6871f, 418.51703f, 1573.1799f, 419.05563f);
                j.lineTo(1577.2443f, 423.11996f);
                j.cubicTo(1577.8313f, 423.70694f, 1577.8357f, 424.6542f, 1577.2449f, 425.24493f);
                j.cubicTo(1576.784f, 425.70578f, 1576.1017f, 425.80792f, 1575.5428f, 425.5432f);
                j.cubicTo(1575.4706f, 425.39014f, 1575.371f, 425.24667f, 1575.2443f, 425.11996f);
                j.lineTo(1540.1871f, 390.06277f);
                j.cubicTo(1540.06f, 389.93573f, 1539.9167f, 389.83615f, 1539.7643f, 389.7639f);
                j.close();
                j.moveTo(1540.0359f, 394.16028f);
                j.cubicTo(1538.8513f, 394.5642f, 1538.0f, 395.68658f, 1538.0f, 397.00793f);
                j.lineTo(1538.0f, 416.99207f);
                j.cubicTo(1538.0f, 418.6569f, 1539.3418f, 420.0f, 1540.9968f, 420.0f);
                j.lineTo(1547.0f, 420.0f);
                j.lineTo(1547.0f, 426.8875f);
                j.cubicTo(1547.0f, 428.08762f, 1547.6836f, 428.36902f, 1548.5267f, 427.5205f);
                j.lineTo(1556.0f, 420.0f);
                j.lineTo(1565.8756f, 420.0f);
                j.lineTo(1540.0359f, 394.16028f);
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
