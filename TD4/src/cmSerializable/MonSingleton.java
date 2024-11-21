package cmSerializable;


import java.io.Serializable;

public final class MonSingleton implements Serializable {

  private static final long   serialVersionUID = -1572447373762477721L;

  private static MonSingleton instance         = new MonSingleton();

  public static MonSingleton getlnstance() {
    return MonSingleton.instance;
  }

  private MonSingleton() {
  }
}