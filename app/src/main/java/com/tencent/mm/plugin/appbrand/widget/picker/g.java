package com.tencent.mm.plugin.appbrand.widget.picker;

import com.tencent.mm.sdk.platformtools.bh;

public final class g {
    public static boolean mn(int i) {
        return i >= 0 && i <= 59;
    }

    public static boolean mo(int i) {
        return i >= 0 && i <= 23;
    }

    public static int[] vf(String str) {
        if (bh.ov(str)) {
            return null;
        }
        String[] split = str.split(":");
        if (split == null || split.length != 2) {
            return null;
        }
        int vg = vg(split[0]);
        int vg2 = vg(split[1]);
        if (!mo(vg) || !mn(vg2)) {
            return null;
        }
        return new int[]{vg, vg2};
    }

    private static int vg(String str) {
        try {
            return Integer.parseInt(str, 10);
        } catch (Exception e) {
            return -1;
        }
    }
}
