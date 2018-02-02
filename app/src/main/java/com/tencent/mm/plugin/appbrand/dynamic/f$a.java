package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.ipcinvoker.a;
import com.tencent.mm.ipcinvoker.c;

public class f$a implements a {
    public final void a(Bundle bundle, c cVar) {
        f.acG().au(bundle.getString(SlookAirButtonFrequentContactAdapter.ID), bundle.getInt("widgetState"));
    }
}
