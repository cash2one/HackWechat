package com.tencent.mm.plugin.nearby.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.aq.o;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI.c;
import com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI.d;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.protocal.c.aoe;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.applet.b;
import com.tencent.mm.z.ak;
import com.tencent.mm.z.ar;
import java.util.LinkedList;

class NearbyFriendsUI$b extends BaseAdapter {
    private final Context context;
    b hvU = new b(new 1(this));
    private b.b hvV = null;
    final /* synthetic */ NearbyFriendsUI oOS;

    public final /* synthetic */ Object getItem(int i) {
        return tO(i);
    }

    public NearbyFriendsUI$b(NearbyFriendsUI nearbyFriendsUI, Context context) {
        this.oOS = nearbyFriendsUI;
        this.context = context;
    }

    public final int getCount() {
        return NearbyFriendsUI.r(this.oOS).size();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        d dVar;
        if (this.hvV == null) {
            this.hvV = new b.b(this) {
                final /* synthetic */ NearbyFriendsUI$b oOW;

                {
                    this.oOW = r1;
                }

                public final String hC(int i) {
                    if (i < 0 || i >= this.oOW.getCount()) {
                        x.e("MicroMsg.NearbyFriend", "pos is invalid");
                        return null;
                    }
                    aoe tO = this.oOW.tO(i);
                    if (tO != null) {
                        return tO.ksU;
                    }
                    return null;
                }

                public final int NJ() {
                    return this.oOW.getCount();
                }
            };
        }
        if (this.hvU != null) {
            this.hvU.a(i, this.hvV);
        }
        if (view == null) {
            d dVar2 = new d();
            view = View.inflate(this.context, R.i.doL, null);
            dVar2.hvZ = (TextView) view.findViewById(R.h.cyX);
            dVar2.oOZ = (TextView) view.findViewById(R.h.cza);
            dVar2.oOY = (TextView) view.findViewById(R.h.cyS);
            dVar2.hvY = (ImageView) view.findViewById(R.h.cyR);
            dVar2.hwa = (TextView) view.findViewById(R.h.cyU);
            dVar2.oPa = (ImageView) view.findViewById(R.h.czc);
            dVar2.oPb = (ImageView) view.findViewById(R.h.czb);
            dVar2.oPd = (ImageView) view.findViewById(R.h.cyO);
            dVar2.oPe = (ImageView) view.findViewById(R.h.cyP);
            dVar2.oPf = (ImageView) view.findViewById(R.h.cyQ);
            LayoutParams layoutParams = dVar2.oPb.getLayoutParams();
            layoutParams.height = a.aa(this.context, R.f.bvJ);
            layoutParams.width = a.aa(this.context, R.f.bvJ);
            dVar2.oPb.setLayoutParams(layoutParams);
            dVar2.oPc = (ImageView) view.findViewById(R.h.cyZ);
            view.setTag(dVar2);
            dVar = dVar2;
        } else {
            dVar = (d) view.getTag();
        }
        aoe com_tencent_mm_protocal_c_aoe = (aoe) NearbyFriendsUI.r(this.oOS).get(i);
        dVar.hvZ.setText(i.b(this.context, com_tencent_mm_protocal_c_aoe.kub, dVar.hvZ.getTextSize()));
        if (NearbyFriendsUI.h(this.oOS) == 1) {
            switch (com_tencent_mm_protocal_c_aoe.hvt) {
                case 1:
                    dVar.oPc.setVisibility(0);
                    dVar.oPc.setImageResource(R.k.dyN);
                    dVar.oPc.setContentDescription(this.context.getString(R.l.euC));
                    break;
                case 2:
                    dVar.oPc.setVisibility(0);
                    dVar.oPc.setImageResource(R.k.dyM);
                    dVar.oPc.setContentDescription(this.context.getString(R.l.ehc));
                    break;
                default:
                    dVar.oPc.setVisibility(8);
                    break;
            }
        }
        dVar.oPc.setVisibility(8);
        if (com_tencent_mm_protocal_c_aoe.wvf != 0) {
            dVar.oPa.setVisibility(0);
            dVar.oPa.setImageBitmap(BackwardSupportUtil.b.b(ak.a.hfN.gO(com_tencent_mm_protocal_c_aoe.wvf), 2.0f));
            dVar.oPc.setVisibility(8);
        } else {
            dVar.oPa.setVisibility(8);
        }
        dVar.oOY.setText(com_tencent_mm_protocal_c_aoe.wve);
        dVar.oPd.setVisibility(8);
        dVar.oPe.setVisibility(8);
        dVar.oPf.setVisibility(8);
        if (com_tencent_mm_protocal_c_aoe instanceof com.tencent.mm.plugin.nearby.a.a) {
            LinkedList linkedList = ((com.tencent.mm.plugin.nearby.a.a) com_tencent_mm_protocal_c_aoe).oNV;
            if (linkedList != null && linkedList.size() == 1) {
                dVar.oPd.setVisibility(0);
                NearbyFriendsUI.l(dVar.oPd, (String) linkedList.get(0));
            } else if (linkedList != null && linkedList.size() == 2) {
                dVar.oPd.setVisibility(0);
                dVar.oPe.setVisibility(0);
                NearbyFriendsUI.l(dVar.oPd, (String) linkedList.get(0));
                NearbyFriendsUI.l(dVar.oPe, (String) linkedList.get(1));
            } else if (linkedList != null && linkedList.size() >= 3) {
                dVar.oPd.setVisibility(0);
                dVar.oPe.setVisibility(0);
                dVar.oPf.setVisibility(0);
                NearbyFriendsUI.l(dVar.oPd, (String) linkedList.get(0));
                NearbyFriendsUI.l(dVar.oPe, (String) linkedList.get(1));
                NearbyFriendsUI.l(dVar.oPf, (String) linkedList.get(2));
            }
        }
        if (com_tencent_mm_protocal_c_aoe.hvw == null || com_tencent_mm_protocal_c_aoe.hvw.trim().equals("")) {
            dVar.oOZ.setVisibility(8);
        } else {
            dVar.oOZ.setVisibility(0);
            dVar.oOZ.setText(i.b(this.context, com_tencent_mm_protocal_c_aoe.hvw, dVar.oOZ.getTextSize()));
        }
        if (com_tencent_mm_protocal_c_aoe.wvl == null || (com_tencent_mm_protocal_c_aoe.wvl.hvE & 1) <= 0) {
            dVar.oPb.setVisibility(8);
        } else {
            dVar.oPb.setVisibility(0);
        }
        if (c.tP(com_tencent_mm_protocal_c_aoe.hvt)) {
            dVar.hvY.setImageBitmap(null);
            com.tencent.mm.aq.a.a.c.a aVar = new com.tencent.mm.aq.a.a.c.a();
            ar.Hg();
            aVar.hDD = com.tencent.mm.z.c.Fi();
            aVar.hDA = true;
            aVar.hDX = true;
            o.PA().a(com_tencent_mm_protocal_c_aoe.ksU, dVar.hvY, aVar.PK());
            if (!bh.ov(com_tencent_mm_protocal_c_aoe.hvy)) {
                dVar.hwa.setText(com_tencent_mm_protocal_c_aoe.hvy);
                dVar.hwa.setVisibility(0);
            }
            dVar.hwa.setVisibility(8);
        } else {
            com.tencent.mm.pluginsdk.ui.a.b.a(dVar.hvY, com_tencent_mm_protocal_c_aoe.ksU);
            ar.Hg();
            if (com.tencent.mm.z.c.EY().WK(com_tencent_mm_protocal_c_aoe.ksU)) {
                dVar.hwa.setVisibility(0);
                if (com.tencent.mm.storage.x.Dn(com_tencent_mm_protocal_c_aoe.wvf)) {
                    dVar.hwa.setText(this.oOS.getString(R.l.exf));
                } else {
                    ar.Hg();
                    com.tencent.mm.storage.x WM = com.tencent.mm.z.c.EY().WM(com_tencent_mm_protocal_c_aoe.ksU);
                    if (WM != null) {
                        dVar.hvZ.setText(i.b(this.context, bh.ov(WM.AQ()) ? com_tencent_mm_protocal_c_aoe.kub : WM.AQ(), dVar.hvZ.getTextSize()));
                    }
                    dVar.hwa.setText(this.oOS.getString(R.l.exh));
                }
            }
            dVar.hwa.setVisibility(8);
        }
        return view;
    }

    public final aoe tO(int i) {
        return (aoe) NearbyFriendsUI.r(this.oOS).get(i);
    }

    public final long getItemId(int i) {
        return 0;
    }
}
