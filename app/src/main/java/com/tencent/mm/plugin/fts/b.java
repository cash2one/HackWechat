package com.tencent.mm.plugin.fts;

import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.h;
import java.util.LinkedList;

public final class b extends a implements Runnable {
    int errorCode = -2;
    private g mJc;

    public b(g gVar) {
        this.mJc = gVar;
    }

    public final boolean execute() {
        if (this.errorCode == -2 || this.errorCode == -3) {
            h hVar = new h(this.mJc);
            hVar.mMa = this;
            hVar.bjW = this.errorCode;
            hVar.mMc = new LinkedList();
            hVar.mMb = e.an(this.mJc.fDj, false);
            if (this.mJc.handler == null) {
                this.mJc.mLZ.b(hVar);
            } else {
                this.mJc.handler.post(new 1(this, hVar));
            }
        }
        return true;
    }

    public final void run() {
        try {
            execute();
        } catch (Exception e) {
        }
    }

    public final int getPriority() {
        return 0;
    }

    public final boolean isCancelled() {
        return false;
    }

    public final int getId() {
        return -1;
    }
}
