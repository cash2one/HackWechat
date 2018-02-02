package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMBaseActivity;

public class InviteRemindDialog extends MMBaseActivity {
    private TextView jpW;
    private TextView spI;
    private String talker = "";
    private int type = 0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.i.doi);
        this.jpW = (TextView) findViewById(R.h.cwk);
        this.spI = (TextView) findViewById(R.h.cwh);
        this.talker = getIntent().getStringExtra("InviteRemindDialog_User");
        this.type = getIntent().getIntExtra("InviteRemindDialog_Type", 0);
        if (this.type == 0) {
            this.jpW.setText(getString(R.l.eVI));
            this.spI.setText(getString(R.l.eVt));
        } else if (this.type == 1) {
            this.jpW.setText(getString(R.l.eWa));
            this.spI.setText(getString(R.l.eVY));
        }
        findViewById(R.h.cwl).setOnClickListener(new 1(this));
        findViewById(R.h.cwb).setOnClickListener(new 2(this));
    }

    public void finish() {
        super.finish();
    }

    public static void k(Context context, String str, int i) {
        Intent intent = new Intent(context, InviteRemindDialog.class);
        intent.putExtra("InviteRemindDialog_User", str);
        intent.putExtra("InviteRemindDialog_Type", i);
        context.startActivity(intent);
    }
}
