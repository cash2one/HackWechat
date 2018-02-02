package com.tencent.mm.plugin.sns.h;

import com.tencent.mm.modelsns.b;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.Vector;

public abstract class g {
    private Vector<b> rdG = new Vector();

    public final b b(b bVar) {
        this.rdG.add(bVar);
        return bVar;
    }

    public final boolean c(b bVar) {
        boolean z;
        Iterator it = this.rdG.iterator();
        while (it.hasNext()) {
            b bVar2 = (b) it.next();
            if (bVar2.hOH == bVar.hOH) {
                this.rdG.remove(bVar2);
                z = true;
                break;
            }
        }
        z = false;
        this.rdG.add(bVar);
        return z;
    }

    public final b bK(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            Iterator it = this.rdG.iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                if (obj.equals(bVar.hOE)) {
                    this.rdG.remove(bVar);
                    return bVar;
                }
            }
        } catch (Exception e) {
            x.e("MicroMsg.Ss_log_base_helper", "report by key " + e.getMessage() + " " + obj);
        }
        return null;
    }
}
