package com.tencent.mm.plugin.multitalk.ui.widget;

import android.content.Context;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.appbrand.jsapi.bs;
import com.tencent.mm.sdk.platformtools.ac;

public final class b {
    public static final int oHU = a.fromDPToPix(ac.getContext(), 3);
    public static final int oHV = a.fromDPToPix(ac.getContext(), 4);
    public static final int oHW = a.fromDPToPix(ac.getContext(), 8);
    public static final int oHX = a.fromDPToPix(ac.getContext(), 10);
    public static final int oHY = a.fromDPToPix(ac.getContext(), 14);
    public static final int oHZ = a.fromDPToPix(ac.getContext(), 30);
    public static final int oIa = a.fromDPToPix(ac.getContext(), 26);
    public static final int oIb = a.fromDPToPix(ac.getContext(), 32);
    public static final int oIc = a.fromDPToPix(ac.getContext(), 96);
    public static final int oId = a.fromDPToPix(ac.getContext(), 76);
    public static final int oIe = a.fromDPToPix(ac.getContext(), bs.CTRL_INDEX);
    private static int oIf = 0;

    public static int dg(Context context) {
        if (oIf == 0) {
            oIf = a.eB(context) - oIe;
        }
        return oIf;
    }
}
