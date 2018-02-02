package com.tencent.mm.plugin.game.model;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.util.ArrayList;

public final class ao implements e {
    ArrayList<a> nea;
    private boolean neb = false;

    public static class a {
        public int hQu;
        public String nec;

        public a(int i, String str) {
            this.hQu = i;
            this.nec = str;
        }

        public static a g(int i, Object... objArr) {
            a aVar = new a();
            aVar.hQu = i;
            StringBuilder stringBuilder = new StringBuilder();
            int length = objArr.length - 1;
            for (int i2 = 0; i2 < length; i2++) {
                stringBuilder.append(String.valueOf(objArr[i2])).append(',');
            }
            stringBuilder.append(String.valueOf(objArr[length]));
            aVar.nec = stringBuilder.toString();
            if (m.fwI > 0) {
                x.i("MicroMsg.AppReportService", "appStat logID=%d, vals.size=%d, val = %s", Integer.valueOf(i), Integer.valueOf(objArr.length), stringBuilder.toString());
            } else {
                x.d("MicroMsg.AppReportService", "appStat logID=%d, vals.size=%d, val = %s", Integer.valueOf(i), Integer.valueOf(objArr.length), stringBuilder.toString());
            }
            return aVar;
        }
    }

    public ao() {
        ar.CG().a(427, (e) this);
        this.nea = new ArrayList();
    }

    public final void a(a aVar) {
        if (!this.nea.contains(aVar)) {
            this.nea.add(aVar);
        }
        aQU();
    }

    private void aQU() {
        while (!this.neb) {
            if (this.nea == null || this.nea.size() == 0) {
                x.d("MicroMsg.AppReportService", "report queue is null, no need do scnene");
                return;
            }
            a aVar = (a) this.nea.remove(0);
            if (aVar != null) {
                this.neb = true;
                ar.CG().a(new al(aVar.hQu, aVar.nec), 0);
                return;
            }
        }
        x.i("MicroMsg.AppReportService", "is doing scene, wait for a minite");
    }

    public final void a(int i, int i2, String str, k kVar) {
        this.neb = false;
        aQU();
    }
}
