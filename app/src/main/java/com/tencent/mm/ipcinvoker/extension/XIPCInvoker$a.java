package com.tencent.mm.ipcinvoker.extension;

import com.tencent.mm.ipcinvoker.extension.XIPCInvoker.WrapperParcelable;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.o;
import com.tencent.mm.sdk.platformtools.x;

class XIPCInvoker$a implements h<WrapperParcelable, WrapperParcelable> {
    private XIPCInvoker$a() {
    }

    public final /* synthetic */ void a(Object obj, final i iVar) {
        WrapperParcelable wrapperParcelable = (WrapperParcelable) obj;
        Object obj2 = wrapperParcelable.gMY;
        String str = wrapperParcelable.gNa;
        if (str == null || str.length() == 0) {
            x.e("IPC.IPCAsyncInvokeTaskProxy", "proxy AsyncInvoke failed, class is null or nil.");
            return;
        }
        h hVar = (h) o.d(str, h.class);
        if (hVar == null) {
            x.w("IPC.IPCAsyncInvokeTaskProxy", "proxy AsyncInvoke failed, newInstance(%s) return null.", new Object[]{str});
            return;
        }
        hVar.a(obj2, new i(this) {
            final /* synthetic */ XIPCInvoker$a gMZ;

            public final void as(Object obj) {
                if (iVar != null) {
                    iVar.as(new WrapperParcelable(null, obj));
                }
            }
        });
    }
}
