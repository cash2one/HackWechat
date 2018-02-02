package com.tencent.mm.plugin.wallet_core.id_verify;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet_core.c.a;
import com.tencent.mm.plugin.wallet_core.id_verify.model.b;
import com.tencent.mm.plugin.wallet_core.ui.o;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import org.json.JSONObject;

public class SwitchRealnameVerifyModeUI extends WalletBaseUI implements OnClickListener {
    private int hze = 0;
    private o omB = new o();
    private boolean sIl = false;
    private boolean sJA = false;
    private int sJk = 500;
    private long sJl = 0;
    private View sJm;
    private View sJn;
    private View sJo;
    private TextView sJp;
    private TextView sJq;
    private TextView sJr;
    private TextView sJs;
    private TextView sJt;
    private TextView sJu;
    private TextView sJv;
    private String sJw;
    private String sJx;
    private String sJy;
    private boolean sJz;

    public void onResume() {
        super.onResume();
        this.omB.onResume();
    }

    public void onPause() {
        super.onPause();
        this.omB.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.sJA = this.vf.getBoolean("key_from_set_pwd", false);
        initView();
        cCc();
        this.hze = this.vf.getInt("entry_scene", this.hze);
        e.a(13, bh.Wo(), this.hze);
        if (this.sJA) {
            setMMTitle(i.uVC);
        }
        this.omB.sWX = new 1(this);
    }

    protected final void initView() {
        setMMTitle(i.uVB);
        this.sJm = findViewById(f.uwI);
        this.sJn = findViewById(f.uwJ);
        this.sJo = findViewById(f.uwK);
        this.sJn.setOnClickListener(this);
        this.sJm.setOnClickListener(this);
        this.sJo.setOnClickListener(this);
        this.sJp = (TextView) findViewById(f.ufG);
        this.sJq = (TextView) findViewById(f.ufF);
        this.sJr = (TextView) findViewById(f.ufJ);
        this.sJs = (TextView) findViewById(f.ufI);
        this.sJt = (TextView) findViewById(f.ukd);
        this.sJu = (TextView) findViewById(f.uxs);
        this.sJv = (TextView) findViewById(f.uxr);
        if (this.sJA) {
            ((TextView) findViewById(f.uwH)).setText(i.uVD);
        }
        jI(false);
        k bVar = new b();
        ji(1666);
        l(bVar);
        setBackBtn(new OnMenuItemClickListener(this) {
            final /* synthetic */ SwitchRealnameVerifyModeUI sJB;

            {
                this.sJB = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                c cCc = this.sJB.cCc();
                if (cCc != null) {
                    e.a(14, bh.Wo(), this.sJB.hze);
                    cCc.d(this.sJB, 0);
                    return true;
                }
                this.sJB.finish();
                return false;
            }
        });
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (kVar instanceof a) {
            if (i == 0 && i2 == 0) {
                com.tencent.mm.pluginsdk.wallet.f.Ta(((a) kVar).bKH());
                jj(580);
                ((a) kVar).bhV();
                c cCc = cCc();
                if (cCc != null) {
                    Bundle bundle = cCc.msB;
                    bundle.putInt("real_name_verify_mode", 1);
                    com.tencent.mm.wallet_core.a.j(this, bundle);
                }
                return true;
            }
        } else if (kVar instanceof b) {
            jj(1666);
            jI(true);
            this.sIl = ((b) kVar).sIl;
        }
        return false;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 1) {
            return;
        }
        if (i2 == -1) {
            this.omB.aYr();
        } else {
            this.omB.cancel();
        }
    }

    protected final int getLayoutId() {
        return g.uFJ;
    }

    public void onClick(View view) {
        if (System.currentTimeMillis() - this.sJl <= ((long) this.sJk)) {
            x.e("MicroMsg.SwitchRealnameVerifyModeUI", "process pass");
            return;
        }
        this.sJl = System.currentTimeMillis();
        this.omB.a(new 3(this, view), this.sIl);
    }

    public final void bJ(View view) {
        int id = view.getId();
        final c cCc = cCc();
        if (cCc != null) {
            Bundle bundle = cCc.msB;
            if (id == f.uwI) {
                e.a(15, bh.Wo(), this.hze);
                if (bundle.getInt("realname_scene") != 1) {
                    bundle.putInt("real_name_verify_mode", 1);
                } else if (getIntent() == null) {
                    String str = "";
                    if (bh.ov(str)) {
                        str = getString(i.uXa);
                    }
                    h.a(this, str, null, false, new 5(this));
                    return;
                } else {
                    ji(580);
                    r(new a(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra(SlookSmartClipMetaTag.TAG_TYPE_URL), 8, "idCardRealnameVerify", getIntent().getIntExtra("pay_channel", 0)));
                    return;
                }
            } else if (id == f.uwJ) {
                e.a(17, bh.Wo(), this.hze);
                bundle.putInt("real_name_verify_mode", 2);
            } else if (id == f.uwK) {
                e.a(16, bh.Wo(), this.hze);
                if (!this.sJz || bh.ov(this.sJy)) {
                    bundle.putInt("real_name_verify_mode", 3);
                    bundle.putString("verify_card_flag", "1");
                } else {
                    h.a(this, this.sJy, "", this.sJx, false, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ SwitchRealnameVerifyModeUI sJB;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            Bundle bundle = cCc.msB;
                            bundle.putInt("real_name_verify_mode", 3);
                            bundle.putString("verify_card_flag", "1");
                            com.tencent.mm.wallet_core.a.j(this.sJB, bundle);
                        }
                    });
                    return;
                }
            }
            com.tencent.mm.wallet_core.a.j(this, bundle);
        }
    }

    private static JSONObject bKM() {
        com.tencent.mm.kernel.g.Dk();
        Object obj = com.tencent.mm.kernel.g.Dj().CU().get(w.a.xro, "");
        if (obj != null) {
            String str = (String) obj;
            if (!bh.ov(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    long j = jSONObject.getLong("timestamp");
                    long j2 = jSONObject.getLong("cache_time");
                    x.i("MicroMsg.SwitchRealnameVerifyModeUI", " dddd time=" + currentTimeMillis + ";timestamp=" + j + ";cachetime=" + j2);
                    if (currentTimeMillis - j <= j2) {
                        return jSONObject;
                    }
                    x.e("MicroMsg.SwitchRealnameVerifyModeUI", "wording data from cache is out of date");
                    return null;
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.SwitchRealnameVerifyModeUI", e, "", new Object[0]);
                    x.e("MicroMsg.SwitchRealnameVerifyModeUI", "parse wording data form cache error");
                    return null;
                }
            }
        }
        x.i("MicroMsg.SwitchRealnameVerifyModeUI", "cache is null");
        return null;
    }

    private boolean jI(boolean z) {
        JSONObject jSONObject;
        JSONObject bKM = bKM();
        if (z && bKM == null) {
            jSONObject = new JSONObject();
        } else {
            jSONObject = bKM;
        }
        if (jSONObject == null) {
            return z;
        }
        CharSequence az = bh.az(jSONObject.optString("cache_header_titles", getString(i.uOr)), getString(i.uOr));
        if (this.sJA) {
            ((TextView) findViewById(f.uwH)).setText(i.uVD);
        } else {
            ((TextView) findViewById(f.uwH)).setText(az);
        }
        if (jSONObject.optBoolean("isShowBindCardVerify", false)) {
            this.sJu.setText(jSONObject.optString("bindCardVerifyTitle"));
            this.sJv.setText(jSONObject.optString("bindCardVerifySubtitle"));
            this.sJo.setVisibility(0);
        } else {
            this.sJo.setVisibility(8);
        }
        if (jSONObject.optBoolean("isShowBindCard", false)) {
            this.sJp.setText(jSONObject.optString("bindcardTitle", getString(i.uOs)));
            this.sJq.setText(jSONObject.optString("bindcardSubTitle", getString(i.uOt)));
            this.sJm.setVisibility(0);
        } else {
            this.sJm.setVisibility(8);
        }
        if (jSONObject.optBoolean("isShowBindId", false)) {
            this.sJr.setText(jSONObject.optString("bindIdTitle", getString(i.uOu)));
            this.sJs.setText(jSONObject.optString("bindIdSubTitle", getString(i.uOv)));
            this.sJn.setVisibility(0);
        } else {
            this.sJn.setVisibility(8);
        }
        this.sJx = jSONObject.optString("bindCardVerifyAlertViewRightBtnTxt", "");
        this.sJy = jSONObject.optString("bindCardVerifyAlertViewContent", "");
        this.sJz = jSONObject.optBoolean("isShowBindCardVerifyAlertView", false);
        CharSequence optString = jSONObject.optString("extral_wording", "");
        if (bh.ov(optString)) {
            this.sJt.setVisibility(8);
        } else {
            this.sJt.setText(optString);
            this.sJt.setVisibility(0);
        }
        this.sJx = jSONObject.optString("bindCardVerifyAlertViewRightBtnTxt", "");
        this.sJy = jSONObject.optString("bindCardVerifyAlertViewContent");
        this.sJz = jSONObject.optBoolean("isShowBindCardVerifyAlertView", false);
        boolean optBoolean = jSONObject.optBoolean("question_answer_switch", false);
        this.sJw = jSONObject.optString("question_answer_url", "");
        if (optBoolean && !bh.ov(this.sJw)) {
            addIconOptionMenu(0, com.tencent.mm.plugin.wxpay.a.e.udW, new OnMenuItemClickListener(this) {
                final /* synthetic */ SwitchRealnameVerifyModeUI sJB;

                {
                    this.sJB = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    e.a(18, bh.Wo(), this.sJB.hze);
                    e.l(this.sJB.mController.xIM, this.sJB.sJw, false);
                    return true;
                }
            });
        }
        return true;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            c cCc = cCc();
            if (cCc != null) {
                e.a(14, bh.Wo(), this.hze);
                cCc.d(this, 0);
                return true;
            }
            finish();
        }
        return super.onKeyDown(i, keyEvent);
    }
}
