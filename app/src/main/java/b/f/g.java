package b.f;

import b.a.a;
import b.c.b.e;
import b.d.c;
import java.util.Collection;
import java.util.Iterator;

public class g extends f {
    public static final boolean X(CharSequence charSequence) {
        e.i(charSequence, "$receiver");
        if (charSequence.length() != 0) {
            int i;
            e.i(charSequence, "$receiver");
            Iterable cVar = new c(0, charSequence.length() - 1);
            if (!((cVar instanceof Collection) && ((Collection) cVar).isEmpty())) {
                Iterator it = cVar.iterator();
                while (it.hasNext()) {
                    char charAt = charSequence.charAt(((a) it).nextInt());
                    if (Character.isWhitespace(charAt) || Character.isSpaceChar(charAt)) {
                        i = 1;
                        continue;
                    } else {
                        i = 0;
                        continue;
                    }
                    if (i == 0) {
                        i = 0;
                        break;
                    }
                }
            }
            i = 1;
            if (i == 0) {
                return false;
            }
        }
        return true;
    }
}
