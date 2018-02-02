package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.k;
import com.tencent.mm.by.h;
import com.tencent.mm.g.a.at;
import com.tencent.mm.g.a.my;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.emoji.e.n;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.fl;
import com.tencent.mm.protocal.c.fm;
import com.tencent.mm.protocal.c.rw;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.d;
import com.tencent.mm.storage.w;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class e extends k implements com.tencent.mm.network.k {
    public static int lyB = 0;
    public static int lyC = 1;
    public final b gJQ;
    private com.tencent.mm.ae.e gJT;
    private ArrayList<String> lyA = new ArrayList();
    private HashMap<String, rw> lyD = new HashMap();
    public int lyE = 0;
    private LinkedList<String> lyF = new LinkedList();
    private int mIndex = 0;

    public e() {
        a aVar = new a();
        aVar.hmj = new fl();
        aVar.hmk = new fm();
        aVar.uri = "/cgi-bin/micromsg-bin/mmbatchemojidownload";
        aVar.hmi = 697;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        this.mIndex = 0;
        this.lyE = lyB;
        this.lyF = new LinkedList();
    }

    public e(LinkedList<String> linkedList) {
        a aVar = new a();
        aVar.hmj = new fl();
        aVar.hmk = new fm();
        aVar.uri = "/cgi-bin/micromsg-bin/mmbatchemojidownload";
        aVar.hmi = 697;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        this.mIndex = 0;
        this.lyE = lyC;
        this.lyF = linkedList;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "errType:%d, errCode:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        fm fmVar;
        if (this.lyE == lyB) {
            if (i2 == 0 && i3 == 0) {
                fmVar = (fm) this.gJQ.hmh.hmo;
                fl flVar = (fl) this.gJQ.hmg.hmo;
                if (fmVar.vLj == 0 && (fmVar.vJK == null || fmVar.vJK.size() <= 0)) {
                    this.gJT.a(i2, i3, str, this);
                    x.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "[cpan] donwload list is null");
                    g.pQN.a(164, 0, 1, false);
                    return;
                } else if (fmVar.vLj == 1) {
                    String str2 = "MicroMsg.emoji.NetSceneBatchEmojiDownLoad";
                    String str3 = "[cpan] preparedDownloadCustomEmojiList size:%s";
                    Object[] objArr = new Object[1];
                    objArr[0] = Integer.valueOf(this.lyD == null ? 0 : this.lyD.size());
                    x.i(str2, str3, objArr);
                    this.gJT.a(i2, i3, str, this);
                    ar.Hg();
                    c.CU().a(w.a.xnr, Long.valueOf(System.currentTimeMillis()));
                    a(fmVar);
                    List<String> list = this.lyA;
                    if (list == null || list.size() <= 0) {
                        x.w("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "[cpan] perparedDownloadCustomEmojiList failed. list is null.");
                        ar.Hg();
                        c.CU().a(w.a.xng, Boolean.valueOf(false));
                    } else {
                        long dz;
                        String str4;
                        if (list.size() < n.aBn()) {
                            ar.Hg();
                            c.CU().a(w.a.xng, Boolean.valueOf(false));
                        }
                        ar.Hg();
                        boolean booleanValue = ((Boolean) c.CU().get(w.a.xnj, Boolean.valueOf(true))).booleanValue();
                        d dVar = i.aBE().lwL;
                        x.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] begin preparedDownloadCustomEmojiList");
                        long currentTimeMillis = System.currentTimeMillis();
                        if (list == null || list.size() <= 0) {
                            x.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] perparedDownloadCustomEmojiList failed. list is null");
                        } else {
                            h hVar;
                            if (dVar.gJP instanceof h) {
                                h hVar2 = (h) dVar.gJP;
                                dz = hVar2.dz(Thread.currentThread().getId());
                                hVar = hVar2;
                            } else {
                                hVar = null;
                                dz = -1;
                            }
                            int i4 = 1;
                            for (String str5 : list) {
                                EmojiInfo XU = dVar.XU(str5);
                                if (XU == null || bh.ov(XU.Nr()) || !XU.cks()) {
                                    XU = new EmojiInfo();
                                    XU.field_md5 = str5;
                                    XU.field_catalog = 85;
                                    XU.field_source = EmojiInfo.xAw;
                                    XU.field_lastUseTime = System.currentTimeMillis();
                                } else {
                                    XU.field_source = EmojiInfo.xAw;
                                    if (XU.field_catalog == EmojiInfo.xAe) {
                                        XU.field_catalog = EmojiInfo.xAk;
                                    }
                                }
                                XU.field_reserved3 = i4;
                                if (booleanValue) {
                                    x.d("MicroMsg.emoji.EmojiInfoStorage", "need repair");
                                    XU.field_temp = 2;
                                }
                                if (XU.cks()) {
                                    com.tencent.mm.sdk.b.b atVar = new at();
                                    atVar.foS.type = 0;
                                    atVar.foS.foU = XU;
                                    com.tencent.mm.sdk.b.a.xef.m(atVar);
                                    if (!atVar.foT.fnI) {
                                        x.d("MicroMsg.emoji.EmojiInfoStorage", "decode failed re download.");
                                        XU.field_temp = 2;
                                    }
                                } else {
                                    x.d("MicroMsg.emoji.EmojiInfoStorage", "file don't exist");
                                    XU.field_temp = 2;
                                }
                                r4 = i4 + 1;
                                if (dVar.gJP.replace("EmojiInfo", "md5", XU.vI()) < 0) {
                                    if (hVar != null) {
                                        hVar.fS(dz);
                                    }
                                    x.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] end preparedDownloadCustomEmojiList user time:%d faild ", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                                } else {
                                    i4 = r4;
                                }
                            }
                            if (hVar != null) {
                                hVar.fS(dz);
                            }
                            str4 = "MicroMsg.emoji.EmojiInfoStorage";
                            str2 = "[cpan] end preparedDownloadCustomEmojiList user time:%d succes. size:%d";
                            Object[] objArr2 = new Object[2];
                            objArr2[0] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
                            objArr2[1] = Integer.valueOf(list == null ? 0 : list.size());
                            x.i(str4, str2, objArr2);
                        }
                        ar.Hg();
                        c.CU().a(w.a.xnj, Boolean.valueOf(false));
                        d dVar2 = i.aBE().lwL;
                        x.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] begin preparedDeleteCustomEmojiList");
                        dz = System.currentTimeMillis();
                        if (list == null || list.size() <= 0) {
                            x.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] preparedDeleteCustomEmojiList failed. list is null");
                        } else {
                            List<String> ckE = dVar2.ckE();
                            if (ckE.size() <= 0) {
                                x.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] preparedDeleteCustomEmojiList failed. sync list is null");
                            } else {
                                Object arrayList = new ArrayList();
                                for (String str52 : ckE) {
                                    if (!list.contains(str52.toLowerCase())) {
                                        arrayList.add(str52);
                                        x.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] delete:%s", new Object[]{str52});
                                    }
                                }
                                dVar2.cU(arrayList);
                                x.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] end preparedDeleteCustomEmojiList user time:%d succes. size:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - dz), Integer.valueOf(arrayList.size())});
                            }
                        }
                        ArrayList arrayList2 = (ArrayList) i.aBE().lwL.ckF();
                        if (arrayList2.size() > 0) {
                            x.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "try to sync emoji downloadList:%d", new Object[]{Integer.valueOf(arrayList2.size())});
                            ArrayList arrayList3 = new ArrayList();
                            int size = arrayList2.size();
                            for (int i5 = 0; i5 < size; i5++) {
                                str4 = ((String) arrayList2.get(i5)).toLowerCase();
                                if (this.lyD == null || !this.lyD.containsKey(str4) || this.lyD.get(str4) == null) {
                                    x.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "emoji info list no contains md5:%s", new Object[]{str4});
                                } else {
                                    rw rwVar = (rw) this.lyD.get(str4);
                                    arrayList3.add(new com.tencent.mm.plugin.emoji.sync.a.a(str4, rwVar.nfX, rwVar.pbP, rwVar.vZM, rwVar.vZN, rwVar.vZO, rwVar.vIR, rwVar.vZR));
                                }
                            }
                            i.aBB().lzq.lzB = list.size();
                            i.aBB().s(arrayList3);
                            i.aBB().lzq.aBZ();
                            g.pQN.h(11595, new Object[]{Integer.valueOf(2)});
                            if (an.isWifi(ac.getContext())) {
                                g.pQN.h(11595, new Object[]{Integer.valueOf(3)});
                            }
                        } else {
                            ar.Hg();
                            c.CU().a(w.a.xno, Boolean.valueOf(false));
                            x.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "no things need to download.");
                        }
                        com.tencent.mm.sdk.b.a.xef.m(new my());
                    }
                    g.pQN.a(164, 0, 1, false);
                    return;
                } else {
                    x.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "[cpan] do next scene. index:%d size:%d", new Object[]{Integer.valueOf(flVar.vLg), Integer.valueOf(fmVar.vJK.size())});
                    this.gJT.a(i2, i3, str, this);
                    flVar.vLg = fmVar.vLg;
                    this.mIndex = flVar.vLg;
                    a(fmVar);
                    r4 = a(this.hmA, this.gJT);
                    if (i < 0) {
                        x.e("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "[cpan] doScene error.nextNetId:%d", new Object[]{Integer.valueOf(r4)});
                        return;
                    }
                    return;
                }
            }
            this.gJT.a(i2, i3, str, this);
            g.pQN.a(164, 1, 1, false);
            ar.Hg();
            c.CU().a(w.a.xnr, Long.valueOf((System.currentTimeMillis() - 86400000) + 3600000));
        } else if (i2 == 0 && i3 == 0) {
            fmVar = (fm) this.gJQ.hmh.hmo;
            if (fmVar.vLk == null || fmVar.vLk.size() <= 0) {
                x.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "Change MD5 to URL failed.");
            } else {
                i.aBE().lwL.cW(fmVar.vLk);
            }
            this.gJT.a(i2, i3, str, this);
        } else {
            this.gJT.a(i2, i3, str, this);
        }
    }

    private void a(fm fmVar) {
        if (fmVar == null) {
            x.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "addEmojiInfoList response is null.");
        } else if (fmVar.vLk == null || fmVar.vLk.size() <= 0) {
            x.i("MicroMsg.emoji.NetSceneBatchEmojiDownLoad", "addemojiInfoList EmojiList is null or size is empty.");
        } else {
            Iterator it = fmVar.vLk.iterator();
            while (it.hasNext()) {
                rw rwVar = (rw) it.next();
                String toLowerCase = rwVar.vZL.toLowerCase();
                this.lyA.add(toLowerCase);
                this.lyD.put(toLowerCase, rwVar);
            }
        }
    }

    public final int getType() {
        return 697;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ae.e eVar2) {
        this.gJT = eVar2;
        fl flVar = (fl) this.gJQ.hmg.hmo;
        flVar.vLg = this.mIndex;
        flVar.vLh = this.lyE;
        flVar.vLi = this.lyF;
        return a(eVar, this.gJQ, this);
    }

    protected final int Bh() {
        return 20;
    }

    protected final int a(q qVar) {
        return k.b.hmP;
    }
}
