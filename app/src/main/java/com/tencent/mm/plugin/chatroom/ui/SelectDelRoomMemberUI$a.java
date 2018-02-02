package com.tencent.mm.plugin.chatroom.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.g.b.af;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.m;
import com.tencent.mm.z.s;
import java.util.ArrayList;
import java.util.List;

class SelectDelRoomMemberUI$a extends BaseAdapter {
    static List<x> fAN = new ArrayList();
    static List<x> ldk;
    private String iQs;
    q kZS;
    private List<String> kiU;
    private c lcA;
    String ldh;
    private String ldj = null;
    a ldv = null;
    private Context mContext;

    private static class a {
        public TextView kEZ;
        public ImageButton ldA;
        public MaskLayout ldx;
        public TextView ldy;
        public ImageView ldz;

        private a() {
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        return oh(i);
    }

    public SelectDelRoomMemberUI$a(Context context, q qVar, String str, List<String> list, String str2) {
        this.kZS = qVar;
        this.iQs = str;
        this.kiU = list;
        this.mContext = context;
        this.ldj = str2;
        this.lcA = ar.Hg();
        at(m.gj(str));
    }

    public final void at(List<String> list) {
        if (list != null) {
            fAN.clear();
            for (int i = 0; i < list.size(); i++) {
                af WO = c.EY().WO((String) list.get(i));
                if (WO == null || !WO.field_username.equals(this.ldj)) {
                    fAN.add(WO);
                } else {
                    fAN.add(0, WO);
                }
            }
            ldk = fAN;
            notifyDataSetChanged();
        }
    }

    public static x oh(int i) {
        return (x) fAN.get(i);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        x xVar = (x) fAN.get(i);
        if (view == null) {
            view = View.inflate(this.mContext, R.i.dfq, null);
            this.ldv = new a();
            this.ldv.ldx = (MaskLayout) view.findViewById(R.h.cKy);
            this.ldv.kEZ = (TextView) view.findViewById(R.h.cKA);
            WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
            this.ldv.kEZ.setMaxWidth((windowManager.getDefaultDisplay().getWidth() * 2) / 3);
            this.ldv.ldy = (TextView) view.findViewById(R.h.cKz);
            this.ldv.ldy.setMaxWidth((windowManager.getDefaultDisplay().getWidth() * 2) / 3);
            this.ldv.ldz = (ImageView) view.findViewById(R.h.cIk);
            this.ldv.ldA = (ImageButton) view.findViewById(R.h.bPg);
            view.setTag(this.ldv);
            view2 = view;
        } else {
            this.ldv = (a) view.getTag();
            view2 = view;
        }
        if (xVar != null) {
            final String str;
            CharSequence charSequence;
            CharSequence charSequence2;
            this.ldv.kEZ.setTextColor(com.tencent.mm.bv.a.Z(this.mContext, !s.hn(xVar.field_username) ? R.e.bth : R.e.bti));
            if (this.kZS.field_roomowner.equals(xVar.field_username)) {
                this.ldv.ldA.setVisibility(8);
                ((LargeTouchableAreasItemView) view2).laY = null;
            } else {
                if (((SelectDelRoomMemberUI) this.mContext).iiv.contains(xVar.field_username)) {
                    ((LargeTouchableAreasItemView) view2).ej(true);
                } else {
                    ((LargeTouchableAreasItemView) view2).ej(false);
                }
                this.ldv.ldA.setVisibility(0);
                str = xVar.field_username;
                ((LargeTouchableAreasItemView) view2).laY = new com.tencent.mm.plugin.chatroom.ui.LargeTouchableAreasItemView.a(this) {
                    final /* synthetic */ SelectDelRoomMemberUI$a ldw;

                    public final void ek(boolean z) {
                        if (z) {
                            ((SelectDelRoomMemberUI) this.ldw.mContext).iiv.add(str);
                        } else {
                            ((SelectDelRoomMemberUI) this.ldw.mContext).iiv.remove(str);
                        }
                        SelectDelRoomMemberUI.f((SelectDelRoomMemberUI) this.ldw.mContext);
                    }
                };
            }
            b.a((ImageView) this.ldv.ldx.view, xVar.field_username);
            if (xVar.field_verifyFlag == 0) {
                this.ldv.ldx.cpQ();
            } else if (com.tencent.mm.z.ak.a.hfN != null) {
                String gP = com.tencent.mm.z.ak.a.hfN.gP(xVar.field_verifyFlag);
                if (gP != null) {
                    this.ldv.ldx.d(com.tencent.mm.ag.m.kf(gP), com.tencent.mm.ui.base.MaskLayout.a.yfa);
                } else {
                    this.ldv.ldx.cpQ();
                }
            } else {
                this.ldv.ldx.cpQ();
            }
            str = SelectDelRoomMemberUI.b(this.kZS, xVar.field_username);
            if (bh.ov(xVar.field_conRemark)) {
                Object obj = str;
            } else {
                charSequence = xVar.field_conRemark;
            }
            if (bh.ov(charSequence)) {
                charSequence = xVar.AP();
            }
            if (!(str == null || str.equals("") || charSequence.equals(str))) {
                charSequence = str + "( " + charSequence + " )";
            }
            str = "";
            if (com.tencent.mm.l.a.fZ(xVar.field_type)) {
                charSequence2 = xVar.fWy;
            } else {
                ar.Hg();
                bf EZ = c.EZ().EZ(xVar.field_username);
                if (EZ != null) {
                    charSequence2 = EZ.field_conDescription;
                    if (!bh.ov(EZ.field_conRemark)) {
                        charSequence = EZ.field_conRemark;
                    }
                } else {
                    Object obj2 = str;
                }
            }
            if (bh.ov(charSequence2)) {
                this.ldv.ldy.setText("");
            } else {
                this.ldv.ldy.setText(i.b(this.mContext, charSequence2, this.ldv.ldy.getTextSize()));
            }
            this.ldv.kEZ.setText(i.b(this.mContext, charSequence, this.ldv.kEZ.getTextSize()));
        }
        return view2;
    }

    public final int getCount() {
        return fAN.size();
    }

    public final long getItemId(int i) {
        return (long) i;
    }
}
