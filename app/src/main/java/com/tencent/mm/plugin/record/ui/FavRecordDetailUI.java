package com.tencent.mm.plugin.record.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.g.a.fv;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.fav.a.r;
import com.tencent.mm.plugin.record.b.b;
import com.tencent.mm.plugin.record.b.h;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.protocal.c.vk;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.q;
import java.util.LinkedList;
import java.util.List;

public class FavRecordDetailUI extends RecordMsgBaseUI {
    private boolean fBV = true;
    private a moo = new 1(this);
    private f mtx;
    private long pFM = -1;
    private boolean pFN = true;
    private boolean pFO = false;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    protected final void bmX() {
        this.pFM = getIntent().getLongExtra("key_detail_info_id", -1);
        this.fBV = getIntent().getBooleanExtra("show_share", true);
        this.mtx = b.ea(this.pFM);
        if (this.mtx == null) {
            finish();
            return;
        }
        h(this.mtx);
        a bVar = new b();
        bVar.pFG = this.mtx;
        bVar.pFF = this.mtx.field_favProto.weU;
        List<uq> list = bVar.pFF;
        if (list == null) {
            this.pFN = false;
        } else if (list.size() == 0) {
            this.pFN = false;
        } else {
            for (uq uqVar : list) {
                if (uqVar.wdR != 0) {
                    this.pFN = false;
                    break;
                }
            }
            this.pFN = true;
        }
        super.bmX();
        this.pGe.a(bVar);
        List list2 = bVar.pFF;
        if (list2 != null) {
            e.post(new 4(this, list2), "calc_fav_record_info");
        }
        ((r) g.k(r.class)).getFavItemInfoStorage().c(this.moo);
        ((r) g.k(r.class)).getFavCdnStorage().a(((d) this.pGe).pFI);
    }

    protected final h bmY() {
        return new d(this, new c(this));
    }

    protected void onResume() {
        super.onResume();
        b bVar = (b) ((d) this.pGe).pGa;
        if (bVar.pFG != null) {
            f ea = b.ea(bVar.pFG.field_localId);
            if (ea != null && ea.field_favProto != null) {
                Object obj;
                LinkedList linkedList = ea.field_favProto.weU;
                for (uq contains : bVar.pFF) {
                    if (!linkedList.contains(contains)) {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj != null) {
                    a bVar2 = new b();
                    bVar2.pFG = ea;
                    bVar2.pFF = ea.field_favProto.weU;
                    this.pGe.a(bVar2);
                }
            }
        }
    }

    protected void onStop() {
        super.onStop();
    }

    protected void onDestroy() {
        ((r) g.k(r.class)).getFavItemInfoStorage().j(this.moo);
        if (this.pGe != null) {
            ((r) g.k(r.class)).getFavCdnStorage().b(((d) this.pGe).pFI);
        }
        this.pFO = true;
        super.onDestroy();
    }

    protected final String bmZ() {
        if (14 == this.mtx.field_type && !bh.ov(this.mtx.field_favProto.title)) {
            return this.mtx.field_favProto.title;
        }
        vk vkVar = this.mtx.field_favProto.weS;
        if (vkVar == null || bh.ov(vkVar.wet)) {
            x.v("MicroMsg.FavRecordDetailUI", "display name, from item info user[%s]", new Object[]{this.mtx.field_fromUser});
            return h.gv(this.mtx.field_fromUser);
        }
        String gu = com.tencent.mm.z.r.gu(vkVar.wet);
        String gv;
        if (q.FS().equals(vkVar.fzO)) {
            gv = h.gv(vkVar.toUser);
            if (!bh.az(gv, "").equals(vkVar.toUser)) {
                gu = gu + " - " + gv;
            }
        } else {
            gv = h.gv(vkVar.fzO);
            if (!bh.az(gv, "").equals(vkVar.fzO)) {
                gu = gu + " - " + gv;
            }
        }
        x.v("MicroMsg.FavRecordDetailUI", "display name, source from[%s] to[%s]", new Object[]{vkVar.fzO, vkVar.toUser});
        return gu;
    }

    protected final String bna() {
        LinkedList linkedList = this.mtx.field_favProto.weU;
        if (linkedList.size() > 0) {
            return ((uq) linkedList.getFirst()).wdH;
        }
        return null;
    }

    protected final String bnb() {
        LinkedList linkedList = this.mtx.field_favProto.weU;
        if (linkedList.size() > 0) {
            return ((uq) linkedList.getLast()).wdH;
        }
        return null;
    }

    protected final void bnc() {
        if (this.fBV) {
            addIconOptionMenu(0, R.l.eRi, R.g.bDI, new 2(this));
        }
    }

    protected final void c(int i, int i2, Intent intent) {
        if (4097 == i && -1 == i2) {
            com.tencent.mm.sdk.b.b fvVar = new fv();
            fvVar.fvq.type = 32;
            fvVar.fvq.fqk = this.pFM;
            com.tencent.mm.sdk.b.a.xef.m(fvVar);
            if (fvVar.fvr.fvI) {
                com.tencent.mm.ui.base.h.bu(this.mController.xIM, getString(R.l.dBN));
                return;
            }
            String stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
            String stringExtra2 = intent == null ? null : intent.getStringExtra("custom_send_text");
            Dialog a = com.tencent.mm.ui.base.h.a(this.mController.xIM, getString(R.l.efz), false, null);
            com.tencent.mm.sdk.b.b fvVar2 = new fv();
            fvVar2.fvq.type = 13;
            fvVar2.fvq.context = this.mController.xIM;
            fvVar2.fvq.toUser = stringExtra;
            fvVar2.fvq.fvw = stringExtra2;
            fvVar2.fvq.fqk = this.pFM;
            fvVar2.fvq.fvv = new 3(this, a);
            com.tencent.mm.sdk.b.a.xef.m(fvVar2);
        }
    }
}
