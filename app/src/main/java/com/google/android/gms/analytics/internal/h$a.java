package com.google.android.gms.analytics.internal;

import com.google.android.gms.common.internal.w;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

class h$a {
    int aFu;
    ByteArrayOutputStream aFv = new ByteArrayOutputStream();
    final /* synthetic */ h aFw;

    public h$a(h hVar) {
        this.aFw = hVar;
    }

    public final boolean b(c cVar) {
        w.ag(cVar);
        if (this.aFu + 1 > ac.nA()) {
            return false;
        }
        String a = this.aFw.a(cVar, false);
        if (a == null) {
            this.aFw.aFo.mS().a(cVar, "Error formatting hit");
            return true;
        }
        byte[] bytes = a.getBytes();
        int length = bytes.length;
        if (length > ac.nw()) {
            this.aFw.aFo.mS().a(cVar, "Hit size exceeds the maximum size limit");
            return true;
        }
        if (this.aFv.size() > 0) {
            length++;
        }
        if (this.aFv.size() + length > ((Integer) aj.aHS.get()).intValue()) {
            return false;
        }
        try {
            if (this.aFv.size() > 0) {
                this.aFv.write(h.mr());
            }
            this.aFv.write(bytes);
            this.aFu++;
            return true;
        } catch (IOException e) {
            this.aFw.f("Failed to write payload when batching hits", e);
            return true;
        }
    }
}
