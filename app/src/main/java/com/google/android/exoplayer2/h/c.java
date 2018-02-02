package com.google.android.exoplayer2.h;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public final class c implements f {
    private final AssetManager aAA;
    private final t<? super c> aAB;
    private InputStream aAC;
    private long aAD;
    private boolean opened;
    private Uri uri;

    public c(Context context, t<? super c> tVar) {
        this.aAA = context.getAssets();
        this.aAB = tVar;
    }

    public final long a(i iVar) {
        try {
            this.uri = iVar.uri;
            String path = this.uri.getPath();
            if (path.startsWith("/android_asset/")) {
                path = path.substring(15);
            } else if (path.startsWith("/")) {
                path = path.substring(1);
            }
            this.aAC = this.aAA.open(path, 1);
            if (this.aAC.skip(iVar.position) < iVar.position) {
                throw new EOFException();
            }
            if (iVar.aAL != -1) {
                this.aAD = iVar.aAL;
            } else {
                this.aAD = (long) this.aAC.available();
                if (this.aAD == 2147483647L) {
                    this.aAD = -1;
                }
            }
            this.opened = true;
            if (this.aAB != null) {
                this.aAB.ls();
            }
            return this.aAD;
        } catch (IOException e) {
            throw new a(e);
        }
    }

    public final int read(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        if (this.aAD == 0) {
            return -1;
        }
        try {
            if (this.aAD != -1) {
                i2 = (int) Math.min(this.aAD, (long) i2);
            }
            int read = this.aAC.read(bArr, i, i2);
            if (read != -1) {
                if (this.aAD != -1) {
                    this.aAD -= (long) read;
                }
                if (this.aAB != null) {
                    this.aAB.cQ(read);
                }
                return read;
            } else if (this.aAD == -1) {
                return -1;
            } else {
                throw new a(new EOFException());
            }
        } catch (IOException e) {
            throw new a(e);
        }
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final void close() {
        this.uri = null;
        try {
            if (this.aAC != null) {
                this.aAC.close();
            }
            this.aAC = null;
            if (this.opened) {
                this.opened = false;
                if (this.aAB != null) {
                    this.aAB.lt();
                }
            }
        } catch (IOException e) {
            throw new a(e);
        } catch (Throwable th) {
            this.aAC = null;
            if (this.opened) {
                this.opened = false;
                if (this.aAB != null) {
                    this.aAB.lt();
                }
            }
        }
    }
}
