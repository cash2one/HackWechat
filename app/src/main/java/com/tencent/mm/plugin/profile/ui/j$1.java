package com.tencent.mm.plugin.profile.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.plugin.profile.a;

class j$1 implements OnClickListener {
    final /* synthetic */ j pjn;

    j$1(j jVar) {
        this.pjn = jVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        a.ifs.h(new Intent(), j.a(this.pjn));
    }
}
