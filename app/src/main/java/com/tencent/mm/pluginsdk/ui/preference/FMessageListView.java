package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bf.f;
import com.tencent.mm.bf.h;
import com.tencent.mm.bf.l;
import com.tencent.mm.g.a.ip;
import com.tencent.mm.g.b.af;
import com.tencent.mm.pluginsdk.d.a;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

public class FMessageListView extends LinearLayout {
    private Context context;
    private final LayoutParams nrZ;
    a$a vsW;
    private a vtd;
    private j.a vte;
    private j.a vtf;
    a vtg;
    a vth;
    private TextView vti;

    static /* synthetic */ void a(FMessageListView fMessageListView, String str) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.FMessageListView", "updateLbs, id is null");
            return;
        }
        long j;
        try {
            j = bh.getLong(str, 0);
        } catch (Exception e) {
            x.e("MicroMsg.FMessageListView", "updateLbs, id = " + str + ", ex = " + e.getMessage());
            j = 0;
        }
        if (j == 0) {
            x.e("MicroMsg.FMessageListView", "updateLbs fail, sysRowId is invalid");
            return;
        }
        x.d("MicroMsg.FMessageListView", "updateLbs succ, sysRowId = " + j);
        c hVar = new h();
        if (!l.Ty().b(j, hVar)) {
            x.e("MicroMsg.FMessageListView", "updateLbs, get fail, id = " + j);
        } else if (fMessageListView.vsW == null || !fMessageListView.vsW.talker.equals(hVar.field_sayhiuser)) {
            x.d("MicroMsg.FMessageListView", "updateLbs, other talker, no need to process");
        } else {
            if (fMessageListView.vsW.mOi != null && fMessageListView.vsW.mOi.length() > 0) {
                fMessageListView.setVisibility(0);
            }
            fMessageListView.a(b.a(fMessageListView.context, hVar));
        }
    }

    static /* synthetic */ void b(FMessageListView fMessageListView, String str) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.FMessageListView", "updateFMsg, id is null");
            return;
        }
        long j;
        try {
            j = bh.getLong(str, 0);
        } catch (Exception e) {
            x.e("MicroMsg.FMessageListView", "updateFMsg, id = " + str + ", ex = " + e.getMessage());
            j = 0;
        }
        if (j == 0) {
            x.e("MicroMsg.FMessageListView", "updateFMsg fail, sysRowId is invalid");
            return;
        }
        x.d("MicroMsg.FMessageListView", "updateFMsg succ, sysRowId = " + j);
        c fVar = new f();
        if (!l.Tw().b(j, fVar)) {
            x.e("MicroMsg.FMessageListView", "updateFMsg, get fail, id = " + j);
        } else if (fMessageListView.vsW == null || !fMessageListView.vsW.talker.equals(fVar.field_talker)) {
            x.d("MicroMsg.FMessageListView", "updateFMsg, other talker, no need to process");
        } else {
            if (fMessageListView.vsW.mOi != null && fMessageListView.vsW.mOi.length() > 0) {
                fMessageListView.setVisibility(0);
            }
            fMessageListView.a(b.a(fMessageListView.context, fVar));
        }
    }

    static /* synthetic */ void c(FMessageListView fMessageListView, String str) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.FMessageListView", "updateShake, id is null");
            return;
        }
        long j;
        try {
            j = bh.getLong(str, 0);
        } catch (Exception e) {
            x.e("MicroMsg.FMessageListView", "updateShake, id = " + str + ", ex = " + e.getMessage());
            j = 0;
        }
        if (j == 0) {
            x.e("MicroMsg.FMessageListView", "updateShake fail, sysRowId is invalid");
            return;
        }
        x.d("MicroMsg.FMessageListView", "updateShake succ, sysRowId = " + j);
        c jVar = new com.tencent.mm.bf.j();
        if (!l.Tz().b(j, jVar)) {
            x.e("MicroMsg.FMessageListView", "updateShake, get fail, id = " + j);
        } else if (fMessageListView.vsW == null || !fMessageListView.vsW.talker.equals(jVar.field_sayhiuser)) {
            x.d("MicroMsg.FMessageListView", "updateShake, other talker, no need to process");
        } else {
            if (fMessageListView.vsW.mOi != null && fMessageListView.vsW.mOi.length() > 0) {
                fMessageListView.setVisibility(0);
            }
            fMessageListView.a(b.a(fMessageListView.context, jVar));
        }
    }

    public FMessageListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FMessageListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.vtd = new 1(this);
        this.vte = new 2(this);
        this.vtf = new 3(this);
        this.nrZ = new LayoutParams(-1, -2);
        this.context = context;
        l.Tw().c(this.vte);
        a.a(ip.class.getName(), this.vtd);
        l.Tz().c(this.vtf);
    }

    public final void detach() {
        l.Tw().j(this.vte);
        a.b(ip.class.getName(), this.vtd);
        l.Tz().j(this.vtf);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof a) {
                a aVar = (a) childAt;
                ar.CG().b(30, aVar);
                if (aVar.tipDialog != null && aVar.tipDialog.isShowing()) {
                    aVar.tipDialog.dismiss();
                }
            }
        }
        this.vtg = null;
        this.vth = null;
    }

    public final void a(b bVar) {
        if (bVar == null) {
            x.e("MicroMsg.FMessageListView", "addItem fail, provider is null");
        } else if (bVar.id <= 0) {
            x.e("MicroMsg.FMessageListView", "addItem fail, systemRowId invalid = " + bVar.id);
        } else {
            int i;
            String string;
            int childCount = getChildCount();
            for (i = 1; i < childCount; i++) {
                View childAt = getChildAt(i);
                if ((childAt instanceof a) && childAt.getTag() != null && childAt.getTag().equals(Long.valueOf(bVar.id))) {
                    x.w("MicroMsg.FMessageListView", "addItem, item repeated, sysRowId = " + bVar.id);
                    return;
                }
            }
            if (bVar.vtm != null) {
                if (this.vti == null) {
                    this.vti = (TextView) findViewById(R.h.bXw);
                }
                this.vti.setText(bVar.vtm);
                this.vti.setVisibility(0);
            }
            x.d("MicroMsg.FMessageListView", "addItem, current child count = " + childCount);
            if (childCount == 6) {
                x.i("MicroMsg.FMessageListView", "addItem, most 3 FMessageItemView, remove earliest");
                removeViewAt(1);
            }
            if (childCount == 1) {
                x.d("MicroMsg.FMessageListView", "addItem, current child count is 0, add two child view");
                this.vtg = new a(this.context);
                addView(this.vtg);
                this.vth = new a(this.context);
                this.vth.SF("");
                this.vth.Cv(0);
                addView(this.vth, this.nrZ);
                ar.Hg();
                af WO = com.tencent.mm.z.c.EY().WO(bVar.username);
                if (WO == null || !com.tencent.mm.l.a.fZ(WO.field_type)) {
                    x.d("MicroMsg.FMessageListView", "addItem, reply btn visible, talker = " + bVar.username);
                    this.vtg.setVisibility(0);
                    this.vth.setVisibility(0);
                } else {
                    x.d("MicroMsg.FMessageListView", "addItem, reply btn gone, talker = " + bVar.username);
                    this.vtg.setVisibility(8);
                    this.vth.setVisibility(8);
                }
            }
            if (bVar.fLH) {
                string = this.context.getString(R.l.eij, new Object[]{bVar.hef});
                i = 0;
            } else {
                String str;
                if (bVar.fpL == null || bVar.fpL.length() <= 0) {
                    str = bVar.username;
                    ar.Hg();
                    com.tencent.mm.l.a WO2 = com.tencent.mm.z.c.EY().WO(bVar.username);
                    if (WO2 != null && ((int) WO2.gJd) > 0) {
                        str = WO2.AQ();
                    }
                } else {
                    str = bVar.fpL;
                }
                string = str + ": " + bVar.hef;
                i = 1;
            }
            View aVar = new a(this.context);
            aVar.setTag(Long.valueOf(bVar.id));
            aVar.SF(string);
            aVar.Cv(8);
            if (i != 0) {
                aVar.setOnLongClickListener(new 4(this, bVar));
            }
            addView(aVar, getChildCount() - 2, this.nrZ);
        }
    }
}
