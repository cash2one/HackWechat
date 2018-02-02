package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiInstallDownloadTask;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class vd extends c {
    private final int height = 384;
    private final int width = JsApiInstallDownloadTask.CTRL_INDEX;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return JsApiInstallDownloadTask.CTRL_INDEX;
            case 1:
                return 384;
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
                e = c.a(e, 1.0f, 0.0f, -638.0f, 0.0f, 1.0f, 0.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                Paint a = c.a(i2, looper);
                a.setColor(-1);
                canvas.save();
                a = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(0.0f, 0.0f);
                j.lineTo(1080.0f, 0.0f);
                j.lineTo(1080.0f, 384.0f);
                j.lineTo(0.0f, 384.0f);
                j.lineTo(0.0f, 0.0f);
                j.close();
                canvas.drawPath(j, a);
                canvas.restore();
                Paint a2 = c.a(i2, looper);
                a2.setColor(WebView.NIGHT_MODE_COLOR);
                Path j2 = c.j(looper);
                j2.moveTo(700.6798f, 213.73169f);
                j2.cubicTo(697.973f, 173.42755f, 710.4088f, 134.17123f, 738.70874f, 105.26089f);
                j2.cubicTo(796.09906f, 46.63267f, 896.9981f, 52.75353f, 964.07306f, 118.932205f);
                j2.cubicTo(1031.1481f, 185.11089f, 1038.999f, 286.28687f, 981.6087f, 344.91507f);
                j2.cubicTo(950.7191f, 376.47092f, 907.22516f, 389.26904f, 863.185f, 384.04095f);
                j2.cubicTo(858.7008f, 393.6198f, 852.6391f, 402.50076f, 844.97217f, 410.33347f);
                j2.cubicTo(803.2441f, 452.9637f, 729.76733f, 448.40085f, 680.8573f, 400.142f);
                j2.cubicTo(631.94727f, 351.88315f, 626.1251f, 278.20294f, 667.8532f, 235.5727f);
                j2.cubicTo(677.36743f, 225.85278f, 688.53217f, 218.58626f, 700.6798f, 213.73169f);
                j2.close();
                j2.moveTo(700.6798f, 213.73169f);
                j2.cubicTo(703.4623f, 255.16158f, 722.245f, 297.69867f, 756.2444f, 331.24374f);
                j2.cubicTo(787.21716f, 361.80264f, 825.4021f, 379.55566f, 863.185f, 384.04095f);
                j2.cubicTo(883.1062f, 341.486f, 871.8916f, 285.15613f, 831.9681f, 245.76416f);
                j2.cubicTo(794.2098f, 208.50858f, 741.8103f, 197.29474f, 700.6798f, 213.73169f);
                j2.close();
                canvas.saveLayerAlpha(null, 7, 4);
                i3 = c.a(a2, looper);
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, i3);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
