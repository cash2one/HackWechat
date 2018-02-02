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

public final class ec extends c {
    private final int height = 50;
    private final int width = 50;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 50;
            case 1:
                return 50;
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
                e = c.a(e, 1.0f, 0.0f, -367.0f, 0.0f, 1.0f, -369.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 367.0f, 0.0f, 1.0f, 369.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(45.0f, 43.282814f);
                j.lineTo(29.594316f, 27.877132f);
                j.cubicTo(28.999725f, 27.28254f, 28.054962f, 27.287527f, 27.469177f, 27.873312f);
                j.cubicTo(26.879307f, 28.463182f, 26.8851f, 29.410557f, 27.472996f, 29.998453f);
                j.lineTo(43.474545f, 46.0f);
                j.lineTo(29.50325f, 46.0f);
                j.cubicTo(28.665436f, 46.0f, 28.0f, 46.671574f, 28.0f, 47.5f);
                j.cubicTo(28.0f, 48.3342f, 28.673029f, 49.0f, 29.50325f, 49.0f);
                j.lineTo(46.49675f, 49.0f);
                j.cubicTo(46.49729f, 49.0f, 46.497833f, 49.0f, 46.498375f, 49.0f);
                j.cubicTo(46.498917f, 49.0f, 46.49946f, 49.0f, 46.5f, 49.0f);
                j.cubicTo(46.916557f, 49.0f, 47.291122f, 48.83218f, 47.561768f, 48.560772f);
                j.cubicTo(47.834072f, 48.288242f, 48.0f, 47.913677f, 48.0f, 47.5f);
                j.cubicTo(48.0f, 47.49946f, 48.0f, 47.498917f, 48.0f, 47.498375f);
                j.cubicTo(48.0f, 47.497833f, 48.0f, 47.49729f, 48.0f, 47.49675f);
                j.lineTo(48.0f, 30.50325f);
                j.cubicTo(48.0f, 29.665436f, 47.328426f, 29.0f, 46.5f, 29.0f);
                j.cubicTo(45.6658f, 29.0f, 45.0f, 29.673029f, 45.0f, 30.50325f);
                j.lineTo(45.0f, 43.282814f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(3.0f, 5.3031335f);
                j.lineTo(18.595417f, 20.89855f);
                j.cubicTo(19.190008f, 21.493141f, 20.13477f, 21.488155f, 20.720556f, 20.902369f);
                j.cubicTo(21.310427f, 20.312498f, 21.304632f, 19.365126f, 20.716738f, 18.77723f);
                j.lineTo(4.939507f, 3.0f);
                j.lineTo(18.49675f, 3.0f);
                j.cubicTo(19.334564f, 3.0f, 20.0f, 2.328427f, 20.0f, DownloadHelper.SAVE_FATOR);
                j.cubicTo(20.0f, 0.66579723f, 19.326971f, 0.0f, 18.49675f, 0.0f);
                j.lineTo(1.5032506f, 0.0f);
                j.cubicTo(1.5027087f, 0.0f, 1.5021669f, 2.809642E-7f, 1.5016251f, 8.427533E-7f);
                j.cubicTo(1.5010837f, 2.840145E-7f, 1.5005419f, 0.0f, DownloadHelper.SAVE_FATOR, 0.0f);
                j.cubicTo(1.0863218f, 0.0f, 0.7117559f, 0.16592918f, 0.44039288f, 0.43639413f);
                j.cubicTo(0.16592893f, 0.71175647f, 0.0f, 1.0863222f, 0.0f, DownloadHelper.SAVE_FATOR);
                j.cubicTo(0.0f, 1.5005419f, 2.840145E-7f, 1.5010837f, 8.519021E-7f, 1.5016255f);
                j.cubicTo(2.809642E-7f, 1.5021669f, 0.0f, 1.5027087f, 0.0f, 1.5032506f);
                j.lineTo(0.0f, 18.49675f);
                j.cubicTo(0.0f, 19.326971f, 0.66579723f, 20.0f, DownloadHelper.SAVE_FATOR, 20.0f);
                j.cubicTo(2.328427f, 20.0f, 3.0f, 19.334564f, 3.0f, 18.49675f);
                j.lineTo(3.0f, 5.3031335f);
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
