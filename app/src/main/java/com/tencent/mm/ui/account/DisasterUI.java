package com.tencent.mm.ui.account;

import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;

public class DisasterUI extends MMActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.DisasterUI", "summerdiz onCreate :%d, content[%s], url[%s]", new Object[]{Integer.valueOf(hashCode()), getIntent().getStringExtra("key_disaster_content"), getIntent().getStringExtra("key_disaster_url")});
        ((TextView) findViewById(R.h.cBq)).setText(r1);
        findViewById(R.h.cBp).setOnClickListener(new 1(this, r2));
        setMMTitle(getString(R.l.dYR));
        setBackBtn(new 2(this));
    }

    protected final int getLayoutId() {
        return R.i.dfw;
    }

    public final boolean needShowIdcError() {
        return false;
    }
}
