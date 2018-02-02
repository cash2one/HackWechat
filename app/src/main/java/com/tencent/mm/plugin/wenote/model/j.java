package com.tencent.mm.plugin.wenote.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.mt;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.model.a.n;
import com.tencent.mm.protocal.b.a.c;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.protocal.c.us;
import com.tencent.mm.protocal.c.ux;
import com.tencent.mm.protocal.c.vg;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.r;
import java.util.HashMap;

public final class j extends d {
    private static HashMap<String, l> tRj = new HashMap();
    private boolean fBV;
    private String fCG;
    private vg fvB = new vg();
    private c pGh = null;
    private int tQJ = 0;
    private int tQK = 0;
    private String tQL;
    private Long tRh;
    private boolean tRi = false;

    static /* synthetic */ void a(j jVar) {
        if (tRj.containsKey(jVar.fCG)) {
            jVar.tQp = (l) tRj.get(jVar.fCG);
            return;
        }
        jVar.tQp = new l();
        jVar.tQp.fqm = jVar.tRh.longValue();
        jVar.tQp.tRJ = jVar.fCG;
        if (jVar.pGh != null && jVar.pGh.hdX != null) {
            if (jVar.pGh.vCU != null) {
                jVar.tQp.tRL = jVar.pGh.vCU.weM;
                jVar.tQp.tRK = jVar.pGh.vCU.weL;
                jVar.tQp.tRM = jVar.pGh.vCV;
            }
            jVar.tQp.pFF = jVar.pGh.hdX;
            jVar.tQp.bjS = 0;
            tRj.put(jVar.fCG, jVar.tQp);
        }
    }

    public j() {
        this.tQr.clear();
        com.tencent.mm.pluginsdk.model.c.bYm();
    }

    public final void a(String str, Long l, boolean z, Context context, int i, int i2, vg vgVar) {
        this.fCG = str;
        this.tRh = l;
        this.fBV = z;
        this.tQJ = i;
        this.tQK = i2;
        this.fvB = vgVar;
        b mtVar = new mt();
        mtVar.fEE.type = 0;
        mtVar.fEE.fEG = str;
        a.xef.m(mtVar);
        this.pGh = mtVar.fEF.fEO;
        if (!(this.pGh == null || this.pGh.hdX == null || this.pGh.hdX.size() <= 1)) {
            b mtVar2 = new mt();
            mtVar2.fEE.type = 9;
            mtVar2.fEE.fve = (uq) this.pGh.hdX.get(0);
            mtVar2.fEE.fqm = this.tRh.longValue();
            a.xef.m(mtVar2);
            this.tRi = mtVar2.fEF.fEQ;
        }
        if (this.pGh == null || this.pGh.vCU == null) {
            this.tQL = null;
        } else {
            this.tQL = this.pGh.vCU.weL + ";" + this.pGh.vCU.weM + ";" + this.pGh.vCV;
        }
        Intent intent = new Intent();
        intent.putExtra("note_open_from_scene", 1);
        intent.putExtra("edit_status", this.tQy);
        intent.putExtra("note_msgid", this.tRh);
        intent.putExtra("record_show_share", this.fBV);
        intent.putExtra("fav_note_xml", this.fCG);
        intent.putExtra("fav_note_out_of_date", this.tRi);
        intent.putExtra("fav_note_scroll_to_position", this.tQJ);
        intent.putExtra("fav_note_scroll_to_offset", this.tQK);
        intent.putExtra("fav_note_scroll_to_offset", this.tQK);
        if (!bh.ov(this.tQL)) {
            intent.putExtra("fav_note_link_source_info", this.tQL);
        }
        intent.putExtra("key_detail_fav_scene", this.fvB.scene);
        intent.putExtra("key_detail_fav_sub_scene", this.fvB.moj);
        intent.putExtra("key_detail_fav_index", this.fvB.index);
        d.b(context, "wenote", ".ui.nativenote.NoteEditorUI", intent);
        ar.Dm().F(new 1(this));
    }

    public final String h(uq uqVar) {
        b mtVar = new mt();
        mtVar.fEE.type = 1;
        mtVar.fEE.fve = uqVar;
        mtVar.fEE.fqm = this.tRh.longValue();
        a.xef.m(mtVar);
        return mtVar.fEF.fEP;
    }

    public final String i(uq uqVar) {
        b mtVar = new mt();
        mtVar.fEE.type = 1;
        mtVar.fEE.fve = uqVar;
        mtVar.fEE.fqm = this.tRh.longValue();
        a.xef.m(mtVar);
        return mtVar.fEF.fvC;
    }

    public final void n(uq uqVar) {
        b mtVar = new mt();
        mtVar.fEE.type = 8;
        mtVar.fEE.fve = uqVar;
        mtVar.fEE.fqm = this.tRh.longValue();
        mtVar.fEE.fvC = "";
        a.xef.m(mtVar);
    }

    public final void a(uq uqVar, String str) {
        b mtVar = new mt();
        mtVar.fEE.type = 8;
        mtVar.fEE.fve = uqVar;
        mtVar.fEE.fqm = this.tRh.longValue();
        mtVar.fEE.fvC = str;
        a.xef.m(mtVar);
    }

    public final void aN(Context context, String str) {
        Intent intent = new Intent();
        intent.putExtra("message_id", this.tRh);
        intent.putExtra("record_xml", this.fCG);
        intent.putExtra("record_data_id", ((n) this.tQt.get(str)).mvG);
        d.b(ac.getContext(), "record", ".ui.RecordMsgFileUI", intent);
    }

    public final void aP(Context context, String str) {
        Intent intent = new Intent();
        intent.putExtra("message_id", this.tRh);
        intent.putExtra("record_data_id", ((n) this.tQt.get(str)).mvG);
        intent.putExtra("record_xml", this.fCG);
        d.b(ac.getContext(), "record", ".ui.RecordMsgImageUI", intent);
    }

    public final void aO(Context context, String str) {
        us usVar;
        String str2 = null;
        uq uqVar = ((n) this.tQt.get(str)).tRO;
        if (uqVar.wdD != null) {
            ux uxVar = uqVar.wdD.wdZ;
            usVar = uqVar.wdD.wdX;
        } else {
            usVar = null;
        }
        if (usVar != null) {
            if (bh.ov(usVar.wet)) {
                str2 = r.gu(usVar.fzO);
            } else {
                str2 = r.gu(usVar.wet);
            }
        }
        com.tencent.mm.plugin.wenote.model.a.r rVar = (com.tencent.mm.plugin.wenote.model.a.r) this.tQt.get(str);
        if (rVar == null) {
            h.bu(ac.getContext(), ac.getContext().getString(R.l.egm));
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("map_view_type", 2);
        intent.putExtra("kwebmap_slat", rVar.lat);
        intent.putExtra("kwebmap_lng", rVar.lng);
        intent.putExtra("kPoiName", rVar.nTe);
        intent.putExtra("Kwebmap_locaion", rVar.hxu);
        if (rVar.tSd >= 0.0d) {
            intent.putExtra("kwebmap_scale", rVar.tSd);
        }
        intent.putExtra("kisUsername", str2);
        intent.putExtra("kwebmap_from_to", true);
        intent.putExtra("KFavLocSigleView", true);
        intent.putExtra("kFavCanDel", false);
        intent.putExtra("kFavCanRemark", false);
        d.b(ac.getContext(), "location", ".ui.RedirectUI", intent);
    }
}
