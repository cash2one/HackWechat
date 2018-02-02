package com.tencent.mm.plugin.product.b;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.product.c.a;
import com.tencent.mm.plugin.product.c.h;
import com.tencent.mm.plugin.product.c.l;
import com.tencent.mm.plugin.product.c.m;
import com.tencent.mm.plugin.product.ui.e;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.anm;
import com.tencent.mm.protocal.c.as;
import com.tencent.mm.protocal.c.aya;
import com.tencent.mm.protocal.c.bbk;
import com.tencent.mm.protocal.c.bds;
import com.tencent.mm.protocal.c.biu;
import com.tencent.mm.protocal.c.cb;
import com.tencent.mm.protocal.c.rc;
import com.tencent.mm.protocal.c.ti;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class c {
    public int mCount = 1;
    private d pdJ = null;
    public m pdK;
    public List<n> pdL;
    public String pdM;
    public String pdN;
    public String pdO;
    public ti pdP;
    public cb pdQ;
    public bbk pdR;
    public String pdS;
    public String pdT;
    public int pdU;
    public Map<String, e> pdV;
    public Map<String, String> pdW = new HashMap();
    public LinkedList<ti> pdX;
    public LinkedList<as> pdY;
    public e pdZ;
    private e pea;
    public Map<String, LinkedList<rc>> peb = null;

    public final void clear() {
        this.pdK = null;
        if (this.pdL != null) {
            this.pdL.clear();
            this.pdL = null;
        }
        this.pdM = null;
        this.pdN = null;
        this.mCount = 1;
        this.pdO = null;
        this.pdP = null;
        this.pdR = null;
        this.pdS = null;
        this.pdU = 0;
        this.pdZ = null;
        if (this.pdV != null) {
            this.pdV.clear();
            this.pdV = null;
        }
        if (this.pdW != null) {
            this.pdW.clear();
        }
        if (this.pdX != null) {
            this.pdX.clear();
            this.pdX = null;
        }
        if (this.peb != null) {
            this.peb.clear();
            this.peb = null;
        }
    }

    public final void a(m mVar, List<n> list) {
        int i;
        int i2 = 0;
        clear();
        this.pdK = mVar;
        this.pdL = list;
        if (bh.ov(this.pdK.pes)) {
            this.pdK.pes = this.pdN;
        }
        LinkedList linkedList = this.pdK.peq;
        this.pdV = new HashMap();
        if (linkedList != null && linkedList.size() > 0) {
            int size = linkedList.size();
            for (int i3 = 0; i3 < size; i3++) {
                l lVar = (l) linkedList.get(i3);
                a(lVar.peS.split(";"), lVar);
            }
            bje();
        }
        if (!(this.pdK.peo == null || this.pdK.peo.peJ == null)) {
            this.pdU = this.pdK.peo.peJ.size();
        }
        if (!(this.pdK.peo == null || this.pdK.peo.peC == null || this.pdK.peo.peC.size() <= 0)) {
            this.pdS = (String) this.pdK.peo.peC.get(0);
        }
        if (!bh.ov(this.pdK.bji())) {
            j.a(new com.tencent.mm.plugin.product.ui.c(this.pdK.bji()));
            x.d("MicroMsg.MallProductManager", "product img path : " + biW());
        }
        if (this.pdK.per == null || this.pdK.per.peN == null) {
            i = 0;
        } else {
            i = this.pdK.per.peN.fDt;
        }
        if (this.pdK.pep != null) {
            i2 = this.pdK.pep.fDt;
        }
        this.pea = new e(i, i2);
    }

    public final e biP() {
        if (this.pea == null) {
            this.pea = new e(0, 0);
        }
        return this.pea;
    }

    public final String biQ() {
        if (this.pdZ == null || bh.ov(this.pdZ.url)) {
            return this.pdS;
        }
        return this.pdZ.url;
    }

    public final String biR() {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = this.pdK.peo.peJ.iterator();
        while (it.hasNext()) {
            m mVar = (m) it.next();
            String str = (String) this.pdW.get(mVar.peV);
            if (str != null) {
                Iterator it2 = mVar.peX.iterator();
                while (it2.hasNext()) {
                    h hVar = (h) it2.next();
                    if (str.equals(hVar.id)) {
                        stringBuilder.append(hVar.name).append(" ");
                        break;
                    }
                }
            }
        }
        return stringBuilder.toString();
    }

    public final void S(Intent intent) {
        cb cbVar = new cb();
        cbVar.ksU = bh.az(intent.getStringExtra("userName"), "");
        cbVar.vHm = bh.az(intent.getStringExtra("telNumber"), "");
        cbVar.vHn = bh.az(intent.getStringExtra("addressPostalCode"), "");
        cbVar.hvu = bh.az(intent.getStringExtra("proviceFirstStageName"), "");
        cbVar.hvv = bh.az(intent.getStringExtra("addressCitySecondStageName"), "");
        cbVar.hvC = bh.az(intent.getStringExtra("addressCountiesThirdStageName"), "");
        cbVar.ngs = bh.az(intent.getStringExtra("addressDetailInfo"), "");
        if (!bh.ov(cbVar.ksU) && !bh.ov(cbVar.vHm)) {
            this.pdQ = cbVar;
        }
    }

    public final LinkedList<a> G(Activity activity) {
        LinkedList<a> linkedList = new LinkedList();
        if (this.pdY != null) {
            Iterator it = this.pdY.iterator();
            while (it.hasNext()) {
                as asVar = (as) it.next();
                a aVar = new a();
                aVar.nfp = asVar.nfp;
                aVar.pew = asVar.pew;
                aVar.nje = asVar.nje;
                aVar.ktN = asVar.ktN;
                aVar.nfT = asVar.nfT;
                if (aVar.ktN == 1 && Hs(aVar.nje) > 0) {
                    aVar.pew = activity.getString(i.uLF, new Object[]{b.c((double) r0, this.pdK.peo.paz)});
                }
                linkedList.add(aVar);
            }
        }
        return linkedList;
    }

    public final void uC(int i) {
        if (this.pdX != null && i < this.pdX.size() && i >= 0) {
            this.pdP = (ti) this.pdX.get(i);
        }
    }

    public final int biS() {
        int i = 0;
        if (!(biP().bjl() || this.pdP == null)) {
            i = this.pdP.vPD + 0;
        }
        if (this.pdZ != null) {
            i += this.pdZ.ped * this.mCount;
        } else {
            i += this.pdK.peo.peA * this.mCount;
        }
        return i - biT();
    }

    public final int biT() {
        if (this.peb == null || this.peb.size() <= 0) {
            return 0;
        }
        int i = 0;
        for (LinkedList linkedList : this.peb.values()) {
            if (linkedList != null && linkedList.size() > 0) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    i += ((rc) it.next()).vPD;
                }
            }
            i = i;
        }
        return i;
    }

    private int Hs(String str) {
        int i = 0;
        if (this.peb != null && this.peb.size() > 0) {
            LinkedList linkedList = (LinkedList) this.peb.get(str);
            if (linkedList != null && linkedList.size() > 0) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    i = ((rc) it.next()).vPD + i;
                }
            }
        }
        return i;
    }

    public final bbk biU() {
        if (this.pdR != null) {
            return this.pdR;
        }
        if (this.pdJ == null) {
            this.pdJ = com.tencent.mm.plugin.product.a.a.biM().biO();
        }
        d dVar = this.pdJ;
        String str = (dVar.pec == null || dVar.pec.size() <= 0) ? null : (String) dVar.pec.get(0);
        if (bh.ov(str)) {
            cb cbVar = this.pdQ;
            if (cbVar == null || bh.ov(cbVar.ksU)) {
                return null;
            }
            this.pdR = new bbk();
            this.pdR.ngs = cbVar.ksU;
            this.pdR.wHN = 1;
            return this.pdR;
        }
        this.pdR = new bbk();
        this.pdR.ngs = str;
        this.pdR.wHN = 1;
        return this.pdR;
    }

    public final String getAppId() {
        if (this.pdK.pep != null) {
            return this.pdK.pep.fFm;
        }
        return null;
    }

    public final String biV() {
        if (this.pdK.pep != null) {
            return this.pdK.pep.username;
        }
        return null;
    }

    public final String biW() {
        if (bh.ov(this.pdK.bji())) {
            return null;
        }
        return com.tencent.mm.plugin.product.ui.c.Hu(this.pdK.bji());
    }

    public final String biX() {
        if (this.pdK.peo != null && this.pdK.peo.peL != null) {
            return this.pdK.peo.peL.url;
        }
        if (bh.ov(this.pdK.pes)) {
            return this.pdN;
        }
        return this.pdK.pes;
    }

    public final int biY() {
        int i = this.pdK.pem;
        if (this.pdZ == null || i <= this.pdZ.pem) {
            return i;
        }
        return this.pdZ.pem;
    }

    public final boolean biZ() {
        return (this.mCount <= 0 || this.pdK == null || this.mCount > biY() || this.pdK.peo == null || this.pdK.peo.peJ == null) ? false : true;
    }

    public final boolean bja() {
        if (!biZ() || this.pdW == null || this.pdW.size() != this.pdU) {
            return false;
        }
        if (this.pdU > 0) {
            if (this.pdZ == null || this.mCount <= 0 || this.mCount > biY()) {
                return false;
            }
            return true;
        } else if (this.pdU == 0) {
            return true;
        } else {
            return false;
        }
    }

    public final boolean bjb() {
        if (!bja() || this.pdQ == null) {
            return false;
        }
        if (biP().bjl() || this.pdP != null) {
            return true;
        }
        return false;
    }

    public final LinkedList<bds> bjc() {
        LinkedList<bds> linkedList = new LinkedList();
        bds com_tencent_mm_protocal_c_bds = new bds();
        com_tencent_mm_protocal_c_bds.ksO = this.mCount;
        com_tencent_mm_protocal_c_bds.wmH = this.pdK.pek;
        com_tencent_mm_protocal_c_bds.wFh = this.pdK.pes;
        com_tencent_mm_protocal_c_bds.wFi = this.pdO;
        linkedList.add(com_tencent_mm_protocal_c_bds);
        return linkedList;
    }

    public final biu bjd() {
        biu com_tencent_mm_protocal_c_biu = new biu();
        com_tencent_mm_protocal_c_biu.vQO = this.pdM;
        com_tencent_mm_protocal_c_biu.pbw = 1;
        com_tencent_mm_protocal_c_biu.wMe = new LinkedList();
        aya com_tencent_mm_protocal_c_aya = new aya();
        com_tencent_mm_protocal_c_aya.ksO = this.mCount;
        com_tencent_mm_protocal_c_aya.wmH = this.pdK.pek;
        com_tencent_mm_protocal_c_aya.nfp = this.pdK.peo.name;
        if (this.pdZ != null) {
            com_tencent_mm_protocal_c_aya.wFg = this.pdZ.ped;
        } else {
            com_tencent_mm_protocal_c_aya.wFg = this.pdK.peo.peA;
        }
        com_tencent_mm_protocal_c_aya.wFh = this.pdK.pes;
        com_tencent_mm_protocal_c_aya.wFi = this.pdO;
        com_tencent_mm_protocal_c_aya.ktN = this.pdK.pel;
        com_tencent_mm_protocal_c_aya.wFe = this.pdU;
        com_tencent_mm_protocal_c_aya.wFf = new LinkedList();
        for (String str : this.pdW.keySet()) {
            String str2 = (String) this.pdW.get(str);
            anm com_tencent_mm_protocal_c_anm = new anm();
            com_tencent_mm_protocal_c_anm.vNj = str;
            com_tencent_mm_protocal_c_anm.pQt = str2;
            com_tencent_mm_protocal_c_aya.wFf.add(com_tencent_mm_protocal_c_anm);
        }
        com_tencent_mm_protocal_c_aya.wFm = new LinkedList();
        com_tencent_mm_protocal_c_aya.wFl = 0;
        if (this.peb != null && this.peb.size() > 0) {
            for (LinkedList linkedList : this.peb.values()) {
                com_tencent_mm_protocal_c_aya.wFm.addAll(linkedList);
                com_tencent_mm_protocal_c_aya.wFl = linkedList.size() + com_tencent_mm_protocal_c_aya.wFl;
            }
        }
        com_tencent_mm_protocal_c_biu.wMe.add(com_tencent_mm_protocal_c_aya);
        com_tencent_mm_protocal_c_biu.wMg = new LinkedList();
        com_tencent_mm_protocal_c_biu.wMh = 1;
        this.pdR = biU();
        if (this.pdR != null) {
            com_tencent_mm_protocal_c_biu.wMg.add(this.pdR);
        } else {
            this.pdR = new bbk();
            this.pdR.wHN = 0;
            com_tencent_mm_protocal_c_biu.wMg.add(this.pdR);
        }
        com_tencent_mm_protocal_c_biu.wlA = this.pdQ;
        com_tencent_mm_protocal_c_biu.wMf = this.pdP;
        return com_tencent_mm_protocal_c_biu;
    }

    public final void bje() {
        if (this.pdW != null) {
            Iterator it = this.pdK.peo.peJ.iterator();
            while (it.hasNext()) {
                m mVar = (m) it.next();
                Iterator it2 = mVar.peX.iterator();
                while (it2.hasNext()) {
                    boolean z;
                    h hVar = (h) it2.next();
                    String str = mVar.peV;
                    String str2 = hVar.id;
                    if (this.pdW == null || this.pdV == null) {
                        z = false;
                    } else if (this.pdW.containsKey(str)) {
                        r2 = (String) this.pdW.get(str);
                        this.pdW.put(str, str2);
                        str2 = L(this.pdW);
                        this.pdW.put(str, r2);
                        r2 = (e) this.pdV.get(str2);
                        z = r2 != null ? r2.pem > 0 : false;
                    } else {
                        this.pdW.put(str, str2);
                        r2 = L(this.pdW);
                        this.pdW.remove(str);
                        r2 = (e) this.pdV.get(r2);
                        z = r2 != null ? r2.pem > 0 : false;
                    }
                    hVar.peP = z;
                    x.d("MicroMsg.MallProductManager", "(" + mVar.peV + " , " + hVar.id + ") hasStock--> " + hVar.peP);
                }
            }
        }
    }

    public static String L(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        Object arrayList = new ArrayList(map.entrySet());
        Collections.sort(arrayList, new 1());
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            stringBuilder.append((String) entry.getKey()).append(":").append((String) entry.getValue()).append(";");
        }
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(";"));
        return stringBuilder.toString();
    }

    private void a(String[] strArr, l lVar) {
        if (strArr != null && strArr.length > 0) {
            int length = strArr.length;
            int i = -1 >>> (32 - length);
            for (int i2 = 1; i2 <= i; i2++) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i3 = 0; i3 < length; i3++) {
                    if (((i2 << (31 - i3)) >> 31) == -1) {
                        stringBuilder.append(strArr[i3]).append(";");
                    }
                }
                stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(";"));
                e eVar = (e) this.pdV.get(stringBuilder.toString());
                if (eVar != null) {
                    if (eVar.ped < lVar.peT) {
                        eVar.ped = lVar.peT;
                    }
                    if (eVar.pee > lVar.peT) {
                        eVar.pee = lVar.peT;
                    }
                    eVar.pem += lVar.pem;
                } else {
                    eVar = new e();
                    eVar.ped = lVar.peT;
                    eVar.pee = lVar.peT;
                    eVar.pem = lVar.pem;
                    eVar.peU = lVar.peU;
                    eVar.url = lVar.url;
                    this.pdV.put(stringBuilder.toString(), eVar);
                }
            }
        }
    }

    public final String bjf() {
        g.a aVar = new g.a();
        aVar.title = this.pdK.peo.name;
        aVar.description = bjg();
        aVar.type = 13;
        aVar.url = biX();
        aVar.thumburl = this.pdK.bji();
        aVar.hbC = this.pdK.pel;
        aVar.hbD = a(this.pdK);
        return g.a.a(aVar, null, null);
    }

    public final String bjg() {
        return b.c((double) this.pdK.peo.peB, this.pdK.peo.paz);
    }

    public final String a(m mVar) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<mallProductInfo>");
        stringBuilder.append("<type>").append(mVar.pel).append("</type>");
        stringBuilder.append("<id>").append(mVar.pek).append("</id>");
        stringBuilder.append("<version>").append(mVar.peo.version).append("</version>");
        stringBuilder.append("<name>").append(bh.VG(mVar.peo.name)).append("</name>");
        stringBuilder.append("<highPrice>").append(mVar.peo.peA).append("</highPrice>");
        stringBuilder.append("<lowPrice>").append(mVar.peo.peB).append("</lowPrice>");
        stringBuilder.append("<originPrice>").append(mVar.peo.pez).append("</originPrice>");
        stringBuilder.append("<sourceUrl>").append(bh.VG(this.pdK.pes)).append("</sourceUrl>");
        if (mVar.peo.peC != null) {
            stringBuilder.append("<imgCount>").append(mVar.peo.peC.size()).append("</imgCount>");
            stringBuilder.append("<imgList>");
            Iterator it = mVar.peo.peC.iterator();
            while (it.hasNext()) {
                stringBuilder.append("<imgUrl>").append(bh.VG((String) it.next())).append("</imgUrl>");
            }
            stringBuilder.append("</imgList>");
        }
        stringBuilder.append("<shareInfo>");
        stringBuilder.append("<shareUrl>").append(bh.VG(biX())).append("</shareUrl>");
        stringBuilder.append("<shareThumbUrl>").append(bh.VG(mVar.bji())).append("</shareThumbUrl>");
        stringBuilder.append("</shareInfo>");
        if (this.pdK.pep != null) {
            stringBuilder.append("<sellerInfo>");
            stringBuilder.append("<appID>").append(mVar.pep.fFm).append("</appID>");
            stringBuilder.append("<appName>").append(mVar.pep.name).append("</appName>");
            stringBuilder.append("<usrName>").append(mVar.pep.username).append("</usrName>");
            stringBuilder.append("</sellerInfo>");
        }
        stringBuilder.append("</mallProductInfo>");
        return stringBuilder.toString();
    }
}
