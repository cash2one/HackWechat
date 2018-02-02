package com.tencent.mm.plugin.clean.c;

import android.database.Cursor;
import android.os.Looper;
import android.os.StatFs;
import com.tencent.mm.aq.e;
import com.tencent.mm.aq.o;
import com.tencent.mm.g.b.aj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.plugin.clean.c.a.a$a;
import com.tencent.mm.plugin.clean.c.a.b;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.g$a;
import com.tencent.mm.z.ar;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.xwalk.core.R$styleable;

public final class c implements a$a, Runnable {
    private static final Long leU = Long.valueOf(604800000);
    private static final Long leV = Long.valueOf(7776000000L);
    private static final int lfh = (com.tencent.mm.z.c.FC().length() - 1);
    private long endTime = 0;
    private af hae = new af(Looper.getMainLooper());
    public boolean isStop;
    private long leX;
    private long leY;
    private b lfi;
    private g lfj;
    private int lfk = 0;
    private int lfl = 0;
    private ConcurrentHashMap<String, b> lfm = new ConcurrentHashMap();
    private long lfn;
    private long lfo;
    private HashSet<String> lfp = new HashSet();
    private HashSet<String> lfq = new HashSet();
    private boolean lfr = true;
    private int[] lfs = new int[10];
    private long startTime = 0;

    public class a extends com.tencent.mm.plugin.clean.c.a.a {
        final /* synthetic */ c lfu;
        private String username;

        public a(c cVar, String str) {
            this.lfu = cVar;
            super(cVar);
            this.username = str;
        }

        public final String TL() {
            return "username[" + this.username + "]" + super.TL();
        }

        public final void execute() {
            Throwable e;
            Cursor cursor;
            ar.Hg();
            int EP = com.tencent.mm.z.c.Fa().EP(this.username);
            if (EP <= 0) {
                x.i("MicroMsg.CleanController", "Finish user:%s allMsgCount[%d]", new Object[]{this.username, Integer.valueOf(EP)});
                return;
            }
            int a;
            b bVar = new b();
            bVar.username = this.username;
            bVar.lfg = new ArrayList();
            bVar.fwg = 0;
            Cursor cursor2 = null;
            int i = 0;
            while (i < EP) {
                try {
                    ar.Hg();
                    cursor2 = com.tencent.mm.z.c.Fa().L(this.username, i, 50);
                    if (cursor2 == null) {
                        break;
                    }
                    a = a(cursor2, bVar);
                    if (!(cursor2 == null || cursor2.isClosed())) {
                        cursor2.close();
                    }
                    if (a <= 0) {
                        break;
                    }
                    i += a;
                    if (this.lfu.isStop) {
                        break;
                    }
                } catch (Throwable e2) {
                    Throwable th = e2;
                    a = i;
                    cursor = cursor2;
                    x.printErrStackTrace("MicroMsg.CleanController", th, "execute analyse Task error.", new Object[0]);
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Throwable th2) {
                    e2 = th2;
                    cursor2 = cursor;
                }
            }
            a = i;
            if (cursor2 != null) {
                cursor2.close();
            }
            if (bVar.lfg.size() > 0) {
                this.lfu.lfm.put(this.username, bVar);
            }
            x.i("MicroMsg.CleanController", "Finish user:%s allMsgCount[%d] alreadyHandleCount[%d] isStop[%b] ", new Object[]{this.username, Integer.valueOf(EP), Integer.valueOf(a), Boolean.valueOf(this.lfu.isStop)});
            return;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw e2;
        }

        private int a(Cursor cursor, b bVar) {
            if (cursor.moveToFirst()) {
                int i = 0;
                a aVar = null;
                while (!cursor.isAfterLast()) {
                    i++;
                    au auVar = new au();
                    auVar.b(cursor);
                    switch (l.BG(auVar.getType())) {
                        case 3:
                            aVar = c.a(this.lfu, auVar, this.username);
                            break;
                        case R$styleable.AppCompatTheme_dialogPreferredPadding /*43*/:
                        case R$styleable.AppCompatTheme_listDividerAlertDialog /*44*/:
                        case 62:
                            aVar = c.b(auVar, this.username);
                            break;
                        case R$styleable.AppCompatTheme_actionButtonStyle /*49*/:
                            aVar = c.a(auVar, this.username);
                            break;
                    }
                    if (aVar != null) {
                        bVar.lfg.add(aVar);
                        bVar.fwg += aVar.size;
                        aVar = null;
                    }
                    if (cursor.moveToNext()) {
                        if (this.lfu.isStop) {
                        }
                    }
                    cursor.close();
                    return i;
                }
                cursor.close();
                return i;
            }
            x.d("MicroMsg.CleanController", "Message count of user:%s is empty", new Object[]{this.username});
            cursor.close();
            return 0;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ a a(c cVar, au auVar, String str) {
        e bi;
        String B = o.Pw().B(auVar.field_imgPath, true);
        if (auVar.field_isSend == 1) {
            bi = o.Pw().bi((long) ((int) auVar.field_msgId));
        }
        bi = o.Pw().bh(auVar.field_msgSvrId);
        a aVar = null;
        if (auVar.field_isSend == 1) {
            String m = o.Pw().m(bi.hzQ, "", "");
            if (bh.ov(m) || !com.tencent.mm.a.e.bO(m)) {
                return null;
            }
            x.v("MicroMsg.CleanController", "bigImgPath " + m + " " + com.tencent.mm.a.e.bN(m));
            return new a(B, m, 1, str, auVar.field_msgId, auVar.field_createTime);
        } else if (!bi.Pd()) {
            return null;
        } else {
            String m2 = o.Pw().m(bi.hzQ, "", "");
            Object obj = "";
            if (bi.Pe()) {
                e hQ;
                if (bi.Pe()) {
                    hQ = o.Pw().hQ(bi.hzZ);
                }
                hQ = bi;
                if (!(hQ == null || hQ.equals(bi))) {
                    obj = o.Pw().m(hQ.hzQ, "", "");
                    x.v("MicroMsg.CleanController", "hdPath " + obj + " " + com.tencent.mm.a.e.bN(obj));
                    if (com.tencent.mm.a.e.bO(obj)) {
                        aVar = new a(B, obj, 1, str, auVar.field_msgId, auVar.field_createTime);
                    }
                }
            }
            if (!com.tencent.mm.a.e.bO(m2) || bh.ov(m2) || m2.equals(r3)) {
                return aVar;
            }
            return new a(B, m2, 1, str, auVar.field_msgId, auVar.field_createTime);
        }
    }

    static /* synthetic */ a a(au auVar, String str) {
        String VH = bh.VH(auVar.field_content);
        g$a fT = VH != null ? g$a.fT(VH) : null;
        if (fT == null) {
            x.e("MicroMsg.CleanController", "content is null");
            return null;
        }
        String B = o.Pw().B(auVar.field_imgPath, true);
        com.tencent.mm.pluginsdk.model.app.b Rz;
        switch (fT.type) {
            case 2:
                Rz = an.aqd().Rz(fT.fny);
                if ((Rz == null || !Rz.aOC()) && (auVar.field_isSend != 1 || Rz == null || !Rz.field_isUpload)) {
                    return null;
                }
                String str2 = Rz.field_fileFullPath;
                if (!com.tencent.mm.a.e.bO(str2)) {
                    return null;
                }
                x.v("MicroMsg.CleanController", "image " + str2);
                return new a(B, str2, 1, str, auVar.field_msgId, auVar.field_createTime);
            case 6:
                Rz = an.aqd().Rz(fT.fny);
                if ((Rz == null || !Rz.aOC()) && (auVar.field_isSend != 1 || Rz == null || !Rz.field_isUpload)) {
                    return null;
                }
                x.v("MicroMsg.CleanController", "full path " + Rz.field_fileFullPath);
                if (!com.tencent.mm.a.e.bO(Rz.field_fileFullPath)) {
                    return null;
                }
                return new a(B, Rz.field_fileFullPath, 4, str, auVar.field_msgId, auVar.field_createTime);
            case 7:
                Rz = an.aqd().Rz(fT.fny);
                if ((Rz == null || !Rz.aOC()) && (auVar.field_isSend != 1 || Rz == null || !Rz.field_isUpload)) {
                    return null;
                }
                x.v("MicroMsg.CleanController", "full path " + Rz.field_fileFullPath);
                if (!com.tencent.mm.a.e.bO(Rz.field_fileFullPath)) {
                    return null;
                }
                return new a(B, Rz.field_fileFullPath, 4, str, auVar.field_msgId, auVar.field_createTime);
            default:
                return null;
        }
    }

    static /* synthetic */ boolean a(c cVar, String str) {
        if (!bh.ov(str)) {
            ar.Hg();
            if (!str.startsWith(com.tencent.mm.z.c.FC())) {
                Iterator it = cVar.lfp.iterator();
                while (it.hasNext()) {
                    String str2 = (String) it.next();
                    if (str.startsWith(g.Dj().gQh) && str.contains(str2)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    static /* synthetic */ a b(au auVar, String str) {
        com.tencent.mm.modelvideo.o.TU();
        String nt = s.nt(auVar.field_imgPath);
        String str2 = auVar.field_imgPath;
        if (!bh.ov(str2)) {
            com.tencent.mm.modelvideo.o.TU().nr(str2);
        }
        com.tencent.mm.modelvideo.o.TU();
        String nu = s.nu(auVar.field_imgPath);
        if (!new File(nt).exists()) {
            return null;
        }
        return new a(nu, nt, 3, str, auVar.field_msgId, auVar.field_createTime);
    }

    static {
        ar.Hg();
    }

    public c(b bVar, g gVar) {
        this.lfj = gVar;
        this.lfi = bVar;
    }

    public final void run() {
        int i;
        x.i("MicroMsg.CleanController", "Start to run clean controller");
        this.startTime = System.currentTimeMillis();
        long Wq = bh.Wq();
        String str = com.tencent.mm.compatible.util.e.bnF;
        x.v("MicroMsg.CleanController", "root path: %s", new Object[]{str});
        StringBuilder stringBuilder = new StringBuilder("mm");
        g.Dk();
        g.Dh();
        String s = com.tencent.mm.a.g.s(stringBuilder.append(com.tencent.mm.kernel.a.Cg()).toString().getBytes());
        ArrayList arrayList = new ArrayList();
        File file = new File(str);
        if (file.isDirectory()) {
            String[] list = file.list();
            if (list != null) {
                for (String str2 : list) {
                    String str3 = str + str2;
                    if (str2.length() >= 32) {
                        x.v("MicroMsg.CleanController", "add subfile list: %s uinPath %s ", new Object[]{str2, s});
                        Collection xm = xm(str3);
                        if (arrayList.size() > 0) {
                            if (!s.equals(str2)) {
                                x.i("MicroMsg.CleanController", "add other acc tmp path %s", new Object[]{str2});
                                this.lfp.add(str2);
                            }
                            arrayList.addAll(0, xm);
                        } else {
                            arrayList.addAll(xm);
                        }
                    } else {
                        x.v("MicroMsg.CleanController", "subfile: %s", new Object[]{str2});
                        if (arrayList.size() > 0) {
                            arrayList.add(0, str3);
                        } else {
                            arrayList.add(str3);
                        }
                    }
                }
            }
        } else {
            bQ((long) com.tencent.mm.a.e.bN(str));
        }
        int i2 = -1;
        int i3 = -1;
        for (i = 0; i < arrayList.size(); i++) {
            String str4 = (String) arrayList.get(i);
            if (str4.contains("image2")) {
                i2 = i;
            }
            if (str4.contains("voice2")) {
                i3 = i;
            }
        }
        if (i3 != -1) {
            arrayList.add(0, (String) arrayList.remove(i3));
        }
        if (i2 != -1) {
            arrayList.add(0, (String) arrayList.remove(i2));
        }
        x.d("MicroMsg.CleanController", "scan is finish [%s]", new Object[]{Long.valueOf(bh.bA(Wq))});
        long Wq2 = bh.Wq();
        ArrayList aye = aye();
        x.d("MicroMsg.CleanController", "user is finish [%s]", new Object[]{Long.valueOf(bh.bA(Wq2))});
        this.lfk = arrayList.size() + aye.size();
        if (this.lfk == 0) {
            x.i("MicroMsg.CleanController", "Clean Controller totalTaskCount=0");
            ayb();
            return;
        }
        x.i("MicroMsg.CleanController", "Clean Controller totalTaskCount=%d", new Object[]{Integer.valueOf(this.lfk)});
        i = 0;
        while (!this.isStop && i < arrayList.size()) {
            x.d("MicroMsg.CleanController", "while loop index=%d | filePath=%s", new Object[]{Integer.valueOf(i), (String) arrayList.get(i)});
            com.tencent.mm.plugin.clean.c.a.a bVar = new b(this, str4);
            while (!this.lfi.b(bVar)) {
                try {
                    Thread.sleep(2147483647L);
                } catch (InterruptedException e) {
                }
            }
            x.d("MicroMsg.CleanController", "Start task： filePath＝%s", new Object[]{str4});
            i++;
        }
        i = 0;
        while (!this.isStop && i < aye.size()) {
            x.d("MicroMsg.CleanController", "while loop index=%d | username=%s", new Object[]{Integer.valueOf(i), (String) aye.get(i)});
            bVar = new a(this, str4);
            while (!this.lfi.b(bVar)) {
                try {
                    Thread.sleep(2147483647L);
                } catch (InterruptedException e2) {
                }
            }
            x.d("MicroMsg.CleanController", "Start task： user＝%s", new Object[]{str4});
            i++;
        }
    }

    public final void a(com.tencent.mm.plugin.clean.c.a.a aVar) {
        if (aVar instanceof a) {
            x.d("MicroMsg.CleanController", "AnalyseTask is finish [%d] cost[%s]", new Object[]{Integer.valueOf(aVar.hashCode()), aVar.TL()});
        } else {
            x.d("MicroMsg.CleanController", "ScanSpaceTask is finish [%d] cost[%s]", new Object[]{Integer.valueOf(aVar.hashCode()), aVar.TL()});
        }
        com.tencent.mm.sdk.f.e.Q(this);
        this.lfl++;
        if (!(this.lfj == null || this.isStop)) {
            this.hae.post(new 2(this));
        }
        if (this.lfl == this.lfk) {
            ayb();
        }
    }

    private void ayb() {
        this.endTime = System.currentTimeMillis();
        x.i("MicroMsg.CleanController", "totalUserTime:%d", new Object[]{Long.valueOf(this.endTime - this.startTime)});
        if (this.lfj != null && !this.isStop) {
            Object arrayList = new ArrayList();
            for (b add : this.lfm.values()) {
                arrayList.add(add);
            }
            Collections.sort(arrayList);
            Collections.reverse(arrayList);
            this.hae.post(new 1(this, arrayList));
        }
    }

    public static long ayc() {
        long blockSize;
        try {
            StatFs statFs = new StatFs(com.tencent.mm.compatible.util.e.bnD);
            blockSize = ((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount());
        } catch (Exception e) {
            blockSize = 0;
        }
        return blockSize <= 0 ? 1 : blockSize;
    }

    public static long ayd() {
        long blockSize;
        try {
            StatFs statFs = new StatFs(com.tencent.mm.compatible.util.e.bnD);
            blockSize = ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
        } catch (Exception e) {
            blockSize = 0;
        }
        return blockSize <= 0 ? 1 : blockSize;
    }

    private static ArrayList<String> aye() {
        ArrayList<String> arrayList = new ArrayList();
        List linkedList = new LinkedList();
        for (Object add : com.tencent.mm.z.s.hfr) {
            linkedList.add(add);
        }
        ar.Hg();
        Cursor c = com.tencent.mm.z.c.Fd().c(com.tencent.mm.z.s.hfk, linkedList, "*");
        if (c.moveToFirst()) {
            do {
                aj aeVar = new ae();
                aeVar.b(c);
                if (!bh.ov(aeVar.field_username)) {
                    ar.Hg();
                    if (!com.tencent.mm.storage.x.Dn(com.tencent.mm.z.c.EY().WO(aeVar.field_username).field_verifyFlag)) {
                        arrayList.add(aeVar.field_username);
                    }
                }
                if (!c.moveToNext()) {
                    break;
                }
            } while (!c.isAfterLast());
        }
        c.close();
        return arrayList;
    }

    private static ArrayList<String> xm(String str) {
        ArrayList<String> arrayList = new ArrayList();
        File file = new File(str);
        if (file.isDirectory()) {
            String[] list = file.list();
            if (list == null || list.length <= 0) {
                arrayList.add(str);
            } else {
                for (String str2 : list) {
                    arrayList.add(str + File.separator + str2);
                }
            }
        } else {
            arrayList.add(str);
        }
        return arrayList;
    }

    private synchronized void bQ(long j) {
        if (j < 0) {
            x.w("MicroMsg.CleanController", "summerclean file size[%d] overlimit ", new Object[]{Long.valueOf(j)});
            this.lfo += 60;
        } else {
            this.lfo += j;
        }
    }
}
