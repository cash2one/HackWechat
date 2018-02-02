package com.google.android.gms.analytics.internal;

import android.content.Context;
import com.google.android.gms.common.internal.w;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public final class y extends o {
    private Future<String> aGZ;
    private volatile String aGm;

    protected y(q qVar) {
        super(qVar);
    }

    private boolean e(Context context, String str) {
        w.aM(str);
        w.aO("ClientId should be saved from worker thread");
        FileOutputStream fileOutputStream = null;
        try {
            c("Storing clientId", str);
            fileOutputStream = context.openFileOutput("gaClientId", 0);
            fileOutputStream.write(str.getBytes());
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    f("Failed to close clientId writing stream", e);
                }
            }
            return true;
        } catch (FileNotFoundException e2) {
            f("Error creating clientId file", e2);
            if (fileOutputStream == null) {
                return false;
            }
            try {
                fileOutputStream.close();
                return false;
            } catch (IOException e3) {
                f("Failed to close clientId writing stream", e3);
                return false;
            }
        } catch (IOException e32) {
            f("Error writing to clientId file", e32);
            if (fileOutputStream == null) {
                return false;
            }
            try {
                fileOutputStream.close();
                return false;
            } catch (IOException e322) {
                f("Failed to close clientId writing stream", e322);
                return false;
            }
        } catch (Throwable th) {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e3222) {
                    f("Failed to close clientId writing stream", e3222);
                }
            }
        }
    }

    String B(Context context) {
        FileInputStream openFileInput;
        FileInputStream fileInputStream;
        Object e;
        Throwable th;
        w.aO("ClientId should be loaded from worker thread");
        try {
            openFileInput = context.openFileInput("gaClientId");
            try {
                byte[] bArr = new byte[36];
                int read = openFileInput.read(bArr, 0, 36);
                if (openFileInput.available() > 0) {
                    ax("clientId file seems corrupted, deleting it.");
                    openFileInput.close();
                    context.deleteFile("gaClientId");
                    if (openFileInput == null) {
                        return null;
                    }
                    try {
                        openFileInput.close();
                        return null;
                    } catch (IOException e2) {
                        f("Failed to close client id reading stream", e2);
                        return null;
                    }
                } else if (read < 14) {
                    ax("clientId file is empty, deleting it.");
                    openFileInput.close();
                    context.deleteFile("gaClientId");
                    if (openFileInput == null) {
                        return null;
                    }
                    try {
                        openFileInput.close();
                        return null;
                    } catch (IOException e22) {
                        f("Failed to close client id reading stream", e22);
                        return null;
                    }
                } else {
                    openFileInput.close();
                    String str = new String(bArr, 0, read);
                    c("Read client id from disk", str);
                    if (openFileInput != null) {
                        try {
                            openFileInput.close();
                        } catch (IOException e3) {
                            f("Failed to close client id reading stream", e3);
                        }
                    }
                    return str;
                }
            } catch (FileNotFoundException e4) {
                fileInputStream = openFileInput;
                if (fileInputStream != null) {
                    return null;
                }
                try {
                    fileInputStream.close();
                    return null;
                } catch (IOException e222) {
                    f("Failed to close client id reading stream", e222);
                    return null;
                }
            } catch (IOException e5) {
                e = e5;
                try {
                    f("Error reading client id file, deleting it", e);
                    context.deleteFile("gaClientId");
                    if (openFileInput != null) {
                        return null;
                    }
                    try {
                        openFileInput.close();
                        return null;
                    } catch (IOException e2222) {
                        f("Failed to close client id reading stream", e2222);
                        return null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (openFileInput != null) {
                        try {
                            openFileInput.close();
                        } catch (IOException e22222) {
                            f("Failed to close client id reading stream", e22222);
                        }
                    }
                    throw th;
                }
            }
        } catch (FileNotFoundException e6) {
            fileInputStream = null;
            if (fileInputStream != null) {
                return null;
            }
            fileInputStream.close();
            return null;
        } catch (IOException e7) {
            e = e7;
            openFileInput = null;
            f("Error reading client id file, deleting it", e);
            context.deleteFile("gaClientId");
            if (openFileInput != null) {
                return null;
            }
            openFileInput.close();
            return null;
        } catch (Throwable th3) {
            openFileInput = null;
            th = th3;
            if (openFileInput != null) {
                openFileInput.close();
            }
            throw th;
        }
    }

    protected final void mf() {
    }

    public final String nq() {
        String str;
        mQ();
        synchronized (this) {
            if (this.aGm == null) {
                this.aGZ = this.aFo.mT().a(new 1(this));
            }
            if (this.aGZ != null) {
                try {
                    this.aGm = (String) this.aGZ.get();
                } catch (InterruptedException e) {
                    e("ClientId loading or generation was interrupted", e);
                    this.aGm = "0";
                } catch (ExecutionException e2) {
                    f("Failed to load or generate client id", e2);
                    this.aGm = "0";
                }
                if (this.aGm == null) {
                    this.aGm = "0";
                }
                c("Loaded clientId", this.aGm);
                this.aGZ = null;
            }
            str = this.aGm;
        }
        return str;
    }

    final String nr() {
        synchronized (this) {
            this.aGm = null;
            this.aGZ = this.aFo.mT().a(new 2(this));
        }
        return nq();
    }

    final String ns() {
        String toLowerCase = UUID.randomUUID().toString().toLowerCase();
        try {
            return !e(this.aFo.mT().mContext, toLowerCase) ? "0" : toLowerCase;
        } catch (Exception e) {
            f("Error saving clientId file", e);
            return "0";
        }
    }
}
