package com.tencent.mm.kernel.a.b;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import junit.framework.Assert;

public final class a {
    private static ThreadLocal<Stack<b>> gRW = new ThreadLocal();

    public static class a {
        Object gRT;
        Class gRX;
        Set gRY = new HashSet();

        a(Object obj, Class cls) {
            this.gRT = obj;
            if (cls != null) {
                this.gRX = cls;
            }
            aI(this.gRT);
        }

        private void aI(Object obj) {
            Assert.assertNotNull(obj);
            Assert.assertNotNull(this.gRX);
            if (!this.gRX.isInstance(obj)) {
                throw new IllegalArgumentException("Your depend object " + obj + " must implement your type " + this.gRX);
            }
        }

        public final a aJ(Object obj) {
            this.gRY.add(obj);
            aI(obj);
            return this;
        }
    }

    static class b {
        public HashMap<Class, a> gRZ = null;

        b() {
        }
    }

    public static a a(Object obj, Class cls) {
        b bVar = (b) ((Stack) gRW.get()).peek();
        Assert.assertNotNull(bVar);
        if (bVar.gRZ == null) {
            bVar.gRZ = new HashMap();
        }
        a aVar = (a) bVar.gRZ.get(cls);
        if (aVar != null) {
            return aVar;
        }
        aVar = new a(obj, cls);
        bVar.gRZ.put(aVar.gRX, aVar);
        return aVar;
    }

    static void start() {
        b bVar = new b();
        Stack stack = (Stack) gRW.get();
        if (stack == null) {
            stack = new Stack();
            gRW.set(stack);
        }
        stack.push(bVar);
    }

    static b DC() {
        return (b) ((Stack) gRW.get()).pop();
    }
}
