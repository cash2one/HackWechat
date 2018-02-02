package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.comm.a.c;
import com.tencent.mm.plugin.comm.a.e;
import com.tencent.mm.plugin.comm.a.f;
import com.tencent.mm.pluginsdk.ui.applet.i.3;
import com.tencent.mm.pluginsdk.ui.applet.i.4;
import com.tencent.mm.pluginsdk.ui.applet.i.b;
import com.tencent.mm.pluginsdk.ui.d;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.ArrayList;
import java.util.List;

public class ContactListExpandPreference extends Preference {
    private int vok = -1;
    public g vol;
    public i vom;

    public interface a {
        void axM();

        void od(int i);

        void oe(int i);

        void of(int i);
    }

    public ContactListExpandPreference(Context context, int i) {
        super(context);
        if (i == 0) {
            caX();
        } else if (i == 1) {
            this.vok = 1;
            this.vom = new i();
        }
        setLayoutResource(f.lnU);
    }

    public ContactListExpandPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        caX();
        setLayoutResource(f.lnU);
    }

    public ContactListExpandPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        caX();
        setLayoutResource(f.lnU);
    }

    private void caX() {
        this.vok = 0;
        this.vol = new g(this.mContext);
    }

    public final void onBindView(View view) {
        if (this.vok == 1) {
            i iVar = this.vom;
            ViewGroup viewGroup = view.getId() == e.lnM ? (ViewGroup) view : (ViewGroup) view.findViewById(e.lnM);
            if (iVar.row == 0) {
                viewGroup.setPadding(viewGroup.getPaddingLeft(), viewGroup.getResources().getDimensionPixelSize(c.bvy), viewGroup.getPaddingRight(), viewGroup.getResources().getDimensionPixelSize(c.bvB));
            } else if (iVar.row == (iVar.vnx.getCount() / h.vnH) - 1) {
                viewGroup.setPadding(viewGroup.getPaddingLeft(), viewGroup.getPaddingTop(), viewGroup.getPaddingRight(), viewGroup.getResources().getDimensionPixelSize(c.bvy));
            } else {
                viewGroup.setPadding(viewGroup.getPaddingLeft(), viewGroup.getResources().getDimensionPixelSize(c.bvB), viewGroup.getPaddingRight(), viewGroup.getResources().getDimensionPixelSize(c.bvB));
            }
            if ((iVar.vnx.vnR % h.vnH == h.vnH - 1 || iVar.vnx.vnR % h.vnH == 0) && iVar.kZP && iVar.row == (iVar.vnx.getCount() / h.vnH) - 1) {
                viewGroup.setPadding(viewGroup.getPaddingLeft(), viewGroup.getPaddingTop(), viewGroup.getPaddingRight(), 0);
            } else if (!iVar.kZP && iVar.vnx.vnR % h.vnH == 0 && iVar.row == (iVar.vnx.getCount() / h.vnH) - 1) {
                viewGroup.setPadding(viewGroup.getPaddingLeft(), viewGroup.getPaddingTop(), viewGroup.getPaddingRight(), (int) viewGroup.getContext().getResources().getDimension(c.bvS));
            }
            if (iVar.vnx != null) {
                int i;
                viewGroup.setOnClickListener(iVar.pGO);
                if (viewGroup.getChildCount() > h.vnH) {
                    int childCount = viewGroup.getChildCount();
                    for (i = 0; i < childCount - h.vnH; i++) {
                        viewGroup.removeViewAt(i);
                    }
                    viewGroup.requestLayout();
                }
                for (i = 0; i < iVar.von; i++) {
                    View inflate;
                    int dimensionPixelSize;
                    if (viewGroup.getChildAt(i) == null) {
                        inflate = View.inflate(viewGroup.getContext(), f.dqQ, null);
                        viewGroup.addView(inflate);
                    } else {
                        inflate = viewGroup.getChildAt(i);
                    }
                    LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    if (h.vnH == 4) {
                        dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(c.bvJ);
                        layoutParams.setMargins(dimensionPixelSize, 0, dimensionPixelSize, 0);
                    } else {
                        dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(c.bvB);
                        layoutParams.setMargins(dimensionPixelSize, 0, dimensionPixelSize, 0);
                    }
                    if (!iVar.vnx.caV() && iVar.vnx.vnR == 1) {
                        dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(c.buv);
                        layoutParams.setMargins(dimensionPixelSize, 0, dimensionPixelSize, 0);
                    }
                    inflate.setLayoutParams(layoutParams);
                    int i2 = (iVar.row * iVar.von) + i;
                    iVar.vnx.getView(i2, inflate, viewGroup);
                    if (iVar.vnD != null) {
                        inflate.setOnClickListener(new 3(iVar, viewGroup, i2));
                    }
                    if (iVar.voo != null) {
                        inflate.setOnLongClickListener(new 4(iVar, viewGroup, i2));
                    }
                }
                if (iVar.vnx.caV() || iVar.vnx.vnR > 1) {
                    ((LinearLayout) viewGroup).setGravity(17);
                } else {
                    ((LinearLayout) viewGroup).setGravity(19);
                }
            }
        }
        super.onBindView(view);
    }

    public final void a(com.tencent.mm.ui.base.preference.f fVar, String str) {
        if (this.vol != null) {
            g gVar = this.vol;
            if (fVar != null && str != null) {
                gVar.ilB = fVar;
                gVar.vnt = str;
                fVar.bk(str, true);
            }
        }
    }

    public final void a(d dVar) {
        if (this.vol != null) {
            this.vol.vnx.vnS = dVar;
        }
    }

    public final void notifyChanged() {
        if (this.vol != null) {
            this.vol.blx();
        }
    }

    public final void n(String str, List<String> list) {
        if (this.vol != null) {
            g gVar = this.vol;
            gVar.username = str;
            if (list == null) {
                list = new ArrayList(0);
            }
            gVar.vnx.bS(list);
            gVar.DP(str);
        }
    }

    public final void ad(ArrayList<x> arrayList) {
        if (this.vol != null) {
            g gVar = this.vol;
            gVar.vnx.ac(arrayList);
            gVar.DP(null);
        }
    }

    public final void caY() {
        if (this.vol != null) {
            this.vol.vnx.voe = false;
        }
    }

    public final void St(String str) {
        if (this.vol != null) {
            this.vol.vnx.vnZ = str;
        }
    }

    public final boolean Ca(int i) {
        if (this.vol != null) {
            return this.vol.vnx.Ca(i);
        }
        return false;
    }

    public final Object getItem(int i) {
        if (this.vol == null || !this.vol.vnx.Ca(i)) {
            return null;
        }
        return this.vol.vnx.getItem(i);
    }

    public final String Cb(int i) {
        if (this.vol == null || !this.vol.vnx.Ca(i)) {
            return "";
        }
        return ((x) this.vol.vnx.getItem(i)).field_username;
    }

    public final String Cc(int i) {
        if (this.vol == null || !this.vol.vnx.Ca(i)) {
            return "";
        }
        return ((x) this.vol.vnx.getItem(i)).field_nickname;
    }

    public final String Cd(int i) {
        if (this.vol == null || !this.vol.vnx.Ca(i)) {
            return "";
        }
        return ((x) this.vol.vnx.getItem(i)).field_conRemark;
    }

    public final void caZ() {
        if (this.vol != null) {
            h hVar = this.vol.vnx;
            hVar.lbP = false;
            hVar.notifyChanged();
        }
    }

    public final ContactListExpandPreference la(boolean z) {
        if (this.vol != null) {
            this.vol.vnx.vnU = z;
        }
        return this;
    }

    public final ContactListExpandPreference lb(boolean z) {
        if (this.vol != null) {
            this.vol.vnx.vnT = z;
        }
        return this;
    }

    public final ContactListExpandPreference cba() {
        if (this.vol != null) {
            this.vol.vnx.vnV = false;
        }
        return this;
    }

    public final void cbb() {
        boolean z = false;
        if (this.vol != null) {
            g gVar = this.vol;
            gVar.vnv = false;
            if (gVar.vnv) {
                z = true;
            }
            gVar.vnw = z;
        }
    }

    public final void refresh() {
        if (this.vol != null) {
            this.vol.vnx.notifyChanged();
        }
    }

    public final void bb(List<String> list) {
        if (this.vol != null) {
            h hVar = this.vol.vnx;
            hVar.bS(list);
            hVar.notifyChanged();
        }
    }

    public final void a(b bVar) {
        if (this.vol != null) {
            this.vol.vny = bVar;
        }
    }

    public final void a(a aVar) {
        if (this.vol != null) {
            this.vol.rUx = aVar;
        }
    }
}
