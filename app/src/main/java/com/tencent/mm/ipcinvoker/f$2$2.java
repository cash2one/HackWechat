package com.tencent.mm.ipcinvoker;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.b.b.a;
import com.tencent.mm.ipcinvoker.f.2;

class f$2$2 extends a {
    final /* synthetic */ 2 gME;

    f$2$2(2 2) {
        this.gME = 2;
    }

    public final void i(Bundle bundle) {
        if (bundle == null) {
            this.gME.gMv.as(null);
            return;
        }
        bundle.setClassLoader(f.class.getClassLoader());
        this.gME.gMv.as(bundle.getParcelable("__remote_task_result_data"));
    }
}
