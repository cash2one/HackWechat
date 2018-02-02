package org.b.d;

import java.io.Serializable;
import org.b.g.d;

public final class i implements Serializable {
    private final String AyD;
    public final String token;
    public final String wyk;

    public i(String str, String str2) {
        this(str, str2, null);
    }

    public i(String str, String str2, String str3) {
        d.j(str, "Token can't be null");
        d.j(str2, "Secret can't be null");
        this.token = str;
        this.wyk = str2;
        this.AyD = str3;
    }

    public final String toString() {
        return String.format("Token[%s , %s]", new Object[]{this.token, this.wyk});
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        if (this.token.equals(iVar.token) && this.wyk.equals(iVar.wyk)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (this.token.hashCode() * 31) + this.wyk.hashCode();
    }
}
