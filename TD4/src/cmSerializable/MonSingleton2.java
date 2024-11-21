package cmSerializable;


import java.io.ObjectStreamException;
import java.io.Serializable;

public final class MonSingleton2 implements Serializable {

  private static final long   serialVersionUID = -1572447373762477721L;

  private static MonSingleton2 instance         = new MonSingleton2();

  public static MonSingleton2 getlnstance() {
    return MonSingleton2.instance;
  }

  private MonSingleton2() {
  }

  protected Object readResolve() throws ObjectStreamException {
    return MonSingleton2.getlnstance();
  }
}