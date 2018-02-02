package com.tencent.mm.plugin.recharge.ui.form;

import android.content.Context;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.recharge.model.a;
import com.tencent.mm.plugin.recharge.model.b;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public class c$b {
    public List<String[]> pCt;
    public a pCu = null;
    public MallFormView pEb = null;
    public d pEc;
    boolean pEd = false;

    class AnonymousClass4 implements OnFocusChangeListener {
        final /* synthetic */ c$b pEe;
        final /* synthetic */ InstantAutoCompleteTextView pEf;

        public AnonymousClass4(c$b com_tencent_mm_plugin_recharge_ui_form_c_b, InstantAutoCompleteTextView instantAutoCompleteTextView) {
            this.pEe = com_tencent_mm_plugin_recharge_ui_form_c_b;
            this.pEf = instantAutoCompleteTextView;
        }

        public final void onFocusChange(View view, boolean z) {
            if (z) {
                this.pEf.setHintTextColor(view.getContext().getResources().getColor(c.uaI));
                if (this.pEe.pCu != null && this.pEe.pCu.fqd == 2 && !this.pEe.pEd) {
                    x.d(c.bz(), "clear input");
                    this.pEe.pEb.bmK();
                    this.pEe.pCu = null;
                } else if (this.pEe.pEd) {
                    this.pEe.pEd = false;
                }
                if (bh.ov(this.pEf.getText().toString())) {
                    this.pEf.showDropDown();
                }
            }
        }
    }

    public c$b(MallFormView mallFormView) {
        this.pEb = mallFormView;
    }

    public final void b(a aVar) {
        this.pCu = aVar;
        if (aVar != null) {
            if (bh.ov(this.pEb.getText()) || !this.pEb.getText().equals(aVar.pBH)) {
                this.pEb.pEh.setText(b.Ie(aVar.pBH));
            }
            this.pEb.pEh.setSelection(this.pEb.pEh.getText().length());
            x.d(c.bz(), "editTv.setText %s, name: %s, location: %s, type: %s", new Object[]{aVar.pBH, aVar.name, aVar.pBI, Integer.valueOf(aVar.fqd)});
            Context context = this.pEb.getContext();
            if (this.pCu.fqd == 3) {
                this.pEb.pEj.setText(this.pCu.name);
                this.pEb.pEj.setTextColor(context.getResources().getColor(c.ubm));
                return;
            } else if (this.pCu.fqd == 1) {
                CharSequence string;
                if (bh.ov(this.pCu.name)) {
                    string = context.getString(i.uVV);
                    if (!bh.ov(this.pCu.pBI)) {
                        string = string + context.getString(i.uVN, new Object[]{this.pCu.pBI});
                    }
                    this.pEb.pEj.setText(string);
                    this.pEb.pEj.setTextColor(context.getResources().getColor(c.ubi));
                    return;
                }
                string = this.pCu.name;
                if (!bh.ov(this.pCu.pBI)) {
                    string = string + context.getString(i.uVN, new Object[]{this.pCu.pBI});
                }
                this.pEb.pEj.setText(string);
                this.pEb.pEj.setTextColor(context.getResources().getColor(c.btv));
                return;
            } else if (this.pCu.fqd == 2) {
                if (bh.ov(this.pCu.pBI)) {
                    this.pEb.pEj.setText("");
                    this.pEb.pEj.setTextColor(context.getResources().getColor(c.ubi));
                    return;
                }
                this.pEb.pEj.setText(this.pCu.pBI);
                this.pEb.pEj.setTextColor(context.getResources().getColor(c.btv));
                return;
            } else if (this.pCu.fqd != 0) {
                return;
            } else {
                if (bh.ov(this.pCu.pBI)) {
                    if (bh.ov(this.pCu.name)) {
                        this.pEb.pEj.setText("");
                        this.pEb.pEj.setTextColor(context.getResources().getColor(c.btv));
                        return;
                    }
                    this.pEb.pEj.setText(this.pCu.name);
                    this.pEb.pEj.setTextColor(context.getResources().getColor(c.ubi));
                    return;
                } else if (bh.ov(this.pCu.name)) {
                    this.pEb.pEj.setText(this.pCu.pBI);
                    this.pEb.pEj.setTextColor(context.getResources().getColor(c.btv));
                    return;
                } else {
                    this.pEb.pEj.setText(this.pCu.name + context.getString(i.uVN, new Object[]{this.pCu.pBI}));
                    this.pEb.pEj.setTextColor(context.getResources().getColor(c.ubi));
                    return;
                }
            }
        }
        this.pEb.pEh.setText("");
        x.d(c.bz(), "editTv.setText null");
        this.pEb.pEj.setText("");
    }

    public final void hy(boolean z) {
        List arrayList;
        x.d(c.bz(), "needSetInput: %s", new Object[]{Boolean.valueOf(z)});
        List bms = com.tencent.mm.plugin.recharge.a.a.bmr().bms();
        a bmt;
        if (bms == null) {
            arrayList = new ArrayList();
            bmt = com.tencent.mm.plugin.recharge.a.a.bmt();
            if (bmt != null) {
                arrayList.add(bmt);
                com.tencent.mm.plugin.recharge.a.a.bmr().a(bmt);
            }
        } else {
            String str = (String) g.Dj().CU().get(6, null);
            for (int i = 0; i < bms.size(); i++) {
                bmt = (a) bms.get(i);
                if (bh.ov(bmt.pBH) || !bmt.pBH.equals(str)) {
                    if (!(bh.ov(bmt.pBH) || !bh.ov(bmt.name) || this.pCt == null)) {
                        for (String[] strArr : this.pCt) {
                            if (bmt.pBH.equals(b.Id(strArr[2]))) {
                                bmt.name = strArr[1];
                                x.i(c.bz(), "add name: %s", new Object[]{strArr[1]});
                                break;
                            }
                        }
                    }
                } else if (bh.ov(bmt.name) || !bmt.name.equals(this.pEb.getContext().getString(i.uVT))) {
                    bmt.name = this.pEb.getContext().getString(i.uVT);
                } else {
                }
                com.tencent.mm.plugin.recharge.a.a.bmr().bt(bms);
            }
            arrayList = bms;
        }
        this.pEc.bt(arrayList);
        if (arrayList != null && arrayList.size() > 0 && z) {
            this.pCu = (a) arrayList.get(0);
            b(this.pCu);
        }
    }
}
