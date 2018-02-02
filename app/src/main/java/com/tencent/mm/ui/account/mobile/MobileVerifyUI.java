package com.tencent.mm.ui.account.mobile;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.c.b;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.pluginsdk.h.a;
import com.tencent.mm.pluginsdk.h.o;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.account.RegByMobileSetPwdUI;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.MMFormInputView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMEditText.c;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bh;
import com.tencent.wcdb.FileUtils;
import java.util.Timer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MobileVerifyUI extends MMActivity {
    String bgo;
    private Timer bnp;
    protected String fAf;
    int hNU;
    protected ProgressDialog iln = null;
    String mzr;
    String pRQ;
    private ContentResolver qxW;
    private String[] qyb;
    protected Button sCT;
    SecurityImage xKa = null;
    private a xOK;
    protected String xOW;
    protected boolean xPI = false;
    private int xRt = 30;
    protected EditText xTy;
    protected MMFormInputView xUR;
    protected TextView xUS;
    protected TextView xUT;
    protected TextView xUU;
    protected ScrollView xUV;
    private c xUW;
    private long xUX = 0;
    private boolean xUY = false;
    private String xUZ;
    private int xUf;
    protected TextView xUr;
    private boolean xVa = false;
    Boolean xVb;
    Boolean xVc;
    protected boolean xVd = false;
    protected boolean xVe = false;
    protected int xVf = -1;
    private b xVg;
    String xVh;

    static /* synthetic */ void d(MobileVerifyUI mobileVerifyUI) {
        mobileVerifyUI.xUY = false;
        if (mobileVerifyUI.bnp != null) {
            mobileVerifyUI.bnp.cancel();
        }
    }

    static /* synthetic */ int h(MobileVerifyUI mobileVerifyUI) {
        switch (mobileVerifyUI.xUf) {
            case 2:
                return 0;
            case 3:
                return 2;
            case 4:
                return 1;
            default:
                return 3;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.xVc = Boolean.valueOf(bh.HO().HP() > 0);
        this.xUf = getIntent().getIntExtra("mobile_verify_purpose", 0);
        this.xVh = getIntent().getStringExtra("MicroMsg.MobileVerifyUIIntent_sms_code");
        this.mzr = getIntent().getStringExtra("kintent_password");
        this.bgo = getIntent().getStringExtra("kintent_nickname");
        this.xVb = Boolean.valueOf(getIntent().getBooleanExtra("kintent_hasavatar", false));
        this.xPI = getIntent().getBooleanExtra("from_deep_link", false);
        this.xOW = getIntent().getStringExtra("regsession_id");
        switch (this.xUf) {
            case 2:
                this.xVg = new h();
                if (this.mzr != null && this.mzr.length() >= 8) {
                    this.hNU = 1;
                    break;
                } else {
                    this.hNU = 4;
                    break;
                }
            case 3:
                this.xVg = new f();
                break;
            case 4:
                this.xVg = new g();
                break;
            default:
                x.e("MicroMsg.MobileVerifyUI", "wrong purpose %s", new Object[]{Integer.valueOf(this.xUf)});
                finish();
                return;
        }
        String string = getString(R.l.dLn);
        if (d.vAC) {
            string = getString(R.l.app_name) + getString(R.l.dDD);
        }
        setMMTitle(string);
        this.xRt = getIntent().getIntExtra("mobileverify_countdownsec", 30);
        this.xVd = getIntent().getBooleanExtra("mobileverify_fb", false);
        this.xVe = getIntent().getBooleanExtra("mobileverify_reg_qq", false);
        this.fAf = getIntent().getExtras().getString("bindmcontact_mobile");
        this.pRQ = b.Xn();
        initView();
        this.xVg.a(this);
        if (this.xVh != null) {
            this.xTy.setText(this.xVh);
            bKz();
        } else {
            this.xUW = new c(this, this);
            getContentResolver().registerContentObserver(Uri.parse("content://sms/"), true, this.xUW);
        }
        this.xOK = new a();
    }

    public void onDestroy() {
        if (this.xUW != null) {
            getContentResolver().unregisterContentObserver(this.xUW);
            this.xUW = null;
        }
        if (this.xOK != null) {
            this.xOK.close();
        }
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
        this.xVg.start();
    }

    public void onPause() {
        super.onPause();
        this.xVg.stop();
    }

    protected final int getLayoutId() {
        return R.i.doo;
    }

    private void aTb() {
        if (!this.xUY) {
            this.bnp = new Timer();
            this.xUY = true;
            this.xUX = (long) this.xRt;
            this.bnp.schedule(new 1(this), 1000, 1000);
        }
    }

    public final void onKeyboardStateChanged() {
        if (this.mController.xJg == 1) {
            this.xUV.scrollTo(0, this.xUV.getChildAt(0).getMeasuredHeight() - this.xUV.getMeasuredHeight());
        } else {
            this.xUV.scrollTo(0, 0);
        }
    }

    protected final void initView() {
        x.d("MicroMsg.MobileVerifyUI", "init getintent mobile:" + this.fAf);
        this.xUR = (MMFormInputView) findViewById(R.h.bNA);
        MMFormInputView mMFormInputView = this.xUR;
        if (mMFormInputView.pqM != null) {
            mMFormInputView.pqM.setImeOptions(5);
        } else {
            x.e("MicroMsg.MMFormInputView", "contentET is null!");
        }
        this.xUR.setInputType(3);
        this.xTy = this.xUR.pqM;
        this.xUS = (TextView) findViewById(R.h.cwR);
        this.xUT = (TextView) findViewById(R.h.cwQ);
        this.xUr = (TextView) findViewById(R.h.bNy);
        this.xUr.setText(this.fAf);
        this.fAf = ao.Vk(this.fAf);
        this.xUS.setText(getString(R.l.evt));
        this.xUU = (TextView) findViewById(R.h.bNB);
        this.sCT = (Button) findViewById(R.h.cAg);
        this.xUV = (ScrollView) findViewById(R.h.cJf);
        this.qyb = getResources().getStringArray(R.c.bra);
        this.xUU.setText(Html.fromHtml(getString(R.l.eDD)));
        InputFilter[] inputFilterArr = new InputFilter[]{new 5(this)};
        this.xUT.setVisibility(0);
        this.xUT.setText(getResources().getQuantityString(R.j.duC, this.xRt, new Object[]{Integer.valueOf(this.xRt)}));
        aTb();
        this.xVa = false;
        this.xTy.setFilters(inputFilterArr);
        this.xTy.addTextChangedListener(new c(this.xTy, null, 12));
        this.sCT.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MobileVerifyUI xVi;

            {
                this.xVi = r1;
            }

            public final void onClick(View view) {
                this.xVi.bKz();
            }
        });
        this.sCT.setEnabled(false);
        this.xTy.setTextSize(15.0f);
        this.xTy.addTextChangedListener(new 7(this));
        this.xUS.setOnClickListener(new 8(this));
        this.xUS.setEnabled(false);
        setBackBtn(new 9(this));
        this.xTy.setOnEditorActionListener(new 10(this));
        this.xTy.setOnKeyListener(new OnKeyListener(this) {
            final /* synthetic */ MobileVerifyUI xVi;

            {
                this.xVi = r1;
            }

            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (66 != i || keyEvent.getAction() != 0) {
                    return false;
                }
                this.xVi.bKz();
                return true;
            }
        });
    }

    private void bKz() {
        aWs();
        if (this.xTy.getText().toString().trim().equals("")) {
            h.h(this, R.l.dLG, R.l.dGO);
        } else {
            this.xVg.Ej(a.xVp);
        }
    }

    private void XD() {
        this.xVa = false;
        this.xUS.setEnabled(false);
        this.xUT.setVisibility(0);
        this.xUT.setText(getResources().getQuantityString(R.j.duC, this.xRt, new Object[]{Integer.valueOf(this.xRt)}));
        this.xUS.setVisibility(8);
        aTb();
        this.xVg.Ej(a.xVq);
        h.bu(this, getString(R.l.evi));
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    private void goBack() {
        b.oH(this.pRQ);
        if (!this.xVg.Ej(a.xVo)) {
            finish();
        }
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            String stringExtra = intent.getStringExtra("nofification_type");
            x.d("MicroMsg.MobileVerifyUI", "[oneliang][notificationType]%s", new Object[]{stringExtra});
            if (stringExtra != null && stringExtra.equals("no_reg_notification")) {
                XD();
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final boolean o(int i, int i2, String str) {
        com.tencent.mm.h.a eA = com.tencent.mm.h.a.eA(str);
        if (eA != null) {
            eA.a(this, null, null);
            return true;
        }
        int i3;
        if (i == 4) {
            switch (i2) {
                case -75:
                    break;
                case -1:
                    if (ar.CG().Km() == 5) {
                        h.h(this, R.l.exG, R.l.exF);
                        return true;
                    }
                    break;
            }
        }
        switch (i2) {
            case -100:
                ar.hold();
                h.a(this.mController.xIM, TextUtils.isEmpty(ar.Ci()) ? com.tencent.mm.bv.a.ac(this.mController.xIM, R.l.euu) : ar.Ci(), this.mController.xIM.getString(R.l.dGO), new 3(this), new OnCancelListener(this) {
                    final /* synthetic */ MobileVerifyUI xVi;

                    {
                        this.xVi = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                    }
                });
                i3 = 1;
                break;
            case -43:
                Toast.makeText(this, R.l.dKQ, 0).show();
                i3 = 1;
                break;
            case -41:
                Toast.makeText(this, R.l.dKS, 0).show();
                i3 = 1;
                break;
            case -36:
                Toast.makeText(this, R.l.dKV, 0).show();
                i3 = 1;
                break;
            case -34:
                Toast.makeText(this, R.l.dKT, 0).show();
                i3 = 1;
                break;
            case -33:
                h.a(this, R.l.dLA, R.l.bNB, new 2(this));
                i3 = 1;
                break;
            case -32:
                h.a(this, getString(R.l.dLC), "", new 12(this));
                i3 = 1;
                break;
            default:
                i3 = 0;
                break;
        }
        if (i3 != 0) {
            return true;
        }
        if (this.xOK.a(this, new o(i, i2, str))) {
            return true;
        }
        return false;
    }

    protected final void mc(boolean z) {
        Intent intent = new Intent(this, RegByMobileSetPwdUI.class);
        intent.putExtra("kintent_hint", getString(R.l.eLU));
        intent.putExtra("kintent_cancelable", z);
        startActivityForResult(intent, 0);
    }

    private void cos() {
        Exception e;
        Cursor cursor;
        Throwable th;
        String str = null;
        Uri parse = Uri.parse("content://sms/inbox");
        this.qxW = getContentResolver();
        String[] strArr = new String[]{"body", "_id", FFmpegMetadataRetriever.METADATA_KEY_DATE};
        String str2 = "( ";
        int i = 0;
        while (i < this.qyb.length) {
            str2 = i == this.qyb.length + -1 ? str2 + " body like \"%" + this.qyb[i] + "%\" ) " : str2 + "body like \"%" + this.qyb[i] + "%\" or ";
            i++;
        }
        String str3 = str2 + " and date > " + (System.currentTimeMillis() - 300000) + " ";
        x.v("MicroMsg.MobileVerifyUI", "sql where:" + str3);
        if (str3 != null && !str3.equals("")) {
            Cursor query;
            try {
                query = this.qxW.query(parse, strArr, str3, null, null);
                if (query != null) {
                    int i2 = -1;
                    long j = 0;
                    while (query.moveToNext()) {
                        try {
                            int position;
                            long j2 = query.getLong(2);
                            if (j2 > j) {
                                position = query.getPosition();
                            } else {
                                j2 = j;
                                position = i2;
                            }
                            i2 = position;
                            j = j2;
                        } catch (Exception e2) {
                            e = e2;
                            cursor = query;
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                    this.xUZ = null;
                    if (i2 >= 0) {
                        query.moveToPosition(i2);
                        Matcher matcher = Pattern.compile("\\d{4,8}").matcher(query.getString(query.getColumnIndex("body")));
                        if (matcher.find()) {
                            str = matcher.group();
                        }
                        this.xUZ = str;
                        if (!this.xVa) {
                            this.xVa = true;
                            this.xTy.setText(this.xUZ);
                            aWs();
                            if (!this.xTy.getText().toString().trim().equals("")) {
                                if (this.iln != null) {
                                    this.iln.dismiss();
                                    this.iln = null;
                                }
                                this.xVg.Ej(a.xVr);
                            }
                        }
                    }
                    if (query != null && !query.isClosed()) {
                        query.close();
                    }
                } else if (query != null && !query.isClosed()) {
                    query.close();
                }
            } catch (Exception e3) {
                e = e3;
                cursor = null;
                try {
                    x.e("MicroMsg.MobileVerifyUI", e.toString());
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                } catch (Throwable th3) {
                    th = th3;
                    query = cursor;
                    if (!(query == null || query.isClosed())) {
                        query.close();
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                query = null;
                query.close();
                throw th;
            }
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            String str = "MicroMsg.MobileVerifyUI";
            String str2 = "summerper onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(iArr == null ? -1 : iArr.length);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = strArr;
            objArr[3] = com.tencent.mm.sdk.platformtools.bh.cgy();
            x.w(str, str2, objArr);
            return;
        }
        x.i("MicroMsg.MobileVerifyUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case FileUtils.S_IWUSR /*128*/:
                if (iArr[0] == 0) {
                    cos();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
