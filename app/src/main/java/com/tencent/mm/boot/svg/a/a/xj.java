package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class xj extends c {
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
                i2 = c.a(i2, looper);
                i2.setColor(-8617851);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(58.944443f, 58.17809f);
                j.lineTo(58.944443f, 57.333332f);
                j.cubicTo(58.944443f, 56.21663f, 57.851852f, 55.137257f, 57.923233f, 55.137257f);
                j.cubicTo(54.02851f, 51.314743f, 51.494057f, 45.915337f, 51.494057f, 37.300488f);
                j.cubicTo(51.48578f, 27.372776f, 56.851036f, 20.0f, 65.5f, 20.0f);
                j.cubicTo(74.148964f, 20.0f, 79.52899f, 27.370667f, 79.53726f, 37.300488f);
                j.cubicTo(79.54445f, 45.9168f, 76.98692f, 51.330833f, 73.14815f, 55.137257f);
                j.cubicTo(73.14815f, 55.137257f, 72.05556f, 56.21663f, 72.05556f, 57.333332f);
                j.lineTo(72.05556f, 58.431374f);
                j.cubicTo(72.05556f, 59.335876f, 72.7224f, 59.935307f, 73.88674f, 60.627453f);
                j.cubicTo(75.05109f, 61.319595f, 85.62963f, 66.500496f, 85.62963f, 66.500496f);
                j.cubicTo(88.17391f, 67.40601f, 90.0f, 69.83854f, 90.0f, 72.70588f);
                j.lineTo(90.0f, 76.0f);
                j.lineTo(62.587566f, 76.0f);
                j.cubicTo(62.587566f, 76.78842f, 62.587566f, 75.32884f, 62.587566f, 72.70669f);
                j.cubicTo(62.587566f, 69.52989f, 61.461308f, 66.85559f, 59.701096f, 64.777214f);
                j.cubicTo(59.696297f, 64.76989f, 59.691f, 64.76228f, 59.68521f, 64.75441f);
                j.cubicTo(59.225693f, 64.12954f, 58.979626f, 63.455254f, 58.947006f, 62.731556f);
                j.lineTo(58.947006f, 58.176933f);
                j.lineTo(58.944443f, 58.17809f);
                j.close();
                j.moveTo(38.88674f, 60.627453f);
                j.cubicTo(40.051086f, 61.319595f, 47.968254f, 65.0638f, 50.62963f, 66.500496f);
                j.cubicTo(53.291004f, 67.937195f, 55.0f, 69.83854f, 55.0f, 72.70588f);
                j.lineTo(55.0f, 76.0f);
                j.lineTo(6.0f, 76.0f);
                j.lineTo(6.0f, 72.70588f);
                j.cubicTo(6.0f, 69.83854f, 8.610812f, 67.51598f, 10.370371f, 66.48366f);
                j.cubicTo(12.129929f, 65.45134f, 16.263937f, 63.62631f, 22.113258f, 60.627453f);
                j.cubicTo(22.749458f, 60.29427f, 23.944445f, 59.65627f, 23.944445f, 58.431374f);
                j.lineTo(23.944445f, 57.333332f);
                j.cubicTo(23.944445f, 56.21663f, 22.851852f, 55.137257f, 22.923235f, 55.137257f);
                j.cubicTo(19.02851f, 51.314743f, 16.494055f, 45.915337f, 16.494055f, 37.300488f);
                j.cubicTo(16.485779f, 27.372776f, 21.851036f, 20.0f, 30.5f, 20.0f);
                j.cubicTo(39.148964f, 20.0f, 44.528988f, 27.370667f, 44.537266f, 37.300488f);
                j.cubicTo(44.54445f, 45.9168f, 41.986927f, 51.330833f, 38.148148f, 55.137257f);
                j.cubicTo(38.148148f, 55.137257f, 37.055557f, 56.21663f, 37.055557f, 57.333332f);
                j.lineTo(37.055557f, 58.431374f);
                j.cubicTo(37.055557f, 59.625034f, 37.722397f, 59.935307f, 38.88674f, 60.627453f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
