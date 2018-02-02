package com.tencent.mm.ui.transmit;

import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bx.g;
import com.tencent.mm.ui.MMActivity;

public class RetransmitPreviewUI extends MMActivity {
    private TextView kO = null;
    private String text = null;

    protected final int getLayoutId() {
        return R.i.ddE;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle("");
        this.text = getIntent().getStringExtra("Retr_Msg_content");
        this.kO = (TextView) findViewById(R.h.cko);
        this.kO.setText(g.chg().a(this.mController.xIM, this.text, this.kO.getTextSize()));
        setBackBtn(new 1(this));
    }

    public void onBackPressed() {
        finish();
    }

    protected void onDestroy() {
        super.onDestroy();
    }
}
