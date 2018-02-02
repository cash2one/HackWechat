package com.tencent.mm.plugin.bbom;

import android.content.SharedPreferences;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelsimple.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.aj;
import com.tencent.mm.z.ar;

public final class m implements e {
    static m kvD;

    public final void a(int i, int i2, String str, k kVar) {
        if (i == 4 && !ar.CG().foreground) {
            switch (i2) {
                case -999999:
                    new af().post(new 1(this));
                    return;
                case -311:
                case -310:
                case -205:
                case -72:
                case -9:
                case -6:
                case -4:
                case -3:
                    ar.getNotification().ep(ac.getContext().getString(R.l.euv));
                    ar.hold();
                    return;
                case -140:
                    x.e("MicroMsg.NewSyncErrorProcessor", "alpha need whitelist : [%s]", new Object[]{str});
                    if (bh.ov(str)) {
                        ar.getNotification().ep(ac.getContext().getString(R.l.euv));
                    } else {
                        ar.getNotification().ep(str);
                    }
                    ar.hold();
                    return;
                case -100:
                    ar.getNotification().ep(ac.getContext().getString(R.l.euu));
                    d.br(ac.getContext());
                    ar.hold();
                    return;
                case -17:
                case -16:
                    SharedPreferences sharedPreferences = ac.getContext().getSharedPreferences("system_config_prefs", 0);
                    long j = sharedPreferences.getLong("recomended_update_ignore", -1);
                    if (j == -1 || bh.by(j) >= 86400) {
                        int i3;
                        aj notification = ar.getNotification();
                        if (i2 == -17) {
                            i3 = 2;
                        } else {
                            i3 = 1;
                        }
                        notification.fk(i3);
                        sharedPreferences.edit().putLong("recomended_update_ignore", bh.Wo()).commit();
                        g.pQN.a(405, 27, 1, true);
                        return;
                    }
                    x.d("MicroMsg.NewSyncErrorProcessor", "skip update notification, last check=" + j);
                    return;
                default:
                    return;
            }
        }
    }
}
