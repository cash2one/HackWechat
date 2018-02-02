package com.tencent.mm.plugin.wenote.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.g.a.ko;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wenote.model.d;
import com.tencent.mm.plugin.wenote.model.f;
import com.tencent.mm.plugin.wenote.model.g.1;
import com.tencent.mm.plugin.wenote.model.h;
import com.tencent.mm.protocal.c.ve;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

public final class a extends c<ko> {
    public a() {
        this.xen = ko.class.getName().hashCode();
    }

    private static boolean a(ko koVar) {
        switch (koVar.fBM.type) {
            case 0:
                com.tencent.mm.plugin.wenote.model.c.bVN().tQn.b(koVar);
                break;
            case 2:
                if (koVar.fBM.fBT == 4) {
                    long j;
                    String str;
                    String str2;
                    g.pQN.h(14789, new Object[]{Integer.valueOf(4)});
                    x.i("MicroMsg.NotifyWNNoteOperationListener", "do OPEN_NOTE_FROM_SNS");
                    d gVar = new com.tencent.mm.plugin.wenote.model.g();
                    com.tencent.mm.plugin.wenote.model.c.bVN().tQn = gVar;
                    Context context = koVar.fBM.context;
                    ve veVar = koVar.fBM.field_favProto;
                    Bundle bundle = koVar.fBM.fBR;
                    boolean z = koVar.fBM.fBV;
                    String str3 = "";
                    String str4 = "";
                    if (bundle != null) {
                        String string = bundle.getString("noteauthor", "");
                        String string2 = bundle.getString("noteeditor", "");
                        j = bundle.getLong("edittime", 0);
                        gVar.tQG = bundle.getString("snslocalid");
                        gVar.tQH = bundle.getString("notexml", "");
                        gVar.tQO = bundle.getString("snsthumbpath", "");
                        gVar.tQP = bundle.getString("snsnotelinkxml", "");
                        str = string2;
                        str2 = string;
                    } else {
                        str = str4;
                        str2 = str3;
                        j = 0;
                    }
                    gVar.fCb = System.currentTimeMillis();
                    gVar.fBV = z;
                    gVar.tQy = false;
                    gVar.tQL = str2 + ";" + str + ";" + j;
                    gVar.P(context, 4);
                    ar.Dm().F(new 1(gVar, veVar));
                    break;
                }
                g.pQN.h(14789, new Object[]{Integer.valueOf(1)});
                x.i("MicroMsg.NotifyWNNoteOperationListener", "do OPEN_NOTE_FROM_FAV");
                d gVar2 = new com.tencent.mm.plugin.wenote.model.g();
                com.tencent.mm.plugin.wenote.model.c.bVN().tQn = gVar2;
                if (!(koVar.fBM.field_favProto == null || koVar.fBM.field_favProto.weS == null)) {
                    gVar2.tQM = koVar.fBM.field_favProto.weS.fqd;
                }
                if (koVar.fBM.fBR != null) {
                    gVar2.tQN = koVar.fBM.fBR.getLong("edittime", 0);
                }
                gVar2.a(koVar.fBM.field_localId, koVar.fBM.context, Boolean.valueOf(koVar.fBM.fBV), 0, 0, koVar.fBM.fBW);
                break;
            case 3:
                koVar.fBN.path = com.tencent.mm.bi.a.Vh();
                break;
            case 7:
                switch (koVar.fBM.fBS) {
                    case 2:
                        h.aa(koVar.fBM.fBU);
                        break;
                    case 3:
                        try {
                            h.QL(koVar.fBM.fBP);
                            break;
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.NotifyWNNoteOperationListener", e, "", new Object[0]);
                            break;
                        }
                    case 4:
                        h.l(koVar.fBM.context, koVar.fBM.path, koVar.fBM.fBT);
                        break;
                    case 5:
                        h.QK(koVar.fBM.path);
                        break;
                    default:
                        break;
                }
            case 8:
                h.aQ(koVar.fBM.context, koVar.fBM.path);
                break;
            case 9:
                x.i("MicroMsg.NotifyWNNoteOperationListener", "do OPEN_NOTE_FROM_ADD");
                d gVar3 = new com.tencent.mm.plugin.wenote.model.g();
                gVar3.fCb = koVar.fBM.field_localId;
                com.tencent.mm.plugin.wenote.model.c.bVN().tQn = gVar3;
                Context context2 = koVar.fBM.context;
                gVar3.tQy = true;
                if (com.tencent.mm.pluginsdk.model.c.vdg) {
                    gVar3.P(context2, 2);
                    break;
                }
                break;
            case 10:
                f.s(koVar.fBM.field_localId, koVar.fBM.path);
                break;
            case 11:
                f.Z(koVar.fBM.fBU);
                break;
            case 12:
                ar.Dm().g(new c$1(com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp()), 700);
                break;
        }
        return false;
    }
}
