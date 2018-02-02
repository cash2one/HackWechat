package com.tencent.mm.plugin.shake.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.shake.ui.ShakeItemListUI.a;

class ShakeItemListUI$a$a {
    ImageView hvY;
    TextView hvZ;
    TextView hwa;
    TextView oOY;
    TextView oOZ;
    ImageView oPa;
    final /* synthetic */ a qqE;
    View qqF;
    ImageView qqG;
    TextView qqH;
    LinearLayout qqI;
    TextView qqJ;

    ShakeItemListUI$a$a(a aVar) {
        this.qqE = aVar;
    }

    public final void clear() {
        if (this.hvY != null) {
            this.hvY.setImageDrawable(null);
            this.hvY.setVisibility(8);
        }
        if (this.hvZ != null) {
            this.hvZ.setText("");
            this.hvZ.setVisibility(8);
        }
        if (this.hwa != null) {
            this.hwa.setVisibility(8);
        }
        if (this.qqG != null) {
            this.qqG.setVisibility(8);
        }
        if (this.oOY != null) {
            this.oOY.setText("");
            this.oOY.setVisibility(8);
        }
        if (this.oOZ != null) {
            this.oOZ.setVisibility(8);
            this.qqF.setVisibility(8);
        }
        if (this.oPa != null) {
            this.oPa.setVisibility(8);
        }
        if (this.qqH != null) {
            this.qqH.setText("");
            this.qqH.setVisibility(8);
        }
    }
}
