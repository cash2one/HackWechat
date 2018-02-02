package com.tencent.mm.plugin.game.gamewebview.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.v;

public final class e extends LinearLayout {
    ImageView kQn;
    TextView lVg;
    private Context mContext;
    b mZP;
    ImageView mZQ;
    public i mZR;
    private a mZS;
    public i mZT = null;

    public e(b bVar) {
        super(bVar.getContext());
        this.mContext = bVar.getContext();
        this.mZP = bVar;
        this.mZR = new g(bVar);
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        setLayoutParams(new LayoutParams(-1, displayMetrics.widthPixels > displayMetrics.heightPixels ? this.mContext.getResources().getDimensionPixelSize(R.f.buF) : this.mContext.getResources().getDimensionPixelSize(R.f.buG)));
        setBackgroundResource(R.e.bre);
        View inflate = v.fv(getContext()).inflate(R.i.dlr, this, false);
        addView(inflate);
        this.kQn = (ImageView) inflate.findViewById(R.h.bIS);
        this.kQn.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ e mZU;

            {
                this.mZU = r1;
            }

            public final void onClick(View view) {
                if (!this.mZU.aPo()) {
                    this.mZU.mZP.aOZ();
                }
            }
        });
        this.lVg = (TextView) inflate.findViewById(R.h.title);
        this.mZQ = (ImageView) inflate.findViewById(R.h.bIT);
        this.mZQ.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ e mZU;

            {
                this.mZU = r1;
            }

            public final void onClick(View view) {
                this.mZU.mZR.aPz();
            }
        });
    }

    public final void xv(String str) {
        this.lVg.setText(str);
    }

    public final void aPz() {
        if (this.mZR != null) {
            this.mZR.aPz();
        }
    }

    public final void B(Bundle bundle) {
        this.mZS = bundle == null ? null : new a(bundle);
    }

    public final boolean aPo() {
        if (this.mZS != null) {
            a aVar = this.mZS;
            boolean z = (!aVar.mYj || bh.ov(aVar.aOS()) || bh.ov(aVar.aOT()) || bh.ov(aVar.aOU())) ? false : true;
            if (z) {
                x.i("MicroMsg.GameWebViewActionBar", "use js api close window confirm info : %s, %s, %s", this.mZS.aOS(), this.mZS.aOT(), this.mZS.aOU());
                View inflate = View.inflate(getContext(), R.i.dnm, null);
                CheckBox checkBox = (CheckBox) inflate.findViewById(R.h.cwc);
                checkBox.setChecked(false);
                checkBox.setVisibility(8);
                TextView textView = (TextView) inflate.findViewById(R.h.cwe);
                textView.setText(r6);
                textView.setTextColor(getResources().getColor(R.e.btv));
                textView = (TextView) inflate.findViewById(R.h.cwd);
                textView.setTextColor(getResources().getColor(R.e.btv));
                textView.setVisibility(8);
                this.mZT = h.a(getContext(), true, "", inflate, r4, r5, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ e mZU;

                    {
                        this.mZU = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.mZU.mZT = null;
                        this.mZU.mZP.aOZ();
                    }
                }, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ e mZU;

                    {
                        this.mZU = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.mZU.mZT = null;
                    }
                });
                return true;
            }
        }
        return false;
    }
}
