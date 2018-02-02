package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.model.r;
import com.tencent.mm.plugin.card.ui.a.g;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Iterator;

public final class x extends i {
    private boolean kWX = false;
    private View kWY;
    private View kWZ;
    private ImageView kXa;
    private TextView kXb;
    private TextView kXc;
    private ImageView kXd;
    View kXe;
    private LinearLayout kXf;
    private OnClickListener kXg = new OnClickListener(this) {
        final /* synthetic */ x kXh;

        {
            this.kXh = r1;
        }

        public final void onClick(View view) {
            if (view.getTag() instanceof r) {
                b avI = this.kXh.kWz.avI();
                this.kXh.kWz.avK();
                r rVar = (r) view.getTag();
                if (rVar != null && rVar.kNA != null && !rVar.kNA.isEmpty()) {
                    if (rVar.kNz != null && rVar.kNz.equals(avI.atH())) {
                        this.kXh.kXe.setVisibility(8);
                        this.kXh.kWz.ava();
                    } else if (TextUtils.isEmpty(rVar.kNz) && TextUtils.isEmpty(avI.atH())) {
                        this.kXh.kXe.setVisibility(8);
                        this.kXh.kWz.ava();
                    } else {
                        boolean z;
                        ArrayList wo = com.tencent.mm.plugin.card.sharecard.a.b.wo(rVar.kJN);
                        if (wo == null || wo.size() <= 0) {
                            z = false;
                        } else {
                            z = false;
                            for (int i = 0; i < wo.size(); i++) {
                                r rVar2 = (r) wo.get(i);
                                if ((rVar2.kNz == null || !rVar2.kNz.equals(rVar.kNz)) && !(TextUtils.isEmpty(rVar2.kNz) && TextUtils.isEmpty(rVar.kNz))) {
                                    rVar2.kNB = false;
                                    wo.set(i, rVar2);
                                } else {
                                    rVar2.kNB = true;
                                    if (!rVar2.kNC) {
                                        rVar2.kNC = true;
                                        z = true;
                                    }
                                    wo.set(i, rVar2);
                                }
                            }
                        }
                        b wv = am.auI().wv((String) rVar.kNA.get(0));
                        if (wv != null) {
                            this.kXh.kWz.d(wv);
                        }
                        if (z && this.kXh.kWz.avO() != null) {
                            this.kXh.kWz.avO().avB();
                        }
                        this.kXh.kXe.setVisibility(8);
                    }
                }
            }
        }
    };
    MMActivity kaY;

    public final void initView() {
        this.kWY = findViewById(R.h.cNW);
        this.kWZ = findViewById(R.h.cNX);
        this.kXa = (ImageView) findViewById(R.h.cNQ);
        this.kXb = (TextView) findViewById(R.h.cNR);
        this.kXc = (TextView) findViewById(R.h.cNT);
        this.kXd = (ImageView) findViewById(R.h.cNS);
        this.kWY.setVisibility(8);
        this.kXe = findViewById(R.h.cNU);
        this.kXf = (LinearLayout) findViewById(R.h.cNV);
        this.kXe.setVisibility(8);
        this.kaY = this.kWz.avL();
    }

    public final void update() {
        b avI = this.kWz.avI();
        ArrayList wo = com.tencent.mm.plugin.card.sharecard.a.b.wo(avI.atG());
        g avN = this.kWz.avN();
        String str;
        if (avN.awF()) {
            this.kWY.setVisibility(0);
            if (com.tencent.mm.plugin.card.sharecard.a.b.wn(avI.atG()) > 1) {
                this.kWZ.setOnClickListener(this.kWz.avM());
            } else {
                this.kXd.setVisibility(8);
                this.kXe.setVisibility(8);
                this.kXf.removeAllViews();
                this.kWz.avK();
            }
            b avI2 = this.kWz.avI();
            if (this.kWz.avJ()) {
                this.kXa.setVisibility(8);
                this.kXb.setVisibility(8);
                this.kXc.setVisibility(0);
                this.kXd.setImageResource(R.g.bAu);
                this.kXc.setText(this.kaY.getString(R.l.dPm));
            } else {
                this.kXa.setVisibility(0);
                this.kXb.setVisibility(0);
                this.kXc.setVisibility(8);
                if (com.tencent.mm.plugin.card.sharecard.a.b.wn(avI2.atG()) <= 1) {
                    this.kXd.setVisibility(8);
                } else {
                    this.kXd.setVisibility(0);
                    this.kXd.setImageResource(R.g.bAt);
                }
                String str2 = "";
                if (wo != null && wo.size() > 0) {
                    for (int i = 0; i < wo.size(); i++) {
                        r rVar = (r) wo.get(i);
                        if (rVar.kNB) {
                            str = rVar.kNz;
                            break;
                        }
                    }
                }
                str = str2;
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(avI2.atH())) {
                    str = avI2.atH();
                }
                if (!TextUtils.isEmpty(str)) {
                    a.b.a(this.kXa, str);
                    this.kXb.setText(i.f(this.kaY, this.kaY.getString(R.l.dPq, new Object[]{l.wR(str)}), this.kaY.getResources().getDimensionPixelOffset(R.f.bvK)));
                }
            }
            if (this.kWz.avJ()) {
                this.kXe.setVisibility(0);
                r rVar2;
                ImageView imageView;
                if (this.kXf.getChildCount() != 0 || wo == null) {
                    for (int i2 = 0; i2 < this.kXf.getChildCount(); i2++) {
                        View childAt = this.kXf.getChildAt(i2);
                        rVar2 = (wo == null || wo.size() < this.kXf.getChildCount()) ? null : (r) wo.get(i2);
                        ImageView imageView2 = (ImageView) childAt.findViewById(R.h.cUg);
                        imageView = (ImageView) childAt.findViewById(R.h.cUf);
                        if (rVar2 == null || !rVar2.kNB) {
                            imageView2.setVisibility(8);
                            imageView.setVisibility(8);
                        } else {
                            imageView2.setVisibility(0);
                            imageView.setVisibility(0);
                        }
                    }
                    this.kXf.invalidate();
                } else {
                    LayoutInflater layoutInflater = (LayoutInflater) this.kaY.getSystemService("layout_inflater");
                    Iterator it = wo.iterator();
                    while (it.hasNext()) {
                        rVar2 = (r) it.next();
                        View inflate = layoutInflater.inflate(R.i.dsA, this.kXf, false);
                        ImageView imageView3 = (ImageView) inflate.findViewById(R.h.cUe);
                        TextView textView = (TextView) inflate.findViewById(R.h.cUj);
                        TextView textView2 = (TextView) inflate.findViewById(R.h.cNH);
                        if (!TextUtils.isEmpty(rVar2.kNz)) {
                            a.b.a(imageView3, rVar2.kNz);
                            CharSequence wR = l.wR(rVar2.kNz);
                            if (TextUtils.isEmpty(wR)) {
                                textView.setText("");
                            } else {
                                textView.setText(i.f(this.kaY, wR, this.kaY.getResources().getDimensionPixelOffset(R.f.bvW)));
                            }
                        }
                        textView2.setText("x " + rVar2.cNH);
                        inflate.setTag(rVar2);
                        inflate.setOnClickListener(this.kXg);
                        imageView = (ImageView) inflate.findViewById(R.h.cUg);
                        imageView3 = (ImageView) inflate.findViewById(R.h.cUf);
                        if (rVar2.kNB) {
                            imageView.setVisibility(0);
                            imageView3.setVisibility(0);
                        } else {
                            imageView.setVisibility(8);
                            imageView3.setVisibility(8);
                        }
                        this.kXf.addView(inflate);
                    }
                    this.kXf.invalidate();
                }
            } else {
                this.kXe.setVisibility(8);
                this.kXf.removeAllViews();
            }
            this.kWX = true;
        } else if (!avN.awF()) {
            this.kWY.setVisibility(0);
            this.kXa.setVisibility(0);
            this.kXb.setVisibility(0);
            this.kXc.setVisibility(8);
            this.kXd.setVisibility(8);
            str = "";
            if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(avI.atH())) {
                str = avI.atH();
            }
            if (!TextUtils.isEmpty(str)) {
                a.b.a(this.kXa, str);
                this.kXb.setText(i.f(this.kaY, this.kaY.getString(R.l.dPq, new Object[]{l.wR(str)}), this.kaY.getResources().getDimensionPixelOffset(R.f.bvK)));
            }
            this.kWX = true;
        }
    }

    public final void awW() {
        this.kWY.setVisibility(8);
    }
}
