package b.c.b;

import b.e.b;
import b.e.e;

public final class j {
    private static final k AuR;
    private static final b[] AuS = new b[0];

    static {
        k kVar;
        try {
            kVar = (k) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException e) {
            kVar = null;
        } catch (ClassNotFoundException e2) {
            kVar = null;
        } catch (InstantiationException e3) {
            kVar = null;
        } catch (IllegalAccessException e4) {
            kVar = null;
        }
        if (kVar == null) {
            kVar = new k();
        }
        AuR = kVar;
    }

    public static b R(Class cls) {
        return new c(cls);
    }

    public static String a(f fVar) {
        String obj = fVar.getClass().getGenericInterfaces()[0].toString();
        return obj.startsWith("kotlin.jvm.functions.") ? obj.substring(21) : obj;
    }

    public static e a(h hVar) {
        return hVar;
    }
}
