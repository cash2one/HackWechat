package com.google.android.exoplayer2.h;

import com.google.android.exoplayer2.i.l;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public interface q extends f {
    public static final l<String> aBC = new 1();

    public static final class d extends c {
        public final String aBD;

        public d(String str, i iVar) {
            super("Invalid content type: " + str, iVar);
            this.aBD = str;
        }
    }

    public static final class f {
        private final Map<String, String> aBF = new HashMap();
        private Map<String, String> aBG;

        public final synchronized Map<String, String> lx() {
            if (this.aBG == null) {
                this.aBG = Collections.unmodifiableMap(new HashMap(this.aBF));
            }
            return this.aBG;
        }
    }
}
