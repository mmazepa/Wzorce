abstract class Prototype {
  public abstract Object ShallowCopy() throws CloneNotSupportedException;
  public abstract Object DeepCopy() throws CloneNotSupportedException;
}
