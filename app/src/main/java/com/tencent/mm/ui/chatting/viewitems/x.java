package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.aq.e;
import com.tencent.mm.aq.f;
import com.tencent.mm.aq.g;
import com.tencent.mm.aq.n;
import com.tencent.mm.aq.n.d;
import com.tencent.mm.aq.o;
import com.tencent.mm.g.a.dh;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.ChattingUI$a;
import com.tencent.mm.ui.chatting.viewitems.b.a;
import com.tencent.mm.y.g$a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.wcdb.FileUtils;

public final class x {

    public static class b extends b {
        private c yMB;
        private ChattingUI$a yqa;

        public final boolean aXj() {
            return true;
        }

        public final boolean aj(int i, boolean z) {
            if (z && (i == 3 || i == 23 || i == 13 || i == 39 || i == 33)) {
                return true;
            }
            return false;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            if (view != null && view.getTag() != null) {
                return view;
            }
            view = new p(layoutInflater, R.i.deb);
            view.setTag(new d().q(view, false));
            return view;
        }

        public final void a(a aVar, int i, ChattingUI$a chattingUI$a, au auVar, String str) {
            boolean z;
            View view;
            this.yqa = chattingUI$a;
            aVar = (d) aVar;
            boolean containsKey = n.Pn().hBZ.containsKey(Long.valueOf(auVar.field_msgId));
            e n = o.Pw().n(auVar);
            if (n == null || containsKey) {
                z = false;
            } else {
                boolean z2;
                if (n.Pn().bk(n.hzP)) {
                    d bl = n.Pn().bl(n.hzP);
                    int i2 = (int) bl.fzM;
                    z2 = i2 == 0 ? true : ((int) bl.oJ) == i2 && i2 != 0;
                } else {
                    z2 = f.b(n);
                }
                z = z2;
            }
            g Pw = o.Pw();
            ImageView imageView = aVar.yKh;
            String str2 = auVar.field_imgPath;
            float density = com.tencent.mm.bv.a.getDensity(chattingUI$a.getContext());
            int i3 = auVar.gjG;
            int i4 = auVar.gjH;
            int i5 = R.g.bAH;
            ImageView imageView2 = aVar.yME;
            int i6 = R.g.bAE;
            if (z) {
                view = null;
            } else {
                view = aVar.yMF;
            }
            if (!(Pw.a(imageView, str2, density, i3, i4, i5, imageView2, i6, 0, view) || this.vzn)) {
                aVar.yKh.setImageDrawable(com.tencent.mm.bv.a.b(chattingUI$a.getContext(), R.g.bEl));
            }
            if (n != null || containsKey) {
                Object obj = (z || auVar.field_status == 5) ? 1 : null;
                if (containsKey) {
                    aVar.yMD.setText("0%");
                } else {
                    int i7;
                    TextView textView = aVar.yMD;
                    StringBuilder stringBuilder = new StringBuilder();
                    if (n != null) {
                        i2 = n.hlp;
                        i7 = n.offset;
                        if (n.Pn().bk(n.hzP)) {
                            bl = n.Pn().bl(n.hzP);
                            i2 = (int) bl.fzM;
                            i7 = (int) bl.oJ;
                        }
                        if (n.Pe()) {
                            e hQ = o.Pw().hQ(n.hzZ);
                            if (n.Pn().bk((long) n.hzZ)) {
                                bl = n.Pn().bl((long) n.hzZ);
                                i2 = (int) bl.fzM;
                                i7 = (int) bl.oJ;
                            } else {
                                i2 = hQ.hlp;
                                i7 = hQ.offset;
                            }
                        }
                        if (i2 > 0) {
                            i7 = i7 >= i2 ? 100 : (i7 * 100) / i2;
                            textView.setText(stringBuilder.append(i7).append("%").toString());
                        }
                    }
                    i7 = 0;
                    textView.setText(stringBuilder.append(i7).append("%").toString());
                }
                aVar.psA.setVisibility(obj != null ? 8 : 0);
                aVar.yMD.setVisibility(obj != null ? 8 : 0);
                aVar.yMF.setVisibility(obj != null ? 8 : 0);
            } else {
                aVar.yMF.setVisibility(8);
                aVar.psA.setVisibility(8);
                aVar.yMD.setVisibility(8);
            }
            aVar.yIy.setTag(new ar(auVar, chattingUI$a.ypn, i, auVar.field_talker, (byte) 0));
            View view2 = aVar.yIy;
            if (this.yMB == null) {
                this.yMB = new c(this.yqa, this);
            }
            view2.setOnClickListener(this.yMB);
            aVar.yIy.setOnTouchListener(chattingUI$a.ysf.ysV);
            aVar.yIy.setOnLongClickListener(s(chattingUI$a));
            aVar.yKh.setContentDescription(chattingUI$a.getString(R.l.dRl));
            if (cvy()) {
                aVar.psA.setVisibility(8);
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactInfoUI", "[oneliang]%s,%s", new Object[]{Long.valueOf(auVar.field_msgId), Integer.valueOf(auVar.field_status)});
                if (cvy()) {
                    if (auVar.field_status == 2 && a(chattingUI$a.ysf, auVar.field_msgId)) {
                        if (aVar.yJk != null) {
                            aVar.yJk.setVisibility(0);
                        }
                    } else if (aVar.yJk != null) {
                        aVar.yJk.setVisibility(8);
                    }
                }
            }
            a(i, aVar, auVar, chattingUI$a.ysf.hlJ, chattingUI$a.ypn, chattingUI$a);
            x.a(auVar, this, chattingUI$a, aVar);
        }

        public final boolean a(ContextMenu contextMenu, View view, au auVar) {
            ar.Hg();
            if (c.isSDCardAvailable() && view != null) {
                int i = ((ar) view.getTag()).position;
                e eVar = null;
                if (auVar.field_msgId > 0) {
                    eVar = o.Pw().bi(auVar.field_msgId);
                }
                if ((eVar == null || eVar.hzP <= 0) && auVar.field_msgSvrId > 0) {
                    eVar = o.Pw().bh(auVar.field_msgSvrId);
                }
                if (eVar.Pe() && eVar.hlp == 0) {
                    eVar = o.Pw().hQ(eVar.hzZ);
                }
                contextMenu.add(i, 110, 0, view.getContext().getString(R.l.eEC));
                if (auVar.field_status == 5) {
                    contextMenu.add(i, 103, 0, view.getContext().getString(R.l.dSI));
                }
                if (com.tencent.mm.ag.f.LN() && !this.yqa.csV()) {
                    contextMenu.add(i, 114, 0, view.getContext().getString(R.l.dRD));
                }
                if (com.tencent.mm.bm.d.OQ("favorite")) {
                    contextMenu.add(i, 116, 0, view.getContext().getString(R.l.eAd));
                }
                com.tencent.mm.sdk.b.b dhVar = new dh();
                dhVar.frQ.fqm = auVar.field_msgId;
                com.tencent.mm.sdk.b.a.xef.m(dhVar);
                if (dhVar.frR.frp || com.tencent.mm.pluginsdk.model.app.g.R(this.yqa.getContext(), auVar.getType())) {
                    contextMenu.add(i, FileUtils.S_IWUSR, 0, view.getContext().getString(R.l.dRM));
                }
                if (com.tencent.mm.bm.d.OQ("photoedit") && r0.status != -1) {
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
                if (!auVar.ciV() && auVar.cje() && ((auVar.field_status == 2 || auVar.gjJ == 1) && a(auVar, this.yqa) && Zq(auVar.field_talker))) {
                    contextMenu.add(i, 123, 0, view.getContext().getString(R.l.dRQ));
                }
                if (!this.yqa.csV()) {
                    contextMenu.add(i, 100, 0, view.getContext().getString(R.l.dRG));
                }
            }
            return true;
        }

        public final boolean a(MenuItem menuItem, ChattingUI$a chattingUI$a, au auVar) {
            if (100 == menuItem.getItemId()) {
                x.a(auVar, this, chattingUI$a);
            }
            return false;
        }

        public final boolean b(View view, ChattingUI$a chattingUI$a, au auVar) {
            return false;
        }

        public static void a(a aVar, int i, int i2) {
            int i3 = i2 > 0 ? i >= i2 ? 100 : (int) ((((long) i) * 100) / ((long) i2)) : 0;
            d dVar = (d) aVar;
            if (i3 < 100 || dVar.yMD.getVisibility() == 0) {
                dVar.yMD.setText(i3 + "%");
                if (cvy()) {
                    dVar.psA.setVisibility(8);
                } else {
                    dVar.psA.setVisibility(0);
                }
                dVar.yMD.setVisibility(0);
                dVar.yMF.setVisibility(0);
            }
        }

        public static void a(a aVar, boolean z) {
            if (z) {
                d dVar = (d) aVar;
                dVar.psA.setVisibility(4);
                dVar.yMD.setVisibility(4);
                dVar.yMF.setVisibility(4);
            }
        }
    }

    static /* synthetic */ void a(au auVar, b bVar, ChattingUI$a chattingUI$a) {
        g$a fS = g$a.fS(auVar.field_content);
        if (fS != null && !bh.ov(fS.appId)) {
            com.tencent.mm.pluginsdk.model.app.f aZ = com.tencent.mm.pluginsdk.model.app.g.aZ(fS.appId, false);
            if (aZ != null && aZ.Yz()) {
                b.a(chattingUI$a, fS, auVar, aZ);
            }
        }
    }

    static /* synthetic */ void a(au auVar, b bVar, ChattingUI$a chattingUI$a, d dVar) {
        g$a fS = g$a.fS(auVar.field_content);
        if (fS == null || bh.ov(fS.appId)) {
            dVar.mxT.setVisibility(8);
            return;
        }
        String str = fS.appId;
        com.tencent.mm.pluginsdk.model.app.f cQ = com.tencent.mm.pluginsdk.model.app.g.cQ(str, fS.fIm);
        if (cQ != null && cQ.Yz()) {
            b.b(chattingUI$a, fS, auVar);
        }
        String str2 = (cQ == null || cQ.field_appName == null || cQ.field_appName.trim().length() <= 0) ? fS.appName : cQ.field_appName;
        if (b.cz(str2)) {
            dVar.mxT.setText(com.tencent.mm.pluginsdk.model.app.g.a(chattingUI$a.getContext(), cQ, str2));
            dVar.mxT.setVisibility(0);
            if (cQ == null || !cQ.Yz()) {
                b.a(chattingUI$a, dVar.mxT, str);
            } else {
                b.a(chattingUI$a, dVar.mxT, auVar, fS, cQ.field_packageName, auVar.field_msgSvrId);
            }
            b.a(chattingUI$a, dVar.mxT, str);
            return;
        }
        dVar.mxT.setVisibility(8);
    }
}
