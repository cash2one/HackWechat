package com.tencent.mm.plugin.backup.backuppcui;

import android.view.View;
import android.view.View.OnClickListener;

class a$1 implements OnClickListener {
    final /* synthetic */ int kI;
    final /* synthetic */ a kok;

    a$1(a aVar, int i) {
        this.kok = aVar;
        this.kI = i;
    }

    public final void onClick(View view) {
        if (a.a(this.kok).contains(Integer.valueOf(this.kI))) {
            a.a(this.kok).remove(Integer.valueOf(this.kI));
        } else {
            a.a(this.kok).add(Integer.valueOf(this.kI));
        }
        this.kok.notifyDataSetChanged();
        a.b(this.kok).a(a.a(this.kok));
    }
}
