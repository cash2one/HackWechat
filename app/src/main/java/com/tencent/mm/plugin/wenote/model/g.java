package com.tencent.mm.plugin.wenote.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.fv;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.model.a.n;
import com.tencent.mm.plugin.wenote.model.a.r;
import com.tencent.mm.plugin.wenote.model.a.t;
import com.tencent.mm.pluginsdk.model.c;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.protocal.c.vg;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;
import java.util.HashMap;
import java.util.Iterator;

public final class g extends d implements e {
    private static HashMap<f, l> tQI = new HashMap();
    public boolean fBV = true;
    public long fCb = -1;
    private vg fvB = new vg();
    private f mtx;
    public String tQG;
    public String tQH = "";
    private int tQJ = 0;
    private int tQK = 0;
    public String tQL;
    public int tQM = 0;
    public long tQN = 0;
    public String tQO;
    public String tQP;

    static /* synthetic */ void c(g gVar) {
        gVar.tQp = new l();
        gVar.tQp.pFG = gVar.mtx;
        gVar.tQp.fCb = gVar.fCb;
        gVar.tQp.bjS = 1;
        if (gVar.mtx != null && gVar.mtx.field_favProto != null) {
            gVar.tQp.tRM = gVar.tQN;
            gVar.tQp.pFF = gVar.mtx.field_favProto.weU;
            tQI.put(gVar.mtx, gVar.tQp);
        }
    }

    public g() {
        this.tQr.clear();
        this.tQq = null;
        tQw = "";
        this.tQy = false;
        c.bYm();
        ar.CG().a(426, this);
    }

    public final void a(long j, Context context, Boolean bool, int i, int i2, vg vgVar) {
        this.fCb = j;
        this.fBV = bool.booleanValue();
        this.tQJ = i;
        this.tQK = i2;
        this.fvB = vgVar;
        this.mtx = f.ea(this.fCb);
        if (this.mtx != null) {
            if (this.tQN <= 0) {
                this.tQN = this.mtx.field_updateTime;
            }
            this.tQz = this.mtx.field_favProto;
            this.tQq = this.mtx;
        }
        if (this.tQM == 0 && this.tQz.weS != null) {
            this.tQM = this.tQz.weS.fqd;
        }
        P(context, 2);
        ar.Dm().F(new 2(this));
    }

    public final void P(Context context, int i) {
        Intent intent = new Intent();
        intent.putExtra("note_open_from_scene", i);
        if (i == 4) {
            intent.putExtra("fav_note_thumbpath", this.tQO);
            intent.putExtra("fav_note_link_sns_xml", this.tQP);
        }
        intent.putExtra("edit_status", this.tQy);
        intent.putExtra("show_share", this.fBV);
        intent.putExtra("note_fav_localid", this.fCb);
        intent.putExtra("note_link_sns_localid", this.tQG);
        intent.putExtra("fav_note_xml", this.tQH);
        intent.putExtra("fav_note_scroll_to_position", this.tQJ);
        intent.putExtra("fav_note_scroll_to_offset", this.tQK);
        intent.putExtra("fav_note_link_source_info", this.tQL);
        intent.putExtra("note_fav_post_scene", this.tQM);
        intent.putExtra("key_detail_fav_scene", this.fvB.scene);
        intent.putExtra("key_detail_fav_sub_scene", this.fvB.moj);
        intent.putExtra("key_detail_fav_index", this.fvB.index);
        d.b(context, "wenote", ".ui.nativenote.NoteEditorUI", intent);
    }

    public final String h(uq uqVar) {
        return f.o(uqVar);
    }

    public final String i(uq uqVar) {
        return f.i(uqVar);
    }

    public final void n(uq uqVar) {
        l lVar = this.tQp;
        b fvVar = new fv();
        fvVar.fvq.type = 28;
        fvVar.fvq.fqk = lVar.pFG.field_localId;
        fvVar.fvq.fvs = uqVar;
        fvVar.fvq.path = "";
        fvVar.fvq.fvx = 18;
        a.xef.m(fvVar);
    }

    public final void a(uq uqVar, String str) {
        l lVar = this.tQp;
        b fvVar = new fv();
        fvVar.fvq.type = 28;
        fvVar.fvq.fqk = lVar.pFG.field_localId;
        fvVar.fvq.fvs = uqVar;
        fvVar.fvq.path = str;
        fvVar.fvq.fvx = 18;
        a.xef.m(fvVar);
    }

    public final void aN(Context context, String str) {
        t tVar = (t) this.tQt.get(str);
        Intent intent = new Intent();
        intent.putExtra("fav_open_from_wnnote", true);
        intent.putExtra("fav_note_xml", this.tQH);
        if (tVar != null) {
            intent.putExtra("key_detail_data_id", QJ(str));
        }
        intent.putExtra("key_detail_can_delete", false);
        intent.putExtra("key_detail_info_id", this.fCb);
        intent.putExtra("key_detail_fav_scene", this.fvB.scene);
        intent.putExtra("key_detail_fav_sub_scene", this.fvB.moj);
        intent.putExtra("key_detail_fav_index", this.fvB.index);
        d.b(context, "favorite", ".ui.detail.FavoriteFileDetailUI", intent, 1);
    }

    public final void aP(Context context, String str) {
        Intent intent = new Intent();
        intent.putExtra("fav_open_from_wnnote", true);
        intent.putExtra("fav_note_xml", this.tQH);
        if (this.tQt.get(str) != null) {
            intent.putExtra("key_detail_data_id", ((n) this.tQt.get(str)).mvG);
        }
        intent.putExtra("key_detail_info_id", this.fCb);
        intent.putExtra("key_detail_fav_scene", this.fvB.scene);
        intent.putExtra("key_detail_fav_sub_scene", this.fvB.moj);
        intent.putExtra("key_detail_fav_index", this.fvB.index);
        d.b(context, "favorite", ".ui.FavImgGalleryUI", intent, 1);
    }

    public final void aO(Context context, String str) {
        String str2 = "";
        r rVar = (r) this.tQt.get(str);
        if (rVar == null) {
            h.bu(context, ac.getContext().getString(R.l.egm));
            return;
        }
        Intent intent = new Intent();
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
        intent.putExtra("map_view_type", 2);
        intent.putExtra("kFavInfoLocalId", this.fCb);
        intent.putExtra("kFavCanDel", false);
        intent.putExtra("kFavCanRemark", false);
        d.b(context, "location", ".ui.RedirectUI", intent, 1);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == 426) {
            b fvVar = new fv();
            fvVar.fvq.frb = kVar;
            fvVar.fvq.type = 31;
            a.xef.m(fvVar);
            if (!bh.ov(fvVar.fvr.path) && i2 == -435) {
                x.e("MicroMsg.WNNoteFavProcess", "wenote conflict when commit");
            }
            ar.CG().b(426, this);
        }
    }

    public final void QG(String str) {
        this.tQH = str;
    }

    public final String bVO() {
        return this.tQH;
    }

    private String QJ(String str) {
        f ea = f.ea(this.fCb);
        if (ea == null) {
            return ((n) this.tQt.get(str)).mvG;
        }
        Iterator it = ea.field_favProto.weU.iterator();
        while (it.hasNext()) {
            uq uqVar = (uq) it.next();
            if (!bh.ov(uqVar.wdL) && uqVar.wdL.equals(str)) {
                return uqVar.mvG;
            }
        }
        return ((n) this.tQt.get(str)).mvG;
    }
}
