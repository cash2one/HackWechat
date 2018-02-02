package com.tencent.mm.plugin.accountsync.a;

import com.tencent.mm.by.h.d;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.plugin.accountsync.model.a;
import com.tencent.mm.plugin.messenger.foundation.a.m;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.ar;
import java.io.File;
import java.util.HashMap;

public final class c implements ap {
    private static int hUu = 0;
    public static int ikG = a.ikN;
    private static ak ikI = null;
    private a ikF = null;
    private a ikH;
    private m ikJ = new 2(this);
    private com.tencent.mm.sdk.b.c ikK = new 3(this);

    static /* synthetic */ void oJ(String str) {
        x.i("MicroMsg.SubCoreAccountSync", "filePath: %s", new Object[]{str});
        if (!bh.ov(str)) {
            File file = new File(str);
            if (file.exists()) {
                String str2 = e.gZK + "splashWelcomeImg";
                if (b.deleteFile(str2)) {
                    com.tencent.mm.a.e.x(file.getAbsolutePath(), str2);
                }
            }
        }
    }

    static /* synthetic */ int vC() {
        int i = hUu;
        hUu = i + 1;
        return i;
    }

    public final void onAccountRelease() {
        com.tencent.mm.sdk.b.a.xef.c(this.ikH.ikV);
        this.ikH = null;
        ((n) g.k(n.class)).getSysCmdMsgExtension().b("ChangeLaunchImage", this.ikJ);
        this.ikK.dead();
    }

    public final HashMap<Integer, d> Bn() {
        return null;
    }

    public final void gd(int i) {
    }

    public final void bq(boolean z) {
        this.ikH = new a();
        ((n) g.k(n.class)).getSysCmdMsgExtension().a("ChangeLaunchImage", this.ikJ);
        this.ikK.ceO();
        com.tencent.mm.pluginsdk.i.a.b.b.c.bZm();
        com.tencent.mm.pluginsdk.i.a.b.b.BH(43);
    }

    public final void br(boolean z) {
    }

    public static void je(int i) {
        ikG = i;
        switch (4.ikM[i - 1]) {
            case 1:
                hUu = 0;
                if (ikI == null) {
                    ikI = new ak(new 1(), true);
                }
                x.d("MicroMsg.SubCoreAccountSync", "[oneliang][SmsVerifyCodeState]Sent");
                ikI.J(900000, 900000);
                return;
            case 2:
            case 3:
                if (ikI != null) {
                    ikI.TG();
                }
                x.d("MicroMsg.SubCoreAccountSync", "[oneliang][SmsVerifyCodeState]verified");
                ikG = a.ikN;
                ar.getNotification().xa();
                hUu = 0;
                ikI = null;
                return;
            default:
                return;
        }
    }
}
