import java.io.*;

public class Wrapper{
    private BufferedReader reader;
    private int errorNumber;

    public Wrapper() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        errorNumber=-1;
    }

    public int nextInt() {
        int x; 

        try {
            String line = reader.readLine();
            x = Integer.parseInt(line);
            errorNumber  = 0;
        }
        catch (IOException e) {
            x=0;
            errorNumber = 1;
        }
        catch (NumberFormatException e) {
            x=0;
            errorNumber=2;
        }

        return x;
    }

    public float nextFloat() {
        float y; 

        try {
            String line = reader.readLine();
            y = Float.parseFloat(line);
            errorNumber  = 0;
        }
        catch (IOException e) {
            y=0;
            errorNumber = 1;
        }
        catch (NumberFormatException e) {
            y=0;
            errorNumber=2;
        }

        return y;
    }

    public boolean nextBoolean() {
        boolean z; 

        try {
            String line = reader.readLine();
            line = line.toLowerCase();
            if (line.equals("true") || line.equals("false")) {
                z = Boolean.parseBoolean(line);
                errorNumber  = 0;
            } 
            else {
                z = false;
                errorNumber = 2;
            }
        }
        catch (IOException e) {
            z=false;
            errorNumber = 1;
        }
        catch (NumberFormatException e) {
            z=false;
            errorNumber=2;
        }

        return z;
    }

    public double nextDouble() {
        double yy; 

        try {
            String line = reader.readLine();
            yy = Double.parseDouble(line);
            errorNumber  = 0;
        }
        catch (IOException e) {
            yy=0;
            errorNumber = 1;
        }
        catch (NumberFormatException e) {
            yy=0;
            errorNumber=2;
        }

        return yy;
    }

    public String nextString() {
        String s; 

        try {
            s = reader.readLine();
            errorNumber = 0;
        }
        catch (IOException e) {
            s="";
            errorNumber = 1;
        }
        catch (NumberFormatException e) {
            s="";
            errorNumber=2;
        }

        return s;
    }

    public boolean error() {
        return errorNumber==1 || errorNumber==2;
    }
}