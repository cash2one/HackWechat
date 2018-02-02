package com.tencent.mm.plugin.wallet_payu.security_question.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class PayUSecurityQuestion$1 implements Creator<PayUSecurityQuestion> {
    PayUSecurityQuestion$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new PayUSecurityQuestion(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new PayUSecurityQuestion[i];
    }
}
