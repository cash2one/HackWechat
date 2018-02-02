package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.plugin.sns.ui.bf;
import com.tencent.mm.protocal.c.bnp;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;

public final class as implements e {
    public List<WeakReference<e>> qXL = new LinkedList();

    public final void a(e eVar) {
        for (WeakReference weakReference : this.qXL) {
            if (weakReference != null && weakReference.get() != null && ((e) weakReference.get()).equals(eVar)) {
                return;
            }
        }
        this.qXL.add(new WeakReference(eVar));
    }

    public final void a(int i, String str, long j, String str2, bnp com_tencent_mm_protocal_c_bnp, boolean z, bf bfVar) {
        for (WeakReference weakReference : this.qXL) {
            if (!(weakReference == null || weakReference.get() == null)) {
                ((e) weakReference.get()).a(i, str, j, str2, com_tencent_mm_protocal_c_bnp, z, bfVar);
            }
        }
    }

    public final void a(int i, String str, long j, String str2, bnp com_tencent_mm_protocal_c_bnp, boolean z) {
        for (WeakReference weakReference : this.qXL) {
            if (!(weakReference == null || weakReference.get() == null)) {
                ((e) weakReference.get()).a(i, str, j, str2, com_tencent_mm_protocal_c_bnp, z);
            }
        }
    }
}
