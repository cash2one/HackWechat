package com.tencent.mm.plugin.ext;

import android.database.Cursor;
import com.tencent.mm.plugin.messenger.foundation.a.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.c.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.z.s;

class b$5 implements a {
    final /* synthetic */ b lZF;

    b$5(b bVar) {
        this.lZF = bVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(c cVar, c.c cVar2) {
        if (cVar == null || cVar2 == null || cVar2.ooV == null) {
            x.e("MicroMsg.SubCoreExt", "onMsgChange, wrong args");
            return;
        }
        synchronized (this.lZF) {
            Cursor cjO = b.aFB().cjO();
            if (cjO == null) {
                x.i("MicroMsg.SubCoreExt", "onMsgChange onNotifyChange getValidOpenMsgListener cu == null");
                return;
            }
            x.d("MicroMsg.SubCoreExt", "onMsgChange onNotifyChange listener count = %s", new Object[]{Integer.valueOf(cjO.getCount())});
            if (cjO.getCount() <= 0) {
                cjO.close();
                x.i("MicroMsg.SubCoreExt", "onMsgChange onNotifyChange cu.getCount() <= 0");
                return;
            }
            cjO.close();
            for (int i = 0; i < cVar2.ooV.size(); i++) {
                au auVar = (au) cVar2.ooV.get(i);
                if (!(auVar == null || auVar.field_isSend != 0 || auVar.field_status == 4 || auVar.getType() == 9999 || auVar.getType() == 10000 || s.ho(auVar.field_talker) || s.hs(auVar.field_talker))) {
                    Integer num = (Integer) b.a(this.lZF).get(auVar.field_talker);
                    if (num == null) {
                        b.a(this.lZF).put(auVar.field_talker, Integer.valueOf(1));
                        x.d("MicroMsg.SubCoreExt", "onMsgChange %s, %d", new Object[]{auVar.field_talker, Integer.valueOf(1)});
                    } else {
                        b.a(this.lZF).put(auVar.field_talker, Integer.valueOf(num.intValue() + 1));
                        x.d("MicroMsg.SubCoreExt", "onMsgChange %s, %d", new Object[]{auVar.field_talker, Integer.valueOf(num.intValue() + 1)});
                    }
                }
            }
            if (b.a(this.lZF).size() > 0) {
                this.lZF.aFG();
            } else {
                x.i("MicroMsg.SubCoreExt", "notifyMsgUsers.size < 1");
            }
        }
    }
}
