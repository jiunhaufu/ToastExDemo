package fu.alfie.com.toastexdemo;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButton1Click(View view) {
        Toast.makeText(this,"下",Toast.LENGTH_SHORT).show();
    }

    public void onButton2Click(View view) {
        Toast toast = Toast.makeText(this,"Here",Toast.LENGTH_SHORT);
//        toast.setGravity(Gravity.TOP|Gravity.LEFT,0,0);      //左上
//        toast.setGravity(Gravity.CENTER,0,0);                //置中
//        toast.setGravity(Gravity.BOTTOM|Gravity.RIGHT,0,0);  //右下
        toast.setGravity(Gravity.TOP|Gravity.RIGHT,50,50);     //設定顯示位置
        toast.show();
    }

    public void onButton3Click(View view) {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_view, (ViewGroup) findViewById(R.id.custom_toast_layout));

        TextView textView = (TextView) layout.findViewById(R.id.textView);
        textView.setText("客製化Toast內容");

        Toast toast = Toast.makeText(this,"客製化Toast內容",Toast.LENGTH_SHORT); //設定在預設顯示位置，顯示的內容
        toast.setView(layout); //設定顯示的view
        toast.show(); //使用show()把Toast顯示出來
    }

    public void onButton4Click(View view) {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_view2, (ViewGroup) findViewById(R.id.custom_toast_layout));

        ImageView imageView = (ImageView) layout.findViewById(R.id.imageView);
        imageView.setImageResource(R.mipmap.ic_umbrella);
        TextView textView = (TextView) layout.findViewById(R.id.textView2);
        textView.setText("客製化Toast含圖片內容");

        Toast toast = new Toast(MainActivity.this);
        toast.setDuration(Toast.LENGTH_LONG);  //設定持續時間-長
        toast.setView(layout);
        toast.show();
    }

    public void onButton5Click(View view) {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_view2, (ViewGroup) findViewById(R.id.custom_toast_layout));

        TextView textView = (TextView) layout.findViewById(R.id.textView2);
        textView.setText("客製化Toast含圖片內容");

        GradientDrawable style = new GradientDrawable();
        style.setColor(Color.argb(50,200,0,0));  //設定顯示的顏色
        style.setCornerRadius(50);  //設定圓弧的角度
        style.setShape(GradientDrawable.RECTANGLE);  //設定顯示的形狀
        layout.setBackground(style);  //將上述三種值載入顯示的view背景設定

        Toast toast = new Toast(MainActivity.this);
        toast.setDuration(Toast.LENGTH_SHORT);  //設定持續時間-長
        toast.setView(layout); //設定顯示的view
        toast.show();
    }

}
