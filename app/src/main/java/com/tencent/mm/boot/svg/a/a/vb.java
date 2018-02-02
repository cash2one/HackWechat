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

public final class vb extends c {
    private final int height = 224;
    private final int width = 641;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 641;
            case 1:
                return 224;
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
                a.setColor(-4934476);
                e = c.a(e, 1.0f, 0.0f, -43.0f, 0.0f, 1.0f, -363.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 43.0f, 0.0f, 1.0f, 347.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                float[] a2 = c.a(e, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 15.0f);
                f.reset();
                f.setValues(a2);
                canvas.concat(f);
                canvas.save();
                Paint a3 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(491.8881f, 224.8092f);
                j.lineTo(498.2307f, 222.9777f);
                j.cubicTo(477.1635f, 149.9817f, 409.3254f, 99.0f, 333.267f, 99.0f);
                j.cubicTo(257.2053f, 99.0f, 189.3705f, 149.985f, 168.3f, 222.9876f);
                j.lineTo(174.6426f, 224.8158f);
                j.cubicTo(179.7048f, 207.2664f, 187.5819f, 191.0436f, 197.6898f, 176.5731f);
                j.cubicTo(207.5733f, 180.9225f, 219.1464f, 184.7307f, 232.0197f, 187.9152f);
                j.cubicTo(227.9079f, 198.9702f, 224.565f, 210.7908f, 222.1626f, 223.2747f);
                j.lineTo(228.6471f, 224.5221f);
                j.cubicTo(231.033f, 212.1141f, 234.366f, 200.3826f, 238.4745f, 189.453f);
                j.cubicTo(265.3233f, 195.4755f, 297.0627f, 198.891f, 329.967f, 199.1088f);
                j.lineTo(329.967f, 223.905f);
                j.lineTo(336.567f, 223.905f);
                j.lineTo(336.567f, 199.1088f);
                j.cubicTo(369.468f, 198.891f, 401.2107f, 195.4755f, 428.0595f, 189.453f);
                j.cubicTo(432.168f, 200.3826f, 435.501f, 212.1141f, 437.8869f, 224.5221f);
                j.lineTo(444.3714f, 223.2747f);
                j.cubicTo(441.969f, 210.7908f, 438.6261f, 198.9702f, 434.5143f, 187.9152f);
                j.cubicTo(447.3876f, 184.7307f, 458.9607f, 180.9225f, 468.8442f, 176.5731f);
                j.cubicTo(478.9521f, 191.0403f, 486.8259f, 207.2631f, 491.8881f, 224.8092f);
                j.lineTo(491.8881f, 224.8092f);
                j.close();
                j.moveTo(415.6878f, 127.8288f);
                j.cubicTo(410.8467f, 129.2082f, 405.8901f, 130.4622f, 400.8246f, 131.5875f);
                j.cubicTo(393.1818f, 123.4035f, 384.879f, 116.5857f, 376.0779f, 111.3387f);
                j.cubicTo(390.0204f, 115.1238f, 403.3326f, 120.681f, 415.6878f, 127.8288f);
                j.lineTo(415.6878f, 127.8288f);
                j.close();
                j.moveTo(329.967f, 138.6957f);
                j.cubicTo(310.4145f, 138.5043f, 291.2712f, 136.6299f, 273.2796f, 133.1583f);
                j.cubicTo(289.8324f, 116.5494f, 309.3717f, 106.6626f, 329.967f, 105.7023f);
                j.lineTo(329.967f, 138.6957f);
                j.lineTo(329.967f, 138.6957f);
                j.close();
                j.moveTo(336.567f, 105.7023f);
                j.cubicTo(357.1656f, 106.6626f, 376.7082f, 116.5527f, 393.2643f, 133.1682f);
                j.cubicTo(375.276f, 136.6398f, 356.1294f, 138.5043f, 336.567f, 138.6957f);
                j.lineTo(336.567f, 105.7023f);
                j.lineTo(336.567f, 105.7023f);
                j.close();
                j.moveTo(265.7028f, 131.5974f);
                j.cubicTo(260.634f, 130.4721f, 255.6972f, 129.2016f, 250.8627f, 127.8189f);
                j.cubicTo(263.2113f, 120.6744f, 276.5202f, 115.1205f, 290.4561f, 111.3387f);
                j.cubicTo(281.6517f, 116.589f, 273.3423f, 123.4101f, 265.7028f, 131.5974f);
                j.lineTo(265.7028f, 131.5974f);
                j.close();
                j.moveTo(201.6762f, 171.1149f);
                j.cubicTo(213.2592f, 155.9019f, 227.3997f, 142.8504f, 243.3288f, 132.4719f);
                j.cubicTo(248.9586f, 134.2275f, 254.7666f, 135.8082f, 260.7264f, 137.214f);
                j.cubicTo(250.3677f, 149.6088f, 241.4412f, 164.6436f, 234.4386f, 181.7244f);
                j.cubicTo(222.1989f, 178.7346f, 211.1571f, 175.1739f, 201.6762f, 171.1149f);
                j.lineTo(201.6762f, 171.1149f);
                j.close();
                j.moveTo(240.9231f, 183.249f);
                j.cubicTo(248.1039f, 165.9636f, 257.3076f, 150.9123f, 267.9666f, 138.798f);
                j.cubicTo(287.5422f, 142.8702f, 308.5203f, 145.0878f, 329.967f, 145.2957f);
                j.lineTo(329.967f, 192.5088f);
                j.cubicTo(297.9141f, 192.2943f, 267.0492f, 189.0174f, 240.9231f, 183.249f);
                j.lineTo(240.9231f, 183.249f);
                j.close();
                j.moveTo(336.567f, 192.5088f);
                j.lineTo(336.567f, 145.2924f);
                j.cubicTo(358.0302f, 145.0878f, 378.9951f, 142.8702f, 398.5674f, 138.798f);
                j.cubicTo(409.2264f, 150.9123f, 418.4301f, 165.9603f, 425.6109f, 183.2457f);
                j.cubicTo(399.4815f, 189.0174f, 368.6199f, 192.2943f, 336.567f, 192.5088f);
                j.lineTo(336.567f, 192.5088f);
                j.close();
                j.moveTo(432.0954f, 181.7244f);
                j.cubicTo(425.0928f, 164.6502f, 416.1729f, 149.6187f, 405.8175f, 137.2272f);
                j.cubicTo(411.774f, 135.8214f, 417.5589f, 134.2176f, 423.192f, 132.462f);
                j.cubicTo(439.1277f, 142.8405f, 453.2715f, 155.8986f, 464.8578f, 171.1149f);
                j.cubicTo(455.3769f, 175.1739f, 444.3351f, 178.7346f, 432.0954f, 181.7244f);
                j.lineTo(432.0954f, 181.7244f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a3);
                canvas.restore();
                canvas.save();
                a3 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(34.1f, 67.542984f);
                j.cubicTo(37.867435f, 67.542984f, 40.9209f, 64.45843f, 40.9209f, 60.649837f);
                j.cubicTo(40.9209f, 56.843513f, 37.867435f, 53.75669f, 34.1f, 53.75669f);
                j.cubicTo(30.33481f, 53.75669f, 27.281347f, 56.843513f, 27.281347f, 60.649837f);
                j.cubicTo(27.281347f, 64.45843f, 30.33481f, 67.542984f, 34.1f, 67.542984f);
                j.moveTo(68.20225f, 67.542984f);
                j.cubicTo(71.96744f, 67.542984f, 75.0209f, 64.45843f, 75.0209f, 60.649837f);
                j.cubicTo(75.0209f, 56.843513f, 71.96744f, 53.75669f, 68.20225f, 53.75669f);
                j.cubicTo(64.43481f, 53.75669f, 61.381348f, 56.843513f, 61.381348f, 60.649837f);
                j.cubicTo(61.381348f, 64.45843f, 64.43481f, 67.542984f, 68.20225f, 67.542984f);
                j.moveTo(17.674164f, 107.0089f);
                j.cubicTo(6.890499f, 99.108f, -8.526513E-14f, 87.4212f, -8.526513E-14f, 74.44067f);
                j.cubicTo(-8.526513E-14f, 50.640366f, 22.900974f, 31.35f, 51.15f, 31.35f);
                j.cubicTo(79.399025f, 31.35f, 102.3f, 50.640366f, 102.3f, 74.44067f);
                j.cubicTo(102.3f, 98.23643f, 79.399025f, 117.52906f, 51.15f, 117.52906f);
                j.cubicTo(45.314743f, 117.52906f, 39.679306f, 116.68472f, 34.454742f, 115.16628f);
                j.cubicTo(33.97876f, 115.02102f, 33.47359f, 114.93931f, 32.950462f, 114.93931f);
                j.cubicTo(31.96931f, 114.93931f, 31.075724f, 115.24118f, 30.233776f, 115.73371f);
                j.lineTo(19.039242f, 122.26824f);
                j.cubicTo(18.724915f, 122.44982f, 18.421814f, 122.59054f, 18.051355f, 122.59054f);
                j.cubicTo(17.11062f, 122.59054f, 16.347254f, 121.81883f, 16.347254f, 120.86782f);
                j.cubicTo(16.347254f, 120.44112f, 16.515644f, 120.014404f, 16.621168f, 119.60812f);
                j.cubicTo(16.68628f, 119.363f, 18.064827f, 114.16306f, 18.926981f, 110.91509f);
                j.cubicTo(19.02577f, 110.54967f, 19.106598f, 110.19786f, 19.106598f, 109.81654f);
                j.cubicTo(19.106598f, 108.65899f, 18.540808f, 107.63307f, 17.674164f, 107.0089f);
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a3);
                canvas.restore();
                canvas.save();
                a3 = c.a(a, looper);
                a2 = c.a(a2, -0.9659258f, 0.25881904f, 1166.2971f, 0.25881904f, 0.9659258f, -153.54593f);
                f.reset();
                f.setValues(a2);
                canvas.concat(f);
                j = c.j(looper);
                j.moveTo(594.1839f, 90.56611f);
                j.cubicTo(603.446f, 99.828224f, 612.222f, 104.172485f, 615.46735f, 103.91808f);
                j.cubicTo(618.71277f, 103.66369f, 626.7947f, 98.105736f, 630.61f, 98.17971f);
                j.cubicTo(632.44366f, 98.21526f, 644.4262f, 106.319046f, 645.8767f, 107.255974f);
                j.cubicTo(647.32715f, 108.19291f, 648.67206f, 109.28735f, 648.4192f, 110.67228f);
                j.cubicTo(648.1663f, 112.0572f, 642.90015f, 127.312065f, 629.45557f, 125.199615f);
                j.cubicTo(616.01105f, 123.087166f, 597.26746f, 108.59371f, 586.5869f, 98.16311f);
                j.lineTo(594.1839f, 90.56611f);
                j.lineTo(594.1839f, 90.56611f);
                j.close();
                j.moveTo(594.1839f, 90.56611f);
                j.cubicTo(584.92175f, 81.30399f, 580.5775f, 72.52803f, 580.8319f, 69.28264f);
                j.cubicTo(581.0863f, 66.037254f, 586.6443f, 57.95533f, 586.5703f, 54.140003f);
                j.cubicTo(586.5347f, 52.306324f, 578.43097f, 40.323803f, 577.494f, 38.873318f);
                j.cubicTo(576.55707f, 37.422832f, 575.46265f, 36.07791f, 574.0777f, 36.330803f);
                j.cubicTo(572.6928f, 36.583694f, 557.4379f, 41.849873f, 559.55035f, 55.294426f);
                j.cubicTo(561.66284f, 68.738976f, 576.1563f, 87.48256f, 586.5869f, 98.16311f);
                j.lineTo(594.1839f, 90.56611f);
                j.lineTo(594.1839f, 90.56611f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a3);
                canvas.restore();
                canvas.save();
                e = c.a(a2, -1.0f, 0.0f, 539.55f, 0.0f, 1.0f, 0.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a4 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(391.6935f, 52.4931f);
                j.cubicTo(387.9414f, 50.2557f, 383.9913f, 48.0579f, 379.9587f, 45.9591f);
                j.lineTo(383.0046f, 40.1016f);
                j.cubicTo(387.1494f, 42.2598f, 391.2117f, 44.5236f, 395.0727f, 46.8237f);
                j.lineTo(391.6935f, 52.4931f);
                j.lineTo(391.6935f, 52.4931f);
                j.close();
                j.moveTo(39.1281f, 41.5866f);
                j.lineTo(36.3066f, 35.6202f);
                j.cubicTo(40.3656f, 33.6996f, 44.6094f, 31.8219f, 48.9093f, 30.0366f);
                j.lineTo(51.4371f, 36.1317f);
                j.cubicTo(47.2329f, 37.8741f, 43.0947f, 39.7122f, 39.1281f, 41.5866f);
                j.lineTo(39.1281f, 41.5866f);
                j.close();
                j.moveTo(367.8675f, 40.062f);
                j.cubicTo(363.8646f, 38.2338f, 359.6967f, 36.4518f, 355.4826f, 34.7655f);
                j.lineTo(357.9378f, 28.6374f);
                j.cubicTo(362.2476f, 30.3666f, 366.5112f, 32.1882f, 370.6065f, 34.0593f);
                j.lineTo(367.8675f, 40.062f);
                j.lineTo(367.8675f, 40.062f);
                j.close();
                j.moveTo(64.0002f, 31.2444f);
                j.lineTo(61.743f, 25.0437f);
                j.cubicTo(65.9769f, 23.5026f, 70.356f, 22.0077f, 74.7615f, 20.6052f);
                j.lineTo(76.7679f, 26.8917f);
                j.cubicTo(72.4482f, 28.2678f, 68.1516f, 29.733f, 64.0002f, 31.2444f);
                j.lineTo(64.0002f, 31.2444f);
                j.close();
                j.moveTo(342.8535f, 30.0234f);
                j.cubicTo(338.7087f, 28.5615f, 334.3956f, 27.1458f, 330.0429f, 25.806f);
                j.lineTo(331.9833f, 19.4964f);
                j.cubicTo(336.4185f, 20.8626f, 340.8141f, 22.308f, 345.048f, 23.7963f);
                j.lineTo(342.8535f, 30.0234f);
                j.lineTo(342.8535f, 30.0234f);
                j.close();
                j.moveTo(89.7072f, 23.0373f);
                j.lineTo(87.9384f, 16.6782f);
                j.cubicTo(92.2911f, 15.4737f, 96.7692f, 14.3187f, 101.2506f, 13.2462f);
                j.lineTo(102.7818f, 19.6647f);
                j.cubicTo(98.3796f, 20.7174f, 93.9807f, 21.8526f, 89.7072f, 23.0373f);
                j.lineTo(89.7072f, 23.0373f);
                j.close();
                j.moveTo(317.064f, 22.0869f);
                j.cubicTo(312.7674f, 20.9418f, 308.3553f, 19.8495f, 303.9498f, 18.8397f);
                j.lineTo(305.4282f, 12.408f);
                j.cubicTo(309.903f, 13.431f, 314.391f, 14.5431f, 318.7668f, 15.7113f);
                j.lineTo(317.064f, 22.0869f);
                j.lineTo(317.064f, 22.0869f);
                j.close();
                j.moveTo(115.9818f, 16.7541f);
                j.lineTo(114.6651f, 10.2861f);
                j.cubicTo(119.1168f, 9.3852f, 123.6609f, 8.5404f, 128.1687f, 7.7748f);
                j.lineTo(129.2709f, 14.2824f);
                j.cubicTo(124.8291f, 15.0348f, 120.3609f, 15.8664f, 115.9818f, 16.7541f);
                j.lineTo(115.9818f, 16.7541f);
                j.close();
                j.moveTo(290.7267f, 16.0479f);
                j.cubicTo(286.3707f, 15.2031f, 281.8926f, 14.4111f, 277.4145f, 13.695f);
                j.lineTo(278.4606f, 7.1775f);
                j.cubicTo(283.008f, 7.9068f, 287.5587f, 8.712f, 291.9807f, 9.57f);
                j.lineTo(290.7267f, 16.0479f);
                j.lineTo(290.7267f, 16.0479f);
                j.close();
                j.moveTo(142.6326f, 12.2397f);
                j.lineTo(141.735f, 5.7024f);
                j.cubicTo(146.2329f, 5.0853f, 150.777f, 4.5375f, 155.3607f, 4.0491f);
                j.lineTo(156.057f, 10.6128f);
                j.cubicTo(151.536f, 11.0913f, 147.0645f, 11.6358f, 142.6326f, 12.2397f);
                j.lineTo(142.6326f, 12.2397f);
                j.close();
                j.moveTo(264.0363f, 11.7645f);
                j.cubicTo(259.6011f, 11.1969f, 255.1197f, 10.6887f, 250.5954f, 10.2465f);
                j.lineTo(251.2356f, 3.6795f);
                j.cubicTo(255.8259f, 4.125f, 260.3733f, 4.6398f, 264.8745f, 5.2206f);
                j.lineTo(264.0363f, 11.7645f);
                j.lineTo(264.0363f, 11.7645f);
                j.close();
                j.moveTo(169.5276f, 9.3918f);
                j.lineTo(169.026f, 2.8116f);
                j.cubicTo(173.5536f, 2.4651f, 178.1208f, 2.1879f, 182.7177f, 1.9734f);
                j.lineTo(183.0279f, 8.5668f);
                j.cubicTo(178.4937f, 8.778f, 173.9925f, 9.0519f, 169.5276f, 9.3918f);
                j.lineTo(169.5276f, 9.3918f);
                j.close();
                j.moveTo(237.1182f, 9.1311f);
                j.cubicTo(232.65f, 8.8275f, 228.1455f, 8.5866f, 223.608f, 8.4084f);
                j.lineTo(223.8654f, 1.815f);
                j.cubicTo(228.4656f, 1.9932f, 233.0361f, 2.2374f, 237.567f, 2.5476f);
                j.lineTo(237.1182f, 9.1311f);
                j.lineTo(237.1182f, 9.1311f);
                j.close();
                j.moveTo(196.5447f, 8.1279f);
                j.lineTo(196.4259f, 1.5279f);
                j.cubicTo(199.3134f, 1.4784f, 202.1085f, 1.4223f, 205.1346f, 1.452f);
                j.cubicTo(206.8077f, 1.452f, 208.4775f, 1.4619f, 210.1506f, 1.4784f);
                j.lineTo(210.078f, 8.0784f);
                j.cubicTo(208.3488f, 8.0586f, 206.6856f, 8.0619f, 204.8772f, 8.052f);
                j.cubicTo(202.0854f, 8.052f, 199.3068f, 8.0784f, 196.5447f, 8.1279f);
                j.lineTo(196.5447f, 8.1279f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a4);
                canvas.restore();
                canvas.save();
                Paint a5 = c.a(a, looper);
                Path j2 = c.j(looper);
                j2.moveTo(37.2009f, 54.5655f);
                j2.lineTo(24.0669f, 45.5433f);
                j2.lineTo(21.4467f, 29.8254f);
                j2.lineTo(0.0f, 60.8652f);
                j2.lineTo(37.2009f, 54.5655f);
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, a5);
                canvas.restore();
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