package com.tencent.mm.plugin.clean.b;

import android.database.Cursor;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.clean.c.h;
import com.tencent.mm.plugin.clean.c.i;
import com.tencent.mm.plugin.i.b.a;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.HashSet;
import java.util.List;

public final class b implements Runnable {
    private long leZ = 0;
    private List<String> lfd;
    private List<i> lfe;
    private h lff;

    public b(List<String> list, List<i> list2, h hVar) {
        this.lfd = list;
        this.lfe = list2;
        this.lff = hVar;
    }

    private void au(List<a> list) {
        int size = list.size();
        HashSet hashSet = new HashSet();
        ar.Hg();
        long dz = c.EV().dz(Thread.currentThread().getId());
        for (int i = 0; i < size; i++) {
            a aVar = (a) list.get(i);
            long Wq = bh.Wq();
            if (!hashSet.contains(Long.valueOf(aVar.field_msgId))) {
                ar.Hg();
                cf dH = c.Fa().dH(aVar.field_msgId);
                if (!(dH.field_msgId == 0 || dH.cjs())) {
                    com.tencent.mm.plugin.i.b asG = com.tencent.mm.plugin.i.b.asG();
                    long j = aVar.field_msgId;
                    asG.kHG = true;
                    asG.kHF.add(Long.valueOf(j));
                    x.d("MicroMsg.CalcWxService", "%d lock msg change [%d] [%s]", new Object[]{Integer.valueOf(asG.hashCode()), Long.valueOf(j), bh.cgy()});
                    dH.cjt();
                    ar.Hg();
                    c.Fa().a(aVar.field_msgId, dH);
                }
                hashSet.add(Long.valueOf(aVar.field_msgId));
                x.d("MicroMsg.DeleteFileByWxIndex", "%s deleteByIndex handle msg[%d]", new Object[]{asN(), Long.valueOf(bh.bA(Wq))});
            }
            if (!(aVar == null || com.tencent.mm.plugin.i.a.nA(aVar.field_msgSubType) || aVar.field_size <= 0)) {
                this.leZ += aVar.field_size;
                FileOp.deleteFile(g.Dj().gQh + aVar.field_path);
                aVar.field_path = "";
                aVar.field_size = 0;
                com.tencent.mm.plugin.i.b.asG().asH().a(aVar.xjy, aVar, false);
            }
            x.d("MicroMsg.DeleteFileByWxIndex", "%s deleteByIndex[%d]", new Object[]{asN(), Long.valueOf(bh.bA(Wq))});
        }
        ar.Hg();
        c.EV().fS(dz);
    }

    public final void run() {
        long j;
        int i;
        if (this.lfd != null) {
            long Wq = bh.Wq();
            int size = this.lfd.size();
            int i2 = 0;
            for (String str : this.lfd) {
                if (!bh.ov(str)) {
                    long Wq2 = bh.Wq();
                    PLong pLong = new PLong();
                    PLong pLong2 = new PLong();
                    com.tencent.mm.plugin.i.b.b asH = com.tencent.mm.plugin.i.b.asG().asH();
                    long Wq3 = bh.Wq();
                    String str2 = "select max(msgtime), min(msgtime) from WxFileIndex2 where username='" + str + "' and msgSubType in (1,20,23,30,32,34 ) and size" + " > 0 ";
                    Cursor cursor = null;
                    try {
                        cursor = asH.gJP.rawQuery(str2, null);
                        if (cursor != null && cursor.moveToFirst()) {
                            pLong.value = cursor.getLong(0);
                            pLong2.value = cursor.getLong(1);
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.WxFileIndexStorage", e, " sql [%s]", new Object[]{str2});
                        if (cursor != null) {
                            cursor.close();
                        }
                    } catch (Throwable th) {
                        if (cursor != null) {
                            cursor.close();
                        }
                    }
                    x.i("MicroMsg.WxFileIndexStorage", "getNoThumbMediaMsgTimeByUsername [%s] cost[%d]", new Object[]{str, Long.valueOf(bh.bA(Wq3))});
                    pLong2.value--;
                    j = pLong.value;
                    Wq3 = Math.max(j - 2592000000L, pLong2.value);
                    if (Wq3 == j) {
                        Wq3--;
                    }
                    List g = com.tencent.mm.plugin.i.b.asG().asH().g(str, j, Wq3);
                    j = 0 + ((long) g.size());
                    au(g);
                    long j2 = j;
                    j = Wq3;
                    while (j > pLong2.value) {
                        Wq3 = Math.max(j - 2592000000L, pLong2.value);
                        if (Wq3 == j) {
                            Wq3--;
                        }
                        g = com.tencent.mm.plugin.i.b.asG().asH().g(str, j, Wq3);
                        j = ((long) g.size()) + j2;
                        au(g);
                        j2 = j;
                        j = Wq3;
                    }
                    x.i("MicroMsg.DeleteFileByWxIndex", "%s deleteByName [%s] [%d] [%d %d] cost[%d]", new Object[]{asN(), str, Long.valueOf(j2), Long.valueOf(pLong2.value), Long.valueOf(pLong.value), Long.valueOf(bh.bA(Wq2))});
                }
                i = i2 + 1;
                if (this.lff != null) {
                    this.lff.cl(i, size);
                }
                i2 = i;
            }
            if (this.lff != null) {
                this.lff.bW(this.leZ);
            }
            com.tencent.mm.plugin.i.b.asG().asK();
            x.i("MicroMsg.DeleteFileByWxIndex", "%s deleteByUsername cost[%d]", new Object[]{asN(), Long.valueOf(bh.bA(Wq))});
        } else if (this.lfe != null) {
            j = bh.Wq();
            int size2 = this.lfe.size();
            int i3 = 0;
            for (i iVar : this.lfe) {
                au(iVar.lfI);
                i = i3 + 1;
                if (this.lff != null) {
                    this.lff.cl(i, size2);
                }
                i3 = i;
            }
            if (this.lff != null) {
                this.lff.bW(this.leZ);
            }
            com.tencent.mm.plugin.i.b.asG().asK();
            x.i("MicroMsg.DeleteFileByWxIndex", "%s deleteByNewAnalyseItem cost[%d]", new Object[]{asN(), Long.valueOf(bh.bA(j))});
        }
    }

    private String asN() {
        return hashCode();
    }
}
