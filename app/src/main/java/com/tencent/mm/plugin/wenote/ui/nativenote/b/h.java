package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.t;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.g.a.ko;
import com.tencent.mm.plugin.wenote.model.a.b;
import com.tencent.mm.plugin.wenote.model.a.n;
import com.tencent.mm.plugin.wenote.model.nativenote.c.e;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.c;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.sdk.platformtools.x;

public abstract class h extends a {
    public static float tYp = Resources.getSystem().getDisplayMetrics().density;
    public static int tYq = Resources.getSystem().getDisplayMetrics().widthPixels;
    public static int tYr = ((int) ((40.0f * tYp) + 0.5f));
    public ImageView fvf;
    public OnClickListener npY = new OnClickListener(this) {
        final /* synthetic */ h tYs;

        {
            this.tYs = r1;
        }

        public final void onClick(View view) {
            if (this.tYs.tWs.bWY() != null) {
                x.e("Micromsg.NoteOtherItemHolder", "click item , now is editing, quit it");
                return;
            }
            if (this.tYs.tWs.tUp == 2) {
                this.tYs.tWs.tUc.bXJ().bWk();
                this.tYs.tWs.bXb();
            }
            int ge = ((t) view.getTag()).ge();
            ko koVar = new ko();
            if (c.bWp().Bt(ge) == null) {
                x.e("Micromsg.NoteOtherItemHolder", "click not response, null == NoteDataManager.getMgr().get(position),position is %d,datalist size = %d", new Object[]{Integer.valueOf(ge), Integer.valueOf(c.bWp().size())});
            } else if (com.tencent.mm.plugin.wenote.model.c.bVN().tQn == null) {
                x.e("Micromsg.NoteOtherItemHolder", "getWnNoteBase is null");
            } else {
                x.i("Micromsg.NoteOtherItemHolder", "click item, type is %d", new Object[]{Integer.valueOf(c.bWp().Bt(ge).getType())});
                koVar.fBM.fBO = ((n) c.bWp().Bt(ge)).tRP;
                koVar.fBM.context = view.getContext();
                koVar.fBM.type = 1;
                com.tencent.mm.plugin.wenote.model.c.bVN().tQn.b(koVar);
            }
        }
    };
    public WXRTEditText tYa;
    public WXRTEditText tYb;
    public LinearLayout tYc;
    public TextView tYd;
    public TextView tYe;
    public ImageView tYf;
    public View tYg;
    public LinearLayout tYh;
    public LinearLayout tYi;
    public LinearLayout tYj;
    public LinearLayout tYk;
    public LinearLayout tYl;
    public LinearLayout tYm;
    public LinearLayout tYn;
    public LinearLayout tYo;

    public h(View view, k kVar) {
        super(view, kVar);
        this.fvf = (ImageView) view.findViewById(R.h.cdg);
        this.tYg = view.findViewById(R.h.cUG);
        this.tYc = (LinearLayout) view.findViewById(R.h.cAK);
        this.tYh = (LinearLayout) view.findViewById(R.h.cBd);
        this.tYd = (TextView) view.findViewById(R.h.cAL);
        this.tYe = (TextView) view.findViewById(R.h.cAI);
        this.tYf = (ImageView) view.findViewById(R.h.cAJ);
        this.tYd.setTextSize(16.0f);
        this.tYe.setTextSize(12.0f);
        this.tYi = (LinearLayout) view.findViewById(R.h.cBb);
        this.tYi.setVisibility(8);
        this.tYk = (LinearLayout) view.findViewById(R.h.cAW);
        this.tYk.setVisibility(8);
        this.tYl = (LinearLayout) view.findViewById(R.h.cAH);
        this.tYl.setVisibility(8);
        this.tYm = (LinearLayout) view.findViewById(R.h.cBU);
        this.tYm.setBackgroundColor(1347529272);
        this.tYm.setVisibility(8);
        this.tYm.setOnClickListener(new 1(this));
        this.tYn = (LinearLayout) view.findViewById(R.h.cBY);
        this.tYn.setBackgroundColor(1347529272);
        this.tYn.setVisibility(4);
        this.tYo = (LinearLayout) view.findViewById(R.h.cBW);
        this.tYo.setBackgroundColor(1347529272);
        this.tYo.setVisibility(4);
        this.tYj = (LinearLayout) view.findViewById(R.h.cdi);
        LayoutParams layoutParams = (LayoutParams) this.tYj.getLayoutParams();
        layoutParams.width = tYq - tYr;
        layoutParams.height = -2;
        this.tYj.setLayoutParams(layoutParams);
        this.tYb = (WXRTEditText) view.findViewById(R.h.bOZ);
        this.tYa = (WXRTEditText) view.findViewById(R.h.bPb);
        ((LinearLayout) view.findViewById(R.h.bPa)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ h tYs;

            {
                this.tYs = r1;
            }

            public final void onClick(View view) {
                this.tYs.tYb.bWL();
                this.tYs.tYb.requestFocus();
            }
        });
        ((LinearLayout) view.findViewById(R.h.bPc)).setOnClickListener(new 3(this));
        this.tYb.tTw = 2;
        this.tYa.tTw = 1;
        this.tYa.tTy = this;
        this.tYb.tTy = this;
        if (!(kVar.tUp == 2 && this.tWs.tUq)) {
            this.tYb.setKeyListener(null);
            this.tYb.setEnabled(false);
            this.tYb.setFocusable(false);
            this.tYa.setKeyListener(null);
            this.tYa.setEnabled(false);
            this.tYa.setFocusable(false);
        }
        this.tWs.o(this.tYa);
        this.tWs.o(this.tYb);
    }

    public void a(b bVar, int i, int i2) {
        x.i("Micromsg.NoteOtherItemHolder", "ImageItemHolder position is " + gd());
        this.tYa.tTJ = i;
        this.tYb.tTJ = i;
        if (e.isEnabled()) {
            e.bXf().a(this.tYm, this.tYn, this.tYo, i);
        }
        bVar.tRw = this.tYa;
        bVar.tRx = this.tYb;
        bVar.tRy = null;
        if (!bVar.tRt) {
            if (this.tYa.hasFocus()) {
                this.tYa.clearFocus();
            }
            if (this.tYb.hasFocus()) {
                this.tYb.clearFocus();
            }
        } else if (bVar.tRz) {
            this.tYa.requestFocus();
        } else {
            this.tYb.requestFocus();
        }
        if (this.tYc.getVisibility() != 0) {
            return;
        }
        if (bVar.tRA) {
            this.tYc.setBackgroundResource(R.g.bHX);
        } else {
            this.tYc.setBackgroundResource(R.g.bHW);
        }
    }
}
