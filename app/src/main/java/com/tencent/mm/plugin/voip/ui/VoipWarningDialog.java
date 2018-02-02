package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import com.tencent.mm.R;
import com.tencent.mm.compatible.e.b;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.ac;
import com.tencent.mm.ui.base.i;

public class VoipWarningDialog extends MMBaseActivity {
    private static a ssA;
    public static int ssz = 1234;
    private i ibT = null;

    public interface a {
        void a(VoipWarningDialog voipWarningDialog);

        void b(VoipWarningDialog voipWarningDialog);
    }

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
            x.e("MicroMsg.VoipWarningDialog", "Intent is null");
            return;
        }
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            x.e("MicroMsg.VoipWarningDialog", "invalid params");
            return;
        }
        com.tencent.mm.ui.base.i.a aVar = new com.tencent.mm.ui.base.i.a(this);
        aVar.YF(getString(R.l.eVm));
        aVar.YG(extras.getString("warning_content"));
        aVar.d(new 1(this));
        aVar.EC(d.fM(23) ? R.l.eVl : R.l.eVk).a(new OnClickListener(this) {
            final /* synthetic */ VoipWarningDialog ssB;

            {
                this.ssB = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                if (d.fM(23)) {
                    try {
                        if (!bh.ov((String) Settings.class.getField("ACTION_MANAGE_OVERLAY_PERMISSION").get(Settings.class))) {
                            this.ssB.startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + com.tencent.mm.sdk.platformtools.ac.getPackageName())), VoipWarningDialog.ssz);
                            return;
                        }
                    } catch (Exception e) {
                        x.e("MicroMsg.VoipWarningDialog", "getField:ACTION_MANAGE_OVERLAY_PERMISSION! Error:%s, etype:%s", new Object[]{e.getMessage(), e.getClass().getCanonicalName()});
                    }
                }
                String string = this.ssB.getString(R.l.eVn);
                Intent intent = new Intent();
                intent.putExtra("rawUrl", string);
                intent.putExtra("useJs", true);
                intent.putExtra("vertical_scroll", true);
                com.tencent.mm.bm.d.b(this.ssB, "webview", ".ui.tools.WebViewUI", intent);
                this.ssB.finish();
            }
        });
        this.ibT = aVar.akx();
        this.ibT.setCanceledOnTouchOutside(false);
        this.ibT.show();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (ssA != null) {
            if (i != ssz) {
                ssA.b(this);
            } else if (b.aM(com.tencent.mm.sdk.platformtools.ac.getContext())) {
                ssA.a(this);
            } else {
                ssA.b(this);
            }
        }
    }

    public static void a(Context context, a aVar) {
        ssA = aVar;
        Intent intent = new Intent(context, VoipWarningDialog.class);
        intent.putExtra("warning_content", com.tencent.mm.sdk.platformtools.ac.getContext().getString(R.l.eVj));
        intent.addFlags(805306368);
        context.startActivity(intent);
    }
}
