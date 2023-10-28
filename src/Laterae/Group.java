package Laterae;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private int id;
    private String name;
    private int number;
    private List<Child> children;

    public Group(int id, String name, int number) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.children = new ArrayList<>();
    }
    // Add a child to the group
    public void addChild(Child child) {
        children.add(child);
    }
    // Remove a child from the group
    public void removeChild(Child child) {
        children.remove(child);
    }
    // Getters and setters
}
