package com.tencent.mm.plugin.card.ui;

import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMVerticalTextView;
import com.tencent.mm.ui.base.q;
import java.util.ArrayList;

public final class j {
    public Bitmap inI;
    public q inJ = null;
    public ImageView inK;
    View inL;
    OnClickListener inN = new 1(this);
    MMActivity iqt;
    b kIK;
    public Bitmap kNH;
    float kNP = 0.0f;
    boolean kRg = true;
    Bitmap kUY = null;
    TextView kUZ;
    TextView kVa;
    View kVb;
    ImageView kVc;
    MMVerticalTextView kVd;
    MMVerticalTextView kVe;
    ArrayList<Bitmap> kVf = new ArrayList();
    String kVg = "";

    public j(MMActivity mMActivity) {
        this.iqt = mMActivity;
    }

    private void af(float f) {
        LayoutParams attributes = this.iqt.getWindow().getAttributes();
        attributes.screenBrightness = f;
        this.iqt.getWindow().setAttributes(attributes);
    }

    public final void awg() {
        if (this.kNP < 0.8f) {
            af(0.8f);
        }
    }

    public final void awh() {
        af(this.kNP);
    }

    final void awi() {
        if (this.kVf.size() > 2) {
            for (int size = this.kVf.size() - 1; size > 1; size--) {
                l.u((Bitmap) this.kVf.remove(size));
            }
        }
    }
}
