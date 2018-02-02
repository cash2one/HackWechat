package com.tencent.mm.pluginsdk.model;

import android.os.Bundle;
import com.tencent.mm.k.g;
import com.tencent.mm.sdk.platformtools.bh;

public final class v {
    private static volatile v vdP = null;

    private v() {
    }

    public static v bYu() {
        if (vdP == null) {
            synchronized (v.class) {
                if (vdP == null) {
                    vdP = new v();
                }
            }
        }
        return vdP;
    }

    public static u t(int i, Bundle bundle) {
        switch (i) {
            case 1:
                return new y();
            case 2:
                return new a(bundle);
            default:
                return new r();
        }
    }

    public static int BB(int i) {
        switch (i) {
            case 0:
                return bh.getInt(g.zZ().F("QQBroswer", "RecommendCount"), 5);
            case 1:
                return Integer.MAX_VALUE;
            default:
                return 5;
        }
    }

    public static void BC(int i) {
        switch (i) {
            case 0:
                com.tencent.mm.plugin.report.service.g.pQN.h(10998, new Object[]{Integer.valueOf(0)});
                return;
            case 1:
                com.tencent.mm.plugin.report.service.g.pQN.h(11091, new Object[]{Integer.valueOf(0)});
                return;
            default:
                return;
        }
    }

    public static void BD(int i) {
        switch (i) {
            case 0:
                com.tencent.mm.plugin.report.service.g.pQN.h(10998, new Object[]{Integer.valueOf(1)});
                return;
            case 1:
                com.tencent.mm.plugin.report.service.g.pQN.h(11091, new Object[]{Integer.valueOf(1)});
                return;
            default:
                return;
        }
    }

    public static void BE(int i) {
        switch (i) {
            case 0:
                com.tencent.mm.plugin.report.service.g.pQN.h(10998, new Object[]{Integer.valueOf(3)});
                return;
            case 1:
                com.tencent.mm.plugin.report.service.g.pQN.h(11091, new Object[]{Integer.valueOf(3)});
                return;
            default:
                return;
        }
    }

    public static void BF(int i) {
        switch (i) {
            case 0:
                com.tencent.mm.plugin.report.service.g.pQN.h(10998, new Object[]{Integer.valueOf(2)});
                return;
            case 1:
                com.tencent.mm.plugin.report.service.g.pQN.h(11091, new Object[]{Integer.valueOf(2)});
                return;
            default:
                return;
        }
    }
}
