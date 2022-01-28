// Required modules

import android.graphics.*;
import android.graphics.Bitmap.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import android.os.Environment;

// Function 

static void DrawingShapes()
  {
    Bitmap b1=Bitmap.createBitmap(1000,1000,Bitmap.Config.RGB_565);
    Canvas c1=new Canvas(b1);
    Paint p1=new Paint();
    // DRAW IMAGE
    cwl("Drawing background rectangle");
    p1.setColor(Color.rgb(50,50,50));
    c1.drawRect(0,0,b1.getWidth(),b1.getHeight(),p1);
    
    cwl("Drawing sharp degrade");
    p1.setStrokeWidth(5);
    // degrade > bottom right
    p1.setColor(Color.rgb(210,70,0));
    for(int i=0;i<b1.getWidth();i++)
    {
      c1.drawLine(b1.getWidth(),0,i,b1.getHeight(),p1);
    }
    // degrade > top left
    p1.setColor(Color.rgb(255,100,0));
    for(int i=0;i<b1.getWidth();i++)
    {
      c1.drawLine(0,i,i,0,p1);
    }
    
    cwl("Drawing outer rectangle");
    p1.setStrokeWidth(10);
    p1.setColor(Color.WHITE);
    p1.setStyle(Paint.Style.STROKE);
    c1.drawRect(10,10,b1.getWidth()-10,b1.getHeight()-10,p1);
    
    cwl("Drawing WQS title text");
    p1.setTextSize(50);
    p1.setStrokeWidth(0);
    p1.setStyle(Paint.Style.FILL);
    c1.drawText("Weekly Question Solving",b1.getWidth()/2-(50*5),60,p1);
    // SAVE IMAGE
    String path1=Environment.getExternalStorageDirectory().toString()+"/Documents/TestImages/";
    String path2=Environment.getExternalStorageDirectory().toString()+"/Documents/TestImages/test.png";
    try{
      File f1=new File(path1);
      f1.mkdirs();
      File f2=new File(path2);
      //if(f2.exists()){f2.delete();}
      FileOutputStream fos1=new FileOutputStream(f2);
      b1.compress(Bitmap.CompressFormat.JPEG,100,fos1);
      fos1.flush();
      fos1.close();
      cwl("Image Saved !");
    }catch(Exception e){
      cwl(e);
    }
  }
  public static void cw(Object msg)
  {
    System.out.print(msg);
  }
  public static void cwl(Object msg)
  {
    System.out.println(msg);
  }
