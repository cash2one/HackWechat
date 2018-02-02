package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.protocal.c.dp;
import com.tencent.mm.ui.base.k;

public class ArtistHeader extends LinearLayout implements b {
    Context context = null;
    private View jWc;
    private k mzO = null;
    dp rqI = null;
    a rqN;
    private ImageView rqO;
    private ProgressBar rqP;

    public ArtistHeader(Context context) {
        super(context);
        init(context);
    }

    public ArtistHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(g.qHb, this, true);
        this.context = context;
        this.rqN = new a(this);
        this.rqN.ihQ = (ImageView) inflate.findViewById(f.qBn);
        this.rqN.iXX = (TextView) inflate.findViewById(f.qzX);
        this.rqN.rqS = (TextView) inflate.findViewById(f.qAa);
        this.rqN.rqT = (TextView) inflate.findViewById(f.qzY);
        this.rqN.ihS = (TextView) inflate.findViewById(f.qzZ);
        this.rqN.ihQ.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ArtistHeader rqQ;

            {
                this.rqQ = r1;
            }

            public final void onClick(View view) {
                if ((this.rqQ.mzO == null || !this.rqQ.mzO.isShowing()) && this.rqQ.rqI != null) {
                    View inflate = LayoutInflater.from(this.rqQ.getContext()).inflate(g.lnV, null);
                    this.rqQ.mzO = new k(this.rqQ.getContext(), i.k.qMR);
                    inflate.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass1 rqR;

                        {
                            this.rqR = r1;
                        }

                        public final void onClick(View view) {
                            this.rqR.rqQ.mzO.dismiss();
                        }
                    });
                    this.rqQ.mzO.setCanceledOnTouchOutside(true);
                    this.rqQ.mzO.setContentView(inflate);
                    this.rqQ.mzO.show();
                    this.rqQ.rqO = (ImageView) inflate.findViewById(f.lnN);
                    this.rqQ.rqP = (ProgressBar) inflate.findViewById(f.lnO);
                    this.rqQ.jWc = inflate.findViewById(f.lnP);
                }
            }
        });
    }

    public final void JT(String str) {
    }

    public final void aE(String str, boolean z) {
        if (this.rqI != null && this.mzO != null && this.mzO.isShowing() && !z) {
            aqr com_tencent_mm_protocal_c_aqr = this.rqI.vIP.vIQ;
            if (com_tencent_mm_protocal_c_aqr.nGJ != null && com_tencent_mm_protocal_c_aqr.nGJ.equals(str)) {
                Toast.makeText(this.context, this.context.getString(j.qKx), 0).show();
            }
        }
    }

    public final void aF(String str, boolean z) {
    }

    public final void bun() {
    }
}
