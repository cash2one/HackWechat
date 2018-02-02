package com.tencent.mm.plugin.wallet_core.id_verify.util;

import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.id_verify.util.a.3;
import com.tencent.mm.plugin.wallet_core.id_verify.util.a.4;
import com.tencent.mm.plugin.wallet_core.id_verify.util.a.5;
import com.tencent.mm.plugin.wxpay.a$c;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public class RealnameGuideHelper implements Parcelable {
    public static final Creator<RealnameGuideHelper> CREATOR = new 1();
    private int hze;
    private String odu;
    private String odv;
    private String odw = "";
    private String odx = "";
    private String ody = "";
    private SetPwdInfo sKf;
    private boolean sKg = false;

    protected RealnameGuideHelper(Parcel parcel) {
        boolean z;
        this.sKf = (SetPwdInfo) parcel.readParcelable(SetPwdInfo.class.getClassLoader());
        this.odu = parcel.readString();
        this.odv = parcel.readString();
        this.odw = parcel.readString();
        this.odx = parcel.readString();
        this.ody = parcel.readString();
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.sKg = z;
        this.hze = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.sKf, i);
        parcel.writeString(this.odu);
        parcel.writeString(this.odv);
        parcel.writeString(this.odw);
        parcel.writeString(this.odx);
        parcel.writeString(this.ody);
        parcel.writeByte((byte) (this.sKg ? 1 : 0));
        parcel.writeInt(this.hze);
    }

    public int describeContents() {
        return 0;
    }

    public final void a(String str, SetPwdInfo setPwdInfo, String str2, String str3, String str4, String str5, int i) {
        this.sKf = setPwdInfo;
        this.odu = str;
        this.odv = str2;
        this.odw = str3;
        this.odx = str4;
        this.ody = str5;
        this.hze = i;
    }

    public final void a(String str, String str2, String str3, String str4, String str5, int i) {
        a(str, null, str2, str3, str4, str5, i);
    }

    public final boolean a(MMActivity mMActivity, Bundle bundle, OnClickListener onClickListener) {
        x.d("MicroMsg.RealnameGuideHelper", "doIfNeedSetPwd sendPwdMsg %s mEntryScene %s guide_wording %s upload_credit_url %s left_button_wording %s right_button_wording %s hadShow %s guide_flag %s", new Object[]{this.sKf, Integer.valueOf(this.hze), this.odv, this.ody, this.odw, this.odx, Boolean.valueOf(this.sKg), this.odu});
        if (this.sKg) {
            return false;
        }
        if (this.sKf == null || this.sKf.sKq != 1) {
            return false;
        }
        boolean z;
        int i = this.hze;
        String str = this.sKf.odv;
        String str2 = this.sKf.odw;
        String str3 = this.sKf.odx;
        g.Dk();
        int intValue = ((Integer) g.Dj().CU().get(a.xwA, Integer.valueOf(0))).intValue();
        x.i("MicroMsg.RealnameVerifyUtil", "showSetPwdDialog count %s", new Object[]{Integer.valueOf(intValue)});
        if (intValue >= 3) {
            z = false;
        } else {
            OnClickListener 3;
            intValue++;
            g.Dk();
            g.Dj().CU().a(a.xwA, Integer.valueOf(intValue));
            if (bh.ov(str2)) {
                str2 = mMActivity.getString(i.dEn);
            }
            if (bh.ov(str3)) {
                str3 = mMActivity.getString(i.dFU);
            }
            if (onClickListener == null) {
                3 = new 3(false, mMActivity);
            } else {
                3 = onClickListener;
            }
            com.tencent.mm.ui.base.i a = h.a(mMActivity, str, "", str3, str2, new 4(bundle, i, mMActivity, false), 3, a$c.bui);
            if (a != null) {
                a.setOnCancelListener(new 5(false, mMActivity));
                a.setOnDismissListener(new a$6(false, mMActivity));
            }
            z = true;
        }
        if (!z || this.sKg) {
            return z;
        }
        this.sKg = true;
        return z;
    }

    public final boolean b(MMActivity mMActivity, Bundle bundle, OnClickListener onClickListener) {
        return a(mMActivity, bundle, onClickListener, false);
    }

    public final boolean a(MMActivity mMActivity, Bundle bundle, OnClickListener onClickListener, boolean z) {
        if (this.sKg) {
            return false;
        }
        if ("1".equals(this.odu)) {
            if (!this.sKg) {
                this.sKg = true;
            }
            return a.a(mMActivity, bundle, this.hze);
        } else if (!"2".equals(this.odu) || bh.ov(this.ody)) {
            return false;
        } else {
            if (!this.sKg) {
                this.sKg = true;
            }
            return a.a(mMActivity, this.odv, this.ody, this.odw, this.odx, z, onClickListener);
        }
    }
}
