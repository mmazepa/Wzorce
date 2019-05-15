public class BookFactory {
	public static AbstractBook getBook(BookAbstractFactory factory){
		return factory.createBook();
	}
}
