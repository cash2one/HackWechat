package com.tencent.mm.plugin.ipcall.ui;

final class a {
    String countryCode;
    String hEx;
    private int nGR;
    String nGS;

    public a(String str, String str2, int i, String str3) {
        this.hEx = str;
        this.countryCode = str2;
        this.nGR = i;
        this.nGS = str3;
    }

    public final int aUi() {
        if (this.nGR == 0) {
            return 0;
        }
        for (String equals : IPCallCountryCodeScrollbar.nJf) {
            if (equals.equals(String.valueOf((char) this.nGR))) {
                return this.nGR;
            }
        }
        return "#".charAt(0);
    }
}
