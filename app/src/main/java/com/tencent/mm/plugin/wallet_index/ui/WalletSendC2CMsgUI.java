package com.tencent.mm.plugin.wallet_index.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.ae.k;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@a(7)
public class WalletSendC2CMsgUI extends WalletBaseUI {
    private int irz;
    private Map<String, String> tbk = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        uD(8);
        this.irz = getIntent().getIntExtra("key_scene", 0);
        x.i("MicroMsg.WalletSendC2CMsgUI", "scene:" + this.irz);
        if (this.irz == 0) {
            ji(580);
            if (getIntent() == null) {
                x.e("MicroMsg.WalletSendC2CMsgUI", "func[doCheckPayNetscene] intent null");
                setResult(DownloadResult.CODE_UNDEFINED);
                finish();
                return;
            }
            r(new com.tencent.mm.plugin.wallet_core.c.a(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra(SlookSmartClipMetaTag.TAG_TYPE_URL), 6, "getSendC2CMessageRequest", getIntent().getIntExtra("pay_channel", 0)));
        } else if (!Ny(null)) {
            x.d("MicroMsg.WalletSendC2CMsgUI", "doSendC2CMsg fail");
            setResult(DownloadResult.CODE_UNDEFINED);
            finish();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        jj(580);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        boolean z = false;
        if (i == 0 && i2 == 0) {
            if (kVar instanceof com.tencent.mm.plugin.wallet_core.c.a) {
                x.i("MicroMsg.WalletSendC2CMsgUI", "Check jsapi suc & Go Select Contact");
                f.Ta(((com.tencent.mm.plugin.wallet_core.c.a) kVar).bKH());
                x.i("MicroMsg.WalletSendC2CMsgUI", "doCallSelectConversationUI");
                Map bNq = bNq();
                if (bNq != null && bNq.containsKey("togroup") && "0".equals(bNq.get("togroup"))) {
                    z = true;
                }
                Intent intent = new Intent();
                int i3 = z ? 7 : 3;
                intent.putExtra("select_is_ret", true);
                intent.putExtra("Select_Conv_Type", i3);
                d.a((Context) this, ".ui.transmit.SelectConversationUI", intent, 1);
                return true;
            } else if (kVar instanceof com.tencent.mm.plugin.wallet_index.c.f) {
                x.i("MicroMsg.WalletSendC2CMsgUI", "Send c2c msg suc");
                if (this.irz == 1) {
                    h.bu(this, getString(i.uWI));
                } else {
                    h.bu(this, getString(i.epb));
                    setResult(-1);
                }
                finish();
                return true;
            }
        } else if (kVar instanceof com.tencent.mm.plugin.wallet_core.c.a) {
            x.e("MicroMsg.WalletSendC2CMsgUI", "Check jsapi fail");
            setResult(DownloadResult.CODE_UNDEFINED);
            finish();
            return true;
        } else if (kVar instanceof com.tencent.mm.plugin.wallet_index.c.f) {
            if (this.irz == 1) {
                h.bu(this, str);
            } else {
                setResult(DownloadResult.CODE_UNDEFINED);
            }
            finish();
            return true;
        } else {
            setResult(DownloadResult.CODE_UNDEFINED);
            finish();
        }
        return false;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent != null) {
            x.d("MicroMsg.WalletSendC2CMsgUI", "onActivityResult, requestCode = " + i + ", resultCode = " + i2 + ", data = " + intent.toString());
        } else {
            x.e("MicroMsg.WalletSendC2CMsgUI", "onActivityResult, requestCode = " + i + ", resultCode = " + i2 + ", data = null");
        }
        if (i != 1) {
            x.e("MicroMsg.WalletSendC2CMsgUI", "onActivityResult, unknown requestCode = " + i);
        } else if (i2 != -1 || intent == null) {
            x.e("MicroMsg.WalletSendC2CMsgUI", "cancel select contact fail");
            setResult(0);
            finish();
        } else {
            String stringExtra = intent.getStringExtra("Select_Conv_User");
            x.d("MicroMsg.WalletSendC2CMsgUI", "Select user , " + bh.ou(stringExtra));
            if (!Ny(stringExtra)) {
                x.e("MicroMsg.WalletSendC2CMsgUI", "doSendC2CMsg fail");
                setResult(DownloadResult.CODE_UNDEFINED);
                finish();
            }
        }
    }

    protected final int getLayoutId() {
        return -1;
    }

    private boolean Ny(String str) {
        String stringExtra;
        String stringExtra2;
        String encode;
        String stringExtra3;
        String stringExtra4;
        String stringExtra5;
        String str2;
        String str3 = null;
        if (this.irz == 1) {
            str = getIntent().getStringExtra("key_receiver");
            stringExtra = getIntent().getStringExtra("key_sender_des");
            stringExtra2 = getIntent().getStringExtra("key_receiver_des");
            encode = URLEncoder.encode(getIntent().getStringExtra("key_url"));
            stringExtra3 = getIntent().getStringExtra("key_templateid");
            str3 = getIntent().getStringExtra("key_sceneid");
            stringExtra4 = getIntent().getStringExtra("key_receivertitle");
            stringExtra5 = getIntent().getStringExtra("key_sendertitle");
            str2 = str;
        } else {
            Map bNq = bNq();
            if (bNq == null || bh.ov(str)) {
                stringExtra3 = null;
                encode = null;
                stringExtra2 = null;
                stringExtra = null;
                stringExtra5 = null;
                stringExtra4 = null;
                str2 = str;
            } else {
                stringExtra4 = URLDecoder.decode(bh.ou((String) bNq.get("receivertitle")));
                stringExtra5 = URLDecoder.decode(bh.ou((String) bNq.get("sendertitle")));
                stringExtra = URLDecoder.decode(bh.ou((String) bNq.get("senderdes")));
                stringExtra2 = URLDecoder.decode(bh.ou((String) bNq.get("receiverdes")));
                encode = bh.ou((String) bNq.get(SlookSmartClipMetaTag.TAG_TYPE_URL));
                stringExtra3 = URLDecoder.decode(bh.ou((String) bNq.get("templateid")));
                str3 = URLDecoder.decode(bh.ou((String) bNq.get("senceid")));
                str2 = str;
            }
        }
        if (bh.ov(encode) || bh.ov(stringExtra3)) {
            x.w("MicroMsg.WalletSendC2CMsgUI", "url = " + bh.ov(encode) + "templateId=" + bh.ov(stringExtra3));
            return false;
        }
        x.d("MicroMsg.WalletSendC2CMsgUI", "send c2c msg to" + str2);
        l(new com.tencent.mm.plugin.wallet_index.c.f(str2, stringExtra4, stringExtra5, stringExtra3, stringExtra, stringExtra2, encode, str3));
        return true;
    }

    private Map<String, String> bNq() {
        if (this.tbk == null) {
            String stringExtra = getIntent().getStringExtra("packageExt");
            x.d("MicroMsg.WalletSendC2CMsgUI", "func[getPackageData] packageExt: " + stringExtra);
            if (!bh.ov(stringExtra)) {
                String[] split = stringExtra.split("&");
                this.tbk = new HashMap();
                if (split != null && split.length > 0) {
                    for (int i = 0; i < split.length; i++) {
                        if (!bh.ov(split[i])) {
                            String[] split2 = split[i].split("=");
                            if (split2.length == 2 && !bh.ov(split2[0])) {
                                this.tbk.put(split2[0], split2[1]);
                            }
                        }
                    }
                }
            }
        }
        return this.tbk;
    }
}
