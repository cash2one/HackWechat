package com.google.android.gms.c;

public final class av extends ay<av> {
    public a[] aZw;

    public static final class a extends ay<a> {
        private static volatile a[] aZx;
        public a aZy;
        public String name;

        public a() {
            this.name = "";
            this.aZy = null;
            this.aZZ = null;
            this.bak = -1;
        }

        public static a[] pV() {
            if (aZx == null) {
                synchronized (bc.baj) {
                    if (aZx == null) {
                        aZx = new a[0];
                    }
                }
            }
            return aZx;
        }

        public final /* synthetic */ be a(aw awVar) {
            while (true) {
                int pX = awVar.pX();
                switch (pX) {
                    case 0:
                        break;
                    case 10:
                        this.name = awVar.readString();
                        continue;
                    case 18:
                        if (this.aZy == null) {
                            this.aZy = new a();
                        }
                        awVar.a(this.aZy);
                        continue;
                    default:
                        if (!a(awVar, pX)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public final void a(ax axVar) {
            axVar.e(1, this.name);
            if (this.aZy != null) {
                axVar.a(2, this.aZy);
            }
            super.a(axVar);
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.name == null) {
                if (aVar.name != null) {
                    return false;
                }
            } else if (!this.name.equals(aVar.name)) {
                return false;
            }
            if (this.aZy == null) {
                if (aVar.aZy != null) {
                    return false;
                }
            } else if (!this.aZy.equals(aVar.aZy)) {
                return false;
            }
            return a((ay) aVar);
        }

        public final int hashCode() {
            int i = 0;
            int hashCode = ((this.name == null ? 0 : this.name.hashCode()) + 527) * 31;
            if (this.aZy != null) {
                i = this.aZy.hashCode();
            }
            return ((hashCode + i) * 31) + qg();
        }

        protected final int pw() {
            int pw = super.pw() + ax.f(1, this.name);
            return this.aZy != null ? pw + ax.b(2, this.aZy) : pw;
        }
    }

    public av() {
        this.aZw = a.pV();
        this.aZZ = null;
        this.bak = -1;
    }

    public final /* synthetic */ be a(aw awVar) {
        while (true) {
            int pX = awVar.pX();
            switch (pX) {
                case 0:
                    break;
                case 10:
                    int b = bh.b(awVar, 10);
                    pX = this.aZw == null ? 0 : this.aZw.length;
                    Object obj = new a[(b + pX)];
                    if (pX != 0) {
                        System.arraycopy(this.aZw, 0, obj, 0, pX);
                    }
                    while (pX < obj.length - 1) {
                        obj[pX] = new a();
                        awVar.a(obj[pX]);
                        awVar.pX();
                        pX++;
                    }
                    obj[pX] = new a();
                    awVar.a(obj[pX]);
                    this.aZw = obj;
                    continue;
                default:
                    if (!a(awVar, pX)) {
                        break;
                    }
                    continue;
            }
            return this;
        }
    }

    public final void a(ax axVar) {
        if (this.aZw != null && this.aZw.length > 0) {
            for (be beVar : this.aZw) {
                if (beVar != null) {
                    axVar.a(1, beVar);
                }
            }
        }
        super.a(axVar);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof av)) {
            return false;
        }
        av avVar = (av) obj;
        return bc.equals(this.aZw, avVar.aZw) ? a((ay) avVar) : false;
    }

    public final int hashCode() {
        return ((bc.hashCode(this.aZw) + 527) * 31) + qg();
    }

    protected final int pw() {
        int pw = super.pw();
        if (this.aZw != null && this.aZw.length > 0) {
            for (be beVar : this.aZw) {
                if (beVar != null) {
                    pw += ax.b(1, beVar);
                }
            }
        }
        return pw;
    }
}
