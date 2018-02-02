package g.a.c;

import com.tencent.smtt.sdk.WebView;
import java.io.InputStream;

public final class b {
    public int AzE;
    public InputStream AzF;
    public int wPs;

    public final int d(short[] sArr, int i) {
        short s = sArr[i];
        int i2 = (this.AzE >>> 11) * s;
        if ((this.wPs ^ Integer.MIN_VALUE) < (Integer.MIN_VALUE ^ i2)) {
            this.AzE = i2;
            sArr[i] = (short) (s + ((2048 - s) >>> 5));
            if ((this.AzE & WebView.NIGHT_MODE_COLOR) == 0) {
                this.wPs = (this.wPs << 8) | this.AzF.read();
                this.AzE <<= 8;
            }
            return 0;
        }
        this.AzE -= i2;
        this.wPs -= i2;
        sArr[i] = (short) (s - (s >>> 5));
        if ((this.AzE & WebView.NIGHT_MODE_COLOR) == 0) {
            this.wPs = (this.wPs << 8) | this.AzF.read();
            this.AzE <<= 8;
        }
        return 1;
    }

    public static void b(short[] sArr) {
        for (int i = 0; i < sArr.length; i++) {
            sArr[i] = (short) 1024;
        }
    }
}
