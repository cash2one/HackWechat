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

public final class aey extends c {
    private final int height = 76;
    private final int width = 76;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 76;
            case 1:
                return 76;
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
                a.setColor(-789517);
                Path j = c.j(looper);
                j.moveTo(0.0f, 4.0f);
                j.cubicTo(0.0f, 1.7908609f, 1.7908609f, 0.0f, 4.0f, 0.0f);
                j.lineTo(72.0f, 0.0f);
                j.cubicTo(74.20914f, 0.0f, 76.0f, 1.7908609f, 76.0f, 4.0f);
                j.lineTo(76.0f, 72.0f);
                j.cubicTo(76.0f, 74.20914f, 74.20914f, 76.0f, 72.0f, 76.0f);
                j.lineTo(4.0f, 76.0f);
                j.cubicTo(1.7908609f, 76.0f, 0.0f, 74.20914f, 0.0f, 72.0f);
                j.lineTo(0.0f, 4.0f);
                j.close();
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                i2 = c.a(i2, looper);
                i2.setColor(-5658199);
                float[] a2 = c.a(e, 1.0f, 0.0f, 13.0f, 0.0f, 1.0f, 12.0f);
                f.reset();
                f.setValues(a2);
                canvas.concat(f);
                canvas.save();
                Paint a3 = c.a(i2, looper);
                j = c.j(looper);
                j.moveTo(11.583784f, 5.263718f);
                j.cubicTo(15.113784f, 0.93371826f, 21.073784f, -0.28628173f, 26.403784f, 0.053718258f);
                j.cubicTo(31.023785f, 0.17371826f, 35.813786f, 1.9637183f, 38.623783f, 5.7737184f);
                j.cubicTo(42.543785f, 10.853719f, 43.273785f, 17.463718f, 43.843784f, 23.603718f);
                j.cubicTo(48.673782f, 27.943718f, 51.873783f, 35.12372f, 48.313786f, 41.25372f);
                j.cubicTo(46.263783f, 40.443718f, 45.183784f, 38.43372f, 43.783783f, 36.87372f);
                j.cubicTo(42.833782f, 39.27372f, 41.543785f, 41.52372f, 39.793785f, 43.443718f);
                j.cubicTo(42.843784f, 44.30372f, 47.663784f, 46.923717f, 45.073784f, 50.723717f);
                j.cubicTo(41.733784f, 53.063717f, 37.273785f, 52.57372f, 33.433784f, 52.193718f);
                j.cubicTo(30.393784f, 51.993717f, 27.863785f, 50.30372f, 25.473783f, 48.603718f);
                j.cubicTo(23.133783f, 48.543716f, 21.713783f, 51.02372f, 19.473783f, 51.493717f);
                j.cubicTo(15.313784f, 52.68372f, 10.753784f, 52.93372f, 6.563784f, 51.73372f);
                j.cubicTo(4.513784f, 51.353718f, 3.3337839f, 48.82372f, 4.403784f, 47.013718f);
                j.cubicTo(5.553784f, 44.93372f, 8.053783f, 44.353718f, 10.073784f, 43.473717f);
                j.cubicTo(8.263783f, 41.53372f, 6.953784f, 39.223717f, 6.013784f, 36.763718f);
                j.cubicTo(4.7137837f, 38.43372f, 3.5937839f, 40.423717f, 1.5337839f, 41.263718f);
                j.cubicTo(-2.066216f, 35.11372f, 1.1737839f, 27.883718f, 6.053784f, 23.563719f);
                j.cubicTo(6.563784f, 17.223719f, 7.323784f, 10.363718f, 11.583784f, 5.263718f);
                j.lineTo(11.583784f, 5.263718f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a3);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
