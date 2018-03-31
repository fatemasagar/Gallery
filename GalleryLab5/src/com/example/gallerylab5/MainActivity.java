package com.example.gallerylab5;

import android.support.v7.app.ActionBarActivity;
import android.widget.*;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;


@SuppressLint("NewApi") public class MainActivity extends ActionBarActivity implements OnClickListener{

	ImageView a,b,c,d,e,f,g;
	TextView x1,x2;
	int brightnessValue = 0;
	String s1="";
     Bitmap bitmap_Source, bitmap_Dest;
	 int value=0;
	 SeekBar brightnessBar,seekbar_contrast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
		// TODO Auto-generated method stub
		a = (ImageView) findViewById(R.id.pickachu);
		a.setOnClickListener(this);
		b = (ImageView) findViewById(R.id.dexter);
		b.setOnClickListener(this);
		c = (ImageView) findViewById(R.id.princess);
		c.setOnClickListener(this);
		d = (ImageView) findViewById(R.id.simba);
		d.setOnClickListener(this);
		e = (ImageView) findViewById(R.id.dragonballz);
		e.setOnClickListener(this);
		g = (ImageView) findViewById(R.id.tomjerry);
		g.setOnClickListener(this);
		f = (ImageView) findViewById(R.id.set);
		x1 = (TextView)findViewById(R.id.seek1);
		x2 = (TextView)findViewById(R.id.seek2);
		 brightnessBar = (SeekBar)findViewById(R.id.brightnessBar);
		 brightnessBar.setOnSeekBarChangeListener(brightnessBarChangeListener);
		seekbar_contrast = (SeekBar)findViewById(R.id.ConBar);
	}
    private void CreateMenu(Menu menu)
    {
	    MenuItem mnu1 = menu.add(0, 0, 0, "Rotate Right");
	    MenuItem mnu2 = menu.add(0, 1, 1, "Rotate Reverse");
	    MenuItem mnu3 = menu.add(0, 2, 2, "Rotate Left");
	    MenuItem mnu4 = menu.add(0, 3, 3, "Straight up");
	    menu.add(0, 4, 4, "Brightness");
	    menu.add(0, 5, 5, "Contrast");
	    menu.add(0, 6, 6, "Exit");
    }
    private boolean MenuChoice(MenuItem item)
    {
    switch (item.getItemId()) {
	    case 0:
	    Toast.makeText(this, "You clicked on Item 1",Toast.LENGTH_LONG).show();
	    f.setRotation(90);
	    return true;
	    case 1:
	    	Toast.makeText(this, "You clicked on Item 2",Toast.LENGTH_LONG).show();
	    	 f.setRotation(180);
		    return true;
	    case 2:
	    	Toast.makeText(this, "You clicked on Item 3",Toast.LENGTH_LONG).show();
	    	 f.setRotation(270);
		    return true;
	    case 3:
	    	Toast.makeText(this, "You clicked on Item 4",Toast.LENGTH_LONG).show();
	    	 f.setRotation(360);
		    return true;
	    case 4:
	    	x1.setVisibility(View.VISIBLE);
	    	brightnessBar.setVisibility(View.VISIBLE);
	    	x2.setVisibility(View.INVISIBLE);
	    	seekbar_contrast.setVisibility(View.INVISIBLE);
	    	Toast.makeText(this, "You clicked on Item 5",Toast.LENGTH_LONG).show();
	    	 if(s1.equals("dexter")){
	 	    	bitmap_Source = BitmapFactory.decodeResource(getResources(), R.drawable.dexter);
	 	        f.setImageBitmap(processingBitmap_Brightness(bitmap_Source));
	 	    }
	 	    else if(s1.equals("princess")){
	 	    	bitmap_Source = BitmapFactory.decodeResource(getResources(), R.drawable.princess);
	 	        f.setImageBitmap(processingBitmap_Brightness(bitmap_Source));
	 	    }
	 	    else if(s1.equals("simba")){
	 	    	bitmap_Source = BitmapFactory.decodeResource(getResources(), R.drawable.simba);
	 	        f.setImageBitmap(processingBitmap_Brightness(bitmap_Source));
	 	    }
	 	   else if(s1.equals("tomjerry")){
	 	    	bitmap_Source = BitmapFactory.decodeResource(getResources(), R.drawable.tomjerry);
	 	        f.setImageBitmap(processingBitmap_Brightness(bitmap_Source));
	 	    }
	 	  else if(s1.equals("pickachu")){
	 	    	bitmap_Source = BitmapFactory.decodeResource(getResources(), R.drawable.pickachu);
	 	        f.setImageBitmap(processingBitmap_Brightness(bitmap_Source));
	 	    }
	 	 else if(s1.equals("dragonballz")){
	 	    	bitmap_Source = BitmapFactory.decodeResource(getResources(), R.drawable.dragonballz);
	 	        f.setImageBitmap(processingBitmap_Brightness(bitmap_Source));
	 	    }
		    return true;
	    case 5:
	    	x2.setVisibility(View.VISIBLE);
	    	seekbar_contrast.setVisibility(View.VISIBLE);
	    	x1.setVisibility(View.INVISIBLE);
	    	brightnessBar.setVisibility(View.INVISIBLE);
	    	if(s1.equals("pickachu"))
	    	{
		    	seekbar_contrast.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
				
				public void onStopTrackingTouch(SeekBar seekBar) {
				if(value>200){
					f.setImageBitmap(takeContrast(BitmapFactory.decodeResource(getResources(), R.drawable.pickachu),value));
			    }
				else{
					f.setImageBitmap(takeColorContrast(BitmapFactory.decodeResource(getResources(), R.drawable.pickachu),value));
				}
				}

				@Override
				public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
					// TODO Auto-generated method stub
					value = progress-255;
				}
				@Override
				public void onStartTrackingTouch(SeekBar seekBar) {
					// TODO Auto-generated method stub	
				}
			});
		  }
	    	else if(s1.equals("princess"))
	    	{
	    		seekbar_contrast.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
					
					public void onStopTrackingTouch(SeekBar seekBar) {
						// TODO Auto-generated method stub
						 if(value>200)
					        {
					        	f.setImageBitmap(takeContrast(BitmapFactory.decodeResource(getResources(), R.drawable.princess),value));
					        }
					        else
					        {
					        	f.setImageBitmap(takeColorContrast(BitmapFactory.decodeResource(getResources(), R.drawable.princess),value));
					        }
					}
					public void onStartTrackingTouch(SeekBar seekBar) {
						// TODO Auto-generated method stub	
					}
					public void onProgressChanged(SeekBar seekBar, int progress,
							boolean fromUser) {
						// TODO Auto-generated method stub
						value = progress-255;
					}
				});
	    	}
	    	else if(s1.equals("simba"))
	    	{
	    	seekbar_contrast.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
				public void onStopTrackingTouch(SeekBar seekBar) {
					// TODO Auto-generated method stub
					 if(value>200)
				        {
				        	f.setImageBitmap(takeContrast(BitmapFactory.decodeResource(getResources(), R.drawable.simba),value));
				        }
				        else
				        {
				        	f.setImageBitmap(takeColorContrast(BitmapFactory.decodeResource(getResources(), R.drawable.simba),value));
				        }
				}
				public void onStartTrackingTouch(SeekBar seekBar) {
					// TODO Auto-generated method stub
					
				}
				public void onProgressChanged(SeekBar seekBar, int progress,
						boolean fromUser) {
					// TODO Auto-generated method stub
					value = progress-255;
				}
			});
	    	}
	    	else if(s1.equals("dragonballz"))
	    	{
seekbar_contrast.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
					
					public void onStopTrackingTouch(SeekBar seekBar) {
						// TODO Auto-generated method stub
						 if(value>200)
					        {
					        	f.setImageBitmap(takeContrast(BitmapFactory.decodeResource(getResources(), R.drawable.dragonballz),value));
					        }
					        else
					        {
					        	f.setImageBitmap(takeColorContrast(BitmapFactory.decodeResource(getResources(), R.drawable.dragonballz),value));
					        }
					}
					public void onStartTrackingTouch(SeekBar seekBar) {
						// TODO Auto-generated method stub
						
					}
					public void onProgressChanged(SeekBar seekBar, int progress,
							boolean fromUser) {
						// TODO Auto-generated method stub
						value = progress-255;
					}
				});
		    	
	    	}
	    	else if(s1.equals("dexter"))
	    	{
seekbar_contrast.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
					
					public void onStopTrackingTouch(SeekBar seekBar) {
						// TODO Auto-generated method stub
						 if(value>200)
					        {
					        	f.setImageBitmap(takeContrast(BitmapFactory.decodeResource(getResources(), R.drawable.dexter),value));
					        }
					        else
					        {
					        	f.setImageBitmap(takeColorContrast(BitmapFactory.decodeResource(getResources(), R.drawable.dexter),value));
					        }
					}
					
					public void onStartTrackingTouch(SeekBar seekBar) {
						// TODO Auto-generated method stub
					}
					
					public void onProgressChanged(SeekBar seekBar, int progress,
							boolean fromUser) {
						// TODO Auto-generated method stub
						value = progress-255;
					}
				});
		    	
	    	}
	    	else if(s1.equals("tomjerry"))
	    	{
seekbar_contrast.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
					
					public void onStopTrackingTouch(SeekBar seekBar) {
						// TODO Auto-generated method stub
						 if(value>200){
					        	f.setImageBitmap(takeContrast(BitmapFactory.decodeResource(getResources(), R.drawable.tomjerry),value));
					        }
					        else{
					        	f.setImageBitmap(takeColorContrast(BitmapFactory.decodeResource(getResources(), R.drawable.tomjerry),value));
					        }
					}
					public void onStartTrackingTouch(SeekBar seekBar) {
						// TODO Auto-generated method stub
					}
					public void onProgressChanged(SeekBar seekBar, int progress,
							boolean fromUser) {
						// TODO Auto-generated method stub
						value = progress-255;
					}
				});
		    	
	    	}
	    	Toast.makeText(this, "You clicked on Item 6",Toast.LENGTH_LONG).show();
		    return true;
	    case 6:
	    	Toast.makeText(this, "You clicked on Item 7",Toast.LENGTH_LONG).show();
	    	finish();
		    return true;
     }
    	return false;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        CreateMenu(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        /*int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);*/
    	return MenuChoice(item);
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId())
		{
		    case R.id.pickachu :
		    	 f.setImageResource(R.drawable.pickachu);
		    	 s1="pickachu";
		    	 break;
		    	 
		    case R.id.dexter :
		    	 f.setImageResource(R.drawable.dexter);
		    	 s1="dexter";
		    	 break;
		    	 
		    case R.id.tomjerry :
		    	f.setImageResource(R.drawable.tomjerry);
		    	s1="tomjerry";
		    	 break;
		    	 
		    case R.id.princess :
		    	f.setImageResource(R.drawable.princess);
		    	s1="princess";
		    	 break;
		    	 
		    case R.id.dragonballz :
		    	f.setImageResource(R.drawable.dragonballz);
		    	s1="dragonballz";
		    	 break;
		    	 
		    case R.id.simba :
		    	f.setImageResource(R.drawable.simba);
		    	s1="simba";
		    	 break;
		    	 
		}
	}
	
	OnSeekBarChangeListener brightnessBarChangeListener = new OnSeekBarChangeListener(){

		  @Override
		  public void onProgressChanged(SeekBar seekBar, int progress,
		    boolean fromUser) {
		   brightnessValue = progress - 255;
		   f.setImageBitmap(processingBitmap_Brightness(bitmap_Source)); 
		  }
		  @Override
		  public void onStartTrackingTouch(SeekBar seekBar) {
		   // TODO Auto-generated method stub
		   
		  }
		  @Override
		  public void onStopTrackingTouch(SeekBar seekBar) {
		   // TODO Auto-generated method stub
			  //f.setImageBitmap(processingBitmap_Brightness(bitmap_Source));
		  }     
	 };

	 private Bitmap processingBitmap_Brightness(Bitmap src){
	      Bitmap dest = Bitmap.createBitmap(
	        src.getWidth(), src.getHeight(), src.getConfig());
	          
	      for(int x = 0; x < src.getWidth(); x++){
	       for(int y = 0; y < src.getHeight(); y++){
	        int pixelColor = src.getPixel(x, y);
	        int pixelAlpha = Color.alpha(pixelColor);
	        
	        int pixelRed = Color.red(pixelColor) + brightnessValue;
	        int pixelGreen = Color.green(pixelColor) + brightnessValue;
	        int pixelBlue = Color.blue(pixelColor) + brightnessValue;
	        
	        if(pixelRed > 255){
	         pixelRed = 255;
	        }else if(pixelRed < 0){
	         pixelRed = 0;
	        }
	        
	        if(pixelGreen > 255){
	         pixelGreen = 255;
	        }else if(pixelGreen < 0){
	         pixelGreen = 0;
	        }
	        
	        if(pixelBlue > 255){
	         pixelBlue = 255;
	        }else if(pixelBlue < 0){
	         pixelBlue = 0;
	        }

	        int newPixel = Color.argb(
	          pixelAlpha, pixelRed, pixelGreen, pixelBlue);
	        
	        dest.setPixel(x, y, newPixel);
	        
	       } 
	      }
	      return dest; 
	}
public  Bitmap takeContrast(Bitmap src, double value) {
	     
	     int width = src.getWidth();
	     int height = src.getHeight();
	     Bitmap bmOut = Bitmap.createBitmap(width, height, src.getConfig());
	     
	     int A, R, G, B;
	     int pixel;
	     
	     double contrast = Math.pow((100 + value) / 100, 2);
	     for(int x = 0; x < width; ++x) {
	         for(int y = 0; y < height; ++y) {
	            
	             pixel = src.getPixel(x, y);
	             A = Color.alpha(pixel);
	            
	             R = Color.red(pixel);
	             R = (int)(((((R / 255.0) - 0.5) * contrast) + 0.5) * 255.0);
	             if(R < 0) { R = 0; }
	             else if(R > 255) { R = 255; }
	  
	             G = Color.red(pixel);
	             G = (int)(((((G / 255.0) - 0.5) * contrast) + 0.5) * 255.0);
	             if(G < 0) { G = 0; }
	             else if(G > 255) { G = 255; }
	  
	             B = Color.red(pixel);
	             B = (int)(((((B / 255.0) - 0.5) * contrast) + 0.5) * 255.0);
	             if(B < 0) { B = 0; }
	             else if(B > 255) { B = 255; }
	  
	            
	             bmOut.setPixel(x, y, Color.argb(A, R, G, B));
	         }
	     }
	     return bmOut;
	 }
	
public  Bitmap takeColorContrast(Bitmap src, double value) {
    
    int width = src.getWidth();
    int height = src.getHeight();
    Bitmap bmOut = Bitmap.createBitmap(width, height, src.getConfig());
    
    int A, R, G, B;
    int pixel;
    
    double contrast = Math.pow((100 + value) / 100, 2);
    for(int x = 0; x < width; ++x) {
        for(int y = 0; y < height; ++y) {
            
	            pixel = src.getPixel(x, y);
	            A = Color.alpha(pixel);
	            
	            R = Color.red(pixel);
	            R = (int)(((((R / 255.0) - 0.5) * contrast) + 0.5) * 255.0);
	            if(R < 0) { R = 0; }
	            else if(R > 255) { R = 255; }
	 
	            G = Color.green(pixel);
	            G = (int)(((((G / 255.0) - 0.5) * contrast) + 0.5) * 255.0);
	            if(G < 0) { G = 0; }
	            else if(G > 255) { G = 255; }
	 
	            B = Color.blue(pixel);
	            B = (int)(((((B / 255.0) - 0.5) * contrast) + 0.5) * 255.0);
	            if(B < 0) { B = 0; }
	            else if(B > 255) { B = 255; }
	 
	            
	            bmOut.setPixel(x, y, Color.argb(A, R, G, B));
        	}
    	}
    	return bmOut;
	}
}

	