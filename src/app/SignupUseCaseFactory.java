package CACoding.src.app;

import CACoding.src.interface_adapter.login.LoginViewModel;
import CACoding.src.interface_adapter.signup.SignupController;
import CACoding.src.interface_adapter.signup.SignupPresenter;
import CACoding.src.interface_adapter.signup.SignupViewModel;
import use_case.signup.SignupUserDataAccessInterface;
import CACoding.src.entity.CommonUserFactory;
import CACoding.src.entity.UserFactory;
import CACoding.src.interface_adapter.*;
import use_case.signup.SignupInputBoundary;
import use_case.signup.SignupInteractor;
import use_case.signup.SignupOutputBoundary;
import CACoding.src.view.SignupView;

import javax.swing.*;
import java.io.IOException;

public class SignupUseCaseFactory {

    /** Prevent instantiation. */
    private SignupUseCaseFactory() {}

    public static SignupView create(
            ViewManagerModel viewManagerModel, LoginViewModel loginViewModel, SignupViewModel signupViewModel, SignupUserDataAccessInterface userDataAccessObject) {

        try {
            SignupController signupController = createUserSignupUseCase(viewManagerModel, signupViewModel, loginViewModel, userDataAccessObject);
            return new SignupView(signupController, signupViewModel);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    private static SignupController createUserSignupUseCase(ViewManagerModel viewManagerModel, SignupViewModel signupViewModel, LoginViewModel loginViewModel, SignupUserDataAccessInterface userDataAccessObject) throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        SignupOutputBoundary signupOutputBoundary = new SignupPresenter(viewManagerModel, signupViewModel, loginViewModel);

        UserFactory userFactory = new CommonUserFactory();

        SignupInputBoundary userSignupInteractor = new SignupInteractor(
                userDataAccessObject, signupOutputBoundary, userFactory);

        return new SignupController(userSignupInteractor);
    }
}
