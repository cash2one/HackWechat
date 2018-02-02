package com.tencent.mm.ui.account;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;

public class RegByMobileSetPwdUI extends SetPwdUI {
    private TextView qjb;
    private TextView rYg;
    private String vtt = null;
    private View xRh;
    private TextView xRi;
    private boolean xRj = false;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.vtt = getIntent().getStringExtra("kintent_hint");
        this.qoX = getIntent().getBooleanExtra("kintent_cancelable", true);
        this.xRj = getIntent().getBooleanExtra("from_unbind", false);
        initView();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.dqG;
    }

    protected final void initView() {
        if (!this.qoX) {
            cmW();
        }
        setMMTitle(R.l.eDU);
        this.qjb = (TextView) findViewById(R.h.cUq);
        this.xRh = findViewById(R.h.bIu);
        this.rYg = (TextView) findViewById(R.h.cHq);
        this.xRi = (TextView) findViewById(R.h.bIA);
        if (this.vtt != null && this.vtt.length() > 0) {
            this.rYg.setText(this.vtt);
        }
        if (this.xRj || !g.Dh().Cy()) {
            this.xRh.setVisibility(8);
        } else {
            this.xRh.setVisibility(0);
            CharSequence FT = q.FT();
            if (bh.ov(FT)) {
                FT = q.FS();
                if (x.WB(FT)) {
                    FT = null;
                }
            }
            if (bh.ov(FT)) {
                ar.Hg();
                String str = (String) c.CU().get(6, null);
                ar.Hg();
                String str2 = (String) c.CU().get(5, null);
                if (!bh.ov(str)) {
                    if (bh.VR(str).booleanValue()) {
                        ao aoVar = new ao();
                        str2 = "86";
                        if (str.startsWith("+")) {
                            str2 = str.replace("+", "");
                            str = ao.De(str2);
                            if (str != null) {
                                str2 = str2.substring(str.length());
                            }
                        } else {
                            String str3 = str2;
                            str2 = str;
                            str = str3;
                        }
                        FT = ao.formatNumber(str, str2);
                        this.xRi.setText(R.l.eLN);
                        this.qjb.setText(FT);
                    }
                    this.rYg.setText(R.l.eDW);
                } else if (bh.ov(str2)) {
                    this.xRh.setVisibility(8);
                } else {
                    this.qjb.setText(str2);
                    this.xRi.setText(R.l.eLj);
                    this.rYg.setText(R.l.eDV);
                }
            } else {
                this.xRi.setText(R.l.eNP);
                this.qjb.setText(FT);
            }
        }
        TextView textView = (TextView) findViewById(R.h.cCn);
        TextView textView2 = (TextView) findViewById(R.h.bWX);
        EditText editText = (EditText) findViewById(R.h.cHu);
        EditText editText2 = (EditText) findViewById(R.h.cHt);
        if (!w.cfe()) {
            textView.setTextSize(1, 14.0f);
            textView2.setTextSize(1, 14.0f);
            editText.setTextSize(1, 14.0f);
            editText2.setTextSize(1, 14.0f);
        }
        float measureText = this.xRi.getPaint().measureText(this.xRi.getText().toString());
        float measureText2 = textView.getPaint().measureText(textView.getText().toString());
        float max = Math.max(Math.max(measureText, measureText2), textView2.getPaint().measureText(textView2.getText().toString()));
        this.xRi.setWidth((int) max);
        textView.setWidth((int) max);
        textView.setWidth((int) max);
    }

    protected final String cnW() {
        return ((EditText) findViewById(R.h.cHu)).getText().toString();
    }

    protected final String cnX() {
        return ((EditText) findViewById(R.h.cHt)).getText().toString();
    }

    protected final void Eg(int i) {
        switch (1.xQc[i - 1]) {
            case 1:
                h.h(this, R.l.eDP, R.l.eDR);
                return;
            case 2:
                h.h(this, R.l.eDQ, R.l.eDR);
                return;
            case 3:
                h.h(this, R.l.eSL, R.l.eDR);
                return;
            case 4:
                h.h(this, R.l.eSN, R.l.eDR);
                return;
            default:
                return;
        }
    }

    protected final boolean s(int i, int i2, String str) {
        if (i != 0 || i2 != 0) {
            return o(i, i2, str);
        }
        finish();
        return true;
    }

    public final boolean cod() {
        return true;
    }
}
