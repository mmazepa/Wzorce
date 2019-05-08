import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

class SpeakerSetBase {
  private String speakerSetType;
  private Map<String, String> parts = new HashMap<String, String>();

  public SpeakerSetBase() {

  }

  public void setSpeakerSetType(String speakerSetType) {
    this.speakerSetType = speakerSetType;
  }
  public String getSpeakerSetType() {
    return speakerSetType;
  }

  public void setPart(String partKey, String partValue) {
    parts.put(partKey, partValue);
  }

  public void displayAllParts() {
    Iterator it = parts.entrySet().iterator();
    while (it.hasNext()) {
        Map.Entry pair = (Map.Entry)it.next();
        System.out.println("         " + pair.getKey() + ": " + pair.getValue());
    }
  }

  public void show() {
    System.out.println("      Typ zestawu: " + speakerSetType);
    displayAllParts();
  }
}
