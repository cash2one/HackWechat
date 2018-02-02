package com.tencent.mm.plugin.appbrand.dynamic.debugger;

import android.os.Bundle;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.ipcinvoker.d.c;
import com.tencent.mm.modelappbrand.LogInfo;
import com.tencent.mm.plugin.appbrand.wxawidget.console.b;
import java.util.ArrayList;

public final class a {
    private static com.tencent.mm.u.c.e.a iSU = new 1();

    public static void a(String str, ArrayList<LogInfo> arrayList) {
        Bundle bundle = new Bundle();
        bundle.putString(SlookAirButtonFrequentContactAdapter.ID, str);
        bundle.putParcelableArrayList("logList", arrayList);
        c.Bz().b(b.khs.getClass().getName(), bundle);
    }

    public static com.tencent.mm.u.c.e.a acT() {
        return iSU;
    }
}
