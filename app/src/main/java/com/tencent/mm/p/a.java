package com.tencent.mm.p;

import android.content.Context;
import android.widget.Toast;
import com.tencent.mm.g.a.jq;
import com.tencent.mm.g.a.so;
import com.tencent.mm.plugin.comm.a.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ac;

public final class a {
    private static ac fgl;

    public static boolean aU(Context context) {
        if (!AW()) {
            return false;
        }
        x.i("MicroMsg.DeviceOccupy", "isMultiTalking");
        Toast.makeText(context, h.lpe, 0).show();
        return true;
    }

    public static boolean AW() {
        b jqVar = new jq();
        jqVar.fAq.action = 1;
        com.tencent.mm.sdk.b.a.xef.m(jqVar);
        return jqVar.fAr.fAs;
    }

    public static boolean aV(Context context) {
        b soVar = new so();
        com.tencent.mm.sdk.b.a.xef.m(soVar);
        if (soVar.fKm.fKo) {
            x.i("MicroMsg.DeviceOccupy", "isCameraUsing");
            Toast.makeText(context, d(context, soVar.fKm.fKn), 0).show();
        }
        return soVar.fKm.fKo;
    }

    public static boolean aW(Context context) {
        b soVar = new so();
        com.tencent.mm.sdk.b.a.xef.m(soVar);
        if (soVar.fKm.fKp) {
            x.i("MicroMsg.DeviceOccupy", "isVoiceUsing");
            Toast.makeText(context, d(context, soVar.fKm.fKn), 0).show();
        }
        return soVar.fKm.fKp;
    }

    private static String d(Context context, boolean z) {
        if (z) {
            return context.getString(h.lot);
        }
        return context.getString(h.lou);
    }

    public static ac ux() {
        if (fgl == null) {
            fgl = com.tencent.mm.booter.a.wz();
        }
        return fgl;
    }
}
