package com.tencent.mm.plugin.fts.b;

import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.storage.x;

class a$i extends a {
    final /* synthetic */ a mMS;
    private boolean mNn;
    private String username;

    public a$i(a aVar, String str) {
        this.mMS = aVar;
        this.username = str;
    }

    public final boolean execute() {
        if (a.b(this.mMS).containsKey(this.username)) {
            this.mNn = true;
        } else if (a.c(this.mMS).add(this.username)) {
            x AW = a.d(this.mMS).AW(this.username);
            if (AW == null || this.mMS.D(AW)) {
                com.tencent.mm.plugin.fts.a.a a = a.a(this.mMS);
                String str = this.username;
                a.mJX.bindLong(1, 2);
                a.mJX.bindString(2, str);
                a.mJX.bindLong(3, 0);
                a.mJX.execute();
            } else {
                this.mNn = true;
            }
        } else {
            this.mNn = true;
        }
        return true;
    }

    public final String ado() {
        return String.format("{username: %s isSkipped: %b}", new Object[]{this.username, Boolean.valueOf(this.mNn)});
    }

    public final String getName() {
        return "MarkContactTimestampTask";
    }
}
