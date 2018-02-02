package com.tencent.d.b.f;

import android.content.Context;
import com.tencent.d.b.c.a;
import com.tencent.d.b.e.c;
import com.tencent.d.b.e.f;

public final class b {
    c AcW;
    public f AcX;
    com.tencent.d.b.c.b AcY;
    public int irz;
    Context mContext;
    a mzB;
    String thp;

    private b() {
    }

    public final String toString() {
        return "AuthenticationParam{mScene=" + this.irz + ", mChallenge='" + this.thp + '\'' + ", mIWrapGetChallengeStr=" + this.AcW + ", mIWrapUploadSignature=" + this.AcX + ", mContext=" + this.mContext + ", mFingerprintCanceller=" + this.mzB + ", mSoterFingerprintStateCallback=" + this.AcY + '}';
    }
}
