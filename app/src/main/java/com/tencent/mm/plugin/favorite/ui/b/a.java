package com.tencent.mm.plugin.favorite.ui.b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.g.b.af;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.a.g;
import com.tencent.mm.plugin.favorite.b.h;
import com.tencent.mm.plugin.favorite.d;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.protocal.c.vg;
import com.tencent.mm.protocal.c.vk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.q;
import com.tencent.mm.z.r;
import com.tencent.mm.z.s;

public abstract class a {
    protected h mpb = null;
    public final a mxM = new a();

    public interface c {
        void dq(long j);
    }

    public abstract View a(View view, ViewGroup viewGroup, f fVar);

    public abstract void a(View view, vg vgVar);

    public a(h hVar) {
        this.mpb = hVar;
    }

    protected final View a(View view, b bVar, f fVar) {
        if (view == null) {
            throw new NullPointerException("base item view is null");
        }
        bVar.mxP = view.findViewById(R.h.chr);
        if (bVar.mxP == null) {
            throw new IllegalArgumentException("base item view do not contain id named favTypeLayout");
        }
        bVar.lgz = (TextView) view.findViewById(R.h.cgR);
        if (bVar.lgz == null) {
            throw new IllegalArgumentException("base item view do not contain id named fav_name");
        }
        bVar.ldK = (TextView) view.findViewById(R.h.chn);
        if (bVar.ldK == null) {
            throw new IllegalArgumentException("base item view do not contain id named fav_time");
        }
        bVar.iis = (CheckBox) view.findViewById(R.h.cgo);
        if (bVar.iis == null) {
            throw new IllegalArgumentException("base item view do not contain id named checkbox");
        }
        bVar.mxQ = (ImageView) view.findViewById(R.h.chk);
        if (bVar.mxQ == null) {
            throw new IllegalArgumentException("base item view do not contain id named tagIV");
        }
        bVar.iis.setOnCheckedChangeListener(new 1(this));
        bVar.mqC = fVar;
        view.setTag(bVar);
        bVar.mxR = (LinearLayout) view.findViewById(R.h.chh);
        bVar.mxS = (TextView) view.findViewById(R.h.chg);
        bVar.mxS.setOnClickListener(new 2(this));
        return view;
    }

    protected final void a(b bVar, f fVar) {
        bVar.mqC = fVar;
        if (bVar.mqC.field_type == 18) {
            bVar.mxP.setVisibility(0);
        } else {
            bVar.mxP.setVisibility(8);
        }
        if (this.mxM.mux) {
            bVar.ldK.setText(d.dg(bVar.mqC.field_datatotalsize));
        } else {
            bVar.ldK.setText(g.e(bVar.ldK.getContext(), bVar.mqC.field_updateTime));
        }
        Context context = bVar.lgz.getContext();
        ar.Hg();
        af WN = com.tencent.mm.z.c.EY().WN(bVar.mqC.field_fromUser);
        if (WN == null || !WN.field_username.equals(bVar.mqC.field_fromUser)) {
            x.w("MicroMsg.FavBaseListItem", "render name, user is %s, but name is null", bVar.mqC.field_fromUser);
            bVar.lgz.setText("");
            com.tencent.mm.z.ak.a.hfL.a(bVar.mqC.field_fromUser, "", null);
        } else {
            CharSequence gu;
            if (s.eV(bVar.mqC.field_fromUser)) {
                vk vkVar = bVar.mqC.field_favProto.weS;
                gu = q.FS().equals(vkVar.fzO) ? r.gu(vkVar.toUser) : r.gu(vkVar.fzO);
            } else {
                gu = r.a(WN, WN.field_username);
            }
            bVar.lgz.setText(i.b(context, gu, bVar.lgz.getTextSize()));
        }
        if (bVar.mqC.aHM()) {
            bVar.mxR.setVisibility(0);
        } else {
            bVar.mxR.setVisibility(8);
        }
        bVar.iis.setTag(fVar);
        if (this.mxM.mup || this.mxM.mux) {
            boolean z;
            bVar.iis.setVisibility(0);
            CheckBox checkBox = bVar.iis;
            if (this.mxM.muq.get(Long.valueOf(fVar.field_localId)) != null) {
                z = true;
            } else {
                z = false;
            }
            checkBox.setChecked(z);
        } else {
            bVar.iis.setVisibility(8);
        }
        bVar.mxS.setTag(fVar);
        if (fVar.field_tagProto.wfj == null || fVar.field_tagProto.wfj.isEmpty()) {
            bVar.mxQ.setVisibility(8);
        } else {
            bVar.mxQ.setVisibility(0);
        }
    }
}
