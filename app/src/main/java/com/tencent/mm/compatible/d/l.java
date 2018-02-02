package com.tencent.mm.compatible.d;

import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public final class l {
    private static l gFC = null;
    private String filePath = "";
    private boolean gFB = false;
    private Map<Integer, Object> values;

    public static synchronized l yn() {
        l lVar;
        synchronized (l.class) {
            if (gFC == null) {
                gFC = new l(e.gZK + "CompatibleInfo.cfg");
            }
            lVar = gFC;
        }
        return lVar;
    }

    private l(String str) {
        Throwable e;
        FileInputStream fileInputStream;
        ObjectInputStream objectInputStream = null;
        this.filePath = str;
        FileInputStream fileInputStream2;
        try {
            File file = new File(this.filePath);
            if (!file.exists()) {
                file.createNewFile();
            }
            if (file.length() == 0) {
                this.values = new HashMap();
            } else {
                fileInputStream2 = new FileInputStream(file);
                try {
                    ObjectInputStream objectInputStream2 = new ObjectInputStream(fileInputStream2);
                    try {
                        this.values = (Map) objectInputStream2.readObject();
                        objectInputStream2.close();
                        fileInputStream2.close();
                        try {
                            fileInputStream2.close();
                        } catch (Throwable e2) {
                            x.printErrStackTrace("MicroMsg.CompatibleFileStorage", e2, "", new Object[0]);
                        }
                        try {
                            objectInputStream2.close();
                        } catch (Throwable e22) {
                            x.printErrStackTrace("MicroMsg.CompatibleFileStorage", e22, "", new Object[0]);
                        }
                    } catch (Exception e3) {
                        e22 = e3;
                        objectInputStream = objectInputStream2;
                        fileInputStream = fileInputStream2;
                        try {
                            this.values = new HashMap();
                            x.printErrStackTrace("MicroMsg.CompatibleFileStorage", e22, "", new Object[0]);
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Throwable e222) {
                                    x.printErrStackTrace("MicroMsg.CompatibleFileStorage", e222, "", new Object[0]);
                                }
                            }
                            if (objectInputStream != null) {
                                try {
                                    objectInputStream.close();
                                } catch (Throwable e2222) {
                                    x.printErrStackTrace("MicroMsg.CompatibleFileStorage", e2222, "", new Object[0]);
                                }
                            }
                            this.gFB = false;
                        } catch (Throwable th) {
                            e2222 = th;
                            fileInputStream2 = fileInputStream;
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                } catch (Throwable e4) {
                                    x.printErrStackTrace("MicroMsg.CompatibleFileStorage", e4, "", new Object[0]);
                                }
                            }
                            if (objectInputStream != null) {
                                try {
                                    objectInputStream.close();
                                } catch (Throwable e5) {
                                    x.printErrStackTrace("MicroMsg.CompatibleFileStorage", e5, "", new Object[0]);
                                }
                            }
                            throw e2222;
                        }
                    } catch (Throwable th2) {
                        e2222 = th2;
                        objectInputStream = objectInputStream2;
                        if (fileInputStream2 != null) {
                            fileInputStream2.close();
                        }
                        if (objectInputStream != null) {
                            objectInputStream.close();
                        }
                        throw e2222;
                    }
                } catch (Exception e6) {
                    e2222 = e6;
                    fileInputStream = fileInputStream2;
                    this.values = new HashMap();
                    x.printErrStackTrace("MicroMsg.CompatibleFileStorage", e2222, "", new Object[0]);
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                    this.gFB = false;
                } catch (Throwable th3) {
                    e2222 = th3;
                    if (fileInputStream2 != null) {
                        fileInputStream2.close();
                    }
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                    throw e2222;
                }
            }
        } catch (Exception e7) {
            e2222 = e7;
            fileInputStream = null;
            this.values = new HashMap();
            x.printErrStackTrace("MicroMsg.CompatibleFileStorage", e2222, "", new Object[0]);
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            this.gFB = false;
        } catch (Throwable th4) {
            e2222 = th4;
            fileInputStream2 = null;
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            throw e2222;
        }
        this.gFB = false;
    }

    public final synchronized void set(int i, Object obj) {
        this.values.put(Integer.valueOf(i), obj);
        if (!this.gFB) {
            yo();
        }
    }

    public final Object get(int i) {
        return this.values.get(Integer.valueOf(i));
    }

    public final Object fH(int i) {
        Object obj = this.values.get(Integer.valueOf(i));
        if (obj == null) {
            return null;
        }
        return obj;
    }

    private synchronized void yo() {
        FileOutputStream fileOutputStream;
        ObjectOutputStream objectOutputStream;
        Throwable e;
        FileOutputStream fileOutputStream2 = null;
        synchronized (this) {
            try {
                fileOutputStream = new FileOutputStream(this.filePath);
                try {
                    objectOutputStream = new ObjectOutputStream(fileOutputStream);
                    try {
                        objectOutputStream.writeObject(this.values);
                        objectOutputStream.close();
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        try {
                            fileOutputStream.close();
                        } catch (Throwable e2) {
                            x.printErrStackTrace("MicroMsg.CompatibleFileStorage", e2, "", new Object[0]);
                        }
                        try {
                            objectOutputStream.close();
                        } catch (Throwable e22) {
                            x.printErrStackTrace("MicroMsg.CompatibleFileStorage", e22, "", new Object[0]);
                        }
                    } catch (IOException e3) {
                        e22 = e3;
                        fileOutputStream2 = fileOutputStream;
                        try {
                            x.printErrStackTrace("MicroMsg.CompatibleFileStorage", e22, "", new Object[0]);
                            if (fileOutputStream2 != null) {
                                try {
                                    fileOutputStream2.close();
                                } catch (Throwable e222) {
                                    x.printErrStackTrace("MicroMsg.CompatibleFileStorage", e222, "", new Object[0]);
                                }
                            }
                            if (objectOutputStream != null) {
                                try {
                                    objectOutputStream.close();
                                } catch (Throwable e2222) {
                                    x.printErrStackTrace("MicroMsg.CompatibleFileStorage", e2222, "", new Object[0]);
                                }
                            }
                        } catch (Throwable th) {
                            e2222 = th;
                            fileOutputStream = fileOutputStream2;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (Throwable e4) {
                                    x.printErrStackTrace("MicroMsg.CompatibleFileStorage", e4, "", new Object[0]);
                                }
                            }
                            if (objectOutputStream != null) {
                                try {
                                    objectOutputStream.close();
                                } catch (Throwable e5) {
                                    x.printErrStackTrace("MicroMsg.CompatibleFileStorage", e5, "", new Object[0]);
                                }
                            }
                            throw e2222;
                        }
                    } catch (Throwable th2) {
                        e2222 = th2;
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        if (objectOutputStream != null) {
                            objectOutputStream.close();
                        }
                        throw e2222;
                    }
                } catch (IOException e6) {
                    e2222 = e6;
                    objectOutputStream = null;
                    fileOutputStream2 = fileOutputStream;
                    x.printErrStackTrace("MicroMsg.CompatibleFileStorage", e2222, "", new Object[0]);
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                    if (objectOutputStream != null) {
                        objectOutputStream.close();
                    }
                } catch (Throwable th3) {
                    e2222 = th3;
                    objectOutputStream = null;
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    if (objectOutputStream != null) {
                        objectOutputStream.close();
                    }
                    throw e2222;
                }
            } catch (IOException e7) {
                e2222 = e7;
                objectOutputStream = null;
                x.printErrStackTrace("MicroMsg.CompatibleFileStorage", e2222, "", new Object[0]);
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
            } catch (Throwable th4) {
                e2222 = th4;
                objectOutputStream = null;
                fileOutputStream = null;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
                throw e2222;
            }
        }
    }
}
