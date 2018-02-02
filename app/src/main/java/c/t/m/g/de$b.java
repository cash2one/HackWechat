package c.t.m.g;

public enum de$b {
    Normal,
    Daemon,
    Single,
    Stop;

    static {
        Normal = new de$b("Normal", 0);
        Daemon = new de$b("Daemon", 1);
        Single = new de$b("Single", 2);
        Stop = new de$b("Stop", 3);
        de$b[] c_t_m_g_de_bArr = new de$b[]{Normal, Daemon, Single, Stop};
    }
}
