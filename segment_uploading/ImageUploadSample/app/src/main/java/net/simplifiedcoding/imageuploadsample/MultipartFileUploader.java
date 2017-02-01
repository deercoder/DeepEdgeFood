package net.simplifiedcoding.imageuploadsample;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * This program demonstrates a usage of the MultipartUtility class.
 * @author www.codejava.net
 *
 */
public class MultipartFileUploader {

	public static void test_upload(String mPath) {
		String charset = "UTF-8";
		File uploadFile1 = new File(mPath);
		String requestURL = "http://129.63.16.64:8000/image/";

		try {
			MultipartUtility multipart = new MultipartUtility(requestURL, charset);

			multipart.addFilePart("image", uploadFile1);

			List<String> response = multipart.finish();
			
			System.out.println("SERVER REPLIED:");
			
			for (String line : response) {
				System.out.println(line);
			}
		} catch (IOException ex) {
			System.err.println(ex);
		}
	}
}