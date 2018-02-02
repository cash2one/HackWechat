package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Parcel;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.plugin.appbrand.app.f;

final class f$a implements j<IPCInteger, Parcel> {
    private f$a() {
    }

    public final /* synthetic */ Object at(Object obj) {
        return a((IPCInteger) obj);
    }

    private static Parcel a(IPCInteger iPCInteger) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeTypedList(((e) f.u(e.class)).v(iPCInteger.value, false));
            return obtain;
        } catch (Exception e) {
            obtain.setDataPosition(0);
            obtain.writeTypedList(null);
            return obtain;
        }
    }
}
