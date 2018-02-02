package com.tencent.mm.plugin.sns.model;

import android.os.Build.VERSION;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.memory.n;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.sns.data.f;
import com.tencent.mm.plugin.sns.data.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.a.c.a;
import com.tencent.mm.plugin.sns.model.a.d;
import com.tencent.mm.plugin.sns.model.a.h;
import com.tencent.mm.plugin.sns.model.g.9;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.an;
import com.tencent.mm.z.ak;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class b implements e, a {
    static int qSu = 0;
    private static final int qSv = (VERSION.SDK_INT >= 14 ? 100 : 25);
    LinkedList<f> gBH;
    Set<b> gCl;
    private af handler;
    public HashMap<String, Long> qSA;
    public boolean qSB;
    public Set<a> qSC;
    Map<String, Long> qSD;
    Map<String, com.tencent.mm.plugin.sns.data.c> qSE;
    private long qSw;
    private int qSx;
    private int qSy;
    private LinkedList<g> qSz;

    class AnonymousClass3 implements Runnable {
        final /* synthetic */ String gBF;
        final /* synthetic */ b qSG;
        final /* synthetic */ String uS;

        public AnonymousClass3(b bVar, String str, String str2) {
            this.qSG = bVar;
            this.uS = str;
            this.gBF = str2;
        }

        public final void run() {
            if (this.qSG.qSC != null) {
                for (a aVar : this.qSG.qSC) {
                    if (aVar != null) {
                        aVar.dY(this.uS, this.gBF);
                    }
                }
            }
        }
    }

    class c implements IdleHandler {
        final /* synthetic */ b qSG;

        c(b bVar) {
            this.qSG = bVar;
        }

        public final boolean queueIdle() {
            x.d("MicroMsg.DownloadManager", "I run idleHandler ");
            this.qSG.qSw = bh.Wo();
            return b.a(this.qSG);
        }
    }

    static /* synthetic */ void a(b bVar, String str) {
        x.d("MicroMsg.DownloadManager", "onDownLoadFinish by scene %s", new Object[]{str});
        ae.bvu().Kj(str);
        bVar.OW();
    }

    static /* synthetic */ boolean a(b bVar) {
        if (bVar.qSz == null || bVar.qSz.size() <= 0) {
            return false;
        }
        g gVar = (g) bVar.qSz.remove();
        new ar().m(new g[]{gVar});
        return true;
    }

    static /* synthetic */ boolean a(b bVar, aqr com_tencent_mm_protocal_c_aqr, int i, com.tencent.mm.plugin.sns.data.e eVar, an anVar) {
        if (!i.JP(ae.FC())) {
            x.i("MicroMsg.DownloadManager", "isHasSdcard is false accpath %s sdcard: %s", new Object[]{ae.FC(), com.tencent.mm.compatible.util.e.bnD});
            return false;
        } else if (com_tencent_mm_protocal_c_aqr.nGJ.startsWith("Locall_path") || com_tencent_mm_protocal_c_aqr.nGJ.startsWith("pre_temp_sns_pic")) {
            x.d("MicroMsg.DownloadManager", "is a local img not need download");
            return false;
        } else {
            String aE = i.aE(i, com_tencent_mm_protocal_c_aqr.nGJ);
            if (bVar.qSE.containsKey(aE)) {
                Iterator it = bVar.gBH.iterator();
                while (it.hasNext()) {
                    f fVar = (f) it.next();
                    if (fVar.fHC.nGJ.equals(com_tencent_mm_protocal_c_aqr.nGJ) && fVar.requestType == i) {
                        if (bVar.gBH.remove(fVar)) {
                            bVar.gBH.addLast(fVar);
                        }
                        x.v("MicroMsg.DownloadManager", "update the donwload list ");
                    }
                }
            } else {
                x.i("MicroMsg.DownloadManager", "add list %s", new Object[]{com_tencent_mm_protocal_c_aqr.nGJ});
                bVar.qSE.put(aE, new com.tencent.mm.plugin.sns.data.c(eVar, i));
                bVar.gBH.add(new f(com_tencent_mm_protocal_c_aqr, i, aE, anVar));
            }
            x.d("MicroMsg.DownloadManager", "tryStartNetscene size %s Tsize : %s", new Object[]{Integer.valueOf(ae.bvu().buZ()), Integer.valueOf(bVar.qSD.size())});
            x.v("MicroMsg.DownloadManager", "lockwaitdownload. %s * %s memeryFiles.size() ", new Object[]{Integer.valueOf(bVar.qSE.size()), Integer.valueOf(bVar.qSE.size()), Integer.valueOf(bVar.qSz.size())});
            if (Looper.myLooper() == null) {
                x.w("MicroMsg.DownloadManager", "Looper.myLooper() == null");
                return false;
            }
            Looper.myQueue().addIdleHandler(new c(bVar));
            if ((bh.by(bVar.qSw) * 1000 > 300000 ? 1 : null) != null) {
                bVar.handler.postDelayed(new 6(bVar), 500);
            }
            List<String> linkedList = new LinkedList();
            for (Entry key : bVar.qSD.entrySet()) {
                linkedList.add(key.getKey());
            }
            for (String aE2 : linkedList) {
                if (bVar.qSD.containsKey(aE2) && bh.by(((Long) bVar.qSD.get(aE2)).longValue()) * 1000 > 300000) {
                    x.d("MicroMsg.DownloadManager", "too long to download");
                    bVar.qSD.remove(aE2);
                    bVar.qSE.remove(aE2);
                }
            }
            if (bVar.gBH.size() > 0) {
                bVar.handler.postDelayed(new 4(bVar), 500);
            }
            return true;
        }
    }

    public static void buy() {
    }

    public static boolean buz() {
        return false;
    }

    public final void I(int i, boolean z) {
        this.qSy = i;
        try {
            String value;
            String str;
            if (com.tencent.mm.sdk.platformtools.an.isWifi(ac.getContext())) {
                value = com.tencent.mm.k.g.zY().getValue("SnsImgDownloadConcurrentCountForWifi");
            } else {
                value = com.tencent.mm.k.g.zY().getValue("SnsImgDownloadConcurrentCountForNotWifi");
            }
            if (bh.ov(value) && com.tencent.mm.sdk.a.b.ceK()) {
                str = "00:00-18:30-1-3;19:30-23:00-1-2;23:00-23:59-1-3;18:30-19:30-3-5;";
            } else {
                str = value;
            }
            if (!bh.ov(str)) {
                int i2;
                String[] split = new SimpleDateFormat("HH:mm").format(new Date()).split(":");
                int VI = (bh.VI(split[1]) + (bh.VI(split[0]) * 60)) - ((((int) i.MQ()) - 8) * 60);
                if (VI < 0) {
                    i2 = VI + 1440;
                } else if (VI >= 1440) {
                    i2 = VI - 1440;
                } else {
                    i2 = VI;
                }
                String[] split2 = str.split(";");
                for (int i3 = 0; i3 < split2.length; i3++) {
                    if (!bh.ov(split2[i3])) {
                        split = split2[i3].split("-");
                        if (split == null || split.length < 4) {
                            x.e("MicroMsg.DownloadManager", "setMaxThread Err i%d :%s", new Object[]{Integer.valueOf(i3), str});
                        } else {
                            String[] split3 = split[0].split(":");
                            int VI2 = bh.VI(split3[1]) + (bh.VI(split3[0]) * 60);
                            String[] split4 = split[1].split(":");
                            x.i("MicroMsg.DownloadManager", "setMaxThread i:%d [%d,%d] now:%d threadcnt:[%s,%s]", new Object[]{Integer.valueOf(i3), Integer.valueOf(VI2), Integer.valueOf(bh.VI(split4[1]) + (bh.VI(split4[0]) * 60)), Integer.valueOf(i2), split[2], split[3]});
                            if (i2 <= bh.VI(split4[1]) + (bh.VI(split4[0]) * 60) && i2 > VI2) {
                                VI = bh.VI(z ? split[2] : split[3]);
                                if (VI > 0) {
                                    this.qSy = VI;
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable e) {
            x.e("MicroMsg.DownloadManager", "setMaxThread :%s", new Object[]{bh.i(e)});
        }
        x.i("MicroMsg.DownloadManager", "setMaxThread Res:%d ", new Object[]{Integer.valueOf(this.qSy)});
    }

    public b() {
        this.handler = null;
        this.qSw = 0;
        this.qSx = 0;
        this.qSy = 2;
        this.qSz = new LinkedList();
        this.qSA = new HashMap();
        this.qSB = true;
        this.gCl = new HashSet();
        this.qSC = new HashSet();
        this.gBH = new LinkedList();
        this.qSD = new ConcurrentHashMap();
        this.qSE = new HashMap();
        this.handler = ae.aNT();
        buA();
    }

    private void buA() {
        this.gBH.clear();
        this.qSE.clear();
        this.qSD.clear();
        this.qSz.clear();
        this.qSA.clear();
    }

    public final void a(b bVar) {
        this.handler.post(new 1(this, bVar));
    }

    public final void b(b bVar) {
        this.handler.post(new 2(this, bVar));
    }

    public final boolean a(aqr com_tencent_mm_protocal_c_aqr, int i, com.tencent.mm.plugin.sns.data.e eVar, an anVar) {
        if (com_tencent_mm_protocal_c_aqr == null) {
            x.e("MicroMsg.DownloadManager", "unknow case media is null " + bh.cgy().toString());
            return false;
        }
        ae.aNT().post(new 5(this, com_tencent_mm_protocal_c_aqr, i, eVar, anVar));
        return true;
    }

    public final void JW(String str) {
        x.d("MicroMsg.DownloadManager", "unLockDownLoad the thread id is %s %s", new Object[]{Long.valueOf(Thread.currentThread().getId()), str});
        com.tencent.mm.plugin.sns.data.c cVar = (com.tencent.mm.plugin.sns.data.c) this.qSE.get(str);
        if (cVar != null) {
            com.tencent.mm.plugin.sns.data.e eVar = cVar.qQL;
            if (eVar != null) {
                aqr com_tencent_mm_protocal_c_aqr;
                g bvs = ae.bvs();
                aqr com_tencent_mm_protocal_c_aqr2 = (aqr) eVar.list.get(0);
                for (int i = 1; i < eVar.list.size(); i++) {
                    aqr com_tencent_mm_protocal_c_aqr3 = (aqr) eVar.list.get(i);
                    if (str != null && str.indexOf(com_tencent_mm_protocal_c_aqr3.nGJ) >= 0) {
                        com_tencent_mm_protocal_c_aqr = com_tencent_mm_protocal_c_aqr3;
                        break;
                    }
                }
                com_tencent_mm_protocal_c_aqr = com_tencent_mm_protocal_c_aqr2;
                String r = am.r(ae.getAccSnsPath(), com_tencent_mm_protocal_c_aqr.nGJ);
                String f = eVar.qQR == 0 ? i.f(com_tencent_mm_protocal_c_aqr) : eVar.qQR == 4 ? i.g(com_tencent_mm_protocal_c_aqr) : eVar.qQR == 5 ? i.g(com_tencent_mm_protocal_c_aqr) : i.e(com_tencent_mm_protocal_c_aqr);
                if (!bvs.qSO.bt(i.aD(eVar.qQR, com_tencent_mm_protocal_c_aqr.nGJ))) {
                    new com.tencent.mm.plugin.sns.model.g.b(bvs, i.aD(eVar.qQR, com_tencent_mm_protocal_c_aqr.nGJ), r + f, r, com_tencent_mm_protocal_c_aqr, eVar.qQR).m(new String[]{""});
                }
            }
        }
        this.qSE.remove(str);
    }

    public final void OW() {
        if (!this.qSB) {
            return;
        }
        if (ae.bve()) {
            buA();
        } else if (i.JP(ae.FC())) {
            int i = this.qSy;
            if (r.icY > 0) {
                i = r.icY;
            }
            if (this.gBH.size() > 0 && ae.bvu().buZ() + this.qSD.size() <= r2) {
                x.i("MicroMsg.DownloadManager", "tryStartNetscene size %s Tsize : %s listsize %s max_thread_downloading: %s", new Object[]{Integer.valueOf(ae.bvu().buZ()), Integer.valueOf(this.qSD.size()), Integer.valueOf(this.gBH.size()), Integer.valueOf(this.qSy)});
                f fVar = (f) this.gBH.removeLast();
                aqr com_tencent_mm_protocal_c_aqr = fVar.fHC;
                int i2 = fVar.requestType;
                String str = fVar.aAM;
                if (!this.qSE.containsKey(str) || this.qSE.get(str) == null) {
                    this.qSE.remove(str);
                    return;
                }
                boolean z;
                String str2;
                int i3;
                Object obj;
                com.tencent.mm.plugin.sns.data.e eVar = ((com.tencent.mm.plugin.sns.data.c) this.qSE.get(str)).qQL;
                if (i2 == 1 && com_tencent_mm_protocal_c_aqr.qQH) {
                    i2 = 8;
                }
                if (i2 == 1 || i2 == 5 || i2 == 7) {
                    z = true;
                    String str3 = com_tencent_mm_protocal_c_aqr.wxE;
                    if (i2 == 7 && !bh.ov(com_tencent_mm_protocal_c_aqr.wxO)) {
                        str3 = com_tencent_mm_protocal_c_aqr.wxO;
                    }
                    int i4 = com_tencent_mm_protocal_c_aqr.wxF;
                    if (bh.ov(str3) && com_tencent_mm_protocal_c_aqr.ktN == 2) {
                        str2 = com_tencent_mm_protocal_c_aqr.nfX;
                        i3 = com_tencent_mm_protocal_c_aqr.wxD;
                    } else {
                        i3 = i4;
                        str2 = str3;
                    }
                } else if (i2 == 6) {
                    z = false;
                    str2 = com_tencent_mm_protocal_c_aqr.wxL;
                    i3 = com_tencent_mm_protocal_c_aqr.wxD;
                } else {
                    z = false;
                    str2 = com_tencent_mm_protocal_c_aqr.nfX;
                    i3 = com_tencent_mm_protocal_c_aqr.wxD;
                }
                if (str2 == null || str2.equals("")) {
                    x.d("MicroMsg.DownloadManager", "url  " + str2);
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj == null) {
                    this.qSE.remove(str);
                } else if (i3 == 2) {
                    if (!ae.bvu().isDownloading(str)) {
                        x.d("MicroMsg.DownloadManager", "to downLoad scene " + com_tencent_mm_protocal_c_aqr.nGJ + "  " + str2);
                        com.tencent.mm.kernel.g.Dk();
                        com.tencent.mm.kernel.g.Di().gPJ.a(new o(com_tencent_mm_protocal_c_aqr, com_tencent_mm_protocal_c_aqr.nGJ, str2, com_tencent_mm_protocal_c_aqr.ktN, z, i2, str), 0);
                        ae.bvu().Ki(str);
                    }
                } else if (i3 == 1 || i3 == 0) {
                    if (i3 == 0) {
                        x.e("MicroMsg.DownloadManager", "others http: urlType" + i3 + " -- url : " + str2 + " isThumb :" + z);
                    }
                    if (!this.qSD.containsKey(str)) {
                        x.i("MicroMsg.DownloadManager", "to downLoad cdn " + com_tencent_mm_protocal_c_aqr.nGJ + "  " + str2);
                        if (!(com_tencent_mm_protocal_c_aqr == null || i2 == 6 || !this.qSA.containsKey(str))) {
                            long longValue = ((Long) this.qSA.get(str)).longValue();
                            if (System.currentTimeMillis() - longValue < 300000) {
                                this.qSE.remove(str);
                                x.w("MicroMsg.DownloadManager", "download error pass " + longValue + " url " + str2 + " id: " + com_tencent_mm_protocal_c_aqr.nGJ);
                                return;
                            }
                        }
                        this.qSD.put(str, Long.valueOf(bh.Wo()));
                        if (i2 == 2 || i2 == 8) {
                            com.tencent.mm.kernel.g.Dk();
                            int a = bh.a((Integer) com.tencent.mm.kernel.g.Dj().CU().get(68391, null), 0);
                            com.tencent.mm.kernel.g.Dk();
                            com.tencent.mm.kernel.g.Dj().CU().set(68391, Integer.valueOf(a + 1));
                        }
                        com.tencent.mm.plugin.sns.model.a.a aVar = new com.tencent.mm.plugin.sns.model.a.a(com_tencent_mm_protocal_c_aqr.nGJ);
                        aVar.qTV = com_tencent_mm_protocal_c_aqr;
                        aVar.qYC = fVar.qQS;
                        if (i2 == 4) {
                            aVar.qYA = true;
                        } else {
                            aVar.qYA = false;
                        }
                        aVar.url = str2;
                        i = com_tencent_mm_protocal_c_aqr.ktN;
                        aVar.qYz = z;
                        aVar.qYB = i2;
                        aVar.qTU = str;
                        aVar.qQL = eVar;
                        com.tencent.mm.plugin.sns.model.a.c cVar = null;
                        if (i2 == 1 || i2 == 5 || i2 == 7) {
                            cVar = new com.tencent.mm.plugin.sns.model.a.i(this, aVar);
                        } else if (i2 == 4) {
                            x.w("MicroMsg.DownloadManager", "it can not download sight, may be something warn here.");
                            if (com_tencent_mm_protocal_c_aqr.qQH) {
                                cVar = new h(this, aVar);
                            } else {
                                cVar = new com.tencent.mm.plugin.sns.model.a.g(this, aVar);
                            }
                        } else if (i2 == 2 || i2 == 8 || i2 == 3) {
                            cVar = new com.tencent.mm.plugin.sns.model.a.e(this, aVar);
                        } else if (i2 == 6) {
                            aVar.url = com_tencent_mm_protocal_c_aqr.wxL;
                            aVar.fqR = com_tencent_mm_protocal_c_aqr.wxN;
                            cVar = new d(this, aVar);
                        }
                        cVar.m(new String[]{""});
                    }
                } else {
                    this.qSE.remove(str);
                }
            }
        }
    }

    public final void a(int i, aqr com_tencent_mm_protocal_c_aqr, int i2, boolean z, String str, int i3) {
        x.i("MicroMsg.DownloadManager", "state:%d, mediaId:%s, reqDownloadType:%d, isThumb:%b, requestKey:%s, totalSize:%d", new Object[]{Integer.valueOf(i), com_tencent_mm_protocal_c_aqr.nGJ, Integer.valueOf(i2), Boolean.valueOf(z), str, Integer.valueOf(i3)});
        if (!ae.bve()) {
            com.tencent.mm.kernel.g.Dk();
            if (com.tencent.mm.kernel.g.Dh().Cy()) {
                this.qSx += i3;
                if (this.qSx > 512000 && this.gBH.size() == 0) {
                    x.d("MicroMsg.DownloadManager", "netSizeAdd %s", new Object[]{Integer.valueOf(this.qSx)});
                    ak.a.hfM.aV(this.qSx, 0);
                    this.qSx = 0;
                }
                if (i == 1 || i == 3) {
                    this.qSA.put(str, Long.valueOf(System.currentTimeMillis()));
                }
                if (!(i == 3 || i != 1 || i2 == 3)) {
                    g bvs = ae.bvs();
                    x.d("MicroMsg.LazyerImageLoader2", "updateCache " + com_tencent_mm_protocal_c_aqr.nGJ);
                    n nVar = (n) bvs.qSO.get(i.aD(1, com_tencent_mm_protocal_c_aqr.nGJ));
                    if (i.b(nVar)) {
                        nVar.EE();
                        x.d("MicroMsg.LazyerImageLoader2", "force update");
                        ae.bvi().post(new 9(bvs, com_tencent_mm_protocal_c_aqr));
                    }
                }
                for (b bVar : this.gCl) {
                    if (bVar != null) {
                        if (i != 2) {
                            if (i2 == 3) {
                                bVar.bun();
                            } else if (i2 == 1 || i2 == 5 || i2 == 7) {
                                bVar.JT(com_tencent_mm_protocal_c_aqr.nGJ);
                            } else if (i2 == 2 || i2 == 8) {
                                bVar.aE(com_tencent_mm_protocal_c_aqr.nGJ, true);
                            } else if (i2 == 4 || i2 == 6) {
                                bVar.aF(com_tencent_mm_protocal_c_aqr.nGJ, true);
                            }
                        } else if (i2 == 2 || i2 == 8) {
                            bVar.aE(com_tencent_mm_protocal_c_aqr.nGJ, false);
                        } else if (i2 == 4 || i2 == 6) {
                            bVar.aF(com_tencent_mm_protocal_c_aqr.nGJ, false);
                        }
                    }
                }
                x.d("MicroMsg.DownloadManager", "onDownLoadFinish by cdn %s", new Object[]{str});
                this.qSD.remove(str);
                OW();
                JW(str);
                return;
            }
        }
        buA();
    }

    public final void JX(String str) {
        ae.aNT().post(new 7(this, str));
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.DownloadManager", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " type = " + kVar.getType() + " @" + hashCode());
        if (kVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.a.f.CTRL_INDEX) {
            o oVar = (o) kVar;
            if (i == 0 && i2 == 0) {
                if (kVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.a.f.CTRL_INDEX) {
                    for (b bVar : this.gCl) {
                        if (bVar != null) {
                            if (oVar.qTS == 3) {
                                bVar.bun();
                            } else if (oVar.qTS == 1 || oVar.qTS == 5 || oVar.qTS == 7) {
                                bVar.JT(oVar.mediaId);
                            } else if (oVar.qTS == 2 || oVar.qTS == 8) {
                                bVar.aE(oVar.mediaId, true);
                            }
                        }
                    }
                }
            } else if (oVar.qTS == 2 || oVar.qTS == 8) {
                for (b bVar2 : this.gCl) {
                    if (bVar2 != null) {
                        bVar2.aE(oVar.mediaId, false);
                    }
                }
            }
        }
    }
}
