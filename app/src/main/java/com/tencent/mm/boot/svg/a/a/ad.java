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

public final class ad extends c {
    private final int height = 96;
    private final int width = 96;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
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
                a.setColor(-1);
                e = c.a(e, 1.0f, 0.0f, 14.0f, 0.0f, 1.0f, 27.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(2.3958402f, 1.5091976f);
                j.cubicTo(3.783774f, 0.71045625f, 5.511202f, 1.1397798f, 7.0389276f, 1.0f);
                j.cubicTo(20.049559f, 1.0898584f, 33.06019f, 0.9301101f, 46.060833f, 1.0698899f);
                j.cubicTo(48.067844f, 0.95007867f, 49.24609f, 3.1366334f, 48.95652f, 4.913833f);
                j.cubicTo(48.93655f, 15.956433f, 49.046387f, 27.009018f, 48.906597f, 38.061604f);
                j.cubicTo(48.97649f, 40.038486f, 46.8896f, 41.276535f, 45.08229f, 40.947056f);
                j.cubicTo(31.3727f, 40.927086f, 17.66311f, 41.026928f, 3.953521f, 40.90712f);
                j.cubicTo(1.9564942f, 41.026928f, 0.73830783f, 38.890297f, 1.047847f, 37.09313f);
                j.cubicTo(1.0079064f, 26.719473f, 1.0678172f, 16.335835f, 1.0178915f, 5.9521966f);
                j.cubicTo(1.0678172f, 4.4046354f, 0.82817405f, 2.4277503f, 2.3958402f, 1.5091976f);
                j.lineTo(2.3958402f, 1.5091976f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(52.01634f, 14.457662f);
                j.cubicTo(57.03326f, 10.022178f, 61.740986f, 5.203629f, 66.96736f, 1.0f);
                j.cubicTo(68.35375f, 3.0665324f, 67.924866f, 5.6169353f, 67.97474f, 7.955645f);
                j.cubicTo(67.94482f, 17.713709f, 67.97474f, 27.471775f, 67.97474f, 37.22984f);
                j.cubicTo(68.01463f, 38.590725f, 67.675514f, 39.840725f, 66.95739f, 41.0f);
                j.cubicTo(61.731014f, 36.836693f, 57.08313f, 31.997984f, 52.036285f, 27.612904f);
                j.cubicTo(51.97644f, 23.227823f, 52.006363f, 18.842741f, 52.01634f, 14.457662f);
                j.lineTo(52.01634f, 14.457662f);
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
