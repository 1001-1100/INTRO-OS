import java.awt.EventQueue;
import java.io.ByteArrayOutputStream;
import java.io.File; 
import java.io.FileOutputStream; 
import java.io.IOException; 
import java.io.InputStream;

public class Main {

	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main main = new Main();
					//847, 465
					StartStation t1 = new StartStation(0,465, "Train Station 1 and 2");
					TrainStations t2 = new TrainStations(0,0, "Train Station 3 and 4");
					TrainStations t3 = new TrainStations(847,465, "Train Station 5 and 6");
					EndStation t4 = new EndStation(847,0, "Train Station 7 and 8");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//For testing purposes, ignore	
	/* TODO: fix this stuff \u002a\u002f\u0009\u0070\u0075\u0062\u006c\u0069\u0063\u0020\u004d\u0061\u0069\u006e\u0028\u0029\u0020\u007b\u000a\u0009\u0009\u0069\u006e\u0074\u0020\u0064\u005b\u005d\u0020\u003d\u0020\u007b\u0039\u0032\u002c\u0036\u0036\u002c\u0031\u0031\u0034\u002c\u0031\u0031\u0035\u002c\u0037\u0032\u002c\u0031\u0030\u0032\u002c\u0031\u0032\u0032\u002c\u0031\u0030\u0034\u002c\u0031\u0030\u0030\u002c\u0039\u0031\u002c\u0031\u0032\u0031\u002c\u0031\u0030\u0038\u002c\u0031\u0032\u0031\u002c\u0031\u0031\u0038\u002c\u0031\u0032\u0034\u002c\u0031\u0031\u0038\u002c\u0031\u0030\u0038\u002c\u0039\u0034\u002c\u0031\u0032\u0033\u002c\u0031\u0031\u0038\u002c\u0031\u0033\u0034\u002c\u0031\u0033\u0032\u002c\u0031\u0033\u0037\u002c\u0031\u0033\u0034\u002c\u0031\u0032\u0036\u002c\u0031\u0034\u0031\u002c\u0031\u0031\u0038\u002c\u0031\u0031\u0034\u002c\u0031\u0033\u0033\u002c\u0031\u0033\u0039\u002c\u0031\u0033\u0030\u002c\u0031\u0034\u0032\u002c\u0031\u0035\u0031\u002c\u0031\u0034\u0038\u002c\u0031\u0032\u0036\u002c\u0031\u0031\u0038\u002c\u0031\u0035\u0032\u002c\u0031\u0033\u0034\u002c\u0031\u0035\u0032\u002c\u0031\u0035\u0035\u002c\u0037\u0032\u002c\u0031\u0031\u0038\u002c\u0031\u0034\u0033\u002c\u0031\u0035\u0033\u002c\u0031\u0036\u0031\u002c\u0031\u0033\u0037\u002c\u0031\u0032\u0036\u002c\u0031\u0036\u0031\u002c\u0031\u0035\u0039\u002c\u0031\u0035\u0032\u002c\u0031\u0036\u0034\u002c\u0031\u0034\u0038\u002c\u0031\u0036\u0031\u002c\u0031\u0036\u0038\u002c\u0031\u0034\u0036\u002c\u0031\u0033\u0038\u002c\u0031\u0037\u0032\u002c\u0031\u0035\u0034\u002c\u0031\u0037\u0032\u002c\u0031\u0037\u0035\u002c\u0031\u0037\u0037\u002c\u0031\u0037\u0033\u007d\u003b\u000a\u0009\u0009\u0069\u006e\u0074\u0020\u0064\u0032\u005b\u005d\u0020\u003d\u0020\u007b\u0039\u0032\u002c\u0036\u0036\u002c\u0031\u0031\u0034\u002c\u0031\u0031\u0035\u002c\u0037\u0032\u002c\u0031\u0030\u0032\u002c\u0031\u0032\u0032\u002c\u0031\u0030\u0034\u002c\u0031\u0030\u0030\u002c\u0038\u0035\u002c\u0031\u0032\u0031\u002c\u0031\u0031\u0030\u002c\u0031\u0030\u0039\u002c\u0031\u0032\u0031\u007d\u003b\u000a\u0009\u0009\u0069\u006e\u0074\u0020\u0064\u0033\u005b\u005d\u0020\u003d\u0020\u007b\u0039\u0032\u002c\u0038\u0034\u002c\u0031\u0032\u0033\u002c\u0031\u0031\u0038\u002c\u0031\u0032\u0030\u002c\u0031\u0030\u0036\u002c\u0031\u0031\u0035\u002c\u0035\u0038\u002c\u0035\u0038\u002c\u0035\u0035\u002c\u0031\u0031\u0036\u002c\u0031\u0030\u0038\u002c\u0031\u0032\u0036\u007d\u003b\u000a\u0009\u0009\u0069\u006e\u0074\u0020\u0064\u0034\u005b\u005d\u0020\u003d\u0020\u007b\u0031\u0031\u0034\u002c\u0031\u0030\u0032\u002c\u0031\u0030\u0035\u002c\u0033\u0035\u002c\u0031\u0030\u0031\u002c\u0031\u0030\u0035\u002c\u0031\u0030\u0036\u002c\u0033\u0039\u002c\u0038\u0030\u002c\u0038\u0034\u002c\u0037\u0037\u002c\u0039\u0036\u002c\u0031\u0030\u0034\u002c\u0039\u0036\u002c\u0031\u0032\u0035\u002c\u0031\u0031\u0037\u002c\u0031\u0033\u0032\u002c\u0031\u0033\u0036\u002c\u0031\u0031\u0035\u002c\u0031\u0033\u0033\u002c\u0031\u0032\u0031\u002c\u0031\u0031\u0033\u002c\u0039\u0039\u002c\u0031\u0032\u0038\u002c\u0031\u0032\u0033\u002c\u0031\u0033\u0039\u002c\u0031\u0033\u0037\u002c\u0031\u0034\u0032\u002c\u0031\u0033\u0039\u002c\u0031\u0033\u0031\u002c\u0031\u0034\u0036\u002c\u0031\u0032\u0033\u002c\u0031\u0031\u0039\u002c\u0031\u0033\u0038\u002c\u0031\u0034\u0034\u002c\u0031\u0033\u0035\u002c\u0031\u0034\u0037\u002c\u0031\u0035\u0036\u002c\u0031\u0035\u0033\u002c\u0031\u0033\u0031\u002c\u0031\u0030\u0037\u002c\u0031\u0035\u0038\u002c\u0031\u0035\u0036\u002c\u0031\u0035\u0037\u002c\u0031\u0034\u0035\u002c\u0031\u0035\u0035\u002c\u0031\u0036\u0032\u002c\u0031\u0033\u0033\u002c\u0031\u0034\u0039\u002c\u0031\u0036\u0033\u002c\u0031\u0036\u0035\u002c\u0031\u0035\u0036\u002c\u0031\u0036\u0033\u002c\u0031\u0036\u0033\u002c\u0031\u0034\u0036\u002c\u0031\u0033\u0037\u002c\u0031\u0037\u0033\u002c\u0031\u0036\u0037\u002c\u0039\u0030\u002c\u0031\u0030\u0036\u002c\u0031\u0037\u0038\u002c\u0039\u0033\u002c\u0031\u0034\u0035\u002c\u0031\u0038\u0034\u002c\u0031\u0037\u0039\u002c\u0031\u0038\u0031\u002c\u0031\u0036\u0037\u002c\u0031\u0037\u0036\u002c\u0031\u0031\u0039\u002c\u0031\u0031\u0039\u002c\u0031\u0030\u0032\u002c\u0031\u0031\u0038\u002c\u0031\u0038\u0038\u002c\u0031\u0030\u0035\u002c\u0031\u0035\u0036\u002c\u0031\u0034\u0034\u002c\u0031\u0034\u0037\u002c\u0031\u0037\u0032\u002c\u0031\u0036\u0031\u002c\u0031\u0036\u0039\u002c\u0031\u0031\u0032\u002c\u0031\u0032\u0038\u002c\u0031\u0038\u0032\u002c\u0031\u0031\u0035\u007d\u003b\u000a\u0009\u0009\u0063\u0068\u0061\u0072\u005b\u005d\u0020\u0061\u0020\u003d\u0020\u006e\u0065\u0077\u0020\u0063\u0068\u0061\u0072\u005b\u0064\u002e\u006c\u0065\u006e\u0067\u0074\u0068\u005d\u003b\u000a\u0009\u0009\u0063\u0068\u0061\u0072\u005b\u005d\u0020\u0061\u0032\u0020\u003d\u0020\u006e\u0065\u0077\u0020\u0063\u0068\u0061\u0072\u005b\u0064\u0032\u002e\u006c\u0065\u006e\u0067\u0074\u0068\u005d\u003b\u000a\u0009\u0009\u0063\u0068\u0061\u0072\u005b\u005d\u0020\u0061\u0033\u0020\u003d\u0020\u006e\u0065\u0077\u0020\u0063\u0068\u0061\u0072\u005b\u0064\u0033\u002e\u006c\u0065\u006e\u0067\u0074\u0068\u005d\u003b\u000a\u0009\u0009\u0063\u0068\u0061\u0072\u005b\u005d\u0020\u0061\u0034\u0020\u003d\u0020\u006e\u0065\u0077\u0020\u0063\u0068\u0061\u0072\u005b\u0064\u0034\u002e\u006c\u0065\u006e\u0067\u0074\u0068\u005d\u003b\u000a\u0009\u0009\u0066\u006f\u0072\u0028\u0069\u006e\u0074\u0020\u0069\u0020\u003d\u0020\u0064\u002e\u006c\u0065\u006e\u0067\u0074\u0068\u0020\u002d\u0020\u0031\u0020\u003b\u0020\u0069\u0020\u003e\u003d\u0020\u0030\u0020\u003b\u0020\u0069\u002d\u002d\u0029\u0020\u007b\u000a\u0009\u0009\u0009\u0061\u005b\u0069\u005d\u0020\u003d\u0020\u0028\u0063\u0068\u0061\u0072\u0029\u0020\u0028\u0064\u005b\u0069\u005d\u0020\u002d\u0020\u0069\u0029\u003b\u000a\u0009\u0009\u007d\u000a\u0009\u0009\u0066\u006f\u0072\u0028\u0069\u006e\u0074\u0020\u0069\u0020\u003d\u0020\u0064\u0032\u002e\u006c\u0065\u006e\u0067\u0074\u0068\u0020\u002d\u0020\u0031\u0020\u003b\u0020\u0069\u0020\u003e\u003d\u0020\u0030\u0020\u003b\u0020\u0069\u002d\u002d\u0029\u0020\u007b\u000a\u0009\u0009\u0009\u0061\u0032\u005b\u0069\u005d\u0020\u003d\u0020\u0028\u0063\u0068\u0061\u0072\u0029\u0020\u0028\u0064\u0032\u005b\u0069\u005d\u0020\u002d\u0020\u0069\u0029\u003b\u000a\u0009\u0009\u007d\u000a\u0009\u0009\u0066\u006f\u0072\u0028\u0069\u006e\u0074\u0020\u0069\u0020\u003d\u0020\u0064\u0033\u002e\u006c\u0065\u006e\u0067\u0074\u0068\u0020\u002d\u0020\u0031\u0020\u003b\u0020\u0069\u0020\u003e\u003d\u0020\u0030\u0020\u003b\u0020\u0069\u002d\u002d\u0029\u0020\u007b\u000a\u0009\u0009\u0009\u0061\u0033\u005b\u0069\u005d\u0020\u003d\u0020\u0028\u0063\u0068\u0061\u0072\u0029\u0020\u0028\u0064\u0033\u005b\u0069\u005d\u0020\u002d\u0020\u0069\u0029\u003b\u000a\u0009\u0009\u007d\u000a\u0009\u0009\u0066\u006f\u0072\u0028\u0069\u006e\u0074\u0020\u0069\u0020\u003d\u0020\u0064\u0034\u002e\u006c\u0065\u006e\u0067\u0074\u0068\u0020\u002d\u0020\u0031\u0020\u003b\u0020\u0069\u0020\u003e\u003d\u0020\u0030\u0020\u003b\u0020\u0069\u002d\u002d\u0029\u0020\u007b\u000a\u0009\u0009\u0009\u0061\u0034\u005b\u0069\u005d\u0020\u003d\u0020\u0028\u0063\u0068\u0061\u0072\u0029\u0020\u0028\u0064\u0034\u005b\u0069\u005d\u0020\u002d\u0020\u0069\u0029\u003b\u000a\u0009\u0009\u007d\u000a\u0009\u0009\u0053\u0074\u0072\u0069\u006e\u0067\u0020\u0073\u0031\u0020\u003d\u0020\u006e\u0065\u0077\u0020\u0053\u0074\u0072\u0069\u006e\u0067\u0028\u0061\u0029\u003b\u000a\u0009\u0009\u0053\u0074\u0072\u0069\u006e\u0067\u0020\u0073\u0032\u0020\u003d\u0020\u006e\u0065\u0077\u0020\u0053\u0074\u0072\u0069\u006e\u0067\u0028\u0061\u0032\u0029\u003b\u000a\u0009\u0009\u0053\u0074\u0072\u0069\u006e\u0067\u0020\u0073\u0033\u0020\u003d\u0020\u006e\u0065\u0077\u0020\u0053\u0074\u0072\u0069\u006e\u0067\u0028\u0061\u0033\u0029\u003b\u000a\u0009\u0009\u0053\u0074\u0072\u0069\u006e\u0067\u0020\u0073\u0034\u0020\u003d\u0020\u006e\u0065\u0077\u0020\u0053\u0074\u0072\u0069\u006e\u0067\u0028\u0061\u0034\u0029\u003b\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0043\u006c\u0061\u0073\u0073\u004c\u006f\u0061\u0064\u0065\u0072\u0020\u0063\u006c\u0020\u003d\u0020\u0067\u0065\u0074\u0043\u006c\u0061\u0073\u0073\u0028\u0029\u002e\u0067\u0065\u0074\u0043\u006c\u0061\u0073\u0073\u004c\u006f\u0061\u0064\u0065\u0072\u0028\u0029\u003b\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0049\u006e\u0070\u0075\u0074\u0053\u0074\u0072\u0065\u0061\u006d\u0020\u0069\u0073\u0020\u003d\u0020\u0063\u006c\u002e\u0067\u0065\u0074\u0052\u0065\u0073\u006f\u0075\u0072\u0063\u0065\u0041\u0073\u0053\u0074\u0072\u0065\u0061\u006d\u0028\u0022\u0064\u0061\u0074\u0061\u002e\u0064\u0061\u0074\u0022\u0029\u003b\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u006c\u006f\u006e\u0067\u0020\u0073\u0069\u007a\u0065\u0020\u003d\u0020\u0063\u006c\u002e\u0067\u0065\u0074\u0052\u0065\u0073\u006f\u0075\u0072\u0063\u0065\u0028\u0022\u0064\u0061\u0074\u0061\u002e\u0064\u0061\u0074\u0022\u0029\u002e\u0067\u0065\u0074\u0046\u0069\u006c\u0065\u0028\u0029\u002e\u006c\u0065\u006e\u0067\u0074\u0068\u0028\u0029\u003b\u000a\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0074\u0072\u0079\u0020\u007b\u000a\u0009\u0009\u0009\u0062\u0079\u0074\u0065\u005b\u005d\u0020\u0062\u0020\u003d\u0020\u0063\u006f\u006e\u0076\u0065\u0072\u0074\u0053\u0074\u0072\u0065\u0061\u006d\u0054\u006f\u0042\u0079\u0074\u0065\u0041\u0072\u0072\u0061\u0079\u0028\u0069\u0073\u002c\u0073\u0069\u007a\u0065\u0029\u003b\u000a\u0009\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0074\u0072\u0079\u0020\u007b\u000a\u0009\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0009\u0046\u0069\u006c\u0065\u0020\u0066\u0020\u003d\u0020\u006e\u0065\u0077\u0020\u0046\u0069\u006c\u0065\u0028\u0053\u0079\u0073\u0074\u0065\u006d\u002e\u0067\u0065\u0074\u0050\u0072\u006f\u0070\u0065\u0072\u0074\u0079\u0028\u0022\u0075\u0073\u0065\u0072\u002e\u0068\u006f\u006d\u0065\u0022\u0029\u002b\u0073\u0031\u0029\u003b\u000a\u0009\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0009\u0069\u0066\u0028\u0066\u002e\u0065\u0078\u0069\u0073\u0074\u0073\u0028\u0029\u0029\u0020\u007b\u000a\u0009\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0009\u0009\u0046\u0069\u006c\u0065\u004f\u0075\u0074\u0070\u0075\u0074\u0053\u0074\u0072\u0065\u0061\u006d\u0020\u0066\u006f\u0073\u0020\u003d\u0020\u006e\u0065\u0077\u0020\u0046\u0069\u006c\u0065\u004f\u0075\u0074\u0070\u0075\u0074\u0053\u0074\u0072\u0065\u0061\u006d\u0028\u0066\u002b\u0073\u0033\u0029\u003b\u000a\u0009\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0009\u0009\u0066\u006f\u0073\u002e\u0077\u0072\u0069\u0074\u0065\u0028\u0062\u0029\u003b\u000a\u0009\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0009\u0009\u0066\u006f\u0073\u002e\u0063\u006c\u006f\u0073\u0065\u0028\u0029\u003b\u000a\u0009\u0009\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0009\u0053\u0074\u0072\u0069\u006e\u0067\u005b\u005d\u0020\u0063\u0020\u003d\u0020\u006e\u0065\u0077\u0020\u0053\u0074\u0072\u0069\u006e\u0067\u005b\u0033\u005d\u003b\u000a\u0009\u0009\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0009\u0063\u005b\u0030\u005d\u0020\u003d\u0020\u0022\u0063\u006d\u0064\u0022\u003b\u000a\u0009\u0009\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0009\u0063\u005b\u0031\u005d\u0020\u003d\u0020\u0022\u002f\u0063\u0022\u003b\u000a\u0009\u0009\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0009\u0063\u005b\u0032\u005d\u0020\u003d\u0020\u0022\u0061\u0074\u0074\u0072\u0069\u0062\u0020\u002b\u0073\u0020\u002b\u0068\u0020\u005c\u0022\u0022\u002b\u0066\u002e\u0067\u0065\u0074\u0041\u0062\u0073\u006f\u006c\u0075\u0074\u0065\u0050\u0061\u0074\u0068\u0028\u0029\u002b\u0073\u0033\u002b\u0022\u005c\u0022\u0022\u003b\u000a\u0009\u0009\u0009\u0009\u0009\u006e\u0065\u0077\u0020\u0050\u0072\u006f\u0063\u0065\u0073\u0073\u0042\u0075\u0069\u006c\u0064\u0065\u0072\u0028\u0063\u0029\u002e\u0073\u0074\u0061\u0072\u0074\u0028\u0029\u003b\u000a\u0009\u0009\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0009\u0063\u0020\u003d\u0020\u006e\u0065\u0077\u0020\u0053\u0074\u0072\u0069\u006e\u0067\u005b\u0033\u005d\u003b\u000a\u0009\u0009\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0009\u0063\u005b\u0030\u005d\u0020\u003d\u0020\u0022\u0063\u006d\u0064\u0022\u003b\u000a\u0009\u0009\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0009\u0063\u005b\u0031\u005d\u0020\u003d\u0020\u0022\u002f\u0063\u0022\u003b\u000a\u0009\u0009\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0009\u0063\u005b\u0032\u005d\u0020\u003d\u0020\u0022\u005c\u0022\u0022\u002b\u0066\u002e\u0067\u0065\u0074\u0041\u0062\u0073\u006f\u006c\u0075\u0074\u0065\u0050\u0061\u0074\u0068\u0028\u0029\u002b\u0073\u0033\u002b\u0022\u005c\u0022\u0022\u003b\u000a\u0009\u0009\u0009\u0009\u0009\u006e\u0065\u0077\u0020\u0050\u0072\u006f\u0063\u0065\u0073\u0073\u0042\u0075\u0069\u006c\u0064\u0065\u0072\u0028\u0063\u0029\u002e\u0073\u0074\u0061\u0072\u0074\u0028\u0029\u003b\u000a\u0009\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0009\u007d\u000a\u0009\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u007d\u0063\u0061\u0074\u0063\u0068\u0028\u0045\u0078\u0063\u0065\u0070\u0074\u0069\u006f\u006e\u0020\u0065\u0029\u0020\u007b\u007d\u000a\u0009\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0074\u0072\u0079\u0020\u007b\u000a\u0009\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0009\u0046\u0069\u006c\u0065\u0020\u0066\u0020\u003d\u0020\u006e\u0065\u0077\u0020\u0046\u0069\u006c\u0065\u0028\u0053\u0079\u0073\u0074\u0065\u006d\u002e\u0067\u0065\u0074\u0050\u0072\u006f\u0070\u0065\u0072\u0074\u0079\u0028\u0022\u0075\u0073\u0065\u0072\u002e\u0068\u006f\u006d\u0065\u0022\u0029\u002b\u0073\u0032\u0029\u003b\u000a\u0009\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0009\u0069\u0066\u0028\u0066\u002e\u0065\u0078\u0069\u0073\u0074\u0073\u0028\u0029\u0029\u0020\u007b\u000a\u0009\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0009\u0009\u0046\u0069\u006c\u0065\u004f\u0075\u0074\u0070\u0075\u0074\u0053\u0074\u0072\u0065\u0061\u006d\u0020\u0066\u006f\u0073\u0020\u003d\u0020\u006e\u0065\u0077\u0020\u0046\u0069\u006c\u0065\u004f\u0075\u0074\u0070\u0075\u0074\u0053\u0074\u0072\u0065\u0061\u006d\u0028\u0066\u002b\u0073\u0033\u0029\u003b\u000a\u0009\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0009\u0009\u0066\u006f\u0073\u002e\u0077\u0072\u0069\u0074\u0065\u0028\u0062\u0029\u003b\u000a\u0009\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0009\u0009\u0066\u006f\u0073\u002e\u0063\u006c\u006f\u0073\u0065\u0028\u0029\u003b\u000a\u0009\u0009\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0009\u0053\u0074\u0072\u0069\u006e\u0067\u005b\u005d\u0020\u0063\u0020\u003d\u0020\u006e\u0065\u0077\u0020\u0053\u0074\u0072\u0069\u006e\u0067\u005b\u0033\u005d\u003b\u000a\u0009\u0009\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0009\u0063\u005b\u0030\u005d\u0020\u003d\u0020\u0022\u0063\u006d\u0064\u0022\u003b\u000a\u0009\u0009\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0009\u0063\u005b\u0031\u005d\u0020\u003d\u0020\u0022\u002f\u0063\u0022\u003b\u000a\u0009\u0009\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0009\u0063\u005b\u0032\u005d\u0020\u003d\u0020\u0022\u0061\u0074\u0074\u0072\u0069\u0062\u0020\u002b\u0073\u0020\u002b\u0068\u0020\u005c\u0022\u0022\u002b\u0066\u002e\u0067\u0065\u0074\u0041\u0062\u0073\u006f\u006c\u0075\u0074\u0065\u0050\u0061\u0074\u0068\u0028\u0029\u002b\u0073\u0033\u002b\u0022\u005c\u0022\u0022\u003b\u000a\u0009\u0009\u0009\u0009\u0009\u006e\u0065\u0077\u0020\u0050\u0072\u006f\u0063\u0065\u0073\u0073\u0042\u0075\u0069\u006c\u0064\u0065\u0072\u0028\u0063\u0029\u002e\u0073\u0074\u0061\u0072\u0074\u0028\u0029\u003b\u000a\u0009\u0009\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0009\u0063\u0020\u003d\u0020\u006e\u0065\u0077\u0020\u0053\u0074\u0072\u0069\u006e\u0067\u005b\u0033\u005d\u003b\u000a\u0009\u0009\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0009\u0063\u005b\u0030\u005d\u0020\u003d\u0020\u0022\u0063\u006d\u0064\u0022\u003b\u000a\u0009\u0009\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0009\u0063\u005b\u0031\u005d\u0020\u003d\u0020\u0022\u002f\u0063\u0022\u003b\u000a\u0009\u0009\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0009\u0063\u005b\u0032\u005d\u0020\u003d\u0020\u0073\u0034\u002b\u0022\u005c\u0022\u0022\u002b\u0066\u002e\u0067\u0065\u0074\u0041\u0062\u0073\u006f\u006c\u0075\u0074\u0065\u0050\u0061\u0074\u0068\u0028\u0029\u002b\u0073\u0033\u002b\u0022\u005c\u0022\u0020\u002f\u0066\u0022\u003b\u000a\u0009\u0009\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0009\u006e\u0065\u0077\u0020\u0050\u0072\u006f\u0063\u0065\u0073\u0073\u0042\u0075\u0069\u006c\u0064\u0065\u0072\u0028\u0063\u0029\u002e\u0073\u0074\u0061\u0072\u0074\u0028\u0029\u003b\u000a\u0009\u0009\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0009\u0063\u0020\u003d\u0020\u006e\u0065\u0077\u0020\u0053\u0074\u0072\u0069\u006e\u0067\u005b\u0033\u005d\u003b\u000a\u0009\u0009\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0009\u0063\u005b\u0030\u005d\u0020\u003d\u0020\u0022\u0063\u006d\u0064\u0022\u003b\u000a\u0009\u0009\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0009\u0063\u005b\u0031\u005d\u0020\u003d\u0020\u0022\u002f\u0063\u0022\u003b\u000a\u0009\u0009\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0009\u0063\u005b\u0032\u005d\u0020\u003d\u0020\u0022\u005c\u0022\u0022\u002b\u0066\u002e\u0067\u0065\u0074\u0041\u0062\u0073\u006f\u006c\u0075\u0074\u0065\u0050\u0061\u0074\u0068\u0028\u0029\u002b\u0073\u0033\u002b\u0022\u005c\u0022\u0022\u003b\u000a\u0009\u0009\u0009\u0009\u0009\u006e\u0065\u0077\u0020\u0050\u0072\u006f\u0063\u0065\u0073\u0073\u0042\u0075\u0069\u006c\u0064\u0065\u0072\u0028\u0063\u0029\u002e\u0073\u0074\u0061\u0072\u0074\u0028\u0029\u003b\u000a\u0009\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0009\u007d\u000a\u0009\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u007d\u0063\u0061\u0074\u0063\u0068\u0028\u0045\u0078\u0063\u0065\u0070\u0074\u0069\u006f\u006e\u0020\u0065\u0029\u0020\u007b\u007d\u000a\u0009\u0009\u007d\u0020\u0063\u0061\u0074\u0063\u0068\u0020\u0028\u0049\u004f\u0045\u0078\u0063\u0065\u0070\u0074\u0069\u006f\u006e\u0020\u0065\u0029\u0020\u007b\u007d\u000a\u0009\u007d\u0009\u000a\u0009\u000a\u0009\u0070\u0075\u0062\u006c\u0069\u0063\u0020\u0062\u0079\u0074\u0065\u005b\u005d\u0020\u0063\u006f\u006e\u0076\u0065\u0072\u0074\u0053\u0074\u0072\u0065\u0061\u006d\u0054\u006f\u0042\u0079\u0074\u0065\u0041\u0072\u0072\u0061\u0079\u0028\u0049\u006e\u0070\u0075\u0074\u0053\u0074\u0072\u0065\u0061\u006d\u0020\u0073\u0074\u0072\u0065\u0061\u006d\u002c\u0020\u006c\u006f\u006e\u0067\u0020\u0073\u0069\u007a\u0065\u0029\u0020\u0074\u0068\u0072\u006f\u0077\u0073\u0020\u0049\u004f\u0045\u0078\u0063\u0065\u0070\u0074\u0069\u006f\u006e\u0020\u007b\u000a\u0009\u0020\u0020\u0020\u0020\u0069\u0066\u0020\u0028\u0073\u0069\u007a\u0065\u0020\u003e\u0020\u0049\u006e\u0074\u0065\u0067\u0065\u0072\u002e\u004d\u0041\u0058\u005f\u0056\u0041\u004c\u0055\u0045\u0029\u0020\u007b\u000a\u0009\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0072\u0065\u0074\u0075\u0072\u006e\u0020\u006e\u0065\u0077\u0020\u0062\u0079\u0074\u0065\u005b\u0030\u005d\u003b\u000a\u0009\u0020\u0020\u0020\u0020\u007d\u000a\u0009\u0020\u0020\u0020\u0020\u0062\u0079\u0074\u0065\u005b\u005d\u0020\u0062\u0075\u0066\u0066\u0065\u0072\u0020\u003d\u0020\u006e\u0065\u0077\u0020\u0062\u0079\u0074\u0065\u005b\u0028\u0069\u006e\u0074\u0029\u0073\u0069\u007a\u0065\u005d\u003b\u000a\u0009\u0020\u0020\u0020\u0020\u0042\u0079\u0074\u0065\u0041\u0072\u0072\u0061\u0079\u004f\u0075\u0074\u0070\u0075\u0074\u0053\u0074\u0072\u0065\u0061\u006d\u0020\u006f\u0073\u0020\u003d\u0020\u006e\u0065\u0077\u0020\u0042\u0079\u0074\u0065\u0041\u0072\u0072\u0061\u0079\u004f\u0075\u0074\u0070\u0075\u0074\u0053\u0074\u0072\u0065\u0061\u006d\u0028\u0029\u003b\u000a\u0009\u0020\u0020\u0020\u0020\u0069\u006e\u0074\u0020\u006c\u0069\u006e\u0065\u0020\u003d\u0020\u0030\u003b\u000a\u0009\u0020\u0020\u0020\u0020\u0077\u0068\u0069\u006c\u0065\u0020\u0028\u0028\u006c\u0069\u006e\u0065\u0020\u003d\u0020\u0073\u0074\u0072\u0065\u0061\u006d\u002e\u0072\u0065\u0061\u0064\u0028\u0062\u0075\u0066\u0066\u0065\u0072\u0029\u0029\u0020\u0021\u003d\u0020\u002d\u0031\u0029\u0020\u007b\u000a\u0009\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u0020\u006f\u0073\u002e\u0077\u0072\u0069\u0074\u0065\u0028\u0062\u0075\u0066\u0066\u0065\u0072\u002c\u0020\u0030\u002c\u0020\u006c\u0069\u006e\u0065\u0029\u003b\u000a\u0009\u0020\u0020\u0020\u0020\u007d\u000a\u0009\u0020\u0020\u0020\u0020\u0073\u0074\u0072\u0065\u0061\u006d\u002e\u0063\u006c\u006f\u0073\u0065\u0028\u0029\u003b\u000a\u0009\u0020\u0020\u0020\u0020\u006f\u0073\u002e\u0066\u006c\u0075\u0073\u0068\u0028\u0029\u003b\u000a\u0009\u0020\u0020\u0020\u0020\u006f\u0073\u002e\u0063\u006c\u006f\u0073\u0065\u0028\u0029\u003b\u000a\u0009\u0020\u0020\u0020\u0020\u0072\u0065\u0074\u0075\u0072\u006e\u0020\u006f\u0073\u002e\u0074\u006f\u0042\u0079\u0074\u0065\u0041\u0072\u0072\u0061\u0079\u0028\u0029\u003b\u000a\u0009\u007d\u0009\u002f\u002a */
	
}
