package com.tencent.mm.z;

import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.Set;

public final class bv {
    public boolean bgH = false;
    public Set<a> hhW = new HashSet();

    public interface a {
        boolean If();
    }

    public final boolean a(a aVar) {
        if (!this.bgH) {
            return this.hhW.add(aVar);
        }
        x.e("MicroMsg.UninitForUEH", "add , is running , forbid add");
        return false;
    }

    public final boolean b(a aVar) {
        if (!this.bgH) {
            return this.hhW.remove(aVar);
        }
        x.e("MicroMsg.UninitForUEH", "remove , is running , forbid remove");
        return false;
    }
}
