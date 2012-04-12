package pjn.androidbluetooth.main;

import android.app.Activity;
import android.app.AlertDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Android_BluetoothActivity extends Activity {

	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
    	// Default
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button myButton = (Button) findViewById(R.id.button_main);
        myButton.setText("Deploy!");
    	//myButton.setOnClickListener(this); // not necessary it's wired in the xml

        /*
         * Programmaticly create views
		super.onCreate(savedInstanceState);
		TextView tv = new TextView(this);
		tv.setText("Frag Out!");
    	setContentView(tv);
    	*/
        
        // Register Broadcast Receiver
        // Register the BroadcastReceiver
        IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
        registerReceiver(mReceiver, filter); // Don't forget to unregister during onDestroy


    }

    // Create a BroadcastReceiver for ACTION_FOUND
    private final BroadcastReceiver mReceiver = new BroadcastReceiver(){
    
	    public void onReceive(Context context, Intent intent) {
	        String action = intent.getAction();
	        // When discovery finds a device
	        if (BluetoothDevice.ACTION_FOUND.equals(action)) {
	            // Get the BluetoothDevice object from the Intent
	            BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);

	            TextView textviewMain = (TextView) findViewById(R.id.textviewMain);
		    	textviewMain.setText(device.getName());
		    	
	            // Add the name and address to an array adapter to show in a ListView
	            //mArrayAdapter.add(device.getName() + "\n" + device.getAddress());
	        }
	    }
    };

    public void button_main_onClick(View v)
    {
    	
    	
//    	EditText edittextMain = (EditText) findViewById(R.id.editText_main);
//    	
//        Button myButton = (Button) findViewById(R.id.button_main);
//        myButton.setText(edittextMain.getText());

    	BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    	if (mBluetoothAdapter != null) 
    	{
    		// Device does support Bluetooth
    		AlertDialog.Builder builder = new AlertDialog.Builder(this);
    		builder.setMessage("Device supports bluetooth! 20111101")
    		       .setCancelable(false)
    		       .setNegativeButton("OK", new DialogInterface.OnClickListener() {
    		           public void onClick(DialogInterface dialog, int id) {
    		                dialog.cancel();
    		           }
    		       });
    		AlertDialog alert = builder.create();
    		alert.show();
    	}
    	else
    	{
    		// Device does support Bluetooth
    		AlertDialog.Builder builder = new AlertDialog.Builder(this);
    		builder
    				//.setMessage("Device does not support Bluetooth!")
    		       .setCancelable(false)
    		       .setNegativeButton("OK", new DialogInterface.OnClickListener() {
    		           public void onClick(DialogInterface dialog, int id) {
    		                dialog.cancel();
    		           }
    		       });
    		AlertDialog alert = builder.create();
    		alert.show();
    	}
    	
    }
    
    public void button_bluetooth_onClick(View v)
    {
    	try
    	{
        	BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        	mBluetoothAdapter.setName("Bryan Panjavan\nSenior Developer\nMCPD.NET");
        	Intent discoverableIntent = new
        			Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
	    	discoverableIntent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 300);
	    	startActivity(discoverableIntent);
	    	
	    	TextView textviewMain = (TextView) findViewById(R.id.textviewMain);
	    	textviewMain.setText("Broadcasting...");
    	}
    	catch(Exception ex)
    	{
    		AlertDialog.Builder builder = new AlertDialog.Builder(this);
    		builder.setMessage(ex.getMessage())
    		       .setCancelable(false)
    		       .setNegativeButton("OK", new DialogInterface.OnClickListener() {
    		           public void onClick(DialogInterface dialog, int id) {
    		                dialog.cancel();
    		           }
    		       });
    		AlertDialog alert = builder.create();
    		alert.show();
    	}
    	
    	
    }    

    
    //private BluetoothServerSocket mmServerSocket;
    public void button_listen_onClick(View v)
    {
    	TextView textviewMain = (TextView) findViewById(R.id.textviewMain);
    	textviewMain.setText("Listening...");

    	try
    	{
        	BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        	mBluetoothAdapter.startDiscovery();
    	
    	}
    	catch(Exception ex)
    	{
    		AlertDialog.Builder builder = new AlertDialog.Builder(this);
    		builder.setMessage(ex.getMessage())
    		       .setCancelable(false)
    		       .setNegativeButton("OK", new DialogInterface.OnClickListener() {
    		           public void onClick(DialogInterface dialog, int id) {
    		                dialog.cancel();
    		           }
    		       });
    		AlertDialog alert = builder.create();
    		alert.show();
    	}
    	
    	
    	
    	
    /*
    	TextView textviewMain = (TextView) findViewById(R.id.textviewMain);
    	textviewMain.setText("Listening...");
    	
    	try
    	{
    		 // Use a temporary object that is later assigned to mmServerSocket,
            // because mmServerSocket is final
            BluetoothServerSocket tmp = null;
            try {
            	BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
               // MY_UUID is the app's UUID string, also used by the client code
            	String myName = "Libra";
            	UUID myUUID = new UUID(0, 1);
            	
                tmp = mBluetoothAdapter.listenUsingRfcommWithServiceRecord(myName, myUUID);
            } catch (IOException ex) {
        		AlertDialog.Builder builder = new AlertDialog.Builder(this);
        		builder.setMessage(ex.getMessage())
        		       .setCancelable(false)
        		       .setNegativeButton("OK", new DialogInterface.OnClickListener() {
        		           public void onClick(DialogInterface dialog, int id) {
        		                dialog.cancel();
        		           }
        		       });
        		AlertDialog alert = builder.create();
        		alert.show();
            }

            mmServerSocket = tmp;
        	
        	BluetoothSocket socket = null;
            // Keep listening until exception occurs or a socket is returned
            while (true) {
                try {
                    socket = mmServerSocket.accept();
                } catch (IOException ex) {
            		AlertDialog.Builder builder = new AlertDialog.Builder(this);
            		builder.setMessage(ex.getMessage())
            		       .setCancelable(false)
            		       .setNegativeButton("OK", new DialogInterface.OnClickListener() {
            		           public void onClick(DialogInterface dialog, int id) {
            		                dialog.cancel();
            		           }
            		       });
            		AlertDialog alert = builder.create();
            		alert.show();
                    break;
                }
                
                // If a connection was accepted
                if (socket != null) {
                    // Do work to manage the connection (in a separate thread)
                    //manageConnectedSocket(socket);
                	
            		AlertDialog.Builder builder = new AlertDialog.Builder(this);
            		builder.setMessage("Accepted!")
            		       .setCancelable(false)
            		       .setNegativeButton("OK", new DialogInterface.OnClickListener() {
            		           public void onClick(DialogInterface dialog, int id) {
            		                dialog.cancel();
            		           }
            		       });
            		AlertDialog alert = builder.create();
            		alert.show();
                	
                	
                    mmServerSocket.close();
                    break;
                }
            }
    	}
    	catch(Exception ex)
    	{
    		AlertDialog.Builder builder = new AlertDialog.Builder(this);
    		builder.setMessage(ex.getMessage())
    		       .setCancelable(false)
    		       .setNegativeButton("OK", new DialogInterface.OnClickListener() {
    		           public void onClick(DialogInterface dialog, int id) {
    		                dialog.cancel();
    		           }
    		       });
    		AlertDialog alert = builder.create();
    		alert.show();
    	}
    	
    	*/
    }    

    
    // Create an anonymous implementation of OnClickListener
    /*
	private OnClickListener button1Listener = new OnClickListener() {
        public void onClick(View v) {

        	TextView textviewMain = (TextView) findViewById(R.id.textviewMain);
        	textviewMain.setText("Deploy!");
        	
        }
    };
	*/

	
	/** Called when the activity is first created. */
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//       
//    	super.onCreate(savedInstanceState);
//        setContentView(R.layout.main);
//
//        int i = 0;
//        i = i + 1;
//    }


	
}