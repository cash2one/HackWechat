package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Looper;
import android.os.Parcel;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.j.a;
import java.util.ArrayList;
import java.util.List;

public final class f extends j implements r {
    private boolean iJg = false;

    public final boolean am(String str, int i) {
        IPCBoolean iPCBoolean = (IPCBoolean) XIPCInvoker.a("com.tencent.mm", new AppIdentity(str, i), c.class);
        return iPCBoolean == null ? false : iPCBoolean.value;
    }

    public final List<LocalUsageInfo> jE(int i) {
        Parcel parcel = (Parcel) XIPCInvoker.a("com.tencent.mm", new IPCInteger(12), a.class);
        if (parcel == null) {
            return null;
        }
        List<LocalUsageInfo> arrayList = new ArrayList(12);
        parcel.readTypedList(arrayList, LocalUsageInfo.CREATOR);
        return arrayList;
    }

    public final void c(a aVar) {
        a(aVar, Looper.getMainLooper());
    }

    public final void a(a aVar, Looper looper) {
        Object obj = 1;
        super.a(aVar, looper);
        synchronized (f.class) {
            if (this.iJg) {
                obj = null;
            }
            this.iJg = true;
        }
        if (obj != null) {
            XIPCInvoker.a("com.tencent.mm", IPCVoid.gNf, b.class, new 1(this));
        }
    }
}
