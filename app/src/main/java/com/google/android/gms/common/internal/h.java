package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.view.View;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;
import com.google.android.gms.signin.e;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class h {
    public final Account aIz;
    public final Set<Scope> aJU;
    private final int aJV;
    private final View aJW;
    public final String aJX;
    final String aJY;
    final Set<Scope> aNP;
    public final Map<a<?>, a> aNQ;
    public final e aNR;
    public Integer aNS;

    public h(Account account, Set<Scope> set, Map<a<?>, a> map, int i, View view, String str, String str2, e eVar) {
        Map map2;
        this.aIz = account;
        this.aJU = set == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(set);
        if (map == null) {
            map2 = Collections.EMPTY_MAP;
        }
        this.aNQ = map2;
        this.aJW = view;
        this.aJV = i;
        this.aJX = str;
        this.aJY = str2;
        this.aNR = eVar;
        Set hashSet = new HashSet(this.aJU);
        for (a aVar : this.aNQ.values()) {
            hashSet.addAll(aVar.aKo);
        }
        this.aNP = Collections.unmodifiableSet(hashSet);
    }
}
