package b.c.b;

import b.c.b.a.a;
import b.c.b.a.b;
import java.util.Collection;

public class m {
    private static ClassCastException a(ClassCastException classCastException) {
        throw ((ClassCastException) e.b(classCastException, m.class.getName()));
    }

    public static Collection cC(Object obj) {
        if (!(obj instanceof a) || (obj instanceof b)) {
            return cD(obj);
        }
        throw a(new ClassCastException((obj == null ? "null" : obj.getClass().getName()) + " cannot be cast to " + "kotlin.collections.MutableCollection"));
    }

    private static Collection cD(Object obj) {
        try {
            return (Collection) obj;
        } catch (ClassCastException e) {
            throw a(e);
        }
    }
}
