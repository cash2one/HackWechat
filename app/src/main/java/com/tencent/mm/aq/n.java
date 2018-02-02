package com.tencent.mm.aq;

import android.graphics.Bitmap;
import com.tencent.mm.a.b;
import com.tencent.mm.a.e;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.j.a.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.report.service.f;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.bc;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public class n {
    private static n hBY;
    ConcurrentHashMap<Long, d> hBW = new ConcurrentHashMap();
    public c hBX = new c();
    public ConcurrentHashMap<Long, e> hBZ = new ConcurrentHashMap();
    private ArrayList<Long> hCa = new ArrayList();
    ArrayList<e> hCb = new ArrayList();

    public static n Pn() {
        if (hBY == null) {
            synchronized (n.class) {
                if (hBY == null) {
                    hBY = new n();
                }
            }
        }
        return hBY;
    }

    public final ArrayList<Integer> lp(String str) {
        Collection<e> values = this.hBZ.values();
        for (e eVar : values) {
            PString pString = new PString();
            PInt pInt = new PInt();
            PInt pInt2 = new PInt();
            eVar.hCq = o.Pw().a(eVar.hCn, eVar.hzT, eVar.cOY, eVar.fyR, pString, pInt, pInt2, eVar.hCo, eVar.hCp, eVar.fqm, eVar.hCu, eVar.hCv, eVar.hCw);
            cf dH = ((h) g.h(h.class)).aZi().dH(eVar.fqm);
            if (bh.ov(dH.field_imgPath)) {
                dH.dT(pString.value);
                dH.fc(pInt.value);
                dH.fd(pInt2.value);
                ((h) g.h(h.class)).aZi().a(eVar.fqm, dH);
            }
        }
        if (!bh.ov(str)) {
            for (e eVar2 : values) {
                if (!str.equals(eVar2.toUserName)) {
                    this.hBZ.remove(Long.valueOf(eVar2.fqm));
                    this.hCa.remove(Long.valueOf(eVar2.fqm));
                    x.e("MicroMsg.SendImgSpeeder", "fatal!! Send user mis-match, want:%s, fact:%s", new Object[]{str, eVar2.toUserName});
                }
            }
        }
        ArrayList<Integer> arrayList = new ArrayList();
        for (int i = 0; i < this.hCa.size(); i++) {
            arrayList.add(Integer.valueOf((int) ((e) this.hBZ.get(this.hCa.get(i))).hCq));
        }
        this.hBZ.clear();
        this.hCa.clear();
        x.i("MicroMsg.SendImgSpeeder", "syncImgData, id size %d", new Object[]{Integer.valueOf(arrayList.size())});
        return arrayList;
    }

    public final boolean bk(long j) {
        return this.hBW.containsKey(Long.valueOf(j));
    }

    public final d bl(long j) {
        return (d) this.hBW.get(Long.valueOf(j));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(ArrayList<String> arrayList, boolean z, int i, int i2, String str, int i3) {
        x.i("MicroMsg.SendImgSpeeder", "summersafecdn sendThumbImg fileSize:%d, compressImg[%b], source[%d], user:%s", new Object[]{Integer.valueOf(arrayList.size()), Boolean.valueOf(z), Integer.valueOf(i), str});
        Iterator it = this.hCb.iterator();
        while (it.hasNext()) {
            e eVar = (e) it.next();
            if (arrayList.contains(eVar.hCn) && (bh.ov(eVar.toUserName) || eVar.toUserName.equalsIgnoreCase(str))) {
                if (!bh.ov(str)) {
                }
                eVar.hzT = b(eVar.hCn, str, z);
            }
            it.remove();
        }
        ArrayList arrayList2 = new ArrayList();
        if (arrayList.size() == 9) {
            f.vz(18);
        } else if (arrayList.size() == 1) {
            boolean isWifi = an.isWifi(ac.getContext());
            f.vz(25);
            if (isWifi) {
                if (q.a((String) arrayList.get(0), str, z)) {
                    f.vz(23);
                } else {
                    f.vz(21);
                }
            }
        } else {
            f.vz(24);
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            String str2 = (String) it2.next();
            if (str2 == null || str2.equals("") || !e.bO(str2)) {
                x.d("MicroMsg.SendImgSpeeder", " doSendImage : filePath is null or empty");
            } else if (p.UR(str2)) {
                x.i("MicroMsg.SendImgSpeeder", "[cpan] is gif coutinue. did not add filePath:%s filesize:%d", new Object[]{str2, Integer.valueOf(e.bN(str2))});
            } else if (!lq(str2)) {
                arrayList2.add(str2);
            }
        }
        Iterator it3 = arrayList2.iterator();
        while (it3.hasNext()) {
            a(i, i2, (String) it3.next(), str, z, i3);
        }
        ArrayList arrayList3 = new ArrayList();
        long dz = g.Dj().gQj.dz(Thread.currentThread().getId());
        ((h) g.h(h.class)).aZi().Et("SendImgSpeeder");
        Object obj = 1;
        int i4 = 0;
        while (i4 < this.hCb.size()) {
            Object obj2;
            eVar = (e) this.hCb.get(i4);
            if (p.UR(eVar.hCn)) {
                x.i("MicroMsg.SendImgSpeeder", "[cpan] is gif coutinue. did not add to msg table");
                obj2 = obj;
            } else {
                cf auVar = new au();
                auVar.setType(s.hq(str));
                auVar.dS(str);
                auVar.eR(1);
                auVar.eQ(1);
                auVar.dT(eVar.hCr.value);
                auVar.fc(eVar.hCs.value);
                auVar.fd(eVar.hCt.value);
                String HD = bc.HD();
                if (!(HD == null || HD.equals(auVar.gjF)) || (HD == null && auVar.gjF != null)) {
                    auVar.dY(HD);
                }
                a.xD().b(auVar);
                auVar.aq(ba.hR(auVar.field_talker));
                arrayList3.add(auVar);
                long Q = ((h) g.h(h.class)).aZi().Q(auVar);
                Assert.assertTrue(Q >= 0);
                eVar.fqm = Q;
                this.hBZ.put(Long.valueOf(eVar.fqm), eVar);
                this.hCa.add(Long.valueOf(eVar.fqm));
                obj2 = null;
            }
            i4++;
            obj = obj2;
        }
        this.hCb.clear();
        if (dz > 0) {
            g.Dj().gQj.fS(dz);
        }
        if (obj != null) {
            ((h) g.h(h.class)).aZi().Eu("SendImgSpeeder");
        }
    }

    private boolean lq(String str) {
        Iterator it = this.hCb.iterator();
        while (it.hasNext()) {
            if (((e) it.next()).hCn.equals(str)) {
                return true;
            }
        }
        return false;
    }

    private boolean Po() {
        if (this.hCb.size() <= 0 || f.a.bom().pQJ > 2) {
            return true;
        }
        x.i("MicroMsg.SendImgSpeeder", "cpu core is low ,do not use multi mode");
        return false;
    }

    public final void a(int i, int i2, String str, String str2, boolean z, int i3) {
        if (!lq(str)) {
            b bVar;
            b bVar2;
            String str3;
            String str4;
            int b = b(str, str2, z);
            PString pString = new PString();
            PInt pInt = new PInt();
            PInt pInt2 = new PInt();
            if (Po()) {
                b hX = this.hBX.hX(1);
                b hX2 = this.hBX.hX(2);
                b bVar3 = hX.hCj;
                bVar = hX2.hCj;
                bVar2 = bVar3;
                str3 = hX2.hCk;
                str4 = hX.hCk;
            } else {
                bVar = null;
                bVar2 = null;
                str3 = null;
                str4 = null;
            }
            g Pw = o.Pw();
            if (FileOp.bO(str)) {
                String str5 = "THUMBNAIL_DIRPATH://th_" + (bh.ov(str3) ? g.Ph() : str3);
                String a = Pw.a(str5, "th_", "", false);
                pString.value = str5;
                long Wq = bh.Wq();
                Bitmap a2 = Pw.a(str, b, i2, pInt, pInt2, false, null, null);
                str5 = (String) Pw.hAx.get(str);
                Object obj = str5 != null ? (Bitmap) Pw.hAw.get(str5) : null;
                if (obj == null || obj.isRecycled()) {
                    obj = Pw.a(str, true, com.tencent.mm.bv.a.getDensity(ac.getContext()), false, false, true, i3, true, a2);
                    Pw.hAx.put(str, a);
                }
                if (obj != null) {
                    Pw.hAw.l(a, obj);
                }
                x.i("MicroMsg.ImgInfoStorage", "test decode thumb img:%d", new Object[]{Long.valueOf(bh.bA(Wq))});
            } else {
                x.e("MicroMsg.ImgInfoStorage", "file not exit:%s", new Object[]{str});
            }
            e eVar = new e();
            eVar.hCn = str;
            eVar.hzT = b;
            eVar.cOY = i;
            eVar.fyR = i2;
            eVar.hCo = str3;
            eVar.hCr = pString;
            eVar.hCt = pInt2;
            eVar.hCs = pInt;
            eVar.hCp = str4;
            eVar.hCv = bVar;
            eVar.hCu = bVar2;
            if (hBY.Po()) {
                a.a(eVar);
            }
            eVar.toUserName = str2;
            this.hCb.add(eVar);
            x.i("MicroMsg.SendImgSpeeder", "summersafecdn img path %s has prebuild, user:%s", new Object[]{str, str2});
        }
    }

    private static int b(String str, String str2, boolean z) {
        return q.a(str, str2, z) ? 1 : 0;
    }
}
