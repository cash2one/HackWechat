package com.google.android.gms.c;

public abstract class ay<M extends ay<M>> extends be {
    protected ba aZZ;

    private M qh() {
        ay ayVar = (ay) super.qi();
        bc.a(this, ayVar);
        return ayVar;
    }

    public void a(ax axVar) {
        if (this.aZZ != null) {
            for (int i = 0; i < this.aZZ.size(); i++) {
                this.aZZ.dH(i).a(axVar);
            }
        }
    }

    protected final boolean a(aw awVar, int i) {
        int position = awVar.getPosition();
        if (!awVar.dv(i)) {
            return false;
        }
        byte[] bArr;
        bb bbVar;
        int dK = bh.dK(i);
        int position2 = awVar.getPosition() - position;
        if (position2 == 0) {
            bArr = bh.bat;
        } else {
            bArr = new byte[position2];
            System.arraycopy(awVar.buffer, position + awVar.aZP, bArr, 0, position2);
        }
        bg bgVar = new bg(i, bArr);
        if (this.aZZ == null) {
            this.aZZ = new ba();
            bbVar = null;
        } else {
            ba baVar = this.aZZ;
            position2 = baVar.dI(dK);
            bbVar = (position2 < 0 || baVar.baf[position2] == ba.bac) ? null : baVar.baf[position2];
        }
        if (bbVar == null) {
            bb bbVar2 = new bb();
            ba baVar2 = this.aZZ;
            int dI = baVar2.dI(dK);
            if (dI >= 0) {
                baVar2.baf[dI] = bbVar2;
                bbVar = bbVar2;
            } else {
                dI ^= -1;
                if (dI >= baVar2.hX || baVar2.baf[dI] != ba.bac) {
                    if (baVar2.bad && baVar2.hX >= baVar2.bae.length) {
                        baVar2.gc();
                        dI = baVar2.dI(dK) ^ -1;
                    }
                    if (baVar2.hX >= baVar2.bae.length) {
                        int Y = ba.Y(baVar2.hX + 1);
                        Object obj = new int[Y];
                        Object obj2 = new bb[Y];
                        System.arraycopy(baVar2.bae, 0, obj, 0, baVar2.bae.length);
                        System.arraycopy(baVar2.baf, 0, obj2, 0, baVar2.baf.length);
                        baVar2.bae = obj;
                        baVar2.baf = obj2;
                    }
                    if (baVar2.hX - dI != 0) {
                        System.arraycopy(baVar2.bae, dI, baVar2.bae, dI + 1, baVar2.hX - dI);
                        System.arraycopy(baVar2.baf, dI, baVar2.baf, dI + 1, baVar2.hX - dI);
                    }
                    baVar2.bae[dI] = dK;
                    baVar2.baf[dI] = bbVar2;
                    baVar2.hX++;
                    bbVar = bbVar2;
                } else {
                    baVar2.bae[dI] = dK;
                    baVar2.baf[dI] = bbVar2;
                    bbVar = bbVar2;
                }
            }
        }
        bbVar.bai.add(bgVar);
        return true;
    }

    protected final boolean a(M m) {
        return (this.aZZ == null || this.aZZ.isEmpty()) ? m.aZZ == null || m.aZZ.isEmpty() : this.aZZ.equals(m.aZZ);
    }

    public /* synthetic */ Object clone() {
        return qh();
    }

    protected int pw() {
        int i = 0;
        if (this.aZZ == null) {
            return 0;
        }
        int i2 = 0;
        while (i < this.aZZ.size()) {
            i2 += this.aZZ.dH(i).pw();
            i++;
        }
        return i2;
    }

    protected final int qg() {
        return (this.aZZ == null || this.aZZ.isEmpty()) ? 0 : this.aZZ.hashCode();
    }

    public final /* synthetic */ be qi() {
        return qh();
    }
}
