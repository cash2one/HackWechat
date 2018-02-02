package com.tencent.mm.ui.bindmobile;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.friend.i;
import com.tencent.mm.ui.friend.i.b;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.wcdb.FileUtils;

public class BindMContactUI extends MMWizardActivity {
    private String countryCode = null;
    private String fAf;
    private int fromScene = 0;
    private String hEx = null;
    private boolean kmx = false;
    private LinearLayout xQd;
    private TextView xQe;
    private String xQh = null;
    private boolean xTC = false;
    private boolean xTE = false;
    private EditText xTl;
    private TextView xTm;
    private i xTn;
    private CheckBox xTr;
    private boolean ylG = false;
    private TextView ylQ;
    private LinearLayout ylR;
    private boolean ylS = false;

    static /* synthetic */ void b(BindMContactUI bindMContactUI, String str) {
        if (bindMContactUI.xTn == null) {
            int i = b.zdM;
            if (bindMContactUI.ylS) {
                i = b.zdN;
            }
            bindMContactUI.xTn = new i(i, bindMContactUI, new 6(bindMContactUI, str));
            bindMContactUI.getContentResolver().registerContentObserver(Uri.parse("content://sms/"), true, bindMContactUI.xTn);
        }
        i iVar = bindMContactUI.xTn;
        boolean z = (bindMContactUI.xTC || bindMContactUI.ylG) ? false : true;
        iVar.zdI = z;
        bindMContactUI.xTn.ZQ(str);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.dLk);
        this.hEx = bh.az(getIntent().getStringExtra("country_name"), "");
        this.countryCode = bh.az(getIntent().getStringExtra("couttry_code"), "");
        this.xQh = bh.az(getIntent().getStringExtra("bindmcontact_shortmobile"), "");
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
        cqA();
        return true;
    }

    private void cqA() {
        if (this.xTC || this.ylG) {
            xKw.clear();
            DU(1);
            return;
        }
        h.a(this, this.ylS ? R.l.dKX : R.l.dKW, this.ylS ? R.l.dKZ : R.l.dKY, new 1(this), null);
    }

    protected final void initView() {
        this.xTC = getIntent().getBooleanExtra("is_bind_for_safe_device", false);
        this.ylG = getIntent().getBooleanExtra("is_bind_for_contact_sync", false);
        this.xTE = getIntent().getBooleanExtra("BIND_FOR_QQ_REG", false);
        this.ylS = getIntent().getBooleanExtra("is_bind_for_change_mobile", false);
        this.kmx = getIntent().getBooleanExtra("KEnterFromBanner", false);
        this.fromScene = getIntent().getIntExtra("bind_scene", 0);
        x.i("MicroMsg.BindMContactUI", "bindScene:%d", Integer.valueOf(this.fromScene));
        this.xTl = (EditText) findViewById(R.h.bNs);
        this.xQd = (LinearLayout) findViewById(R.h.bZd);
        this.xQe = (TextView) findViewById(R.h.bZf);
        this.xTm = (TextView) findViewById(R.h.bZb);
        this.xTr = (CheckBox) findViewById(R.h.bNp);
        this.ylR = (LinearLayout) findViewById(R.h.bNq);
        this.ylQ = (TextView) findViewById(R.h.cLU);
        if (this.ylS) {
            ar.Hg();
            String str = (String) c.CU().get(6, null);
            if (!bh.ov(str)) {
                String De;
                if (str.startsWith("+")) {
                    De = ao.De(str);
                    String str2 = De;
                    De = str.substring(De.length() + 1);
                    str = str2;
                } else {
                    De = str;
                    str = "86";
                }
                ao aoVar = new ao();
                str = ao.formatNumber(str, De);
                this.ylQ.setText(getString(R.l.dKL, new Object[]{str}));
            }
        }
        if (!(this.hEx == null || this.hEx.equals(""))) {
            this.xQe.setText(this.hEx);
        }
        if (!(this.countryCode == null || this.countryCode.equals(""))) {
            this.xTm.setText("+" + this.countryCode);
        }
        if (this.xQh == null || this.xQh.equals("")) {
            ar.Dm().a(new 2(this));
        } else {
            this.xTl.setText(this.xQh);
            this.xTl.setSelection(this.xQh.length());
        }
        if (com.tencent.mm.ar.b.PT()) {
            this.ylR.setVisibility(4);
            this.xTr.setChecked(true);
        }
        addTextOptionMenu(0, getString(R.l.dFQ), new 3(this));
        this.xTl.requestFocus();
        setBackBtn(new 4(this));
        this.xQd.setOnClickListener(new 5(this));
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
        return R.i.dbf;
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
        x.i("MicroMsg.BindMContactUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
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
