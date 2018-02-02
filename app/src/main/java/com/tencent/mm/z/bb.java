package com.tencent.mm.z;

import com.tencent.mm.aj.a;
import com.tencent.mm.g.b.af;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.xwalk.core.R$styleable;

public final class bb {
    private static final Queue<Integer> hgU = new ConcurrentLinkedQueue();
    private static final long[] hgV = new long[]{0, 2000, 5000, 10000, 30000, 60000, 180000, 300000, 600000, 1800000, 3600000};
    private static final int[] hgW = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private static final int[] hgX = new int[]{30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40};

    public static void a(String str, long j, long j2, int i) {
        if (str != null) {
            try {
                String FS = q.FS();
                if (FS == null || !FS.equals(str)) {
                    af WO = ((h) g.h(h.class)).EY().WO(str);
                    if (str.endsWith("@chatroom")) {
                        if (WO.fWn != 0) {
                            x.i("MicroMsg.MsgReporter", "[oneliang]it is a normal chatroom? username:%s", new Object[]{str});
                        } else {
                            return;
                        }
                    } else if (!s.hk(str) && !com.tencent.mm.storage.x.Wx(str) && !com.tencent.mm.storage.x.Wz(str) && !s.hg(str) && !com.tencent.mm.storage.x.gy(str)) {
                        if (WO.cia()) {
                            return;
                        }
                    } else {
                        return;
                    }
                    long Ie = bu.Ie();
                    if (Ie <= 0) {
                        x.i("MicroMsg.MsgReporter", "[oneliang]current server time is 0l,then return");
                        return;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    long j3 = Ie - j2;
                    x.i("MicroMsg.MsgReporter", "[oneliang]current server time:%s, msg server time:%s, intervalTime:%s, username:%s, msg server id:%s,msg type:%s", new Object[]{Long.valueOf(Ie), Long.valueOf(j2), Long.valueOf(j3), str, Long.valueOf(j), Integer.valueOf(i)});
                    boolean bb = a.bb(j2);
                    if (bb) {
                        d.pPH.a(780, 100, 1, false);
                    } else {
                        d.pPH.a(780, 101, 1, false);
                    }
                    for (int length = hgV.length - 1; length >= 0; length--) {
                        if (j3 >= hgV[length]) {
                            if (bb) {
                                d.pPH.a(780, (long) hgW[length], 1, false);
                            } else {
                                d.pPH.a(780, (long) hgX[length], 1, false);
                            }
                            if (j3 >= 2000) {
                                a.a(Ie, currentTimeMillis, j2, j3, j);
                            }
                            switch (i) {
                                case 1:
                                    if (j3 < 60000) {
                                        if (bb) {
                                            d.pPH.a(780, 118, 1, false);
                                            return;
                                        } else {
                                            d.pPH.a(780, 113, 1, false);
                                            return;
                                        }
                                    } else if (j3 < 30000) {
                                        if (bb) {
                                            d.pPH.a(780, 117, 1, false);
                                            return;
                                        } else {
                                            d.pPH.a(780, 112, 1, false);
                                            return;
                                        }
                                    } else if (j3 < 10000) {
                                        if (bb) {
                                            d.pPH.a(780, 116, 1, false);
                                            return;
                                        } else {
                                            d.pPH.a(780, 111, 1, false);
                                            return;
                                        }
                                    } else if (j3 < 0) {
                                        return;
                                    } else {
                                        if (bb) {
                                            d.pPH.a(780, 115, 1, false);
                                            return;
                                        } else {
                                            d.pPH.a(780, 110, 1, false);
                                            return;
                                        }
                                    }
                                case 3:
                                    if (j3 < 60000) {
                                        if (bb) {
                                            d.pPH.a(780, 138, 1, false);
                                            return;
                                        } else {
                                            d.pPH.a(780, 133, 1, false);
                                            return;
                                        }
                                    } else if (j3 < 30000) {
                                        if (bb) {
                                            d.pPH.a(780, 137, 1, false);
                                            return;
                                        } else {
                                            d.pPH.a(780, 132, 1, false);
                                            return;
                                        }
                                    } else if (j3 < 10000) {
                                        if (bb) {
                                            d.pPH.a(780, 136, 1, false);
                                            return;
                                        } else {
                                            d.pPH.a(780, 131, 1, false);
                                            return;
                                        }
                                    } else if (j3 < 0) {
                                        return;
                                    } else {
                                        if (bb) {
                                            d.pPH.a(780, 135, 1, false);
                                            return;
                                        } else {
                                            d.pPH.a(780, 130, 1, false);
                                            return;
                                        }
                                    }
                                case 34:
                                    if (j3 < 60000) {
                                        if (bb) {
                                            d.pPH.a(780, 128, 1, false);
                                            return;
                                        } else {
                                            d.pPH.a(780, 123, 1, false);
                                            return;
                                        }
                                    } else if (j3 < 30000) {
                                        if (bb) {
                                            d.pPH.a(780, 127, 1, false);
                                            return;
                                        } else {
                                            d.pPH.a(780, 122, 1, false);
                                            return;
                                        }
                                    } else if (j3 < 10000) {
                                        if (bb) {
                                            d.pPH.a(780, 126, 1, false);
                                            return;
                                        } else {
                                            d.pPH.a(780, 121, 1, false);
                                            return;
                                        }
                                    } else if (j3 < 0) {
                                        return;
                                    } else {
                                        if (bb) {
                                            d.pPH.a(780, 125, 1, false);
                                            return;
                                        } else {
                                            d.pPH.a(780, 120, 1, false);
                                            return;
                                        }
                                    }
                                case R$styleable.AppCompatTheme_dialogPreferredPadding /*43*/:
                                    if (j3 < 60000) {
                                        if (bb) {
                                            d.pPH.a(780, 158, 1, false);
                                            return;
                                        } else {
                                            d.pPH.a(780, 153, 1, false);
                                            return;
                                        }
                                    } else if (j3 < 30000) {
                                        if (bb) {
                                            d.pPH.a(780, 157, 1, false);
                                            return;
                                        } else {
                                            d.pPH.a(780, 152, 1, false);
                                            return;
                                        }
                                    } else if (j3 < 10000) {
                                        if (bb) {
                                            d.pPH.a(780, 156, 1, false);
                                            return;
                                        } else {
                                            d.pPH.a(780, 151, 1, false);
                                            return;
                                        }
                                    } else if (j3 < 0) {
                                        return;
                                    } else {
                                        if (bb) {
                                            d.pPH.a(780, 155, 1, false);
                                            return;
                                        } else {
                                            d.pPH.a(780, 150, 1, false);
                                            return;
                                        }
                                    }
                                case 47:
                                    if (j3 < 60000) {
                                        if (bb) {
                                            d.pPH.a(780, 148, 1, false);
                                            return;
                                        } else {
                                            d.pPH.a(780, 143, 1, false);
                                            return;
                                        }
                                    } else if (j3 < 30000) {
                                        if (bb) {
                                            d.pPH.a(780, 147, 1, false);
                                            return;
                                        } else {
                                            d.pPH.a(780, 142, 1, false);
                                            return;
                                        }
                                    } else if (j3 < 10000) {
                                        if (bb) {
                                            d.pPH.a(780, 146, 1, false);
                                            return;
                                        } else {
                                            d.pPH.a(780, 141, 1, false);
                                            return;
                                        }
                                    } else if (j3 < 0) {
                                        return;
                                    } else {
                                        if (bb) {
                                            d.pPH.a(780, 145, 1, false);
                                            return;
                                        } else {
                                            d.pPH.a(780, 140, 1, false);
                                            return;
                                        }
                                    }
                                default:
                                    return;
                            }
                        }
                    }
                    switch (i) {
                        case 1:
                            if (j3 < 60000) {
                                if (j3 < 30000) {
                                    if (j3 < 10000) {
                                        if (j3 < 0) {
                                            if (bb) {
                                                d.pPH.a(780, 115, 1, false);
                                                return;
                                            } else {
                                                d.pPH.a(780, 110, 1, false);
                                                return;
                                            }
                                        }
                                        return;
                                    } else if (bb) {
                                        d.pPH.a(780, 116, 1, false);
                                        return;
                                    } else {
                                        d.pPH.a(780, 111, 1, false);
                                        return;
                                    }
                                } else if (bb) {
                                    d.pPH.a(780, 117, 1, false);
                                    return;
                                } else {
                                    d.pPH.a(780, 112, 1, false);
                                    return;
                                }
                            } else if (bb) {
                                d.pPH.a(780, 118, 1, false);
                                return;
                            } else {
                                d.pPH.a(780, 113, 1, false);
                                return;
                            }
                        case 3:
                            if (j3 < 60000) {
                                if (j3 < 30000) {
                                    if (j3 < 10000) {
                                        if (j3 < 0) {
                                            if (bb) {
                                                d.pPH.a(780, 135, 1, false);
                                                return;
                                            } else {
                                                d.pPH.a(780, 130, 1, false);
                                                return;
                                            }
                                        }
                                        return;
                                    } else if (bb) {
                                        d.pPH.a(780, 136, 1, false);
                                        return;
                                    } else {
                                        d.pPH.a(780, 131, 1, false);
                                        return;
                                    }
                                } else if (bb) {
                                    d.pPH.a(780, 137, 1, false);
                                    return;
                                } else {
                                    d.pPH.a(780, 132, 1, false);
                                    return;
                                }
                            } else if (bb) {
                                d.pPH.a(780, 138, 1, false);
                                return;
                            } else {
                                d.pPH.a(780, 133, 1, false);
                                return;
                            }
                        case 34:
                            if (j3 < 60000) {
                                if (j3 < 30000) {
                                    if (j3 < 10000) {
                                        if (j3 < 0) {
                                            if (bb) {
                                                d.pPH.a(780, 125, 1, false);
                                                return;
                                            } else {
                                                d.pPH.a(780, 120, 1, false);
                                                return;
                                            }
                                        }
                                        return;
                                    } else if (bb) {
                                        d.pPH.a(780, 126, 1, false);
                                        return;
                                    } else {
                                        d.pPH.a(780, 121, 1, false);
                                        return;
                                    }
                                } else if (bb) {
                                    d.pPH.a(780, 127, 1, false);
                                    return;
                                } else {
                                    d.pPH.a(780, 122, 1, false);
                                    return;
                                }
                            } else if (bb) {
                                d.pPH.a(780, 128, 1, false);
                                return;
                            } else {
                                d.pPH.a(780, 123, 1, false);
                                return;
                            }
                        case R$styleable.AppCompatTheme_dialogPreferredPadding /*43*/:
                            if (j3 < 60000) {
                                if (j3 < 30000) {
                                    if (j3 < 10000) {
                                        if (j3 < 0) {
                                            if (bb) {
                                                d.pPH.a(780, 155, 1, false);
                                                return;
                                            } else {
                                                d.pPH.a(780, 150, 1, false);
                                                return;
                                            }
                                        }
                                        return;
                                    } else if (bb) {
                                        d.pPH.a(780, 156, 1, false);
                                        return;
                                    } else {
                                        d.pPH.a(780, 151, 1, false);
                                        return;
                                    }
                                } else if (bb) {
                                    d.pPH.a(780, 157, 1, false);
                                    return;
                                } else {
                                    d.pPH.a(780, 152, 1, false);
                                    return;
                                }
                            } else if (bb) {
                                d.pPH.a(780, 158, 1, false);
                                return;
                            } else {
                                d.pPH.a(780, 153, 1, false);
                                return;
                            }
                        case 47:
                            if (j3 < 60000) {
                                if (j3 < 30000) {
                                    if (j3 < 10000) {
                                        if (j3 < 0) {
                                            if (bb) {
                                                d.pPH.a(780, 145, 1, false);
                                                return;
                                            } else {
                                                d.pPH.a(780, 140, 1, false);
                                                return;
                                            }
                                        }
                                        return;
                                    } else if (bb) {
                                        d.pPH.a(780, 146, 1, false);
                                        return;
                                    } else {
                                        d.pPH.a(780, 141, 1, false);
                                        return;
                                    }
                                } else if (bb) {
                                    d.pPH.a(780, 147, 1, false);
                                    return;
                                } else {
                                    d.pPH.a(780, 142, 1, false);
                                    return;
                                }
                            } else if (bb) {
                                d.pPH.a(780, 148, 1, false);
                                return;
                            } else {
                                d.pPH.a(780, 143, 1, false);
                                return;
                            }
                        default:
                            return;
                    }
                }
            } catch (Exception e) {
                x.e("MicroMsg.MsgReporter", "[oneliang]something about contact has exception:%s", new Object[]{e.getMessage()});
            }
        }
    }
}
