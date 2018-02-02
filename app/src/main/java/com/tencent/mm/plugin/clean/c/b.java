package com.tencent.mm.plugin.clean.c;

import java.util.ArrayList;
import java.util.Iterator;

public final class b implements Comparable<b> {
    public long fwg;
    public ArrayList<a> lfg;
    public String username;

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        b bVar = (b) obj;
        if (this.fwg < bVar.fwg) {
            return -1;
        }
        return this.fwg > bVar.fwg ? 1 : 0;
    }

    public final boolean aya() {
        this.fwg = 0;
        Iterator it = this.lfg.iterator();
        while (it.hasNext()) {
            this.fwg += ((a) it.next()).size;
        }
        if (this.lfg.size() == 0) {
            return false;
        }
        return true;
    }
}
