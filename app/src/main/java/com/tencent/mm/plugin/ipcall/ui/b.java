package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.ipcall.b.a;
import com.tencent.mm.plugin.ipcall.b.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.bwo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.MMActivity;
import java.util.Iterator;
import java.util.LinkedList;

public final class b {
    MMActivity fmM;
    String hgM;
    TextView iiQ;
    a nHc;
    private DialPad nHd;
    TextView nHe;
    EditText nHf;
    View nHg;
    private ImageButton nHh;
    View nHi;
    TextView nHj;
    TextView nHk;
    private ao nHl;
    String nHm;
    String nHn;
    String nHo = "";
    String nHp;
    LinkedList<bwo> nHq;
    long nHr = 0;
    boolean nHs = false;
    private Runnable nHt = new 1(this);
    private ag nHu = new ag("IPCallDialQueryPhoneNumber");
    boolean nHv = false;
    private TextWatcher nHw = new 2(this);
    String nHx = "";

    public b(MMActivity mMActivity, EditText editText, TextView textView, View view, DialPad dialPad, ImageButton imageButton, TextView textView2, View view2, TextView textView3, TextView textView4) {
        this.fmM = mMActivity;
        this.nHf = editText;
        this.nHe = textView;
        this.nHg = view;
        this.nHd = dialPad;
        this.nHh = imageButton;
        this.iiQ = textView2;
        this.nHi = view2;
        this.nHj = textView3;
        this.nHk = textView4;
        this.nHl = new ao();
        this.nHn = c.aUO();
        String string = ac.getContext().getSharedPreferences("IPCall_LastInputPref", 0).getString("IPCall_LastInputCountryName", "");
        if (bh.ov(string)) {
            string = a.Dc(a.aUL());
        }
        this.nHm = string;
        this.nHe.addTextChangedListener(this.nHw);
        this.nHe.setText("+" + this.nHn);
        this.nHd.nHb = new 3(this);
        this.nHg.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ b nHy;

            {
                this.nHy = r1;
            }

            public final void onClick(View view) {
                String obj = this.nHy.nHf.getText().toString();
                if (bh.ov(obj)) {
                    obj = this.nHy.nHe.getText().toString();
                    if (!bh.ov(obj)) {
                        Object substring = obj.substring(0, obj.length() - 1);
                        if (bh.ov(substring) || substring.equals("+")) {
                            this.nHy.nHe.setText("+");
                            this.nHy.nHn = "+";
                            this.nHy.nHs = true;
                            return;
                        }
                        this.nHy.nHe.setText(substring);
                        this.nHy.nHn = substring;
                        return;
                    }
                    return;
                }
                int selectionStart = this.nHy.nHf.getSelectionStart();
                if (!this.nHy.nHv || selectionStart - 1 < 0) {
                    obj = obj.substring(0, obj.length() - 1);
                } else {
                    Editable text = this.nHy.nHf.getText();
                    text.delete(selectionStart - 1, selectionStart);
                    obj = text.toString();
                }
                if (bh.ov(obj)) {
                    this.nHy.nHo = "";
                    this.nHy.bv("", -1);
                } else {
                    String replace = this.nHy.nHe.getText().toString().replace("+", "");
                    if (this.nHy.nHv) {
                        this.nHy.nHo = this.nHy.cW(replace, obj);
                        this.nHy.bv(this.nHy.nHo, (this.nHy.nHo.length() - obj.length()) + (selectionStart - 1));
                    } else {
                        this.nHy.nHo = this.nHy.cW(replace, obj);
                        this.nHy.bv(this.nHy.nHo, -1);
                    }
                    this.nHy.aUl();
                }
                this.nHy.nHp = "";
                this.nHy.iiQ.setText("");
            }
        });
        this.nHg.setOnLongClickListener(new OnLongClickListener(this) {
            final /* synthetic */ b nHy;

            {
                this.nHy = r1;
            }

            public final boolean onLongClick(View view) {
                if (this.nHy.nHs) {
                    this.nHy.nHn = "+";
                    this.nHy.nHe.setText(this.nHy.nHn);
                } else {
                    this.nHy.iiQ.setText("");
                    this.nHy.nHo = "";
                    this.nHy.bv("", -1);
                }
                return true;
            }
        });
        this.nHe.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ b nHy;

            {
                this.nHy = r1;
            }

            public final void onClick(View view) {
                g.pQN.h(12061, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0)});
                String replace = this.nHy.nHe.getText().toString().replace("+", "");
                Intent intent = new Intent(this.nHy.fmM, IPCallCountryCodeSelectUI.class);
                intent.putExtra("couttry_code", replace);
                intent.putExtra("CountryCodeUI_isShowCountryCode", true);
                this.nHy.fmM.startActivityForResult(intent, 100);
                this.nHy.fmM.overridePendingTransition(R.a.bqo, -1);
            }
        });
        this.nHh.setOnClickListener(new 7(this));
        this.nHf.setHorizontallyScrolling(true);
        this.nHf.setOnClickListener(new 8(this));
        this.nHf.addTextChangedListener(new 9(this));
        if (d.fM(16)) {
            this.nHe.setTypeface(Typeface.create("sans-serif-light", 0));
            this.nHf.setTypeface(Typeface.create("sans-serif-light", 0));
            this.iiQ.setTypeface(Typeface.create("sans-serif-light", 0));
        }
    }

    public final void CK(String str) {
        this.nHn = str;
        if (this.nHe != null) {
            this.nHe.setText("+" + str);
        }
    }

    public final void W(LinkedList<bwo> linkedList) {
        int i;
        this.nHq = linkedList;
        String replace = this.nHe.getText().toString().replace("+", "");
        if (a.Df(replace) && this.nHq != null && this.nHq.size() > 0) {
            String Dd = a.Dd(replace);
            Iterator it = this.nHq.iterator();
            while (it.hasNext()) {
                bwo com_tencent_mm_protocal_c_bwo = (bwo) it.next();
                if (com_tencent_mm_protocal_c_bwo != null && com_tencent_mm_protocal_c_bwo.hvC.equals(Dd)) {
                    i = 1;
                    break;
                }
            }
        }
        i = 0;
        if (i != 0) {
            this.nHk.setVisibility(0);
        } else {
            this.nHk.setVisibility(8);
        }
    }

    final String cW(String str, String str2) {
        String formatNumber = ao.formatNumber(str, c.Dm(str2));
        return bh.ov(formatNumber) ? str2 : formatNumber;
    }

    public final void bv(String str, int i) {
        this.nHf.setText(str);
        if (!bh.ov(str)) {
            if (i != -1) {
                if (this.nHv) {
                    if (i > 0 && i <= this.nHf.getText().length()) {
                        this.nHf.setSelection(i);
                    }
                }
            }
            this.nHf.setSelection(this.nHf.getText().length());
        }
        this.nHo = str;
    }

    public final void aUl() {
        this.nHu.cfF().removeCallbacks(this.nHt);
        this.nHu.g(this.nHt, 500);
    }
}
