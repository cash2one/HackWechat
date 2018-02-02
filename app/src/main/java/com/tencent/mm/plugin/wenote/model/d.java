package com.tencent.mm.plugin.wenote.model;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.R;
import com.tencent.mm.bi.a;
import com.tencent.mm.g.a.fv;
import com.tencent.mm.g.a.ko;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wenote.b.c;
import com.tencent.mm.plugin.wenote.model.a.e;
import com.tencent.mm.plugin.wenote.model.a.h;
import com.tencent.mm.plugin.wenote.model.a.i;
import com.tencent.mm.plugin.wenote.model.a.j;
import com.tencent.mm.plugin.wenote.model.a.k;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.model.a.m;
import com.tencent.mm.plugin.wenote.model.a.n;
import com.tencent.mm.plugin.wenote.model.a.o;
import com.tencent.mm.plugin.wenote.model.a.q;
import com.tencent.mm.plugin.wenote.model.a.r;
import com.tencent.mm.plugin.wenote.model.a.s;
import com.tencent.mm.plugin.wenote.model.a.t;
import com.tencent.mm.plugin.wenote.model.a.u;
import com.tencent.mm.plugin.wenote.model.a.v;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.protocal.c.ur;
import com.tencent.mm.protocal.c.us;
import com.tencent.mm.protocal.c.ux;
import com.tencent.mm.protocal.c.ve;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;

public abstract class d {
    public static boolean tQA = false;
    public static String tQB = (a.Vg() + "/fav_fileicon_recording.png");
    private static String tQC = (a.Vg() + "/ofm_file_icon.png");
    private static String tQD = (a.Vg() + "/app_attach_file_icon_pic.png");
    public static String tQE = (a.Vg() + "/location_msg.png");
    public static String tQF = (a.Vg() + "/note_fav_not_support.png");
    public static String tQw = "";
    public static HashMap<String, JSONArray> tQx = new HashMap();
    public l tQp = null;
    public f tQq;
    public HashMap<String, v> tQr = new HashMap();
    public HashMap<String, String> tQs = new HashMap();
    public HashMap<String, n> tQt = new HashMap();
    public String tQu = "WeNote_0";
    public String tQv = "";
    public boolean tQy = false;
    public ve tQz = new ve();

    public abstract void a(uq uqVar, String str);

    public abstract void aN(Context context, String str);

    public abstract void aO(Context context, String str);

    public abstract void aP(Context context, String str);

    public abstract String h(uq uqVar);

    public abstract String i(uq uqVar);

    public abstract void n(uq uqVar);

    public final void cu(List<uq> list) {
        ArrayList QS;
        Throwable e;
        v vVar = new v();
        List list2 = null;
        for (uq uqVar : list) {
            n nVar = new n();
            nVar.tRP = uqVar.wdL;
            if (uqVar.bjS == 1) {
                nVar.tRP = "-1";
            }
            String h;
            if (!bh.ov(nVar.tRP)) {
                if (!nVar.tRP.equals("WeNoteHtmlFile")) {
                    if (!nVar.tRP.equals("-1")) {
                        int i = bh.getInt(nVar.tRP.substring(7), 0);
                        int i2 = bh.getInt(this.tQu.substring(7), 0);
                        this.tQu = "WeNote_" + (i2 > i ? String.valueOf(i2) : String.valueOf(i));
                    }
                    nVar.mvG = uqVar.mvG;
                    String h2;
                    String str;
                    switch (uqVar.bjS) {
                        case 1:
                            if (!bh.ov(uqVar.desc)) {
                                s sVar;
                                if (vVar.tSi.size() > 0 && vVar.tSi.get(vVar.tSi.size() - 1) != null && ((n) vVar.tSi.get(vVar.tSi.size() - 1)).tRP.equals("-1")) {
                                    sVar = (s) vVar.tSi.get(vVar.tSi.size() - 1);
                                    sVar.content += uqVar.desc;
                                    break;
                                }
                                sVar = new h();
                                sVar.tRP = nVar.tRP;
                                sVar.content = uqVar.desc;
                                vVar.tSi.add(sVar);
                                break;
                            }
                            break;
                            break;
                        case 2:
                            o eVar = new e();
                            eVar.tRP = nVar.tRP;
                            eVar.type = 2;
                            eVar.mvG = nVar.mvG;
                            eVar.tRO = uqVar;
                            h2 = h(uqVar);
                            if (!bh.ov(h2)) {
                                str = h2 + "_bigthumb";
                                String i3 = i(uqVar);
                                if (!com.tencent.mm.a.e.bO(i3)) {
                                    a(uqVar, i3);
                                }
                                if (com.tencent.mm.a.e.bO(h2)) {
                                    eVar.tRQ = true;
                                    c.fb(h2, str);
                                } else {
                                    n(uqVar);
                                    eVar.tRQ = false;
                                    this.tQs.put(uqVar.mvG, nVar.tRP);
                                }
                                eVar.fCa = str;
                                eVar.tRR = h2;
                                vVar.tSi.add(eVar);
                                this.tQt.put(nVar.tRP, eVar);
                                break;
                            }
                            break;
                        case 3:
                            u kVar = new k();
                            kVar.tRP = nVar.tRP;
                            kVar.type = 4;
                            kVar.mvG = nVar.mvG;
                            kVar.tRO = uqVar;
                            h2 = h(uqVar);
                            if (bh.ov(h2) || !com.tencent.mm.a.e.bO(h2)) {
                                n(uqVar);
                                kVar.tRQ = false;
                                kVar.tSg = ac.getContext().getString(R.l.egZ);
                                this.tQs.put(uqVar.mvG, nVar.tRP);
                            } else {
                                kVar.tRQ = true;
                                kVar.tRN = tQB;
                                kVar.length = uqVar.duration;
                            }
                            kVar.fCa = h2;
                            kVar.tSf = f.s(ac.getContext(), (int) f.bv((long) uqVar.duration));
                            kVar.fvy = uqVar.duration;
                            b fvVar = new fv();
                            fvVar.fvq.type = 17;
                            fvVar.fvq.fvs = uqVar;
                            com.tencent.mm.sdk.b.a.xef.m(fvVar);
                            kVar.fvx = fvVar.fvr.ret;
                            kVar.tRF = uqVar.wcY;
                            vVar.tSi.add(kVar);
                            this.tQt.put(nVar.tRP, kVar);
                            break;
                        case 4:
                            j jVar = new j();
                            jVar.tRP = nVar.tRP;
                            jVar.type = 6;
                            jVar.mvG = nVar.mvG;
                            jVar.tRO = uqVar;
                            jVar.fvC = i(uqVar);
                            str = h(uqVar);
                            jVar.fCa = str;
                            if (!(bh.ov(jVar.fvC) || com.tencent.mm.a.e.bO(jVar.fvC))) {
                                if (com.tencent.mm.a.e.bO(str)) {
                                    Bitmap Rs = com.tencent.mm.pluginsdk.model.c.Rs(str);
                                    if (Rs != null) {
                                        try {
                                            x.i("MicroMsg.WNNoteBase", "add fav service: create thumbpath bitmap, saveBitmapToImage ");
                                            com.tencent.mm.pluginsdk.k.e.a(Rs, CompressFormat.JPEG, jVar.fvC);
                                        } catch (Throwable e2) {
                                            x.printErrStackTrace("MicroMsg.WNNoteBase", e2, "", new Object[0]);
                                        }
                                    }
                                } else {
                                    a(uqVar, jVar.fvC);
                                    this.tQs.put(uqVar.mvG + "_t", nVar.tRP);
                                }
                            }
                            if (bh.ov(str) || !com.tencent.mm.a.e.bO(str)) {
                                jVar.tRQ = false;
                                this.tQs.put(uqVar.mvG, nVar.tRP);
                            } else {
                                jVar.tRQ = true;
                            }
                            vVar.tSi.add(jVar);
                            this.tQt.put(nVar.tRP, jVar);
                            break;
                        case 6:
                            q qVar = new q();
                            qVar.fzt = (float) uqVar.wdD.wdZ.lat;
                            qVar.hBL = (float) uqVar.wdD.wdZ.lng;
                            qVar.fzv = uqVar.wdD.wdZ.fzv;
                            qVar.tSa = uqVar.wdD.wdZ.label;
                            qVar.tSb = uqVar.wdD.wdZ.fDu;
                            qVar.tSc = uqVar.wdL;
                            r fVar = new com.tencent.mm.plugin.wenote.model.a.f();
                            fVar.tRP = nVar.tRP;
                            fVar.type = 3;
                            fVar.mvG = nVar.mvG;
                            fVar.tRO = uqVar;
                            fVar.tRQ = true;
                            fVar.nTe = qVar.tSb;
                            fVar.hxu = qVar.tSa;
                            fVar.lat = (double) qVar.fzt;
                            fVar.lng = (double) qVar.hBL;
                            fVar.tSd = (double) qVar.fzv;
                            fVar.fCa = "";
                            vVar.tSi.add(fVar);
                            this.tQt.put(nVar.tRP, fVar);
                            break;
                        case 8:
                            t cVar = new com.tencent.mm.plugin.wenote.model.a.c();
                            cVar.tRP = nVar.tRP;
                            cVar.type = 5;
                            cVar.mvG = nVar.mvG;
                            cVar.tRO = uqVar;
                            h2 = h(uqVar);
                            if (bh.ov(h2) || !com.tencent.mm.a.e.bO(h2)) {
                                cVar.tRQ = false;
                                this.tQs.put(uqVar.mvG, nVar.tRP);
                            } else {
                                cVar.tRQ = true;
                                cVar.fCa = h2;
                            }
                            cVar.tRN = h.QM(uqVar.wcY);
                            cVar.title = uqVar.title;
                            cVar.content = uqVar.desc;
                            cVar.tRF = uqVar.wcY;
                            if (bh.ov(cVar.content)) {
                                cVar.content = f.ah((float) uqVar.wde);
                            }
                            vVar.tSi.add(cVar);
                            this.tQt.put(nVar.tRP, cVar);
                            break;
                        default:
                            if (uqVar.bjS <= 0) {
                                break;
                            }
                            m iVar = new i();
                            iVar.tRP = nVar.tRP;
                            iVar.type = 0;
                            iVar.mvG = nVar.mvG;
                            iVar.tRO = uqVar;
                            String h3 = h(uqVar);
                            iVar.tRQ = true;
                            iVar.fCa = h3;
                            iVar.tRN = tQF;
                            iVar.title = ac.getContext().getResources().getString(R.l.egn);
                            iVar.content = ac.getContext().getResources().getString(R.l.efW);
                            vVar.tSi.add(iVar);
                            this.tQt.put(nVar.tRP, iVar);
                            break;
                    }
                }
                h = h(uqVar);
                List list3;
                if (bh.ov(h) || !com.tencent.mm.a.e.bO(h)) {
                    n(uqVar);
                    vVar.tSj = true;
                    x.i("MicroMsg.WNNoteBase", "local html file not exist,download htmlfile,dataid: %s", new Object[]{uqVar.mvG});
                    this.tQs.put(uqVar.mvG, nVar.tRP);
                    list3 = list2;
                } else {
                    try {
                        vVar.tSh = c.QZ(h);
                        QS = com.tencent.mm.plugin.wenote.b.b.QS(vVar.tSh);
                        try {
                            x.i("MicroMsg.WNNoteBase", "local html file exist,dataid: %s", new Object[]{uqVar.mvG});
                            tQx.containsKey(vVar.tSh);
                        } catch (Exception e3) {
                            e = e3;
                            x.printErrStackTrace("MicroMsg.WNNoteBase", e, "", new Object[0]);
                            x.i("MicroMsg.WNNoteBase", "dealWNNoteInfo,WeNoteHtmlFile, cdnurl is null :%B, cdnkey is null : %B ", new Object[]{Boolean.valueOf(bh.ov(uqVar.wcJ)), Boolean.valueOf(bh.ov(uqVar.wcL))});
                            list2 = QS;
                        }
                    } catch (Throwable e22) {
                        Throwable th = e22;
                        list3 = list2;
                        e = th;
                        x.printErrStackTrace("MicroMsg.WNNoteBase", e, "", new Object[0]);
                        x.i("MicroMsg.WNNoteBase", "dealWNNoteInfo,WeNoteHtmlFile, cdnurl is null :%B, cdnkey is null : %B ", new Object[]{Boolean.valueOf(bh.ov(uqVar.wcJ)), Boolean.valueOf(bh.ov(uqVar.wcL))});
                        list2 = QS;
                    }
                }
                x.i("MicroMsg.WNNoteBase", "dealWNNoteInfo,WeNoteHtmlFile, cdnurl is null :%B, cdnkey is null : %B ", new Object[]{Boolean.valueOf(bh.ov(uqVar.wcJ)), Boolean.valueOf(bh.ov(uqVar.wcL))});
                list2 = QS;
            } else {
                x.e("MicroMsg.WNNoteBase", "Note: DataItem.htmlid is null");
                h = h(uqVar);
                if (bh.ov(h) || !com.tencent.mm.a.e.bO(h)) {
                    n(uqVar);
                    return;
                } else {
                    f.s(this.tQp.fCb, h);
                    return;
                }
            }
        }
        if (list2 != null && list2.size() > 0) {
            h.a(vVar.tSi, list2, true);
        }
        if (this.tQp.fqm == -1) {
            this.tQr.put(Long.toString(this.tQp.fCb), vVar);
        } else {
            this.tQr.put(Long.toString(this.tQp.fqm), vVar);
        }
    }

    public final void b(ko koVar) {
        if (koVar.fBM == null) {
            x.e("MicroMsg.WNNoteBase", "setWNNativeCallbackOnClick, opertionevent.data is null, retutn");
            return;
        }
        String str = koVar.fBM.fBO;
        n nVar = (n) this.tQt.get(str);
        if (nVar == null) {
            x.e("MicroMsg.WNNoteBase", "setWNNativeCallbackOnClick, mEditorIdToDataItem.get(localEditorId) is null, retutn");
            return;
        }
        x.i("MicroMsg.WNNoteBase", "setWNNativeCallbackOnClick, mEditorIdToDataItem.get(localEditorId) is %d", new Object[]{Integer.valueOf(nVar.type)});
        switch (nVar.type) {
            case 2:
                aP(koVar.fBM.context, str);
                return;
            case 3:
                aO(koVar.fBM.context, str);
                return;
            case 5:
                aN(koVar.fBM.context, str);
                return;
            case 6:
                Context context = koVar.fBM.context;
                j jVar = (j) this.tQt.get(str);
                if (!bh.ov(jVar.fCa)) {
                    if (!com.tencent.mm.a.e.bO(jVar.fCa)) {
                        uq QH = QH(jVar.mvG);
                        if (QH == null) {
                            x.e("MicroMsg.WNNoteBase", "goToVideoPlay, favData is null");
                            return;
                        }
                        n(QH);
                    }
                    Intent intent = new Intent();
                    intent.putExtra("key_detail_fav_path", jVar.fCa);
                    intent.putExtra("key_detail_fav_thumb_path", jVar.fvC);
                    intent.putExtra("key_detail_fav_video_duration", jVar.duration);
                    intent.putExtra("key_detail_data_id", jVar.mvG);
                    intent.putExtra("key_detail_statExtStr", "");
                    intent.putExtra("key_detail_fav_video_show_download_status", true);
                    com.tencent.mm.bm.d.b(context, "favorite", ".ui.detail.FavoriteVideoPlayUI", intent, 1);
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static ve a(String str, List<n> list, uq uqVar) {
        String Vj;
        LinkedList linkedList = new LinkedList();
        ve veVar = new ve();
        if (uqVar != null) {
            linkedList.add(uqVar);
        } else if (!bh.ov(str) && str.length() > 0) {
            Vj = a.Vj();
            uq uqVar2 = new uq();
            uqVar2.CJ(8);
            uqVar2.TN("WeNoteHtmlFile");
            uqVar2.lt(true);
            uqVar2.fw((long) com.tencent.mm.a.e.bN(Vj));
            uqVar2.TA(".htm");
            linkedList.add(uqVar2);
            String o = f.o(uqVar2);
            if (!FileOp.bO(o)) {
                FileOp.x(Vj, o);
            }
            uqVar2.TE(o);
        }
        for (n nVar : list) {
            if (nVar != null) {
                if (nVar.tRO != null) {
                    linkedList.add(nVar.tRO);
                } else {
                    uq uqVar3 = new uq();
                    ur urVar = new ur();
                    us usVar = new us();
                    usVar.CN(6);
                    urVar.c(usVar);
                    uqVar3.a(urVar);
                    switch (nVar.type) {
                        case 1:
                            if (!tQA) {
                                g.pQN.h(14547, new Object[]{Integer.valueOf(6)});
                                tQA = true;
                            }
                            uqVar3.CJ(1);
                            uqVar3.ls(true);
                            uqVar3.lt(true);
                            h hVar = (h) nVar;
                            uqVar3.TD(nVar.mvG);
                            uqVar3.Tr(com.tencent.mm.plugin.wenote.b.b.QT(hVar.content));
                            if (!bh.ov(uqVar3.desc) && uqVar3.desc.length() > 1000) {
                                uqVar3.Tr(uqVar3.desc.substring(0, 1000));
                            }
                        case 2:
                            uqVar3.CJ(2);
                            o oVar = (o) nVar;
                            Vj = oVar.tRR;
                            uqVar3.TE(Vj);
                            if (bh.ov(((o) nVar).mvG)) {
                                uqVar3.TD(f.QI(oVar.toString()));
                                com.tencent.mm.sdk.platformtools.d.b(Vj, 150, 150, CompressFormat.JPEG, 90, f.i(uqVar3));
                                uqVar3.TF(f.i(uqVar3));
                            } else {
                                uqVar3.TD(nVar.mvG);
                                uqVar3.TF(oVar.fCa);
                            }
                            uqVar3.CJ(2);
                        case 3:
                            uqVar3.CJ(6);
                            r rVar = (r) nVar;
                            uqVar3.TD(nVar.mvG);
                            ux uxVar = new ux();
                            uxVar.TZ(rVar.hxu);
                            uxVar.s(rVar.lat);
                            uxVar.r(rVar.lng);
                            uxVar.CO((int) rVar.tSd);
                            uxVar.Ua(rVar.nTe);
                            uqVar3.ls(true);
                            uqVar3.lt(true);
                            uqVar3.wdD.a(uxVar);
                        case 4:
                            uqVar3.CJ(3);
                            u uVar = (u) nVar;
                            uqVar3.TD(nVar.mvG);
                            String str2 = uVar.fCa;
                            if (!(bh.ov(str2) || str2.length() == 0)) {
                                uqVar3.TE(str2);
                                uqVar3.CI(uVar.length);
                                uqVar3.lt(true);
                                uqVar3.TA(uVar.tRF);
                            }
                        case 5:
                            uqVar3.CJ(8);
                            t tVar = (t) nVar;
                            uqVar3.TD(nVar.mvG);
                            uqVar3.TE(tVar.fCa);
                            uqVar3.lt(true);
                            uqVar3.Tq(tVar.title);
                            uqVar3.Tr(tVar.content);
                            uqVar3.TA(tVar.tRF);
                            uqVar3.TN(nVar.tRP);
                            linkedList.add(uqVar3);
                            break;
                        case 6:
                            uqVar3.CJ(4);
                            j jVar = (j) nVar;
                            uqVar3.TD(nVar.mvG);
                            uqVar3.TE(jVar.fCa);
                            uqVar3.TF(jVar.fvC);
                            com.tencent.mm.plugin.sight.base.a Js = com.tencent.mm.plugin.sight.base.d.Js(jVar.fCa);
                            if (Js != null) {
                                uqVar3.CI(Js.bsA());
                            } else {
                                uqVar3.CI(1);
                            }
                            uqVar3.TA(jVar.tRF);
                            uqVar3.TN(nVar.tRP);
                            linkedList.add(uqVar3);
                            break;
                    }
                    uqVar3.TN(nVar.tRP);
                    linkedList.add(uqVar3);
                }
            }
        }
        a(linkedList, (List) list);
        veVar.av(linkedList);
        return veVar;
    }

    private static void a(LinkedList<uq> linkedList, List<n> list) {
        x.i("MicroMsg.WNNoteBase", "do WNNoteBase.setExtraInfo");
        if (linkedList.size() > 0) {
            int size = linkedList.size();
            int i = 0;
            while (i < size) {
                uq uqVar = (uq) linkedList.get(i);
                if (i > 0 && bh.ov(uqVar.wcJ)) {
                    uqVar.TD(f.QI(uqVar.toString()));
                    n nVar = null;
                    if (i - 1 >= 0 && i - 1 < list.size() && list.size() > 0) {
                        nVar = (n) list.get(i - 1);
                    }
                    if (!(nVar == null || nVar.tRP == null || !nVar.tRP.equals(uqVar.wdL))) {
                        nVar.mvG = uqVar.mvG;
                    }
                }
                if (i <= 0 || bh.ov(uqVar.wcJ) || bh.ov(uqVar.wcL)) {
                    String bV;
                    String bW;
                    x.i("MicroMsg.WNNoteBase", "datalist.get[%d].type = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(uqVar.bjS)});
                    String str = uqVar.wdh;
                    if (FileOp.bO(str)) {
                        x.i("MicroMsg.WNNoteBase", "datapath exist,pathname:%s", new Object[]{str});
                        bV = com.tencent.mm.a.g.bV(str);
                        bW = com.tencent.mm.a.g.bW(str);
                        uqVar.TB(bV);
                        uqVar.TC(bW);
                        uqVar.fw(new File(str).length());
                        bV = f.o(uqVar);
                        boolean bO = FileOp.bO(bV);
                        if (!(str.equals(bV) || bO || uqVar.wdL.equals("WeNoteHtmlFile"))) {
                            FileOp.x(str, bV);
                        }
                    } else {
                        x.e("MicroMsg.WNNoteBase", "datapath not exist, %s not exist!", new Object[]{str});
                    }
                    str = uqVar.wdj;
                    if (FileOp.bO(str)) {
                        x.i("MicroMsg.WNNoteBase", "thumbPath exist,pathname:%s", new Object[]{str});
                        bV = com.tencent.mm.a.g.bV(str);
                        bW = com.tencent.mm.a.g.bW(str);
                        uqVar.TG(bV);
                        uqVar.TH(bW);
                        uqVar.fx(new File(str).length());
                        String i2 = f.i(uqVar);
                        if (!(str.equals(i2) || FileOp.bO(i2))) {
                            FileOp.x(str, i2);
                        }
                    } else {
                        x.e("MicroMsg.WNNoteBase", "thumbPath not exist, pathname:%s", new Object[]{str});
                    }
                } else {
                    uqVar.ls(true);
                    uqVar.lt(true);
                }
                i++;
            }
        }
    }

    public void QG(String str) {
    }

    public final uq QH(String str) {
        if (bh.ov(str)) {
            x.e("MicroMsg.WNNoteBase", "getFavDataItemByDataId, dataId is null");
            return null;
        }
        String str2 = (String) this.tQs.get(str);
        if (bh.ov(str2)) {
            x.e("MicroMsg.WNNoteBase", "getFavDataItemByDataId, can not find editorId by dataId: %s", new Object[]{str});
            return null;
        }
        n nVar = (n) this.tQt.get(str2);
        if (nVar != null) {
            return nVar.tRO;
        }
        x.e("MicroMsg.WNNoteBase", "getFavDataItemByDataId, can not find item by editorId: %s", new Object[]{str2});
        return null;
    }

    public String bVO() {
        return "";
    }
}
