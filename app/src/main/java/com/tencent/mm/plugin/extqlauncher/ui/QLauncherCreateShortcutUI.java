package com.tencent.mm.plugin.extqlauncher.ui;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.n;
import com.tencent.mm.bm.d;
import com.tencent.mm.l.a;
import com.tencent.mm.plugin.base.model.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import com.tencent.mm.z.r;
import java.util.List;

public class QLauncherCreateShortcutUI extends MMBaseActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.d("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "onCreate");
        requestWindowFeature(1);
        setContentView(R.i.dfm);
        Intent intent = new Intent();
        int p = s.p(new int[]{s.yTD, 64, 16384});
        s.fb(p, 1);
        intent.putExtra("list_attr", p);
        intent.putExtra("list_type", 12);
        intent.putExtra("stay_in_wechat", false);
        intent.putExtra("titile", getString(R.l.dDo));
        intent.putExtra("block_contact", q.FS());
        d.a(this, ".ui.contact.SelectContactUI", intent, 1);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        x.d("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "onActivityResult resultCode = %s", new Object[]{Integer.valueOf(i2)});
        if (i2 != -1) {
            finish();
            return;
        }
        switch (i) {
            case 1:
                if (intent != null) {
                    if (ar.Hj()) {
                        List list;
                        String stringExtra = intent.getStringExtra("Select_Contact");
                        if (bh.ov(stringExtra)) {
                            list = null;
                        } else {
                            list = bh.F(stringExtra.split(","));
                        }
                        if (list != null && list.size() > 0) {
                            x.d("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "userNames count " + list.size());
                            String FS = q.FS();
                            try {
                                ContentValues[] contentValuesArr = new ContentValues[list.size()];
                                for (int i3 = 0; i3 < list.size(); i3++) {
                                    ar.Hg();
                                    a WO = c.EY().WO((String) list.get(i3));
                                    if (WO == null || ((int) WO.gJd) <= 0) {
                                        x.e("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "no such user");
                                        finish();
                                        return;
                                    }
                                    String vE = b.vE((String) list.get(i3));
                                    if (bh.ov(vE)) {
                                        x.e("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "null encryptShortcutUser");
                                        finish();
                                        return;
                                    }
                                    ContentValues contentValues = new ContentValues();
                                    contentValues.put("source_key", b.kuC);
                                    contentValues.put("owner_id", b.vE(FS));
                                    contentValues.put("unique_id", vE);
                                    contentValues.put("container", Integer.valueOf(1));
                                    contentValues.put("item_type", Integer.valueOf(b.y(WO)));
                                    contentValues.put("name", r.a(WO, (String) list.get(i3)));
                                    n.Jz();
                                    contentValues.put("icon_path", com.tencent.mm.ad.d.x((String) list.get(i3), false));
                                    Intent intent2 = new Intent("com.tencent.mm.action.BIZSHORTCUT");
                                    intent2.putExtra("LauncherUI.Shortcut.Username", vE);
                                    intent2.putExtra("LauncherUI.From.Biz.Shortcut", true);
                                    intent2.addFlags(67108864);
                                    contentValues.put("intent", intent2.toUri(0));
                                    contentValuesArr[i3] = contentValues;
                                }
                                getContentResolver().bulkInsert(a.mcn, contentValuesArr);
                                Toast.makeText(this, R.l.edZ, 0).show();
                                com.tencent.mm.plugin.extqlauncher.b.aGb().aGd();
                                break;
                            } catch (Throwable e) {
                                x.d("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "bulkInsert shortcut failed, %s", new Object[]{e.getMessage()});
                                x.printErrStackTrace("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", e, "", new Object[0]);
                                Toast.makeText(this, R.l.edY, 0).show();
                                break;
                            }
                        }
                        x.e("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "userNames empty");
                        break;
                    }
                    x.e("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "account not ready");
                    Toast.makeText(this, R.l.edY, 0).show();
                    finish();
                    return;
                }
                break;
        }
        finish();
    }
}
