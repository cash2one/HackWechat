package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.az.a;
import com.tencent.mm.az.b;
import com.tencent.mm.az.n;
import com.tencent.mm.az.r;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public class SettingsChattingBackgroundUI extends MMPreference {
    private f ilB;
    private boolean qjg;
    private String username;

    static /* synthetic */ void bqG() {
        b QI = r.QI();
        Cursor a = QI.hhp.a("select chattingbginfo.username,chattingbginfo.bgflag,chattingbginfo.path,chattingbginfo.reserved1,chattingbginfo.reserved2,chattingbginfo.reserved3,chattingbginfo.reserved4 from chattingbginfo  ", null, 0);
        if (a == null) {
            x.i("MicroMsg.SettingsChattingBackgroundUI", "applyToAll : cursor is null");
            return;
        }
        r.QH();
        if (a.moveToFirst()) {
            a aVar = new a();
            while (!a.isAfterLast()) {
                aVar.b(a);
                com.tencent.mm.loader.stub.b.deleteFile(n.D(aVar.getUsername(), true));
                com.tencent.mm.loader.stub.b.deleteFile(n.D(aVar.getUsername(), false));
                a.moveToNext();
            }
        }
        a.close();
        if (QI.hhp.delete("chattingbginfo", null, null) > 0) {
            QI.doNotify();
        }
    }

    public final int XB() {
        return R.o.fcf;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 1:
                if (intent != null) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("CropImageMode", 2);
                    intent2.putExtra("CropImage_bg_vertical", hO(true));
                    intent2.putExtra("CropImage_bg_horizontal", hO(false));
                    com.tencent.mm.pluginsdk.n nVar = com.tencent.mm.plugin.setting.a.ifs;
                    ar.Hg();
                    nVar.a((Activity) this, intent, intent2, c.Fi(), 4, null);
                    return;
                }
                return;
            case 2:
                Context applicationContext = getApplicationContext();
                ar.Hg();
                String b = k.b(applicationContext, intent, c.Fi());
                if (b != null) {
                    Intent intent3 = new Intent();
                    intent3.putExtra("CropImageMode", 2);
                    intent3.putExtra("CropImage_ImgPath", b);
                    intent3.putExtra("CropImage_bg_vertical", hO(true));
                    intent3.putExtra("CropImage_bg_horizontal", hO(false));
                    com.tencent.mm.plugin.setting.a.ifs.a((Activity) this, intent3, 4);
                    return;
                }
                return;
            case 3:
                if (i2 != -1) {
                    return;
                }
                break;
            case 4:
                if (i2 == -1) {
                    ar.Hg();
                    c.CU().set(66820, Integer.valueOf(-1));
                    g.pQN.h(10198, new Object[]{Integer.valueOf(-1)});
                    x.i("MicroMsg.SettingsChattingBackgroundUI", "set chating bg id:%d", new Object[]{Integer.valueOf(-1)});
                    if (!this.qjg) {
                        b QI = r.QI();
                        a lM = QI.lM(this.username);
                        if (lM != null) {
                            lM.hJl = -1;
                            QI.b(lM);
                            break;
                        }
                        lM = new a();
                        lM.username = this.username;
                        lM.hJl = -1;
                        QI.a(lM);
                        break;
                    }
                    ar.Hg();
                    c.CU().set(12311, Integer.valueOf(-1));
                    r.QH().ii(1);
                    break;
                }
                break;
        }
        if (!this.qjg) {
            setResult(-1);
            finish();
        }
    }

    protected final void initView() {
        setMMTitle(R.l.eLb);
        this.ilB = this.yjd;
        this.qjg = getIntent().getBooleanExtra("isApplyToAll", true);
        if (!this.qjg) {
            Preference YN = this.ilB.YN("settings_chatting_bg_apply_to_all");
            if (YN != null) {
                this.ilB.c(YN);
            }
        }
        this.username = getIntent().getStringExtra("username");
        setBackBtn(new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsChattingBackgroundUI qjh;

            {
                this.qjh = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.qjh.aWs();
                this.qjh.finish();
                return true;
            }
        });
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.ibD;
        x.i("MicroMsg.SettingsChattingBackgroundUI", str + " item has been clicked!");
        if (str.equals("settings_chatting_bg_select_bg")) {
            Intent intent = new Intent();
            intent.setClass(this, SettingsSelectBgUI.class);
            intent.putExtra("isApplyToAll", this.qjg);
            intent.putExtra("username", this.username);
            startActivityForResult(intent, 3);
            return true;
        } else if (str.equals("settings_chatting_bg_select_from_album")) {
            k.a(this, 1, null);
            return true;
        } else if (str.equals("settings_chatting_bg_take_photo")) {
            x.i("MicroMsg.SettingsChattingBackgroundUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this.mController.xIM, "android.permission.CAMERA", 16, "", "")), bh.cgy(), this.mController.xIM});
            if (!com.tencent.mm.pluginsdk.g.a.a(this.mController.xIM, "android.permission.CAMERA", 16, "", "")) {
                return false;
            }
            arQ();
            return true;
        } else if (!str.equals("settings_chatting_bg_apply_to_all")) {
            return false;
        } else {
            h.a(this.mController.xIM, getString(R.l.eLc), "", new OnClickListener(this) {
                final /* synthetic */ SettingsChattingBackgroundUI qjh;

                {
                    this.qjh = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    SettingsChattingBackgroundUI.bqG();
                }
            }, null);
            return true;
        }
    }

    private void arQ() {
        if (!k.c(this, e.gHu, "microMsg." + System.currentTimeMillis() + ".jpg", 2)) {
            Toast.makeText(this, getString(R.l.eJu), 1).show();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.SettingsChattingBackgroundUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 16:
                if (iArr[0] == 0) {
                    arQ();
                    return;
                } else {
                    h.a((Context) this, getString(R.l.ezM), getString(R.l.ezT), getString(R.l.est), getString(R.l.cancel), false, new OnClickListener(this) {
                        final /* synthetic */ SettingsChattingBackgroundUI qjh;

                        {
                            this.qjh = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.qjh.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, null);
                    return;
                }
            default:
                return;
        }
    }

    private String hO(boolean z) {
        r.QH();
        if (this.qjg) {
            return n.D("default", z);
        }
        return n.D(this.username, z);
    }
}
