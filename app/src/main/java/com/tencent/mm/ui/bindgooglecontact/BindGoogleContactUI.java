package com.tencent.mm.ui.bindgooglecontact;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.ap.a;
import com.tencent.mm.modelfriend.n;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.xweb.WebView;
import com.tencent.xweb.b;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.JSEXECUTECHECK})
public class BindGoogleContactUI extends MMActivity implements e {
    private boolean hnr = false;
    private int jxi;
    private boolean kmx = false;
    private ProgressDialog ltM;
    private TextView ntC;
    String ykA;
    String ykB;
    private a ykC;
    private boolean ykp = false;
    String ykr;
    private WebView ykx;
    private boolean yky = false;
    private String ykz;

    static /* synthetic */ void a(BindGoogleContactUI bindGoogleContactUI, String str) {
        String substring = str.substring(30);
        x.d("MicroMsg.GoogleContact.BindGoogleContactUI", "keep_GET_TOKEN_CODE value:" + substring);
        bindGoogleContactUI.aCw();
        new b(bindGoogleContactUI, substring).execute(new Void[0]);
        x.d("MicroMsg.GoogleContact.BindGoogleContactUI", "keep_GET_TOKEN_CODE End.");
    }

    protected final int getLayoutId() {
        return R.i.dbc;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jxi = getIntent().getIntExtra("enter_scene", 0);
        this.kmx = getIntent().getBooleanExtra("KEnterFromBanner", false);
        this.ykp = n.bj(this);
        ar.Hg();
        this.ykr = (String) c.CU().get(208903, null);
        initView();
        if (this.ykp) {
            startActivityForResult(new Intent("com.tencent.mm.gms.CHECK_GP_SERVICES"), 1005);
        } else {
            au();
        }
    }

    private void au() {
        if (this.ykp) {
            this.ykx.setVisibility(8);
            aCw();
            startActivityForResult(new Intent("com.tencent.mm.gms.ACTION_CHOOSE_ACCOUNT"), 1003);
            return;
        }
        this.ntC.setVisibility(4);
        this.ykx.setVisibility(0);
        cqu();
    }

    protected void onResume() {
        super.onResume();
        ar.CG().a(487, this);
        ar.Hg();
        this.yky = ((Boolean) c.CU().get(208905, Boolean.valueOf(false))).booleanValue();
        if (this.yky) {
            cqw();
            this.yky = false;
            ar.Hg();
            c.CU().set(208905, Boolean.valueOf(false));
        }
    }

    protected void onPause() {
        super.onPause();
        ar.CG().b(487, this);
    }

    protected final void initView() {
        setMMTitle(R.l.enl);
        setBackBtn(new OnMenuItemClickListener(this) {
            final /* synthetic */ BindGoogleContactUI ykD;

            {
                this.ykD = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.ykD.finish();
                return true;
            }
        });
        this.ykx = MMWebView.a.l(this, R.h.cnC);
        this.ntC = (TextView) findViewById(R.h.empty);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.GoogleContact.BindGoogleContactUI", "requestCode:%d, resultCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i2 == -1) {
            switch (i) {
                case 1003:
                    x.i("MicroMsg.GoogleContact.BindGoogleContactUI", "errorCode:%d ", new Object[]{Integer.valueOf(intent.getIntExtra("error_code", -1))});
                    if (intent.getIntExtra("error_code", -1) == 0) {
                        this.ykr = intent.getStringExtra("account");
                        if (this.hnr) {
                            alp();
                            return;
                        }
                        x.d("MicroMsg.GoogleContact.BindGoogleContactUI", "startAcitivtyForGetToken");
                        Intent intent2 = new Intent("com.tencent.mm.gms.ACTION_GET_TOKEN");
                        intent2.putExtra("gmail", this.ykr);
                        intent2.putExtra("scope", "oauth2:https://www.googleapis.com/auth/userinfo.email https://www.google.com/m8/feeds");
                        startActivityForResult(intent2, 1004);
                        return;
                    }
                    alp();
                    cqv();
                    return;
                case 1004:
                    int intExtra = intent.getIntExtra("error_code", -1);
                    String stringExtra = intent.getStringExtra("error_msg");
                    x.i("MicroMsg.GoogleContact.BindGoogleContactUI", "errorCode:%d errorMsg:%s", new Object[]{Integer.valueOf(intExtra), stringExtra});
                    if (intExtra == 0) {
                        this.ykz = intent.getStringExtra("token");
                        Fi(a.hyR);
                        return;
                    }
                    alp();
                    cqv();
                    return;
                case 1005:
                    this.ykp = intent.getBooleanExtra("gpservices", false);
                    au();
                    return;
                default:
                    return;
            }
        } else if (i == 1005) {
            this.ykp = intent.getBooleanExtra("gpservices", false);
            au();
        } else {
            alp();
            cqv();
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        String str2 = "MicroMsg.GoogleContact.BindGoogleContactUI";
        String str3 = "[onSceneEnd] errType:%d,errCode:%d,errMsg:%s";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        objArr[2] = str;
        x.i(str2, str3, objArr);
        alp();
        if (i == 0 && i2 == 0) {
            if (this.ykp) {
                ar.Hg();
                c.CU().set(208903, this.ykr);
                ar.Hg();
                c.CU().set(208901, this.ykz);
            } else {
                ar.Hg();
                c.CU().set(208903, this.ykr);
                ar.Hg();
                c.CU().set(208902, this.ykA);
                ar.Hg();
                c.CU().set(208904, this.ykB);
            }
            ar.Hg();
            c.CU().lH(true);
            Intent intent = new Intent(this, GoogleFriendUI.class);
            intent.putExtra("enter_scene", this.jxi);
            startActivity(intent);
            finish();
            if (this.kmx) {
                g.pQN.h(TXCStreamUploader.TXE_UPLOAD_INFO_PUSH_BEGIN, new Object[]{Integer.valueOf(6), Integer.valueOf(5)});
            }
        } else if (i2 == a.hyT) {
            h.a(this, getString(R.l.ens), "", new 6(this), new 7(this));
        } else {
            cqv();
        }
    }

    private void cqu() {
        aCw();
        this.ykx.getSettings().setJavaScriptEnabled(true);
        this.ykx.setWebViewClient(new 2(this));
        this.ykx.setWebChromeClient(new 3(this));
        x.i("MicroMsg.GoogleContactLogic", "getRequestCodeUrl:%s", new Object[]{"https://accounts.google.com/o/oauth2/auth?scope=https://www.googleapis.com/auth/userinfo.email https://www.google.com/m8/feeds&redirect_uri=urn:ietf:wg:oauth:2.0:oob&response_type=code&client_id=369820936870.apps.googleusercontent.com"});
        this.ykx.loadUrl("https://accounts.google.com/o/oauth2/auth?scope=https://www.googleapis.com/auth/userinfo.email https://www.google.com/m8/feeds&redirect_uri=urn:ietf:wg:oauth:2.0:oob&response_type=code&client_id=369820936870.apps.googleusercontent.com");
    }

    private void Fi(int i) {
        this.ykC = new a(a.a.hyY, this.ykr, i);
        ar.CG().a(this.ykC, 0);
        x.i("MicroMsg.GoogleContact.BindGoogleContactUI", "doScene mAppToken:%s, mWebToke:%s", new Object[]{this.ykz, this.ykA});
    }

    final void dj(String str, int i) {
        this.ykr = str;
        Fi(i);
    }

    final void cqv() {
        CharSequence string;
        if (this.ykx != null) {
            this.ykx.setVisibility(4);
        }
        if (this.ntC != null) {
            this.ntC.setVisibility(0);
        }
        if (an.isConnected(this)) {
            string = getString(R.l.enm);
        } else {
            string = getString(R.l.enu);
        }
        this.ntC.setText(string);
    }

    private void cqw() {
        try {
            com.tencent.xweb.c.iO(this);
            b.cIj().removeAllCookie();
        } catch (Exception e) {
            x.d("Google Login", "Clear cookie failed");
        }
    }

    private void aCw() {
        if (this.ltM == null || !this.ltM.isShowing()) {
            getString(R.l.dGO);
            this.ltM = h.a(this, getString(R.l.dHc), true, new 8(this));
        }
    }

    final void alp() {
        if (this.ltM != null && this.ltM.isShowing()) {
            this.ltM.dismiss();
        }
    }
}
