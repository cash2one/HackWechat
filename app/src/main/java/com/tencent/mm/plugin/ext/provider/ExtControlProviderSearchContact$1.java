package com.tencent.mm.plugin.ext.provider;

import android.database.Cursor;
import com.tencent.mm.pluginsdk.e.a.b;

class ExtControlProviderSearchContact$1 implements Runnable {
    final /* synthetic */ Cursor iKq;
    final /* synthetic */ b kvk;
    final /* synthetic */ ExtControlProviderSearchContact maU;

    ExtControlProviderSearchContact$1(ExtControlProviderSearchContact extControlProviderSearchContact, Cursor cursor, b bVar) {
        this.maU = extControlProviderSearchContact;
        this.iKq = cursor;
        this.kvk = bVar;
    }

    public final void run() {
        ExtControlProviderSearchContact.a(this.maU, ExtControlProviderSearchContact.e(this.iKq));
        this.kvk.countDown();
    }
}
