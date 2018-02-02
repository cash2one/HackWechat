package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.bc;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class aim extends c {
    private final int height = 60;
    private final int width = 60;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 60;
            case 1:
                return 60;
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
                float[] a = c.a(e, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 6.0f);
                f.reset();
                f.setValues(a);
                canvas.concat(f);
                Paint a2 = c.a(i2, looper);
                a2.setColor(-2236963);
                canvas.saveLayerAlpha(null, 222, 4);
                canvas.save();
                Paint a3 = c.a(a2, looper);
                Path j = c.j(looper);
                j.moveTo(13.408646f, 1.6899189f);
                j.cubicTo(22.319056f, -1.1299042f, 32.56653f, 5.027872f, 34.52223f, 14.085183f);
                j.cubicTo(36.098763f, 19.346195f, 33.48451f, 24.517532f, 30.890213f, 28.951529f);
                j.cubicTo(27.13846f, 35.01963f, 22.788025f, 40.71906f, 17.988577f, 46.0f);
                j.cubicTo(11.84209f, 39.005245f, 5.845274f, 31.601963f, 2.093522f, 23.012962f);
                j.cubicTo(-1.6183176f, 14.404033f, 4.607994f, 3.9318275f, 13.408646f, 1.6899189f);
                j.lineTo(13.408646f, 1.6899189f);
                j.close();
                j.moveTo(3.2691474f, 20.083824f);
                j.cubicTo(6.0192595f, 28.886927f, 12.3555975f, 35.91335f, 18.006926f, 43.0f);
                j.cubicTo(23.275455f, 36.49554f, 28.846195f, 29.981043f, 32.07984f, 22.171675f);
                j.cubicTo(35.4243f, 14.271968f, 29.178625f, 4.7963343f, 20.978659f, 3.3810122f);
                j.cubicTo(11.398599f, 0.9719528f, 1.2040452f, 10.397397f, 3.2691474f, 20.083824f);
                j.lineTo(3.2691474f, 20.083824f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a3);
                canvas.restore();
                canvas.restore();
                canvas.save();
                i2 = c.a(i2, looper);
                i2.setColor(-1907998);
                e = c.a(a, 1.0f, 0.0f, 9.0f, 0.0f, 1.0f, 8.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.saveLayerAlpha(null, bc.CTRL_BYTE, 4);
                canvas.save();
                Paint a4 = c.a(i2, looper);
                j = c.j(looper);
                j.moveTo(7.2950993f, 0.192574f);
                j.cubicTo(12.620774f, -1.0085815f, 18.16545f, 3.5875754f, 17.996222f, 9.017592f);
                j.cubicTo(18.175404f, 14.745417f, 11.923957f, 19.470623f, 6.448964f, 17.574585f);
                j.cubicTo(1.8499701f, 16.333721f, -1.0965714f, 11.032754f, 0.38665384f, 6.4961586f);
                j.cubicTo(1.2726072f, 3.309622f, 4.0598764f, 0.8378228f, 7.2950993f, 0.192574f);
                j.lineTo(7.2950993f, 0.192574f);
                j.close();
                j.moveTo(6.4085283f, 2.5550814f);
                j.cubicTo(1.6162406f, 4.3491087f, 0.31749043f, 11.2947f, 4.586251f, 14.351562f);
                j.cubicTo(8.462366f, 18.069908f, 15.227949f, 15.013046f, 15.912561f, 10.001798f);
                j.cubicTo(16.778395f, 5.100796f, 11.039731f, 0.35013187f, 6.4085283f, 2.5550814f);
                j.lineTo(6.4085283f, 2.5550814f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a4);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
