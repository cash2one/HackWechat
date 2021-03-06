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

public final class ot extends c {
    private final int height = 54;
    private final int width = 54;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 54;
            case 1:
                return 54;
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
                i2.setColor(-10658467);
                canvas.saveLayerAlpha(null, 51, 4);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(27.0f, 10.48036f);
                j.cubicTo(28.520756f, 7.5187073f, 31.927713f, 3.0f, 38.559685f, 3.0f);
                j.cubicTo(48.42443f, 3.0f, 55.286037f, 9.86097f, 53.796867f, 19.960094f);
                j.cubicTo(51.85492f, 31.37217f, 31.893957f, 47.352608f, 27.419691f, 51.072113f);
                j.cubicTo(27.187933f, 51.26478f, 26.997726f, 51.424545f, 26.853727f, 51.549076f);
                j.cubicTo(26.85368f, 51.566315f, 26.853643f, 51.58329f, 26.85362f, 51.6f);
                j.cubicTo(26.844093f, 51.591694f, 26.83434f, 51.583206f, 26.824354f, 51.574547f);
                j.cubicTo(26.819895f, 51.578423f, 26.815485f, 51.582264f, 26.811125f, 51.586067f);
                j.cubicTo(26.811113f, 51.57845f, 26.8111f, 51.570774f, 26.811085f, 51.563046f);
                j.cubicTo(23.89057f, 49.03434f, 2.2456808f, 31.963354f, 0.20313297f, 19.960094f);
                j.cubicTo(-1.2860388f, 9.86097f, 5.5755696f, 3.0f, 15.440317f, 3.0f);
                j.cubicTo(22.072287f, 3.0f, 25.479244f, 7.5187073f, 27.0f, 10.48036f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
