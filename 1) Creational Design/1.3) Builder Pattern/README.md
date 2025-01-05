### Builder Pattern

The Builder Pattern is a creational design pattern that allows for the <u>step-by-step construction of complex objects</u>. It separates the construction of a complex object from its representation so that the same construction process can create different representations.

### Real-Life Example

**Scenario: Building a User Profile**

In a web application, when creating a user profile, you might want to set various optional fields such as address, phone number, profile picture, etc. Instead of having a complex constructor with many parameters, the Builder Pattern allows for the step-by-step construction of a user profile.

### Java Implementation with Lombok

##### Step 1: Define the Product class with Lombok annotations

```java
// UserProfile.java
import lombok.Getter;
import lombok.Setter;

@Getter
public class UserProfile {
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String profilePictureUrl;

    // Private constructor to enforce object creation through the builder
    private UserProfile(Builder builder) {
        this.username = builder.username;
        this.email = builder.email;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.address = builder.address;
        this.phoneNumber = builder.phoneNumber;
        this.profilePictureUrl = builder.profilePictureUrl;
    }

    // Static nested Builder class
    @Setter
    public static class Builder {
        private String username;
        private String email;
        private String firstName;
        private String lastName;
        private String address;
        private String phoneNumber;
        private String profilePictureUrl;

        // Build method to create the final product
        public UserProfile build() {
            return new UserProfile(this);
        }
    }
}
```

##### Step 2: Use the Builder to construct the object

```java
// UserProfileBuilderDemo.java
public class UserProfileBuilderDemo {
    public static void main(String[] args) {
        // Using the Builder to create a user profile
        UserProfile userProfile = new UserProfile.Builder()
                .setUsername("johndoe")
                .setEmail("johndoe@example.com")
                .setFirstName("John")
                .setLastName("Doe")
                .setAddress("123 Main St, Anytown, USA")
                .setPhoneNumber("123-456-7890")
                .setProfilePictureUrl("http://example.com/profile/johndoe.jpg")
                .build();

        System.out.println("User Profile created with username: " + userProfile.getUsername());
        System.out.println("User Profile created with email: " + userProfile.getEmail());
        System.out.println("User Profile created with first name: " + userProfile.getFirstName());
        System.out.println("User Profile created with last name: " + userProfile.getLastName());
        System.out.println("User Profile created with address: " + userProfile.getAddress());
        System.out.println("User Profile created with phone number: " + userProfile.getPhoneNumber());
        System.out.println("User Profile created with profile picture URL: " + userProfile.getProfilePictureUrl());
    }
}
```

### Explanation

In the above example:
1. **UserProfile Class**: This is the product class.
   - Lombok's `@Getter` annotation generates the getter methods for all fields.
   - The constructor is private, and objects are created through the nested Builder class.
2. **UserProfile.Builder Class**: This static nested class is the builder.
   - Lombok's `@Setter` annotation generates the setter methods for all fields.
   - Each setter method returns the builder object itself (`this`), allowing for method chaining.
   - The `build` method constructs the final `UserProfile` object using the builder's values.
3. **UserProfileBuilderDemo Class**: This is the client code that demonstrates the use of the Builder pattern.
   - It uses the `UserProfile.Builder` to create a `UserProfile` object step-by-step, specifying only the desired parts.
   - The `build` method finalizes the creation of the `UserProfile` object.

### Benefits
- **Reduced Boilerplate Code**: Lombok annotations significantly reduce the amount of boilerplate code for getters and setters.
- **Flexible and Readable Code**: The Builder pattern provides a clear and readable way to construct complex objects, especially when there are many parameters.
- **Immutable Objects**: The pattern often results in immutable objects since the fields are set only once during object construction.
- **Method Chaining**: The builder methods support method chaining, making the client code more concise and readable.
- **Separation of Concerns**: It separates the construction process from the final representation, making the code easier to maintain and extend.

### Real-World Usage
- **User Profile Management**: Constructing user profiles with various optional attributes.
- **Configuration Objects**: Constructing configuration objects with many optional parameters.
- **DTOs**: Constructing Data Transfer Objects for transferring data across different layers of an application.
- **API Clients**: Building API client objects with configurable parameters for making HTTP requests.