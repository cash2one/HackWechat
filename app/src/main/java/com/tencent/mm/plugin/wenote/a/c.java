package com.tencent.mm.plugin.wenote.a;

import com.tencent.mm.a.e;
import com.tencent.mm.g.a.kp;
import com.tencent.mm.plugin.fav.a.i;
import com.tencent.mm.plugin.wenote.b.b;
import com.tencent.mm.plugin.wenote.model.a.n;
import com.tencent.mm.plugin.wenote.model.a.u;
import com.tencent.mm.plugin.wenote.model.a.v;
import com.tencent.mm.plugin.wenote.model.d;
import com.tencent.mm.plugin.wenote.model.f;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.util.ArrayList;
import java.util.Iterator;

public final class c implements i, com.tencent.mm.plugin.record.a.c {
    public final void a(com.tencent.mm.plugin.fav.a.c cVar) {
        if (cVar.field_type != 18) {
            x.i("MicroMsg.Note.WNNoteFavCdnChangedListener", "Not Note CDN onCdnStatusChanged %d", new Object[]{Long.valueOf(cVar.field_favLocalId)});
            return;
        }
        if (cVar.field_status == 3 && e.bO(cVar.field_path) && cVar.field_path.endsWith("..htm")) {
            f.s(cVar.field_favLocalId, cVar.field_path);
        }
        com.tencent.mm.plugin.wenote.model.e eVar = new com.tencent.mm.plugin.wenote.model.e();
        eVar.field_favLocalId = cVar.field_favLocalId;
        eVar.field_dataId = cVar.field_dataId;
        eVar.field_status = cVar.field_status;
        eVar.field_offset = cVar.field_offset;
        eVar.field_totalLen = cVar.field_totalLen;
        eVar.field_path = cVar.field_path;
        a(eVar);
    }

    public final void a(int i, com.tencent.mm.plugin.record.a.f fVar) {
        com.tencent.mm.plugin.wenote.model.e eVar = new com.tencent.mm.plugin.wenote.model.e();
        eVar.field_localId = fVar.field_localId;
        eVar.field_dataId = fVar.field_dataId;
        eVar.field_status = fVar.field_status;
        eVar.field_offset = fVar.field_offset;
        eVar.field_totalLen = fVar.field_totalLen;
        eVar.field_path = fVar.field_path;
        a(eVar);
    }

    private static void a(com.tencent.mm.plugin.wenote.model.e eVar) {
        int i = 0;
        d dVar = com.tencent.mm.plugin.wenote.model.c.bVN().tQn;
        if (dVar != null) {
            int i2 = (eVar.field_status == 3 || eVar.field_status == 2) ? true : 0;
            if (i2 != 0 && e.bO(eVar.field_path)) {
                String str = (String) dVar.tQs.get(eVar.field_dataId);
                if (!bh.ov(str)) {
                    x.d("MicroMsg.Note.WNNoteFavCdnChangedListener", "on cdn status change,editorId[%s]", new Object[]{str});
                    if (!eVar.field_dataId.endsWith("_t") || dVar.tQt.get(str) == null) {
                        if (str.equals("WeNoteHtmlFile")) {
                            v vVar;
                            x.d("MicroMsg.Note.WNNoteFavCdnChangedListener", "WNNote:webview reload");
                            if (dVar.tQp.fCb == -1) {
                                vVar = (v) dVar.tQr.get(Long.toString(dVar.tQp.fqm));
                            } else {
                                vVar = (v) dVar.tQr.get(Long.toString(dVar.tQp.fCb));
                            }
                            if (vVar != null) {
                                try {
                                    vVar.tSh = com.tencent.mm.plugin.wenote.b.c.QZ(eVar.field_path);
                                    com.tencent.mm.plugin.wenote.model.nativenote.manager.c bWp = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp();
                                    str = vVar.tSh;
                                    if (!(bh.ov(str) || bWp.jRt == null)) {
                                        ArrayList QS = b.QS(str);
                                        if (QS != null && QS.size() > 0) {
                                            synchronized (bWp) {
                                                try {
                                                    x.i("MicroMsg.Note.NoteDataManager", "updateDataByHtml, mHasInitDataListFinish :％B", new Object[]{Boolean.valueOf(bWp.tSJ)});
                                                    ar.Dm().g(new c$2(bWp, QS), bWp.tSJ ? 500 : 1000);
                                                } catch (Exception e) {
                                                    x.e("MicroMsg.Note.NoteDataManager", "updateDataByHtml exception,%s", new Object[]{e.toString()});
                                                }
                                            }
                                        }
                                    }
                                } catch (Throwable e2) {
                                    x.printErrStackTrace("MicroMsg.Note.WNNoteFavCdnChangedListener", e2, "", new Object[0]);
                                }
                            } else {
                                return;
                            }
                        } else if (dVar.tQs.containsValue("WeNoteHtmlFile")) {
                            v vVar2;
                            if (dVar.tQp.fCb == -1) {
                                vVar2 = (v) dVar.tQr.get(Long.toString(dVar.tQp.fqm));
                            } else {
                                vVar2 = (v) dVar.tQr.get(Long.toString(dVar.tQp.fCb));
                            }
                            if (vVar2 != null && vVar2.tSi != null) {
                                Iterator it = vVar2.tSi.iterator();
                                while (it.hasNext()) {
                                    n nVar = (n) it.next();
                                    if (nVar.tRP.equals(str)) {
                                        nVar.tRQ = true;
                                        if (nVar.type == 4) {
                                            u uVar = (u) nVar;
                                            uVar.tRN = d.tQB;
                                            uq QH = dVar.QH(eVar.field_dataId);
                                            if (QH == null) {
                                                x.e("MicroMsg.Note.WNNoteFavCdnChangedListener", "favData is null");
                                            } else {
                                                i = QH.duration;
                                            }
                                            uVar.length = (int) f.bv((long) i);
                                            uVar.tSf = f.s(ac.getContext(), uVar.length);
                                        } else if (nVar.getType() == 2) {
                                            com.tencent.mm.plugin.wenote.b.c.fb(eVar.field_path, ((n) dVar.tQt.get(str)).fCa);
                                        } else {
                                            nVar.fCa = eVar.field_path;
                                        }
                                        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().a(str, nVar);
                                    }
                                }
                            } else {
                                return;
                            }
                        } else {
                            com.tencent.mm.sdk.b.b kpVar = new kp();
                            kpVar.fBX.fBO = str;
                            kpVar.fBX.fCa = eVar.field_path;
                            kpVar.fBX.type = 1;
                            kpVar.fBX.fBS = ((n) dVar.tQt.get(str)).type;
                            if (com.tencent.mm.pluginsdk.model.c.vdg && kpVar.fBX.fBS != 4) {
                                if (kpVar.fBX.fBS != 2) {
                                    ((n) dVar.tQt.get(str)).fCa = eVar.field_path;
                                } else {
                                    com.tencent.mm.plugin.wenote.b.c.fb(eVar.field_path, ((n) dVar.tQt.get(str)).fCa);
                                }
                                ((n) dVar.tQt.get(str)).tRQ = true;
                                com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().a(str, (com.tencent.mm.plugin.wenote.model.a.b) dVar.tQt.get(str));
                            }
                            if (5 != kpVar.fBX.fBS) {
                                if (kpVar.fBX.fBS == 4) {
                                    int i3;
                                    uq QH2 = dVar.QH(eVar.field_dataId);
                                    if (QH2 == null) {
                                        x.e("MicroMsg.Note.WNNoteFavCdnChangedListener", "favData is null");
                                        i3 = 0;
                                    } else {
                                        i3 = QH2.duration;
                                    }
                                    kpVar.fBX.fvy = i3;
                                    ((n) dVar.tQt.get(str)).fCa = eVar.field_path;
                                    ((n) dVar.tQt.get(str)).tRQ = true;
                                    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().a(str, (com.tencent.mm.plugin.wenote.model.a.b) dVar.tQt.get(str));
                                }
                                x.i("MicroMsg.Note.WNNoteFavCdnChangedListener", "WNNote: publish insertevnet:%s,%s", new Object[]{kpVar.fBX.fBO, kpVar.fBX.fCa});
                                if (!com.tencent.mm.pluginsdk.model.c.vdg) {
                                    a.xef.m(kpVar);
                                }
                            } else {
                                return;
                            }
                        }
                        dVar.tQs.remove(eVar.field_dataId);
                        return;
                    }
                    if (((n) dVar.tQt.get(str)).getType() == 2) {
                        ((n) dVar.tQt.get(str)).fCa = eVar.field_path;
                    }
                    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().a(str, (com.tencent.mm.plugin.wenote.model.a.b) dVar.tQt.get(str));
                    dVar.tQs.remove(eVar.field_dataId);
                }
            }
        }
    }
}
