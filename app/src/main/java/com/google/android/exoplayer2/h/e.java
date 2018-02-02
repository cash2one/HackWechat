package com.google.android.exoplayer2.h;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public final class e implements f {
    private final t<? super e> aAB;
    private InputStream aAC;
    private long aAD;
    private final ContentResolver aAE;
    private AssetFileDescriptor aAF;
    private boolean opened;
    private Uri uri;

    public e(Context context, t<? super e> tVar) {
        this.aAE = context.getContentResolver();
        this.aAB = tVar;
    }

    public final long a(i iVar) {
        try {
            this.uri = iVar.uri;
            this.aAF = this.aAE.openAssetFileDescriptor(this.uri, "r");
            if (this.aAF == null) {
                throw new FileNotFoundException("Could not open file descriptor for: " + this.uri);
            }
            this.aAC = new FileInputStream(this.aAF.getFileDescriptor());
            long startOffset = this.aAF.getStartOffset();
            startOffset = this.aAC.skip(iVar.position + startOffset) - startOffset;
            if (startOffset != iVar.position) {
                throw new EOFException();
            }
            if (iVar.aAL != -1) {
                this.aAD = iVar.aAL;
            } else {
                long length = this.aAF.getLength();
                if (length == -1) {
                    this.aAD = (long) this.aAC.available();
                    if (this.aAD == 0) {
                        this.aAD = -1;
                    }
                } else {
                    this.aAD = length - startOffset;
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
            try {
                if (this.aAF != null) {
                    this.aAF.close();
                }
                this.aAF = null;
                if (this.opened) {
                    this.opened = false;
                    if (this.aAB != null) {
                        this.aAB.lt();
                    }
                }
            } catch (IOException e) {
                throw new a(e);
            } catch (Throwable th) {
                this.aAF = null;
                if (this.opened) {
                    this.opened = false;
                    if (this.aAB != null) {
                        this.aAB.lt();
                    }
                }
            }
        } catch (IOException e2) {
            throw new a(e2);
        } catch (Throwable th2) {
            this.aAC = null;
            try {
                if (this.aAF != null) {
                    this.aAF.close();
                }
                this.aAF = null;
                if (this.opened) {
                    this.opened = false;
                    if (this.aAB != null) {
                        this.aAB.lt();
                    }
                }
            } catch (IOException e22) {
                throw new a(e22);
            } catch (Throwable th3) {
                this.aAF = null;
                if (this.opened) {
                    this.opened = false;
                    if (this.aAB != null) {
                        this.aAB.lt();
                    }
                }
            }
        }
    }
}
