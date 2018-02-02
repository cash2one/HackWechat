package com.tencent.mm.bm;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.tencent.mm.sdk.platformtools.ac;

class d$2 implements a {
    final /* synthetic */ int pa;
    final /* synthetic */ Fragment qS;
    final /* synthetic */ Intent val$intent;
    final /* synthetic */ String vzO;
    final /* synthetic */ String vzT;

    d$2(Intent intent, String str, String str2, Fragment fragment, int i) {
        this.val$intent = intent;
        this.vzO = str;
        this.vzT = str2;
        this.qS = fragment;
        this.pa = i;
    }

    public final void onDone() {
        Intent intent = this.val$intent == null ? new Intent() : this.val$intent;
        intent.setClassName(ac.getPackageName(), this.vzT.startsWith(".") ? (ac.cfr() + ".plugin." + this.vzO) + this.vzT : this.vzT);
        this.qS.startActivityForResult(intent, this.pa);
        d.b(this.qS.getActivity(), this.vzT, this.val$intent);
    }
}
