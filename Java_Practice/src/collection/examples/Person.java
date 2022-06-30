package collection.examples;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Person {
  private String firstName;
  private String lastName;
  private long timeOfBirth;

  @Override public int hashCode() { return Objects.hash(firstName, lastName, timeOfBirth); }

  @Override public boolean equals(Object obj) {
    if (this == obj) { return true; }
    if (!(obj instanceof Person)) { return false; }
    Person other = (Person) obj;
    return Objects.equals(firstName, other.firstName)
        && Objects.equals(lastName, other.lastName)
        && timeOfBirth == other.timeOfBirth;
  }

  public String getFirstName()                 { return firstName;               }
  public void setFirstName(String firstName)   { this.firstName = firstName;     }
  public String getLastName()                  { return lastName;                }
  public void setLastName(String lastName)     { this.lastName = lastName;       }
  public long getTimeOfBirth()                 { return timeOfBirth;             }
  public void setTimeOfBirth(long timeOfBirth) { this.timeOfBirth = timeOfBirth; }

  public static void main(String[] args) {
    Map<Person, Person> map = new HashMap<>();
    long val = 3;
    Person p = person("alice", "bob", val);

    System.out.println("1. " + map.containsKey(p)); // ??? false

    map.put(p, p);
    System.out.println("2. " + map.containsKey(p)); // ??? true

    p.setFirstName("charlie");
    System.out.println("3. " + map.containsKey(p)); // ??? false

    Person p2 = person("alice", "bob", val);
    System.out.println("4. " + map.containsKey(p2)); // ??? false

    Person p3 = person("charlie", "bob", val);
    p.setFirstName("alice");
    System.out.println("5. " + map.containsKey(p)); // ??? false
   
    
  }

  static Person person(String firstName, String lastName, long time) {
    Person p = new Person();

    p.setFirstName(firstName);
    p.setLastName(lastName);
    p.setTimeOfBirth(time);

    return p;
  }
}