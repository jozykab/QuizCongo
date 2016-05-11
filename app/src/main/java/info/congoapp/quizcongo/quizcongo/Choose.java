package info.congoapp.quizcongo.quizcongo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Choose extends AppCompatActivity {
    ImageButton navigateLeft, navigateRight, play; // Mes buttons
    //TextView topic, topicComments;
    ImageView categoryImage;
    ArrayAdapter<CharSequence> topic,topicDescription, imageArr;
    TextView setTopic, setTopicDesc;
    int topicIndex=1;
    int imgfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selection);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //set all default

        setTopic = (TextView) findViewById(R.id.selectionText);
        setTopicDesc = (TextView) findViewById(R.id.subjectText);
        categoryImage = (ImageView)findViewById(R.id.selectionImage);
        topic = ArrayAdapter.createFromResource(this, R.array.topics, android.R.layout.simple_spinner_item);
        topicDescription = ArrayAdapter.createFromResource(this, R.array.topicsDescription, android.R.layout.simple_spinner_item);
        imageArr = ArrayAdapter.createFromResource(this, R.array.imageTopic, android.R.layout.simple_spinner_item);

        setTopicText(topicIndex);
        setTopicDescription(topicIndex);
        setTopicImg(topicIndex);

        navigateLeft = (ImageButton) findViewById(R.id.selectionNavigateLeft);
        navigateLeft.setOnClickListener(new View.OnClickListener() {
            public void onClick(View b) {
                if (topicIndex == 0) {
                    topicIndex = topic.getCount() - 1;
                    setTopicText(topicIndex);
                    setTopicDescription(topicIndex);
                    setTopicImg(topicIndex);
                } else {
                    topicIndex = topicIndex - 1;
                    setTopicText(topicIndex);
                    setTopicDescription(topicIndex);
                    setTopicImg(topicIndex);
                }

            }
        });
        navigateRight = (ImageButton) findViewById(R.id.selectionNavigateRight);
        navigateRight.setOnClickListener(new View.OnClickListener() {
            public void onClick(View b) {
                if (topicIndex==topic.getCount()-1){
                    topicIndex = 0;
                    setTopicText(topicIndex);
                    setTopicDescription(topicIndex);
                    setTopicImg(topicIndex);
                }
                else{
                    topicIndex = topicIndex + 1;
                    setTopicText(topicIndex);
                    setTopicDescription(topicIndex);
                    setTopicImg(topicIndex);
                }

            }
        });

        play = (ImageButton) findViewById(R.id.play);
        play.setOnClickListener(new View.OnClickListener() {
            public void onClick(View b) {

                Intent intent = new Intent(Choose.this, Play.class);
                intent.putExtra("topicIndex", topicIndex);
                        startActivity(intent);

            }
        });
    }

    //Udates the topic's text
    public void setTopicText(int arrIndex){
        setTopic.setText(topic.getItem(arrIndex));
    }

    public void setTopicDescription(int arrIndex){
        setTopicDesc.setText(topicDescription.getItem(arrIndex));
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
