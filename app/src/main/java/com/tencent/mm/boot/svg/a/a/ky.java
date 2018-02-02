package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.map.h;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;

public final class ky extends c {
    private final int height = h.CTRL_INDEX;
    private final int width = h.CTRL_INDEX;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return h.CTRL_INDEX;
            case 1:
                return h.CTRL_INDEX;
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
                i3 = c.a(i2, looper);
                i3.setColor(-921103);
                Path j = c.j(looper);
                j.moveTo(0.0f, 0.0f);
                j.lineTo(136.0f, 0.0f);
                j.lineTo(136.0f, 136.0f);
                j.lineTo(0.0f, 136.0f);
                j.lineTo(0.0f, 0.0f);
                j.close();
                canvas.drawPath(j, i3);
                canvas.restore();
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 34.0f, 0.0f, 1.0f, 42.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                a2.setColor(-3552823);
                a2.setStrokeWidth(3.0f);
                Path j2 = c.j(looper);
                j2.moveTo(DownloadHelper.SAVE_FATOR, 6.0f);
                j2.cubicTo(DownloadHelper.SAVE_FATOR, 3.5147185f, 3.5147185f, DownloadHelper.SAVE_FATOR, 6.0f, DownloadHelper.SAVE_FATOR);
                j2.lineTo(63.0f, DownloadHelper.SAVE_FATOR);
                j2.cubicTo(65.48528f, DownloadHelper.SAVE_FATOR, 67.5f, 3.5147185f, 67.5f, 6.0f);
                j2.lineTo(67.5f, 47.0f);
                j2.cubicTo(67.5f, 49.485283f, 65.48528f, 51.5f, 63.0f, 51.5f);
                j2.lineTo(6.0f, 51.5f);
                j2.cubicTo(3.5147185f, 51.5f, DownloadHelper.SAVE_FATOR, 49.485283f, DownloadHelper.SAVE_FATOR, 47.0f);
                j2.lineTo(DownloadHelper.SAVE_FATOR, 6.0f);
                j2.close();
                canvas.drawPath(j2, a2);
                canvas.restore();
                canvas.save();
                Paint a3 = c.a(i2, looper);
                a3.setColor(-3552823);
                Path j3 = c.j(looper);
                j3.moveTo(2.0f, 40.47622f);
                j3.lineTo(23.9226f, 20.0f);
                j3.lineTo(48.016544f, 43.06765f);
                j3.lineTo(44.84195f, 35.311966f);
                j3.lineTo(54.734417f, 27.538553f);
                j3.lineTo(68.0f, 40.47622f);
                j3.lineTo(68.0f, 50.245495f);
                j3.lineTo(2.0f, 50.245495f);
                j3.close();
                WeChatSVGRenderC2Java.setFillType(j3, 1);
                WeChatSVGRenderC2Java.setFillType(j3, 2);
                canvas.drawPath(j3, a3);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
