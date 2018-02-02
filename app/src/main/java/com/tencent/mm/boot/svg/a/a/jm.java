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
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;

public final class jm extends c {
    private final int height = 69;
    private final int width = 69;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 69;
            case 1:
                return 69;
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
                Paint a = c.a(i3, looper);
                a.setStrokeWidth(1.0f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, -66.0f, 0.0f, 1.0f, -459.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 72.0f, 0.0f, 1.0f, 465.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                a2.setColor(-1);
                a2.setStrokeWidth(3.0f);
                Path j = c.j(looper);
                j.moveTo(28.5f, DownloadHelper.SAVE_FATOR);
                j.cubicTo(43.41169f, DownloadHelper.SAVE_FATOR, 55.5f, 13.588311f, 55.5f, 28.5f);
                j.cubicTo(55.5f, 43.41169f, 43.41169f, 55.5f, 28.5f, 55.5f);
                j.cubicTo(13.588311f, 55.5f, DownloadHelper.SAVE_FATOR, 43.41169f, DownloadHelper.SAVE_FATOR, 28.5f);
                j.cubicTo(DownloadHelper.SAVE_FATOR, 13.588311f, 13.588311f, DownloadHelper.SAVE_FATOR, 28.5f, DownloadHelper.SAVE_FATOR);
                j.close();
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(i2, looper);
                a2.setColor(-1);
                j = c.j(looper);
                j.moveTo(39.81111f, 30.250793f);
                j.lineTo(23.24421f, 39.717594f);
                j.lineTo(23.24421f, 39.717594f);
                j.cubicTo(22.524933f, 40.12861f, 21.60865f, 39.878716f, 21.197636f, 39.15944f);
                j.cubicTo(21.068123f, 38.932793f, 21.0f, 38.67627f, 21.0f, 38.41523f);
                j.lineTo(21.0f, 18.692726f);
                j.lineTo(21.0f, 18.692726f);
                j.cubicTo(21.0f, 17.8643f, 21.671574f, 17.192726f, 22.5f, 17.192726f);
                j.cubicTo(22.778942f, 17.192726f, 23.052357f, 17.270508f, 23.289532f, 17.41733f);
                j.lineTo(39.856434f, 27.67303f);
                j.lineTo(39.856434f, 27.67303f);
                j.cubicTo(40.560818f, 28.109077f, 40.778347f, 29.033579f, 40.3423f, 29.73796f);
                j.cubicTo(40.21073f, 29.950493f, 40.028137f, 30.126778f, 39.81111f, 30.250793f);
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
