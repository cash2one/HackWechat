package com.tencent.mm.plugin.label.ui;

import android.database.Cursor;

class a$1 implements Runnable {
    final /* synthetic */ Cursor nPu;
    final /* synthetic */ a nPv;

    a$1(a aVar, Cursor cursor) {
        this.nPv = aVar;
        this.nPu = cursor;
    }

    public final void run() {
        this.nPv.i(this.nPu);
    }
}
