package com.tencent.mm.ipcinvoker;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.d.e;
import junit.framework.Assert;

public final class d {
    public String process;

    private static class a implements h<Bundle, Bundle> {
        private a() {
        }

        public final /* synthetic */ void a(Object obj, final i iVar) {
            Bundle bundle = (Bundle) obj;
            String string = bundle.getString("Token");
            com.tencent.mm.ipcinvoker.d.c.Bz().a(bundle.getString("Event"), new c(this, string) {
                final /* synthetic */ a gMw;

                public final /* bridge */ /* synthetic */ void as(Object obj) {
                    iVar.as((Bundle) obj);
                }
            });
        }
    }

    private static abstract class c implements e {
        String token;

        c(String str) {
            this.token = str;
            Assert.assertNotNull(str);
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof c)) {
                return false;
            }
            return this.token.equals(((c) obj).token);
        }
    }

    public d(String str) {
        this.process = str;
    }

    public static String ar(Object obj) {
        return "Token#IPCObserver#" + obj.hashCode();
    }
}
