package com.tencent.mm.ipcinvoker.wx_extension;

import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.wx_extension.service.IPCRunCgiRespWrapper;

class b$2 implements i<IPCRunCgiRespWrapper> {
    final /* synthetic */ b$a gNg;

    b$2(b$a com_tencent_mm_ipcinvoker_wx_extension_b_a) {
        this.gNg = com_tencent_mm_ipcinvoker_wx_extension_b_a;
    }

    public final /* synthetic */ void as(Object obj) {
        IPCRunCgiRespWrapper iPCRunCgiRespWrapper = (IPCRunCgiRespWrapper) obj;
        if (this.gNg != null && iPCRunCgiRespWrapper != null) {
            this.gNg.a(iPCRunCgiRespWrapper.errType, iPCRunCgiRespWrapper.errCode, iPCRunCgiRespWrapper.fnL, iPCRunCgiRespWrapper.gJQ);
        }
    }
}
