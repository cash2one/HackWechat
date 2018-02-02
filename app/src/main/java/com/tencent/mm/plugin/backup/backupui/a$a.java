package com.tencent.mm.plugin.backup.backupui;

import com.tencent.mm.plugin.backup.a.b.a;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

class a$a implements a {
    private final WeakReference<a> kqc;

    a$a(a aVar) {
        this.kqc = new WeakReference(aVar);
    }

    public final void my(int i) {
        a aVar = (a) this.kqc.get();
        if (aVar != null) {
            a.a(aVar, i);
        } else {
            x.e(a.bz(), "BackupChatBanner WeakReference is null!");
        }
    }
}
