package com.google.android.exoplayer2.h;

import java.io.IOException;

public class q$c extends IOException {
    public final i asH;
    public final int type;

    public q$c(String str, i iVar) {
        super(str);
        this.asH = iVar;
        this.type = 1;
    }

    public q$c(IOException iOException, i iVar, int i) {
        super(iOException);
        this.asH = iVar;
        this.type = i;
    }

    public q$c(String str, IOException iOException, i iVar) {
        super(str, iOException);
        this.asH = iVar;
        this.type = 1;
    }
}
