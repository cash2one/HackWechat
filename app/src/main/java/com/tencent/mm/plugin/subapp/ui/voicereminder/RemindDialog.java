package com.tencent.mm.plugin.subapp.ui.voicereminder;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.z.ak.d;
import com.tencent.mm.z.ar;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

@a(3)
public class RemindDialog extends Activity {
    private static boolean fpa = false;
    private static List<String> rYP = new ArrayList();
    private af handler = new af();
    private i pyk;
    private List<String> rYO = new ArrayList();
    private d rYQ = new 1(this);
    private String talker = "";

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        i.a aVar = new i.a(this);
        aVar.Ez(R.l.eTQ);
        aVar.YG(" ");
        aVar.EC(R.l.eTN).a(new 2(this));
        aVar.ED(R.l.eTP).b(new 3(this));
        aVar.a(new OnDismissListener(this) {
            final /* synthetic */ RemindDialog rYR;

            {
                this.rYR = r1;
            }

            public final void onDismiss(DialogInterface dialogInterface) {
                this.rYR.finish();
            }
        });
        this.talker = getIntent().getStringExtra("_RemindDialog_User");
        String stringExtra = getIntent().getStringExtra("_RemindDialog_Remind");
        this.rYO.clear();
        this.rYO.add(stringExtra);
        for (String stringExtra2 : rYP) {
            this.rYO.add(stringExtra2);
        }
        this.pyk = aVar.akx();
        this.pyk.setCanceledOnTouchOutside(false);
        this.pyk.show();
        bEj();
    }

    private void bEj() {
        this.handler.post(new 5(this));
    }

    public void onResume() {
        fpa = true;
        com.tencent.mm.plugin.subapp.c.d bEa = com.tencent.mm.plugin.subapp.c.d.bEa();
        if (bEa != null) {
            bEa.a(this.rYQ);
        }
        super.onResume();
    }

    public void onPause() {
        fpa = false;
        com.tencent.mm.plugin.subapp.c.d bEa = com.tencent.mm.plugin.subapp.c.d.bEa();
        if (bEa != null) {
            bEa.b(this.rYQ);
        }
        super.onPause();
    }

    public static void u(Context context, String str, String str2) {
        x.d("MicroMsg.RemindDialog", "show " + fpa + " remind " + str2);
        if (fpa) {
            rYP.add(str2);
            return;
        }
        rYP.clear();
        fpa = true;
        if (ar.CG().foreground) {
            Intent intent = new Intent(context, RemindDialog.class);
            intent.putExtra("_RemindDialog_User", str);
            intent.putExtra("_RemindDialog_Remind", str2);
            intent.setFlags(603979776);
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            context.startActivity(intent);
            return;
        }
        intent = new Intent(context, RemindDialog.class);
        intent.putExtra("_RemindDialog_User", str);
        intent.putExtra("_RemindDialog_Remind", str2);
        intent.setFlags(604012544);
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        context.startActivity(intent);
    }
}
