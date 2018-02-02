package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.q.d;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.plugin.appbrand.widget.a;
import com.tencent.mm.plugin.appbrand.widget.input.AppBrandNumberKeyboardView;
import com.tencent.mm.protocal.c.ec;
import com.tencent.mm.protocal.c.ed;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMFormVerifyCodeInputView;
import com.tencent.mm.ui.u;
import com.tencent.mm.ui.v;
import java.lang.reflect.Method;

public final class b extends u {
    private TextView iXX;
    private ed jNM;
    private ec jNU;
    private TextView jNV;
    private TextView jNW;
    private MMFormVerifyCodeInputView jNX;
    private AppBrandNumberKeyboardView jNY;
    AppBrandIDCardUI$a jNt;
    private LinearLayout jNu;
    private View jNv;
    private Button jNy;
    private com.tencent.mm.ui.b mActionBarHelper;

    protected final void dealContentView(View view) {
        if (this.jNt == null || this.jNt.alb() == null) {
            x.e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "idCardUILogic or idCardUILogic.getIDCardShowInfo() is null, err");
        } else if (this.jNt.alb().vJv == null || this.jNt.alb().vJv.size() <= 0) {
            x.e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "sms.get(0) is null, err, return");
        } else {
            this.jNu = (LinearLayout) view.findViewById(g.iuk);
            this.iXX = (TextView) view.findViewById(g.iuh);
            this.jNV = (TextView) view.findViewById(g.iul);
            this.jNW = (TextView) view.findViewById(g.ium);
            this.jNy = (Button) view.findViewById(g.itW);
            this.jNX = (MMFormVerifyCodeInputView) view.findViewById(g.iui);
            this.jNY = (AppBrandNumberKeyboardView) view.findViewById(g.iuj);
            this.jNv = v.fv(getContext()).inflate(h.cZW, null);
            this.jNv.setBackgroundColor(getResources().getColor(d.bre));
            this.mActionBarHelper = new com.tencent.mm.ui.b(this.jNv);
            this.jNu.addView(this.jNv, 0, new LayoutParams(-1, a.ci(getActivity())));
            this.jNM = this.jNt.alb();
            this.mActionBarHelper.setTitle(this.jNM.title);
            this.mActionBarHelper.p(new OnClickListener(this) {
                final /* synthetic */ b jNZ;

                {
                    this.jNZ = r1;
                }

                public final void onClick(View view) {
                    if (this.jNZ.jNt != null) {
                        this.jNZ.jNt.back();
                    }
                }
            });
            this.iXX.setText(this.jNM.desc);
            this.jNU = (ec) this.jNM.vJv.get(0);
            this.jNV.setText(((ec) this.jNM.vJv.get(0)).vJu);
            this.jNW.setOnClickListener(new 2(this));
            this.jNX.setVisibility(0);
            this.jNX.yaE = new 3(this);
            this.jNX.addTextChangedListener(new 4(this));
            View view2 = this.jNX.pqM;
            if (view2 != null) {
                if (VERSION.SDK_INT >= 21) {
                    view2.setShowSoftInputOnFocus(false);
                } else {
                    Class cls = EditText.class;
                    try {
                        Method method = cls.getMethod("setShowSoftInputOnFocus", new Class[]{Boolean.TYPE});
                        method.setAccessible(true);
                        method.invoke(view2, new Object[]{Boolean.valueOf(false)});
                        method.setAccessible(false);
                    } catch (NoSuchMethodException e) {
                        x.i("MicroMsg.AppBrandIDCardVerifyPwdFrag", "setNoSystemInputOnEditText, setShowSoftInputOnFocus no such method, api level = %d", new Object[]{Integer.valueOf(VERSION.SDK_INT)});
                        try {
                            Method method2 = cls.getMethod("setSoftInputShownOnFocus", new Class[]{Boolean.TYPE});
                            method2.setAccessible(true);
                            method2.invoke(view2, new Object[]{Boolean.valueOf(false)});
                            method2.setAccessible(false);
                        } catch (Throwable e2) {
                            x.e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "setNoSystemInputOnEditText, reflect method [setSoftInputShownOnFocus], exp = %s", new Object[]{bh.i(e2)});
                            if (view2.getContext() != null && (view2.getContext() instanceof MMActivity)) {
                                ((MMActivity) view2.getContext()).df(view2);
                            }
                        }
                    } catch (Throwable e22) {
                        x.e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "setNoSystemInputOnEditText, reflect method [setShowSoftInputOnFocus], exp = %s", new Object[]{bh.i(e22)});
                    }
                }
            }
            if (this.jNX.getText() == null || this.jNX.getText().toString().length() <= 0) {
                this.jNy.setEnabled(false);
            } else {
                this.jNy.setEnabled(true);
            }
            this.jNy.setVisibility(0);
            this.jNy.setOnClickListener(new 5(this));
            this.jNY.setXMode(0);
            this.jNY.setInputEditText(this.jNX.pqM);
        }
    }

    protected final int getLayoutId() {
        return h.iwW;
    }

    public final void onResume() {
        super.onResume();
        if (isSupportNavigationSwipeBack()) {
            getContentView().setVisibility(0);
            getSwipeBackLayout().mEnable = true;
        }
    }

    public final boolean noActionBar() {
        return true;
    }

    public final void onSwipeBack() {
        if (this.jNt != null) {
            this.jNt.onSwipeBack();
            getContentView().setVisibility(8);
            if (isSupportNavigationSwipeBack()) {
                getSwipeBackLayout().mEnable = false;
            }
        }
    }
}
