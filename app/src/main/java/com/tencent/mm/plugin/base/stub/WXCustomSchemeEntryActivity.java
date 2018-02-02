package com.tencent.mm.plugin.base.stub;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.R;
import com.tencent.mm.g.a.gh;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.d;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity$a;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.q;
import com.tencent.mm.z.u;
import java.util.ArrayList;
import java.util.List;

@JgClassChecked(author = 50, fComment = "checked", lastDate = "20141016", reviewer = 50, vComment = {EType.ACTIVITYCHECK})
public class WXCustomSchemeEntryActivity extends AutoLoginActivity {
    private List<String> kvm;

    public void onCreate(Bundle bundle) {
        x.i("MicroMsg.WXCustomSchemeEntryActivity", "onCreate");
        this.kvm = new ArrayList();
        this.kvm.add("cardpackage");
        this.kvm.add("connectToFreeWifi");
        this.kvm.add("wap");
        super.onCreate(bundle);
        setTitleVisibility(0);
    }

    protected final int getLayoutId() {
        return R.i.dbq;
    }

    protected final boolean z(Intent intent) {
        Uri data;
        try {
            data = getIntent().getData();
        } catch (Exception e) {
            x.e("MicroMsg.WXCustomSchemeEntryActivity", "get url from intent failed : %s", e.getMessage());
            data = null;
        }
        if (data != null) {
            if (d.Re(data.toString())) {
                return true;
            }
            String scheme = data.getScheme();
            String host = data.getHost();
            String query = data.getQuery();
            x.i("MicroMsg.WXCustomSchemeEntryActivity", "uri is %s,scheme is %s, host is %s, query is %s", data.toString(), scheme, host, query);
            if (!bh.ov(host) && this.kvm.contains(host)) {
                x.i("MicroMsg.WXCustomSchemeEntryActivity", "match the host : %s", host);
                if (host.equals("cardpackage")) {
                    scheme = data.getQueryParameter("encrystr");
                    x.i("MicroMsg.WXCustomSchemeEntryActivity", "card encrypt value = %s", scheme);
                    if (!bh.ov(scheme) && scheme.length() < WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
                        return true;
                    }
                }
                if (host.equals("connectToFreeWifi")) {
                    if (!bh.ov(query) && query.startsWith("apKey=") && query.length() > 6) {
                        scheme = query.substring(6);
                        x.i("MicroMsg.WXCustomSchemeEntryActivity", "apKey value = %s", scheme);
                        if (!bh.ov(scheme) && scheme.length() < WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
                            return true;
                        }
                    } else if (data.toString().startsWith("weixin://connectToFreeWifi/friendWifi")) {
                        return true;
                    }
                }
                if (host.equals("wap") && data.toString().startsWith("weixin://wap/pay")) {
                    x.i("MicroMsg.WXCustomSchemeEntryActivity", "preLogin for WX_WAP_PAY");
                    return true;
                }
            }
        }
        finish();
        return false;
    }

    protected final void a(AutoLoginActivity$a autoLoginActivity$a, Intent intent) {
        switch (5.kuV[autoLoginActivity$a.ordinal()]) {
            case 1:
                Uri data;
                try {
                    data = getIntent().getData();
                } catch (Exception e) {
                    x.e("MicroMsg.WXCustomSchemeEntryActivity", "post login get url from intent failed : %s", e.getMessage());
                    data = null;
                }
                if (data != null) {
                    Object obj;
                    if (data != null) {
                        int i = 2;
                        if (intent != null) {
                            i = t.a(intent, "translate_link_scene", 2);
                        }
                        int a = t.a(intent, "pay_channel", -1);
                        x.i("MicroMsg.WXCustomSchemeEntryActivity", "translateLinkScene = %d, payChannel = %d", Integer.valueOf(i), Integer.valueOf(a));
                        Bundle bundle = null;
                        if (a >= 0) {
                            x.i("MicroMsg.WXCustomSchemeEntryActivity", "doTicketsDeepLink put paychannel to extraData: %s", Integer.valueOf(a));
                            bundle = new Bundle();
                            bundle.putInt("pay_channel", a);
                        }
                        String host;
                        if (!d.Re(data.toString())) {
                            String scheme = data.getScheme();
                            host = data.getHost();
                            Object query = data.getQuery();
                            x.i("MicroMsg.WXCustomSchemeEntryActivity", "scheme is %s, host is %s, query is %s", scheme, host, query);
                            if (!bh.ov(host) && this.kvm.contains(host)) {
                                if (host.equals("cardpackage") && !bh.ov(data.getQueryParameter("encrystr"))) {
                                    intent.setClassName(this, "com.tencent.mm.ui.CheckSmsCanAddCardUI");
                                    startActivity(intent);
                                }
                                if (host.equals("connectToFreeWifi")) {
                                    if (!bh.ov(query) && query.startsWith("apKey=")) {
                                        scheme = data.getQueryParameter("apKey");
                                        x.i("MicroMsg.WXCustomSchemeEntryActivity", "apKey value = %s", scheme);
                                        String queryParameter = data.getQueryParameter("ticket");
                                        if (!bh.ov(scheme) && scheme.length() < WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
                                            Intent intent2 = new Intent();
                                            intent2.putExtra("free_wifi_schema_uri", data.toString());
                                            intent2.putExtra("free_wifi_ap_key", scheme);
                                            intent2.putExtra("free_wifi_source", 5);
                                            intent2.putExtra("free_wifi_threeone_startup_type", 1);
                                            if (!bh.ov(queryParameter)) {
                                                intent2.putExtra("free_wifi_schema_ticket", queryParameter);
                                            }
                                            if (scheme.startsWith("_") || bh.ov(queryParameter)) {
                                                intent2.addFlags(67108864);
                                                com.tencent.mm.bm.d.b(this, "freewifi", ".ui.FreeWifiEntryUI", intent2);
                                            } else {
                                                b ghVar = new gh();
                                                ghVar.fws.intent = intent2;
                                                a.xef.m(ghVar);
                                            }
                                        }
                                    } else if (data.toString().startsWith("weixin://connectToFreeWifi/friendWifi")) {
                                        Intent intent3 = new Intent();
                                        intent3.putExtra("key_connected_router", data.toString());
                                        com.tencent.mm.bm.d.b(this, "exdevice", ".ui.ExdeviceConnectedRouterActivateStateUI", intent3);
                                        x.i("MicroMsg.WXCustomSchemeEntryActivity", "Jump to ExdeviceConnectedRouterUi.");
                                    }
                                }
                                if (host.equals("wap") && data.toString().startsWith("weixin://wap/pay")) {
                                    x.i("MicroMsg.WXCustomSchemeEntryActivity", "postLogin for WX_WAP_PAY");
                                    if (!TextUtils.isEmpty(query)) {
                                        h.a((Context) this, com.tencent.mm.pluginsdk.f.a.Rp(query), false);
                                    }
                                }
                            }
                        } else if (d.j(data)) {
                            x.i("MicroMsg.WXCustomSchemeEntryActivity", "isTicketLink uri:%s, %b", data.toString(), Boolean.valueOf(d.k(data)));
                            if (d.k(data)) {
                                d.a(this, data.toString(), i, bundle, new 1(this));
                                obj = 1;
                                if (obj != null) {
                                    return;
                                }
                            }
                            d.a(this, data.toString(), i, bundle, new 2(this));
                        } else if (d.Rf(data.toString())) {
                            if (i == 1) {
                                u.b hx = u.GK().hx("key_data_center_session_id");
                                if (hx == null) {
                                    x.e("MicroMsg.WXCustomSchemeEntryActivity", "null keyvalue for opensdk scene");
                                    finish();
                                } else {
                                    x.i("MicroMsg.WXCustomSchemeEntryActivity", "pkg = %s, sig = %s, intentpkg = %s, intentsig = %s", hx.getString("key_package_name", ""), hx.getString("key_package_signature", ""), intent.getStringExtra("key_package_name"), intent.getStringExtra("key_package_signature"));
                                    u.GK().hy("key_data_center_session_id");
                                    if (!(hx.getString("key_package_name", "").equals(intent.getStringExtra("key_package_name")) && r1.equals(r6))) {
                                        x.e("MicroMsg.WXCustomSchemeEntryActivity", "signature or package check failed");
                                        finish();
                                    }
                                }
                            }
                            d.a(this, data.toString(), i, bundle, new 3(this), intent.getStringExtra("key_package_name"), intent.getStringExtra("key_package_signature"));
                            obj = 1;
                            if (obj != null) {
                                return;
                            }
                        } else {
                            host = q.FS();
                            x.i("MicroMsg.WXCustomSchemeEntryActivity", "not TicketLink uri:%s", data.toString());
                            d.a(this, data.toString(), host, 23, data.toString(), new 4(this));
                        }
                    }
                    obj = null;
                    if (obj != null) {
                        return;
                    }
                }
                break;
        }
        finish();
    }
}
