package b.c.b;

import b.e.c;
import java.io.Serializable;

public abstract class a implements b.e.a, Serializable {
    public static final Object AuM = a.cJw();
    private transient b.e.a AuK;
    protected final Object AuL;

    protected abstract b.e.a cJs();

    public a() {
        this(AuM);
    }

    private a(Object obj) {
        this.AuL = obj;
    }

    public final Object cJt() {
        return this.AuL;
    }

    public final b.e.a cJu() {
        b.e.a aVar = this.AuK;
        if (aVar != null) {
            return aVar;
        }
        aVar = cJs();
        this.AuK = aVar;
        return aVar;
    }

    public c cJv() {
        throw new AbstractMethodError();
    }

    public String getName() {
        throw new AbstractMethodError();
    }

    public String cjL() {
        throw new AbstractMethodError();
    }
}
