package info.congoapp.quizcongo.quizcongo;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Play extends AppCompatActivity {
    ImageButton navigateLeft, navigateRight, play; // Mes buttons
    //TextView topic, topicComments;
    ImageView categoryImage;
    ArrayAdapter<CharSequence> topic,topicDescription, imageArr;
    TextView setQuestion, setTopicDesc;
    int topicIndex= Integer.parseInt(getIntent().getStringExtra("topicIndex")), questionIndex=0;
       ListView listView ;
    int imgfile=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //set questions

        try {
            setChoixMultipleQ(topicIndex);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



        /*categoryImage = (ImageView)findViewById(R.id.playImage);


        setQuestion = (TextView) findViewById(R.id.question);
        Resources res = getResources();
        String[] questionaire = res.getStringArray(R.array.questions);
        String question = questionaire[questionIndex];
        setQuestion.setText(question);
        Resources res2 = getResources();
        String[] responses = res2.getStringArray(R.array.reponses);
        String response = responses[questionIndex];

        String[] choices = response.split("=");

        listView = (ListView) findViewById(R.id.choices);
        ArrayAdapter<String> questionAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, choices);
        listView.setAdapter(questionAdapter);*/




}

    public int[] genRandomArrOfNumbers(){

        int[] quest = new int[4];
        Random randomGenerator = new Random();
        for (int i = 0; i <= 4; ++i){
            int randomInt = randomGenerator.nextInt(10);
            quest[i]=randomInt;
        }
        return quest;
    }
    public void setChoixMultipleQ(int category) throws InterruptedException {
        categoryImage = (ImageView)findViewById(R.id.playImage);
        setQuestion = (TextView) findViewById(R.id.question);
        Resources res = getResources();

        if (category==1) {
            String[] questionaire = res.getStringArray(R.array.questions1);
            int[] questionIndex = genRandomArrOfNumbers();
            for (int i = 0 ; i < questionIndex.length; i++ ){
                String question = questionaire[questionIndex[i]];
                setQuestion.setText(question);
                Resources res2 = getResources();
                String[] responses = res2.getStringArray(R.array.reponses1);
                String response = responses[questionIndex[i]];


                String[] choices = response.split("=");

                listView = (ListView) findViewById(R.id.choices);
                ArrayAdapter<String> questionAdapter = new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1, android.R.id.text1, choices);
                listView.setAdapter(questionAdapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view,
                                            int position, long id) {

                        // ListView Clicked item index
                        int itemPosition = position;

                        // ListView Clicked item value
                        String itemValue = (String) listView.getItemAtPosition(position);

                        // Show Alert
                        Toast.makeText(getApplicationContext(),
                                "Position :" + itemPosition + "  ListItem : " + itemValue, Toast.LENGTH_LONG)
                                .show();

                    }

                });

                setTopicImg(topicIndex);
                Thread.sleep(5000);
            }

        }
    }

    public void setTopicImg(int arrIndex){

        if(arrIndex==0){
            imgfile = R.drawable.sportimage;
            categoryImage.setImageResource(imgfile);
        }else if (arrIndex==1){
            imgfile = R.drawable.mosolee;
            categoryImage.setImageResource(imgfile);
        }else if (arrIndex==2){
            imgfile = R.drawable.histoire;
            categoryImage.setImageResource(imgfile);
        }else if (arrIndex==3){
            imgfile = R.drawable.news;
            categoryImage.setImageResource(imgfile);
        }else if (arrIndex==4){
            imgfile = R.drawable.musique;
            categoryImage.setImageResource(imgfile);
        }else if (arrIndex==5){
            imgfile = R.drawable.geo;
            categoryImage.setImageResource(imgfile);
        }
        else if (arrIndex==6){
            imgfile = R.drawable.pomba;
            categoryImage.setImageResource(imgfile);
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_accueil, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
