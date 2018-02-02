package com.tencent.mm.plugin.wallet_core.id_verify.util;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.protocal.c.bnm;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.wallet_core.d.c;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public final class a implements e {
    int irz = -1;
    private a sKh = null;
    WeakReference<MMActivity> sKi;
    WeakReference<c> sKj;
    private boolean sKk = false;
    i sKl;

    public interface a {
        boolean b(int i, int i2, String str, boolean z);
    }

    public final boolean a(MMActivity mMActivity, c cVar, boolean z, int i) {
        this.sKk = false;
        g.Dk();
        long longValue = ((Long) g.Dj().CU().get(com.tencent.mm.storage.w.a.xrp, Long.valueOf(0))).longValue();
        if (longValue > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            com.tencent.mm.wallet_core.ui.e.a(5, bh.Wo(), i);
            if (currentTimeMillis < longValue) {
                x.i("MicroMsg.RealnameVerifyUtil", "getDisclaimer query is not expired. expiredTime = " + longValue);
                return false;
            }
            x.i("MicroMsg.RealnameVerifyUtil", "getDisclaimer query had expired. expiredTime = " + longValue);
        }
        if (mMActivity == null) {
            x.e("MicroMsg.RealnameVerifyUtil", "context is null");
        } else if (cVar == null) {
            x.e("MicroMsg.RealnameVerifyUtil", "netmgr is null");
        }
        return false;
    }

    private void aXe() {
        if (this.sKj != null && this.sKj.get() != null) {
            ((c) this.sKj.get()).aXe();
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.e) {
            g.Dk();
            g.Di().gPJ.b(385, this);
            aXe();
            if (i == 0 && i2 == 0) {
                com.tencent.mm.plugin.wallet_core.id_verify.model.e eVar = (com.tencent.mm.plugin.wallet_core.id_verify.model.e) kVar;
                boolean equals = eVar.sJR.equals("1");
                if (equals) {
                    x.i("MicroMsg.RealnameVerifyUtil", "user had agreed");
                    c(0, i2, str, equals);
                    return;
                }
                a((MMActivity) this.sKi.get(), (c) this.sKj.get(), eVar.title, eVar.sJS, eVar.sJT, eVar.sJU, this.sKh, false, eVar.sJV);
                return;
            }
            c(2, i2, str, false);
        } else if (kVar instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.a) {
            g.Dk();
            g.Di().gPJ.a(385, this);
            aXe();
            if (i == 0 && i2 == 0) {
                c(0, i2, str, true);
            } else {
                c(3, i2, str, false);
            }
        }
    }

    public final void a(MMActivity mMActivity, c cVar, String str, String str2, String str3, String str4, a aVar, boolean z, int i) {
        this.sKi = new WeakReference(mMActivity);
        this.sKj = new WeakReference(cVar);
        this.sKk = z;
        if (this.sKi != null && this.sKi.get() != null) {
            this.sKh = aVar;
            CharSequence charSequence = str + str2;
            com.tencent.mm.plugin.wallet_core.ui.g gVar = new com.tencent.mm.plugin.wallet_core.ui.g(mMActivity);
            gVar.sTw = new 1(this, i, str3, mMActivity);
            charSequence = com.tencent.mm.pluginsdk.ui.d.i.a(mMActivity, charSequence);
            CharSequence spannableString = new SpannableString(charSequence);
            spannableString.setSpan(gVar, charSequence.length() - str2.length(), charSequence.length(), 33);
            View textView = new TextView(mMActivity);
            textView.setText(spannableString);
            textView.setTextSize(0, (float) com.tencent.mm.bv.a.aa(mMActivity, d.bvs));
            textView.setTextColor(mMActivity.getResources().getColorStateList(com.tencent.mm.plugin.wxpay.a.c.btv));
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            com.tencent.mm.wallet_core.ui.e.a(0, bh.Wo(), i);
            final int i2 = i;
            Context context = mMActivity;
            String str5 = str4;
            this.sKl = h.a(context, "", textView, str5, mMActivity.getString(com.tencent.mm.plugin.wxpay.a.i.dEn), new 7(this, i), new OnClickListener(this) {
                final /* synthetic */ a sKo;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    com.tencent.mm.wallet_core.ui.e.a(1, bh.Wo(), i2);
                    this.sKo.c(1, -1, "cancel", false);
                }
            });
        }
    }

    final void c(int i, int i2, String str, boolean z) {
        x.i("MicroMsg.RealnameVerifyUtil", "doGetDisclaimerCallback call");
        if (this.sKh != null) {
            g.Dk();
            g.Dj().CU().a(com.tencent.mm.storage.w.a.xrq, Integer.valueOf(z ? 0 : 1));
            this.sKh.b(i, i2, str, z);
            if (this.sKl != null) {
                this.sKl.dismiss();
            }
            this.sKk = false;
            if (this.sKl != null) {
                x.i("MicroMsg.RealnameVerifyUtil", "getDisclaimerCallback : close mDisclaimerDialog");
                this.sKl = null;
            }
            if (this.sKj != null) {
                x.i("MicroMsg.RealnameVerifyUtil", "getDisclaimerCallback : clear mNetSceneMgr");
                this.sKj.clear();
                this.sKj = null;
            }
            if (this.sKi != null) {
                x.i("MicroMsg.RealnameVerifyUtil", "getDisclaimerCallback : clear mContextReference");
                this.sKi.clear();
                this.sKi = null;
            }
            x.i("MicroMsg.RealnameVerifyUtil", "getDisclaimerCallback : clear getDisclaimerCallback");
            this.sKh = null;
        }
    }

    private static JSONObject p(k kVar) {
        if (kVar != null && (kVar instanceof com.tencent.mm.wallet_core.tenpay.model.i)) {
            b bVar = ((com.tencent.mm.wallet_core.tenpay.model.i) kVar).gJQ;
            if (bVar != null) {
                bnm com_tencent_mm_protocal_c_bnm = (bnm) bVar.hmh.hmo;
                if (com_tencent_mm_protocal_c_bnm.wrx != null) {
                    try {
                        return new JSONObject(n.b(com_tencent_mm_protocal_c_bnm.wrx));
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.RealnameVerifyUtil", e, "", new Object[0]);
                        return null;
                    }
                }
            }
        }
        return null;
    }

    public static boolean a(Activity activity, int i, k kVar, Bundle bundle, int i2) {
        if (i != 416) {
            x.i("MicroMsg.RealnameVerifyUtil", "don't need realname verify");
            return false;
        }
        x.i("MicroMsg.RealnameVerifyUtil", "need realname verify");
        return a(activity, kVar, bundle, false, null, i2, 2);
    }

    public static boolean a(Activity activity, k kVar, Bundle bundle, boolean z, OnClickListener onClickListener, int i, int i2) {
        String str;
        String str2 = "";
        String str3 = "";
        String str4 = "";
        String str5 = "";
        String str6 = "";
        JSONObject p = p(kVar);
        if (p != null) {
            if (p.has("real_name_info")) {
                p = p.optJSONObject("real_name_info");
            }
            str2 = p.optString("guide_flag", "0");
            str3 = p.optString("guide_wording");
            str4 = p.optString("left_button_wording", activity.getString(com.tencent.mm.plugin.wxpay.a.i.dEn));
            str5 = p.optString("right_button_wording", activity.getString(com.tencent.mm.plugin.wxpay.a.i.dFU));
            str6 = p.optString("upload_credit_url", "");
            str = str2;
        } else {
            str = str2;
        }
        x.i("MicroMsg.RealnameVerifyUtil", "guide_flag = " + str + ";upload_credit_url=" + str6);
        if ("1".equals(str)) {
            x.i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog");
            return a(activity, bundle, i);
        } else if (!"2".equals(str) || bh.ov(str6)) {
            x.e("MicroMsg.RealnameVerifyUtil", "guide_flag=" + str + ";upload_credit_url=null?" + bh.ov(str6));
            return false;
        } else {
            x.i("MicroMsg.RealnameVerifyUtil", "showUploadCreditDialog");
            return a(activity, str3, str6, str4, str5, z, null);
        }
    }

    public static boolean a(Activity activity, Bundle bundle, int i) {
        x.i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog call %d", new Object[]{Integer.valueOf(0)});
        x.i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog click OK");
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putInt("real_name_verify_mode", 0);
        bundle.putInt("entry_scene", i);
        com.tencent.mm.wallet_core.a.a(activity, com.tencent.mm.plugin.wallet_core.id_verify.a.class, bundle);
        com.tencent.mm.wallet_core.ui.e.a(19, bh.Wo(), i);
        return true;
    }

    public static boolean a(final Activity activity, String str, String str2, String str3, String str4, final boolean z, OnClickListener onClickListener) {
        String string;
        String string2;
        OnClickListener 9;
        if (bh.ov(str3)) {
            string = activity.getString(com.tencent.mm.plugin.wxpay.a.i.dEn);
        } else {
            string = str3;
        }
        if (bh.ov(str4)) {
            string2 = activity.getString(com.tencent.mm.plugin.wxpay.a.i.dFU);
        } else {
            string2 = str4;
        }
        if (onClickListener == null) {
            x.i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog use default calcel listener");
            9 = new 9(z, activity);
        } else {
            9 = onClickListener;
        }
        i a = h.a((Context) activity, str, "", string2, string, new 10(str2, activity, z), 9, com.tencent.mm.plugin.wxpay.a.c.bui);
        if (a != null) {
            a.setOnCancelListener(new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    if (z) {
                        activity.finish();
                    }
                }
            });
            a.setOnDismissListener(new 2(z, activity));
        }
        return true;
    }
}
