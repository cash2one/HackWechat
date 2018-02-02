package com.tencent.mm.plugin.emoji.c;

import com.tencent.mm.g.a.lu;
import com.tencent.mm.plugin.emoji.f.e;
import com.tencent.mm.plugin.emoji.f.n;
import com.tencent.mm.plugin.emoji.f.s;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.sync.a.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.util.ArrayList;
import java.util.List;

public final class a extends c<lu> {
    public a() {
        this.xen = lu.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        aAM();
        ar.Hg();
        boolean booleanValue = ((Boolean) com.tencent.mm.z.c.CU().get(com.tencent.mm.storage.w.a.xno, Boolean.valueOf(true))).booleanValue();
        ar.Hg();
        boolean z = System.currentTimeMillis() - ((Long) com.tencent.mm.z.c.CU().get(com.tencent.mm.storage.w.a.xnr, Long.valueOf(0))).longValue() > 86400000 && booleanValue;
        if (z) {
            ar.CG().a(new e(), 0);
        }
        et(false);
        es(false);
        ar.Hg();
        if (((Boolean) com.tencent.mm.z.c.CU().get(com.tencent.mm.storage.w.a.xnk, Boolean.valueOf(false))).booleanValue()) {
            ar.Hg();
            Object obj = com.tencent.mm.z.c.CU().get(com.tencent.mm.storage.w.a.xni, null);
            long longValue = (obj == null || !(obj instanceof Long)) ? 0 : ((Long) obj).longValue();
            if (System.currentTimeMillis() - longValue > 86400000) {
                z = true;
                if (z) {
                    ar.CG().a(new n(8, 15), 0);
                }
                ar.Hg();
                if (System.currentTimeMillis() - ((Long) com.tencent.mm.z.c.CU().get(com.tencent.mm.storage.w.a.xnu, Long.valueOf(0))).longValue() > 86400000) {
                    int lI = i.aBE().lwL.lI(false);
                    g.pQN.h(11597, new Object[]{Integer.valueOf(lI)});
                    ar.Hg();
                    com.tencent.mm.z.c.CU().a(com.tencent.mm.storage.w.a.xnu, Long.valueOf(System.currentTimeMillis()));
                }
                return false;
            }
        }
        z = false;
        if (z) {
            ar.CG().a(new n(8, 15), 0);
        }
        ar.Hg();
        if (System.currentTimeMillis() - ((Long) com.tencent.mm.z.c.CU().get(com.tencent.mm.storage.w.a.xnu, Long.valueOf(0))).longValue() > 86400000) {
            int lI2 = i.aBE().lwL.lI(false);
            g.pQN.h(11597, new Object[]{Integer.valueOf(lI2)});
            ar.Hg();
            com.tencent.mm.z.c.CU().a(com.tencent.mm.storage.w.a.xnu, Long.valueOf(System.currentTimeMillis()));
        }
        return false;
    }

    public static void es(boolean z) {
        long j;
        ar.Hg();
        Object obj = com.tencent.mm.z.c.CU().get(com.tencent.mm.storage.w.a.xnh, null);
        if (obj == null || !(obj instanceof Long)) {
            j = 0;
        } else {
            j = ((Long) obj).longValue();
        }
        if ((System.currentTimeMillis() - j > 86400000) || z) {
            x.i("MicroMsg.emoji.EmojiPostTaskListener", "uploadStoreEmoji need upload:%b", new Object[]{Boolean.valueOf(i.aBE().lwM.ckn())});
            if (i.aBE().lwM.ckn() || z) {
                ar.CG().a(new s(i.aBE().lwM.ckp(), 1), 0);
                return;
            }
            ar.Hg();
            com.tencent.mm.z.c.CU().a(com.tencent.mm.storage.w.a.xnk, Boolean.valueOf(true));
        }
    }

    public static void et(boolean z) {
        ar.Hg();
        boolean z2;
        if (bh.a((Boolean) com.tencent.mm.z.c.CU().get(348165, null), false)) {
            long j;
            ar.Hg();
            Object obj = com.tencent.mm.z.c.CU().get(348166, null);
            if (obj == null || !(obj instanceof Long)) {
                j = 0;
            } else {
                j = ((Long) obj).longValue();
            }
            if (System.currentTimeMillis() - j > 3600000) {
                int i = 1;
            } else {
                z2 = false;
            }
        } else {
            z2 = false;
        }
        if (i != 0 || z) {
            ArrayList ckH = i.aBE().lwL.ckH();
            if (ckH.size() > 0) {
                x.i("MicroMsg.emoji.EmojiPostTaskListener", "try to sync emoji uploadEmojiList:%d", new Object[]{Integer.valueOf(ckH.size())});
                List arrayList = new ArrayList();
                int size = ckH.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.add(new d((String) ckH.get(i2)));
                    x.i("MicroMsg.emoji.EmojiPostTaskListener", "try to sync emoji upload Emoji:%s", new Object[]{ckH.get(i2)});
                }
                i.aBB().lzq.aB(arrayList);
                i.aBB().lzq.aBZ();
            } else {
                x.i("MicroMsg.emoji.EmojiPostTaskListener", "no things need to upload.");
                ar.Hg();
                com.tencent.mm.z.c.CU().set(348165, Boolean.valueOf(false));
            }
            ar.Hg();
            com.tencent.mm.z.c.CU().set(348166, Long.valueOf(System.currentTimeMillis()));
        }
    }

    public static void aAM() {
        ar.Hg();
        boolean a = bh.a((Boolean) com.tencent.mm.z.c.CU().get(348162, null), false);
        ar.Hg();
        boolean z;
        if (bh.a((Boolean) com.tencent.mm.z.c.CU().get(com.tencent.mm.storage.w.a.xng, null), false) || !a) {
            z = false;
        } else {
            long j;
            ar.Hg();
            Object obj = com.tencent.mm.z.c.CU().get(348163, null);
            if (obj == null || !(obj instanceof Long)) {
                j = 0;
            } else {
                j = ((Long) obj).longValue();
            }
            if (System.currentTimeMillis() - j > 3600000) {
                int i = 1;
            } else {
                z = false;
            }
        }
        if (i != 0) {
            x.i("MicroMsg.emoji.EmojiPostTaskListener", "[cpan] start do backup emoji.");
            ArrayList arrayList = (ArrayList) i.aBE().lwL.ckD();
            if (arrayList.size() <= 0) {
                x.i("MicroMsg.emoji.EmojiPostTaskListener", "[cpan] no local emoji need not to backup ");
                ar.Hg();
                com.tencent.mm.z.c.CU().set(348162, Boolean.valueOf(false));
                return;
            }
            ar.Hg();
            com.tencent.mm.z.c.CU().set(348163, Long.valueOf(System.currentTimeMillis()));
            x.i("MicroMsg.emoji.EmojiPostTaskListener", "[cpan] start backup local emoji ");
            if (arrayList.size() > 50) {
                int size = arrayList.size();
                x.i("MicroMsg.emoji.EmojiPostTaskListener", "count:%d", new Object[]{Integer.valueOf(size / 50)});
                for (int i2 = 0; i2 <= r6; i2++) {
                    ArrayList arrayList2 = new ArrayList();
                    int i3 = i2 * 50;
                    int i4 = ((i2 + 1) * 50) + -1 >= size ? size : (i2 + 1) * 50;
                    x.i("MicroMsg.emoji.EmojiPostTaskListener", "start index:%d to index:%d", new Object[]{Integer.valueOf(i3), Integer.valueOf(i4)});
                    if (i4 > i3) {
                        arrayList2.addAll(arrayList.subList(i3, i4));
                        ar.CG().a(new com.tencent.mm.plugin.emoji.f.d(arrayList2), 0);
                    }
                }
                return;
            }
            ar.CG().a(new com.tencent.mm.plugin.emoji.f.d(arrayList), 0);
        }
    }
}
