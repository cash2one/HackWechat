package com.tencent.mm.ui.contact;

import android.os.Looper;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.contact.a.d;
import com.tencent.mm.ui.contact.m.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class r extends q {
    private String fDj;
    private af handler = new af(Looper.getMainLooper());
    private a ySU;
    private Map<String, String> yTB = new HashMap();
    private List<String> yTC = new ArrayList();
    private List<String> yTn;

    public r(MMBaseSelectContactUI mMBaseSelectContactUI, List<String> list, boolean z, String str) {
        super(mMBaseSelectContactUI, list, z, 0);
        this.yTn = list;
        if (!bh.ov(str)) {
            this.yTC = bh.F(str.split(","));
            if (this.yTC != null) {
                for (String str2 : this.yTC) {
                    String gu = ((b) g.h(b.class)).gu(str2);
                    if (!bh.ov(gu)) {
                        this.yTB.put(gu, str2);
                    }
                }
            }
        }
        WT();
    }

    public final void a(a aVar) {
        this.ySU = aVar;
    }

    public final void bo(String str, boolean z) {
        if (this.ySU != null) {
            this.ySU.r(str, getCount(), z);
        }
    }

    private void WT() {
        this.fDj = null;
        clearCache();
    }

    public final int getCount() {
        return this.yTC == null ? 0 : this.yTC.size();
    }

    protected final com.tencent.mm.ui.contact.a.a jb(int i) {
        com.tencent.mm.ui.contact.a.a dVar = new d(i);
        dVar.fDj = this.fDj;
        g.Dk();
        dVar.jLe = ((h) g.h(h.class)).EY().WM((String) this.yTC.get(i));
        dVar.ySW = btz();
        return dVar;
    }

    public final void finish() {
        super.finish();
        WT();
    }

    protected final boolean c(com.tencent.mm.ui.contact.a.a aVar) {
        return true;
    }
}
