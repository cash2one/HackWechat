package com.tencent.mm.plugin.sns.storage;

import com.tencent.mm.plugin.sns.storage.b.d;
import java.util.ArrayList;

public class b$c {
    final /* synthetic */ b rfq;
    public String rfs = "";
    public ArrayList<d> rft = new ArrayList();

    public b$c(b bVar) {
        this.rfq = bVar;
    }

    public final String wT(int i) {
        if (i < 0 || i >= this.rft.size()) {
            return "";
        }
        return ((d) this.rft.get(i)).rfw;
    }

    public final String wU(int i) {
        if (i < 0 || i >= this.rft.size()) {
            return "";
        }
        return ((d) this.rft.get(i)).title;
    }
}
