import java.util.ArrayList;

class Borrowable extends Decorator {
  protected ArrayList<String> borrowers = new ArrayList<String>();

  public Borrowable(LibraryItemPrototype libraryItem) {
    super(libraryItem);
  }

  public void borrowItem(String name) {
    borrowers.add(name);
    libraryItem.copies--;
  }

  public void returnItem(String name) {
    borrowers.remove(name);
    libraryItem.copies++;
  }

  @Override
  public String toString() {
    String decoratorString = super.toString() + "\n";
    for (String borrower : borrowers)
      decoratorString += "   Wypożyczone przez: " + borrower + "\n";
    return decoratorString;
  }

  @Override
  public Object ShallowCopy() throws CloneNotSupportedException {
    System.out.println("[SHALLOW COPYING]: " + this.toString());
    return (LibraryItemPrototype) this.clone();
  }

  @Override
  public Object DeepCopy() throws CloneNotSupportedException {
    System.out.println("[DEEP COPYING]: " + this.toString());
    return (LibraryItemPrototype) new Borrowable(this);
  }
}
