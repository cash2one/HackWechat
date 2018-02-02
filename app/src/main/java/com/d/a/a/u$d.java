package com.d.a.a;

import android.os.SystemClock;

class u$d {
    private float blO;
    private float blP;
    private float blQ;
    private float blR;
    private float blS;
    private float blT;
    private float blU;
    private float blV;
    private float blW;
    private int count;

    private u$d() {
        this.count = 0;
        this.blO = 0.0f;
        this.blP = 0.0f;
        this.blQ = 0.0f;
        this.blR = 0.0f;
        this.blS = 0.0f;
        this.blT = 0.0f;
        this.blU = 0.0f;
        this.blV = 0.0f;
        this.blW = 0.0f;
    }

    final synchronized void reset() {
        this.count = 0;
        this.blO = 0.0f;
        this.blP = 0.0f;
        this.blQ = 0.0f;
        this.blR = 0.0f;
        this.blS = 0.0f;
        this.blT = 0.0f;
        this.blU = 0.0f;
        this.blV = 0.0f;
        this.blW = 0.0f;
    }

    final synchronized void a(float[] fArr, float[] fArr2, float[] fArr3) {
        if (fArr.length >= 3) {
            this.count++;
            this.blO += fArr[0];
            this.blP += fArr[1];
            this.blQ += fArr[2];
            this.blR += fArr2[0];
            this.blS += fArr2[1];
            this.blT += fArr2[2];
            this.blU += fArr3[0];
            this.blV += fArr3[1];
            this.blW += fArr3[2];
        }
    }

    final synchronized u$b a(float[][] fArr) {
        u$b com_d_a_a_u_b;
        synchronized (this) {
            if (this.count <= 0 || fArr.length < 3) {
                com_d_a_a_u_b = null;
            } else {
                com_d_a_a_u_b = new u$b();
                com_d_a_a_u_b.time = SystemClock.elapsedRealtime();
                for (int i = 0; i <= 5; i++) {
                    com_d_a_a_u_b.blI[i] = fArr[i][0];
                    com_d_a_a_u_b.blJ[i] = fArr[i][1];
                    com_d_a_a_u_b.blK[i] = fArr[i][2];
                    com_d_a_a_u_b.blL[i] = (float) Math.sin((double) com_d_a_a_u_b.blI[i]);
                    com_d_a_a_u_b.blM[i] = (float) Math.cos((double) com_d_a_a_u_b.blI[i]);
                }
                com_d_a_a_u_b.blx = this.blO / ((float) this.count);
                com_d_a_a_u_b.bly = this.blP / ((float) this.count);
                com_d_a_a_u_b.blz = this.blQ / ((float) this.count);
                com_d_a_a_u_b.blA = this.blR / ((float) this.count);
                com_d_a_a_u_b.blB = this.blS / ((float) this.count);
                com_d_a_a_u_b.blC = this.blT / ((float) this.count);
                com_d_a_a_u_b.blD = this.blU / ((float) this.count);
                com_d_a_a_u_b.blE = this.blV / ((float) this.count);
                com_d_a_a_u_b.blF = this.blW / ((float) this.count);
                com_d_a_a_u_b.blH = (float) Math.sqrt((double) ((com_d_a_a_u_b.blx * com_d_a_a_u_b.blx) + (com_d_a_a_u_b.bly * com_d_a_a_u_b.bly)));
                reset();
            }
        }
        return com_d_a_a_u_b;
    }
}
