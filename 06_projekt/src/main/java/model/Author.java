class Author {
  private String firstName;
  private String lastName;

  public Author(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public Author(Author author) {
    this(author.getFirstName(), author.getLastName());
  }

  String getFirstName() {
    return this.firstName;
  }

  void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  String getLastName() {
    return this.lastName;
  }

  void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String toString() {
    return this.firstName + " " + this.lastName;
  }
}
