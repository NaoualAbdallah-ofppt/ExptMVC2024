package aa.bb.exptmvc.view;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import aa.bb.exptmvc.R;
import aa.bb.exptmvc.model.Animal;

public class MainActivity extends AppCompatActivity {
    EditText editNum;
    TextView txtNom,txtPrix;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNom=findViewById(R.id.txtNom);
        txtPrix=findViewById(R.id.txtPrix);
        editNum=findViewById(R.id.editNum);
        btn=findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //affichage du nom de l'animal
                int num=Integer.parseInt(editNum.getText().toString());
                String nom=getAnimalByNum(num).getNom();
                Double prix=getAnimalByNum(num).getPrix();
                txtNom.setText(nom);
                txtPrix.setText(String.valueOf(prix));

            }
        });
    }
    public Animal getAnimalByNum(int num)
    {
        for (Animal a: Animal.getAnimals()){
            if (a.getNum()==num)
                return a;
        }
        return null;
    }
}