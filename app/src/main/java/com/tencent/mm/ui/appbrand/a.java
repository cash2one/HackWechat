package com.tencent.mm.ui.appbrand;

import android.content.Context;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p$d;
import com.tencent.mm.ui.v;
import com.tencent.mm.ui.widget.g;
import java.io.UnsupportedEncodingException;

public final class a {
    public String appId = "";
    Context context;
    g jDg;
    public WxaExposedParams jLv = new com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a().ace();
    public boolean kfu;
    public int scene;
    public String username;
    h xVA;
    public String xVB = "";

    public class a extends c {
        final /* synthetic */ a xVC;

        public a(a aVar) {
            this.xVC = aVar;
            super(aVar);
        }

        public final void a(n nVar) {
            super.a(nVar);
            nVar.f(2, this.xVC.context.getString(R.l.dEg));
            nVar.f(8, this.xVC.context.getString(R.l.dEe));
            nVar.f(7, a.a(this.xVC));
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            super.onMMMenuItemSelected(menuItem, i);
        }
    }

    public class b extends c {
        final /* synthetic */ a xVC;

        public b(a aVar) {
            this.xVC = aVar;
            super(aVar);
        }

        public final void a(n nVar) {
            super.a(nVar);
            nVar.f(3, this.xVC.context.getString(R.l.dEi));
            nVar.f(8, this.xVC.context.getString(R.l.dEe));
            nVar.f(7, a.a(this.xVC));
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            super.onMMMenuItemSelected(menuItem, i);
        }
    }

    public class d extends c {
        final /* synthetic */ a xVC;

        public d(a aVar) {
            this.xVC = aVar;
            super(aVar);
        }

        public final void a(n nVar) {
            super.a(nVar);
            nVar.f(2, this.xVC.context.getString(R.l.dEg));
            nVar.f(8, this.xVC.context.getString(R.l.dEe));
            nVar.f(7, a.a(this.xVC));
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            super.onMMMenuItemSelected(menuItem, i);
        }
    }

    public class f extends c {
        final /* synthetic */ a xVC;

        public f(a aVar) {
            this.xVC = aVar;
            super(aVar);
        }

        public final View coC() {
            View inflate = v.fv(this.xVC.context).inflate(R.i.dcV, null);
            ((TextView) inflate.findViewById(R.h.bKO)).setText(this.xVC.context.getString(R.l.dEf));
            return inflate;
        }

        public final void a(n nVar) {
            super.a(nVar);
            nVar.f(5, this.xVC.context.getString(R.l.dDW));
            nVar.f(4, this.xVC.context.getString(R.l.dEd));
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            super.onMMMenuItemSelected(menuItem, i);
        }
    }

    static /* synthetic */ String a(a aVar) {
        if (aVar.jLv == null) {
            return "";
        }
        if (bh.ov(aVar.jLv.fpL)) {
            aVar.jLv.fpL = "";
        }
        return aVar.context.getString(R.l.dDP, new Object[]{aVar.jLv.fpL});
    }

    static /* synthetic */ void a(a aVar, int i) {
        if (!bh.ov(aVar.getAppId())) {
            x.d("MicroMsg.AppBrandSerivceActionSheet", "stev report(%s), eventId : %s, appId %s, sceneId %s", new Object[]{Integer.valueOf(13798), Integer.valueOf(i), aVar.appId, aVar.xVB});
            com.tencent.mm.plugin.report.service.g.pQN.h(13798, new Object[]{Integer.valueOf(i), aVar.getAppId(), Integer.valueOf(0), aVar.xVB, Long.valueOf(bh.Wo())});
        }
    }

    public a(Context context) {
        this.context = context;
    }

    public final void show(int i) {
        this.jDg = new g(this.context, g.ztp, true);
        switch (i) {
            case 1:
                this.xVA = new a(this);
                break;
            case 2:
                this.xVA = new b(this);
                break;
            case 3:
                this.xVA = new f(this);
                break;
            case 4:
                this.xVA = new g(this);
                break;
            case 5:
                this.xVA = new d(this);
                break;
            case 6:
                this.xVA = new e(this);
                break;
            default:
                return;
        }
        if (this.xVA == null) {
            x.e("MicroMsg.AppBrandSerivceActionSheet", "resetTitleView, state is null");
        } else {
            View coC = this.xVA.coC();
            if (coC != null) {
                this.jDg.dO(coC);
            }
        }
        this.jDg.rKC = new 2(this);
        this.jDg.rKD = new p$d(this) {
            final /* synthetic */ a xVC;

            {
                this.xVC = r1;
            }

            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                if (this.xVC.xVA == null) {
                    x.e("MicroMsg.AppBrandSerivceActionSheet", "resetOnCreateMenuListener, state is null");
                } else {
                    this.xVC.xVA.onMMMenuItemSelected(menuItem, i);
                }
            }
        };
        this.jDg.bUk();
    }

    final String getAppId() {
        if (bh.ov(this.username)) {
            return null;
        }
        if (bh.ov(this.appId)) {
            WxaAttributes qK = ((com.tencent.mm.plugin.appbrand.m.b) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.m.b.class)).qK(this.username);
            if (qK != null) {
                this.appId = qK.field_appId;
            }
        }
        return this.appId;
    }

    final void eN(int i, int i2) {
        if (!bh.ov(getAppId())) {
            x.d("MicroMsg.AppBrandSerivceActionSheet", "stev report(%s), appId : %s, scene %s, sceneId %s, action %s", new Object[]{Integer.valueOf(13918), this.appId, Integer.valueOf(i), this.xVB, Integer.valueOf(i2)});
            com.tencent.mm.plugin.report.service.g.pQN.h(13918, new Object[]{getAppId(), Integer.valueOf(i), this.xVB, Integer.valueOf(i2), Long.valueOf(bh.Wo())});
        }
    }

    public static String aj(String str, String str2, String str3) {
        String str4 = "";
        try {
            str4 = String.format("https://mp.weixin.qq.com/mp/wacomplain?action=show&appid=%s&pageid=%s&from=%d&&business_appid=%s#wechat_redirect", new Object[]{p.encode(bh.ou(str), "UTF-8"), p.encode(bh.ou(str2), "UTF-8"), Integer.valueOf(10), p.encode(bh.ou(str3), "UTF-8")});
        } catch (UnsupportedEncodingException e) {
            x.e("MicroMsg.AppBrandSerivceActionSheet", "buildExposeUrl encode fail, invalid arguments");
        }
        return str4;
    }
}
