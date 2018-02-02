package com.tencent.mm.plugin.dbbackup;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.io.File;
import java.util.Arrays;
import java.util.List;

class d$4 implements Runnable {
    final /* synthetic */ String gIn;
    final /* synthetic */ b lpY;
    final /* synthetic */ d lqk;
    final /* synthetic */ File lqp;

    d$4(d dVar, File file, String str, b bVar) {
        this.lqk = dVar;
        this.lqp = file;
        this.gIn = str;
        this.lpY = bVar;
    }

    public final void run() {
        int i;
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
        }
        ar.Hg();
        String FB = c.FB();
        String str = FB + this.lqp.getName().replace(".db", "temp.db");
        x.i("MicroMsg.SubCoreDBBackup", "temp db path is %s", new Object[]{str});
        this.lqp.renameTo(new File(str));
        String str2 = FB + "sqlTemp.sql";
        List asList = Arrays.asList(new String[]{"getcontactinfo", "contact", "contact_ext", "ContactCmdBuf", "rcontact", "img_flag", "userinfo"});
        int[] iArr = new int[1];
        long currentTimeMillis = System.currentTimeMillis();
        ar.Hg();
        boolean a = c.EV().a(str, this.gIn, str2, asList, new 1(this, iArr));
        if (a) {
            ar.Hg();
            c.Fa().aZm();
            ar.Hg();
            c.Fd().ciC();
            ar.Hg();
            c.Fa().aZo();
            ar.Hg();
            c.Fa().aZn();
            i = 12;
        } else {
            i = 15;
        }
        g.pQN.a(181, (long) i, 1, true);
        x.i("MicroMsg.SubCoreDBBackup", "execute %d sql and last %d", new Object[]{Integer.valueOf(iArr[0]), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        g gVar = g.pQN;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(a ? 1 : 0);
        objArr[1] = iArr;
        objArr[2] = Long.valueOf(r2);
        gVar.h(11224, objArr);
        ar.Dm().cfE();
        if (this.lpY != null) {
            this.lpY.ou(a ? 0 : -1);
        }
    }
}
