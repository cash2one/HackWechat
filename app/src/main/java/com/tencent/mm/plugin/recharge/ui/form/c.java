package com.tencent.mm.plugin.recharge.ui.form;

import com.tencent.mm.sdk.platformtools.x;

public final class c {
    private static String TAG = "MicroMsg.CommonHintViewConfig";

    public static void b(MallFormView mallFormView) {
        if (mallFormView == null) {
            x.e(TAG, "hy: param error");
        } else {
            mallFormView.pEo = new 1();
        }
    }
}
