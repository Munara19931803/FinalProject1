import company.enums.Gender;
import company.model.User;
import company.service.impl.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        User user1 = new User(1, "Ruslan", 27, Gender.FEMALE);

        User user2 = new User(2, "Aidana", 20, Gender.MALE);

        User user3 = new User(3, "Bakyt", 25, Gender.FEMALE);

        UserServiceImpl userService = new UserServiceImpl();

        userService.addUser(user1);

        userService.addUser(user2);

        userService.addUser(user3);

        System.out.println(userService.getById(3));


        try {
            userService.deleteById(2);

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(userService.getAllUsers());

    }
}