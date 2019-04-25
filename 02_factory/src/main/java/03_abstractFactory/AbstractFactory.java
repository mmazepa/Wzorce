interface Bottle { void process(); }
interface Sticker { void process(); }

class LagerBottle implements Bottle {
  @Override
  public void process() {
    System.out.println("   Wybieram butelkę od Lagera...");
  }
}

class LagerSticker implements Sticker {
  @Override
  public void process() {
    System.out.println("   Naklejam naklejkę Lagera...");
  }
}

class PorterBottle implements Bottle {
  @Override
  public void process() {
    System.out.println("   Wybieram butelkę od Portera...");
  }
}

class PorterSticker implements Sticker {
  @Override
  public void process() {
    System.out.println("   Naklejam naklejkę Portera...");
  }
}

interface BottleFactory {
  public Bottle createBottle();
  public Sticker createSticker();
}

class LagerFactory implements BottleFactory {
  @Override
  public Bottle createBottle() {
    return new LagerBottle();
  }

  @Override
  public Sticker createSticker() {
    return new LagerSticker();
  }
}

class PorterFactory implements BottleFactory {
  @Override
  public Bottle createBottle() {
    return new PorterBottle();
  }

  @Override
  public Sticker createSticker() {
    return new PorterSticker();
  }
}

class PreparedBottle {
  private String serialNumber;
  private Bottle bottle;
  private Sticker sticker;

  public PreparedBottle(String serialNumber, BottleFactory factory) {
    this.serialNumber = serialNumber;
    bottle = factory.createBottle();
    sticker = factory.createSticker();
    process();
  }

  private void process() {
    System.out.println("Rozpoczynam tworzenie butelki [" + serialNumber + "].");
    bottle.process();
    sticker.process();
    System.out.println("Zakończyłem tworzenie butelki [" + serialNumber + "].");
  }
}
