package com.tencent.mm.plugin.webwx.ui;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMBaseActivity;

public class WebWXPopupUnlockUI extends MMBaseActivity {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent() != null) {
            CharSequence stringExtra = getIntent().getStringExtra("deviceName");
            if (stringExtra != null) {
                Dialog dialog = new Dialog(this);
                dialog.requestWindowFeature(1);
                View inflate = View.inflate(this, R.i.dhl, null);
                TextView textView = (TextView) inflate.findViewById(R.h.cbv);
                ((TextView) inflate.findViewById(R.h.cTK)).setOnClickListener(new 1(this, dialog));
                dialog.setOnDismissListener(new 2(this));
                textView.setText(stringExtra);
                dialog.setContentView(inflate);
                dialog.show();
                return;
            }
            x.w("MicroMsg.WebWxPopUnlockUI", "Mac WeChat request to unlock,the deviceName is null");
        }
    }
}
