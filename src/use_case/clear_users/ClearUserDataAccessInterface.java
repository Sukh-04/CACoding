package CACoding.src.use_case.clear_users;

import CACoding.src.entity.User;

public interface ClearUserDataAccessInterface {

    boolean existsByName(String Identifier);

}
