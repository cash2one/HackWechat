package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class qm extends c {
    private final int height = 98;
    private final int width = 98;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 98;
            case 1:
                return 98;
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
                i2 = c.a(i3, looper);
                i2.setStrokeWidth(1.0f);
                i2 = c.a(i2, looper);
                i2.setColor(-9012352);
                i2.setStrokeWidth(3.0f);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(25.636152f, 33.94453f);
                j.lineTo(47.514046f, 46.408054f);
                j.cubicTo(48.43459f, 46.932476f, 49.56348f, 46.932476f, 50.484028f, 46.408054f);
                j.lineTo(72.361916f, 33.94453f);
                j.cubicTo(73.80155f, 33.124393f, 74.30375f, 31.292488f, 73.48361f, 29.852856f);
                j.cubicTo(73.1879f, 29.333775f, 72.74394f, 28.9148f, 72.20862f, 28.649614f);
                j.lineTo(50.33073f, 17.811768f);
                j.cubicTo(49.491592f, 17.396078f, 48.506477f, 17.396078f, 47.667343f, 17.811768f);
                j.lineTo(25.78945f, 28.649614f);
                j.cubicTo(24.30478f, 29.385088f, 23.697437f, 31.184872f, 24.43291f, 32.66954f);
                j.cubicTo(24.698097f, 33.20486f, 25.117071f, 33.64882f, 25.636152f, 33.94453f);
                j.close();
                j.moveTo(51.5f, 54.065365f);
                j.lineTo(51.5f, 77.94596f);
                j.cubicTo(51.5f, 79.60281f, 52.843147f, 80.94596f, 54.5f, 80.94596f);
                j.cubicTo(55.0565f, 80.94596f, 55.602028f, 80.791176f, 56.075596f, 80.4989f);
                j.lineTo(77.0756f, 67.53834f);
                j.cubicTo(77.96095f, 66.99192f, 78.5f, 66.0258f, 78.5f, 64.9854f);
                j.lineTo(78.5f, 41.93013f);
                j.cubicTo(78.5f, 40.273277f, 77.15685f, 38.93013f, 75.5f, 38.93013f);
                j.cubicTo(74.97299f, 38.93013f, 74.45529f, 39.06896f, 73.99899f, 39.332638f);
                j.lineTo(52.998993f, 51.46787f);
                j.cubicTo(52.071358f, 52.00392f, 51.5f, 52.993984f, 51.5f, 54.065365f);
                j.close();
                j.moveTo(46.5f, 54.407204f);
                j.cubicTo(46.5f, 53.35098f, 45.944565f, 52.372574f, 45.037624f, 51.831215f);
                j.lineTo(24.037622f, 39.296185f);
                j.cubicTo(23.572733f, 39.01869f, 23.041412f, 38.872173f, 22.5f, 38.872173f);
                j.cubicTo(20.843145f, 38.872173f, 19.5f, 40.21532f, 19.5f, 41.872173f);
                j.lineTo(19.5f, 64.84526f);
                j.cubicTo(19.5f, 65.874146f, 20.027266f, 66.83126f, 20.896944f, 67.38104f);
                j.lineTo(41.896942f, 80.656685f);
                j.cubicTo(42.376633f, 80.95993f, 42.932495f, 81.1209f, 43.5f, 81.1209f);
                j.cubicTo(45.156853f, 81.1209f, 46.5f, 79.777756f, 46.5f, 78.1209f);
                j.lineTo(46.5f, 54.407204f);
                j.close();
                canvas.drawPath(j, a);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
