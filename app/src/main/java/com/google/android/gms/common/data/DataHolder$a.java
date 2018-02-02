package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.w;
import java.util.ArrayList;
import java.util.HashMap;

public class DataHolder$a {
    final String[] aMi;
    final ArrayList<HashMap<String, Object>> aMr;
    private final String aMs;
    private final HashMap<Object, Integer> aMt;
    private boolean aMu;
    private String aMv;

    private DataHolder$a(String[] strArr, String str) {
        this.aMi = (String[]) w.ag(strArr);
        this.aMr = new ArrayList();
        this.aMs = str;
        this.aMt = new HashMap();
        this.aMu = false;
        this.aMv = null;
    }
}
