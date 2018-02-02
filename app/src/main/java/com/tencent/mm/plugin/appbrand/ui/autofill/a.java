package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.modelappbrand.a.f;
import com.tencent.mm.plugin.appbrand.q.d;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.protocal.c.bik;
import com.tencent.mm.protocal.c.eb;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.b;
import com.tencent.mm.ui.u;
import com.tencent.mm.ui.v;

public final class a extends u {
    private TextView iXX;
    private TextView jNA;
    private LinearLayout jNB;
    private View jNC;
    private TextView jND;
    private TextView jNE;
    private ImageView jNs;
    AppBrandIDCardUI$a jNt;
    private LinearLayout jNu;
    private View jNv;
    private RecyclerView jNw;
    private TextView jNx;
    private Button jNy;
    private TextView jNz;
    private b mActionBarHelper;

    protected final void dealContentView(View view) {
        if (this.jNt == null || this.jNt.ala() == null) {
            x.e("MicroMsg.AppBrandIDCardShowFrag", "idCardUILogic or idCardUILogic.getIDCardShowInfo() is null, err");
            return;
        }
        this.jNu = (LinearLayout) view.findViewById(g.iub);
        this.jNs = (ImageView) view.findViewById(g.itY);
        this.iXX = (TextView) view.findViewById(g.itX);
        this.jNw = (RecyclerView) view.findViewById(g.iuc);
        this.jNx = (TextView) view.findViewById(g.itV);
        this.jNy = (Button) view.findViewById(g.itW);
        this.jNz = (TextView) view.findViewById(g.iud);
        this.jNA = (TextView) view.findViewById(g.iuS);
        this.jNB = (LinearLayout) view.findViewById(g.itU);
        this.jNC = view.findViewById(g.iug);
        this.jND = (TextView) view.findViewById(g.iue);
        this.jNE = (TextView) view.findViewById(g.iuf);
        this.jNv = v.fv(getContext()).inflate(h.cZW, null);
        this.jNv.setBackgroundColor(getResources().getColor(d.bre));
        this.mActionBarHelper = new b(this.jNv);
        this.jNu.addView(this.jNv, 0, new LayoutParams(-1, com.tencent.mm.plugin.appbrand.widget.a.ci(getActivity())));
        bik ala = this.jNt.ala();
        this.mActionBarHelper.setTitle(ala.title);
        this.mActionBarHelper.p(new 1(this));
        com.tencent.mm.modelappbrand.a.b.Jj().a(this.jNs, ala.wBK, com.tencent.mm.modelappbrand.a.a.Ji(), f.hkr);
        this.iXX.setText(ala.hcp + " " + ala.wLQ);
        if (ala.wLR != null) {
            this.jNw.setVisibility(0);
            RecyclerView recyclerView = this.jNw;
            getContext();
            recyclerView.a(new LinearLayoutManager());
            this.jNw.a(new a(ala.wLR));
        } else {
            x.e("MicroMsg.AppBrandIDCardShowFrag", "idCardShowInfo.user_id_list is null");
            this.jNw.setVisibility(8);
        }
        this.jNx.setText(ala.wLS);
        if (bh.ov(ala.wLT)) {
            this.jNy.setText(ala.wLT);
            this.jNz.setText(getString(j.izB, new Object[]{ala.wLT}));
        } else {
            this.jNy.setText(getString(j.izA));
            this.jNz.setText(getString(j.izB, new Object[]{getString(j.izA)}));
        }
        this.jNy.setOnClickListener(new 2(this));
        if (ala.wLU != null) {
            this.jNA.setText(ala.wLU.name);
            this.jNA.setOnClickListener(new 3(this, ala));
        }
        if (ala.wLV != null) {
            x.d("MicroMsg.AppBrandIDCardShowFrag", "idCardShowInfo.jump_list size:%d", new Object[]{Integer.valueOf(ala.wLV.size())});
            if (ala.wLV.size() == 0) {
                this.jNB.setVisibility(8);
            } else if (ala.wLV.size() == 1) {
                this.jNB.setVisibility(0);
                this.jNC.setVisibility(8);
                this.jNE.setVisibility(8);
                if (ala.wLV.get(0) != null) {
                    this.jND.setText(((eb) ala.wLV.get(0)).name);
                    this.jND.setOnClickListener(new 4(this, ala));
                }
            } else {
                this.jNB.setVisibility(0);
                this.jNC.setVisibility(0);
                this.jNE.setVisibility(0);
                if (ala.wLV.get(0) != null) {
                    this.jND.setText(((eb) ala.wLV.get(0)).name);
                    this.jND.setOnClickListener(new 5(this, ala));
                }
                if (ala.wLV.get(1) != null) {
                    this.jNE.setText(((eb) ala.wLV.get(1)).name);
                    this.jNE.setOnClickListener(new 6(this, ala));
                }
            }
        }
    }

    public final boolean noActionBar() {
        return true;
    }

    public final boolean supportNavigationSwipeBack() {
        return false;
    }

    protected final int getLayoutId() {
        return h.iwV;
    }

    public final void onSwipeBack() {
        if (this.jNt != null) {
            this.jNt.onSwipeBack();
        }
    }
}
