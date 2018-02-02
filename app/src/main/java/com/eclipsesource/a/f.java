package com.eclipsesource.a;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.io.Reader;
import java.io.StringReader;
import org.xwalk.core.R$styleable;

final class f {
    private final Reader abK;
    private final char[] abL;
    private int abM;
    private int abN;
    private int abO;
    private int abP;
    private StringBuilder abQ;
    private int abR;
    private int index;
    private int line;

    f(String str) {
        this(new StringReader(str), Math.max(10, Math.min(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, str.length())));
    }

    private f(Reader reader, int i) {
        this.abK = reader;
        this.abL = new char[i];
        this.line = 1;
        this.abR = -1;
    }

    final h hu() {
        h bVar;
        switch (this.abP) {
            case 34:
                return new g(hv());
            case R$styleable.AppCompatTheme_actionDropDownStyle /*45*/:
            case R$styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
            case R$styleable.AppCompatTheme_actionButtonStyle /*49*/:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
                hz();
                c('-');
                int i = this.abP;
                if (hw()) {
                    if (i != 48) {
                        do {
                        } while (hw());
                    }
                    if (c('.')) {
                        if (hw()) {
                            do {
                            } while (hw());
                        } else {
                            throw D("digit");
                        }
                    }
                    if (!c('e') && !c('E')) {
                        return new d(hA());
                    }
                    if (!c('+')) {
                        c('-');
                    }
                    if (hw()) {
                        do {
                        } while (hw());
                        return new d(hA());
                    }
                    throw D("digit");
                }
                throw D("digit");
            case 91:
                hy();
                bVar = new b();
                hx();
                if (c(']')) {
                    return bVar;
                }
                do {
                    hx();
                    bVar.a(hu());
                    hx();
                } while (c(','));
                if (c(']')) {
                    return bVar;
                }
                throw D("',' or ']'");
            case 102:
                hy();
                b('a');
                b('l');
                b('s');
                b('e');
                return a.abv;
            case 110:
                hy();
                b('u');
                b('l');
                b('l');
                return a.abt;
            case 116:
                hy();
                b('r');
                b('u');
                b('e');
                return a.abu;
            case 123:
                hy();
                bVar = new e();
                hx();
                if (c('}')) {
                    return bVar;
                }
                do {
                    hx();
                    if (this.abP != 34) {
                        throw D("name");
                    }
                    String hv = hv();
                    hx();
                    if (c(':')) {
                        hx();
                        bVar.a(hv, hu());
                        hx();
                    } else {
                        throw D("':'");
                    }
                } while (c(','));
                if (c('}')) {
                    return bVar;
                }
                throw D("',' or '}'");
            default:
                throw D(DownloadSettingTable$Columns.VALUE);
        }
    }

    private void b(char c) {
        if (!c(c)) {
            throw D("'" + c + "'");
        }
    }

    private String hv() {
        hy();
        hz();
        while (this.abP != 34) {
            if (this.abP == 92) {
                this.abQ.append(this.abL, this.abR, (this.abP == -1 ? this.index : this.index - 1) - this.abR);
                this.abR = -1;
                hy();
                switch (this.abP) {
                    case 34:
                    case 47:
                    case 92:
                        this.abQ.append((char) this.abP);
                        break;
                    case 98:
                        this.abQ.append('\b');
                        break;
                    case 102:
                        this.abQ.append('\f');
                        break;
                    case 110:
                        this.abQ.append('\n');
                        break;
                    case 114:
                        this.abQ.append('\r');
                        break;
                    case 116:
                        this.abQ.append('\t');
                        break;
                    case 117:
                        char[] cArr = new char[4];
                        for (int i = 0; i < 4; i++) {
                            hy();
                            Object obj = ((this.abP < 48 || this.abP > 57) && ((this.abP < 97 || this.abP > 102) && (this.abP < 65 || this.abP > 70))) ? null : 1;
                            if (obj == null) {
                                throw D("hexadecimal digit");
                            }
                            cArr[i] = (char) this.abP;
                        }
                        this.abQ.append((char) Integer.parseInt(new String(cArr), 16));
                        break;
                    default:
                        throw D("valid escape sequence");
                }
                hy();
                hz();
            } else if (this.abP < 32) {
                throw D("valid string character");
            } else {
                hy();
            }
        }
        String hA = hA();
        hy();
        return hA;
    }

    private boolean c(char c) {
        if (this.abP != c) {
            return false;
        }
        hy();
        return true;
    }

    private boolean hw() {
        boolean z;
        if (this.abP < 48 || this.abP > 57) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            return false;
        }
        hy();
        return true;
    }

    final void hx() {
        while (true) {
            Object obj = (this.abP == 32 || this.abP == 9 || this.abP == 10 || this.abP == 13) ? 1 : null;
            if (obj != null) {
                hy();
            } else {
                return;
            }
        }
    }

    final void hy() {
        if (this.index == this.abN) {
            if (this.abR != -1) {
                this.abQ.append(this.abL, this.abR, this.abN - this.abR);
                this.abR = 0;
            }
            this.abM += this.abN;
            this.abN = this.abK.read(this.abL, 0, this.abL.length);
            this.index = 0;
            if (this.abN == -1) {
                this.abP = -1;
                return;
            }
        }
        if (this.abP == 10) {
            this.line++;
            this.abO = this.abM + this.index;
        }
        char[] cArr = this.abL;
        int i = this.index;
        this.index = i + 1;
        this.abP = cArr[i];
    }

    private void hz() {
        if (this.abQ == null) {
            this.abQ = new StringBuilder();
        }
        this.abR = this.index - 1;
    }

    private String hA() {
        String stringBuilder;
        int i = this.abP == -1 ? this.index : this.index - 1;
        if (this.abQ.length() > 0) {
            this.abQ.append(this.abL, this.abR, i - this.abR);
            stringBuilder = this.abQ.toString();
            this.abQ.setLength(0);
        } else {
            stringBuilder = new String(this.abL, this.abR, i - this.abR);
        }
        this.abR = -1;
        return stringBuilder;
    }

    private j D(String str) {
        if (hB()) {
            return E("Unexpected end of input");
        }
        return E("Expected " + str);
    }

    final j E(String str) {
        int i = this.abM + this.index;
        int i2 = i - this.abO;
        if (!hB()) {
            i--;
        }
        return new j(str, i, this.line, i2 - 1);
    }

    final boolean hB() {
        return this.abP == -1;
    }
}
