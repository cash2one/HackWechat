package com.tencent.mm.ui.chatting;

import android.os.Bundle;
import android.os.Looper;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.b.p;
import com.tencent.mm.z.am;
import com.tencent.mm.z.s;
import java.util.ArrayList;
import java.util.List;

public final class x implements am {
    public p fhr;
    public z ywZ = new z();

    public x(p pVar) {
        this.fhr = pVar;
    }

    public final void a(au auVar) {
        if (this.fhr == null) {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ChattingUIKeywordChecker", "chatting ui is null.");
            return;
        }
        this.fhr.cqY();
        if (auVar.field_talker.equals(this.fhr.crz()) && auVar.cjg()) {
            aB(auVar);
        }
    }

    public final void y(List<au> list) {
        if (this.fhr == null) {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ChattingUIKeywordChecker", "chatting ui is null.");
        } else if (!s.eV(this.fhr.crz())) {
            List arrayList = new ArrayList();
            for (au auVar : list) {
                if (auVar.field_talker.equals(this.fhr.crz()) && auVar.cjg()) {
                    arrayList.add(auVar);
                }
            }
            di(arrayList);
        }
    }

    public final void aB(au auVar) {
        if (auVar != null) {
            List arrayList = new ArrayList();
            arrayList.add(auVar);
            di(arrayList);
        }
    }

    private void di(List<au> list) {
        if (this.ywZ != null && this.fhr != null) {
            this.ywZ.a(this.fhr.csq().thisActivity(), list);
        }
    }

    public final Looper getLooper() {
        return Looper.getMainLooper();
    }

    public final void a(int i, String str, String str2, String str3, String str4, Bundle bundle) {
    }
}
