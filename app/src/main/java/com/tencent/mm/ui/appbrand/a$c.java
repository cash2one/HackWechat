package com.tencent.mm.ui.appbrand;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.bm.d;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.appbrand.a.h;
import com.tencent.mm.ui.base.n;

public class a$c implements h {
    final /* synthetic */ a xVC;

    public a$c(a aVar) {
        this.xVC = aVar;
    }

    public View coC() {
        return null;
    }

    public void a(n nVar) {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMMMenuItemSelected(MenuItem menuItem, int i) {
        boolean z = false;
        a aVar;
        switch (menuItem.getItemId()) {
            case 2:
                ag.h(new Runnable(this) {
                    final /* synthetic */ a$c xVD;

                    {
                        this.xVD = r1;
                    }

                    public final void run() {
                        this.xVD.xVC.show(3);
                    }
                }, 100);
                z = true;
                break;
            case 3:
                ag.h(new 2(this), 100);
                z = true;
                break;
            case 4:
                this.xVC.jDg.bxh();
                z = true;
                break;
            case 5:
                if (!bh.ov(this.xVC.username)) {
                    b.i(this.xVC.context, this.xVC.username, true);
                    if (!this.xVC.kfu) {
                        this.xVC.eN(this.xVC.scene, 4);
                        z = true;
                        break;
                    }
                    a.a(this.xVC, 6);
                    z = true;
                    break;
                }
            case 6:
                if (!bh.ov(this.xVC.username)) {
                    b.i(this.xVC.context, this.xVC.username, false);
                    if (!this.xVC.kfu) {
                        this.xVC.eN(this.xVC.scene, 2);
                        z = true;
                        break;
                    }
                    a.a(this.xVC, 1);
                    z = true;
                    break;
                }
            case 7:
                aVar = this.xVC;
                Context context = this.xVC.context;
                Parcelable parcelable = this.xVC.jLv;
                if (parcelable != null) {
                    x.i("MicroMsg.AppBrandSerivceActionSheet", "exportUrlParams : %s", new Object[]{parcelable.toString()});
                    if (!bh.ov(parcelable.username)) {
                        Intent intent = new Intent();
                        intent.putExtra("key_username", parcelable.username);
                        intent.putExtra("key_from_scene", 4);
                        intent.putExtra("key_scene_exposed_params", parcelable);
                        d.b(context, "appbrand", ".ui.AppBrandProfileUI", intent);
                        aVar.eN(aVar.scene, 1);
                    }
                    z = true;
                    break;
                }
                x.e("MicroMsg.AppBrandSerivceActionSheet", "exportUrlParams is null");
                z = true;
                break;
            case 8:
                aVar = this.xVC;
                Intent intent2 = new Intent();
                String aj = a.aj(aVar.jLv.appId, aVar.jLv.fCp, aVar.jLv.appId.equals(aVar.getAppId()) ? "" : aVar.getAppId());
                x.v("MicroMsg.AppBrandSerivceActionSheet", "KRawUrl " + aj);
                intent2.putExtra("rawUrl", aj);
                intent2.putExtra("forceHideShare", true);
                d.b(aVar.context, "webview", ".ui.tools.WebViewUI", intent2);
                z = true;
                break;
        }
        if (z) {
            this.xVC.jDg.bxh();
        }
    }
}
