package com.tencent.mm.plugin.chatroom.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.g.b.af;
import com.tencent.mm.plugin.chatroom.ui.SeeRoomMemberUI.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.q;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.m;
import java.util.ArrayList;
import java.util.List;

class SeeRoomMemberUI$b extends BaseAdapter {
    private List<a> fAN = new ArrayList();
    private String iQs;
    private q kZS;
    private List<String> kiU;
    private c lcA;
    final /* synthetic */ SeeRoomMemberUI lde;
    public String ldh;
    private boolean ldi = false;
    private String ldj = null;
    private List<a> ldk;
    private Context mContext;

    public final /* synthetic */ Object getItem(int i) {
        return og(i);
    }

    public SeeRoomMemberUI$b(SeeRoomMemberUI seeRoomMemberUI, Context context, q qVar, String str, List<String> list, String str2) {
        this.lde = seeRoomMemberUI;
        this.kZS = qVar;
        this.iQs = str;
        this.kiU = list;
        this.ldj = str2;
        this.mContext = context;
        this.lcA = ar.Hg();
        at(m.gj(str));
    }

    public final void at(List<String> list) {
        if (list != null) {
            this.fAN.clear();
            for (int i = 0; i < list.size(); i++) {
                af WO = c.EY().WO((String) list.get(i));
                if (WO == null || !WO.field_username.equals(this.ldj)) {
                    this.fAN.add(new a(1, WO));
                } else {
                    this.fAN.add(0, new a(1, WO));
                }
            }
            this.fAN.add(new a(2, null));
            if (SeeRoomMemberUI.j(this.lde)) {
                this.fAN.add(new a(3, null));
            }
            this.ldk = this.fAN;
            notifyDataSetChanged();
        }
    }

    public final a og(int i) {
        return (a) this.fAN.get(i);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        SeeRoomMemberUI.c cVar;
        if (view == null) {
            view = View.inflate(this.mContext, R.i.drA, null);
            cVar = new SeeRoomMemberUI.c((byte) 0);
            cVar.iip = (ImageView) view.findViewById(R.h.cKy);
            cVar.kEZ = (TextView) view.findViewById(R.h.cKA);
            cVar.kEZ.setMaxWidth((((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getWidth() * 2) / 3);
            view.setTag(cVar);
        } else {
            cVar = (SeeRoomMemberUI.c) view.getTag();
        }
        a aVar = (a) this.fAN.get(i);
        if (aVar != null && aVar.type == 1) {
            CharSequence charSequence;
            af afVar = aVar.jLe;
            b.a(cVar.iip, afVar.field_username);
            String a = SeeRoomMemberUI.a(this.kZS, afVar.field_username);
            if (bh.ov(afVar.field_conRemark)) {
                Object obj = a;
            } else {
                charSequence = afVar.field_conRemark;
            }
            if (bh.ov(charSequence)) {
                charSequence = afVar.AP();
            }
            if (!(a == null || a.equals("") || charSequence.equals(a))) {
                charSequence = a + "( " + charSequence + " )";
            }
            cVar.kEZ.setVisibility(0);
            cVar.kEZ.setText(i.b(this.mContext, charSequence, cVar.kEZ.getTextSize()));
        } else if (aVar != null && aVar.type == 2) {
            cVar.kEZ.setVisibility(4);
            cVar.iip.setImageResource(R.g.bzk);
        } else if (aVar != null && aVar.type == 3) {
            cVar.kEZ.setVisibility(4);
            cVar.iip.setImageResource(R.g.bzl);
        }
        return view;
    }

    public final void xg(String str) {
        this.ldi = true;
        this.ldh = str;
        List arrayList = new ArrayList();
        if (bh.ov(str)) {
            this.fAN = this.ldk;
        } else {
            for (a aVar : this.ldk) {
                if (!(aVar == null || aVar.jLe == null || aVar.type != 1)) {
                    af afVar = aVar.jLe;
                    if (afVar.field_conRemark != null && afVar.field_conRemark.toUpperCase().contains(str.toUpperCase())) {
                        arrayList.add(aVar);
                    } else if (!bh.ov(SeeRoomMemberUI.a(this.kZS, afVar.field_username)) && SeeRoomMemberUI.a(this.kZS, afVar.field_username).contains(str)) {
                        arrayList.add(aVar);
                    } else if (afVar.AP() != null && afVar.AP().toUpperCase().contains(str.toUpperCase())) {
                        arrayList.add(aVar);
                    } else if (afVar.vQ() != null && afVar.vQ().toUpperCase().contains(str.toUpperCase())) {
                        arrayList.add(aVar);
                    } else if (afVar.vN() != null && afVar.vN().contains(str)) {
                        arrayList.add(aVar);
                    } else if (afVar.field_username != null && afVar.field_username.contains(str)) {
                        arrayList.add(aVar);
                    } else if (!com.tencent.mm.l.a.fZ(afVar.field_type)) {
                        ar.Hg();
                        bf EZ = c.EZ().EZ(afVar.field_username);
                        if (!(EZ == null || EZ.field_conRemark == null || !EZ.field_conRemark.toUpperCase().contains(str.toUpperCase()))) {
                            arrayList.add(aVar);
                        }
                    }
                }
            }
            x.i("MicroMsg.SeeRoomMemberUI", "[setMemberListBySearch]");
            this.fAN = arrayList;
        }
        notifyDataSetChanged();
    }

    public final int getCount() {
        return this.fAN.size();
    }

    public final long getItemId(int i) {
        return (long) i;
    }
}
