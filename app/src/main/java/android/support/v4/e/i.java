package android.support.v4.e;

public final class i {

    public static class b<T> implements a<T> {
        private final Object[] ws;
        private int wt;

        public b(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }
            this.ws = new Object[i];
        }

        public T bG() {
            if (this.wt <= 0) {
                return null;
            }
            int i = this.wt - 1;
            T t = this.ws[i];
            this.ws[i] = null;
            this.wt--;
            return t;
        }

        public boolean j(T t) {
            boolean z;
            for (int i = 0; i < this.wt; i++) {
                if (this.ws[i] == t) {
                    z = true;
                    break;
                }
            }
            z = false;
            if (z) {
                throw new IllegalStateException("Already in the pool!");
            } else if (this.wt >= this.ws.length) {
                return false;
            } else {
                this.ws[this.wt] = t;
                this.wt++;
                return true;
            }
        }
    }

    public static class c<T> extends b<T> {
        private final Object mLock = new Object();

        public c() {
            super(16);
        }

        public final T bG() {
            T bG;
            synchronized (this.mLock) {
                bG = super.bG();
            }
            return bG;
        }

        public final boolean j(T t) {
            boolean j;
            synchronized (this.mLock) {
                j = super.j(t);
            }
            return j;
        }
    }
}
