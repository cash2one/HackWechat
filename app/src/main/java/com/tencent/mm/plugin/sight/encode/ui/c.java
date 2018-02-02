package com.tencent.mm.plugin.sight.encode.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.g.b.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.contact.a.d;
import com.tencent.mm.ui.contact.l;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.z.ar;
import java.util.ArrayList;
import java.util.List;

public final class c extends o {
    public static boolean qwS = true;
    public static boolean qwT = false;
    List<String> qwQ;
    private boolean qwR;

    public class a extends d {
        final /* synthetic */ c qwU;

        public class b extends com.tencent.mm.ui.contact.a.d.b {
            final /* synthetic */ a qwW;

            public b(a aVar) {
                this.qwW = aVar;
                super(aVar);
            }

            public final View a(Context context, ViewGroup viewGroup) {
                View inflate = LayoutInflater.from(context).inflate(R.i.dsK, viewGroup, false);
                a aVar = (a) this.qwW.WR();
                aVar.iip = (ImageView) inflate.findViewById(R.h.bLL);
                aVar.iiq = (TextView) inflate.findViewById(R.h.cSu);
                aVar.iir = (TextView) inflate.findViewById(R.h.caS);
                aVar.contentView = inflate.findViewById(R.h.cKR);
                aVar.iis = (CheckBox) inflate.findViewById(R.h.cKI);
                aVar.qvO = inflate.findViewById(R.h.crM);
                aVar.qwV = inflate.findViewById(R.h.cKe);
                inflate.setTag(aVar);
                aVar.iiq.setTextColor(-1);
                LayoutParams layoutParams = (LayoutParams) inflate.getLayoutParams();
                layoutParams.width = -1;
                inflate.setLayoutParams(layoutParams);
                inflate.setBackgroundResource(R.e.black);
                return inflate;
            }

            public final void a(Context context, com.tencent.mm.ui.contact.a.a.a aVar, com.tencent.mm.ui.contact.a.a aVar2, boolean z, boolean z2) {
                af afVar = aVar2.jLe;
                a aVar3 = (a) aVar;
                aVar3.contentView.setVisibility(0);
                aVar3.qwV.setVisibility(8);
                aVar3.qvO.setVisibility(8);
                if (c.Jx(afVar.field_username)) {
                    aVar3.iip.setImageResource(R.k.dAJ);
                    aVar3.iiq.setText(R.l.ePI);
                    aVar3.iir.setText(R.l.ePG);
                    aVar3.iir.setVisibility(0);
                    aVar3.iis.setEnabled(false);
                    if (c.qwT) {
                        aVar3.contentView.setBackgroundResource(R.g.bGj);
                        aVar3.iis.setVisibility(0);
                        aVar3.iis.setBackgroundResource(R.k.dAL);
                        aVar3.qvO.setVisibility(0);
                    } else {
                        aVar3.contentView.setBackgroundResource(R.g.bGk);
                        aVar3.iis.setVisibility(8);
                        aVar3.iis.setBackgroundResource(R.k.dAM);
                        aVar3.qvO.setVisibility(8);
                    }
                    c cVar = this.qwW.qwU;
                    c.d(context, aVar3.contentView);
                    ViewGroup.LayoutParams layoutParams = aVar3.iip.getLayoutParams();
                    layoutParams.width = com.tencent.mm.bv.a.aa(context, R.f.bxY);
                    layoutParams.height = com.tencent.mm.bv.a.aa(context, R.f.bxY);
                    aVar3.iip.setLayoutParams(layoutParams);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) aVar3.iis.getLayoutParams();
                    layoutParams2.height = com.tencent.mm.bv.a.aa(context, R.f.bxZ);
                    layoutParams2.width = com.tencent.mm.bv.a.aa(context, R.f.bxZ);
                    layoutParams2.setMargins(layoutParams2.leftMargin, layoutParams2.topMargin, 0, layoutParams2.bottomMargin);
                    aVar3.iis.setLayoutParams(layoutParams2);
                    return;
                }
                if (c.Jv(afVar.field_username)) {
                    aVar3.iip.setImageResource(R.k.dAK);
                    aVar3.iis.setVisibility(8);
                    aVar3.iiq.setText(context.getString(R.l.ePL));
                    aVar3.iir.setVisibility(8);
                    if (c.qwS) {
                        aVar3.contentView.setBackgroundResource(R.g.bGk);
                        aVar3.qvO.setVisibility(8);
                    } else {
                        aVar3.contentView.setBackgroundResource(R.g.bGj);
                        aVar3.qvO.setVisibility(0);
                    }
                    cVar = this.qwW.qwU;
                    c.d(context, aVar3.contentView);
                } else if (c.Jw(afVar.field_username)) {
                    aVar3.contentView.setVisibility(8);
                    aVar3.qwV.setVisibility(0);
                    return;
                } else {
                    super.a(context, aVar, aVar2, z, z2);
                    aVar3.contentView.setBackgroundResource(R.g.bGk);
                    cVar = this.qwW.qwU;
                    c.d(context, aVar3.contentView);
                }
                layoutParams = aVar3.iip.getLayoutParams();
                layoutParams.width = com.tencent.mm.bv.a.aa(context, R.f.bxY);
                layoutParams.height = com.tencent.mm.bv.a.aa(context, R.f.bxY);
                aVar3.iip.setLayoutParams(layoutParams);
                layoutParams2 = (LinearLayout.LayoutParams) aVar3.iis.getLayoutParams();
                layoutParams2.height = com.tencent.mm.bv.a.aa(context, R.f.bxZ);
                layoutParams2.width = com.tencent.mm.bv.a.aa(context, R.f.bxZ);
                layoutParams2.setMargins(layoutParams2.leftMargin, layoutParams2.topMargin, 0, layoutParams2.bottomMargin);
                aVar3.iis.setLayoutParams(layoutParams2);
                aVar3.iis.setBackgroundResource(R.g.bGi);
            }
        }

        public a(c cVar, int i) {
            this.qwU = cVar;
            super(i);
        }

        public final com.tencent.mm.ui.contact.a.a.b WQ() {
            return new b(this);
        }

        protected final com.tencent.mm.ui.contact.a.a.a WR() {
            return new a(this);
        }
    }

    static /* synthetic */ void d(Context context, View view) {
        if (view != null && context != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
            layoutParams.height = com.tencent.mm.bv.a.aa(context, R.f.byb);
            layoutParams.rightMargin = 0;
            layoutParams.leftMargin = 0;
            view.setLayoutParams(layoutParams);
            view.setPadding(com.tencent.mm.bv.a.fromDPToPix(context, 10), view.getPaddingTop(), com.tencent.mm.bv.a.fromDPToPix(context, 10), view.getPaddingTop());
        }
    }

    public c(l lVar) {
        super(lVar, new ArrayList(), true, true);
        this.qwR = true;
        this.qwR = true;
        this.qwQ = null;
    }

    public final int getCount() {
        return this.qwQ == null ? 0 : this.qwQ.size();
    }

    protected final com.tencent.mm.ui.contact.a.a jb(int i) {
        if (this.qwQ == null) {
            return null;
        }
        if (i < 0 || i >= getCount()) {
            x.e("MicroMsg.MainSightSelectContactAdapter", "create Data Item Error position=%d", new Object[]{Integer.valueOf(i)});
            return null;
        }
        com.tencent.mm.storage.x xVar;
        com.tencent.mm.ui.contact.a.a aVar = new a(this, i);
        String str = (String) this.qwQ.get(i);
        if (Jv(str)) {
            xVar = new com.tencent.mm.storage.x("@sns.tencent");
        } else if (Jw(str)) {
            xVar = new com.tencent.mm.storage.x("@search.tencent");
        } else if (Jx(str)) {
            xVar = new com.tencent.mm.storage.x("@draft.tencent");
        } else {
            ar.Hg();
            xVar = com.tencent.mm.z.c.EY().WO((String) this.qwQ.get(i));
        }
        aVar.jLe = xVar;
        aVar.ySW = this.qwR;
        return aVar;
    }

    public static boolean Jv(String str) {
        return bh.ov(str) ? false : str.endsWith("@sns.tencent");
    }

    public static boolean Jw(String str) {
        return bh.ov(str) ? false : str.endsWith("@search.tencent");
    }

    public static boolean Jx(String str) {
        return bh.ov(str) ? false : str.endsWith("@draft.tencent");
    }

    public final boolean btz() {
        return this.qwR;
    }
}
