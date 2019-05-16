package com.jhonatasrm.exemplo_lista_posts_twitter.Activities.Activities.Activities;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.jhonatasrm.exemplo_lista_posts_twitter.Activities.Activities.Adapter.CommetsAdapter;
import com.jhonatasrm.exemplo_lista_posts_twitter.Activities.Activities.Model.Comments;
import com.jhonatasrm.exemplo_lista_posts_twitter.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView list;
    private ImageButton home, search, notifications, dm, timeLine;

    // método onCreate que chama o layout da activity e o método que inicializa as opções da mesma
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    // método que inicializa as opções da activity
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void init() {
        list = findViewById(R.id.list);
        // atribuído a List o método que retorna a lista criada
        List<Comments> comments = initComments();
        CommetsAdapter commetsAdapter = new CommetsAdapter(comments, this);
        list.setAdapter(commetsAdapter);
        list.setNestedScrollingEnabled(true);

        // inicializa os findViewById
        home = findViewById(R.id.homeButton);
        search = findViewById(R.id.searchButton);
        notifications = findViewById(R.id.notificationsButton);
        dm = findViewById(R.id.dmButton);
        timeLine = findViewById(R.id.timeline);

        // retornar um toast quando clicado na opção de menu Home
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, getString(R.string.local), Toast.LENGTH_LONG).show();
            }
        });
        
        // retornar um toast quando clicado na opção de menu Search
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, getString(R.string.search), Toast.LENGTH_LONG).show();
            }
        });
        
        // retornar um toast quando clicado na opção de menu Notifications
        notifications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, getString(R.string.notifications), Toast.LENGTH_LONG).show();
            }
        });
        
        // retornar um toast quando clicado na opção de menu DM
        dm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, getString(R.string.dm), Toast.LENGTH_LONG).show();
            }
        });

        // retornar um toast quando clicado na opção da toolbar Timeline
        timeLine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, R.string.timeline, Toast.LENGTH_SHORT).show();
            }
        });
    }

    /* inicializa a lista de comentários com: nome, nome de usuário, tempo da publicação, mensagem, número de curtidas
    e retweets */
    public List<Comments> initComments() {
        return new ArrayList<>(Arrays.asList(new Comments(R.drawable.model1, "Ana Clara", "@anac", "1h",
                        "Não vou sair de casa, está chovendo..", 12, 10),
                new Comments(R.drawable.model3, "José Alfredo", "@joseaa", "1h",
                        "...não vou falar nada..", 19, 28),
                new Comments(R.drawable.model2, "Cynthia Alcântara", "@cynthiaa", "2h",
                        "Que chuva boa", 20, 19),
                new Comments(R.drawable.model3, "José Alfredo", "@joseaa", "3h",
                        "Odeio chuva!", 12, 10),
                new Comments(R.drawable.model3, "José Alfredo", "@joseaa", "4h",
                        "Tomara que não chova!", 11, 18),
                new Comments(R.drawable.model1, "Ana Clara", "@anac", "4h",
                        "Tomara que não chova..tenho que sair", 15, 11),
                new Comments(R.drawable.model4, "Sophia Souza", "@sophiab", "4h",
                        "Amo essa chuva!", 10, 10),
                new Comments(R.drawable.model5, "Ana Carla", "@aninhac", "6h",
                        "Que dia lindo! Só falta chover! ", 24, 12),
                new Comments(R.drawable.model6, "Ana Julia", "@anaj", "8h",
                        "Que dia maravilhoso!", 20, 10),
                new Comments(R.drawable.model2, "Cynthia Alcântara", "@cynthiaa", "9h",
                        "Que dia bonito", 12, 21),
                new Comments(R.drawable.model1, "Ana Clara", "@anac", "1d",
                        "Segundas são ótimas!", 50, 12)));
    }
}
