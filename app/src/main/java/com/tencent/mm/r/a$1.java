package com.tencent.mm.r;

import com.tencent.mm.sdk.platformtools.x;

class a$1 implements Runnable {
    a$1() {
    }

    public final void run() {
        x.i("MicroMsg.FetchAllNeedFunctionJob", "FetchAllNeedFunctionJob, run");
        if (!i.Bm().Bc() && !i.Bm().Bd()) {
            i.Bm().Be();
        }
    }
}
