package com.tencent.mm.ipcinvoker.extension;

import com.tencent.mm.ipcinvoker.extension.XIPCInvoker.WrapperParcelable;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.o;
import com.tencent.mm.sdk.platformtools.x;

class XIPCInvoker$b implements j<WrapperParcelable, WrapperParcelable> {
    private XIPCInvoker$b() {
    }

    public final /* synthetic */ Object at(Object obj) {
        WrapperParcelable wrapperParcelable = (WrapperParcelable) obj;
        Object obj2 = wrapperParcelable.gMY;
        String str = wrapperParcelable.gNa;
        if (str == null || str.length() == 0) {
            x.e("IPC.XIPCInvoker", "proxy SyncInvoke failed, class is null or nil.");
            return new WrapperParcelable(null, null);
        }
        j jVar = (j) o.d(str, j.class);
        if (jVar != null) {
            return new WrapperParcelable(null, jVar.at(obj2));
        }
        x.w("IPC.XIPCInvoker", "proxy SyncInvoke failed, newInstance(%s) return null.", new Object[]{str});
        return new WrapperParcelable(null, null);
    }
}
