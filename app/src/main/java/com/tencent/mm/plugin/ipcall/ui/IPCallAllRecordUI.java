package com.tencent.mm.plugin.ipcall.ui;

import android.os.Bundle;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMActivity;

public class IPCallAllRecordUI extends MMActivity {
    private String fIA;
    private String fIy;
    private ListView nIE;
    private boolean nIF = false;

    protected final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fIA = getIntent().getStringExtra("IPCallAllRecordUI_phoneNumber");
        this.fIy = getIntent().getStringExtra("IPCallAllRecordUI_contactId");
        this.nIF = getIntent().getBooleanExtra("IPCallAllRecordUI_isSinglePhoneNumber", false);
        setMMTitle(R.l.ere);
        setBackBtn(new 1(this));
        this.nIE = (ListView) findViewById(R.h.bKb);
        this.nIE.setAdapter(new a(this, this));
    }

    protected final int getLayoutId() {
        return R.i.dlV;
    }
}
