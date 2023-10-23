package CACoding.src.interface_adapter.clear_users;

import CACoding.src.use_case.clear_users.ClearInputData;
import CACoding.src.use_case.clear_users.ClearInputBoundary;

public class ClearController {

    static ClearInputBoundary clearUseCaseInteractor = null;

    public ClearController(ClearInputBoundary clearUseCaseInteractor) {
        ClearController.clearUseCaseInteractor = clearUseCaseInteractor;
    }

    public static void execute(){
        ClearInputData clearInputData = new ClearInputData();

        clearUseCaseInteractor.execute(clearInputData);
    }


}
