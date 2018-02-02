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

public final class bu extends c {
    private final int height = 80;
    private final int width = 80;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 80;
            case 1:
                return 80;
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
                Paint a = c.a(i2, looper);
                a.setColor(-1);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 5.0f, 0.0f, 1.0f, 19.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                i2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(0.0f, 0.6294041f);
                j.lineTo(44.081802f, 0.6294054f);
                j.lineTo(44.081802f, 41.746845f);
                j.lineTo(0.0f, 41.74684f);
                j.lineTo(0.0f, 0.6294041f);
                j.close();
                j.moveTo(5.0f, 5.629404f);
                j.lineTo(39.0f, 5.6294045f);
                j.lineTo(39.0f, 36.629406f);
                j.lineTo(5.0f, 36.629402f);
                j.lineTo(5.0f, 5.629404f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, i2);
                canvas.restore();
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 47.88276f, 0.0f, 1.0f, 1.922839f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j2 = c.j(looper);
                j2.moveTo(17.238659f, 3.8456779f);
                j2.lineTo(21.276552f, 3.8456774f);
                j2.lineTo(21.276552f, 34.611103f);
                j2.lineTo(17.238659f, 34.611107f);
                j2.lineTo(17.238659f, 3.8456779f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j2 = c.j(looper);
                j2.moveTo(0.2687733f, 13.459874f);
                j2.lineTo(4.221509f, 13.459874f);
                j2.lineTo(4.221509f, 24.99691f);
                j2.lineTo(0.2687733f, 24.99691f);
                j2.lineTo(0.2687733f, 13.459874f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j2 = c.j(looper);
                j2.moveTo(0.0f, 13.459874f);
                j2.lineTo(21.388449f, 0.0f);
                j2.lineTo(21.388449f, 5.171436f);
                j2.lineTo(0.0f, 18.63131f);
                j2.lineTo(0.0f, 13.459874f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j2 = c.j(looper);
                j2.moveTo(21.388449f, 33.285347f);
                j2.lineTo(0.0f, 19.825474f);
                j2.lineTo(0.0f, 24.99691f);
                j2.lineTo(21.388449f, 38.456783f);
                j2.lineTo(21.388449f, 33.285347f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
