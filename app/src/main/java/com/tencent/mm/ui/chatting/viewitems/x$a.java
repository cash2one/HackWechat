package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.ag.f;
import com.tencent.mm.aq.e;
import com.tencent.mm.aq.o;
import com.tencent.mm.g.a.dh;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.viewitems.x.c;
import com.tencent.mm.ui.chatting.viewitems.x.d;
import com.tencent.mm.z.ar;
import com.tencent.wcdb.FileUtils;

public class x$a extends b {
    private c yMB;
    private a yqa;

    public final boolean aXj() {
        return false;
    }

    public final boolean aj(int i, boolean z) {
        if (z || (i != 39 && i != 3 && i != 23 && i != 13 && i != 33)) {
            return false;
        }
        return true;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        view = new p(layoutInflater, R.i.ddy);
        view.setTag(new d().q(view, true));
        return view;
    }

    public final String a(a aVar, au auVar) {
        return super.a(aVar, auVar);
    }

    public final void a(b.a aVar, int i, a aVar2, au auVar, String str) {
        this.yqa = aVar2;
        aVar2.yvP.aS(auVar);
        d dVar = (d) aVar;
        boolean a = o.Pw().a(dVar.yKh, auVar.field_imgPath, com.tencent.mm.bv.a.getDensity(aVar2.getContext()), auVar.gjG, auVar.gjH, R.g.bAH, dVar.yME, R.g.bAE, 1, null);
        dVar.yMF.setVisibility(0);
        dVar.psA.setVisibility(8);
        if (!(a || this.vzn)) {
            dVar.yKh.setImageBitmap(BitmapFactory.decodeResource(aVar2.getResources(), R.g.bEl));
        }
        String str2 = null;
        if (aVar2.ypn) {
            str2 = auVar.field_talker;
        }
        dVar.yIy.setTag(new ar(auVar, aVar2.ypn, i, str, str2));
        View view = dVar.yIy;
        if (this.yMB == null) {
            this.yMB = new c(this.yqa, this);
        }
        view.setOnClickListener(this.yMB);
        dVar.yIy.setOnLongClickListener(s(aVar2));
        dVar.yIy.setOnTouchListener(aVar2.ysf.ysV);
        x.a(auVar, this, aVar2, dVar);
    }

    protected final boolean r(a aVar) {
        return aVar.ypn;
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        ar.Hg();
        if (!(!com.tencent.mm.z.c.isSDCardAvailable() || view == null || auVar == null)) {
            int i = ((ar) view.getTag()).position;
            e eVar = null;
            if (auVar.field_msgId > 0) {
                eVar = o.Pw().bi(auVar.field_msgId);
            }
            if ((eVar == null || eVar.hzP <= 0) && auVar.field_msgSvrId > 0) {
                eVar = o.Pw().bh(auVar.field_msgSvrId);
            }
            contextMenu.add(i, 110, 0, view.getContext().getString(R.l.eEC));
            if (f.LN() && !this.yqa.csV()) {
                contextMenu.add(i, 114, 0, view.getContext().getString(R.l.dRD));
            }
            if (com.tencent.mm.bm.d.OQ("favorite")) {
                contextMenu.add(i, 116, 0, view.getContext().getString(R.l.eAd));
            }
            b dhVar = new dh();
            dhVar.frQ.fqm = auVar.field_msgId;
            com.tencent.mm.sdk.b.a.xef.m(dhVar);
            if (dhVar.frR.frp || g.R(this.yqa.getContext(), auVar.getType())) {
                contextMenu.add(i, FileUtils.S_IWUSR, 0, view.getContext().getString(R.l.dRM));
            }
            if (!(!com.tencent.mm.bm.d.OQ("photoedit") || r0 == null || r0.status == -1)) {
                int width;
                int height;
                MenuItem add = contextMenu.add(i, 130, 0, view.getContext().getString(R.l.dRk));
                int[] iArr = new int[2];
                if (view != null) {
                    width = view.getWidth();
                    height = view.getHeight();
                    view.getLocationInWindow(iArr);
                } else {
                    height = 0;
                    width = 0;
                }
                Intent intent = new Intent();
                intent.putExtra("img_gallery_width", width).putExtra("img_gallery_height", height).putExtra("img_gallery_left", iArr[0]).putExtra("img_gallery_top", iArr[1]);
                add.setIntent(intent);
            }
            if (!this.yqa.csV()) {
                contextMenu.add(i, 100, 0, view.getContext().getString(R.l.dRG));
            }
        }
        return true;
    }

    public final boolean a(MenuItem menuItem, a aVar, au auVar) {
        if (100 == menuItem.getItemId()) {
            x.a(auVar, this, aVar);
        }
        return false;
    }

    public final boolean b(View view, a aVar, au auVar) {
        return false;
    }

    public static void a(Context context, b.a aVar, au auVar, boolean z) {
        if (true == z) {
            d dVar = (d) aVar;
            o.Pw().a(dVar.yKh, auVar.field_imgPath, com.tencent.mm.bv.a.getDensity(context), auVar.gjG, auVar.gjH, R.g.bAH, dVar.yME, R.g.bAG, 1, null);
        }
    }
}
