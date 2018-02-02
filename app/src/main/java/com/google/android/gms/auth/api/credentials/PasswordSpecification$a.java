package com.google.android.gms.auth.api.credentials;

import android.text.TextUtils;
import com.google.android.gms.auth.api.credentials.PasswordSpecification.b;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class PasswordSpecification$a {
    private final List<String> aIW = new ArrayList();
    private final List<Integer> aIX = new ArrayList();
    private int aIY = 12;
    private int aIZ = 16;
    private final TreeSet<Character> aJc = new TreeSet();

    private static TreeSet<Character> m(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new b(str2 + " cannot be null or empty");
        }
        TreeSet<Character> treeSet = new TreeSet();
        for (char c : str.toCharArray()) {
            if (PasswordSpecification.dc(c)) {
                throw new b(str2 + " must only contain ASCII printable characters");
            }
            treeSet.add(Character.valueOf(c));
        }
        return treeSet;
    }

    public final PasswordSpecification$a aH(String str) {
        this.aJc.addAll(m(str, "allowedChars"));
        return this;
    }

    public final PasswordSpecification$a aI(String str) {
        this.aIW.add(PasswordSpecification.b(m(str, "requiredChars")));
        this.aIX.add(Integer.valueOf(1));
        return this;
    }

    public final PasswordSpecification$a nO() {
        this.aIY = 12;
        this.aIZ = 16;
        return this;
    }

    public final PasswordSpecification nP() {
        if (this.aJc.isEmpty()) {
            throw new b("no allowed characters specified");
        }
        int i = 0;
        for (Integer intValue : this.aIX) {
            i = intValue.intValue() + i;
        }
        if (i > this.aIZ) {
            throw new b("required character count cannot be greater than the max password size");
        }
        boolean[] zArr = new boolean[95];
        for (String toCharArray : this.aIW) {
            for (char c : toCharArray.toCharArray()) {
                if (zArr[c - 32]) {
                    throw new b("character " + c + " occurs in more than one required character set");
                }
                zArr[c - 32] = true;
            }
        }
        return new PasswordSpecification(1, PasswordSpecification.b(this.aJc), this.aIW, this.aIX, this.aIY, this.aIZ);
    }
}
