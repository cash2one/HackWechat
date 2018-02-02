package b.d;

import b.a.a;
import java.util.NoSuchElementException;

public final class b extends a {
    private final int AuW;
    private boolean AuX;
    private int AuY;
    private final int jer;

    public b(int i, int i2, int i3) {
        boolean z = true;
        this.jer = i3;
        this.AuW = i2;
        if (this.jer > 0) {
            if (i > i2) {
                z = false;
            }
        } else if (i < i2) {
            z = false;
        }
        this.AuX = z;
        if (!this.AuX) {
            i = this.AuW;
        }
        this.AuY = i;
    }

    public final boolean hasNext() {
        return this.AuX;
    }

    public final int nextInt() {
        int i = this.AuY;
        if (i != this.AuW) {
            this.AuY += this.jer;
        } else if (this.AuX) {
            this.AuX = false;
        } else {
            throw new NoSuchElementException();
        }
        return i;
    }
}
