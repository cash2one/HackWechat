package com.tencent.mm.ui.account;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.KeyEvent;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.c.b;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.account.j.a;
import com.tencent.mm.ui.account.mobile.MobileVerifyUI;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;
import com.tencent.wcdb.FileUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RegByMobileWaitingSMSUI extends MMActivity {
    private String fAf;
    private ListView kGl;
    private ProgressBar lAk;
    private String pRQ;
    private j xQC;
    private boolean xQD;
    private a xQE = new 2(this);
    private TextView xRr;
    private CountDownTimer xRs;
    private int xRt = 30;
    private a xRu;
    private List<Integer> xRv = new ArrayList();
    String[] xRw = new String[]{"你好", "可以请你喝一杯吗？", "Здравствуйте!", "Darf ich Ihnen einen Drink ausgeben?", "Ich habe Gefühle für Dich.", "Bonjour!", "Prends soins de toi.", "?Hola! ", "Soy un ingeniero.", "Tu novio es un hombre bonito", "今日は!", "カッコいいですね", "Buona notte!", "Ayons une fête ce soir!", "Let's enjoy the holidays.", "Hello!"};
    private Drawable xRx;
    private List<Drawable> xRy = new ArrayList();
    private boolean xRz = false;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.xRy.add(getResources().getDrawable(R.g.bCS));
        this.xRy.add(getResources().getDrawable(R.g.bCT));
        this.xRy.add(getResources().getDrawable(R.g.bCU));
        this.xRy.add(getResources().getDrawable(R.g.bCV));
        this.xRy.add(getResources().getDrawable(R.g.bCW));
        this.xRy.add(getResources().getDrawable(R.g.bCX));
        initView();
        this.xQC = new j(this, this.xQE);
        this.xQC.coq();
        this.pRQ = b.Xn();
    }

    protected void onDestroy() {
        if (this.xQC != null) {
            this.xQC.cor();
            this.xQC = null;
        }
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        b.b(true, ar.CB() + "," + getClass().getName() + ",RE200_250," + ar.fH("RE200_250") + ",1");
    }

    protected void onPause() {
        super.onPause();
        b.oG("RE200_250");
        if (this.xRz) {
            b.oH(this.pRQ);
        } else {
            b.oH("RE200_300");
        }
        b.b(false, ar.CB() + "," + getClass().getName() + ",RE200_250," + ar.fH("RE200_250") + ",2");
    }

    protected final void initView() {
        this.xRr = (TextView) findViewById(R.h.cYw);
        this.lAk = (ProgressBar) findViewById(R.h.cYy);
        this.kGl = (ListView) findViewById(R.h.cYx);
        this.xQD = false;
        String string = getString(R.l.dLn);
        if (d.vAC) {
            string = getString(R.l.app_name) + getString(R.l.dDD);
        }
        setMMTitle(string);
        this.fAf = getIntent().getExtras().getString("bindmcontact_mobile");
        this.fAf = ao.Vk(this.fAf);
        this.xRt = getIntent().getIntExtra("mobileverify_countdownsec", this.xRt);
        Random random = new Random();
        for (int i = 0; i < this.xRt; i++) {
            this.xRv.add(Integer.valueOf(random.nextInt(1000)));
        }
        int nextInt = random.nextInt(1000) % this.xRy.size();
        this.xRx = (Drawable) this.xRy.get(nextInt);
        this.xRy.remove(nextInt);
        setBackBtn(new 1(this));
        ao aoVar = new ao();
        string = "86";
        if (this.fAf.startsWith("+")) {
            this.fAf = this.fAf.replace("+", "");
            string = ao.De(this.fAf);
            if (string != null) {
                this.fAf = this.fAf.substring(string.length());
            }
        }
        CharSequence formatNumber = ao.formatNumber(string, this.fAf);
        if (string == null || string.length() <= 0) {
            this.xRr.setText(formatNumber);
        } else {
            this.xRr.setText("+" + string + " " + formatNumber);
        }
        this.kGl.setVisibility(4);
        if (this.xRs == null) {
            this.xRs = new 3(this, (long) (this.xRt * 1000));
            this.lAk.setMax(this.xRt);
            this.xRs.start();
        }
    }

    protected final int getLayoutId() {
        return R.i.dop;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    private void goBack() {
        h.a(this, getString(R.l.evp), "", getString(R.l.evq), getString(R.l.evr), new 4(this), new 5(this));
    }

    private synchronized void Yx(String str) {
        if (this.xQC != null) {
            this.xQC.cor();
            this.xQC = null;
        }
        if (!(this.xRs == null || this.xRs == null)) {
            this.xRs.cancel();
            this.xRs = null;
        }
        if (!this.xQD) {
            this.xQD = true;
            Intent intent = getIntent();
            intent.putExtra("mobile_verify_purpose", 2);
            if (str != null && str.length() > 0) {
                intent.putExtra("MicroMsg.MobileVerifyUIIntent_sms_code", str);
            }
            a(MobileVerifyUI.class, intent);
            finish();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            String str = "MicroMsg.RegByMobileWaitingSMSUI";
            String str2 = "summerper onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(iArr == null ? -1 : iArr.length);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = strArr;
            objArr[3] = bh.cgy();
            x.w(str, str2, objArr);
            return;
        }
        x.i("MicroMsg.RegByMobileWaitingSMSUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case FileUtils.S_IWUSR /*128*/:
                if (iArr[0] == 0 && this.xQC != null) {
                    this.xQC.cos();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
