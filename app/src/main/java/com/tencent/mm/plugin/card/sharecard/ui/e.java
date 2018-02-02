package com.tencent.mm.plugin.card.sharecard.ui;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.a.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;

public final class e {
    private ImageView fyg;
    View kOE;
    b kOF;
    protected LinearLayout kOG;
    protected LinearLayout kOH;
    private TextView kOI;
    private MMActivity kaY;

    public e(MMActivity mMActivity) {
        this.kaY = mMActivity;
    }

    public final void ave() {
        if (this.kOE == null) {
            this.kOE = View.inflate(this.kaY, R.i.dcv, null);
            this.fyg = (ImageView) this.kOE.findViewById(R.h.bJR);
            this.kOI = (TextView) this.kOE.findViewById(R.h.cOk);
            this.kOG = (LinearLayout) this.kOE.findViewById(R.h.ctv);
            this.kOH = (LinearLayout) this.kOE.findViewById(R.h.ctt);
            this.kOG.setVisibility(8);
            this.kOH.setVisibility(8);
            Animation rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setDuration(1000);
            rotateAnimation.setRepeatCount(-1);
            rotateAnimation.setInterpolator(new LinearInterpolator());
            this.fyg.startAnimation(rotateAnimation);
        }
        au();
    }

    public final void avf() {
        this.kOG.setVisibility(0);
        this.kOH.setVisibility(8);
    }

    public final void avg() {
        this.kOG.setVisibility(8);
    }

    private void avh() {
        this.kOG.setVisibility(8);
        this.kOH.setVisibility(8);
    }

    public final void avi() {
        avh();
        this.kOI.setVisibility(8);
    }

    public final void au() {
        Integer num = (Integer) am.auF().getValue("key_share_card_show_type");
        if (num == null) {
            num = Integer.valueOf(0);
        }
        if (this.kOF != null && b.auY() && ((r0.intValue() == 1 || r0.intValue() == 4) && b.auV())) {
            this.kOI.setVisibility(0);
        } else {
            this.kOI.setVisibility(8);
            if (this.kOF != null) {
                x.d("MicroMsg.ShareCardFooterController", "updateView isLocalEnd %s isOtherEnd %s ", new Object[]{Boolean.valueOf(b.auY()), Boolean.valueOf(b.auZ())});
                if (!b.auY() || !b.auZ()) {
                    avf();
                    return;
                } else if (b.auY() && b.auZ()) {
                    this.kOG.setVisibility(8);
                    this.kOH.setVisibility(8);
                    return;
                } else {
                    return;
                }
            }
        }
        avh();
    }
}
