package com.tencent.mm.ipcinvoker.extension;

import com.tencent.mm.ipcinvoker.extension.XIPCInvoker.WrapperParcelable;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.sdk.platformtools.x;

class XIPCInvoker$1 implements i<WrapperParcelable> {
    final /* synthetic */ i gMv;

    XIPCInvoker$1(i iVar) {
        this.gMv = iVar;
    }

    public final /* synthetic */ void as(Object obj) {
        WrapperParcelable wrapperParcelable = (WrapperParcelable) obj;
        if (this.gMv == null) {
            return;
        }
        if (wrapperParcelable == null) {
            x.w("IPC.XIPCInvoker", "async invoke callback error, wrapper parcelable data is null!");
            this.gMv.as(null);
            return;
        }
        this.gMv.as(wrapperParcelable.gMY);
    }
}
