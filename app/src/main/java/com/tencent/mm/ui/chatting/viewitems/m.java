package com.tencent.mm.ui.chatting.viewitems;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.aq.o;
import com.tencent.mm.g.a.dh;
import com.tencent.mm.g.a.hy;
import com.tencent.mm.g.a.mt;
import com.tencent.mm.g.a.qp;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.e;
import com.tencent.mm.modelappbrand.f;
import com.tencent.mm.modelappbrand.h;
import com.tencent.mm.modelappbrand.q;
import com.tencent.mm.modelappbrand.r;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.p.k;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.i;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.u;
import com.tencent.wcdb.FileUtils;

public final class m {

    public static class b extends b implements f {
        private q iVn = new r(this);
        private a yqa;

        public final boolean aXj() {
            return true;
        }

        public final boolean aj(int i, boolean z) {
            if (z && i == 553648177) {
                return true;
            }
            return false;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            if (view != null && view.getTag() != null) {
                return view;
            }
            view = new p(layoutInflater, R.i.ddW);
            d s = new d().s(view, false);
            View be = ((e) g.h(e.class)).be(view.getContext());
            s.yKH = be;
            s.yKG.addView(be, new LayoutParams(-1, -1));
            view.setTag(s);
            return view;
        }

        public final void a(b.a aVar, int i, a aVar2, au auVar, String str) {
            com.tencent.mm.y.g.a I;
            aVar = (d) aVar;
            this.yqa = aVar2;
            aVar2.yvP.aT(auVar);
            String str2 = auVar.field_content;
            aVar2.yvP.aR(auVar);
            if (str2 != null) {
                I = com.tencent.mm.y.g.a.I(str2, auVar.field_reserved);
            } else {
                I = null;
            }
            ar arVar = new ar(auVar, aVar2.ypn, i, null, (byte) 0);
            if (I != null) {
                CharSequence charSequence;
                aVar.yIU.setVisibility(8);
                aVar.yIT.setVisibility(8);
                aVar.yIQ.setVisibility(8);
                aVar.yJs.setVisibility(8);
                WxaAttributes qK = ((com.tencent.mm.plugin.appbrand.m.b) g.h(com.tencent.mm.plugin.appbrand.m.b.class)).qK(I.hdx);
                if (qK != null) {
                    charSequence = qK.field_nickname;
                } else {
                    Object obj = I.fGA;
                }
                String str3 = qK != null ? qK.field_brandIconURL : I.hdG;
                aVar.yJs.setVisibility(0);
                aVar.yJo.setVisibility(8);
                aVar.yJv.setText(I.title);
                aVar.yJo.setText(I.description);
                aVar.yJq.setText(charSequence);
                switch (I.hdE) {
                    case 1:
                        aVar.yJr.setText(R.l.dEl);
                        break;
                    case 2:
                        aVar.yJr.setText(R.l.dEk);
                        break;
                    default:
                        aVar.yJr.setText(R.l.dDT);
                        break;
                }
                o.PA().a(str3, aVar.yJp, d.yKF);
                if (cvy()) {
                    com.tencent.mm.ui.chatting.q qVar = aVar2.ysf;
                    if (auVar.field_status == 2 && a(qVar, auVar.field_msgId)) {
                        if (aVar.yJk != null) {
                            aVar.yJk.setVisibility(0);
                        }
                    } else if (aVar.yJk != null) {
                        aVar.yJk.setVisibility(8);
                    }
                    if (aVar.psA != null) {
                        aVar.psA.setVisibility(8);
                    }
                } else if (aVar.psA != null) {
                    aVar.psA.setVisibility(0);
                    if (auVar.field_status >= 2) {
                        aVar.psA.setVisibility(8);
                    }
                }
                com.tencent.mm.y.a aVar3 = (com.tencent.mm.y.a) I.r(com.tencent.mm.y.a.class);
                Bundle bundle = new Bundle();
                bundle.putString("app_id", I.hdy);
                bundle.putString("msg_id", auVar.field_msgId);
                String str4 = "cache_key";
                if (aVar3 != null) {
                    str3 = aVar3.haA;
                } else {
                    str3 = null;
                }
                bundle.putString(str4, str3);
                bundle.putString("msg_title", I.title);
                bundle.putString("msg_path", I.hdw);
                bundle.putInt("msg_pkg_type", I.hdE);
                bundle.putInt("pkg_version", I.fIm);
                bundle.putInt("widget_type", 0);
                bundle.putInt("scene", aVar2.ysk ? 1008 : 1007);
                bundle.putInt("view_init_width", d.yKD);
                bundle.putInt("view_init_height", d.yKE);
                aVar.yKH.setTag(aVar);
                ((e) g.h(e.class)).a(k.bi(aVar2), aVar.yKH, bundle, this.iVn);
            }
            aVar.yIy.setTag(arVar);
            aVar.yIy.setOnClickListener(t(aVar2));
            com.tencent.mm.z.u.b t = u.GK().t(k.bi(aVar2), true);
            c cVar = (c) t.get("listener", null);
            if (cVar == null) {
                cVar = new c();
                t.o("listener", cVar);
            }
            cVar.z(aVar2);
            if (this.vzn) {
                aVar.yIy.setOnLongClickListener(s(aVar2));
            }
            a(i, aVar, auVar, aVar2.ysf.hlJ, aVar2.ypn, aVar2);
        }

        public final boolean a(ContextMenu contextMenu, View view, au auVar) {
            int i = ((ar) view.getTag()).position;
            String str = auVar.field_content;
            if (str != null) {
                com.tencent.mm.y.g.a fT = com.tencent.mm.y.g.a.fT(this.yqa.dk(str, auVar.field_isSend));
                if (fT != null) {
                    if (com.tencent.mm.pluginsdk.model.app.g.h(com.tencent.mm.pluginsdk.model.app.g.aZ(fT.appId, false)) && !i.an(auVar)) {
                        contextMenu.add(i, 111, 0, this.yqa.getString(R.l.eEC));
                    }
                    if ((auVar.field_status == 2 || auVar.gjJ == 1) && a(auVar, this.yqa) && Zq(auVar.field_talker)) {
                        contextMenu.add(i, 123, 0, view.getContext().getString(R.l.dRQ));
                    }
                    com.tencent.mm.sdk.b.b dhVar = new dh();
                    dhVar.frQ.fqm = auVar.field_msgId;
                    com.tencent.mm.sdk.b.a.xef.m(dhVar);
                    if (dhVar.frR.frp || c$b.a(this.yqa.getContext(), fT)) {
                        contextMenu.add(i, FileUtils.S_IWUSR, 0, view.getContext().getString(R.l.dRM));
                    }
                    if (!this.yqa.csV()) {
                        contextMenu.add(i, 100, 0, this.yqa.getString(R.l.dRH));
                    }
                    h IX = ((e) g.h(e.class)).IX();
                    if (IX.IZ() || IX.hf(fT.hdE)) {
                        contextMenu.add(i, 132, 0, this.yqa.getString(R.l.dRO));
                        contextMenu.add(i, 131, 0, this.yqa.getString(R.l.dRN));
                    }
                }
            }
            return true;
        }

        public final boolean a(MenuItem menuItem, a aVar, au auVar) {
            com.tencent.mm.y.g.a aVar2 = null;
            String str;
            com.tencent.mm.sdk.b.b mtVar;
            switch (menuItem.getItemId()) {
                case 100:
                    str = auVar.field_content;
                    if (str != null) {
                        aVar2 = com.tencent.mm.y.g.a.fT(str);
                    }
                    if (aVar2 != null) {
                        if (19 == aVar2.type) {
                            mtVar = new mt();
                            mtVar.fEE.type = 3;
                            mtVar.fEE.fqm = auVar.field_msgId;
                            com.tencent.mm.sdk.b.a.xef.m(mtVar);
                        }
                        com.tencent.mm.pluginsdk.model.app.f aZ = com.tencent.mm.pluginsdk.model.app.g.aZ(aVar2.appId, false);
                        if (aZ != null && aZ.Yz()) {
                            a(aVar, aVar2, auVar, aZ);
                        }
                    }
                    ba.aK(auVar.field_msgId);
                    break;
                case 103:
                    String str2 = auVar.field_content;
                    if (str2 != null) {
                        aVar2 = com.tencent.mm.y.g.a.fT(str2);
                        if (aVar2 != null) {
                            switch (aVar2.type) {
                                case 16:
                                    mtVar = new hy();
                                    mtVar.fyr.fys = aVar2.fys;
                                    mtVar.fyr.fpG = auVar.field_msgId;
                                    mtVar.fyr.fyt = auVar.field_talker;
                                    com.tencent.mm.sdk.b.a.xef.m(mtVar);
                                    break;
                                default:
                                    break;
                            }
                        }
                    }
                    break;
                case 111:
                    c$b.a(aVar, auVar, a(aVar, auVar));
                    break;
                case 131:
                    ((e) g.h(e.class)).IX().bf(aVar.getContext());
                    break;
                case 132:
                    str = auVar.field_content;
                    if (str != null) {
                        aVar2 = com.tencent.mm.y.g.a.fT(str);
                    }
                    if (aVar2 != null) {
                        Bundle bundle = new Bundle();
                        bundle.putString("app_id", aVar2.hdy);
                        bundle.putString("msg_id", auVar.field_msgId);
                        bundle.putInt("pkg_type", aVar2.hdE);
                        bundle.putInt("pkg_version", aVar2.hdB);
                        ((e) g.h(e.class)).IX().b(aVar.getContext(), bundle);
                        break;
                    }
                    break;
            }
            return false;
        }

        public final boolean b(View view, a aVar, au auVar) {
            view.getTag();
            String str = auVar.field_content;
            if (str == null) {
                return false;
            }
            com.tencent.mm.y.g.a fT = com.tencent.mm.y.g.a.fT(str);
            if (fT == null) {
                return false;
            }
            com.tencent.mm.pluginsdk.model.app.f aZ = com.tencent.mm.pluginsdk.model.app.g.aZ(fT.appId, true);
            if (!(aZ == null || bh.ov(aZ.field_appId) || !aZ.Yz())) {
                a(aVar, fT, com.tencent.mm.z.q.FS(), aZ, auVar.field_msgSvrId);
            }
            com.tencent.mm.sdk.b.b qpVar = new qp();
            qpVar.fIi.appId = fT.hdy;
            qpVar.fIi.userName = fT.hdx;
            qpVar.fIi.fIk = fT.hdw;
            qpVar.fIi.fIl = fT.hdE;
            qpVar.fIi.fIn = fT.hdA;
            qpVar.fIi.fIm = fT.hdF;
            qpVar.fIi.fIo = fT.hdE != 0;
            str = fT.hdC;
            StringBuilder stringBuilder;
            if (aVar.ysk) {
                qpVar.fIi.scene = 1008;
                stringBuilder = new StringBuilder(aVar.crz());
                stringBuilder.append(":");
                stringBuilder.append(a(aVar, auVar));
                stringBuilder.append(":");
                stringBuilder.append(str);
                qpVar.fIi.fnp = stringBuilder.toString();
            } else {
                qpVar.fIi.scene = 1007;
                stringBuilder = new StringBuilder(a(aVar, auVar));
                stringBuilder.append(":");
                stringBuilder.append(str);
                qpVar.fIi.fnp = stringBuilder.toString();
            }
            qpVar.fIi.fIq.hjz = aVar.crz();
            qpVar.fIi.fIq.hjA = fT.hdD;
            com.tencent.mm.sdk.b.a.xef.m(qpVar);
            return true;
        }

        public final void q(View view, int i) {
            Object tag = view.getTag();
            if (tag instanceof d) {
                x.i("MicroMsg.ChattingItemAppMsgWxaDynamicTo", "onWidgetStateChanged(%s, state : %d)", new Object[]{Integer.valueOf(view.hashCode()), Integer.valueOf(i)});
                d dVar = (d) tag;
                switch (i) {
                    case 0:
                        dVar.jPG.setVisibility(0);
                        dVar.jPG.cze();
                        dVar.yKH.setVisibility(4);
                        dVar.tpk.setVisibility(4);
                        return;
                    case 1:
                        dVar.jPG.ajm();
                        dVar.jPG.setVisibility(4);
                        dVar.yKH.setVisibility(4);
                        dVar.tpk.setVisibility(0);
                        dVar.tpk.setImageResource(R.k.dyu);
                        return;
                    case 4:
                        dVar.jPG.ajm();
                        dVar.jPG.setVisibility(4);
                        dVar.yKH.setVisibility(0);
                        dVar.tpk.setVisibility(4);
                        return;
                    default:
                        dVar.jPG.ajm();
                        dVar.jPG.setVisibility(4);
                        dVar.yKH.setVisibility(4);
                        dVar.tpk.setVisibility(0);
                        dVar.tpk.setImageResource(R.k.dvI);
                        return;
                }
            }
        }
    }
}
