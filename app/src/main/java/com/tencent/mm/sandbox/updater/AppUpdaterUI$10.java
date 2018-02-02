package com.tencent.mm.sandbox.updater;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sandbox.monitor.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.database.SQLiteDatabase;

class AppUpdaterUI$10 implements OnClickListener {
    final /* synthetic */ AppUpdaterUI xcq;

    AppUpdaterUI$10(AppUpdaterUI appUpdaterUI) {
        this.xcq = appUpdaterUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.d("MicroMsg.AppUpdaterUI", "getBtn (ok button) is click");
        if (AppUpdaterUI.e(this.xcq).ruR == 1) {
            i.af(this.xcq, 6);
        }
        if (!h.getExternalStorageState().equals("mounted")) {
            x.e("MicroMsg.AppUpdaterUI", "no sdcard.");
            AppUpdaterUI.b(this.xcq).dismiss();
            AppUpdaterUI.c(this.xcq);
        } else if ((AppUpdaterUI.e(this.xcq).fdU & 1) != 0) {
            x.e("MicroMsg.AppUpdaterUI", "package has set external update mode");
            Uri parse = Uri.parse(AppUpdaterUI.e(this.xcq).fdW);
            Intent addFlags = new Intent("android.intent.action.VIEW", parse).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            if (parse == null || addFlags == null || !bh.k(this.xcq, addFlags)) {
                x.e("MicroMsg.AppUpdaterUI", "parse market uri failed, jump to weixin.qq.com");
                this.xcq.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://weixin.qq.com")).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY));
            } else {
                x.i("MicroMsg.AppUpdaterUI", "parse market uri ok");
                this.xcq.startActivity(addFlags);
            }
            AppUpdaterUI.f(this.xcq);
        } else {
            String be = c.be(AppUpdaterUI.e(this.xcq).fqR, AppUpdaterUI.e(this.xcq).xdD);
            if (bh.ov(be) && AppUpdaterUI.e(this.xcq).xdy != null) {
                be = c.UD(AppUpdaterUI.e(this.xcq).xdy.fek);
            }
            x.d("MicroMsg.AppUpdaterUI", be);
            if (be != null) {
                x.i("MicroMsg.AppUpdaterUI", "update package already exist.");
                AppUpdaterUI.a(this.xcq, 8);
                if (AppUpdaterUI.e(this.xcq).xdz) {
                    AppUpdaterUI.a(this.xcq, 0);
                } else {
                    AppUpdaterUI.a(this.xcq, 9);
                }
                AppUpdaterUI.e(this.xcq).ac(1, true);
                AppUpdaterUI.h(this.xcq).KY(be);
                return;
            }
            x.d("MicroMsg.AppUpdaterUI", "current downloadMode : %s", new Object[]{Integer.valueOf(AppUpdaterUI.e(this.xcq).ruR)});
            x.d("MicroMsg.AppUpdaterUI", "current updateType : %s", new Object[]{Integer.valueOf(AppUpdaterUI.e(this.xcq).xcb)});
            if (AppUpdaterUI.e(this.xcq).ruR == 0) {
                AppUpdaterUI.e(this.xcq).ceC();
            } else if (AppUpdaterUI.e(this.xcq).ruR == 1) {
                x.d("MicroMsg.AppUpdaterUI", "gonna start UpdaterService");
                AppUpdaterUI.f(this.xcq);
                Intent intent = new Intent(this.xcq.getIntent());
                intent.setClass(this.xcq, UpdaterService.class);
                intent.putExtra("intent_extra_run_in_foreground", true);
                this.xcq.startService(intent);
                if (AppUpdaterUI.e(this.xcq).xdD) {
                    g.pQN.a(614, 56, 1, false);
                    x.d("MicroMsg.AppUpdaterUI", "boots download start.");
                }
            } else {
                x.e("MicroMsg.AppUpdaterUI", "silence download never go here!");
            }
        }
    }
}
