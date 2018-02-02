package com.tencent.mm.plugin.nearby.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bf.h;
import com.tencent.mm.bf.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.rtmp.TXLiveConstants;

public class NearbyFriendShowSayHiUI extends MMActivity {
    ImageView iip;
    String oOw = "";
    View oOx = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.exr);
        initView();
    }

    protected void onResume() {
        super.onResume();
        TextView textView = (TextView) findViewById(R.h.cIH);
        int Tq = l.Ty().Tq();
        if (Tq == 0) {
            this.oOx.setVisibility(4);
            return;
        }
        textView.setText(getResources().getQuantityString(R.j.duK, Tq, new Object[]{Integer.valueOf(Tq)}));
        this.iip = (ImageView) findViewById(R.h.cvt);
        h Tr = l.Ty().Tr();
        if (Tr != null) {
            this.oOw = Tr.field_sayhiuser;
            b.a(this.iip, this.oOw);
        }
    }

    public void onPause() {
        super.onPause();
    }

    protected final int getLayoutId() {
        return R.i.doM;
    }

    protected final void initView() {
        setBackBtn(new 1(this));
        ((Button) findViewById(R.h.cyT)).setOnClickListener(new 2(this));
        this.oOx = findViewById(R.h.cnP);
        this.oOx.setVisibility(0);
        this.oOx.setOnClickListener(new 3(this));
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == TXLiveConstants.PLAY_EVT_CHANGE_RESOLUTION && i2 == -1) {
            finish();
        }
    }
}
