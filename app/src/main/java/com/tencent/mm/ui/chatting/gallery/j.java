package com.tencent.mm.ui.chatting.gallery;

import android.annotation.TargetApi;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.util.HashMap;

public final class j {
    String fzO = "";
    String fzR;
    long hVE;
    public int mPosition;
    public View mUL;
    public TextView mwd;
    int rkQ = 0;
    public b yDo;
    public b$b yGa;
    public HashMap<String, Boolean> yGb = new HashMap();
    public RelativeLayout yGc;
    public f yGd;
    public ImageView yGe;
    public ImageView yGf;
    public MMPinProgressBtn yGg;
    public View yGh;
    public RelativeLayout yGi;
    public ImageView yGj;
    public ImageView yGk;
    public f yGl;
    public MMPinProgressBtn yGm;
    public TextView yGn;
    public LinearLayout yGo;
    public TextView yGp;
    public TextView yGq;
    public ImageView yGr;
    public ProgressBar yGs;
    public ProgressBar yGt;
    public LinearLayout yGu;
    public TextView yGv;
    public ImageView yGw;
    public MultiTouchImageView yGx;
    int yGy = 0;
    int yGz = 0;

    @TargetApi(11)
    public j(b bVar, View view) {
        this.mUL = view;
        this.yDo = bVar;
        this.yGx = (MultiTouchImageView) view.findViewById(R.h.image);
        this.yGt = (ProgressBar) view.findViewById(R.h.cpb);
        if (d.fM(11) && view.getLayerType() != 2) {
            view.setLayerType(2, null);
        }
    }

    public static void N(View view, int i) {
        if (view != null) {
            view.setVisibility(i);
        }
    }

    public final j cvi() {
        if (this.yGo == null) {
            this.yGo = (LinearLayout) ((ViewStub) this.mUL.findViewById(R.h.cpe)).inflate();
            this.yGs = (ProgressBar) this.yGo.findViewById(R.h.ccV);
            this.yGp = (TextView) this.yGo.findViewById(R.h.ccW);
            this.yGq = (TextView) this.yGo.findViewById(R.h.ccU);
            this.yGr = (ImageView) this.yGo.findViewById(R.h.ccX);
        }
        return this;
    }

    public final j cvj() {
        if (this.yGu == null) {
            this.yGu = (LinearLayout) ((ViewStub) this.mUL.findViewById(R.h.cpc)).inflate();
            this.yGw = (ImageView) this.yGu.findViewById(R.h.ccB);
            this.yGv = (TextView) this.yGu.findViewById(R.h.ccC);
        }
        return this;
    }

    public final j cvk() {
        if (this.yGc == null) {
            this.yGc = (RelativeLayout) ((ViewStub) this.mUL.findViewById(R.h.cOs)).inflate();
            this.yGd = n.er(this.mUL.getContext());
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(13);
            this.yGc.addView((View) this.yGd, layoutParams);
            ((View) this.yGd).setVisibility(8);
            this.yGh = this.yGc.findViewById(R.h.cSe);
            this.yGh.setVisibility(8);
            this.mwd = (TextView) this.yGc.findViewById(R.h.cOg);
            this.yGg = (MMPinProgressBtn) this.yGc.findViewById(R.h.cOp);
            this.yGg.setVisibility(8);
            this.yGe = (ImageView) this.yGc.findViewById(R.h.cOq);
            this.yGf = (ImageView) this.yGc.findViewById(R.h.cVG);
            this.yGd.a(new 1(this));
            this.mwd.setOnClickListener(new 2(this));
        }
        return this;
    }

    public final j cvl() {
        if (this.yGi == null) {
            this.yGi = (RelativeLayout) ((ViewStub) this.mUL.findViewById(R.h.cVu)).inflate();
            this.yGj = (ImageView) this.yGi.findViewById(R.h.cUX);
            this.yGk = (ImageView) this.yGi.findViewById(R.h.cVF);
            this.yGk.setOnClickListener(new 3(this));
            com.tencent.mm.modelcontrol.d.MU();
            if (com.tencent.mm.modelcontrol.d.Nb()) {
                this.yGl = new VideoPlayerTextureView(this.mUL.getContext());
                g.pQN.a(354, 150, 1, false);
            } else {
                this.yGl = new VideoTextureView(this.mUL.getContext());
                g.pQN.a(354, 151, 1, false);
            }
            this.yGn = (TextView) this.mUL.findViewById(R.h.car);
            this.yGl.id(true);
            this.yGi.addView((View) this.yGl, 2, new RelativeLayout.LayoutParams(-1, -1));
            this.yGm = (MMPinProgressBtn) this.yGi.findViewById(R.h.cUR);
            this.yGm.setVisibility(8);
            ((View) this.yGl).setVisibility(8);
            this.yGl.a(new 4(this));
        }
        return this;
    }

    public final void a(boolean z, float f) {
        x.i("MicroMsg.ImageGalleryViewHolder", "%d switch video model isVideoPlay[%b] alpha[%f]", new Object[]{Integer.valueOf(hashCode()), Boolean.valueOf(z), Float.valueOf(f)});
        if (z) {
            View view = (View) cvl().yGl;
            view.setAlpha(f);
            N(view, 0);
            if (((double) f) >= 1.0d) {
                N(cvl().yGj, 8);
                N(cvl().yGk, 8);
                return;
            }
            return;
        }
        N((View) cvl().yGl, 8);
        N(cvl().yGj, 0);
        N(cvl().yGk, 0);
    }
}
