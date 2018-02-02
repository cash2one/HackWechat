package com.tencent.mm.plugin.walletlock.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.soter.c.h;
import com.tencent.mm.plugin.walletlock.a$g;
import com.tencent.mm.plugin.walletlock.a$i;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.plugin.walletlock.b.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class WalletLockSettingUI extends MMPreference {
    private i ibT;
    private f ilB;
    private int irz = -1;
    private IconPreference thA;
    private boolean thB = false;
    private boolean thC = true;
    private boolean thD = true;
    private IconPreference thy;
    private IconPreference thz;

    public final int XB() {
        return a$i.tft;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setBackBtn(new OnMenuItemClickListener(this) {
            final /* synthetic */ WalletLockSettingUI thE;

            {
                this.thE = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (this.thE.thB) {
                    this.thE.q(0, 4, "user cancel setting wallet lock");
                } else {
                    this.thE.finish();
                }
                return false;
            }
        });
        setMMTitle(a$g.tfi);
        this.ilB = this.yjd;
        this.ilB = this.yjd;
        this.thy = (IconPreference) this.ilB.YN("wallet_lock_fingerprint");
        this.thz = (IconPreference) this.ilB.YN("wallet_lock_gesture");
        this.thA = (IconPreference) this.ilB.YN("wallet_lock_close");
        this.irz = getIntent().getIntExtra("key_wallet_lock_setting_scene", -1);
        if (this.irz == 1) {
            this.thB = true;
            this.thC = false;
        }
        x.i("MicroMsg.WalletLockSettingUI", "alvinluo isNeedFinish: %b, isNeedShowOpenIcon: %b", new Object[]{Boolean.valueOf(this.thB), Boolean.valueOf(this.thC)});
    }

    protected void onResume() {
        super.onResume();
        bOr();
    }

    protected void onPause() {
        super.onPause();
        if (this.ibT != null && this.ibT.isShowing()) {
            this.ibT.dismiss();
        }
    }

    public void onBackPressed() {
        x.i("MicroMsg.WalletLockSettingUI", "alvinluo onBackPressed");
        if (this.thB) {
            q(0, 4, "user cancel setting wallet lock");
        } else {
            finish();
        }
    }

    private void q(int i, int i2, String str) {
        Intent intent = new Intent();
        intent.putExtra("key_err_code", i2);
        intent.putExtra("key_err_msg", str);
        d(i, intent);
    }

    private void d(int i, Intent intent) {
        setResult(i, intent);
        finish();
    }

    private void bOr() {
        bOs();
        x.i("MicroMsg.WalletLockSettingUI", "alvinluo current wallet lock type: %d", new Object[]{Integer.valueOf(g.tho.bOh())});
        g gVar = g.tho;
        if (g.bOj()) {
            boolean bCT = h.bCT();
            g gVar2 = g.tho;
            if (g.bNC()) {
                if (!bCT) {
                    this.ilB.bk("wallet_lock_fingerprint", false);
                    this.thy.YQ(getString(a$g.teT));
                    this.thy.cqn();
                    a(this.thy, true, false);
                    this.thy.setEnabled(false);
                    this.thy.yiI = true;
                    this.thD = false;
                } else if (this.thC) {
                    this.ilB.bk("wallet_lock_fingerprint", false);
                    a(this.thy, true, true);
                }
            } else if (bCT) {
                this.ilB.bk("wallet_lock_fingerprint", false);
                a(this.thy, false, true);
            } else {
                this.ilB.bk("wallet_lock_fingerprint", true);
            }
        } else {
            x.w("MicroMsg.WalletLockSettingUI", "alvinluo FingerprintLock entry is not opened and don't show FingerprintLock entry");
            this.ilB.bk("wallet_lock_fingerprint", true);
        }
        Object[] objArr = new Object[1];
        g gVar3 = g.tho;
        objArr[0] = Boolean.valueOf(g.bNN());
        x.i("MicroMsg.WalletLockSettingUI", "alvinluo isUserSetGesturePwd: %b", objArr);
        if (g.tho.bOh() == 2 || g.tho.bOh() != 1) {
            a(this.thz, false, true);
            this.ilB.bk("wallet_lock_modify_gesture", true);
        } else if (this.thC) {
            a(this.thz, true, true);
            this.ilB.bk("wallet_lock_modify_gesture", false);
        }
        if (g.tho.bOh() != 0) {
            a(this.thA, false, true);
        } else if (this.thC) {
            a(this.thA, true, true);
        }
    }

    private void bOs() {
        if (this.thy != null && this.thD) {
            a(this.thy, false, this.thD);
        }
        if (this.thz != null) {
            a(this.thz, false, true);
        }
        if (this.thA != null) {
            a(this.thA, false, true);
        }
    }

    private void a(Preference preference, boolean z, boolean z2) {
        if (preference instanceof IconPreference) {
            IconPreference iconPreference = (IconPreference) preference;
            iconPreference.eX(a.fromDPToPix(this, 20), a.fromDPToPix(this, 20));
            if (z) {
                if (z2) {
                    iconPreference.Fa(com.tencent.mm.plugin.walletlock.a.f.dAr);
                } else {
                    iconPreference.Fa(com.tencent.mm.plugin.walletlock.a.f.teo);
                }
                iconPreference.Fb(0);
                return;
            }
            iconPreference.Fa(com.tencent.mm.plugin.walletlock.a.f.dAq);
            iconPreference.Fb(0);
        }
    }

    public final boolean a(f fVar, Preference preference) {
        if ("wallet_lock_fingerprint".equals(preference.ibD)) {
            bOs();
            a(preference, true, true);
            if (this.thD && !(this.thC && g.tho.bOh() == 2)) {
                if (!com.tencent.d.a.a.id(this)) {
                    this.ibT = com.tencent.mm.ui.base.h.a(this, getString(a$g.tff), "", new 2(this));
                    this.ibT.setCanceledOnTouchOutside(false);
                } else if (!(this.thC && g.tho.bOh() == 2)) {
                    x.i("MicroMsg.WalletLockSettingUI", "alvinluo request open fingerprint lock");
                    ((b) com.tencent.mm.kernel.g.h(b.class)).b(this, 2, 1);
                }
            }
            return true;
        } else if ("wallet_lock_gesture".equals(preference.ibD)) {
            bOs();
            a(preference, true, true);
            if (g.tho.bOh() != 1) {
                x.i("MicroMsg.WalletLockSettingUI", "alvinluo request open gesture lock");
                ((b) com.tencent.mm.kernel.g.h(b.class)).b(this, 1, 2);
            }
            return true;
        } else if ("wallet_lock_close".equals(preference.ibD)) {
            bOs();
            a(preference, true, true);
            if (g.tho.bOh() != 0) {
                x.i("MicroMsg.WalletLockSettingUI", "alvinluo request close wallet lock");
                ((b) com.tencent.mm.kernel.g.h(b.class)).k(this, 3);
            }
            return true;
        } else if (!"wallet_lock_modify_gesture".equals(preference.ibD)) {
            return false;
        } else {
            ((b) com.tencent.mm.kernel.g.h(b.class)).L(this);
            return true;
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.WalletLockSettingUI", "alvinluo onActivityResult requestCode: %d, resultCode: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (intent == null) {
            x.e("MicroMsg.WalletLockSettingUI", "alvinluo data is null");
            return;
        }
        int intExtra = intent.getIntExtra("key_err_code", -1);
        x.i("MicroMsg.WalletLockSettingUI", "alvinluo wallet lock setting onActivityResult errCode: %d", new Object[]{Integer.valueOf(intExtra)});
        if (i == 1) {
            x.i("MicroMsg.WalletLockSettingUI", "alvinluo request open fingerprint lock onActivityResult");
            if (intExtra == 0) {
                if (this.thB) {
                    d(i2, intent);
                }
            } else if (intExtra != 4) {
                x.i("MicroMsg.WalletLockSettingUI", "alvinluo open fingerprint lock failed");
                yE(getString(a$g.teU));
            }
        } else if (i == 2) {
            x.i("MicroMsg.WalletLockSettingUI", "alvinluo request open gesture onActivityResult");
            if (intExtra == 0) {
                if (this.thB) {
                    d(i2, intent);
                }
            } else if (intExtra != 4) {
                x.i("MicroMsg.WalletLockSettingUI", "alvinluo open gesture lock failed");
                yE(getString(a$g.tfd));
            }
        } else if (i != 3) {
        } else {
            if (intExtra == 0) {
                ((b) com.tencent.mm.kernel.g.h(b.class)).zu(0);
                g gVar = g.tho;
                g.bNE();
                bOr();
                Toast.makeText(this, getString(a$g.teR), 0).show();
                com.tencent.mm.plugin.walletlock.b.h.bOl();
                if (this.thB) {
                    q(-1, 0, "close wallet lock ok");
                }
            } else if (intExtra != 4) {
                yE(getString(a$g.teS));
            }
        }
    }

    private void yE(String str) {
        this.ibT = com.tencent.mm.ui.base.h.a(this, str, "", new 3(this));
        this.ibT.setCanceledOnTouchOutside(false);
        this.ibT.show();
    }
}
