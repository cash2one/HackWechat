package com.tencent.mm.permission;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.ac;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.base.i.a;
import com.tencent.mm.ui.base.j.b;

public class PermissionWarningDialog extends MMBaseActivity {
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
        if (getIntent() == null) {
            x.e("MicroMsg.PermissionWarningDialog", "Intent is null");
            return;
        }
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            x.e("MicroMsg.PermissionWarningDialog", "invalid params");
            return;
        }
        int i = extras.getInt("warning_type", 0);
        a aVar;
        if (1 == i) {
            aVar = new a(this);
            aVar.YF(extras.getString("warning_title"));
            aVar.YG(extras.getString("warning_content"));
            aVar.EC(R.l.dFs).a(new 1(this));
            this.ibT = aVar.akx();
            this.ibT.setCanceledOnTouchOutside(false);
            this.ibT.show();
        } else if (2 == i) {
            aVar = new a(this);
            boolean z = extras.getBoolean("warning_filter", false);
            boolean z2 = extras.getBoolean("warning_due2Exception", false);
            aVar.Ez(R.l.dGi);
            aVar.YG(getString(R.l.dGd));
            aVar.ED(R.l.dEn).b(new 2(this, z2));
            aVar.EC(R.l.dFX).a(new 3(this, z, z2));
            this.ibT = aVar.akx();
            this.ibT.setCanceledOnTouchOutside(false);
            this.ibT.show();
        } else if (3 == i) {
            b YK = new b(this).YK(getString(R.l.dFE));
            YK.xZR = getString(R.l.dFt);
            YK.xZQ = getString(R.l.dFF);
            YK.a(new 4(this)).pyk.show();
        }
    }

    public static void i(Context context, String str, String str2) {
        Intent intent = new Intent(context, PermissionWarningDialog.class);
        intent.putExtra("warning_type", 1);
        intent.putExtra("warning_title", str);
        intent.putExtra("warning_content", str2);
        intent.addFlags(805306368);
        context.startActivity(intent);
    }

    public static void a(Context context, boolean z, boolean z2) {
        Intent intent = new Intent(context, PermissionWarningDialog.class);
        intent.putExtra("warning_type", 2);
        intent.putExtra("warning_filter", z);
        intent.putExtra("warning_due2Exception", z2);
        intent.addFlags(805306368);
        context.startActivity(intent);
    }

    public static void bD(Context context) {
        Intent intent = new Intent(context, PermissionWarningDialog.class);
        intent.putExtra("warning_type", 3);
        intent.addFlags(805306368);
        context.startActivity(intent);
    }
}
