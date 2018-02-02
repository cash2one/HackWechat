package com.tencent.mm.plugin.card.sharecard.ui;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.a.b;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.ui.MMActivity;

public final class i {
    private View kND;
    View kPk;
    TextView kPl;
    TextView kPm;
    private boolean kPn = false;
    MMActivity kaY;

    public i(MMActivity mMActivity, View view) {
        this.kaY = mMActivity;
        this.kND = view;
    }

    public final void au() {
        Integer num = (Integer) am.auF().getValue("key_share_card_show_type");
        if (num == null) {
            num = Integer.valueOf(0);
        }
        if (num.intValue() == 0 || b.auW()) {
            this.kPk.setVisibility(8);
            return;
        }
        this.kPk.setVisibility(0);
        this.kPl.setVisibility(0);
        ShareCardInfo shareCardInfo = new ShareCardInfo();
        if (TextUtils.isEmpty(shareCardInfo.nE(10))) {
            this.kPl.setVisibility(8);
        } else {
            this.kPl.setVisibility(0);
            this.kPl.setText(shareCardInfo.nE(10));
        }
        if (TextUtils.isEmpty("")) {
            this.kPm.setVisibility(8);
            return;
        }
        this.kPm.setVisibility(0);
        this.kPm.setText("");
    }
}
