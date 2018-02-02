package com.tencent.mm.plugin.location.ui;

import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.g.a.cf;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.MMTextInputUI;

public class RemarkUI extends MMTextInputUI {
    protected final int getLayoutId() {
        return R.i.dqJ;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.ete);
        CharSequence stringExtra = getIntent().getStringExtra("Kwebmap_locaion");
        if (bh.ov(stringExtra)) {
            findViewById(R.h.ctR).setVisibility(8);
        } else {
            ((TextView) findViewById(R.h.cud)).setText(stringExtra);
        }
    }

    protected final void y(CharSequence charSequence) {
        long longExtra = getIntent().getLongExtra("kFavInfoLocalId", -1);
        if (longExtra > 0) {
            String charSequence2 = charSequence == null ? "" : charSequence.toString();
            x.i("MicroMsg.MMTextInputUI", "same remark[%s]", new Object[]{charSequence2});
            if (!charSequence2.equals(getIntent().getStringExtra("kRemark"))) {
                b cfVar = new cf();
                cfVar.fqp.type = -2;
                cfVar.fqp.fqf = Long.toString(longExtra);
                cfVar.fqp.desc = charSequence2;
                x.d("MicroMsg.MMTextInputUI", "update location remark, favlocalid is %s, remark is %s", new Object[]{cfVar.fqp.fqf, cfVar.fqp.desc});
                a.xef.m(cfVar);
            }
        }
    }
}
