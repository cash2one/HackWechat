package com.tencent.mm.ui.f.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import com.tencent.xweb.b;

public final class c {
    protected static String zbP = "https://m.facebook.com/dialog/";
    protected static String zbQ = "https://graph.facebook.com/";
    protected static String zbR = "https://api.facebook.com/restserver.php";
    private String mAppId;
    public String ykF = null;
    private long zbS = 0;
    public long zbT = 0;
    private Activity zbU;
    private String[] zbV;
    private int zbW;
    private a zbX;
    private final long zbY = 86400000;

    public c(String str) {
        this.mAppId = str;
    }

    public final void a(Activity activity, String[] strArr, a aVar) {
        this.zbX = aVar;
        a(activity, strArr);
        g.pQN.a(582, 0, 1, false);
    }

    private void a(Activity activity, String[] strArr) {
        Bundle bundle = new Bundle();
        if (strArr.length > 0) {
            bundle.putString("scope", TextUtils.join(",", strArr));
        }
        com.tencent.xweb.c.iO(activity);
        a(activity, "oauth", bundle, new a(this) {
            final /* synthetic */ c zbZ;

            {
                this.zbZ = r1;
            }

            public final void k(Bundle bundle) {
                com.tencent.xweb.c.cIl();
                com.tencent.xweb.c.sync();
                this.zbZ.ZI(bundle.getString("access_token"));
                this.zbZ.ZJ(bundle.getString("expires_in"));
                if (this.zbZ.cwS()) {
                    x.d("Facebook-authorize", "Login Success! access_token=" + this.zbZ.ykF + " expires=" + this.zbZ.zbT);
                    this.zbZ.zbX.k(bundle);
                    return;
                }
                this.zbZ.zbX.a(new d("Failed to receive access token."));
            }

            public final void a(b bVar) {
                x.d("Facebook-authorize", "Login failed: " + bVar);
                this.zbZ.zbX.a(bVar);
            }

            public final void a(d dVar) {
                x.d("Facebook-authorize", "Login failed: " + dVar);
                this.zbZ.zbX.a(dVar);
            }

            public final void onCancel() {
                x.d("Facebook-authorize", "Login canceled");
                this.zbZ.zbX.onCancel();
            }
        });
    }

    public final void e(int i, int i2, Intent intent) {
        if (i != this.zbW) {
            return;
        }
        if (i2 == -1) {
            String stringExtra = intent.getStringExtra("error");
            if (stringExtra == null) {
                stringExtra = intent.getStringExtra("error_type");
            }
            if (stringExtra == null) {
                ZI(intent.getStringExtra("access_token"));
                ZJ(intent.getStringExtra("expires_in"));
                if (cwS()) {
                    x.d("Facebook-authorize", "Login Success! access_token=" + this.ykF + " expires=" + this.zbT);
                    this.zbX.k(intent.getExtras());
                    return;
                }
                this.zbX.a(new d("Failed to receive access token."));
            } else if (stringExtra.equals("service_disabled") || stringExtra.equals("AndroidAuthKillSwitchException")) {
                x.d("Facebook-authorize", "Hosted auth currently disabled. Retrying dialog auth...");
                a(this.zbU, this.zbV);
            } else if (stringExtra.equals("access_denied") || stringExtra.equals("OAuthAccessDeniedException")) {
                x.d("Facebook-authorize", "Login canceled by user.");
                this.zbX.onCancel();
            } else {
                String stringExtra2 = intent.getStringExtra("error_description");
                if (stringExtra2 != null) {
                    stringExtra = stringExtra + ":" + stringExtra2;
                }
                x.d("Facebook-authorize", "Login failed: " + stringExtra);
                this.zbX.a(new d(stringExtra));
            }
        } else if (i2 != 0) {
        } else {
            if (intent != null) {
                x.d("Facebook-authorize", "Login failed: " + intent.getStringExtra("error"));
                this.zbX.a(new b(intent.getStringExtra("error"), intent.getIntExtra("error_code", -1), intent.getStringExtra("failing_url")));
                return;
            }
            x.d("Facebook-authorize", "Login canceled by user.");
            this.zbX.onCancel();
        }
    }

    public final String fY(Context context) {
        com.tencent.xweb.c.iO(context);
        b.cIj().removeAllCookie();
        ZI(null);
        this.zbT = 0;
        return null;
    }

    public final String a(String str, Bundle bundle, String str2) {
        bundle.putString("format", "json");
        if (cwS()) {
            bundle.putString("access_token", this.ykF);
        }
        return e.e(str != null ? zbQ + str : zbR, str2, bundle);
    }

    public final void a(Context context, String str, Bundle bundle, a aVar) {
        String str2 = zbP + str;
        bundle.putString("display", "touch");
        bundle.putString("redirect_uri", "fbconnect://success");
        if (str.equals("oauth")) {
            bundle.putString(DownloadSettingTable$Columns.TYPE, "user_agent");
            bundle.putString("client_id", this.mAppId);
        } else {
            bundle.putString("app_id", this.mAppId);
        }
        if (cwS()) {
            bundle.putString("access_token", this.ykF);
        }
        str2 = str2 + "?" + e.ai(bundle);
        if (context.checkCallingOrSelfPermission("android.permission.INTERNET") != 0) {
            e.C(context, "Error", "Application requires permission to access the Internet");
        } else {
            new f(context, str2, aVar).show();
        }
    }

    public final boolean cwS() {
        return this.ykF != null && (this.zbT == 0 || System.currentTimeMillis() < this.zbT);
    }

    public final void ZI(String str) {
        this.ykF = str;
        this.zbS = System.currentTimeMillis();
    }

    public final void ZJ(String str) {
        if (str != null) {
            long j;
            if (str.equals("0")) {
                j = 0;
            } else {
                j = System.currentTimeMillis() + (bh.VJ(str) * 1000);
            }
            this.zbT = j;
        }
    }
}
