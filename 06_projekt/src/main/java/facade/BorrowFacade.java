class BorrowFacade {
  private Library library;
  private Borrowable borrowable;

  public BorrowFacade() {
    library = Library.getInstance();
    // System.out.println(library);
  }

  public String borrowItem(Book book, String borrower) {
    borrowable = new Borrowable(book);
    // if (book.isFromThisLibrary(library)) {
    //   if (book.isAvailable(library)) {
        borrowable.borrowItem(borrower);
        return "Książka wypożyczona!";
    //   } else {
    //     return "Książka niedostępna do wypożyczenia!";
    //   }
    // } else {
    //   return "Książka nie należy do zasobów tej biblioteki!";
    // }
  }

  public String returnItem(Book book, String borrower) {
    borrowable = new Borrowable(book);
    // if (book.isFromThisLibrary(library)) {
      borrowable.returnItem(borrower);
      return "Książka oddana!";
    // } else {
    //   return "Książka nie należy do zasobów tej biblioteki!";
    // }
  }
}
