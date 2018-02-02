package com.tencent.mm.plugin.webwx.ui;

import android.os.Bundle;
import android.widget.Button;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMActivity;

public class WebWeiXinIntroductionUI extends MMActivity {
    private Button tOT;

    protected final int getLayoutId() {
        return R.i.dtY;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected final void initView() {
        setMMTitle("");
        this.tOT = (Button) findViewById(R.h.cYW);
        this.tOT.setOnClickListener(new 1(this));
        setBackBtn(new 2(this));
    }
}
