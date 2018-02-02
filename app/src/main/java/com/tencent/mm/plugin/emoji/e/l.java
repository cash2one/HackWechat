package com.tencent.mm.plugin.emoji.e;

import android.content.Context;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.a;
import com.tencent.mm.storage.emotion.c;
import com.tencent.mm.storage.emotion.d;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.storage.emotion.h;
import com.tencent.mm.storage.emotion.j;
import com.tencent.mm.storage.emotion.n;
import com.tencent.mm.storage.emotion.p;
import com.tencent.mm.storage.emotion.r;
import com.tencent.mm.storage.emotion.t;
import com.tencent.mm.storage.w;
import com.tencent.mm.z.ar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class l {
    private static int fMG = -1;
    public static boolean lwW = false;
    public static boolean lwX = false;
    public static boolean lwY = false;
    public static boolean lwZ = false;
    public static ArrayList<EmojiGroupInfo> lxa = new ArrayList();
    public static HashMap<String, ArrayList<EmojiInfo>> lxb = new HashMap();
    public d lwL;
    public a lwM;
    public c lwN;
    public p lwO;
    public j lwP;
    public com.tencent.mm.storage.emotion.l lwQ;
    public h lwR;
    public n lwS;
    r lwT;
    t lwU;
    f lwV;
    public final com.tencent.mm.sdk.e.j.a lxc = new 1(this);
    public final com.tencent.mm.sdk.e.j.a lxd = new 2(this);
    public final com.tencent.mm.sdk.e.j.a lxe = new com.tencent.mm.sdk.e.j.a(this) {
        final /* synthetic */ l lxg;

        {
            this.lxg = r1;
        }

        public final void a(String str, com.tencent.mm.sdk.e.l lVar) {
            if (str != null) {
                if (str.equalsIgnoreCase("delete_emoji_info_notify")) {
                    l.lwX = true;
                } else if (g.Dh().Cy()) {
                    EmojiInfo yc = ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().yc(str);
                    if (yc != null && yc.field_catalog == EmojiInfo.xAk) {
                        l.lwX = true;
                    }
                }
            }
        }
    };
    public final com.tencent.mm.sdk.b.c lxf = new 4(this);

    public l() {
        ar.Hg();
        this.lwL = new d(com.tencent.mm.z.c.EV());
        ar.Hg();
        this.lwM = new a(com.tencent.mm.z.c.EV());
        ar.Hg();
        this.lwN = new c(com.tencent.mm.z.c.EV());
        ar.Hg();
        this.lwP = new j(com.tencent.mm.z.c.EV());
        ar.Hg();
        this.lwQ = new com.tencent.mm.storage.emotion.l(com.tencent.mm.z.c.EV());
        ar.Hg();
        this.lwR = new h(com.tencent.mm.z.c.EV());
        ar.Hg();
        this.lwO = new p(com.tencent.mm.z.c.EV());
        ar.Hg();
        this.lwS = new n(com.tencent.mm.z.c.EV());
        ar.Hg();
        this.lwT = new r(com.tencent.mm.z.c.EV());
        ar.Hg();
        this.lwU = new t(com.tencent.mm.z.c.EV());
        ar.Hg();
        this.lwV = new f(com.tencent.mm.z.c.EV());
    }

    public final void aBj() {
        Context context = ac.getContext();
        if (context != null) {
            ar.Hg();
            x.i("MicroMsg.emoji.EmojiStorageMgr", "[oneliang]initCore,need init emoji:%s", new Object[]{String.valueOf(((Boolean) com.tencent.mm.z.c.CU().get(274480, Boolean.valueOf(true))).booleanValue())});
            if (((Boolean) com.tencent.mm.z.c.CU().get(274480, Boolean.valueOf(true))).booleanValue()) {
                this.lwL.fl(context);
                this.lwM.fl(context);
            }
            ar.Hg();
            com.tencent.mm.z.c.CU().set(274480, Boolean.valueOf(false));
        }
        ar.Hg();
        if (((Integer) com.tencent.mm.z.c.CU().get(w.a.xnw, Integer.valueOf(0))).intValue() != com.tencent.mm.protocal.d.vAz) {
            long currentTimeMillis = System.currentTimeMillis();
            i.aBE().lwM.ckr();
            ar.Hg();
            com.tencent.mm.z.c.CU().a(w.a.xnw, Integer.valueOf(com.tencent.mm.protocal.d.vAz));
            x.i("MicroMsg.emoji.EmojiStorageMgr", "recoverCustomEmojiGroup use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        }
        ar.Hg();
        if (((Boolean) com.tencent.mm.z.c.CU().get(w.a.xnx, Boolean.valueOf(true))).booleanValue()) {
            long dz;
            com.tencent.mm.by.h hVar;
            int fS;
            long currentTimeMillis2 = System.currentTimeMillis();
            a aVar = i.aBE().lwM;
            if (aVar.gJP instanceof com.tencent.mm.by.h) {
                com.tencent.mm.by.h hVar2 = (com.tencent.mm.by.h) aVar.gJP;
                dz = hVar2.dz(Thread.currentThread().getId());
                hVar = hVar2;
            } else {
                hVar = null;
                dz = -1;
            }
            ArrayList cke = aVar.cke();
            if (!cke.isEmpty()) {
                Iterator it = cke.iterator();
                while (it.hasNext()) {
                    EmojiGroupInfo emojiGroupInfo = (EmojiGroupInfo) it.next();
                    if (!(emojiGroupInfo == null || bh.ov(emojiGroupInfo.field_productID))) {
                        int ym = aVar.ym(emojiGroupInfo.field_productID);
                        if (emojiGroupInfo.field_count != ym) {
                            emojiGroupInfo.field_count = ym;
                            aVar.gJP.update("EmojiGroupInfo", emojiGroupInfo.vI(), "productID=?", new String[]{emojiGroupInfo.field_productID});
                        }
                    }
                }
            }
            if (hVar != null) {
                fS = hVar.fS(dz);
            } else {
                fS = -1;
            }
            aVar.b("event_update_group", 0, bh.cgy().toString());
            Object obj = fS >= 0 ? 1 : null;
            ar.Hg();
            com.tencent.mm.z.c.CU().a(w.a.xnx, Boolean.valueOf(obj == null));
            x.i("MicroMsg.emoji.EmojiStorageMgr", "updateEmojiGroupCount use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis2)});
        }
    }

    public final d aqc() {
        return this.lwL;
    }

    public final ArrayList<EmojiGroupInfo> aBb() {
        if (lxa == null) {
            lxa = new ArrayList();
        }
        if (lxa.size() == 0 || lwW) {
            ar.Hg();
            if (com.tencent.mm.z.c.isSDCardAvailable()) {
                lxa = this.lwM.ckj();
            } else {
                lxa = (ArrayList) this.lwM.ckb();
            }
        }
        lwW = false;
        return lxa;
    }

    public final int aBc() {
        if (fMG == -1 || lwZ) {
            fMG = this.lwM.ckf();
        }
        return fMG;
    }

    public final ArrayList<EmojiInfo> aBd() {
        if (lxb == null) {
            lxb = new HashMap();
        }
        if (!lxb.containsKey("custom") || lwX) {
            lxb.put("custom", (ArrayList) this.lwL.ckC());
        }
        lwX = false;
        return (ArrayList) lxb.get("custom");
    }
}
