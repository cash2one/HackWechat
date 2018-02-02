package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.os.Parcelable;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.base.model.b;
import com.tencent.mm.plugin.scanner.history.ui.ScannerHistoryUI;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.widget.g;

class BaseScanUI$10 implements OnMenuItemClickListener {
    final /* synthetic */ BaseScanUI pUR;
    final /* synthetic */ OnClickListener pUV;

    BaseScanUI$10(BaseScanUI baseScanUI, OnClickListener onClickListener) {
        this.pUR = baseScanUI;
        this.pUV = onClickListener;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        g gVar = new g(this.pUR.mController.xIM, g.ztp, false);
        gVar.rKC = new 1(this);
        gVar.rKD = new d(this) {
            final /* synthetic */ BaseScanUI$10 pUW;

            {
                this.pUW = r1;
            }

            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                switch (menuItem.getItemId()) {
                    case 0:
                        Context context = this.pUW.pUR;
                        Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
                        intent.putExtra("android.intent.extra.shortcut.NAME", context.getString(R.l.ehu));
                        intent.putExtra("duplicate", false);
                        Parcelable intent2 = new Intent("com.tencent.mm.action.BIZSHORTCUT");
                        intent2.putExtra("LauncherUI.From.Scaner.Shortcut", true);
                        intent2.addFlags(67108864);
                        intent.putExtra("android.intent.extra.shortcut.INTENT", intent2);
                        intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", ShortcutIconResource.fromContext(context, R.g.bFx));
                        intent.putExtra("shortcut_icon_resource_id", R.g.bFx);
                        b.n(context, intent);
                        com.tencent.mm.plugin.report.service.g.pQN.h(11410, new Object[0]);
                        return;
                    case 1:
                        if (this.pUW.pUV != null) {
                            this.pUW.pUV.onClick(null);
                            return;
                        }
                        return;
                    case 2:
                        Intent intent3 = new Intent();
                        intent3.setClass(this.pUW.pUR, ScannerHistoryUI.class);
                        this.pUW.pUR.startActivity(intent3);
                        com.tencent.mm.plugin.report.service.g.pQN.h(12684, Integer.valueOf(1), Integer.valueOf(0));
                        return;
                    default:
                        return;
                }
            }
        };
        gVar.bUk();
        return false;
    }
}
