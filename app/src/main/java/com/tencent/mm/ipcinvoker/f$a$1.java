package com.tencent.mm.ipcinvoker;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.mm.ipcinvoker.f.a;

class f$a$1 implements i<Parcelable> {
    final /* synthetic */ c gMB;
    final /* synthetic */ a gMF;

    f$a$1(a aVar, c cVar) {
        this.gMF = aVar;
        this.gMB = cVar;
    }

    public final /* synthetic */ void as(Object obj) {
        Parcelable parcelable = (Parcelable) obj;
        if (this.gMB != null) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("__remote_task_result_data", parcelable);
            this.gMB.i(bundle);
        }
    }
}
