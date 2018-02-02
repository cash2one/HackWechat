package com.tencent.mm.plugin.mall.ui;

import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ae;

public final class a {
    private static int ole = 39;
    private static int olf = 40;
    private static int olg = 95;
    private static int olh = 0;
    private static int oli = 0;

    public static void c(MMActivity mMActivity) {
        int height;
        int fromDPToPix = com.tencent.mm.bv.a.fromDPToPix(mMActivity, ole);
        int fromDPToPix2 = com.tencent.mm.bv.a.fromDPToPix(mMActivity, olf);
        int i = ae.fz(mMActivity).y;
        if (ae.fy(mMActivity)) {
            i -= ae.fx(mMActivity);
        }
        if (mMActivity.getSupportActionBar() != null) {
            height = mMActivity.getSupportActionBar().getHeight();
        } else {
            height = 0;
        }
        int fromDPToPix3 = com.tencent.mm.bv.a.fromDPToPix(mMActivity, olg);
        olh = Math.round(((float) (((i - (fromDPToPix * 2)) - fromDPToPix2) - height)) / 5.0f);
        x.i("MicroMsg.FunctionGridSizeCalculator", "calc GRID_HEIGHT_SIZE_PX: %s, minHeight: %s", new Object[]{Integer.valueOf(olh), Integer.valueOf(fromDPToPix3)});
        if (olh < fromDPToPix3) {
            olh = fromDPToPix3;
        }
        oli = Math.round(((float) (olh * 4)) / 3.0f);
        x.i("MicroMsg.FunctionGridSizeCalculator", "calcGridSize, GRID_HEIGHT_SIZE_PX: %s, TOP_FUNC_LINE_GRID_SIZE_PX: %s", new Object[]{Integer.valueOf(olh), Integer.valueOf(oli)});
    }

    public static int aXY() {
        return olh;
    }

    public static int aXZ() {
        return oli;
    }

    public static int aYa() {
        return com.tencent.mm.bv.a.fromDPToPix(ac.getContext(), ole);
    }
}
