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

public final class pq extends c {
    private final int height = 72;
    private final int width = 72;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 72;
            case 1:
                return 72;
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
                a.setColor(-6710887);
                e = c.a(e, 1.0f, 0.0f, 5.0f, 0.0f, 1.0f, 5.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(28.262707f, 1.3849335f);
                j.cubicTo(30.334364f, 1.0462617f, 33.47173f, 0.32907447f, 34.716717f, 2.5503626f);
                j.cubicTo(35.872063f, 4.8114944f, 36.240578f, 7.3614936f, 36.88797f, 9.801922f);
                j.cubicTo(38.541313f, 10.479266f, 40.184692f, 11.176531f, 41.828075f, 11.873796f);
                j.cubicTo(43.92961f, 10.618719f, 45.95147f, 9.194305f, 48.242245f, 8.317743f);
                j.cubicTo(50.682415f, 7.3814154f, 52.295918f, 10.021063f, 53.670383f, 11.574968f);
                j.cubicTo(54.367577f, 14.832193f, 51.479206f, 17.46188f, 50.144585f, 20.201138f);
                j.cubicTo(50.831814f, 21.84469f, 51.509087f, 23.498205f, 52.20628f, 25.15172f);
                j.cubicTo(55.48308f, 26.20758f, 61.608414f, 26.078087f, 60.95106f, 31.008749f);
                j.cubicTo(61.588493f, 35.92945f, 55.47312f, 35.789997f, 52.19632f, 36.85582f);
                j.cubicTo(51.529007f, 38.509335f, 50.841774f, 40.16285f, 50.144585f, 41.8064f);
                j.cubicTo(51.39953f, 43.93804f, 52.863632f, 45.989994f, 53.720184f, 48.320854f);
                j.cubicTo(54.516975f, 50.900734f, 51.718246f, 52.594093f, 49.965305f, 53.908936f);
                j.cubicTo(46.86778f, 53.799366f, 44.437565f, 51.548195f, 41.838036f, 50.133743f);
                j.cubicTo(40.174732f, 50.83101f, 38.511433f, 51.538235f, 36.838173f, 52.215576f);
                j.cubicTo(35.98162f, 55.034523f, 35.95174f, 58.421238f, 33.730686f, 60.602684f);
                j.cubicTo(31.659029f, 60.961277f, 28.531624f, 61.668503f, 27.276678f, 59.447216f);
                j.cubicTo(26.12133f, 57.196045f, 25.782694f, 54.646046f, 25.145262f, 52.215576f);
                j.cubicTo(23.472f, 51.538235f, 21.808699f, 50.83101f, 20.135437f, 50.133743f);
                j.cubicTo(18.053822f, 51.38882f, 16.022003f, 52.813232f, 13.73123f, 53.679836f);
                j.cubicTo(11.291057f, 54.61616f, 9.677555f, 51.956593f, 8.31305f, 50.402687f);
                j.cubicTo(7.6158576f, 47.145462f, 10.524145f, 44.535698f, 11.838851f, 41.79644f);
                j.cubicTo(11.141658f, 40.152885f, 10.464386f, 38.509335f, 9.787113f, 36.85582f);
                j.cubicTo(6.958505f, 35.989216f, 3.5821028f, 35.94937f, 1.3809674f, 33.75797f);
                j.cubicTo(0.9726119f, 31.516758f, 0.30529934f, 28.01051f, 3.034309f, 27.014416f);
                j.cubicTo(5.2055645f, 26.127893f, 7.5162587f, 25.709534f, 9.787113f, 25.15172f);
                j.cubicTo(10.454426f, 23.488245f, 11.141658f, 21.84469f, 11.838851f, 20.191175f);
                j.cubicTo(10.593864f, 18.069498f, 9.139721f, 16.037466f, 8.273211f, 13.716569f);
                j.cubicTo(7.42662f, 11.27614f, 10.046071f, 9.662469f, 11.609773f, 8.297821f);
                j.cubicTo(14.836777f, 7.7001653f, 17.436308f, 10.529071f, 20.145397f, 11.873796f);
                j.cubicTo(21.78878f, 11.176531f, 23.442122f, 10.479266f, 25.095463f, 9.801922f);
                j.cubicTo(25.961973f, 6.963056f, 26.031693f, 3.5763388f, 28.262707f, 1.3849335f);
                j.lineTo(28.262707f, 1.3849335f);
                j.close();
                j.moveTo(27.355852f, 18.576183f);
                j.cubicTo(20.938553f, 20.263443f, 16.71691f, 27.431799f, 18.35367f, 33.88132f);
                j.cubicTo(19.661081f, 40.330845f, 26.45763f, 44.973305f, 32.94479f, 43.82517f);
                j.cubicTo(39.8112f, 42.966564f, 45.040848f, 35.918015f, 43.823257f, 29.089108f);
                j.cubicTo(42.944996f, 21.561335f, 34.57157f, 16.180077f, 27.355852f, 18.576183f);
                j.lineTo(27.355852f, 18.576183f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
