package org.b.d;

import java.io.OutputStream;

public final class a {
    public final String Ayh;
    public final String Ayi;
    public final String Ayj;
    public final h Ayl;
    private final OutputStream Aym;
    public final String scope;

    public a(String str, String str2, String str3, h hVar, String str4, OutputStream outputStream) {
        this.Ayh = str;
        this.Ayi = str2;
        this.Ayj = str3;
        this.Ayl = hVar;
        this.scope = str4;
        this.Aym = outputStream;
    }

    public final void rE(String str) {
        if (this.Aym != null) {
            try {
                this.Aym.write(new StringBuilder(String.valueOf(str)).append("\n").toString().getBytes("UTF8"));
            } catch (Throwable e) {
                throw new RuntimeException("there were problems while writting to the debug stream", e);
            }
        }
    }
}
