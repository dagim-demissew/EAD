package javaclasses;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Base64;

public class ImageUtil {
	  public static String convertInputStreamToBase64(InputStream inputStream) {
	        try {
	            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	            byte[] buffer = new byte[1024];
	            int bytesRead;
	            while ((bytesRead = inputStream.read(buffer)) != -1) {
	                outputStream.write(buffer, 0, bytesRead);
	            }

	            // Convert the byte array to a base64-encoded string
	            byte[] imageBytes = outputStream.toByteArray();
	            return Base64.getEncoder().encodeToString(imageBytes);
	        } catch (Exception e) {
	            e.printStackTrace(); // Handle the exception appropriately
	            return null;
	        }
	    }

}
