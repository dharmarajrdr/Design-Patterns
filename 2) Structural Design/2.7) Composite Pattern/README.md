# Composite Pattern

It lets clients treat individual objects and groups of objects uniformly.
Eg: File and Folder structure in an OS.

### Without Composite Pattern

```java
@Getter
@AllArgsConstructor
class File {
    private String name;
    private int size;
}

@AllArgsConstructor
class Folder {

    private String name;
    private List<Object> files;

    public int getSize() {
        int size = 0;
        for (Object file : files) {
            if (file instanceof File) {
                size += ((File) file).getSize();
            } else if (file instanceof Folder) {
                size += ((Folder) file).getSize();
            }
            // What if we add another type like Shortcut? Too many instanceof checks!
        }
        return size;
    }
}
```

#### Problems:
1. Violates Open-Closed Principle. Every time we add a new type, we need to modify the `getSize` method.
2. Client code needs to know about all the types (File, Folder, etc.) and handle them accordingly.

### With Composite Pattern

```java
interface FileSystemComponent {
    int getSize();
}

@Getter
@AllArgsConstructor
class File implements FileSystemComponent {
    
    private String name;
    private int size;   
}

@AllArgsConstructor
class Folder implements FileSystemComponent {

    private String name;
    private List<FileSystemComponent> components;

    @Override
    public int getSize() {
        int size = 0;
        for (FileSystemComponent component : components) {
            size += component.getSize();
        }
        return size;
    }
}
```

#### Benefits:
1. New types can be added without modifying existing code, adhering to the Open-Closed Principle.
2. Client code can treat all components uniformly through the `FileSystemComponent` interface.