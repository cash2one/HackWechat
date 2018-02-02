package com.tencent.mm.plugin.wear.model;

import com.tencent.mm.plugin.wear.model.f.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public final class g {
    private static int tiz = 0;
    private HashMap<String, f> tiA = new HashMap();

    public final synchronized f NH(String str) {
        f fVar;
        if (this.tiA.containsKey(str)) {
            fVar = (f) ((f) this.tiA.get(str)).clone();
        } else {
            tiz++;
            fVar = new f();
            fVar.talker = str;
            fVar.id = tiz;
            fVar.tit = a.tiu;
            this.tiA.put(str, fVar);
            fVar = (f) fVar.clone();
        }
        return fVar;
    }

    public final synchronized void NI(String str) {
        x.i("MicroMsg.Wear.WearNotificationMap", "reset notification talker=%s", new Object[]{str});
        if (this.tiA.containsKey(str)) {
            ((f) this.tiA.get(str)).tit = a.tiu;
            ((f) this.tiA.get(str)).tis = 0;
        }
    }

    public final synchronized void a(f fVar) {
        x.i("MicroMsg.Wear.WearNotificationMap", "update notification=%s", new Object[]{fVar});
        this.tiA.put(fVar.talker, fVar);
    }

    public final synchronized void NJ(String str) {
        if (this.tiA.containsKey(str)) {
            f fVar = (f) this.tiA.get(str);
            fVar.tit = a.tix;
            fVar.tis = 0;
            x.i("MicroMsg.Wear.WearNotificationMap", "Update reply success, notification=%s", new Object[]{fVar});
        }
    }

    public final synchronized void ct(String str, int i) {
        if (this.tiA.containsKey(str)) {
            f fVar = (f) this.tiA.get(str);
            fVar.tit = a.tiw;
            fVar.tis = i;
            x.i("MicroMsg.Wear.WearNotificationMap", "Update ignore success, notification=%s", new Object[]{fVar});
        }
    }

    public final synchronized void NK(String str) {
        if (this.tiA.containsKey(str)) {
            ((f) this.tiA.get(str)).tit = a.tiv;
            x.i("MicroMsg.Wear.WearNotificationMap", "Update showing success, notification=%s", new Object[]{r0});
        }
    }
}
