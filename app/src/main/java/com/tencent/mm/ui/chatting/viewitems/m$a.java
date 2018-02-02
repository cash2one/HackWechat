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
import com.tencent.mm.g.a.mt;
import com.tencent.mm.g.a.qp;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.e;
import com.tencent.mm.modelappbrand.f;
import com.tencent.mm.modelappbrand.h;
import com.tencent.mm.modelappbrand.q;
import com.tencent.mm.modelappbrand.r;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.m.b;
import com.tencent.mm.plugin.appbrand.p.k;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.i;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.u;
import com.tencent.wcdb.FileUtils;

public class m$a extends b implements f {
    private q iVn = new r(this);
    private a yqa;

    public final boolean aXj() {
        return false;
    }

    public final boolean aj(int i, boolean z) {
        if (z || i != 553648177) {
            return false;
        }
        return true;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        view = new p(layoutInflater, R.i.ddr);
        m$d s = new m$d().s(view, true);
        View be = ((e) g.h(e.class)).be(view.getContext());
        s.yKH = be;
        s.yKG.addView(be, new LayoutParams(-1, -1));
        view.setTag(s);
        return view;
    }

    public final void a(b.a aVar, int i, a aVar2, au auVar, String str) {
        com.tencent.mm.y.g.a I;
        this.yqa = aVar2;
        m$d com_tencent_mm_ui_chatting_viewitems_m_d = (m$d) aVar;
        String str2 = auVar.field_content;
        aVar2.yvP.aR(auVar);
        aVar2.yvP.aS(auVar);
        aVar2.yvP.aT(auVar);
        x.d("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "filling Wxa dynamic from ChattingItem(%s)", new Object[]{str});
        if (str2 != null) {
            I = com.tencent.mm.y.g.a.I(str2, auVar.field_reserved);
        } else {
            x.e("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "amessage, msgid:%s, user:%s", new Object[]{Long.valueOf(auVar.field_msgId), str});
            I = null;
        }
        ar arVar = new ar(auVar, aVar2.ypn, i, null, (byte) 0);
        if (I != null) {
            CharSequence charSequence;
            com_tencent_mm_ui_chatting_viewitems_m_d.yIU.setVisibility(8);
            com_tencent_mm_ui_chatting_viewitems_m_d.yIT.setVisibility(8);
            com_tencent_mm_ui_chatting_viewitems_m_d.yJs.setVisibility(8);
            com.tencent.mm.y.e eVar = (com.tencent.mm.y.e) I.r(com.tencent.mm.y.e.class);
            if (com_tencent_mm_ui_chatting_viewitems_m_d.yIX.m(eVar == null ? null : eVar.haX, auVar.field_talker)) {
                com_tencent_mm_ui_chatting_viewitems_m_d.yIy.setBackgroundResource(R.g.bAW);
            } else {
                com_tencent_mm_ui_chatting_viewitems_m_d.yIy.setBackgroundResource(R.g.bAS);
            }
            com.tencent.mm.pluginsdk.model.app.f cQ = com.tencent.mm.pluginsdk.model.app.g.cQ(I.appId, I.fIm);
            if (cQ != null && cQ.Yz()) {
                b(aVar2, I, auVar);
            }
            if (I.gjD == null || I.gjD.length() == 0) {
                com_tencent_mm_ui_chatting_viewitems_m_d.yIW.setVisibility(8);
            } else {
                com_tencent_mm_ui_chatting_viewitems_m_d.yIW.setVisibility(0);
                b(aVar2, com_tencent_mm_ui_chatting_viewitems_m_d.yIW, ar.Zx(I.gjD));
            }
            WxaAttributes qK = ((b) g.h(b.class)).qK(I.hdx);
            com_tencent_mm_ui_chatting_viewitems_m_d.yIZ.setVisibility(0);
            com_tencent_mm_ui_chatting_viewitems_m_d.yIQ.setVisibility(8);
            com_tencent_mm_ui_chatting_viewitems_m_d.yJc.setVisibility(0);
            com_tencent_mm_ui_chatting_viewitems_m_d.yJa.setVisibility(8);
            if (qK != null) {
                charSequence = qK.field_nickname;
            } else {
                Object obj = I.fGA;
            }
            str2 = qK != null ? qK.field_brandIconURL : I.hdG;
            com_tencent_mm_ui_chatting_viewitems_m_d.yJs.setVisibility(0);
            com_tencent_mm_ui_chatting_viewitems_m_d.yJo.setVisibility(8);
            com_tencent_mm_ui_chatting_viewitems_m_d.yJv.setText(I.title);
            com_tencent_mm_ui_chatting_viewitems_m_d.yJo.setText(I.description);
            com_tencent_mm_ui_chatting_viewitems_m_d.yJq.setText(charSequence);
            switch (I.hdE) {
                case 1:
                    com_tencent_mm_ui_chatting_viewitems_m_d.yJr.setText(R.l.dEl);
                    break;
                case 2:
                    com_tencent_mm_ui_chatting_viewitems_m_d.yJr.setText(R.l.dEk);
                    break;
                default:
                    com_tencent_mm_ui_chatting_viewitems_m_d.yJr.setText(R.l.dDT);
                    break;
            }
            o.PA().a(str2, com_tencent_mm_ui_chatting_viewitems_m_d.yJp, m$d.yKF);
            if (aVar2.ypn) {
                com_tencent_mm_ui_chatting_viewitems_m_d.yIY.setVisibility(8);
            } else if (com.tencent.mm.pluginsdk.model.app.g.g(cQ)) {
                com_tencent_mm_ui_chatting_viewitems_m_d.yIY.setVisibility(0);
                c(aVar2, com_tencent_mm_ui_chatting_viewitems_m_d.yIY, ar.a(I, auVar));
            } else {
                com_tencent_mm_ui_chatting_viewitems_m_d.yIY.setVisibility(8);
            }
            com.tencent.mm.y.a aVar3 = (com.tencent.mm.y.a) I.r(com.tencent.mm.y.a.class);
            Bundle bundle = new Bundle();
            bundle.putString("app_id", I.hdy);
            bundle.putString("msg_id", auVar.field_msgId);
            bundle.putString("cache_key", aVar3 != null ? aVar3.haA : null);
            bundle.putString("msg_title", I.title);
            bundle.putString("msg_path", I.hdw);
            bundle.putInt("msg_pkg_type", I.hdE);
            bundle.putInt("pkg_version", I.fIm);
            bundle.putInt("widget_type", 0);
            bundle.putInt("scene", aVar2.ysk ? 1008 : 1007);
            bundle.putInt("view_init_width", m$d.yKD);
            bundle.putInt("view_init_height", m$d.yKE);
            com_tencent_mm_ui_chatting_viewitems_m_d.yKH.setTag(com_tencent_mm_ui_chatting_viewitems_m_d);
            ((e) g.h(e.class)).a(k.bi(aVar2), com_tencent_mm_ui_chatting_viewitems_m_d.yKH, bundle, this.iVn);
        }
        com_tencent_mm_ui_chatting_viewitems_m_d.yIy.setTag(arVar);
        com_tencent_mm_ui_chatting_viewitems_m_d.yIy.setOnClickListener(t(aVar2));
        u.b t = u.GK().t(k.bi(aVar2), true);
        m$c com_tencent_mm_ui_chatting_viewitems_m_c = (m$c) t.get("listener", null);
        if (com_tencent_mm_ui_chatting_viewitems_m_c == null) {
            com_tencent_mm_ui_chatting_viewitems_m_c = new m$c();
            t.o("listener", com_tencent_mm_ui_chatting_viewitems_m_c);
        }
        com_tencent_mm_ui_chatting_viewitems_m_c.z(aVar2);
        if (this.vzn) {
            com_tencent_mm_ui_chatting_viewitems_m_d.yIy.setOnLongClickListener(s(aVar2));
        }
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        int i = ((ar) view.getTag()).position;
        com.tencent.mm.y.g.a fT = com.tencent.mm.y.g.a.fT(this.yqa.dk(auVar.field_content, auVar.field_isSend));
        if (com.tencent.mm.pluginsdk.model.app.g.h(com.tencent.mm.pluginsdk.model.app.g.aZ(fT.appId, false)) && !i.an(auVar)) {
            if (fT.type == 6) {
                com.tencent.mm.pluginsdk.model.app.b RI = l.RI(fT.fny);
                if ((RI == null || !c.b.c(auVar, RI.field_fileFullPath)) && !auVar.cjs()) {
                    contextMenu.add(i, 111, 0, this.yqa.getString(R.l.eEC));
                }
            } else {
                contextMenu.add(i, 111, 0, this.yqa.getString(R.l.eEC));
            }
        }
        com.tencent.mm.sdk.b.b dhVar = new dh();
        dhVar.frQ.fqm = auVar.field_msgId;
        com.tencent.mm.sdk.b.a.xef.m(dhVar);
        if (dhVar.frR.frp || c.b.a(this.yqa.getContext(), fT)) {
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
        return true;
    }

    public final boolean a(MenuItem menuItem, a aVar, au auVar) {
        com.tencent.mm.y.g.a aVar2 = null;
        String str;
        switch (menuItem.getItemId()) {
            case 100:
                str = auVar.field_content;
                if (str != null) {
                    aVar2 = com.tencent.mm.y.g.a.fT(str);
                }
                if (aVar2 != null) {
                    l.fq(auVar.field_msgId);
                    if (19 == aVar2.type) {
                        com.tencent.mm.sdk.b.b mtVar = new mt();
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
            case 111:
                c.b.a(aVar, auVar, a(aVar, auVar));
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
        com.tencent.mm.modelstat.a.a(auVar, com.tencent.mm.modelstat.a.a.hPx);
        String str = auVar.field_content;
        if (str == null) {
            return false;
        }
        com.tencent.mm.y.g.a fT = com.tencent.mm.y.g.a.fT(aVar.dk(str, auVar.field_isSend));
        if (fT == null) {
            return false;
        }
        com.tencent.mm.pluginsdk.model.app.f aZ = com.tencent.mm.pluginsdk.model.app.g.aZ(fT.appId, false);
        if (aZ != null && aZ.Yz()) {
            a(aVar, fT, c(aVar, auVar), aZ, auVar.field_msgSvrId);
        }
        x.i("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "username: %s , path: %s ,appid %s ,url : %s, pkgType : %s, md5 : %s", new Object[]{fT.hdx, fT.hdw, fT.hdy, fT.url, Integer.valueOf(fT.hdE), fT.hdA});
        com.tencent.mm.sdk.b.b qpVar = new qp();
        qpVar.fIi.appId = fT.hdy;
        qpVar.fIi.userName = fT.hdx;
        qpVar.fIi.fIk = fT.hdw;
        qpVar.fIi.fIl = fT.hdE;
        qpVar.fIi.fIn = fT.hdA;
        qpVar.fIi.fIm = fT.hdF;
        qpVar.fIi.fIo = fT.hdE != 0;
        qpVar.fIi.fIq.hjz = aVar.crz();
        qpVar.fIi.fIq.hjA = fT.hdD;
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
        com.tencent.mm.sdk.b.a.xef.m(qpVar);
        return true;
    }

    public final void q(View view, int i) {
        Object tag = view.getTag();
        if (tag instanceof m$d) {
            x.i("MicroMsg.ChattingItemAppMsgWxaDynamicFrom", "onWidgetStateChanged(%s, state : %d)", new Object[]{Integer.valueOf(view.hashCode()), Integer.valueOf(i)});
            m$d com_tencent_mm_ui_chatting_viewitems_m_d = (m$d) tag;
            switch (i) {
                case 0:
                    com_tencent_mm_ui_chatting_viewitems_m_d.jPG.setVisibility(0);
                    com_tencent_mm_ui_chatting_viewitems_m_d.jPG.cze();
                    com_tencent_mm_ui_chatting_viewitems_m_d.tpk.setVisibility(4);
                    com_tencent_mm_ui_chatting_viewitems_m_d.yKH.setVisibility(4);
                    return;
                case 1:
                    com_tencent_mm_ui_chatting_viewitems_m_d.jPG.ajm();
                    com_tencent_mm_ui_chatting_viewitems_m_d.jPG.setVisibility(4);
                    com_tencent_mm_ui_chatting_viewitems_m_d.yKH.setVisibility(4);
                    com_tencent_mm_ui_chatting_viewitems_m_d.tpk.setVisibility(0);
                    com_tencent_mm_ui_chatting_viewitems_m_d.tpk.setImageResource(R.k.dyu);
                    return;
                case 4:
                    com_tencent_mm_ui_chatting_viewitems_m_d.jPG.ajm();
                    com_tencent_mm_ui_chatting_viewitems_m_d.jPG.setVisibility(4);
                    com_tencent_mm_ui_chatting_viewitems_m_d.yKH.setVisibility(0);
                    com_tencent_mm_ui_chatting_viewitems_m_d.tpk.setVisibility(4);
                    return;
                default:
                    com_tencent_mm_ui_chatting_viewitems_m_d.jPG.ajm();
                    com_tencent_mm_ui_chatting_viewitems_m_d.jPG.setVisibility(4);
                    com_tencent_mm_ui_chatting_viewitems_m_d.yKH.setVisibility(4);
                    com_tencent_mm_ui_chatting_viewitems_m_d.tpk.setVisibility(0);
                    com_tencent_mm_ui_chatting_viewitems_m_d.tpk.setImageResource(R.k.dvI);
                    return;
            }
        }
    }
}
