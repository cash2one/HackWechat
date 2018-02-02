package com.tencent.mm.plugin.wear.model.f;

import android.graphics.Bitmap;
import com.tencent.mm.bq.b;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.f;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.c.byu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public final class j extends b {
    private boolean fBx;
    private int fnm;
    private String talker;

    public j(String str, int i, boolean z) {
        this.talker = str;
        this.fnm = i;
        this.fBx = z;
    }

    private String i(String str, ArrayList<au> arrayList) {
        x.d("MicroMsg.WearNotificationCreateTask", "Talker: %s, MsgSize: %d", new Object[]{str, Integer.valueOf(arrayList.size())});
        StringBuffer stringBuffer = new StringBuffer();
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            stringBuffer.append(c(str, (au) arrayList.get(size)));
            stringBuffer.append("​​");
        }
        return stringBuffer.toString().trim();
    }

    private static String T(ArrayList<au> arrayList) {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            au auVar = (au) it.next();
            stringBuffer.append(auVar.field_msgId);
            stringBuffer.append(auVar.field_talker);
            stringBuffer.append(auVar.field_content);
            stringBuffer.append(auVar.getType());
            stringBuffer.append(auVar.field_createTime);
        }
        return ab.UZ(stringBuffer.toString());
    }

    public final String getName() {
        return "WearNotificationCreateTask";
    }

    protected final void send() {
        x.d("MicroMsg.WearNotificationCreateTask", "start to execute notification create task");
        f NH = a.bOt().thJ.NH(this.talker);
        ArrayList arrayList = new ArrayList();
        int i = this.fnm - NH.tis;
        if (i < 0) {
            i = 0;
        }
        x.d("MicroMsg.WearNotificationCreateTask", "limit=%d", new Object[]{Integer.valueOf(i)});
        ar.Hg();
        for (au auVar : c.Fa().bw(this.talker, i)) {
            if ((auVar.isSystem() ? 0 : 1) != 0) {
                arrayList.add(auVar);
            }
        }
        x.i("MicroMsg.WearNotificationCreateTask", "receiveUnreadMsgList.size=%d", new Object[]{Integer.valueOf(arrayList.size())});
        if (arrayList.size() != 0) {
            String T = T(arrayList);
            if (NH.fqR.equals(T)) {
                x.i("MicroMsg.WearNotificationCreateTask", "same md5, not to update");
                return;
            }
            NH.fqR = T;
            byu com_tencent_mm_protocal_c_byu = new byu();
            com_tencent_mm_protocal_c_byu.nkn = NH.id;
            com_tencent_mm_protocal_c_byu.wYG = NH.talker;
            com_tencent_mm_protocal_c_byu.fon = h.NM(NH.talker);
            com_tencent_mm_protocal_c_byu.nje = i(NH.talker, arrayList);
            com_tencent_mm_protocal_c_byu.wYS = this.fnm;
            com_tencent_mm_protocal_c_byu.wYU = this.fBx;
            com_tencent_mm_protocal_c_byu.wYT = !bh.cgw();
            Bitmap NL = h.NL(NH.talker);
            if (NL != null) {
                com_tencent_mm_protocal_c_byu.wYy = new b(h.M(NL));
            }
            x.d("MicroMsg.WearNotificationCreateTask", "generate notification content and ready to send");
            try {
                a.bOt();
                r.a(20003, com_tencent_mm_protocal_c_byu.toByteArray(), true);
            } catch (IOException e) {
            }
            x.d("MicroMsg.WearNotificationCreateTask", "start to update notification status");
            a.bOt().thJ.a(NH);
            a.bOt().thJ.NK(this.talker);
            com.tencent.mm.plugin.wear.model.c.a.ee(6, 0);
            com.tencent.mm.plugin.wear.model.c.a.zA(1);
        }
    }
}
