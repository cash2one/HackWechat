package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.map.e;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class dt extends c {
    private final int height = e.CTRL_INDEX;
    private final int width = e.CTRL_INDEX;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return e.CTRL_INDEX;
            case 1:
                return e.CTRL_INDEX;
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
                i3 = c.a(i2, looper);
                i3.setColor(-2565928);
                Path j = c.j(looper);
                j.moveTo(0.0f, 0.0f);
                j.lineTo(144.0f, 0.0f);
                j.lineTo(144.0f, 144.0f);
                j.lineTo(0.0f, 144.0f);
                j.lineTo(0.0f, 0.0f);
                j.close();
                canvas.saveLayerAlpha(null, 0, 4);
                canvas.drawPath(j, c.a(i3, looper));
                canvas.restore();
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-1);
                Path j2 = c.j(looper);
                j2.moveTo(72.0f, 102.0f);
                j2.cubicTo(55.431458f, 102.0f, 42.0f, 88.56854f, 42.0f, 72.0f);
                j2.cubicTo(42.0f, 55.431458f, 55.431458f, 42.0f, 72.0f, 42.0f);
                j2.cubicTo(88.56854f, 42.0f, 102.0f, 55.431458f, 102.0f, 72.0f);
                j2.cubicTo(102.0f, 88.56854f, 88.56854f, 102.0f, 72.0f, 102.0f);
                j2.close();
                j2.moveTo(72.0f, 96.0f);
                j2.cubicTo(85.25484f, 96.0f, 96.0f, 85.25484f, 96.0f, 72.0f);
                j2.cubicTo(96.0f, 58.745167f, 85.25484f, 48.0f, 72.0f, 48.0f);
                j2.cubicTo(72.0f, 64.35864f, 72.0f, 82.30664f, 72.0f, 96.0f);
                j2.close();
                j2.moveTo(3.0f, 69.0f);
                j2.lineTo(30.0f, 69.0f);
                j2.lineTo(30.0f, 75.0f);
                j2.lineTo(3.0f, 75.0f);
                j2.lineTo(3.0f, 69.0f);
                j2.close();
                j2.moveTo(69.0f, 3.0f);
                j2.lineTo(75.0f, 3.0f);
                j2.lineTo(75.0f, 30.0f);
                j2.lineTo(69.0f, 30.0f);
                j2.lineTo(69.0f, 3.0f);
                j2.close();
                j2.moveTo(69.0f, 114.0f);
                j2.lineTo(75.0f, 114.0f);
                j2.lineTo(75.0f, 141.0f);
                j2.lineTo(69.0f, 141.0f);
                j2.lineTo(69.0f, 114.0f);
                j2.close();
                j2.moveTo(114.0f, 69.0f);
                j2.lineTo(141.0f, 69.0f);
                j2.lineTo(141.0f, 75.0f);
                j2.lineTo(114.0f, 75.0f);
                j2.lineTo(114.0f, 69.0f);
                j2.close();
                j2.moveTo(25.330952f, 21.088312f);
                j2.lineTo(44.422836f, 40.180195f);
                j2.lineTo(40.180195f, 44.422836f);
                j2.lineTo(21.088312f, 25.330952f);
                j2.lineTo(25.330952f, 21.088312f);
                j2.close();
                j2.moveTo(118.669044f, 21.088312f);
                j2.lineTo(122.91169f, 25.330952f);
                j2.lineTo(103.8198f, 44.422836f);
                j2.lineTo(99.57716f, 40.180195f);
                j2.lineTo(118.669044f, 21.088312f);
                j2.close();
                j2.moveTo(40.180195f, 99.57716f);
                j2.lineTo(44.422836f, 103.8198f);
                j2.lineTo(25.330952f, 122.91169f);
                j2.lineTo(21.088312f, 118.669044f);
                j2.lineTo(40.180195f, 99.57716f);
                j2.close();
                j2.moveTo(103.8198f, 99.57716f);
                j2.lineTo(122.91169f, 118.669044f);
                j2.lineTo(118.669044f, 122.91169f);
                j2.lineTo(99.57716f, 103.8198f);
                j2.lineTo(103.8198f, 99.57716f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, a);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
