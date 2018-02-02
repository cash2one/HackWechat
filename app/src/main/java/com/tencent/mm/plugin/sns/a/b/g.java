package com.tencent.mm.plugin.sns.a.b;

import android.app.Activity;
import android.view.View;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.kh;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.sns.a.b.a.1;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.b;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.plugin.sns.ui.bf;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.protocal.c.bd;
import com.tencent.mm.protocal.c.bg;
import com.tencent.mm.protocal.c.bjv;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.common.TMAssistantDownloadSDKErrorCode;
import com.tencent.wcdb.FileUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

public final class g implements b {
    public static Map<String, Integer> qOY = new HashMap();
    public Activity activity;
    long kCY = 0;
    public HashMap<String, Long> qON = new HashMap();
    public HashSet<Long> qOO = new HashSet();
    private Map<String, Long> qOP = new HashMap();
    private Map<String, Integer> qOQ = new HashMap();
    private Map<String, a> qOR = new HashMap();
    public HashSet<Long> qOS = new HashSet();
    public Map<Long, h> qOT = new HashMap();
    public Map<Long, h> qOU = new HashMap();
    public Map<String, a> qOV = new HashMap();
    private LinkedList<String> qOW = new LinkedList();
    private Map<String, Integer> qOX = new HashMap();
    private int qOZ = 0;
    public int qOh = 0;
    public View qPa = null;
    public Map<Long, Integer> qPb = new HashMap();
    public Map<Long, Integer> qPc = new HashMap();
    private int qPd = -1;
    public int sceneType = 1;

    public final boolean ei(long j) {
        return this.qOO.contains(Long.valueOf(j));
    }

    public g(int i) {
        this.sceneType = i;
    }

    public final void onResume() {
        if (this.kCY > 0) {
            long bA = bh.bA(this.kCY);
            for (String str : this.qOV.keySet()) {
                x.i("MicroMsg.SnsAdStatistic", "before Key " + str + " " + ((a) this.qOV.get(str)).time);
            }
            for (String str2 : this.qOV.keySet()) {
                a aVar = (a) this.qOV.get(str2);
                aVar.time += bA;
                if (aVar.qPj > 0) {
                    aVar.qPj += bA;
                }
                h hVar = (h) this.qOT.get(Long.valueOf(aVar.hOu));
                if (hVar != null) {
                    hVar.onResume();
                }
                h hVar2 = (h) this.qOU.get(Long.valueOf(aVar.hOu));
                if (hVar2 != null) {
                    hVar2.onResume();
                }
            }
            for (String str22 : this.qOV.keySet()) {
                x.i("MicroMsg.SnsAdStatistic", "update Key " + str22 + " " + ((a) this.qOV.get(str22)).time);
            }
        }
    }

    public final void m(long j, boolean z) {
        ag.y(new 1(this, j, z));
    }

    public final void v(long j, int i) {
        a(j, i, true, false);
    }

    public final void a(long j, int i, boolean z, boolean z2) {
        ag.y(new 2(this, j, i, true, z2));
    }

    public final void n(long j, boolean z) {
        b(j, 0, z, false);
    }

    public final void b(long j, int i, boolean z, boolean z2) {
        h hVar;
        if (z2) {
            if (this.qOU.containsKey(Long.valueOf(j))) {
                hVar = (h) this.qOU.get(Long.valueOf(j));
            } else {
                hVar = new h("timeline");
            }
        } else if (this.qOT.containsKey(Long.valueOf(j))) {
            hVar = (h) this.qOT.get(Long.valueOf(j));
        } else {
            hVar = new h("timeline");
        }
        if (i > 0) {
            hVar.qPv = (long) i;
            hVar.qPt.qQs = i;
        }
        hVar.qPl = z ? 1 : 0;
        if (z2) {
            this.qOU.put(Long.valueOf(j), hVar);
        } else {
            this.qOT.put(Long.valueOf(j), hVar);
        }
    }

    public final void o(long j, boolean z) {
        a(j, z, 1, false);
    }

    public final void a(long j, boolean z, int i, boolean z2) {
        h hVar;
        if (z2) {
            if (this.qOU.containsKey(Long.valueOf(j))) {
                hVar = (h) this.qOU.get(Long.valueOf(j));
            } else {
                hVar = new h("timeline");
            }
        } else if (this.qOT.containsKey(Long.valueOf(j))) {
            hVar = (h) this.qOT.get(Long.valueOf(j));
        } else {
            hVar = new h("timeline");
        }
        if (z) {
            hVar.qPt.qQt = 2;
        } else {
            hVar.qPt.qQt = 1;
        }
        hVar.qPt.qQu = 1;
        if (z2) {
            this.qOU.put(Long.valueOf(j), hVar);
        } else {
            this.qOT.put(Long.valueOf(j), hVar);
        }
    }

    public final void z(long j, long j2) {
        ag.y(new 3(this, j, j2));
    }

    public final boolean ej(long j) {
        if (this.qOS.contains(Long.valueOf(j))) {
            return true;
        }
        return false;
    }

    public final void b(long j, long j2, boolean z) {
        ag.y(new 4(this, j, j2, z));
    }

    public final void p(long j, boolean z) {
        Object obj;
        if (z) {
            if (this.qOU.containsKey(Long.valueOf(j))) {
                obj = (h) this.qOU.get(Long.valueOf(j));
                obj.wr(0);
            } else {
                obj = new h("timeline");
            }
            this.qOU.put(Long.valueOf(j), obj);
            return;
        }
        if (this.qOT.containsKey(Long.valueOf(j))) {
            obj = (h) this.qOT.get(Long.valueOf(j));
            obj.wr(0);
        } else {
            obj = new h("timeline");
        }
        this.qOT.put(Long.valueOf(j), obj);
    }

    public final void onPause() {
        this.kCY = bh.Wq();
        for (String str : this.qOV.keySet()) {
            a aVar = (a) this.qOV.get(str);
            h hVar = (h) this.qOT.get(Long.valueOf(aVar.hOu));
            if (hVar != null) {
                hVar.hOC = bh.Wq();
            }
            h hVar2 = (h) this.qOU.get(Long.valueOf(aVar.hOu));
            if (hVar2 != null) {
                hVar2.hOC = bh.Wq();
            }
        }
    }

    public final void a(int i, String str, String str2, boolean z, View view, long j, bf bfVar, bjv com_tencent_mm_protocal_c_bjv, int i2, int i3) {
        this.qOO.add(Long.valueOf(j));
        this.qON.put(str, Long.valueOf(j));
        if (this.qPd == -1) {
            this.qPd = this.activity == null ? -1 : e.eb(this.activity);
        }
        m Lm = ae.bvv().Lm(str);
        if (Lm == null) {
            x.w("MicroMsg.SnsAdStatistic", "snsinfo not found! skip onAdAdded logic!");
            return;
        }
        a aVar;
        a aVar2 = (a) this.qOR.get(str);
        if (aVar2 == null && view != null && ae.qVo) {
            a aVar3 = new a(bfVar == null ? null : bfVar.rMn, str, j, view, this.qOh, this.qPa, this.qPd, this.sceneType, com_tencent_mm_protocal_c_bjv, i, Lm.bxR());
            aVar3.qOq = System.currentTimeMillis();
            ae.aNT().post(new 1(aVar3));
            this.qOR.put(str, aVar3);
            if (!this.qPb.containsKey(Long.valueOf(j))) {
                this.qPb.put(Long.valueOf(j), Integer.valueOf(Lm.field_likeFlag == 1 ? 1 : 0));
            }
            aVar = aVar3;
        } else {
            aVar = aVar2;
        }
        if (this.qOP.containsKey(str)) {
            long bA = bh.bA(((Long) this.qOP.get(str)).longValue());
            if (bA < 1200000) {
                int intValue = this.qOQ.containsKey(str) ? ((Integer) this.qOQ.get(str)).intValue() : 0;
                if (intValue >= 2) {
                    x.i("MicroMsg.SnsAdStatistic", "passed localid " + str + " viewid " + str2 + " passedTime: " + bA);
                    return;
                }
                this.qOQ.put(str, Integer.valueOf(intValue + 1));
            } else {
                this.qOP.put(str, Long.valueOf(bh.Wq()));
                this.qOQ.put(str, Integer.valueOf(0));
            }
        }
        if (!this.qOV.containsKey(str)) {
            k dVar;
            this.qOV.put(str, new a(bh.Wq(), str, i, str2, i2, j));
            x.i("MicroMsg.SnsAdStatistic", "onAdAdded " + i + " " + str + "  isExposure: " + z);
            h hVar;
            if (i2 == 9) {
                if (this.qOT.containsKey(Long.valueOf(j))) {
                    hVar = (h) this.qOT.get(Long.valueOf(j));
                } else {
                    hVar = new h("timeline");
                }
                hVar.qPn = bh.Wq();
                this.qOT.put(Long.valueOf(j), hVar);
            } else if (i2 == 12 && Lm.bxV().wQo.vYd.size() > 0) {
                if (((aqr) Lm.bxV().wQo.vYd.get(0)).ktN == 6) {
                    if (this.qOT.containsKey(Long.valueOf(j))) {
                        hVar = (h) this.qOT.get(Long.valueOf(j));
                    } else {
                        hVar = new h("timeline");
                    }
                    hVar.qPn = bh.Wq();
                    hVar.qPs = true;
                    this.qOT.put(Long.valueOf(j), hVar);
                }
                if (Lm.bxV().wQo.vYd.size() > 1 && ((aqr) Lm.bxV().wQo.vYd.get(1)).ktN == 6) {
                    if (this.qOU.containsKey(Long.valueOf(j))) {
                        hVar = (h) this.qOU.get(Long.valueOf(j));
                    } else {
                        hVar = new h("timeline");
                    }
                    hVar.qPn = bh.Wq();
                    this.qOU.put(Long.valueOf(j), hVar);
                }
            }
            if (!this.qOW.contains(str)) {
                this.qOW.add(str);
                x.i("MicroMsg.SnsAdStatistic", "exposures item " + str);
                this.qOX.put(str, Integer.valueOf((int) (System.currentTimeMillis() / 1000)));
            }
            b bxR = Lm.bxR();
            bnp bxV = Lm.bxV();
            bg bgVar = null;
            if (aVar != null && ae.qVo) {
                bgVar = aVar.btX();
            }
            c byB = Lm.byB();
            int i4 = 0;
            if (i3 == 1) {
                i4 = byB.field_exposureCount + 1;
                byB.field_exposureCount = i4;
                ae.bvy().c(byB, new String[0]);
            }
            if (bxR.bwx()) {
                dVar = new d(str2, this.sceneType, bgVar, 3, i4, Lm.byC());
            } else if (bxV != null && bxV.wQo.vYc == 27) {
                dVar = new d(str2, this.sceneType, 1, 0, null, bgVar, 6, "", i4, Lm.byC(), 0, 0, Lm.field_likeFlag == 1 ? 2 : 1);
            } else if (bxR.bwy()) {
                if (bxV == null || bxV.wQo.vYc != 15 || bxV.wQv == 1) {
                    dVar = new d(str2, this.sceneType, bgVar, 4, i4, Lm.byC());
                } else {
                    dVar = new d(str2, this.sceneType, bgVar, 5, i4, Lm.byC());
                }
            } else if (i2 == 9) {
                dVar = new d(str2, this.sceneType, bgVar, 2, i4, Lm.byC());
            } else {
                dVar = new d(str2, this.sceneType, bgVar, 1, i4, Lm.byC());
            }
            com.tencent.mm.kernel.g.Dk();
            com.tencent.mm.kernel.g.Di().gPJ.a(dVar, 0);
        }
    }

    public final void t(int i, String str, String str2) {
        if (this.qON.containsKey(str)) {
            this.qOO.remove(Long.valueOf(((Long) this.qON.remove(str)).longValue()));
        }
        bd bdVar = null;
        bg bgVar = null;
        a aVar = (a) this.qOR.get(str);
        if (aVar != null && ae.qVo) {
            aVar.kMn = true;
            aVar.qOr = System.currentTimeMillis();
            if (aVar.qOm < 0) {
                aVar.qOH = 2;
            } else {
                aVar.qOH = 1;
            }
            if (aVar.qOo < 0) {
                aVar.qOI = 2;
            } else {
                aVar.qOI = 1;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(i.eq(aVar.hOu) + ",");
            stringBuilder.append(aVar.hOv + ",");
            stringBuilder.append(aVar.qOH + ",");
            stringBuilder.append(aVar.qOI + ",");
            stringBuilder.append(aVar.qOE + ",");
            stringBuilder.append(aVar.qOF + ",");
            stringBuilder.append(aVar.qOG + ",");
            stringBuilder.append(aVar.qOq + ",");
            stringBuilder.append(aVar.qOr + ",");
            if (aVar.qOu > 0 && aVar.qOx == 0) {
                aVar.qOx = System.currentTimeMillis();
            }
            stringBuilder.append(aVar.qOu + ",");
            stringBuilder.append(aVar.qOx + ",");
            if (aVar.qOA > 0 && aVar.qOD == 0) {
                aVar.qOD = System.currentTimeMillis();
            }
            stringBuilder.append(aVar.qOA + ",");
            stringBuilder.append(aVar.qOD);
            f.a(aVar.hOu, stringBuilder);
            x.i("MicroMsg.AdViewStatic", "report " + stringBuilder.toString());
            bdVar = new bd();
            bdVar.vGp = aVar.qOA;
            bdVar.vGq = aVar.qOD;
            bdVar.qOH = aVar.qOH;
            bdVar.qOI = aVar.qOI;
            bdVar.vGk = (float) aVar.qOE;
            bdVar.vGl = (float) aVar.qOF;
            bdVar.vGm = (float) aVar.qOG;
            bdVar.vGn = aVar.qOu;
            bdVar.vGo = aVar.qOx;
            bdVar.startTime = aVar.qOq;
            bdVar.endTime = aVar.qOr;
            if (aVar.qOl == null || !aVar.qOl.bwE()) {
                ae.bvp().h(12010, stringBuilder.toString());
            } else {
                ae.bvp().h(14648, stringBuilder.toString());
            }
            com.tencent.mm.modelsns.b iu = com.tencent.mm.modelsns.b.iu(TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_SPACE_NOT_ENOUGH);
            iu.mB(i.eq(aVar.hOu)).mB(aVar.hOv).ix(aVar.qOH).ix(aVar.qOI).ix(aVar.qOE).ix(aVar.qOF).ix(aVar.qOG).mB(aVar.qOq).mB(aVar.qOr).mB(aVar.qOu).mB(aVar.qOx).mB(aVar.qOA).mB(aVar.qOD);
            iu.Sx();
            com.tencent.mm.sdk.b.b khVar = new kh();
            khVar.fBE.position = aVar.position;
            a.xef.m(khVar);
            if (r.idY) {
                int nextInt;
                nextInt = new Random(System.currentTimeMillis()).nextInt(MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) + 10;
                x.i("MicroMsg.AdViewStatic", "run on test kv " + nextInt);
                for (int i2 = 0; i2 < nextInt; i2++) {
                    if (aVar.qOl == null || !aVar.qOl.bwE()) {
                        ae.bvp().h(12010, stringBuilder.toString());
                    } else {
                        ae.bvp().h(14648, stringBuilder.toString());
                    }
                }
            }
            bgVar = aVar.btX();
            this.qOR.remove(str);
        }
        if (this.qOV.containsKey(str)) {
            a aVar2 = (a) this.qOV.remove(str);
            this.qOP.put(str, Long.valueOf(bh.Wq()));
            if (aVar2 != null) {
                long bA = bh.bA(aVar2.time);
                if (aVar2.qPj > 0) {
                    aVar2.qPk += bh.bA(aVar2.qPj);
                    aVar2.qPj = 0;
                }
                x.i("MicroMsg.SnsAdStatistic", "onAdRemoved " + i + " " + str + " " + bA + " ");
                m Lm = ae.bvv().Lm(str);
                if (Lm != null) {
                    int i3;
                    String str3;
                    h hVar;
                    String btZ;
                    String str4 = "";
                    bnp bxV = Lm.bxV();
                    int i4 = 0;
                    b bxR = Lm.bxR();
                    if (bxR.bwx()) {
                        i3 = 3;
                        str3 = str4;
                    } else if (bxV.wQo.vYc == 27) {
                        i3 = 6;
                        hVar = (h) this.qOT.remove(Long.valueOf(aVar2.hOu));
                        if (hVar != null) {
                            if (Lm.field_likeFlag == 0) {
                                hVar.wr(0);
                            }
                            btZ = hVar.btZ();
                        } else {
                            btZ = str4;
                        }
                        this.qOS.remove(Long.valueOf(aVar2.hOu));
                        this.qOS.remove(Long.valueOf(aVar2.hOu + 1));
                        str3 = btZ;
                    } else if (bxR.bwy()) {
                        if (bxV == null || bxV.wQo.vYc != 15 || bxV.wQv == 1) {
                            i3 = 4;
                            str3 = str4;
                        } else {
                            i3 = 5;
                            hVar = (h) this.qOT.remove(Long.valueOf(aVar2.hOu));
                            if (hVar != null) {
                                hVar.wr(0);
                                str4 = hVar.btZ();
                            }
                            this.qOS.remove(Long.valueOf(aVar2.hOu));
                            str3 = str4;
                        }
                    } else if (aVar2.kTK == 9) {
                        i3 = 2;
                        hVar = (h) this.qOT.remove(Long.valueOf(aVar2.hOu));
                        if (hVar != null) {
                            hVar.wr(0);
                            str4 = hVar.btZ();
                        }
                        this.qOS.remove(Long.valueOf(aVar2.hOu));
                        str3 = str4;
                    } else {
                        i3 = 1;
                        str3 = str4;
                    }
                    if (Lm.bxV().wQo.vYc == 27) {
                        int intValue;
                        int i5 = Lm.field_likeFlag == 1 ? 2 : 1;
                        nextInt = this.qPc.containsKey(Long.valueOf(aVar2.hOu)) ? ((Integer) this.qPc.get(Long.valueOf(aVar2.hOu))).intValue() : 0;
                        if (this.qPb.containsKey(Long.valueOf(aVar2.hOu))) {
                            intValue = ((Integer) this.qPb.get(Long.valueOf(aVar2.hOu))).intValue();
                        } else {
                            intValue = 0;
                        }
                        long j = 0;
                        long j2 = 0;
                        long j3 = 0;
                        hVar = (h) this.qOU.remove(Long.valueOf(aVar2.hOu));
                        if (hVar != null) {
                            hVar.wr(0);
                            hVar.bua();
                            j = (long) hVar.qPr;
                            j2 = (long) hVar.qPq;
                            j3 = hVar.qPv * 1000;
                        }
                        String str5 = "%s,%s,%s,%s,%s,%s,%s,%s,%s";
                        String[] strArr = new Object[9];
                        strArr[0] = Lm.bxV().nGJ;
                        strArr[1] = Lm.byA();
                        strArr[2] = this.sceneType;
                        strArr[3] = String.valueOf(nextInt);
                        strArr[4] = String.valueOf(intValue);
                        strArr[5] = String.valueOf(j);
                        strArr[6] = String.valueOf(j2);
                        strArr[7] = String.valueOf(j3);
                        strArr[8] = Lm.field_likeFlag == 1 ? "1" : "0";
                        com.tencent.mm.plugin.report.service.g.pQN.k(15155, String.format(str5, strArr));
                        x.i("MicroMsg.SnsAdStatistic", "15155, %s", btZ);
                        i4 = i5;
                    }
                    this.qPc.remove(Long.valueOf(aVar2.hOu));
                    this.qPb.remove(Long.valueOf(aVar2.hOu));
                    k dVar = new d(str2, this.sceneType, 2, (int) bA, bdVar, bgVar, i3, str3, -1, Lm.byC(), (int) bA, (int) aVar2.qPk, i4);
                    com.tencent.mm.kernel.g.Dk();
                    com.tencent.mm.kernel.g.Di().gPJ.a(dVar, 0);
                    return;
                }
                return;
            }
            return;
        }
        x.i("MicroMsg.SnsAdStatistic", "can not find onAdRemoved " + i + " " + str);
    }

    public final void btY() {
        for (Entry value : this.qOR.entrySet()) {
            a aVar = (a) value.getValue();
            if (aVar != null && ae.qVo) {
                aVar.btW();
                if (!(bh.ov(aVar.fus) || this.qOV.get(aVar.fus) == null)) {
                    a aVar2 = (a) this.qOV.get(aVar.fus);
                    Object obj = aVar.qOJ == 1 ? 1 : null;
                    if (obj != null && aVar2.qPj == 0) {
                        aVar2.qPj = bh.Wq();
                    } else if (obj == null && aVar2.qPj > 0) {
                        aVar2.qPk += bh.bA(aVar2.qPj);
                        aVar2.qPj = 0;
                    }
                }
            }
        }
    }

    public final void clear() {
        String str;
        onResume();
        x.i("MicroMsg.SnsAdStatistic", "clean the adRemove" + this.qOW.size());
        List<String> linkedList = new LinkedList();
        for (String str2 : this.qOV.keySet()) {
            linkedList.add(str2);
        }
        for (String str22 : linkedList) {
            a aVar = (a) this.qOV.get(str22);
            t(aVar.position, aVar.fIf, aVar.hOt);
        }
        Iterator it = this.qOW.iterator();
        while (it.hasNext()) {
            str22 = (String) it.next();
            com.tencent.mm.plugin.sns.storage.e xk = ae.bvy().xk(u.LG(str22));
            if (xk != null) {
                int intValue;
                m bxX = xk.bxX();
                xk.field_localFlag |= FileUtils.S_IWUSR;
                int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                if (this.qOX.containsKey(str22)) {
                    intValue = ((Integer) this.qOX.get(str22)).intValue();
                } else {
                    intValue = currentTimeMillis;
                }
                if (xk.field_exposureTime <= 0) {
                    xk.field_exposureTime = intValue;
                }
                bxX.field_localFlag |= FileUtils.S_IWUSR;
                ae.bvv().b(bxX.field_snsId, bxX);
                ae.bvy().b(xk.field_snsId, xk);
            }
        }
        this.qOW.clear();
        this.qOX.clear();
    }

    public final void ek(long j) {
        int i = 0;
        if (this.qPb.containsKey(Long.valueOf(j))) {
            i = ((Integer) this.qPb.get(Long.valueOf(j))).intValue();
        }
        this.qPb.put(Long.valueOf(j), Integer.valueOf(i + 1));
    }

    public final void el(long j) {
        int i = 0;
        if (this.qPc.containsKey(Long.valueOf(j))) {
            i = ((Integer) this.qPc.get(Long.valueOf(j))).intValue();
        }
        this.qPc.put(Long.valueOf(j), Integer.valueOf(i + 1));
    }
}
