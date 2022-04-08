package sv.edu.ejemplomvp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View {

    Button btnInicio;
    EditText Email,Contraseña;

    MainActivityContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInicio= findViewById(R.id.Iniciartbn);
        Email= findViewById(R.id.Emailetx);
        Contraseña=findViewById(R.id.contraseña);

        presenter=new MainActivityPresenter(this);
        //Funcion Boton Login

        btnInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Inputs
                String email1=Email.getText().toString();
                String contraseña1=Contraseña.getText().toString();

                if (TextUtils.isEmpty(email1) || TextUtils.isEmpty(contraseña1)){
                    onError("Campos requeridos");
                }else {
                    presenter.doLogin(email1,contraseña1);
                }
            }
        });
    }


    @Override
    public void onSuccess(String message) {
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}