package com.tencent.mm.plugin.backup.b;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import org.xwalk.core.R$styleable;

public final class e {
    public static int kkq;
    public static int kkr;
    public static int kks;
    public static int kkt;
    public static int kku;
    public static int kkv;
    public static int kkw;
    public static long kkx;
    public static long kky;
    public static long kkz;

    public static void reset() {
        kkq = 0;
        kkr = 0;
        kks = 0;
        kkt = 0;
        kku = 0;
        kkv = 0;
        kkw = 0;
        long Wp = bh.Wp();
        kkx = Wp;
        kkz = Wp - kky;
    }

    public static void mC(int i) {
        switch (i) {
            case 1:
                kks++;
                break;
            case 3:
                kkq++;
                break;
            case 34:
                kku++;
                break;
            case 37:
            case 40:
            case R$styleable.AppCompatTheme_dialogTheme /*42*/:
            case R$styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
            case 10000:
                kkr++;
                break;
            case R$styleable.AppCompatTheme_dialogPreferredPadding /*43*/:
                kkt++;
                break;
            case R$styleable.AppCompatTheme_actionButtonStyle /*49*/:
                kkv++;
                break;
        }
        kkw++;
    }

    public static void aoK() {
        x.d("MicroMsg.TestInfo", "total_count: " + kkw + "text_count: " + kks + "normal_count : " + kkr + " image_count: " + kkq + " voice_count : " + kku + " video_count " + kkt + " app_count : " + kkv + " time: " + (bh.Wp() - kkx) + " net: " + kkz);
    }

    public static void aoL() {
        x.d("MicroMsg.TestInfo", "netTime" + (bh.Wp() - kky));
    }
}
