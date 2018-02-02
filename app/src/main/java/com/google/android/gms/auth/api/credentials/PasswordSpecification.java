package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public final class PasswordSpecification implements SafeParcelable {
    public static final e CREATOR = new e();
    public static final PasswordSpecification aIT = new a().nO().aH("abcdefghijkmnopqrstxyzABCDEFGHJKLMNPQRSTXY3456789").aI("abcdefghijkmnopqrstxyz").aI("ABCDEFGHJKLMNPQRSTXY").aI("3456789").nP();
    public static final PasswordSpecification aIU = new a().nO().aH("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890").aI("abcdefghijklmnopqrstuvwxyz").aI("ABCDEFGHIJKLMNOPQRSTUVWXYZ").aI("1234567890").nP();
    final String aIV;
    final List<String> aIW;
    final List<Integer> aIX;
    final int aIY;
    final int aIZ;
    private final int[] aJa = nN();
    private final Random aJb = new SecureRandom();
    final int mVersionCode;

    PasswordSpecification(int i, String str, List<String> list, List<Integer> list2, int i2, int i3) {
        this.mVersionCode = i;
        this.aIV = str;
        this.aIW = Collections.unmodifiableList(list);
        this.aIX = Collections.unmodifiableList(list2);
        this.aIY = i2;
        this.aIZ = i3;
    }

    static /* synthetic */ String b(Collection collection) {
        char[] cArr = new char[collection.size()];
        int i = 0;
        for (Character charValue : collection) {
            int i2 = i + 1;
            cArr[i] = charValue.charValue();
            i = i2;
        }
        return new String(cArr);
    }

    static /* synthetic */ boolean dc(int i) {
        return i < 32 || i > 126;
    }

    private int[] nN() {
        int[] iArr = new int[95];
        Arrays.fill(iArr, -1);
        int i = 0;
        for (String toCharArray : this.aIW) {
            for (char c : toCharArray.toCharArray()) {
                iArr[c - 32] = i;
            }
            i++;
        }
        return iArr;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        e.a(this, parcel);
    }
}
