package sv.edu.ejemplomvp;

public class MainActivityPresenter implements MainActivityContract.Presenter {

    MainActivityContract.View view;

    public MainActivityPresenter(MainActivityContract.View view) {
        this.view = view;
    }

    @Override
    public void doLogin(String email, String password) {
        if (email.equals("usuario@gmail.com") && password.equals("123456")){
            view.onSuccess("Login hecho con exito");
        }else {
            view.onError("La contraseña o el correo son incorrectos");
        }
    }

}
