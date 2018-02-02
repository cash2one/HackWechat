package com.tencent.mm.plugin.subapp.jdbiz;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.ac;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.base.i$a;

public class JDRemindDialog extends MMBaseActivity {
    private i ibT = null;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        Wb();
    }

    protected void onResume() {
        super.onResume();
        ac.a(true, null);
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        if (this.ibT != null) {
            this.ibT.dismiss();
            this.ibT = null;
        }
        Wb();
    }

    protected void onPause() {
        super.onPause();
        ac.a(false, null);
    }

    private void Wb() {
        if (getIntent() != null) {
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                i$a com_tencent_mm_ui_base_i_a = new i$a(this);
                com_tencent_mm_ui_base_i_a.YF("");
                com_tencent_mm_ui_base_i_a.YG(extras.getString("alertcontent"));
                com_tencent_mm_ui_base_i_a.YI(extras.getString("alertconfirm")).a(new 1(this));
                com_tencent_mm_ui_base_i_a.YJ(extras.getString("alert_cancel")).b(new 2(this));
                this.ibT = com_tencent_mm_ui_base_i_a.akx();
                this.ibT.setCanceledOnTouchOutside(false);
                this.ibT.show();
            }
        }
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5) {
        Intent intent = new Intent(context, JDRemindDialog.class);
        intent.putExtra("alertcontent", str);
        intent.putExtra("alertconfirm", str2);
        intent.putExtra("alert_cancel", str3);
        intent.putExtra("alertjumpurl", str4);
        intent.putExtra("alert_activityid", str5);
        intent.addFlags(805306368);
        context.startActivity(intent);
    }
}
