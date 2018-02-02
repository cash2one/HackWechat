package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.ag.f;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.dh;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.wcdb.FileUtils;

public final class ag {

    public static class b extends b {
        private c yNs;
        private a yqa;

        private c cvB() {
            if (this.yNs == null) {
                this.yNs = new c(this.yqa);
            }
            return this.yNs;
        }

        public final boolean aXj() {
            return true;
        }

        public final boolean aj(int i, boolean z) {
            if (z && i == 43) {
                return true;
            }
            return false;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            if (view != null && view.getTag() != null) {
                return view;
            }
            view = new p(layoutInflater, R.i.ded);
            view.setTag(new d().q(view, false));
            return view;
        }

        public final void a(b.a aVar, int i, a aVar2, au auVar, String str) {
            this.yqa = aVar2;
            d dVar = (d) aVar;
            d.a(dVar, auVar, false, i, aVar2, R.g.bAH, cvB(), s(aVar2));
            if (cvy()) {
                r nF = t.nF(auVar.field_imgPath);
                if (nF != null && nF.status == 199 && a(aVar2.ysf, auVar.field_msgId)) {
                    if (dVar.yJk != null) {
                        dVar.yJk.setVisibility(0);
                    }
                } else if (dVar.yJk != null) {
                    dVar.yJk.setVisibility(8);
                }
            }
        }

        public final boolean a(ContextMenu contextMenu, View view, au auVar) {
            ar.Hg();
            if (c.isSDCardAvailable()) {
                if (view == null) {
                    return false;
                }
                int i = ((ar) view.getTag()).position;
                r nr = o.TU().nr(auVar.field_imgPath);
                MenuItem add = contextMenu.add(i, 129, 0, view.getContext().getString(R.l.dRL));
                int width = view.getWidth();
                int height = view.getHeight();
                int[] iArr = new int[2];
                view.getLocationInWindow(iArr);
                Intent intent = new Intent();
                intent.putExtra("img_gallery_width", width).putExtra("img_gallery_height", height).putExtra("img_gallery_left", iArr[0]).putExtra("img_gallery_top", iArr[1]);
                add.setIntent(intent);
                if (nr != null) {
                    int i2 = nr.status;
                    if (!(104 == i2 || 103 == i2 || 105 == i2 || 106 == i2)) {
                        contextMenu.add(i, 107, 0, view.getContext().getString(R.l.eEC));
                    }
                }
                if (nr != null && (nr.status == 199 || nr.status == 199)) {
                    if (d.OQ("favorite")) {
                        contextMenu.add(i, 116, 0, view.getContext().getString(R.l.eAd));
                    }
                    com.tencent.mm.sdk.b.b dhVar = new dh();
                    dhVar.frQ.fqm = auVar.field_msgId;
                    com.tencent.mm.sdk.b.a.xef.m(dhVar);
                    if (dhVar.frR.frp) {
                        contextMenu.add(i, FileUtils.S_IWUSR, 0, view.getContext().getString(R.l.dRM));
                    }
                    if (!auVar.ciV() && ((auVar.cjh() || auVar.cji()) && a(auVar, this.yqa) && ((nr.status == 199 || nr.status == 199 || auVar.gjJ == 1) && Zq(auVar.field_talker)))) {
                        contextMenu.add(i, 123, 0, view.getContext().getString(R.l.dRQ));
                    }
                    if (f.LO() && !this.yqa.csV()) {
                        contextMenu.add(i, 114, 0, view.getContext().getString(R.l.dRD));
                    }
                }
                if (!this.yqa.csV()) {
                    contextMenu.add(i, 100, 0, view.getContext().getString(R.l.dRI));
                }
            }
            return true;
        }

        public final boolean a(MenuItem menuItem, a aVar, au auVar) {
            return false;
        }

        public final boolean b(View view, a aVar, au auVar) {
            cvB().onClick(view);
            return true;
        }
    }

    protected static class e extends ar {
        int kTK;

        public e(au auVar, boolean z, int i, String str) {
            super(auVar, z, i, str, (byte) 0);
        }
    }
}
