package com.tencent.mm.ui.account;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.ay.i;
import com.tencent.mm.ay.i.a;
import com.tencent.mm.g.a.iy;
import com.tencent.mm.modelsimple.g;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.q;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FacebookAuthUI extends MMPreference implements e {
    public static final String[] xNO = new String[]{"publish_actions", "email"};
    private f ilB;
    private OnCancelListener jWm;
    private final Map<String, Preference> kCt = new HashMap();
    private boolean xNP = false;
    private boolean xNQ = false;
    private c xNR = new c<iy>(this) {
        final /* synthetic */ FacebookAuthUI xNS;

        {
            this.xNS = r2;
            this.xen = iy.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            iy iyVar = (iy) bVar;
            if (iyVar == null || iyVar.fzB == null) {
                return false;
            }
            x.i("MicroMsg.FacebookAuthUI", "summerdiz loginDisasterListener callback content[%s], url[%s]", new Object[]{iyVar.fzB.content, iyVar.fzB.url});
            Intent intent = new Intent();
            intent.putExtra("key_disaster_content", iyVar.fzB.content);
            intent.putExtra("key_disaster_url", iyVar.fzB.url);
            intent.setClass(ac.getContext(), DisasterUI.class).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            ac.getContext().startActivity(intent);
            return true;
        }
    };
    private com.tencent.mm.ui.f.a.c xNv;
    private ProgressDialog xNw;
    private g xNx;

    static /* synthetic */ void ma(boolean z) {
        List arrayList = new ArrayList();
        arrayList.add(new a(32, z ? "0" : "1"));
        ar.Hg();
        com.tencent.mm.z.c.EX().b(new i(arrayList));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ilB = this.yjd;
        initView();
    }

    protected void onResume() {
        com.tencent.mm.sdk.b.a.xef.b(this.xNR);
        super.onResume();
        ar.CG().a(183, this);
        ar.CG().a(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.i.CTRL_BYTE, this);
        cnL();
    }

    protected void onPause() {
        super.onPause();
        com.tencent.mm.sdk.b.a.xef.c(this.xNR);
        ar.CG().b(183, this);
        ar.CG().b(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.i.CTRL_BYTE, this);
    }

    public final int XB() {
        return R.o.fbJ;
    }

    protected final void initView() {
        this.xNP = getIntent().getBooleanExtra("is_force_unbind", false);
        this.xNv = new com.tencent.mm.ui.f.a.c("290293790992170");
        this.jWm = new 3(this);
        this.ilB.addPreferencesFromResource(R.o.fbJ);
        Preference YN = this.ilB.YN("facebook_auth_tip");
        if (YN != null) {
            this.kCt.put("facebook_auth_tip", YN);
        }
        YN = this.ilB.YN("facebook_auth_cat");
        if (YN != null) {
            this.kCt.put("facebook_auth_cat", YN);
        }
        YN = this.ilB.YN("facebook_auth_bind_btn");
        if (YN != null) {
            this.kCt.put("facebook_auth_bind_btn", YN);
        }
        YN = this.ilB.YN("facebook_auth_account");
        if (YN != null) {
            this.kCt.put("facebook_auth_account", YN);
        }
        YN = this.ilB.YN("facebook_auth_cat2");
        if (YN != null) {
            this.kCt.put("facebook_auth_cat2", YN);
        }
        YN = this.ilB.YN("facebook_auth_unbind_btn");
        if (YN != null) {
            this.kCt.put("facebook_auth_unbind_btn", YN);
        }
        setBackBtn(new 4(this));
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.ibD;
        if (str == null) {
            x.e("MicroMsg.FacebookAuthUI", "onPreferenceTreeClick, key is null");
            return true;
        } else if (str.equals("facebook_auth_bind_btn")) {
            try {
                this.xNv.fY(this);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.FacebookAuthUI", e, "", new Object[0]);
            }
            this.xNv = new com.tencent.mm.ui.f.a.c("290293790992170");
            this.xNv.a(this, xNO, new a(this, (byte) 0));
            return true;
        } else if (!str.equals("facebook_auth_unbind_btn")) {
            return false;
        } else {
            h.a(this, R.l.eeh, R.l.dGO, new 5(this), new 6(this));
            return true;
        }
    }

    private void cnL() {
        this.ilB.removeAll();
        boolean Gt = this.xNP ? false : q.Gt();
        if (this.kCt.containsKey("facebook_auth_tip")) {
            Preference preference = (Preference) this.kCt.get("facebook_auth_tip");
            preference.setTitle(Gt ? R.l.eei : R.l.eec);
            this.ilB.a(preference);
        }
        if (this.kCt.containsKey("facebook_auth_cat")) {
            this.ilB.a((Preference) this.kCt.get("facebook_auth_cat"));
        }
        if (Gt) {
            if (this.kCt.containsKey("facebook_auth_account")) {
                preference = (Preference) this.kCt.get("facebook_auth_account");
                StringBuilder append = new StringBuilder().append(getString(R.l.eee));
                ar.Hg();
                preference.setTitle(append.append(com.tencent.mm.z.c.CU().get(65826, null)).toString());
                this.ilB.a(preference);
            }
            if (this.kCt.containsKey("facebook_auth_cat2")) {
                this.ilB.a((Preference) this.kCt.get("facebook_auth_cat2"));
            }
            if (this.kCt.containsKey("facebook_auth_unbind_btn")) {
                this.ilB.a((Preference) this.kCt.get("facebook_auth_unbind_btn"));
            }
        } else if (this.kCt.containsKey("facebook_auth_bind_btn")) {
            this.ilB.a((Preference) this.kCt.get("facebook_auth_bind_btn"));
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        String str = "MicroMsg.FacebookAuthUI";
        String str2 = "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Boolean.valueOf(intent == null);
        x.i(str, str2, objArr);
        if (i2 == -1 && i == WXMediaMessage.DESCRIPTION_LENGTH_LIMIT && intent != null) {
            String stringExtra = intent.getStringExtra("VoiceLoginAuthPwd");
            int intExtra = intent.getIntExtra("KVoiceHelpCode", 0);
            str2 = "MicroMsg.FacebookAuthUI";
            String str3 = "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d";
            Object[] objArr2 = new Object[3];
            objArr2[0] = Boolean.valueOf(bh.ov(stringExtra));
            objArr2[1] = Integer.valueOf(bh.ov(stringExtra) ? 0 : stringExtra.length());
            objArr2[2] = Integer.valueOf(intExtra);
            x.i(str2, str3, objArr2);
            if (intExtra == -217) {
                try {
                    this.xNv.fY(this);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.FacebookAuthUI", e, "", new Object[0]);
                }
                this.xNv = new com.tencent.mm.ui.f.a.c("290293790992170");
                this.xNv.a(this, xNO, new a(this, (byte) 0));
                return;
            }
        }
        this.xNv.e(i, i2, intent);
    }

    public final void a(int i, int i2, String str, k kVar) {
        com.tencent.mm.h.a eA;
        if (kVar.getType() == com.tencent.mm.plugin.game.gamewebview.jsapi.biz.i.CTRL_BYTE) {
            if (i == 0 && i2 == 0) {
                this.xNx = new g(0, "");
                ar.CG().a(this.xNx, 0);
                return;
            }
            if (this.xNw != null) {
                this.xNw.dismiss();
            }
            if (i2 == -82) {
                h.a(this, R.l.eKA, R.l.dGO, new 7(this));
            } else if (i2 == -83) {
                h.a(this, R.l.eKx, R.l.dGO, new 8(this));
            } else if (i2 == -84) {
                h.a(this, R.l.eKy, R.l.dGO, new OnClickListener(this) {
                    final /* synthetic */ FacebookAuthUI xNS;

                    {
                        this.xNS = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            } else if (i2 == -85) {
                h.a(this, R.l.eKw, R.l.dGO, new 10(this));
            } else if (i2 == -86) {
                h.a(this, R.l.eKB, R.l.dGO, new OnClickListener(this) {
                    final /* synthetic */ FacebookAuthUI xNS;

                    {
                        this.xNS = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            } else if (i2 == -106) {
                m.b(this, str, 0);
            } else if (i2 == -217) {
                m.a(this, com.tencent.mm.pluginsdk.a.a.a((v) kVar), i2);
            } else {
                eA = com.tencent.mm.h.a.eA(str);
                if (eA != null) {
                    eA.a(this, null, null);
                }
            }
        } else if (kVar.getType() == 183) {
            if (this.xNw != null) {
                this.xNw.dismiss();
            }
            int i3 = ((g) kVar).opType;
            if (i == 0 && i2 == 0) {
                Toast.makeText(this, i3 == 0 ? R.l.dUW : R.l.dUT, 1).show();
                this.xNP = false;
                cnL();
                if (i3 == 1) {
                    ar.Hg();
                    com.tencent.mm.z.c.Fd().WX("facebookapp");
                    ar.Hg();
                    com.tencent.mm.z.c.Fa().ED("facebookapp");
                    this.xNQ = true;
                }
            } else if (i == 4 && i2 == -67) {
                Toast.makeText(this, R.l.eef, 1).show();
            } else if (i == 4 && i2 == -5) {
                Toast.makeText(this, i3 == 1 ? R.l.eeb : R.l.eeg, 1).show();
            } else if (i2 == -106) {
                m.b(this, str, 0);
            } else {
                eA = com.tencent.mm.h.a.eA(str);
                if (eA != null) {
                    eA.a(this, null, null);
                } else {
                    Toast.makeText(this, i3 == 0 ? R.l.dUV : R.l.dUS, 1).show();
                }
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            Intent intent = getIntent();
            intent.putExtra("bind_facebook_succ", this.xNQ);
            setResult(-1, intent);
        }
        return super.onKeyDown(i, keyEvent);
    }
}
