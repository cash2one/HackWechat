package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.widget.ListView;
import com.tencent.mm.g.a.ba;
import com.tencent.mm.g.a.jg;
import com.tencent.mm.g.b.aj;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.w;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.s;
import java.util.HashMap;
import java.util.Map.Entry;

public final class c {
    Activity activity;
    ListView yVR;
    HashMap<String, Integer> yWt = new HashMap();
    int yWu = -1;
    public int yWv = -1;
    g yWw;
    com.tencent.mm.sdk.b.c yWx = new 1(this);
    com.tencent.mm.sdk.b.c yWy = new com.tencent.mm.sdk.b.c<ba>(this) {
        final /* synthetic */ c yWA;

        {
            this.yWA = r2;
            this.xen = ba.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            if (((ba) bVar).fph.fpi != this.yWA.yWv) {
                x.i("MicroMsg.ConvUnreadHelper", "unreadcheck wrong should be %d, but is %d", Integer.valueOf(((ba) bVar).fph.fpi), Integer.valueOf(this.yWA.yWv));
                this.yWA.yWv = -1;
            }
            return true;
        }
    };
    com.tencent.mm.sdk.b.c yWz = new com.tencent.mm.sdk.b.c<jg>(this) {
        private final long INTERVAL;
        final /* synthetic */ c yWA;
        long yWC;
        int yWD;

        {
            this.yWA = r3;
            this.INTERVAL = 3000;
            this.yWC = 0;
            this.yWD = -1;
            this.xen = jg.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            if (this.yWA.activity != null) {
                x.d("MicroMsg.ConvUnreadHelper", "trigger double tab");
                this.yWA.yVR.postDelayed(new 1(this), 100);
            }
            return false;
        }
    };

    public final void aa(Activity activity) {
        this.yWv = ((LauncherUI) activity).xGS.xGh.cnn();
    }

    public final void cwp() {
        if (this.activity != null) {
            long currentTimeMillis = System.currentTimeMillis();
            LauncherUI launcherUI = (LauncherUI) this.activity;
            x.i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount  resetStatus %d", Integer.valueOf(this.yWu));
            switch (this.yWu) {
                case 1:
                    return;
                case 2:
                    int i = 0;
                    for (Entry entry : this.yWt.entrySet()) {
                        int i2;
                        String str = (String) entry.getKey();
                        int intValue = ((Integer) entry.getValue()).intValue();
                        x.i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount  username %s, preunread %d", str, Integer.valueOf(intValue));
                        aj ZF = ZF(str);
                        if (ZF == null || af.cnG().contains(str)) {
                            x.i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount  cov == null username %s, change %d", str, Integer.valueOf(0 - intValue));
                            i2 = intValue;
                        } else {
                            x.i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount  cov != null username %s, change %d", str, Integer.valueOf((ZF.field_unReadCount - intValue) + 0));
                            i2 = intValue;
                        }
                        if (i2 != 0 && this.yWw.ZG(str)) {
                            x.i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount  username %s isWithoutItemCache", str);
                            ar.Hg();
                            com.tencent.mm.g.b.af WO = com.tencent.mm.z.c.EY().WO(str);
                            if (WO != null) {
                                if (s.eV(str)) {
                                    if (WO.fWn == 0) {
                                    }
                                } else if (WO.AI()) {
                                }
                            }
                        }
                        x.i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount  real change usename %s, change %d, totalchange %d", str, Integer.valueOf(i2), Integer.valueOf(i + i2));
                        i = intValue;
                    }
                    this.yWv += i;
                    w wVar = launcherUI.xGS.xGh;
                    wVar.xKx.DY(this.yWv);
                    x.i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount UNREAD_RESET_PART totalUnReadCount %d, change %d, usetime %d,", Integer.valueOf(this.yWv), Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    return;
                default:
                    this.yWv = launcherUI.xGS.xGh.cnn();
                    x.i("MicroMsg.ConvUnreadHelper", "unreadcheck postSetLauncherUIUnReadCount UNREAD_RESET_ALL totalUnReadCount %d, usetime %d,", Integer.valueOf(this.yWv), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    return;
            }
        }
    }

    final ae ZF(String str) {
        if (this.yWw != null) {
            return (ae) this.yWw.ce(str);
        }
        return null;
    }
}
