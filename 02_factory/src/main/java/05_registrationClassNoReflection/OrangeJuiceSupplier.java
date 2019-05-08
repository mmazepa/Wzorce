import java.util.function.Supplier;

public class OrangeJuiceSupplier implements Supplier<Juice> {

    @Override
    public OrangeJuice get() {
        return new OrangeJuice();
    }
}
