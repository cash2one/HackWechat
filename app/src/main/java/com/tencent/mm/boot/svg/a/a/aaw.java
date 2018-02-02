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

public final class aaw extends c {
    private final int height = 84;
    private final int width = 96;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 84;
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
                e = c.a(e, 1.0f, 0.0f, -663.0f, 0.0f, 1.0f, -151.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 673.0f, 0.0f, 1.0f, 155.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                Path j = c.j(looper);
                j.moveTo(0.0024212555f, 0.0f);
                j.lineTo(76.00242f, 0.0f);
                j.lineTo(76.00242f, 76.0f);
                j.lineTo(0.0024212555f, 76.0f);
                j.lineTo(0.0024212555f, 0.0f);
                j.close();
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-15028967);
                j = c.j(looper);
                j.moveTo(36.825302f, 4.0206747f);
                j.cubicTo(41.6383f, 3.852675f, 46.4883f, 4.709675f, 50.9403f, 6.549675f);
                j.cubicTo(57.4393f, 9.213675f, 63.0573f, 13.956675f, 66.7893f, 19.905674f);
                j.cubicTo(68.8923f, 23.240675f, 70.4073f, 26.946674f, 71.2353f, 30.802675f);
                j.cubicTo(72.808304f, 38.059673f, 71.9403f, 45.829674f, 68.7423f, 52.537674f);
                j.cubicTo(65.9823f, 58.382675f, 61.5123f, 63.402676f, 56.0303f, 66.827675f);
                j.cubicTo(53.1813f, 68.61468f, 50.0643f, 69.97468f, 46.8153f, 70.842674f);
                j.cubicTo(38.9413f, 72.965675f, 30.3073f, 72.14468f, 22.9983f, 68.51668f);
                j.cubicTo(16.084301f, 65.13068f, 10.397301f, 59.319675f, 7.1633005f, 52.333675f);
                j.cubicTo(3.6933002f, 44.936676f, 3.0593002f, 36.271675f, 5.3653f, 28.438675f);
                j.cubicTo(7.4403005f, 21.280674f, 11.970301f, 14.876675f, 18.0003f, 10.502675f);
                j.cubicTo(23.438301f, 6.5206747f, 30.0883f, 4.2306747f, 36.825302f, 4.0206747f);
                j.lineTo(36.825302f, 4.0206747f);
                j.close();
                j.moveTo(35.6533f, 8.090675f);
                j.cubicTo(31.3123f, 8.420675f, 27.049301f, 9.718675f, 23.2623f, 11.863675f);
                j.cubicTo(17.8743f, 14.898675f, 13.4673f, 19.638676f, 10.8433f, 25.238674f);
                j.cubicTo(8.2583f, 30.696674f, 7.4153004f, 36.946674f, 8.4003f, 42.900677f);
                j.cubicTo(9.0273f, 46.732674f, 10.416301f, 50.437675f, 12.458301f, 53.740673f);
                j.cubicTo(15.772301f, 59.125675f, 20.8293f, 63.417675f, 26.6913f, 65.79267f);
                j.cubicTo(33.6343f, 68.64168f, 41.6543f, 68.730675f, 48.6623f, 66.047676f);
                j.cubicTo(51.8833f, 64.82368f, 54.8873f, 63.034676f, 57.5043f, 60.792675f);
                j.cubicTo(62.1973f, 56.787674f, 65.6133f, 51.304676f, 67.1013f, 45.313675f);
                j.cubicTo(68.1643f, 41.069675f, 68.2833f, 36.592674f, 67.4573f, 32.295673f);
                j.cubicTo(66.7423f, 28.557674f, 65.2953f, 24.963675f, 63.2323f, 21.766674f);
                j.cubicTo(59.9473f, 16.654675f, 55.0763f, 12.578675f, 49.4563f, 10.265675f);
                j.cubicTo(45.1123f, 8.461675f, 40.339302f, 7.723675f, 35.6533f, 8.090675f);
                j.lineTo(35.6533f, 8.090675f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                a = c.a(i2, looper);
                a.setColor(-15028967);
                j = c.j(looper);
                j.moveTo(33.536423f, 30.936f);
                j.cubicTo(40.75542f, 27.29f, 47.97542f, 23.644f, 55.195423f, 20.0f);
                j.cubicTo(51.53342f, 27.263f, 47.86542f, 34.522f, 44.19842f, 41.783f);
                j.cubicTo(43.40242f, 43.327f, 42.084423f, 44.591f, 40.516422f, 45.334f);
                j.cubicTo(33.34542f, 48.957f, 26.16842f, 52.568f, 19.00242f, 56.198f);
                j.cubicTo(22.659422f, 48.952f, 26.316422f, 41.706f, 29.973421f, 34.461f);
                j.cubicTo(30.743422f, 32.945f, 32.01342f, 31.691f, 33.536423f, 30.936f);
                j.lineTo(33.536423f, 30.936f);
                j.close();
                j.moveTo(36.44442f, 35.171f);
                j.cubicTo(34.96342f, 35.471f, 33.88542f, 37.01f, 34.126423f, 38.505f);
                j.cubicTo(34.30442f, 40.13f, 35.987423f, 41.376f, 37.59442f, 41.056f);
                j.cubicTo(39.22142f, 40.828f, 40.412422f, 39.095f, 40.03442f, 37.494f);
                j.cubicTo(39.74942f, 35.898f, 38.01742f, 34.778f, 36.44442f, 35.171f);
                j.lineTo(36.44442f, 35.171f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
