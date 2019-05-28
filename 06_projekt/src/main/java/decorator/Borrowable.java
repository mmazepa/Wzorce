import java.util.ArrayList;

class Borrowable extends Decorator {
  protected ArrayList<Borrower> borrowers = new ArrayList<Borrower>();

  public Borrowable(LibraryItemPrototype libraryItem) {
    super(libraryItem);
  }

  public void borrowItem(Borrower borrower) {
    borrowers.add(borrower);
    libraryItem.copies--;
  }

  public void returnItem(Borrower borrower) {
    borrowers.remove(borrower);
    libraryItem.copies++;
  }

  @Override
  public String toString() {
    String decoratorString = super.toString() + "\n";
    for (Borrower borrower : borrowers)
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
