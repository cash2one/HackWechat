package com.tencent.mm.plugin.backup.i;

import android.content.Intent;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.by.h.d;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.backup.i.b.1;
import com.tencent.mm.plugin.backup.i.b.2;
import com.tencent.mm.plugin.backup.i.b.3;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.ar;
import java.util.HashMap;

public final class a implements ap {
    public static a kum;
    private c kun = new 1(this);
    private c kuo = new 2(this);
    private c kup = new 3(this);
    private c kuq = new 4(this);
    private com.tencent.mm.z.bs.a kur = new com.tencent.mm.z.bs.a(this) {
        final /* synthetic */ a kus;

        {
            this.kus = r1;
        }

        public final void a(com.tencent.mm.ae.d.a aVar) {
            x.i("MicroMsg.BackupCore.BackupToPc", "backupcore onreceiveMsg");
            g.pQN.a(400, 0, 1, false);
            String str = (String) bi.y(n.a(aVar.hmq.vGZ), "sysmsg").get(".sysmsg.MMBakChatNotify.url");
            if (bh.ov(str)) {
                x.e("MicroMsg.BackupCore.BackupToPc", "MMBakChatNotify url is null");
            }
            Intent className = new Intent().setClassName(ac.getContext(), "com.tencent.mm.plugin.backup.backuppcmodel.BackupPcService");
            Intent z = bh.z(ac.getContext(), className);
            if (z == null) {
                z = className;
            }
            ac.getContext().startService(z.putExtra(SlookSmartClipMetaTag.TAG_TYPE_URL, str).putExtra("isFromWifi", true));
        }
    };

    public a() {
        x.i("MicroMsg.BackupCore", "BackupCore init");
    }

    public final HashMap<Integer, d> Bn() {
        return null;
    }

    public final void gd(int i) {
    }

    public final void bq(boolean z) {
        b aqR = b.aqR();
        x.i("MicroMsg.BackupEventListener", "init addListener");
        aqR.kuv = new 1(aqR);
        com.tencent.mm.sdk.b.a.xef.b(aqR.kuv);
        aqR.kuw = new 2(aqR);
        com.tencent.mm.sdk.b.a.xef.b(aqR.kuw);
        aqR.bannerOnInitListener = new 3(aqR);
        com.tencent.mm.sdk.b.a.xef.b(aqR.bannerOnInitListener);
        ar.getSysCmdMsgExtension().a("MMBakChatNotify", this.kur, true);
        com.tencent.mm.sdk.b.a.xef.a(this.kun);
        com.tencent.mm.sdk.b.a.xef.a(this.kuo);
        com.tencent.mm.sdk.b.a.xef.a(this.kup);
        com.tencent.mm.sdk.b.a.xef.a(this.kuq);
    }

    public final void br(boolean z) {
    }

    public final void onAccountRelease() {
        b aqR = b.aqR();
        com.tencent.mm.sdk.b.a.xef.c(aqR.kuv);
        com.tencent.mm.sdk.b.a.xef.c(aqR.kuw);
        com.tencent.mm.sdk.b.a.xef.c(aqR.bannerOnInitListener);
        ar.getSysCmdMsgExtension().b("MMBakChatNotify", this.kur, true);
        com.tencent.mm.sdk.b.a.xef.c(this.kun);
        com.tencent.mm.sdk.b.a.xef.c(this.kuo);
        com.tencent.mm.sdk.b.a.xef.c(this.kup);
        com.tencent.mm.sdk.b.a.xef.c(this.kuq);
    }
}
