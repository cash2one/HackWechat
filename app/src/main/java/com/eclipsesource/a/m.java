package com.eclipsesource.a;

import com.tencent.wcdb.FileUtils;
import java.io.Writer;

final class m extends Writer {
    private final char[] abL;
    private int abN = 0;
    private final Writer aca;

    m(Writer writer) {
        this.aca = writer;
        this.abL = new char[FileUtils.S_IWUSR];
    }

    public final void write(int i) {
        if (this.abN > this.abL.length - 1) {
            flush();
        }
        char[] cArr = this.abL;
        int i2 = this.abN;
        this.abN = i2 + 1;
        cArr[i2] = (char) i;
    }

    public final void write(char[] cArr, int i, int i2) {
        if (this.abN > this.abL.length - i2) {
            flush();
            if (i2 > this.abL.length) {
                this.aca.write(cArr, i, i2);
                return;
            }
        }
        System.arraycopy(cArr, i, this.abL, this.abN, i2);
        this.abN += i2;
    }

    public final void write(String str, int i, int i2) {
        if (this.abN > this.abL.length - i2) {
            flush();
            if (i2 > this.abL.length) {
                this.aca.write(str, i, i2);
                return;
            }
        }
        str.getChars(i, i + i2, this.abL, this.abN);
        this.abN += i2;
    }

    public final void flush() {
        this.aca.write(this.abL, 0, this.abN);
        this.abN = 0;
    }

    public final void close() {
    }
}
