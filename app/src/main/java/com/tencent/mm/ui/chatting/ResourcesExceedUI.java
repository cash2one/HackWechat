package com.tencent.mm.ui.chatting;

import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMActivity;

public class ResourcesExceedUI extends MMActivity {
    private int type = 0;
    private TextView yxs;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.type = getIntent().getIntExtra("clean_view_type", 0);
        setMMTitle("");
        initView();
    }

    protected final void initView() {
        setBackBtn(new 1(this));
        this.yxs = (TextView) findViewById(R.h.ccC);
        switch (this.type) {
            case 0:
                this.yxs.setText(R.l.eTa);
                return;
            case 1:
                this.yxs.setText(R.l.epp);
                return;
            case 2:
                this.yxs.setText(R.l.ehl);
                return;
            default:
                return;
        }
    }

    protected final int getLayoutId() {
        return R.i.dqO;
    }

    public void onDestroy() {
        super.onDestroy();
    }
}
