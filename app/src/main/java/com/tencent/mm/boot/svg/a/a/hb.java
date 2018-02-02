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

public final class hb extends c {
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
                j.moveTo(81.0f, 60.0f);
                j.lineTo(72.0f, 60.0f);
                j.lineTo(72.0f, 68.0f);
                j.lineTo(64.0f, 68.0f);
                j.lineTo(64.0f, 77.0f);
                j.lineTo(72.0f, 77.0f);
                j.lineTo(72.0f, 85.0f);
                j.lineTo(81.0f, 85.0f);
                j.lineTo(81.0f, 77.0f);
                j.lineTo(89.0f, 77.0f);
                j.lineTo(89.0f, 68.0f);
                j.lineTo(81.0f, 68.0f);
                j.lineTo(81.0f, 60.0f);
                j.close();
                j.moveTo(33.0f, 66.0f);
                j.lineTo(27.0f, 69.0f);
                j.lineTo(28.0f, 64.0f);
                j.cubicTo(20.127745f, 59.652744f, 15.2f, 52.282616f, 15.0f, 44.0f);
                j.cubicTo(15.2f, 30.296667f, 28.315445f, 19.235294f, 48.0f, 19.0f);
                j.cubicTo(67.684555f, 19.235294f, 80.8f, 30.296667f, 81.0f, 44.0f);
                j.cubicTo(80.8f, 46.829475f, 80.203674f, 49.600197f, 79.0f, 52.0f);
                j.lineTo(88.0f, 52.0f);
                j.cubicTo(88.59775f, 49.54438f, 89.0f, 46.78464f, 89.0f, 44.0f);
                j.cubicTo(89.0f, 25.74804f, 72.60592f, 11.0f, 48.0f, 11.0f);
                j.cubicTo(23.394077f, 11.0f, 7.0f, 25.74804f, 7.0f, 44.0f);
                j.cubicTo(7.0f, 53.683987f, 11.725022f, 62.435818f, 20.0f, 68.0f);
                j.lineTo(15.0f, 81.0f);
                j.lineTo(31.0f, 74.0f);
                j.cubicTo(36.047134f, 75.924774f, 41.76071f, 76.882355f, 48.0f, 77.0f);
                j.cubicTo(50.683678f, 76.882355f, 53.264854f, 76.696144f, 56.0f, 76.0f);
                j.lineTo(56.0f, 68.0f);
                j.cubicTo(53.296288f, 68.428825f, 50.71238f, 68.64706f, 48.0f, 69.0f);
                j.cubicTo(42.51602f, 68.64706f, 37.537712f, 67.78236f, 33.0f, 66.0f);
                j.lineTo(33.0f, 66.0f);
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
