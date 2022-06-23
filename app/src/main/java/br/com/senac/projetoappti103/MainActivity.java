package br.com.senac.projetoappti103;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // DECLARAR AS VARIÁVEIS GLOBAIS REFERENCIANDO OS COMPONENTES
    ListView lstFilmes;

    // CRIANDO OS DADOS PARA A LISTA
    String titulo[] = {"Contractor","Wrath of Man","Moonfall","Shrek 2", "Joker",
            "Bad Boys","Hitman's","John Wick","The Good Father","Fast & Furious 5"};

    String ano[] = {"2022","2021","2022","2004","2019","2020","2021","2014","1972","2011"};

    String classificacao[] = {"18 anos ou mais","18 anos ou mais","13 anos ou mais",
            "7 anos ou mais","18 anos ou mais","18 anos ou mais","16 anos ou mais",
            "18 anos ou mais","13 anos ou mais","13 anos ou mais"};

    int imgFilmes[] = {R.drawable.contractor,R.drawable.wrathofman,
            R.drawable.moonfall,R.drawable.shrek,R.drawable.joker,
            R.drawable.badboys,R.drawable.hitman,R.drawable.jonh,
            R.drawable.goodfather,R.drawable.fast};

    String notas[] = {"12","846","420","1.527","18.834","97","71","10.899","1.144","1.966"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstFilmes = findViewById(R.id.listaFilmes);

        // INSTANCIAR O ADAPTADOR
        MyAdapter adapter = new MyAdapter();

        lstFilmes.setAdapter(adapter);

        lstFilmes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //ABRINDO OUTRA JANELA E PASSANDO OS VALORES
                Intent intent = new Intent(getApplicationContext(),MostrarActivity.class);

                intent.putExtra("titulo",titulo[position]);
                intent.putExtra("ano",ano[position]);
                intent.putExtra("classificacao",classificacao[position]);
                intent.putExtra("notas",notas[position]);
                intent.putExtra("imagemFilme",imgFilmes[position]);

                startActivity(intent);
            }
        });

    }

    // CRIANDO UMA CLASSE INTERNA (INNER CLASS)
    public class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return imgFilmes.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //  CRIANDO AS VARIÁVEIS GLOBAIS PARA OS COMPONENTES
            ImageView imageFilmes;
            TextView txtTitulo,txtAno,txtClassificacao,txtNotas;

            // INSTÂNCIANDO E CARREGANDO O MODELO AO ADAPTADOR
            View view = getLayoutInflater().inflate(R.layout.modelo_filmes,null);

            // DECLARANDO O XML PARA O JAVA
            txtTitulo = view.findViewById(R.id.txtModeloTitulo);
            txtAno = view.findViewById(R.id.txtModeloAno);
            txtClassificacao = view.findViewById(R.id.txtModeloClassificacao);
            txtNotas = view.findViewById(R.id.txtModeloNotas);
            imageFilmes = view.findViewById(R.id.imgModeloFilme);

            // PASSANDO OS VALORES PARA OS COMPONENTES DO MODELO
            txtTitulo.setText(titulo[position]);
            txtAno.setText(ano[position]);
            txtClassificacao.setText(classificacao[position]);
            txtNotas.setText(notas[position]);
            imageFilmes.setImageResource(imgFilmes[position]);

            return view;
        }
    }
}