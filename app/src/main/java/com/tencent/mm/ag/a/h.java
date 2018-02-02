package com.tencent.mm.ag.a;

import android.database.Cursor;
import com.tencent.mm.a.f;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.ag.n;
import com.tencent.mm.ag.y;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.ace;
import com.tencent.mm.protocal.c.acf;
import com.tencent.mm.protocal.c.alh;
import com.tencent.mm.protocal.c.bpc;
import com.tencent.mm.protocal.c.bpd;
import com.tencent.mm.protocal.c.bpe;
import com.tencent.mm.protocal.c.bpf;
import com.tencent.mm.protocal.c.hj;
import com.tencent.mm.protocal.c.hk;
import com.tencent.mm.protocal.c.hl;
import com.tencent.mm.protocal.c.hm;
import com.tencent.mm.protocal.c.hq;
import com.tencent.mm.protocal.c.ij;
import com.tencent.mm.protocal.c.pf;
import com.tencent.mm.protocal.c.pk;
import com.tencent.mm.protocal.c.pl;
import com.tencent.mm.protocal.c.wj;
import com.tencent.mm.protocal.c.ze;
import com.tencent.mm.protocal.c.zf;
import com.tencent.mm.protocal.c.zg;
import com.tencent.mm.protocal.c.zh;
import com.tencent.mm.protocal.c.zi;
import com.tencent.mm.protocal.c.zk;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class h implements e {
    private HashSet<a> hre = new HashSet();
    private HashSet<a> hrf = new HashSet();
    private final Object hrg = new Object();
    private f<String, Long> hrh = new f(64);
    private HashSet<a> hri = new HashSet();
    private HashSet<a> hrj = new HashSet();
    private final Object hrk = new Object();
    private f<String, Long> hrl = new f(64);

    public h() {
        g.Di().gPJ.a(1352, (e) this);
        g.Di().gPJ.a(1365, (e) this);
        g.Di().gPJ.a(1353, (e) this);
        g.Di().gPJ.a(1354, (e) this);
        g.Di().gPJ.a(1357, (e) this);
        g.Di().gPJ.a(1356, (e) this);
        g.Di().gPJ.a(1355, (e) this);
        g.Di().gPJ.a(1358, (e) this);
        g.Di().gPJ.a(1367, (e) this);
        g.Di().gPJ.a(1361, (e) this);
        g.Di().gPJ.a(1389, (e) this);
        g.Di().gPJ.a(1315, (e) this);
    }

    protected final void finalize() {
        g.Di().gPJ.b(1352, (e) this);
        g.Di().gPJ.b(1365, (e) this);
        g.Di().gPJ.b(1353, (e) this);
        g.Di().gPJ.b(1354, (e) this);
        g.Di().gPJ.b(1357, (e) this);
        g.Di().gPJ.b(1356, (e) this);
        g.Di().gPJ.b(1355, (e) this);
        g.Di().gPJ.b(1358, (e) this);
        g.Di().gPJ.b(1367, (e) this);
        g.Di().gPJ.b(1361, (e) this);
        g.Di().gPJ.b(1389, (e) this);
        g.Di().gPJ.b(1315, (e) this);
        super.finalize();
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (!(i == 0 && i2 == 0)) {
            x.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:Network not ok");
            if (!(kVar.getType() == 1365 || kVar.getType() == 1353)) {
                return;
            }
        }
        int i3;
        boolean a;
        int i4;
        n nVar;
        String str2;
        String str3;
        switch (kVar.getType()) {
            case 1315:
                kVar = (m) kVar;
                pf My = kVar.My();
                i3 = 0;
                if (My == null || My.vNw == null || My.vNw.ret != 0) {
                    if (My == null || My.vNw == null) {
                        x.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                    } else {
                        x.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", Integer.valueOf(My.vNw.ret));
                    }
                    i3 = -1;
                }
                if (i3 >= 0 && My.vYn == null && My.vYm == null) {
                    i3 = -1;
                }
                if (i3 >= 0) {
                    if (My.vYn != null) {
                        a = a(My.vYn, My.vNq);
                        if (a) {
                            kVar.hrt = My.vYn.vNr;
                        }
                    } else {
                        a = a(My.vYm, My.vNq, true);
                        if (a) {
                            kVar.hrt = My.vYm.wgJ.vNk;
                        }
                    }
                    if (!a) {
                        i4 = -1;
                        nVar = (n) kVar.data;
                        if (nVar != null) {
                            nVar.a(i4, kVar);
                            return;
                        }
                        return;
                    }
                }
                i4 = i3;
                nVar = (n) kVar.data;
                if (nVar != null) {
                    nVar.a(i4, kVar);
                    return;
                }
                return;
            case 1352:
                o oVar = (o) kVar;
                zg zgVar = (oVar.gJQ == null || oVar.gJQ.hmh.hmo == null) ? null : (zg) oVar.gJQ.hmh.hmo;
                zf zfVar = (oVar.gJQ == null || oVar.gJQ.hmg.hmo == null) ? null : (zf) oVar.gJQ.hmg.hmo;
                boolean z = oVar.hru;
                if (zgVar != null && zgVar.vNw != null && zgVar.vNw.ret == 0) {
                    a(zgVar.vYt, zfVar.vNq, z);
                    return;
                } else if (zgVar == null || zgVar.vNw == null) {
                    x.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                    return;
                } else {
                    x.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", Integer.valueOf(zgVar.vNw.ret));
                    return;
                }
            case 1353:
                kVar = (r) kVar;
                nVar = (n) kVar.data;
                if (nVar == null) {
                    synchronized (this.hrk) {
                        this.hrj.clear();
                    }
                    Mx();
                }
                if (i == 0 && i2 == 0) {
                    int i5;
                    zk zkVar = (kVar.gJQ == null || kVar.gJQ.hmh.hmo == null) ? null : (zk) kVar.gJQ.hmh.hmo;
                    i4 = 0;
                    if (zkVar == null || zkVar.vNw == null || zkVar.vNw.ret != 0) {
                        if (zkVar == null || zkVar.vNw == null) {
                            x.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                        } else {
                            x.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", Integer.valueOf(zkVar.vNw.ret));
                        }
                        i4 = -1;
                    }
                    if (i4 < 0 || zkVar.vNx != null) {
                        i5 = i4;
                    } else {
                        x.w("MicroMsg.BizChatNetworkMgr", "resp.user==null");
                        i5 = -1;
                    }
                    if (i5 >= 0) {
                        com.tencent.mm.sdk.e.e eVar = y.Mj().gJP;
                        long j = 0;
                        if (eVar instanceof com.tencent.mm.by.h) {
                            j = ((com.tencent.mm.by.h) eVar).dz(Thread.currentThread().getId());
                        }
                        for (int i6 = 0; i6 < zkVar.vNx.size(); i6++) {
                            x.d("MicroMsg.BizChatNetworkMgr", "GetBizChatUserInfoList %s", ((hq) zkVar.vNx.get(i6)).kNz);
                            j jVar = new j();
                            jVar.field_userId = ((hq) zkVar.vNx.get(i6)).vNr;
                            jVar.field_userName = ((hq) zkVar.vNx.get(i6)).kNz;
                            str2 = jVar.field_userId;
                            str2 = (str2 == null || kVar.hrw == null) ? null : (String) kVar.hrw.get(str2);
                            jVar.field_brandUserName = str2;
                            jVar.field_UserVersion = ((hq) zkVar.vNx.get(i6)).ver;
                            jVar.field_headImageUrl = ((hq) zkVar.vNx.get(i6)).vNl;
                            jVar.field_profileUrl = ((hq) zkVar.vNx.get(i6)).vNz;
                            jVar.field_bitFlag = ((hq) zkVar.vNx.get(i6)).vNm;
                            jVar.field_addMemberUrl = ((hq) zkVar.vNx.get(i6)).vNp;
                            jVar.field_needToUpdate = false;
                            j ca = y.Mj().ca(((hq) zkVar.vNx.get(i6)).vNr);
                            a = ca == null ? false : ca.ho(16);
                            boolean ho = jVar.ho(16);
                            if (ca == null) {
                                y.Mj().a(jVar);
                            } else {
                                y.Mj().b(jVar);
                            }
                            if (a != ho) {
                                c kl = y.Mh().kl(jVar.field_userId);
                                if (kl != null) {
                                    if (a && !ho) {
                                        y.Mi().aX(kl.field_bizChatLocalId);
                                    } else if (!a && ho) {
                                        y.Mi().aW(kl.field_bizChatLocalId);
                                    }
                                }
                            }
                        }
                        if (eVar instanceof com.tencent.mm.by.h) {
                            g.Dj().gQj.fS(j);
                        }
                    }
                    if (nVar != null) {
                        nVar.a(i5, kVar);
                        return;
                    }
                    return;
                }
                return;
            case 1354:
                int i7;
                kVar = (q) kVar;
                zi ziVar = (kVar.gJQ == null || kVar.gJQ.hmh.hmo == null) ? null : (zi) kVar.gJQ.hmh.hmo;
                zh zhVar = kVar.gJQ == null ? null : (zh) kVar.gJQ.hmg.hmo;
                if (ziVar == null || ziVar.vNw == null || ziVar.vNw.ret != 0) {
                    if (ziVar == null || ziVar.vNw == null) {
                        x.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                    } else {
                        x.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", Integer.valueOf(ziVar.vNw.ret));
                    }
                    i7 = -1;
                } else {
                    i7 = 0;
                }
                if (i7 >= 0) {
                    k Mj = y.Mj();
                    String str4 = zhVar.vNq;
                    hq hqVar = ziVar.vNt;
                    if (hqVar == null || bh.ov(str4)) {
                        x.w("MicroMsg.BizChatUserInfoStorage", "setMyUserId: wrong argument");
                    } else {
                        x.i("MicroMsg.BizChatUserInfoStorage", "setMyUserId:%s,%s,%s", str4, hqVar.vNr, Boolean.valueOf(bh.ov(hqVar.vNp)));
                        f kv = y.Mk().kv(str4);
                        if (kv == null) {
                            kv = new f();
                            kv.field_brandUserName = str4;
                            kv.field_userId = hqVar.vNr;
                            y.Mk().a(kv);
                        } else {
                            kv.field_userId = hqVar.vNr;
                            y.Mk().b(kv);
                            x.i("MicroMsg.BizChatUserInfoStorage", "setMyUserId: MyUserId seted");
                        }
                        j jVar2 = new j();
                        jVar2.field_userId = hqVar.vNr;
                        jVar2.field_userName = hqVar.kNz;
                        jVar2.field_brandUserName = str4;
                        jVar2.field_UserVersion = hqVar.ver;
                        jVar2.field_headImageUrl = hqVar.vNl;
                        jVar2.field_profileUrl = hqVar.vNz;
                        jVar2.field_bitFlag = hqVar.vNm;
                        jVar2.field_needToUpdate = false;
                        jVar2.field_addMemberUrl = hqVar.vNp;
                        if (!Mj.b(jVar2)) {
                            Mj.a(jVar2);
                        }
                        Mj.hqH.put(str4, jVar2.field_userId);
                    }
                }
                nVar = (n) kVar.data;
                if (nVar != null) {
                    nVar.a(i7, kVar);
                    return;
                }
                return;
            case 1355:
                kVar = (n) kVar;
                pl Mz = kVar.Mz();
                pk MA = kVar.MA();
                i3 = 0;
                if (Mz == null || Mz.vNw == null || Mz.vNw.ret != 0) {
                    if (Mz == null || Mz.vNw == null) {
                        x.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                    } else {
                        x.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", Integer.valueOf(Mz.vNw.ret));
                    }
                    i3 = -1;
                }
                if (i3 >= 0) {
                    i4 = a(Mz.vYt, MA.vNq, true) ? 0 : -1;
                } else {
                    i4 = i3;
                }
                nVar = (n) kVar.data;
                if (nVar != null) {
                    nVar.a(i4, kVar);
                    return;
                }
                return;
            case 1356:
                kVar = (w) kVar;
                bpf com_tencent_mm_protocal_c_bpf = (kVar.gJQ == null || kVar.gJQ.hmh.hmo == null) ? null : (bpf) kVar.gJQ.hmh.hmo;
                bpe com_tencent_mm_protocal_c_bpe = (kVar.gJQ == null || kVar.gJQ.hmg.hmo == null) ? null : (bpe) kVar.gJQ.hmg.hmo;
                i3 = 0;
                if (com_tencent_mm_protocal_c_bpf == null || com_tencent_mm_protocal_c_bpf.vNw == null || com_tencent_mm_protocal_c_bpf.vNw.ret != 0 || com_tencent_mm_protocal_c_bpf.wgJ == null) {
                    if (com_tencent_mm_protocal_c_bpf == null || com_tencent_mm_protocal_c_bpf.vNw == null) {
                        x.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                    } else {
                        x.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", Integer.valueOf(com_tencent_mm_protocal_c_bpf.vNw.ret));
                    }
                    i3 = -1;
                }
                if (i3 >= 0) {
                    c kl2 = y.Mh().kl(com_tencent_mm_protocal_c_bpf.wgJ.vNk);
                    if (kl2 == null) {
                        str3 = "MicroMsg.BizChatNetworkMgr";
                        String str5 = "bizChatInfo == null:%s, resp.chat == null:%s";
                        Object[] objArr = new Object[2];
                        objArr[0] = Boolean.valueOf(kl2 == null);
                        objArr[1] = Boolean.valueOf(com_tencent_mm_protocal_c_bpf.wgJ == null);
                        x.w(str3, str5, objArr);
                        i3 = -1;
                    }
                    if (i3 < 0 || ((kl2.field_bitFlag == com_tencent_mm_protocal_c_bpf.wgJ.vNm || !kl2.Mu()) && com_tencent_mm_protocal_c_bpf.wgJ.ver <= kl2.field_chatVersion)) {
                        i4 = -1;
                    } else {
                        kl2.field_chatType = com_tencent_mm_protocal_c_bpf.wgJ.type;
                        kl2.field_headImageUrl = com_tencent_mm_protocal_c_bpf.wgJ.vNl;
                        kl2.field_chatName = com_tencent_mm_protocal_c_bpf.wgJ.name;
                        kl2.field_chatVersion = com_tencent_mm_protocal_c_bpf.wgJ.ver;
                        kl2.field_needToUpdate = false;
                        kl2.field_bitFlag = com_tencent_mm_protocal_c_bpf.wgJ.vNm;
                        kl2.field_maxMemberCnt = com_tencent_mm_protocal_c_bpf.wgJ.vNn;
                        kl2.field_ownerUserId = com_tencent_mm_protocal_c_bpf.wgJ.vNo;
                        kl2.field_addMemberUrl = com_tencent_mm_protocal_c_bpf.wgJ.vNp;
                        kl2.field_brandUserName = com_tencent_mm_protocal_c_bpe.vNq;
                        y.Mh().b(kl2);
                        i4 = i3;
                    }
                } else {
                    i4 = i3;
                }
                nVar = (n) kVar.data;
                if (nVar != null) {
                    nVar.a(i4, kVar);
                    return;
                }
                return;
            case 1357:
                x.d("MicroMsg.BizChatNetworkMgr", "handleUpdateBizChatMemberListSceneEnd");
                kVar = (x) kVar;
                bpd com_tencent_mm_protocal_c_bpd = (kVar.gJQ == null || kVar.gJQ.hmh.hmo == null) ? null : (bpd) kVar.gJQ.hmh.hmo;
                bpc com_tencent_mm_protocal_c_bpc = (kVar.gJQ == null || kVar.gJQ.hmg.hmo == null) ? null : (bpc) kVar.gJQ.hmg.hmo;
                if (com_tencent_mm_protocal_c_bpd != null && com_tencent_mm_protocal_c_bpd.vNw != null && com_tencent_mm_protocal_c_bpd.vNw.ret == 0) {
                    i4 = a(com_tencent_mm_protocal_c_bpd.vYt, com_tencent_mm_protocal_c_bpc.vNq, false) ? 0 : -1;
                    nVar = (n) kVar.data;
                    if (nVar != null) {
                        nVar.a(i4, kVar);
                        return;
                    }
                    return;
                } else if (com_tencent_mm_protocal_c_bpd == null || com_tencent_mm_protocal_c_bpd.vNw == null) {
                    x.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                    return;
                } else {
                    x.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", Integer.valueOf(com_tencent_mm_protocal_c_bpd.vNw.ret));
                    return;
                }
            case 1358:
                return;
            case 1365:
                synchronized (this.hrg) {
                    this.hrf.clear();
                }
                Mw();
                if (i == 0 && i2 == 0) {
                    p pVar = (p) kVar;
                    ze zeVar = (pVar.gJQ == null || pVar.gJQ.hmh.hmo == null) ? null : (ze) pVar.gJQ.hmh.hmo;
                    if (zeVar != null && zeVar.vNw != null && zeVar.vNw.ret == 0) {
                        LinkedList linkedList = zeVar.wjd;
                        if (linkedList == null || linkedList.size() == 0) {
                            x.w("MicroMsg.BizChatNetworkMgr", "fullBizChats is empty");
                            return;
                        }
                        Iterator it = linkedList.iterator();
                        while (it.hasNext()) {
                            wj wjVar = (wj) it.next();
                            str2 = wjVar.wgJ.vNk;
                            str2 = (str2 == null || pVar.hrv == null) ? null : (String) pVar.hrv.get(str2);
                            a(wjVar, str2, false);
                        }
                        return;
                    } else if (zeVar == null || zeVar.vNw == null) {
                        x.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                        return;
                    } else {
                        x.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", Integer.valueOf(zeVar.vNw.ret));
                        return;
                    }
                }
                return;
            case 1367:
                s sVar = (s) kVar;
                acf com_tencent_mm_protocal_c_acf = (sVar.gJQ == null || sVar.gJQ.hmh.hmo == null) ? null : (acf) sVar.gJQ.hmh.hmo;
                ace com_tencent_mm_protocal_c_ace = (sVar.gJQ == null || sVar.gJQ.hmg.hmo == null) ? null : (ace) sVar.gJQ.hmg.hmo;
                if (com_tencent_mm_protocal_c_acf != null && com_tencent_mm_protocal_c_acf.vNw != null && com_tencent_mm_protocal_c_acf.vNw.ret == 0) {
                    List<String> list = com_tencent_mm_protocal_c_acf.wkZ;
                    d Mh = y.Mh();
                    str3 = com_tencent_mm_protocal_c_ace.vNq;
                    List<String> arrayList = new ArrayList();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("select bizChatServId from BizChatInfo");
                    stringBuilder.append(" where brandUserName = '").append(str3).append("'");
                    stringBuilder.append(" and (bitFlag & 8").append(") != 0 ");
                    Cursor rawQuery = Mh.rawQuery(stringBuilder.toString(), new String[0]);
                    if (rawQuery != null) {
                        if (rawQuery.moveToFirst()) {
                            do {
                                arrayList.add(rawQuery.getString(0));
                            } while (rawQuery.moveToNext());
                        }
                        rawQuery.close();
                    }
                    for (String str6 : arrayList) {
                        if (!list.contains(str6)) {
                            c kl3 = y.Mh().kl(str6);
                            if (kl3 != null) {
                                kl3.field_bitFlag &= -9;
                                y.Mh().b(kl3);
                            }
                        }
                    }
                    for (String str62 : list) {
                        if (!arrayList.contains(str62)) {
                            c kl4 = y.Mh().kl(str62);
                            if (kl4 == null) {
                                kl4 = new c();
                                kl4.field_bizChatServId = str62;
                                kl4.field_brandUserName = com_tencent_mm_protocal_c_ace.vNq;
                                kl4.field_bitFlag |= 8;
                                y.Mh().a(kl4);
                            } else {
                                kl4.field_bitFlag |= 8;
                                y.Mh().b(kl4);
                            }
                        }
                    }
                    a(com_tencent_mm_protocal_c_acf.wkZ, com_tencent_mm_protocal_c_ace.vNq);
                    return;
                } else if (com_tencent_mm_protocal_c_acf == null || com_tencent_mm_protocal_c_acf.vNw == null) {
                    x.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                    return;
                } else {
                    x.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", Integer.valueOf(com_tencent_mm_protocal_c_acf.vNw.ret));
                    return;
                }
            case 1389:
                kVar = (t) kVar;
                alh MB = kVar.MB();
                i3 = 0;
                if (MB == null || MB.vNw == null || MB.vNw.ret != 0) {
                    if (MB == null || MB.vNw == null) {
                        x.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                    } else {
                        x.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", Integer.valueOf(MB.vNw.ret));
                    }
                    i3 = -1;
                }
                if (i3 >= 0 && MB.vYn == null && MB.vYm == null) {
                    i3 = -1;
                }
                if (i3 >= 0) {
                    if (MB.vYn != null) {
                        a = a(MB.vYn, MB.vNq);
                        if (a) {
                            kVar.hrt = MB.vYn.vNr;
                        }
                    } else {
                        a = a(MB.vYm, MB.vNq, true);
                        if (a) {
                            kVar.hrt = MB.vYm.wgJ.vNk;
                        }
                    }
                    if (!a) {
                        i4 = -1;
                        nVar = (n) kVar.data;
                        if (nVar != null) {
                            nVar.a(i4, kVar);
                            return;
                        }
                        return;
                    }
                }
                i4 = i3;
                nVar = (n) kVar.data;
                if (nVar != null) {
                    nVar.a(i4, kVar);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public static void f(k kVar) {
        g.Di().gPJ.c(kVar);
    }

    public final void ah(String str, String str2) {
        Long l = (Long) this.hrh.get(str);
        if (l == null || l.longValue() + 5000 < System.currentTimeMillis()) {
            long currentTimeMillis = System.currentTimeMillis();
            synchronized (this.hrg) {
                a aVar = new a(str2, str);
                if (this.hrf.contains(aVar)) {
                    return;
                }
                this.hre.add(aVar);
                this.hrh.put(str, new Long(currentTimeMillis));
                Mw();
            }
        }
    }

    public final void a(LinkedList<String> linkedList, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.hrg) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                a aVar = new a(str, str2);
                if (!this.hrf.contains(aVar)) {
                    this.hre.add(aVar);
                    this.hrh.put(str2, new Long(currentTimeMillis));
                }
            }
            Mw();
        }
    }

    private void Mw() {
        LinkedList linkedList = new LinkedList();
        synchronized (this.hrg) {
            if (!this.hrf.isEmpty()) {
            } else if (this.hre.isEmpty()) {
            } else {
                Iterator it = this.hre.iterator();
                while (it.hasNext()) {
                    a aVar = (a) it.next();
                    hk hkVar = new hk();
                    hkVar.vNq = a.a(aVar);
                    hkVar.vNk = a.b(aVar);
                    linkedList.add(hkVar);
                }
                if (linkedList.isEmpty()) {
                    return;
                }
                this.hrf.addAll(this.hre);
                this.hre.clear();
                g.Di().gPJ.a(new p(linkedList), 0);
            }
        }
    }

    public final void ai(String str, String str2) {
        Long l = (Long) this.hrl.get(str);
        if (l == null || l.longValue() + 5000 < System.currentTimeMillis()) {
            aj(str, str2);
        }
    }

    public final void aj(String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.hrk) {
            a aVar = new a(str2, str);
            if (this.hrj.contains(aVar)) {
                return;
            }
            this.hri.add(aVar);
            this.hrl.put(str, new Long(currentTimeMillis));
            Mx();
        }
    }

    public final void b(LinkedList<String> linkedList, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.hrk) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                a aVar = new a(str, str2);
                if (this.hrj.contains(aVar)) {
                    return;
                } else {
                    this.hri.add(aVar);
                    this.hrl.put(str2, new Long(currentTimeMillis));
                }
            }
            Mx();
        }
    }

    private void Mx() {
        LinkedList linkedList = new LinkedList();
        synchronized (this.hrk) {
            if (!this.hrj.isEmpty()) {
            } else if (this.hri.isEmpty()) {
            } else {
                LinkedList linkedList2;
                HashMap hashMap = new HashMap();
                Iterator it = this.hri.iterator();
                while (it.hasNext()) {
                    a aVar = (a) it.next();
                    linkedList2 = (LinkedList) hashMap.get(a.a(aVar));
                    if (linkedList2 == null) {
                        linkedList2 = new LinkedList();
                        hashMap.put(a.a(aVar), linkedList2);
                    }
                    linkedList2.add(a.b(aVar));
                }
                for (String str : hashMap.keySet()) {
                    linkedList2 = (LinkedList) hashMap.get(str);
                    if (!(linkedList2 == null || linkedList2.isEmpty())) {
                        ij ijVar = new ij();
                        ijVar.vNq = str;
                        ijVar.vOD = linkedList2;
                        linkedList.add(ijVar);
                    }
                }
                this.hrj.addAll(this.hri);
                this.hri.clear();
                g.Di().gPJ.a(new r(linkedList, null), 0);
            }
        }
    }

    public static void ak(String str, String str2) {
        g.Di().gPJ.a(new o(str, str2), 0);
    }

    public static void a(String str, String str2, n nVar) {
        if (nVar != null) {
            j kq = e.kq(str2);
            if (kq == null || kq.field_userId.equals(str)) {
                a(str2, nVar);
                return;
            }
            LinkedList linkedList = new LinkedList();
            linkedList.add(str);
            ij ijVar = new ij();
            ijVar.vNq = str2;
            ijVar.vOD = linkedList;
            linkedList = new LinkedList();
            linkedList.add(ijVar);
            g.Di().gPJ.a(new r(linkedList, nVar), 0);
        }
    }

    public static void a(String str, n nVar) {
        g.Di().gPJ.a(new q(str, nVar), 0);
    }

    public static n a(String str, wj wjVar, n nVar) {
        k nVar2 = new n(str, wjVar, nVar);
        g.Di().gPJ.a(nVar2, 0);
        return nVar2;
    }

    public static x a(String str, String str2, hm hmVar, hm hmVar2, n nVar) {
        k xVar = new x(str, str2, hmVar, hmVar2, nVar);
        g.Di().gPJ.a(xVar, 0);
        return xVar;
    }

    public static w a(String str, hj hjVar, n nVar) {
        k wVar = new w(str, hjVar, nVar);
        g.Di().gPJ.a(wVar, 0);
        return wVar;
    }

    private static boolean a(hq hqVar, String str) {
        if (bh.ov(str) || bh.ov(hqVar.vNr)) {
            return false;
        }
        j jVar = new j();
        jVar.field_userId = hqVar.vNr;
        jVar.field_userName = hqVar.kNz;
        jVar.field_brandUserName = str;
        jVar.field_headImageUrl = hqVar.vNl;
        jVar.field_profileUrl = hqVar.vNz;
        jVar.field_UserVersion = hqVar.ver;
        jVar.field_addMemberUrl = hqVar.vNp;
        if (!y.Mj().b(jVar)) {
            y.Mj().a(jVar);
        }
        c cVar = new c();
        cVar.field_bizChatServId = jVar.field_userId;
        cVar.field_brandUserName = jVar.field_brandUserName;
        cVar.field_chatName = jVar.field_userName;
        cVar.field_chatType = 1;
        if (e.e(cVar) != null) {
            return true;
        }
        return false;
    }

    private static boolean a(wj wjVar, String str, boolean z) {
        x.d("MicroMsg.BizChatNetworkMgr", "handleGetBizChatInfoSceneEnd");
        if (wjVar == null || wjVar.wgJ == null || bh.ov(str)) {
            x.w("MicroMsg.BizChatNetworkMgr", "fullBizChat or fullBizChat.chat or brandUserName == null");
            return false;
        }
        boolean z2;
        c cVar;
        c kl = y.Mh().kl(wjVar.wgJ.vNk);
        if (kl == null) {
            x.w("MicroMsg.BizChatNetworkMgr", "bizChatInfo == null");
            kl = new c();
            kl.field_bizChatServId = wjVar.wgJ.vNk;
            kl.field_brandUserName = str;
            z2 = true;
            cVar = kl;
            z = true;
        } else {
            z2 = false;
            cVar = kl;
        }
        if (wjVar.vNs == null) {
            x.w("MicroMsg.BizChatNetworkMgr", "members==null");
            return false;
        }
        Iterator it;
        if (cVar.Mu() || wjVar.wgJ.ver > cVar.field_chatVersion) {
            cVar.field_chatType = wjVar.wgJ.type;
            cVar.field_headImageUrl = wjVar.wgJ.vNl;
            cVar.field_chatName = wjVar.wgJ.name;
            cVar.field_chatVersion = wjVar.wgJ.ver;
            cVar.field_needToUpdate = false;
            cVar.field_bitFlag = wjVar.wgJ.vNm;
            cVar.field_maxMemberCnt = wjVar.wgJ.vNn;
            cVar.field_ownerUserId = wjVar.wgJ.vNo;
            cVar.field_addMemberUrl = wjVar.wgJ.vNp;
            cVar.field_brandUserName = str;
            List linkedList = new LinkedList();
            it = wjVar.vNs.iterator();
            while (it.hasNext()) {
                linkedList.add(((hl) it.next()).vNr);
            }
            cVar.field_userList = bh.d(linkedList, ";");
            if (z2) {
                y.Mh().a(cVar);
            } else {
                y.Mh().b(cVar);
            }
        }
        e.h(cVar);
        hl hlVar;
        if (z) {
            ij ijVar = new ij();
            ijVar.vNq = cVar.field_brandUserName;
            LinkedList linkedList2 = new LinkedList();
            it = wjVar.vNs.iterator();
            while (it.hasNext()) {
                int i;
                hlVar = (hl) it.next();
                k Mj = y.Mj();
                String str2 = hlVar.vNr;
                if (bh.ov(str2)) {
                    x.w("MicroMsg.BizChatUserInfoStorage", "getBizChatVersion wrong argument");
                    i = -1;
                } else {
                    j ca = Mj.ca(str2);
                    if (ca != null) {
                        i = ca.field_UserVersion;
                    } else {
                        x.w("MicroMsg.BizChatUserInfoStorage", "getBizChatVersion item == null");
                        i = -1;
                    }
                }
                if (((long) hlVar.ver) > ((long) i)) {
                    linkedList2.add(hlVar.vNr);
                }
            }
            if (linkedList2.size() > 0) {
                ijVar.vOD = linkedList2;
                LinkedList linkedList3 = new LinkedList();
                linkedList3.add(ijVar);
                g.Di().gPJ.a(new r(linkedList3, null), 0);
            }
        } else {
            com.tencent.mm.sdk.e.e eVar = y.Mj().gJP;
            long j = 0;
            if (eVar instanceof com.tencent.mm.by.h) {
                j = ((com.tencent.mm.by.h) eVar).dz(Thread.currentThread().getId());
            }
            Iterator it2 = wjVar.vNs.iterator();
            while (it2.hasNext()) {
                hlVar = (hl) it2.next();
                j ca2 = y.Mj().ca(hlVar.vNr);
                if (ca2 == null) {
                    ca2 = new j();
                    ca2.field_userId = hlVar.vNr;
                    ca2.field_userName = hlVar.kNz;
                    ca2.field_brandUserName = cVar.field_brandUserName;
                    ca2.field_needToUpdate = true;
                    y.Mj().a(ca2);
                } else if (hlVar.ver > ca2.field_UserVersion) {
                    ca2.field_needToUpdate = true;
                    y.Mj().b(ca2);
                }
            }
            if (eVar instanceof com.tencent.mm.by.h) {
                g.Dj().gQj.fS(j);
            }
        }
        return true;
    }
}
