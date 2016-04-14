import java.io.*;
import java.security.MessageDigest;

public class HashSHA1 {

   public static byte[] createHash(String filename) throws Exception {
     InputStream fis =  new FileInputStream(filename);

     byte[] buffer = new byte[1024];
     MessageDigest complete = MessageDigest.getInstance("SHA1");
     int numRead;
     do {
       numRead = fis.read(buffer);
       if (numRead > 0) {
         complete.update(buffer, 0, numRead);
       }
     } while (numRead != -1);
         fis.close();
         return complete.digest();
   }

   public static String getSHA1Hash(String filename) throws Exception {
     byte[] b = createHash(filename);
     String result = "";
     for (int i=0; i < b.length; i++) {
       result +=
          Integer.toString( ( b[i] & 0xff ) + 0x100, 16).substring( 1 );
      }
     return result;
   }

   public static void main(String args[]) {
      // Check how many arguments were passed in
      if(args.length == 0 || args.length > 2) {
        System.out.println("Proper Usage is: java program path to .jar file to be hashed path to the .jar files meta file where the hash is to be written");
        System.exit(0);
      }
      
      //Verify path/file exists
      File MetaFile = new File(args[1]);
      if(!MetaFile.exists()) {
        System.out.println("The path you entered for the .jar files meta file does not exist");
        System.exit(0);
      }
      
      //Verify path/file exists
      File toBeHashed = new File(args[0]);
      if(!toBeHashed.exists()) {
        System.out.println("The path you entered for the .jar file to be hashed does not exist.");
        System.exit(0);
      }
      
      //Destination of hash 
      String strFilePath = args[1];
     
       try {
         FileWriter fw = new FileWriter(strFilePath,true);
         BufferedWriter bw = new BufferedWriter(fw);
         PrintWriter pw = new PrintWriter(bw);
	    
         //File to be hashed
         String strContent = (getSHA1Hash(args[0]));
        
         pw.println(strContent);
       
         pw.close();
       
         System.out.println("File Written Successfully");
       }
       catch (Exception e) {
         e.printStackTrace();
       }
   }
}