package com.tencent.mm.ui.account.bind;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ar.b;
import com.tencent.mm.ar.b.a;
import com.tencent.mm.modelsimple.BindWordingContent;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.friend.i;
import com.tencent.mm.ui.friend.i$b;
import com.tencent.wcdb.FileUtils;

public class BindMobileUI extends MMWizardActivity {
    private String countryCode = null;
    private String fAf;
    private String hEx = null;
    private TextView jpW;
    private LinearLayout xQd;
    private TextView xQe;
    private String xQh = null;
    private BindWordingContent xTf;
    private int xTg;
    private EditText xTl;
    private TextView xTm;
    private i xTn;
    private Button xTo;
    private TextView xTp;
    private TextView xTq;
    private CheckBox xTr;
    private CheckBox xTs;
    private LinearLayout xTt;
    private ImageView xTu;
    private boolean xTv;

    static /* synthetic */ void a(BindMobileUI bindMobileUI, String str) {
        if (bindMobileUI.xTn == null) {
            bindMobileUI.xTn = new i(i$b.zdM, bindMobileUI, new 7(bindMobileUI, str));
            bindMobileUI.getContentResolver().registerContentObserver(Uri.parse("content://sms/"), true, bindMobileUI.xTn);
        }
        bindMobileUI.xTn.ZQ(str);
        if (bindMobileUI.xTv) {
            bindMobileUI.xTn.zdI = false;
        }
    }

    static /* synthetic */ void c(BindMobileUI bindMobileUI, String str) {
        String string = bindMobileUI.mController.xIM.getString(R.l.dLE);
        h.a(bindMobileUI.mController.xIM, String.format("%s\n%s", new Object[]{bindMobileUI.mController.xIM.getString(R.l.dLF), str}), string, new 1(bindMobileUI, str), null);
    }

    static /* synthetic */ void d(BindMobileUI bindMobileUI, String str) {
        Intent intent = new Intent(bindMobileUI, BindMobileVerifyUI.class);
        intent.putExtra("bindmcontact_mobile", str);
        intent.putExtra("kstyle_bind_wording", bindMobileUI.xTf);
        intent.putExtra("kstyle_bind_recommend_show", bindMobileUI.xTg);
        intent.putExtra("Kfind_friend_by_mobile_flag", bindMobileUI.xTr.isChecked());
        intent.putExtra("Krecom_friends_by_mobile_flag", bindMobileUI.xTs.isChecked());
        intent.putExtra("is_bind_for_chatroom_upgrade", bindMobileUI.xTv);
        A(bindMobileUI, intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.dLi);
        this.hEx = bh.az(getIntent().getStringExtra("country_name"), "");
        this.countryCode = bh.az(getIntent().getStringExtra("couttry_code"), "");
        this.xQh = bh.az(getIntent().getStringExtra("bindmcontact_shortmobile"), "");
        this.xTf = (BindWordingContent) getIntent().getParcelableExtra("kstyle_bind_wording");
        this.xTg = getIntent().getIntExtra("kstyle_bind_recommend_show", 0);
        this.xTv = getIntent().getBooleanExtra("is_bind_for_chatroom_upgrade", false);
        initView();
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.xTn != null) {
            getContentResolver().unregisterContentObserver(this.xTn);
            this.xTn.recycle();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        DU(1);
        return true;
    }

    protected final void initView() {
        this.xTl = (EditText) findViewById(R.h.bNs);
        this.xQd = (LinearLayout) findViewById(R.h.bZd);
        this.xQe = (TextView) findViewById(R.h.bZf);
        this.xTm = (TextView) findViewById(R.h.bZb);
        this.jpW = (TextView) findViewById(R.h.bNw);
        this.xTo = (Button) findViewById(R.h.bNe);
        this.xTp = (TextView) findViewById(R.h.bNt);
        this.jpW.setText(getString(R.l.dLh));
        this.xTq = (TextView) findViewById(R.h.bNf);
        this.xTt = (LinearLayout) findViewById(R.h.bNv);
        this.xTs = (CheckBox) findViewById(R.h.bNo);
        this.xTr = (CheckBox) findViewById(R.h.bNn);
        this.xTu = (ImageView) findViewById(R.h.bNr);
        if (this.xTf != null) {
            if (this.xTf.title != null && this.xTf.title.length() > 0) {
                this.jpW.setText(this.xTf.title);
            }
            if (this.xTf.content != null && this.xTf.content.length() > 0) {
                this.xTq.setText(this.xTf.content);
            }
            switch (this.xTf.hMv.intValue()) {
                case 0:
                    this.xTu.setImageResource(R.g.bzn);
                    break;
                case 1:
                    this.xTu.setImageResource(R.g.bzq);
                    break;
                case 2:
                    this.xTu.setImageResource(R.g.bzo);
                    break;
            }
        }
        switch (this.xTg) {
            case 0:
                this.xTt.setVisibility(0);
                this.xTs.setVisibility(0);
                this.xTq.setVisibility(8);
                break;
            case 1:
                this.xTt.setVisibility(8);
                this.xTs.setVisibility(8);
                this.xTq.setVisibility(0);
                break;
        }
        if (bh.ov(this.hEx) && bh.ov(this.countryCode)) {
            String simCountryIso = ((TelephonyManager) getSystemService("phone")).getSimCountryIso();
            x.d("MicroMsg.BindMContactUI", "tm.getSimCountryIso()" + simCountryIso);
            if (bh.ov(simCountryIso)) {
                x.e("MicroMsg.BindMContactUI", "getDefaultCountryInfo error");
            } else {
                a h = b.h(this, simCountryIso, getString(R.l.bZb));
                if (h == null) {
                    x.e("MicroMsg.BindMContactUI", "getDefaultCountryInfo error");
                } else {
                    this.hEx = h.hEx;
                    this.countryCode = h.hEw;
                }
            }
        }
        if (!(this.hEx == null || this.hEx.equals(""))) {
            this.xQe.setText(this.hEx);
        }
        if (!(this.countryCode == null || this.countryCode.equals(""))) {
            this.xTm.setText("+" + this.countryCode);
        }
        if (!(this.xQh == null || this.xQh.equals(""))) {
            this.xTl.setText(this.xQh);
        }
        this.xTo.setOnClickListener(new 2(this));
        this.xTp.setOnClickListener(new 3(this));
        if (this.xTv) {
            setMMTitle(R.l.dKH);
            this.xTu.setVisibility(8);
            this.jpW.setText(R.l.dLa);
            this.xTt.setVisibility(8);
            this.xTs.setVisibility(8);
            this.xTs.setChecked(false);
            this.xTr.setVisibility(0);
            this.xTr.setChecked(false);
            this.xTq.setVisibility(8);
            this.xTq.setText(getString(R.l.dKI));
            this.xTp.setVisibility(8);
            this.xTo.setText(R.l.dKH);
            setBackBtn(new 4(this));
        }
        this.xQd.setOnClickListener(new 5(this));
        this.xQd.setOnClickListener(new 6(this));
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i2) {
            case 100:
                this.hEx = bh.az(intent.getStringExtra("country_name"), "");
                this.countryCode = bh.az(intent.getStringExtra("couttry_code"), "");
                if (!this.hEx.equals("")) {
                    this.xQe.setText(this.hEx);
                }
                if (!this.countryCode.equals("")) {
                    this.xTm.setText("+" + this.countryCode);
                    return;
                }
                return;
            default:
                return;
        }
    }

    protected final int getLayoutId() {
        return R.i.daZ;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            String str = "MicroMsg.BindMContactUI";
            String str2 = "summerper onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(iArr == null ? -1 : iArr.length);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = strArr;
            objArr[3] = bh.cgy();
            x.w(str, str2, objArr);
            return;
        }
        x.i("MicroMsg.BindMContactUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case FileUtils.S_IWUSR /*128*/:
                if (iArr[0] == 0 && this.xTn != null) {
                    this.xTn.cos();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
