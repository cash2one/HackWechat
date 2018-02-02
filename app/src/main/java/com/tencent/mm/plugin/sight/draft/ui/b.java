package com.tencent.mm.plugin.sight.draft.ui;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.modelvideo.j;
import com.tencent.mm.modelvideo.k;
import com.tencent.mm.plugin.sight.decode.a.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.ui.o;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.HashSet;
import java.util.Set;

public final class b extends o<j> {
    private int kVD;
    private int kYJ;
    private d qvA = d.qvJ;
    a qvB;
    private int qvC = R.l.ePF;
    int qvD = 0;
    private int qvE;
    private int qvF;
    private c qvG = new 1(this);
    e qvH;
    a qvw = new a(this, (byte) 0);
    private b qvx = new b(this, (byte) 0);
    private c qvy = new c(this, (byte) 0);
    private Set<e> qvz = new HashSet();

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        obj = (j) obj;
        if (obj == null) {
            obj = new j();
        }
        obj.b(cursor);
        return obj;
    }

    public b(Context context, a aVar) {
        super(context, null);
        this.qvB = aVar;
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.f.bya) * 2;
        this.qvE = context.getResources().getDisplayMetrics().widthPixels / 3;
        this.kYJ = this.qvE - dimensionPixelSize;
        this.kVD = (this.kYJ * 3) / 4;
        this.qvF = dimensionPixelSize + this.kVD;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        f fVar;
        if (view == null) {
            f fVar2 = new f((byte) 0);
            view = new LinearLayout(viewGroup.getContext());
            view.setOrientation(0);
            for (int i2 = 0; i2 < 3; i2++) {
                View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.i.dsJ, view, false);
                e eVar = new e((byte) 0);
                eVar.lWv = inflate;
                eVar.lWv.setTag(eVar);
                eVar.qvM = inflate.findViewById(R.h.cOr);
                eVar.qvN = (a) inflate.findViewById(R.h.cOv);
                eVar.myd = (ImageView) inflate.findViewById(R.h.cOw);
                eVar.qvO = inflate.findViewById(R.h.cMA);
                eVar.jCQ = (TextView) inflate.findViewById(R.h.cOu);
                eVar.jCQ.setText(this.qvC);
                eVar.qlw = (ImageView) inflate.findViewById(R.h.cOo);
                fVar2.qvQ.add(eVar);
                LayoutParams layoutParams = (LayoutParams) inflate.getLayoutParams();
                layoutParams.weight = 1.0f;
                layoutParams.height = this.qvF;
                view.addView(inflate);
                inflate.setOnClickListener(this.qvw);
                eVar.qlw.setTag(eVar);
                eVar.qlw.setOnClickListener(this.qvy);
            }
            view.setTag(fVar2);
            fVar = fVar2;
        } else {
            fVar = (f) view.getTag();
        }
        for (int i3 = 0; i3 < fVar.qvQ.size(); i3++) {
            int i4 = (i * 3) + i3;
            e eVar2 = (e) fVar.qvQ.get(i3);
            this.qvz.add(eVar2);
            eVar2.qvO.setVisibility(8);
            eVar2.jCQ.setVisibility(8);
            eVar2.myd.setBackgroundResource(R.g.bGg);
            eVar2.qvN.aA(null, false);
            eVar2.qvN.hY(false);
            eVar2.qvN.bsH();
            ((ImageView) eVar2.qvN).setBackgroundResource(0);
            if (i4 >= aCQ()) {
                eVar2.qvP = null;
                eVar2.lWv.setVisibility(4);
                com.tencent.mm.ui.tools.j.m(eVar2.qvM, 1.0f);
            } else {
                this.qvD--;
                j jVar = (j) getItem(i4);
                ar.Hg();
                if (c.isSDCardAvailable()) {
                    boolean z;
                    eVar2.qvP = jVar;
                    c cVar = this.qvG;
                    String str = jVar.field_fileName;
                    String nl = k.nl(jVar.field_fileName);
                    if (this.qvD <= 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    Bitmap n = cVar.n(str, nl, z);
                    ((ImageView) eVar2.qvN).setScaleType(ScaleType.CENTER_CROP);
                    eVar2.qvN.B(n);
                } else {
                    eVar2.qvP = null;
                    eVar2.qvN.bsD();
                }
                if (d.qvK == this.qvA) {
                    eVar2.qlw.setVisibility(0);
                    com.tencent.mm.ui.tools.j.m(eVar2.qvM, 0.95f);
                } else {
                    eVar2.qlw.setVisibility(8);
                    com.tencent.mm.ui.tools.j.m(eVar2.qvM, 1.0f);
                }
                eVar2.lWv.setVisibility(0);
            }
        }
        return view;
    }

    final void a(e eVar) {
        if (eVar == null) {
            for (e eVar2 : this.qvz) {
                eVar2.qvO.setVisibility(8);
            }
            return;
        }
        for (e eVar22 : this.qvz) {
            eVar22.qvO.setVisibility(eVar == eVar22 ? 8 : 0);
        }
    }

    public final boolean a(d dVar, boolean z) {
        if (dVar == this.qvA) {
            if (z && this.qvB != null) {
                this.qvB.btm();
            }
            return false;
        }
        this.qvA = dVar;
        this.qvw.btn();
        notifyDataSetChanged();
        if (z && this.qvB != null) {
            this.qvB.btm();
        }
        return true;
    }

    public final void a(String str, l lVar) {
        this.qvz.clear();
        super.a(str, lVar);
    }

    public final void Xy() {
        Xz();
        super.notifyDataSetChanged();
    }

    protected final void Xz() {
        setCursor(com.tencent.mm.modelvideo.o.TY().gJP.rawQuery("SELECT * FROM SightDraftInfo WHERE fileStatus = ?  ORDER BY localId DESC ", new String[]{"1"}));
    }

    public final int getCount() {
        return (super.getCount() / 3) + 1;
    }
}
