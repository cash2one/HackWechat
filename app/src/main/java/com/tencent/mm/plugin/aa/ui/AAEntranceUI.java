package com.tencent.mm.plugin.aa.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a$g;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.pluginsdk.ui.d.l;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;

@a(1)
public class AAEntranceUI extends MMActivity {
    private Button ihN;
    private TextView ihO;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(a$i.uJG);
        this.ihN = (Button) findViewById(f.ulI);
        this.ihO = (TextView) findViewById(f.uhE);
        this.ihN.setOnClickListener(new 1(this));
        this.ihO.setClickable(true);
        this.ihO.setOnTouchListener(new l(this));
        CharSequence spannableStringBuilder = new SpannableStringBuilder(getString(a$i.uIe));
        spannableStringBuilder.setSpan(new a(new 2(this)), 0, spannableStringBuilder.length(), 18);
        this.ihO.setText(spannableStringBuilder);
        setBackBtn(new 3(this));
    }

    protected final int getLayoutId() {
        return a$g.uAP;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 1) {
            String stringExtra = intent.getStringExtra("Select_Conv_User");
            x.i("MicroMsg.AAEntranceUI", "select chatroom：%s", new Object[]{stringExtra});
            if (!bh.ov(stringExtra)) {
                Intent intent2 = new Intent(this.mController.xIM, LaunchAAUI.class);
                intent2.putExtra("enter_scene", 2);
                intent2.putExtra("chatroom_name", stringExtra);
                startActivity(intent2);
            }
        }
    }
}
