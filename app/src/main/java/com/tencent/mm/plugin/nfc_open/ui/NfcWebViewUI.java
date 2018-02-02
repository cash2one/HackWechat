package com.tencent.mm.plugin.nfc_open.ui;

import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.nfc_open.a.a;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.protocal.c.atk;
import com.tencent.mm.protocal.c.kf;
import com.tencent.mm.protocal.c.ok;
import com.tencent.mm.protocal.c.pi;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.regex.Pattern;

public class NfcWebViewUI extends WebViewUI {
    private String oSi = null;
    private boolean oSj = false;
    private a oSk = new a();

    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (R(intent)) {
            x.e("MicroMsg.NfcWebViewUI", "onCreate judgeIllegalCall finish");
            intent.putExtra("key_trust_url", false);
            super.onCreate(bundle);
            finish();
            return;
        }
        intent.putExtra("key_trust_url", false);
        super.onCreate(bundle);
        com.tencent.mm.sdk.b.a.xef.b(this.oSk);
        d.ccW();
        x.i("MicroMsg.NfcWebViewUI", "onCreate, intent action = " + intent.getAction());
        setBackBtn(new OnMenuItemClickListener(this) {
            final /* synthetic */ NfcWebViewUI oSl;

            {
                this.oSl = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (this.oSl.oSj) {
                    this.oSl.bfB();
                } else {
                    this.oSl.finish();
                }
                return true;
            }
        });
        getIntent().putExtra("showShare", false);
        kt(false);
    }

    @TargetApi(11)
    protected void onDestroy() {
        super.onDestroy();
        com.tencent.mm.sdk.b.a.xef.c(this.oSk);
    }

    protected final void akN() {
        if (bfz()) {
            finish();
            x.w("MicroMsg.NfcWebViewUI", "not login, go to SimpleLogin");
            return;
        }
        super.akN();
        a(AutoLoginActivity.a.vjh, getIntent());
    }

    public void onNewIntent(Intent intent) {
        if (R(intent)) {
            x.e("MicroMsg.NfcWebViewUI", "onNewIntent judgeIllegalCall finish");
            return;
        }
        intent.putExtra("key_trust_url", false);
        super.onNewIntent(intent);
        setIntent(intent);
        int a = t.a(intent, "wizard_activity_result_code", Integer.MAX_VALUE);
        x.i("MicroMsg.NfcWebViewUI", "onNewIntent, resultCode = " + a);
        if (a != Integer.MAX_VALUE) {
            this.oSj = true;
        }
        switch (a) {
            case -1:
                a(AutoLoginActivity.a.vjh, intent);
                break;
            case 0:
                bfz();
                return;
            case 1:
                a(AutoLoginActivity.a.vjj, intent);
                break;
        }
        hb(true);
        x.i("Foreground dispatch", "Discovered tag with intent: " + intent);
    }

    private boolean bfz() {
        try {
            if (!this.juQ.bSb()) {
                return false;
            }
            x.w("MicroMsg.NfcWebViewUI", "not login");
            Intent intent = new Intent(this, getClass());
            intent.putExtras(getIntent());
            intent.addFlags(67108864);
            this.juQ.aa(intent);
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NfcWebViewUI", e, "", new Object[0]);
            return true;
        }
    }

    private void a(AutoLoginActivity.a aVar, Intent intent) {
        switch (3.kuV[aVar.ordinal()]) {
            case 1:
                Tag tag;
                Parcelable parcelableExtra = intent.getParcelableExtra("android.nfc.extra.TAG");
                if (parcelableExtra == null || !(parcelableExtra instanceof Tag)) {
                    tag = null;
                } else {
                    tag = (Tag) parcelableExtra;
                }
                if (tag == null) {
                    x.e("MicroMsg.NfcWebViewUI", "[NFC]tag is null");
                    return;
                }
                try {
                    com.tencent.mm.plugin.nfc.c.a.a.bfv().a(tag);
                    x.i("MicroMsg.NfcWebViewUI", "[NFC] connect status : " + com.tencent.mm.plugin.nfc.c.a.a.bfv().dj(this.mController.xIM));
                    return;
                } catch (Exception e) {
                    x.e("MicroMsg.NfcWebViewUI", "exp protect");
                    return;
                }
            default:
                finish();
                return;
        }
    }

    protected final void hb(boolean z) {
        if (this.juQ == null) {
            x.e("MicroMsg.NfcWebViewUI", "[NFC] invoker is null");
            return;
        }
        a(AutoLoginActivity.a.vjh, getIntent());
        String bfA = bfA();
        String str = this.fIG;
        if (!z || bh.ov(this.fIG) || this.fIG.startsWith("https://support.weixin.qq.com/security/readtemplate?t=bus_recharge/index_error")) {
            this.fIG = bfA;
            if (bh.ov(this.fIG)) {
                this.fIG = tW(0);
                x.e("MicroMsg.NfcWebViewUI", "[NFC] url not found! not support this card ?");
            }
            getIntent().putExtra("rawUrl", this.fIG);
            if (!this.fIG.equals(str)) {
                x.i("MicroMsg.NfcWebViewUI", "lo-nfc-dealwithNFC: onNewIntent load:" + this.fIG);
                this.ptK.loadUrl(this.fIG);
                return;
            }
            return;
        }
        try {
            int i;
            if (!bh.ov(bfA)) {
                try {
                    Uri parse = Uri.parse(bfA);
                    Uri parse2 = Uri.parse(this.fIG);
                    bfA = parse.getHost();
                    str = parse2.getHost();
                    x.i("MicroMsg.NfcWebViewUI", "targetHost=" + bfA + ", curHost=" + str);
                    if (bfA.equals(str)) {
                        i = 1;
                        if (i != 0) {
                            this.fBH.n(4007, new Bundle());
                        }
                        x.i("MicroMsg.NfcWebViewUI", "[NFC]new intent not guide the page");
                    }
                } catch (Exception e) {
                }
            }
            i = 0;
            if (i != 0) {
                this.fBH.n(4007, new Bundle());
            }
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.NfcWebViewUI", e2, "", new Object[0]);
        }
        x.i("MicroMsg.NfcWebViewUI", "[NFC]new intent not guide the page");
    }

    private static String tW(int i) {
        String str;
        StringBuilder stringBuilder = new StringBuilder("https://support.weixin.qq.com/security/readtemplate?t=bus_recharge/index_error");
        stringBuilder.append("&type=").append(i);
        if (!f.xeD && w.cfi().equals("zh_CN")) {
            str = "zh_CN";
        } else if (w.cfg()) {
            str = "zh_TW";
        } else {
            str = "en";
        }
        stringBuilder.append("&lang=").append(str);
        return stringBuilder.toString();
    }

    private String bfA() {
        String str = null;
        x.i("MicroMsg.NfcWebViewUI", "nfc-getNfcCpuCardGuideUrl start");
        try {
            Bundle e = this.juQ.e(4006, null);
            if (e == null) {
                x.i("MicroMsg.NfcWebViewUI", "nfc-getNfcCpuCardGuideUrl data is null");
                return str;
            }
            e.setClassLoader(getClass().getClassLoader());
            String string = e.getString("debugConfig");
            String string2 = e.getString("config");
            if (string != null) {
                str = GE(string);
            } else {
                str = GF(string2);
            }
            x.i("MicroMsg.NfcWebViewUI", "nfc-getNfcCpuCardGuideUrl targetUrl=" + bh.ou(str));
            return str;
        } catch (Throwable e2) {
            x.e("MicroMsg.NfcWebViewUI", e2.toString());
            x.printErrStackTrace("MicroMsg.NfcWebViewUI", e2, "", new Object[0]);
        }
    }

    private String GE(String str) {
        x.i("MicroMsg.NfcWebViewUI", "nfc-getDebugNfcCardGuideUrl start");
        this.oSi = "";
        try {
            String[] split = str.split(" ");
            if (split != null && split.length > 1) {
                boolean z = false;
                for (int i = 0; i < split.length - 1; i = (i + 1) + 1) {
                    String str2 = split[i];
                    String str3 = split[i + 1];
                    x.d("MicroMsg.NfcWebViewUI", "nfc-getDebugNfcCardGuideUrl cmd = " + str2 + " anwser = " + str3);
                    z = a(new com.tencent.mm.plugin.nfc.a.a(com.tencent.mm.plugin.nfc.d.a.hexStringToByteArray(str2)), str3);
                    if (!z) {
                        break;
                    }
                }
                if (z) {
                    this.oSi = split[split.length - 1];
                    x.d("MicroMsg.NfcWebViewUI", "nfc-getDebugNfcCardGuideUrl tempurl = " + this.oSi);
                    return this.oSi;
                }
            }
            return this.oSi;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NfcWebViewUI", e, "", new Object[0]);
            x.e("MicroMsg.NfcWebViewUI", "[NFC] Debug get nfc card type exception!" + e.toString());
            x.e("MicroMsg.NfcWebViewUI", "isConnect:" + com.tencent.mm.plugin.nfc.c.a.a.bfv().di(this.mController.xIM));
            this.oSi = tW(1);
            return this.oSi;
        }
    }

    private String GF(String str) {
        x.i("MicroMsg.NfcWebViewUI", "nfc-getCommonNfcCardGuideUrl start");
        this.oSi = "";
        atk com_tencent_mm_protocal_c_atk = new atk();
        if (!bh.ov(str)) {
            try {
                com_tencent_mm_protocal_c_atk.aF(str.getBytes("ISO-8859-1"));
                if (com_tencent_mm_protocal_c_atk.vYo != null) {
                    int i = 0;
                    int i2 = 0;
                    while (i2 < com_tencent_mm_protocal_c_atk.vYo.size()) {
                        kf kfVar = (kf) com_tencent_mm_protocal_c_atk.vYo.get(i2);
                        com.tencent.mm.plugin.nfc.c.a.a bfv = com.tencent.mm.plugin.nfc.c.a.a.bfv();
                        if (bfv.oRX != null) {
                            bfv.oRX.bfw();
                        }
                        if (!(kfVar == null || bh.ov(kfVar.vDi) || bh.cA(kfVar.vQU))) {
                            String str2;
                            int i3 = 0;
                            int i4 = i;
                            while (i3 < kfVar.vQU.size()) {
                                if (!bh.cA(((pi) kfVar.vQU.get(i3)).vYr)) {
                                    int i5 = 0;
                                    while (i5 < ((pi) kfVar.vQU.get(i3)).vYr.size()) {
                                        if (((pi) kfVar.vQU.get(i3)).vYr.get(i5) != null && !bh.ov(((ok) ((pi) kfVar.vQU.get(i3)).vYr.get(i5)).vXo) && !bh.ov(((ok) ((pi) kfVar.vQU.get(i3)).vYr.get(i5)).ocF)) {
                                            String str3 = ((ok) ((pi) kfVar.vQU.get(i3)).vYr.get(i5)).vXo;
                                            str2 = ((ok) ((pi) kfVar.vQU.get(i3)).vYr.get(i5)).ocF;
                                            x.d("MicroMsg.NfcWebViewUI", "nfc-getCommonNfcCardGuideUrl cmd = " + str3 + " anwser = " + str2);
                                            if (!a(new com.tencent.mm.plugin.nfc.a.a(com.tencent.mm.plugin.nfc.d.a.hexStringToByteArray(str3)), str2)) {
                                                i = 0;
                                                break;
                                            }
                                            i = 1;
                                        } else {
                                            i = i4;
                                        }
                                        i5++;
                                        i4 = i;
                                    }
                                    i = i4;
                                    if (i != 0) {
                                        break;
                                    }
                                } else {
                                    i = i4;
                                }
                                i3++;
                                i4 = i;
                            }
                            i = i4;
                            if (i != 0) {
                                str2 = kfVar.vDi;
                                x.i("MicroMsg.NfcWebViewUI", "doCardTypeReport start");
                                e.post(new 2(this, str2), getClass().getName());
                                return kfVar.vDi;
                            }
                        }
                        i2++;
                        i = i;
                    }
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.NfcWebViewUI", e, "", new Object[0]);
                x.e("MicroMsg.NfcWebViewUI", "[NFC] Common get nfc card type exception!" + e.toString());
                x.e("MicroMsg.NfcWebViewUI", "isConnect:" + com.tencent.mm.plugin.nfc.c.a.a.bfv().di(this.mController.xIM));
                this.oSi = tW(1);
                return this.oSi;
            }
        }
        return this.oSi;
    }

    private static boolean a(com.tencent.mm.plugin.nfc.a.a aVar, String str) {
        boolean z;
        x.i("MicroMsg.NfcWebViewUI", "nfc-doCmd start");
        CharSequence cVar = com.tencent.mm.plugin.nfc.c.a.a.bfv().a(aVar).toString();
        if (!bh.ov(cVar)) {
            x.d("MicroMsg.NfcWebViewUI", "nfc-judge mAnwser = " + bh.ou(str) + " resp = " + bh.ou(cVar));
            if (Pattern.compile(str, 2).matcher(cVar).find()) {
                z = true;
                if (z) {
                    return false;
                }
                return true;
            }
        }
        z = false;
        if (z) {
            return false;
        }
        return true;
    }

    public void onBackPressed() {
        if (this.oSj) {
            bfB();
        } else {
            super.onBackPressed();
        }
    }

    private void bfB() {
        Intent intent = new Intent();
        intent.addFlags(67108864);
        d.a(this, "com.tencent.mm.ui.LauncherUI", intent);
        finish();
        overridePendingTransition(R.a.bpQ, R.a.bql);
        x.i("MicroMsg.NfcWebViewUI", "lo-nfc-setBackBtn:back click after login");
    }

    private static boolean R(Intent intent) {
        if (intent == null) {
            x.e("MicroMsg.NfcWebViewUI", "intent is null");
            return true;
        }
        Tag tag;
        Iterator it = intent.getExtras().keySet().iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!(str == null || str.startsWith("android.nfc"))) {
                x.e("MicroMsg.NfcWebViewUI", "extra wrong key = " + str);
                it.remove();
            }
        }
        Parcelable parcelableExtra = intent.getParcelableExtra("android.nfc.extra.TAG");
        if (parcelableExtra == null || !(parcelableExtra instanceof Tag)) {
            tag = null;
        } else {
            tag = (Tag) parcelableExtra;
        }
        if (tag != null) {
            return false;
        }
        x.e("MicroMsg.NfcWebViewUI", "tag is null");
        return true;
    }
}
