package com.tencent.mm.plugin.offline.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.ae.k;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.gi;
import com.tencent.mm.plugin.appbrand.jsapi.ap;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;

@a(7)
public class WalletOfflineEntranceUI extends WalletBaseUI {
    private int hze = -1;
    private int irz;
    boolean oZg = true;
    private boolean oZh = false;
    private c<gi> oZi = new 1(this);

    protected final int getLayoutId() {
        return g.uFo;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mm.wallet_core.c.a.cBn();
        com.tencent.mm.wallet_core.c.a.init(getApplicationContext());
        this.oZi.ceO();
        bhG();
    }

    private void bhG() {
        x.v("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI onCreate()");
        i.i(this, 1);
        e.HF(30);
        if (getIntent() != null) {
            int intExtra = getIntent().getIntExtra("key_from_scene", 0);
            x.i("MicroMsg.WalletOfflineEntranceUI", "parserCardData(), scene is " + intExtra);
            if (intExtra == 3) {
                com.tencent.mm.plugin.offline.c.a.oZq = intExtra;
                intExtra = getIntent().getIntExtra("key_expire_time", 0);
                long longExtra = getIntent().getLongExtra("key_begin_time", 0);
                boolean booleanExtra = getIntent().getBooleanExtra("key_is_mark", false);
                x.i("MicroMsg.WalletOfflineEntranceUI", "expire_time:" + intExtra + " beginTime:" + longExtra + " isMark:" + booleanExtra);
                com.tencent.mm.plugin.offline.c.a.oZr = intExtra;
                com.tencent.mm.plugin.offline.c.a.oZs = longExtra;
                com.tencent.mm.plugin.offline.c.a.oZt = booleanExtra;
                com.tencent.mm.plugin.offline.c.a.kIw = getIntent().getStringExtra("key_card_id");
                com.tencent.mm.plugin.offline.c.a.oZu = getIntent().getStringExtra("key_user_card_id");
                com.tencent.mm.plugin.offline.c.a.oZv = getIntent().getStringExtra("key_card_code");
            } else if (intExtra == 1 || intExtra == 2 || intExtra == 4) {
                com.tencent.mm.plugin.offline.c.a.oZq = intExtra;
                com.tencent.mm.plugin.offline.c.a.oZr = 0;
                com.tencent.mm.plugin.offline.c.a.oZs = 0;
                com.tencent.mm.plugin.offline.c.a.oZt = false;
                com.tencent.mm.plugin.offline.c.a.kIw = "";
                com.tencent.mm.plugin.offline.c.a.oZu = "";
                com.tencent.mm.plugin.offline.c.a.oZv = "";
            }
        }
        this.irz = getIntent().getIntExtra("key_from_scene", 0);
        if (getIntent().getBooleanExtra("is_offline_create", false) || !(this.irz == 6 || this.irz == 7)) {
            init();
            this.oZg = false;
            return;
        }
        k aVar;
        x.i("MicroMsg.WalletOfflineEntranceUI", "from h5 or wxapp check sign: %s", new Object[]{Integer.valueOf(this.irz)});
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("appId");
        String stringExtra2 = intent.getStringExtra("timeStamp");
        String stringExtra3 = intent.getStringExtra("nonceStr");
        String stringExtra4 = intent.getStringExtra("packageExt");
        String stringExtra5 = intent.getStringExtra("signtype");
        String stringExtra6 = intent.getStringExtra("paySignature");
        int intExtra2 = intent.getIntExtra("pay_channel", 0);
        if (this.irz == 6) {
            aVar = new com.tencent.mm.plugin.wallet_core.c.a(stringExtra, stringExtra2, stringExtra3, stringExtra4, stringExtra5, stringExtra6, intent.getStringExtra(SlookSmartClipMetaTag.TAG_TYPE_URL), 16, ap.NAME, intExtra2);
        } else {
            aVar = new com.tencent.mm.plugin.wallet_core.c.a(stringExtra, stringExtra2, stringExtra3, stringExtra4, stringExtra5, stringExtra6, intent.getStringExtra("wxapp_username"), intent.getStringExtra("wxapp_path"), ap.NAME, intExtra2);
        }
        ji(580);
        b(aVar, true);
        this.oZg = false;
    }

    public void onDestroy() {
        super.onDestroy();
        this.oZi.dead();
    }

    private void init() {
        int i = 3;
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("key_from_scene")) {
            int intExtra = intent.getIntExtra("key_from_scene", 0);
            if (intExtra == 1) {
                this.hze = 1;
                i = 2;
            } else if (intExtra == 2) {
                this.hze = 2;
                i = 1;
            } else if (intExtra == 3) {
                this.hze = 3;
            } else if (intExtra == 4) {
                this.hze = 4;
                i = 6;
            } else if (intExtra == 5) {
                this.hze = 8;
                i = 4;
            } else if (intExtra == 6) {
                this.hze = 10;
                i = 7;
            } else if (intExtra == 7) {
                this.hze = 11;
                i = 8;
            } else {
                this.hze = 0;
                x.i("MicroMsg.WalletOfflineEntranceUI", "unknown scene: %d", new Object[]{Integer.valueOf(intExtra)});
                i = 1;
            }
            com.tencent.mm.plugin.report.service.g.pQN.h(14021, new Object[]{Integer.valueOf(1), Integer.valueOf(i)});
        }
        if (o.bLq().bLL()) {
            x.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI isDataInvalid()");
            b(new com.tencent.mm.plugin.wallet_core.c.x(null, 8), true);
            this.oZg = false;
            return;
        }
        Intent intent2 = new Intent();
        intent2.putExtra("key_entry_scene", this.hze);
        intent2.putExtra("key_from_scene", this.irz);
        String stringExtra = getIntent().getStringExtra("key_business_attach");
        if (!bh.ov(stringExtra)) {
            intent2.putExtra("key_business_attach", stringExtra);
        }
        intent2.putExtra("is_offline_create", getIntent().getBooleanExtra("is_offline_create", false));
        d.b(this.mController.xIM, "offline", ".ui.WalletOfflineCoinPurseUI", intent2, 1);
    }

    public void onResume() {
        super.onResume();
        x.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI onResume()");
        if (this.oZg) {
            x.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI isShouldFinishOnResume is true , finish activity");
            if (com.tencent.mm.plugin.offline.c.a.bhH()) {
                x.v("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI isOfflineCreate() true");
                Intent intent = new Intent();
                intent.putExtra("key_entry_scene", this.hze);
                intent.putExtra("key_from_scene", 0);
                return;
            }
            x.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI isOfflineCreate() false");
            return;
        }
        x.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI isShouldFinishOnResume is false , not finish activity");
        this.oZg = true;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1 && i2 == -1) {
            x.i("MicroMsg.WalletOfflineEntranceUI", "do not finish");
        } else {
            finish();
        }
        super.onActivityResult(i, i2, intent);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (kVar instanceof com.tencent.mm.plugin.wallet_core.c.a) {
            if (i == 0 && i2 == 0) {
                x.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI onSceneEnd SUCC");
                f.Ta(((com.tencent.mm.plugin.wallet_core.c.a) kVar).bKH());
                init();
                if (this.irz != 6 && this.irz != 7) {
                    return true;
                }
                Intent intent = new Intent();
                if (this.oZh) {
                    intent.putExtra("key_callback", "return");
                } else {
                    intent.putExtra("key_callback", "ok");
                }
                setResult(-1, intent);
                return true;
            }
            x.i("MicroMsg.WalletOfflineEntranceUI", "net error: %d, %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            if (this.irz == 6 || this.irz == 7) {
                Intent intent2 = new Intent();
                intent2.putExtra("key_callback", "fail");
                setResult(0, intent2);
            }
            finish();
            return true;
        } else if (i == 0 && i2 == 0) {
            x.i("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI onSceneEnd SUCC");
            init();
            return true;
        } else {
            x.i("MicroMsg.WalletOfflineEntranceUI", "net error: %d, %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            init();
            x.e("MicroMsg.WalletOfflineEntranceUI", "WalletOfflineEntranceUI onSceneEnd FAIL");
            finish();
            return false;
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            finish();
        }
        return true;
    }

    protected void onNewIntent(Intent intent) {
        x.i("MicroMsg.WalletOfflineEntranceUI", "onNewIntent");
        if (intent == null || !intent.hasExtra("is_offline_create")) {
            this.oZg = false;
            this.oZh = true;
            setIntent(intent);
            bhG();
            return;
        }
        this.oZg = true;
        this.oZh = true;
        setIntent(intent);
        bhG();
    }
}
