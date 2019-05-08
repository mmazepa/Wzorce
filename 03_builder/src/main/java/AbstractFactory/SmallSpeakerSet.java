package factory_package;

public class SmallSpeakerSet extends SpeakerSet {
  private String speakerSetType;
  private String membranes;
  private String amplifier;
  private String speakers;
  private String color;

  public SmallSpeakerSet(String speakerSetType, String membranes, String amplifier, String speakers, String color) {
    this.speakerSetType = speakerSetType;
    this.membranes = membranes;
    this.amplifier = amplifier;
    this.speakers = speakers;
    this.color = color;
  }

  @Override
  public String getSpeakerSetType() {
    return this.speakerSetType;
  }

  @Override
  public String getMembranes() {
    return this.membranes;
  }

  @Override
  public String getAmplifier() {
    return this.amplifier;
  }

  @Override
  public String getSpeakers() {
    return this.speakers;
  }

  @Override
  public String getColor() {
    return this.color;
  }
}
